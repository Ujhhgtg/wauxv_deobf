package me.hd.wauxv.obf;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctb extends awb {
    public final int a;
    public EditText b;
    public final bq c;

    public ctb(awa awaVar, int i) {
        super(awaVar);
        this.a = R.drawable.design_password_eye;
        this.c = new bq(this, 12);
        if (i != 0) {
            this.a = i;
        }
    }

    @Override // me.hd.wauxv.obf.awb
    public final boolean aa() {
        EditText editText = this.b;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // me.hd.wauxv.obf.awb
    public final void aj() {
        al();
    }

    @Override // me.hd.wauxv.obf.awb
    public final boolean ak() {
        return true;
    }

    @Override // me.hd.wauxv.obf.awb
    public final int k() {
        return R.string.password_toggle_content_description;
    }

    @Override // me.hd.wauxv.obf.awb
    public final int l() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.awb
    public final View.OnClickListener n() {
        return this.c;
    }

    @Override // me.hd.wauxv.obf.awb
    public final void p(EditText editText) {
        this.b = editText;
        al();
    }

    @Override // me.hd.wauxv.obf.awb
    public final void r() {
        EditText editText = this.b;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.b.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // me.hd.wauxv.obf.awb
    public final void s() {
        EditText editText = this.b;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
