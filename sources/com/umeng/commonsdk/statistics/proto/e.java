package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class e implements ch<e, EnumC0018e>, Serializable, Cloneable {
    public static final Map<EnumC0018e, ct> d;
    private static final long e = 7501688097813630241L;
    private static final dl f = new dl("ImprintValue");
    private static final db g = new db("value", (byte) 11, 1);
    private static final db h = new db("ts", (byte) 10, 2);
    private static final db i = new db("guid", (byte) 11, 3);
    private static final Map<Class<? extends Cdo>, dp> j;
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private EnumC0018e[] m;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a extends dq<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, e eVar) {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    dgVar.k();
                    eVar.k();
                    return;
                }
                short s = dbVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            dj.a(dgVar, b);
                        } else if (b == 11) {
                            eVar.c = dgVar.z();
                            eVar.c(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = dgVar.x();
                        eVar.b(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = dgVar.z();
                    eVar.a(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, e eVar) {
            eVar.k();
            dgVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                dgVar.a(e.g);
                dgVar.a(eVar.a);
                dgVar.c();
            }
            if (eVar.g()) {
                dgVar.a(e.h);
                dgVar.a(eVar.b);
                dgVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                dgVar.a(e.i);
                dgVar.a(eVar.c);
                dgVar.c();
            }
            dgVar.d();
            dgVar.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class c extends dr<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            dmVar.a(bitSet, 3);
            if (eVar.d()) {
                dmVar.a(eVar.a);
            }
            if (eVar.g()) {
                dmVar.a(eVar.b);
            }
            if (eVar.j()) {
                dmVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, e eVar) {
            dm dmVar = (dm) dgVar;
            BitSet bitSetB = dmVar.b(3);
            if (bitSetB.get(0)) {
                eVar.a = dmVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = dmVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.c = dmVar.z();
                eVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0018e.class);
        enumMap.put(EnumC0018e.VALUE, new ct("value", (byte) 2, new cu((byte) 11)));
        enumMap.put(EnumC0018e.TS, new ct("ts", (byte) 2, new cu((byte) 10)));
        enumMap.put(EnumC0018e.GUID, new ct("guid", (byte) 2, new cu((byte) 11)));
        Map<EnumC0018e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        ct.a(e.class, mapUnmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0018e[]{EnumC0018e.VALUE, EnumC0018e.TS, EnumC0018e.GUID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = ce.b(this.l, 0);
    }

    public boolean g() {
        return ce.a(this.l, 0);
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void k() {
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        j.get(dgVar.D()).b().a(dgVar, this);
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = ce.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum EnumC0018e implements co {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC0018e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (EnumC0018e enumC0018e : EnumSet.allOf(EnumC0018e.class)) {
                d.put(enumC0018e.b(), enumC0018e);
            }
        }

        EnumC0018e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static EnumC0018e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0018e b(int i) {
            EnumC0018e enumC0018eA = a(i);
            if (enumC0018eA != null) {
                return enumC0018eA;
            }
            throw new IllegalArgumentException(yg.f(i, "Field ", " doesn't exist!"));
        }

        public static EnumC0018e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.f;
        }
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0018e fieldForId(int i2) {
        return EnumC0018e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0018e[]{EnumC0018e.VALUE, EnumC0018e.TS, EnumC0018e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException {
        try {
            this.l = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
