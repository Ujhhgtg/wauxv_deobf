package me.hd.wauxv.obf;

import android.widget.RelativeLayout;
import com.kongzue.dialogx.util.views.DialogScrollView;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bfr {
    public boolean a;
    public float b;
    public float c;

    public final void d(bfp bfpVar, bfo bfoVar) {
        if (bfpVar == null || bfoVar == null) {
            return;
        }
        RelativeLayout relativeLayout = bfoVar.f;
        MaxRelativeLayout maxRelativeLayout = bfoVar.e;
        if (maxRelativeLayout == null) {
            return;
        }
        if (bfpVar.bd) {
            if (bfoVar.g != null) {
                relativeLayout = maxRelativeLayout;
            }
            relativeLayout.setOnTouchListener(new bfq(this, bfoVar, bfpVar));
        } else {
            dfa dfaVar = bfoVar.g;
            if (dfaVar != null) {
                relativeLayout = maxRelativeLayout;
            }
            if (dfaVar != null) {
                ((DialogScrollView) dfaVar).a = false;
            }
            relativeLayout.setOnTouchListener(null);
        }
    }
}
