package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cqz extends bws implements bob {
    public static final cqz a = new cqz();

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.bob
    public final void j(bmm bmmVar, String str, ContentValues contentValues, String str2, String[] strArr, int i) throws IOException {
        if (str.equals(cnb.z(-399599462251306L))) {
            String asString = contentValues.getAsString(cnb.z(-399509267938090L));
            Integer asInteger = contentValues.getAsInteger(cnb.z(-399487793101610L));
            String asString2 = contentValues.getAsString(cnb.z(-399401893755690L));
            if (asString2 == null || dnj.ak(asString2)) {
                return;
            }
            Set setAd = aaz.ad(dnj.as(asString2, new String[]{cnb.z(-396640229784362L)}));
            int i2 = bte.a;
            dlx.a.getClass();
            cde cdeVarT = dqc.bi(dlx.b()).t();
            cdeVarT.ab = cnb.z(-103246718827306L);
            Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(Object[].class)}, 2, cdeVarT)).j(cnb.z(-396648819718954L), new Object[]{asString});
            bzo.n(objJ);
            Cursor cursor = (Cursor) objJ;
            try {
                if (cursor.moveToFirst()) {
                    int i3 = cursor.getInt(cursor.getColumnIndex(cnb.z(-396872158018346L)));
                    if (i3 == 0) {
                        cursor.close();
                        return;
                    }
                    String string = cursor.getString(cursor.getColumnIndex(cnb.z(-396854978149162L)));
                    if (string != null && !dnj.ak(string)) {
                        Set setAd2 = aaz.ad(dnj.as(string, new String[]{cnb.z(-396756193901354L)}));
                        if (asInteger.intValue() > i3) {
                            for (String str3 : dgg.a(setAd, setAd2)) {
                                String strZ = cnb.z(-396764783835946L);
                                Cursor cursorAc = arj.ac(cnb.z(-85083302132522L) + str3 + '\'');
                                cursorAc.moveToFirst();
                                String nickname = cnb.s(cursorAc).getNickname();
                                if (nickname == null) {
                                    nickname = cnb.z(-396726129130282L);
                                }
                                for (ctx ctxVar : cuk.a) {
                                    ctxVar.getClass();
                                    ctxVar.n(cnb.z(-401905859689258L), strZ, asString, str3, nickname);
                                }
                            }
                        } else if (asInteger.intValue() < i3) {
                            for (String str4 : dgg.a(setAd2, setAd)) {
                                String strZ2 = cnb.z(-396721834162986L);
                                Cursor cursorAc2 = arj.ac(cnb.z(-85083302132522L) + str4 + '\'');
                                cursorAc2.moveToFirst();
                                String nickname2 = cnb.s(cursorAc2).getNickname();
                                if (nickname2 == null) {
                                    nickname2 = cnb.z(-396751898934058L);
                                }
                                for (ctx ctxVar2 : cuk.a) {
                                    ctxVar2.getClass();
                                    ctxVar2.n(cnb.z(-401905859689258L), strZ2, asString, str4, nickname2);
                                }
                            }
                        }
                    }
                    cursor.close();
                    return;
                }
                cursor.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cursor, th);
                    throw th2;
                }
            }
        }
    }
}
