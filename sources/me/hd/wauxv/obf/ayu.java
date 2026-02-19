package me.hd.wauxv.obf;

import android.view.ContextMenu;
import android.view.MenuItem;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ayu implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ ContextMenu b;

    public /* synthetic */ ayu(ContextMenu contextMenu, int i) {
        this.a = i;
        this.b = contextMenu;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i = this.a;
        Class cls = Integer.TYPE;
        ContextMenu contextMenu = this.b;
        switch (i) {
            case 0:
                int i2 = 0;
                cde cdeVarT = dqc.bi(contextMenu).t();
                cdeVarT.a = dal.b(MenuItem.class);
                return (MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(cls), dal.b(cls), dal.b(CharSequence.class), dal.b(cls)}, 5, cdeVarT);
            case 1:
                int i3 = 0;
                cde cdeVarT2 = dqc.bi(contextMenu).t();
                cdeVarT2.a = dal.b(MenuItem.class);
                return (MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(cls), dal.b(cls), dal.b(CharSequence.class), dal.b(cls)}, 5, cdeVarT2);
            case 2:
                int i4 = 0;
                cde cdeVarT3 = dqc.bi(contextMenu).t();
                cdeVarT3.a = dal.b(MenuItem.class);
                return (MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(CharSequence.class), dal.b(cls)}, 3, cdeVarT3);
            case 3:
                int i5 = 0;
                cde cdeVarT4 = dqc.bi(contextMenu).t();
                cdeVarT4.a = dal.b(MenuItem.class);
                return (MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(CharSequence.class), dal.b(cls)}, 3, cdeVarT4);
            default:
                int i6 = 0;
                cde cdeVarT5 = dqc.bi(contextMenu).t();
                cdeVarT5.a = dal.b(MenuItem.class);
                return (MethodHookWrapper) dkz.n(new Object[]{dal.b(cls), dal.b(CharSequence.class)}, 2, cdeVarT5);
        }
    }
}
