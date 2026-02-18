package me.hd.wauxv.obf;

import android.view.MenuItem;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dod implements MenuItem.OnMenuItemClickListener {
    public static final Class[] a = {MenuItem.class};
    public final /* synthetic */ int b = 0;
    public Object c;
    public Object d;

    public /* synthetic */ dod() {
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        switch (this.b) {
            case 0:
                Object obj = this.c;
                Method method = (Method) this.d;
                try {
                    if (method.getReturnType() == Boolean.TYPE) {
                        return ((Boolean) method.invoke(obj, menuItem)).booleanValue();
                    }
                    method.invoke(obj, menuItem);
                    return true;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            default:
                return ((MenuItem.OnMenuItemClickListener) this.c).onMenuItemClick(((ccd) this.d).l(menuItem));
        }
    }

    public dod(ccd ccdVar, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.d = ccdVar;
        this.c = onMenuItemClickListener;
    }
}
