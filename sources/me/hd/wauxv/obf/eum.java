package me.hd.wauxv.obf;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eum {
    public static int a;
    public ArrayList b;
    public int c;
    public int d;
    public ArrayList e;
    public int f;

    public final void g(ArrayList arrayList) {
        int size = this.b.size();
        if (this.f != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                eum eumVar = (eum) arrayList.get(i);
                if (this.f == eumVar.c) {
                    i(this.d, eumVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int h(bvm bvmVar, int i) {
        int iR;
        int iR2;
        ArrayList arrayList = this.b;
        if (arrayList.size() == 0) {
            return 0;
        }
        adr adrVar = (adr) ((adq) arrayList.get(0)).bd;
        bvmVar.ak();
        adrVar.e(bvmVar, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((adq) arrayList.get(i2)).e(bvmVar, false);
        }
        if (i == 0 && adrVar.dq > 0) {
            bmy.k(adrVar, bvmVar, arrayList, 0);
        }
        if (i == 1 && adrVar.dr > 0) {
            bmy.k(adrVar, bvmVar, arrayList, 1);
        }
        try {
            bvmVar.ag();
        } catch (Exception e) {
            System.err.println(e.toString() + "\n" + Arrays.toString(e.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.e = new ArrayList();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            adq adqVar = (adq) arrayList.get(i3);
            dop dopVar = new dop(23);
            new WeakReference(adqVar);
            bvm.r(adqVar.as);
            bvm.r(adqVar.at);
            bvm.r(adqVar.au);
            bvm.r(adqVar.av);
            bvm.r(adqVar.aw);
            this.e.add(dopVar);
        }
        if (i == 0) {
            iR = bvm.r(adrVar.as);
            iR2 = bvm.r(adrVar.au);
            bvmVar.ak();
        } else {
            iR = bvm.r(adrVar.at);
            iR2 = bvm.r(adrVar.av);
            bvmVar.ak();
        }
        return iR2 - iR;
    }

    public final void i(int i, eum eumVar) {
        int i2 = eumVar.c;
        for (adq adqVar : this.b) {
            ArrayList arrayList = eumVar.b;
            if (!arrayList.contains(adqVar)) {
                arrayList.add(adqVar);
            }
            if (i == 0) {
                adqVar.bx = i2;
            } else {
                adqVar.by = i2;
            }
        }
        this.f = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.d;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strM = yg.concatToVar1(sb, "] <", this.c);
        for (adq adqVar : this.b) {
            StringBuilder sbR = concat(strM, " ");
            sbR.append(adqVar.br);
            strM = sbR.toString();
        }
        return StaticHelpers6.concat(strM, " >");
    }
}
