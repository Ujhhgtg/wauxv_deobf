package me.hd.wauxv.obf;

import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class SyntheticClass implements axv, dcq, dcm, LogBackend, dcc, cvg {
    public static SyntheticClass a;
    public final /* synthetic */ int b;

    public /* synthetic */ SyntheticClass(int i) {
        this.b = i;
    }

    public static Configuration initConfig(Object obj, Class cls, int i) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return new Configuration(cls, obj);
    }

    public static blq d(blu bluVar, Class cls, ViewGroup viewGroup, blq blqVar) {
        blq blqVar2 = new blq(bluVar, cls, viewGroup);
        blqVar2.e = new erp(blqVar, 27);
        return blqVar2;
    }

    private final void h(Object obj) {
    }

    @Override // me.hd.wauxv.obf.axv
    public Object create() {
        switch (this.b) {
            case 4:
                return new ArrayList();
            default:
                return new bxp();
        }
    }

    @Override // me.hd.wauxv.obf.btg
    public void logD(String str) {
        Kotlin$Lazy kotlin$LazyVar = LogConfig.isDevelopmentMode;
        if (((Boolean) LogConfig.isVerboseLogging.getValue()).booleanValue()) {
            Log.d("KavaRef", String.valueOf(str), null);
        } else {
            ((bxs) LogConfig.isDevelopmentMode.getValue()).debug(String.valueOf(str));
        }
    }

    @Override // me.hd.wauxv.obf.btg
    public void logException(Object obj, Throwable th) {
        Kotlin$Lazy kotlin$LazyVar = LogConfig.isDevelopmentMode;
        if (((Boolean) LogConfig.isVerboseLogging.getValue()).booleanValue()) {
            Log.w("KavaRef", String.valueOf(obj), th);
        } else {
            ((bxs) LogConfig.isDevelopmentMode.getValue()).warn(String.valueOf(obj), th);
        }
    }

    public pe f(aff affVar, ud udVar, int i) {
        afo afoVarY = affVar.y(udVar.b);
        int i2 = udVar.c;
        String string = afoVarY.subSequence(0, i2).toString();
        String string2 = afoVarY.subSequence(i2, afoVarY.b).toString();
        long jM = cna.m(string);
        int i3 = (((int) (jM & 4294967295L)) * i) + ((int) (jM >> 32));
        int iN = brd.n(string);
        int iN2 = brd.n(string2);
        StringBuilder sb = new StringBuilder("\n");
        sb.append(cna.n(iN + i3, i, false));
        sb.append('\n');
        String strN = cna.n(i3 + iN2, i, false);
        sb.append(strN);
        return new pe(strN.length() + 1, sb);
    }

    @Override // me.hd.wauxv.obf.dcq
    public dcg g(dcg dcgVar, crw crwVar) {
        byte[] bArrArray;
        ByteBuffer byteBufferAsReadOnlyBuffer = ((bhh) ((bha) dcgVar.get()).a.b).a.d.asReadOnlyBuffer();
        AtomicReference atomicReference = sf.a;
        SourceBuffer sourceBufferVar = (byteBufferAsReadOnlyBuffer.isReadOnly() || !byteBufferAsReadOnlyBuffer.hasArray()) ? null : new SourceBuffer(byteBufferAsReadOnlyBuffer.array(), byteBufferAsReadOnlyBuffer.arrayOffset(), byteBufferAsReadOnlyBuffer.limit());
        if (sourceBufferVar != null && sourceBufferVar.a == 0 && sourceBufferVar.b == sourceBufferVar.c.length) {
            bArrArray = byteBufferAsReadOnlyBuffer.array();
        } else {
            ByteBuffer byteBufferAsReadOnlyBuffer2 = byteBufferAsReadOnlyBuffer.asReadOnlyBuffer();
            byte[] bArr = new byte[byteBufferAsReadOnlyBuffer2.limit()];
            byteBufferAsReadOnlyBuffer2.get(bArr);
            bArrArray = bArr;
        }
        return new ez(bArrArray);
    }

    @Override // me.hd.wauxv.obf.avu
    public boolean saveStreamToFile(Object obj, File file, crw crwVar) throws Throwable {
        try {
            sf.e(((bhh) ((bha) ((dcg) obj).get()).a.b).a.d.asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            return false;
        }
    }

    @Override // me.hd.wauxv.obf.cvg
    public CharSequence r(Preference preference) {
        ListPreference listPreference = (ListPreference) preference;
        if (TextUtils.isEmpty(null)) {
            return listPreference.f.getString(R.string.not_set);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.dcm
    public int x(crw crwVar) {
        return 1;
    }

    public SyntheticClass(but butVar, beg begVar) {
        this.b = 22;
    }

    public SyntheticClass(brd brdVar) {
        this.b = 19;
    }
}
