package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bed implements bec {
    public final String a;
    public final int b;
    public final /* synthetic */ beg c;

    public bed(beg begVar, String str, int i) {
        this.c = begVar;
        this.a = str;
        this.b = i;
    }

    @Override // me.hd.wauxv.obf.bec
    public final boolean v(ArrayList arrayList, ArrayList arrayList2) {
        SomeFragmentManager someFragmentManagerVar = this.c.z;
        if (someFragmentManagerVar != null && this.b < 0 && this.a == null && someFragmentManagerVar.cp().cm(-1, 0)) {
            return false;
        }
        return this.c.cn(arrayList, arrayList2, this.a, this.b, 1);
    }
}
