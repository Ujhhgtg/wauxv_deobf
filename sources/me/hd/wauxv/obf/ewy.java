package me.hd.wauxv.obf;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ewy extends PackageParam {
    public final void ak(PackageParam packageParamVar) {
        Object objX;
        this.processInfo = packageParamVar.processInfo;
        try {
            w();
            objX = Kotlin$Unit.INSTANCE;
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        Throwable thB = Success.exceptionOrNull(objX);
        if (thB != null) {
            ArrayList arrayList = Logger.a;
            Logger.logException(4, "An exception occurred in " + this, thB);
        }
    }

    public abstract void w();
}
