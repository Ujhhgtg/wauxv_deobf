package me.hd.wauxv.obf;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ckm {
    public static final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();

    public final void c(ckl cklVar) {
        String strAu = cnd.au(cklVar.getClass());
        if (strAu.length() <= 0) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        LinkedHashMap linkedHashMap = this.b;
        ckl cklVar2 = (ckl) linkedHashMap.get(strAu);
        if (nullSafeIsEqual(cklVar2, cklVar)) {
            return;
        }
        if (cklVar2 != null && cklVar2.v) {
            throw new IllegalStateException(
                    ("Navigator " + cklVar + " is replacing an already attached " + cklVar2).toString());
        }
        if (!cklVar.v) {
            return;
        }
        throw new IllegalStateException(
                ("Navigator " + cklVar + " is already attached to another NavController").toString());
    }

    public final ckl d(String str) {
        throwIfVar1IsNull(str, "name");
        if (str.length() <= 0) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        ckl cklVar = (ckl) this.b.get(str);
        if (cklVar != null) {
            return cklVar;
        }
        throw new IllegalStateException(concat("Could not find Navigator with name \"", str,
                "\". You must call NavController.addNavigator() for each navigation type."));
    }
}
