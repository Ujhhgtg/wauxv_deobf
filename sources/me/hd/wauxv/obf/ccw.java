package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ccw implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ViewGroup c;

    public /* synthetic */ ccw(ViewGroup viewGroup, int i, int i2) {
        this.a = i2;
        this.c = viewGroup;
        this.b = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                IHasInvokeMethod bgfVar = ((ccz) this.c).q;
                if (bgfVar != null) {
                    bgfVar.invoke(Integer.valueOf(this.b));
                }
                break;
            default:
                dgi dgiVar = (dgi) this.c;
                FrameLayout frameLayout = dgiVar.a;
                frameLayout.removeAllViews();
                frameLayout.addView(dgiVar.c(this.b));
                break;
        }
    }
}
