package bsh;

import bsh.ClassGenerator;
import bsh.security.SecurityError;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CompletionException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHAllocationExpression extends SimpleNode {
    private static int innerClassCount;

    public BSHAllocationExpression(int i) {
        super(i);
    }

    private Object arrayAllocation(BSHArrayDimensions bSHArrayDimensions, Class<?> cls, CallStack callStack, Interpreter interpreter) {
        Object objEval = bSHArrayDimensions.eval(cls, callStack, interpreter);
        return objEval != Primitive.VOID ? objEval : arrayNewInstance(cls, bSHArrayDimensions, callStack, interpreter);
    }

    private Object arrayNewInstance(Class<?> cls, BSHArrayDimensions bSHArrayDimensions, CallStack callStack, Interpreter interpreter) throws TargetError, EvalException {
        int i = bSHArrayDimensions.numUndefinedDims;
        if (i > 0) {
            cls = Array.newInstance(cls, new int[i]).getClass();
        }
        try {
            return Array.newInstance(cls, bSHArrayDimensions.definedDimensions);
        } catch (NegativeArraySizeException e) {
            throw new TargetError(e, this, callStack);
        } catch (Exception e2) {
            throw new EvalException("Can't construct primitive array: " + e2.getMessage(), this, callStack, e2);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:40:0x00c2  */
    /* JADX WARN: Found duplicated region for block: B:46:? A[SYNTHETIC] */
    private Object constructObject(Class<?> cls, Object[] objArr, CallStack callStack, Interpreter interpreter) throws Throwable {
        Throwable th;
        boolean zIsGeneratedClass = Reflect.isGeneratedClass(cls);
        if (zIsGeneratedClass) {
            This.registerConstructorContext(callStack, interpreter);
        }
        try {
            try {
                Object objConstructObject = Reflect.constructObject(cls, objArr);
                if (zIsGeneratedClass) {
                    This.registerConstructorContext(null, null);
                }
                if (cls.getName().indexOf("$") != -1) {
                    NameSpace nameSpace = callStack.top().getThis(null).getNameSpace();
                    if (Name.getClassNameSpace(nameSpace) != null && !Reflect.getClassModifiers(objConstructObject.getClass()).hasModifier("static")) {
                        Reflect.getThisNS(objConstructObject).setParent(nameSpace);
                        return objConstructObject;
                    }
                    if (Reflect.getClassModifiers(objConstructObject.getClass()).hasModifier("static")) {
                        Reflect.getThisNS(objConstructObject).setParent(Reflect.getThisNS(objConstructObject.getClass()).getParent());
                    }
                }
                return objConstructObject;
            } catch (Throwable th2) {
                th = th2;
                th = th;
                if (!zIsGeneratedClass) {
                    throw th;
                }
                This.registerConstructorContext(null, null);
                throw th;
            }
        } catch (ReflectError e) {
            throw new EvalException("Constructor error: " + e.getMessage(), this, callStack, e);
        } catch (InvocationTargetException e2) {
            e = e2;
            Throwable th3 = e;
            try {
                Interpreter.debug("The constructor threw an exception:\n\t" + th3.getCause());
                throw new TargetError("Object constructor", th3.getCause(), this, callStack, true);
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (!zIsGeneratedClass) {
                    throw th;
                }
                This.registerConstructorContext(null, null);
                throw th;
            }
        } catch (CompletionException e3) {
            e = e3;
            Throwable th32 = e;
            Interpreter.debug("The constructor threw an exception:\n\t" + th32.getCause());
            throw new TargetError("Object constructor", th32.getCause(), this, callStack, true);
        } catch (Throwable th5) {
            th = th5;
            if (!zIsGeneratedClass) {
                throw th;
            }
            This.registerConstructorContext(null, null);
            throw th;
        }
    }

    private Object constructWithClassBody(Class<?> cls, Object[] objArr, BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter) throws EvalException {
        StringBuilder sb = new StringBuilder("anon");
        int i = innerClassCount + 1;
        innerClassCount = i;
        sb.append(i);
        String string = sb.toString();
        String str = callStack.top().getName().replace('/', '_') + "$" + string;
        This.CONTEXT_ARGS.get().put(string, objArr);
        try {
            return Reflect.constructObject(ClassGenerator.getClassGenerator().generateClass(str, new Modifiers(0), null, cls, bSHBlock, ClassGenerator.Type.CLASS, callStack, interpreter), objArr);
        } catch (Exception e) {
            throw new EvalException("Error constructing inner class instance: " + e, this, callStack, e instanceof InvocationTargetException ? e.getCause() : e);
        }
    }

    private Object constructWithInterfaceBody(Class<?> cls, Object[] objArr, BSHBlock bSHBlock, CallStack callStack, Interpreter interpreter) {
        NameSpace nameSpace = new NameSpace(callStack.top(), "AnonymousBlock");
        callStack.push(nameSpace);
        try {
            bSHBlock.eval(callStack, interpreter, Boolean.TRUE);
            callStack.pop();
            nameSpace.importStatic(cls);
            return nameSpace.getThis(interpreter).getInterface(cls);
        } catch (Throwable th) {
            callStack.pop();
            throw th;
        }
    }

    private Object objectAllocation(BSHAmbiguousName bSHAmbiguousName, BSHArguments bSHArguments, CallStack callStack, Interpreter interpreter) throws EvalError {
        Object[] arguments = bSHArguments.getArguments(callStack, interpreter);
        if (arguments == null) {
            throw new EvalError("Null args in new.", this, callStack);
        }
        Object object = bSHAmbiguousName.toObject(callStack, interpreter, true);
        if (!(object instanceof ClassIdentifier)) {
            throw new EvalException("Unknown class: " + bSHAmbiguousName.text, this, callStack);
        }
        Class<?> targetClass = ((ClassIdentifier) object).getTargetClass();
        boolean z = jjtGetNumChildren() > 2;
        try {
            Interpreter.mainSecurityGuard.canConstruct(targetClass, arguments);
            if (!z) {
                return constructObject(targetClass, arguments, callStack, interpreter);
            }
            BSHBlock bSHBlock = (BSHBlock) jjtGetChild(2);
            return targetClass.isInterface() ? constructWithInterfaceBody(targetClass, arguments, bSHBlock, callStack, interpreter) : constructWithClassBody(targetClass, arguments, bSHBlock, callStack, interpreter);
        } catch (SecurityError e) {
            throw e.toEvalError(this, callStack);
        }
    }

    private Object objectArrayAllocation(BSHAmbiguousName bSHAmbiguousName, BSHArrayDimensions bSHArrayDimensions, CallStack callStack, Interpreter interpreter) {
        return arrayAllocation(bSHArrayDimensions, bSHAmbiguousName.toClass(callStack, interpreter), callStack, interpreter);
    }

    private Object primitiveArrayAllocation(BSHPrimitiveType bSHPrimitiveType, BSHArrayDimensions bSHArrayDimensions, CallStack callStack, Interpreter interpreter) {
        return arrayAllocation(bSHArrayDimensions, bSHPrimitiveType.getType(), callStack, interpreter);
    }

    public Object constructFromEnclosingInstance(Object obj, CallStack callStack, Interpreter interpreter) throws TargetError {
        String str = jjtGetChild(0) instanceof BSHAmbiguousName ? ((BSHAmbiguousName) jjtGetChild(0)).text : "";
        Class<?> cls = null;
        Object[] arguments = jjtGetChild(1) instanceof BSHArguments ? ((BSHArguments) jjtGetChild(1)).getArguments(callStack, interpreter) : null;
        for (Class<?> cls2 : obj.getClass().getDeclaredClasses()) {
            if (Types.getBaseName(cls2.getName()).equals(str)) {
                cls = cls2;
                break;
            }
        }
        try {
            return Reflect.constructObject(cls, obj, arguments);
        } catch (InvocationTargetException e) {
            throw new TargetError("Object constructor", e.getCause(), this, callStack, true);
        }
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        if (jjtGetNumChildren() == 1 && (jjtGetChild(0) instanceof BSHArrayDimensions)) {
            return arrayAllocation((BSHArrayDimensions) jjtGetChild(0), Void.TYPE, callStack, interpreter);
        }
        Node nodeJjtGetChild = jjtGetChild(0);
        Node nodeJjtGetChild2 = jjtGetChild(1);
        if (!(nodeJjtGetChild instanceof BSHAmbiguousName)) {
            return primitiveArrayAllocation((BSHPrimitiveType) nodeJjtGetChild, (BSHArrayDimensions) nodeJjtGetChild2, callStack, interpreter);
        }
        BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) nodeJjtGetChild;
        return nodeJjtGetChild2 instanceof BSHArguments ? objectAllocation(bSHAmbiguousName, (BSHArguments) nodeJjtGetChild2, callStack, interpreter) : objectArrayAllocation(bSHAmbiguousName, (BSHArrayDimensions) nodeJjtGetChild2, callStack, interpreter);
    }
}
