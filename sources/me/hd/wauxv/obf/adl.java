package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adl {
    public static final SparseIntArray a;
    public int aa;
    public int ab;
    public float ac;
    public int ad;
    public int ae;
    public int af;
    public int ag;
    public int ah;
    public int ai;
    public int aj;
    public int ak;
    public int al;
    public int am;
    public int an;
    public int ao;
    public int ap;
    public int aq;
    public int ar;
    public int as;
    public int at;
    public float au;
    public float av;
    public int aw;
    public int ax;
    public int ay;
    public int az;
    public boolean b;
    public int ba;
    public int bb;
    public int bc;
    public int bd;
    public float be;
    public float bf;
    public int bg;
    public int bh;
    public int bi;
    public int[] bj;
    public String bk;
    public String bl;
    public boolean bm;
    public boolean bn;
    public boolean bo;
    public int bp;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public float x;
    public float y;
    public String z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        a = sparseIntArray;
        sparseIntArray.append(43, 24);
        sparseIntArray.append(44, 25);
        sparseIntArray.append(46, 28);
        sparseIntArray.append(47, 29);
        sparseIntArray.append(52, 35);
        sparseIntArray.append(51, 34);
        sparseIntArray.append(24, 4);
        sparseIntArray.append(23, 3);
        sparseIntArray.append(19, 1);
        sparseIntArray.append(61, 6);
        sparseIntArray.append(62, 7);
        sparseIntArray.append(31, 17);
        sparseIntArray.append(32, 18);
        sparseIntArray.append(33, 19);
        sparseIntArray.append(15, 90);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(48, 31);
        sparseIntArray.append(49, 32);
        sparseIntArray.append(30, 10);
        sparseIntArray.append(29, 9);
        sparseIntArray.append(66, 13);
        sparseIntArray.append(69, 16);
        sparseIntArray.append(67, 14);
        sparseIntArray.append(64, 11);
        sparseIntArray.append(68, 15);
        sparseIntArray.append(65, 12);
        sparseIntArray.append(55, 38);
        sparseIntArray.append(41, 37);
        sparseIntArray.append(40, 39);
        sparseIntArray.append(54, 40);
        sparseIntArray.append(39, 20);
        sparseIntArray.append(53, 36);
        sparseIntArray.append(28, 5);
        sparseIntArray.append(42, 91);
        sparseIntArray.append(50, 91);
        sparseIntArray.append(45, 91);
        sparseIntArray.append(22, 91);
        sparseIntArray.append(18, 91);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(56, 41);
        sparseIntArray.append(34, 42);
        sparseIntArray.append(17, 87);
        sparseIntArray.append(16, 88);
        sparseIntArray.append(71, 76);
        sparseIntArray.append(25, 61);
        sparseIntArray.append(27, 62);
        sparseIntArray.append(26, 63);
        sparseIntArray.append(60, 69);
        sparseIntArray.append(38, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
        sparseIntArray.append(58, 84);
        sparseIntArray.append(59, 86);
        sparseIntArray.append(58, 83);
        sparseIntArray.append(37, 85);
        sparseIntArray.append(56, 87);
        sparseIntArray.append(34, 88);
        sparseIntArray.append(91, 89);
        sparseIntArray.append(15, 90);
    }

    public final void bq(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxx.e);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            SparseIntArray sparseIntArray = a;
            int i2 = sparseIntArray.get(index);
            switch (i2) {
                case 1:
                    this.q = adp.i(typedArrayObtainStyledAttributes, index, this.q);
                    break;
                case 2:
                    this.aj = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.aj);
                    break;
                case 3:
                    this.p = adp.i(typedArrayObtainStyledAttributes, index, this.p);
                    break;
                case 4:
                    this.o = adp.i(typedArrayObtainStyledAttributes, index, this.o);
                    break;
                case 5:
                    this.z = typedArrayObtainStyledAttributes.getString(index);
                    break;
                case 6:
                    this.ad = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.ad);
                    break;
                case 7:
                    this.ae = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.ae);
                    break;
                case 8:
                    this.ak = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ak);
                    break;
                case 9:
                    this.w = adp.i(typedArrayObtainStyledAttributes, index, this.w);
                    break;
                case 10:
                    this.v = adp.i(typedArrayObtainStyledAttributes, index, this.v);
                    break;
                case 11:
                    this.aq = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.aq);
                    break;
                case 12:
                    this.ar = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ar);
                    break;
                case 13:
                    this.an = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.an);
                    break;
                case 14:
                    this.ap = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ap);
                    break;
                case 15:
                    this.as = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.as);
                    break;
                case 16:
                    this.ao = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ao);
                    break;
                case 17:
                    this.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                    break;
                case 18:
                    this.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                    break;
                case 19:
                    this.g = typedArrayObtainStyledAttributes.getFloat(index, this.g);
                    break;
                case 20:
                    this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                    break;
                case 21:
                    this.d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.d);
                    break;
                case 22:
                    this.c = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.c);
                    break;
                case 23:
                    this.ag = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ag);
                    break;
                case 24:
                    this.i = adp.i(typedArrayObtainStyledAttributes, index, this.i);
                    break;
                case 25:
                    this.j = adp.i(typedArrayObtainStyledAttributes, index, this.j);
                    break;
                case 26:
                    this.af = typedArrayObtainStyledAttributes.getInt(index, this.af);
                    break;
                case 27:
                    this.ah = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ah);
                    break;
                case 28:
                    this.k = adp.i(typedArrayObtainStyledAttributes, index, this.k);
                    break;
                case 29:
                    this.l = adp.i(typedArrayObtainStyledAttributes, index, this.l);
                    break;
                case 30:
                    this.al = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.al);
                    break;
                case 31:
                    this.t = adp.i(typedArrayObtainStyledAttributes, index, this.t);
                    break;
                case 32:
                    this.u = adp.i(typedArrayObtainStyledAttributes, index, this.u);
                    break;
                case 33:
                    this.ai = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ai);
                    break;
                case 34:
                    this.n = adp.i(typedArrayObtainStyledAttributes, index, this.n);
                    break;
                case 35:
                    this.m = adp.i(typedArrayObtainStyledAttributes, index, this.m);
                    break;
                case 36:
                    this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
                    break;
                case 37:
                    this.av = typedArrayObtainStyledAttributes.getFloat(index, this.av);
                    break;
                case 38:
                    this.au = typedArrayObtainStyledAttributes.getFloat(index, this.au);
                    break;
                case 39:
                    this.aw = typedArrayObtainStyledAttributes.getInt(index, this.aw);
                    break;
                case 40:
                    this.ax = typedArrayObtainStyledAttributes.getInt(index, this.ax);
                    break;
                case 41:
                    adp.j(this, typedArrayObtainStyledAttributes, index, 0);
                    break;
                case 42:
                    adp.j(this, typedArrayObtainStyledAttributes, index, 1);
                    break;
                default:
                    switch (i2) {
                        case 61:
                            this.aa = adp.i(typedArrayObtainStyledAttributes, index, this.aa);
                            break;
                        case 62:
                            this.ab = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ab);
                            break;
                        case 63:
                            this.ac = typedArrayObtainStyledAttributes.getFloat(index, this.ac);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    this.be = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    this.bf = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    this.bg = typedArrayObtainStyledAttributes.getInt(index, this.bg);
                                    break;
                                case 73:
                                    this.bh = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bh);
                                    break;
                                case 74:
                                    this.bk = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 75:
                                    this.bo = typedArrayObtainStyledAttributes.getBoolean(index, this.bo);
                                    break;
                                case 76:
                                    this.bp = typedArrayObtainStyledAttributes.getInt(index, this.bp);
                                    break;
                                case 77:
                                    this.r = adp.i(typedArrayObtainStyledAttributes, index, this.r);
                                    break;
                                case 78:
                                    this.s = adp.i(typedArrayObtainStyledAttributes, index, this.s);
                                    break;
                                case 79:
                                    this.at = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.at);
                                    break;
                                case 80:
                                    this.am = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.am);
                                    break;
                                case 81:
                                    this.ay = typedArrayObtainStyledAttributes.getInt(index, this.ay);
                                    break;
                                case 82:
                                    this.az = typedArrayObtainStyledAttributes.getInt(index, this.az);
                                    break;
                                case 83:
                                    this.bb = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bb);
                                    break;
                                case 84:
                                    this.ba = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.ba);
                                    break;
                                case 85:
                                    this.bd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bd);
                                    break;
                                case 86:
                                    this.bc = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.bc);
                                    break;
                                case 87:
                                    this.bm = typedArrayObtainStyledAttributes.getBoolean(index, this.bm);
                                    break;
                                case 88:
                                    this.bn = typedArrayObtainStyledAttributes.getBoolean(index, this.bn);
                                    break;
                                case 89:
                                    this.bl = typedArrayObtainStyledAttributes.getString(index);
                                    break;
                                case 90:
                                    this.h = typedArrayObtainStyledAttributes.getBoolean(index, this.h);
                                    break;
                                case 91:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
