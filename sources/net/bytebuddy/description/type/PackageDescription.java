package net.bytebuddy.description.type;

import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface PackageDescription extends NamedElement.WithRuntimeName, AnnotationSource {
    public static final String PACKAGE_CLASS_NAME = "package-info";
    public static final int PACKAGE_MODIFIERS = 5632;
    public static final PackageDescription DEFAULT = new Simple("");

    @AlwaysNull
    public static final PackageDescription UNDEFINED = null;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static abstract class AbstractBase implements PackageDescription {
        @Override // net.bytebuddy.description.type.PackageDescription
        public boolean contains(TypeDescription typeDescription) {
            return equals(typeDescription.getPackage());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this != obj) {
                return (obj instanceof PackageDescription) && getName().equals(((PackageDescription) obj).getName());
            }
            return true;
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return getName();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
        }

        public int hashCode() {
            return getName().hashCode();
        }

        @Override // net.bytebuddy.description.type.PackageDescription
        public boolean isDefault() {
            return getName().equals("");
        }

        public String toString() {
            return "package " + getName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ForLoadedPackage extends AbstractBase {
        private final Package aPackage;

        public ForLoadedPackage(Package r1) {
            this.aPackage = r1;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.ForLoadedAnnotations(this.aPackage.getDeclaredAnnotations());
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.aPackage.getName();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Simple extends AbstractBase {
        private final String name;

        public Simple(String str) {
            this.name = str;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.name;
        }
    }

    boolean contains(TypeDescription typeDescription);

    boolean isDefault();
}
