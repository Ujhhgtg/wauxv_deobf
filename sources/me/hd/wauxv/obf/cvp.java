package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cvp {
    public static final bzg a;

    static {
        bzg bzgVar = new bzg(8);
        bzgVar.put(dal.getKClassFromClass(String.class), dnh.b);
        bzgVar.put(dal.getKClassFromClass(Character.TYPE), ui.b);
        bzgVar.put(dal.getKClassFromClass(char[].class), ub.j);
        bzgVar.put(dal.getKClassFromClass(Double.TYPE), apl.b);
        bzgVar.put(dal.getKClassFromClass(double[].class), apk.j);
        bzgVar.put(dal.getKClassFromClass(Float.TYPE), bbm.b);
        bzgVar.put(dal.getKClassFromClass(float[].class), bbl.j);
        bzgVar.put(dal.getKClassFromClass(Long.TYPE), bya.b);
        bzgVar.put(dal.getKClassFromClass(long[].class), bxx.j);
        bzgVar.put(dal.getKClassFromClass(emz.class), end.b);
        bzgVar.put(dal.getKClassFromClass(Integer.TYPE), bqj.b);
        bzgVar.put(dal.getKClassFromClass(int[].class), bqd.j);
        bzgVar.put(dal.getKClassFromClass(emu.class), emy.b);
        bzgVar.put(dal.getKClassFromClass(Short.TYPE), dhf.b);
        bzgVar.put(dal.getKClassFromClass(short[].class), dhe.j);
        bzgVar.put(dal.getKClassFromClass(ene.class), eni.b);
        bzgVar.put(dal.getKClassFromClass(Byte.TYPE), si.b);
        bzgVar.put(dal.getKClassFromClass(byte[].class), rx.j);
        bzgVar.put(dal.getKClassFromClass(emp.class), emt.b);
        bzgVar.put(dal.getKClassFromClass(Boolean.TYPE), pv.b);
        bzgVar.put(dal.getKClassFromClass(boolean[].class), pu.j);
        bzgVar.put(dal.getKClassFromClass(Kotlin$Unit.class), enu.b);
        bzgVar.put(dal.getKClassFromClass(Void.class), coq.b);
        try {
            KClass zcVarB = dal.getKClassFromClass(aqm.class);
            int i = aqm.c;
            bzgVar.put(zcVarB, aqo.b);
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        try {
            bzgVar.put(dal.getKClassFromClass(ena.class), enc.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused2) {
        }
        try {
            bzgVar.put(dal.getKClassFromClass(emv.class), emx.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
        }
        try {
            bzgVar.put(dal.getKClassFromClass(enf.class), enh.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused4) {
        }
        try {
            bzgVar.put(dal.getKClassFromClass(emq.class), ems.j);
        } catch (ClassNotFoundException | NoClassDefFoundError unused5) {
        }
        try {
            bzgVar.put(dal.getKClassFromClass(eov.class), eow.b);
        } catch (ClassNotFoundException | NoClassDefFoundError unused6) {
        }
        try {
            KClass zcVarB2 = dal.getKClassFromClass(Instant.class);
            Instant instantVar = Instant.a;
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
