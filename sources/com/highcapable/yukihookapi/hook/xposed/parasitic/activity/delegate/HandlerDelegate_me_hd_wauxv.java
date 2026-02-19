package com.highcapable.yukihookapi.hook.xposed.parasitic.activity.delegate;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.hd.wauxv.obf.StaticHelpers5;
import me.hd.wauxv.obf.FieldResolver;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.FastKV;
import me.hd.wauxv.obf.bkc;
import me.hd.wauxv.obf.SyntheticPileOfMess;
import me.hd.wauxv.obf.btc;
import me.hd.wauxv.obf.Configuration;
import me.hd.wauxv.obf.MethodResolver;
import me.hd.wauxv.obf.MethodHookWrapper;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dcx;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.Kotlin$Lazy;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.ep;
import me.hd.wauxv.obf.eu;
import me.hd.wauxv.obf.FactoryPools;
import me.hd.wauxv.obf.ki;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerDelegate_me_hd_wauxv implements Handler.Callback {
    private final Handler.Callback baseInstance;

    public HandlerDelegate_me_hd_wauxv(Handler.Callback callback) {
        this.baseInstance = callback;
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x0063 */
    /* JADX WARN: Found duplicated region for block: B:64:0x01bf */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws IllegalAccessException {
        Bundle bundle;
        Object objX;
        List list;
        Bundle bundle2;
        Object objF;
        Object objX2;
        bkc bkcVar = bkc.a;
        Handler.Callback callback = this.baseInstance;
        bkcVar.getClass();
        btc[] btcVarArr = bkc.b;
        int i = message.what;
        if (i == 100) {
            int i2 = 0;
            SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(message.obj);
            Kotlin$Lazy kotlin$LazyVar = ep.a;
            ((Configuration) bmuVarBi.obj).processorResolver = FastKV.aa();
            bmuVarBi.setHookOptional(true);
            FieldResolver fieldResolverVarR = bmuVarBi.r();
            fieldResolverVarR.name = "intent";
            azk azkVar = (azk) StaticHelpers5.g(fieldResolverVarR.resolve());
            Intent intent = azkVar != null ? (Intent) azkVar.e() : null;
            azk azkVar2 = (azk) bkc.e.getValue();
            if (azkVar2 != null) {
                azk azkVar3 = new azk(azkVar2.a);
                azkVar3.dexFind(intent);
                try {
                    objX = azkVar3.e();
                } catch (Throwable th) {
                    objX = FastKV.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                bundle = (Bundle) objX;
            } else {
                bundle = null;
            }
            if (bundle != null) {
                ki.a.getClass();
                Application applicationH = ki.h();
                bundle.setClassLoader(applicationH != null ? applicationH.getClassLoader() : null);
            }
            if (intent != null && intent.hasExtra("")) {
                azkVar.f(intent.getParcelableExtra(""));
            }
        } else if (i == 159) {
            int i3 = 0;
            FactoryPools factoryPoolsVar = bkc.d;
            btc btcVar = btcVarArr[1];
            SyntheticPileOfMess bmuVarBh = dqc.bh(factoryPoolsVar.w());
            Kotlin$Lazy kotlin$LazyVar2 = ep.a;
            ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
            bmuVarBh.setHookOptional(true);
            MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "getCallbacks";
            MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT.findMethods());
            if (methodHookWrapperVar != null) {
                methodHookWrapperVar.dexFind(message.obj);
                list = (List) methodHookWrapperVar.i(new Object[0]);
                if (list == null || list.isEmpty()) {
                    list = null;
                }
            } else {
                list = null;
            }
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (dnj.ab(obj.getClass().getName(), "LaunchActivityItem", false)) {
                        arrayList.add(obj);
                    }
                }
                for (Object obj2 : arrayList) {
                    int i4 = 0;
                    SyntheticPileOfMess bmuVarBi2 = dqc.getWrapperConfiguration(obj2);
                    bmuVarBi2.setHookOptional(true);
                    FieldResolver fieldResolverVarR2 = bmuVarBi2.r();
                    fieldResolverVarR2.name = "mIntent";
                    azk azkVar4 = (azk) StaticHelpers5.g(fieldResolverVarR2.resolve());
                    Intent intent2 = azkVar4 != null ? (Intent) azkVar4.e() : null;
                    bkc.a.getClass();
                    azk azkVar5 = (azk) bkc.e.getValue();
                    if (azkVar5 != null) {
                        azk azkVar6 = new azk(azkVar5.a);
                        azkVar6.dexFind(intent2);
                        try {
                            objX2 = azkVar6.e();
                        } catch (Throwable th2) {
                            objX2 = FastKV.x(th2);
                        }
                        if (objX2 instanceof dcx) {
                            objX2 = null;
                        }
                        bundle2 = (Bundle) objX2;
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        ki.a.getClass();
                        Application applicationH2 = ki.h();
                        bundle2.setClassLoader(applicationH2 != null ? applicationH2.getClassLoader() : null);
                    }
                    if (intent2 != null && intent2.hasExtra("")) {
                        Intent intent3 = (Intent) intent2.getParcelableExtra("");
                        if (eu.b(31)) {
                            FactoryPools factoryPoolsVar2 = bkc.c;
                            btc btcVar2 = btcVarArr[0];
                            SyntheticPileOfMess bmuVarBh2 = dqc.bh(factoryPoolsVar2.w());
                            Kotlin$Lazy kotlin$LazyVar3 = ep.a;
                            ((Configuration) bmuVarBh2.obj).processorResolver = FastKV.aa();
                            bmuVarBh2.setHookOptional(true);
                            MethodResolver methodResolverVarT2 = bmuVarBh2.getMethodResolverBasedOnPreviouslyProvidedConfig();
                            methodResolverVarT2.name = "currentActivityThread";
                            MethodHookWrapper methodHookWrapperVar2 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT2.findMethods());
                            Object objE = methodHookWrapperVar2 != null ? methodHookWrapperVar2.e(new Object[0]) : null;
                            SyntheticPileOfMess bmuVarBi3 = dqc.getWrapperConfiguration(message.obj);
                            ((Configuration) bmuVarBi3.obj).processorResolver = FastKV.aa();
                            bmuVarBi3.setHookOptional(true);
                            MethodResolver methodResolverVarT3 = bmuVarBi3.getMethodResolverBasedOnPreviouslyProvidedConfig();
                            methodResolverVarT3.name = "getActivityToken";
                            MethodHookWrapper methodHookWrapperVar3 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT3.findMethods());
                            Object objF2 = methodHookWrapperVar3 != null ? methodHookWrapperVar3.f(new Object[0]) : null;
                            if (objE != null) {
                                SyntheticPileOfMess bmuVarBi4 = dqc.getWrapperConfiguration(objE);
                                ((Configuration) bmuVarBi4.obj).processorResolver = FastKV.aa();
                                bmuVarBi4.setHookOptional(true);
                                MethodResolver methodResolverVarT4 = bmuVarBi4.getMethodResolverBasedOnPreviouslyProvidedConfig();
                                methodResolverVarT4.name = "getLaunchingActivity";
                                methodResolverVarT4.setParams(Arrays.copyOf(new Object[] { dal.b(IBinder.class) }, 1));
                                MethodHookWrapper methodHookWrapperVar4 = (MethodHookWrapper) StaticHelpers5.g(methodResolverVarT4.findMethods());
                                objF = methodHookWrapperVar4 != null ? methodHookWrapperVar4.f(objF2) : null;
                            }
                            if (objF != null) {
                                SyntheticPileOfMess bmuVarBi5 = dqc.getWrapperConfiguration(objF);
                                ((Configuration) bmuVarBi5.obj).processorResolver = FastKV.aa();
                                bmuVarBi5.setHookOptional(true);
                                FieldResolver fieldResolverVarR3 = bmuVarBi5.r();
                                fieldResolverVarR3.name = "intent";
                                azk azkVar7 = (azk) StaticHelpers5.g(fieldResolverVarR3.resolve());
                                if (azkVar7 != null) {
                                    azkVar7.f(intent3);
                                }
                            }
                        }
                        azkVar4.f(intent3);
                    }
                }
            }
        }
        if (callback != null) {
            return callback.handleMessage(message);
        }
        return false;
    }
}
