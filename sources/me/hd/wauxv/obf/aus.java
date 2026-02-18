package me.hd.wauxv.obf;

import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aus extends atd {
    public final /* synthetic */ int c = 0;
    public final WeakReference d;

    public aus(EditText editText) {
        this.d = new WeakReference(editText);
    }

    @Override // me.hd.wauxv.obf.atd
    public void a() {
        switch (this.c) {
            case 1:
                SwitchCompat switchCompat = (SwitchCompat) this.d.get();
                if (switchCompat != null) {
                    switchCompat.av();
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.atd
    public final void b() {
        switch (this.c) {
            case 0:
                aut.d((EditText) this.d.get(), 1);
                break;
            default:
                SwitchCompat switchCompat = (SwitchCompat) this.d.get();
                if (switchCompat != null) {
                    switchCompat.av();
                }
                break;
        }
    }

    public aus(SwitchCompat switchCompat) {
        this.d = new WeakReference(switchCompat);
    }
}
