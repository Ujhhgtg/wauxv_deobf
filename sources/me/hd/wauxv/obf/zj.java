package me.hd.wauxv.obf;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zj implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ zj(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.a) {
            case 0:
                zm zmVar = (zm) this.b;
                zn znVar = (zn) this.c;
                Set set = (Set) zmVar.c;
                if (!z) {
                    set.remove(znVar.a);
                } else {
                    set.add(znVar.a);
                }
                break;
            case 1:
                adx adxVar = (adx) this.b;
                adw adwVar = (adw) this.c;
                adxVar.d = z;
                adwVar.b.q();
                adwVar.b.o();
                break;
            default:
                ob obVar = (ob) this.b;
                Switch r1 = (Switch) this.c;
                if (compoundButton.isPressed()) {
                    doo dooVar = obVar.c;
                    dooVar.aj(z);
                    if (z && !dooVar.v) {
                        dooVar.getAllBaseBaseHookInstances();
                    }
                    if (dooVar.getAllSwitchHookInstances()) {
                        Context context = r1.getContext();
                        StringBuilder sb = new StringBuilder();
                        sb.append("重启 " /* "重启 " /* "重启 " /* cnb.z(-57990648429354L)  */);
                        HostInfoRegistry.INSTANCE.getClass();
                        sb.append(HostInfoRegistry.getAppName());
                        sb.append(" 生效" /* " 生效" /* " 生效" /* cnb.z(-57939108821802L)  */);
                        Toast.makeText(context, sb.toString(), 0).show();
                    }
                    break;
                }
                break;
        }
    }
}
