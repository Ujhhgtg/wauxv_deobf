package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbo implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ MemberResolver b;
    public final /* synthetic */ Configuration c;

    public /* synthetic */ cbo(MemberResolver memberResolverVar, Configuration configurationVar, int i) {
        this.a = i;
        this.b = memberResolverVar;
        this.c = configurationVar;
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
        Configuration configurationVar = this.c;
        MemberResolver memberResolverVar = this.b;
        switch (i) {
            case 0:
                Class cls = (Class) obj;
                MethodResolver methodResolverVar = (MethodResolver) memberResolverVar;
                cbm cbmVar2 = configurationVar.processorResolver;
                if (cbmVar2 != null) {
                    cbmVar = cbmVar2;
                }
                bae baeVarO = cbp
                        .o(cbp.o(
                                cbp.o(cbp.o(
                                        cbp.o(cbp.o(cbp.f(cbp.b(StaticHelpers5.a(cbmVar.c(cls)), methodResolverVar, configurationVar), methodResolverVar, configurationVar),
                                                        configurationVar, "returnType", methodResolverVar.returnType, new cbi(configurationVar, i2)), configurationVar,
                                                "returnTypeCondition", methodResolverVar.returnTypeCondition, new fq(15)),
                                        configurationVar, "isBridge", null, new fq(17)), configurationVar, "isBridgeNot", null, new fq(25)),
                                configurationVar, "isDefault", null, new cbk(2)), configurationVar, "isDefaultNot", null, new cbk(3));
                KClass zcVarB = dal.getKClassFromClass(Method.class);
                if (zcVarB.equals(dal.getKClassFromClass(Method.class))) {
                    dpuVar = new dpu(baeVarO, new cbn(configurationVar, 6), 1);
                } else if (zcVarB.equals(dal.getKClassFromClass(Constructor.class))) {
                    dpuVar = new dpu(baeVarO, new cbn(configurationVar, 7), 1);
                } else {
                    if (!zcVarB.equals(dal.getKClassFromClass(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarO).toString());
                    }
                    dpuVar = new dpu(baeVarO, new cbn(configurationVar, 8), 1);
                }
                return dfv.ak(dpuVar);
            case 1:
                Class cls2 = (Class) obj;
                adt adtVar = (adt) memberResolverVar;
                cbm cbmVar3 = configurationVar.processorResolver;
                if (cbmVar3 != null) {
                    cbmVar = cbmVar3;
                }
                bae baeVarF = cbp.f(cbp.b(StaticHelpers5.a(cbmVar.b(cls2)), adtVar, configurationVar), adtVar, configurationVar);
                KClass zcVarB2 = dal.getKClassFromClass(Constructor.class);
                if (zcVarB2.equals(dal.getKClassFromClass(Method.class))) {
                    dpuVar2 = new dpu(baeVarF, new cbn(configurationVar, 0), 1);
                } else if (zcVarB2.equals(dal.getKClassFromClass(Constructor.class))) {
                    dpuVar2 = new dpu(baeVarF, new cbn(configurationVar, 1), 1);
                } else {
                    if (!zcVarB2.equals(dal.getKClassFromClass(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarF).toString());
                    }
                    dpuVar2 = new dpu(baeVarF, new cbn(configurationVar, 2), 1);
                }
                return dfv.ak(dpuVar2);
            default:
                Class cls3 = (Class) obj;
                FieldResolver fieldResolverVar = (FieldResolver) memberResolverVar;
                cbm cbmVar4 = configurationVar.processorResolver;
                if (cbmVar4 != null) {
                    cbmVar = cbmVar4;
                }
                try {
                    objX = SomeStaticHelpers.arrayToList(cls3.getDeclaredFields());
                    break;
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                Throwable thB = Success.exceptionOrNull(objX);
                if (thB != null) {
                    Kotlin$Lazy kotlin$LazyVar = LogConfig.isDevelopmentMode;
                    LogConfig.logE("Failed to get declared fields in " + cbmVar + " because got an exception.", thB);
                }
                if (objX instanceof Failure) {
                    objX = null;
                }
                Iterable iterable = (List) objX;
                if (iterable == null) {
                    iterable = EmptyReadonlyList.INSTANCE;
                }
                bae baeVarO2 = cbp.o(
                        cbp.o(cbp.o(
                                cbp.o(cbp.o(cbp.o(cbp.b(StaticHelpers5.a(iterable), fieldResolverVar, configurationVar), configurationVar, "isEnumConstant",
                                        null, new cbk(4)), configurationVar, "isEnumConstantNot", null, new cbk(5)), configurationVar,
                                        "type", fieldResolverVar.fieldType, new cbi(configurationVar, i3)),
                                configurationVar, "typeCondition", fieldResolverVar.b, new cbk(6)), configurationVar, "genericType", null, new fq(8)),
                        configurationVar, "genericTypeCondition", null, new fq(9));
                KClass zcVarB3 = dal.getKClassFromClass(Field.class);
                if (zcVarB3.equals(dal.getKClassFromClass(Method.class))) {
                    dpuVar3 = new dpu(baeVarO2, new cbn(configurationVar, 3), 1);
                } else if (zcVarB3.equals(dal.getKClassFromClass(Constructor.class))) {
                    dpuVar3 = new dpu(baeVarO2, new cbn(configurationVar, 4), 1);
                } else {
                    if (!zcVarB3.equals(dal.getKClassFromClass(Field.class))) {
                        throw new IllegalStateException(("Unsupported member type: " + baeVarO2).toString());
                    }
                    dpuVar3 = new dpu(baeVarO2, new cbn(configurationVar, 5), 1);
                }
                return dfv.ak(dpuVar3);
        }
    }
}
