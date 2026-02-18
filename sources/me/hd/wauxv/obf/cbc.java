package me.hd.wauxv.obf;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbc implements ajb {
    public static final String[] a = {"_data"};
    public final /* synthetic */ int c;
    public final Object g;
    public final Object h;

    public /* synthetic */ cbc(Object obj, int i, Object obj2) {
        this.c = i;
        this.g = obj;
        this.h = obj2;
    }

    private final void i() {
    }

    private final void j() {
    }

    private final void k() {
    }

    private final void l() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.c) {
            case 0:
                return File.class;
            default:
                switch (((nu) this.h).b) {
                    case 5:
                        return ByteBuffer.class;
                    default:
                        return InputStream.class;
                }
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        int i = this.c;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        int i = this.c;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        switch (this.c) {
        }
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        Object objWrap;
        switch (this.c) {
            case 0:
                Cursor cursorQuery = ((Context) this.g).getContentResolver().query((Uri) this.h, a, null, null, null);
                if (cursorQuery != null) {
                    try {
                        string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                        cursorQuery.close();
                    } catch (Throwable th) {
                        cursorQuery.close();
                        throw th;
                    }
                    break;
                }
                if (!TextUtils.isEmpty(string)) {
                    ajaVar._bo(new File(string));
                    return;
                }
                ajaVar.k(new FileNotFoundException("Failed to find file path for: " + ((Uri) this.h)));
                return;
            default:
                nu nuVar = (nu) this.h;
                byte[] bArr = (byte[]) this.g;
                switch (nuVar.b) {
                    case 5:
                        objWrap = ByteBuffer.wrap(bArr);
                        break;
                    default:
                        objWrap = new ByteArrayInputStream(bArr);
                        break;
                }
                ajaVar._bo(objWrap);
                return;
        }
    }
}
