package me.hd.wauxv.obf;

import android.view.View;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpt extends ua {
    public final View a;
    public int l;
    public int m;
    public final int[] n;

    public bpt(View view) {
        super(0);
        this.n = new int[2];
        this.a = view;
    }

    @Override // me.hd.wauxv.obf.ua
    public final void _bs() {
        this.a.setTranslationY(0.0f);
    }

    @Override // me.hd.wauxv.obf.ua
    public final void _bt() {
        View view = this.a;
        int[] iArr = this.n;
        view.getLocationOnScreen(iArr);
        this.l = iArr[1];
    }

    @Override // me.hd.wauxv.obf.ua
    public final evr _bu(evr evrVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if ((((eva) it.next()).a.d() & 8) != 0) {
                this.a.setTranslationY(ff.h(this.m, r0.a.c(), 0));
                break;
            }
        }
        return evrVar;
    }

    @Override // me.hd.wauxv.obf.ua
    public final but _bv(but butVar) {
        View view = this.a;
        int[] iArr = this.n;
        view.getLocationOnScreen(iArr);
        int i = this.l - iArr[1];
        this.m = i;
        view.setTranslationY(i);
        return butVar;
    }
}
