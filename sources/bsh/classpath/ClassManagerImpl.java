package bsh.classpath;

import bsh.BshClassManager;
import bsh.ClassPathException;
import bsh.Interpreter;
import bsh.InterpreterError;
import bsh.UtilEvalError;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassManagerImpl extends BshClassManager {
    static final String BSH_PACKAGE = "bsh";
    private BshClassPath baseClassPath;
    private BshClassLoader baseLoader;
    private BshClassPath fullClassPath;
    private boolean superImport;
    private final Set<WeakReference<BshClassManager.Listener>> listeners = ConcurrentHashMap.newKeySet();
    private final ReferenceQueue<BshClassManager.Listener> refQueue = new ReferenceQueue<>();
    private final Map<String, DiscreteFilesClassLoader> loaderMap = new ConcurrentHashMap();

    public ClassManagerImpl() {
        reset();
    }

    private void initBaseLoader() {
        this.baseLoader = new BshClassLoader(this, this.baseClassPath);
    }

    @Override // bsh.BshClassManager
    public void addClassPath(URL url) {
        BshClassLoader bshClassLoader = this.baseLoader;
        if (bshClassLoader == null) {
            setClassPath(new URL[]{url});
            return;
        }
        bshClassLoader.addURL(url);
        this.baseClassPath.add(url);
        classLoaderChanged();
    }

    @Override // bsh.BshClassManager
    public void addListener(BshClassManager.Listener listener) {
        this.listeners.add(new WeakReference<>(listener, this.refQueue));
        while (true) {
            Reference<? extends BshClassManager.Listener> referencePoll = this.refQueue.poll();
            if (referencePoll == null) {
                return;
            }
            if (!this.listeners.remove(referencePoll)) {
                Interpreter.debug("tried to remove non-existent weak ref: ", referencePoll);
            }
        }
    }

    @Override // bsh.BshClassManager
    public Class<?> classForName(String str) {
        ClassLoader classLoader;
        BshClassLoader bshClassLoader;
        Class<?> clsLoadClass = this.absoluteClassCache.get(str);
        if (clsLoadClass != null) {
            return clsLoadClass;
        }
        if (this.absoluteNonClasses.contains(str)) {
            Interpreter.debug("absoluteNonClass list hit: ", str);
            return null;
        }
        Interpreter.debug("Trying to load class: ", str);
        ClassLoader loaderForClass = getLoaderForClass(str);
        if (loaderForClass != null) {
            try {
                clsLoadClass = loaderForClass.loadClass(str);
            } catch (Exception e) {
                Interpreter.debug("overlay loader failed for '", "' - ", e);
            }
        }
        if (clsLoadClass == null && str.startsWith(BSH_PACKAGE)) {
            ClassLoader classLoader2 = Interpreter.class.getClassLoader();
            try {
                clsLoadClass = classLoader2 != null ? classLoader2.loadClass(str) : Class.forName(str);
            } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            }
        }
        if (clsLoadClass == null && (bshClassLoader = this.baseLoader) != null) {
            try {
                clsLoadClass = bshClassLoader.loadClass(str);
            } catch (ClassNotFoundException unused2) {
            }
        }
        if (clsLoadClass == null && (classLoader = this.externalClassLoader) != null) {
            try {
                clsLoadClass = classLoader.loadClass(str);
            } catch (ClassNotFoundException unused3) {
            }
        }
        if (clsLoadClass == null) {
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null) {
                    clsLoadClass = Class.forName(str, true, contextClassLoader);
                }
            } catch (ClassNotFoundException | NoClassDefFoundError | SecurityException unused4) {
            }
        }
        if (clsLoadClass == null) {
            try {
                clsLoadClass = Class.forName(str);
            } catch (ClassNotFoundException unused5) {
            } catch (NoClassDefFoundError e2) {
                PrintStream printStream = System.err;
                StringBuilder sbZ = StaticHelpers6.concatAndToSb("The class named '", str, "' could not be found, either because it no longer exists or it is not contained in the class file of the same name. Caused by: ");
                sbZ.append(e2.getMessage());
                printStream.println(sbZ.toString());
            }
        }
        if (clsLoadClass == null) {
            clsLoadClass = loadSourceClass(str);
        }
        cacheClassInfo(str, clsLoadClass);
        return clsLoadClass;
    }

    @Override // bsh.BshClassManager
    public void classLoaderChanged() {
        ArrayList arrayList = new ArrayList();
        for (WeakReference<BshClassManager.Listener> weakReference : this.listeners) {
            BshClassManager.Listener listener = weakReference.get();
            if (listener == null) {
                arrayList.add(weakReference);
            } else {
                listener.classLoaderChanged();
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.listeners.remove((WeakReference) it.next());
        }
    }

    @Override // bsh.BshClassManager
    public Class<?> defineClass(String str, byte[] bArr) {
        this.baseClassPath.setClassSource(str, new BshClassPath.GeneratedClassSource(bArr));
        try {
            reloadClasses(new String[]{str});
            return classForName(str);
        } catch (ClassPathException e) {
            throw new InterpreterError("defineClass: " + e, e);
        }
    }

    @Override // bsh.BshClassManager
    public void doSuperImport() throws UtilEvalError {
        try {
            getClassPath().insureInitialized();
            getClassNameByUnqName("");
            this.superImport = true;
        } catch (ClassPathException e) {
            throw new UtilEvalError("Error importing classpath " + e, e);
        }
    }

    @Override // bsh.BshClassManager
    public void dump(PrintWriter printWriter) {
        printWriter.println("Bsh Class Manager Dump: ");
        printWriter.println("----------------------- ");
        printWriter.println("baseLoader = " + this.baseLoader);
        printWriter.println("loaderMap= " + this.loaderMap);
        printWriter.println("----------------------- ");
        printWriter.println("baseClassPath = " + this.baseClassPath);
    }

    public ClassLoader getBaseLoader() {
        return this.baseLoader;
    }

    @Override // bsh.BshClassManager
    public String getClassNameByUnqName(String str) {
        return getClassPath().getClassNameByUnqName(str);
    }

    public BshClassPath getClassPath() {
        BshClassPath bshClassPath = this.fullClassPath;
        if (bshClassPath != null) {
            return bshClassPath;
        }
        BshClassPath bshClassPath2 = new BshClassPath("BeanShell Full Class Path");
        this.fullClassPath = bshClassPath2;
        bshClassPath2.addComponent(BshClassPath.getUserClassPath());
        try {
            this.fullClassPath.addComponent(BshClassPath.getBootClassPath());
        } catch (ClassPathException unused) {
            System.err.println("Warning: can't get boot class path");
        }
        this.fullClassPath.addComponent(this.baseClassPath);
        return this.fullClassPath;
    }

    public ClassLoader getLoaderForClass(String str) {
        return this.loaderMap.get(str);
    }

    @Override // bsh.BshClassManager
    public URL getResource(String str) {
        BshClassLoader bshClassLoader = this.baseLoader;
        URL resource = bshClassLoader != null ? bshClassLoader.getResource(str.substring(1)) : null;
        return resource == null ? super.getResource(str) : resource;
    }

    @Override // bsh.BshClassManager
    public InputStream getResourceAsStream(String str) {
        BshClassLoader bshClassLoader = this.baseLoader;
        InputStream resourceAsStream = bshClassLoader != null ? bshClassLoader.getResourceAsStream(str.substring(1)) : null;
        return resourceAsStream == null ? super.getResourceAsStream(str) : resourceAsStream;
    }

    @Override // bsh.BshClassManager
    public boolean hasSuperImport() {
        return this.superImport;
    }

    @Override // bsh.BshClassManager
    public void reloadAllClasses() {
        BshClassPath bshClassPath = new BshClassPath("temp");
        bshClassPath.addComponent(this.baseClassPath);
        bshClassPath.addComponent(BshClassPath.getUserClassPath());
        setClassPath(bshClassPath.getPathComponents());
    }

    @Override // bsh.BshClassManager
    public void reloadClasses(String[] strArr) throws ClassPathException {
        clearCaches();
        if (this.baseLoader == null) {
            initBaseLoader();
        }
        DiscreteFilesClassLoader.ClassSourceMap classSourceMap = new DiscreteFilesClassLoader.ClassSourceMap();
        for (String str : strArr) {
            BshClassPath.ClassSource classSource = this.baseClassPath.getClassSource(str);
            if (classSource == null) {
                BshClassPath.getUserClassPath().insureInitialized();
                classSource = BshClassPath.getUserClassPath().getClassSource(str);
            }
            if (classSource == null) {
                throw new ClassPathException(yg.k("Nothing known about class: ", str));
            }
            if (classSource instanceof BshClassPath.JarClassSource) {
                throw new ClassPathException("Cannot reload class: " + str + " from source: " + classSource);
            }
            classSourceMap.put(str, classSource);
        }
        DiscreteFilesClassLoader.newInstance(this, classSourceMap);
        Iterator<String> it = classSourceMap.keySet().iterator();
        while (it.hasNext()) {
            this.loaderMap.put(it.next(), DiscreteFilesClassLoader.instance());
        }
        classLoaderChanged();
    }

    @Override // bsh.BshClassManager
    public void reloadPackage(String str) throws ClassPathException {
        Set<String> classesForPackage = this.baseClassPath.getClassesForPackage(str);
        if (classesForPackage == null) {
            classesForPackage = BshClassPath.getUserClassPath().getClassesForPackage(str);
        }
        if (classesForPackage == null) {
            throw new ClassPathException(yg.k("No classes found for package: ", str));
        }
        reloadClasses((String[]) classesForPackage.toArray(new String[classesForPackage.size()]));
    }

    @Override // bsh.BshClassManager
    public void removeListener(BshClassManager.Listener listener) {
        throw new Error("unimplemented");
    }

    @Override // bsh.BshClassManager
    public void reset() {
        this.baseClassPath = new BshClassPath("baseClassPath");
        this.baseLoader = null;
        this.loaderMap.clear();
        classLoaderChanged();
    }

    @Override // bsh.BshClassManager
    public void setClassPath(URL[] urlArr) {
        this.baseClassPath.setPath(urlArr);
        initBaseLoader();
        this.loaderMap.clear();
        classLoaderChanged();
    }
}
