package me.hd.wauxv.plugin.api.method;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.icu.util.Calendar;
import bsh.classpath.BshLoaderManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import me.hd.wauxv.obf.aye;
import me.hd.wauxv.obf.bmo;
import me.hd.wauxv.obf.SyntheticPileOfMess;
import me.hd.wauxv.obf.bpy;
import me.hd.wauxv.obf.but;
import me.hd.wauxv.obf.chm;
import me.hd.wauxv.obf.cme;
import me.hd.wauxv.obf.cmq;
import me.hd.wauxv.obf.cmr;
import me.hd.wauxv.obf.cot;
import me.hd.wauxv.obf.cpc;
import me.hd.wauxv.obf.ctx;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.cud;
import me.hd.wauxv.obf.cuh;
import me.hd.wauxv.obf.dgc;
import me.hd.wauxv.obf.dgd;
import me.hd.wauxv.obf.dnc;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.Kotlin$Lazy;
import me.hd.wauxv.obf.StaticHelpers7;
import me.hd.wauxv.obf.eu;
import me.hd.wauxv.obf.ewq;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginOtherMethod {
    public final ctx a;

    public PluginOtherMethod(ctx ctxVar) {
        this.a = ctxVar;
    }

    @cty
    public final void eval(String str) {
        this.a.o().eval(str);
    }

    @cty
    public final Activity getTopActivity() {
        return aye.v();
    }

    @cty
    public final void loadDex(String str) throws IOException {
        boolean zIsAbsolute = new File(str).isAbsolute();
        ctx ctxVar = this.a;
        String canonicalPath = (zIsAbsolute ? new File(str) : new File(ctxVar.a, str)).getCanonicalPath();
        ctxVar.getClass();
        BshLoaderManager.addLoader(BshLoaderManager.getDexLoader(canonicalPath, cud.class.getClassLoader()));
    }

    @cty
    public final void loadJava(String str) {
        boolean zIsAbsolute = new File(str).isAbsolute();
        ctx ctxVar = this.a;
        ctxVar.o().source((zIsAbsolute ? new File(str) : new File(ctxVar.a, str)).getCanonicalPath());
    }

    @cty
    public final void log(Object obj) throws IOException {
        ArrayList arrayList = ewq.a;
        StringBuilder sb = new StringBuilder();
        sb.append("Plugin[" /* "Plugin[" /* "Plugin[" /* cnb.z(-401033981328170L)  */);
        ctx ctxVar = this.a;
        sb.append(ctxVar.f);
        sb.append("]: " /* "]: " /* "]: " /* cnb.z(-400999621589802L)  */);
        sb.append(obj);
        ewq.d(14, sb.toString());
        SyntheticPileOfMess bmuVar = ctxVar.m;
        bmuVar.writePluginLog(new cuh(((ctx) bmuVar.obj).f, "D" /* "D" /* "D" /* cnb.z(-390322332891946L)  */, String.valueOf(obj)));
    }

    @cty
    public final void notify(String str, String str2) {
        bmo.a.getClass();
        Context contextN = bmo.n();
        bpy bpyVar = new bpy("WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-400969556818730L)  */);
        bpyVar.b = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-400939492047658L)  */;
        but butVar = new but(bpyVar);
        chm chmVar = new chm();
        chmVar.c = contextN;
        chmVar.d = butVar;
        chmVar.e = "";
        chmVar.f = "";
        chmVar.e = this.a.f + ": " /* ": " /* ": " /* cnb.z(-400857887669034L)  */ + str;
        chmVar.f = str2;
        but butVar2 = new but(chmVar);
        Kotlin$Lazy kotlin$LazyVar = (Kotlin$Lazy) new but(butVar2).c;
        cpc cpcVar = (cpc) kotlin$LazyVar.getValue();
        cot cotVar = (cot) ((Kotlin$Lazy) butVar.c).getValue();
        cpcVar.getClass();
        NotificationChannel notificationChannel = new NotificationChannel(cotVar.a, cotVar.b, cotVar.c);
        notificationChannel.setDescription(cotVar.d);
        notificationChannel.setGroup(null);
        notificationChannel.setShowBadge(true);
        notificationChannel.setSound(cotVar.e, cotVar.f);
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(0);
        notificationChannel.setVibrationPattern(null);
        notificationChannel.enableVibration(false);
        cpcVar.g.createNotificationChannel(notificationChannel);
        Notification notification = (Notification) ((Kotlin$Lazy) butVar2.c).getValue();
        if (dnj.ak("")) {
            ((cpc) kotlin$LazyVar.getValue()).h(null, notification);
        } else {
            ((cpc) kotlin$LazyVar.getValue()).h("", notification);
        }
        ((Number) eu.a.getValue()).intValue();
    }

    @cty
    public final void toast(String str) {
        dnc.g(null, 3, this.a.f + ": " /* ": " /* ": " /* cnb.z(-400948081982250L)  */ + str);
    }

    @cty
    public final void uploadDeviceStep(long j)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        cmr.a.getClass();
        Constructor constructorBa = StaticHelpers7.ba(cmq.a);
        String strZ = "" /* "" /* "" /* cnb.z(-140136192932650L)  */;
        String strZ2 = "gh_43f2581f6fd6" /* "gh_43f2581f6fd6" /* "gh_43f2581f6fd6" /* cnb.z(-140131897965354L)  */;
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long j2 = 1000;
        Integer numValueOf = Integer.valueOf((int) (calendar.getTimeInMillis() / j2));
        Integer numValueOf2 = Integer.valueOf((int) (System.currentTimeMillis() / j2));
        Integer numValueOf3 = Integer.valueOf((int) j);
        dgd.a.getClass();
        Object objInvoke = StaticHelpers7.bb(dgc.a).invoke(null, null);
        throwIfVar1IsNull(objInvoke);
        cme.b(cme.a, constructorBa.newInstance(strZ, strZ2, numValueOf, numValueOf2, numValueOf3, objInvoke, 1));
    }
}
