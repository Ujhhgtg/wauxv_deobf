package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aye {
    public static volatile ExecutorService a;
    public static final rf b = new rf();
    public static final afr c = new afr(new df(4));
    public static final cbm d = new cbm(18);
    public static final cbm e = new cbm(19);
    public static final cbm f = new cbm(20);
    public static boolean g;
    public static Method h;

    public static final boolean i(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (KotlinHelpers.r(cCharAt, 128) >= 0 || Character.isLetter(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public static void j(Throwable th, Throwable th2) {
        throwIfVar1IsNull(th, "<this>");
        throwIfVar1IsNull(th2, "exception");
        if (th != th2) {
            Integer num = bqy.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = ctu.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static void transformToAppend(StringBuilder sb, Object obj, IInvokable bgfVar) {
        if (bgfVar != null) {
            sb.append((CharSequence) bgfVar.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    public static final boolean l(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        throwIfVar1IsNull(bArr, com.umeng.analytics.pro.bt.at);
        throwIfVar1IsNull(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void m(erk erkVar, but butVar, bur burVar) {
        AutoCloseable autoCloseable;
        throwIfVar1IsNull(butVar, "registry");
        throwIfVar1IsNull(burVar, "lifecycle");
        erl erlVar = erkVar.m;
        if (erlVar != null) {
            synchronized (erlVar.a) {
                autoCloseable = (AutoCloseable) erlVar.b.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        dei deiVar = (dei) autoCloseable;
        if (deiVar == null || deiVar.c) {
            return;
        }
        deiVar.d(butVar, burVar);
        buh buhVar = burVar.c;
        if (buhVar == buh.b || buhVar.compareTo(buh.d) >= 0) {
            butVar.ag();
        } else {
            burVar.j(new akz(burVar, 3, butVar));
        }
    }

    public static final void n(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static int o(Context context, String str) {
        int iNoteProxyOpNoThrow;
        int iMyPid = Process.myPid();
        int iMyUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, iMyPid, iMyUid) != -1) {
            String strPermissionToOp = AppOpsManager.permissionToOp(str);
            if (strPermissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(iMyUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int iMyUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (iMyUid2 == iMyUid && Objects.equals(packageName2, packageName) && Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    iNoteProxyOpNoThrow = appOpsManager == null ? 1
                            : appOpsManager.checkOpNoThrow(strPermissionToOp, Binder.getCallingUid(), packageName);
                    if (iNoteProxyOpNoThrow == 0) {
                        iNoteProxyOpNoThrow = appOpsManager != null
                                ? appOpsManager.checkOpNoThrow(strPermissionToOp, iMyUid, ke.a(context))
                                : 1;
                    }
                } else {
                    iNoteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class))
                            .noteProxyOpNoThrow(strPermissionToOp, packageName);
                }
                if (iNoteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static das p(com.bumptech.glide.a aVar, ArrayList arrayList) {
        dcj ouVar;
        dcj rzVar;
        oz ozVar;
        int i;
        ContentResolver contentResolver;
        Class cls;
        oz ozVar2 = aVar.c;
        bva bvaVar = aVar.f;
        bhw bhwVar = aVar.e;
        Context applicationContext = bhwVar.getApplicationContext();
        bib bibVar = bhwVar.i;
        das dasVar = new das();
        akp akpVar = new akp();
        avw avwVar = dasVar.g;
        synchronized (avwVar) {
            avwVar.a.add(akpVar);
        }
        int i2 = Build.VERSION.SDK_INT;
        axm axmVar = new axm();
        avw avwVar2 = dasVar.g;
        synchronized (avwVar2) {
            avwVar2.a.add(axmVar);
        }
        Resources resources = applicationContext.getResources();
        ArrayList arrayListO = dasVar.o();
        sc scVar = new sc(applicationContext, arrayListO, ozVar2, bvaVar);
        epu epuVar = new epu(ozVar2, new dop(18));
        apq apqVar = new apq(dasVar.o(), resources.getDisplayMetrics(), ozVar2, bvaVar);
        if (i2 < 28 || !bibVar.a.containsKey(bhs.class)) {
            ry ryVar = new ry(apqVar, 0);
            ouVar = new ou(apqVar, 2, bvaVar);
            rzVar = ryVar;
        } else {
            rz rzVar2 = new rz(1);
            rzVar = new rz(0);
            ouVar = rzVar2;
        }
        if (i2 >= 28) {
            i = i2;
            ozVar = ozVar2;
            int i3 = 1;
            dasVar.n("Animation", InputStream.class, Drawable.class,
                    new fa(new DefaultConfig(arrayListO, i3, bvaVar), i3));
            dasVar.n("Animation", ByteBuffer.class, Drawable.class,
                    new fa(new DefaultConfig(arrayListO, 1, bvaVar), 0));
        } else {
            ozVar = ozVar2;
            i = i2;
        }
        dcl dclVar = new dcl(applicationContext);
        ow owVar = new ow(bvaVar);
        ek ekVar = new ek((byte) 0, 1);
        SyntheticClass syntheticClassVar = new SyntheticClass(11);
        ContentResolver contentResolver2 = applicationContext.getContentResolver();
        dasVar.l(ByteBuffer.class, new nu(9));
        dasVar.l(InputStream.class, new SyntheticPileOfMess(bvaVar));
        dasVar.n("Bitmap", ByteBuffer.class, Bitmap.class, rzVar);
        dasVar.n("Bitmap", InputStream.class, Bitmap.class, ouVar);
        String str = Build.FINGERPRINT;
        if ("robolectric".equals(str)) {
            contentResolver = contentResolver2;
            cls = ParcelFileDescriptor.class;
        } else {
            contentResolver = contentResolver2;
            cls = ParcelFileDescriptor.class;
            dasVar.n("Bitmap", cls, Bitmap.class, new ry(apqVar, 1));
        }
        oz ozVar3 = ozVar;
        dasVar.n("Bitmap", AssetFileDescriptor.class, Bitmap.class, new epu(ozVar3, new dop(15)));
        dasVar.n("Bitmap", cls, Bitmap.class, epuVar);
        arj arjVar = arj.o;
        dasVar.k(Bitmap.class, Bitmap.class, arjVar);
        dasVar.n("Bitmap", Bitmap.class, Bitmap.class, new azn(1));
        dasVar.m(Bitmap.class, owVar);
        dasVar.n("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new ou(resources, rzVar));
        dasVar.n("BitmapDrawable", InputStream.class, BitmapDrawable.class, new ou(resources, ouVar));
        dasVar.n("BitmapDrawable", cls, BitmapDrawable.class, new ou(resources, epuVar));
        dasVar.m(BitmapDrawable.class, new DefaultConfig(ozVar3, 8, owVar));
        dasVar.n("Animation", InputStream.class, bha.class, new dmv(arrayListO, scVar, bvaVar));
        dasVar.n("Animation", ByteBuffer.class, bha.class, scVar);
        dasVar.m(bha.class, new SyntheticClass(12));
        dasVar.k(dmg.class, dmg.class, arjVar);
        dasVar.n("Bitmap", dmg.class, Bitmap.class, new BitmapImageDecoder(ozVar3));
        dasVar.n("legacy_append", Uri.class, Drawable.class, dclVar);
        dasVar.n("legacy_append", Uri.class, Bitmap.class, new ou(dclVar, 1, ozVar3));
        dasVar.s(new sd(0));
        dasVar.k(File.class, ByteBuffer.class, new nu(10));
        dasVar.k(File.class, InputStream.class, new azs(new SyntheticClass(7)));
        dasVar.n("legacy_append", File.class, File.class, new azn(0));
        dasVar.k(File.class, cls, new azs(new SyntheticClass(6)));
        dasVar.k(File.class, File.class, arjVar);
        dasVar.s(new bpp(bvaVar));
        if (!"robolectric".equals(str)) {
            dasVar.s(new sd(2));
        }
        anr anrVar = new anr(applicationContext, 2);
        anr anrVar2 = new anr(applicationContext, 0);
        anr anrVar3 = new anr(applicationContext, 1);
        Class cls2 = Integer.TYPE;
        dasVar.k(cls2, InputStream.class, anrVar);
        dasVar.k(Integer.class, InputStream.class, anrVar);
        dasVar.k(cls2, AssetFileDescriptor.class, anrVar2);
        dasVar.k(Integer.class, AssetFileDescriptor.class, anrVar2);
        dasVar.k(cls2, Drawable.class, anrVar3);
        dasVar.k(Integer.class, Drawable.class, anrVar3);
        dasVar.k(Uri.class, InputStream.class, new anr(applicationContext, 10));
        dasVar.k(Uri.class, AssetFileDescriptor.class, new anr(applicationContext, 9));
        ov ovVar = new ov(resources, 3);
        ov ovVar2 = new ov(resources, 1);
        ov ovVar3 = new ov(resources, 2);
        dasVar.k(Integer.class, Uri.class, ovVar);
        dasVar.k(cls2, Uri.class, ovVar);
        dasVar.k(Integer.class, AssetFileDescriptor.class, ovVar2);
        dasVar.k(cls2, AssetFileDescriptor.class, ovVar2);
        dasVar.k(Integer.class, InputStream.class, ovVar3);
        dasVar.k(cls2, InputStream.class, ovVar3);
        dasVar.k(String.class, InputStream.class, new erp(12));
        dasVar.k(Uri.class, InputStream.class, new erp(12));
        dasVar.k(String.class, InputStream.class, new cbm(28));
        dasVar.k(String.class, cls, new cbm(27));
        dasVar.k(String.class, AssetFileDescriptor.class, new cbm(26));
        dasVar.k(Uri.class, InputStream.class, new ld(applicationContext.getAssets(), 1));
        dasVar.k(Uri.class, AssetFileDescriptor.class, new ld(applicationContext.getAssets(), 0));
        dasVar.k(Uri.class, InputStream.class, new anr(applicationContext, 6));
        dasVar.k(Uri.class, InputStream.class, new anr(applicationContext, 7));
        if (i >= 29) {
            dasVar.k(Uri.class, InputStream.class, new cwq(applicationContext, InputStream.class));
            dasVar.k(Uri.class, cls, new cwq(applicationContext, cls));
        }
        boolean zContainsKey = bibVar.a.containsKey(bhv.class);
        ContentResolver contentResolver3 = contentResolver;
        dasVar.k(Uri.class, InputStream.class, new eoh(contentResolver3, zContainsKey, 2));
        dasVar.k(Uri.class, cls, new eoh(contentResolver3, zContainsKey, 1));
        dasVar.k(Uri.class, AssetFileDescriptor.class, new eoh(contentResolver3, zContainsKey, 0));
        dasVar.k(Uri.class, InputStream.class, new dop(12));
        dasVar.k(URL.class, InputStream.class, new dop(11));
        dasVar.k(Uri.class, File.class, new anr(applicationContext, 5));
        dasVar.k(bid.class, InputStream.class, new SyntheticPileOfMess(0));
        dasVar.k(byte[].class, ByteBuffer.class, new nu(6));
        dasVar.k(byte[].class, InputStream.class, new nu(8));
        dasVar.k(Uri.class, Uri.class, arjVar);
        dasVar.k(Drawable.class, Drawable.class, arjVar);
        dasVar.n("legacy_append", Drawable.class, Drawable.class, new azn(2));
        dasVar.r(Bitmap.class, BitmapDrawable.class, new ov(resources, 0));
        dasVar.r(Bitmap.class, byte[].class, ekVar);
        dasVar.r(Drawable.class, byte[].class, new FactoryPools(ozVar3, ekVar, syntheticClassVar, 6));
        dasVar.r(bha.class, byte[].class, syntheticClassVar);
        epu epuVar2 = new epu(ozVar3, new dop(16));
        dasVar.n("legacy_append", ByteBuffer.class, Bitmap.class, epuVar2);
        dasVar.n("legacy_append", ByteBuffer.class, BitmapDrawable.class, new ou(resources, epuVar2));
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
        return dasVar;
    }

    public static final deh q(ahx ahxVar) {
        throwIfVar1IsNull(ahxVar, "<this>");
        dep depVar = (dep) ahxVar.b(d);
        if (depVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        err errVar = (err) ahxVar.b(e);
        if (errVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) ahxVar.b(f);
        String str = (String) ahxVar.b(erp.s);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        den denVarT = depVar.ak().t();
        Bundle bundle2 = null;
        dek dekVar = denVarT instanceof dek ? (dek) denVarT : null;
        if (dekVar == null) {
            throw new IllegalStateException(
                    "enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap = u(errVar).a;
        deh dehVar = (deh) linkedHashMap.get(str);
        if (dehVar != null) {
            return dehVar;
        }
        dekVar.f();
        Bundle bundle3 = dekVar.d;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = ResourcesCompat.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                dekVar.d = null;
            }
            bundle2 = bundle4;
        }
        deh dehVarM = bmy.m(bundle2, bundle);
        linkedHashMap.put(str, dehVarM);
        return dehVarM;
    }

    public static final void r(dep depVar) {
        buh buhVar = depVar.ap().c;
        if (buhVar != buh.b && buhVar != buh.c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (depVar.ak().t() == null) {
            dek dekVar = new dek(depVar.ak(), (err) depVar);
            depVar.ak().ad("androidx.lifecycle.internal.SavedStateHandlesProvider", dekVar);
            depVar.ap().j(new cyo(dekVar, 7));
        }
    }

    public static Executor s() {
        if (a == null) {
            synchronized (aye.class) {
                try {
                    if (a == null) {
                        a = Executors.newCachedThreadPool();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    public static final btd t(btd btdVar) {
        throwIfVar1IsNull(btdVar, "<this>");
        return btdVar.getDescriptor().f() ? btdVar : new cpe(btdVar);
    }

    public static final del u(err errVar) {
        dej dejVar = new dej();
        ahx ahxVarAi = errVar instanceof bkg ? ((bkg) errVar).ai() : ahv.a;
        throwIfVar1IsNull(dejVar, "factory");
        throwIfVar1IsNull(ahxVarAi, "extras");
        return (del) ((chm) new erp(errVar.aj(), dejVar, ahxVarAi).v)
                .ah("androidx.lifecycle.internal.SavedStateHandlesVM", dal.getKClassFromClass(del.class));
    }

    public static Activity v() {
        try {
            int i = 0;
            SyntheticPileOfMess bmuVarBh = dqc.bh(ajn.tryGetClassByClassName("android.app.ActivityThread" /* "android.app.ActivityThread" /* "android.app.ActivityThread" /* cnb.z(-73748883438378L)  */));
            Kotlin$Lazy kotlin$LazyVar = ep.a;
            ((Configuration) bmuVarBh.obj).processorResolver = FastKV.aa();
            MethodResolver methodResolverVarT = bmuVarBh.getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "currentActivityThread" /* "currentActivityThread" /* "currentActivityThread" /* cnb.z(-74217034873642L)  */;
            Object objE = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(new Object[0]);
            throwIfVar1IsNull(objE);
            FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objE).r();
            fieldResolverVarR.name = "mActivities" /* "mActivities" /* "mActivities" /* cnb.z(-74105365723946L)  */;
            Object objE2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue_();
            throwIfVar1IsNull(objE2);
            for (Object obj : ((Map) objE2).values()) {
                int i2 = 0;
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj).r();
                fieldResolverVarR2.name = "paused" /* "paused" /* "paused" /* cnb.z(-74019466378026L)  */;
                Object objE3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue_();
                throwIfVar1IsNull(objE3);
                if (!((Boolean) objE3).booleanValue()) {
                    FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).r();
                    fieldResolverVarR3.name = "activity" /* "activity" /* "activity" /* cnb.z(-74040941214506L)  */;
                    return (Activity) ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).getValue_();
                }
            }
            return null;
        } catch (Exception e2) {
            ArrayList arrayList = Logger.a;
            Logger.logE("getCurrentActivity Failed" /* "getCurrentActivity Failed" /* "getCurrentActivity Failed" /* cnb.z(-73950746901290L)  */, e2, 12);
            return null;
        }
    }

    public static long w(int i, String str, String str2, long j)
            throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        MicroMsgMsgInfoDexClassFind cgeVar = MicroMsgMsgInfoDexClassFind.INSTANCE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", (Integer) 0);
        contentValues.put("msgSvrId", Long.valueOf(((long) cyj.f.b()) + j));
        contentValues.put("type", Integer.valueOf(i));
        contentValues.put("status", (Integer) 3);
        contentValues.put("createTime", Long.valueOf(j));
        contentValues.put("talker", str);
        contentValues.put("content", str2);
        Object objC = ReflectionWrapper.createInstanceWithArgs(StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE), new Object[0]);
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objC).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "convertFrom";
        methodResolverVarT.setParams(Arrays.copyOf(new Object[] { dal.getKClassFromClass(ContentValues.class), dal.getKClassFromClass(Boolean.TYPE) }, 2));
        methodResolverVarT.enableSuperclass();
        ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(contentValues, Boolean.TRUE);
        Method methodBb = StaticHelpers7.toDexMethod(cgw.a);
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(ServiceManagerDexFinder.getServiceByClass(StaticHelpers7.toDexClass(dmt.a))).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.returnType = StaticHelpers7.toDexClass(cgv.a);
        Object objE = ((MethodHookWrapper) bjs.resolveFirstMethodWithoutParams(methodResolverVarT2)).invokeAndThrowIfFailed(new Object[0]);
        throwIfVar1IsNull(objE);
        Object objInvoke = methodBb.invoke(objE, objC);
        throwIfVar1IsNull(objInvoke, "null cannot be cast to non-null type kotlin.Long" /* "null cannot be cast to non-null type kotlin.Long" /* "null cannot be cast to non-null type kotlin.Long" /* cnb.z(-370294900390698L)  */);
        return ((Long) objInvoke).longValue();
    }

    public static final Object x(Object obj) {
        return obj instanceof abr ? FastKV.getFailureFromException(((abr) obj).c) : obj;
    }

    public static byte[] y(ArrayList arrayList) {
        byte[] bArr = new byte[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            bArr[i] = ((emp) it.next()).a;
            i++;
        }
        return bArr;
    }

    public abstract void aa();

    public abstract void z();
}
