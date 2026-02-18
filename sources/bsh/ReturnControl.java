package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class ReturnControl implements ParserConstants {
    public int kind;
    public String label;
    public Node returnPoint;
    public Object value;

    public ReturnControl(int i, Object obj, Node node) {
        this.label = null;
        Primitive primitive = Primitive.TRUE;
        this.kind = i;
        this.value = obj;
        this.returnPoint = node;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ReturnControl: ");
        int i = this.kind;
        if (i == 13) {
            str = "BREAK ";
        } else if (i == 47) {
            str = "RETURN ";
        } else if (i == 20) {
            str = "CONTINUE ";
        } else {
            str = "DUNNO?? " + this.kind;
        }
        sb.append(str);
        sb.append(this.label);
        sb.append(": from: ");
        sb.append(this.returnPoint);
        return sb.toString();
    }

    public ReturnControl(int i, String str, Node node) {
        this.label = null;
        this.value = Primitive.VOID;
        this.kind = i;
        this.label = str;
        this.returnPoint = node;
    }
}
