package me.hd.wauxv.obf;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cua extends bdo {
    public final ArrayList a;
    public final dov b;

    public cua() {
        super(ctz.a);
        this.a = new ArrayList();
        this.b = new dov(new cfx(this, 8));
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void cz() {
        this.bx = true;
        bhp bhpVar = new bhp(this, null);
        alc alcVar = aou.a;
        cnd.bf(bza.a, bhpVar);
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        eqj eqjVar = this.d;
        throwIfVar1IsNull(eqjVar);
        RecyclerView recyclerView = ((bev) eqjVar).b;
        dc();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        recyclerView.setAdapter((eqi) this.b.getValue());
    }
}
