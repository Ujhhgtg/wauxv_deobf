package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pe {
    public final StringBuilder a;
    public int b;

    public pe() {
        this.b = 0;
        this.a = new StringBuilder();
    }

    public pe(int i, StringBuilder sb) {
        this.a = sb;
        this.b = i;
        if (i < 0 || i > sb.length()) {
            throw new IllegalArgumentException("invalid shiftLeft");
        }
    }
}
