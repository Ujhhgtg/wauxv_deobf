package me.hd.wauxv.hook;

import android.content.res.XModuleResources;
import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import me.hd.wauxv.obf.bhu;
import me.hd.wauxv.obf.bml;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.dcx;
import me.hd.wauxv.obf.dcy;
import me.hd.wauxv.obf.ens;
import me.hd.wauxv.obf.ewq;
import me.hd.wauxv.obf.exk;
import me.hd.wauxv.obf.exm;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Entry implements IXposedHookZygoteInit, IXposedHookLoadPackage {
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
        bml bmlVar = bml.a;
        bmlVar.getClass();
        if (loadPackageParam == null || !bml.b) {
            return;
        }
        bml.d(bmlVar, loadPackageParam, 5);
    }

    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) {
        Object objX;
        Object objX2;
        bml bmlVar = bml.a;
        bmlVar.getClass();
        if (startupParam == null) {
            return;
        }
        try {
            String strZ = cnb.z(-77159087471402L);
            String str = startupParam.modulePath;
            exm.a = true;
            exm.h = strZ;
            exm.i = str;
            try {
                int i = exk.a;
                objX2 = new exk(XModuleResources.createInstance(exm.i, (XResources) null));
            } catch (Throwable th) {
                objX2 = bhu.x(th);
            }
            if (objX2 instanceof dcx) {
                objX2 = null;
            }
            bml.d(bmlVar, null, 6);
            bml.b = true;
            objX = ens.a;
        } catch (Throwable th2) {
            objX = bhu.x(th2);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            ewq.g(4, cnb.z(-77073188125482L), thB);
        }
    }
}
