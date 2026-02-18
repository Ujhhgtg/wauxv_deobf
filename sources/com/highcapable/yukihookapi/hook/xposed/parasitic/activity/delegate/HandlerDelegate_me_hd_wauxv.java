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
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.azg;
import me.hd.wauxv.obf.azk;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bkc;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.btc;
import me.hd.wauxv.obf.bte;
import me.hd.wauxv.obf.cbg;
import me.hd.wauxv.obf.cde;
import me.hd.wauxv.obf.cdk;
import me.hd.wauxv.obf.dal;
import me.hd.wauxv.obf.dcx;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dov;
import me.hd.wauxv.obf.dqc;
import me.hd.wauxv.obf.ep;
import me.hd.wauxv.obf.eu;
import me.hd.wauxv.obf.jx;
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
            int i2 = bte.a;
            bmu bmuVarBi = dqc.bi(message.obj);
            dov dovVar = ep.a;
            ((cbg) bmuVarBi.h).c = bhu.aa();
            bmuVarBi.v(true);
            azg azgVarR = bmuVarBi.r();
            azgVarR.ab = "intent";
            azk azkVar = (azk) aaz.g(azgVarR.c());
            Intent intent = azkVar != null ? (Intent) azkVar.e() : null;
            azk azkVar2 = (azk) bkc.e.getValue();
            if (azkVar2 != null) {
                azk azkVar3 = new azk(azkVar2.a);
                azkVar3.dexFind(intent);
                try {
                    objX = azkVar3.e();
                } catch (Throwable th) {
                    objX = bhu.x(th);
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
            int i3 = bte.a;
            jx jxVar = bkc.d;
            btc btcVar = btcVarArr[1];
            bmu bmuVarBh = dqc.bh(jxVar.w());
            dov dovVar2 = ep.a;
            ((cbg) bmuVarBh.h).c = bhu.aa();
            bmuVarBh.v(true);
            cde cdeVarT = bmuVarBh.t();
            cdeVarT.ab = "getCallbacks";
            cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
            if (cdkVar != null) {
                cdkVar.dexFind(message.obj);
                list = (List) cdkVar.i(new Object[0]);
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
                    int i4 = bte.a;
                    bmu bmuVarBi2 = dqc.bi(obj2);
                    bmuVarBi2.v(true);
                    azg azgVarR2 = bmuVarBi2.r();
                    azgVarR2.ab = "mIntent";
                    azk azkVar4 = (azk) aaz.g(azgVarR2.c());
                    Intent intent2 = azkVar4 != null ? (Intent) azkVar4.e() : null;
                    bkc.a.getClass();
                    azk azkVar5 = (azk) bkc.e.getValue();
                    if (azkVar5 != null) {
                        azk azkVar6 = new azk(azkVar5.a);
                        azkVar6.dexFind(intent2);
                        try {
                            objX2 = azkVar6.e();
                        } catch (Throwable th2) {
                            objX2 = bhu.x(th2);
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
                            jx jxVar2 = bkc.c;
                            btc btcVar2 = btcVarArr[0];
                            bmu bmuVarBh2 = dqc.bh(jxVar2.w());
                            dov dovVar3 = ep.a;
                            ((cbg) bmuVarBh2.h).c = bhu.aa();
                            bmuVarBh2.v(true);
                            cde cdeVarT2 = bmuVarBh2.t();
                            cdeVarT2.ab = "currentActivityThread";
                            cdk cdkVar2 = (cdk) aaz.g(cdeVarT2.aj());
                            Object objE = cdkVar2 != null ? cdkVar2.e(new Object[0]) : null;
                            bmu bmuVarBi3 = dqc.bi(message.obj);
                            ((cbg) bmuVarBi3.h).c = bhu.aa();
                            bmuVarBi3.v(true);
                            cde cdeVarT3 = bmuVarBi3.t();
                            cdeVarT3.ab = "getActivityToken";
                            cdk cdkVar3 = (cdk) aaz.g(cdeVarT3.aj());
                            Object objF2 = cdkVar3 != null ? cdkVar3.f(new Object[0]) : null;
                            if (objE != null) {
                                bmu bmuVarBi4 = dqc.bi(objE);
                                ((cbg) bmuVarBi4.h).c = bhu.aa();
                                bmuVarBi4.v(true);
                                cde cdeVarT4 = bmuVarBi4.t();
                                cdeVarT4.ab = "getLaunchingActivity";
                                cdeVarT4.z(Arrays.copyOf(new Object[] { dal.b(IBinder.class) }, 1));
                                cdk cdkVar4 = (cdk) aaz.g(cdeVarT4.aj());
                                objF = cdkVar4 != null ? cdkVar4.f(objF2) : null;
                            }
                            if (objF != null) {
                                bmu bmuVarBi5 = dqc.bi(objF);
                                ((cbg) bmuVarBi5.h).c = bhu.aa();
                                bmuVarBi5.v(true);
                                azg azgVarR3 = bmuVarBi5.r();
                                azgVarR3.ab = "intent";
                                azk azkVar7 = (azk) aaz.g(azgVarR3.c());
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
