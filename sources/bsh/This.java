package bsh;

import bsh.ClassGenerator;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bqn;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.ol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class This implements Serializable, Runnable {
    transient Interpreter declaringInterpreter;
    private Map<Integer, Object> interfaces;
    private final InvocationHandler invocationHandler = new Handler();
    final NameSpace namespace;
    public static final Map<String, NameSpace> contextStore = new ConcurrentHashMap();
    private static final ThreadLocal<NameSpace> CONTEXT_NAMESPACE = new ThreadLocal<>();
    private static final ThreadLocal<Interpreter> CONTEXT_INTERPRETER = new ThreadLocal<>();
    static final ThreadLocal<Map<String, Object[]>> CONTEXT_ARGS = ThreadLocal.withInitial(new bqn(2));

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class Handler implements InvocationHandler, Serializable {
        public Handler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                return invokeImpl(obj, method, objArr);
            } catch (TargetError e) {
                System.err.println("TargetError in scripted interface: " + e);
                return null;
            } catch (EvalError e2) {
                System.err.println("EvalError in scripted interface: " + e2);
                return null;
            }
        }

        public Object invokeImpl(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            BshMethod method2 = Reflect.getMethod(This.this.namespace, "equals", (Class<?>[]) new Class[]{Object.class});
            if (name.equals("equals") && method2 == null) {
                return Boolean.valueOf(obj == objArr[0]);
            }
            BshMethod method3 = Reflect.getMethod(This.this.namespace, "toString", (Class<?>[]) new Class[0]);
            if (!name.equals("toString") || method3 != null) {
                return Primitive.unwrap(This.this.invokeMethod(name, Primitive.wrap(objArr, method.getParameterTypes())));
            }
            Class<?>[] interfaces = obj.getClass().getInterfaces();
            StringBuilder sb = new StringBuilder(This.this.toString() + "\nimplements:");
            for (Class<?> cls : interfaces) {
                StringBuilder sb2 = new StringBuilder(" ");
                sb2.append(cls.getName());
                sb2.append(interfaces.length > 1 ? "," : "");
                sb.append(sb2.toString());
            }
            return sb.toString();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Keys {
        public static final Keys BSHSTATIC = new AnonymousClass1();
        public static final Keys BSHTHIS = new AnonymousClass2();
        public static final Keys BSHSUPER = new AnonymousClass3();
        public static final Keys BSHINIT = new AnonymousClass4();
        public static final Keys BSHCONSTRUCTORS = new AnonymousClass5();
        public static final Keys BSHCLASSMODIFIERS = new AnonymousClass6();
        private static final /* synthetic */ Keys[] $VALUES = $values();

        /* JADX INFO: renamed from: bsh.This$Keys$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass1 extends Keys {
            public /* synthetic */ AnonymousClass1() {
                this("BSHSTATIC", 0);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshStatic";
            }

            private AnonymousClass1(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: bsh.This$Keys$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass2 extends Keys {
            public /* synthetic */ AnonymousClass2() {
                this("BSHTHIS", 1);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshThis";
            }

            private AnonymousClass2(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: bsh.This$Keys$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass3 extends Keys {
            public /* synthetic */ AnonymousClass3() {
                this("BSHSUPER", 2);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshSuper";
            }

            private AnonymousClass3(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: bsh.This$Keys$4, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass4 extends Keys {
            public /* synthetic */ AnonymousClass4() {
                this("BSHINIT", 3);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshInstanceInitializer";
            }

            private AnonymousClass4(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: bsh.This$Keys$5, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass5 extends Keys {
            public /* synthetic */ AnonymousClass5() {
                this("BSHCONSTRUCTORS", 4);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshConstructors";
            }

            private AnonymousClass5(String str, int i) {
                super(str, i, 0);
            }
        }

        /* JADX INFO: renamed from: bsh.This$Keys$6, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum AnonymousClass6 extends Keys {
            public /* synthetic */ AnonymousClass6() {
                this("BSHCLASSMODIFIERS", 5);
            }

            @Override // java.lang.Enum
            public String toString() {
                return "_bshClassModifiers";
            }

            private AnonymousClass6(String str, int i) {
                super(str, i, 0);
            }
        }

        private static /* synthetic */ Keys[] $values() {
            return new Keys[]{BSHSTATIC, BSHTHIS, BSHSUPER, BSHINIT, BSHCONSTRUCTORS, BSHCLASSMODIFIERS};
        }

        public /* synthetic */ Keys(String str, int i, int i2) {
            this(str, i);
        }

        public static Keys valueOf(String str) {
            return (Keys) Enum.valueOf(Keys.class, str);
        }

        public static Keys[] values() {
            return (Keys[]) $VALUES.clone();
        }

        private Keys(String str, int i) {
        }
    }

    public This(NameSpace nameSpace, Interpreter interpreter) {
        this.namespace = nameSpace;
        this.declaringInterpreter = interpreter;
    }

    public static void bind(This r1, NameSpace nameSpace, Interpreter interpreter) {
        r1.namespace.setParent(nameSpace);
        r1.declaringInterpreter = interpreter;
    }

    public static ConstructorArgs getConstructorArgs(Class<?> cls, This r17, Object[] objArr, int i) {
        if (r17 == null) {
            throw new InterpreterError("Unititialized class: no static");
        }
        if (i == -1) {
            return ConstructorArgs.DEFAULT;
        }
        try {
            Object variable = r17.getNameSpace().getVariable(Keys.BSHCONSTRUCTORS.toString());
            if (variable == Primitive.VOID) {
                throw new InterpreterError("Unable to find constructors array in class");
            }
            DelayedEvalBshMethod[] delayedEvalBshMethodArr = (DelayedEvalBshMethod[]) variable;
            DelayedEvalBshMethod delayedEvalBshMethod = delayedEvalBshMethodArr[i];
            String altConstructor = delayedEvalBshMethod.getAltConstructor();
            if (altConstructor == null) {
                return ConstructorArgs.DEFAULT;
            }
            BSHArguments argsNode = delayedEvalBshMethod.getArgsNode();
            NameSpace nameSpace = new NameSpace(r17.getNameSpace(), "consArgs");
            String[] parameterNames = delayedEvalBshMethod.getParameterNames();
            Class<?>[] parameterTypes = delayedEvalBshMethod.getParameterTypes();
            for (int i2 = 0; i2 < objArr.length; i2++) {
                try {
                    nameSpace.setTypedVariable(parameterNames[i2], parameterTypes[i2], objArr[i2], (Modifiers) null);
                } catch (UtilEvalError e) {
                    throw new InterpreterError("err setting local cons arg:" + e, e);
                }
            }
            CallStack callStack = new CallStack();
            callStack.push(nameSpace);
            Object[] constructorArgs = delayedEvalBshMethod.getConstructorArgs();
            Interpreter interpreter = r17.declaringInterpreter;
            if (argsNode != null) {
                try {
                    constructorArgs = argsNode.getArguments(callStack, interpreter);
                } catch (EvalError e2) {
                    throw new InterpreterError("Error evaluating constructor args: " + e2, e2);
                }
            }
            Class<?>[] types = Types.getTypes(constructorArgs);
            Object[] objArrUnwrap = Primitive.unwrap(constructorArgs);
            if (altConstructor.equals("super")) {
                int iFindMemberIndex = BshClassManager.memberCache.get(cls).findMemberIndex(cls.getName(), types);
                if (iFindMemberIndex != -1) {
                    return new ConstructorArgs(iFindMemberIndex, objArrUnwrap);
                }
                throw new InterpreterError("can't find super constructor for args!");
            }
            int iFindMostSpecificBshMethodIndex = Reflect.findMostSpecificBshMethodIndex(types, Arrays.asList(delayedEvalBshMethodArr));
            if (iFindMostSpecificBshMethodIndex == -1) {
                throw new InterpreterError("can't find this constructor for args!");
            }
            int iMemberCount = BshClassManager.memberCache.get(cls).memberCount(cls.getName());
            int i3 = iFindMostSpecificBshMethodIndex + iMemberCount;
            if (i3 != iMemberCount + i) {
                return new ConstructorArgs(i3, objArrUnwrap);
            }
            throw new InterpreterError("Recursive constructor call.");
        } catch (Exception e3) {
            throw new InterpreterError("Unable to get instance initializers: " + e3, e3);
        }
    }

    public static This getThis(NameSpace nameSpace, Interpreter interpreter) {
        return new This(nameSpace, interpreter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static This initClassInstanceThis(Object obj, String str) {
        This classInstanceThis = Reflect.getClassInstanceThis(obj, str);
        if (classInstanceThis != null) {
            return classInstanceThis;
        }
        This classStaticThis = Reflect.getClassStaticThis(obj.getClass(), str);
        NameSpace nameSpaceCopy = classStaticThis.getNameSpace().copy();
        ThreadLocal<NameSpace> threadLocal = CONTEXT_NAMESPACE;
        if (threadLocal.get() != null) {
            nameSpaceCopy.setParent(threadLocal.get());
        }
        ThreadLocal<Interpreter> threadLocal2 = CONTEXT_INTERPRETER;
        This r2 = threadLocal2.get() != null ? nameSpaceCopy.getThis(threadLocal2.get()) : nameSpaceCopy.getThis(classStaticThis.declaringInterpreter);
        try {
            Reflect.getLHSObjectField(obj, Keys.BSHTHIS + str).assign(r2, false);
            nameSpaceCopy.setClassInstance(obj);
            try {
                BSHBlock bSHBlock = (BSHBlock) classStaticThis.getNameSpace().getVariable(Keys.BSHINIT.toString());
                try {
                    CallStack callStack = new CallStack(nameSpaceCopy);
                    Interpreter interpreter = r2.declaringInterpreter;
                    Boolean bool = Boolean.TRUE;
                    bSHBlock.evalBlock(callStack, interpreter, bool, ClassGenerator.ClassNodeFilter.CLASSINSTANCEMETHODS);
                    bSHBlock.evalBlock(new CallStack(nameSpaceCopy), r2.declaringInterpreter, bool, ClassGenerator.ClassNodeFilter.CLASSINSTANCEFIELDS);
                    return r2;
                } catch (Exception e) {
                    throw new InterpreterError("Error in class instance This initialization: " + e, e);
                }
            } catch (Exception e2) {
                throw new InterpreterError("unable to get instance initializer: " + e2, e2);
            }
        } catch (Exception e3) {
            throw new InterpreterError("Error in class gen setup: " + e3, e3);
        }
    }

    public static void initInstance(GeneratedClass generatedClass, String str, Object[] objArr) {
        try {
            This thisInitClassInstanceThis = initClassInstanceThis(generatedClass, str);
            NameSpace nameSpace = thisInitClassInstanceThis.getNameSpace();
            ArrayList arrayList = new ArrayList();
            for (Class<?> superclass = generatedClass.getClass(); superclass != null && !superclass.getSimpleName().equals(str); superclass = superclass.getSuperclass()) {
                arrayList.add(0, superclass.getSimpleName());
            }
            arrayList.forEach(new ol(generatedClass, 4));
            if (nameSpace.isEnum) {
                ThreadLocal<Map<String, Object[]>> threadLocal = CONTEXT_ARGS;
                if (threadLocal.get().containsKey(generatedClass.toString())) {
                    objArr = threadLocal.get().remove(generatedClass.toString());
                }
            }
            BshMethod method = nameSpace.getMethod(Types.getBaseName(str), Types.getTypes(objArr), true);
            if (objArr.length > 0 && method == null) {
                throw new InterpreterError("Can't find constructor: " + StringUtil.methodString(str, objArr));
            }
            if (method != null) {
                method.invoke(objArr, thisInitClassInstanceThis.declaringInterpreter);
            }
            for (Variable variable : Reflect.getVariables(generatedClass)) {
                variable.validateFinalIsSet(false);
            }
        } catch (Exception e) {
            e = e;
            if (e instanceof TargetError) {
                e = (Exception) ((TargetError) e).getTarget();
            }
            if (e instanceof InvocationTargetException) {
                e = (Exception) e.getCause();
            }
            throw new InterpreterError("Error in class instance initialization: " + e, e);
        }
    }

    public static void initStatic(Class<?> cls) throws UtilEvalError {
        String simpleName = cls.getSimpleName();
        try {
            This classStaticThis = Reflect.getClassStaticThis(cls, simpleName);
            NameSpace nameSpace = classStaticThis.getNameSpace();
            Interpreter interpreter = classStaticThis.declaringInterpreter;
            if (interpreter == null) {
                throw new UtilEvalError("No namespace or interpreter for statitc This. Start interpreter for class not implemented yet.");
            }
            BSHBlock bSHBlock = (BSHBlock) nameSpace.getVariable(Keys.BSHINIT.toString());
            CallStack callStack = new CallStack(nameSpace);
            Boolean bool = Boolean.TRUE;
            bSHBlock.evalBlock(callStack, interpreter, bool, ClassGenerator.ClassNodeFilter.CLASSSTATICMETHODS);
            bSHBlock.evalBlock(callStack, interpreter, bool, ClassGenerator.ClassNodeFilter.CLASSSTATICFIELDS);
            for (Variable variable : Reflect.getVariables(nameSpace)) {
                variable.validateFinalIsSet(true);
            }
        } catch (Exception e) {
            StringBuilder sbZ = dkz.z("Exception in static init block <clinit> for class ", simpleName, ". With message: ");
            sbZ.append(e.getMessage());
            throw new UtilEvalError(sbZ.toString(), e);
        }
    }

    public static boolean isExposedThisMethod(String str) {
        return str.equals("invokeMethod") || str.equals("getInterface") || str.equals("wait") || str.equals("notify") || str.equals("notifyAll");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map lambda$static$1() {
        return new HashMap();
    }

    public static This pullBshStatic(String str) {
        Map<String, NameSpace> map = contextStore;
        return map.containsKey(str) ? map.remove(str).getThis(null) : getThis(null, null);
    }

    public static void registerConstructorContext(CallStack callStack, Interpreter interpreter) {
        if (callStack != null) {
            CONTEXT_NAMESPACE.set(callStack.top());
        } else {
            CONTEXT_NAMESPACE.remove();
        }
        if (interpreter != null) {
            CONTEXT_INTERPRETER.set(interpreter);
        } else {
            CONTEXT_INTERPRETER.remove();
        }
    }

    public Object cloneMethodImpl(Node node, CallStack callStack) {
        return cloneMethodImpl(node, callStack, null);
    }

    public Object[] enumValues() {
        return Reflect.getEnumConstants(getNameSpace().classStatic);
    }

    public Object getInterface(Class<?> cls) {
        return getInterface(new Class[]{cls});
    }

    public NameSpace getNameSpace() {
        return this.namespace;
    }

    public Object invokeMethod(String str, Object[] objArr) {
        return invokeMethod(str, objArr, null, null, null, false);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            invokeMethod("run", Reflect.ZERO_ARGS);
        } catch (EvalError e) {
            this.declaringInterpreter.error("Exception in runnable:" + e);
        }
    }

    public String toString() {
        BshMethod method = Reflect.getMethod(this.namespace, "toString", (Class<?>[]) new Class[0]);
        if (method != null) {
            try {
                return (String) method.invoke(new Object[0], this.declaringInterpreter);
            } catch (EvalError unused) {
            }
        }
        return "'this' reference to Bsh object: " + this.namespace;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class ConstructorArgs {
        public static final ConstructorArgs DEFAULT = new ConstructorArgs();
        int arg;
        Object[] args;
        public int selector;

        public ConstructorArgs() {
            this.selector = -1;
        }

        public boolean getBoolean() {
            return ((Boolean) next()).booleanValue();
        }

        public byte getByte() {
            return ((Number) next()).byteValue();
        }

        public char getChar() {
            return ((Character) next()).charValue();
        }

        public double getDouble() {
            return ((Number) next()).doubleValue();
        }

        public float getFloat() {
            return ((Number) next()).floatValue();
        }

        public int getInt() {
            return ((Number) next()).intValue();
        }

        public long getLong() {
            return ((Number) next()).longValue();
        }

        public Object getObject() {
            return next();
        }

        public short getShort() {
            return ((Number) next()).shortValue();
        }

        public Object next() {
            Object[] objArr = this.args;
            int i = this.arg;
            this.arg = i + 1;
            return objArr[i];
        }

        public ConstructorArgs(int i, Object[] objArr) {
            this.selector = i;
            this.args = objArr;
        }
    }

    public Object cloneMethodImpl(Node node, CallStack callStack, Object obj) throws EvalError {
        NameSpace nameSpace = new NameSpace(this.namespace.getParent(), this.namespace.getName() + " clone");
        if (obj == null) {
            try {
                Class<?> cls = this.namespace.classStatic;
                if (cls == null) {
                    return nameSpace.getThis(this.declaringInterpreter);
                }
                obj = cls.getConstructor(null).newInstance(null);
            } catch (UtilEvalError e) {
                throw e.toEvalError("Unable to assign clone instance This: " + e.getMessage(), node, callStack);
            } catch (IllegalAccessException e2) {
                e = e2;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            } catch (InstantiationException e4) {
                e = e4;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            } catch (NoSuchMethodException e5) {
                e = e5;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            } catch (SecurityException e6) {
                e = e6;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            } catch (InvocationTargetException e7) {
                e = e7;
                throw new EvalError("Unable to clone from This reference: " + e.getMessage(), node, callStack);
            }
        }
        nameSpace.setClassInstance(obj);
        nameSpace.setClassStatic(this.namespace.classStatic);
        nameSpace.isClass = true;
        nameSpace.isMethod = true;
        for (Variable variable : this.namespace.getVariables()) {
            nameSpace.setVariableImpl(variable);
        }
        NameSpace nameSpace2 = new NameSpace(nameSpace, (String) null);
        nameSpace2.setClassInstance(obj);
        nameSpace2.setClassStatic(nameSpace.classStatic);
        nameSpace2.isClass = true;
        nameSpace2.isMethod = true;
        for (BshMethod bshMethod : this.namespace.getMethods()) {
            BshMethod bshMethodClone = bshMethod.m1clone();
            bshMethodClone.declaringNameSpace = nameSpace2;
            nameSpace.setMethod(bshMethodClone);
        }
        Reflect.getLHSObjectField(obj, Keys.BSHTHIS + nameSpace.classStatic.getSimpleName()).assign(nameSpace.getThis(this.declaringInterpreter));
        return obj;
    }

    public Object getInterface(Class<?>[] clsArr) {
        if (this.interfaces == null) {
            this.interfaces = new HashMap();
        }
        int iD = 21;
        for (Class<?> cls : clsArr) {
            iD = bjs.d(3, iD, cls);
        }
        Integer numValueOf = Integer.valueOf(iD);
        Object obj = this.interfaces.get(numValueOf);
        if (obj != null) {
            return obj;
        }
        Object objNewProxyInstance = Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, this.invocationHandler);
        this.interfaces.put(numValueOf, objNewProxyInstance);
        return objNewProxyInstance;
    }

    public Object invokeMethod(String str, Object[] objArr, boolean z) throws EvalException {
        CallStack callStack = new CallStack(this.namespace);
        Node node = this.namespace.getNode();
        this.namespace.setNode(null);
        try {
            Object objInvokeMethod = invokeMethod(str, objArr, this.declaringInterpreter, callStack, node, z);
            return (!(objInvokeMethod instanceof Primitive) || objInvokeMethod == Primitive.VOID) ? objInvokeMethod : ((Primitive) objInvokeMethod).getValue();
        } catch (Exception e) {
            throw new EvalException(e.getMessage(), node, callStack, e);
        }
    }

    public Object invokeMethod(String str, Object[] objArr, Interpreter interpreter, CallStack callStack, Node node, boolean z) throws EvalException {
        if (objArr == null) {
            objArr = Reflect.ZERO_ARGS;
        }
        Object[] objArr2 = objArr;
        if (interpreter == null) {
            interpreter = this.declaringInterpreter;
        }
        Interpreter interpreter2 = interpreter;
        if (interpreter2.getNameSpace() == null) {
            interpreter2.setNameSpace(this.namespace);
        }
        if (callStack == null) {
            callStack = new CallStack(this.namespace);
        }
        CallStack callStack2 = callStack;
        if (node == null) {
            node = Node.JAVACODE;
        }
        Node node2 = node;
        Class<?>[] types = Types.getTypes(objArr2);
        BshMethod method = Reflect.getMethod(this.namespace, str, types, z);
        if (method != null) {
            return method.invoke(objArr2, interpreter2, callStack2, node2);
        }
        if (str.equals("getClass") && objArr2.length == 0) {
            return This.class;
        }
        if (str.equals("toString") && objArr2.length == 0) {
            return toString();
        }
        if (str.equals("hashCode") && objArr2.length == 0) {
            return Integer.valueOf(hashCode());
        }
        if (str.equals("equals") && objArr2.length == 1) {
            return this == objArr2[0] ? Boolean.TRUE : Boolean.FALSE;
        }
        if (str.equals("clone") && objArr2.length == 0) {
            return cloneMethodImpl(node2, callStack2);
        }
        boolean[] zArr = new boolean[1];
        Object objInvokeDefaultInvokeMethod = this.namespace.invokeDefaultInvokeMethod(str, objArr2, interpreter2, callStack2, node2, zArr);
        if (zArr[0]) {
            return objInvokeDefaultInvokeMethod;
        }
        try {
            return this.namespace.invokeCommand(str, objArr2, interpreter2, callStack2, node2, true);
        } catch (EvalError e) {
            throw new EvalException("Method " + StringUtil.methodString(str, types) + " not found in bsh scripted object: " + this.namespace.getName(), node2, callStack2, e);
        }
    }
}
