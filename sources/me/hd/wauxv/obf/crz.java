package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class crz extends atb {
    public final /* synthetic */ int s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ crz(czg czgVar, int i) {
        super(czgVar);
        this.s = i;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int e(View view) {
        int iEj;
        int i;
        switch (this.s) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEj = czg.ej(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar).rightMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEj = czg.ef(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar2).bottomMargin;
                break;
        }
        return iEj + i;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int f(View view) {
        int iEi;
        int i;
        switch (this.s) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEi = czg.ei(view) + ((ViewGroup.MarginLayoutParams) czhVar).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) czhVar).rightMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEi = czg.eh(view) + ((ViewGroup.MarginLayoutParams) czhVar2).topMargin;
                i = ((ViewGroup.MarginLayoutParams) czhVar2).bottomMargin;
                break;
        }
        return iEi + i;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int g(View view) {
        int iEh;
        int i;
        switch (this.s) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEh = czg.eh(view) + ((ViewGroup.MarginLayoutParams) czhVar).topMargin;
                i = ((ViewGroup.MarginLayoutParams) czhVar).bottomMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEh = czg.ei(view) + ((ViewGroup.MarginLayoutParams) czhVar2).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) czhVar2).rightMargin;
                break;
        }
        return iEh + i;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int h(View view) {
        int iEg;
        int i;
        switch (this.s) {
            case 0:
                czh czhVar = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEg = czg.eg(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar).leftMargin;
                break;
            default:
                czh czhVar2 = (czh) view.getLayoutParams();
                ((czg) this.b).getClass();
                iEg = czg.ek(view);
                i = ((ViewGroup.MarginLayoutParams) czhVar2).topMargin;
                break;
        }
        return iEg - i;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int i() {
        switch (this.s) {
            case 0:
                return ((czg) this.b).eb;
            default:
                return ((czg) this.b).ec;
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int j() {
        int i;
        int iEw;
        switch (this.s) {
            case 0:
                czg czgVar = (czg) this.b;
                i = czgVar.eb;
                iEw = czgVar.ew();
                break;
            default:
                czg czgVar2 = (czg) this.b;
                i = czgVar2.ec;
                iEw = czgVar2.eu();
                break;
        }
        return i - iEw;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int k() {
        switch (this.s) {
            case 0:
                return ((czg) this.b).ew();
            default:
                return ((czg) this.b).eu();
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int l() {
        switch (this.s) {
            case 0:
                return ((czg) this.b).dz;
            default:
                return ((czg) this.b).ea;
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int m() {
        switch (this.s) {
            case 0:
                return ((czg) this.b).ea;
            default:
                return ((czg) this.b).dz;
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int n() {
        switch (this.s) {
            case 0:
                return ((czg) this.b).ev();
            default:
                return ((czg) this.b).ex();
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int o() {
        int iEv;
        int iEw;
        switch (this.s) {
            case 0:
                czg czgVar = (czg) this.b;
                iEv = czgVar.eb - czgVar.ev();
                iEw = czgVar.ew();
                break;
            default:
                czg czgVar2 = (czg) this.b;
                iEv = czgVar2.ec - czgVar2.ex();
                iEw = czgVar2.eu();
                break;
        }
        return iEv - iEw;
    }

    @Override // me.hd.wauxv.obf.atb
    public final int p(View view) {
        switch (this.s) {
            case 0:
                czg czgVar = (czg) this.b;
                Rect rect = (Rect) this.c;
                czgVar.ey(view, rect);
                return rect.right;
            default:
                czg czgVar2 = (czg) this.b;
                Rect rect2 = (Rect) this.c;
                czgVar2.ey(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final int q(View view) {
        switch (this.s) {
            case 0:
                czg czgVar = (czg) this.b;
                Rect rect = (Rect) this.c;
                czgVar.ey(view, rect);
                return rect.left;
            default:
                czg czgVar2 = (czg) this.b;
                Rect rect2 = (Rect) this.c;
                czgVar2.ey(view, rect2);
                return rect2.top;
        }
    }

    @Override // me.hd.wauxv.obf.atb
    public final void r(int i) {
        switch (this.s) {
            case 0:
                ((czg) this.b).ay(i);
                break;
            default:
                ((czg) this.b).az(i);
                break;
        }
    }
}
