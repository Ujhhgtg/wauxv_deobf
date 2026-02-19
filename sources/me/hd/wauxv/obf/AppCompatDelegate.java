package me.hd.wauxv.obf;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.umeng.analytics.pro.q;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegate extends ho implements cbu, LayoutInflater.Factory2 {
    public static final dhq t = new dhq(0);
    public static final int[] u = { R.attr.windowBackground };
    public static final boolean v = !"robolectric".equals(Build.FINGERPRINT);
    public final Object aa;
    public eut ab;
    public dof ac;
    public CharSequence ad;
    public aju ae;
    public ViewUtils af;
    public ViewUtils ag;
    public da ah;
    public ActionBarContextView ai;
    public PopupWindow aj;
    public hp ak;
    public boolean am;
    public ViewGroup an;
    public TextView ao;
    public View ap;
    public boolean aq;
    public boolean ar;
    public boolean as;
    public boolean at;
    public boolean au;
    public boolean av;
    public boolean aw;
    public boolean ax;
    public ib[] ay;
    public ib az;
    public boolean ba;
    public boolean bb;
    public boolean bc;
    public boolean bd;
    public Configuration be;
    public final int bf;
    public int bg;
    public int bh;
    public boolean bi;
    public hx bj;
    public hx bk;
    public boolean bl;
    public int bm;
    public boolean bo;
    public Rect bp;
    public Rect bq;
    public jw br;
    public OnBackInvokedDispatcher bs;
    public OnBackInvokedCallback bt;
    public final Object w;
    public final Context x;
    public Window y;
    public hw z;
    public esg al = null;
    public final hp bn = new hp(this, 0);

    public AppCompatDelegate(Context context, Window window, he heVar, Object obj) {
        hb hbVar = null;
        this.bf = -100;
        this.x = context;
        this.aa = heVar;
        this.w = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof hb)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    hbVar = (hb) context;
                    break;
                }
            }
            if (hbVar != null) {
                this.bf = ((AppCompatDelegate) hbVar.j()).bf;
            }
        }
        if (this.bf == -100) {
            String name = this.w.getClass().getName();
            dhq dhqVar = t;
            Integer num = (Integer) dhqVar.get(name);
            if (num != null) {
                this.bf = num.intValue();
                dhqVar.remove(this.w.getClass().getName());
            }
        }
        if (window != null) {
            bz(window);
        }
        C0023if.f();
    }

    public static bwy bu(Context context) {
        bwy bwyVar;
        bwy bwyVar2;
        if (Build.VERSION.SDK_INT >= 33 || (bwyVar = ho.c) == null) {
            return null;
        }
        bwz bwzVar = bwyVar.b;
        bwy bwyVarB = ht.b(context.getApplicationContext().getResources().getConfiguration());
        if (bwzVar.a.isEmpty()) {
            bwyVar2 = bwy.a;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < bwyVarB.b.a.size() + bwzVar.a.size()) {
                Locale locale = i < bwzVar.a.size() ? bwzVar.a.get(i) : bwyVarB.b.a.get(i - bwzVar.a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i++;
            }
            bwyVar2 = new bwy(
                    new bwz(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return bwyVar2.b.a.isEmpty() ? bwyVarB : bwyVar2;
    }

    public static Configuration bv(Context context, int i, bwy bwyVar, Configuration configuration, boolean z) {
        int i2 = i != 1
                ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32
                : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (bwyVar != null) {
            ht.d(configuration2, bwyVar);
        }
        return configuration2;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
     * 
     * if (r6.ai() != false) goto L20;
     */
    @Override // me.hd.wauxv.obf.cbu
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final void bw(me.hd.wauxv.obf.cbw r6) {
        /*
         * Method dump skipped, instruction units count: 241
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.ic.bw(me.hd.wauxv.obf.cbw):void");
    }

    /* JADX WARN: Found duplicated region for block: B:20:0x002a */
    @Override // me.hd.wauxv.obf.cbu
    public final boolean bx(cbw cbwVar, MenuItem menuItem) {
        ib ibVar;
        Window.Callback callback = this.y.getCallback();
        if (callback != null && !this.bd) {
            cbw cbwVarAj = cbwVar.aj();
            ib[] ibVarArr = this.ay;
            int length = ibVarArr != null ? ibVarArr.length : 0;
            for (int i = 0; i < length; i++) {
                ibVar = ibVarArr[i];
                if (ibVar != null && ibVar.h == cbwVarAj) {
                    if (ibVar != null) {
                        return callback.onMenuItemSelected(ibVar.a, menuItem);
                    }
                }
            }
            ibVar = null;
            if (ibVar != null) {
                return callback.onMenuItemSelected(ibVar.a, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:71:0x00f8 */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean by(boolean z, boolean z2) {
        int i;
        boolean z3;
        if (this.bd) {
            return false;
        }
        int i2 = this.bf;
        if (i2 == -100) {
            i2 = ho.b;
        }
        Context context = this.x;
        int iCl = cl(context, i2);
        int i3 = Build.VERSION.SDK_INT;
        bwy bwyVarBu = i3 < 33 ? bu(context) : null;
        if (!z2 && bwyVarBu != null) {
            bwyVarBu = ht.b(context.getResources().getConfiguration());
        }
        Configuration configurationBv = bv(context, iCl, bwyVarBu, null, false);
        boolean z4 = this.bi;
        boolean z5 = true;
        Object obj = this.w;
        if (z4 || !(obj instanceof Activity)) {
            this.bi = true;
            i = this.bh;
        } else {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
            } else {
                try {
                    ActivityInfo activityInfo = packageManager
                            .getActivityInfo(new ComponentName(context, obj.getClass()), i3 >= 29 ? 269221888 : 786432);
                    if (activityInfo != null) {
                        this.bh = activityInfo.configChanges;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
                    this.bh = 0;
                }
                this.bi = true;
                i = this.bh;
            }
        }
        Configuration configuration = this.be;
        if (configuration == null) {
            configuration = context.getResources().getConfiguration();
        }
        int i4 = configuration.uiMode & 48;
        int i5 = configurationBv.uiMode & 48;
        bwy bwyVarB = ht.b(configuration);
        bwy bwyVarB2 = bwyVarBu == null ? null : ht.b(configurationBv);
        int i6 = i4 != i5 ? 512 : 0;
        if (bwyVarB2 != null && !bwyVarB.equals(bwyVarB2)) {
            i6 |= q.a.u;
        }
        if (((~i) & i6) != 0 && z && this.bb && ((v || this.bc) && (obj instanceof Activity))) {
            Activity activity = (Activity) obj;
            if (activity.isChild()) {
                z3 = false;
            } else {
                int i7 = Build.VERSION.SDK_INT;
                if (i7 >= 31 && (i6 & 8192) != 0) {
                    activity.getWindow().getDecorView().setLayoutDirection(configurationBv.getLayoutDirection());
                }
                if (i7 >= 28) {
                    activity.recreate();
                } else {
                    new Handler(activity.getMainLooper()).post(new dh(activity, 0));
                }
                z3 = true;
            }
        } else {
            z3 = false;
        }
        if (z3 || i6 == 0) {
            z5 = z3;
        } else {
            boolean z6 = (i6 & i) == i6;
            Resources resources = context.getResources();
            Configuration configuration2 = new Configuration(resources.getConfiguration());
            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i5;
            if (bwyVarB2 != null) {
                ht.d(configuration2, bwyVarB2);
            }
            resources.updateConfiguration(configuration2, null);
            int i8 = this.bg;
            if (i8 != 0) {
                context.setTheme(i8);
                context.getTheme().applyStyle(this.bg, true);
            }
            if (z6 && (obj instanceof Activity)) {
                Activity activity2 = (Activity) obj;
                if (activity2 instanceof bup) {
                    if (((bup) activity2).ap().c.compareTo(buh.c) >= 0) {
                        activity2.onConfigurationChanged(configuration2);
                    }
                } else if (this.bc && !this.bd) {
                    activity2.onConfigurationChanged(configuration2);
                }
            }
        }
        if (bwyVarB2 != null) {
            ht.c(ht.b(context.getResources().getConfiguration()));
        }
        if (i2 == 0) {
            ch(context).t();
        } else {
            hx hxVar = this.bj;
            if (hxVar != null) {
                hxVar.i();
            }
        }
        if (i2 == 3) {
            if (this.bk == null) {
                this.bk = new hx(this, context);
            }
            this.bk.t();
        } else {
            hx hxVar2 = this.bk;
            if (hxVar2 != null) {
                hxVar2.i();
            }
        }
        return z5;
    }

    /* JADX WARN: Found duplicated region for block: B:35:0x0074 */
    public final void bz(Window window) {
        Drawable drawableM;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.y != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof hw) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        hw hwVar = new hw(this, callback);
        this.z = hwVar;
        window.setCallback(hwVar);
        Context context = this.x;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, u);
        if (!typedArrayObtainStyledAttributes.hasValue(0)
                || (resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawableM = null;
        } else {
            C0023if c0023ifD = C0023if.d();
            synchronized (c0023ifD) {
                drawableM = c0023ifD.c.m(context, resourceId, true);
            }
        }
        if (drawableM != null) {
            window.setBackgroundDrawable(drawableM);
        }
        typedArrayObtainStyledAttributes.recycle();
        this.y = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.bs) != null) {
            return;
        }
        Object obj = this.w;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.bt) != null) {
            hv.createInstanceWithArgs(onBackInvokedDispatcher, onBackInvokedCallback);
            this.bt = null;
        }
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.bs = hv.a(activity);
            } else {
                this.bs = null;
            }
        } else {
            this.bs = null;
        }
        cr();
    }

    public final void ca(int i, ib ibVar, cbw cbwVar) {
        if (cbwVar == null) {
            if (ibVar == null && i >= 0) {
                ib[] ibVarArr = this.ay;
                if (i < ibVarArr.length) {
                    ibVar = ibVarArr[i];
                }
            }
            if (ibVar != null) {
                cbwVar = ibVar.h;
            }
        }
        if ((ibVar == null || ibVar.m) && !this.bd) {
            hw hwVar = this.z;
            Window.Callback callback = this.y.getCallback();
            hwVar.getClass();
            try {
                hwVar.d = true;
                callback.onPanelClosed(i, cbwVar);
            } finally {
                hwVar.d = false;
            }
        }
    }

    public final void cb(cbw cbwVar) {
        cw cwVar;
        if (this.ax) {
            return;
        }
        this.ax = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.ae;
        actionBarOverlayLayout.ap();
        ActionMenuView actionMenuView = ((ekt) actionBarOverlayLayout.h).a.a;
        if (actionMenuView != null && (cwVar = actionMenuView.g) != null) {
            cwVar.ag();
            cq cqVar = cwVar.u;
            if (cqVar != null && cqVar.p()) {
                cqVar.l.dismiss();
            }
        }
        Window.Callback callback = this.y.getCallback();
        if (callback != null && !this.bd) {
            callback.onPanelClosed(108, cbwVar);
        }
        this.ax = false;
    }

    public final void cc(ib ibVar, boolean z) {
        ia iaVar;
        aju ajuVar;
        cw cwVar;
        if (z && ibVar.a == 0 && (ajuVar = this.ae) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ajuVar;
            actionBarOverlayLayout.ap();
            ActionMenuView actionMenuView = ((ekt) actionBarOverlayLayout.h).a.a;
            if (actionMenuView != null && (cwVar = actionMenuView.g) != null && cwVar.ai()) {
                cb(ibVar.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.x.getSystemService("window");
        if (windowManager != null && ibVar.m && (iaVar = ibVar.e) != null) {
            windowManager.removeView(iaVar);
            if (z) {
                ca(ibVar.a, ibVar, null);
            }
        }
        ibVar.k = false;
        ibVar.l = false;
        ibVar.m = false;
        ibVar.f = null;
        ibVar.n = true;
        if (this.az == ibVar) {
            this.az = null;
        }
        if (ibVar.a == 0) {
            cr();
        }
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x0147 */
    /* JADX WARN: Found duplicated region for block: B:104:0x014e A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:21:0x003f */
    /* JADX WARN: Found duplicated region for block: B:23:0x004a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:24:0x004c A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:26:0x0050 */
    /* JADX WARN: Found duplicated region for block: B:28:0x0056 */
    /* JADX WARN: Found duplicated region for block: B:30:0x005e */
    /* JADX WARN: Found duplicated region for block: B:32:0x0062 */
    /* JADX WARN: Found duplicated region for block: B:35:0x006b */
    /* JADX WARN: Found duplicated region for block: B:38:0x006f A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:39:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:41:0x0075 */
    /* JADX WARN: Found duplicated region for block: B:44:0x007b */
    /* JADX WARN: Found duplicated region for block: B:46:0x0085 */
    /* JADX WARN: Found duplicated region for block: B:78:0x0105 */
    /* JADX WARN: Found duplicated region for block: B:80:0x0109 */
    /* JADX WARN: Found duplicated region for block: B:91:0x0123 */
    /* JADX WARN: Found duplicated region for block: B:95:0x012d */
    /* JADX WARN: Found duplicated region for block: B:97:0x013b */
    /* JADX WARN: Found duplicated region for block: B:99:0x013f */
    public final boolean cd(KeyEvent keyEvent) {
        View decorView;
        int keyCode;
        ib ibVarCi;
        aju ajuVar;
        Context context;
        boolean z;
        boolean z2;
        boolean zCp;
        AudioManager audioManager;
        Toolbar toolbar;
        ActionMenuView actionMenuView;
        cw cwVar;
        cw cwVar2;
        cw cwVar3;
        ib ibVarCi2;
        Object obj = this.w;
        if ((!(obj instanceof btl) && !(obj instanceof el)) || (decorView = this.y.getDecorView()) == null
                || !emc.al(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                hw hwVar = this.z;
                Window.Callback callback = this.y.getCallback();
                hwVar.getClass();
                try {
                    hwVar.c = true;
                    boolean zDispatchKeyEvent = callback.dispatchKeyEvent(keyEvent);
                    hwVar.c = false;
                    if (!zDispatchKeyEvent) {
                        keyCode = keyEvent.getKeyCode();
                        if (keyEvent.getAction() == 0) {
                            if (keyCode != 4) {
                                this.ba = (keyEvent.getFlags() & 128) != 0;
                                return false;
                            }
                            if (keyCode == 82) {
                                if (keyEvent.getRepeatCount() == 0) {
                                    ibVarCi2 = ci(0);
                                    if (!ibVarCi2.m) {
                                        cp(ibVarCi2, keyEvent);
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (keyCode != 4) {
                            if (keyCode == 82) {
                                if (this.ah == null) {
                                    ibVarCi = ci(0);
                                    ajuVar = this.ae;
                                    context = this.x;
                                    if (ajuVar != null) {
                                        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ajuVar;
                                        actionBarOverlayLayout.ap();
                                        toolbar = ((ekt) actionBarOverlayLayout.h).a;
                                        if (toolbar.getVisibility() == 0 || (actionMenuView = toolbar.a) == null
                                                || !actionMenuView.f
                                                || ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                            z = ibVarCi.m;
                                            if (!z || ibVarCi.l) {
                                                cc(ibVarCi, true);
                                                z2 = z;
                                            } else {
                                                if (ibVarCi.k) {
                                                    if (ibVarCi.o) {
                                                        ibVarCi.k = false;
                                                        zCp = cp(ibVarCi, keyEvent);
                                                    } else {
                                                        zCp = true;
                                                    }
                                                    if (zCp) {
                                                        cn(ibVarCi, keyEvent);
                                                    }
                                                }
                                            }
                                        } else {
                                            ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.ae;
                                            actionBarOverlayLayout2.ap();
                                            ActionMenuView actionMenuView2 = ((ekt) actionBarOverlayLayout2.h).a.a;
                                            if (actionMenuView2 == null || (cwVar2 = actionMenuView2.g) == null
                                                    || !cwVar2.ai()) {
                                                if (!this.bd && cp(ibVarCi, keyEvent)) {
                                                    ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.ae;
                                                    actionBarOverlayLayout3.ap();
                                                    ActionMenuView actionMenuView3 = ((ekt) actionBarOverlayLayout3.h).a.a;
                                                    if (actionMenuView3 == null || (cwVar = actionMenuView3.g) == null
                                                            || !cwVar.am()) {
                                                    }
                                                }
                                            } else {
                                                ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.ae;
                                                actionBarOverlayLayout4.ap();
                                                ActionMenuView actionMenuView4 = ((ekt) actionBarOverlayLayout4.h).a.a;
                                                z2 = (actionMenuView4 == null || (cwVar3 = actionMenuView4.g) == null
                                                        || !cwVar3.ag()) ? false : true;
                                            }
                                        }
                                    } else {
                                        z = ibVarCi.m;
                                        if (z) {
                                        }
                                        cc(ibVarCi, true);
                                        z2 = z;
                                    }
                                    if (z2) {
                                        audioManager = (AudioManager) context.getApplicationContext()
                                                .getSystemService("audio");
                                        if (audioManager != null) {
                                            audioManager.playSoundEffect(0);
                                            return true;
                                        }
                                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        if (cm()) {
                            return false;
                        }
                    }
                } catch (Throwable th) {
                    hwVar.c = false;
                    throw th;
                }
            } else {
                keyCode = keyEvent.getKeyCode();
                if (keyEvent.getAction() == 0) {
                    if (keyCode != 4) {
                        this.ba = (keyEvent.getFlags() & 128) != 0;
                        return false;
                    }
                    if (keyCode == 82) {
                        if (keyEvent.getRepeatCount() == 0) {
                            ibVarCi2 = ci(0);
                            if (!ibVarCi2.m) {
                                cp(ibVarCi2, keyEvent);
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (keyCode != 4) {
                    if (keyCode == 82) {
                        if (this.ah == null) {
                            ibVarCi = ci(0);
                            ajuVar = this.ae;
                            context = this.x;
                            if (ajuVar != null) {
                                ActionBarOverlayLayout actionBarOverlayLayout5 = (ActionBarOverlayLayout) ajuVar;
                                actionBarOverlayLayout5.ap();
                                toolbar = ((ekt) actionBarOverlayLayout5.h).a;
                                if (toolbar.getVisibility() == 0) {
                                    z = ibVarCi.m;
                                    if (z) {
                                    }
                                    cc(ibVarCi, true);
                                    z2 = z;
                                } else {
                                    z = ibVarCi.m;
                                    if (z) {
                                    }
                                    cc(ibVarCi, true);
                                    z2 = z;
                                }
                            } else {
                                z = ibVarCi.m;
                                if (z) {
                                }
                                cc(ibVarCi, true);
                                z2 = z;
                            }
                            if (z2) {
                                audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                if (audioManager != null) {
                                    audioManager.playSoundEffect(0);
                                    return true;
                                }
                                Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if (cm()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void ce(int i) {
        ib ibVarCi = ci(i);
        if (ibVarCi.h != null) {
            Bundle bundle = new Bundle();
            ibVarCi.h.as(bundle);
            if (bundle.size() > 0) {
                ibVarCi.p = bundle;
            }
            ibVarCi.h.av();
            ibVarCi.h.clear();
        }
        ibVarCi.o = true;
        ibVarCi.n = true;
        if ((i == 108 || i == 0) && this.ae != null) {
            ib ibVarCi2 = ci(0);
            ibVarCi2.k = false;
            cp(ibVarCi2, null);
        }
    }

    public final void cf() {
        ViewGroup viewGroup;
        if (this.am) {
            return;
        }
        Context context = this.x;
        int[] iArr = cyf.j;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException(
                    "You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        int i = 0;
        int i2 = 1;
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            o(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            o(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            o(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            o(10);
        }
        this.av = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        cg();
        this.y.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.aw) {
            viewGroup = this.au
                    ? (ViewGroup) layoutInflaterFrom.inflate(me.hd.wauxv.R.layout.abc_screen_simple_overlay_action_mode,
                            (ViewGroup) null)
                    : (ViewGroup) layoutInflaterFrom.inflate(me.hd.wauxv.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.av) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(me.hd.wauxv.R.layout.abc_dialog_title_material,
                    (ViewGroup) null);
            this.at = false;
            this.as = false;
        } else if (this.as) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(me.hd.wauxv.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater
                    .from(typedValue.resourceId != 0 ? new afv(context, typedValue.resourceId) : context)
                    .inflate(me.hd.wauxv.R.layout.abc_screen_toolbar, (ViewGroup) null);
            aju ajuVar = (aju) viewGroup.findViewById(me.hd.wauxv.R.id.decor_content_parent);
            this.ae = ajuVar;
            ajuVar.setWindowCallback(this.y.getCallback());
            if (this.at) {
                ((ActionBarOverlayLayout) this.ae).ao(109);
            }
            if (this.aq) {
                ((ActionBarOverlayLayout) this.ae).ao(2);
            }
            if (this.ar) {
                ((ActionBarOverlayLayout) this.ae).ao(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException(
                    "AppCompat does not support the current theme features: { windowActionBar: " + this.as
                            + ", windowActionBarOverlay: " + this.at + ", android:windowIsFloating: " + this.av
                            + ", windowActionModeOverlay: " + this.au + ", windowNoTitle: " + this.aw + " }");
        }
        ViewUtils viewUtilsVar = new ViewUtils(this, i);
        WeakHashMap weakHashMap = ViewCompat.a;
        eqq.l(viewGroup, viewUtilsVar);
        if (this.ae == null) {
            this.ao = (TextView) viewGroup.findViewById(me.hd.wauxv.R.id.title);
        }
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup
                .findViewById(me.hd.wauxv.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.y.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.y.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ViewUtils(this, i2));
        this.an = viewGroup;
        Object obj = this.w;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.ad;
        if (!TextUtils.isEmpty(title)) {
            aju ajuVar2 = this.ae;
            if (ajuVar2 != null) {
                ajuVar2.setWindowTitle(title);
            } else {
                eut eutVar = this.ab;
                if (eutVar != null) {
                    ekt ektVar = (ekt) eutVar.at;
                    if (!ektVar.g) {
                        Toolbar toolbar = ektVar.a;
                        ektVar.h = title;
                        if ((ektVar.b & 8) != 0) {
                            toolbar.setTitle(title);
                            if (ektVar.g) {
                                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.ao;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.an.findViewById(R.id.content);
        View decorView = this.y.getDecorView();
        contentFrameLayout2.g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(),
                decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.am = true;
        ib ibVarCi = ci(0);
        if (this.bd || ibVarCi.h != null) {
            return;
        }
        ck(108);
    }

    public final void cg() {
        if (this.y == null) {
            Object obj = this.w;
            if (obj instanceof Activity) {
                bz(((Activity) obj).getWindow());
            }
        }
        if (this.y == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final hz ch(Context context) {
        if (this.bj == null) {
            if (FactoryPools.c == null) {
                Context applicationContext = context.getApplicationContext();
                FactoryPools.c = new FactoryPools(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.bj = new hx(this, FactoryPools.c);
        }
        return this.bj;
    }

    public final ib ci(int i) {
        ib[] ibVarArr = this.ay;
        if (ibVarArr == null || ibVarArr.length <= i) {
            ib[] ibVarArr2 = new ib[i + 1];
            if (ibVarArr != null) {
                System.arraycopy(ibVarArr, 0, ibVarArr2, 0, ibVarArr.length);
            }
            this.ay = ibVarArr2;
            ibVarArr = ibVarArr2;
        }
        ib ibVar = ibVarArr[i];
        if (ibVar != null) {
            return ibVar;
        }
        ib ibVar2 = new ib();
        ibVar2.a = i;
        ibVar2.n = false;
        ibVarArr[i] = ibVar2;
        return ibVar2;
    }

    public final void cj() {
        cf();
        if (this.as && this.ab == null) {
            Object obj = this.w;
            if (obj instanceof Activity) {
                this.ab = new eut((Activity) obj, this.at);
            } else if (obj instanceof Dialog) {
                this.ab = new eut((Dialog) obj);
            }
            eut eutVar = this.ab;
            if (eutVar != null) {
                eutVar.bq(this.bo);
            }
        }
    }

    public final void ck(int i) {
        this.bm = (1 << i) | this.bm;
        if (this.bl) {
            return;
        }
        View decorView = this.y.getDecorView();
        WeakHashMap weakHashMap = ViewCompat.a;
        decorView.postOnAnimation(this.bn);
        this.bl = true;
    }

    public final int cl(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException(
                                    "Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.bk == null) {
                            this.bk = new hx(this, context);
                        }
                        return this.bk.e();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode"))
                        .getNightMode() != 0) {
                    return ch(context).getThisObject();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean cm() {
        ajv ajvVar;
        eko ekoVar;
        boolean z = this.ba;
        this.ba = false;
        ib ibVarCi = ci(0);
        if (!ibVarCi.m) {
            da daVar = this.ah;
            if (daVar != null) {
                daVar.c();
                return true;
            }
            cj();
            eut eutVar = this.ab;
            if (eutVar == null || (ajvVar = eutVar.at) == null || (ekoVar = ((ekt) ajvVar).a.al) == null
                    || ekoVar.b == null) {
                return false;
            }
            eko ekoVar2 = ((ekt) ajvVar).a.al;
            cbz cbzVar = ekoVar2 == null ? null : ekoVar2.b;
            if (cbzVar != null) {
                cbzVar.collapseActionView();
            }
        } else if (!z) {
            cc(ibVarCi, true);
            return true;
        }
        return true;
    }

    /*
     * JADX WARN: Code restructure failed: missing block: B:87:0x0176, code lost:
     * 
     * if (r2.f.getCount() > 0) goto L88;
     */
    /* JADX WARN: Found duplicated region for block: B:100:0x01d3 */
    /* JADX WARN: Found duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /*
     * Code decompiled incorrectly, please refer to instructions dump.
     * To view partially-correct add '--show-bad-code' argument
     */
    public final void cn(me.hd.wauxv.obf.ib r18, android.view.KeyEvent r19) {
        /*
         * Method dump skipped, instruction units count: 474
         * To view this dump add '--comments-level debug' option
         */
        throw new UnsupportedOperationException(
                "Method not decompiled: me.hd.wauxv.obf.ic.cn(me.hd.wauxv.obf.ib, android.view.KeyEvent):void");
    }

    public final boolean co(ib ibVar, int i, KeyEvent keyEvent) {
        cbw cbwVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((ibVar.k || cp(ibVar, keyEvent)) && (cbwVar = ibVar.h) != null) {
            return cbwVar.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Found duplicated region for block: B:59:0x00d0 */
    /* JADX WARN: Found duplicated region for block: B:64:0x00da */
    /* JADX WARN: Found duplicated region for block: B:68:0x00f8 */
    /* JADX WARN: Found duplicated region for block: B:71:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:72:0x00ff */
    /* JADX WARN: Found duplicated region for block: B:79:0x0114 */
    public final boolean cp(ib ibVar, KeyEvent keyEvent) {
        cbw cbwVar;
        aju ajuVar;
        aju ajuVar2;
        Resources.Theme themeNewTheme;
        aju ajuVar3;
        aju ajuVar4;
        if (!this.bd) {
            boolean z = ibVar.k;
            int i = ibVar.a;
            if (z) {
                return true;
            }
            ib ibVar2 = this.az;
            if (ibVar2 != null && ibVar2 != ibVar) {
                cc(ibVar2, false);
            }
            Window.Callback callback = this.y.getCallback();
            if (callback != null) {
                ibVar.g = callback.onCreatePanelView(i);
            }
            boolean z2 = i == 0 || i == 108;
            if (z2 && (ajuVar4 = this.ae) != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) ajuVar4;
                actionBarOverlayLayout.ap();
                ((ekt) actionBarOverlayLayout.h).l = true;
            }
            if (ibVar.g == null) {
                cbw cbwVar2 = ibVar.h;
                if (cbwVar2 == null || ibVar.o) {
                    if (cbwVar2 == null) {
                        Context context = this.x;
                        if ((i == 0 || i == 108) && this.ae != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme = context.getTheme();
                            theme.resolveAttribute(me.hd.wauxv.R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                                themeNewTheme.resolveAttribute(me.hd.wauxv.R.attr.actionBarWidgetTheme, typedValue,
                                        true);
                            } else {
                                theme.resolveAttribute(me.hd.wauxv.R.attr.actionBarWidgetTheme, typedValue, true);
                                themeNewTheme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (themeNewTheme == null) {
                                    themeNewTheme = context.getResources().newTheme();
                                    themeNewTheme.setTo(theme);
                                }
                                themeNewTheme.applyStyle(typedValue.resourceId, true);
                            }
                            if (themeNewTheme != null) {
                                afv afvVar = new afv(context, 0);
                                afvVar.getTheme().setTo(themeNewTheme);
                                context = afvVar;
                            }
                        }
                        cbw cbwVar3 = new cbw(context);
                        cbwVar3.f = this;
                        cbw cbwVar4 = ibVar.h;
                        if (cbwVar3 != cbwVar4) {
                            if (cbwVar4 != null) {
                                cbwVar4.aq(ibVar.i);
                            }
                            ibVar.h = cbwVar3;
                            bwf bwfVar = ibVar.i;
                            if (bwfVar != null) {
                                cbwVar3.aa(bwfVar, cbwVar3.b);
                            }
                        }
                        if (ibVar.h != null) {
                            if (z2 && (ajuVar2 = this.ae) != null) {
                                if (this.af == null) {
                                    this.af = new ViewUtils(this, 2);
                                }
                                ((ActionBarOverlayLayout) ajuVar2).aq(ibVar.h, this.af);
                            }
                            ibVar.h.av();
                            if (callback.onCreatePanelMenu(i, ibVar.h)) {
                                ibVar.o = false;
                            } else {
                                cbwVar = ibVar.h;
                                if (cbwVar != null) {
                                    if (cbwVar != null) {
                                        cbwVar.aq(ibVar.i);
                                    }
                                    ibVar.h = null;
                                }
                                if (z2 && (ajuVar = this.ae) != null) {
                                    ((ActionBarOverlayLayout) ajuVar).aq(null, this.af);
                                }
                            }
                        }
                    } else {
                        if (z2) {
                            if (this.af == null) {
                                this.af = new ViewUtils(this, 2);
                            }
                            ((ActionBarOverlayLayout) ajuVar2).aq(ibVar.h, this.af);
                        }
                        ibVar.h.av();
                        if (callback.onCreatePanelMenu(i, ibVar.h)) {
                            cbwVar = ibVar.h;
                            if (cbwVar != null) {
                                if (cbwVar != null) {
                                    cbwVar.aq(ibVar.i);
                                }
                                ibVar.h = null;
                            }
                            if (z2) {
                                ((ActionBarOverlayLayout) ajuVar).aq(null, this.af);
                            }
                        } else {
                            ibVar.o = false;
                        }
                    }
                }
                ibVar.h.av();
                Bundle bundle = ibVar.p;
                if (bundle != null) {
                    ibVar.h.ar(bundle);
                    ibVar.p = null;
                }
                if (!callback.onPreparePanel(0, ibVar.g, ibVar.h)) {
                    if (z2 && (ajuVar3 = this.ae) != null) {
                        ((ActionBarOverlayLayout) ajuVar3).aq(null, this.af);
                    }
                    ibVar.h.au();
                    return false;
                }
                ibVar.h.setQwertyMode(
                        KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                ibVar.h.au();
            }
            ibVar.k = true;
            ibVar.l = false;
            this.az = ibVar;
            return true;
        }
        return false;
    }

    public final void cq() {
        if (this.am) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void cr() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.bs != null && (ci(0).m || this.ah != null)) {
                z = true;
            }
            if (z && this.bt == null) {
                this.bt = hv.tryGetClassByName(this.bs, this);
            } else {
                if (z || (onBackInvokedCallback = this.bt) == null) {
                    return;
                }
                hv.createInstanceWithArgs(this.bs, onBackInvokedCallback);
                this.bt = null;
            }
        }
    }

    @Override // me.hd.wauxv.obf.ho
    public final void l() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.x);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegate) {
                return;
            }
            Log.i("AppCompatDelegate",
                    "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // me.hd.wauxv.obf.ho
    public final void m() {
        String strY;
        this.bb = true;
        by(false, true);
        cg();
        Object obj = this.w;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strY = cna.y(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                strY = null;
            }
            if (strY != null) {
                eut eutVar = this.ab;
                if (eutVar == null) {
                    this.bo = true;
                } else {
                    eutVar.bq(true);
                }
            }
            synchronized (ho.h) {
                ho.k(this);
                ho.g.add(new WeakReference(this));
            }
        }
        this.be = new Configuration(this.x.getResources().getConfiguration());
        this.bc = true;
    }

    /* JADX WARN: Found duplicated region for block: B:22:0x004d */
    @Override // me.hd.wauxv.obf.ho
    public final void n() {
        if (this.w instanceof Activity) {
            synchronized (ho.h) {
                ho.k(this);
            }
        }
        if (this.bl) {
            this.y.getDecorView().removeCallbacks(this.bn);
        }
        this.bd = true;
        if (this.bf != -100) {
            Object obj = this.w;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                t.put(this.w.getClass().getName(), Integer.valueOf(this.bf));
            } else {
                t.remove(this.w.getClass().getName());
            }
        } else {
            t.remove(this.w.getClass().getName());
        }
        hx hxVar = this.bj;
        if (hxVar != null) {
            hxVar.i();
        }
        hx hxVar2 = this.bk;
        if (hxVar2 != null) {
            hxVar2.i();
        }
    }

    @Override // me.hd.wauxv.obf.ho
    public final boolean o(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate",
                    "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate",
                    "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.aw && i == 108) {
            return false;
        }
        if (this.as && i == 1) {
            this.as = false;
        }
        if (i == 1) {
            cq();
            this.aw = true;
            return true;
        }
        if (i == 2) {
            cq();
            this.aq = true;
            return true;
        }
        if (i == 5) {
            cq();
            this.ar = true;
            return true;
        }
        if (i == 10) {
            cq();
            this.au = true;
            return true;
        }
        if (i == 108) {
            cq();
            this.as = true;
            return true;
        }
        if (i != 109) {
            return this.y.requestFeature(i);
        }
        cq();
        this.at = true;
        return true;
    }

    /*
     * JADX WARN: Failed to restore switch over string. Please report as a
     * decompilation issue
     */
    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View iqVar;
        View view2 = null;
        if (this.br == null) {
            int[] iArr = cyf.j;
            Context context2 = this.x;
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = typedArrayObtainStyledAttributes.getString(116);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.br = new jw();
            } else {
                try {
                    this.br = (jw) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null)
                            .newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate",
                            "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.br = new jw();
                }
            }
        }
        jw jwVar = this.br;
        int i = epm.a;
        jwVar.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cyf.y, 0, 0);
        byte b = 4;
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes2.recycle();
        Context afvVar = (resourceId == 0 || ((context instanceof afv) && ((afv) context).b == resourceId)) ? context
                : new afv(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b = !str.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b = !str.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b = !str.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b = !str.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!str.equals("ImageButton")) {
                    b = -1;
                }
                break;
            case -658531749:
                b = !str.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b = !str.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b = !str.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b = !str.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b = !str.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b = !str.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b = !str.equals("CheckBox") ? (byte) -1 : (byte) 11;
                break;
            case 1666676343:
                b = !str.equals("EditText") ? (byte) -1 : (byte) 12;
                break;
            case 2001146706:
                b = !str.equals("Button") ? (byte) -1 : com.umeng.analytics.pro.dn.k;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                iqVar = new iq(afvVar, attributeSet);
                break;
            case 1:
                iqVar = new hg(afvVar, attributeSet);
                break;
            case 2:
                iqVar = new im(afvVar, attributeSet);
                break;
            case 3:
                iqVar = jwVar.e(afvVar, attributeSet);
                break;
            case 4:
                iqVar = new ij(afvVar, attributeSet, me.hd.wauxv.R.attr.imageButtonStyle);
                break;
            case 5:
                iqVar = new is(afvVar, attributeSet);
                break;
            case 6:
                iqVar = new je(afvVar, attributeSet);
                break;
            case 7:
                iqVar = jwVar.d(afvVar, attributeSet);
                break;
            case 8:
                iqVar = new ju(afvVar, attributeSet);
                break;
            case 9:
                iqVar = new il(afvVar, attributeSet, 0);
                break;
            case 10:
                iqVar = jwVar.a(afvVar, attributeSet);
                break;
            case 11:
                iqVar = jwVar.createInstanceWithArgs(afvVar, attributeSet);
                break;
            case 12:
                iqVar = new ih(afvVar, attributeSet);
                break;
            case 13:
                iqVar = jwVar.tryGetClassByName(afvVar, attributeSet);
                break;
            default:
                iqVar = null;
                break;
        }
        if (iqVar != null || context == afvVar) {
            view2 = iqVar;
        } else {
            Object[] objArr = jwVar.m;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = afvVar;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = jw.k;
                        if (i2 < 3) {
                            View viewN = jwVar.n(afvVar, str, strArr[i2]);
                            if (viewN != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewN;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View viewN2 = jwVar.n(afvVar, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewN2;
                }
            } catch (Exception unused) {
                objArr[0] = view2;
                objArr[1] = view2;
            } catch (Throwable th2) {
                objArr[0] = view2;
                objArr[1] = view2;
                throw th2;
            }
        }
        if (view2 != null) {
            Context context3 = view2.getContext();
            if ((context3 instanceof ContextWrapper) && view2.hasOnClickListeners()) {
                TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, jw.g);
                String string2 = typedArrayObtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    view2.setOnClickListener(new jv(view2, string2));
                }
                typedArrayObtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes4 = afvVar.obtainStyledAttributes(attributeSet, jw.h);
                if (typedArrayObtainStyledAttributes4.hasValue(0)) {
                    boolean z = typedArrayObtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = ViewCompat.a;
                    new eqm(me.hd.wauxv.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).setAccessibilityProperty(view2,
                            Boolean.valueOf(z));
                }
                typedArrayObtainStyledAttributes4.recycle();
                TypedArray typedArrayObtainStyledAttributes5 = afvVar.obtainStyledAttributes(attributeSet, jw.i);
                if (typedArrayObtainStyledAttributes5.hasValue(0)) {
                    ViewCompat.setAccessibilityPaneTitle(view2, typedArrayObtainStyledAttributes5.getString(0));
                }
                typedArrayObtainStyledAttributes5.recycle();
                TypedArray typedArrayObtainStyledAttributes6 = afvVar.obtainStyledAttributes(attributeSet, jw.j);
                if (typedArrayObtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = typedArrayObtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = ViewCompat.a;
                    new eqm(me.hd.wauxv.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).setAccessibilityProperty(view2,
                            Boolean.valueOf(z2));
                }
                typedArrayObtainStyledAttributes6.recycle();
            }
        }
        return view2;
    }

    @Override // me.hd.wauxv.obf.ho
    public final void p(int i) {
        cf();
        ViewGroup viewGroup = (ViewGroup) this.an.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.x).inflate(i, viewGroup);
        this.z.f(this.y.getCallback());
    }

    @Override // me.hd.wauxv.obf.ho
    public final void q(View view) {
        cf();
        ViewGroup viewGroup = (ViewGroup) this.an.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.z.f(this.y.getCallback());
    }

    @Override // me.hd.wauxv.obf.ho
    public final void r(View view, ViewGroup.LayoutParams layoutParams) {
        cf();
        ViewGroup viewGroup = (ViewGroup) this.an.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.z.f(this.y.getCallback());
    }

    @Override // me.hd.wauxv.obf.ho
    public final void s(CharSequence charSequence) {
        this.ad = charSequence;
        aju ajuVar = this.ae;
        if (ajuVar != null) {
            ajuVar.setWindowTitle(charSequence);
            return;
        }
        eut eutVar = this.ab;
        if (eutVar == null) {
            TextView textView = this.ao;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        ekt ektVar = (ekt) eutVar.at;
        if (ektVar.g) {
            return;
        }
        Toolbar toolbar = ektVar.a;
        ektVar.h = charSequence;
        if ((ektVar.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (ektVar.g) {
                ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
