package bsh;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHPrimarySuffix extends SimpleNode {
    public static final int CLASS = 6;
    public static final int INDEX = 1;
    public static final int METHODREF = 5;
    public static final int NAME = 2;
    public static final int NEW = 4;
    public static final int PROPERTY = 3;
    public String field;
    public boolean hasLeftIndex;
    public boolean hasRightIndex;
    Object index;
    public int operation;
    public boolean safeNavigate;
    public boolean slice;
    public boolean step;

    public BSHPrimarySuffix(int i) {
        super(i);
        this.slice = false;
        this.step = false;
        this.hasLeftIndex = false;
        this.hasRightIndex = false;
        this.safeNavigate = false;
    }

    /* JADX WARN: Found duplicated region for block: B:91:0x013e A[PHI: r3
      0x013e: PHI (r3v5 int) = (r3v4 int), (r3v13 int) binds: [B:64:0x00e4, B:85:0x0129] A[DONT_GENERATE, DONT_INLINE]] */
    private Object doIndex(Object obj, boolean z, CallStack callStack, Interpreter interpreter) throws EvalError {
        int iIntValue;
        Integer numValueOf;
        int i = 0;
        if (!interpreter.getStrictJava()) {
            if (Types.isPropertyTypeMap(obj)) {
                Object objEval = jjtGetChild(0).eval(callStack, interpreter);
                return z ? new LHS(obj, objEval) : Reflect.getObjectProperty(obj, objEval);
            }
            if (Types.isPropertyTypeEntry(obj)) {
                Object objEval2 = jjtGetChild(0).eval(callStack, interpreter);
                if (!z) {
                    return Reflect.getObjectProperty(obj, objEval2);
                }
                if (objEval2.equals(((Map.Entry) obj).getKey())) {
                    return new LHS(obj);
                }
                throw new EvalError(StaticHelpers6.concatVar2Var1(objEval2, "No such property: "), this, callStack);
            }
        }
        Class<?> cls = obj.getClass();
        if ((interpreter.getStrictJava() || !(obj instanceof List)) && !cls.isArray()) {
            throw new EvalError("Not an array or List type", this, callStack);
        }
        int size = obj instanceof List ? ((List) obj).size() : Array.getLength(obj);
        int indexAux = size + 1;
        if (!interpreter.getStrictJava() && Types.isPropertyTypeEntryList(cls)) {
            Object objEval3 = jjtGetChild(0).eval(callStack, interpreter);
            if (((!(objEval3 instanceof Primitive) || !((Primitive) objEval3).isNumber()) && !Primitive.isWrapperType(objEval3.getClass())) || size <= (indexAux = ((Integer) Primitive.castWrapper(Integer.TYPE, objEval3)).intValue()) || (-size) >= indexAux) {
                return z ? new LHS(Reflect.getEntryForKey(objEval3, (Map.Entry[]) obj)) : Reflect.getObjectProperty(obj, objEval3);
            }
        } else if (indexAux > size) {
            indexAux = getIndexAux(obj, 0, callStack, interpreter, this);
        }
        if (!interpreter.getStrictJava()) {
            if (indexAux < 0) {
                indexAux += size;
            }
            if (this.slice) {
                if (z) {
                    throw new EvalError("cannot assign to array slice", this, callStack);
                }
                if (this.step) {
                    if (this.hasLeftIndex && this.hasRightIndex && jjtGetNumChildren() == 3) {
                        numValueOf = Integer.valueOf(getIndexAux(obj, 2, callStack, interpreter, this));
                    } else if (!(this.hasLeftIndex && this.hasRightIndex) && jjtGetNumChildren() == 2) {
                        numValueOf = Integer.valueOf(getIndexAux(obj, 1, callStack, interpreter, this));
                    } else if (this.hasLeftIndex || this.hasRightIndex) {
                        numValueOf = null;
                    } else {
                        numValueOf = Integer.valueOf(getIndexAux(obj, 0, callStack, interpreter, this));
                        indexAux = 0;
                    }
                    if (numValueOf == null) {
                        iIntValue = 0;
                    } else {
                        if (numValueOf.intValue() == 0) {
                            throw new EvalError("array slice step cannot be zero", this, callStack);
                        }
                        iIntValue = numValueOf.intValue();
                    }
                } else {
                    iIntValue = 0;
                }
                if (this.hasLeftIndex && this.hasRightIndex) {
                    i = indexAux;
                    indexAux = getIndexAux(obj, 1, callStack, interpreter, this);
                } else if (!this.hasRightIndex) {
                    i = indexAux;
                    indexAux = size;
                }
                if (indexAux < 0) {
                    indexAux += size;
                }
                return obj.getClass().isArray() ? BshArray.slice(obj, i, indexAux, iIntValue) : BshArray.slice((List<Object>) obj, i, indexAux, iIntValue);
            }
        } else if (this.slice) {
            throw new EvalError("expected ']' but found ':'", this, callStack);
        }
        if (z) {
            return new LHS(obj, indexAux);
        }
        try {
            return BshArray.getIndex(obj, indexAux);
        } catch (UtilEvalError e) {
            throw e.toEvalError("Error array get index", this, callStack);
        }
    }

    private BshLambda doMethodRef(Object obj) {
        return BshLambda.fromMethodReference(this, obj, this.field);
    }

    private Object doName(Object obj, boolean z, CallStack callStack, Interpreter interpreter) throws EvalError {
        CallStack callStack2;
        UtilEvalError utilEvalError;
        try {
            if (this.safeNavigate) {
                try {
                    if (Primitive.NULL == obj) {
                        throw SafeNavigate.doAbort();
                    }
                } catch (UtilEvalError e) {
                    utilEvalError = e;
                    callStack2 = callStack;
                }
            }
        } catch (UtilEvalError e2) {
            e = e2;
            callStack2 = callStack;
        }
        if (this.field.equals("length") && obj.getClass().isArray()) {
            Interpreter.mainSecurityGuard.canGetField(obj, this.field);
            if (z) {
                throw new EvalError("Can't assign array length", this, callStack);
            }
            return new Primitive(Array.getLength(obj));
        }
        if (jjtGetNumChildren() == 0) {
            Interpreter.mainSecurityGuard.canGetField(obj, this.field);
            if (z) {
                try {
                    return Reflect.getLHSObjectField(obj, this.field);
                } catch (Throwable unused) {
                    return new LHS(obj, this.field);
                }
            }
            try {
                try {
                    return Reflect.getObjectFieldValue(obj, this.field);
                } catch (Throwable unused2) {
                    return Reflect.getObjectProperty(obj, this.field);
                }
            } catch (Throwable unused3) {
                return Primitive.VOID;
            }
            utilEvalError = e;
            callStack2 = callStack;
            throw utilEvalError.toEvalError(this, callStack2);
        }
        Object[] arguments = ((BSHArguments) jjtGetChild(0)).getArguments(callStack, interpreter);
        Interpreter.mainSecurityGuard.canInvokeMethod(obj, this.field, arguments);
        callStack2 = callStack;
        try {
            return Reflect.invokeObjectMethod(obj, this.field, arguments, interpreter, callStack2, this);
        } catch (UtilEvalError e3) {
            e = e3;
        }
        utilEvalError = e;
        throw utilEvalError.toEvalError(this, callStack2);
    }

    private Object doNewInner(Object obj, boolean z, CallStack callStack, Interpreter interpreter) {
        BSHAllocationExpression bSHAllocationExpression = (BSHAllocationExpression) jjtGetChild(0);
        if (!Reflect.isGeneratedClass(obj.getClass())) {
            return bSHAllocationExpression.constructFromEnclosingInstance(obj, callStack, interpreter);
        }
        callStack.pop();
        callStack.push(Reflect.getThisNS(obj));
        return bSHAllocationExpression.eval(callStack, interpreter);
    }

    private Object doProperty(boolean z, Object obj, CallStack callStack, Interpreter interpreter) throws EvalError {
        if (obj == Primitive.VOID) {
            throw new EvalError("Attempt to access property on undefined variable or class name", this, callStack);
        }
        if (obj instanceof Primitive) {
            throw new EvalError("Attempt to access property on a primitive", this, callStack);
        }
        Object objEval = jjtGetChild(0).eval(callStack, interpreter);
        if (!(objEval instanceof String)) {
            throw new EvalError("Property expression must be a String or identifier.", this, callStack);
        }
        if (z) {
            return new LHS(obj, (String) objEval);
        }
        try {
            Object objectProperty = Reflect.getObjectProperty(obj, (String) objEval);
            return objectProperty == null ? Primitive.NULL : Primitive.unwrap(objectProperty);
        } catch (ReflectError e) {
            throw new EvalError(StaticHelpers6.concatVar2Var1(objEval, "No such property: "), this, callStack, e);
        }
    }

    public static int getIndexAux(Object obj, int i, CallStack callStack, Interpreter interpreter, Node node) throws EvalError {
        try {
            Object objEval = node.jjtGetChild(i).eval(callStack, interpreter);
            boolean z = objEval instanceof Primitive;
            Class cls = Integer.TYPE;
            if (!z) {
                objEval = Types.castObject(objEval, cls, 1);
            }
            return ((Integer) Primitive.castWrapper(cls, objEval)).intValue();
        } catch (Exception e) {
            Interpreter.debug("doIndex: " + e);
            throw new EvalError("Array index does not evaluate to an integer.", node, callStack, e);
        }
    }

    public Object doSuffix(Object obj, boolean z, CallStack callStack, Interpreter interpreter) {
        if (this.operation == 6) {
            if (!(obj instanceof BSHType)) {
                throw new EvalException("Attempt to use .class suffix on non class.", this, callStack);
            }
            if (z) {
                throw new EvalException("Can't assign .class", this, callStack);
            }
            return ((BSHType) obj).getType(callStack, interpreter);
        }
        if (obj instanceof Node) {
            obj = obj instanceof BSHAmbiguousName ? ((BSHAmbiguousName) obj).toObject(callStack, interpreter) : ((Node) obj).eval(callStack, interpreter);
        } else if (obj instanceof LHS) {
            try {
                obj = ((LHS) obj).getValue();
            } catch (UtilEvalError e) {
                throw e.toEvalError(this, callStack);
            }
        }
        try {
            int i = this.operation;
            if (i == 1) {
                return doIndex(obj, z, callStack, interpreter);
            }
            if (i == 2) {
                return doName(obj, z, callStack, interpreter);
            }
            if (i == 3) {
                return doProperty(z, obj, callStack, interpreter);
            }
            if (i == 4) {
                return doNewInner(obj, z, callStack, interpreter);
            }
            if (i == 5) {
                return doMethodRef(obj);
            }
            throw new InterpreterError("Unknown suffix type");
        } catch (ReflectError e2) {
            throw new EvalError("reflection error: " + e2, this, callStack, e2);
        }
    }

    @Override // bsh.SimpleNode
    public String toString() {
        int i = this.operation;
        if (i != 1) {
            if (i != 2) {
                return i == 3 ? yg.concatToVar1(new StringBuilder(), super.toString(), ":PROPERTY {}") : i == 4 ? yg.concatToVar1(new StringBuilder(), super.toString(), ":NEW new") : i == 6 ? yg.concatToVar1(new StringBuilder(), super.toString(), ":CLASS class") : yg.concatToVar1(new StringBuilder(), super.toString(), ":NO OPERATION");
            }
            return super.toString() + ":NAME " + this.field;
        }
        return super.toString() + ":INDEX [" + this.hasLeftIndex + ":" + this.slice + " " + this.hasRightIndex + ":" + this.step + "]";
    }
}
