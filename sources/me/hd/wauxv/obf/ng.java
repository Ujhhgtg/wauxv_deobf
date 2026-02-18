package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ng implements bup {
    public static Thread a;
    public static WeakReference b;
    public static CopyOnWriteArrayList c;
    public static HashMap d;
    public static WeakReference e;
    public WeakReference f;
    public WeakReference g;
    public WeakReference h;
    public qp j;
    public final boolean k;
    public final int[] l;
    public boolean m;
    public boolean n;
    public final bht o;
    public final boolean p;
    public long q;
    public final long r;
    public int s;
    public final int[] t;
    public boolean u;
    public final int w;
    public final int v = anj.h;
    public final bur i = new bur(this);

    public ng() {
        this.k = true;
        new HashMap();
        this.l = new int[2];
        this.q = -1L;
        this.r = -1L;
        this.t = new int[4];
        this.m = true;
        this.o = anj.a;
        this.w = anj.g;
        this.q = -1L;
        this.r = -1L;
        this.p = true;
        this.k = anj.f;
    }

    public static Application aa() {
        Application application;
        Application application2 = di.b;
        if (application2 != null) {
            return application2;
        }
        try {
            try {
                try {
                    return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
                } catch (Exception unused) {
                    Class<?> cls = Class.forName("android.app.ActivityThread");
                    application = (Application) cls.getDeclaredMethod("getApplication", null).invoke(cls.getDeclaredMethod("currentActivityThread", null).invoke(null, null), null);
                    return application;
                }
            } catch (Exception unused2) {
                return null;
            }
        } catch (Exception unused3) {
            application = (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", null).invoke(null, null);
            return application;
        }
    }

    public static FrameLayout ab(Activity activity) {
        if (activity == null || activity.getWindow() == null || !(activity.getWindow().getDecorView() instanceof FrameLayout)) {
            return null;
        }
        return (FrameLayout) activity.getWindow().getDecorView();
    }

    public static Handler ac() {
        WeakReference weakReference = e;
        if (weakReference != null && weakReference.get() != null) {
            return (Handler) e.get();
        }
        WeakReference weakReference2 = new WeakReference(new Handler(Looper.getMainLooper()));
        e = weakReference2;
        return (Handler) weakReference2.get();
    }

    public static ContextWrapper ad() {
        Activity activityAe = ae();
        if (activityAe != null) {
            return activityAe;
        }
        Application applicationAa = aa();
        if (applicationAa != null) {
            return applicationAa;
        }
        y("DialogX 未初始化(E2)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return null;
    }

    public static Activity ae() {
        WeakReference weakReference = b;
        if (weakReference != null && weakReference.get() != null) {
            return (Activity) b.get();
        }
        af(null);
        WeakReference weakReference2 = b;
        if (weakReference2 != null && weakReference2.get() != null) {
            return (Activity) b.get();
        }
        Activity activityD = di.d();
        af(activityD);
        return activityD;
    }

    public static void af(Context context) {
        if (context == null) {
            context = di.d();
        }
        if (context instanceof Activity) {
            ag((Activity) context);
        }
        di.e(context, new arj());
    }

    public static void ag(Activity activity) {
        if (activity == null) {
            return;
        }
        for (String str : anj.c) {
            if (activity.getClass().getName().contains(str)) {
                return;
            }
        }
        try {
            a = Looper.getMainLooper().getThread();
            b = new WeakReference(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
            y("DialogX.init: 初始化异常，找不到Activity的根布局");
        }
    }

    public static boolean ah(CharSequence charSequence) {
        String strValueOf = String.valueOf(charSequence);
        return charSequence == null || strValueOf.trim().isEmpty() || "null".equals(strValueOf) || "(null)".equals(strValueOf);
    }

    public static void ai(Activity activity) {
        WeakReference weakReference;
        WeakReference weakReference2;
        int iAe = dkz.ae(anj.h);
        if (iAe != 1) {
            if (iAe != 2) {
                if (iAe != 3 && c != null) {
                    for (ng ngVar : new CopyOnWriteArrayList(c)) {
                        if (ngVar.as() == activity) {
                            WeakReference weakReference3 = ngVar.f;
                            if (weakReference3 != null) {
                                weakReference3.clear();
                            }
                            ngVar.g = null;
                            ngVar.f = null;
                            c.remove(ngVar);
                        }
                    }
                }
            } else if (c != null) {
                for (ng ngVar2 : new CopyOnWriteArrayList(c)) {
                    if (ngVar2.as() == activity && (weakReference2 = ngVar2.h) != null && weakReference2.get() != null) {
                        ((ane) ngVar2.h.get()).af();
                        c.remove(ngVar2);
                    }
                }
            }
        } else if (c != null) {
            for (ng ngVar3 : new CopyOnWriteArrayList(c)) {
                if (ngVar3.as() == activity && (weakReference = ngVar3.g) != null) {
                    bmy.n((View) weakReference.get());
                    c.remove(ngVar3);
                }
            }
        }
        if (activity == ae()) {
            WeakReference weakReference4 = b;
            if (weakReference4 != null) {
                weakReference4.clear();
            }
            b = null;
            bht bhtVar = anj.a;
        }
    }

    public static void aj(Runnable runnable) {
        bht bhtVar = anj.a;
        if (a == null) {
            a = Looper.getMainLooper().getThread();
        }
        if (a != null) {
            Thread threadCurrentThread = Thread.currentThread();
            if (a == null) {
                a = Looper.getMainLooper().getThread();
            }
            if (threadCurrentThread == a) {
                runnable.run();
                return;
            }
        }
        ac().post(runnable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void ak(View view) {
        ng ngVar;
        if (view == null || (ngVar = (ng) view.getTag()) == null) {
            return;
        }
        int i = 0;
        Object[] objArr = 0;
        if (ngVar.n) {
            if (ngVar.ar() != null) {
                ngVar.ar().setVisibility(0);
                return;
            }
            y(((ng) view.getTag()).ao() + "已处于显示状态，请勿重复执行 show() 指令。");
            return;
        }
        ngVar.g = new WeakReference(view);
        StringBuilder sb = new StringBuilder();
        sb.append(ngVar.ao());
        sb.append(".show on ");
        sb.append(ngVar.aw() ? ngVar.as() : "window");
        String string = sb.toString();
        bht bhtVar = anj.a;
        Log.i(">>>", string.toString());
        if (c == null) {
            c = new CopyOnWriteArrayList();
        }
        c.add(ngVar);
        int iAe = dkz.ae(ngVar.v);
        if (iAe == 1) {
            Activity activityAs = ngVar.as();
            try {
                if (activityAs.getWindow().getDecorView().isAttachedToWindow()) {
                    bmy.af(activityAs, view);
                    return;
                } else {
                    activityAs.getWindow().getDecorView().post(new cs(activityAs, view, 11, objArr == true ? 1 : 0));
                    return;
                }
            } catch (Exception unused) {
                if (activityAs == null || activityAs.isDestroyed()) {
                    return;
                }
                bmy.af(activityAs, view);
                return;
            }
        }
        if (iAe == 2) {
            ane aneVar = new ane();
            aneVar.aq = null;
            aneVar.an = view;
            aneVar.ao = ngVar;
            aneVar.aq = new WeakReference(ngVar.as());
            Activity activityAs2 = ngVar.as();
            aneVar.am(activityAs2 instanceof hb ? ((bdm) ((hb) activityAs2).c.v).g : null, "DialogX");
            ngVar.h = new WeakReference(aneVar);
            return;
        }
        if (iAe != 3) {
            if (ngVar.au() == null) {
                return;
            }
            aj(new nf(view, ngVar, i));
            return;
        }
        if (d == null) {
            d = new HashMap();
        }
        d.put(ngVar.ao(), new arj());
        int i2 = anl.a;
        Intent intent = new Intent(ad(), (Class<?>) anl.class);
        if (ngVar.as() == null) {
            intent.addFlags(268435456);
        }
        intent.putExtra("dialogXKey", ngVar.ao());
        intent.putExtra("fromActivityUiStatus", (ngVar.as() == null || ab(ngVar.as()) == null) ? 0 : ab(ngVar.as()).getSystemUiVisibility());
        intent.putExtra("from", ad().hashCode());
        ad().startActivity(intent);
        if (ngVar.as() != null) {
            ngVar.as().overridePendingTransition(0, 0);
        }
    }

    public static void al(TextView textView, CharSequence charSequence) {
        if (textView == null) {
            return;
        }
        if (ah(charSequence)) {
            textView.setVisibility(8);
            textView.setText("");
        } else {
            textView.setVisibility(0);
            textView.setText(charSequence);
        }
    }

    public static void x(View view) {
        if (view == null) {
            return;
        }
        ng ngVar = (ng) view.getTag();
        String str = ngVar.ao() + ".dismiss";
        bht bhtVar = anj.a;
        Log.i(">>>", str.toString());
        CopyOnWriteArrayList copyOnWriteArrayList = c;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(ngVar);
        }
        WeakReference weakReference = ngVar.g;
        if (weakReference != null) {
            weakReference.clear();
        }
        int iAe = dkz.ae(ngVar.v);
        int i = 1;
        if (iAe == 1) {
            bmy.n(view);
            return;
        }
        if (iAe != 2) {
            if (iAe != 3) {
                ac().post(new nf(view, ngVar, i));
                return;
            }
            return;
        }
        WeakReference weakReference2 = ngVar.h;
        if (weakReference2 == null || weakReference2.get() == null) {
            return;
        }
        ((ane) ngVar.h.get()).af();
    }

    public static void y(String str) {
        bht bhtVar = anj.a;
        Log.e(">>>", str.toString());
    }

    public static ArrayList z(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                ArrayList arrayListZ = z(viewGroup.getChildAt(i));
                if (arrayListZ != null) {
                    arrayList.addAll(arrayListZ);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public final void am() {
        this.u = false;
        this.f = new WeakReference(ae());
        if (as() == null && aw()) {
            af(null);
            if (as() == null) {
                y("DialogX 未初始化(E5)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                return;
            }
        }
        if (this.v != 1 && (as() instanceof bup)) {
            ((bup) as()).ap().j(new cyo(this, 1));
        }
        View currentFocus = as().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) as().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public final View an(int i) {
        if (!aw()) {
            Application applicationAa = aa();
            return LayoutInflater.from(applicationAa).cloneInContext(new baz(applicationAa)).inflate(i, (ViewGroup) null);
        }
        if (as() == null) {
            y("DialogX 未初始化(E3)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
            return null;
        }
        Activity activityAs = as();
        return LayoutInflater.from(activityAs).cloneInContext(new baz(activityAs)).inflate(i, (ViewGroup) null);
    }

    public abstract String ao();

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.i;
    }

    public final int aq(boolean z) {
        return this.l[!z ? 1 : 0];
    }

    public final View ar() {
        WeakReference weakReference = this.g;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final Activity as() {
        WeakReference weakReference = this.f;
        if (weakReference == null || weakReference.get() == null) {
            this.f = new WeakReference(ae());
        }
        return (Activity) this.f.get();
    }

    public final Resources at() {
        return as() != null ? as().getResources() : aa() == null ? Resources.getSystem() : aa().getResources();
    }

    public final FrameLayout au() {
        FrameLayout frameLayoutAb;
        Activity activityAs = as();
        if (aw()) {
            if (activityAs == null) {
                activityAs = ae();
                if (activityAs == null) {
                    y("DialogX 错误：在 getRootFrameLayout() 时无法获取绑定的 activity，请确认是否正确初始化：\nDialogX.init(context);\n\n或者使用 .show(activity) 启动对话框\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                    return null;
                }
                this.f = new WeakReference(activityAs);
            }
            frameLayoutAb = ab(activityAs);
        } else {
            frameLayoutAb = (FrameLayout) ar().getParent();
        }
        if (frameLayoutAb != null) {
            return (FrameLayout) new WeakReference(frameLayoutAb).get();
        }
        y("DialogX 错误：在 getRootFrameLayout() 时无法获 activity(" + activityAs + ") 的 decorView，请检查该 activity 是否正常显示且可以使 DialogX 基于其显示。\n若该 activity 不可用，可通过以下代码配置豁免 DialogX 对话框绑定至该 activity，例如：\nDialogX.unsupportedActivitiesPackageNames = new String[]{\n        \"com.bytedance.sdk.openadsdk.stub.activity\",\n        \"com.mobile.auth.gatewayauth\",\n        \"com.google.android.gms.ads\"\n};\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return null;
    }

    public final void av(EditText editText, boolean z) {
        if (as() == null) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) as().getSystemService("input_method");
        if (z) {
            inputMethodManager.showSoftInput(editText, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    public final boolean aw() {
        int i = this.v;
        return i == 1 || i == 4 || i == 3;
    }

    public final boolean ax() {
        int i = this.w;
        if (i == 3) {
            if (aa() == null) {
                if (i != 1) {
                    return false;
                }
            } else if ((at().getConfiguration().uiMode & 48) != 16) {
                return false;
            }
        } else if (i != 1) {
            return false;
        }
        return true;
    }

    public abstract void ay();

    public final void az(buh buhVar) {
        bur burVar = this.i;
        if (burVar != null) {
            try {
                burVar.p(buhVar);
            } catch (Exception unused) {
            }
        }
    }
}
