package me.hd.wauxv.obf;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cck extends bwn implements cby {
    public static final Method a;
    public erp b;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // me.hd.wauxv.obf.bwn
    public final aqe aw(Context context, boolean z) {
        ccj ccjVar = new ccj(context, z);
        ccjVar.setHoverListener(this);
        return ccjVar;
    }

    @Override // me.hd.wauxv.obf.cby
    public final void q(cbw cbwVar, MenuItem menuItem) {
        erp erpVar = this.b;
        if (erpVar != null) {
            erpVar.ensureParameterNotNull(cbwVar, menuItem);
        }
    }

    @Override // me.hd.wauxv.obf.cby
    public final void r(cbw cbwVar, cbz cbzVar) {
        erp erpVar = this.b;
        if (erpVar != null) {
            erpVar.r(cbwVar, cbzVar);
        }
    }
}
