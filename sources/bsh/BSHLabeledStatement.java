package bsh;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BSHLabeledStatement extends SimpleNode implements ParserConstants {
    String label;

    public BSHLabeledStatement(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode
    public /* bridge */ /* synthetic */ void add(Node node) {
        super.add(node);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void dump(String str) {
        super.dump(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0074, code lost:
    
        if (r3.label.equals(r0.label) == false) goto L27;
     */
    @Override // bsh.SimpleNode, bsh.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object eval(bsh.CallStack r4, bsh.Interpreter r5) throws bsh.EvalError {
        /*
            r3 = this;
            int r0 = r3.jjtGetNumChildren()
            if (r0 <= 0) goto L77
            r0 = 0
            bsh.Node r1 = r3.jjtGetChild(r0)
            boolean r1 = r1 instanceof bsh.BSHForStatement
            if (r1 == 0) goto L1a
            bsh.Node r1 = r3.jjtGetChild(r0)
            bsh.BSHForStatement r1 = (bsh.BSHForStatement) r1
            java.lang.String r2 = r3.label
            r1.label = r2
            goto L3f
        L1a:
            bsh.Node r1 = r3.jjtGetChild(r0)
            boolean r1 = r1 instanceof bsh.BSHEnhancedForStatement
            if (r1 == 0) goto L2d
            bsh.Node r1 = r3.jjtGetChild(r0)
            bsh.BSHEnhancedForStatement r1 = (bsh.BSHEnhancedForStatement) r1
            java.lang.String r2 = r3.label
            r1.label = r2
            goto L3f
        L2d:
            bsh.Node r1 = r3.jjtGetChild(r0)
            boolean r1 = r1 instanceof bsh.BSHWhileStatement
            if (r1 == 0) goto L3f
            bsh.Node r1 = r3.jjtGetChild(r0)
            bsh.BSHWhileStatement r1 = (bsh.BSHWhileStatement) r1
            java.lang.String r2 = r3.label
            r1.label = r2
        L3f:
            bsh.Node r0 = r3.jjtGetChild(r0)
            java.lang.Object r5 = r0.eval(r4, r5)
            boolean r0 = r5 instanceof bsh.ReturnControl
            if (r0 == 0) goto L77
            r0 = r5
            bsh.ReturnControl r0 = (bsh.ReturnControl) r0
            int r1 = r0.kind
            r2 = 13
            if (r1 == r2) goto L6c
            r2 = 20
            if (r1 == r2) goto L59
            goto L76
        L59:
            java.lang.String r1 = r3.label
            java.lang.String r0 = r0.label
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L64
            goto L76
        L64:
            bsh.EvalError r5 = new bsh.EvalError
            java.lang.String r0 = "Continue cannot be used outside of a loop"
            r5.<init>(r0, r3, r4)
            throw r5
        L6c:
            java.lang.String r4 = r3.label
            java.lang.String r0 = r0.label
            boolean r4 = r4.equals(r0)
            if (r4 != 0) goto L77
        L76:
            return r5
        L77:
            bsh.Primitive r4 = bsh.Primitive.VOID
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHLabeledStatement.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ int getId() {
        return super.getId();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ int getLineNumber() {
        return super.getLineNumber();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ String getSourceFile() {
        return super.getSourceFile();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ String getText() {
        return super.getText();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ boolean hasNext() {
        return super.hasNext();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator
    public /* bridge */ /* synthetic */ boolean hasPrevious() {
        return super.hasPrevious();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void jjtAddChild(Node node, int i) {
        super.jjtAddChild(node, i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void jjtClose() {
        super.jjtClose();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ Node jjtGetChild(int i) {
        return super.jjtGetChild(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ Node[] jjtGetChildren() {
        return super.jjtGetChildren();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ int jjtGetNumChildren() {
        return super.jjtGetNumChildren();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ Node jjtGetParent() {
        return super.jjtGetParent();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void jjtOpen() {
        super.jjtOpen();
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void jjtSetParent(Node node) {
        super.jjtSetParent(node);
    }

    @Override // bsh.SimpleNode, java.util.ListIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ Node next() {
        return super.next();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator
    public /* bridge */ /* synthetic */ int nextIndex() {
        return super.nextIndex();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator
    public /* bridge */ /* synthetic */ Node previous() {
        return super.previous();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator
    public /* bridge */ /* synthetic */ int previousIndex() {
        return super.previousIndex();
    }

    @Override // bsh.SimpleNode, java.util.ListIterator, java.util.Iterator
    public /* bridge */ /* synthetic */ void remove() {
        super.remove();
    }

    @Override // bsh.SimpleNode
    public /* bridge */ /* synthetic */ void set(Node node) {
        super.set(node);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ void setSourceFile(String str) {
        super.setSourceFile(str);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public /* bridge */ /* synthetic */ String toString(String str) {
        return super.toString(str);
    }

    @Override // bsh.SimpleNode
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": ");
        return yg.concatToVar1(sb, this.label, ":");
    }
}
