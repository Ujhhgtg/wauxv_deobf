package me.hd.wauxv.obf;

import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bau implements View.OnAttachStateChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ bau(Object obj, int i, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    private final void d(View view) {
    }

    private final void e(View view) {
    }

    private final void f(View view) {
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Found duplicated region for block: B:19:0x0059  */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        View view2;
        pw pwVar;
        int i = this.a;
        Object obj = this.c;
        switch (i) {
            case 0:
                break;
            case 1:
                view.removeOnAttachStateChangeListener(this);
                bax baxVar = (bax) obj;
                int i2 = DialogXBaseRelativeLayout.a;
                int i3 = 0;
                if (Build.VERSION.SDK_INT >= 30) {
                    int i4 = -1;
                    try {
                        Application applicationAa = ng.aa();
                        if (applicationAa != null) {
                            i4 = applicationAa.getPackageManager().getApplicationInfo(applicationAa.getPackageName(), 0).targetSdkVersion;
                            break;
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (i4 < 30) {
                        view2 = (View) view.getParent();
                        pwVar = baxVar.e;
                        if (pwVar != null) {
                            view2.removeOnLayoutChangeListener(pwVar);
                        }
                        pw pwVar2 = new pw(this, 1);
                        baxVar.e = pwVar2;
                        view2.addOnLayoutChangeListener(pwVar2);
                        view2.addOnAttachStateChangeListener(new bau(this, i3, view2));
                    }
                } else {
                    view2 = (View) view.getParent();
                    pwVar = baxVar.e;
                    if (pwVar != null) {
                        view2.removeOnLayoutChangeListener(pwVar);
                    }
                    pw pwVar22 = new pw(this, 1);
                    baxVar.e = pwVar22;
                    view2.addOnLayoutChangeListener(pwVar22);
                    view2.addOnAttachStateChangeListener(new bau(this, i3, view2));
                }
                WeakHashMap weakHashMap = ViewCompat.a;
                eqo.c(view);
                break;
            default:
                FragmentManager fragmentManagerVar = (FragmentManager) this.b;
                SomeFragmentManager someFragmentManagerVar = fragmentManagerVar.c;
                fragmentManagerVar.p();
                aln.g((ViewGroup) someFragmentManagerVar.bz.getParent(), ((bds) obj).a).p();
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.a) {
            case 0:
                ((View) this.b).removeOnLayoutChangeListener(((bax) ((bau) this.c).c).e);
                break;
        }
    }
}
