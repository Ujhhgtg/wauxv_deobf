package me.hd.wauxv.obf;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class np implements Runnable {
    public final /* synthetic */ int a;
    public int b;
    public final Object c;

    public /* synthetic */ np(Object obj, int i, int i2) {
        this.a = i2;
        this.c = obj;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                ((ns) this.c).h.ao(this.b, 4);
                break;
            case 1:
                bmu bmuVar = (bmu) this.c;
                int i = this.b;
                bht bhtVar = (bht) bmuVar.h;
                if (bhtVar != null) {
                    bhtVar.e(i);
                }
                break;
            case 2:
                ArrayList arrayList = (ArrayList) this.c;
                int size = arrayList.size();
                int i2 = 0;
                if (this.b == 1) {
                    while (i2 < size) {
                        ((atd) arrayList.get(i2)).b();
                        i2++;
                    }
                } else {
                    while (i2 < size) {
                        ((atd) arrayList.get(i2)).a();
                        i2++;
                    }
                }
                break;
            case 3:
                ((cal) this.c).n.et(this.b);
                break;
            case 4:
                ((cjy) this.c).as(this.b);
                break;
            default:
                ((RecyclerView) this.c).et(this.b);
                break;
        }
    }

    public np(int i, esd esdVar) {
        this.a = 5;
        this.b = i;
        this.c = esdVar;
    }

    public np(List list, int i, Throwable th) {
        this.a = 2;
        cna.j(list, "initCallbacks cannot be null");
        this.c = new ArrayList(list);
        this.b = i;
    }

    public np(ns nsVar) {
        this.a = 0;
        this.c = nsVar;
        this.b = -1;
    }
}
