package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHMethodDeclaration extends SimpleNode {
    BSHBlock blockNode;
    int firstThrowsClause;
    private boolean isScriptedObject;
    boolean isVarArgs;
    public Modifiers modifiers;
    public String name;
    int numThrows;
    BSHFormalParameters paramsNode;
    Class<?> returnType;
    BSHReturnType returnTypeNode;

    public BSHMethodDeclaration(int i) {
        super(i);
        this.modifiers = new Modifiers(2);
        this.numThrows = 0;
    }

    private void evalNodes(CallStack callStack, Interpreter interpreter) throws EvalError {
        insureNodesParsed();
        for (int i = this.firstThrowsClause; i < this.numThrows + this.firstThrowsClause; i++) {
            ((BSHAmbiguousName) jjtGetChild(i)).toClass(callStack, interpreter);
        }
        this.paramsNode.eval(callStack, interpreter);
        if (!interpreter.getStrictJava()) {
            return;
        }
        int i2 = 0;
        while (true) {
            Class<?>[] clsArr = this.paramsNode.paramTypes;
            if (i2 >= clsArr.length) {
                if (this.returnType != null) {
                    return;
                }
                throw new EvalException("(Strict Java Mode) Undeclared return type for method: " + this.name, this, null);
            }
            if (clsArr[i2] == null) {
                throw new EvalException("(Strict Java Mode) Undeclared argument type, parameter: " + this.paramsNode.getParamNames()[i2] + " in method: " + this.name, this, null);
            }
            i2++;
        }
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        this.returnType = evalReturnType(callStack, interpreter);
        evalNodes(callStack, interpreter);
        NameSpace pVar = callStack.top();
        BshMethod bshMethod = new BshMethod(this, pVar, this.modifiers, this.isScriptedObject);
        boolean z = pVar.isMethod;
        if (!z && !pVar.isClass) {
            interpreter.getClassManager().addListener(bshMethod);
        } else if (z && !this.paramsNode.isListener()) {
            interpreter.getClassManager().addListener(this.paramsNode);
            this.paramsNode.setListener(true);
        }
        pVar.setMethod(bshMethod);
        return Primitive.VOID;
    }

    public Class<?> evalReturnType(CallStack callStack, Interpreter interpreter) {
        insureNodesParsed();
        BSHReturnType bSHReturnType = this.returnTypeNode;
        if (bSHReturnType != null) {
            return bSHReturnType.evalReturnType(callStack, interpreter);
        }
        return null;
    }

    public String getReturnTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        insureNodesParsed();
        BSHReturnType bSHReturnType = this.returnTypeNode;
        if (bSHReturnType == null) {
            return null;
        }
        return bSHReturnType.getTypeDescriptor(callStack, interpreter, str);
    }

    public BSHReturnType getReturnTypeNode() {
        insureNodesParsed();
        return this.returnTypeNode;
    }

    public synchronized void insureNodesParsed() {
        try {
            if (this.paramsNode != null) {
                return;
            }
            Node nodeJjtGetChild = jjtGetChild(0);
            this.firstThrowsClause = 1;
            if (nodeJjtGetChild instanceof BSHReturnType) {
                this.returnTypeNode = (BSHReturnType) nodeJjtGetChild;
                this.paramsNode = (BSHFormalParameters) jjtGetChild(1);
                int iJjtGetNumChildren = jjtGetNumChildren();
                int i = this.numThrows;
                if (iJjtGetNumChildren > i + 2) {
                    this.blockNode = (BSHBlock) jjtGetChild(i + 2);
                }
                this.firstThrowsClause++;
            } else {
                this.paramsNode = (BSHFormalParameters) jjtGetChild(0);
                this.blockNode = (BSHBlock) jjtGetChild(this.numThrows + 1);
            }
            BSHBlock bSHBlock = this.blockNode;
            if (bSHBlock != null && bSHBlock.jjtGetNumChildren() > 0) {
                BSHBlock bSHBlock2 = this.blockNode;
                Node nodeJjtGetChild2 = bSHBlock2.jjtGetChild(bSHBlock2.jjtGetNumChildren() - 1);
                if (nodeJjtGetChild2 instanceof BSHReturnStatement) {
                    while (nodeJjtGetChild2.hasNext()) {
                        nodeJjtGetChild2 = nodeJjtGetChild2.next();
                        if (nodeJjtGetChild2 instanceof BSHAmbiguousName) {
                            this.isScriptedObject = ((BSHAmbiguousName) nodeJjtGetChild2).text.startsWith("this");
                        }
                    }
                }
            }
            this.paramsNode.insureParsed();
            this.isVarArgs = this.paramsNode.isVarArgs;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.name;
    }
}
