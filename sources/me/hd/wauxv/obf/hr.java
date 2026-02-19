package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hr extends StaticHelpers7 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ hr(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.emn, me.hd.wauxv.obf.esi
    public void e() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((hp) obj).b.ai.setVisibility(0);
                break;
            case 1:
                AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) obj;
                appCompatDelegateVar.ai.setVisibility(0);
                if (appCompatDelegateVar.ai.getParent() instanceof View) {
                    View view = (View) appCompatDelegateVar.ai.getParent();
                    WeakHashMap weakHashMap = ViewCompat.a;
                    eqo.c(view);
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.esi
    public final void f() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                AppCompatDelegate appCompatDelegateVar = ((hp) obj).b;
                appCompatDelegateVar.ai.setAlpha(1.0f);
                appCompatDelegateVar.al.e(null);
                appCompatDelegateVar.al = null;
                break;
            case 1:
                AppCompatDelegate appCompatDelegateVar2 = (AppCompatDelegate) obj;
                appCompatDelegateVar2.ai.setAlpha(1.0f);
                appCompatDelegateVar2.al.e(null);
                appCompatDelegateVar2.al = null;
                break;
            default:
                AppCompatDelegate appCompatDelegateVar3 = (AppCompatDelegate) ((DefaultConfig) obj).d;
                appCompatDelegateVar3.ai.setVisibility(8);
                PopupWindow popupWindow = appCompatDelegateVar3.aj;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateVar3.ai.getParent() instanceof View) {
                    View view = (View) appCompatDelegateVar3.ai.getParent();
                    WeakHashMap weakHashMap = ViewCompat.a;
                    eqo.c(view);
                }
                appCompatDelegateVar3.ai.aa();
                appCompatDelegateVar3.al.e(null);
                appCompatDelegateVar3.al = null;
                ViewGroup viewGroup = appCompatDelegateVar3.an;
                WeakHashMap weakHashMap2 = ViewCompat.a;
                eqo.c(viewGroup);
                break;
        }
    }
}
