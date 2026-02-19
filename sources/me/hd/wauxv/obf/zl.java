package me.hd.wauxv.obf;

import android.app.AlertDialog;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zl extends doi implements bgj {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zl(Object obj, afw afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.d = obj;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws Throwable {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                return ((zl) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            default:
                zl zlVar = (zl) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
                zlVar.i(kotlinUnitVar);
                return kotlinUnitVar;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                return new zl((zn) this.d, afwVar, 0);
            default:
                return new zl((AlertDialog) this.d, afwVar, 1);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x0037  */
    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        long length;
        int i = this.a;
        Object obj2 = this.d;
        switch (i) {
            case 0:
                FastKV.bd(obj);
                Iterator it = ((zn) obj2).b.iterator();
                long j = 0;
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (!file.exists()) {
                        length = 0;
                    } else if (file.isFile()) {
                        length = file.length();
                    } else {
                        File[] fileArrListFiles = file.listFiles();
                        if (fileArrListFiles != null) {
                            long jAs = 0;
                            for (File file2 : fileArrListFiles) {
                                jAs += KotlinHelpers2.as(file2);
                            }
                            length = jAs;
                        } else {
                            length = 0;
                        }
                    }
                    j += length;
                }
                if (j < RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
                    String str = String.format(Locale.CHINA, "%.2f B" /* "%.2f B" /* "%.2f B" /* cnb.z(-12206297053994L)  */, Arrays.copyOf(new Object[]{Double.valueOf(j)}, 1));
                    "format(...)" /* "format(...)" /* "format(...)" /* cnb.z(-12227771890474L)  */;
                    return str;
                }
                if (j < 1048576) {
                    String str2 = String.format(Locale.CHINA, "%.2f KB" /* "%.2f KB" /* "%.2f KB" /* cnb.z(-12141872544554L)  */, Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
                    "format(...)" /* "format(...)" /* "format(...)" /* cnb.z(-12107512806186L)  */;
                    return str2;
                }
                if (j < 1073741824) {
                    String str3 = String.format(Locale.CHINA, "%.2f MB" /* "%.2f MB" /* "%.2f MB" /* cnb.z(-12640088750890L)  */, Arrays.copyOf(new Object[]{Double.valueOf((j / 1024.0d) / 1024.0d)}, 1));
                    "format(...)" /* "format(...)" /* "format(...)" /* cnb.z(-12605729012522L)  */;
                    return str3;
                }
                String str4 = String.format(Locale.CHINA, "%.2f GB" /* "%.2f GB" /* "%.2f GB" /* cnb.z(-12519829666602L)  */, Arrays.copyOf(new Object[]{Double.valueOf(((j / 1024.0d) / 1024.0d) / 1024.0d)}, 1));
                "format(...)" /* "format(...)" /* "format(...)" /* cnb.z(-12485469928234L)  */;
                return str4;
            default:
                FastKV.bd(obj);
                ((AlertDialog) obj2).dismiss();
                return Kotlin$Unit.INSTANCE;
        }
    }
}
