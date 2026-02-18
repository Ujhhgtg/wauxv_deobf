package me.hd.wauxv.obf;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dme extends da implements cbu {
    public Context q;
    public ActionBarContextView r;
    public io s;
    public WeakReference t;
    public boolean u;
    public cbw v;

    @Override // me.hd.wauxv.obf.cbu
    public final void bw(cbw cbwVar) {
        i();
        cw cwVar = this.r.d;
        if (cwVar != null) {
            cwVar.am();
        }
    }

    @Override // me.hd.wauxv.obf.cbu
    public final boolean bx(cbw cbwVar, MenuItem menuItem) {
        return ((chm) this.s.c).am(this, menuItem);
    }

    @Override // me.hd.wauxv.obf.da
    public final void c() {
        if (this.u) {
            return;
        }
        this.u = true;
        this.s.ao(this);
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
        return this.v;
    }

    @Override // me.hd.wauxv.obf.da
    public final MenuInflater f() {
        return new dof(this.r.getContext());
    }

    @Override // me.hd.wauxv.obf.da
    public final CharSequence g() {
        return this.r.getSubtitle();
    }

    @Override // me.hd.wauxv.obf.da
    public final CharSequence h() {
        return this.r.getTitle();
    }

    @Override // me.hd.wauxv.obf.da
    public final void i() {
        this.s.ap(this, this.v);
    }

    @Override // me.hd.wauxv.obf.da
    public final boolean j() {
        return this.r.s;
    }

    @Override // me.hd.wauxv.obf.da
    public final void k(View view) {
        this.r.setCustomView(view);
        this.t = view != null ? new WeakReference(view) : null;
    }

    @Override // me.hd.wauxv.obf.da
    public final void l(int i) {
        m(this.q.getString(i));
    }

    @Override // me.hd.wauxv.obf.da
    public final void m(CharSequence charSequence) {
        this.r.setSubtitle(charSequence);
    }

    @Override // me.hd.wauxv.obf.da
    public final void n(int i) {
        o(this.q.getString(i));
    }

    @Override // me.hd.wauxv.obf.da
    public final void o(CharSequence charSequence) {
        this.r.setTitle(charSequence);
    }

    @Override // me.hd.wauxv.obf.da
    public final void p(boolean z) {
        this.b = z;
        this.r.setTitleOptional(z);
    }
}
