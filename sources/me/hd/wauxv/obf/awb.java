package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class awb {
    public final TextInputLayout af;
    public final awa ag;
    public final Context ah;
    public final CheckableImageButton ai;

    public awb(awa awaVar) {
        this.af = awaVar.a;
        this.ag = awaVar;
        this.ah = awaVar.getContext();
        this.ai = awaVar.g;
    }

    public boolean aa() {
        return false;
    }

    public void ab(bd bdVar) {
    }

    public void ac(AccessibilityEvent accessibilityEvent) {
    }

    public void aj() {
    }

    public boolean ak() {
        return this instanceof aql;
    }

    public final void al() {
        this.ag.ab(false);
    }

    public void j() {
    }

    public int k() {
        return 0;
    }

    public int l() {
        return 0;
    }

    public View.OnFocusChangeListener m() {
        return null;
    }

    public View.OnClickListener n() {
        return null;
    }

    public View.OnFocusChangeListener o() {
        return null;
    }

    public void p(EditText editText) {
    }

    public void q(boolean z) {
    }

    public void r() {
    }

    public void s() {
    }

    public qp y() {
        return null;
    }

    public boolean z(int i) {
        return true;
    }
}
