package me.hd.wauxv.obf;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwg implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ bwn a;

    public bwg(bwn bwnVar) {
        this.a = bwnVar;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        aqe aqeVar;
        if (i == -1 || (aqeVar = this.a.w) == null) {
            return;
        }
        aqeVar.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
