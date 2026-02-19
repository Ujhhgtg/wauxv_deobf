package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class nu implements oz, esn, cdw, avu, aoh, bfh, app, cvg, ccv, dcc {
    public static nu a;
    public final /* synthetic */ int b;

    public /* synthetic */ nu(int i) {
        this.b = i;
    }

    public static nu c(Context context, int i) {
        cna.g("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cxs.u);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0),
                typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0),
                typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0),
                typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        cnb.v(context, typedArrayObtainStyledAttributes, 4);
        cnb.v(context, typedArrayObtainStyledAttributes, 9);
        cnb.v(context, typedArrayObtainStyledAttributes, 7);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        dgm.m(context, typedArrayObtainStyledAttributes.getResourceId(5, 0),
                typedArrayObtainStyledAttributes.getResourceId(6, 0), new o(0)).m();
        typedArrayObtainStyledAttributes.recycle();
        nu nuVar = new nu(13);
        cna.dexFind(rect.left);
        cna.dexFind(rect.top);
        cna.dexFind(rect.right);
        cna.dexFind(rect.bottom);
        return nuVar;
    }

    public static ByteArrayInputStream d(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }

    /* JADX WARN: Found duplicated region for block: B:66:0x00d7 */
    /* JADX WARN: Found duplicated region for block: B:68:0x00dd A[RETURN] */
    public static sj e(String str) {
        int i;
        char cCharAt;
        throwIfVar1IsNull(str, "<this>");
        byte[] bArr = a.a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r'
                || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArrCopyOf = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i3 >= length) {
                int i7 = i4 % 4;
                if (i7 != 1) {
                    if (i7 == 2) {
                        bArrCopyOf[i6] = (byte) ((i5 << 12) >> 16);
                        i6++;
                    } else if (i7 == 3) {
                        int i8 = i5 << 6;
                        int i9 = i6 + 1;
                        bArrCopyOf[i6] = (byte) (i8 >> 16);
                        i6 += 2;
                        bArrCopyOf[i9] = (byte) (i8 >> 8);
                    }
                    if (i6 != i2) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i6);
                        throwIfVar1IsNull(bArrCopyOf, "copyOf(this, newSize)");
                    }
                }
                if (bArrCopyOf != null) {
                    return new sj(bArrCopyOf);
                }
                return null;
            }
            char cCharAt2 = str.charAt(i3);
            if ('A' <= cCharAt2 && cCharAt2 < '[') {
                i = cCharAt2 - 'A';
            } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                i = cCharAt2 - 'G';
            } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                i = cCharAt2 + 4;
            } else if (cCharAt2 == '+' || cCharAt2 == '-') {
                i = 62;
            } else {
                if (cCharAt2 != '/' && cCharAt2 != '_') {
                    if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                        break;
                    }
                } else {
                    i = 63;
                }
                i3++;
            }
            i5 = (i5 << 6) | i;
            i4++;
            if (i4 % 4 == 0) {
                bArrCopyOf[i6] = (byte) (i5 >> 16);
                int i10 = i6 + 2;
                bArrCopyOf[i6 + 1] = (byte) (i5 >> 8);
                i6 += 3;
                bArrCopyOf[i10] = (byte) i5;
            }
            i3++;
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new sj(bArrCopyOf);
        }
        return null;
    }

    public static sj f(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (ajn.f(str.charAt(i2 + 1)) + (ajn.f(str.charAt(i2)) << 4));
        }
        return new sj(bArr);
    }

    public static sj g(String str) {
        throwIfVar1IsNull(str, "<this>");
        byte[] bytes = str.getBytes(uj.a);
        throwIfVar1IsNull(bytes, "this as java.lang.String).getBytes(charset)");
        sj sjVar = new sj(bytes);
        sjVar.d = str;
        return sjVar;
    }

    public static boolean h(auc aucVar, Editable editable, int i, int i2, boolean z) {
        int iMin;
        if (editable != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd) {
                if (z) {
                    int iMax = Math.max(i, 0);
                    int length = editable.length();
                    if (selectionStart >= 0 && length >= selectionStart && iMax >= 0) {
                        loop0: while (true) {
                            boolean z2 = false;
                            while (true) {
                                if (iMax == 0) {
                                    break loop0;
                                }
                                selectionStart--;
                                if (selectionStart < 0) {
                                    if (!z2) {
                                        selectionStart = 0;
                                        break loop0;
                                    }
                                    break loop0;
                                }
                                char cCharAt = editable.charAt(selectionStart);
                                if (z2) {
                                    if (Character.isHighSurrogate(cCharAt)) {
                                        iMax--;
                                    }
                                } else if (!Character.isSurrogate(cCharAt)) {
                                    iMax--;
                                } else if (!Character.isHighSurrogate(cCharAt)) {
                                    z2 = true;
                                }
                                selectionStart = -1;
                                break loop0;
                            }
                        }
                    }
                    selectionStart = -1;
                    break loop0;
                    int iMax2 = Math.max(i2, 0);
                    iMin = editable.length();
                    if (selectionEnd >= 0 && iMin >= selectionEnd && iMax2 >= 0) {
                        loop2: while (true) {
                            boolean z3 = false;
                            while (true) {
                                if (iMax2 != 0) {
                                    if (selectionEnd >= iMin) {
                                        if (!z3) {
                                            break loop2;
                                        }
                                        break loop2;
                                    }
                                    char cCharAt2 = editable.charAt(selectionEnd);
                                    if (z3) {
                                        if (Character.isLowSurrogate(cCharAt2)) {
                                            iMax2--;
                                            selectionEnd++;
                                        }
                                    } else if (!Character.isSurrogate(cCharAt2)) {
                                        iMax2--;
                                        selectionEnd++;
                                    } else if (!Character.isLowSurrogate(cCharAt2)) {
                                        selectionEnd++;
                                        z3 = true;
                                    }
                                    iMin = -1;
                                    break loop2;
                                }
                                iMin = selectionEnd;
                                break loop2;
                            }
                        }
                    }
                    iMin = -1;
                    break loop2;
                    if (selectionStart != -1 && iMin != -1) {
                    }
                } else {
                    selectionStart = Math.max(selectionStart - i, 0);
                    iMin = Math.min(selectionEnd + i2, editable.length());
                }
                eml[] emlVarArr = (eml[]) editable.getSpans(selectionStart, iMin, eml.class);
                if (emlVarArr != null && emlVarArr.length > 0) {
                    for (eml emlVar : emlVarArr) {
                        int spanStart = editable.getSpanStart(emlVar);
                        int spanEnd = editable.getSpanEnd(emlVar);
                        selectionStart = Math.min(spanStart, selectionStart);
                        iMin = Math.max(spanEnd, iMin);
                    }
                    int iMax3 = Math.max(selectionStart, 0);
                    int iMin2 = Math.min(iMin, editable.length());
                    aucVar.beginBatchEdit();
                    editable.delete(iMax3, iMin2);
                    aucVar.endBatchEdit();
                    return true;
                }
            }
        }
        return false;
    }

    public static sj i(byte[] bArr) {
        sj sjVar = sj.a;
        int length = bArr.length;
        aye.n(bArr.length, 0, length);
        return new sj(SomeStaticHelpers._ap(0, length, bArr));
    }

    @Override // me.hd.wauxv.obf.oz
    public void aa() {
    }

    public Signature[] ab(PackageManager packageManager, String str) {
        return packageManager.getPackageInfo(str, 64).signatures;
    }

    public void ac(DefaultConfig ioVar, float f) {
        ddi ddiVar = (ddi) ((Drawable) ioVar.c);
        te teVar = (te) ioVar.d;
        boolean useCompatPadding = teVar.getUseCompatPadding();
        boolean preventCornerOverlap = teVar.getPreventCornerOverlap();
        if (f != ddiVar.e || ddiVar.f != useCompatPadding || ddiVar.g != preventCornerOverlap) {
            ddiVar.e = f;
            ddiVar.f = useCompatPadding;
            ddiVar.g = preventCornerOverlap;
            ddiVar.m(null);
            ddiVar.invalidateSelf();
        }
        if (!teVar.getUseCompatPadding()) {
            ioVar.ax(0, 0, 0, 0);
            return;
        }
        ddi ddiVar2 = (ddi) ((Drawable) ioVar.c);
        float f2 = ddiVar2.e;
        float f3 = ddiVar2.a;
        int iCeil = (int) Math.ceil(ddj.b(f2, f3, teVar.getPreventCornerOverlap()));
        int iCeil2 = (int) Math.ceil(ddj.c(f2, f3, teVar.getPreventCornerOverlap()));
        ioVar.ax(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // me.hd.wauxv.obf.ccv
    public Drawable j(int i) {
        return null;
    }

    @Override // me.hd.wauxv.obf.avu
    public boolean saveStreamToFile(Object obj, File file, crw crwVar) throws Throwable {
        try {
            sf.e((ByteBuffer) obj, file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("ByteBufferEncoder", 3)) {
                return false;
            }
            Log.d("ByteBufferEncoder", "Failed to write data", e);
            return false;
        }
    }

    @Override // me.hd.wauxv.obf.app
    public void l(Bitmap bitmap, oz ozVar) {
    }

    @Override // me.hd.wauxv.obf.ccv
    public int m() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.oz
    public Bitmap n(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // me.hd.wauxv.obf.ccv
    public int o() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.oz
    public void p(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // me.hd.wauxv.obf.esn
    public evr q(View view, evr evrVar, baw bawVar) {
        bawVar.d = evrVar.e() + bawVar.d;
        WeakHashMap weakHashMap = ViewCompat.a;
        boolean z = view.getLayoutDirection() == 1;
        int iF = evrVar.f();
        int iG = evrVar.g();
        int i = bawVar.a + (z ? iG : iF);
        bawVar.a = i;
        int i2 = bawVar.c;
        if (!z) {
            iF = iG;
        }
        int i3 = i2 + iF;
        bawVar.c = i3;
        view.setPaddingRelative(i, bawVar.b, i3, bawVar.d);
        return evrVar;
    }

    @Override // me.hd.wauxv.obf.cvg
    public CharSequence r(Preference preference) {
        EditTextPreference editTextPreference = (EditTextPreference) preference;
        if (TextUtils.isEmpty(null)) {
            return editTextPreference.f.getString(R.string.not_set);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.ccv
    public int s() {
        return 0;
    }

    @Override // me.hd.wauxv.obf.bfh
    public void t(hb hbVar) {
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        switch (this.b) {
            case 6:
                return new rv(new nu(5), 0);
            case 7:
            default:
                return new ent(1);
            case 8:
                return new rv(new nu(7), 0);
        }
    }

    @Override // me.hd.wauxv.obf.app
    public void v() {
    }

    @Override // me.hd.wauxv.obf.aoh
    public File w(btj btjVar) {
        return null;
    }

    @Override // me.hd.wauxv.obf.oz
    public Bitmap x(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // me.hd.wauxv.obf.aoh
    public void y(btj btjVar, FactoryPools factoryPoolsVar) {
    }

    @Override // me.hd.wauxv.obf.oz
    public void z(int i) {
    }
}
