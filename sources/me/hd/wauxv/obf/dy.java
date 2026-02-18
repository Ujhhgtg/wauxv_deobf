package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dy extends dt {
    public final /* synthetic */ int b;
    public final /* synthetic */ acg c;
    public final /* synthetic */ String d;
    public final /* synthetic */ bhs e;

    public /* synthetic */ dy(acg acgVar, String str, bhs bhsVar, int i) {
        this.b = i;
        this.c = acgVar;
        this.d = str;
        this.e = bhsVar;
    }

    @Override // me.hd.wauxv.obf.dt
    public final void a(String str) throws Exception {
        switch (this.b) {
            case 0:
                acg acgVar = this.c;
                ArrayList arrayList = acgVar.d;
                LinkedHashMap linkedHashMap = acgVar.b;
                String str2 = this.d;
                Object obj = linkedHashMap.get(str2);
                bhs bhsVar = this.e;
                if (obj == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + bhsVar + " and input " + ((Object) str) + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj).intValue();
                arrayList.add(str2);
                try {
                    acgVar.j(iIntValue, bhsVar, str);
                    return;
                } catch (Exception e) {
                    arrayList.remove(str2);
                    throw e;
                }
            default:
                acg acgVar2 = this.c;
                ArrayList arrayList2 = acgVar2.d;
                LinkedHashMap linkedHashMap2 = acgVar2.b;
                String str3 = this.d;
                Object obj2 = linkedHashMap2.get(str3);
                bhs bhsVar2 = this.e;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + bhsVar2 + " and input " + ((Object) str) + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj2).intValue();
                arrayList2.add(str3);
                try {
                    acgVar2.j(iIntValue2, bhsVar2, str);
                    return;
                } catch (Exception e2) {
                    arrayList2.remove(str3);
                    throw e2;
                }
        }
    }

    public void f() {
        this.c.m(this.d);
    }
}
