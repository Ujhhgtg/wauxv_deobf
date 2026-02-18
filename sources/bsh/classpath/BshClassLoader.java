package bsh.classpath;

import bsh.BshClassManager;
import bsh.Interpreter;
import java.net.URL;
import java.net.URLClassLoader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshClassLoader extends URLClassLoader {
    BshClassManager classManager;

    public BshClassLoader(BshClassManager bshClassManager, URL[] urlArr) {
        super(urlArr);
        this.classManager = bshClassManager;
    }

    @Override // java.net.URLClassLoader
    public void addURL(URL url) {
        super.addURL(url);
    }

    @Override // java.net.URLClassLoader, java.lang.ClassLoader
    public Class findClass(String str) throws ClassNotFoundException {
        ClassManagerImpl classManagerImpl = (ClassManagerImpl) getClassManager();
        ClassLoader loaderForClass = classManagerImpl.getLoaderForClass(str);
        if (loaderForClass != null && loaderForClass != this) {
            try {
                return loaderForClass.loadClass(str);
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException("Designated loader could not find class: " + e);
            }
        }
        if (getURLs().length > 0) {
            try {
                return super.findClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        ClassLoader baseLoader = classManagerImpl.getBaseLoader();
        if (baseLoader != null && baseLoader != this) {
            try {
                return baseLoader.loadClass(str);
            } catch (ClassNotFoundException unused2) {
            }
        }
        return classManagerImpl.plainClassForName(str);
    }

    public BshClassManager getClassManager() {
        return this.classManager;
    }

    @Override // java.lang.ClassLoader
    public Class loadClass(String str, boolean z) throws ClassNotFoundException {
        ClassLoader classLoader;
        if (str.startsWith("java.")) {
            return super.loadClass(str, z);
        }
        Class<?> clsFindLoadedClass = findLoadedClass(str);
        if (clsFindLoadedClass != null) {
            return clsFindLoadedClass;
        }
        if (str.startsWith("bsh") && (classLoader = Interpreter.class.getClassLoader()) != null) {
            try {
                return classLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        Class clsFindClass = findClass(str);
        if (z) {
            resolveClass(clsFindClass);
        }
        return clsFindClass;
    }

    public BshClassLoader(BshClassManager bshClassManager, BshClassPath bshClassPath) {
        this(bshClassManager, bshClassPath.getPathComponents());
    }

    public BshClassLoader(BshClassManager bshClassManager) {
        this(bshClassManager, new URL[0]);
    }
}
