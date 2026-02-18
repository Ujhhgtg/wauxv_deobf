package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHReturnStatement extends SimpleNode implements ParserConstants {
    public int kind;
    public String label;

    public BSHReturnStatement(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        String str = this.label;
        if (str != null) {
            return new ReturnControl(this.kind, str, (Node) this);
        }
        return new ReturnControl(this.kind, jjtGetNumChildren() > 0 ? jjtGetChild(0).eval(callStack, interpreter) : Primitive.VOID, this);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": ");
        sb.append(ParserConstants.tokenImage[this.kind]);
        sb.append(" ");
        return yg.o(sb, this.label, ":");
    }
}
