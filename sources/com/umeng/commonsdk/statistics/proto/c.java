package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class c implements ch<c, e>, Serializable, Cloneable {
    public static final Map<e, ct> d;
    private static final long e = -5764118265293965743L;
    private static final dl f = new dl("IdTracking");
    private static final db g = new db("snapshots", dn.k, 1);
    private static final db h = new db("journals", dn.m, 2);
    private static final db i = new db("checksum", (byte) 11, 3);
    private static final Map<Class<? extends Cdo>, dp> j;
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;
    public String c;
    private e[] k;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class a extends dq<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, c cVar) throws dh {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    dgVar.k();
                    cVar.n();
                    return;
                }
                short s = dbVarL.c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            dj.a(dgVar, b);
                        } else if (b == 11) {
                            cVar.c = dgVar.z();
                            cVar.c(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 15) {
                        dc dcVarP = dgVar.p();
                        cVar.b = new ArrayList(dcVarP.b);
                        while (i < dcVarP.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(dgVar);
                            cVar.b.add(aVar);
                            i++;
                        }
                        dgVar.q();
                        cVar.b(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 13) {
                    dd ddVarN = dgVar.n();
                    cVar.a = new HashMap(ddVarN.c * 2);
                    while (i < ddVarN.c) {
                        String strZ = dgVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(dgVar);
                        cVar.a.put(strZ, bVar);
                        i++;
                    }
                    dgVar.o();
                    cVar.a(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, c cVar) throws dh {
            cVar.n();
            dgVar.a(c.f);
            if (cVar.a != null) {
                dgVar.a(c.g);
                dgVar.a(new dd((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    dgVar.a(entry.getKey());
                    entry.getValue().write(dgVar);
                }
                dgVar.e();
                dgVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                dgVar.a(c.h);
                dgVar.a(new dc((byte) 12, cVar.b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(dgVar);
                }
                dgVar.f();
                dgVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                dgVar.a(c.i);
                dgVar.a(cVar.c);
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

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class C0016c extends dr<c> {
        private C0016c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dmVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                dmVar.a(entry.getKey());
                entry.getValue().write(dmVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            dmVar.a(bitSet, 2);
            if (cVar.j()) {
                dmVar.a(cVar.b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(dmVar);
                }
            }
            if (cVar.m()) {
                dmVar.a(cVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, c cVar) {
            dm dmVar = (dm) dgVar;
            dd ddVar = new dd((byte) 11, (byte) 12, dmVar.w());
            cVar.a = new HashMap(ddVar.c * 2);
            for (int i = 0; i < ddVar.c; i++) {
                String strZ = dmVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(dmVar);
                cVar.a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = dmVar.b(2);
            if (bitSetB.get(0)) {
                dc dcVar = new dc((byte) 12, dmVar.w());
                cVar.b = new ArrayList(dcVar.b);
                for (int i2 = 0; i2 < dcVar.b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(dmVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.c = dmVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0016c b() {
            return new C0016c();
        }
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new ct("snapshots", (byte) 1, new cw(dn.k, new cu((byte) 11), new cy((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new ct("journals", (byte) 2, new cv(dn.m, new cy((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 2, new cu((byte) 11)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        ct.a(c.class, mapUnmodifiableMap);
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.c;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void n() throws dh {
        if (this.a != null) {
            return;
        }
        throw new dh("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) {
        j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) {
        j.get(dgVar.D()).b().a(dgVar, this);
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum e implements co {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
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
                return SNAPSHOTS;
            }
            if (i == 2) {
                return JOURNALS;
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

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
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
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
