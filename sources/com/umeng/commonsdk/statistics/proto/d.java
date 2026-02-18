package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dd;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dn;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class d implements ch<d, e>, Serializable, Cloneable {
    public static final Map<e, ct> d;
    private static final long e = 2846460275012375038L;
    private static final dl f = new dl("Imprint");
    private static final db g = new db("property", dn.k, 1);
    private static final db h = new db("version", (byte) 8, 2);
    private static final db i = new db("checksum", (byte) 11, 3);
    private static final Map<Class<? extends Cdo>, dp> j;
    private static final int k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;
    public String c;
    private byte l;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a extends dq<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, d dVar) throws dh {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    break;
                }
                short s = dbVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            dj.a(dgVar, b);
                        } else if (b == 11) {
                            dVar.c = dgVar.z();
                            dVar.c(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = dgVar.w();
                        dVar.b(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 13) {
                    dd ddVarN = dgVar.n();
                    dVar.a = new HashMap(ddVarN.c * 2);
                    for (int i = 0; i < ddVarN.c; i++) {
                        String strZ = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(dgVar);
                        dVar.a.put(strZ, eVar);
                    }
                    dgVar.o();
                    dVar.a(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
            dgVar.k();
            if (!dVar.h()) {
                throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            dVar.l();
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, d dVar) throws dh {
            dVar.l();
            dgVar.a(d.f);
            if (dVar.a != null) {
                dgVar.a(d.g);
                dgVar.a(new dd((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            dgVar.a(d.h);
            dgVar.a(dVar.b);
            dgVar.c();
            if (dVar.c != null) {
                dgVar.a(d.i);
                dgVar.a(dVar.c);
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
    public static class c extends dr<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            dmVar.a(dVar.b);
            dmVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, d dVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            dVar.a = new HashMap(ddVar.c * 2);
            for (int i = 0; i < ddVar.c; i++) {
                String strZ = dmVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(dmVar);
                dVar.a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.b = dmVar.w();
            dVar.b(true);
            dVar.c = dmVar.z();
            dVar.c(true);
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class C0017d implements dp {
        private C0017d() {
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
        map.put(dr.class, new C0017d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.PROPERTY, new ct("property", (byte) 1, new cw(dn.k, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 1, new cu((byte) 11)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        ct.a(d.class, mapUnmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = ce.b(this.l, 0);
    }

    public boolean h() {
        return ce.a(this.l, 0);
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void l() throws dh {
        if (this.a == null) {
            throw new dh("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        j.get(dgVar.D()).b().a(dgVar, this);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
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

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum e implements co {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException(yg.f(i, "Field ", " doesn't exist!"));
        }

        public static e a(String str) {
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

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = map;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
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
