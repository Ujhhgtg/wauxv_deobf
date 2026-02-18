package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bsg implements btd {
    public static final bsg b = new bsg();
    public static final cvo d;

    static {
        List listBf;
        int length;
        Comparable comparable;
        cvm cvmVar = cvm.s;
        if (dnj.ak("kotlinx.serialization.json.JsonLiteral")) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        Object it = ((bzi) cvp.a.values()).iterator();
        while (((bzf) it).hasNext()) {
            btd btdVar = (btd) ((bzd) it).next();
            if ("kotlinx.serialization.json.JsonLiteral".equals(btdVar.getDescriptor().b())) {
                String str = "\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name kotlinx.serialization.json.JsonLiteral there already exists " + dal.b(btdVar.getClass()).d() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            ";
                bzo.q(str, "<this>");
                bvn bvnVar = new bvn(str);
                if (bvnVar.hasNext()) {
                    Object next = bvnVar.next();
                    if (bvnVar.hasNext()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        while (bvnVar.hasNext()) {
                            arrayList.add(bvnVar.next());
                        }
                        listBf = arrayList;
                    } else {
                        listBf = dqc.bf(next);
                    }
                } else {
                    listBf = avd.a;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listBf) {
                    if (!dnj.ak((String) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(abb.ak(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (true) {
                    length = 0;
                    if (!it2.hasNext()) {
                        break;
                    }
                    String str2 = (String) it2.next();
                    int length2 = str2.length();
                    while (true) {
                        if (length >= length2) {
                            length = -1;
                            break;
                        } else if (!cmz.ac(str2.charAt(length))) {
                            break;
                        } else {
                            length++;
                        }
                    }
                    if (length == -1) {
                        length = str2.length();
                    }
                    arrayList3.add(Integer.valueOf(length));
                }
                Iterator it3 = arrayList3.iterator();
                if (it3.hasNext()) {
                    comparable = (Comparable) it3.next();
                    while (it3.hasNext()) {
                        Comparable comparable2 = (Comparable) it3.next();
                        if (comparable.compareTo(comparable2) > 0) {
                            comparable = comparable2;
                        }
                    }
                } else {
                    comparable = null;
                }
                Integer num = (Integer) comparable;
                int iIntValue = num != null ? num.intValue() : 0;
                int length3 = str.length();
                listBf.size();
                int iAf = aba.af(listBf);
                ArrayList arrayList4 = new ArrayList();
                for (Object obj2 : listBf) {
                    int i = length + 1;
                    if (length < 0) {
                        aba.aj();
                        throw null;
                    }
                    String str3 = (String) obj2;
                    String strAd = ((length == 0 || length == iAf) && dnj.ak(str3)) ? null : dnj.ad(iIntValue, str3);
                    if (strAd != null) {
                        arrayList4.add(strAd);
                    }
                    length = i;
                }
                StringBuilder sb = new StringBuilder(length3);
                aaz.i(arrayList4, sb, "\n", "", "", "...", null);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        d = new cvo("kotlinx.serialization.json.JsonLiteral", cvmVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        brx brxVarBw = cnb.n(ajtVar).bw();
        if (brxVarBw instanceof bsf) {
            return (bsf) brxVarBw;
        }
        throw cnd.ak(-1, "Unexpected JSON element, expected JsonLiteral, had " + dal.b(brxVarBw.getClass()), brxVarBw.toString());
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        bsf bsfVar = (bsf) obj;
        bzo.q(bsfVar, "value");
        String str = bsfVar.b;
        cnb.l(avtVar);
        if (bsfVar.a) {
            avtVar.ad(str);
            return;
        }
        Long lBg = dnq.bg(str);
        if (lBg != null) {
            avtVar.ab(lBg.longValue());
            return;
        }
        emz emzVarAa = bhs.aa(str);
        if (emzVarAa != null) {
            avtVar.r(end.d).ab(emzVarAa.a);
            return;
        }
        Boolean bool = null;
        Double dValueOf = dnp.bc(str) ? Double.valueOf(Double.parseDouble(str)) : null;
        if (dValueOf != null) {
            avtVar.s(dValueOf.doubleValue());
            return;
        }
        if (str.equals("true")) {
            bool = Boolean.TRUE;
        } else if (str.equals("false")) {
            bool = Boolean.FALSE;
        }
        if (bool != null) {
            avtVar.w(bool.booleanValue());
        } else {
            avtVar.ad(str);
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return d;
    }
}
