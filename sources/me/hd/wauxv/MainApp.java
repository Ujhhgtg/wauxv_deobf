package me.hd.wauxv;

import android.app.Application;
import com.umeng.commonsdk.UMConfigure;
import me.hd.wauxv.hook.HookEntry;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.exf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MainApp extends Application {
    public static MainApp a;

    public final void b() {
        super.onCreate();
        a = this;
        try {
            HookEntry.a.getClass();
            cna.d = "WAuxiliary" /* cnb.z(-71829033057066L) */;
            cnb.k = false;
        } catch (Throwable unused) {
        }
        exf exfVar = exf.f;
        if (exfVar == null) {
            exfVar = new exf();
            exf.f = exfVar;
        }
        String packageName = getPackageName();
        if (packageName == null) {
            packageName = "";
        }
        exfVar.n(this, packageName);
    }

    @Override // android.app.Application
    public final void onCreate() {
        b();
        UMConfigure.init(this, "68393b1dbc47b67d83776862" /* cnb.z(-398087633763114L) */, "WAuxiliary" /* cnb.z(-398478475787050L) */, 1, "" /* cnb.z(-398448411015978L) */);
        System.loadLibrary("wauxv-core" /* cnb.z(-398461295917866L) */);
    }
}
