package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnf extends dqc {
    public final String a;
    public dne b;
    public final boolean d;

    public dnf(String str, dne dneVar, boolean z) {
        throwIfVar1IsNull(str, "value");
        throwIfVar1IsNull(dneVar, "matchType");
        this.a = str;
        this.b = dneVar;
        this.d = z;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        String str = this.a;
        if (str == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        if (str.length() == 0) {
            dne dneVar = this.b;
            dne dneVar2 = dne.Equals;
            if (dneVar != dneVar2) {
                this.b = dneVar2;
            }
        }
        int iS = bbbVar.s(str);
        byte b = this.b.d;
        bbbVar.ab(3);
        bbbVar.q(0, iS);
        boolean z = this.d;
        if (z) {
            bbbVar.y(1, 0);
            ByteBuffer byteBuffer = bbbVar.a;
            int i = bbbVar.b - 1;
            bbbVar.b = i;
            byteBuffer.put(i, z ? (byte) 1 : (byte) 0);
            bbbVar.aa(2);
        } else {
            bbbVar.getClass();
        }
        bbbVar.o(b, 1);
        int iU = bbbVar.u();
        bbbVar.w(iU);
        return iU;
    }
}
