package net.bytebuddy.dynamic.loading;

import java.util.Map;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ClassLoaderDecorator {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Factory {

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum NoOp implements Factory {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator.Factory
            public ClassLoaderDecorator make(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map) {
                return new NoOp(classLoader);
            }
        }

        ClassLoaderDecorator make(@MaybeNull ClassLoader classLoader, Map<String, byte[]> map);
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class NoOp implements ClassLoaderDecorator {

        @MaybeNull
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;

        public NoOp(@MaybeNull ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator
        @MaybeNull
        public ClassLoader apply(TypeDescription typeDescription) {
            return this.classLoader;
        }

        /* JADX WARN: Found duplicated region for block: B:19:0x0027 A[RETURN] */
        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassLoader classLoader = this.classLoader;
            ClassLoader classLoader2 = ((NoOp) obj).classLoader;
            if (classLoader2 != null) {
                return classLoader != null && classLoader.equals(classLoader2);
            }
            if (classLoader != null) {
                return false;
            }
        }

        public int hashCode() {
            int iHashCode = getClass().hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            return classLoader != null ? classLoader.hashCode() + iHashCode : iHashCode;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassLoaderDecorator
        public boolean isSkipped(TypeDescription typeDescription) {
            return false;
        }
    }

    @MaybeNull
    ClassLoader apply(TypeDescription typeDescription);

    boolean isSkipped(TypeDescription typeDescription);
}
