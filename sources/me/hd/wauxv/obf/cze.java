package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cze {
    public final /* synthetic */ int a;
    public final /* synthetic */ czg b;

    public /* synthetic */ cze(czg czgVar, int i) {
        this.a = i;
        this.b = czgVar;
    }

    public final int c(View view) {
        int iEj;
        int i;
        switch (this.a) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                iEj = czg.ej(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar).rightMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                iEj = czg.ef(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar2).bottomMargin;
                break;
        }
        return iEj + i;
    }

    public final int d(View view) {
        int iEg;
        int i;
        switch (this.a) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                iEg = czg.eg(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar).leftMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                iEg = czg.ek(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar2).topMargin;
                break;
        }
        return iEg - i;
    }

    public final int e() {
        int i;
        int iEw;
        switch (this.a) {
            case 0:
                czg czgVar = this.b;
                i = czgVar.eb;
                iEw = czgVar.ew();
                break;
            default:
                czg czgVar2 = this.b;
                i = czgVar2.ec;
                iEw = czgVar2.eu();
                break;
        }
        return i - iEw;
    }

    public final int f() {
        switch (this.a) {
            case 0:
                return this.b.ev();
            default:
                return this.b.ex();
        }
    }
}
