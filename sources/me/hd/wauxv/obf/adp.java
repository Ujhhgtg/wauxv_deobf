package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adp {
    public static final int[] a = {0, 4, 8};
    public static final SparseIntArray b;
    public static final SparseIntArray c;
    public final HashMap d = new HashMap();
    public final boolean e = true;
    public final HashMap f = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        c = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] g(na naVar, String str) {
        int iIntValue;
        String[] strArrSplit = str.split(",");
        Context context = naVar.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            Object obj = null;
            try {
                iIntValue = cxp.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && naVar.isInEditMode() && (naVar.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) naVar.getParent();
                if (strTrim != null) {
                    HashMap map = constraintLayout.n;
                    if (map != null && map.containsKey(strTrim)) {
                        obj = constraintLayout.n.get(strTrim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    public static adk h(Context context, AttributeSet attributeSet, boolean z) {
        int i;
        int i2;
        adk adkVar = new adk();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z ? cxx.c : cxx.a);
        String[] strArr = dqc.at;
        adn adnVar = adkVar.b;
        ado adoVar = adkVar.e;
        adm admVar = adkVar.c;
        adl adlVar = adkVar.d;
        int[] iArr = a;
        SparseIntArray sparseIntArray = b;
        if (z) {
            adj adjVar = new adj();
            adjVar.a = new int[10];
            adjVar.b = new int[10];
            adjVar.c = 0;
            adjVar.d = new int[10];
            adjVar.e = new float[10];
            adjVar.f = 0;
            adjVar.g = new int[5];
            adjVar.h = new String[5];
            adjVar.i = 0;
            adjVar.j = new int[4];
            adjVar.k = new boolean[4];
            adjVar.l = 0;
            admVar.getClass();
            adlVar.getClass();
            adoVar.getClass();
            int i3 = 0;
            for (int indexCount = typedArrayObtainStyledAttributes.getIndexCount(); i3 < indexCount; indexCount = i2) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = i3;
                switch (c.get(index)) {
                    case 2:
                        i2 = indexCount;
                        adjVar.n(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.aj));
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder("Unknown attribute 0x");
                        i2 = indexCount;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        break;
                    case 5:
                        i2 = indexCount;
                        adjVar.o(5, typedArrayObtainStyledAttributes.getString(index));
                        continue;
                        i3 = i4 + 1;
                        break;
                    case 6:
                        i2 = indexCount;
                        adjVar.n(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adlVar.ad));
                        break;
                    case 7:
                        i2 = indexCount;
                        adjVar.n(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adlVar.ae));
                        break;
                    case 8:
                        i2 = indexCount;
                        adjVar.n(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ak));
                        break;
                    case 11:
                        i2 = indexCount;
                        adjVar.n(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.aq));
                        break;
                    case 12:
                        i2 = indexCount;
                        adjVar.n(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ar));
                        break;
                    case 13:
                        i2 = indexCount;
                        adjVar.n(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.an));
                        break;
                    case 14:
                        i2 = indexCount;
                        adjVar.n(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ap));
                        break;
                    case 15:
                        i2 = indexCount;
                        adjVar.n(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.as));
                        break;
                    case 16:
                        i2 = indexCount;
                        adjVar.n(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ao));
                        break;
                    case 17:
                        i2 = indexCount;
                        adjVar.n(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adlVar.e));
                        break;
                    case 18:
                        i2 = indexCount;
                        adjVar.n(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, adlVar.f));
                        break;
                    case 19:
                        i2 = indexCount;
                        adjVar.m(19, typedArrayObtainStyledAttributes.getFloat(index, adlVar.g));
                        break;
                    case 20:
                        i2 = indexCount;
                        adjVar.m(20, typedArrayObtainStyledAttributes.getFloat(index, adlVar.x));
                        break;
                    case 21:
                        i2 = indexCount;
                        adjVar.n(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, adlVar.d));
                        break;
                    case 22:
                        i2 = indexCount;
                        adjVar.n(22, iArr[typedArrayObtainStyledAttributes.getInt(index, adnVar.a)]);
                        break;
                    case 23:
                        i2 = indexCount;
                        adjVar.n(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, adlVar.c));
                        break;
                    case 24:
                        i2 = indexCount;
                        adjVar.n(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ag));
                        break;
                    case 27:
                        i2 = indexCount;
                        adjVar.n(27, typedArrayObtainStyledAttributes.getInt(index, adlVar.af));
                        break;
                    case 28:
                        i2 = indexCount;
                        adjVar.n(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ah));
                        break;
                    case 31:
                        i2 = indexCount;
                        adjVar.n(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.al));
                        break;
                    case 34:
                        i2 = indexCount;
                        adjVar.n(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ai));
                        break;
                    case 37:
                        i2 = indexCount;
                        adjVar.m(37, typedArrayObtainStyledAttributes.getFloat(index, adlVar.y));
                        break;
                    case 38:
                        i2 = indexCount;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, adkVar.a);
                        adkVar.a = resourceId;
                        adjVar.n(38, resourceId);
                        break;
                    case 39:
                        i2 = indexCount;
                        adjVar.m(39, typedArrayObtainStyledAttributes.getFloat(index, adlVar.av));
                        break;
                    case 40:
                        i2 = indexCount;
                        adjVar.m(40, typedArrayObtainStyledAttributes.getFloat(index, adlVar.au));
                        break;
                    case 41:
                        i2 = indexCount;
                        adjVar.n(41, typedArrayObtainStyledAttributes.getInt(index, adlVar.aw));
                        break;
                    case 42:
                        i2 = indexCount;
                        adjVar.n(42, typedArrayObtainStyledAttributes.getInt(index, adlVar.ax));
                        break;
                    case 43:
                        i2 = indexCount;
                        adjVar.m(43, typedArrayObtainStyledAttributes.getFloat(index, adnVar.c));
                        break;
                    case 44:
                        i2 = indexCount;
                        adjVar.p(44, true);
                        adjVar.m(44, typedArrayObtainStyledAttributes.getDimension(index, adoVar.n));
                        break;
                    case 45:
                        i2 = indexCount;
                        adjVar.m(45, typedArrayObtainStyledAttributes.getFloat(index, adoVar.c));
                        break;
                    case 46:
                        i2 = indexCount;
                        adjVar.m(46, typedArrayObtainStyledAttributes.getFloat(index, adoVar.d));
                        break;
                    case 47:
                        i2 = indexCount;
                        adjVar.m(47, typedArrayObtainStyledAttributes.getFloat(index, adoVar.e));
                        break;
                    case 48:
                        i2 = indexCount;
                        adjVar.m(48, typedArrayObtainStyledAttributes.getFloat(index, adoVar.f));
                        break;
                    case 49:
                        i2 = indexCount;
                        adjVar.m(49, typedArrayObtainStyledAttributes.getDimension(index, adoVar.g));
                        break;
                    case 50:
                        i2 = indexCount;
                        adjVar.m(50, typedArrayObtainStyledAttributes.getDimension(index, adoVar.h));
                        break;
                    case 51:
                        i2 = indexCount;
                        adjVar.m(51, typedArrayObtainStyledAttributes.getDimension(index, adoVar.j));
                        break;
                    case 52:
                        i2 = indexCount;
                        adjVar.m(52, typedArrayObtainStyledAttributes.getDimension(index, adoVar.k));
                        break;
                    case 53:
                        i2 = indexCount;
                        adjVar.m(53, typedArrayObtainStyledAttributes.getDimension(index, adoVar.l));
                        break;
                    case 54:
                        i2 = indexCount;
                        adjVar.n(54, typedArrayObtainStyledAttributes.getInt(index, adlVar.ay));
                        break;
                    case 55:
                        i2 = indexCount;
                        adjVar.n(55, typedArrayObtainStyledAttributes.getInt(index, adlVar.az));
                        break;
                    case 56:
                        i2 = indexCount;
                        adjVar.n(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ba));
                        break;
                    case 57:
                        i2 = indexCount;
                        adjVar.n(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.bb));
                        break;
                    case 58:
                        i2 = indexCount;
                        adjVar.n(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.bc));
                        break;
                    case 59:
                        i2 = indexCount;
                        adjVar.n(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.bd));
                        break;
                    case 60:
                        i2 = indexCount;
                        adjVar.m(60, typedArrayObtainStyledAttributes.getFloat(index, adoVar.b));
                        break;
                    case 62:
                        i2 = indexCount;
                        adjVar.n(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.ab));
                        break;
                    case 63:
                        i2 = indexCount;
                        adjVar.m(63, typedArrayObtainStyledAttributes.getFloat(index, adlVar.ac));
                        break;
                    case 64:
                        i2 = indexCount;
                        adjVar.n(64, i(typedArrayObtainStyledAttributes, index, admVar.b));
                        break;
                    case 65:
                        i2 = indexCount;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            adjVar.o(65, typedArrayObtainStyledAttributes.getString(index));
                        } else {
                            adjVar.o(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                        }
                        break;
                    case 66:
                        i2 = indexCount;
                        adjVar.n(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i2 = indexCount;
                        adjVar.m(67, typedArrayObtainStyledAttributes.getFloat(index, admVar.f));
                        break;
                    case 68:
                        i2 = indexCount;
                        adjVar.m(68, typedArrayObtainStyledAttributes.getFloat(index, adnVar.d));
                        break;
                    case 69:
                        i2 = indexCount;
                        adjVar.m(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i2 = indexCount;
                        adjVar.m(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i2 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i2 = indexCount;
                        adjVar.n(72, typedArrayObtainStyledAttributes.getInt(index, adlVar.bg));
                        break;
                    case 73:
                        i2 = indexCount;
                        adjVar.n(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.bh));
                        break;
                    case 74:
                        i2 = indexCount;
                        adjVar.o(74, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i2 = indexCount;
                        adjVar.p(75, typedArrayObtainStyledAttributes.getBoolean(index, adlVar.bo));
                        break;
                    case 76:
                        i2 = indexCount;
                        adjVar.n(76, typedArrayObtainStyledAttributes.getInt(index, admVar.d));
                        break;
                    case 77:
                        i2 = indexCount;
                        adjVar.o(77, typedArrayObtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i2 = indexCount;
                        adjVar.n(78, typedArrayObtainStyledAttributes.getInt(index, adnVar.b));
                        break;
                    case 79:
                        i2 = indexCount;
                        adjVar.m(79, typedArrayObtainStyledAttributes.getFloat(index, admVar.e));
                        break;
                    case 80:
                        i2 = indexCount;
                        adjVar.p(80, typedArrayObtainStyledAttributes.getBoolean(index, adlVar.bm));
                        break;
                    case 81:
                        i2 = indexCount;
                        adjVar.p(81, typedArrayObtainStyledAttributes.getBoolean(index, adlVar.bn));
                        break;
                    case 82:
                        i2 = indexCount;
                        adjVar.n(82, typedArrayObtainStyledAttributes.getInteger(index, admVar.c));
                        break;
                    case 83:
                        i2 = indexCount;
                        adjVar.n(83, i(typedArrayObtainStyledAttributes, index, adoVar.i));
                        break;
                    case 84:
                        i2 = indexCount;
                        adjVar.n(84, typedArrayObtainStyledAttributes.getInteger(index, admVar.h));
                        break;
                    case 85:
                        i2 = indexCount;
                        adjVar.m(85, typedArrayObtainStyledAttributes.getFloat(index, admVar.g));
                        break;
                    case 86:
                        i2 = indexCount;
                        int i5 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i5 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            admVar.j = resourceId2;
                            adjVar.n(89, resourceId2);
                            if (admVar.j != -1) {
                                adjVar.n(88, -2);
                            }
                        } else if (i5 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            admVar.i = string;
                            adjVar.o(90, string);
                            if (admVar.i.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                admVar.j = resourceId3;
                                adjVar.n(89, resourceId3);
                                adjVar.n(88, -2);
                            } else {
                                adjVar.n(88, -1);
                            }
                        } else {
                            adjVar.n(88, typedArrayObtainStyledAttributes.getInteger(index, admVar.j));
                        }
                        break;
                    case 87:
                        i2 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i2 = indexCount;
                        adjVar.n(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.am));
                        break;
                    case 94:
                        i2 = indexCount;
                        adjVar.n(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, adlVar.at));
                        break;
                    case 95:
                        i2 = indexCount;
                        j(adjVar, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i2 = indexCount;
                        j(adjVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i2 = indexCount;
                        adjVar.n(97, typedArrayObtainStyledAttributes.getInt(index, adlVar.bp));
                        break;
                    case 98:
                        i2 = indexCount;
                        int i6 = cfd.w;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            adkVar.a = typedArrayObtainStyledAttributes.getResourceId(index, adkVar.a);
                        }
                        break;
                    case 99:
                        i2 = indexCount;
                        adjVar.p(99, typedArrayObtainStyledAttributes.getBoolean(index, adlVar.h));
                        break;
                }
                i3 = i4 + 1;
            }
        } else {
            int i7 = 0;
            for (int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount(); i7 < indexCount2; indexCount2 = i) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        admVar.getClass();
                        adlVar.getClass();
                        adoVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i = indexCount2;
                        adlVar.q = i(typedArrayObtainStyledAttributes, index2, adlVar.q);
                        continue;
                        i7++;
                        break;
                    case 2:
                        i = indexCount2;
                        adlVar.aj = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.aj);
                        continue;
                        i7++;
                        break;
                    case 3:
                        i = indexCount2;
                        adlVar.p = i(typedArrayObtainStyledAttributes, index2, adlVar.p);
                        continue;
                        i7++;
                        break;
                    case 4:
                        i = indexCount2;
                        adlVar.o = i(typedArrayObtainStyledAttributes, index2, adlVar.o);
                        continue;
                        i7++;
                        break;
                    case 5:
                        i = indexCount2;
                        adlVar.z = typedArrayObtainStyledAttributes.getString(index2);
                        continue;
                        i7++;
                        break;
                    case 6:
                        i = indexCount2;
                        adlVar.ad = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, adlVar.ad);
                        continue;
                        i7++;
                        break;
                    case 7:
                        i = indexCount2;
                        adlVar.ae = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, adlVar.ae);
                        continue;
                        i7++;
                        break;
                    case 8:
                        i = indexCount2;
                        adlVar.ak = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ak);
                        continue;
                        i7++;
                        break;
                    case 9:
                        i = indexCount2;
                        adlVar.w = i(typedArrayObtainStyledAttributes, index2, adlVar.w);
                        continue;
                        i7++;
                        break;
                    case 10:
                        i = indexCount2;
                        adlVar.v = i(typedArrayObtainStyledAttributes, index2, adlVar.v);
                        continue;
                        i7++;
                        break;
                    case 11:
                        i = indexCount2;
                        adlVar.aq = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.aq);
                        continue;
                        i7++;
                        break;
                    case 12:
                        i = indexCount2;
                        adlVar.ar = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ar);
                        continue;
                        i7++;
                        break;
                    case 13:
                        i = indexCount2;
                        adlVar.an = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.an);
                        continue;
                        i7++;
                        break;
                    case 14:
                        i = indexCount2;
                        adlVar.ap = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ap);
                        continue;
                        i7++;
                        break;
                    case 15:
                        i = indexCount2;
                        adlVar.as = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.as);
                        continue;
                        i7++;
                        break;
                    case 16:
                        i = indexCount2;
                        adlVar.ao = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ao);
                        continue;
                        i7++;
                        break;
                    case 17:
                        i = indexCount2;
                        adlVar.e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, adlVar.e);
                        continue;
                        i7++;
                        break;
                    case 18:
                        i = indexCount2;
                        adlVar.f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, adlVar.f);
                        continue;
                        i7++;
                        break;
                    case 19:
                        i = indexCount2;
                        adlVar.g = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.g);
                        continue;
                        i7++;
                        break;
                    case 20:
                        i = indexCount2;
                        adlVar.x = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.x);
                        continue;
                        i7++;
                        break;
                    case 21:
                        i = indexCount2;
                        adlVar.d = typedArrayObtainStyledAttributes.getLayoutDimension(index2, adlVar.d);
                        continue;
                        i7++;
                        break;
                    case 22:
                        i = indexCount2;
                        int i8 = typedArrayObtainStyledAttributes.getInt(index2, adnVar.a);
                        adnVar.a = i8;
                        adnVar.a = iArr[i8];
                        continue;
                        i7++;
                        break;
                    case 23:
                        i = indexCount2;
                        adlVar.c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, adlVar.c);
                        continue;
                        i7++;
                        break;
                    case 24:
                        i = indexCount2;
                        adlVar.ag = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ag);
                        continue;
                        i7++;
                        break;
                    case 25:
                        i = indexCount2;
                        adlVar.i = i(typedArrayObtainStyledAttributes, index2, adlVar.i);
                        continue;
                        i7++;
                        break;
                    case 26:
                        i = indexCount2;
                        adlVar.j = i(typedArrayObtainStyledAttributes, index2, adlVar.j);
                        continue;
                        i7++;
                        break;
                    case 27:
                        i = indexCount2;
                        adlVar.af = typedArrayObtainStyledAttributes.getInt(index2, adlVar.af);
                        continue;
                        i7++;
                        break;
                    case 28:
                        i = indexCount2;
                        adlVar.ah = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ah);
                        continue;
                        i7++;
                        break;
                    case 29:
                        i = indexCount2;
                        adlVar.k = i(typedArrayObtainStyledAttributes, index2, adlVar.k);
                        continue;
                        i7++;
                        break;
                    case 30:
                        i = indexCount2;
                        adlVar.l = i(typedArrayObtainStyledAttributes, index2, adlVar.l);
                        continue;
                        i7++;
                        break;
                    case 31:
                        i = indexCount2;
                        adlVar.al = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.al);
                        continue;
                        i7++;
                        break;
                    case 32:
                        i = indexCount2;
                        adlVar.t = i(typedArrayObtainStyledAttributes, index2, adlVar.t);
                        continue;
                        i7++;
                        break;
                    case 33:
                        i = indexCount2;
                        adlVar.u = i(typedArrayObtainStyledAttributes, index2, adlVar.u);
                        continue;
                        i7++;
                        break;
                    case 34:
                        i = indexCount2;
                        adlVar.ai = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ai);
                        continue;
                        i7++;
                        break;
                    case 35:
                        i = indexCount2;
                        adlVar.n = i(typedArrayObtainStyledAttributes, index2, adlVar.n);
                        continue;
                        i7++;
                        break;
                    case 36:
                        i = indexCount2;
                        adlVar.m = i(typedArrayObtainStyledAttributes, index2, adlVar.m);
                        continue;
                        i7++;
                        break;
                    case 37:
                        i = indexCount2;
                        adlVar.y = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.y);
                        continue;
                        i7++;
                        break;
                    case 38:
                        i = indexCount2;
                        adkVar.a = typedArrayObtainStyledAttributes.getResourceId(index2, adkVar.a);
                        continue;
                        i7++;
                        break;
                    case 39:
                        i = indexCount2;
                        adlVar.av = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.av);
                        continue;
                        i7++;
                        break;
                    case 40:
                        i = indexCount2;
                        adlVar.au = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.au);
                        continue;
                        i7++;
                        break;
                    case 41:
                        i = indexCount2;
                        adlVar.aw = typedArrayObtainStyledAttributes.getInt(index2, adlVar.aw);
                        continue;
                        i7++;
                        break;
                    case 42:
                        i = indexCount2;
                        adlVar.ax = typedArrayObtainStyledAttributes.getInt(index2, adlVar.ax);
                        continue;
                        i7++;
                        break;
                    case 43:
                        i = indexCount2;
                        adnVar.c = typedArrayObtainStyledAttributes.getFloat(index2, adnVar.c);
                        continue;
                        i7++;
                        break;
                    case 44:
                        i = indexCount2;
                        adoVar.m = true;
                        adoVar.n = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.n);
                        continue;
                        i7++;
                        break;
                    case 45:
                        i = indexCount2;
                        adoVar.c = typedArrayObtainStyledAttributes.getFloat(index2, adoVar.c);
                        continue;
                        i7++;
                        break;
                    case 46:
                        i = indexCount2;
                        adoVar.d = typedArrayObtainStyledAttributes.getFloat(index2, adoVar.d);
                        continue;
                        i7++;
                        break;
                    case 47:
                        i = indexCount2;
                        adoVar.e = typedArrayObtainStyledAttributes.getFloat(index2, adoVar.e);
                        continue;
                        i7++;
                        break;
                    case 48:
                        i = indexCount2;
                        adoVar.f = typedArrayObtainStyledAttributes.getFloat(index2, adoVar.f);
                        continue;
                        i7++;
                        break;
                    case 49:
                        i = indexCount2;
                        adoVar.g = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.g);
                        continue;
                        i7++;
                        break;
                    case 50:
                        i = indexCount2;
                        adoVar.h = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.h);
                        continue;
                        i7++;
                        break;
                    case 51:
                        i = indexCount2;
                        adoVar.j = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.j);
                        continue;
                        i7++;
                        break;
                    case 52:
                        i = indexCount2;
                        adoVar.k = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.k);
                        continue;
                        i7++;
                        break;
                    case 53:
                        i = indexCount2;
                        adoVar.l = typedArrayObtainStyledAttributes.getDimension(index2, adoVar.l);
                        continue;
                        i7++;
                        break;
                    case 54:
                        i = indexCount2;
                        adlVar.ay = typedArrayObtainStyledAttributes.getInt(index2, adlVar.ay);
                        continue;
                        i7++;
                        break;
                    case 55:
                        i = indexCount2;
                        adlVar.az = typedArrayObtainStyledAttributes.getInt(index2, adlVar.az);
                        continue;
                        i7++;
                        break;
                    case 56:
                        i = indexCount2;
                        adlVar.ba = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ba);
                        continue;
                        i7++;
                        break;
                    case 57:
                        i = indexCount2;
                        adlVar.bb = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.bb);
                        continue;
                        i7++;
                        break;
                    case 58:
                        i = indexCount2;
                        adlVar.bc = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.bc);
                        continue;
                        i7++;
                        break;
                    case 59:
                        i = indexCount2;
                        adlVar.bd = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.bd);
                        continue;
                        i7++;
                        break;
                    case 60:
                        i = indexCount2;
                        adoVar.b = typedArrayObtainStyledAttributes.getFloat(index2, adoVar.b);
                        continue;
                        i7++;
                        break;
                    case 61:
                        i = indexCount2;
                        adlVar.aa = i(typedArrayObtainStyledAttributes, index2, adlVar.aa);
                        continue;
                        i7++;
                        break;
                    case 62:
                        i = indexCount2;
                        adlVar.ab = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.ab);
                        continue;
                        i7++;
                        break;
                    case 63:
                        i = indexCount2;
                        adlVar.ac = typedArrayObtainStyledAttributes.getFloat(index2, adlVar.ac);
                        continue;
                        i7++;
                        break;
                    case 64:
                        i = indexCount2;
                        admVar.b = i(typedArrayObtainStyledAttributes, index2, admVar.b);
                        continue;
                        i7++;
                        break;
                    case 65:
                        i = indexCount2;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index2);
                            admVar.getClass();
                        } else {
                            String str = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            admVar.getClass();
                        }
                        i7++;
                        break;
                    case 66:
                        i = indexCount2;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        admVar.getClass();
                        continue;
                        i7++;
                        break;
                    case 67:
                        i = indexCount2;
                        admVar.f = typedArrayObtainStyledAttributes.getFloat(index2, admVar.f);
                        break;
                    case 68:
                        i = indexCount2;
                        adnVar.d = typedArrayObtainStyledAttributes.getFloat(index2, adnVar.d);
                        break;
                    case 69:
                        i = indexCount2;
                        adlVar.be = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i = indexCount2;
                        adlVar.bf = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i = indexCount2;
                        adlVar.bg = typedArrayObtainStyledAttributes.getInt(index2, adlVar.bg);
                        break;
                    case 73:
                        i = indexCount2;
                        adlVar.bh = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.bh);
                        break;
                    case 74:
                        i = indexCount2;
                        adlVar.bk = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i = indexCount2;
                        adlVar.bo = typedArrayObtainStyledAttributes.getBoolean(index2, adlVar.bo);
                        break;
                    case 76:
                        i = indexCount2;
                        admVar.d = typedArrayObtainStyledAttributes.getInt(index2, admVar.d);
                        break;
                    case 77:
                        i = indexCount2;
                        adlVar.bl = typedArrayObtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i = indexCount2;
                        adnVar.b = typedArrayObtainStyledAttributes.getInt(index2, adnVar.b);
                        break;
                    case 79:
                        i = indexCount2;
                        admVar.e = typedArrayObtainStyledAttributes.getFloat(index2, admVar.e);
                        break;
                    case 80:
                        i = indexCount2;
                        adlVar.bm = typedArrayObtainStyledAttributes.getBoolean(index2, adlVar.bm);
                        break;
                    case 81:
                        i = indexCount2;
                        adlVar.bn = typedArrayObtainStyledAttributes.getBoolean(index2, adlVar.bn);
                        break;
                    case 82:
                        i = indexCount2;
                        admVar.c = typedArrayObtainStyledAttributes.getInteger(index2, admVar.c);
                        break;
                    case 83:
                        i = indexCount2;
                        adoVar.i = i(typedArrayObtainStyledAttributes, index2, adoVar.i);
                        break;
                    case 84:
                        i = indexCount2;
                        admVar.h = typedArrayObtainStyledAttributes.getInteger(index2, admVar.h);
                        break;
                    case 85:
                        i = indexCount2;
                        admVar.g = typedArrayObtainStyledAttributes.getFloat(index2, admVar.g);
                        break;
                    case 86:
                        i = indexCount2;
                        int i9 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i9 == 1) {
                            admVar.j = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i9 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            admVar.i = string2;
                            if (string2.indexOf("/") > 0) {
                                admVar.j = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, admVar.j);
                        }
                        break;
                    case 87:
                        i = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 91:
                        i = indexCount2;
                        adlVar.r = i(typedArrayObtainStyledAttributes, index2, adlVar.r);
                        break;
                    case 92:
                        i = indexCount2;
                        adlVar.s = i(typedArrayObtainStyledAttributes, index2, adlVar.s);
                        break;
                    case 93:
                        i = indexCount2;
                        adlVar.am = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.am);
                        break;
                    case 94:
                        i = indexCount2;
                        adlVar.at = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, adlVar.at);
                        break;
                    case 95:
                        i = indexCount2;
                        j(adlVar, typedArrayObtainStyledAttributes, index2, 0);
                        continue;
                        i7++;
                        break;
                    case 96:
                        i = indexCount2;
                        j(adlVar, typedArrayObtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i = indexCount2;
                        adlVar.bp = typedArrayObtainStyledAttributes.getInt(index2, adlVar.bp);
                        break;
                }
                i7++;
            }
            if (adlVar.bk != null) {
                adlVar.bj = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return adkVar;
    }

    public static int i(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* JADX WARN: Found duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Found duplicated region for block: B:22:0x003a  */
    /* JADX WARN: Found duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Found duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Found duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Found duplicated region for block: B:30:0x004c  */
    /* JADX WARN: Found duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Found duplicated region for block: B:34:0x0056  */
    /* JADX WARN: Found duplicated region for block: B:36:0x005a  */
    /* JADX WARN: Found duplicated region for block: B:38:0x005e  */
    /* JADX WARN: Found duplicated region for block: B:40:0x0067  */
    public static void j(Object obj, TypedArray typedArray, int i, int i2) {
        int dimensionPixelSize;
        adj adjVar;
        adl adlVar;
        adf adfVar;
        if (obj == null) {
            return;
        }
        int i3 = typedArray.peekValue(i).type;
        boolean z = true;
        int i4 = 0;
        if (i3 != 3) {
            if (i3 != 5) {
                dimensionPixelSize = typedArray.getInt(i, 0);
                if (dimensionPixelSize == -4) {
                    i4 = -2;
                } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                    z = false;
                }
                if (obj instanceof adf) {
                    adfVar = (adf) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) adfVar).width = i4;
                        adfVar.aw = z;
                        return;
                    } else {
                        ((ViewGroup.MarginLayoutParams) adfVar).height = i4;
                        adfVar.ax = z;
                        return;
                    }
                }
                if (obj instanceof adl) {
                    adlVar = (adl) obj;
                    if (i2 == 0) {
                        adlVar.c = i4;
                        adlVar.bm = z;
                        return;
                    } else {
                        adlVar.d = i4;
                        adlVar.bn = z;
                        return;
                    }
                }
                if (obj instanceof adj) {
                    adjVar = (adj) obj;
                    if (i2 == 0) {
                        adjVar.n(23, i4);
                        adjVar.p(80, z);
                        return;
                    } else {
                        adjVar.n(21, i4);
                        adjVar.p(81, z);
                        return;
                    }
                }
                return;
            }
            dimensionPixelSize = typedArray.getDimensionPixelSize(i, 0);
            z = false;
            i4 = dimensionPixelSize;
            if (obj instanceof adf) {
                adfVar = (adf) obj;
                if (i2 == 0) {
                    ((ViewGroup.MarginLayoutParams) adfVar).width = i4;
                    adfVar.aw = z;
                    return;
                } else {
                    ((ViewGroup.MarginLayoutParams) adfVar).height = i4;
                    adfVar.ax = z;
                    return;
                }
            }
            if (obj instanceof adl) {
                adlVar = (adl) obj;
                if (i2 == 0) {
                    adlVar.c = i4;
                    adlVar.bm = z;
                    return;
                } else {
                    adlVar.d = i4;
                    adlVar.bn = z;
                    return;
                }
            }
            if (obj instanceof adj) {
                adjVar = (adj) obj;
                if (i2 == 0) {
                    adjVar.n(23, i4);
                    adjVar.p(80, z);
                    return;
                } else {
                    adjVar.n(21, i4);
                    adjVar.p(81, z);
                    return;
                }
            }
            return;
        }
        String string = typedArray.getString(i);
        if (string == null) {
            return;
        }
        int iIndexOf = string.indexOf(61);
        int length = string.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = string.substring(0, iIndexOf);
        String strSubstring2 = string.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if ("ratio".equalsIgnoreCase(strTrim)) {
                if (obj instanceof adf) {
                    adf adfVar2 = (adf) obj;
                    if (i2 == 0) {
                        ((ViewGroup.MarginLayoutParams) adfVar2).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) adfVar2).height = 0;
                    }
                    k(adfVar2, strTrim2);
                    return;
                }
                if (obj instanceof adl) {
                    ((adl) obj).z = strTrim2;
                    return;
                } else {
                    if (obj instanceof adj) {
                        ((adj) obj).o(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f = Float.parseFloat(strTrim2);
                    if (obj instanceof adf) {
                        adf adfVar3 = (adf) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) adfVar3).width = 0;
                            adfVar3.ah = f;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) adfVar3).height = 0;
                            adfVar3.ai = f;
                            return;
                        }
                    }
                    if (obj instanceof adl) {
                        adl adlVar2 = (adl) obj;
                        if (i2 == 0) {
                            adlVar2.c = 0;
                            adlVar2.av = f;
                            return;
                        } else {
                            adlVar2.d = 0;
                            adlVar2.au = f;
                            return;
                        }
                    }
                    if (obj instanceof adj) {
                        adj adjVar2 = (adj) obj;
                        if (i2 == 0) {
                            adjVar2.n(23, 0);
                            adjVar2.m(39, f);
                            return;
                        } else {
                            adjVar2.n(21, 0);
                            adjVar2.m(40, f);
                            return;
                        }
                    }
                    return;
                }
                if ("parent".equalsIgnoreCase(strTrim)) {
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (obj instanceof adf) {
                        adf adfVar4 = (adf) obj;
                        if (i2 == 0) {
                            ((ViewGroup.MarginLayoutParams) adfVar4).width = 0;
                            adfVar4.ar = fMax;
                            adfVar4.al = 2;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) adfVar4).height = 0;
                            adfVar4.as = fMax;
                            adfVar4.am = 2;
                            return;
                        }
                    }
                    if (obj instanceof adl) {
                        adl adlVar3 = (adl) obj;
                        if (i2 == 0) {
                            adlVar3.c = 0;
                            adlVar3.be = fMax;
                            adlVar3.ay = 2;
                            return;
                        } else {
                            adlVar3.d = 0;
                            adlVar3.bf = fMax;
                            adlVar3.az = 2;
                            return;
                        }
                    }
                    if (obj instanceof adj) {
                        adj adjVar3 = (adj) obj;
                        if (i2 == 0) {
                            adjVar3.n(23, 0);
                            adjVar3.n(54, 2);
                        } else {
                            adjVar3.n(21, 0);
                            adjVar3.n(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void k(adf adfVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f = Float.parseFloat(strSubstring3);
                        float f2 = Float.parseFloat(strSubstring4);
                        if (f > 0.0f && f2 > 0.0f) {
                            if (i == 1) {
                                Math.abs(f2 / f);
                            } else {
                                Math.abs(f / f2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        adfVar.ag = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void l(ConstraintLayout constraintLayout) {
        HashSet hashSet;
        int i;
        HashMap map;
        String resourceEntryName;
        adp adpVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = adpVar.f;
        HashSet<Integer> hashSet2 = new HashSet(map2.keySet());
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (adpVar.e && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map2.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        adk adkVar = (adk) map2.get(Integer.valueOf(id));
                        if (adkVar != null) {
                            adn adnVar = adkVar.b;
                            adl adlVar = adkVar.d;
                            ado adoVar = adkVar.e;
                            if (childAt instanceof na) {
                                adlVar.bi = 1;
                                na naVar = (na) childAt;
                                naVar.setId(id);
                                naVar.setType(adlVar.bg);
                                naVar.setMargin(adlVar.bh);
                                naVar.setAllowsGoneWidget(adlVar.bo);
                                int[] iArr = adlVar.bj;
                                if (iArr != null) {
                                    naVar.setReferencedIds(iArr);
                                } else {
                                    String str = adlVar.bk;
                                    if (str != null) {
                                        int[] iArrG = g(naVar, str);
                                        adlVar.bj = iArrG;
                                        naVar.setReferencedIds(iArrG);
                                    }
                                }
                            }
                            adf adfVar = (adf) childAt.getLayoutParams();
                            adfVar.bq();
                            adkVar.g(adfVar);
                            HashMap map3 = adkVar.f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                adc adcVar = (adc) map3.get(str2);
                                HashSet hashSet3 = hashSet2;
                                String strK = !adcVar.a ? yg.k("set", str2) : str2;
                                int i3 = i2;
                                try {
                                    int iAe = dkz.ae(adcVar.b);
                                    Class cls2 = Float.TYPE;
                                    Class cls3 = Integer.TYPE;
                                    switch (iAe) {
                                        case 0:
                                            map = map3;
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(adcVar.c));
                                            break;
                                        case 1:
                                            map = map3;
                                            cls.getMethod(strK, cls2).invoke(childAt, Float.valueOf(adcVar.d));
                                            break;
                                        case 2:
                                            map = map3;
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(adcVar.g));
                                            break;
                                        case 3:
                                            Method method = cls.getMethod(strK, Drawable.class);
                                            map = map3;
                                            try {
                                                ColorDrawable colorDrawable = new ColorDrawable();
                                                colorDrawable.setColor(adcVar.g);
                                                method.invoke(childAt, colorDrawable);
                                            } catch (IllegalAccessException e) {
                                                e = e;
                                                StringBuilder sbZ = dkz.z(" Custom Attribute \"", str2, "\" not found on ");
                                                sbZ.append(cls.getName());
                                                Log.e("TransitionLayout", sbZ.toString(), e);
                                            } catch (NoSuchMethodException e2) {
                                                e = e2;
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strK, e);
                                            } catch (InvocationTargetException e3) {
                                                e = e3;
                                                StringBuilder sbZ2 = dkz.z(" Custom Attribute \"", str2, "\" not found on ");
                                                sbZ2.append(cls.getName());
                                                Log.e("TransitionLayout", sbZ2.toString(), e);
                                            }
                                            break;
                                        case 4:
                                            cls.getMethod(strK, CharSequence.class).invoke(childAt, adcVar.e);
                                            map = map3;
                                            break;
                                        case 5:
                                            cls.getMethod(strK, Boolean.TYPE).invoke(childAt, Boolean.valueOf(adcVar.f));
                                            map = map3;
                                            break;
                                        case 6:
                                            cls.getMethod(strK, cls2).invoke(childAt, Float.valueOf(adcVar.d));
                                            map = map3;
                                            break;
                                        case 7:
                                            cls.getMethod(strK, cls3).invoke(childAt, Integer.valueOf(adcVar.c));
                                            map = map3;
                                            break;
                                        default:
                                            map = map3;
                                            break;
                                    }
                                } catch (IllegalAccessException e4) {
                                    e = e4;
                                    map = map3;
                                } catch (NoSuchMethodException e5) {
                                    e = e5;
                                    map = map3;
                                } catch (InvocationTargetException e6) {
                                    e = e6;
                                    map = map3;
                                }
                                hashSet2 = hashSet3;
                                i2 = i3;
                                map3 = map;
                            }
                            hashSet = hashSet2;
                            i = i2;
                            childAt.setLayoutParams(adfVar);
                            if (adnVar.b == 0) {
                                childAt.setVisibility(adnVar.a);
                            }
                            childAt.setAlpha(adnVar.c);
                            childAt.setRotation(adoVar.b);
                            childAt.setRotationX(adoVar.c);
                            childAt.setRotationY(adoVar.d);
                            childAt.setScaleX(adoVar.e);
                            childAt.setScaleY(adoVar.f);
                            if (adoVar.i != -1) {
                                if (((View) childAt.getParent()).findViewById(adoVar.i) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(adoVar.g)) {
                                    childAt.setPivotX(adoVar.g);
                                }
                                if (!Float.isNaN(adoVar.h)) {
                                    childAt.setPivotY(adoVar.h);
                                }
                            }
                            childAt.setTranslationX(adoVar.j);
                            childAt.setTranslationY(adoVar.k);
                            childAt.setTranslationZ(adoVar.l);
                            if (adoVar.m) {
                                childAt.setElevation(adoVar.n);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i = i2;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i2 = i + 1;
                adpVar = this;
                hashSet2 = hashSet;
            }
            hashSet = hashSet2;
            i = i2;
            i2 = i + 1;
            adpVar = this;
            hashSet2 = hashSet;
        }
        for (Integer num : hashSet2) {
            adk adkVar2 = (adk) map2.get(num);
            if (adkVar2 != null) {
                adl adlVar2 = adkVar2.d;
                if (adlVar2.bi == 1) {
                    Context context = constraintLayout.getContext();
                    na naVar2 = new na(context);
                    naVar2.e = new int[32];
                    naVar2.k = new HashMap();
                    naVar2.g = context;
                    nb nbVar = new nb();
                    nbVar.a = 0;
                    nbVar.b = true;
                    nbVar.c = 0;
                    nbVar.d = false;
                    naVar2.d = nbVar;
                    naVar2.h = nbVar;
                    naVar2.s();
                    naVar2.setVisibility(8);
                    naVar2.setId(num.intValue());
                    int[] iArr2 = adlVar2.bj;
                    if (iArr2 != null) {
                        naVar2.setReferencedIds(iArr2);
                    } else {
                        String str3 = adlVar2.bk;
                        if (str3 != null) {
                            int[] iArrG2 = g(naVar2, str3);
                            adlVar2.bj = iArrG2;
                            naVar2.setReferencedIds(iArrG2);
                        }
                    }
                    naVar2.setType(adlVar2.bg);
                    naVar2.setMargin(adlVar2.bh);
                    adf adfVarQ = ConstraintLayout.q();
                    naVar2.s();
                    adkVar2.g(adfVarQ);
                    constraintLayout.addView(naVar2, adfVarQ);
                }
                if (adlVar2.b) {
                    View bjoVar = new bjo(constraintLayout.getContext());
                    bjoVar.setId(num.intValue());
                    adf adfVarQ2 = ConstraintLayout.q();
                    adkVar2.g(adfVarQ2);
                    constraintLayout.addView(bjoVar, adfVarQ2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof add) {
                ((add) childAt2).p(constraintLayout);
            }
        }
    }

    public final void m(ConstraintLayout constraintLayout) {
        int i;
        HashMap map;
        int i2;
        adp adpVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = adpVar.f;
        map2.clear();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = constraintLayout.getChildAt(i3);
            adf adfVar = (adf) childAt.getLayoutParams();
            int id = childAt.getId();
            if (adpVar.e && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map2.containsKey(Integer.valueOf(id))) {
                map2.put(Integer.valueOf(id), new adk());
            }
            adk adkVar = (adk) map2.get(Integer.valueOf(id));
            if (adkVar == null) {
                i = childCount;
                map = map2;
                i2 = i3;
            } else {
                adn adnVar = adkVar.b;
                adl adlVar = adkVar.d;
                ado adoVar = adkVar.e;
                i = childCount;
                HashMap map3 = new HashMap();
                map = map2;
                Class<?> cls = childAt.getClass();
                i2 = i3;
                HashMap map4 = adpVar.d;
                for (String str : map4.keySet()) {
                    adc adcVar = (adc) map4.get(str);
                    HashMap map5 = map4;
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new adc(adcVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new adc(adcVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e) {
                        StringBuilder sbZ = dkz.z(" Custom Attribute \"", str, "\" not found on ");
                        sbZ.append(cls.getName());
                        Log.e("TransitionLayout", sbZ.toString(), e);
                    } catch (NoSuchMethodException e2) {
                        Log.e("TransitionLayout", cls.getName() + " must have a method " + str, e2);
                    } catch (InvocationTargetException e3) {
                        StringBuilder sbZ2 = dkz.z(" Custom Attribute \"", str, "\" not found on ");
                        sbZ2.append(cls.getName());
                        Log.e("TransitionLayout", sbZ2.toString(), e3);
                    }
                    map4 = map5;
                }
                adkVar.f = map3;
                adkVar.a = id;
                adlVar.i = adfVar.e;
                adlVar.j = adfVar.f;
                adlVar.k = adfVar.g;
                adlVar.l = adfVar.h;
                adlVar.m = adfVar.i;
                adlVar.n = adfVar.j;
                adlVar.o = adfVar.k;
                adlVar.p = adfVar.l;
                adlVar.q = adfVar.m;
                adlVar.r = adfVar.n;
                adlVar.s = adfVar.o;
                adlVar.t = adfVar.s;
                adlVar.u = adfVar.t;
                adlVar.v = adfVar.u;
                adlVar.w = adfVar.v;
                adlVar.x = adfVar.ae;
                adlVar.y = adfVar.af;
                adlVar.z = adfVar.ag;
                adlVar.aa = adfVar.p;
                adlVar.ab = adfVar.q;
                adlVar.ac = adfVar.r;
                adlVar.ad = adfVar.at;
                adlVar.ae = adfVar.au;
                adlVar.af = adfVar.av;
                adlVar.g = adfVar.c;
                adlVar.e = adfVar.a;
                adlVar.f = adfVar.b;
                adlVar.c = ((ViewGroup.MarginLayoutParams) adfVar).width;
                adlVar.d = ((ViewGroup.MarginLayoutParams) adfVar).height;
                adlVar.ag = ((ViewGroup.MarginLayoutParams) adfVar).leftMargin;
                adlVar.ah = ((ViewGroup.MarginLayoutParams) adfVar).rightMargin;
                adlVar.ai = ((ViewGroup.MarginLayoutParams) adfVar).topMargin;
                adlVar.aj = ((ViewGroup.MarginLayoutParams) adfVar).bottomMargin;
                adlVar.am = adfVar.ad;
                adlVar.au = adfVar.ai;
                adlVar.av = adfVar.ah;
                adlVar.ax = adfVar.ak;
                adlVar.aw = adfVar.aj;
                adlVar.bm = adfVar.aw;
                adlVar.bn = adfVar.ax;
                adlVar.ay = adfVar.al;
                adlVar.az = adfVar.am;
                adlVar.ba = adfVar.ap;
                adlVar.bb = adfVar.aq;
                adlVar.bc = adfVar.an;
                adlVar.bd = adfVar.ao;
                adlVar.be = adfVar.ar;
                adlVar.bf = adfVar.as;
                adlVar.bl = adfVar.ay;
                adlVar.ao = adfVar.x;
                adlVar.aq = adfVar.z;
                adlVar.an = adfVar.w;
                adlVar.ap = adfVar.y;
                adlVar.as = adfVar.aa;
                adlVar.ar = adfVar.ab;
                adlVar.at = adfVar.ac;
                adlVar.bp = adfVar.az;
                adlVar.ak = adfVar.getMarginEnd();
                adlVar.al = adfVar.getMarginStart();
                adnVar.a = childAt.getVisibility();
                adnVar.c = childAt.getAlpha();
                adoVar.b = childAt.getRotation();
                adoVar.c = childAt.getRotationX();
                adoVar.d = childAt.getRotationY();
                adoVar.e = childAt.getScaleX();
                adoVar.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    adoVar.g = pivotX;
                    adoVar.h = pivotY;
                }
                adoVar.j = childAt.getTranslationX();
                adoVar.k = childAt.getTranslationY();
                adoVar.l = childAt.getTranslationZ();
                if (adoVar.m) {
                    adoVar.n = childAt.getElevation();
                }
                if (childAt instanceof na) {
                    na naVar = (na) childAt;
                    adlVar.bo = naVar.getAllowsGoneWidget();
                    adlVar.bj = naVar.getReferencedIds();
                    adlVar.bg = naVar.getType();
                    adlVar.bh = naVar.getMargin();
                }
            }
            i3 = i2 + 1;
            adpVar = this;
            childCount = i;
            map2 = map;
        }
    }

    public final void n(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 2) {
                    String name = xml.getName();
                    adk adkVarH = h(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        adkVarH.d.b = true;
                    }
                    this.f.put(Integer.valueOf(adkVarH.a), adkVarH);
                }
            }
        } catch (IOException e) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e);
        } catch (XmlPullParserException e2) {
            Log.e("ConstraintSet", "Error parsing resource: " + i, e2);
        }
    }
}
