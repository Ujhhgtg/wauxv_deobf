package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwk {
    public static final cbm a;
    public static final cwk[] b;
    public static final cwk c;
    public static final cwk d;
    public static final cwk e;
    public static final cwk f;
    public static final cwk g;
    public static final /* synthetic */ cwk[] h;
    public static final /* synthetic */ awn i;
    public final int j;

    static {
        Object next;
        cwk cwkVar = new cwk("INVALID", 0, -1);
        c = cwkVar;
        cwk cwkVar2 = new cwk("VARINT", 1, 0);
        d = cwkVar2;
        cwk cwkVar3 = new cwk("i64", 2, 1);
        e = cwkVar3;
        cwk cwkVar4 = new cwk("SIZE_DELIMITED", 3, 2);
        f = cwkVar4;
        cwk cwkVar5 = new cwk("i32", 4, 5);
        g = cwkVar5;
        cwk[] cwkVarArr = {cwkVar, cwkVar2, cwkVar3, cwkVar4, cwkVar5};
        h = cwkVarArr;
        i = new awn(cwkVarArr);
        a = new cbm(15);
        cwk[] cwkVarArr2 = new cwk[8];
        for (int i2 = 0; i2 < 8; i2++) {
            awn awnVar = i;
            awnVar.getClass();
            z zVar = new z(awnVar, 0);
            do {
                if (!zVar.hasNext()) {
                    next = null;
                    break;
                }
                next = zVar.next();
            } while (((cwk) next).j != i2);
            cwk cwkVar6 = (cwk) next;
            if (cwkVar6 == null) {
                cwkVar6 = c;
            }
            cwkVarArr2[i2] = cwkVar6;
        }
        b = cwkVarArr2;
    }

    public cwk(String str, int i2, int i3) {
        this.j = i3;
    }

    public static cwk valueOf(String str) {
        return (cwk) Enum.valueOf(cwk.class, str);
    }

    public static cwk[] values() {
        return (cwk[]) h.clone();
    }

    public final int k(int i2) {
        return (i2 << 3) | this.j;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name());
        sb.append('(');
        return dkz.v(sb, this.j, ')');
    }
}
