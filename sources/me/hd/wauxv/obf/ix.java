package me.hd.wauxv.obf;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ix implements jd, DialogInterface.OnClickListener {
    public el a;
    public iy b;
    public CharSequence c;
    public final /* synthetic */ je d;

    public ix(je jeVar) {
        this.d = jeVar;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void dismiss() {
        el elVar = this.a;
        if (elVar != null) {
            elVar.dismiss();
            this.a = null;
        }
    }

    @Override // me.hd.wauxv.obf.jd
    public final boolean e() {
        el elVar = this.a;
        if (elVar != null) {
            return elVar.isShowing();
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.jd
    public final int f() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void g(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
    }

    @Override // me.hd.wauxv.obf.jd
    public final CharSequence h() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.jd
    public final Drawable i() {
        return null;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void j(CharSequence charSequence) {
        this.c = charSequence;
    }

    @Override // me.hd.wauxv.obf.jd
    public final void k(Drawable drawable) {
        Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
    }

    @Override // me.hd.wauxv.obf.jd
    public final void l(int i) {
        Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
    }

    @Override // me.hd.wauxv.obf.jd
    public final void m(int i) {
        Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
    }

    @Override // me.hd.wauxv.obf.jd
    public final void n(int i, int i2) {
        if (this.b == null) {
            return;
        }
        je jeVar = this.d;
        ek ekVar = new ek(jeVar.getPopupContext());
        eg egVar = (eg) ekVar.d;
        CharSequence charSequence = this.c;
        if (charSequence != null) {
            egVar.d = charSequence;
        }
        iy iyVar = this.b;
        int selectedItemPosition = jeVar.getSelectedItemPosition();
        egVar.p = iyVar;
        egVar.q = this;
        egVar.t = selectedItemPosition;
        egVar.s = true;
        el elVarI = ekVar.i();
        this.a = elVarI;
        AlertController$RecycleListView alertController$RecycleListView = elVarI.c.f;
        alertController$RecycleListView.setTextDirection(i);
        alertController$RecycleListView.setTextAlignment(i2);
        this.a.show();
    }

    @Override // me.hd.wauxv.obf.jd
    public final int o() {
        return 0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        je jeVar = this.d;
        jeVar.setSelection(i);
        if (jeVar.getOnItemClickListener() != null) {
            jeVar.performItemClick(null, i, this.b.getItemId(i));
        }
        dismiss();
    }

    @Override // me.hd.wauxv.obf.jd
    public final void p(ListAdapter listAdapter) {
        this.b = (iy) listAdapter;
    }
}
