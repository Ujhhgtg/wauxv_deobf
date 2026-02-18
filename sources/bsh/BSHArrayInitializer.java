package bsh;

import bsh.Types;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHArrayInitializer extends SimpleNode {
    private static final long serialVersionUID = 1;
    Deque<BSHPrimaryExpression> expressionQueue;
    boolean isMapInArray;

    public BSHArrayInitializer(int i) {
        super(i);
        this.isMapInArray = false;
        this.expressionQueue = new ArrayDeque();
    }

    private Object buildArray(int i, Class<?> cls, CallStack callStack, Interpreter interpreter) throws EvalException {
        Object objEval;
        int[] iArr = new int[i];
        iArr[0] = jjtGetNumChildren();
        Object objNewInstance = Array.newInstance(cls, iArr);
        for (int i2 = 0; i2 < jjtGetNumChildren(); i2++) {
            Node nodeJjtGetChild = jjtGetChild(i2);
            if (!(nodeJjtGetChild instanceof BSHArrayInitializer)) {
                objEval = nodeJjtGetChild.eval(callStack, interpreter);
            } else if (i < 2) {
                BSHArrayInitializer bSHArrayInitializer = (BSHArrayInitializer) nodeJjtGetChild;
                if (!isMapInArray(bSHArrayInitializer)) {
                    throw new EvalException("Invalid Intializer for " + cls + ", at position: " + i2, this, callStack);
                }
                objEval = bSHArrayInitializer.eval(Types.MapEntry.class, 1, callStack, interpreter);
            } else {
                objEval = ((BSHArrayInitializer) nodeJjtGetChild).eval(cls, i - 1, callStack, interpreter);
            }
            if (objEval == Primitive.VOID) {
                throw new EvalException(concatVar2Var1(i2, "Void in array initializer, position "), this, callStack);
            }
            try {
                Array.set(objNewInstance, i2, normalizeEntry(objEval, cls, i, callStack));
            } catch (IllegalArgumentException e) {
                Interpreter.debug("illegal arg", e);
                throwTypeError(cls, objEval, i2, callStack);
            }
        }
        return objNewInstance;
    }

    private Object buildBean(Class<?> cls, CallStack callStack, Interpreter interpreter) {
        callStack.push(new NameSpace(callStack.top(), cls.getName()));
        callStack.top().setClassStatic(cls);
        callStack.top().getThis(interpreter);
        try {
            Object objNewInstance = cls.getConstructor(null).newInstance(null);
            callStack.top().setClassInstance(objNewInstance);
            for (int i = 0; i < jjtGetNumChildren(); i++) {
                BSHAssignment bSHAssignment = (BSHAssignment) jjtGetChild(i);
                BSHPrimaryExpression bSHPrimaryExpression = (BSHPrimaryExpression) bSHAssignment.jjtGetChild(0);
                bSHPrimaryExpression.isMapExpression = false;
                bSHPrimaryExpression.isArrayExpression = false;
                bSHAssignment.eval(callStack, interpreter);
            }
            callStack.pop();
            return objNewInstance;
        } catch (Throwable th) {
            try {
                throw new EvalException(th.getMessage(), this, callStack, th);
            } catch (Throwable th2) {
                callStack.pop();
                throw th2;
            }
        }
    }

    private void clearEvalCache() {
        Iterator<BSHPrimaryExpression> it = this.expressionQueue.iterator();
        while (it.hasNext()) {
            it.next().clearCache();
        }
    }

    private Class<?> inferCommonType(Class<?> cls, Node node, CallStack callStack, Interpreter interpreter) {
        if (Object.class != cls && Types.MapEntry.class != cls) {
            if (node instanceof BSHAssignment) {
                return Types.getCommonType(cls, Types.arrayElementType(
                        Types.getType(node.eval(callStack, interpreter), Primitive.isWrapperType(cls))));
            }
            if ((node instanceof BSHArrayInitializer) && isMapInArray((BSHArrayInitializer) node)) {
                return Types.getCommonType(cls, Map.class);
            }
            for (Node node2 : node.jjtGetChildren()) {
                cls = inferCommonType(cls, node2, callStack, interpreter);
            }
        }
        return cls;
    }

    private int inferDimensions(int i, int i2, Node node, CallStack callStack, Interpreter interpreter) {
        int i3 = i;
        while (node.jjtGetNumChildren() > i2) {
            node = node.jjtGetChild(i2);
            if (!(node instanceof BSHArrayInitializer) || isMapInArray((BSHArrayInitializer) node)
                    || node.jjtGetNumChildren() <= 0) {
                break;
            }
            i3++;
            i2 = 0;
        }
        if (node instanceof BSHArrayInitializer) {
            return node.jjtGetNumChildren() == 0
                    ? inferDimensions(i3, i2 + 1, node.jjtGetParent(), callStack, interpreter)
                    : i3;
        }
        Object objEval = node.eval(callStack, interpreter);
        return objEval == Primitive.NULL ? inferDimensions(i3, i2 + 1, node.jjtGetParent(), callStack, interpreter)
                : i3 + Types.arrayDimensions(Types.getType(objEval));
    }

    private boolean isBeanType(Class<?> cls) {
        return Void.TYPE != cls && !Types.isCollectionType(cls) && (jjtGetChild(0) instanceof BSHAssignment)
                && (jjtGetChild(0).jjtGetChild(0) instanceof BSHPrimaryExpression)
                && ((BSHPrimaryExpression) jjtGetChild(0).jjtGetChild(0)).isMapExpression
                && (jjtGetChild(0).jjtGetChild(0).jjtGetChild(0) instanceof BSHAmbiguousName);
    }

    private boolean isMapInArray(BSHArrayInitializer bSHArrayInitializer) {
        return bSHArrayInitializer.isMapInArray;
    }

    private Object normalizeEntry(Object obj, Class<?> cls, int i, CallStack callStack) throws EvalException {
        if (i != 1 && obj == Primitive.NULL) {
            return Primitive.unwrap(obj);
        }
        try {
            return Primitive.unwrap(Types.castObject(obj, cls, 0));
        } catch (UtilEvalError e) {
            throw e.toEvalException("Error in array initializer", this, callStack);
        }
    }

    private void throwTypeError(Class<?> cls, Object obj, int i, CallStack callStack) throws EvalException {
        StringBuilder sbZ = dkz.z("Incompatible type: ", StringUtil.typeString(obj), " in initializer of array type: ");
        sbZ.append(cls.getSimpleName());
        sbZ.append(" at position: ");
        sbZ.append(i);
        throw new EvalException(sbZ.toString(), this, callStack);
    }

    private Object toCollection(Object obj, Class<?> cls, CallStack callStack) {
        if (Types.isCollectionType(cls)) {
            try {
                return Types.castObject(obj, cls, 0);
            } catch (UtilEvalError e) {
                e.toEvalError(this, callStack);
            }
        }
        return obj;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        throw new EvalError("Array initializer has no base type.", this, callStack);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public void jjtSetParent(Node node) {
        this.parent = node;
        Node[] nodeArr = this.children;
        if (nodeArr != null) {
            for (Node node2 : nodeArr) {
                if (node2.jjtGetNumChildren() > 0 && (node2.jjtGetChild(0) instanceof BSHPrimaryExpression)) {
                    this.expressionQueue.push((BSHPrimaryExpression) node2.jjtGetChild(0));
                    this.expressionQueue.peek().setArrayExpression(this);
                }
            }
        }
    }

    public void setMapInArray(boolean z) {
        this.isMapInArray = z;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.isMapInArray;
    }

    /* JADX WARN: Found duplicated region for block: B:30:0x0059 */
    /* JADX WARN: Found duplicated region for block: B:37:0x006a */
    /* JADX WARN: Found duplicated region for block: B:38:0x006d */
    public Object eval(Class<?> cls, int i, CallStack callStack, Interpreter interpreter) throws EvalException {
        CallStack callStack2;
        Interpreter interpreter2;
        Class<?> clsInferCommonType;
        if (jjtGetNumChildren() == 0) {
            i = 0;
        }
        Class<?> cls2 = Object.class;
        Class<?> cls3 = Void.TYPE;
        if (i == 0) {
            if (cls != cls3 && !Types.isCollectionType(cls)) {
                cls2 = cls;
            }
            return toCollection(Array.newInstance(cls2, 0), cls, callStack);
        }
        if (-1 == i) {
            if (interpreter.getStrictJava()) {
                throw new EvalException("No declared array type or dimensions.", this, callStack);
            }
            if (isBeanType(cls)) {
                return buildBean(cls, callStack, interpreter);
            }
            callStack2 = callStack;
            interpreter2 = interpreter;
            i = inferDimensions(1, 0, this, callStack2, interpreter2);
            if (Types.isCollectionType(cls)) {
                clsInferCommonType = cls3;
            }
            if (clsInferCommonType == cls3) {
                clsInferCommonType = inferCommonType(null, this, callStack2, interpreter2);
            }
            if ((Types.MapEntry.class != clsInferCommonType && cls3 == cls) || Types.MapEntry.class == cls) {
            }
            if (clsInferCommonType == null) {
                i++;
            } else {
                cls2 = clsInferCommonType;
            }
            Object objBuildArray = buildArray(i, cls2, callStack2, interpreter2);
            clearEvalCache();
            return toCollection(objBuildArray, cls, callStack2);
        }
        callStack2 = callStack;
        interpreter2 = interpreter;
        clsInferCommonType = cls;
        if (clsInferCommonType == cls3) {
            clsInferCommonType = inferCommonType(null, this, callStack2, interpreter2);
        }
        cls = Types.MapEntry.class != clsInferCommonType ? Map.class : Map.class;
        if (clsInferCommonType == null) {
            i++;
        } else {
            cls2 = clsInferCommonType;
        }
        Object objBuildArray2 = buildArray(i, cls2, callStack2, interpreter2);
        clearEvalCache();
        return toCollection(objBuildArray2, cls, callStack2);
    }
}
