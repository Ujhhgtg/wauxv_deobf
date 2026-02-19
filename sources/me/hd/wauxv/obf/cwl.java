package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cwl extends ua implements ajt, acm {
    public final cwd ah;
    public final ProtoReader ai;
    public final dfx aj;
    public final int[] ak;
    public HashMap al;
    public HashMap am;
    public boolean an;
    public final asx ao;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public cwl(cwd cwdVar, ProtoReader protoReaderVar, dfx dfxVar) {
        super(2, false);
        throwIfVar1IsNull(dfxVar, "descriptor");
        this.ah = cwdVar;
        this.ai = protoReaderVar;
        this.aj = dfxVar;
        this.ao = new asx(dfxVar, new brz(2, this, cwl.class, "readIfAbsent",
                "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0, 0, 1));
        int i = dfxVar.i();
        if (i >= 32) {
            ax(dfxVar, i);
            return;
        }
        int i2 = i + 1;
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = -1;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int iO = ajn.o(dfxVar, i4, false);
            if (iO > i || iO == -2) {
                ax(dfxVar, i);
                return;
            }
            iArr[iO] = i4;
        }
        this.ak = iArr;
    }

    @Override // me.hd.wauxv.obf.acm
    public final void _bp(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
    }

    @Override // me.hd.wauxv.obf.acm
    public final double _bq(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return ar(ad(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final cbm a() {
        return this.ah.b;
    }

    @Override // me.hd.wauxv.obf.ajt
    public final float aa() {
        return as(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final double ab() {
        return ar(_bx());
    }

    public long ad(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "<this>");
        return ajn.n(dfxVar, i);
    }

    public String ag(long j) {
        ProtoReader protoReaderVar = this.ai;
        try {
            if (j != 19500) {
                return protoReaderVar.readString();
            }
            int iG = protoReaderVar.readVarint32(IntEncodingEnum.DEFAULT);
            ProtoReader.validateLength(iG);
            return protoReaderVar.sourceBuffer.f(iG);
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.aj.b(), e);
        }
    }

    public final Object ap(btd btdVar, Object obj) {
        String string;
        dnt dntVar = dnt.c;
        throwIfVar1IsNull(btdVar, "deserializer");
        try {
            return btdVar instanceof bvt ? aw(btdVar, obj)
                    : nullSafeIsEqual(btdVar.getDescriptor(), rx.j.o) ? av((byte[]) obj)
                            : btdVar instanceof s ? ((s) btdVar).f(this, obj) : btdVar.a(this);
        } catch (AnotherIllegalArgumentException e) {
            long j_br = _br();
            dfx descriptor = btdVar.getDescriptor();
            dfx dfxVar = this.aj;
            if (nullSafeIsEqual(dfxVar, descriptor)) {
                string = "Error while decoding " + dfxVar.b();
            } else if (nullSafeIsEqual(dfxVar.h(), dnt.b) && !nullSafeIsEqual(btdVar.getDescriptor().h(), dntVar)) {
                StringBuilder sb = new StringBuilder("Error while decoding index ");
                sb.append(((int) (j_br & 2147483647L)) - 1);
                sb.append(" in repeated field of ");
                sb.append(btdVar.getDescriptor().b());
                string = sb.toString();
            } else if (nullSafeIsEqual(dfxVar.h(), dntVar)) {
                int i = ((int) (j_br & 2147483647L)) - 1;
                int i2 = i / 2;
                string = "Error while decoding " + (i % 2 == 0 ? "key" : "value") + " of index " + i2
                        + " in map field of " + btdVar.getDescriptor().b();
            } else {
                string = "Error while decoding " + btdVar.getDescriptor().b() + " at proto number "
                        + ((int) (j_br & 2147483647L)) + " of " + dfxVar.b();
            }
            throw new AnotherIllegalArgumentException(string, e);
        }
    }

    public final boolean aq(long j) {
        int iAt = at(j);
        if (iAt == 0) {
            return false;
        }
        if (iAt == 1) {
            return true;
        }
        throw new SomeIllegalArgumentException(concatVar2Var1(iAt, "Unexpected boolean value: "));
    }

    public final double ar(long j) {
        ProtoReader protoReaderVar = this.ai;
        try {
            return j == 19500 ? Double.longBitsToDouble(protoReaderVar.readFixed64()) : protoReaderVar.m();
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.aj.b(), e);
        }
    }

    public final float as(long j) {
        ProtoReader protoReaderVar = this.ai;
        try {
            return j == 19500 ? Float.intBitsToFloat(protoReaderVar.readFixed32()) : protoReaderVar.n();
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.aj.b(), e);
        }
    }

    public final int at(long j) {
        ProtoReader protoReaderVar = this.ai;
        try {
            return j == 19500 ? protoReaderVar.readVarint32(IntEncodingEnum.DEFAULT) : protoReaderVar.o(ajn.r(j));
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.aj.b(), e);
        }
    }

    public final long au(long j) {
        ProtoReader protoReaderVar = this.ai;
        try {
            return j == 19500 ? protoReaderVar.readVarint64(IntEncodingEnum.DEFAULT) : protoReaderVar.q(ajn.r(j));
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j & 2147483647L)) + " of " + this.aj.b(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9, types: [byte[]] */
    public final byte[] av(byte[] bArr) {
        byte[] bArrK;
        byte[] bArrL;
        long j_br = _br();
        ProtoReader protoReaderVar = this.ai;
        try {
            if (j_br == 19500) {
                bArrL = protoReaderVar.readRawBytes();
            } else {
                bArrK = protoReaderVar.readBytes();
            }
            if (bArr == null) {
                j_br = bArrK;
                j_br = bArrL;
                return j_br;
            }
            j_br = bArrK;
            j_br = bArrL;
            return SomeStaticHelpers.v(bArr, j_br);
        } catch (AnotherIllegalArgumentException e) {
            throw new AnotherIllegalArgumentException("Error while decoding proto number " + ((int) (j_br & 2147483647L)) + " of " + this.aj.b(),
                    e);
        }
    }

    public final LinkedHashMap aw(btd btdVar, Object obj) {
        throwIfVar1IsNull(btdVar,
                "null cannot be cast to non-null type kotlinx.serialization.internal.MapLikeSerializer<kotlin.Any?, kotlin.Any?, T of kotlinx.serialization.protobuf.internal.ProtobufDecoder.deserializeMap, *>");
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        bzm bzmVar = new bzm(0);
        Map map = obj instanceof Map ? (Map) obj : null;
        Set<Map.Entry> set = (Set) new ko(bzmVar).f(this, map != null ? map.entrySet() : null);
        int iAh = KotlinHelpers.calcHashMapCapacity(StaticHelpers4.ak(set, 10));
        if (iAh < 16) {
            iAh = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iAh);
        for (Map.Entry entry : set) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public final void ax(dfx dfxVar, int i) {
        HashMap map = new HashMap(i, 1.0f);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (ajn.o(dfxVar, i3, false) == -2) {
                List listP = ajn.p(dfxVar.l(i3), this.ah.b);
                ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listP, 10));
                Iterator it = listP.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf((int) (ajn.n((dfx) it.next(), 0) & 2147483647L)));
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    map.put(Integer.valueOf(((Number) it2.next()).intValue()), Integer.valueOf(i3));
                }
                i2++;
            } else {
                map.put(Integer.valueOf(ajn.o(dfxVar, i3, false)), Integer.valueOf(i3));
            }
        }
        if (i2 > 0) {
            this.am = new HashMap(i2, 1.0f);
        }
        this.al = map;
    }

    @Override // me.hd.wauxv.obf.acm
    public final String d(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return ag(ad(dfxVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final long e(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return au(ad(cvkVar, i));
    }

    public int f(dfx dfxVar) {
        int iIntValue;
        HashMap map;
        ProtoReader protoReaderVar = this.ai;
        throwIfVar1IsNull(dfxVar, "descriptor");
        while (true) {
            try {
                int iT = protoReaderVar.nextField();
                asx asxVar = this.ao;
                if (iT == -1) {
                    return asxVar.g();
                }
                if (iT == 0) {
                    throw new SomeIllegalArgumentException("0 is not allowed as the protobuf field number in " + dfxVar.b()
                            + ", the input bytes may have been corrupted");
                }
                int[] iArr = this.ak;
                if (iArr != null) {
                    iIntValue = (iT < 0 || iT >= iArr.length) ? -1 : iArr[iT];
                } else {
                    HashMap map2 = this.al;
                    throwIfVar1IsNull(map2);
                    Object obj = map2.get(Integer.valueOf(iT));
                    if (obj == null) {
                        obj = -1;
                    }
                    iIntValue = ((Number) obj).intValue();
                }
                if (iIntValue != -1) {
                    if (ajn.w(ajn.n(dfxVar, iIntValue)) && (map = this.am) != null) {
                    }
                    asxVar.f(iIntValue);
                    return iIntValue;
                }
                protoReaderVar.skipField();
            } catch (AnotherIllegalArgumentException e) {
                throw new AnotherIllegalArgumentException("Fail to get element index for " + dfxVar.b() + " in " + this.aj.b(), e);
            }
        }
    }

    @Override // me.hd.wauxv.obf.acm
    public final int g(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return at(ad(dfxVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final Object h(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "deserializer");
        _by(ad(dfxVar, i));
        return ap(btdVar, obj);
    }

    @Override // me.hd.wauxv.obf.acm
    public final Object i(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "deserializer");
        _by(ad(dfxVar, i));
        if (this.an) {
            return null;
        }
        return ap(btdVar, obj);
    }

    @Override // me.hd.wauxv.obf.acm
    public final char j(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return (char) at(ad(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final byte k(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return (byte) at(ad(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final boolean l(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return aq(ad(dfxVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final ajt m(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        long jAd = ad(cvkVar, i);
        throwIfVar1IsNull(cvkVar.l(i), "inlineDescriptor");
        _by(jAd);
        return this;
    }

    @Override // me.hd.wauxv.obf.acm
    public final short n(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return (short) at(ad(cvkVar, i));
    }

    @Override // me.hd.wauxv.obf.acm
    public final float o(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return as(ad(cvkVar, i));
    }

    /*
     * JADX WARN: Not initialized variable reg: 11, insn: 0x0076: MOVE (r14
     * I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:119),
     * block:B:32:0x0076
     */
    public acm p(dfx dfxVar) {
        dfx dfxVar2;
        emc emcVarH;
        dnt dntVar;
        boolean zF;
        cwd cwdVar;
        ProtoReader protoReaderVar;
        Integer num;
        dfx dfxVar3 = this.aj;
        throwIfVar1IsNull(dfxVar, "descriptor");
        try {
            emcVarH = dfxVar.h();
            dntVar = dnt.b;
            zF = nullSafeIsEqual(emcVarH, dntVar);
            cwdVar = this.ah;
            protoReaderVar = this.ai;
        } catch (AnotherIllegalArgumentException e) {
            e = e;
            dfxVar2 = dfxVar;
        }
        try {
            try {
                if (zF) {
                    long j_br = _br();
                    if (!nullSafeIsEqual(dfxVar3.h(), dntVar) || j_br == 19500 || dfxVar3.equals(dfxVar)) {
                        return (protoReaderVar.protoWireType == ProtoWireType.ENUM_LENGTH_DELIMITED && ajn.x(dfxVar.l(0))) ? new cse(cwdVar, new ProtoReader(protoReaderVar.beginMessage()), dfxVar)
                                : new dbm(cwdVar, protoReaderVar, j_br, dfxVar);
                    }
                    ProtoReader protoReaderVarAl = HugeSyntheticPileOfHelpers.readProtoSubMessage(protoReaderVar, j_br);
                    protoReaderVarAl.nextField();
                    return new dbm(cwdVar, protoReaderVarAl, 1, dfxVar);
                }
                if (!nullSafeIsEqual(emcVarH, dnt.a) && !nullSafeIsEqual(emcVarH, dnt.n) && !(emcVarH instanceof cur)) {
                    if (nullSafeIsEqual(emcVarH, dnt.c)) {
                        return new bzj(cwdVar, new ProtoReader(_br() == 19500 ? protoReaderVar.readBytesAsBuffer() : protoReaderVar.beginMessage()), _br(), dfxVar);
                    }
                    throw new SomeIllegalArgumentException("Primitives are not supported at top-level");
                }
                long j_br2 = _br();
                if (j_br2 == 19500 && nullSafeIsEqual(dfxVar3, dfxVar)) {
                    return this;
                }
                if (!ajn.w(j_br2)) {
                    return new cwl(cwdVar, HugeSyntheticPileOfHelpers.readProtoSubMessage(protoReaderVar, j_br2), dfxVar);
                }
                int i = ((int) (j_br2 & 2147483647L)) - 1;
                HashMap map = this.am;
                if (map != null && (num = (Integer) map.get(Integer.valueOf(i))) != null) {
                    j_br2 = (j_br2 & 1152921500311879680L) | ((long) num.intValue());
                }
                return new crg(cwdVar, protoReaderVar, j_br2, dfxVar);
            } catch (AnotherIllegalArgumentException e2) {
                e = e2;
                throw new AnotherIllegalArgumentException("Fail to begin structure for " + dfxVar2.b() + " in " + dfxVar3.b() + " at proto number "
                        + ((int) (_br() & 2147483647L)), e);
            }
        } catch (AnotherIllegalArgumentException e3) {
            e = e3;
            throw new AnotherIllegalArgumentException("Fail to begin structure for " + dfxVar2.b() + " in " + dfxVar3.b() + " at proto number "
                    + ((int) (_br() & 2147483647L)), e);
        }
    }

    @Override // me.hd.wauxv.obf.ajt
    public final boolean q() {
        return aq(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final char r() {
        return (char) at(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final int s() {
        return at(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final Object t(btd btdVar) {
        throwIfVar1IsNull(btdVar, "deserializer");
        return ap(btdVar, null);
    }

    @Override // me.hd.wauxv.obf.ajt
    public final ajt u(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        _by(_bw());
        return this;
    }

    @Override // me.hd.wauxv.obf.ajt
    public final String v() {
        return ag(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final long w() {
        return au(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final boolean x() {
        return !this.an;
    }

    @Override // me.hd.wauxv.obf.ajt
    public final byte y() {
        return (byte) at(_bx());
    }

    @Override // me.hd.wauxv.obf.ajt
    public final short z() {
        return (short) at(_bx());
    }
}
