package me.hd.wauxv.obf;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class acp implements bnz {
    public final HashMap a = new HashMap();

    public final void b(bnz bnzVar) {
        if (bnzVar instanceof acp) {
            throw new IllegalArgumentException();
        }
        for (String str : bnzVar.c()) {
            this.a.put(str, bnzVar);
        }
    }

    @Override // me.hd.wauxv.obf.bnz
    public final String[] c() {
        return new String[0];
    }

    @Override // me.hd.wauxv.obf.bnz
    public final String resolve(String str) {
        bnz bnzVar = (bnz) this.a.get(str);
        return bnzVar != null ? bnzVar.resolve(str) : "";
    }
}
