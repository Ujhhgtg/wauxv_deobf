package me.hd.wauxv.obf;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agv implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public agv(esk eskVar) {
        this.b = new WeakReference(eskVar);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Throwable {
        switch (this.a) {
            case 0:
                ((CoordinatorLayout) this.b).aq(0);
                break;
            default:
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                esk eskVar = (esk) ((WeakReference) this.b).get();
                if (eskVar != null) {
                    ArrayList arrayList = eskVar.c;
                    ImageView imageView = eskVar.b;
                    if (!arrayList.isEmpty()) {
                        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int iE = eskVar.e(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                        int iE2 = eskVar.e(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (iE > 0 || iE == Integer.MIN_VALUE) {
                            if (iE2 > 0 || iE2 == Integer.MIN_VALUE) {
                                Iterator it = new ArrayList(arrayList).iterator();
                                while (it.hasNext()) {
                                    ((dht) ((dic) it.next())).ao(iE, iE2);
                                }
                                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(eskVar.d);
                                }
                                eskVar.d = null;
                                arrayList.clear();
                            }
                        }
                        break;
                    }
                }
                break;
        }
        return true;
    }

    public agv(CoordinatorLayout coordinatorLayout) {
        this.b = coordinatorLayout;
    }
}
