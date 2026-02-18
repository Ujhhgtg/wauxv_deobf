package me.hd.wauxv.obf;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ht {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static bwy b(Configuration configuration) {
        return bwy.c(configuration.getLocales().toLanguageTags());
    }

    public static void c(bwy bwyVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(bwyVar.b.a.toLanguageTags()));
    }

    public static void d(Configuration configuration, bwy bwyVar) {
        configuration.setLocales(LocaleList.forLanguageTags(bwyVar.b.a.toLanguageTags()));
    }
}
