package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import net.bytebuddy.pool.TypePool;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjx extends doo implements bng, bob {
    public static final bjx a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final bep m;

    static {
        cnb.z(-506788961057578L);
        cnb.z(-506754601319210L);
        a = new bjx(cnb.z(-502979325066026L));
        b = cnb.z(-506711651646250L);
        c = cnb.z(-506715946613546L);
        i = cnb.z(-506672996940586L);
        m = new bep(4);
    }

    public static String r(String str, String str2, String str3) throws IllegalAccessException, InvocationTargetException {
        xj.a.getClass();
        String strB = xj.b(str2, str);
        String strB2 = xj.b(str2, cnb.z(-99252399242026L));
        if (!strB.equals(strB2)) {
            strB = strB + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + strB2 + ']';
        }
        String strO = bjv.a.o();
        String str4 = cnb.z(-502841886112554L) + dnj.ax(str, cnb.z(-502867655916330L)) + cnb.z(-508683041635114L) + str2;
        StringBuilder sbY = dkz.y(strB);
        sbY.append(cnb.z(-508635796994858L));
        sbY.append(strO);
        sbY.append(cnb.z(-508537012747050L));
        sbY.append(str4);
        sbY.append(cnb.z(-509065293724458L));
        sbY.append(str2);
        sbY.append(cnb.z(-509069588691754L));
        sbY.append(str3);
        return sbY.toString();
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
        List listBf = dqc.bf(emn.bb(bju.a));
        bjx bjxVar = a;
        aki akiVarAb = csb.ab(bjxVar, listBf);
        bjxVar.y(akiVarAb, new bep(6));
        akiVarAb.o();
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bng
    public final void h(DexKitBridge dexKitBridge) {
        emn.aj(bju.a, dexKitBridge, new bep(5));
    }

    @Override // me.hd.wauxv.obf.bob
    public final void j(bmm bmmVar, String str, ContentValues contentValues, String str2, String[] strArr, int i2) throws IOException {
        if (z() && str.equals(cnb.z(-508962214509354L))) {
            String asString = contentValues.getAsString(cnb.z(-508923559803690L));
            Integer asInteger = contentValues.getAsInteger(cnb.z(-508850545359658L));
            String asString2 = contentValues.getAsString(cnb.z(-508833365490474L));
            if (asString2 == null || dnj.ak(asString2)) {
                return;
            }
            Set setAd = aaz.ad(dnj.as(asString2, new String[]{cnb.z(-508184825428778L)}));
            int i3 = bte.a;
            dlx.a.getClass();
            cde cdeVarT = dqc.bi(dlx.b()).t();
            cdeVarT.ab = cnb.z(-103246718827306L);
            Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(Object[].class)}, 2, cdeVarT)).j(cnb.z(-508193415363370L), new Object[]{asString});
            bzo.n(objJ);
            Cursor cursor = (Cursor) objJ;
            try {
                if (cursor.moveToFirst()) {
                    int i4 = cursor.getInt(cursor.getColumnIndex(cnb.z(-508485473139498L)));
                    if (i4 == 0) {
                        cursor.close();
                        return;
                    }
                    String string = cursor.getString(cursor.getColumnIndex(cnb.z(-508399573793578L)));
                    if (string != null && !dnj.ak(string)) {
                        Set setAd2 = aaz.ad(dnj.as(string, new String[]{cnb.z(-508386688891690L)}));
                        if (asInteger.intValue() < i4) {
                            for (String str3 : dgg.a(setAd2, setAd)) {
                                bjx bjxVar = a;
                                String strO = bjw.a.o();
                                bjxVar.getClass();
                                aye.w(ewg.j.w, asString, r(asString, str3, strO), System.currentTimeMillis());
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

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return i;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return m;
    }
}
