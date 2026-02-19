package me.hd.wauxv.obf;

import android.app.Application;
import android.app.Instrumentation;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eui extends ewy {
    public static final eui a;
    public static final Kotlin$Lazy b;

    static {
        "initDexObfKey" /* "initDexObfKey" /* "initDexObfKey" /* "initDexObfKey" /* cnb.z(-82905753713450L)   */;
        a = new eui();
        b = new Kotlin$Lazy(new efq(18));
    }

    public static boolean c() {
        String strZ = "initDexObfKey" /* "initDexObfKey" /* "initDexObfKey" /* "initDexObfKey" /* cnb.z(-81814832020266L)   */;
        String strZ2 = "" /* "" /* "" /* "" /* cnb.z(-5841155521322L)   */;
        io ioVar = emc.w;
        if (ioVar == null) {
            throw new IllegalArgumentException("DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* cnb.z(-6021544147754L)   */.toString());
        }
        String string = ioVar.aj().getString(strZ, strZ2);
        throwIfVar1IsNull(string);
        return string.equals((String) b.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d() {
        for (bmf bmfVar : (List) ajf.a.getValue()) {
            if (bmfVar instanceof bmz) {
                ur.a.getClass();
                ur.b.add((bmz) bmfVar);
            }
            if (bmfVar instanceof bna) {
                wm.a.getClass();
                wm.b.add((bna) bmfVar);
            }
            if (bmfVar instanceof bnb) {
                wp.a.getClass();
                wp.b.add((bnb) bmfVar);
            }
            if (bmfVar instanceof bnc) {
                wr.a.getClass();
                wr.b.add((bnc) bmfVar);
            }
            if (bmfVar instanceof bnd) {
                aeq.a.getClass();
                aeq.b.add((bnd) bmfVar);
            }
            if (bmfVar instanceof bne) {
                afu.a.getClass();
                afu.b.add((bne) bmfVar);
            }
            if (bmfVar instanceof bnf) {
                agi.a.getClass();
                agi.b.add((bnf) bmfVar);
            }
            if (bmfVar instanceof bni) {
                axu.a.getClass();
                axu.b.add((bni) bmfVar);
            }
            if (bmfVar instanceof bnj) {
                ayy.a.getClass();
                ayy.b.add((bnj) bmfVar);
            }
            if (bmfVar instanceof bnk) {
                azd.a.getClass();
                azd.b.add((bnk) bmfVar);
            }
            if (bmfVar instanceof bnm) {
                bap.a.getClass();
                bap.b.add((bnm) bmfVar);
            }
            if (bmfVar instanceof bnl) {
                bal.a.getClass();
                bal.b.add((bnl) bmfVar);
            }
            if (bmfVar instanceof bnn) {
                bmb.a.getClass();
                bmb.b.add((bnn) bmfVar);
            }
            if (bmfVar instanceof bnp) {
                bzc.a.getClass();
                bzc.b.add((bnp) bmfVar);
            }
            if (bmfVar instanceof bnq) {
                cey.a.getClass();
                cey.b.add((bnq) bmfVar);
            }
            if (bmfVar instanceof bnr) {
                cgf.a.getClass();
                cgf.b.add((bnr) bmfVar);
            }
            if (bmfVar instanceof bns) {
                cgt.a.getClass();
                cgt.b.add((bns) bmfVar);
            }
            if (bmfVar instanceof bnt) {
                cos.a.getClass();
                cos.b.add((bnt) bmfVar);
            }
            if (bmfVar instanceof bnx) {
                crj.a.getClass();
                crj.b.add((bnx) bmfVar);
            }
            if (bmfVar instanceof bny) {
                dbl.a.getClass();
                dbl.b.add((bny) bmfVar);
            }
            if (bmfVar instanceof boa) {
                djo.a.getClass();
                djo.b.add((boa) bmfVar);
            }
            if (bmfVar instanceof bob) {
                dly.a.getClass();
                dly.b.add((bob) bmfVar);
            }
            if (bmfVar instanceof boc) {
                dmi.a.getClass();
                dmi.b.add((boc) bmfVar);
            }
            if (bmfVar instanceof bod) {
                dou.a.getClass();
                dou.b.add((bod) bmfVar);
            }
            if (bmfVar.z() && !bmfVar.v) {
                String[] strArr_aa = bmfVar._aa();
                String[] strArr = (String[]) Arrays.copyOf(strArr_aa, strArr_aa.length);
                if (strArr.length == 0) {
                    throw new IllegalStateException("withProcess method need a \"name\" param" /*
                                                                                                * cnb.z(-
                                                                                                * 82716775152426L)
                                                                                                */.toString());
                }
                for (String str : strArr) {
                    eui euiVar = a;
                    if (nullSafeIsEqual(str, euiVar.ac())) {
                        euiVar.ae(bmfVar);
                        break;
                    }
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.ewy
    public final void w() {
        int i = 0;
        MethodResolver methodResolverVarT = dqc.bg(dal.b(Instrumentation.class)).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "callApplicationOnCreate" /* "callApplicationOnCreate" /* "callApplicationOnCreate" /* "callApplicationOnCreate" /* cnb.z(-82549271427882L)   */;
        aki akiVarAd = a.ad((MethodHookWrapper) StaticHelpers6.n(new Object[] { dal.b(Application.class) }, 1, methodResolverVarT), HookPriorityEnum.ENUM_DEFAULT);
        akiVarAd.m(new epy(14));
        akiVarAd.o();
    }
}
