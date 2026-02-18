package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mf extends doo implements boc {
    public static final mf a = new mf(cnb.z(-443369473964842L));
    public static final String b = cnb.z(-440582040189738L);
    public static final String c = cnb.z(-440534795549482L);
    public static final String d = cnb.z(-440556270385962L);

    @Override // me.hd.wauxv.obf.boc
    public final void _cc(bmm bmmVar, Intent intent) {
        if (z()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != 812972616) {
                    if (iHashCode != 1600608476 || !className.equals(cnb.z(-443214855142186L))) {
                        return;
                    }
                } else if (!className.equals(cnb.z(-443558452525866L))) {
                    return;
                }
                intent.putExtra(cnb.z(-440603515026218L), true);
            }
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }
}
