package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class alz implements alx {
    public final eun e;
    public int g;
    public int h;
    public eun a = null;
    public boolean b = false;
    public boolean d = false;
    public int f = 1;
    public int i = 1;
    public anp j = null;
    public boolean k = false;
    public final ArrayList l = new ArrayList();
    public final ArrayList m = new ArrayList();

    public alz(eun eunVar) {
        this.e = eunVar;
    }

    @Override // me.hd.wauxv.obf.alx
    public final void c(alx alxVar) {
        ArrayList<alz> arrayList = this.m;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((alz) it.next()).k) {
                return;
            }
        }
        this.d = true;
        eun eunVar = this.a;
        if (eunVar != null) {
            eunVar.c(this);
        }
        if (this.b) {
            this.e.c(this);
            return;
        }
        alz alzVar = null;
        int i = 0;
        for (alz alzVar2 : arrayList) {
            if (!(alzVar2 instanceof anp)) {
                i++;
                alzVar = alzVar2;
            }
        }
        if (alzVar != null && i == 1 && alzVar.k) {
            anp anpVar = this.j;
            if (anpVar != null) {
                if (!anpVar.k) {
                    return;
                } else {
                    this.g = this.i * anpVar.h;
                }
            }
            p(alzVar.h + this.g);
        }
        eun eunVar2 = this.a;
        if (eunVar2 != null) {
            eunVar2.c(this);
        }
    }

    public final void n(eun eunVar) {
        this.l.add(eunVar);
        if (this.k) {
            eunVar.c(eunVar);
        }
    }

    public final void o() {
        this.m.clear();
        this.l.clear();
        this.k = false;
        this.h = 0;
        this.d = false;
        this.b = false;
    }

    public void p(int i) {
        if (this.k) {
            return;
        }
        this.k = true;
        this.h = i;
        for (alx alxVar : this.l) {
            alxVar.c(alxVar);
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.e.l.br);
        sb.append(":");
        switch (this.f) {
            case 1:
                str = "UNKNOWN";
                break;
            case 2:
                str = "HORIZONTAL_DIMENSION";
                break;
            case 3:
                str = "VERTICAL_DIMENSION";
                break;
            case 4:
                str = "LEFT";
                break;
            case 5:
                str = "RIGHT";
                break;
            case 6:
                str = "TOP";
                break;
            case 7:
                str = "BOTTOM";
                break;
            case 8:
                str = "BASELINE";
                break;
            default:
                str = "null";
                break;
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.k ? Integer.valueOf(this.h) : "unresolved");
        sb.append(") <t=");
        sb.append(this.m.size());
        sb.append(":d=");
        sb.append(this.l.size());
        sb.append(">");
        return sb.toString();
    }
}
