package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ddq {
    public eun a;
    public ArrayList b;

    public static long c(alz alzVar, long j) {
        eun eunVar = alzVar.e;
        ArrayList arrayList = alzVar.l;
        if (eunVar instanceof bkv) {
            return j;
        }
        int size = arrayList.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            alx alxVar = (alx) arrayList.get(i);
            if (alxVar instanceof alz) {
                alz alzVar2 = (alz) alxVar;
                if (alzVar2.e != eunVar) {
                    jMin = Math.min(jMin, c(alzVar2, ((long) alzVar2.g) + j));
                }
            }
        }
        alz alzVar3 = eunVar.s;
        alz alzVar4 = eunVar.r;
        if (alzVar != alzVar3) {
            return jMin;
        }
        long jG = j - eunVar.g();
        return Math.min(Math.min(jMin, c(alzVar4, jG)), jG - ((long) alzVar4.g));
    }

    public static long d(alz alzVar, long j) {
        eun eunVar = alzVar.e;
        ArrayList arrayList = alzVar.l;
        if (eunVar instanceof bkv) {
            return j;
        }
        int size = arrayList.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            alx alxVar = (alx) arrayList.get(i);
            if (alxVar instanceof alz) {
                alz alzVar2 = (alz) alxVar;
                if (alzVar2.e != eunVar) {
                    jMax = Math.max(jMax, d(alzVar2, ((long) alzVar2.g) + j));
                }
            }
        }
        alz alzVar3 = eunVar.r;
        alz alzVar4 = eunVar.s;
        if (alzVar != alzVar3) {
            return jMax;
        }
        long jG = eunVar.g() + j;
        return Math.max(Math.max(jMax, d(alzVar4, jG)), jG - ((long) alzVar4.g));
    }
}
