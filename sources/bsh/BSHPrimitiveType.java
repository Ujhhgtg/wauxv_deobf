package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHPrimitiveType extends SimpleNode {
    public Class<?> type;

    public BSHPrimitiveType(int i) {
        super(i);
    }

    public Class<?> getType() {
        return this.type;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.type;
    }
}
