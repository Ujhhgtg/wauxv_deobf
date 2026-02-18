package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class emk {
    public static final ThreadLocal a = new ThreadLocal();
    public final int b;
    public final chm c;
    public volatile int d = 0;

    public emk(chm chmVar, int i) {
        this.c = chmVar;
        this.b = i;
    }

    public final int e(int i) {
        cdb cdbVarF = f();
        int iF = cdbVarF.f(16);
        if (iF == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) cdbVarF.e;
        int i2 = iF + cdbVarF.b;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final cdb f() {
        ThreadLocal threadLocal = a;
        cdb cdbVar = (cdb) threadLocal.get();
        if (cdbVar == null) {
            cdbVar = new cdb();
            threadLocal.set(cdbVar);
        }
        cdc cdcVar = (cdc) this.c.c;
        int iF = cdcVar.f(6);
        if (iF != 0) {
            int i = iF + cdcVar.b;
            int i2 = (this.b * 4) + ((ByteBuffer) cdcVar.e).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) cdcVar.e).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) cdcVar.e;
            cdbVar.e = byteBuffer;
            if (byteBuffer != null) {
                cdbVar.b = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                cdbVar.c = i4;
                cdbVar.d = ((ByteBuffer) cdbVar.e).getShort(i4);
                return cdbVar;
            }
            cdbVar.b = 0;
            cdbVar.c = 0;
            cdbVar.d = 0;
        }
        return cdbVar;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        cdb cdbVarF = f();
        int iF = cdbVarF.f(4);
        sb.append(Integer.toHexString(iF != 0 ? ((ByteBuffer) cdbVarF.e).getInt(iF + cdbVarF.b) : 0));
        sb.append(", codepoints:");
        cdb cdbVarF2 = f();
        int iF2 = cdbVarF2.f(16);
        if (iF2 != 0) {
            int i2 = iF2 + cdbVarF2.b;
            i = ((ByteBuffer) cdbVarF2.e).getInt(((ByteBuffer) cdbVarF2.e).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(e(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
