package me.hd.wauxv.obf;

import android.app.Activity;
import android.view.MenuItem;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ars implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ars(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        switch (this.a) {
            case 0:
                bfu bfuVar = (bfu) this.b;
                bzo.q(menuItem, "it");
                bfuVar.invoke();
                return true;
            case 1:
                ((djp) this.b).invoke(menuItem);
                return Boolean.TRUE.booleanValue();
            default:
                emn.ax((Activity) this.b);
                return true;
        }
    }
}
