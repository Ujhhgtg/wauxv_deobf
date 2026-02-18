package me.hd.wauxv.obf;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dfg {
    public final dff a;

    public dfg(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.a = new dfe(nestedScrollView);
        } else {
            this.a = new cbm(21);
        }
    }
}
