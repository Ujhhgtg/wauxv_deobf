package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cnv {
    public static final cnu Companion = new cnu();
    public final int a;
    public final ddv b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final Long h;

    public /* synthetic */ cnv(int i, int i2, ddv ddvVar, int i3, int i4, int i5, int i6, int i7, Long l) {
        if (255 != (i & Opcodes.CONST_METHOD_TYPE)) {
            bht.ah(i, Opcodes.CONST_METHOD_TYPE, cnt.b.getDescriptor());
            throw null;
        }
        this.a = i2;
        this.b = ddvVar;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = i7;
        this.h = l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cnv)) {
            return false;
        }
        cnv cnvVar = (cnv) obj;
        return this.a == cnvVar.a && nullSafeIsEqual(this.b, cnvVar.b) && this.c == cnvVar.c && this.d == cnvVar.d
                && this.e == cnvVar.e && this.f == cnvVar.f && this.g == cnvVar.g && nullSafeIsEqual(this.h, cnvVar.h);
    }

    public final int hashCode() {
        int iA = dts.a(this.g, dts.a(this.f,
                dts.a(this.e, dts.a(this.d,
                        dts.a(this.c, (this.b.hashCode() + (Integer.hashCode(this.a) * 31)) * 31, 31), 31), 31),
                31), 31);
        Long l = this.h;
        return iA + (l == null ? 0 : l.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MicroMsgResponseNew(ret=" /* cnb.z(-130996502526762L) */);
        dkz.ac(sb, this.a, -130889128344362L);
        sb.append(this.b);
        sb.append(", msgId=" /* cnb.z(-131361574746922L) */);
        dkz.ac(sb, this.c, -131340099910442L);
        dkz.ac(sb, this.d, -131258495531818L);
        dkz.ac(sb, this.e, -131249905597226L);
        dkz.ac(sb, this.f, -131172596185898L);
        dkz.ac(sb, this.g, -131138236447530L);
        sb.append(this.h);
        sb.append(')');
        return sb.toString();
    }
}
