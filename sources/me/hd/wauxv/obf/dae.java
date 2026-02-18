package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dae extends doo implements boc {
    public static final dae a = new dae(cnb.z(-536638983764778L));
    public static final String b = cnb.z(-538734927805226L);
    public static final String c = cnb.z(-538739222772522L);
    public static final String i = cnb.z(-538709158001450L);

    @Override // me.hd.wauxv.obf.boc
    public final void _cc(bmm bmmVar, Intent intent) {
        if (z()) {
            ComponentName component = intent.getComponent();
            String className = component != null ? component.getClassName() : null;
            if (className != null) {
                int iHashCode = className.hashCode();
                if (iHashCode != -1765744774) {
                    if (iHashCode != 1306075868 || !className.equals(cnb.z(-537102840232746L))) {
                        return;
                    }
                } else if (!className.equals(cnb.z(-536862322064170L))) {
                    return;
                }
                intent.putExtra(cnb.z(-538275366304554L), 1);
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
        return i;
    }
}
