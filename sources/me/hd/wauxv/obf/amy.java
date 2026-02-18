package me.hd.wauxv.obf;

import android.app.Dialog;
import android.content.DialogInterface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class amy implements DialogInterface.OnCancelListener {
    public final /* synthetic */ anc a;

    public amy(anc ancVar) {
        this.a = ancVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        anc ancVar = this.a;
        Dialog dialog = ancVar.s;
        if (dialog != null) {
            ancVar.onCancel(dialog);
        }
    }
}
