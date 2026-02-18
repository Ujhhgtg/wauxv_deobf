package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvt extends s {
    public final bvs j;

    public bvt() {
        dnh dnhVar = dnh.b;
        bsb bsbVar = bsb.b;
        this.j = new bvs(dnh.d, bsb.d);
    }

    @Override // me.hd.wauxv.obf.s
    public final int _s(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        bzo.q(linkedHashMap, "<this>");
        return linkedHashMap.size() * 2;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object b() {
        return new LinkedHashMap();
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        int iE = e(obj);
        bvs bvsVar = this.j;
        acn acnVarV = avtVar.v(bvsVar, iE);
        Iterator itD = d(obj);
        int i = 0;
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i2 = i + 1;
            acnVarV._ca(bvsVar, i, dnh.b, key);
            i += 2;
            acnVarV._ca(bvsVar, i2, bsb.b, value);
        }
        acnVarV.a(bvsVar);
    }

    @Override // me.hd.wauxv.obf.s
    public final Iterator d(Object obj) {
        Map map = (Map) obj;
        bzo.q(map, "<this>");
        return map.entrySet().iterator();
    }

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        Map map = (Map) obj;
        bzo.q(map, "<this>");
        return map.size();
    }

    @Override // me.hd.wauxv.obf.s
    public final void g(acm acmVar, int i, Object obj) {
        Map map = (Map) obj;
        bsb bsbVar = bsb.b;
        bzo.q(map, "builder");
        dnh dnhVar = dnh.b;
        bvs bvsVar = this.j;
        Object objH = acmVar.h(bvsVar, i, dnhVar, null);
        int iF = acmVar.f(bvsVar);
        if (iF != i + 1) {
            throw new IllegalArgumentException(dkz.p(i, "Value must follow key in a map, index for key: ", ", returned index for value: ", iF).toString());
        }
        map.put(objH, (!map.containsKey(objH) || (bsb.d.e instanceof cvn)) ? acmVar.h(bvsVar, iF, bsbVar, null) : acmVar.h(bvsVar, iF, bsbVar, bzo.x(map, objH)));
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return this.j;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        Map map = (Map) obj;
        bzo.q(map, "<this>");
        LinkedHashMap linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap(map) : linkedHashMap;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object i(Object obj) {
        LinkedHashMap linkedHashMap = (LinkedHashMap) obj;
        bzo.q(linkedHashMap, "<this>");
        return linkedHashMap;
    }
}
