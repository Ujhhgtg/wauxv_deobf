package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHTypedVariableDeclaration extends SimpleNode {
    private static final long serialVersionUID = 1;
    private BSHVariableDeclarator[] bvda;
    public Modifiers modifiers;

    public BSHTypedVariableDeclaration(int i) {
        super(i);
        this.modifiers = new Modifiers(3);
    }

    private BSHType getTypeNode() {
        return (BSHType) jjtGetChild(0);
    }

    /* JADX WARN: Found duplicated region for block: B:36:0x00b1 A[Catch: EvalError -> 0x0042, UtilEvalError -> 0x0045, TRY_LEAVE, TryCatch #0 {UtilEvalError -> 0x0045, blocks: (B:7:0x0024, B:9:0x0028, B:12:0x002e, B:20:0x005f, B:22:0x0063, B:34:0x00ad, B:36:0x00b1, B:24:0x0077, B:26:0x007d, B:28:0x0081, B:30:0x008a, B:31:0x0094, B:33:0x009f, B:17:0x0048), top: B:45:0x0024, outer: #1 }] */
    /* JADX WARN: Found duplicated region for block: B:38:0x00b8  */
    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        LHS lhs;
        Object variable = Primitive.VOID;
        try {
            NameSpace pVar = callStack.top();
            BSHType typeNode = getTypeNode();
            Class<?> type = typeNode.getType(callStack, interpreter);
            for (BSHVariableDeclarator bSHVariableDeclarator : getDeclarators()) {
                Object objEval = bSHVariableDeclarator.eval(typeNode, this.modifiers, callStack, interpreter);
                try {
                    if (pVar.isClass) {
                        Object obj = pVar.classInstance;
                        if (obj != null) {
                            lhs = new LHS(obj, Reflect.resolveJavaField(pVar.classStatic, bSHVariableDeclarator.name, this.modifiers.hasModifier("static")));
                        } else {
                            Class<?> cls = pVar.classStatic;
                            lhs = new LHS((Object) cls, Reflect.resolveJavaField(cls, bSHVariableDeclarator.name, this.modifiers.hasModifier("static")));
                        }
                    } else {
                        lhs = null;
                    }
                    if (lhs == null || lhs.field == null) {
                        if (interpreter.getStrictJava() && (objEval instanceof Primitive) && ((Primitive) objEval).isNumber()) {
                            objEval = Primitive.castNumberStrictJava(type, ((Primitive) objEval).numberValue());
                        }
                        pVar.setTypedVariable(bSHVariableDeclarator.name, type, objEval, this.modifiers);
                        if (!pVar.isMethod) {
                            interpreter.getClassManager().addListener(pVar.getVariableImpl(bSHVariableDeclarator.name, false));
                        }
                        variable = !pVar.isClass ? pVar.getVariable(bSHVariableDeclarator.name) : objEval;
                    } else {
                        Variable variable2 = new Variable(bSHVariableDeclarator.name, type, lhs);
                        variable2.modifiers = this.modifiers;
                        variable2.setValue(objEval, 1);
                        pVar.setVariableImpl(variable2);
                    }
                    if (!pVar.isClass) {
                    }
                } catch (UtilEvalError e) {
                    throw e.toEvalError(this, callStack);
                }
            }
            return variable;
        } catch (EvalError e2) {
            throw e2.reThrow("Typed variable declaration");
        }
    }

    public Class<?> evalType(CallStack callStack, Interpreter interpreter) {
        return getTypeNode().getType(callStack, interpreter);
    }

    public BSHVariableDeclarator[] getDeclarators() {
        BSHVariableDeclarator[] bSHVariableDeclaratorArr = this.bvda;
        if (bSHVariableDeclaratorArr != null) {
            return bSHVariableDeclaratorArr;
        }
        int iJjtGetNumChildren = jjtGetNumChildren();
        this.bvda = new BSHVariableDeclarator[iJjtGetNumChildren - 1];
        for (int i = 1; i < iJjtGetNumChildren; i++) {
            this.bvda[i - 1] = (BSHVariableDeclarator) jjtGetChild(i);
        }
        return this.bvda;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.modifiers;
    }
}
