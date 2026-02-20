package me.hd.wauxv.plugin.api.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.hd.wauxv.obf.aem;
import me.hd.wauxv.obf.aen;
import me.hd.wauxv.obf.aeo;
import me.hd.wauxv.obf.FieldResolver;
import me.hd.wauxv.obf.BoundField;
import me.hd.wauxv.obf.IFunction0;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.MethodResolver;
import me.hd.wauxv.obf.MethodHookWrapper;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.ServiceManagerDexFinder;
import me.hd.wauxv.obf.dmt;
import me.hd.wauxv.obf.dmu;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.StaticHelpers7;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginVipMethod {
    public static void a(IFunction0 bfuVar) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        aeo aeoVar = aeo.a;
        String strZ = "gh_6f586343034c" /* "gh_6f586343034c" /* "gh_6f586343034c" /* cnb.z(-401128470608682L)  */;
        aeoVar.getClass();
        Method methodBb = StaticHelpers7.toDexMethod(aen.a);
        dmu dmuVar = dmu.a;
        dmuVar.getClass();
        int i = 0;
        ServiceManagerDexFinder.INSTANCE.getClass();
        dmuVar.getClass();
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ServiceManagerDexFinder.getServiceByClass(StaticHelpers7.toDexClass(dmt.a))).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.returnType = StaticHelpers7.toDexClass(aem.a);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        Object objInvoke = methodBb.invoke(objE, strZ, Boolean.FALSE);
        throwIfVar1IsNull(objInvoke);
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objInvoke).r();
        fieldResolverVarR.name = "field_type" /* "field_type" /* "field_type" /* cnb.z(-382930694175530L)  */;
        Object objE2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
        throwIfVar1IsNull(objE2);
        if ((((Number) objE2).intValue() & 1) == 0) {
            throw new RuntimeException("no permission to invoke method" /* "no permission to invoke method" /* "no permission to invoke method" /* cnb.z(-401059751131946L)  */);
        }
        bfuVar.invoke();
    }

    @cty
    public final void confirmTransfer(final String str, final String str2, final String str3, final int i)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        a(new IFunction0() { // from class: me.hd.wauxv.obf.cul
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws NoSuchMethodException {
                cme.tryGetClassByName(cme.a, cmp.tryGetClassByName(cmp.a, str, str2, "confirm" /*
                                                                                                * cnb.z(-
                                                                                                * 115594749803306L)
                                                                                                */, str3, i));
                return ens.a;
            }
        });
    }

    @cty
    public final void refuseTransfer(final String str, final String str2, final String str3)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        a(new IFunction0() { // from class: me.hd.wauxv.obf.cum
            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws NoSuchMethodException {
                cme.tryGetClassByName(cme.a, cmp.tryGetClassByName(cmp.a, str, str2, "refuse" /*
                                                                                               * cnb.z(-
                                                                                               * 115560390064938L)
                                                                                               */, str3, 0));
                return ens.a;
            }
        });
    }
}
