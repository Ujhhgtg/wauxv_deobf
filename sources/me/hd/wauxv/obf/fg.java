package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class fg implements Comparable {
    public final amk a;
    public final byte b;
    public final avr c;

    public fg(amk amkVar, byte b, avr avrVar) {
        this.a = amkVar;
        this.b = b;
        this.c = avrVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.c.compareTo(((fg) obj).c);
    }

    public final String toString() {
        avr avrVar = this.c;
        byte b = this.b;
        amk amkVar = this.a;
        if (amkVar == null) {
            StringBuilder sb = new StringBuilder();
            sb.append((int) b);
            sb.append(" ");
            avs avsVar = new avs(avrVar, 29);
            avsVar.g();
            sb.append(avsVar.c);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((int) b);
        sb2.append(" ");
        ami amiVar = amkVar.g;
        avs avsVar2 = new avs(avrVar, 29);
        avsVar2.g();
        sb2.append((String) amiVar.get(avsVar2.c));
        return sb2.toString();
    }
}
