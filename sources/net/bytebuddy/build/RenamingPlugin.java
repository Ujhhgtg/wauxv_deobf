package net.bytebuddy.build;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.commons.ClassRemapper;
import net.bytebuddy.jar.asm.commons.Remapper;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class RenamingPlugin extends AsmVisitorWrapper.AbstractBase implements Plugin, Plugin.Factory {
    private final ElementMatcher<? super TypeDescription> matcher;
    private final Renaming renaming;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Renaming {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Compound implements Renaming {
            private final List<Renaming> renamings;

            public Compound(Renaming... renamingArr) {
                this((List<? extends Renaming>) Arrays.asList(renamingArr));
            }

            @Override // net.bytebuddy.build.RenamingPlugin.Renaming
            public String apply(String str) {
                Iterator<Renaming> it = this.renamings.iterator();
                while (it.hasNext()) {
                    str = it.next().apply(str);
                }
                return str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.renamings.equals(((Compound) obj).renamings);
            }

            public int hashCode() {
                return this.renamings.hashCode() + (getClass().hashCode() * 31);
            }

            public Compound(List<? extends Renaming> list) {
                this.renamings = new ArrayList(list.size());
                for (Renaming renaming : list) {
                    if (renaming instanceof Compound) {
                        this.renamings.addAll(((Compound) renaming).renamings);
                    } else if (!(renaming instanceof NoOp)) {
                        this.renamings.add(renaming);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class ForPattern implements Renaming {
            private final Pattern pattern;
            private final String replacement;

            public ForPattern(Pattern pattern, String str) {
                this.pattern = pattern;
                this.replacement = str;
            }

            @Override // net.bytebuddy.build.RenamingPlugin.Renaming
            public String apply(String str) {
                Matcher matcher = this.pattern.matcher(str);
                if (!matcher.find()) {
                    return str;
                }
                StringBuffer stringBuffer = new StringBuffer();
                do {
                    matcher.appendReplacement(stringBuffer, this.replacement);
                } while (matcher.find());
                return matcher.appendTail(stringBuffer).toString();
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                ForPattern forPattern = (ForPattern) obj;
                return this.replacement.equals(forPattern.replacement) && this.pattern.equals(forPattern.pattern);
            }

            public int hashCode() {
                return this.replacement.hashCode() + ((this.pattern.hashCode() + (getClass().hashCode() * 31)) * 31);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements Renaming {
            INSTANCE;

            @Override // net.bytebuddy.build.RenamingPlugin.Renaming
            public String apply(String str) {
                return str;
            }
        }

        String apply(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class RenamingRemapper extends Remapper {
        private final Map<String, String> cache;
        private final Renaming renaming;

        public RenamingRemapper(Renaming renaming) {
            super(OpenedClassReader.ASM_API);
            this.cache = new HashMap();
            this.renaming = renaming;
        }

        @Override // net.bytebuddy.jar.asm.commons.Remapper
        public String map(String str) {
            String str2 = this.cache.get(str);
            if (str2 != null) {
                return str2;
            }
            String strReplace = this.renaming.apply(str.replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH)).replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
            this.cache.put(str, strReplace);
            return strReplace;
        }
    }

    public RenamingPlugin(String str, String str2) {
        this(new Renaming.ForPattern(Pattern.compile(str), str2));
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return builder.visit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RenamingPlugin renamingPlugin = (RenamingPlugin) obj;
        return this.renaming.equals(renamingPlugin.renaming) && this.matcher.equals(renamingPlugin.matcher);
    }

    public int hashCode() {
        return this.matcher.hashCode() + ((this.renaming.hashCode() + (getClass().hashCode() * 31)) * 31);
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i2) {
        return new ClassRemapper(classVisitor, new RenamingRemapper(this.renaming));
    }

    public RenamingPlugin(String str, String str2, String str3) {
        this(new Renaming.ForPattern(Pattern.compile(str), str2), ElementMatchers.nameStartsWith(str3));
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull TypeDescription typeDescription) {
        return this.matcher.matches(typeDescription);
    }

    public RenamingPlugin(Renaming renaming) {
        this(renaming, ElementMatchers.any());
    }

    public RenamingPlugin(Renaming renaming, ElementMatcher<? super TypeDescription> elementMatcher) {
        this.renaming = renaming;
        this.matcher = elementMatcher;
    }
}
