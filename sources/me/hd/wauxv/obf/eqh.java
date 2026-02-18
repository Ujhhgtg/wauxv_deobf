package me.hd.wauxv.obf;

import android.widget.CompoundButton;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eqh implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ CompoundButton b;

    public /* synthetic */ eqh(CompoundButton compoundButton, int i) {
        this.a = i;
        this.b = compoundButton;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                this.b.setChecked(false);
                break;
            default:
                this.b.setChecked(false);
                break;
        }
        return ens.a;
    }
}
