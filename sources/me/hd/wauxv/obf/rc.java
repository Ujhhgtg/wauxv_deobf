package me.hd.wauxv.obf;

import bsh.classpath.BshClassPath;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class rc implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ rc(int i, ArrayList arrayList) {
        this.a = i;
        this.b = arrayList;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BshClassPath.lambda$getFullPath$2(this.b, (BshClassPath) obj);
                break;
            default:
                this.b.add((Constructor) obj);
                break;
        }
    }
}
