package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cvp {
    public static final bzg a;

    static {
        bzg bzgVar = new bzg(8);
        bzgVar.put(dal.b(String.class), dnh.b);
        bzgVar.put(dal.b(Character.TYPE), ui.b);
        bzgVar.put(dal.b(char[].class), ub.j);
        bzgVar.put(dal.b(Double.TYPE), apl.b);
        bzgVar.put(dal.b(double[].class), apk.j);
        bzgVar.put(dal.b(Float.TYPE), bbm.b);
        bzgVar.put(dal.b(float[].class), bbl.j);
        bzgVar.put(dal.b(Long.TYPE), bya.b);
        bzgVar.put(dal.b(long[].class), bxx.j);
        bzgVar.put(dal.b(emz.class), end.b);
        bzgVar.put(dal.b(Integer.TYPE), bqj.b);
        bzgVar.put(dal.b(int[].class), bqd.j);
        bzgVar.put(dal.b(emu.class), emy.b);
        bzgVar.put(dal.b(Short.TYPE), dhf.b);
        bzgVar.put(dal.b(short[].class), dhe.j);
        bzgVar.put(dal.b(ene.class), eni.b);
        bzgVar.put(dal.b(Byte.TYPE), si.b);
        bzgVar.put(dal.b(byte[].class), rx.j);
        bzgVar.put(dal.b(emp.class), emt.b);
        bzgVar.put(dal.b(Boolean.TYPE), pv.b);
        bzgVar.put(dal.b(boolean[].class), pu.j);
        bzgVar.put(dal.b(ens.class), enu.b);
        bzgVar.put(dal.b(Void.class), coq.b);
        try {
            zc zcVarB = dal.b(aqm.class);
            int i = aqm.c;
            bzgVar.put(zcVarB, aqo.b);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            bzgVar.put(dal.b(ena.class), enc.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            bzgVar.put(dal.b(emv.class), emx.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            bzgVar.put(dal.b(enf.class), enh.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            bzgVar.put(dal.b(emq.class), ems.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            bzgVar.put(dal.b(eov.class), eow.b);
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        try {
            zc zcVarB2 = dal.b(bpw.class);
            bpw bpwVar = bpw.a;
            bzgVar.put(zcVarB2, bqb.b);
        } catch (ClassNotFoundException | NoClassDefFoundError unused7) {
        }
        bzgVar.p();
        bzgVar.n = true;
        if (bzgVar.j <= 0) {
            bzgVar = bzg.a;
            throwIfVar1IsNull(bzgVar,
                    "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        a = bzgVar;
    }
}
