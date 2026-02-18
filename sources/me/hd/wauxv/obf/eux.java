package me.hd.wauxv.obf;

import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eux extends WindowInsetsAnimation$Callback {
    public final ua a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public eux(ua uaVar) {
        super(uaVar.b);
        this.d = new HashMap();
        this.a = uaVar;
    }

    public final eva e(WindowInsetsAnimation windowInsetsAnimation) {
        eva evaVar = (eva) this.d.get(windowInsetsAnimation);
        if (evaVar == null) {
            evaVar = new eva(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                evaVar.a = new euy(windowInsetsAnimation);
            }
            this.d.put(windowInsetsAnimation, evaVar);
        }
        return evaVar;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        e(windowInsetsAnimation);
        this.a._bs();
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        e(windowInsetsAnimation);
        this.a._bt();
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationK = aw.k(list.get(size));
            eva evaVarE = e(windowInsetsAnimationK);
            evaVarE.a.e(windowInsetsAnimationK.getFraction());
            this.c.add(evaVarE);
        }
        return this.a._bu(evr.d(null, windowInsets), this.b).i();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        e(windowInsetsAnimation);
        but butVar_bv = this.a._bv(new but(bounds));
        butVar_bv.getClass();
        aw.n();
        return aw.i(((bps) butVar_bv.b).i(), ((bps) butVar_bv.c).i());
    }
}
