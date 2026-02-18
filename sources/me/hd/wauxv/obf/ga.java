package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ga extends doo implements bob, bng {
    public static final ga a = new ga(cnb.z(-454085417368362L));
    public static final String b = cnb.z(-454776907103018L);
    public static final String c = cnb.z(-454781202070314L);
    public static final String d = cnb.z(-454746842331946L);
    public static final bn i = new bn(14);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() throws NoSuchMethodException {
        Iterator it = aba.ag(fw.a, fy.a, fx.a).iterator();
        while (it.hasNext()) {
            Class clsAz = emn.az((amn) it.next());
            int i2 = bte.a;
            cde cdeVarT = dqc.bi(clsAz).t();
            cdeVarT.a = Void.TYPE;
            cdeVarT.g = 1;
            cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
            exg exgVar = exg.a;
            ga gaVar = a;
            aki akiVarAd = gaVar.ad(cdkVar, exgVar);
            gaVar.y(akiVarAd, new bn(18));
            akiVarAd.o();
        }
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
        emn.aj(fw.a, dexKitBridge, new bn(15));
        emn.aj(fy.a, dexKitBridge, new bn(16));
        emn.aj(fx.a, dexKitBridge, new bn(17));
    }

    @Override // me.hd.wauxv.obf.bob
    public final void j(bmm bmmVar, String str, ContentValues contentValues, String str2, String[] strArr, int i2) throws IOException {
        if (z() && str.equals(cnb.z(-454016697891626L)) && bzo.f(contentValues.get(cnb.z(-453982338153258L)), Integer.valueOf(ewg.l.w))) {
            String asString = contentValues.getAsString(cnb.z(-453943683447594L));
            if (dnr.bp(asString, cnb.z(-453909323709226L), false) || dnr.bp(asString, cnb.z(-453917913643818L), false)) {
                Long asLong = contentValues.getAsLong(cnb.z(-453926503578410L));
                int i3 = bte.a;
                dlx.a.getClass();
                cde cdeVarT = dqc.bi(dlx.b()).t();
                cdeVarT.ab = cnb.z(-103246718827306L);
                Object objJ = ((cdk) dkz.n(new Object[]{dal.b(String.class), dal.b(Object[].class)}, 2, cdeVarT)).j(cnb.z(-453883553905450L), new Object[]{asLong});
                bzo.n(objJ);
                Cursor cursor = (Cursor) objJ;
                try {
                    if (cursor.moveToFirst()) {
                        long j = cursor.getLong(cursor.getColumnIndex(cnb.z(-453080395021098L)));
                        String string = cursor.getString(cursor.getColumnIndex(cnb.z(-453067510119210L)));
                        Pattern patternCompile = Pattern.compile(cnb.z(-453020265478954L));
                        bzo.p(patternCompile, "compile(...)");
                        Matcher matcher = patternCompile.matcher(asString);
                        bzo.p(matcher, "matcher(...)");
                        bzx bzxVarY = ewz.y(matcher, 0, asString);
                        aye.w(ewg.j.w, string, "\"" + (bzxVarY != null ? (String) ((bzv) bzxVarY.e()).get(2) : null) + cnb.z(-453509891750698L) + fz.a.o(), j + 1);
                        bmmVar.h(1);
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

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return d;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return i;
    }
}
