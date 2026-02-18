package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bxa implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;

    public /* synthetic */ bxa(View view, int i) {
        this.a = i;
        this.b = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                View view2 = this.b;
                Context context = view2.getContext();
                bzo.o(context, "null cannot be cast to non-null type android.app.Activity" /* cnb.z(-496008593144618L) */);
                Context context2 = view2.getContext();
                bxj.a.getClass();
                jx jxVar = bxj.i;
                btc btcVar = bxj.b[0];
                Intent intent = new Intent(context2, (Class<?>) jxVar.w());
                intent.putExtra("map_view_type" /* cnb.z(-496326420724522L) */, 8);
                ((Activity) context).startActivityForResult(intent, 6);
                break;
            default:
                cnh.ac(this.b.getContext(), "https://hdshare.github.io/WAuxiliary_Plugin/" /* cnb.z(-485090786278186L) */);
                break;
        }
    }
}
