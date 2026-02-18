package me.hd.wauxv.obf;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ex implements Comparator {
    public final /* synthetic */ int a;

    public /* synthetic */ ex(int i) {
        this.a = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                return ((int[]) obj)[0] - ((int[]) obj2)[0];
            case 1:
                WeakHashMap weakHashMap = eqz.a;
                float fG = eqq.g((View) obj);
                float fG2 = eqq.g((View) obj2);
                if (fG > fG2) {
                    return -1;
                }
                return fG < fG2 ? 1 : 0;
            case 2:
                return ajn.j(((bmf) obj).getClass().getSimpleName(), ((bmf) obj2).getClass().getSimpleName());
            case 3:
                return ajn.j(((yu) obj).f, ((yu) obj2).f);
            case 4:
                return ajn.j(((cdf) obj).f, ((cdf) obj2).f);
            case 5:
                return ajn.j(Integer.valueOf(((bbe) obj).b), Integer.valueOf(((bbe) obj2).b));
            case 6:
                bgu bguVar = (bgu) obj;
                bgu bguVar2 = (bgu) obj2;
                RecyclerView recyclerView = bguVar.d;
                if ((recyclerView == null) == (bguVar2.d == null)) {
                    boolean z = bguVar.a;
                    if (z == bguVar2.a) {
                        int i = bguVar2.b - bguVar.b;
                        if (i != 0) {
                            return i;
                        }
                        int i2 = bguVar.c - bguVar2.c;
                        if (i2 != 0) {
                            return i2;
                        }
                        return 0;
                    }
                    if (!z) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
            case 7:
                return ajn.j(Integer.valueOf(((biv) obj).c), Integer.valueOf(((biv) obj2).c));
            case 8:
                return ajn.j(((ctx) obj).f, ((ctx) obj2).f);
            case 9:
                return ((dla) obj).b - ((dla) obj2).b;
            case 10:
                return ajn.j(((ctx) obj).f, ((ctx) obj2).f);
            default:
                return ((View) obj).getTop() - ((View) obj2).getTop();
        }
    }
}
