package me.hd.wauxv.obf;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amz implements DialogInterface.OnDismissListener {
    public final /* synthetic */ anc a;

    public amz(anc ancVar) {
        this.a = ancVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        anc ancVar = this.a;
        Dialog dialog = ancVar.s;
        if (dialog != null) {
            ancVar.onDismiss(dialog);
        }
    }
}
