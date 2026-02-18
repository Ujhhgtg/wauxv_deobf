package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.util.Log;
import com.android.dx.io.Opcodes;
import com.umeng.analytics.pro.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmg {
    public int[] a;
    public final io c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public final int[] j;
    public int k;
    public bhi l;
    public Bitmap m;
    public final boolean n;
    public int o;
    public final int p;
    public final int q;
    public final int r;
    public Boolean s;
    public final int[] b = new int[256];
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public dmg(io ioVar, bhi bhiVar, ByteBuffer byteBuffer, int i) {
        this.c = ioVar;
        this.l = new bhi();
        synchronized (this) {
            try {
                if (i <= 0) {
                    throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
                }
                int iHighestOneBit = Integer.highestOneBit(i);
                this.o = 0;
                this.l = bhiVar;
                this.k = -1;
                ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.d = byteBufferAsReadOnlyBuffer;
                byteBufferAsReadOnlyBuffer.position(0);
                this.d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                Iterator it = bhiVar.e.iterator();
                while (it.hasNext()) {
                    if (((bhd) it.next()).g == 3) {
                        this.n = true;
                        break;
                    }
                }
                this.p = iHighestOneBit;
                int i2 = bhiVar.f;
                this.r = i2 / iHighestOneBit;
                int i3 = bhiVar.g;
                this.q = i3 / iHighestOneBit;
                int i4 = i2 * i3;
                bva bvaVar = (bva) this.c.d;
                this.i = bvaVar == null ? new byte[i4] : (byte[]) bvaVar.i(i4, byte[].class);
                io ioVar2 = this.c;
                int i5 = this.r * this.q;
                bva bvaVar2 = (bva) ioVar2.d;
                this.j = bvaVar2 == null ? new int[i5] : (int[]) bvaVar2.i(i5, int[].class);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Bitmap u() {
        Boolean bool = this.s;
        Bitmap bitmapN = ((oz) this.c.c).n(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapN.setHasAlpha(true);
        return bitmapN;
    }

    public final synchronized Bitmap v() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                if (Log.isLoggable("ᛱᛲᛲᛸᲀ", 3)) {
                    Log.d("ᛱᛲᛲᛸᲀ", "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k);
                }
                this.o = 1;
            }
            int i = this.o;
            if (i != 1 && i != 2) {
                this.o = 0;
                if (this.e == null) {
                    bva bvaVar = (bva) this.c.d;
                    this.e = bvaVar == null ? new byte[Opcodes.CONST_METHOD_TYPE] : (byte[]) bvaVar.i(Opcodes.CONST_METHOD_TYPE, byte[].class);
                }
                bhd bhdVar = (bhd) this.l.e.get(this.k);
                int i2 = this.k - 1;
                bhd bhdVar2 = i2 >= 0 ? (bhd) this.l.e.get(i2) : null;
                int[] iArr = bhdVar.k;
                if (iArr == null) {
                    iArr = this.l.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    if (Log.isLoggable("ᛱᛲᛲᛸᲀ", 3)) {
                        Log.d("ᛱᛲᛲᛸᲀ", "No valid color table found for frame #" + this.k);
                    }
                    this.o = 1;
                    return null;
                }
                if (bhdVar.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[bhdVar.h] = 0;
                    if (bhdVar.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return x(bhdVar, bhdVar2);
            }
            if (Log.isLoggable("ᛱᛲᛲᛸᲀ", 3)) {
                Log.d("ᛱᛲᛲᛸᲀ", "Unable to decode frame, status=" + this.o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void w(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX WARN: Found duplicated region for block: B:26:0x0047  */
    /* JADX WARN: Found duplicated region for block: B:98:0x01dc A[PHI: r5
      0x01dc: PHI (r5v24 int) = (r5v18 int), (r5v26 int), (r5v26 int) binds: [B:93:0x01c8, B:95:0x01d3, B:96:0x01d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v31, types: [short] */
    /* JADX WARN: Type inference failed for: r6v33 */
    public final Bitmap x(bhd bhdVar, bhd bhdVar2) {
        int[] iArr;
        byte b;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr2;
        int i6;
        short[] sArr;
        int i7;
        short s;
        int i8;
        Bitmap bitmap;
        int i9;
        io ioVar = this.c;
        byte b2 = 0;
        int[] iArr3 = this.j;
        if (bhdVar2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                ((oz) ioVar.c).p(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr3, 0);
        }
        if (bhdVar2 != null && bhdVar2.g == 3 && this.m == null) {
            Arrays.fill(iArr3, 0);
        }
        if (bhdVar2 != null && (i8 = bhdVar2.g) > 0) {
            if (i8 == 2) {
                if (bhdVar.f) {
                    i9 = 0;
                } else {
                    bhi bhiVar = this.l;
                    i9 = bhiVar.k;
                    if (bhdVar.k != null && bhiVar.j == bhdVar.h) {
                        i9 = 0;
                    }
                }
                int i10 = bhdVar2.d;
                int i11 = this.p;
                int i12 = i10 / i11;
                int i13 = bhdVar2.b / i11;
                int i14 = bhdVar2.c / i11;
                int i15 = bhdVar2.a / i11;
                int i16 = this.r;
                int i17 = (i13 * i16) + i15;
                int i18 = (i12 * i16) + i17;
                while (i17 < i18) {
                    int i19 = i17 + i14;
                    for (int i20 = i17; i20 < i19; i20++) {
                        iArr3[i20] = i9;
                    }
                    i17 += this.r;
                }
            } else if (i8 == 3 && (bitmap = this.m) != null) {
                int i21 = this.q;
                int i22 = this.r;
                bitmap.getPixels(iArr3, 0, i22, 0, 0, i22, i21);
            }
        }
        this.d.position(bhdVar.j);
        int i23 = bhdVar.c * bhdVar.d;
        byte[] bArr = this.i;
        if (bArr == null || bArr.length < i23) {
            bva bvaVar = (bva) ioVar.d;
            this.i = bvaVar == null ? new byte[i23] : (byte[]) bvaVar.i(i23, byte[].class);
        }
        byte[] bArr2 = this.i;
        if (this.f == null) {
            this.f = new short[4096];
        }
        short[] sArr2 = this.f;
        if (this.g == null) {
            this.g = new byte[4096];
        }
        byte[] bArr3 = this.g;
        if (this.h == null) {
            this.h = new byte[q.a.a];
        }
        byte[] bArr4 = this.h;
        int i24 = this.d.get() & 255;
        int i25 = 1;
        int i26 = 1 << i24;
        int i27 = i26 + 1;
        int i28 = i26 + 2;
        int i29 = i24 + 1;
        int i30 = (1 << i29) - 1;
        int i31 = 0;
        while (i31 < i26) {
            sArr2[i31] = 0;
            bArr3[i31] = (byte) i31;
            i31++;
            i25 = i25;
        }
        int i32 = i25;
        byte[] bArr5 = this.e;
        int i33 = 0;
        int i34 = 0;
        int i35 = 0;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = i29;
        int i42 = i28;
        int i43 = i30;
        int i44 = -1;
        while (true) {
            if (i33 >= i23) {
                iArr = iArr3;
                b = b2;
                break;
            }
            if (i34 == 0) {
                i7 = -1;
                int i45 = this.d.get() & 255;
                if (i45 <= 0) {
                    sArr = sArr2;
                    iArr = iArr3;
                } else {
                    ByteBuffer byteBuffer = this.d;
                    sArr = sArr2;
                    iArr = iArr3;
                    byteBuffer.get(this.e, 0, Math.min(i45, byteBuffer.remaining()));
                }
                if (i45 <= 0) {
                    this.o = 3;
                    b = 0;
                    break;
                }
                i34 = i45;
                i35 = 0;
            } else {
                sArr = sArr2;
                iArr = iArr3;
                i7 = -1;
            }
            i37 += (bArr5[i35] & 255) << i36;
            i35++;
            i34--;
            int i46 = i36 + 8;
            int i47 = i42;
            int i48 = i41;
            int i49 = i44;
            int i50 = i39;
            while (true) {
                i36 = i46;
                if (i46 < i48) {
                    i44 = i49;
                    i39 = i50;
                    i41 = i48;
                    iArr3 = iArr;
                    b2 = 0;
                    i42 = i47;
                    sArr2 = sArr;
                    break;
                }
                int i51 = i37 & i43;
                i37 >>= i48;
                i36 -= i48;
                if (i51 == i26) {
                    i48 = i29;
                    i47 = i28;
                    i43 = i30;
                    i46 = i36;
                    i49 = i7;
                } else {
                    if (i51 == i27) {
                        i42 = i47;
                        i41 = i48;
                        i44 = i49;
                        i39 = i50;
                        sArr2 = sArr;
                        iArr3 = iArr;
                        b2 = 0;
                        break;
                    }
                    int i52 = i48;
                    if (i49 == i7) {
                        bArr2[i38] = bArr3[i51];
                        i38++;
                        i33++;
                        i49 = i51;
                        i50 = i49;
                        i46 = i36;
                        i48 = i52;
                    } else {
                        if (i51 >= i47) {
                            bArr4[i40] = (byte) i50;
                            i40++;
                            s = i49;
                        } else {
                            s = i51;
                        }
                        while (s >= i26) {
                            bArr4[i40] = bArr3[s];
                            i40++;
                            s = sArr[s];
                        }
                        i50 = bArr3[s] & 255;
                        byte b3 = (byte) i50;
                        bArr2[i38] = b3;
                        while (true) {
                            i38++;
                            i33++;
                            if (i40 <= 0) {
                                break;
                            }
                            i40--;
                            bArr2[i38] = bArr4[i40];
                        }
                        if (i47 < 4096) {
                            sArr[i47] = (short) i49;
                            bArr3[i47] = b3;
                            i47++;
                            if ((i47 & i43) != 0 || i47 >= 4096) {
                                i48 = i52;
                            } else {
                                i48 = i52 + 1;
                                i43 += i47;
                            }
                        } else {
                            i48 = i52;
                        }
                        i46 = i36;
                        i49 = i51;
                    }
                    i7 = -1;
                }
            }
        }
        Arrays.fill(bArr2, i38, i23, b);
        if (bhdVar.e || this.p != i32) {
            int i53 = bhdVar.d;
            int i54 = this.p;
            int i55 = i53 / i54;
            int i56 = bhdVar.b / i54;
            int i57 = bhdVar.c / i54;
            int i58 = bhdVar.a / i54;
            boolean z = this.k == 0;
            byte[] bArr6 = this.i;
            int[] iArr4 = this.a;
            Boolean bool = this.s;
            int i59 = 8;
            int i60 = 0;
            int i61 = 1;
            int i62 = 0;
            while (i62 < i55) {
                if (bhdVar.e) {
                    if (i60 >= i55) {
                        i61++;
                        if (i61 == 2) {
                            i60 = 4;
                        } else if (i61 == 3) {
                            i59 = 4;
                            i60 = 2;
                        } else if (i61 == 4) {
                            i60 = 1;
                            i59 = 2;
                        }
                    }
                    i = i60 + i59;
                } else {
                    i = i60;
                    i60 = i62;
                }
                int i63 = i60 + i56;
                int i64 = i55;
                boolean z2 = i54 == 1;
                if (i63 < this.q) {
                    int i65 = this.r;
                    int i66 = i63 * i65;
                    int i67 = i66 + i58;
                    i3 = i56;
                    int i68 = i67 + i57;
                    int i69 = i66 + i65;
                    if (i69 < i68) {
                        i68 = i69;
                    }
                    i4 = i57;
                    int i70 = i62 * i54 * bhdVar.c;
                    int[] iArr5 = this.j;
                    if (z2) {
                        while (i67 < i68) {
                            int i71 = i67;
                            int i72 = iArr4[bArr6[i70] & 255];
                            if (i72 != 0) {
                                iArr5[i71] = i72;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i70 += i54;
                            i67 = i71 + 1;
                        }
                    } else {
                        int iB = yg.b(i68, i67, i54, i70);
                        while (i67 < i68) {
                            int i73 = i67;
                            int i74 = bhdVar.c;
                            int i75 = i54;
                            int i76 = i70;
                            int i77 = 0;
                            int i78 = 0;
                            int i79 = 0;
                            int i80 = 0;
                            int i81 = 0;
                            while (true) {
                                if (i76 >= this.p + i70) {
                                    i5 = i68;
                                    break;
                                }
                                byte[] bArr7 = this.i;
                                i5 = i68;
                                if (i76 >= bArr7.length || i76 >= iB) {
                                    break;
                                }
                                int i82 = this.a[bArr7[i76] & 255];
                                if (i82 != 0) {
                                    i77 += (i82 >> 24) & Opcodes.CONST_METHOD_TYPE;
                                    i78 += (i82 >> 16) & Opcodes.CONST_METHOD_TYPE;
                                    i79 += (i82 >> 8) & Opcodes.CONST_METHOD_TYPE;
                                    i80 += i82 & Opcodes.CONST_METHOD_TYPE;
                                    i81++;
                                }
                                i76++;
                                i68 = i5;
                            }
                            int i83 = i70 + i74;
                            int i84 = i83;
                            while (i84 < this.p + i83) {
                                byte[] bArr8 = this.i;
                                int i85 = i83;
                                if (i84 >= bArr8.length || i84 >= iB) {
                                    break;
                                }
                                int i86 = this.a[bArr8[i84] & 255];
                                if (i86 != 0) {
                                    i77 += (i86 >> 24) & Opcodes.CONST_METHOD_TYPE;
                                    i78 += (i86 >> 16) & Opcodes.CONST_METHOD_TYPE;
                                    i79 += (i86 >> 8) & Opcodes.CONST_METHOD_TYPE;
                                    i80 += i86 & Opcodes.CONST_METHOD_TYPE;
                                    i81++;
                                }
                                i84++;
                                i83 = i85;
                            }
                            int i87 = i81 == 0 ? 0 : ((i77 / i81) << 24) | ((i78 / i81) << 16) | ((i79 / i81) << 8) | (i80 / i81);
                            if (i87 != 0) {
                                iArr5[i73] = i87;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i70 += i75;
                            i67 = i73 + 1;
                            i54 = i75;
                            i68 = i5;
                        }
                    }
                    i2 = i54;
                } else {
                    i2 = i54;
                    i3 = i56;
                    i4 = i57;
                }
                i62++;
                i60 = i;
                i55 = i64;
                i57 = i4;
                i56 = i3;
                i54 = i2;
            }
            if (this.s == null) {
                this.s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
            }
        } else {
            int i88 = bhdVar.d;
            int i89 = bhdVar.b;
            int i90 = bhdVar.c;
            int i91 = bhdVar.a;
            byte b4 = this.k == 0 ? (byte) 1 : b;
            byte[] bArr9 = this.i;
            int[] iArr6 = this.a;
            byte b5 = -1;
            for (int i92 = b; i92 < i88; i92++) {
                int i93 = this.r;
                int i94 = (i92 + i89) * i93;
                int i95 = i94 + i91;
                int i96 = i95 + i90;
                int i97 = i94 + i93;
                if (i97 < i96) {
                    i96 = i97;
                }
                int i98 = bhdVar.c * i92;
                while (i95 < i96) {
                    byte b6 = bArr9[i98];
                    int i99 = b6 & 255;
                    if (i99 != b5) {
                        int i100 = iArr6[i99];
                        if (i100 != 0) {
                            this.j[i95] = i100;
                        } else {
                            b5 = b6;
                        }
                    }
                    i98++;
                    i95++;
                }
            }
            Boolean bool2 = this.s;
            this.s = Boolean.valueOf((bool2 != null && bool2.booleanValue()) || !(this.s != null || b4 == 0 || b5 == -1));
        }
        if (this.n && ((i6 = bhdVar.g) == 0 || i6 == 1)) {
            if (this.m == null) {
                this.m = u();
            }
            Bitmap bitmap3 = this.m;
            int i101 = this.q;
            int i102 = this.r;
            iArr2 = iArr;
            bitmap3.setPixels(iArr2, 0, i102, 0, 0, i102, i101);
        } else {
            iArr2 = iArr;
        }
        Bitmap bitmapU = u();
        int i103 = this.q;
        int i104 = this.r;
        bitmapU.setPixels(iArr2, 0, i104, 0, 0, i104, i103);
        return bitmapU;
    }
}
