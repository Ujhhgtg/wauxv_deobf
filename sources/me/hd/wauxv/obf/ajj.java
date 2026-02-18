package me.hd.wauxv.obf;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajj implements ajb {
    public final /* synthetic */ int a;
    public final Comparable c;
    public final Object g;
    public Object h;

    public /* synthetic */ ajj(Comparable comparable, Object obj, int i) {
        this.a = i;
        this.c = comparable;
        this.g = obj;
    }

    public static ajj i(Context context, Uri uri, drs drsVar) {
        return new ajj(uri, new chm(com.bumptech.glide.a.j(context).e.l().o(), drsVar, com.bumptech.glide.a.j(context).f, context.getContentResolver()), 2);
    }

    private final void k() {
    }

    private final void l() {
    }

    private final void m() {
    }

    @Override // me.hd.wauxv.obf.ajb
    public final Class b() {
        switch (this.a) {
            case 0:
                ((nu) this.g).getClass();
                return InputStream.class;
            case 1:
                switch (((awp) this.g).b) {
                    case 6:
                        return ParcelFileDescriptor.class;
                    default:
                        return InputStream.class;
                }
            default:
                return InputStream.class;
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void cancel() {
        int i = this.a;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void d() {
        switch (this.a) {
            case 0:
                try {
                    ((ByteArrayInputStream) this.h).close();
                } catch (IOException unused) {
                    return;
                }
                break;
            case 1:
                Object obj = this.h;
                if (obj != null) {
                    try {
                        switch (((awp) this.g).b) {
                            case 6:
                                ((ParcelFileDescriptor) obj).close();
                                break;
                            default:
                                ((InputStream) obj).close();
                                break;
                        }
                    } catch (IOException unused2) {
                        return;
                    }
                }
                break;
            default:
                InputStream inputStream = (InputStream) this.h;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // me.hd.wauxv.obf.ajb
    public final int e() {
        switch (this.a) {
        }
        return 1;
    }

    @Override // me.hd.wauxv.obf.ajb
    public final void f(cvq cvqVar, aja ajaVar) throws Throwable {
        Object objOpen;
        switch (this.a) {
            case 0:
                try {
                    ByteArrayInputStream byteArrayInputStreamD = nu.d((String) this.c);
                    this.h = byteArrayInputStreamD;
                    ajaVar._bo(byteArrayInputStreamD);
                } catch (IllegalArgumentException e) {
                    ajaVar.k(e);
                }
                break;
            case 1:
                try {
                    awp awpVar = (awp) this.g;
                    File file = (File) this.c;
                    switch (awpVar.b) {
                        case 6:
                            objOpen = ParcelFileDescriptor.open(file, 268435456);
                            break;
                        default:
                            objOpen = new FileInputStream(file);
                            break;
                    }
                    this.h = objOpen;
                    ajaVar._bo(objOpen);
                } catch (FileNotFoundException e2) {
                    if (Log.isLoggable("FileLoader", 3)) {
                        Log.d("FileLoader", "Failed to open file", e2);
                    }
                    ajaVar.k(e2);
                    return;
                }
                break;
            default:
                try {
                    InputStream inputStreamJ = j();
                    this.h = inputStreamJ;
                    ajaVar._bo(inputStreamJ);
                } catch (FileNotFoundException e3) {
                    if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                        Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e3);
                    }
                    ajaVar.k(e3);
                    return;
                }
                break;
        }
    }

    /* JADX WARN: Found duplicated region for block: B:15:0x0033 A[PHI: r7
      0x0033: PHI (r7v7 android.database.Cursor) = (r7v3 android.database.Cursor), (r7v10 android.database.Cursor) binds: [B:26:0x0056, B:14:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:25:0x0047 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #8 {all -> 0x002b, blocks: (B:6:0x001c, B:8:0x0022, B:23:0x0041, B:25:0x0047), top: B:83:0x0012 }] */
    /* JADX WARN: Found duplicated region for block: B:30:0x005f  */
    /* JADX WARN: Found duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Found duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Found duplicated region for block: B:43:0x00a5  */
    /* JADX WARN: Found duplicated region for block: B:62:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:64:0x00e6 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:76:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x002c: MOVE (r6 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY]) (LINE:45), block:B:11:0x002c */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.NullPointerException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v0 */
    public InputStream j() throws Throwable {
        ?? r7;
        SecurityException e;
        Cursor cursorE;
        String string;
        File file;
        InputStream inputStreamOpenInputStream;
        int iY;
        chm chmVar = (chm) this.g;
        ContentResolver contentResolver = (ContentResolver) chmVar.f;
        Uri uri = (Uri) this.c;
        ?? r6 = 0;
        InputStream inputStreamOpenInputStream2 = null;
        try {
            try {
                try {
                    try {
                        cursorE = ((drs) chmVar.d).e(uri);
                    } catch (SecurityException e2) {
                        e = e2;
                        cursorE = null;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursorE != null) {
                            cursorE.close();
                        }
                        string = null;
                        if (TextUtils.isEmpty(string)) {
                            file = new File(string);
                            inputStreamOpenInputStream = !file.exists() ? null : null;
                        }
                        if (inputStreamOpenInputStream != null) {
                            try {
                                try {
                                    inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                                    iY = bhv.y((ArrayList) chmVar.c, inputStreamOpenInputStream2, (bva) chmVar.e);
                                    if (inputStreamOpenInputStream2 != null) {
                                        try {
                                            inputStreamOpenInputStream2.close();
                                        } catch (IOException unused) {
                                        }
                                    }
                                } catch (Throwable th) {
                                    if (0 != 0) {
                                        try {
                                            r6.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (IOException | NullPointerException e3) {
                                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e3);
                                }
                                if (inputStreamOpenInputStream2 != null) {
                                    try {
                                        inputStreamOpenInputStream2.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                iY = -1;
                            }
                        } else {
                            iY = -1;
                        }
                        return iY != -1 ? new axp(inputStreamOpenInputStream, iY) : inputStreamOpenInputStream;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r6 != 0) {
                        r6.close();
                    }
                    throw th;
                }
            } catch (SecurityException e4) {
                e = e4;
            }
            if (cursorE != null) {
                try {
                    if (cursorE.moveToFirst()) {
                        string = cursorE.getString(0);
                        cursorE.close();
                    }
                } catch (SecurityException e5) {
                    e = e5;
                    if (Log.isLoggable("ThumbStreamOpener", 3)) {
                        Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                    }
                    if (cursorE != null) {
                    }
                    string = null;
                    if (TextUtils.isEmpty(string)) {
                        file = new File(string);
                        if (!file.exists()) {
                        }
                    }
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                        iY = bhv.y((ArrayList) chmVar.c, inputStreamOpenInputStream2, (bva) chmVar.e);
                        if (inputStreamOpenInputStream2 != null) {
                            inputStreamOpenInputStream2.close();
                        }
                    } else {
                        iY = -1;
                    }
                    if (iY != -1) {
                    }
                }
                if (TextUtils.isEmpty(string)) {
                    file = new File(string);
                    if (!file.exists() && 0 < file.length()) {
                        Uri uriFromFile = Uri.fromFile(file);
                        try {
                            inputStreamOpenInputStream = contentResolver.openInputStream(uriFromFile);
                        } catch (NullPointerException e6) {
                            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e6));
                        }
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                    iY = bhv.y((ArrayList) chmVar.c, inputStreamOpenInputStream2, (bva) chmVar.e);
                    if (inputStreamOpenInputStream2 != null) {
                        inputStreamOpenInputStream2.close();
                    }
                } else {
                    iY = -1;
                }
                if (iY != -1) {
                }
            }
            if (cursorE != null) {
                cursorE.close();
            }
            string = null;
            if (TextUtils.isEmpty(string)) {
                file = new File(string);
                if (!file.exists()) {
                }
            }
            if (inputStreamOpenInputStream != null) {
                inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                iY = bhv.y((ArrayList) chmVar.c, inputStreamOpenInputStream2, (bva) chmVar.e);
                if (inputStreamOpenInputStream2 != null) {
                    inputStreamOpenInputStream2.close();
                }
            } else {
                iY = -1;
            }
            if (iY != -1) {
            }
        } catch (Throwable th3) {
            th = th3;
            r6 = r7;
        }
    }
}
