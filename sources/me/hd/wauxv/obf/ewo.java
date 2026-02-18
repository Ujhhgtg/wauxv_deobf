package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewo {
    public final int a;

    public ewo(int i) {
        this.a = i;
    }

    public final byte[] b(byte[] bArr) {
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf((byte) (b ^ ((byte) this.a))));
        }
        return aaz.w(arrayList);
    }

    public final byte[] c(byte[] bArr) {
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf((byte) (b ^ ((byte) this.a))));
        }
        return aaz.w(arrayList);
    }
}
