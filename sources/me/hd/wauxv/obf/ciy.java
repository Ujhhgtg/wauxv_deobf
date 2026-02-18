package me.hd.wauxv.obf;

import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ciy extends erk {
    public final LinkedHashMap a = new LinkedHashMap();

    @Override // me.hd.wauxv.obf.erk
    public final void h() {
        LinkedHashMap linkedHashMap = this.a;
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            ((erq) it.next()).b();
        }
        linkedHashMap.clear();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        int iIdentityHashCode = System.identityHashCode(this);
        cmz.o(16);
        sb.append(bhv.aj(16, ((long) iIdentityHashCode) & 4294967295L));
        sb.append("} ViewModelStores (");
        Iterator it = this.a.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String string = sb.toString();
        bzo.p(string, "toString(...)");
        return string;
    }
}
