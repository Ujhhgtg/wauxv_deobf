package me.hd.wauxv.obf;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class iz implements AdapterView.OnItemClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ iz(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.a) {
            case 0:
                jb jbVar = (jb) this.b;
                je jeVar = jbVar.q;
                jeVar.setSelection(i);
                if (jeVar.getOnItemClickListener() != null) {
                    jeVar.performItemClick(view, i, jbVar.b.getItemId(i));
                }
                jbVar.dismiss();
                break;
            default:
                caa caaVar = (caa) this.b;
                bwn bwnVar = caaVar.a;
                caa.m(caaVar, i < 0 ? !bwnVar.av.isShowing() ? null : bwnVar.w.getSelectedItem() : caaVar.getAdapter().getItem(i));
                AdapterView.OnItemClickListener onItemClickListener = caaVar.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i < 0) {
                        view = !bwnVar.av.isShowing() ? null : bwnVar.w.getSelectedView();
                        i = !bwnVar.av.isShowing() ? -1 : bwnVar.w.getSelectedItemPosition();
                        j = !bwnVar.av.isShowing() ? Long.MIN_VALUE : bwnVar.w.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(bwnVar.w, view, i, j);
                }
                bwnVar.dismiss();
                break;
        }
    }
}
