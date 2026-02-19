package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import com.alibaba.fastjson2.JSONB;
import com.android.dx.io.Opcodes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.R;
import okhttp3.HttpUrl;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class emn implements esi {
    public static final hn z = new hn(1);
    public static final hn aa = new hn(2);
    public static final byte[] ab = { 112, 114, 111, 0 };
    public static final byte[] ac = { 112, 114, JSONB.Constants.BC_STR_ASCII_FIX_36, 0 };

    public emn() {
        new ConcurrentHashMap();
    }

    public static final String ad(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            return cls.getName();
        }
        dft dftVarAi = dfv.ai(type, emm.a);
        return ((Class) dfv.aj(dftVarAi)).getName() + dnr.bm(dfv.d(dftVarAi), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public static int ae(int i, int i2) {
        return (i & 16777215) | (i2 << 24);
    }

    public static void af(long j, rh rhVar, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        ArrayList arrayList3;
        long j2;
        int i6;
        int i7 = i;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i2 >= i3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i8 = i2; i8 < i3; i8++) {
            if (((sj) arrayList4.get(i8)).g() < i7) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        sj sjVar = (sj) arrayList.get(i2);
        sj sjVar2 = (sj) arrayList4.get(i3 - 1);
        if (i7 == sjVar.g()) {
            int iIntValue = ((Number) arrayList5.get(i2)).intValue();
            int i9 = i2 + 1;
            sj sjVar3 = (sj) arrayList4.get(i9);
            i4 = i9;
            i5 = iIntValue;
            sjVar = sjVar3;
        } else {
            i4 = i2;
            i5 = -1;
        }
        if (sjVar.j(i7) == sjVar2.j(i7)) {
            int iMin = Math.min(sjVar.g(), sjVar2.g());
            int i10 = 0;
            for (int i11 = i7; i11 < iMin && sjVar.j(i11) == sjVar2.j(i11); i11++) {
                i10++;
            }
            long j3 = 4;
            long j4 = (rhVar.b / j3) + j + ((long) 2) + ((long) i10) + 1;
            rhVar.ap(-i10);
            rhVar.ap(i5);
            int i12 = i7 + i10;
            while (i7 < i12) {
                rhVar.ap(sjVar.j(i7) & Opcodes.CONST_METHOD_TYPE);
                i7++;
            }
            if (i4 + 1 == i3) {
                if (i12 != ((sj) arrayList4.get(i4)).g()) {
                    throw new IllegalStateException("Check failed.");
                }
                rhVar.ap(((Number) arrayList5.get(i4)).intValue());
                return;
            } else {
                rh rhVar2 = new rh();
                rhVar.ap(((int) ((rhVar2.b / j3) + j4)) * (-1));
                af(j4, rhVar2, i12, arrayList4, i4, i3, arrayList5);
                rhVar.r(rhVar2);
                return;
            }
        }
        int i13 = 1;
        for (int i14 = i4 + 1; i14 < i3; i14++) {
            if (((sj) arrayList4.get(i14 - 1)).j(i7) != ((sj) arrayList4.get(i14)).j(i7)) {
                i13++;
            }
        }
        long j5 = 4;
        long j6 = (rhVar.b / j5) + j + ((long) 2) + ((long) (i13 * 2));
        rhVar.ap(i13);
        rhVar.ap(i5);
        for (int i15 = i4; i15 < i3; i15++) {
            int iJ = ((sj) arrayList4.get(i15)).j(i7);
            if (i15 == i4 || iJ != ((sj) arrayList4.get(i15 - 1)).j(i7)) {
                rhVar.ap(iJ & Opcodes.CONST_METHOD_TYPE);
            }
        }
        rh rhVar3 = new rh();
        int i16 = i4;
        while (i16 < i3) {
            byte bJ = ((sj) arrayList4.get(i16)).j(i7);
            int i17 = i16 + 1;
            int i18 = i17;
            while (true) {
                if (i18 >= i3) {
                    i18 = i3;
                    break;
                } else if (bJ != ((sj) arrayList4.get(i18)).j(i7)) {
                    break;
                } else {
                    i18++;
                }
            }
            if (i17 == i18 && i7 + 1 == ((sj) arrayList4.get(i16)).g()) {
                rhVar.ap(((Number) arrayList5.get(i16)).intValue());
                arrayList3 = arrayList5;
                j2 = j6;
                i6 = i18;
            } else {
                rhVar.ap(((int) ((rhVar3.b / j5) + j6)) * (-1));
                arrayList3 = arrayList5;
                j2 = j6;
                i6 = i18;
                af(j2, rhVar3, i7 + 1, arrayList, i16, i6, arrayList3);
                arrayList4 = arrayList;
            }
            j6 = j2;
            i16 = i6;
            arrayList5 = arrayList3;
        }
        rhVar.r(rhVar3);
    }

    public static byte[] ag(amr[] amrVarArr, byte[] bArr) throws IOException {
        int i = 0;
        int length = 0;
        for (amr amrVar : amrVarArr) {
            length += ((((amrVar.g * 2) + 7) & (-8)) / 8) + (amrVar.e * 2)
                    + al(amrVar.a, amrVar.b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + amrVar.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, ewz.t)) {
            int length2 = amrVarArr.length;
            while (i < length2) {
                amr amrVar2 = amrVarArr[i];
                bh(byteArrayOutputStream, amrVar2, al(amrVar2.a, amrVar2.b, bArr));
                bg(byteArrayOutputStream, amrVar2);
                i++;
            }
        } else {
            for (amr amrVar3 : amrVarArr) {
                bh(byteArrayOutputStream, amrVar3, al(amrVar3.a, amrVar3.b, bArr));
            }
            int length3 = amrVarArr.length;
            while (i < length3) {
                bg(byteArrayOutputStream, amrVarArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual="
                + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static final csv ah(Class cls, List list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(abb.ak(list, 10));
            Iterator it = list.iterator();
            if (it.hasNext()) {
                throw yg.d(it);
            }
            return new csv(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(abb.ak(list, 10));
            Iterator it2 = list.iterator();
            if (it2.hasNext()) {
                throw yg.d(it2);
            }
            return new csv(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        csv csvVarAh = ah(declaringClass, list.subList(length, list.size()));
        List listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(abb.ak(listSubList, 10));
        Iterator it3 = listSubList.iterator();
        if (it3.hasNext()) {
            throw yg.d(it3);
        }
        return new csv(cls, csvVarAh, arrayList3);
    }

    public static eum ai(adq adqVar, int i, ArrayList arrayList, eum eumVar) {
        int i2;
        int i3 = i == 0 ? adqVar.bx : adqVar.by;
        if (i3 != -1 && (eumVar == null || i3 != eumVar.c)) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                eum eumVar2 = (eum) arrayList.get(i4);
                if (eumVar2.c == i3) {
                    if (eumVar != null) {
                        eumVar.i(i, eumVar2);
                        arrayList.remove(eumVar);
                    }
                    eumVar = eumVar2;
                    break;
                }
            }
        } else if (i3 != -1) {
            return eumVar;
        }
        if (eumVar == null) {
            if (adqVar instanceof bkw) {
                bkw bkwVar = (bkw) adqVar;
                int i5 = 0;
                while (true) {
                    if (i5 >= bkwVar.ew) {
                        i2 = -1;
                        break;
                    }
                    adq adqVar2 = bkwVar.ev[i5];
                    if ((i == 0 && (i2 = adqVar2.bx) != -1) || (i == 1 && (i2 = adqVar2.by) != -1)) {
                        break;
                    }
                    i5++;
                }
                if (i2 != -1) {
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        eum eumVar3 = (eum) arrayList.get(i6);
                        if (eumVar3.c == i2) {
                            eumVar = eumVar3;
                            break;
                        }
                    }
                }
            }
            if (eumVar == null) {
                eumVar = new eum();
                eumVar.b = new ArrayList();
                eumVar.e = null;
                eumVar.f = -1;
                int i7 = eum.a;
                eum.a = i7 + 1;
                eumVar.c = i7;
                eumVar.d = i;
            }
            arrayList.add(eumVar);
        }
        int i8 = eumVar.c;
        ArrayList arrayList2 = eumVar.b;
        if (arrayList2.contains(adqVar)) {
            return eumVar;
        }
        arrayList2.add(adqVar);
        if (adqVar instanceof bjp) {
            bjp bjpVar = (bjp) adqVar;
            bjpVar.d.l(bjpVar.i == 0 ? 1 : 0, arrayList, eumVar);
        }
        if (i == 0) {
            adqVar.bx = i8;
            adqVar.as.l(i, arrayList, eumVar);
            adqVar.au.l(i, arrayList, eumVar);
        } else {
            adqVar.by = i8;
            adqVar.at.l(i, arrayList, eumVar);
            adqVar.aw.l(i, arrayList, eumVar);
            adqVar.av.l(i, arrayList, eumVar);
        }
        adqVar.az.l(i, arrayList, eumVar);
        return eumVar;
    }

    public static final void aj(DexDescData amnVar, DexKitBridge dexKitBridge, IInvokable bgfVar) {
        Object objX;
        String str;
        String str2;
        DefaultConfig ioVar;
        FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = new FindDexClassMethodDslWrapper(dexKitBridge, amnVar);
        bgfVar.invoke(findDexClassMethodDslWrapperVar);
        try {
            IInvokable bgfVar2 = findDexClassMethodDslWrapperVar.onClassCallback;
            if (bgfVar2 != null && findDexClassMethodDslWrapperVar.onMethodCallback != null) {
                bag bagVar = new bag();
                bgfVar2.invoke(bagVar);
                yu yuVar = (yu) dexKitBridge.e(bagVar).a();
                IInvokable bgfVar3 = findDexClassMethodDslWrapperVar.onMethodCallback;
                throwIfVar1IsNull(bgfVar3);
                bah bahVar = new bah();
                bgfVar3.invoke(bahVar);
                yuVar.getClass();
                bahVar.b = dqc.toSingletonList(yuVar);
                cdg cdgVarF = yuVar.a.f(bahVar);
                IInvokable bgfVar4 = findDexClassMethodDslWrapperVar.onResultCallback;
                str = ((cdf) (bgfVar4 != null ? cdgVarF.b(bgfVar4) : cdgVarF.a())).f;
            } else if (bgfVar2 != null) {
                bag bagVar2 = new bag();
                bgfVar2.invoke(bagVar2);
                str = ((yu) dexKitBridge.e(bagVar2).a()).f;
            } else {
                IInvokable bgfVar5 = findDexClassMethodDslWrapperVar.onMethodCallback;
                if (bgfVar5 == null) {
                    throw new IllegalArgumentException(amnVar.b.concat(" FindDexClassMethod Config Failed" /*
                                                                                                            * cnb.z(-
                                                                                                            * 82768314759978L)
                                                                                                            */));
                }
                bah bahVar2 = new bah();
                bgfVar5.invoke(bahVar2);
                cdg cdgVarF2 = dexKitBridge.f(bahVar2);
                IInvokable bgfVar6 = findDexClassMethodDslWrapperVar.onResultCallback;
                str = ((cdf) (bgfVar6 != null ? cdgVarF2.b(bgfVar6) : cdgVarF2.a())).f;
            }
            str2 = (String) amnVar.c.getValue();
            ioVar = emc.w;
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (ioVar == null) {
            throw new IllegalArgumentException("DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* "DexDescConfig must be init" /* cnb.z(-6021544147754L)   */.toString());
        }
        ioVar.aj().putString(str2, str);
        objX = KotlinUnit.INSTANCE;
        if (dcy.b(objX) != null) {
            ArrayList arrayList = ewq.a;
            String strConcat = amnVar.b.concat(" FindDexClassMethod Failed" /* " FindDexClassMethod Failed" /* " FindDexClassMethod Failed" /* " FindDexClassMethod Failed" /* cnb.z(-79821967194922L)   */);
            ro.a.getClass();
            ewq.e(strConcat, null, 12);
        }
    }

    public static cdf ak(DexKitBridge dexKitBridge, c cVar) {
        throwIfVar1IsNull(dexKitBridge, "bridge");
        int iG = cVar.g(10);
        int i = iG != 0 ? cVar.b.getInt(iG + cVar.a) : 0;
        if ((i & 131072) > 0) {
            i = (i ^ 131072) | 32;
        }
        int i2 = i;
        int iG2 = cVar.g(4);
        int i3 = iG2 != 0 ? cVar.b.getInt(iG2 + cVar.a) : 0;
        int iG3 = cVar.g(6);
        int i4 = iG3 != 0 ? cVar.b.getInt(iG3 + cVar.a) : 0;
        int iG4 = cVar.g(8);
        int i5 = iG4 != 0 ? cVar.b.getInt(iG4 + cVar.a) : 0;
        int iG5 = cVar.g(12);
        String strI = iG5 != 0 ? cVar.i(iG5 + cVar.a) : null;
        if (strI == null) {
            strI = "";
        }
        String str = strI;
        int iG6 = cVar.g(14);
        int i6 = iG6 != 0 ? cVar.b.getInt(iG6 + cVar.a) : 0;
        ArrayList arrayList = new ArrayList();
        int iG7 = cVar.g(16);
        int iK = iG7 != 0 ? cVar.k(iG7) : 0;
        for (int i7 = 0; i7 < iK; i7++) {
            int iG8 = cVar.g(16);
            arrayList.add(Integer.valueOf(iG8 != 0 ? cVar.b.getInt((i7 * 4) + cVar.j(iG8)) : 0));
        }
        return new cdf(dexKitBridge, i3, i4, i5, i2, str, i6, arrayList);
    }

    public static String al(String str, String str2, byte[] bArr) {
        byte[] bArr2 = ewz.u;
        byte[] bArr3 = ewz.v;
        String str3 = (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return yg.concatToVar1(dkz.y(str), (Arrays.equals(bArr, bArr3) || Arrays.equals(bArr, bArr2)) ? ":" : "!", str2);
            }
        }
        return str2;
    }

    public static final Type am(eme emeVar) {
        Class clsBd = cnf.getJavaClass(emeVar.a);
        List list = Collections.EMPTY_LIST;
        if (!list.isEmpty()) {
            if (!clsBd.isArray()) {
                return ah(clsBd, list);
            }
            if (!clsBd.getComponentType().isPrimitive()) {
                if (aaz.s(list) != null) {
                    throw new ClassCastException();
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + emeVar);
            }
        }
        return clsBd;
    }

    public static final LayoutInflater an(Context context) {
        LayoutInflater layoutInflater = context instanceof Activity ? ((Activity) context).getLayoutInflater()
                : LayoutInflater.from(context);
        if (layoutInflater != null) {
            return layoutInflater;
        }
        throw new IllegalStateException("Cannot get LayoutInflater from context.");
    }

    public static crv ao(sj... sjVarArr) {
        int i;
        int i2 = 0;
        if (sjVarArr.length == 0) {
            return new crv(new sj[0], new int[] { 0, -1 });
        }
        ArrayList arrayList = new ArrayList(new kk(sjVarArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(sjVarArr.length);
        for (sj sjVar : sjVarArr) {
            arrayList2.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList2.toArray(new Integer[0]);
        ArrayList arrayListAh = OtherStaticHelpers.ah(Arrays.copyOf(numArr, numArr.length));
        int length = sjVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            sj sjVar2 = sjVarArr[i3];
            int i5 = i4 + 1;
            int size = arrayList.size();
            int size2 = arrayList.size();
            if (size < 0) {
                throw new IllegalArgumentException(yg.f(size, "fromIndex (0) is greater than toIndex (", ")."));
            }
            if (size > size2) {
                throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
            }
            int i6 = size - 1;
            int i7 = 0;
            while (true) {
                if (i7 > i6) {
                    i = -(i7 + 1);
                    break;
                }
                i = (i7 + i6) >>> 1;
                int iJ = ajn.j((Comparable) arrayList.get(i), sjVar2);
                if (iJ >= 0) {
                    if (iJ <= 0) {
                        break;
                    }
                    i6 = i - 1;
                } else {
                    i7 = i + 1;
                }
            }
            arrayListAh.set(i, Integer.valueOf(i4));
            i3++;
            i4 = i5;
        }
        if (((sj) arrayList.get(0)).g() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i8 = 0;
        while (i8 < arrayList.size()) {
            sj sjVar3 = (sj) arrayList.get(i8);
            int i9 = i8 + 1;
            int i10 = i9;
            while (i10 < arrayList.size()) {
                sj sjVar4 = (sj) arrayList.get(i10);
                sjVar4.getClass();
                throwIfVar1IsNull(sjVar3, "prefix");
                if (!sjVar4.k(sjVar3, sjVar3.g())) {
                    break;
                }
                if (sjVar4.g() == sjVar3.g()) {
                    throw new IllegalArgumentException(("duplicate option: " + sjVar4).toString());
                }
                if (((Number) arrayListAh.get(i10)).intValue() > ((Number) arrayListAh.get(i8)).intValue()) {
                    arrayList.remove(i10);
                    arrayListAh.remove(i10);
                } else {
                    i10++;
                }
            }
            i8 = i9;
        }
        rh rhVar = new rh();
        af(0L, rhVar, 0, arrayList, 0, arrayList.size(), arrayListAh);
        int[] iArr = new int[(int) (rhVar.b / ((long) 4))];
        while (!rhVar.i()) {
            iArr[i2] = rhVar.readInt();
            i2++;
        }
        Object[] objArrCopyOf = Arrays.copyOf(sjVarArr, sjVarArr.length);
        throwIfVar1IsNull(objArrCopyOf, "copyOf(this, size)");
        return new crv((sj[]) objArrCopyOf, iArr);
    }

    public static int[] ap(ByteArrayInputStream byteArrayInputStream, int i) {
        int[] iArr = new int[i];
        int iAt = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iAt += (int) ewz.at(byteArrayInputStream, 2);
            iArr[i2] = iAt;
        }
        return iArr;
    }

    public static amr[] aq(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, amr[] amrVarArr)
            throws IOException {
        byte[] bArr3 = ewz.w;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, ewz.x)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iAt = (int) ewz.at(fileInputStream, 2);
            byte[] bArrAs = ewz.as(fileInputStream, (int) ewz.at(fileInputStream, 4), (int) ewz.at(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrAs);
            try {
                amr[] amrVarArrAs = as(byteArrayInputStream, bArr2, iAt, amrVarArr);
                byteArrayInputStream.close();
                return amrVarArrAs;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(ewz.r, bArr2)) {
            throw new IllegalStateException(
                    "Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iAt2 = (int) ewz.at(fileInputStream, 1);
        byte[] bArrAs2 = ewz.as(fileInputStream, (int) ewz.at(fileInputStream, 4), (int) ewz.at(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrAs2);
        try {
            amr[] amrVarArrAr = ar(byteArrayInputStream2, iAt2, amrVarArr);
            byteArrayInputStream2.close();
            return amrVarArrAr;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static amr[] ar(ByteArrayInputStream byteArrayInputStream, int i, amr[] amrVarArr) {
        if (byteArrayInputStream.available() == 0) {
            return new amr[0];
        }
        if (i != amrVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iAt = (int) ewz.at(byteArrayInputStream, 2);
            iArr[i2] = (int) ewz.at(byteArrayInputStream, 2);
            strArr[i2] = new String(ewz.ar(byteArrayInputStream, iAt), StandardCharsets.UTF_8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            amr amrVar = amrVarArr[i3];
            if (!amrVar.b.equals(strArr[i3])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            amrVar.e = i4;
            amrVar.h = ap(byteArrayInputStream, i4);
        }
        return amrVarArr;
    }

    public static amr[] as(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, amr[] amrVarArr)
            throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new amr[0];
        }
        if (i != amrVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            ewz.at(byteArrayInputStream, 2);
            String str = new String(ewz.ar(byteArrayInputStream, (int) ewz.at(byteArrayInputStream, 2)),
                    StandardCharsets.UTF_8);
            long jAt = ewz.at(byteArrayInputStream, 4);
            int iAt = (int) ewz.at(byteArrayInputStream, 2);
            amr amrVar = null;
            if (amrVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i3 = 0; i3 < amrVarArr.length; i3++) {
                    if (amrVarArr[i3].b.equals(strSubstring)) {
                        amrVar = amrVarArr[i3];
                        break;
                    }
                }
            }
            if (amrVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            amrVar.d = jAt;
            int[] iArrAp = ap(byteArrayInputStream, iAt);
            if (Arrays.equals(bArr, ewz.v)) {
                amrVar.e = iAt;
                amrVar.h = iArrAp;
            }
        }
        return amrVarArr;
    }

    public static amr[] at(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, ewz.s)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iAt = (int) ewz.at(fileInputStream, 1);
        byte[] bArrAs = ewz.as(fileInputStream, (int) ewz.at(fileInputStream, 4), (int) ewz.at(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrAs);
        try {
            amr[] amrVarArrAv = av(byteArrayInputStream, str, iAt);
            byteArrayInputStream.close();
            return amrVarArrAv;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static int au(sg sgVar, int i) {
        int i2 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((sgVar.readByte() & 255) << 24);
        }
        return i2 >> ((3 - i) * 8);
    }

    public static amr[] av(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new amr[0];
        }
        amr[] amrVarArr = new amr[i];
        for (int i3 = 0; i3 < i; i3++) {
            int iAt = (int) ewz.at(byteArrayInputStream, 2);
            int iAt2 = (int) ewz.at(byteArrayInputStream, 2);
            amrVarArr[i3] = new amr(str, new String(ewz.ar(byteArrayInputStream, iAt), StandardCharsets.UTF_8),
                    ewz.at(byteArrayInputStream, 4), iAt2, (int) ewz.at(byteArrayInputStream, 4),
                    (int) ewz.at(byteArrayInputStream, 4), new int[iAt2], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i) {
            amr amrVar = amrVarArr[i4];
            int iAvailable = byteArrayInputStream.available();
            int i5 = amrVar.f;
            int i6 = amrVar.g;
            TreeMap treeMap = amrVar.i;
            int i7 = iAvailable - i5;
            int iAt3 = i2;
            while (byteArrayInputStream.available() > i7) {
                iAt3 += (int) ewz.at(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(iAt3), 1);
                int iAt4 = (int) ewz.at(byteArrayInputStream, 2);
                while (iAt4 > 0) {
                    ewz.at(byteArrayInputStream, 2);
                    int iAt5 = (int) ewz.at(byteArrayInputStream, 1);
                    if (iAt5 != 6 && iAt5 != 7) {
                        while (iAt5 > 0) {
                            ewz.at(byteArrayInputStream, 1);
                            int i8 = i2;
                            int i9 = i4;
                            for (int iAt6 = (int) ewz.at(byteArrayInputStream, 1); iAt6 > 0; iAt6--) {
                                ewz.at(byteArrayInputStream, 2);
                            }
                            iAt5--;
                            i2 = i8;
                            i4 = i9;
                        }
                    }
                    iAt4--;
                    i2 = i2;
                    i4 = i4;
                }
            }
            int i10 = i2;
            int i11 = i4;
            if (byteArrayInputStream.available() != i7) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            amrVar.h = ap(byteArrayInputStream, amrVar.e);
            BitSet bitSetValueOf = BitSet.valueOf(ewz.ar(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i12 = i10; i12 < i6; i12++) {
                int i13 = bitSetValueOf.get(i12) ? 2 : i10;
                if (bitSetValueOf.get(i12 + i6)) {
                    i13 |= 4;
                }
                if (i13 != 0) {
                    Integer numValueOf = (Integer) treeMap.get(Integer.valueOf(i12));
                    if (numValueOf == null) {
                        numValueOf = Integer.valueOf(i10);
                    }
                    treeMap.put(Integer.valueOf(i12), Integer.valueOf(i13 | numValueOf.intValue()));
                }
            }
            i4 = i11 + 1;
            i2 = i10;
        }
        return amrVarArr;
    }

    public static int aw(sg sgVar, int i, boolean z2) {
        int i2 = 0;
        if (z2) {
            while (i >= 0) {
                i2 = ((sgVar.readByte() & 255) << 24) | (i2 >>> 8);
                i--;
            }
            return i2;
        }
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((sgVar.readByte() & 255) << 24);
        }
        return i2 >>> ((3 - i) * 8);
    }

    public static void ax(Context context) {
        cnf.bh(context);
        dgi dgiVar = new dgi(context);
        or orVar = new or();
        orVar.b = dgiVar;
        bfp bfpVar = new bfp();
        bfpVar.bb = anj.e;
        bfpVar.bc = -1.0f;
        bfpVar.bd = true;
        bfpVar.bf = bfpVar;
        bfpVar.ba = orVar;
        bfpVar.am();
        if (bfpVar.ar() != null) {
            ng.ak(bfpVar.ar());
            return;
        }
        View viewAn = bfpVar.an(bfpVar.aq(bfpVar.ax()) != 0 ? bfpVar.aq(bfpVar.ax())
                : bfpVar.ax() ? R.layout.layout_dialogx_fullscreen : R.layout.layout_dialogx_fullscreen_dark);
        bfpVar.bg = new bfo(bfpVar, viewAn);
        if (viewAn != null) {
            viewAn.setTag(bfpVar);
        }
        ng.ak(viewAn);
    }

    public static Class ay(String str) {
        Object objX;
        String str2 = "[" + str + "][" + ((Object) null) + "]";
        LinkedHashMap linkedHashMap = dan.a;
        Class cls = (Class) linkedHashMap.get(str2);
        if (cls != null) {
            return cls;
        }
        try {
            ki.a.getClass();
            objX = Class.forName(str, false, ki.g());
            linkedHashMap.put(str2, objX);
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        Class cls2 = (Class) (objX instanceof dcx ? null : objX);
        if (cls2 != null) {
            return cls2;
        }
        ki.a.getClass();
        ClassLoader classLoaderG = ki.g();
        String[] strArr = { concat("name:[", str, "]") };
        for (int i = 0; i != 30; i++) {
        }
        String str3 = strArr[0];
        throw new NoClassDefFoundError("Can't find this Class in [" + classLoaderG + "]:\n"
                + ((Object) (dnj.ak(str3) ? "name:[" : "name:[  -> " + str3 + "\n"))
                + "Generated by YukiHookAPI#ReflectionTool");
    }

    public static final Class az(DexDescData amnVar) throws NoSuchMethodException {
        Object objX;
        try {
            String strF = ams.f(amnVar.d());
            bmo.a.getClass();
            objX = bpv.c(bmo.getClassLoader(), strF);
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (dcy.b(objX) == null) {
            return (Class) objX;
        }
        ArrayList arrayList = ewq.a;
        String strConcat = amnVar.b.concat(" toDexClass Failed" /* " toDexClass Failed" /* " toDexClass Failed" /* " toDexClass Failed" /* cnb.z(-79740362816298L)   */);
        ro.a.getClass();
        ewq.e(strConcat, null, 12);
        throw new NoSuchMethodException(amnVar.b.concat(" toDexClass Failed" /* " toDexClass Failed" /* " toDexClass Failed" /* " toDexClass Failed" /* cnb.z(-80225694120746L)   */));
    }

    public static final Constructor ba(DexDescData amnVar) throws NoSuchMethodException {
        Object objX;
        try {
            amq amqVar = new amq(amnVar.d());
            bmo.a.getClass();
            objX = amqVar.g(bmo.getClassLoader());
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (dcy.b(objX) == null) {
            return (Constructor) objX;
        }
        ArrayList arrayList = ewq.a;
        String strConcat = amnVar.b.concat(" toDexConstructor Failed" /* " toDexConstructor Failed" /* " toDexConstructor Failed" /* " toDexConstructor Failed" /* cnb.z(-79388175498026L)   */);
        ro.a.getClass();
        ewq.e(strConcat, null, 12);
        throw new NoSuchMethodException(amnVar.b.concat(" toDexConstructor Failed" /* " toDexConstructor Failed" /* " toDexConstructor Failed" /* " toDexConstructor Failed" /* cnb.z(-79280801315626L)   */));
    }

    public static final Method bb(DexDescData amnVar) throws NoSuchMethodException {
        Object objX;
        try {
            amq amqVar = new amq(amnVar.d());
            bmo.a.getClass();
            objX = amq.f(amqVar, bmo.getClassLoader());
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (dcy.b(objX) == null) {
            return (Method) objX;
        }
        ArrayList arrayList = ewq.a;
        String strConcat = amnVar.b.concat(" toDexMethod Failed" /* " toDexMethod Failed" /* " toDexMethod Failed" /* " toDexMethod Failed" /* cnb.z(-80109730003754L)   */);
        ro.a.getClass();
        ewq.e(strConcat, null, 12);
        throw new NoSuchMethodException(amnVar.b.concat(" toDexMethod Failed" /* " toDexMethod Failed" /* " toDexMethod Failed" /* " toDexMethod Failed" /* cnb.z(-80058190396202L)   */));
    }

    public static final void bc(DexDescData amnVar, IInvokable bgfVar) {
        bgfVar.invoke(bb(amnVar));
    }

    public static final Class bd(Class cls) {
        boolean zF = nullSafeIsEqual(cls, KotlinUnit.class);
        Class cls2 = Void.TYPE;
        if (!zF && !nullSafeIsEqual(cls, Void.class)) {
            if (!nullSafeIsEqual(cls, cls2 == null ? ay("void") : cls2)) {
                boolean zF2 = nullSafeIsEqual(cls, Boolean.class);
                Class cls3 = Boolean.TYPE;
                if (!zF2) {
                    if (!nullSafeIsEqual(cls, cls3 == null ? ay("boolean") : cls3)) {
                        boolean zF3 = nullSafeIsEqual(cls, Integer.class);
                        Class cls4 = Integer.TYPE;
                        if (!zF3) {
                            if (!nullSafeIsEqual(cls, cls4 == null ? ay("int") : cls4)) {
                                boolean zF4 = nullSafeIsEqual(cls, Float.class);
                                Class cls5 = Float.TYPE;
                                if (!zF4) {
                                    if (!nullSafeIsEqual(cls, cls5 == null ? ay("float") : cls5)) {
                                        boolean zF5 = nullSafeIsEqual(cls, Double.class);
                                        Class cls6 = Double.TYPE;
                                        if (!zF5) {
                                            if (!nullSafeIsEqual(cls, cls6 == null ? ay("double") : cls6)) {
                                                boolean zF6 = nullSafeIsEqual(cls, Long.class);
                                                Class cls7 = Long.TYPE;
                                                if (!zF6) {
                                                    if (!nullSafeIsEqual(cls, cls7 == null ? ay("long") : cls7)) {
                                                        boolean zF7 = nullSafeIsEqual(cls, Short.class);
                                                        Class cls8 = Short.TYPE;
                                                        if (!zF7) {
                                                            if (!nullSafeIsEqual(cls,
                                                                    cls8 == null ? ay("short") : cls8)) {
                                                                boolean zF8 = nullSafeIsEqual(cls, Character.class);
                                                                Class cls9 = Character.TYPE;
                                                                if (!zF8) {
                                                                    if (!nullSafeIsEqual(cls,
                                                                            cls9 == null ? ay("char") : cls9)) {
                                                                        boolean zF9 = nullSafeIsEqual(cls, Byte.class);
                                                                        Class cls10 = Byte.TYPE;
                                                                        if (!zF9) {
                                                                            if (!nullSafeIsEqual(cls,
                                                                                    cls10 == null ? ay("byte")
                                                                                            : cls10)) {
                                                                                return cls;
                                                                            }
                                                                        }
                                                                        return cls10 == null ? ay("byte") : cls10;
                                                                    }
                                                                }
                                                                return cls9 == null ? ay("char") : cls9;
                                                            }
                                                        }
                                                        return cls8 == null ? ay("short") : cls8;
                                                    }
                                                }
                                                return cls7 == null ? ay("long") : cls7;
                                            }
                                        }
                                        return cls6 == null ? ay("double") : cls6;
                                    }
                                }
                                return cls5 == null ? ay("float") : cls5;
                            }
                        }
                        return cls4 == null ? ay("int") : cls4;
                    }
                }
                return cls3 == null ? ay("boolean") : cls3;
            }
        }
        return cls2 == null ? ay("void") : cls2;
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough
     * terminus for handler TryEdge: [PREMATURE_EXIT B:158:0x010f -> B:42:0x0138] -
     * Handler: None
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:419)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    public static boolean be(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, amr[] amrVarArr)
            throws IOException {
        long j;
        int length;
        byte[] bArr2 = ewz.v;
        byte[] bArr3 = ewz.u;
        byte[] bArr4 = ewz.r;
        int i = 0;
        if (Arrays.equals(bArr, bArr4)) {
            ArrayList arrayList = new ArrayList(3);
            ArrayList arrayList2 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ewz.az(byteArrayOutputStream2, amrVarArr.length);
                int i2 = 2;
                int i3 = 2;
                for (amr amrVar : amrVarArr) {
                    ewz.ay(byteArrayOutputStream2, amrVar.c, 4);
                    ewz.ay(byteArrayOutputStream2, amrVar.d, 4);
                    ewz.ay(byteArrayOutputStream2, amrVar.g, 4);
                    String strAl = al(amrVar.a, amrVar.b, bArr4);
                    Charset charset = StandardCharsets.UTF_8;
                    int length2 = strAl.getBytes(charset).length;
                    ewz.az(byteArrayOutputStream2, length2);
                    i3 = i3 + 14 + length2;
                    byteArrayOutputStream2.write(strAl.getBytes(charset));
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                if (i3 != byteArray.length) {
                    throw new IllegalStateException(
                            "Expected size " + i3 + ", does not match actual size " + byteArray.length);
                }
                ewe eweVar = new ewe(byteArray, 1, false);
                byteArrayOutputStream2.close();
                arrayList.add(eweVar);
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                int i4 = 0;
                int i5 = 0;
                while (i4 < amrVarArr.length) {
                    try {
                        amr amrVar2 = amrVarArr[i4];
                        ewz.az(byteArrayOutputStream3, i4);
                        ewz.az(byteArrayOutputStream3, amrVar2.e);
                        i5 = i5 + 4 + (amrVar2.e * i2);
                        int[] iArr = amrVar2.h;
                        int length3 = iArr.length;
                        int i6 = i;
                        int i7 = i2;
                        int i8 = i6;
                        while (i8 < length3) {
                            int i9 = iArr[i8];
                            ewz.az(byteArrayOutputStream3, i9 - i6);
                            i8++;
                            i6 = i9;
                        }
                        i4++;
                        i2 = i7;
                        i = 0;
                    } catch (Throwable th) {
                        try {
                            byteArrayOutputStream3.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                }
                byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                if (i5 != byteArray2.length) {
                    throw new IllegalStateException(
                            "Expected size " + i5 + ", does not match actual size " + byteArray2.length);
                }
                ewe eweVar2 = new ewe(byteArray2, 3, true);
                byteArrayOutputStream3.close();
                arrayList.add(eweVar2);
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                int i10 = 0;
                int i11 = 0;
                while (i10 < amrVarArr.length) {
                    try {
                        amr amrVar3 = amrVarArr[i10];
                        Iterator it = amrVar3.i.entrySet().iterator();
                        int iIntValue = 0;
                        while (it.hasNext()) {
                            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
                        }
                        ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
                        try {
                            bi(byteArrayOutputStream5, iIntValue, amrVar3);
                            byte[] byteArray3 = byteArrayOutputStream5.toByteArray();
                            byteArrayOutputStream5.close();
                            ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                            try {
                                bj(byteArrayOutputStream6, amrVar3);
                                byte[] byteArray4 = byteArrayOutputStream6.toByteArray();
                                byteArrayOutputStream6.close();
                                ewz.az(byteArrayOutputStream4, i10);
                                int length4 = byteArray3.length + 2 + byteArray4.length;
                                int i12 = i11 + 6;
                                int i13 = i10;
                                ewz.ay(byteArrayOutputStream4, length4, 4);
                                ewz.az(byteArrayOutputStream4, iIntValue);
                                byteArrayOutputStream4.write(byteArray3);
                                byteArrayOutputStream4.write(byteArray4);
                                i11 = i12 + length4;
                                i10 = i13 + 1;
                            } catch (Throwable th3) {
                                try {
                                    byteArrayOutputStream6.close();
                                    throw th3;
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                byteArrayOutputStream5.close();
                                throw th5;
                            } catch (Throwable th6) {
                                th5.addSuppressed(th6);
                                throw th5;
                            }
                        }
                    } catch (Throwable th7) {
                        try {
                            byteArrayOutputStream4.close();
                            throw th7;
                        } catch (Throwable th8) {
                            th7.addSuppressed(th8);
                            throw th7;
                        }
                    }
                }
                byte[] byteArray5 = byteArrayOutputStream4.toByteArray();
                if (i11 != byteArray5.length) {
                    throw new IllegalStateException(
                            "Expected size " + i11 + ", does not match actual size " + byteArray5.length);
                }
                ewe eweVar3 = new ewe(byteArray5, 4, true);
                byteArrayOutputStream4.close();
                arrayList.add(eweVar3);
                long j2 = 4;
                long size = j2 + j2 + 4 + ((long) (arrayList.size() * 16));
                ewz.ay(byteArrayOutputStream, arrayList.size(), 4);
                for (int i14 = 0; i14 < arrayList.size(); i14++) {
                    ewe eweVar4 = (ewe) arrayList.get(i14);
                    int i15 = eweVar4.a;
                    byte[] bArr5 = eweVar4.b;
                    if (i15 == 1) {
                        j = 0;
                    } else if (i15 == 2) {
                        j = 1;
                    } else if (i15 == 3) {
                        j = 2;
                    } else if (i15 == 4) {
                        j = 3;
                    } else {
                        if (i15 != 5) {
                            throw null;
                        }
                        j = 4;
                    }
                    ewz.ay(byteArrayOutputStream, j, 4);
                    ewz.ay(byteArrayOutputStream, size, 4);
                    if (eweVar4.c) {
                        long length5 = bArr5.length;
                        byte[] bArrAc = ewz.ac(bArr5);
                        arrayList2.add(bArrAc);
                        ewz.ay(byteArrayOutputStream, bArrAc.length, 4);
                        ewz.ay(byteArrayOutputStream, length5, 4);
                        length = bArrAc.length;
                    } else {
                        arrayList2.add(bArr5);
                        ewz.ay(byteArrayOutputStream, bArr5.length, 4);
                        ewz.ay(byteArrayOutputStream, 0L, 4);
                        length = bArr5.length;
                    }
                    size += (long) length;
                }
                for (int i16 = 0; i16 < arrayList2.size(); i16++) {
                    byteArrayOutputStream.write((byte[]) arrayList2.get(i16));
                }
            } catch (Throwable th9) {
                try {
                    byteArrayOutputStream2.close();
                    throw th9;
                } catch (Throwable th10) {
                    th9.addSuppressed(th10);
                    throw th9;
                }
            }
        } else {
            byte[] bArr6 = ewz.s;
            if (Arrays.equals(bArr, bArr6)) {
                byte[] bArrAg = ag(amrVarArr, bArr6);
                ewz.ay(byteArrayOutputStream, amrVarArr.length, 1);
                ewz.ay(byteArrayOutputStream, bArrAg.length, 4);
                byte[] bArrAc2 = ewz.ac(bArrAg);
                ewz.ay(byteArrayOutputStream, bArrAc2.length, 4);
                byteArrayOutputStream.write(bArrAc2);
                return true;
            }
            if (Arrays.equals(bArr, bArr3)) {
                ewz.ay(byteArrayOutputStream, amrVarArr.length, 1);
                for (amr amrVar4 : amrVarArr) {
                    int size2 = amrVar4.i.size() * 4;
                    String strAl2 = al(amrVar4.a, amrVar4.b, bArr3);
                    Charset charset2 = StandardCharsets.UTF_8;
                    ewz.az(byteArrayOutputStream, strAl2.getBytes(charset2).length);
                    ewz.az(byteArrayOutputStream, amrVar4.h.length);
                    ewz.ay(byteArrayOutputStream, size2, 4);
                    ewz.ay(byteArrayOutputStream, amrVar4.c, 4);
                    byteArrayOutputStream.write(strAl2.getBytes(charset2));
                    Iterator it2 = amrVar4.i.keySet().iterator();
                    while (it2.hasNext()) {
                        ewz.az(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                        ewz.az(byteArrayOutputStream, 0);
                    }
                    for (int i17 : amrVar4.h) {
                        ewz.az(byteArrayOutputStream, i17);
                    }
                }
            } else {
                byte[] bArr7 = ewz.t;
                if (Arrays.equals(bArr, bArr7)) {
                    byte[] bArrAg2 = ag(amrVarArr, bArr7);
                    ewz.ay(byteArrayOutputStream, amrVarArr.length, 1);
                    ewz.ay(byteArrayOutputStream, bArrAg2.length, 4);
                    byte[] bArrAc3 = ewz.ac(bArrAg2);
                    ewz.ay(byteArrayOutputStream, bArrAc3.length, 4);
                    byteArrayOutputStream.write(bArrAc3);
                    return true;
                }
                if (!Arrays.equals(bArr, bArr2)) {
                    return false;
                }
                ewz.az(byteArrayOutputStream, amrVarArr.length);
                for (amr amrVar5 : amrVarArr) {
                    String str = amrVar5.a;
                    TreeMap treeMap = amrVar5.i;
                    String strAl3 = al(str, amrVar5.b, bArr2);
                    Charset charset3 = StandardCharsets.UTF_8;
                    ewz.az(byteArrayOutputStream, strAl3.getBytes(charset3).length);
                    ewz.az(byteArrayOutputStream, treeMap.size());
                    ewz.az(byteArrayOutputStream, amrVar5.h.length);
                    ewz.ay(byteArrayOutputStream, amrVar5.c, 4);
                    byteArrayOutputStream.write(strAl3.getBytes(charset3));
                    Iterator it3 = treeMap.keySet().iterator();
                    while (it3.hasNext()) {
                        ewz.az(byteArrayOutputStream, ((Integer) it3.next()).intValue());
                    }
                    for (int i18 : amrVar5.h) {
                        ewz.az(byteArrayOutputStream, i18);
                    }
                }
            }
        }
        return true;
    }

    public static boolean bf(int i, int i2, int i3, int i4) {
        return (i3 == 1 || i3 == 2 || (i3 == 4 && i != 2)) || (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2));
    }

    public static void bg(ByteArrayOutputStream byteArrayOutputStream, amr amrVar) throws IOException {
        bj(byteArrayOutputStream, amrVar);
        int i = amrVar.g;
        int[] iArr = amrVar.h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            ewz.az(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        byte[] bArr = new byte[(((i * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : amrVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                int i5 = iIntValue / 8;
                bArr[i5] = (byte) (bArr[i5] | (1 << (iIntValue % 8)));
            }
            if ((iIntValue2 & 4) != 0) {
                int i6 = iIntValue + i;
                int i7 = i6 / 8;
                bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void bh(ByteArrayOutputStream byteArrayOutputStream, amr amrVar, String str) throws IOException {
        Charset charset = StandardCharsets.UTF_8;
        ewz.az(byteArrayOutputStream, str.getBytes(charset).length);
        ewz.az(byteArrayOutputStream, amrVar.e);
        ewz.ay(byteArrayOutputStream, amrVar.f, 4);
        ewz.ay(byteArrayOutputStream, amrVar.c, 4);
        ewz.ay(byteArrayOutputStream, amrVar.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void bi(ByteArrayOutputStream byteArrayOutputStream, int i, amr amrVar) throws IOException {
        int i2 = amrVar.g;
        byte[] bArr = new byte[(((Integer.bitCount(i & (-2)) * i2) + 7) & (-8)) / 8];
        for (Map.Entry entry : amrVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i3 = 0;
            for (int i4 = 1; i4 <= 4; i4 <<= 1) {
                if (i4 != 1 && (i4 & i) != 0) {
                    if ((i4 & iIntValue2) == i4) {
                        int i5 = (i3 * i2) + iIntValue;
                        int i6 = i5 / 8;
                        bArr[i6] = (byte) ((1 << (i5 % 8)) | bArr[i6]);
                    }
                    i3++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void bj(ByteArrayOutputStream byteArrayOutputStream, amr amrVar) throws IOException {
        int i = 0;
        for (Map.Entry entry : amrVar.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                ewz.az(byteArrayOutputStream, iIntValue - i);
                ewz.az(byteArrayOutputStream, 0);
                i = iIntValue;
            }
        }
    }

    public static void bk(sh shVar, int i, long j) {
        int iNumberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (iNumberOfTrailingZeros == 0) {
            iNumberOfTrailingZeros = 1;
        }
        int i2 = (iNumberOfTrailingZeros + 7) >> 3;
        long j2 = j >> (64 - (i2 * 8));
        shVar.writeByte(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            shVar.writeByte((byte) j2);
            j2 >>= 8;
            i2--;
        }
    }

    public static void bl(sh shVar, int i, long j) {
        int iNumberOfLeadingZeros = (72 - Long.numberOfLeadingZeros((j >> 63) ^ j)) >> 3;
        shVar.writeByte(i | ((iNumberOfLeadingZeros - 1) << 5));
        while (iNumberOfLeadingZeros > 0) {
            shVar.writeByte((byte) j);
            j >>= 8;
            iNumberOfLeadingZeros--;
        }
    }

    public static void bm(sh shVar, int i, long j) {
        int iNumberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros == 0) {
            iNumberOfLeadingZeros = 1;
        }
        int i2 = (iNumberOfLeadingZeros + 7) >> 3;
        shVar.writeByte(i | ((i2 - 1) << 5));
        while (i2 > 0) {
            shVar.writeByte((byte) j);
            j >>= 8;
            i2--;
        }
    }

    public Typeface _ce(Context context, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public bce _cf(bce[] bceVarArr, int i) {
        new dop(9);
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z2 = (i & 2) != 0;
        bce bceVar = null;
        int i3 = Integer.MAX_VALUE;
        for (bce bceVar2 : bceVarArr) {
            int iAbs = (Math.abs(bceVar2.c - i2) * 2) + (bceVar2.d == z2 ? 0 : 1);
            if (bceVar == null || i3 > iAbs) {
                bceVar = bceVar2;
                i3 = iAbs;
            }
        }
        return bceVar;
    }

    @Override // me.hd.wauxv.obf.esi
    public void d() {
    }

    @Override // me.hd.wauxv.obf.esi
    public void e() {
    }

    public abstract Typeface s(Context context, bcb bcbVar, Resources resources, int i);

    public abstract Typeface t(Context context, bce[] bceVarArr, int i);

    public Typeface u(Context context, Resources resources, int i, String str, int i2) {
        File fileAi = ewz.ai(context);
        if (fileAi == null) {
            return null;
        }
        try {
            if (ewz.ad(fileAi, resources, i)) {
                return Typeface.createFromFile(fileAi.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileAi.delete();
        }
    }
}
