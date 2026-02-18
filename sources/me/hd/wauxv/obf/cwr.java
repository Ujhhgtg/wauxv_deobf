package me.hd.wauxv.obf;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cwr implements ajb {
    public static final String[] a = {"_data"};
    public final Context c;
    public final cdv g;
    public final cdv h;
    public final Uri i;
    public final int j;
    public final int k;
    public final crw l;
    public final Class m;
    public volatile boolean n;
    public volatile ajb o;

    public cwr(Context context, cdv cdvVar, cdv cdvVar2, Uri uri, int i, int i2, crw crwVar, Class cls) {
        this.c = context.getApplicationContext();
        this.g = cdvVar;
        this.h = cdvVar2;
        this.i = uri;
        this.j = i;
        this.k = i2;
        this.l = crwVar;
        this.m = cls;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        return this.m;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        this.n = true;
        ajb ajbVar = this.o;
        if (ajbVar != null) {
            ajbVar.cancel();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        ajb ajbVar = this.o;
        if (ajbVar != null) {
            ajbVar.d();
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) throws Throwable {
        try {
            ajb ajbVarP = p();
            if (ajbVarP == null) {
                ajaVar.k(new IllegalArgumentException("Failed to build fetcher for: " + this.i));
            } else {
                this.o = ajbVarP;
                if (this.n) {
                    cancel();
                } else {
                    ajbVarP.f(cvqVar, ajaVar);
                }
            }
        } catch (FileNotFoundException e) {
            ajaVar.k(e);
        }
    }

    public final ajb p() throws Throwable {
        cdu cduVarE;
        boolean zIsExternalStorageLegacy = Environment.isExternalStorageLegacy();
        Cursor cursor = null;
        Context context = this.c;
        crw crwVar = this.l;
        int i = this.k;
        int i2 = this.j;
        if (zIsExternalStorageLegacy) {
            Uri uri = this.i;
            try {
                Cursor cursorQuery = context.getContentResolver().query(uri, a, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                            if (TextUtils.isEmpty(string)) {
                                throw new FileNotFoundException("File path was empty in media store for: " + uri);
                            }
                            File file = new File(string);
                            cursorQuery.close();
                            cduVarE = this.g.e(file, i2, i, crwVar);
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            Uri requireOriginal = this.i;
            boolean zBd = dqc.bd(requireOriginal);
            cdv cdvVar = this.h;
            if (zBd && requireOriginal.getPathSegments().contains("picker")) {
                cduVarE = cdvVar.e(requireOriginal, i2, i, crwVar);
            } else {
                if (context.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0) {
                    requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
                }
                cduVarE = cdvVar.e(requireOriginal, i2, i, crwVar);
            }
        }
        if (cduVarE != null) {
            return cduVarE.c;
        }
        return null;
    }
}
