package bsh;

import bsh.BshClassManager;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.IntStream;
import me.hd.wauxv.obf.ky;
import me.hd.wauxv.obf.ra;
import me.hd.wauxv.obf.rb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshMethod implements Serializable, Cloneable, BshClassManager.Listener {
    private static final long serialVersionUID = 1;
    private Class<?>[] cparamTypes;
    private Class<?> creturnType;
    NameSpace declaringNameSpace;
    boolean isScriptedObject;
    protected boolean isVarArgs;
    private Invocable javaMethod;
    private Object javaObject;
    protected BSHBlock methodBody;
    Modifiers modifiers;
    private String name;
    private int paramCount;
    private Modifiers[] paramModifiers;
    private String[] paramNames;
    private boolean reload;

    /* JADX WARN: Illegal instructions before constructor call */
    public BshMethod(BSHMethodDeclaration bSHMethodDeclaration, NameSpace nameSpace, Modifiers modifiers, boolean z) {
        String str = bSHMethodDeclaration.name;
        Class<?> cls = bSHMethodDeclaration.returnType;
        String[] paramNames = bSHMethodDeclaration.paramsNode.getParamNames();
        BSHFormalParameters bSHFormalParameters = bSHMethodDeclaration.paramsNode;
        this(str, cls, paramNames, bSHFormalParameters.paramTypes, bSHFormalParameters.getParamModifiers(), bSHMethodDeclaration.blockNode, nameSpace, modifiers, bSHMethodDeclaration.isVarArgs);
        this.isScriptedObject = z;
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX WARN: Found duplicated region for block: B:32:0x0097  */
    private Object invokeImpl(Object[] objArr, Interpreter interpreter, CallStack callStack, Node node, boolean z) throws EvalError {
        NameSpace nameSpace;
        Object objNewInstance;
        ReturnControl returnControl;
        This classInstanceThis;
        Object obj;
        CallStack callStack2 = callStack;
        Node node2 = node;
        if (hasModifier("abstract")) {
            throw new EvalError("Cannot invoke abstract method " + this.name, node2, callStack2);
        }
        Class<?> returnType = getReturnType();
        Class<?>[] parameterTypes = getParameterTypes();
        if (callStack2 == null) {
            callStack2 = new CallStack(this.declaringNameSpace);
        }
        CallStack callStack3 = callStack2;
        Object[] objArr2 = objArr == null ? Reflect.ZERO_ARGS : objArr;
        if (!isVarArgs() && objArr2.length != getParameterCount()) {
            throw new EvalError("Wrong number of arguments for local method: " + this.name, node2, callStack3);
        }
        int i = 1;
        if (z) {
            nameSpace = callStack3.top();
        } else {
            nameSpace = new NameSpace(this.declaringNameSpace, this.name);
            nameSpace.isMethod = true;
        }
        nameSpace.setNode(node2);
        int parameterCount = getParameterCount() - 1;
        if (isVarArgs()) {
            objNewInstance = (!(getParameterCount() == objArr2.length && ((obj = objArr2[parameterCount]) == null || (obj.getClass().isArray() && parameterTypes[parameterCount].getComponentType().isAssignableFrom(objArr2[parameterCount].getClass().getComponentType())))) && objArr2.length >= getParameterCount() - 1) ? Array.newInstance(parameterTypes[parameterCount].getComponentType(), objArr2.length - parameterCount) : null;
        }
        int i2 = 0;
        while (i2 < objArr2.length) {
            int i3 = i2 >= parameterCount ? parameterCount : i2;
            Class<?> componentType = (objNewInstance == null || i3 != parameterCount) ? parameterTypes[i3] : parameterTypes[i3].getComponentType();
            if (componentType != null) {
                try {
                    Object objCastObject = Types.castObject(objArr2[i2], componentType, i);
                    objArr2[i2] = objCastObject;
                    if (objNewInstance == null || i2 < parameterCount) {
                        nameSpace.setTypedVariable(this.paramNames[i3], componentType, objCastObject, this.paramModifiers[i3]);
                    } else {
                        try {
                            Array.set(objNewInstance, i2 - i3, Primitive.unwrap(objCastObject));
                        } catch (UtilEvalError e) {
                            throw e.toEvalError("Typed method parameter assignment", node2, callStack3);
                        }
                    }
                } catch (UtilEvalError e2) {
                    throw new EvalError("Invalid argument: `" + this.paramNames[i3] + "' for method: " + this.name + " : " + e2.getMessage(), node2, callStack3);
                }
            } else {
                Object obj2 = objArr2[i2];
                if (obj2 == Primitive.VOID) {
                    throw new EvalError("Undefined variable or class name, parameter: " + this.paramNames[i3] + " to method: " + this.name, node2, callStack3);
                }
                try {
                    nameSpace.setLocalVariable(this.paramNames[i3], obj2, interpreter.getStrictJava());
                } catch (UtilEvalError e3) {
                    throw e3.toEvalError("Typed method parameter assignment", node2, callStack3);
                }
            }
            i2++;
            i = 1;
        }
        if (objNewInstance != null) {
            try {
                nameSpace.setTypedVariable(this.paramNames[parameterCount], parameterTypes[parameterCount], objNewInstance, this.paramModifiers[parameterCount]);
            } catch (UtilEvalError e4) {
                throw e4.toEvalError("Typed method parameter assignment", node2, callStack3);
            }
        }
        if (!z) {
            callStack3.push(nameSpace);
        }
        try {
            Object objEval = this.methodBody.eval(callStack3, interpreter, Boolean.TRUE);
            CallStack callStackCopy = callStack3.copy();
            if (!z) {
                callStack3.pop();
            }
            boolean z2 = objEval instanceof ReturnControl;
            Class<?> cls = Void.TYPE;
            if (z2) {
                returnControl = (ReturnControl) objEval;
                if (returnControl.kind != 47) {
                    throw new EvalException("'continue' or 'break' in method body", returnControl.returnPoint, callStackCopy);
                }
                objEval = returnControl.value;
                if (returnType == cls && objEval != Primitive.VOID) {
                    throw new EvalException("Cannot return value from void method", returnControl.returnPoint, callStackCopy);
                }
            } else {
                returnControl = null;
            }
            if (returnType != null) {
                if (returnType == cls) {
                    return Primitive.VOID;
                }
                try {
                    objEval = Types.castObject(objEval, returnType, 1);
                } catch (UtilEvalError e5) {
                    if (returnControl != null) {
                        node2 = returnControl.returnPoint;
                    }
                    throw e5.toEvalError("Incorrect type returned from method: " + this.name + e5.getMessage(), node2, callStack3);
                }
            }
            return (!"clone".equals(getName()) || (classInstanceThis = Reflect.getClassInstanceThis(objEval, objEval.getClass().getSimpleName())) == null) ? objEval : classInstanceThis.cloneMethodImpl(node2, callStack3, objEval);
        } catch (Throwable th) {
            if (!z) {
                callStack3.pop();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getParameterNames$0(Integer num) {
        return String.valueOf((char) num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getParameterNames$1(int i) {
        return new String[i];
    }

    private void reloadTypes() {
        if (!this.reload) {
            return;
        }
        int i = 0;
        try {
            this.reload = false;
            if (Reflect.isGeneratedClass(this.creturnType)) {
                this.creturnType = this.declaringNameSpace.getClass(this.creturnType.getName());
            }
            while (true) {
                Class<?>[] clsArr = this.cparamTypes;
                if (i >= clsArr.length) {
                    return;
                }
                if (Reflect.isGeneratedClass(clsArr[i])) {
                    Class<?>[] clsArr2 = this.cparamTypes;
                    clsArr2[i] = this.declaringNameSpace.getClass(clsArr2[i].getName());
                }
                i++;
            }
        } catch (UtilEvalError unused) {
        }
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        this.reload = Reflect.isGeneratedClass(this.creturnType) || Arrays.asList(this.cparamTypes).stream().anyMatch(new ra(2));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        BshMethod bshMethod = (BshMethod) obj;
        if (!this.name.equals(bshMethod.name) || getParameterCount() != bshMethod.getParameterCount()) {
            return false;
        }
        for (int i = 0; i < getParameterCount(); i++) {
            if (!equal(getParameterTypes()[i], bshMethod.getParameterTypes()[i])) {
                return false;
            }
        }
        return true;
    }

    public Modifiers getModifiers() {
        if (this.modifiers == null) {
            this.modifiers = new Modifiers(2);
        }
        return this.modifiers;
    }

    public String getName() {
        Invocable invocable = this.javaMethod;
        return invocable == null ? this.name : invocable.getName();
    }

    public int getParameterCount() {
        Invocable invocable = this.javaMethod;
        return invocable == null ? this.paramCount : invocable.getParameterCount();
    }

    public Modifiers[] getParameterModifiers() {
        if (this.paramModifiers == null) {
            this.paramModifiers = new Modifiers[getParameterCount()];
        }
        return this.paramModifiers;
    }

    public String[] getParameterNames() {
        if (this.paramNames == null) {
            this.paramNames = (String[]) IntStream.range(97, getParameterCount() + 97).boxed().map(new ky(3)).toArray(new rb(2));
        }
        return this.paramNames;
    }

    public Class<?>[] getParameterTypes() {
        Invocable invocable = this.javaMethod;
        if (invocable != null) {
            return invocable.getParameterTypes();
        }
        reloadTypes();
        return this.cparamTypes;
    }

    public Class<?> getReturnType() {
        Invocable invocable = this.javaMethod;
        if (invocable != null) {
            return invocable.getReturnType();
        }
        reloadTypes();
        return this.creturnType;
    }

    public boolean hasModifier(String str) {
        Invocable invocable = this.javaMethod;
        if (invocable != null) {
            return Reflect.hasModifier(str, invocable.getModifiers());
        }
        Modifiers modifiers = this.modifiers;
        return modifiers != null && modifiers.hasModifier(str);
    }

    public int hashCode() {
        int iHashCode = getClass().hashCode() + this.name.hashCode();
        Class<?>[] parameterTypes = getParameterTypes();
        int length = parameterTypes.length;
        for (int i = 0; i < length; i++) {
            Class<?> cls = parameterTypes[i];
            iHashCode += (cls == null ? 0 : cls.hashCode()) + 3;
        }
        return getParameterCount() + iHashCode;
    }

    public Object invoke(Object[] objArr, Interpreter interpreter) {
        return invoke(objArr, interpreter, null, null, false);
    }

    public boolean isVarArgs() {
        Invocable invocable = this.javaMethod;
        return invocable == null ? this.isVarArgs : invocable.isVarArgs();
    }

    public String toString() {
        return "Method: " + StringUtil.methodString(this);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BshMethod m1clone() {
        try {
            return (BshMethod) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object invoke(Object[] objArr, Interpreter interpreter, CallStack callStack, Node node) {
        return invoke(objArr, interpreter, callStack, node, false);
    }

    public Object invoke(Object[] objArr, Interpreter interpreter, CallStack callStack, Node node, boolean z) throws EvalError {
        Object classInstance;
        Object objInvokeImpl;
        Interpreter.debug("Bsh method invoke: ", this.name, " overrideNameSpace: ", Boolean.valueOf(z));
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new Error("HERE!");
                }
            }
        }
        Invocable invocable = this.javaMethod;
        if (invocable != null) {
            try {
                if (Reflect.isStatic(invocable)) {
                    Interpreter.mainSecurityGuard.canInvokeStaticMethod(this.javaMethod.getDeclaringClass(), this.javaMethod.getName(), objArr);
                } else {
                    Interpreter.mainSecurityGuard.canInvokeMethod(this.javaObject, this.javaMethod.getName(), objArr);
                }
                return this.javaMethod.invoke(this.javaObject, objArr);
            } catch (ReflectError e) {
                throw new EvalError("Error invoking Java method: " + e, node, callStack);
            } catch (UtilEvalError e2) {
                throw e2.toEvalError(node, callStack);
            } catch (InvocationTargetException e3) {
                throw new TargetError("Exception invoking imported object method.", e3, node, callStack, true);
            }
        }
        Modifiers modifiers = this.modifiers;
        if (modifiers != null && modifiers.hasModifier("synchronized")) {
            NameSpace nameSpace = this.declaringNameSpace;
            if (nameSpace.isClass) {
                try {
                    classInstance = nameSpace.getClassInstance();
                } catch (UtilEvalError unused) {
                    throw new InterpreterError("Can't get class instance for synchronized method.");
                }
            } else {
                classInstance = nameSpace.getThis(interpreter);
            }
            synchronized (classInstance) {
                objInvokeImpl = invokeImpl(objArr, interpreter, callStack, node, z);
            }
            return objInvokeImpl;
        }
        return invokeImpl(objArr, interpreter, callStack, node, z);
    }

    public BshMethod(String str, Class<?> cls, String[] strArr, Class<?>[] clsArr, Modifiers[] modifiersArr, BSHBlock bSHBlock, NameSpace nameSpace, Modifiers modifiers, boolean z) {
        this.isScriptedObject = false;
        this.reload = false;
        this.name = str;
        this.creturnType = cls;
        this.paramNames = strArr;
        this.paramModifiers = modifiersArr;
        if (strArr != null) {
            this.paramCount = strArr.length;
        }
        this.cparamTypes = clsArr;
        this.methodBody = bSHBlock;
        this.declaringNameSpace = nameSpace;
        this.modifiers = modifiers;
        this.isVarArgs = z;
    }

    public BshMethod(Method method, Object obj) {
        this(Invocable.get(method), obj);
    }

    public BshMethod(Invocable invocable, Object obj) {
        this(invocable.getName(), invocable.getReturnType(), null, invocable.getParameterTypes(), null, null, null, null, invocable.isVarArgs());
        this.javaMethod = invocable;
        this.javaObject = obj;
    }
}
