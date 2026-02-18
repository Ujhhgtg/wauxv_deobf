package bsh.classpath;

import bsh.util.DataUtil;
import dalvik.system.InMemoryDexClassLoader;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshLoaderManager {
    private static final HashSet<ClassLoader> loaders = new HashSet<>();
    private static final HashMap<String, ClassLoader> dexLoaders = new HashMap<>();

    public static void addLoader(ClassLoader classLoader) {
        if (classLoader != null) {
            loaders.add(classLoader);
        }
    }

    public static Class<?> getClass(String str) {
        Iterator<ClassLoader> it = loaders.iterator();
        while (it.hasNext()) {
            try {
                return it.next().loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        return null;
    }

    public static ClassLoader getDexLoader(String str, ClassLoader classLoader) {
        String fileMD5 = DataUtil.getFileMD5(str);
        HashMap<String, ClassLoader> map = dexLoaders;
        if (map.containsKey(fileMD5)) {
            return map.get(fileMD5);
        }
        try {
            InMemoryDexClassLoader inMemoryDexClassLoader = new InMemoryDexClassLoader(ByteBuffer.wrap(Files.readAllBytes(new File(str).toPath())), classLoader);
            map.put(fileMD5, inMemoryDexClassLoader);
            return inMemoryDexClassLoader;
        } catch (Exception unused) {
            return null;
        }
    }
}
