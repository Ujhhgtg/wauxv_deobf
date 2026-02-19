package me.hd.wauxv.obf;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpg {
    public final LinkedHashMap a;

    public bpg(int i) {
        switch (i) {
            case 1:
                this.a = new LinkedHashMap(0, 0.75f, true);
                break;
            default:
                this.a = new LinkedHashMap();
                break;
        }
    }

    public void b(zc zcVar, IInvokable bgfVar) {
        LinkedHashMap linkedHashMap = this.a;
        if (!linkedHashMap.containsKey(zcVar)) {
            linkedHashMap.put(zcVar, new erm(zcVar, bgfVar));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: "
                + emc.ao(zcVar) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH).toString());
    }

    public bmu c() {
        Collection collectionValues = this.a.values();
        throwIfVar1IsNull(collectionValues, "initializers");
        erm[] ermVarArr = (erm[]) collectionValues.toArray(new erm[0]);
        erm[] ermVarArr2 = (erm[]) Arrays.copyOf(ermVarArr, ermVarArr.length);
        throwIfVar1IsNull(ermVarArr2, "initializers");
        bmu bmuVar = new bmu();
        bmuVar.h = ermVarArr2;
        return bmuVar;
    }
}
