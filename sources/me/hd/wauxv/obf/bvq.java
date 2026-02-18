package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bvq {
    public StringBuilder d;
    public String e;
    public String f;
    public char g;
    public StringBuilder h;
    public int a = 1;
    public final StringBuilder b = new StringBuilder();
    public final ArrayList c = new ArrayList();
    public boolean i = false;

    public final void j() {
        if (this.i) {
            String strE = awq.e(this.f);
            StringBuilder sb = this.h;
            String strE2 = sb != null ? awq.e(sb.toString()) : null;
            String str = this.e;
            bvp bvpVar = new bvp();
            bvpVar.d = str;
            bvpVar.e = strE;
            bvpVar.g = strE2;
            this.c.add(bvpVar);
            this.d = null;
            this.i = false;
            this.e = null;
            this.f = null;
            this.h = null;
        }
    }
}
