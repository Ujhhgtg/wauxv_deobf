package me.hd.wauxv.obf;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class jh implements Runnable {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ View c;
    public final /* synthetic */ Object d;

    public jh(TextView textView, Typeface typeface, int i) {
        this.c = textView;
        this.d = typeface;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ((TextView) this.c).setTypeface((Typeface) this.d, this.b);
                break;
            default:
                ((BottomSheetBehavior) this.d).ci(this.c, this.b, false);
                break;
        }
    }

    public jh(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
        this.d = bottomSheetBehavior;
        this.c = view;
        this.b = i;
    }
}
