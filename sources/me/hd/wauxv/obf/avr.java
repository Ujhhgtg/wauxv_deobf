package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avr implements Comparable {
    public final byte[] a;

    public avr(byte[] bArr) {
        this.a = bArr;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(avr avrVar) {
        byte[] bArr = this.a;
        int length = bArr.length;
        byte[] bArr2 = avrVar.a;
        byte[] bArr3 = avrVar.a;
        int iMin = Math.min(length, bArr2.length);
        for (int i = 0; i < iMin; i++) {
            byte b = bArr[i];
            byte b2 = bArr3[i];
            if (b != b2) {
                return (b & 255) - (b2 & 255);
            }
        }
        return bArr.length - bArr3.length;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        byte[] bArr = this.a;
        sb.append(Integer.toHexString(bArr[0] & 255));
        sb.append("...(");
        return yg.m(sb, ")", bArr.length);
    }
}
