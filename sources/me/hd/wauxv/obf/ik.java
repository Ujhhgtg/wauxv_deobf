package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.widget.ImageView;
import com.alibaba.fastjson2.JSONB;
import com.android.dx.io.Opcodes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ik {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public Object d;

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public ik(int i) {
        this(new byte[i], 0);
        this.a = 5;
    }

    public static ik e(Resources resources, int i, Resources.Theme theme) {
        int next;
        float f;
        int color;
        float f2;
        int i2;
        float f3;
        float f4;
        Shader radialGradient;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.getClass();
        if (!name.equals("gradient")) {
            if (name.equals("selector")) {
                ColorStateList colorStateListC = abh.c(resources, xml, attributeSetAsAttributeSet, theme);
                return new ik(null, colorStateListC, colorStateListC.getDefaultColor());
            }
            throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
        String name2 = xml.getName();
        if (!name2.equals("gradient")) {
            throw new XmlPullParserException(xml.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
        TypedArray typedArrayAv = emc.av(resources, theme, attributeSetAsAttributeSet, cxz.e);
        float f5 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startX") != null
                ? typedArrayAv.getFloat(8, 0.0f)
                : 0.0f;
        float f6 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startY") != null
                ? typedArrayAv.getFloat(9, 0.0f)
                : 0.0f;
        float f7 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endX") != null
                ? typedArrayAv.getFloat(10, 0.0f)
                : 0.0f;
        float f8 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endY") != null
                ? typedArrayAv.getFloat(11, 0.0f)
                : 0.0f;
        float f9 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerX") != null
                ? typedArrayAv.getFloat(3, 0.0f)
                : 0.0f;
        float f10 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerY") != null
                ? typedArrayAv.getFloat(4, 0.0f)
                : 0.0f;
        int i3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android",
                "type") != null ? typedArrayAv.getInt(2, 0) : 0;
        int color2 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "startColor") != null
                ? typedArrayAv.getColor(0, 0)
                : 0;
        boolean z = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null;
        int color3 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "centerColor") != null
                ? typedArrayAv.getColor(7, 0)
                : 0;
        if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "endColor") != null) {
            f = f5;
            color = typedArrayAv.getColor(1, 0);
        } else {
            f = f5;
            color = 0;
        }
        if (xml.getAttributeValue("http://schemas.android.com/apk/res/android", "tileMode") != null) {
            f2 = f6;
            i2 = typedArrayAv.getInt(6, 0);
        } else {
            f2 = f6;
            i2 = 0;
        }
        float f11 = xml.getAttributeValue("http://schemas.android.com/apk/res/android", "gradientRadius") != null
                ? typedArrayAv.getFloat(5, 0.0f)
                : 0.0f;
        typedArrayAv.recycle();
        int depth = xml.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        float f12 = f11;
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next2 = xml.next();
            f3 = f7;
            if (next2 == 1) {
                f4 = f8;
                break;
            }
            int depth2 = xml.getDepth();
            f4 = f8;
            if (depth2 < depth && next2 == 3) {
                break;
            }
            if (next2 == 2 && depth2 <= depth && xml.getName().equals("item")) {
                TypedArray typedArrayAv2 = emc.av(resources, theme, attributeSetAsAttributeSet, cxz.f);
                boolean zHasValue = typedArrayAv2.hasValue(0);
                boolean zHasValue2 = typedArrayAv2.hasValue(1);
                if (!zHasValue || !zHasValue2) {
                    throw new XmlPullParserException(xml.getPositionDescription()
                            + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
                }
                int color4 = typedArrayAv2.getColor(0, 0);
                float f13 = typedArrayAv2.getFloat(1, 0.0f);
                typedArrayAv2.recycle();
                arrayList2.add(Integer.valueOf(color4));
                arrayList.add(Float.valueOf(f13));
            }
            f7 = f3;
            f8 = f4;
        }
        DefaultConfig ioVar = arrayList2.size() > 0 ? new DefaultConfig(arrayList2, arrayList) : null;
        if (ioVar == null) {
            ioVar = z ? new DefaultConfig(color2, color3, color) : new DefaultConfig(color2, color);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                radialGradient = new LinearGradient(f, f2, f3, f4, (int[]) ioVar.c, (float[]) ioVar.d,
                        i2 != 1 ? i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
            } else {
                radialGradient = new SweepGradient(f9, f10, (int[]) ioVar.c, (float[]) ioVar.d);
            }
        } else {
            if (f12 <= 0.0f) {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
            radialGradient = new RadialGradient(f9, f10, f12, (int[]) ioVar.c, (float[]) ioVar.d,
                    i2 != 1 ? i2 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT);
        }
        return new ik(radialGradient, null, 0);
    }

    public static int f(String str) {
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                i2++;
            } else if (cCharAt < 2048) {
                i2 += 2;
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                i2 += 3;
            } else {
                i += 2;
                i2 += 4;
            }
            i = i3;
        }
        return i2;
    }

    public void aa(int i, long j) {
        byte[] bArr = (byte[]) this.d;
        bArr[i] = (byte) j;
        bArr[i + 1] = (byte) (j >> 8);
        bArr[i + 2] = (byte) (j >> 16);
        bArr[i + 3] = (byte) (j >> 24);
        bArr[i + 4] = (byte) (j >> 32);
        bArr[i + 5] = (byte) (j >> 40);
        bArr[i + 6] = (byte) (j >> 48);
        bArr[i + 7] = (byte) (j >> 56);
    }

    public void ab(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        byte[] bArr = (byte[]) this.d;
        int i = this.b;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >>> 6) | 192);
                i += 2;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else if (cCharAt < 55296 || cCharAt > 57343) {
                bArr[i] = (byte) ((cCharAt >>> '\f') | Opcodes.SHL_INT_LIT8);
                int i5 = i + 2;
                bArr[i + 1] = (byte) (((cCharAt >>> 6) & 63) | 128);
                i += 3;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            } else {
                i2 += 2;
                int iCharAt = ((cCharAt << '\n') + str.charAt(i3)) - 56613888;
                bArr[i] = (byte) ((iCharAt >>> 18) | 240);
                bArr[i + 1] = (byte) (((iCharAt >>> 12) & 63) | 128);
                int i6 = i + 3;
                bArr[i + 2] = (byte) (((iCharAt >>> 6) & 63) | 128);
                i += 4;
                bArr[i6] = (byte) ((iCharAt & 63) | 128);
            }
            i2 = i3;
        }
        this.b = i;
    }

    public cba ac(int i) {
        Object next;
        ArrayList arrayList = (ArrayList) this.d;
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((cba) next).a != i);
        cba cbaVar = (cba) next;
        if (cbaVar != null) {
            arrayList.remove(cbaVar);
            arrayList.add(cbaVar);
        }
        return cbaVar;
    }

    public void ad() {
        int i = this.b * 2;
        Object[] objArrCopyOf = Arrays.copyOf((Object[]) this.c, i);
        throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
        this.c = objArrCopyOf;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = -1;
        }
        SomeStaticHelpers._ao((int[]) this.d, 0, 0, 14, iArr);
        this.d = iArr;
    }

    public void g(int i, ArrayList arrayList) {
        ctq ctqVar;
        ArrayList arrayList2 = (ArrayList) this.c;
        Iterator it = arrayList2.iterator();
        do {
            if (!it.hasNext()) {
                ctqVar = null;
                break;
            }
            ctqVar = (ctq) it.next();
        } while (ctqVar.a != i);
        if (ctqVar == null) {
            ctqVar = new ctq(i);
            arrayList2.add(ctqVar);
        }
        ctqVar.c.addAll(arrayList);
        ((ArrayList) this.d).add(new ctr(ctqVar, this.b));
    }

    public void h(int i, String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new cts(str));
        }
        g(i, arrayList);
    }

    public void i(String str) {
        ArrayList arrayList = (ArrayList) this.d;
        if (arrayList.isEmpty() || !(StaticHelpers6.getLastNElem(1, arrayList) instanceof ctt)) {
            int i = this.b;
            arrayList.add(new ctt(str, i, str.length() + i));
            this.b = str.length() + this.b;
            return;
        }
        ctt cttVar = (ctt) StaticHelpers6.getLastNElem(1, arrayList);
        cttVar.a = yg.concatToVar1(new StringBuilder(), cttVar.a, str);
        int i2 = cttVar.c;
        int length = str.length() + cttVar.d;
        cttVar.c = i2;
        cttVar.d = length;
        this.b = str.length() + this.b;
    }

    public void j() {
        eke ekeVar;
        ImageView imageView = (ImageView) this.c;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            apy.d(drawable);
        }
        if (drawable == null || (ekeVar = (eke) this.d) == null) {
            return;
        }
        C0023if.g(drawable, ekeVar, imageView.getDrawableState());
    }

    public synchronized String k(int i, int i2, byte[] bArr) {
        char[] cArr;
        int i3;
        int i4;
        try {
            cArr = (char[]) this.c;
            if (cArr == null) {
                cArr = i2 <= 256 ? new char[256] : new char[2048];
                this.c = cArr;
            } else if (cArr.length < i2) {
                cArr = new char[2048];
                this.c = cArr;
            }
            int i5 = i2 + i;
            i3 = 0;
            while (i < i5) {
                int i6 = i + 1;
                byte b = bArr[i];
                if (b > 0) {
                    cArr[i3] = (char) b;
                    i3++;
                    i = i6;
                } else {
                    if (b < -32) {
                        i += 2;
                        byte b2 = bArr[i6];
                        if (b < -62 || b2 > -65) {
                            throw new IllegalArgumentException("Invalid String");
                        }
                        i4 = i3 + 1;
                        cArr[i3] = (char) ((b2 & JSONB.Constants.BC_INT32_BYTE_MAX) | ((b & 31) << 6));
                    } else {
                        if (b >= -16) {
                            byte b3 = bArr[i6];
                            int i7 = i + 3;
                            byte b4 = bArr[i + 2];
                            i += 4;
                            byte b5 = bArr[i7];
                            if (b3 <= -65) {
                                if ((((b3 + 112) + (b << 28)) >> 30) == 0 && b4 <= -65 && b5 <= -65) {
                                    int i8 = ((b3 & JSONB.Constants.BC_INT32_BYTE_MAX) << 12) | ((b & 7) << 18)
                                            | ((b4 & JSONB.Constants.BC_INT32_BYTE_MAX) << 6)
                                            | (b5 & JSONB.Constants.BC_INT32_BYTE_MAX);
                                    int i9 = i3 + 1;
                                    cArr[i3] = (char) ((i8 >>> 10) + 55232);
                                    i3 += 2;
                                    cArr[i9] = (char) ((i8 & 1023) + 56320);
                                }
                            }
                            throw new IllegalArgumentException("Invalid String");
                        }
                        int i10 = i + 2;
                        byte b6 = bArr[i6];
                        i += 3;
                        byte b7 = bArr[i10];
                        if ((b == -32 && b6 < -96) || ((b == -19 && b6 >= -96) || b6 > -65 || b7 > -65)) {
                            throw new IllegalArgumentException("Invalid String");
                        }
                        i4 = i3 + 1;
                        cArr[i3] = (char) (((b6 & JSONB.Constants.BC_INT32_BYTE_MAX) << 6)
                                | ((b & com.umeng.analytics.pro.dn.m) << 12)
                                | (b7 & JSONB.Constants.BC_INT32_BYTE_MAX));
                    }
                    i3 = i4;
                }
            }
            if (i > i5) {
                throw new IllegalArgumentException("Invalid String");
            }
        } catch (Throwable th) {
            throw th;
        }
        return new String(cArr, 0, i3);
    }

    public long l(int i, int i2) {
        long jO = 0;
        if (i2 <= 0) {
            return 0L;
        }
        int i3 = i2 >> 3;
        int i4 = i2 & 7;
        int i5 = 0;
        int i6 = i;
        for (int i7 = 0; i7 < i3; i7++) {
            jO ^= o(i6);
            i6 += 8;
        }
        int i8 = i4 << 3;
        while (i5 < i8) {
            jO ^= (((long) ((byte[]) this.d)[i6]) & 255) << i5;
            i5 += 8;
            i6++;
        }
        int i9 = (i & 7) << 3;
        return (jO >>> (64 - i9)) | (jO << i9);
    }

    public int m() {
        byte[] bArr = (byte[]) this.d;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i + 2;
        this.b = i4;
        int i5 = ((bArr[i2] & 255) << 8) | i3;
        int i6 = i + 3;
        this.b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.b = i + 4;
        return (bArr[i6] << 24) | i7;
    }

    public int n(int i) {
        byte[] bArr = (byte[]) this.d;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        return (bArr[i + 3] << 24) | i2 | ((bArr[i + 2] & 255) << 16);
    }

    public long o(int i) {
        byte[] bArr = (byte[]) this.d;
        int i2 = i + 6;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16)
                | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32)
                | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i2]) & 255) << 48)
                | (((long) bArr[i + 7]) << 56);
    }

    public String p() {
        StringBuilder sb = new StringBuilder("$");
        int i = this.b + 1;
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = ((Object[]) this.c)[i2];
            if (obj instanceof dfx) {
                dfx dfxVar = (dfx) obj;
                if (!nullSafeIsEqual(dfxVar.h(), dnt.b)) {
                    int i3 = ((int[]) this.d)[i2];
                    if (i3 >= 0) {
                        sb.append(".");
                        sb.append(dfxVar.j(i3));
                    }
                } else if (((int[]) this.d)[i2] != -1) {
                    sb.append("[");
                    sb.append(((int[]) this.d)[i2]);
                    sb.append("]");
                }
            } else if (obj != arj.j) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        return sb.toString();
    }

    public short q() {
        byte[] bArr = (byte[]) this.d;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return (short) ((bArr[i2] << 8) | i3);
    }

    public String r(int i) {
        String strK;
        if (i < 0) {
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i > 2048) {
            strK = new String((byte[]) this.d, this.b, i, StandardCharsets.UTF_8);
        } else {
            strK = k(this.b, i, (byte[]) this.d);
        }
        this.b += i;
        return strK;
    }

    public String s(ewo ewoVar, int i) {
        if (ewoVar == null || i <= 0) {
            return r(i);
        }
        byte[] bArr = (byte[]) this.d;
        int i2 = this.b;
        byte[] bArrB = ewoVar.b(Arrays.copyOfRange(bArr, i2, i2 + i));
        String str = bArrB.length > 2048 ? new String(bArrB, StandardCharsets.UTF_8) : k(0, bArrB.length, bArrB);
        this.b += i;
        return str;
    }

    public boolean t() {
        return !(((lh) this.c).d != ((lj) this.d).c || ((lh) this.c).b || ((lh) this.c).isInterrupted());
    }

    public String toString() {
        switch (this.a) {
            case 6:
                return p();
            default:
                return super.toString();
        }
    }

    public boolean u() {
        ColorStateList colorStateList;
        return ((Shader) this.c) == null && (colorStateList = (ColorStateList) this.d) != null
                && colorStateList.isStateful();
    }

    public void v(AttributeSet attributeSet, int i) {
        int resourceId;
        ImageView imageView = (ImageView) this.c;
        Context context = imageView.getContext();
        int[] iArr = cyf.f;
        FactoryPools factoryPoolsVarK = FactoryPools.k(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) factoryPoolsVarK.e;
        ViewCompat.r(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) factoryPoolsVarK.e, i, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1
                    && (drawable = cmz.y(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                apy.d(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(factoryPoolsVarK.r(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(apy.f(typedArray.getInt(3, -1), null));
            }
        } finally {
            factoryPoolsVarK.ae();
        }
    }

    public void w(byte b) {
        byte[] bArr = (byte[]) this.d;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public void x(byte[] bArr) {
        int length = bArr.length;
        if (length > 0) {
            System.arraycopy(bArr, 0, (byte[]) this.d, this.b, length);
            this.b += length;
        }
    }

    public void y(int i) {
        byte[] bArr = (byte[]) this.d;
        int i2 = this.b;
        int i3 = i2 + 1;
        this.b = i3;
        bArr[i2] = (byte) i;
        int i4 = i2 + 2;
        this.b = i4;
        bArr[i3] = (byte) (i >> 8);
        int i5 = i2 + 3;
        this.b = i5;
        bArr[i4] = (byte) (i >> 16);
        this.b = i2 + 4;
        bArr[i5] = (byte) (i >> 24);
    }

    public void z(int i, int i2) {
        byte[] bArr = (byte[]) this.d;
        bArr[i] = (byte) i2;
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    public ik(byte[] bArr, int i) {
        this.a = 5;
        this.c = null;
        this.d = bArr;
        this.b = i;
    }

    public ik(byte b, int i) {
        this.a = i;
        switch (i) {
            case 7:
                this.c = new chs();
                this.d = new ArrayList();
                this.b = 75;
                break;
        }
    }

    public ik(ImageView imageView) {
        this.a = 0;
        this.b = 0;
        this.c = imageView;
    }

    public ik(Shader shader, ColorStateList colorStateList, int i) {
        this.a = 3;
        this.c = shader;
        this.d = colorStateList;
        this.b = i;
    }

    public ik(ArrayList arrayList) {
        this.a = 2;
        this.d = new ArrayList();
        this.c = arrayList;
    }

    public ik(lj ljVar, lh lhVar) {
        this.a = 1;
        this.d = ljVar;
        this.c = lhVar;
    }

    public ik(afr afrVar) {
        this.a = 4;
        this.d = StaticAndroidHelpers.aw(150, new erp(this, 21));
        this.c = afrVar;
    }
}
