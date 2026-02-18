package bsh.security;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface SecurityGuard {
    default boolean canConstruct(Class<?> cls, Object[] objArr) {
        return true;
    }

    default boolean canExtends(Class<?> cls) {
        return true;
    }

    default boolean canGetField(Object obj, String str) {
        return true;
    }

    default boolean canGetStaticField(Class<?> cls, String str) {
        return true;
    }

    default boolean canImplements(Class<?> cls) {
        return true;
    }

    default boolean canInvokeLocalMethod(String str, Object[] objArr) {
        return true;
    }

    default boolean canInvokeMethod(Object obj, String str, Object[] objArr) {
        return true;
    }

    default boolean canInvokeStaticMethod(Class<?> cls, String str, Object[] objArr) {
        return true;
    }
}
