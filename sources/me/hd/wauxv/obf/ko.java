package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ko extends aax {
    public final /* synthetic */ int j = 0;
    public final bwd k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ko(btd btdVar) {
        super(btdVar);
        bzo.q(btdVar, "element");
        dfx descriptor = btdVar.getDescriptor();
        bzo.q(descriptor, "elementDesc");
        this.k = new kl(descriptor, 1);
    }

    @Override // me.hd.wauxv.obf.s
    public final int _s(Object obj) {
        switch (this.j) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                bzo.q(arrayList, "<this>");
                return arrayList.size();
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                bzo.q(linkedHashSet, "<this>");
                return linkedHashSet.size();
        }
    }

    @Override // me.hd.wauxv.obf.s
    public final Object b() {
        switch (this.j) {
            case 0:
                return new ArrayList();
            default:
                return new LinkedHashSet();
        }
    }

    @Override // me.hd.wauxv.obf.s
    public final Iterator d(Object obj) {
        Collection collection = (Collection) obj;
        bzo.q(collection, "<this>");
        return collection.iterator();
    }

    @Override // me.hd.wauxv.obf.s
    public final int e(Object obj) {
        Collection collection = (Collection) obj;
        bzo.q(collection, "<this>");
        return collection.size();
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        switch (this.j) {
            case 0:
                break;
        }
        return (kl) this.k;
    }

    @Override // me.hd.wauxv.obf.s
    public final Object h(Object obj) {
        switch (this.j) {
            case 0:
                List list = (List) obj;
                bzo.q(list, "<this>");
                ArrayList arrayList = list instanceof ArrayList ? (ArrayList) list : null;
                return arrayList == null ? new ArrayList(list) : arrayList;
            default:
                Set set = (Set) obj;
                bzo.q(set, "<this>");
                LinkedHashSet linkedHashSet = set instanceof LinkedHashSet ? (LinkedHashSet) set : null;
                return linkedHashSet == null ? new LinkedHashSet(set) : linkedHashSet;
        }
    }

    @Override // me.hd.wauxv.obf.s
    public final Object i(Object obj) {
        switch (this.j) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                bzo.q(arrayList, "<this>");
                return arrayList;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                bzo.q(linkedHashSet, "<this>");
                return linkedHashSet;
        }
    }

    @Override // me.hd.wauxv.obf.aax
    public final void l(Object obj, int i, Object obj2) {
        switch (this.j) {
            case 0:
                ArrayList arrayList = (ArrayList) obj;
                bzo.q(arrayList, "<this>");
                arrayList.add(i, obj2);
                break;
            default:
                LinkedHashSet linkedHashSet = (LinkedHashSet) obj;
                bzo.q(linkedHashSet, "<this>");
                linkedHashSet.add(obj2);
                break;
        }
    }

    public ko(bzm bzmVar) {
        super(bzmVar);
        dfz dfzVar = (dfz) bzmVar.d;
        bzo.q(dfzVar, "elementDesc");
        this.k = new kl(dfzVar, 2);
    }
}
