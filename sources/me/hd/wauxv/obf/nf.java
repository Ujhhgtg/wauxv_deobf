package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.util.concurrent.CopyOnWriteArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nf implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;
    public final /* synthetic */ ng c;

    public /* synthetic */ nf(View view, ng ngVar, int i) {
        this.a = i;
        this.b = view;
        this.c = ngVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                View view = this.b;
                ViewParent parent = view.getParent();
                ng ngVar = this.c;
                if (parent == ngVar.au()) {
                    ng.y(((ng) view.getTag()).ao() + "已处于显示状态，请勿重复执行 show() 指令。");
                } else {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    ngVar.au().addView(view);
                }
                break;
            default:
                View view2 = this.b;
                if (view2.getParent() == null || !(view2.getParent() instanceof ViewGroup)) {
                    ng ngVar2 = this.c;
                    if (ngVar2.au() != null) {
                        ngVar2.au().removeView(view2);
                    }
                } else {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                if (ng.c != null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(ng.c);
                    for (int size = copyOnWriteArrayList.size() - 1; size >= 0; size--) {
                        ng ngVar3 = (ng) copyOnWriteArrayList.get(size);
                        if (ngVar3.as() == ng.ae() && ngVar3.n && ngVar3.ar() != null) {
                            View viewFindViewById = ngVar3.ar().findViewById(R.id.box_root);
                            if ((viewFindViewById instanceof DialogXBaseRelativeLayout) && ((DialogXBaseRelativeLayout) viewFindViewById).e) {
                                viewFindViewById.requestFocus();
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
}
