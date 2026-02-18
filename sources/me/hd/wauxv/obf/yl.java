package me.hd.wauxv.obf;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yl extends ViewOutlineProvider {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ yl(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.a) {
            case 0:
                yo yoVar = ((Chip) this.b).d;
                if (yoVar == null) {
                    outline.setAlpha(0.0f);
                } else {
                    yoVar.getOutline(outline);
                }
                break;
            case 1:
                int width = view.getWidth();
                float height = view.getHeight();
                float f = ((bfo) this.b).l.bb;
                outline.setRoundRect(0, 0, width, (int) (height + f), f);
                break;
            default:
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), ((cct) this.b).o.bj);
                break;
        }
    }
}
