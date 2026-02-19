package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emd implements Comparable {
    public static final emd a = new emd(null, amk.a);
    public final amk b;
    public final short[] c;

    public emd(amk amkVar, short[] sArr) {
        this.b = amkVar;
        this.c = sArr;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        short[] sArr;
        emd emdVar = (emd) obj;
        int i = 0;
        while (true) {
            sArr = this.c;
            if (i >= sArr.length) {
                break;
            }
            short[] sArr2 = emdVar.c;
            if (i >= sArr2.length) {
                break;
            }
            short s = sArr[i];
            short s2 = sArr2[i];
            if (s != s2) {
                if (s == s2) {
                    return 0;
                }
                return (s & 65535) < (65535 & s2) ? -1 : 1;
            }
            i++;
        }
        return FastKV.t(sArr.length, emdVar.c.length);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        short[] sArr = this.c;
        int length = sArr.length;
        for (int i = 0; i < length; i++) {
            amk amkVar = this.b;
            sb.append(amkVar != null ? (Serializable) amkVar.g.get(sArr[i]) : Short.valueOf(sArr[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}
