package me.hd.wauxv.obf;

import dalvik.system.PathClassLoader;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Executable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agx extends PathClassLoader {
    @Override // java.lang.ClassLoader
    public final Class loadClass(String str) {
        if (Object.class.getName().equals(str)) {
            return Object.class;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException unused) {
            return Executable.class.getName().equals(str) ? bkq.class : MethodHandle.class.getName().equals(str) ? bkr.class : Class.class.getName().equals(str) ? bkp.class : super.loadClass(str);
        }
    }
}
