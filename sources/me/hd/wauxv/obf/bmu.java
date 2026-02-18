package me.hd.wauxv.obf;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.profileinstaller.ProfileInstallReceiver;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bmu implements cdw, ero, ajh, cab, ank, cbu, esn, ano, cvv, avu, bm {
    public Object h;

    public /* synthetic */ bmu(Object obj) {
        this.h = obj;
    }

    @Override // me.hd.wauxv.obf.bm
    public boolean _bm(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.h;
        if (!swipeDismissBehavior.v(view)) {
            return false;
        }
        WeakHashMap weakHashMap = eqz.a;
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.h;
        view.offsetLeftAndRight((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // me.hd.wauxv.obf.ank
    public void a() {
        ccu ccuVar = ((cct) this.h).o;
        ccuVar.getClass();
        if (ccuVar.ba()) {
            ccuVar.getClass();
            ng.aj(new ccq(ccuVar, 1));
        }
    }

    @Override // me.hd.wauxv.obf.cbu
    public void bw(cbw cbwVar) {
    }

    @Override // me.hd.wauxv.obf.cbu
    public boolean bx(cbw cbwVar, MenuItem menuItem) {
        cke ckeVar = ((ckg) this.h).f;
        return (ckeVar == null || ckeVar.d(menuItem)) ? false : true;
    }

    @Override // me.hd.wauxv.obf.ajh
    public void c() {
        ((cyp) this.h).i();
    }

    @Override // me.hd.wauxv.obf.ajh
    public Object d() {
        cyp cypVar = (cyp) this.h;
        cypVar.reset();
        return cypVar;
    }

    @Override // me.hd.wauxv.obf.ano
    public boolean e(float f) {
        if (f == 0.0f) {
            return false;
        }
        g();
        ((NestedScrollView) this.h).ap((int) f);
        return true;
    }

    @Override // me.hd.wauxv.obf.ano
    public float f() {
        return -((NestedScrollView) this.h).getVerticalScrollFactorCompat();
    }

    @Override // me.hd.wauxv.obf.ano
    public void g() {
        ((NestedScrollView) this.h).g.abortAnimation();
    }

    @Override // me.hd.wauxv.obf.cvv
    public void i() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // me.hd.wauxv.obf.cvv
    public void j(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.h).setResultCode(i);
    }

    @Override // me.hd.wauxv.obf.avu
    public boolean k(Object obj, File file, crw crwVar) throws Throwable {
        InputStream inputStream = (InputStream) obj;
        bva bvaVar = (bva) this.h;
        byte[] bArr = (byte[]) bvaVar.i(65536, byte[].class);
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        if (Log.isLoggable("StreamEncoder", 3)) {
                            Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        bvaVar.m(bArr);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        bvaVar.m(bArr);
                        throw th;
                    }
                }
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
                bvaVar.m(bArr);
                return true;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // me.hd.wauxv.obf.ero
    public erk l(Class cls, chq chqVar) {
        erm ermVar;
        zc zcVarB = dal.b(cls);
        erm[] ermVarArr = (erm[]) this.h;
        erm[] ermVarArr2 = (erm[]) Arrays.copyOf(ermVarArr, ermVarArr.length);
        bzo.q(ermVarArr2, "initializers");
        int length = ermVarArr2.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                ermVar = null;
                break;
            }
            ermVar = ermVarArr2[i];
            if (ermVar.a.equals(zcVarB)) {
                break;
            }
            i++;
        }
        erk erkVar = ermVar != null ? (erk) ermVar.b.invoke(chqVar) : null;
        if (erkVar != null) {
            return erkVar;
        }
        throw new IllegalArgumentException(("No initializer set for given class " + emc.ao(zcVarB)).toString());
    }

    public adt m() {
        adt adtVar = new adt();
        adtVar.aa = (cbg) this.h;
        return adtVar;
    }

    public void n(rw rwVar, int i, cwf cwfVar) {
        int iOrdinal = cwfVar.ordinal();
        if (iOrdinal == 0) {
            long j = i;
            rwVar.getClass();
            int i2 = rw.a[Long.numberOfLeadingZeros(j)];
            rwVar.e(i2 + 1);
            rwVar.d(i2, j);
            return;
        }
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new abt();
            }
            ((rw) this.h).f(Integer.reverseBytes(i));
            return;
        }
        int i3 = (i >> 31) ^ (i << 1);
        rwVar.e(5);
        if ((i3 & (-128)) != 0) {
            long j2 = i3;
            rwVar.d(rw.a[Long.numberOfLeadingZeros(j2)], j2);
        } else {
            byte[] bArr = rwVar.b;
            int i4 = rwVar.c;
            rwVar.c = i4 + 1;
            bArr[i4] = (byte) i3;
        }
    }

    public void o(rw rwVar, long j, cwf cwfVar) {
        int iOrdinal = cwfVar.ordinal();
        if (iOrdinal == 0) {
            int i = rw.a[Long.numberOfLeadingZeros(j)];
            rwVar.e(i + 1);
            rwVar.d(i, j);
        } else if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                throw new abt();
            }
            ((rw) this.h).g(Long.reverseBytes(j));
        } else {
            long j2 = (j >> 63) ^ (j << 1);
            int i2 = rw.a[Long.numberOfLeadingZeros(j2)];
            rwVar.e(i2 + 1);
            rwVar.d(i2, j2);
        }
    }

    public void p(String str) throws IOException {
        s(new cuh(((ctx) this.h).f, cnb.z(-390262203349802L), String.valueOf(str)));
    }

    @Override // me.hd.wauxv.obf.esn
    public evr q(View view, evr evrVar, baw bawVar) {
        boolean fitsSystemWindows;
        boolean fitsSystemWindows2;
        boolean fitsSystemWindows3;
        bps bpsVarN = evrVar.b.n(519);
        ckj ckjVar = (ckj) this.h;
        Boolean bool = ckjVar.i;
        if (bool != null) {
            fitsSystemWindows = bool.booleanValue();
        } else {
            WeakHashMap weakHashMap = eqz.a;
            fitsSystemWindows = ckjVar.getFitsSystemWindows();
        }
        if (fitsSystemWindows) {
            bawVar.b += bpsVarN.c;
        }
        Boolean bool2 = ckjVar.j;
        if (bool2 != null) {
            fitsSystemWindows2 = bool2.booleanValue();
        } else {
            WeakHashMap weakHashMap2 = eqz.a;
            fitsSystemWindows2 = ckjVar.getFitsSystemWindows();
        }
        if (fitsSystemWindows2) {
            bawVar.d += bpsVarN.e;
        }
        Boolean bool3 = ckjVar.k;
        if (bool3 != null) {
            fitsSystemWindows3 = bool3.booleanValue();
        } else {
            WeakHashMap weakHashMap3 = eqz.a;
            fitsSystemWindows3 = ckjVar.getFitsSystemWindows();
        }
        if (fitsSystemWindows3) {
            bawVar.a += ewz.al(view) ? bpsVarN.d : bpsVarN.b;
        }
        int i = bawVar.a;
        int i2 = bawVar.b;
        int i3 = bawVar.c;
        int i4 = bawVar.d;
        WeakHashMap weakHashMap4 = eqz.a;
        view.setPaddingRelative(i, i2, i3, i4);
        return evrVar;
    }

    public azg r() {
        azg azgVar = new azg();
        azgVar.aa = (cbg) this.h;
        return azgVar;
    }

    public void s(cuh cuhVar) throws IOException {
        File file = new File(((ctx) this.h).a, cnb.z(-389802641849130L));
        StringBuilder sb = new StringBuilder();
        sb.append(cuhVar);
        sb.append('\n');
        String string = sb.toString();
        Charset charset = uj.a;
        bzo.q(string, "text");
        bzo.q(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            bad.f(fileOutputStream, string, charset);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public cde t() {
        cde cdeVar = new cde();
        cdeVar.aa = (cbg) this.h;
        return cdeVar;
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        return new bmv((bmu) this.h);
    }

    public void v(boolean z) {
        ((cbg) this.h).e = z ? cbf.c : cbf.b;
    }

    public void w(byte[] bArr) {
        bzo.q(bArr, "bytes");
        rw rwVar = (rw) this.h;
        n(rwVar, bArr.length, cwf.DEFAULT);
        int length = bArr.length;
        if (length == 0) {
            return;
        }
        rwVar.e(length);
        la._ak(bArr, rwVar.c, 0, rwVar.b, length);
        rwVar.c += length;
    }

    public void x(rw rwVar) {
        bzo.q(rwVar, "output");
        rw rwVar2 = (rw) this.h;
        n(rwVar2, rwVar.c, cwf.DEFAULT);
        int i = rwVar.c;
        rwVar2.e(i);
        la._ak(rwVar.b, rwVar2.c, 0, rwVar2.b, i);
        rwVar2.c += i;
    }

    public bmu(InputStream inputStream, bva bvaVar) {
        cyp cypVar = new cyp(inputStream, bvaVar);
        this.h = cypVar;
        cypVar.mark(5242880);
    }

    public bmu(int i) {
        switch (i) {
            case 14:
                this.h = new cds(500L);
                break;
            case 25:
                this.h = new SparseIntArray();
                break;
            default:
                this.h = new bmu(14);
                break;
        }
    }
}
