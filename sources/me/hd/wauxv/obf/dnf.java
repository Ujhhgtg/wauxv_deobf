package me.hd.wauxv.obf;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dnf extends dqc {
    public final String value;
    public MatchTypeEnum matchType;
    public final boolean d;

    public dnf(String value, MatchTypeEnum matchType, boolean z) {
        throwIfVar1IsNull(value, "value");
        throwIfVar1IsNull(matchType, "matchType");
        this.value = value;
        this.matchType = matchType;
        this.d = z;
    }

    @Override // me.hd.wauxv.obf.dqc
    public final int c(bbb bbbVar) {
        throwIfVar1IsNull(bbbVar, "fbb");
        String str = this.value;
        if (str == null) {
            throw new IllegalArgumentException("value must not be null");
        }
        if (str.length() == 0) {
            MatchTypeEnum matchTypeEnumVar = this.matchType;
            MatchTypeEnum matchTypeEnumVar2 = MatchTypeEnum.Equals;
            if (matchTypeEnumVar != matchTypeEnumVar2) {
                this.matchType = matchTypeEnumVar2;
            }
        }
        int iS = bbbVar.s(str);
        byte b = this.matchType.d;
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
