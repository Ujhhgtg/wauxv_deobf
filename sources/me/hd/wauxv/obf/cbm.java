package me.hd.wauxv.obf;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cbm implements bno, crt, cvv, axv, ahw, dff, cdw {
    public final /* synthetic */ int f;

    public /* synthetic */ cbm(int i) {
        this.f = i;
    }

    private final void a() {
    }

    public static final void g(ViewGroup viewGroup) {
        int i = dmm.a;
        viewGroup.removeAllViews();
    }

    public static cio h(anr anrVar, cjg cjgVar, Bundle bundle, buh buhVar, ciy ciyVar) {
        String string = UUID.randomUUID().toString();
        throwIfVar1IsNull(string, "toString(...)");
        throwIfVar1IsNull(cjgVar, "destination");
        throwIfVar1IsNull(buhVar, "hostLifecycleState");
        return new cio(anrVar, cjgVar, bundle, buhVar, ciyVar, string, null);
    }

    private final void l(int i, Object obj) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [me.hd.wauxv.obf.dcx] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v7 */
    public List b(Class cls) {
        ?? X;
        try {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            X = new ArrayList();
            for (Constructor<?> constructor : declaredConstructors) {
                if (constructor != null) {
                    X.add(constructor);
                }
            }
        } catch (Throwable th) {
            X = bhu.x(th);
        }
        Throwable thB = dcy.b(X);
        if (thB != null) {
            dov dovVar = bth.a;
            bth.e("Failed to get declared constructors in " + this + " because got an exception.", thB);
        }
        boolean z = X instanceof dcx;
        ?? r0 = X;
        if (z) {
            r0 = 0;
        }
        List list = (List) r0;
        return list == null ? avd.a : list;
    }

    public List c(Class cls) {
        Object objX;
        try {
            objX = la.ab(cls.getDeclaredMethods());
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            dov dovVar = bth.a;
            bth.e("Failed to get declared methods in " + this + " because got an exception.", thB);
        }
        if (objX instanceof dcx) {
            objX = null;
        }
        List list = (List) objX;
        return list == null ? avd.a : list;
    }

    @Override // me.hd.wauxv.obf.axv
    public Object create() {
        try {
            return new def(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // me.hd.wauxv.obf.bno
    public bxs d() {
        return cig.a;
    }

    @Override // me.hd.wauxv.obf.crt
    public void e(byte[] bArr, Object obj, MessageDigest messageDigest) {
    }

    @Override // me.hd.wauxv.obf.cvv
    public void i() {
        switch (this.f) {
            case 11:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cvv
    public void j(int i, Object obj) {
        String str;
        switch (this.f) {
            case 11:
                break;
            default:
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
                break;
        }
    }

    public float k(float f, float f2) {
        return 1.0f;
    }

    @Override // me.hd.wauxv.obf.dff
    public void onScrollLimit(int i, int i2, int i3, boolean z) {
    }

    @Override // me.hd.wauxv.obf.dff
    public void onScrollProgress(int i, int i2, int i3, int i4) {
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        switch (this.f) {
            case 26:
                return new dnd(chmVar.w(Uri.class, AssetFileDescriptor.class), 0);
            case 27:
                return new dnd(chmVar.w(Uri.class, ParcelFileDescriptor.class), 0);
            default:
                return new dnd(chmVar.w(Uri.class, InputStream.class), 0);
        }
    }

    public cbm(awz awzVar) {
        this.f = 29;
        new WeakReference(awzVar);
    }

    public cbm(View view, int i) {
        this.f = i;
        switch (i) {
            case 24:
                if (Build.VERSION.SDK_INT >= 30) {
                    new dky(view, 23);
                } else {
                    new cbm(view, 23);
                }
                break;
        }
    }
}
