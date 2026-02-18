package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.view.MenuItem;
import java.io.File;
import me.hd.wauxv.ui.activity.MainActivity;
import me.hd.wauxv.ui.fragment.module.page.CodeFragment;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aam implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ aam(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                File file = new File((String) obj2);
                eqj eqjVar = ((CodeFragment) obj).d;
                bzo.n(eqjVar);
                bad.e(file, ((bdp) eqjVar).b.getText().toString());
                dnc.g(null, 3, cnb.z(-420137995860778L));
                break;
            default:
                MainActivity mainActivity = (MainActivity) obj2;
                MenuItem menuItem2 = (MenuItem) obj;
                int i2 = MainActivity.as;
                mainActivity.getPackageManager().setComponentEnabledSetting(new ComponentName(mainActivity.getPackageName(), mainActivity.at), !mainActivity.au(mainActivity) ? 2 : 1, 1);
                menuItem2.setChecked(mainActivity.au(mainActivity));
                break;
        }
        return true;
    }
}
