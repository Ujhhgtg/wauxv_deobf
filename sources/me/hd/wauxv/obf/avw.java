package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class avw {
    public final ArrayList a;

    public avw(int i) {
        switch (i) {
            case 1:
                this.a = new ArrayList();
                break;
            case 2:
                this.a = new ArrayList();
                break;
            case 3:
                this.a = new ArrayList();
                break;
            default:
                this.a = new ArrayList();
                break;
        }
    }

    public synchronized dcm b(Class cls) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            dcn dcnVar = (dcn) this.a.get(i);
            if (dcnVar.a.isAssignableFrom(cls)) {
                return dcnVar.b;
            }
        }
        return null;
    }

    public synchronized ArrayList c(Class cls, Class cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (ekz ekzVar : this.a) {
            if ((ekzVar.a.isAssignableFrom(cls) && cls2.isAssignableFrom(ekzVar.b)) && !arrayList.contains(ekzVar.b)) {
                arrayList.add(ekzVar.b);
            }
        }
        return arrayList;
    }
}
