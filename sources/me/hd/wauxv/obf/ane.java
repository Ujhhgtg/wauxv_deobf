package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ane extends anc {
    public View an;
    public ng ao;
    public WeakReference aq = null;

    @Override // me.hd.wauxv.obf.anc, me.hd.wauxv.obf.bdj
    public final void ab() {
        Window window;
        super.ab();
        Activity activity = (Activity) this.aq.get();
        Dialog dialog = this.s;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.clearFlags(8);
        window.setSoftInputMode(16);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.dimAmount = 0.0f;
        attributes.format = -2;
        this.an.setOnTouchListener(new and(this, activity));
        window.setAttributes(attributes);
        window.addFlags(67108864);
        window.getDecorView().setPadding(0, 0, 0, 0);
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView().setSystemUiVisibility((activity == null || (activity.getWindow().getDecorView().getSystemUiVisibility() & 8192) != 8192) ? 1280 : 9472);
        window.addFlags(-2013265920);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    @Override // me.hd.wauxv.obf.anc
    public final void af() {
        ag(true, false);
    }

    @Override // me.hd.wauxv.obf.anc
    public final void am(beg begVar, String str) {
        if (begVar == null) {
            bht bhtVar = anj.a;
            Log.e(">>>", "DialogX.DialogFragment 模式无法支持非 AppCompatActivity 启动。");
        } else {
            mu muVar = new mu(begVar);
            muVar.ac(0, this, str, 1);
            muVar.aa(true, true);
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.an;
    }
}
