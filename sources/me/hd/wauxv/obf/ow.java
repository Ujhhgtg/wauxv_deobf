package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ow implements dcm {
    public static final cru a = cru.f(90, "com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality");
    public static final cru b = new cru("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, cru.a);
    public final bva c;

    public ow(bva bvaVar) {
        this.c = bvaVar;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    @Override // me.hd.wauxv.obf.avu
    public final boolean saveStreamToFile(Object obj, File file, crw crwVar) throws Throwable {
        boolean z;
        Bitmap bitmap = (Bitmap) ((dcg) obj).get();
        cru cruVar = b;
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) crwVar.b(cruVar);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        int i = bxq.b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        int iIntValue = ((Integer) crwVar.b(a)).intValue();
        OutputStream rkVar = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    bva bvaVar = this.c;
                    if (bvaVar != null) {
                        try {
                            rkVar = new rk(fileOutputStream, bvaVar);
                        } catch (IOException e) {
                            e = e;
                            rkVar = fileOutputStream;
                            if (Log.isLoggable("BitmapEncoder", 3)) {
                                Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                            }
                            if (rkVar != null) {
                                try {
                                    rkVar.close();
                                } catch (IOException unused) {
                                }
                            }
                            z = false;
                        } catch (Throwable th) {
                            th = th;
                            rkVar = fileOutputStream;
                            if (rkVar != null) {
                                try {
                                    rkVar.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        rkVar = fileOutputStream;
                    }
                    bitmap.compress(compressFormat, iIntValue, rkVar);
                    rkVar.close();
                    try {
                        rkVar.close();
                    } catch (IOException unused3) {
                    }
                    z = true;
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + eot.f(bitmap) + " in " + bxq.c(jElapsedRealtimeNanos) + ", options format: " + crwVar.b(cruVar) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // me.hd.wauxv.obf.dcm
    public final int x(crw crwVar) {
        return 2;
    }
}
