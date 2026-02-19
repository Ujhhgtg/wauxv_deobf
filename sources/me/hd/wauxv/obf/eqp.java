package me.hd.wauxv.obf;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqp implements View.OnApplyWindowInsetsListener {
    public evr a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ cqk c;

    public eqp(View view, cqk cqkVar) {
        this.b = view;
        this.c = cqkVar;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        evr evrVarD = evr.d(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        cqk cqkVar = this.c;
        if (i < 30) {
            eqq.a(windowInsets, this.b);
            if (evrVarD.equals(this.a)) {
                return cqkVar._ae(view, evrVarD).i();
            }
        }
        this.a = evrVarD;
        evr evrVar_ae = cqkVar._ae(view, evrVarD);
        if (i >= 30) {
            return evrVar_ae.i();
        }
        WeakHashMap weakHashMap = ViewCompat.a;
        eqo.c(view);
        return evrVar_ae.i();
    }
}
