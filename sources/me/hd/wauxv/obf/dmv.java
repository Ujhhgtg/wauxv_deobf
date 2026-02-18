package me.hd.wauxv.obf;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dmv implements dcj {
    public final ArrayList a;
    public final sc b;
    public final bva e;

    public dmv(ArrayList arrayList, sc scVar, bva bvaVar) {
        this.a = arrayList;
        this.b = scVar;
        this.e = bvaVar;
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Found duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // me.hd.wauxv.obf.dcj
    public final dcg c(Object obj, int i, int i2, crw crwVar) {
        byte[] byteArray;
        byte[] bArr;
        InputStream inputStream = (InputStream) obj;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            bArr = new byte[16384];
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            if (Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", e);
            }
            byteArray = null;
        }
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
            if (byteArray == null) {
                return null;
            }
            return this.b.c(ByteBuffer.wrap(byteArray), i, i2, crwVar);
        }
        if (byteArray == null) {
            return null;
        }
        return this.b.c(ByteBuffer.wrap(byteArray), i, i2, crwVar);
    }

    @Override // me.hd.wauxv.obf.dcj
    public final boolean d(Object obj, crw crwVar) {
        return !((Boolean) crwVar.b(bhk.b)).booleanValue() && bhv.z(this.a, (InputStream) obj, this.e) == ImageHeaderParser$ImageType.GIF;
    }
}
