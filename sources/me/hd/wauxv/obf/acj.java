package me.hd.wauxv.obf;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class acj extends Dialog implements bup, dep {
    public bur i;
    public final but j;
    public final cqt k;

    public acj(Context context, int i) {
        super(context, i);
        this.j = new but(new deo(this, new cfx(this, 12)), 10);
        this.k = new cqt(new dh(this, 5));
    }

    public static void l(acj acjVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        bzo.q(view, "view");
        m();
        super.addContentView(view, layoutParams);
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        return (but) this.j.c;
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        bur burVar = this.i;
        if (burVar != null) {
            return burVar;
        }
        bur burVar2 = new bur(this);
        this.i = burVar2;
        return burVar2;
    }

    public final void m() {
        Window window = getWindow();
        bzo.n(window);
        View decorView = window.getDecorView();
        bzo.p(decorView, "window!!.decorView");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        bzo.n(window2);
        View decorView2 = window2.getDecorView();
        bzo.p(decorView2, "window!!.decorView");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        bzo.n(window3);
        View decorView3 = window3.getDecorView();
        bzo.p(decorView3, "window!!.decorView");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.k.i();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            bzo.p(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            cqt cqtVar = this.k;
            cqtVar.getClass();
            cqtVar.e = onBackInvokedDispatcher;
            cqtVar.j(cqtVar.g);
        }
        this.j.aa(bundle);
        bur burVar = this.i;
        if (burVar == null) {
            burVar = new bur(this);
            this.i = burVar;
        }
        burVar.m(bug.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bzo.p(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.j.ab(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        bur burVar = this.i;
        if (burVar == null) {
            burVar = new bur(this);
            this.i = burVar;
        }
        burVar.m(bug.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        bur burVar = this.i;
        if (burVar == null) {
            burVar = new bur(this);
            this.i = burVar;
        }
        burVar.m(bug.ON_DESTROY);
        this.i = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        bzo.q(view, "view");
        m();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        bzo.q(view, "view");
        m();
        super.setContentView(view, layoutParams);
    }
}
