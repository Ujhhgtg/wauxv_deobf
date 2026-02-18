package bsh;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class JJTParserState implements Serializable {
    private boolean node_created;
    private List<Node> nodes = new ArrayList();
    private List<Integer> marks = new ArrayList();
    private int sp = 0;
    private int mk = 0;

    public void clearNodeScope(Node node) {
        while (this.sp > this.mk) {
            popNode();
        }
        this.mk = this.marks.remove(r2.size() - 1).intValue();
    }

    public void closeNodeScope(Node node, int i) {
        List<Integer> list = this.marks;
        this.mk = list.remove(list.size() - 1).intValue();
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                node.jjtClose();
                pushNode(node);
                this.node_created = true;
                return;
            } else {
                Node nodePopNode = popNode();
                nodePopNode.jjtSetParent(node);
                node.jjtAddChild(nodePopNode, i2);
                i = i2;
            }
        }
    }

    public int nodeArity() {
        return this.sp - this.mk;
    }

    public boolean nodeCreated() {
        return this.node_created;
    }

    public void openNodeScope(Node node) {
        this.marks.add(Integer.valueOf(this.mk));
        this.mk = this.sp;
        node.jjtOpen();
    }

    public Node peekNode() {
        return this.nodes.get(r0.size() - 1);
    }

    public Node popNode() {
        int i = this.sp - 1;
        this.sp = i;
        if (i < this.mk) {
            this.mk = this.marks.remove(r0.size() - 1).intValue();
        }
        return this.nodes.remove(r0.size() - 1);
    }

    public void pushNode(Node node) {
        this.nodes.add(node);
        this.sp++;
    }

    public void reset() {
        this.nodes.clear();
        this.marks.clear();
        this.sp = 0;
        this.mk = 0;
    }

    public Node rootNode() {
        return this.nodes.get(0);
    }

    public void closeNodeScope(Node node, boolean z) {
        if (z) {
            int iNodeArity = nodeArity();
            List<Integer> list = this.marks;
            this.mk = list.remove(list.size() - 1).intValue();
            while (true) {
                int i = iNodeArity - 1;
                if (iNodeArity > 0) {
                    Node nodePopNode = popNode();
                    nodePopNode.jjtSetParent(node);
                    node.jjtAddChild(nodePopNode, i);
                    iNodeArity = i;
                } else {
                    node.jjtClose();
                    pushNode(node);
                    this.node_created = true;
                    return;
                }
            }
        } else {
            List<Integer> list2 = this.marks;
            this.mk = list2.remove(list2.size() - 1).intValue();
            this.node_created = false;
        }
    }
}
