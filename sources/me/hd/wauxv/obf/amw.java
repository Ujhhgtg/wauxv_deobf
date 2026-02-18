package me.hd.wauxv.obf;

import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class amw implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ bfu b;

    public /* synthetic */ amw(bfu bfuVar, int i) {
        this.a = i;
        this.b = bfuVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.a) {
            case 0:
                this.b.invoke();
                break;
            case 1:
                this.b.invoke();
                break;
            default:
                this.b.invoke();
                break;
        }
    }
}
