package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bdo extends bdj {
    public final bgk c;
    public eqj d;

    public bdo(bgk bgkVar) {
        this.c = bgkVar;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        eqj eqjVar = (eqj) this.c.b(layoutInflater, viewGroup, Boolean.FALSE);
        this.d = eqjVar;
        bzo.n(eqjVar);
        return eqjVar.getRoot();
    }

    @Override // me.hd.wauxv.obf.bdj
    public void h() {
        this.bx = true;
        this.d = null;
    }
}
