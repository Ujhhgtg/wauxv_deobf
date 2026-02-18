package net.bytebuddy.asm;

import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class MemberRemoval extends AsmVisitorWrapper.AbstractBase {
    private final ElementMatcher.Junction<FieldDescription.InDefinedShape> fieldMatcher;
    private final ElementMatcher.Junction<MethodDescription> methodMatcher;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class MemberRemovingClassVisitor extends ClassVisitor {
        private final ElementMatcher.Junction<FieldDescription.InDefinedShape> fieldMatcher;
        private final Map<String, FieldDescription.InDefinedShape> fields;
        private final ElementMatcher.Junction<MethodDescription> methodMatcher;
        private final Map<String, MethodDescription> methods;

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public FieldVisitor visitField(int i, String str, String str2, @MaybeNull String str3, @MaybeNull Object obj) {
            FieldDescription.InDefinedShape inDefinedShape = this.fields.get(str + str2);
            if (inDefinedShape == null || !this.fieldMatcher.matches(inDefinedShape)) {
                return super.visitField(i, str, str2, str3, obj);
            }
            return null;
        }

        @Override // net.bytebuddy.jar.asm.ClassVisitor
        @MaybeNull
        public MethodVisitor visitMethod(int i, String str, String str2, @MaybeNull String str3, @MaybeNull String[] strArr) {
            MethodDescription methodDescription = this.methods.get(str + str2);
            if (methodDescription == null || !this.methodMatcher.matches(methodDescription)) {
                return super.visitMethod(i, str, str2, str3, strArr);
            }
            return null;
        }

        private MemberRemovingClassVisitor(ClassVisitor classVisitor, ElementMatcher.Junction<FieldDescription.InDefinedShape> junction, ElementMatcher.Junction<MethodDescription> junction2, Map<String, FieldDescription.InDefinedShape> map, Map<String, MethodDescription> map2) {
            super(OpenedClassReader.ASM_API, classVisitor);
            this.fieldMatcher = junction;
            this.methodMatcher = junction2;
            this.fields = map;
            this.methods = map2;
        }
    }

    public MemberRemoval() {
        this(ElementMatchers.none(), ElementMatchers.none());
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemberRemoval memberRemoval = (MemberRemoval) obj;
        return this.fieldMatcher.equals(memberRemoval.fieldMatcher) && this.methodMatcher.equals(memberRemoval.methodMatcher);
    }

    public int hashCode() {
        return this.methodMatcher.hashCode() + ((this.fieldMatcher.hashCode() + (getClass().hashCode() * 31)) * 31);
    }

    public MemberRemoval stripConstructors(ElementMatcher<? super MethodDescription> elementMatcher) {
        return stripInvokables(ElementMatchers.isConstructor().and(elementMatcher));
    }

    public MemberRemoval stripFields(ElementMatcher<? super FieldDescription.InDefinedShape> elementMatcher) {
        return new MemberRemoval(this.fieldMatcher.or(elementMatcher), this.methodMatcher);
    }

    public MemberRemoval stripInvokables(ElementMatcher<? super MethodDescription> elementMatcher) {
        return new MemberRemoval(this.fieldMatcher, this.methodMatcher.or(elementMatcher));
    }

    public MemberRemoval stripMethods(ElementMatcher<? super MethodDescription> elementMatcher) {
        return stripInvokables(ElementMatchers.isMethod().and(elementMatcher));
    }

    @Override // net.bytebuddy.asm.AsmVisitorWrapper
    public ClassVisitor wrap(TypeDescription typeDescription, ClassVisitor classVisitor, Implementation.Context context, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fieldList, MethodList<?> methodList, int i, int i2) {
        HashMap map = new HashMap();
        for (FieldDescription.InDefinedShape inDefinedShape : fieldList) {
            map.put(inDefinedShape.getInternalName() + inDefinedShape.getDescriptor(), inDefinedShape);
        }
        HashMap map2 = new HashMap();
        for (MethodDescription methodDescription : CompoundList.of(methodList, new MethodDescription.Latent.TypeInitializer(typeDescription))) {
            map2.put(methodDescription.getInternalName() + methodDescription.getDescriptor(), methodDescription);
        }
        return new MemberRemovingClassVisitor(classVisitor, this.fieldMatcher, this.methodMatcher, map, map2);
    }

    public MemberRemoval(ElementMatcher.Junction<FieldDescription.InDefinedShape> junction, ElementMatcher.Junction<MethodDescription> junction2) {
        this.fieldMatcher = junction;
        this.methodMatcher = junction2;
    }
}
