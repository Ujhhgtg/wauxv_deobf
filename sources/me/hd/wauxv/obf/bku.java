package me.hd.wauxv.obf;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bku extends bdo {
    public final Kotlin$Lazy a;

    public bku() {
        super(bkt.a);
        this.a = new Kotlin$Lazy(new amd(19));
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        eqj eqjVar = this.d;
        throwIfVar1IsNull(eqjVar);
        RecyclerView recyclerView = ((bdr) eqjVar).b;
        dc();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        recyclerView.setAdapter((eqi) this.a.getValue());
    }
}
