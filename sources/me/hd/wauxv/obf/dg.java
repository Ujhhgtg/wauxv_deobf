package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dg extends hb implements cea {
    public eqj _ac;
    public final IInvokable a;

    public dg(IInvokable bgfVar) {
        ((but) this.t.c).ad("androidx:appcompat", new gz(this));
        am(new ha(this));
        this.a = bgfVar;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        ceb cebVar = ceb.a;
        if (cebVar != null) {
            return cebVar;
        }
        ceb cebVar2 = new ceb();
        ceb.a = cebVar2;
        return cebVar2;
    }

    @Override // me.hd.wauxv.obf.hb, me.hd.wauxv.obf.aci, android.app.Activity,
              // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        Resources resources;
        boolean z = exm.a;
        if (exm.l() && (resources = getResources()) != null) {
            cnf.bi(resources);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // me.hd.wauxv.obf.hb, me.hd.wauxv.obf.aci, android.app.Activity
    public void onCreate(Bundle bundle) {
        View viewPeekDecorView;
        Context context;
        boolean z = exm.a;
        if (exm.l()) {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(bundle);
        if (aqu.d()) {
            TypedArray typedArrayObtainStyledAttributes = obtainStyledAttributes(aqu.a);
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
            typedArrayObtainStyledAttributes.recycle();
            getTheme().applyStyle(resourceId, true);
            Window window = getWindow();
            Resources.Theme theme = (window == null || (viewPeekDecorView = window.peekDecorView()) == null
                    || (context = viewPeekDecorView.getContext()) == null) ? null : context.getTheme();
            if (theme != null) {
                theme.applyStyle(resourceId, true);
            }
        }
        int i = are.a;
        dow dowVar = dow.a;
        dox doxVar = new dox(0, 0, dowVar);
        dox doxVar2 = new dox(are.a, are.b, dowVar);
        View decorView = getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "window.decorView");
        Resources resources = decorView.getResources();
        throwIfVar1IsNull(resources, "view.resources");
        boolean zBooleanValue = ((Boolean) dowVar.invoke(resources)).booleanValue();
        Resources resources2 = decorView.getResources();
        throwIfVar1IsNull(resources2, "view.resources");
        boolean zBooleanValue2 = ((Boolean) dowVar.invoke(resources2)).booleanValue();
        int i2 = Build.VERSION.SDK_INT;
        arf ariVar = i2 >= 30 ? new ari() : i2 >= 29 ? new arh() : i2 >= 28 ? new arg() : new arf();
        Window window2 = getWindow();
        throwIfVar1IsNull(window2, "window");
        ariVar.b(doxVar, doxVar2, window2, decorView, zBooleanValue, zBooleanValue2);
        Window window3 = getWindow();
        throwIfVar1IsNull(window3, "window");
        ariVar.a(window3);
        eqj eqjVar = (eqj) this.a.invoke(getLayoutInflater());
        this._ac = eqjVar;
        throwIfVar1IsNull(eqjVar);
        setContentView(eqjVar.getRoot());
        eqj eqjVar2 = this._ac;
        throwIfVar1IsNull(eqjVar2);
        View root = eqjVar2.getRoot();
        df dfVar = new df(0);
        WeakHashMap weakHashMap = eqz.a;
        eqq.l(root, dfVar);
    }

    @Override // android.app.Activity
    public final void onRestoreInstanceState(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
        if (bundle2 != null) {
            bundle2.setClassLoader(getClassLoader());
        }
        super.onRestoreInstanceState(bundle);
    }
}
