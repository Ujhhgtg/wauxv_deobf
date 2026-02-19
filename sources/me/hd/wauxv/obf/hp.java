package me.hd.wauxv.obf;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hp implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ AppCompatDelegate b;

    public /* synthetic */ hp(AppCompatDelegate appCompatDelegateVar, int i) {
        this.a = i;
        this.b = appCompatDelegateVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.a) {
            case 0:
                AppCompatDelegate appCompatDelegateVar = this.b;
                if ((appCompatDelegateVar.bm & 1) != 0) {
                    appCompatDelegateVar.ce(0);
                }
                if ((appCompatDelegateVar.bm & 4096) != 0) {
                    appCompatDelegateVar.ce(108);
                }
                appCompatDelegateVar.bl = false;
                appCompatDelegateVar.bm = 0;
                break;
            default:
                AppCompatDelegate appCompatDelegateVar2 = this.b;
                appCompatDelegateVar2.aj.showAtLocation(appCompatDelegateVar2.ai, 55, 0, 0);
                esg esgVar = appCompatDelegateVar2.al;
                if (esgVar != null) {
                    esgVar.c();
                }
                if (appCompatDelegateVar2.am && (viewGroup = appCompatDelegateVar2.an) != null && viewGroup.isLaidOut()) {
                    appCompatDelegateVar2.ai.setAlpha(0.0f);
                    esg esgVarG = ViewCompat.getOrCreateAnimationHelper(appCompatDelegateVar2.ai);
                    esgVarG.b(1.0f);
                    appCompatDelegateVar2.al = esgVarG;
                    esgVarG.e(new hr(this, 0));
                } else {
                    appCompatDelegateVar2.ai.setAlpha(1.0f);
                    appCompatDelegateVar2.ai.setVisibility(0);
                }
                break;
        }
    }
}
