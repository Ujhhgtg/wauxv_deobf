package me.hd.wauxv.obf;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eus extends da implements cbu {
    public final Context q;
    public final cbw r;
    public DefaultConfig s;
    public WeakReference t;
    public final /* synthetic */ eut u;

    public eus(eut eutVar, Context context, DefaultConfig ioVar) {
        this.u = eutVar;
        this.q = context;
        this.s = ioVar;
        cbw cbwVar = new cbw(context);
        cbwVar.m = 1;
        this.r = cbwVar;
        cbwVar.f = this;
    }

    @Override // me.hd.wauxv.obf.cbu
    public final void bw(cbw cbwVar) {
        if (this.s == null) {
            return;
        }
        i();
        cw cwVar = this.u.au.d;
        if (cwVar != null) {
            cwVar.am();
        }
    }

    @Override // me.hd.wauxv.obf.cbu
    public final boolean bx(cbw cbwVar, MenuItem menuItem) {
        DefaultConfig ioVar = this.s;
        if (ioVar != null) {
            return ((chm) ioVar.c).am(this, menuItem);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.da
    public final void c() {
        eut eutVar = this.u;
        if (eutVar.ax != this) {
            return;
        }
        if (eutVar.be) {
            eutVar.ay = this;
            eutVar.az = this.s;
        } else {
            this.s.ao(this);
        }
        this.s = null;
        eutVar.bn(false);
        ActionBarContextView actionBarContextView = eutVar.au;
        if (actionBarContextView.k == null) {
            actionBarContextView.aa();
        }
        eutVar.ar.setHideOnContentScrollEnabled(eutVar.bj);
        eutVar.ax = null;
    }

    @Override // me.hd.wauxv.obf.da
    public final View d() {
        WeakReference weakReference = this.t;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.da
    public final cbw e() {
        return this.r;
    }

    @Override // me.hd.wauxv.obf.da
    public final MenuInflater f() {
        return new dof(this.q);
    }

    @Override // me.hd.wauxv.obf.da
    public final CharSequence g() {
        return this.u.au.getSubtitle();
    }

    @Override // me.hd.wauxv.obf.da
    public final CharSequence h() {
        return this.u.au.getTitle();
    }

    @Override // me.hd.wauxv.obf.da
    public final void i() {
        if (this.u.ax != this) {
            return;
        }
        cbw cbwVar = this.r;
        cbwVar.av();
        try {
            this.s.ap(this, cbwVar);
        } finally {
            cbwVar.au();
        }
    }

    @Override // me.hd.wauxv.obf.da
    public final boolean j() {
        return this.u.au.s;
    }

    @Override // me.hd.wauxv.obf.da
    public final void k(View view) {
        this.u.au.setCustomView(view);
        this.t = new WeakReference(view);
    }

    @Override // me.hd.wauxv.obf.da
    public final void l(int i) {
        m(this.u.ap.getResources().getString(i));
    }

    @Override // me.hd.wauxv.obf.da
    public final void m(CharSequence charSequence) {
        this.u.au.setSubtitle(charSequence);
    }

    @Override // me.hd.wauxv.obf.da
    public final void n(int i) {
        o(this.u.ap.getResources().getString(i));
    }

    @Override // me.hd.wauxv.obf.da
    public final void o(CharSequence charSequence) {
        this.u.au.setTitle(charSequence);
    }

    @Override // me.hd.wauxv.obf.da
    public final void p(boolean z) {
        this.b = z;
        this.u.au.setTitleOptional(z);
    }
}
