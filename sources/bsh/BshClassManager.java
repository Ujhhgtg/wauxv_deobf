package bsh;

import bsh.Capabilities;
import bsh.util.ReferenceCache;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.ra;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshClassManager {
    static final ReferenceCache<Class<?>, MemberCache> memberCache;
    protected final transient Map<String, Class<?>> absoluteClassCache = new ConcurrentHashMap();
    protected final transient Set<String> absoluteNonClasses = ConcurrentHashMap.newKeySet();
    protected final transient Map<String, Class<?>> associatedClasses = new ConcurrentHashMap();
    private Interpreter declaringInterpreter;
    protected ClassLoader externalClassLoader;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface Listener {
        void classLoaderChanged();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class MemberCache {
        private final Map<String, List<Invocable>> cache = new ConcurrentHashMap();
        private final Map<String, Invocable> fields = new ConcurrentHashMap();

        public MemberCache(Class<?> cls) {
            Class<?> superclass = cls;
            while (superclass != null) {
                if (Reflect.isPackageAccessible(superclass)
                        && ((Reflect.isPackageScope(superclass) && !Reflect.isPrivate(superclass))
                                || Reflect.isPublic(superclass) || Capabilities.haveAccessibility())) {
                    for (Field field : superclass.getDeclaredFields()) {
                        if (Reflect.isPublic(field) || Capabilities.haveAccessibility()) {
                            cacheMember(Invocable.get(field));
                        }
                    }
                    for (Method method : superclass.getDeclaredMethods()) {
                        if (Reflect.isPublic(method) || Capabilities.haveAccessibility()) {
                            if (cls == superclass) {
                                cacheMember(Invocable.get(method));
                            } else {
                                cacheMember(BshClassManager.memberCache.get(superclass).findMethod(method.getName(),
                                        method.getParameterTypes()));
                            }
                        }
                    }
                    for (Constructor<?> constructor : superclass.getDeclaredConstructors()) {
                        if (cls == superclass) {
                            cacheMember(Invocable.get(constructor));
                        } else {
                            cacheMember(BshClassManager.memberCache.get(superclass).findMethod(constructor.getName(),
                                    constructor.getParameterTypes()));
                        }
                    }
                }
                processInterfaces(superclass.getInterfaces());
                superclass = superclass.getSuperclass();
                BshClassManager.memberCache.init(superclass);
            }
        }

        private boolean cacheMember(FieldAccess fieldAccess) {
            return !hasField(fieldAccess.getName()) && this.fields.put(fieldAccess.getName(), fieldAccess) == null;
        }

        private Invocable findBest(List<Invocable> list, Class<?>[] clsArr) {
            if (list.isEmpty()) {
                return null;
            }
            return list.size() == 1 ? list.get(0) : Reflect.findMostSpecificInvocable(clsArr, list);
        }

        private void processInterfaces(Class<?>[] clsArr) {
            for (Class<?> cls : clsArr) {
                if (Reflect.isPackageAccessible(cls)) {
                    BshClassManager.memberCache.init(cls);
                    for (Field field : cls.getDeclaredFields()) {
                        cacheMember(Invocable.get(field));
                    }
                    for (Method method : cls.getDeclaredMethods()) {
                        if (Reflect.isPublic(method) || Capabilities.haveAccessibility()) {
                            cacheMember(BshClassManager.memberCache.get(cls).findMethod(method.getName(),
                                    method.getParameterTypes()));
                        }
                    }
                }
                processInterfaces(cls.getInterfaces());
            }
        }

        public Invocable findField(String str) {
            if (hasField(str)) {
                return this.fields.get(str);
            }
            return null;
        }

        public Invocable findGetter(String str) {
            if (!hasMember(str)) {
                return null;
            }
            for (Invocable invocable : members(str)) {
                if (invocable.isGetter()) {
                    return invocable;
                }
            }
            return null;
        }

        public int findMemberIndex(String str, Class<?>[] clsArr) {
            return Reflect.findMostSpecificInvocableIndex(clsArr, members(str));
        }

        public Invocable findMethod(String str, Object... objArr) {
            return findMethod(str, Types.getTypes(objArr));
        }

        public Invocable findSetter(String str) {
            if (!hasMember(str)) {
                return null;
            }
            for (Invocable invocable : members(str)) {
                if (invocable.isSetter()) {
                    return invocable;
                }
            }
            return null;
        }

        public Invocable findStaticMethod(String str) {
            if (hasMember(str)) {
                return members(str).stream().filter(new ra(0)).findFirst().get();
            }
            return null;
        }

        public boolean hasField(String str) {
            return this.fields.containsKey(str);
        }

        public boolean hasMember(String str) {
            return this.cache.containsKey(str);
        }

        public int memberCount(String str) {
            return members(str).size();
        }

        public List<Invocable> members(String str) {
            return this.cache.get(str);
        }

        public Invocable findMethod(String str, Class<?>... clsArr) {
            if (hasMember(str)) {
                return findBest(members(str), clsArr);
            }
            return null;
        }

        private boolean cacheMember(Invocable invocable) {
            if (invocable == null) {
                return false;
            }
            if (!invocable.isGetter() && !invocable.isSetter()) {
                return cacheMember(invocable.getName(), invocable);
            }
            String name = invocable.getName();
            String strReplaceFirst = name.replaceFirst("[gs]et|is", "");
            if (strReplaceFirst.length() == 1 || Character.isLowerCase(name.charAt(1))) {
                char[] charArray = strReplaceFirst.toCharArray();
                charArray[0] = Character.toLowerCase(charArray[0]);
                strReplaceFirst = new String(charArray);
            }
            return cacheMember(name, invocable) && cacheMember(strReplaceFirst, invocable);
        }

        private boolean cacheMember(String str, Invocable invocable) {
            if (!hasMember(str)) {
                return this.cache.put(str, Collections.singletonList(invocable)) == null;
            }
            if (memberCount(str) == 1) {
                this.cache.put(str, new ArrayList(members(str)));
            }
            return members(str).add(invocable);
        }
    }

    static {
        ReferenceCache.Type type = ReferenceCache.Type.Soft;
        memberCache = new ReferenceCache<Class<?>, MemberCache>(type, type, 50) { // from class: bsh.BshClassManager.1
            @Override // bsh.util.ReferenceCache
            public MemberCache create(Class<?> cls) {
                return new MemberCache(cls);
            }
        };
    }

    public static UtilEvalError cmUnavailable() {
        return new Capabilities.Unavailable("ClassLoading features unavailable.");
    }

    public static BshClassManager createClassManager(Interpreter interpreter) {
        BshClassManager bshClassManager;
        if (Capabilities.classExists("bsh.classpath.ClassManagerImpl")) {
            try {
                bshClassManager = (BshClassManager) Capabilities.getExisting("bsh.classpath.ClassManagerImpl")
                        .getConstructor(null).newInstance(null);
            } catch (IllegalArgumentException | ReflectiveOperationException | SecurityException e) {
                throw new InterpreterError("Error loading classmanager", e);
            }
        } else {
            bshClassManager = new BshClassManager();
        }
        bshClassManager.declaringInterpreter = interpreter;
        return bshClassManager;
    }

    public void addClassPath(URL url) {
    }

    public void addListener(Listener listener) {
    }

    public void associateClass(Class<?> cls) {
        if (Reflect.isGeneratedClass(cls)) {
            this.associatedClasses.put(cls.getName(), cls);
        }
    }

    public void cacheClassInfo(String str, Class<?> cls) {
        if (cls == null) {
            this.absoluteNonClasses.add(str);
        } else {
            this.absoluteClassCache.put(str, cls);
            memberCache.init(cls);
        }
    }

    public boolean classExists(String str) {
        return classForName(str) != null;
    }

    public Class<?> classForName(String str) {
        Class<?> clsPlainClassForName;
        try {
            clsPlainClassForName = plainClassForName(str);
        } catch (ClassNotFoundException unused) {
            clsPlainClassForName = null;
        }
        return (clsPlainClassForName == null && this.declaringInterpreter.getCompatibility()) ? loadSourceClass(str)
                : clsPlainClassForName;
    }

    public void classLoaderChanged() {
    }

    public void clearCaches() {
        this.absoluteNonClasses.clear();
        this.absoluteClassCache.clear();
        memberCache.clear();
    }

    public Class<?> defineClass(String str, byte[] bArr) {
        throw new InterpreterError(concat("Can't create class (", str, ") without class manager package."));
    }

    public void doSuperImport() throws UtilEvalError {
        throw cmUnavailable();
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("BshClassManager: no class manager.");
    }

    public Class<?> getAssociatedClass(String str) {
        return this.associatedClasses.get(str);
    }

    public String getClassNameByUnqName(String str) throws UtilEvalError {
        throw cmUnavailable();
    }

    public URL getResource(String str) {
        ClassLoader classLoader = this.externalClassLoader;
        URL resource = classLoader != null ? classLoader.getResource(str.substring(1)) : null;
        return resource == null ? Interpreter.class.getResource(str) : resource;
    }

    public InputStream getResourceAsStream(String str) {
        ClassLoader classLoader = this.externalClassLoader;
        InputStream resourceAsStream = classLoader != null ? classLoader.getResourceAsStream(str.substring(1)) : null;
        return resourceAsStream == null ? Interpreter.class.getResourceAsStream(str) : resourceAsStream;
    }

    public boolean getStrictJava() {
        Interpreter interpreter = this.declaringInterpreter;
        return interpreter != null && interpreter.getStrictJava();
    }

    public boolean hasSuperImport() {
        return false;
    }

    public Class<?> loadSourceClass(String str) {
        String str2 = "/" + str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/')
                + ".java";
        URL resource = getResource(str2);
        if (resource == null) {
            return null;
        }
        try {
            FileReader fileReader = new FileReader((InputStream) resource.getContent());
            try {
                Interpreter.debug("Loading class from source file: " + str2);
                this.declaringInterpreter.eval(fileReader);
                fileReader.close();
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (EvalError | IOException e) {
            if (Interpreter.DEBUG.get().booleanValue()) {
                e.printStackTrace();
            }
        }
        try {
            return plainClassForName(str);
        } catch (ClassNotFoundException unused) {
            Interpreter.debug("Class not found in source file: ".concat(str));
            return null;
        }
    }

    public Class<?> plainClassForName(String str) {
        ClassLoader classLoader = this.externalClassLoader;
        Class<?> clsLoadClass = classLoader != null ? classLoader.loadClass(str) : Class.forName(str);
        cacheClassInfo(str, clsLoadClass);
        return clsLoadClass;
    }

    public void reloadAllClasses() throws UtilEvalError {
        throw cmUnavailable();
    }

    public void reloadClasses(String[] strArr) throws UtilEvalError {
        throw cmUnavailable();
    }

    public void reloadPackage(String str) throws UtilEvalError {
        throw cmUnavailable();
    }

    public void removeListener(Listener listener) {
    }

    public void reset() {
        clearCaches();
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.externalClassLoader = classLoader;
        classLoaderChanged();
    }

    public void setClassPath(URL[] urlArr) throws UtilEvalError {
        throw cmUnavailable();
    }
}
