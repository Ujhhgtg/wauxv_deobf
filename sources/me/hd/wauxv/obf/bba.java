package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bba extends ClassLoader {
    public bba(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class findClass(String str) {
        return bba.class.getClassLoader().loadClass(str);
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String str) {
        Class<?> clsLoadClass;
        try {
            if (!str.startsWith("com.airbnb.lottie") && (clsLoadClass = super.loadClass(str)) != null) {
                return clsLoadClass;
            }
        } catch (Throwable unused) {
        }
        return findClass(str);
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String str, boolean z) {
        Class<?> clsLoadClass;
        try {
            if (!str.startsWith("com.airbnb.lottie") && (clsLoadClass = super.loadClass(str, z)) != null) {
                return clsLoadClass;
            }
        } catch (Throwable unused) {
        }
        return findClass(str);
    }
}
