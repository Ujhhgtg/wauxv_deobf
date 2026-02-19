package me.hd.wauxv.obf;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ayd implements SharedPreferences, SharedPreferences.Editor {
    public static final byte[] a = new byte[0];
    public static final int[] b = {0, 1, 4, 4, 8, 8};
    public static final int c;
    public int aa;
    public final String d;
    public final String e;
    public final HashMap f;
    public final ewo g;
    public int h;
    public long i;
    public ik l;
    public int m;
    public int n;
    public int r;
    public FileChannel v;
    public FileChannel w;
    public MappedByteBuffer x;
    public MappedByteBuffer y;
    public int z;
    public final HashMap j = new HashMap();
    public volatile boolean k = false;
    public final ArrayList o = new ArrayList();
    public boolean p = false;
    public final buv q = new buv();
    public final ArrayList s = new ArrayList();
    public final ArrayList t = new ArrayList();
    public final Handler u = new Handler(Looper.getMainLooper());
    public boolean ab = true;

    static {
        int iIntValue;
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", null);
            declaredMethod.setAccessible(true);
            iIntValue = ((Integer) declaredMethod.invoke(declaredField.get(null), null)).intValue();
        } catch (Throwable unused) {
            iIntValue = 16384;
        }
        c = iIntValue;
    }

    public ayd(String str, String str2, dni[] dniVarArr, ewo ewoVar, int i) {
        this.d = str;
        this.e = str2;
        this.g = ewoVar;
        this.aa = i;
        HashMap map = new HashMap();
        if (dniVarArr != null) {
            for (dni dniVar : dniVarArr) {
                dniVar.getClass();
                if (map.containsKey("StringSet")) {
                    bhv.v(this, "duplicate encoder tag:StringSet");
                } else {
                    map.put("StringSet", dniVar);
                }
            }
        }
        map.put("StringSet", dni.a);
        this.f = map;
        synchronized (this.j) {
            aye.s().execute(new ayb(this, 1));
            if (!this.k) {
                try {
                    this.j.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public static void ac(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    public final void ad(String str, Object obj, byte[] bArr, afb afbVar, byte b2) {
        if (afbVar == null) {
            int iAr = ar(str, bArr, b2);
            if (iAr > 0) {
                int length = bArr.length;
                this.j.put(str, b2 == 6 ? new afa(this.m, iAr, (String) obj, length, false) : b2 == 7 ? new aes(this.m, iAr, obj, length, false) : new aez(this.m, iAr, obj, length, false));
                ao();
                return;
            }
            return;
        }
        if (afbVar.l || afbVar.k != bArr.length) {
            int iAr2 = ar(str, bArr, afbVar.a());
            if (iAr2 > 0) {
                String str2 = afbVar.l ? (String) afbVar.i : null;
                al(afbVar.a(), afbVar.j, afbVar.b + afbVar.k);
                afbVar.j = this.m;
                afbVar.b = iAr2;
                afbVar.l = false;
                afbVar.i = obj;
                afbVar.k = bArr.length;
                ao();
                if (this.r >= 8192 || this.s.size() >= 100) {
                    dqc.bb(this, 0);
                }
                if (str2 != null) {
                    if (this.aa == 0) {
                        aye.s().execute(new hl(this, 4, str2));
                        return;
                    } else {
                        this.o.add(str2);
                        return;
                    }
                }
                return;
            }
            return;
        }
        int i = afbVar.b;
        int length2 = bArr.length;
        this.i ^= this.l.l(i, length2);
        ik ikVar = this.l;
        ikVar.b = i;
        ikVar.x(bArr);
        long jL = this.i ^ this.l.l(i, length2);
        this.i = jL;
        if (this.aa == 0) {
            this.x.putInt(0, -1);
            this.x.putLong(4, this.i);
            this.x.position(i);
            this.x.put(bArr);
            MappedByteBuffer mappedByteBuffer = this.x;
            int i2 = this.h - 12;
            if (this.g != null) {
                i2 |= 1073741824;
            }
            mappedByteBuffer.putInt(0, i2);
            this.y.putLong(4, this.i);
            this.y.position(i);
            this.y.put(bArr);
        } else {
            this.l.aa(4, jL);
        }
        afbVar.i = obj;
    }

    public final boolean ae() {
        int i = this.aa;
        if (i == 1) {
            this.q.execute(new ayb(this, 0));
            return true;
        }
        if (i == 2) {
            return FastKV.bj(this);
        }
        return true;
    }

    public final synchronized Object af(String str) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar != null && aetVar.a() == 8) {
            aez aezVar = (aez) aetVar;
            if (!aezVar.l) {
                return aezVar.i;
            }
            LinkedHashSet linkedHashSetAd = FastKV.ad(this, aezVar, this.g);
            if (linkedHashSetAd == null) {
                remove(str);
                return null;
            }
            aezVar.i = linkedHashSetAd;
            aezVar.l = false;
            return linkedHashSetAd;
        }
        return null;
    }

    public final void ag(String str) {
        if (this.aa != 0 && this.ab) {
            ae();
        }
        ah(str);
    }

    public final synchronized void ah(String str) {
        if (this.t.isEmpty()) {
            return;
        }
        Iterator it = this.t.iterator();
        while (it.hasNext()) {
            this.u.post(new ale(this, (SharedPreferences.OnSharedPreferenceChangeListener) it.next(), str, 3));
        }
    }

    public final void ai(byte b2, int i, int i2) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
        int i3 = i + 2 + i2;
        this.n = i3;
        int length = ((byte[]) this.l.d).length;
        int i4 = this.h + i3;
        if (i4 >= length) {
            int i5 = this.r;
            if (i5 <= i3 || i5 <= 8192) {
                int iAc = FastKV.ac(length, i4);
                byte[] bArr = new byte[iAc];
                System.arraycopy((byte[]) this.l.d, 0, bArr, 0, this.h);
                this.l.d = bArr;
                if (this.aa == 0) {
                    MappedByteBuffer mappedByteBufferAw = FastKV.aw(this.v, iAc);
                    MappedByteBuffer mappedByteBufferAw2 = FastKV.aw(this.w, iAc);
                    if (mappedByteBufferAw == null || mappedByteBufferAw2 == null) {
                        Log.e("FastKV", this.e, new Exception("map failed"));
                        int i6 = this.h - 12;
                        if (this.g != null) {
                            i6 |= 1073741824;
                        }
                        this.l.z(0, i6);
                        this.l.aa(4, this.i);
                        FastKV.be(this);
                    } else {
                        this.x = mappedByteBufferAw;
                        this.y = mappedByteBufferAw2;
                    }
                }
            } else {
                dqc.bb(this, i3);
            }
        }
        int i7 = this.h;
        this.m = i7;
        this.h = this.n + i7;
        ik ikVar = this.l;
        ikVar.b = i7;
        ikVar.w(b2);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public final synchronized void aj(String str, byte[] bArr) throws Throwable {
        Throwable th;
        try {
            try {
                ac(str);
            } catch (Throwable th2) {
                th = th2;
                th = th;
                throw th;
            }
            try {
                if (bArr == null) {
                    remove(str);
                } else {
                    aet aetVar = (aet) this.j.get(str);
                    if (aetVar != null && aetVar.a() != 7) {
                        remove(str);
                        aetVar = null;
                    }
                    aes aesVar = (aes) aetVar;
                    ewo ewoVar = this.g;
                    ad(str, bArr, ewoVar != null ? ewoVar.c(bArr) : bArr, aesVar, (byte) 7);
                    ag(str);
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public final synchronized void ak(String str, Object obj, dni dniVar) throws Throwable {
        Throwable th;
        byte[] bArrC;
        try {
            try {
                ac(str);
                if (dniVar == null) {
                    throw new IllegalArgumentException("Encoder is null");
                }
                if (!this.f.containsKey("StringSet")) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                }
                try {
                    if (obj == null) {
                        remove(str);
                        return;
                    }
                    aet aetVar = null;
                    try {
                        bArrC = dniVar.c(obj);
                    } catch (Exception e) {
                        Log.e("FastKV", this.e, e);
                        bArrC = null;
                    }
                    if (bArrC == null) {
                        remove(str);
                        return;
                    }
                    aet aetVar2 = (aet) this.j.get(str);
                    if (aetVar2 == null || aetVar2.a() == 8) {
                        aetVar = aetVar2;
                    } else {
                        remove(str);
                    }
                    aez aezVar = (aez) aetVar;
                    int iF = ik.f("StringSet");
                    ik ikVar = new ik(iF + 1 + bArrC.length);
                    ikVar.w((byte) iF);
                    ikVar.ab("StringSet");
                    ikVar.x(bArrC);
                    byte[] bArrC2 = (byte[]) ikVar.d;
                    ewo ewoVar = this.g;
                    if (ewoVar != null) {
                        bArrC2 = ewoVar.c(bArrC2);
                    }
                    byte[] bArr = bArrC2;
                    if (bArr == null) {
                        return;
                    }
                    ad(str, obj, bArr, aezVar, (byte) 8);
                    ag(str);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
        }
        throw th;
    }

    public final void al(byte b2, int i, int i2) {
        this.r = (i2 - i) + this.r;
        dfk dfkVar = new dfk();
        dfkVar.a = i;
        dfkVar.b = i2;
        this.s.add(dfkVar);
        byte b3 = (byte) (b2 | (-128));
        byte[] bArr = (byte[]) this.l.d;
        this.i = ((((long) (bArr[i] ^ b3)) & 255) << ((i & 7) << 3)) ^ this.i;
        bArr[i] = b3;
        this.z = i;
    }

    public final void am(MappedByteBuffer mappedByteBuffer) {
        mappedByteBuffer.putLong(4, this.i);
        int i = this.z;
        if (i != 0) {
            mappedByteBuffer.put(i, ((byte[]) this.l.d)[i]);
        }
        if (this.n != 0) {
            mappedByteBuffer.position(this.m);
            mappedByteBuffer.put((byte[]) this.l.d, this.m, this.n);
        }
    }

    public final void an(byte b2, int i) {
        long jBc = this.i ^ FastKV.bc(i, 1L);
        this.i = jBc;
        if (this.aa == 0) {
            this.x.putLong(4, jBc);
            this.x.put(i, b2);
            this.y.putLong(4, this.i);
            this.y.put(i, b2);
        } else {
            this.l.aa(4, jBc);
        }
        ((byte[]) this.l.d)[i] = b2;
    }

    public final void ao() {
        this.i ^= this.l.l(this.m, this.n);
        int i = this.h - 12;
        if (this.g != null) {
            i |= 1073741824;
        }
        if (this.aa == 0) {
            this.x.putInt(0, -1);
            am(this.x);
            this.x.putInt(0, i);
            this.y.putInt(0, i);
            am(this.y);
        } else {
            this.l.z(0, i);
            this.l.aa(4, this.i);
        }
        this.z = 0;
        this.n = 0;
    }

    public final void ap(int i, long j, int i2) {
        long jBc = FastKV.bc(i2, j) ^ this.i;
        this.i = jBc;
        if (this.aa == 0) {
            this.x.putLong(4, jBc);
            this.x.putInt(i2, i);
            this.y.putLong(4, this.i);
            this.y.putInt(i2, i);
        } else {
            this.l.aa(4, jBc);
        }
        this.l.z(i2, i);
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized void apply() {
        this.ab = true;
        ae();
    }

    public final void aq(long j, long j2, int i) {
        long jBc = FastKV.bc(i, j2) ^ this.i;
        this.i = jBc;
        if (this.aa == 0) {
            this.x.putLong(4, jBc);
            this.x.putLong(i, j);
            this.y.putLong(4, this.i);
            this.y.putLong(i, j);
        } else {
            this.l.aa(4, jBc);
        }
        this.l.aa(i, j);
    }

    public final int ar(String str, byte[] bArr, byte b2) {
        boolean z = bArr.length >= 65535;
        if (z) {
            if (b2 == 6) {
                b2 = 9;
            } else if (b2 == 7) {
                b2 = 10;
            } else if (b2 == 8) {
                b2 = 11;
            }
        }
        as(str, b2, (z ? 4 : 2) + bArr.length);
        if (z) {
            this.l.y(bArr.length);
        } else {
            ik ikVar = this.l;
            short length = (short) bArr.length;
            byte[] bArr2 = (byte[]) ikVar.d;
            int i = ikVar.b;
            int i2 = i + 1;
            ikVar.b = i2;
            bArr2[i] = (byte) length;
            ikVar.b = i + 2;
            bArr2[i2] = (byte) (length >> 8);
        }
        ik ikVar2 = this.l;
        int i3 = ikVar2.b;
        ikVar2.x(bArr);
        return i3;
    }

    public final void as(String str, byte b2, int i) {
        ewo ewoVar = this.g;
        if (ewoVar != null) {
            byte[] bArrC = ewoVar.c(str.getBytes(StandardCharsets.UTF_8));
            int length = bArrC.length;
            ai(b2, length, i);
            this.l.w((byte) length);
            ik ikVar = this.l;
            System.arraycopy(bArrC, 0, (byte[]) ikVar.d, ikVar.b, length);
            this.l.b += length;
            return;
        }
        int iF = ik.f(str);
        ai(b2, iF, i);
        this.l.w((byte) iF);
        if (iF != str.length()) {
            this.l.ab(str);
            return;
        }
        ik ikVar2 = this.l;
        str.getBytes(0, iF, (byte[]) ikVar2.d, ikVar2.b);
        this.l.b += iF;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor clear() {
        try {
            FastKV.s(this);
            if (this.aa != 0) {
                FastKV.y(this);
            }
            ah(null);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized boolean commit() {
        this.ab = true;
        return ae();
    }

    @Override // android.content.SharedPreferences
    public final synchronized boolean contains(String str) {
        return this.j.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return this;
    }

    @Override // android.content.SharedPreferences
    public final synchronized Map getAll() {
        Object objValueOf;
        int size = this.j.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry entry : this.j.entrySet()) {
            String str = (String) entry.getKey();
            aet aetVar = (aet) entry.getValue();
            switch (aetVar.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((aeu) aetVar).h);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((aex) aetVar).h);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((aew) aetVar).h);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((aey) aetVar).h);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((aev) aetVar).h);
                    break;
                case 6:
                    afa afaVar = (afa) aetVar;
                    objValueOf = afaVar.l ? FastKV.ae(this, afaVar, this.g) : afaVar.i;
                    break;
                case 7:
                    aes aesVar = (aes) aetVar;
                    objValueOf = aesVar.l ? FastKV.ab(this, aesVar, this.g) : aesVar.i;
                    break;
                case 8:
                    aez aezVar = (aez) aetVar;
                    objValueOf = aezVar.l ? FastKV.ad(this, aezVar, this.g) : ((aez) aetVar).i;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            if (objValueOf != null) {
                map.put(str, objValueOf);
            }
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final synchronized boolean getBoolean(String str, boolean z) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar != null) {
            z = aetVar.c();
        }
        return z;
    }

    @Override // android.content.SharedPreferences
    public final synchronized float getFloat(String str, float f) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar != null) {
            f = aetVar.d();
        }
        return f;
    }

    @Override // android.content.SharedPreferences
    public final synchronized int getInt(String str, int i) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar != null) {
            i = aetVar.e();
        }
        return i;
    }

    @Override // android.content.SharedPreferences
    public final synchronized long getLong(String str, long j) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar != null) {
            j = aetVar.f();
        }
        return j;
    }

    @Override // android.content.SharedPreferences
    public final synchronized String getString(String str, String str2) {
        aet aetVar = (aet) this.j.get(str);
        if (aetVar == null) {
            return str2;
        }
        if (aetVar.a() == 6) {
            afa afaVar = (afa) aetVar;
            if (afaVar.l) {
                String strAe = FastKV.ae(this, afaVar, this.g);
                if (strAe != null && !strAe.isEmpty()) {
                    afaVar.i = strAe;
                    afaVar.l = false;
                    return strAe;
                }
                remove(str);
                return str2;
            }
        }
        return aetVar.g();
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Set set2;
        synchronized (this) {
            set2 = (Set) af(str);
        }
        return set2 != null ? set2 : set;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putBoolean(String str, boolean z) {
        try {
            ac(str);
            aet aetVar = (aet) this.j.get(str);
            if (aetVar != null && aetVar.a() != 1) {
                remove(str);
                aetVar = null;
            }
            aeu aeuVar = (aeu) aetVar;
            if (aeuVar == null) {
                as(str, (byte) 1, b[1]);
                ik ikVar = this.l;
                int i = ikVar.b;
                ikVar.w(z ? (byte) 1 : (byte) 0);
                ao();
                this.j.put(str, new aeu(i, z));
                ag(str);
            } else if (aeuVar.h != z) {
                aeuVar.h = z;
                an(z ? (byte) 1 : (byte) 0, aeuVar.b);
                ag(str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putFloat(String str, float f) {
        try {
            ac(str);
            aet aetVar = (aet) this.j.get(str);
            if (aetVar != null && aetVar.a() != 3) {
                remove(str);
                aetVar = null;
            }
            aew aewVar = (aew) aetVar;
            if (aewVar == null) {
                as(str, (byte) 3, b[3]);
                ik ikVar = this.l;
                int i = ikVar.b;
                int iFloatToRawIntBits = Float.floatToRawIntBits(f);
                ewo ewoVar = this.g;
                if (ewoVar != null) {
                    iFloatToRawIntBits ^= ewoVar.a;
                }
                ikVar.y(iFloatToRawIntBits);
                ao();
                this.j.put(str, new aew(i, f));
                ag(str);
            } else if (aewVar.h != f) {
                int iFloatToRawIntBits2 = Float.floatToRawIntBits(f);
                ewo ewoVar2 = this.g;
                if (ewoVar2 != null) {
                    iFloatToRawIntBits2 ^= ewoVar2.a;
                }
                long jN = ((long) (this.l.n(aewVar.b) ^ iFloatToRawIntBits2)) & 4294967295L;
                aewVar.h = f;
                ap(iFloatToRawIntBits2, jN, aewVar.b);
                ag(str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putInt(String str, int i) {
        try {
            ac(str);
            aet aetVar = (aet) this.j.get(str);
            if (aetVar != null && aetVar.a() != 2) {
                remove(str);
                aetVar = null;
            }
            aex aexVar = (aex) aetVar;
            if (aexVar == null) {
                as(str, (byte) 2, b[2]);
                ik ikVar = this.l;
                int i2 = ikVar.b;
                ewo ewoVar = this.g;
                ikVar.y(ewoVar != null ? ewoVar.a ^ i : i);
                ao();
                this.j.put(str, new aex(i2, i));
                ag(str);
            } else {
                int iN = aexVar.h;
                if (iN != i) {
                    ewo ewoVar2 = this.g;
                    int i3 = ewoVar2 != null ? ewoVar2.a ^ i : i;
                    if (ewoVar2 != null) {
                        iN = this.l.n(aexVar.b);
                    }
                    aexVar.h = i;
                    ap(i3, ((long) (iN ^ i3)) & 4294967295L, aexVar.b);
                    ag(str);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putLong(String str, long j) {
        Throwable th;
        ayd aydVar;
        try {
            try {
                ac(str);
                aet aetVar = (aet) this.j.get(str);
                if (aetVar != null) {
                    try {
                        if (aetVar.a() != 4) {
                            remove(str);
                            aetVar = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
                aey aeyVar = (aey) aetVar;
                if (aeyVar != null) {
                    long jO = aeyVar.h;
                    if (jO != j) {
                        ewo ewoVar = this.g;
                        long j2 = ewoVar != null ? ((long) ewoVar.a) ^ j : j;
                        if (ewoVar != null) {
                            jO = this.l.o(aeyVar.b);
                        }
                        long j3 = jO ^ j2;
                        aeyVar.h = j;
                        aydVar = this;
                        aydVar.aq(j2, j3, aeyVar.b);
                        ag(str);
                    }
                    return aydVar;
                }
                as(str, (byte) 4, b[4]);
                ik ikVar = this.l;
                int i = ikVar.b;
                ewo ewoVar2 = this.g;
                ikVar.aa(i, ewoVar2 != null ? ((long) ewoVar2.a) ^ j : j);
                ikVar.b += 8;
                ao();
                this.j.put(str, new aey(i, j));
                ag(str);
                aydVar = this;
                return aydVar;
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putString(String str, String str2) {
        Throwable th;
        ayd aydVar;
        try {
            try {
                ac(str);
                try {
                    return aydVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                th = th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
        if (str2 != null) {
            aet aetVar = (aet) this.j.get(str);
            if (aetVar != null && aetVar.a() != 6) {
                remove(str);
                aetVar = null;
            }
            afa afaVar = (afa) aetVar;
            if (afaVar != null && !afaVar.l && str2.equals(afaVar.i)) {
                return this;
            }
            byte[] bytes = str2.isEmpty() ? a : str2.getBytes(StandardCharsets.UTF_8);
            ewo ewoVar = this.g;
            if (ewoVar != null) {
                bytes = ewoVar.c(bytes);
            }
            byte[] bArr = bytes;
            if (bArr == null) {
                Log.e("FastKV", this.e, new Exception("Encrypt failed"));
                return this;
            }
            aydVar = this;
            aydVar.ad(str, str2, bArr, afaVar, (byte) 6);
            ag(str);
            throw th;
        }
        remove(str);
        aydVar = this;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor putStringSet(String str, Set set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                ak(str, set, dni.a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    @Override // android.content.SharedPreferences
    public final synchronized void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener == null) {
            return;
        }
        if (!this.t.contains(onSharedPreferenceChangeListener)) {
            this.t.add(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final synchronized SharedPreferences.Editor remove(String str) {
        try {
            aet aetVar = (aet) this.j.get(str);
            if (aetVar != null) {
                this.j.remove(str);
                byte bA = aetVar.a();
                String str2 = null;
                if (bA <= 5) {
                    int iF = ik.f(str);
                    int i = aetVar.b;
                    al(bA, i - (iF + 2), i + b[bA]);
                } else {
                    afb afbVar = (afb) aetVar;
                    al(bA, afbVar.j, afbVar.b + afbVar.k);
                    if (afbVar.l) {
                        str2 = (String) afbVar.i;
                    }
                }
                byte b2 = (byte) (bA | (-128));
                if (this.aa == 0) {
                    this.x.putLong(4, this.i);
                    this.x.put(this.z, b2);
                    this.y.putLong(4, this.i);
                    this.y.put(this.z, b2);
                } else {
                    this.l.aa(4, this.i);
                }
                this.z = 0;
                if (str2 != null) {
                    if (this.aa == 0) {
                        aye.s().execute(new hl(this, 4, str2));
                    } else {
                        this.o.add(str2);
                    }
                }
                if (this.r >= 8192 || this.s.size() >= 100) {
                    dqc.bb(this, 0);
                }
                if (this.aa != 0 && this.ab) {
                    ae();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final String toString() {
        return "FastKV: path:" + this.d + " name:" + this.e;
    }

    @Override // android.content.SharedPreferences
    public final synchronized void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.t.remove(onSharedPreferenceChangeListener);
    }
}
