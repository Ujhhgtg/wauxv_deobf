package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsetsController;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bav implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ bax b;

    public bav(bax baxVar, View view) {
        this.b = baxVar;
        this.a = view;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect rect = new Rect();
        View view = this.a;
        view.getWindowVisibleDisplayFrame(rect);
        int height = view.getHeight();
        int i = Build.VERSION.SDK_INT;
        bax baxVar = this.b;
        WindowInsetsController windowInsetsController = i >= 30 ? baxVar.l().getWindowInsetsController() : null;
        if (i >= 30 && windowInsetsController != null && (windowInsetsController.getSystemBarsBehavior() & 16) == 0) {
            rect.bottom = height;
        }
        int i2 = height - rect.bottom;
        if (i2 != baxVar.g) {
            baxVar.g = i2;
            int i3 = DialogXBaseRelativeLayout.a;
            baw bawVar = baxVar.f;
            if (bawVar != null) {
                baxVar.j(bawVar);
            }
        }
    }
}
