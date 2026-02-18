package me.hd.wauxv.obf;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ef implements AdapterView.OnItemClickListener {
    public final /* synthetic */ ej a;
    public final /* synthetic */ eg b;

    public ef(eg egVar, ej ejVar) {
        this.b = egVar;
        this.a = ejVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        eg egVar = this.b;
        DialogInterface.OnClickListener onClickListener = egVar.q;
        ej ejVar = this.a;
        onClickListener.onClick(ejVar.b, i);
        if (egVar.s) {
            return;
        }
        ejVar.b.dismiss();
    }
}
