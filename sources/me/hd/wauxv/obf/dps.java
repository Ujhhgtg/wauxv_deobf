package me.hd.wauxv.obf;

import com.umeng.analytics.pro.q;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dps {
    public final dpr a;
    public int aa;
    public int ab;
    public int ac;
    public final dpr b;
    public final dpr c;
    public final dpr d;
    public final dpr e;
    public final dpr f;
    public final dpr g;
    public final dpr h;
    public final dpr i;
    public final dpr j;
    public final dpr k;
    public final dpr l;
    public final dpr m;
    public final dpr n;
    public final dpr o;
    public final dpr p;
    public final dpr q;
    public final dpr r;
    public final dpr s;
    public final dpr t;
    public final dpr[] u;
    public int v;
    public int w;
    public byte[] x;
    public int y;
    public int z;

    public dps() {
        dpr dprVar = new dpr(0);
        this.a = dprVar;
        dpr dprVar2 = new dpr(1);
        this.b = dprVar2;
        dpr dprVar3 = new dpr(2);
        this.c = dprVar3;
        dpr dprVar4 = new dpr(3);
        this.d = dprVar4;
        dpr dprVar5 = new dpr(4);
        this.e = dprVar5;
        dpr dprVar6 = new dpr(5);
        this.f = dprVar6;
        dpr dprVar7 = new dpr(6);
        this.g = dprVar7;
        dpr dprVar8 = new dpr(7);
        this.h = dprVar8;
        dpr dprVar9 = new dpr(8);
        this.i = dprVar9;
        dpr dprVar10 = new dpr(4096);
        this.j = dprVar10;
        dpr dprVar11 = new dpr(q.a.cachedConstructors);
        this.k = dprVar11;
        dpr dprVar12 = new dpr(q.a.second);
        this.l = dprVar12;
        dpr dprVar13 = new dpr(q.a.c);
        this.m = dprVar13;
        dpr dprVar14 = new dpr(8192);
        this.n = dprVar14;
        dpr dprVar15 = new dpr(q.a.r);
        this.o = dprVar15;
        dpr dprVar16 = new dpr(q.a.s);
        this.p = dprVar16;
        dpr dprVar17 = new dpr(q.a.t);
        this.q = dprVar17;
        dpr dprVar18 = new dpr(q.a.u);
        this.r = dprVar18;
        dpr dprVar19 = new dpr(q.a.v);
        this.s = dprVar19;
        dpr dprVar20 = new dpr(8198);
        this.t = dprVar20;
        this.u = new dpr[] { dprVar, dprVar2, dprVar3, dprVar4, dprVar5, dprVar6, dprVar7, dprVar10, dprVar8, dprVar9,
                dprVar11, dprVar12, dprVar13, dprVar14, dprVar15, dprVar16, dprVar17, dprVar18, dprVar19, dprVar20 };
        this.x = new byte[20];
    }

    public final void ad() {
        int i = this.ac + this.ab;
        dpr[] dprVarArr = this.u;
        for (int length = dprVarArr.length - 1; length >= 0; length--) {
            dpr dprVar = dprVarArr[length];
            int i2 = dprVar.c;
            if (i2 != -1) {
                if (i2 > i) {
                    throw new amo("Map is unsorted at " + dprVar, null);
                }
                dprVar.d = i - i2;
                i = i2;
            }
        }
    }

    public final void ae(amk amkVar) {
        dpr dprVar;
        int i;
        byte[] bArr = new byte[8];
        ByteBuffer byteBuffer = amkVar.n(0).b;
        byteBuffer.get(bArr);
        if (ewz.an(bArr) <= 0) {
            throw new amo(
                    String.format("Unexpected magic: [0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x, 0x%02x]",
                            Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]),
                            Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]), Byte.valueOf(bArr[6]), Byte.valueOf(bArr[7])),
                    null);
        }
        this.v = ewz.an(bArr);
        this.w = byteBuffer.getInt();
        byte[] bArr2 = new byte[20];
        byteBuffer.get(bArr2);
        this.x = bArr2;
        this.y = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        if (i2 != 112) {
            throw new amo("Unexpected header: 0x" + Integer.toHexString(i2), null);
        }
        int i3 = byteBuffer.getInt();
        if (i3 != 305419896) {
            throw new amo("Unexpected endian tag: 0x" + Integer.toHexString(i3), null);
        }
        this.z = byteBuffer.getInt();
        this.aa = byteBuffer.getInt();
        int i4 = byteBuffer.getInt();
        dpr dprVar2 = this.j;
        dprVar2.c = i4;
        if (i4 == 0) {
            throw new amo("Cannot merge dex files that do not contain a map", null);
        }
        int i5 = byteBuffer.getInt();
        dpr dprVar3 = this.b;
        dprVar3.b = i5;
        dprVar3.c = byteBuffer.getInt();
        int i6 = byteBuffer.getInt();
        dpr dprVar4 = this.c;
        dprVar4.b = i6;
        dprVar4.c = byteBuffer.getInt();
        int i7 = byteBuffer.getInt();
        dpr dprVar5 = this.d;
        dprVar5.b = i7;
        dprVar5.c = byteBuffer.getInt();
        int i8 = byteBuffer.getInt();
        dpr dprVar6 = this.e;
        dprVar6.b = i8;
        dprVar6.c = byteBuffer.getInt();
        int i9 = byteBuffer.getInt();
        dpr dprVar7 = this.f;
        dprVar7.b = i9;
        dprVar7.c = byteBuffer.getInt();
        int i10 = byteBuffer.getInt();
        dpr dprVar8 = this.g;
        dprVar8.b = i10;
        dprVar8.c = byteBuffer.getInt();
        this.ab = byteBuffer.getInt();
        this.ac = byteBuffer.getInt();
        ByteBuffer byteBuffer2 = amkVar.n(dprVar2.c).b;
        int i11 = byteBuffer2.getInt();
        int i12 = 0;
        dpr dprVar9 = null;
        while (true) {
            dpr[] dprVarArr = this.u;
            if (i12 >= i11) {
                Arrays.sort(dprVarArr);
                ad();
                return;
            }
            short s = byteBuffer2.getShort();
            byteBuffer2.getShort();
            int length = dprVarArr.length;
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    throw new IllegalArgumentException(concatVar2Var1(s, "No such map item: "));
                }
                dprVar = dprVarArr[i13];
                if (dprVar.a == s) {
                    break;
                } else {
                    i13++;
                }
            }
            int i14 = byteBuffer2.getInt();
            int i15 = byteBuffer2.getInt();
            int i16 = dprVar.b;
            if ((i16 != 0 && i16 != i14) || ((i = dprVar.c) != -1 && i != i15)) {
                throw new amo("Unexpected map value for 0x" + Integer.toHexString(s), null);
            }
            dprVar.b = i14;
            dprVar.c = i15;
            if (dprVar9 != null && dprVar9.c > i15) {
                throw new amo("Map is unsorted at " + dprVar9 + ", " + dprVar, null);
            }
            i12++;
            dprVar9 = dprVar;
        }
    }
}
