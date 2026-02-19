package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbo implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ cbh b;
    public final /* synthetic */ cbg c;

    public /* synthetic */ cbo(cbh cbhVar, cbg cbgVar, int i) {
        this.a = i;
        this.b = cbhVar;
        this.c = cbgVar;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        dpu dpuVar;
        dpu dpuVar2;
        Object objX;
        dpu dpuVar3;
        int i = this.a;
        int i2 = 0;
        int i3 = 17;
        cbm cbmVar = cbp.a;
        cbg cbgVar = this.c;
        cbh cbhVar = this.b;
        switch (i) {
            case 0:
                Class cls = (Class) obj;
                cde cdeVar = (cde) cbhVar;
                cbm cbmVar2 = cbgVar.c;
                if (cbmVar2 != null) {
                    cbmVar = cbmVar2;
                }
                bae baeVarO = cbp
                        .o(cbp.o(
                                cbp.o(cbp.o(
                                        cbp.o(cbp.o(cbp.f(cbp.b(aaz.a(cbmVar.c(cls)), cdeVar, cbgVar), cdeVar, cbgVar),
                                                cbgVar, "returnType", cdeVar.a, new cbi(cbgVar, i2)), cbgVar,
                                                "returnTypeCondition", cdeVar.ai, new fq(15)),
                                        cbgVar, "isBridge", null, new fq(17)), cbgVar, "isBridgeNot", null, new fq(25)),
                                cbgVar, "isDefault", null, new cbk(2)), cbgVar, "isDefaultNot", null, new cbk(3));
                zc zcVarB = dal.b(Method.class);
                if (zcVarB.equals(dal.b(Method.class))) {
                    dpuVar = new dpu(baeVarO, new cbn(cbgVar, 6), 1);
                } else if (zcVarB.equals(dal.b(Constructor.class))) {
                    dpuVar = new dpu(baeVarO, new cbn(cbgVar, 7), 1);
                } else {
                    if (!zcVarB.equals(dal.b(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarO).toString());
                    }
                    dpuVar = new dpu(baeVarO, new cbn(cbgVar, 8), 1);
                }
                return dfv.ak(dpuVar);
            case 1:
                Class cls2 = (Class) obj;
                adt adtVar = (adt) cbhVar;
                cbm cbmVar3 = cbgVar.c;
                if (cbmVar3 != null) {
                    cbmVar = cbmVar3;
                }
                bae baeVarF = cbp.f(cbp.b(aaz.a(cbmVar.b(cls2)), adtVar, cbgVar), adtVar, cbgVar);
                zc zcVarB2 = dal.b(Constructor.class);
                if (zcVarB2.equals(dal.b(Method.class))) {
                    dpuVar2 = new dpu(baeVarF, new cbn(cbgVar, 0), 1);
                } else if (zcVarB2.equals(dal.b(Constructor.class))) {
                    dpuVar2 = new dpu(baeVarF, new cbn(cbgVar, 1), 1);
                } else {
                    if (!zcVarB2.equals(dal.b(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarF).toString());
                    }
                    dpuVar2 = new dpu(baeVarF, new cbn(cbgVar, 2), 1);
                }
                return dfv.ak(dpuVar2);
            default:
                Class cls3 = (Class) obj;
                azg azgVar = (azg) cbhVar;
                cbm cbmVar4 = cbgVar.c;
                if (cbmVar4 != null) {
                    cbmVar = cbmVar4;
                }
                try {
                    objX = SomeStaticHelpers.ab(cls3.getDeclaredFields());
                    break;
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Throwable thB = dcy.b(objX);
                if (thB != null) {
                    dov dovVar = bth.a;
                    bth.e("Failed to get declared fields in " + cbmVar + " because got an exception.", thB);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                Iterable iterable = (List) objX;
                if (iterable == null) {
                    iterable = EmptyReadonlyList.a;
                }
                bae baeVarO2 = cbp.o(
                        cbp.o(cbp.o(
                                cbp.o(cbp.o(cbp.o(cbp.b(aaz.a(iterable), azgVar, cbgVar), cbgVar, "isEnumConstant",
                                        null, new cbk(4)), cbgVar, "isEnumConstantNot", null, new cbk(5)), cbgVar,
                                        "type", azgVar.a, new cbi(cbgVar, i3)),
                                cbgVar, "typeCondition", azgVar.b, new cbk(6)), cbgVar, "genericType", null, new fq(8)),
                        cbgVar, "genericTypeCondition", null, new fq(9));
                zc zcVarB3 = dal.b(Field.class);
                if (zcVarB3.equals(dal.b(Method.class))) {
                    dpuVar3 = new dpu(baeVarO2, new cbn(cbgVar, 3), 1);
                } else if (zcVarB3.equals(dal.b(Constructor.class))) {
                    dpuVar3 = new dpu(baeVarO2, new cbn(cbgVar, 4), 1);
                } else {
                    if (!zcVarB3.equals(dal.b(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarO2).toString());
                    }
                    dpuVar3 = new dpu(baeVarO2, new cbn(cbgVar, 5), 1);
                }
                return dfv.ak(dpuVar3);
        }
    }
}
