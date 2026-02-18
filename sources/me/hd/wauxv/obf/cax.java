package me.hd.wauxv.obf;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cax<S> extends cti {
    public int a;
    public st b;

    @Override // me.hd.wauxv.obf.bdj
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle == null) {
            bundle = this.ax;
        }
        this.a = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.b = (st) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(cq(), this.a));
        throw null;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void j(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.a);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.b);
    }
}
