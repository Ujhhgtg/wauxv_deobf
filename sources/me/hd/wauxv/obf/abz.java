package me.hd.wauxv.obf;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class abz implements den {
    public final /* synthetic */ int a;
    public final /* synthetic */ hb b;

    public /* synthetic */ abz(hb hbVar, int i) {
        this.a = i;
        this.b = hbVar;
    }

    @Override // me.hd.wauxv.obf.den
    public final Bundle c() {
        hb hbVar;
        switch (this.a) {
            case 0:
                Bundle bundle = new Bundle();
                acg acgVar = this.b.x;
                acgVar.getClass();
                LinkedHashMap linkedHashMap = acgVar.b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(acgVar.d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(acgVar.g));
                return bundle;
        }
        do {
            hbVar = this.b;
        } while (hb.i(((bdm) hbVar.c.v).g));
        hbVar.d.m(LifeEventEnum.ON_STOP);
        return new Bundle();
    }
}
