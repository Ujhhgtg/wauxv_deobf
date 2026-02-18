package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import android.widget.ImageView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pw implements View.OnLayoutChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ pw(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        mx mxVar;
        int i9 = this.a;
        Object obj = this.b;
        switch (i9) {
            case 0:
                throw null;
            case 1:
                bau bauVar = (bau) obj;
                WindowInsets rootWindowInsets = view.getRootView().getRootWindowInsets();
                if (rootWindowInsets == null) {
                    ((bax) bauVar.c).getClass();
                    int i10 = DialogXBaseRelativeLayout.a;
                    return;
                } else {
                    ((bax) bauVar.c).getClass();
                    int i11 = DialogXBaseRelativeLayout.a;
                    ((bax) bauVar.c).k(evr.d(null, rootWindowInsets), new baw((baw) bauVar.b));
                    return;
                }
            case 2:
                bfo bfoVar = (bfo) obj;
                MaxRelativeLayout maxRelativeLayout = bfoVar.e;
                DialogXBaseRelativeLayout dialogXBaseRelativeLayout = bfoVar.c;
                if (i8 - i6 == i4 - i2 || bfoVar.k || dialogXBaseRelativeLayout.getFitSystemBarUtils().a) {
                    return;
                }
                bfoVar.p();
                float safeHeight = ((dialogXBaseRelativeLayout.getSafeHeight() - bfoVar.j.bottom) - bfoVar.i) - dialogXBaseRelativeLayout.getUnsafePlace().top;
                if (safeHeight < 0.0f) {
                    safeHeight = 0.0f;
                }
                if (safeHeight != bfoVar.h && maxRelativeLayout.getY() != safeHeight) {
                    float f = bfoVar.h;
                    bfoVar.h = safeHeight;
                    bfoVar.n((int) f, (int) safeHeight, true);
                    return;
                } else {
                    if (maxRelativeLayout.getY() == safeHeight || safeHeight == 0.0f) {
                        return;
                    }
                    maxRelativeLayout.setY(safeHeight);
                    return;
                }
            case 3:
                cjy cjyVar = (cjy) obj;
                ImageView imageView = cjyVar.r;
                if (imageView.getVisibility() != 0 || (mxVar = cjyVar.aj) == null) {
                    return;
                }
                Rect rect = new Rect();
                imageView.getDrawingRect(rect);
                mxVar.setBounds(rect);
                mxVar.v(imageView, null);
                return;
            default:
                ekv ekvVar = (ekv) obj;
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                ekvVar.o = iArr[0];
                view.getWindowVisibleDisplayFrame(ekvVar.g);
                return;
        }
    }
}
