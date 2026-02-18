package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.aji;
import me.hd.wauxv.obf.anr;
import me.hd.wauxv.obf.awd;
import me.hd.wauxv.obf.awp;
import me.hd.wauxv.obf.bhw;
import me.hd.wauxv.obf.bhz;
import me.hd.wauxv.obf.bia;
import me.hd.wauxv.obf.bib;
import me.hd.wauxv.obf.bmu;
import me.hd.wauxv.obf.bmy;
import me.hd.wauxv.obf.bva;
import me.hd.wauxv.obf.byg;
import me.hd.wauxv.obf.byk;
import me.hd.wauxv.obf.cbr;
import me.hd.wauxv.obf.cbs;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.dca;
import me.hd.wauxv.obf.dcb;
import me.hd.wauxv.obf.dd;
import me.hd.wauxv.obf.dhx;
import me.hd.wauxv.obf.eot;
import me.hd.wauxv.obf.ku;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.oz;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ComponentCallbacks2 {
    public static volatile a a;
    public static volatile boolean b;
    public final oz c;
    public final byk d;
    public final bhw e;
    public final bva f;
    public final dcb g;
    public final nu h;
    public final ArrayList i = new ArrayList();

    public a(Context context, awd awdVar, byk bykVar, oz ozVar, bva bvaVar, dcb dcbVar, nu nuVar, awp awpVar, ku kuVar, List list, ArrayList arrayList, cna cnaVar, bib bibVar) {
        this.c = ozVar;
        this.f = bvaVar;
        this.d = bykVar;
        this.g = dcbVar;
        this.h = nuVar;
        this.e = new bhw(context, bvaVar, new dhx(this, arrayList, cnaVar), new awp(18), awpVar, kuVar, list, awdVar, bibVar);
    }

    public static a j(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (a == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
            } catch (InstantiationException e2) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e2);
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e4);
            }
            synchronized (a.class) {
                if (a == null) {
                    if (b) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    b = true;
                    try {
                        k(context, generatedAppGlideModule);
                        b = false;
                    } catch (Throwable th) {
                        b = false;
                        throw th;
                    }
                }
            }
        }
        return a;
    }

    public static void k(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        ku kuVar = new ku(0);
        aji ajiVar = new aji(1);
        awp awpVar = new awp(13);
        Context applicationContext = context.getApplicationContext();
        List list = Collections.EMPTY_LIST;
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                if (Log.isLoggable("ManifestParser", 2)) {
                    Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                }
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        bmy.z(str);
                        throw null;
                    }
                }
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Finished loading Glide modules");
                }
            } else if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Got null app info metadata");
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (Log.isLoggable("ManifestParser", 6)) {
                Log.e("ManifestParser", "Failed to parse glide modules", e);
            }
        }
        if (generatedAppGlideModule != null && !new HashSet().isEmpty()) {
            new HashSet();
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                throw yg.d(it);
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator it2 = arrayList.iterator();
            if (it2.hasNext()) {
                throw yg.d(it2);
            }
        }
        Iterator it3 = arrayList.iterator();
        if (it3.hasNext()) {
            throw yg.d(it3);
        }
        dd ddVar = new dd(1);
        if (bia.b == 0) {
            bia.b = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i = bia.b;
        if (TextUtils.isEmpty("source")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: source");
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bia biaVar = new bia(new ThreadPoolExecutor(i, i, 0L, timeUnit, new PriorityBlockingQueue(), new bhz(ddVar, "source", false)));
        dd ddVar2 = new dd(1);
        if (TextUtils.isEmpty("disk-cache")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: disk-cache");
        }
        bia biaVar2 = new bia(new ThreadPoolExecutor(1, 1, 0L, timeUnit, new PriorityBlockingQueue(), new bhz(ddVar2, "disk-cache", true)));
        if (bia.b == 0) {
            bia.b = Math.min(4, Runtime.getRuntime().availableProcessors());
        }
        int i2 = bia.b >= 4 ? 2 : 1;
        dd ddVar3 = new dd(1);
        if (TextUtils.isEmpty("animation")) {
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: animation");
        }
        bia biaVar3 = new bia(new ThreadPoolExecutor(i2, i2, 0L, timeUnit, new PriorityBlockingQueue(), new bhz(ddVar3, "animation", true)));
        cbs cbsVar = new cbs(new cbr(applicationContext));
        nu nuVar = new nu(16);
        int i3 = cbsVar.a;
        oz bygVar = i3 > 0 ? new byg(i3) : new nu(2);
        bva bvaVar = new bva(cbsVar.c);
        byk bykVar = new byk(cbsVar.b);
        anr anrVar = new anr(applicationContext, 4);
        bmu bmuVar = new bmu();
        bmuVar.h = anrVar;
        a aVar = new a(applicationContext, new awd(bykVar, bmuVar, biaVar2, biaVar, new bia(new ThreadPoolExecutor(0, Integer.MAX_VALUE, bia.a, timeUnit, new SynchronousQueue(), new bhz(new dd(1), "source-unlimited", false))), biaVar3), bykVar, bygVar, bvaVar, new dcb(), nuVar, awpVar, kuVar, Collections.EMPTY_LIST, arrayList, generatedAppGlideModule, new bib(ajiVar));
        applicationContext.registerComponentCallbacks(aVar);
        a = aVar;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        eot.d();
        this.d.h(0L);
        this.c.aa();
        bva bvaVar = this.f;
        synchronized (bvaVar) {
            bvaVar.h(0);
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        long j;
        eot.d();
        synchronized (this.i) {
            try {
                Iterator it = this.i.iterator();
                while (it.hasNext()) {
                    ((dca) it.next()).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        byk bykVar = this.d;
        bykVar.getClass();
        if (i >= 40) {
            bykVar.h(0L);
        } else if (i >= 20 || i == 15) {
            synchronized (bykVar) {
                try {
                    j = bykVar.b;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            bykVar.h(j / 2);
        }
        this.c.z(i);
        bva bvaVar = this.f;
        synchronized (bvaVar) {
            try {
                if (i >= 40) {
                    synchronized (bvaVar) {
                        try {
                            bvaVar.h(0);
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                } else if (i >= 20 || i == 15) {
                    bvaVar.h(bvaVar.a / 2);
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }
}
