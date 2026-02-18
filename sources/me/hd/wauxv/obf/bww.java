package me.hd.wauxv.obf;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bww implements ajb {
    public final boolean g;
    public final Uri h;
    public final ContentResolver i;
    public Object j;

    public bww(ContentResolver contentResolver, Uri uri, boolean z) {
        this.i = contentResolver;
        this.h = uri;
        this.g = z;
    }

    public abstract Object _aq(ContentResolver contentResolver, Uri uri);

    public abstract void c(Object obj);

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        Object obj = this.j;
        if (obj != null) {
            try {
                c(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) {
        try {
            Object obj_aq = _aq(this.i, this.h);
            this.j = obj_aq;
            ajaVar._bo(obj_aq);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            ajaVar.k(e);
        }
    }
}
