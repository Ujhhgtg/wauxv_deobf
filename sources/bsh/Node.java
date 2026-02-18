package bsh;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Node extends ListIterator<Node> {
    public static final Node JAVACODE = new SimpleNode(-1) { // from class: bsh.Node.1
        private static final long serialVersionUID = 1;

        @Override // bsh.SimpleNode, bsh.Node
        public int getLineNumber() {
            return -1;
        }

        @Override // bsh.SimpleNode, bsh.Node
        public String getSourceFile() {
            return "<Called from Java Code>";
        }

        @Override // bsh.SimpleNode, bsh.Node
        public String getText() {
            return "<Compiled Java Code>";
        }

        @Override // bsh.SimpleNode
        public String toString() {
            return "JavaCode";
        }
    };

    void dump(String str);

    Object eval(CallStack callStack, Interpreter interpreter);

    int getId();

    int getLineNumber();

    String getSourceFile();

    String getText();

    void jjtAddChild(Node node, int i);

    void jjtClose();

    Node jjtGetChild(int i);

    Node[] jjtGetChildren();

    int jjtGetNumChildren();

    Node jjtGetParent();

    void jjtOpen();

    void jjtSetParent(Node node);

    void setSourceFile(String str);

    String toString(String str);
}
