package net.bytebuddy.dynamic.loading;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.AllPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.Enumeration;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.nullability.AlwaysNull;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ClassFilePostProcessor {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForClassFileTransformer implements ClassFilePostProcessor {
        protected static final ProtectionDomain ALL_PRIVILEGES = new ProtectionDomain(null, new AllPermissionsCollection());

        @AlwaysNull
        private static final Class<?> UNLOADED_TYPE = null;
        private final ClassFileTransformer classFileTransformer;

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class AllPermissionsCollection extends PermissionCollection {
            private static final long serialVersionUID = 1;

            @Override // java.security.PermissionCollection
            public void add(Permission permission) {
                throw new UnsupportedOperationException("add");
            }

            @Override // java.security.PermissionCollection
            public Enumeration<Permission> elements() {
                return Collections.enumeration(Collections.singleton(new AllPermission()));
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return getClass().hashCode();
            }

            @Override // java.security.PermissionCollection
            public boolean implies(Permission permission) {
                return true;
            }
        }

        public ForClassFileTransformer(ClassFileTransformer classFileTransformer) {
            this.classFileTransformer = classFileTransformer;
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classFileTransformer.equals(((ForClassFileTransformer) obj).classFileTransformer);
        }

        public int hashCode() {
            return this.classFileTransformer.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.loading.ClassFilePostProcessor
        public byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
            try {
                ClassFileTransformer classFileTransformer = this.classFileTransformer;
                String strReplace = str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
                Class<?> cls = UNLOADED_TYPE;
                if (protectionDomain == null) {
                    protectionDomain = ALL_PRIVILEGES;
                }
                byte[] bArrTransform = classFileTransformer.transform(classLoader, strReplace, cls, protectionDomain, bArr);
                return bArrTransform == null ? bArr : bArrTransform;
            } catch (IllegalClassFormatException e) {
                throw new IllegalStateException(yg.concat("Failed to transform ", str), e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum NoOp implements ClassFilePostProcessor {
        INSTANCE;

        @Override // net.bytebuddy.dynamic.loading.ClassFilePostProcessor
        public byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr) {
            return bArr;
        }
    }

    byte[] transform(@MaybeNull ClassLoader classLoader, String str, @MaybeNull ProtectionDomain protectionDomain, byte[] bArr);
}
