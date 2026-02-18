package me.hd.wauxv.obf;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yk extends bhv {
    public final /* synthetic */ int _bc;
    public final /* synthetic */ Object b;

    public /* synthetic */ yk(Object obj, int i) {
        this._bc = i;
        this.b = obj;
    }

    private final void c(int i) {
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void d(int i) {
        switch (this._bc) {
            case 0:
                break;
            default:
                dqk dqkVar = (dqk) this.b;
                dqkVar.e = true;
                dqj dqjVar = (dqj) dqkVar.f.get();
                if (dqjVar != null) {
                    dqjVar.n();
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.bhv
    public final void e(Typeface typeface, boolean z) {
        switch (this._bc) {
            case 0:
                Chip chip = (Chip) this.b;
                yo yoVar = chip.d;
                chip.setText(yoVar.bi ? yoVar.j : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z) {
                    dqk dqkVar = (dqk) this.b;
                    dqkVar.e = true;
                    dqj dqjVar = (dqj) dqkVar.f.get();
                    if (dqjVar != null) {
                        dqjVar.n();
                    }
                    break;
                }
                break;
        }
    }
}
