package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.sidesheet.SideSheetBehavior;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bux implements w, bm {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ bux(Object obj, int i) {
        this.d = obj;
        this.c = i;
    }

    @Override // me.hd.wauxv.obf.bm
    public boolean _bm(View view) {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.d;
        int i = this.c;
        int i2 = 1;
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(yg.o(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = sideSheetBehavior.ae;
        if (weakReference == null || weakReference.get() == null) {
            sideSheetBehavior.al(i);
            return true;
        }
        View view2 = (View) sideSheetBehavior.ae.get();
        dct dctVar = new dct(sideSheetBehavior, i, i2);
        ViewParent parent = view2.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = eqz.a;
            if (view2.isAttachedToWindow()) {
                view2.post(dctVar);
                return true;
            }
        }
        dctVar.run();
        return true;
    }

    @Override // me.hd.wauxv.obf.w
    public void a(Object[] objArr, int i) {
        bvb bvbVar = (bvb) this.d;
        CodeEditor codeEditor = bvbVar.b;
        if (codeEditor == null || i > 0) {
            return;
        }
        codeEditor.ei(new acf(bvbVar, codeEditor, this.c));
    }
}
