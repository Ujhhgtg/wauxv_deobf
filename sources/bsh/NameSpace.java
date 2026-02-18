package bsh;

import bsh.BshClassManager;
import bsh.NameSource;
import bsh.classpath.BshLoaderManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import me.hd.wauxv.obf.cik;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.ky;
import me.hd.wauxv.obf.rb;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class NameSpace implements Serializable, BshClassManager.Listener, NameSource, Cloneable {
    public static final NameSpace JAVACODE;
    private static final long serialVersionUID = 1;
    Node callerInfoNode;
    private transient Map<String, Class<?>> classCache;
    Object classInstance;
    private transient BshClassManager classManager;
    Class<?> classStatic;
    protected Map<String, String> importedClasses;
    private List<String> importedCommands;
    private List<Object> importedObjects;
    private List<String> importedPackages;
    private List<Class<?>> importedStatic;
    boolean isClass;
    boolean isEnum;
    boolean isInterface;
    boolean isMethod;
    private Map<String, List<BshMethod>> methods;
    private List<NameSource.Listener> nameSourceListeners;
    private Map<String, Name> names;
    private String nsName;
    private String packageName;
    private NameSpace parent;
    private This thisReference;
    private Map<String, Variable> variables;

    static {
        NameSpace nameSpace = new NameSpace(null, null, "Called from compiled Java code.");
        JAVACODE = nameSpace;
        nameSpace.isMethod = true;
    }

    public NameSpace(NameSpace nameSpace, String str) {
        this(nameSpace, null, str);
    }

    private Class<?> classForName(String str) {
        return getClassManager().classForName(str);
    }

    private <K, V> Map<K, V> clone(Map<K, V> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }

    private Class<?> getClassImpl(String str) {
        if (this.classCache.containsKey(str)) {
            return this.classCache.get(str);
        }
        if (!Name.isCompound(str)) {
            Class<?> importedClassImpl = getImportedClassImpl(str);
            if (importedClassImpl == null) {
                importedClassImpl = classForName(str);
            }
            if (importedClassImpl != null) {
                cacheClass(str, importedClassImpl);
                return importedClassImpl;
            }
        }
        Class<?> clsClassForName = classForName(str);
        if (clsClassForName != null) {
            return clsClassForName;
        }
        Interpreter.debug("getClass(): ", str, " not found in ", this);
        return null;
    }

    private Class<?> getImportedClassImpl(String str) {
        String classNameByUnqName;
        String str2 = this.importedClasses.get(str);
        if (str2 != null) {
            Class<?> clsClassForName = classForName(str2);
            if (clsClassForName != null) {
                return clsClassForName;
            }
            if (Name.isCompound(str2)) {
                try {
                    clsClassForName = getNameResolver(str2).toClass();
                } catch (ClassNotFoundException unused) {
                }
            }
            Interpreter.debug("imported unpackaged name not found:", str2);
            if (clsClassForName == null) {
                return null;
            }
            getClassManager().cacheClassInfo(str2, clsClassForName);
            return clsClassForName;
        }
        Iterator<String> it = this.importedPackages.iterator();
        while (it.hasNext()) {
            Class<?> clsClassForName2 = classForName(it.next() + "." + str);
            if (clsClassForName2 != null) {
                return clsClassForName2;
            }
        }
        BshClassManager classManager = getClassManager();
        if (!classManager.hasSuperImport() || (classNameByUnqName = classManager.getClassNameByUnqName(str)) == null) {
            return null;
        }
        return classForName(classNameByUnqName);
    }

    public static Class<?> identifierToClass(ClassIdentifier classIdentifier) {
        return classIdentifier.getTargetClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Variable[] lambda$getDeclaredVariables$5(int i) {
        return new Variable[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getMethodNames$2(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BshMethod[] lambda$getMethods$4(int i) {
        return new BshMethod[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getVariableNames$0(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Variable[] lambda$getVariables$1(int i) {
        return new Variable[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Variable lambda$toLambdaNameSpace$6(String str, Variable variable) {
        Variable variableClone = variable.m3clone();
        variableClone.modifiers.addModifier("final");
        return variableClone;
    }

    private BshMethod loadScriptedCommand(InputStream inputStream, String str, Class<?>[] clsArr, String str2, Interpreter interpreter) throws UtilEvalError {
        try {
            FileReader fileReader = new FileReader(inputStream);
            try {
                interpreter.eval(fileReader, this, str2);
                fileReader.close();
                return getMethod(str, clsArr);
            } catch (Throwable th) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (EvalError | IOException e) {
            Interpreter.debug(e.toString());
            throw new UtilEvalError("Error loading script: " + e.getMessage(), e);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.classCache = new HashMap();
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        this.names.clear();
        objectOutputStream.defaultWriteObject();
    }

    @Override // bsh.NameSource
    public void addNameSourceListener(NameSource.Listener listener) {
        this.nameSourceListeners.add(listener);
    }

    public boolean attemptSetPropertyValue(String str, Object obj, Interpreter interpreter) throws UtilEvalError {
        String strAccessorName = Reflect.accessorName("set", str);
        Object objUnwrap = Primitive.unwrap(obj);
        if (getMethod(strAccessorName, new Class[]{objUnwrap == null ? null : objUnwrap.getClass()}) == null) {
            return false;
        }
        try {
            invokeMethod(strAccessorName, new Object[]{obj}, interpreter);
            return true;
        } catch (EvalError e) {
            throw new UtilEvalError("'This' property accessor threw exception: " + e.getMessage(), e);
        }
    }

    public void cacheClass(String str, Class<?> cls) {
        this.classCache.put(str, cls);
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        nameSpaceChanged();
    }

    public void clear() {
        this.variables.clear();
        this.methods.clear();
        this.importedClasses.clear();
        this.importedPackages.clear();
        this.importedCommands.clear();
        this.importedObjects.clear();
        if (this.parent == null) {
            loadDefaultImports();
        }
        this.classCache.clear();
        this.names.clear();
    }

    public NameSpace copy() {
        try {
            NameSpace nameSpace = (NameSpace) clone();
            nameSpace.thisReference = null;
            nameSpace.variables = clone(this.variables);
            nameSpace.methods = clone(this.methods);
            nameSpace.importedClasses = clone(this.importedClasses);
            nameSpace.importedPackages = clone(this.importedPackages);
            nameSpace.importedCommands = clone(this.importedCommands);
            nameSpace.importedObjects = clone(this.importedObjects);
            nameSpace.importedStatic = clone(this.importedStatic);
            nameSpace.names = clone(this.names);
            return nameSpace;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }

    public Variable createVariable(String str, Object obj, Modifiers modifiers) {
        return createVariable(str, null, obj, modifiers);
    }

    public void doSuperImport() throws UtilEvalError {
        getClassManager().doSuperImport();
    }

    public Object get(String str, Interpreter interpreter) {
        return getNameResolver(str).toObject(new CallStack(this), interpreter);
    }

    @Override // bsh.NameSource
    public String[] getAllNames() {
        ArrayList arrayList = new ArrayList();
        getAllNamesAux(arrayList);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void getAllNamesAux(List<String> list) {
        list.addAll(this.variables.keySet());
        Map<String, List<BshMethod>> map = this.methods;
        if (map != null) {
            list.addAll(map.keySet());
        }
        NameSpace nameSpace = this.parent;
        if (nameSpace != null) {
            nameSpace.getAllNamesAux(list);
        }
    }

    public Class<?> getClass(String str) {
        Class<?> classImpl = getClassImpl(str);
        if (classImpl != null) {
            return classImpl;
        }
        NameSpace nameSpace = this.parent;
        if (nameSpace != null) {
            return nameSpace.getClass(str);
        }
        Class<?> cls = BshLoaderManager.getClass(str);
        if (cls != null) {
            return cls;
        }
        return null;
    }

    public Object getClassInstance() throws UtilEvalError {
        Object obj = this.classInstance;
        if (obj != null) {
            return obj;
        }
        if (this.classStatic != null) {
            throw new UtilEvalError("Can't refer to class instance from static context.");
        }
        throw new InterpreterError("Can't resolve class instance 'this' in: " + this);
    }

    public BshClassManager getClassManager() {
        BshClassManager bshClassManager = this.classManager;
        if (bshClassManager != null) {
            return bshClassManager;
        }
        NameSpace nameSpace = this.parent;
        if (nameSpace != null && nameSpace != JAVACODE) {
            return nameSpace.getClassManager();
        }
        setClassManager(BshClassManager.createClassManager(null));
        return this.classManager;
    }

    public Object getCommand(String str, Class<?>[] clsArr, Interpreter interpreter) {
        String str2;
        Class<?>[] clsArr2;
        Interpreter interpreter2;
        String strO;
        Interpreter.debug("Get command: ", str);
        BshClassManager classManager = interpreter.getClassManager();
        for (String str3 : this.importedCommands) {
            String str4 = str3.equals("/") ? str3 + str + ".bsh" : str3 + "/" + str + ".bsh";
            Interpreter.debug(yg.k("searching for script: ", str4));
            URL resource = classManager.getResource(str4);
            if (resource != null) {
                try {
                    str2 = str;
                    clsArr2 = clsArr;
                    interpreter2 = interpreter;
                    try {
                        return loadScriptedCommand((InputStream) resource.getContent(), str2, clsArr2, str4, interpreter2);
                    } catch (IOException unused) {
                    }
                } catch (IOException unused2) {
                    str2 = str;
                    clsArr2 = clsArr;
                    interpreter2 = interpreter;
                }
            } else {
                str2 = str;
                clsArr2 = clsArr;
                interpreter2 = interpreter;
            }
            if (str3.equals("/")) {
                strO = str2;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str3.substring(1).replace('/', TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH));
                strO = yg.o(sb, ".", str2);
            }
            Interpreter.debug(yg.k("searching for class: ", strO));
            Class<?> clsClassForName = classManager.classForName(strO);
            if (clsClassForName != null) {
                return clsClassForName;
            }
            str = str2;
            clsArr = clsArr2;
            interpreter = interpreter2;
        }
        String str5 = str;
        Class<?>[] clsArr3 = clsArr;
        Interpreter interpreter3 = interpreter;
        NameSpace nameSpace = this.parent;
        if (nameSpace != null) {
            return nameSpace.getCommand(str5, clsArr3, interpreter3);
        }
        return null;
    }

    public Variable[] getDeclaredVariables() {
        return (Variable[]) this.variables.values().stream().toArray(new rb(7));
    }

    public This getGlobal(Interpreter interpreter) {
        NameSpace nameSpace = this.parent;
        return nameSpace != null ? nameSpace.getGlobal(interpreter) : getThis(interpreter);
    }

    public BshMethod getImportedMethod(String str, Class<?>[] clsArr) throws UtilEvalError {
        for (Object obj : this.importedObjects) {
            Invocable invocableResolveJavaMethod = Reflect.resolveJavaMethod(obj.getClass(), str, clsArr, false);
            if (invocableResolveJavaMethod != null) {
                return new BshMethod(invocableResolveJavaMethod, obj);
            }
        }
        Iterator<Class<?>> it = this.importedStatic.iterator();
        while (it.hasNext()) {
            Invocable invocableResolveJavaMethod2 = Reflect.resolveJavaMethod(it.next(), str, clsArr, true);
            if (invocableResolveJavaMethod2 != null) {
                return new BshMethod(invocableResolveJavaMethod2, (Object) null);
            }
        }
        return null;
    }

    public Variable getImportedVar(String str) {
        This classInstanceThis;
        Variable variableCreateVariable = null;
        for (Object obj : this.importedObjects) {
            Invocable invocableResolveJavaField = Reflect.resolveJavaField(obj.getClass(), str, false);
            if (invocableResolveJavaField != null) {
                variableCreateVariable = createVariable(str, invocableResolveJavaField.getReturnType(), new LHS(obj, invocableResolveJavaField));
            } else if (this.isClass) {
                Class<?> superclass = obj.getClass();
                while (true) {
                    superclass = superclass.getSuperclass();
                    if (!Reflect.isGeneratedClass(superclass) || ((classInstanceThis = Reflect.getClassInstanceThis(obj, superclass.getSimpleName())) != null && (variableCreateVariable = classInstanceThis.getNameSpace().variables.get(str)) != null)) {
                        break;
                    }
                }
            }
            if (variableCreateVariable != null) {
                this.variables.put(str, variableCreateVariable);
                return variableCreateVariable;
            }
        }
        Iterator<Class<?>> it = this.importedStatic.iterator();
        while (it.hasNext()) {
            Invocable invocableResolveJavaField2 = Reflect.resolveJavaField(it.next(), str, true);
            if (invocableResolveJavaField2 != null) {
                Variable variableCreateVariable2 = createVariable(str, invocableResolveJavaField2.getReturnType(), new LHS(invocableResolveJavaField2));
                this.variables.put(str, variableCreateVariable2);
                return variableCreateVariable2;
            }
        }
        return null;
    }

    public int getInvocationLine() {
        Node node = getNode();
        if (node != null) {
            return node.getLineNumber();
        }
        return -1;
    }

    public String getInvocationText() {
        Node node = getNode();
        return node != null ? node.getText() : "<invoked from Java code>";
    }

    public BshMethod getMethod(String str, Class<?>[] clsArr) {
        return getMethod(str, clsArr, false);
    }

    public String[] getMethodNames() {
        return (String[]) this.methods.keySet().stream().toArray(new rb(10));
    }

    public BshMethod[] getMethods() {
        return (BshMethod[]) this.methods.values().stream().flatMap(new ky(14)).toArray(new rb(9));
    }

    public String getName() {
        return this.nsName;
    }

    public Name getNameResolver(String str) {
        if (!this.names.containsKey(str)) {
            this.names.put(str, new Name(this, str));
        }
        return this.names.get(str);
    }

    public Node getNode() {
        Node node = this.callerInfoNode;
        if (node != null) {
            return node;
        }
        NameSpace nameSpace = this.parent;
        if (nameSpace != null) {
            return nameSpace.getNode();
        }
        return null;
    }

    public String getPackage() {
        String str = this.packageName;
        if (str != null) {
            return str;
        }
        NameSpace nameSpace = this.parent;
        if (nameSpace != null) {
            return nameSpace.getPackage();
        }
        return null;
    }

    public NameSpace getParent() {
        return this.parent;
    }

    public Object getPropertyValue(String str, Interpreter interpreter) throws UtilEvalError {
        String strAccessorName = Reflect.accessorName("get", str);
        Class<?>[] clsArr = Reflect.ZERO_TYPES;
        BshMethod method = getMethod(strAccessorName, clsArr);
        try {
            if (method != null) {
                return method.invoke(null, interpreter);
            }
            BshMethod method2 = getMethod(Reflect.accessorName("is", str), clsArr);
            return (method2 == null || method2.getReturnType() != Boolean.TYPE) ? Primitive.VOID : method2.invoke(null, interpreter);
        } catch (EvalError e) {
            throw new UtilEvalError("'This' property accessor threw exception: " + e.getMessage(), e);
        }
    }

    public This getSuper(Interpreter interpreter) {
        Class<?> cls;
        if (this.isClass && (cls = this.classStatic) != null) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (Reflect.isGeneratedClass(superclass)) {
                return Reflect.getClassInstanceThis(this.classInstance, superclass.getSimpleName());
            }
        }
        NameSpace nameSpace = this.parent;
        return nameSpace != null ? nameSpace.isClass ? nameSpace.getSuper(interpreter) : nameSpace.getThis(interpreter) : getThis(interpreter);
    }

    public This getThis(Interpreter interpreter) {
        if (this.thisReference == null) {
            this.thisReference = This.getThis(this, interpreter);
        }
        return this.thisReference;
    }

    public Object getVariable(String str) {
        return getVariable(str, true);
    }

    public Variable getVariableImpl(String str, boolean z) {
        NameSpace nameSpace;
        if (this.variables.containsKey(str)) {
            return this.variables.get(str);
        }
        Variable importedVar = getImportedVar(str);
        return (z && importedVar == null && (nameSpace = this.parent) != null) ? nameSpace.getVariableImpl(str, z) : importedVar;
    }

    public String[] getVariableNames() {
        return (String[]) this.variables.keySet().stream().toArray(new rb(8));
    }

    public Object getVariableOrProperty(String str, Interpreter interpreter) {
        Object variable = getVariable(str, true);
        return variable == Primitive.VOID ? getPropertyValue(str, interpreter) : variable;
    }

    public Variable[] getVariables() {
        return (Variable[]) this.variables.values().stream().toArray(new rb(6));
    }

    public void importClass(String str) {
        this.importedClasses.put(Name.suffix(str, 1), str);
        nameSpaceChanged();
    }

    public void importCommands(String str) {
        String strReplace = str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
        if (!strReplace.startsWith("/")) {
            strReplace = "/".concat(strReplace);
        }
        if (strReplace.length() > 1 && strReplace.endsWith("/")) {
            strReplace = yg.j(strReplace, 1, 0);
        }
        this.importedCommands.remove(strReplace);
        this.importedCommands.add(0, strReplace);
        nameSpaceChanged();
    }

    public void importObject(Object obj) {
        this.importedObjects.remove(obj);
        this.importedObjects.add(0, obj);
        nameSpaceChanged();
    }

    public void importPackage(String str) {
        this.importedPackages.remove(str);
        this.importedPackages.add(0, str);
        nameSpaceChanged();
    }

    public void importStatic(Class<?> cls) {
        this.importedStatic.remove(cls);
        this.importedStatic.add(0, cls);
        nameSpaceChanged();
    }

    public Object invokeCommand(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, Node node) {
        return invokeCommand(str, objArr, interpreter, callStack, node, false);
    }

    public Object invokeDefaultInvokeMethod(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, Node node, boolean[] zArr) {
        try {
            BshMethod method = getMethod("invoke", new Class[]{null, null});
            boolean z = method != null;
            zArr[0] = z;
            if (z) {
                return method.invoke(new Object[]{str, objArr}, interpreter, callStack, node);
            }
            return null;
        } catch (UtilEvalError e) {
            throw e.toEvalError("Local method invocation", node, callStack);
        }
    }

    public Object invokeMethod(String str, Object[] objArr, Interpreter interpreter) {
        return invokeMethod(str, objArr, interpreter, null, null);
    }

    public boolean isChildOf(NameSpace nameSpace) {
        if (getParent() != null) {
            return getParent().equals(nameSpace) || getParent().isChildOf(nameSpace);
        }
        return false;
    }

    public void loadDefaultImports() {
        importClass("bsh.EvalError");
        importClass("bsh.Interpreter");
        importClass("bsh.Capabilities");
        importPackage("java.net");
        importClass("java.util.Map.Entry");
        importPackage("java.util.function");
        importPackage("java.util.stream");
        importPackage("java.util.regex");
        importPackage("java.util");
        importPackage("java.io");
        importPackage("java.lang");
        importClass("bsh.FileReader");
        importPackage("java.math");
        importCommands("/bsh/commands");
    }

    public void nameSpaceChanged() {
        this.classCache.clear();
        this.names.clear();
    }

    public void prune() {
        getClassManager();
        setParent(null);
    }

    public void setClassInstance(Object obj) {
        this.classInstance = obj;
        importObject(obj);
    }

    public void setClassManager(BshClassManager bshClassManager) {
        this.classManager = bshClassManager;
    }

    public void setClassStatic(Class<?> cls) {
        this.classStatic = cls;
        importStatic(cls);
    }

    public Variable setLocalVariable(String str, Object obj, boolean z) {
        return setVariable(str, obj, z, false);
    }

    public void setLocalVariableOrProperty(String str, Object obj, boolean z) throws UtilEvalError {
        setVariableOrProperty(str, obj, z, false);
    }

    public void setMethod(BshMethod bshMethod) {
        String name = bshMethod.getName();
        if (!this.methods.containsKey(name)) {
            this.methods.put(name, new ArrayList(1));
        }
        this.methods.get(name).remove(bshMethod);
        this.methods.get(name).add(0, bshMethod);
    }

    public void setName(String str) {
        this.nsName = str;
    }

    public void setNode(Node node) {
        this.callerInfoNode = node;
    }

    public void setPackage(String str) {
        this.packageName = str;
    }

    public void setParent(NameSpace nameSpace) {
        this.parent = nameSpace;
        if (nameSpace == null) {
            loadDefaultImports();
        }
    }

    @Deprecated
    public void setTypedVariable(String str, Class<?> cls, Object obj, boolean z) {
        Modifiers modifiers = new Modifiers(3);
        if (z) {
            modifiers.addModifier("final");
        }
        setTypedVariable(str, cls, obj, modifiers);
    }

    public void setVariable(String str, Object obj, boolean z) {
        setVariable(str, obj, z, true);
    }

    public void setVariableImpl(Variable variable) {
        if (this.variables.containsKey(variable.getName())) {
            return;
        }
        this.variables.put(variable.getName(), variable);
    }

    public void setVariableOrProperty(String str, Object obj, boolean z) throws UtilEvalError {
        setVariableOrProperty(str, obj, z, true);
    }

    public NameSpace toLambdaNameSpace() {
        NameSpace nameSpaceCopy = copy();
        Stack stack = new Stack();
        for (NameSpace nameSpace = this.parent; nameSpace != null; nameSpace = nameSpace.parent) {
            stack.add(nameSpace);
        }
        while (!stack.isEmpty()) {
            NameSpace nameSpace2 = (NameSpace) stack.pop();
            if (!nameSpace2.isClass && !nameSpace2.isEnum) {
                nameSpaceCopy.variables.putAll(nameSpace2.variables);
            }
        }
        nameSpaceCopy.variables.replaceAll(new cik());
        return nameSpaceCopy;
    }

    public String toString() {
        String strO;
        StringBuilder sb = new StringBuilder("NameSpace: ");
        if (this.nsName == null) {
            strO = super.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.nsName);
            sb2.append(" (");
            strO = yg.o(sb2, super.toString(), ")");
        }
        sb.append(strO);
        sb.append(this.isClass ? " (class) " : "");
        sb.append(this.isInterface ? " (interface) " : "");
        sb.append(this.isEnum ? " (enum) " : "");
        sb.append(this.isMethod ? " (method) " : "");
        sb.append(this.classStatic != null ? " (class static) " : "");
        sb.append(this.classInstance != null ? " (class instance) " : "");
        return sb.toString();
    }

    public void unsetVariable(String str) {
        this.variables.remove(str);
        nameSpaceChanged();
    }

    public Object unwrapVariable(Variable variable) {
        return variable == null ? Primitive.VOID : variable.getValue();
    }

    public NameSpace(String str) {
        this(null, null, str);
    }

    private <T> List<T> clone(List<T> list) {
        if (list == null) {
            return null;
        }
        return new ArrayList(list);
    }

    public Variable createVariable(String str, Class<?> cls, Object obj, Modifiers modifiers) {
        return new Variable(str, cls, obj, modifiers);
    }

    public BshMethod getMethod(String str, Class<?>[] clsArr, boolean z) {
        NameSpace nameSpace;
        Interpreter.debug("Get method: ", str, " ", this);
        BshMethod importedMethod = (!this.isClass || this.isEnum || z) ? null : getImportedMethod(str, clsArr);
        if (importedMethod == null && this.methods.containsKey(str)) {
            importedMethod = Reflect.findMostSpecificBshMethod(clsArr, this.methods.get(str));
        }
        if (importedMethod == null && !this.isClass && !z) {
            importedMethod = getImportedMethod(str, clsArr);
        }
        return (importedMethod != null || z || (nameSpace = this.parent) == null) ? importedMethod : nameSpace.getMethod(str, clsArr);
    }

    public Object getVariable(String str, boolean z) {
        Variable variableImpl = getVariableImpl(str, z);
        Interpreter.debug("Get variable: ", str, " = ", variableImpl);
        return unwrapVariable(variableImpl);
    }

    public Object invokeCommand(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, Node node, boolean z) throws EvalError {
        String str2;
        CallStack callStack2;
        Node node2;
        Class<?>[] types = Types.getTypes(objArr);
        try {
            Object command = getCommand(str, types, interpreter);
            if (command != null) {
                if (command instanceof BshMethod) {
                    return ((BshMethod) command).invoke(objArr, interpreter, callStack, node);
                }
                try {
                    return Reflect.invokeCompiledCommand((Class) command, objArr, interpreter, callStack, node);
                } catch (UtilEvalError e) {
                    throw e.toEvalError("Error invoking compiled command: ", node, callStack);
                }
            }
            if (z) {
                str2 = str;
                callStack2 = callStack;
                node2 = node;
            } else {
                boolean[] zArr = new boolean[1];
                str2 = str;
                callStack2 = callStack;
                node2 = node;
                Object objInvokeDefaultInvokeMethod = invokeDefaultInvokeMethod(str2, objArr, interpreter, callStack2, node2, zArr);
                if (zArr[0]) {
                    return objInvokeDefaultInvokeMethod;
                }
            }
            throw new EvalException("Command not found: " + StringUtil.methodString(str2, types), node2, callStack2);
        } catch (UtilEvalError e2) {
            throw e2.toEvalError("Error loading command: ", node, callStack);
        }
    }

    public Object invokeMethod(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, Node node) {
        return getThis(interpreter).invokeMethod(str, objArr, interpreter, callStack, node, false);
    }

    public Variable setVariable(String str, Object obj, boolean z, boolean z2) throws UtilEvalError {
        if (obj == null) {
            obj = Primitive.NULL;
        }
        Variable variableImpl = getVariableImpl(str, z2);
        if (variableImpl != null) {
            variableImpl.setValue(obj, 1);
            return variableImpl;
        }
        if (z) {
            throw new UtilEvalError(yg.k("(Strict Java mode) Assignment to undeclared variable: ", str));
        }
        Variable variableCreateVariable = createVariable(str, obj, (Modifiers) null);
        this.variables.put(str, variableCreateVariable);
        nameSpaceChanged();
        return variableCreateVariable;
    }

    public void setVariableOrProperty(String str, Object obj, boolean z, boolean z2) throws UtilEvalError {
        if (obj == null) {
            throw new InterpreterError("null variable value");
        }
        Variable variableImpl = getVariableImpl(str, z2);
        if (variableImpl != null) {
            try {
                variableImpl.setValue(obj, 1);
                return;
            } catch (UtilEvalError e) {
                StringBuilder sbZ = dkz.z("Variable assignment: ", str, ": ");
                sbZ.append(e.getMessage());
                throw new UtilEvalError(sbZ.toString(), e);
            }
        }
        if (z) {
            throw new UtilEvalError(yg.k("(Strict Java mode) Assignment to undeclared variable: ", str));
        }
        This r4 = this.thisReference;
        if (attemptSetPropertyValue(str, obj, r4 != null ? r4.declaringInterpreter : null)) {
            return;
        }
        this.variables.put(str, createVariable(str, obj, (Modifiers) null));
        nameSpaceChanged();
    }

    public NameSpace(String str, BshClassManager bshClassManager) {
        this(null, bshClassManager, str);
    }

    public Variable createVariable(String str, Class<?> cls, LHS lhs) {
        return new Variable(str, cls, lhs);
    }

    public NameSpace(NameSpace nameSpace, BshClassManager bshClassManager, String str) {
        this.variables = new HashMap();
        this.methods = new HashMap();
        this.importedClasses = new HashMap();
        this.importedPackages = new ArrayList();
        this.importedCommands = new ArrayList();
        this.importedObjects = new ArrayList();
        this.importedStatic = new ArrayList();
        this.nameSourceListeners = new ArrayList();
        this.names = new HashMap();
        this.classCache = new HashMap();
        setName(str);
        setParent(nameSpace);
        setClassManager(bshClassManager);
        getClassManager().addListener(this);
    }

    public void setTypedVariable(String str, Class<?> cls, Object obj, Modifiers modifiers) {
        Variable variableImpl = getVariableImpl(str, false);
        if (variableImpl != null && variableImpl.getType() != null) {
            if (variableImpl.getType() == cls) {
                if (variableImpl.modifiers == null) {
                    variableImpl.modifiers = modifiers;
                }
                variableImpl.setValue(obj, 0);
                return;
            } else {
                StringBuilder sbZ = dkz.z("Typed variable: ", str, " was previously declared with type: ");
                sbZ.append(variableImpl.getType());
                throw new UtilEvalError(sbZ.toString());
            }
        }
        this.variables.put(str, createVariable(str, cls, obj, modifiers));
    }
}
