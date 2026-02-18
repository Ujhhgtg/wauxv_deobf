package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class or implements cqk {
    public int a;
    public View b;
    public int c;

    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        View view2 = this.b;
        int i = evrVar.b.n(519).c;
        int i2 = this.a;
        if (i2 >= 0) {
            view2.getLayoutParams().height = i2 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.c + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return evrVar;
    }

    public View d() {
        if (this.b == null) {
            Activity activityAe = ng.ae();
            this.b = LayoutInflater.from(activityAe).cloneInContext(new baz(activityAe)).inflate(0, (ViewGroup) new RelativeLayout(ng.ae()), false);
        }
        return this.b;
    }
}
