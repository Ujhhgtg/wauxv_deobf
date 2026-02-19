package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ewy extends PackageParam {
    public final void ak(PackageParam packageParamVar) {
        Object objX;
        this.aa = packageParamVar.aa;
        try {
            w();
            objX = KotlinUnit.INSTANCE;
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            ArrayList arrayList = ewq.a;
            ewq.g(4, "An exception occurred in " + this, thB);
        }
    }

    public abstract void w();
}
