package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cdl extends SomeIllegalArgumentException {
    public final List a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public cdl(List list, String str, cdl cdlVar) {
        super(str, cdlVar);
        throwIfVar1IsNull(list, "missingFields");
        this.a = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public cdl(String str, ArrayList arrayList) {
        String str2;
        throwIfVar1IsNull(str, "serialName");
        if (arrayList.size() == 1) {
            str2 = "Field '" + ((String) arrayList.get(0)) + "' is required for type with serial name '" + str
                    + "', but it was missing";
        } else {
            str2 = "Fields " + arrayList + " are required for type with serial name '" + str
                    + "', but they were missing";
        }
        this(arrayList, str2, null);
    }
}
