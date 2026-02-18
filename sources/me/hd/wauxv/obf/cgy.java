package me.hd.wauxv.obf;

import android.database.Cursor;
import java.io.IOException;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cgy extends bws implements bng {
    public static final cgy a = new cgy();

    public static Object b(long j) throws IOException {
        String strZ = "SELECT * FROM message WHERE msgId = ?" /* cnb.z(-369534691179306L) */;
        Object[] objArr = {Long.valueOf(j)};
        int i = bte.a;
        dlx.a.getClass();
        cde cdeVarT = dqc.bi(dlx.b()).t();
        cdeVarT.ab = "rawQuery" /* cnb.z(-103246718827306L) */;
        Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(Object[].class)}, 2, cdeVarT)).j(strZ, objArr);
        bzo.n(objJ);
        Cursor cursor = (Cursor) objJ;
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                cge.a.getClass();
                return zf.c(emn.az(cgd.a), new Object[0]);
            }
            cge.a.getClass();
            Object objB = cge.b(cursor);
            cursor.close();
            return objB;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(cursor, th);
                throw th2;
            }
        }
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(cgv.a, dexKitBridge, new bzk(27));
        emn.aj(cgx.a, dexKitBridge, new bzk(28));
        emn.aj(cgw.a, dexKitBridge, new bzk(29));
    }
}
