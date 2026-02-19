package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class dnj extends dnr {
    public static boolean ab(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        throwIfVar1IsNull(charSequence, "<this>");
        throwIfVar1IsNull(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (ai(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                return true;
            }
        } else if (ag(charSequence, charSequence2, 0, charSequence.length(), z, false) >= 0) {
            return true;
        }
        return false;
    }

    public static boolean ac(CharSequence charSequence, char c) {
        throwIfVar1IsNull(charSequence, "<this>");
        return ah(c, 0, 2, charSequence) >= 0;
    }

    public static String ad(int i, String str) {
        throwIfVar1IsNull(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(yg.f(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(i);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int ae(CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int af(CharSequence charSequence, String str, int i, boolean z) {
        throwIfVar1IsNull(charSequence, "<this>");
        throwIfVar1IsNull(str, "string");
        return (z || !(charSequence instanceof String)) ? ag(charSequence, str, i, charSequence.length(), z, false)
                : ((String) charSequence).indexOf(str, i);
    }

    public static final int ag(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z,
            boolean z2) {
        KotlinIntProgression intRangeVar;
        if (z2) {
            int iAe = ae(charSequence);
            if (i > iAe) {
                i = iAe;
            }
            if (i2 < 0) {
                i2 = 0;
            }
            intRangeVar = new KotlinIntProgression(i, i2, -1);
        } else {
            if (i < 0) {
                i = 0;
            }
            int length = charSequence.length();
            if (i2 > length) {
                i2 = length;
            }
            intRangeVar = new IntRange(i, i2, 1);
        }
        boolean z3 = charSequence instanceof String;
        int i3 = intRangeVar.step;
        int i4 = intRangeVar.last;
        int i5 = intRangeVar.first;
        if (!z3 || !(charSequence2 instanceof String)) {
            boolean z4 = z;
            if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
                while (true) {
                    CharSequence charSequence3 = charSequence;
                    CharSequence charSequence4 = charSequence2;
                    boolean z5 = z4;
                    z4 = z5;
                    if (an(charSequence4, 0, charSequence3, i5, charSequence2.length(), z5)) {
                        return i5;
                    }
                    if (i5 != i4) {
                        i5 += i3;
                        charSequence2 = charSequence4;
                        charSequence = charSequence3;
                    }
                }
            }
        } else if ((i3 > 0 && i5 <= i4) || (i3 < 0 && i4 <= i5)) {
            int i6 = i5;
            while (true) {
                String str = (String) charSequence2;
                boolean z6 = z;
                if (dnr.bl(0, i6, str.length(), str, (String) charSequence, z6)) {
                    return i6;
                }
                if (i6 != i4) {
                    i6 += i3;
                    z = z6;
                }
            }
        }
        return -1;
    }

    public static int ah(char c, int i, int i2, CharSequence charSequence) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        throwIfVar1IsNull(charSequence, "<this>");
        return !(charSequence instanceof String) ? aj(charSequence, new char[] { c }, i, false)
                : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int ai(CharSequence charSequence, String str, int i, boolean z, int i2) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return af(charSequence, str, i, z);
    }

    public static final int aj(CharSequence charSequence, char[] cArr, int i, boolean z) {
        throwIfVar1IsNull(charSequence, "<this>");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(SomeStaticHelpers.w(cArr), i);
        }
        if (i < 0) {
            i = 0;
        }
        int iAe = ae(charSequence);
        if (i > iAe) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(i);
            for (char c : cArr) {
                if (cmz.u(c, cCharAt, z)) {
                    return i;
                }
            }
            if (i == iAe) {
                return -1;
            }
            i++;
        }
    }

    public static boolean ak(CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "<this>");
        for (int i = 0; i < charSequence.length(); i++) {
            if (!cmz.ac(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int al(int i, String str, String str2) {
        int iAe = (i & 2) != 0 ? ae(str) : 0;
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "string");
        return str.lastIndexOf(str2, iAe);
    }

    public static int am(String str, char c, int i, int i2) {
        if ((i2 & 2) != 0) {
            i = ae(str);
        }
        throwIfVar1IsNull(str, "<this>");
        return str.lastIndexOf(c, i);
    }

    public static final boolean an(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3,
            boolean z) {
        throwIfVar1IsNull(charSequence, "<this>");
        throwIfVar1IsNull(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!cmz.u(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String ao(String str, String str2) {
        if (!dnr.bp(str, str2, false)) {
            return str;
        }
        String strSubstring = str.substring(str2.length());
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String ap(String str, String str2) {
        if (!dnr.bi(str, str2)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - str2.length());
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final List aq(CharSequence charSequence, String str) {
        int iAf = af(charSequence, str, 0, false);
        if (iAf == -1) {
            return dqc.toSingletonList(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(10);
        int length = 0;
        do {
            arrayList.add(charSequence.subSequence(length, iAf).toString());
            length = str.length() + iAf;
            iAf = af(charSequence, str, length, false);
        } while (iAf != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List ar(CharSequence charSequence, char[] cArr) {
        throwIfVar1IsNull(charSequence, "<this>");
        if (cArr.length == 1) {
            return aq(charSequence, String.valueOf(cArr[0]));
        }
        boz bozVar = new boz(new alu(charSequence, new cxa(cArr, 1)), 1);
        ArrayList arrayList = new ArrayList(StaticHelpers4.ak(bozVar, 10));
        Iterator it = bozVar.iterator();
        while (true) {
            alt altVar = (alt) it;
            if (!altVar.hasNext()) {
                return arrayList;
            }
            IntRange intRangeVar = (IntRange) altVar.next();
            throwIfVar1IsNull(intRangeVar, "range");
            arrayList.add(charSequence.subSequence(intRangeVar.first, intRangeVar.last + 1).toString());
        }
    }

    public static List as(String str, String[] strArr) {
        throwIfVar1IsNull(str, "<this>");
        if (strArr.length == 1) {
            String str2 = strArr[0];
            if (str2.length() != 0) {
                return aq(str, str2);
            }
        }
        boz bozVar = new boz(new alu(str, new cxa(SomeStaticHelpers.toList(strArr), 2)), 1);
        ArrayList arrayList = new ArrayList(StaticHelpers4.ak(bozVar, 10));
        Iterator it = bozVar.iterator();
        while (true) {
            alt altVar = (alt) it;
            if (!altVar.hasNext()) {
                return arrayList;
            }
            IntRange intRangeVar = (IntRange) altVar.next();
            throwIfVar1IsNull(intRangeVar, "range");
            arrayList.add(str.subSequence(intRangeVar.first, intRangeVar.last + 1).toString());
        }
    }

    public static String at(char c, String str, String str2) {
        int iAh = ah(c, 0, 6, str);
        if (iAh == -1) {
            return str2;
        }
        String strSubstring = str.substring(iAh + 1, str.length());
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String au(String str, String str2, String str3) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str2, "delimiter");
        throwIfVar1IsNull(str3, "missingDelimiterValue");
        int iAi = ai(str, str2, 0, false, 6);
        if (iAi == -1) {
            return str3;
        }
        String strSubstring = str.substring(str2.length() + iAi, str.length());
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String av(char c, String str, String str2) {
        int iAm = am(str, c, 0, 6);
        if (iAm == -1) {
            return str2;
        }
        String strSubstring = str.substring(iAm + 1, str.length());
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String aw(String str, char c) {
        int iAh = ah(c, 0, 6, str);
        if (iAh == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iAh);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String ax(String str, String str2) {
        throwIfVar1IsNull(str, "<this>");
        throwIfVar1IsNull(str, "missingDelimiterValue");
        int iAi = ai(str, str2, 0, false, 6);
        if (iAi == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iAi);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String ay(String str, String str2) {
        int iAl = al(6, str, str2);
        if (iAl == -1) {
            return str;
        }
        String strSubstring = str.substring(0, iAl);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String az(int i, String str) {
        throwIfVar1IsNull(str, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(yg.f(i, "Requested character count ", " is less than zero.").toString());
        }
        int length = str.length();
        if (i > length) {
            i = length;
        }
        String strSubstring = str.substring(0, i);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence ba(String str) {
        throwIfVar1IsNull(str, "<this>");
        int length = str.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zAc = cmz.ac(str.charAt(!z ? i : length));
            if (z) {
                if (!zAc) {
                    break;
                }
                length--;
            } else if (zAc) {
                i++;
            } else {
                z = true;
            }
        }
        return str.subSequence(i, length + 1);
    }
}
