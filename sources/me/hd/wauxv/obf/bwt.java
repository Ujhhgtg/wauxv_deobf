package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwt {
    public final cuv a;
    public final List b;
    public final String c;

    public bwt(Class cls, Class cls2, Class cls3, List list, cuv cuvVar) {
        this.a = cuvVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.b = list;
        this.c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final dcg d(int i, int i2, ek ekVar, ajh ajhVar, crw crwVar) {
        cuv cuvVar = this.a;
        List list = (List) cuvVar.acquire();
        cmz.n(list, "Argument must not be null");
        try {
            List list2 = this.b;
            int size = list2.size();
            dcg dcgVarF = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    dcgVarF = ((ajs) list2.get(i3)).f(i, i2, ekVar, ajhVar, crwVar);
                } catch (bhy e) {
                    list.add(e);
                }
                if (dcgVarF != null) {
                    break;
                }
            }
            if (dcgVarF == null) {
                throw new bhy(this.c, new ArrayList(list));
            }
            cuvVar.l(list);
            return dcgVarF;
        } catch (Throwable th) {
            cuvVar.l(list);
            throw th;
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.b.toArray()) + '}';
    }
}
