package me.hd.wauxv.obf;

import bsh.This;
import java.util.ArrayList;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bqn implements Supplier {
    public final /* synthetic */ int a;

    public /* synthetic */ bqn(int i) {
        this.a = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.a) {
            case 0:
                return Boolean.FALSE;
            case 1:
                return new ArrayList();
            default:
                return This.lambda$static$1();
        }
    }
}
