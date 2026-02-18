package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class hr extends emn {
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
                ic icVar = (ic) obj;
                icVar.ai.setVisibility(0);
                if (icVar.ai.getParent() instanceof View) {
                    View view = (View) icVar.ai.getParent();
                    WeakHashMap weakHashMap = eqz.a;
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
                ic icVar = ((hp) obj).b;
                icVar.ai.setAlpha(1.0f);
                icVar.al.e(null);
                icVar.al = null;
                break;
            case 1:
                ic icVar2 = (ic) obj;
                icVar2.ai.setAlpha(1.0f);
                icVar2.al.e(null);
                icVar2.al = null;
                break;
            default:
                ic icVar3 = (ic) ((DefaultConfig) obj).d;
                icVar3.ai.setVisibility(8);
                PopupWindow popupWindow = icVar3.aj;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (icVar3.ai.getParent() instanceof View) {
                    View view = (View) icVar3.ai.getParent();
                    WeakHashMap weakHashMap = eqz.a;
                    eqo.c(view);
                }
                icVar3.ai.aa();
                icVar3.al.e(null);
                icVar3.al = null;
                ViewGroup viewGroup = icVar3.an;
                WeakHashMap weakHashMap2 = eqz.a;
                eqo.c(viewGroup);
                break;
        }
    }
}
