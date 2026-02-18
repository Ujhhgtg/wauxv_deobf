package me.hd.wauxv.obf;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ald implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ aln b;
    public final /* synthetic */ dlr c;

    public /* synthetic */ ald(aln alnVar, dlr dlrVar, int i) {
        this.a = i;
        this.b = alnVar;
        this.c = dlrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                aln alnVar = this.b;
                bzo.q(alnVar, "this$0");
                dlr dlrVar = this.c;
                bzo.q(dlrVar, "$operation");
                alnVar.i(dlrVar);
                break;
            case 1:
                aln alnVar2 = this.b;
                ArrayList arrayList = alnVar2.b;
                dlr dlrVar2 = this.c;
                if (arrayList.contains(dlrVar2)) {
                    int i = dlrVar2.a;
                    View view = dlrVar2.c.bz;
                    bzo.p(view, "operation.fragment.mView");
                    bjs.a(i, view, alnVar2.a);
                }
                break;
            default:
                aln alnVar3 = this.b;
                ArrayList arrayList2 = alnVar3.b;
                dlr dlrVar3 = this.c;
                arrayList2.remove(dlrVar3);
                alnVar3.c.remove(dlrVar3);
                break;
        }
    }
}
