package net.bytebuddy.description.module;

import java.lang.reflect.AnnotatedElement;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ModuleVisitor;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ModuleDescription extends NamedElement, ModifierReviewable.ForModuleDescription, AnnotationSource {
    public static final String MODULE_CLASS_NAME = "module-info";

    @AlwaysNull
    public static final ModuleDescription UNDEFINED = null;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements ModuleDescription {
        @Override // net.bytebuddy.description.module.ModuleDescription
        public void accept(ClassVisitor classVisitor) {
            ModuleVisitor moduleVisitorVisitModule = classVisitor.visitModule(getActualName(), getModifiers(), getVersion());
            if (moduleVisitorVisitModule != null) {
                String mainClass = getMainClass();
                if (mainClass != null) {
                    moduleVisitorVisitModule.visitMainClass(mainClass.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'));
                }
                Iterator<String> it = getPackages().iterator();
                while (it.hasNext()) {
                    moduleVisitorVisitModule.visitPackage(it.next().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'));
                }
                for (Map.Entry<String, Requires> entry : getRequires().entrySet()) {
                    moduleVisitorVisitModule.visitRequire(entry.getKey(), entry.getValue().getModifiers(), entry.getValue().getVersion());
                }
                Iterator<Map.Entry<String, Exports>> it2 = getExports().entrySet().iterator();
                while (true) {
                    String[] strArr = null;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Exports> next = it2.next();
                    String strReplace = next.getKey().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
                    int modifiers = next.getValue().getModifiers();
                    if (!next.getValue().getTargets().isEmpty()) {
                        strArr = (String[]) next.getValue().getTargets().toArray(new String[0]);
                    }
                    moduleVisitorVisitModule.visitExport(strReplace, modifiers, strArr);
                }
                for (Map.Entry<String, Opens> entry2 : getOpens().entrySet()) {
                    moduleVisitorVisitModule.visitOpen(entry2.getKey().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), entry2.getValue().getModifiers(), entry2.getValue().getTargets().isEmpty() ? null : (String[]) entry2.getValue().getTargets().toArray(new String[0]));
                }
                Iterator<String> it3 = getUses().iterator();
                while (it3.hasNext()) {
                    moduleVisitorVisitModule.visitUse(it3.next().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'));
                }
                for (Map.Entry<String, Provides> entry3 : getProvides().entrySet()) {
                    String[] strArr2 = entry3.getValue().getProviders().isEmpty() ? null : new String[entry3.getValue().getProviders().size()];
                    if (strArr2 != null) {
                        Iterator<String> it4 = entry3.getValue().getProviders().iterator();
                        for (int i = 0; i < strArr2.length; i++) {
                            strArr2[i] = it4.next().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
                        }
                    }
                    moduleVisitorVisitModule.visitProvide(entry3.getKey().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), strArr2);
                }
                moduleVisitorVisitModule.visitEnd();
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof ModuleDescription) {
                return getActualName().equals(((ModuleDescription) obj).getActualName());
            }
            return false;
        }

        public int hashCode() {
            return getActualName().hashCode() * 17;
        }

        public String toString() {
            return "module " + getActualName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Exports extends ModifierReviewable.OfMandatable {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Exports {
            public boolean equals(Object obj) {
                if (!(obj instanceof Exports)) {
                    return false;
                }
                Exports exports = (Exports) obj;
                return getModifiers() == exports.getModifiers() && getTargets().equals(exports.getTargets());
            }

            public int hashCode() {
                return (getTargets().hashCode() * 17) + getModifiers();
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Exports
            public boolean isQualified() {
                return !getTargets().isEmpty();
            }

            public String toString() {
                return "Opens{targets=" + getTargets() + ",modifiers=" + getModifiers() + '}';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Simple extends AbstractBase {
            protected final int modifiers;
            private final Set<String> targets;

            public Simple(Set<String> set, int i) {
                this.targets = set;
                this.modifiers = i;
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return this.modifiers;
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Exports
            public Set<String> getTargets() {
                return this.targets;
            }
        }

        Set<String> getTargets();

        boolean isQualified();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForLoadedModule extends AbstractBase {
        private static final boolean ACCESS_CONTROLLER;
        protected static final Module MODULE;
        protected static final ModuleDescriptor MODULE_DESCRIPTOR;
        protected static final ModuleDescriptor.Exports MODULE_DESCRIPTOR_EXPORTS;
        protected static final ModuleDescriptor.Opens MODULE_DESCRIPTOR_OPENS;
        protected static final ModuleDescriptor.Provides MODULE_DESCRIPTOR_PROVIDES;
        protected static final ModuleDescriptor.Requires MODULE_DESCRIPTOR_REQUIRES;
        protected static final Optional OPTIONAL;
        private final AnnotatedElement module;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.lang.Module")
        public interface Module {
            @JavaDispatcher.Proxied("getDescriptor")
            Object getDescriptor(Object obj);

            @JavaDispatcher.Proxied("getName")
            String getName(Object obj);

            @JavaDispatcher.Proxied("getPackages")
            Set<String> getPackages(Object obj);

            @JavaDispatcher.Instance
            @JavaDispatcher.Proxied("isInstance")
            boolean isInstance(Object obj);

            @JavaDispatcher.Proxied("isNamed")
            boolean isNamed(Object obj);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor")
        public interface ModuleDescriptor {

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor$Exports")
            public interface Exports {
                @JavaDispatcher.Proxied("modifiers")
                Set<Enum<?>> modifiers(Object obj);

                @JavaDispatcher.Proxied("source")
                String source(Object obj);

                @JavaDispatcher.Proxied("targets")
                Set<String> targets(Object obj);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor$Opens")
            public interface Opens {
                @JavaDispatcher.Proxied("modifiers")
                Set<Enum<?>> modifiers(Object obj);

                @JavaDispatcher.Proxied("source")
                String source(Object obj);

                @JavaDispatcher.Proxied("targets")
                Set<String> targets(Object obj);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor$Provides")
            public interface Provides {
                @JavaDispatcher.Proxied("providers")
                List<String> providers(Object obj);

                @JavaDispatcher.Proxied("service")
                String service(Object obj);
            }

            /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
            @JavaDispatcher.Proxied("java.lang.module.ModuleDescriptor$Requires")
            public interface Requires {
                @JavaDispatcher.Proxied("modifiers")
                Set<Enum<?>> modifiers(Object obj);

                @JavaDispatcher.Proxied("name")
                String name(Object obj);

                @JavaDispatcher.Proxied("rawCompiledVersion")
                Object rawCompiledVersion(Object obj);
            }

            @JavaDispatcher.Proxied("exports")
            Set<?> exports(Object obj);

            @JavaDispatcher.Proxied("isOpen")
            boolean isOpen(Object obj);

            @JavaDispatcher.Proxied("mainClass")
            Object mainClass(Object obj);

            @JavaDispatcher.Proxied("modifiers")
            Set<Enum<?>> modifiers(Object obj);

            @JavaDispatcher.Proxied("name")
            String name(Object obj);

            @JavaDispatcher.Proxied("opens")
            Set<?> opens(Object obj);

            @JavaDispatcher.Proxied("packages")
            Set<String> packages(Object obj);

            @JavaDispatcher.Proxied("provides")
            Set<?> provides(Object obj);

            @JavaDispatcher.Proxied("rawVersion")
            Object rawVersion(Object obj);

            @JavaDispatcher.Proxied("requires")
            Set<?> requires(Object obj);

            @JavaDispatcher.Proxied("uses")
            Set<String> uses(Object obj);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.util.Optional")
        public interface Optional {
            @MaybeNull
            @JavaDispatcher.Proxied("orElse")
            Object orElse(Object obj, @MaybeNull Object obj2);
        }

        static {
            boolean z = false;
            try {
                Class.forName("java.security.AccessController", false, null);
                ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
            } catch (ClassNotFoundException unused) {
                ACCESS_CONTROLLER = z;
            } catch (SecurityException unused2) {
                z = true;
                ACCESS_CONTROLLER = z;
            }
            MODULE = (Module) doPrivileged(JavaDispatcher.of(Module.class));
            MODULE_DESCRIPTOR = (ModuleDescriptor) doPrivileged(JavaDispatcher.of(ModuleDescriptor.class));
            MODULE_DESCRIPTOR_EXPORTS = (ModuleDescriptor.Exports) doPrivileged(JavaDispatcher.of(ModuleDescriptor.Exports.class));
            MODULE_DESCRIPTOR_OPENS = (ModuleDescriptor.Opens) doPrivileged(JavaDispatcher.of(ModuleDescriptor.Opens.class));
            MODULE_DESCRIPTOR_REQUIRES = (ModuleDescriptor.Requires) doPrivileged(JavaDispatcher.of(ModuleDescriptor.Requires.class));
            MODULE_DESCRIPTOR_PROVIDES = (ModuleDescriptor.Provides) doPrivileged(JavaDispatcher.of(ModuleDescriptor.Provides.class));
            OPTIONAL = (Optional) doPrivileged(JavaDispatcher.of(Optional.class));
        }

        public ForLoadedModule(AnnotatedElement annotatedElement) {
            this.module = annotatedElement;
        }

        @AccessControllerPlugin.Enhance
        private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
            return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
        }

        public static ModuleDescription of(Object obj) {
            Module module = MODULE;
            if (!module.isInstance(obj)) {
                throw new IllegalArgumentException(StaticHelpers6.concatVar2Var1(obj, "Not a Java module: "));
            }
            if (module.isNamed(obj)) {
                return new ForLoadedModule((AnnotatedElement) obj);
            }
            throw new IllegalArgumentException(StaticHelpers6.concatVar2Var1(obj, "Not a named module: "));
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return MODULE_DESCRIPTOR.name(MODULE.getDescriptor(this.module));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.ForLoadedAnnotations(this.module.getDeclaredAnnotations());
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Exports> getExports() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : MODULE_DESCRIPTOR.exports(MODULE.getDescriptor(this.module))) {
                Iterator<Enum<?>> it = MODULE_DESCRIPTOR_EXPORTS.modifiers(obj).iterator();
                int i = 0;
                while (it.hasNext()) {
                    String strName = it.next().name();
                    if (strName.equals("SYNTHETIC")) {
                        i |= 4096;
                    } else {
                        if (!strName.equals("MANDATED")) {
                            throw new IllegalStateException("Unknown export modifier: ".concat(strName));
                        }
                        i |= 32768;
                    }
                }
                ModuleDescriptor.Exports exports = MODULE_DESCRIPTOR_EXPORTS;
                linkedHashMap.put(exports.source(obj), new Exports.Simple(exports.targets(obj), i));
            }
            return linkedHashMap;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        @MaybeNull
        public String getMainClass() {
            return (String) OPTIONAL.orElse(MODULE_DESCRIPTOR.mainClass(MODULE.getDescriptor(this.module)), null);
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            Iterator<Enum<?>> it = MODULE_DESCRIPTOR.modifiers(MODULE.getDescriptor(this.module)).iterator();
            int i = 0;
            while (it.hasNext()) {
                String strName = it.next().name();
                if (strName.equals("SYNTHETIC")) {
                    i |= 4096;
                } else if (strName.equals("MANDATED")) {
                    i |= 32768;
                } else {
                    if (!strName.equals("OPEN")) {
                        throw new IllegalStateException("Unknown module modifier: ".concat(strName));
                    }
                    i |= 32;
                }
            }
            return i;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Opens> getOpens() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : MODULE_DESCRIPTOR.opens(MODULE.getDescriptor(this.module))) {
                Iterator<Enum<?>> it = MODULE_DESCRIPTOR_OPENS.modifiers(obj).iterator();
                int i = 0;
                while (it.hasNext()) {
                    String strName = it.next().name();
                    if (strName.equals("SYNTHETIC")) {
                        i |= 4096;
                    } else {
                        if (!strName.equals("MANDATED")) {
                            throw new IllegalStateException("Unknown opens modifier: ".concat(strName));
                        }
                        i |= 32768;
                    }
                }
                ModuleDescriptor.Opens opens = MODULE_DESCRIPTOR_OPENS;
                linkedHashMap.put(opens.source(obj), new Opens.Simple(opens.targets(obj), i));
            }
            return linkedHashMap;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Set<String> getPackages() {
            return MODULE_DESCRIPTOR.packages(MODULE.getDescriptor(this.module));
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Provides> getProvides() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : MODULE_DESCRIPTOR.provides(MODULE.getDescriptor(this.module))) {
                ModuleDescriptor.Provides provides = MODULE_DESCRIPTOR_PROVIDES;
                linkedHashMap.put(provides.service(obj), new Provides.Simple(new LinkedHashSet(provides.providers(obj))));
            }
            return linkedHashMap;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Requires> getRequires() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : MODULE_DESCRIPTOR.requires(MODULE.getDescriptor(this.module))) {
                Iterator<Enum<?>> it = MODULE_DESCRIPTOR_REQUIRES.modifiers(obj).iterator();
                int i = 0;
                while (it.hasNext()) {
                    String strName = it.next().name();
                    if (strName.equals("SYNTHETIC")) {
                        i |= 4096;
                    } else if (strName.equals("MANDATED")) {
                        i |= 32768;
                    } else if (strName.equals("TRANSITIVE")) {
                        i |= 32;
                    } else {
                        if (!strName.equals("STATIC")) {
                            throw new IllegalStateException("Unknown requires modifier: ".concat(strName));
                        }
                        i |= 64;
                    }
                }
                ModuleDescriptor.Requires requires = MODULE_DESCRIPTOR_REQUIRES;
                linkedHashMap.put(requires.name(obj), new Requires.Simple((String) OPTIONAL.orElse(requires.rawCompiledVersion(obj), null), i));
            }
            return linkedHashMap;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Set<String> getUses() {
            return MODULE_DESCRIPTOR.uses(MODULE.getDescriptor(this.module));
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        @MaybeNull
        public String getVersion() {
            return (String) OPTIONAL.orElse(MODULE_DESCRIPTOR.rawVersion(MODULE.getDescriptor(this.module)), null);
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForModuleDescription
        public boolean isOpen() {
            return MODULE_DESCRIPTOR.isOpen(MODULE.getDescriptor(this.module));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Latent extends AbstractBase {
        private final List<? extends AnnotationDescription> annotations;
        private final Map<String, Exports> exports;

        @MaybeNull
        private final String mainClass;
        private final int modifiers;
        private final String name;
        private final Map<String, Opens> opens;
        private final Set<String> packages;
        private final Map<String, Provides> provides;
        private final Map<String, Requires> requires;
        private final Set<String> uses;

        @MaybeNull
        private final String version;

        public Latent(String str, int i, @MaybeNull String str2, @MaybeNull String str3, Set<String> set, Map<String, Requires> map, Map<String, Exports> map2, Map<String, Opens> map3, Set<String> set2, Map<String, Provides> map4, List<? extends AnnotationDescription> list) {
            this.name = str;
            this.modifiers = i;
            this.version = str2;
            this.mainClass = str3;
            this.packages = set;
            this.requires = map;
            this.exports = map2;
            this.opens = map3;
            this.uses = set2;
            this.provides = map4;
            this.annotations = list;
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return this.name;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Exports> getExports() {
            return this.exports;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        @MaybeNull
        public String getMainClass() {
            return this.mainClass;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Opens> getOpens() {
            return this.opens;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Set<String> getPackages() {
            return this.packages;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Provides> getProvides() {
            return this.provides;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Map<String, Requires> getRequires() {
            return this.requires;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        public Set<String> getUses() {
            return this.uses;
        }

        @Override // net.bytebuddy.description.module.ModuleDescription
        @MaybeNull
        public String getVersion() {
            return this.version;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Opens extends ModifierReviewable.OfMandatable {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Opens {
            public boolean equals(Object obj) {
                if (!(obj instanceof Opens)) {
                    return false;
                }
                Opens opens = (Opens) obj;
                return getModifiers() == opens.getModifiers() && getTargets().equals(opens.getTargets());
            }

            public int hashCode() {
                return (getTargets().hashCode() * 17) + getModifiers();
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Opens
            public boolean isQualified() {
                return !getTargets().isEmpty();
            }

            public String toString() {
                return "Opens{targets=" + getTargets() + ",modifiers=" + getModifiers() + '}';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Simple extends AbstractBase {
            protected final int modifiers;
            private final Set<String> targets;

            public Simple(Set<String> set, int i) {
                this.targets = set;
                this.modifiers = i;
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return this.modifiers;
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Opens
            public Set<String> getTargets() {
                return this.targets;
            }
        }

        Set<String> getTargets();

        boolean isQualified();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Provides {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase implements Provides {
            public boolean equals(Object obj) {
                if (obj instanceof Provides) {
                    return getProviders().equals(((Provides) obj).getProviders());
                }
                return false;
            }

            public int hashCode() {
                return getProviders().hashCode();
            }

            public String toString() {
                return "Provides{providers=" + getProviders() + '}';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Simple extends AbstractBase {
            private final Set<String> providers;

            public Simple(Set<String> set) {
                this.providers = set;
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Provides
            public Set<String> getProviders() {
                return this.providers;
            }
        }

        Set<String> getProviders();
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Requires extends ModifierReviewable.ForModuleRequirement {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Requires {
            public boolean equals(Object obj) {
                if (!(obj instanceof Requires)) {
                    return false;
                }
                Requires requires = (Requires) obj;
                String version = getVersion();
                return (getModifiers() == requires.getModifiers() && version == null) ? requires.getVersion() == null : version.equals(requires.getVersion());
            }

            public int hashCode() {
                int modifiers = getModifiers();
                String version = getVersion();
                return version == null ? modifiers : (version.hashCode() * 17) + modifiers;
            }

            public String toString() {
                String version = getVersion();
                StringBuilder sb = new StringBuilder("Requires{version=");
                sb.append(version == null ? "" : StaticHelpers6.o('\'', "\"", version));
                sb.append(",modifiers=");
                sb.append(getModifiers());
                sb.append('}');
                return sb.toString();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static class Simple extends AbstractBase {
            private final int modifiers;

            @MaybeNull
            private final String version;

            public Simple(@MaybeNull String str, int i) {
                this.version = str;
                this.modifiers = i;
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return this.modifiers;
            }

            @Override // net.bytebuddy.description.module.ModuleDescription.Requires
            @MaybeNull
            public String getVersion() {
                return this.version;
            }
        }

        @MaybeNull
        String getVersion();
    }

    void accept(ClassVisitor classVisitor);

    Map<String, Exports> getExports();

    @MaybeNull
    String getMainClass();

    Map<String, Opens> getOpens();

    Set<String> getPackages();

    Map<String, Provides> getProvides();

    Map<String, Requires> getRequires();

    Set<String> getUses();

    @MaybeNull
    String getVersion();
}
