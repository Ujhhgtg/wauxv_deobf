package me.hd.wauxv.obf;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.EdgeEffect;
import android.widget.Toast;
import androidx.navigation.fragment.NavHostFragment;
import com.alibaba.fastjson2.JSONB;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.WeakHashMap;
import me.hd.wauxv.MainApp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class KotlinHelpers2 implements ajt, acm {
    public static final of ae = new of();
    public static final char[] af = { '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1',
            '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3',
            '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5',
            '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7',
            '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9' };
    public static final char[] ag = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    public static Toast ah;

    public static final brv ai(Number number, String str) {
        return new brv("Unexpected special floating-point value " + number
                + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: "
                + ((Object) ba(-1, str)), 1);
    }

    public static final brv aj(dfx dfxVar) {
        return new brv("Value of type '" + dfxVar.b()
                + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '"
                + dfxVar.h()
                + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.",
                1);
    }

    public static final brv ak(int i, String str, CharSequence charSequence) {
        throwIfVar1IsNull(str, "message");
        throwIfVar1IsNull(charSequence, "input");
        String str2 = str + "\nJSON input: " + ((Object) ba(i, charSequence));
        throwIfVar1IsNull(str2, "message");
        if (i >= 0) {
            str2 = "Unexpected JSON token at offset " + i + ": " + str2;
        }
        return new brv(str2, 0);
    }

    public static final void al(kz kzVar, int i) {
        kzVar.a = new int[i];
        kzVar.b = new Object[i];
    }

    public static boolean am(adq adqVar) {
        int[] iArr = adqVar.bz;
        int i = iArr[0];
        int i2 = iArr[1];
        adq adqVar2 = adqVar.bd;
        adr adrVar = adqVar2 != null ? (adr) adqVar2 : null;
        if (adrVar != null) {
            int i3 = adrVar.bz[0];
        }
        if (adrVar != null) {
            int i4 = adrVar.bz[1];
        }
        boolean z = i == 1 || adqVar.g() || i == 2 || (i == 3 && adqVar.ab == 0 && adqVar.bg == 0.0f && adqVar.ct(0))
                || (i == 3 && adqVar.ab == 1 && adqVar.cu(0, adqVar.cq()));
        boolean z2 = i2 == 1 || adqVar.h() || i2 == 2
                || (i2 == 3 && adqVar.ac == 0 && adqVar.bg == 0.0f && adqVar.ct(1))
                || (i2 == 3 && adqVar.ac == 1 && adqVar.cu(1, adqVar.cm()));
        return (adqVar.bg > 0.0f && (z || z2)) || (z && z2);
    }

    public static int an(int i, int i2) {
        return Math.max(0, Math.min(i2, i));
    }

    public static bhv ao(int i) {
        return i != 0 ? i != 1 ? new ddk() : new aiv() : new ddk();
    }

    /*
     * JADX WARN: Found duplicated region for block: B:19:0x002f A[ORIG_RETURN,
     * RETURN]
     */
    public static boolean ap(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (ap(file2)) {
                }
            }
            if (file.delete()) {
                return true;
            }
        } else if (file.delete()) {
            return true;
        }
        return false;
    }

    public static View recursivelyFindViewById(View view, int i) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewFindViewById = viewGroup.getChildAt(i2).findViewById(i);
            if (viewFindViewById != null) {
                return viewFindViewById;
            }
        }
        return null;
    }

    public static final cjl ar(SomeFragmentManager someFragmentManagerVar) {
        Dialog dialog;
        Window window;
        throwIfVar1IsNull(someFragmentManagerVar, "<this>");
        for (SomeFragmentManager someFragmentManagerVar2 = someFragmentManagerVar; someFragmentManagerVar2 != null; someFragmentManagerVar2 = someFragmentManagerVar2.bp) {
            if (someFragmentManagerVar2 instanceof NavHostFragment) {
                return ((NavHostFragment) someFragmentManagerVar2).l();
            }
            SomeFragmentManager someFragmentManagerVar3 = someFragmentManagerVar2.cs().z;
            if (someFragmentManagerVar3 instanceof NavHostFragment) {
                return ((NavHostFragment) someFragmentManagerVar3).l();
            }
        }
        View view = someFragmentManagerVar.bz;
        if (view != null) {
            return cnb.u(view);
        }
        View decorView = null;
        anc ancVar = someFragmentManagerVar instanceof anc ? (anc) someFragmentManagerVar : null;
        if (ancVar != null && (dialog = ancVar.s) != null && (window = dialog.getWindow()) != null) {
            decorView = window.getDecorView();
        }
        if (decorView != null) {
            return cnb.u(decorView);
        }
        throw new IllegalStateException(yg.l("Fragment ", someFragmentManagerVar, " does not have a NavController set"));
    }

    public static long as(File file) {
        long jAs = 0;
        if (file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    jAs += as(file2);
                }
            }
        }
        return jAs;
    }

    public static float at(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return ard.b(edgeEffect);
        }
        return 0.0f;
    }

    public static String au(Class cls) {
        LinkedHashMap linkedHashMap = ckm.a;
        String strValue = (String) linkedHashMap.get(cls);
        if (strValue == null) {
            ckk ckkVar = (ckk) cls.getAnnotation(ckk.class);
            strValue = ckkVar != null ? ckkVar.value() : null;
            if (strValue == null || strValue.length() <= 0) {
                throw new IllegalArgumentException(
                        "No @Navigator.Name annotation found for ".concat(cls.getSimpleName()).toString());
            }
            linkedHashMap.put(cls, strValue);
        }
        throwIfVar1IsNull(strValue);
        return strValue;
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }

    public static void aw(int i, adg adgVar, adq adqVar, boolean z) {
        adb adbVar;
        adb adbVar2;
        boolean z2;
        adb adbVar3;
        adb adbVar4;
        if (adqVar.w) {
            return;
        }
        if (!(adqVar instanceof adr) && adqVar.cz() && am(adqVar)) {
            adr.ed(adqVar, adgVar, new of());
        }
        adb adbVarCk = adqVar.ck(2);
        adb adbVarCk2 = adqVar.ck(4);
        int iM = adbVarCk.m();
        int iM2 = adbVarCk2.m();
        HashSet<adb> hashSet = adbVarCk.a;
        if (hashSet != null && adbVarCk.c) {
            for (adb adbVar5 : hashSet) {
                adq adqVar2 = adbVar5.d;
                int i2 = i + 1;
                boolean zAm = am(adqVar2);
                adb adbVar6 = adqVar2.as;
                adb adbVar7 = adqVar2.au;
                if (adqVar2.cz() && zAm) {
                    z2 = true;
                    adr.ed(adqVar2, adgVar, new of());
                } else {
                    z2 = true;
                }
                boolean z3 = ((adbVar5 == adbVar6 && (adbVar4 = adbVar7.f) != null && adbVar4.c)
                        || (adbVar5 == adbVar7 && (adbVar3 = adbVar6.f) != null && adbVar3.c)) ? z2 : false;
                int i3 = adqVar2.bz[0];
                if (i3 != 3 || zAm) {
                    if (!adqVar2.cz()) {
                        if (adbVar5 == adbVar6 && adbVar7.f == null) {
                            int iN = adbVar6.n() + iM;
                            adqVar2.df(iN, adqVar2.cq() + iN);
                            aw(i2, adgVar, adqVar2, z);
                        } else if (adbVar5 == adbVar7 && adbVar6.f == null) {
                            int iN2 = iM - adbVar7.n();
                            adqVar2.df(iN2 - adqVar2.cq(), iN2);
                            aw(i2, adgVar, adqVar2, z);
                        } else if (z3 && !adqVar2.cx()) {
                            bk(i2, adgVar, adqVar2, z);
                        }
                    }
                } else if (i3 == 3 && adqVar2.af >= 0 && adqVar2.ae >= 0
                        && (adqVar2.bq == 8 || (adqVar2.ab == 0 && adqVar2.bg == 0.0f))) {
                    if (!adqVar2.cx() && !adqVar2.ap && z3 && !adqVar2.cx()) {
                        bl(i2, adqVar, adgVar, adqVar2, z);
                    }
                }
            }
        }
        if (adqVar instanceof bjp) {
            return;
        }
        HashSet<adb> hashSet2 = adbVarCk2.a;
        if (hashSet2 != null && adbVarCk2.c) {
            for (adb adbVar8 : hashSet2) {
                adq adqVar3 = adbVar8.d;
                int i4 = i + 1;
                boolean zAm2 = am(adqVar3);
                adb adbVar9 = adqVar3.as;
                adb adbVar10 = adqVar3.au;
                if (adqVar3.cz() && zAm2) {
                    adr.ed(adqVar3, adgVar, new of());
                }
                boolean z4 = (adbVar8 == adbVar9 && (adbVar2 = adbVar10.f) != null && adbVar2.c)
                        || (adbVar8 == adbVar10 && (adbVar = adbVar9.f) != null && adbVar.c);
                int i5 = adqVar3.bz[0];
                if (i5 != 3 || zAm2) {
                    if (!adqVar3.cz()) {
                        if (adbVar8 == adbVar9 && adbVar10.f == null) {
                            int iN3 = adbVar9.n() + iM2;
                            adqVar3.df(iN3, adqVar3.cq() + iN3);
                            aw(i4, adgVar, adqVar3, z);
                        } else if (adbVar8 == adbVar10 && adbVar9.f == null) {
                            int iN4 = iM2 - adbVar10.n();
                            adqVar3.df(iN4 - adqVar3.cq(), iN4);
                            aw(i4, adgVar, adqVar3, z);
                        } else if (z4 && !adqVar3.cx()) {
                            bk(i4, adgVar, adqVar3, z);
                        }
                    }
                } else if (i5 == 3 && adqVar3.af >= 0 && adqVar3.ae >= 0) {
                    if (adqVar3.bq == 8 || (adqVar3.ab == 0 && adqVar3.bg == 0.0f)) {
                        if (!adqVar3.cx() && !adqVar3.ap && z4 && !adqVar3.cx()) {
                            bl(i4, adqVar, adgVar, adqVar3, z);
                        }
                    }
                }
            }
        }
        adqVar.w = true;
    }

    public static final int ax(kz kzVar, Object obj, int i) {
        int i2 = kzVar.c;
        if (i2 == 0) {
            return -1;
        }
        try {
            int i3 = KotlinHelpers.i(kzVar.a, i2, i);
            if (i3 < 0 || nullSafeIsEqual(obj, kzVar.b[i3])) {
                return i3;
            }
            int i4 = i3 + 1;
            while (i4 < i2 && kzVar.a[i4] == i) {
                if (nullSafeIsEqual(obj, kzVar.b[i4])) {
                    return i4;
                }
                i4++;
            }
            for (int i5 = i3 - 1; i5 >= 0 && kzVar.a[i5] == i; i5--) {
                if (nullSafeIsEqual(obj, kzVar.b[i5])) {
                    return i5;
                }
            }
            return ~i4;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final void ay(yi yiVar, String str) {
        yiVar.v(yiVar.b - 1, "Trailing comma before the end of JSON ".concat(str),
                "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingComma = true' in 'Json {}' builder to support them.");
        throw null;
    }

    /* JADX WARN: Found duplicated region for block: B:38:0x007e */
    public static boolean az() {
        boolean zBooleanValue;
        Object objX;
        Object objX2;
        Bundle bundleCall;
        Bundle bundleCall2;
        boolean z = exm.a;
        if (exm.l()) {
            return false;
        }
        MainApp mainApp = MainApp.a;
        if (mainApp != null) {
            try {
                ContentResolver contentResolver = mainApp.getContentResolver();
                objX = (contentResolver == null
                        || (bundleCall2 = contentResolver.call(Uri.parse("content://me.weishu.exposed.CP/"), "active",
                                (String) null, (Bundle) null)) == null) ? null
                                        : Boolean.valueOf(bundleCall2.getBoolean("active", false));
            } catch (Throwable th) {
                objX = FastKV.getFailureFromException(th);
            }
            if (objX instanceof Failure) {
                objX = null;
            }
            Boolean bool = (Boolean) objX;
            if (bool != null) {
                zBooleanValue = bool.booleanValue();
            } else {
                try {
                    Intent intent = new Intent("me.weishu.exp.ACTION_ACTIVE");
                    intent.addFlags(268435456);
                    mainApp.startActivity(intent);
                    ContentResolver contentResolver2 = mainApp.getContentResolver();
                    objX2 = (contentResolver2 == null
                            || (bundleCall = contentResolver2.call(Uri.parse("content://me.weishu.exposed.CP/"),
                                    "active", (String) null, (Bundle) null)) == null) ? null
                                            : Boolean.valueOf(bundleCall.getBoolean("active", false));
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                Boolean bool2 = (Boolean) (objX2 instanceof Failure ? null : objX2);
                zBooleanValue = bool2 != null ? bool2.booleanValue() : false;
            }
        }
        return zBooleanValue;
    }

    public static final CharSequence ba(int i, CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i != -1) {
                int i2 = i - 30;
                int i3 = i + 30;
                String str = i2 <= 0 ? "" : ".....";
                String str2 = i3 >= charSequence.length() ? "" : ".....";
                StringBuilder sbY = StaticHelpers6.toSb(str);
                if (i2 < 0) {
                    i2 = 0;
                }
                int length = charSequence.length();
                if (i3 > length) {
                    i3 = length;
                }
                sbY.append(charSequence.subSequence(i2, i3).toString());
                sbY.append(str2);
                return sbY.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static float bb(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return ard.c(edgeEffect, f, f2);
        }
        arc.a(edgeEffect, f, f2);
        return f;
    }

    public static void bc(ayd aydVar, ik ikVar, ewo ewoVar, byte b, String str, int i) {
        HashMap map = aydVar.j;
        if (b == 1) {
            byte[] bArr = (byte[]) ikVar.d;
            int i2 = ikVar.b;
            ikVar.b = i2 + 1;
            map.put(str, new aeu(i, bArr[i2] == 1));
            return;
        }
        if (b == 2) {
            int iM = ikVar.m();
            if (ewoVar != null) {
                iM ^= ewoVar.a;
            }
            map.put(str, new aex(i, iM));
            return;
        }
        if (b == 3) {
            int iM2 = ikVar.m();
            if (ewoVar != null) {
                iM2 ^= ewoVar.a;
            }
            map.put(str, new aew(i, Float.intBitsToFloat(iM2)));
            return;
        }
        if (b != 4) {
            long jO = ikVar.o(ikVar.b);
            ikVar.b += 8;
            if (ewoVar != null) {
                jO ^= (long) ewoVar.a;
            }
            map.put(str, new aev(i, Double.longBitsToDouble(jO)));
            return;
        }
        long jO2 = ikVar.o(ikVar.b);
        ikVar.b += 8;
        if (ewoVar != null) {
            jO2 ^= (long) ewoVar.a;
        }
        map.put(str, new aey(i, jO2));
    }

    public static void bd(ayd aydVar, ik ikVar, ewo ewoVar, byte b, String str, int i, int i2, byte b2)
            throws Exception {
        Object objB;
        int length;
        ik ikVar2;
        byte b3 = b;
        HashMap map = aydVar.j;
        boolean z = b3 == 9 || b3 == 10 || b3 == 11;
        int iM = z ? ikVar.m() : ikVar.q() & 65535;
        int i3 = z ? 4 : 2;
        boolean z2 = (b2 & JSONB.Constants.BC_INT32_SHORT_MIN) != 0;
        if (z2 && iM != 32) {
            throw new IllegalStateException("name size not match");
        }
        switch (b3) {
            case 9:
                b3 = 6;
                break;
            case 10:
                b3 = 7;
                break;
            case 11:
                b3 = 8;
                break;
        }
        if (b3 == 6) {
            map.put(str, new afa(i2, i + i3, z2 ? ikVar.r(iM) : ikVar.s(ewoVar, iM), iM, z2));
            return;
        }
        if (b3 == 7) {
            if (z2) {
                objB = ikVar.r(iM);
            } else {
                ikVar.getClass();
                byte[] bArr = new byte[iM];
                System.arraycopy((byte[]) ikVar.d, ikVar.b, bArr, 0, iM);
                ikVar.b += iM;
                objB = ewoVar != null ? ewoVar.b(bArr) : bArr;
            }
            map.put(str, new aes(i2, i + i3, objB, iM, z2));
            return;
        }
        if (z2) {
            map.put(str, new aez(i2, i + i3, ikVar.r(iM), iM, true));
            return;
        }
        if (ewoVar == null) {
            ikVar2 = aydVar.l;
            length = iM;
        } else {
            byte[] bArr2 = new byte[iM];
            ik ikVar3 = aydVar.l;
            System.arraycopy((byte[]) ikVar3.d, ikVar3.b, bArr2, 0, iM);
            byte[] bArrB = ewoVar.b(bArr2);
            ik ikVar4 = new ik(bArrB, 0);
            length = bArrB.length;
            ikVar2 = ikVar4;
        }
        byte[] bArr3 = (byte[]) ikVar2.d;
        int i4 = ikVar2.b;
        ikVar2.b = i4 + 1;
        int i5 = bArr3[i4] & 255;
        String strR = ikVar2.r(i5);
        dni dniVar = (dni) aydVar.f.get(strR);
        int i6 = length - (i5 + 1);
        if (i6 < 0) {
            throw new Exception("parse dara failed");
        }
        if (dniVar != null) {
            try {
                aez aezVar = new aez(i2, i + 2, dniVar.b(ikVar2.b, i6, (byte[]) ikVar2.d), iM, false);
                aezVar.h = dniVar;
                map.put(str, aezVar);
            } catch (Exception e) {
                Log.e("FastKV", aydVar.e, e);
            }
        } else {
            bhv.v(aydVar, "object with tag: " + strR + " without encoder");
        }
        ikVar.b = i + i3 + iM;
    }

    public static boolean be(ayd aydVar, boolean z) {
        int iM;
        ayd aydVar2 = aydVar;
        ewo ewoVar = aydVar2.g;
        boolean z2 = false;
        if (z && ewoVar == null) {
            bhv.v(aydVar2, "miss cipher");
            return false;
        }
        ewo ewoVar2 = z ? ewoVar : null;
        ik ikVar = aydVar2.l;
        String str = aydVar2.e;
        ikVar.b = 12;
        while (true) {
            try {
                int i = ikVar.b;
                int i2 = aydVar2.h;
                boolean z3 = true;
                if (i >= i2) {
                    if (i != i2) {
                        Log.e("FastKV", str, new Exception("parse dara failed"));
                        return false;
                    }
                    if (!z && ewoVar != null && i2 != 12) {
                        z2 = true;
                    }
                    aydVar2.p = z2;
                    return true;
                }
                byte[] bArr = (byte[]) ikVar.d;
                int i3 = i + 1;
                ikVar.b = i3;
                byte b = bArr[i];
                byte b2 = (byte) (b & JSONB.Constants.BC_INT32_BYTE_MAX);
                if (b2 < 1 || b2 > 11) {
                    throw new Exception("parse dara failed");
                }
                int i4 = i + 2;
                ikVar.b = i4;
                int i5 = bArr[i3] & 255;
                if (i5 == 0) {
                    throw new IllegalStateException("invalid key size");
                }
                if (b < 0) {
                    ikVar.b = i4 + i5;
                    if (b2 <= 5) {
                        iM = ayd.b[b2];
                    } else {
                        if (b2 != 9 && b2 != 10 && b2 != 11) {
                            z3 = false;
                        }
                        iM = z3 ? ikVar.m() : ikVar.q() & 65535;
                    }
                    int i6 = ikVar.b + iM;
                    ikVar.b = i6;
                    aydVar2.r = (i6 - i) + aydVar2.r;
                    ArrayList arrayList = aydVar2.s;
                    dfk dfkVar = new dfk();
                    dfkVar.a = i;
                    dfkVar.b = i6;
                    arrayList.add(dfkVar);
                } else {
                    String strS = ikVar.s(ewoVar2, i5);
                    int i7 = ikVar.b;
                    if (b2 <= 5) {
                        bc(aydVar2, ikVar, ewoVar2, b2, strS, i7);
                        aydVar2 = aydVar;
                    } else {
                        bd(aydVar2, ikVar, ewoVar2, b2, strS, i7, i, b);
                    }
                }
            } catch (Exception e) {
                Log.e("FastKV", str, e);
                return false;
            }
        }
    }

    public static final et bf(Dispatcher dispatcher, bgj bgjVar) {
        throwIfVar1IsNull(dispatcher, "dispatcher");
        et etVar = new et(LifeEventEnum.ON_DESTROY, dispatcher);
        ajn.y(etVar, EmptyCoroutineContext.INSTANCE, new eq(bgjVar, null)).af(new er(etVar, 0));
        return etVar;
    }

    public static void bg(bgj bgjVar) {
        Dispatchers$Default alcVar = aou.a;
        Dispatcher2 dispatcher2Var = bza.a;
        throwIfVar1IsNull(dispatcher2Var, "dispatcher");
        LifeEventEnum lifeEventEnumVar = LifeEventEnum.ON_DESTROY;
        throwIfVar1IsNull(lifeEventEnumVar, "lifeEvent");
        cky ckyVar = new cky(lifeEventEnumVar, dispatcher2Var);
        ajn.y(ckyVar, EmptyCoroutineContext.INSTANCE, new ckx(ckyVar, bgjVar, (kotlinx$coroutines$internal$DispatchedContinuation) null)).af(new er(ckyVar, 1));
    }

    public static void bh(ViewGroup viewGroup, float f) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof cau) {
            ((cau) background).dy(f);
        }
    }

    public static void bi(View view, cau cauVar) {
        asy asyVar = cauVar.ct.c;
        if (asyVar == null || !asyVar.b) {
            return;
        }
        float fE = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            WeakHashMap weakHashMap = ViewCompat.a;
            fE += eqq.e((View) parent);
        }
        cat catVar = cauVar.ct;
        if (catVar.m != fE) {
            catVar.m = fE;
            cauVar.eg();
        }
    }

    public static void bj(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        if (background instanceof cau) {
            bi(viewGroup, (cau) background);
        }
    }

    public static void bk(int i, adg adgVar, adq adqVar, boolean z) {
        float f = adqVar.bn;
        adb adbVar = adqVar.as;
        int iM = adbVar.f.m();
        adb adbVar2 = adqVar.au;
        int iM2 = adbVar2.f.m();
        int iN = adbVar.n() + iM;
        int iN2 = iM2 - adbVar2.n();
        if (iM == iM2) {
            f = 0.5f;
        } else {
            iM = iN;
            iM2 = iN2;
        }
        int iCq = adqVar.cq();
        int i2 = (iM2 - iM) - iCq;
        if (iM > iM2) {
            i2 = (iM - iM2) - iCq;
        }
        int i3 = ((int) (i2 > 0 ? (f * i2) + 0.5f : f * i2)) + iM;
        int i4 = i3 + iCq;
        if (iM > iM2) {
            i4 = i3 - iCq;
        }
        adqVar.df(i3, i4);
        aw(i + 1, adgVar, adqVar, z);
    }

    public static void bl(int i, adq adqVar, adg adgVar, adq adqVar2, boolean z) {
        float f = adqVar2.bn;
        adb adbVar = adqVar2.as;
        int iN = adbVar.n() + adbVar.f.m();
        adb adbVar2 = adqVar2.au;
        int iM = adbVar2.f.m() - adbVar2.n();
        if (iM >= iN) {
            int iCq = adqVar2.cq();
            if (adqVar2.bq != 8) {
                int i2 = adqVar2.ab;
                if (i2 == 2) {
                    iCq = (int) (adqVar2.bn * 0.5f * (adqVar instanceof adr ? adqVar.cq() : adqVar.bd.cq()));
                } else if (i2 == 0) {
                    iCq = iM - iN;
                }
                iCq = Math.max(adqVar2.ae, iCq);
                int i3 = adqVar2.af;
                if (i3 > 0) {
                    iCq = Math.min(i3, iCq);
                }
            }
            int i4 = iN + ((int) ((f * ((iM - iN) - iCq)) + 0.5f));
            adqVar2.df(i4, iCq + i4);
            aw(i + 1, adgVar, adqVar2, z);
        }
    }

    public static void bm(int i, adg adgVar, adq adqVar) {
        float f = adqVar.bo;
        adb adbVar = adqVar.at;
        int iM = adbVar.f.m();
        adb adbVar2 = adqVar.av;
        int iM2 = adbVar2.f.m();
        int iN = adbVar.n() + iM;
        int iN2 = iM2 - adbVar2.n();
        if (iM == iM2) {
            f = 0.5f;
        } else {
            iM = iN;
            iM2 = iN2;
        }
        int iCm = adqVar.cm();
        int i2 = (iM2 - iM) - iCm;
        if (iM > iM2) {
            i2 = (iM - iM2) - iCm;
        }
        int i3 = (int) (i2 > 0 ? (f * i2) + 0.5f : f * i2);
        int i4 = iM + i3;
        int i5 = i4 + iCm;
        if (iM > iM2) {
            i4 = iM - i3;
            i5 = i4 - iCm;
        }
        adqVar.dg(i4, i5);
        bp(i + 1, adgVar, adqVar);
    }

    public static void bn(int i, adq adqVar, adg adgVar, adq adqVar2) {
        float f = adqVar2.bo;
        adb adbVar = adqVar2.at;
        int iN = adbVar.n() + adbVar.f.m();
        adb adbVar2 = adqVar2.av;
        int iM = adbVar2.f.m() - adbVar2.n();
        if (iM >= iN) {
            int iCm = adqVar2.cm();
            if (adqVar2.bq != 8) {
                int i2 = adqVar2.ac;
                if (i2 == 2) {
                    iCm = (int) (f * 0.5f * (adqVar instanceof adr ? adqVar.cm() : adqVar.bd.cm()));
                } else if (i2 == 0) {
                    iCm = iM - iN;
                }
                iCm = Math.max(adqVar2.ah, iCm);
                int i3 = adqVar2.ai;
                if (i3 > 0) {
                    iCm = Math.min(i3, iCm);
                }
            }
            int i4 = iN + ((int) ((f * ((iM - iN) - iCm)) + 0.5f));
            adqVar2.dg(i4, iCm + i4);
            bp(i + 1, adgVar, adqVar2);
        }
    }

    public static final void bo(yi yiVar, Number number) {
        yi.g(yiVar, "Unexpected special floating-point value " + number
                + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification",
                0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static void bp(int i, adg adgVar, adq adqVar) {
        boolean z;
        adb adbVar;
        adb adbVar2;
        adb adbVar3;
        adb adbVar4;
        if (adqVar.x) {
            return;
        }
        if (!(adqVar instanceof adr) && adqVar.cz() && am(adqVar)) {
            adr.ed(adqVar, adgVar, new of());
        }
        adb adbVarCk = adqVar.ck(3);
        adb adbVarCk2 = adqVar.ck(5);
        int iM = adbVarCk.m();
        int iM2 = adbVarCk2.m();
        HashSet<adb> hashSet = adbVarCk.a;
        if (hashSet != null && adbVarCk.c) {
            for (adb adbVar5 : hashSet) {
                adq adqVar2 = adbVar5.d;
                int i2 = i + 1;
                boolean zAm = am(adqVar2);
                adb adbVar6 = adqVar2.at;
                adb adbVar7 = adqVar2.av;
                if (adqVar2.cz() && zAm) {
                    adr.ed(adqVar2, adgVar, new of());
                }
                boolean z2 = (adbVar5 == adbVar6 && (adbVar4 = adbVar7.f) != null && adbVar4.c)
                        || (adbVar5 == adbVar7 && (adbVar3 = adbVar6.f) != null && adbVar3.c);
                int i3 = adqVar2.bz[1];
                if (i3 != 3 || zAm) {
                    if (!adqVar2.cz()) {
                        if (adbVar5 == adbVar6 && adbVar7.f == null) {
                            int iN = adbVar6.n() + iM;
                            adqVar2.dg(iN, adqVar2.cm() + iN);
                            bp(i2, adgVar, adqVar2);
                        } else if (adbVar5 == adbVar7 && adbVar6.f == null) {
                            int iN2 = iM - adbVar7.n();
                            adqVar2.dg(iN2 - adqVar2.cm(), iN2);
                            bp(i2, adgVar, adqVar2);
                        } else if (z2 && !adqVar2.cy()) {
                            bm(i2, adgVar, adqVar2);
                        }
                    }
                } else if (i3 == 3 && adqVar2.ai >= 0 && adqVar2.ah >= 0
                        && (adqVar2.bq == 8 || (adqVar2.ac == 0 && adqVar2.bg == 0.0f))) {
                    if (!adqVar2.cy() && !adqVar2.ap && z2 && !adqVar2.cy()) {
                        bn(i2, adqVar, adgVar, adqVar2);
                    }
                }
            }
        }
        boolean z3 = true;
        z3 = true;
        z3 = true;
        if (adqVar instanceof bjp) {
            return;
        }
        HashSet<adb> hashSet2 = adbVarCk2.a;
        if (hashSet2 != null && adbVarCk2.c) {
            for (adb adbVar8 : hashSet2) {
                adq adqVar3 = adbVar8.d;
                int i4 = i + 1;
                boolean zAm2 = am(adqVar3);
                adb adbVar9 = adqVar3.at;
                adb adbVar10 = adqVar3.av;
                if (adqVar3.cz() && zAm2) {
                    adr.ed(adqVar3, adgVar, new of());
                }
                boolean z4 = (adbVar8 == adbVar9 && (adbVar2 = adbVar10.f) != null && adbVar2.c)
                        || (adbVar8 == adbVar10 && (adbVar = adbVar9.f) != null && adbVar.c);
                int i5 = adqVar3.bz[1];
                if (i5 != 3 || zAm2) {
                    if (!adqVar3.cz()) {
                        if (adbVar8 == adbVar9 && adbVar10.f == null) {
                            int iN3 = adbVar9.n() + iM2;
                            adqVar3.dg(iN3, adqVar3.cm() + iN3);
                            bp(i4, adgVar, adqVar3);
                        } else if (adbVar8 == adbVar10 && adbVar9.f == null) {
                            int iN4 = iM2 - adbVar10.n();
                            adqVar3.dg(iN4 - adqVar3.cm(), iN4);
                            bp(i4, adgVar, adqVar3);
                        } else if (z4 && !adqVar3.cy()) {
                            bm(i4, adgVar, adqVar3);
                        }
                    }
                } else if (i5 == 3 && adqVar3.ai >= 0 && adqVar3.ah >= 0
                        && (adqVar3.bq == 8 || (adqVar3.ac == 0 && adqVar3.bg == 0.0f))) {
                    if (!adqVar3.cy() && !adqVar3.ap && z4 && !adqVar3.cy()) {
                        bn(i4, adqVar, adgVar, adqVar3);
                    }
                }
            }
        }
        adb adbVarCk3 = adqVar.ck(6);
        if (adbVarCk3.a != null && adbVarCk3.c) {
            int iM3 = adbVarCk3.m();
            for (adb adbVar11 : adbVarCk3.a) {
                adq adqVar4 = adbVar11.d;
                int i6 = i + 1;
                boolean zAm3 = am(adqVar4);
                adb adbVar12 = adqVar4.aw;
                if (adqVar4.cz() && zAm3) {
                    adr.ed(adqVar4, adgVar, new of());
                }
                if (adqVar4.bz[z3 ? 1 : 0] != 3 || zAm3) {
                    if (!adqVar4.cz()) {
                        if (adbVar11 == adbVar12) {
                            int iN5 = adbVar11.n() + iM3;
                            if (adqVar4.ao) {
                                int i7 = iN5 - adqVar4.bk;
                                int i8 = adqVar4.bf + i7;
                                adqVar4.bj = i7;
                                adqVar4.at.u(i7);
                                adqVar4.av.u(i8);
                                adbVar12.u(iN5);
                                z = z3 ? 1 : 0;
                                adqVar4.v = z;
                            } else {
                                z = z3 ? 1 : 0;
                            }
                            bp(i6, adgVar, adqVar4);
                        }
                        z3 = z;
                    }
                }
                z = z3 ? 1 : 0;
                z3 = z;
            }
        }
        adqVar.x = z3;
    }

    @Override // me.hd.wauxv.obf.acm
    public void _bp(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
    }

    @Override // me.hd.wauxv.obf.acm
    public double _bq(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return ab();
    }

    @Override // me.hd.wauxv.obf.ajt
    public float aa() {
        bq();
        throw null;
    }

    @Override // me.hd.wauxv.obf.ajt
    public double ab() {
        bq();
        throw null;
    }

    public void bq() {
        throw new SomeIllegalArgumentException(dal.getKClassFromClass(getClass()) + " can't retrieve untyped values");
    }

    @Override // me.hd.wauxv.obf.acm
    public String d(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return v();
    }

    @Override // me.hd.wauxv.obf.acm
    public long e(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return w();
    }

    @Override // me.hd.wauxv.obf.acm
    public int g(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return s();
    }

    @Override // me.hd.wauxv.obf.acm
    public Object h(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "deserializer");
        return t(btdVar);
    }

    @Override // me.hd.wauxv.obf.acm
    public Object i(dfx dfxVar, int i, btd btdVar, Object obj) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throwIfVar1IsNull(btdVar, "deserializer");
        if (btdVar.getDescriptor().f() || x()) {
            return t(btdVar);
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.acm
    public char j(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return r();
    }

    @Override // me.hd.wauxv.obf.acm
    public byte k(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return y();
    }

    @Override // me.hd.wauxv.obf.acm
    public boolean l(dfx dfxVar, int i) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return q();
    }

    @Override // me.hd.wauxv.obf.acm
    public ajt m(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return u(cvkVar.l(i));
    }

    @Override // me.hd.wauxv.obf.acm
    public short n(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return z();
    }

    @Override // me.hd.wauxv.obf.acm
    public float o(cvk cvkVar, int i) {
        throwIfVar1IsNull(cvkVar, "descriptor");
        return aa();
    }

    @Override // me.hd.wauxv.obf.ajt
    public acm p(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return this;
    }

    @Override // me.hd.wauxv.obf.ajt
    public boolean q() {
        bq();
        throw null;
    }

    @Override // me.hd.wauxv.obf.ajt
    public char r() {
        bq();
        throw null;
    }

    @Override // me.hd.wauxv.obf.ajt
    public abstract int s();

    @Override // me.hd.wauxv.obf.ajt
    public Object t(btd btdVar) {
        throwIfVar1IsNull(btdVar, "deserializer");
        return btdVar.a(this);
    }

    @Override // me.hd.wauxv.obf.ajt
    public ajt u(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        return this;
    }

    @Override // me.hd.wauxv.obf.ajt
    public String v() {
        bq();
        throw null;
    }

    @Override // me.hd.wauxv.obf.ajt
    public abstract long w();

    @Override // me.hd.wauxv.obf.ajt
    public boolean x() {
        return true;
    }

    @Override // me.hd.wauxv.obf.ajt
    public abstract byte y();

    @Override // me.hd.wauxv.obf.ajt
    public abstract short z();
}
