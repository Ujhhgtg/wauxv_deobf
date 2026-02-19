package me.hd.wauxv.obf;

import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ais extends awb {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ais(awa awaVar, int i) {
        super(awaVar);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.awb
    public void r() {
        switch (this.a) {
            case 0:
                awa awaVar = this.ag;
                awaVar.o = null;
                CheckableImageButton checkableImageButton = awaVar.g;
                checkableImageButton.setOnLongClickListener(null);
                FastKV.bb(checkableImageButton, null);
                break;
        }
    }
}
