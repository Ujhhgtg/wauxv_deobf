package bsh.classpath;

import bsh.BshClassManager;
import bsh.classpath.BshClassPath;
import bsh.util.DexClassLoaderHelper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DiscreteFilesClassLoader extends BshClassLoader {
    private static DiscreteFilesClassLoader instance;
    ClassSourceMap map;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ClassSourceMap extends HashMap<String, BshClassPath.ClassSource> {
        private static final long serialVersionUID = 1;

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public BshClassPath.ClassSource get(Object obj) {
            return (BshClassPath.ClassSource) super.get(obj);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public BshClassPath.ClassSource put(String str, BshClassPath.ClassSource classSource) {
            return (BshClassPath.ClassSource) super.put(str, classSource);
        }
    }

    public DiscreteFilesClassLoader(BshClassManager bshClassManager, ClassSourceMap classSourceMap) {
        super(bshClassManager);
        this.map = classSourceMap;
    }

    public static DiscreteFilesClassLoader instance() {
        return instance;
    }

    public static void newInstance(BshClassManager bshClassManager, ClassSourceMap classSourceMap) {
        instance = new DiscreteFilesClassLoader(bshClassManager, classSourceMap);
    }

    @Override // bsh.classpath.BshClassLoader, java.net.URLClassLoader, java.lang.ClassLoader
    public Class findClass(String str) {
        BshClassPath.ClassSource classSource = this.map.get((Object) str);
        if (classSource == null) {
            return super.findClass(str);
        }
        return new DexClassLoaderHelper().loadClassInternal(str, classSource.getCode(str));
    }

    public String toString() {
        return super.toString() + "for files: " + this.map;
    }
}
