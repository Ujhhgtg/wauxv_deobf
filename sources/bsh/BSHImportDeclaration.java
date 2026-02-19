package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHImportDeclaration extends SimpleNode {
    private static final long serialVersionUID = 1;
    public boolean importPackage;
    public boolean staticImport;
    public boolean superImport;

    public BSHImportDeclaration(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        Class<?> cls;
        NameSpace pVar = callStack.top();
        if (this.superImport) {
            try {
                pVar.doSuperImport();
            } catch (UtilEvalError e) {
                throw e.toEvalError(this, callStack);
            }
        } else {
            BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) jjtGetChild(0);
            if (!this.staticImport) {
                String str = bSHAmbiguousName.text;
                if (this.importPackage) {
                    pVar.importPackage(str);
                } else {
                    pVar.importClass(str);
                }
            } else {
                if (!this.importPackage) {
                    String strSuffix = Name.suffix(bSHAmbiguousName.text, 1);
                    Object object = null;
                    try {
                        cls = pVar.getClass(Name.prefix(bSHAmbiguousName.text));
                        try {
                            object = Reflect.staticMethodImport(cls, strSuffix);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        cls = null;
                    }
                    if (cls != null && object == null) {
                        try {
                            object = Reflect.getLHSStaticField(cls, strSuffix);
                        } catch (Exception unused3) {
                        }
                    }
                    if (object == null) {
                        try {
                            object = bSHAmbiguousName.toObject(callStack, interpreter);
                        } catch (Exception unused4) {
                        }
                    }
                    if (object instanceof BshMethod) {
                        pVar.setMethod((BshMethod) object);
                        return Primitive.VOID;
                    }
                    if (!(object instanceof LHS)) {
                        object = bSHAmbiguousName.toLHS(callStack, interpreter);
                    }
                    if (object instanceof LHS) {
                        LHS lhs = (LHS) object;
                        if (lhs.isStatic()) {
                            pVar.setVariableImpl(lhs.getVariable());
                            return Primitive.VOID;
                        }
                    }
                    throw new EvalException(yg.concatToVar1(new StringBuilder(), bSHAmbiguousName.text, " is not a static member of a class"), this, callStack);
                }
                pVar.importStatic(bSHAmbiguousName.toClass(callStack, interpreter));
            }
        }
        return Primitive.VOID;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": static=" + this.staticImport + ", *=" + this.importPackage + ", super import=" + this.superImport;
    }
}
