package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class yi {
    public final /* synthetic */ int a;
    public int b;
    public final Object c;
    public Object d;
    public final Serializable e;
    public Object f;

    public yi(cyv cyvVar) {
        this.a = 0;
        this.b = 0;
        this.c = cyvVar;
        this.d = new yh();
        this.e = new ArrayList();
    }

    public static /* synthetic */ void g(yi yiVar, String str, int i, String str2, int i2) {
        if ((i2 & 2) != 0) {
            i = yiVar.b;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        yiVar.v(i, str, str2);
        throw null;
    }

    public View aa(int i) {
        return ((cyv) this.c).a.getChildAt(i);
    }

    public int ab() {
        return ((cyv) this.c).a.getChildCount();
    }

    public void ac(View view) {
        ((ArrayList) this.e).add(view);
        cyv cyvVar = (cyv) this.c;
        czx czxVarCs = RecyclerView.cs(view);
        if (czxVarCs != null) {
            View view2 = czxVarCs.d;
            RecyclerView recyclerView = cyvVar.a;
            int i = czxVarCs.t;
            if (i != -1) {
                czxVarCs.s = i;
            } else {
                czxVarCs.s = view2.getImportantForAccessibility();
            }
            if (!recyclerView.dy()) {
                view2.setImportantForAccessibility(4);
            } else {
                czxVarCs.t = 4;
                recyclerView.cb.add(czxVarCs);
            }
        }
    }

    public String ad(String str) {
        throwIfVar1IsNull(str, "keyToMatch");
        int i = this.b;
        try {
            if (n() == 6 && nullSafeIsEqual(af(), str)) {
                this.d = null;
                if (n() == 5) {
                    return af();
                }
            }
            return null;
        } finally {
            this.b = i;
            this.d = null;
        }
    }

    public byte ae() {
        String str = (String) this.f;
        int i = this.b;
        while (true) {
            int iAg = ag(i);
            if (iAg == -1) {
                this.b = iAg;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iAg);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.b = iAg;
                return cnf.ap(cCharAt);
            }
            i = iAg + 1;
        }
    }

    public String af() {
        if (ae() != 1) {
            return null;
        }
        String strR = r();
        this.d = strR;
        return strR;
    }

    public int ag(int i) {
        if (i < ((String) this.f).length()) {
            return i;
        }
        return -1;
    }

    public int ah() {
        char cCharAt;
        int i = this.b;
        if (i == -1) {
            return i;
        }
        String str = (String) this.f;
        while (i < str.length()
                && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.b = i;
        return i;
    }

    public boolean ai() {
        int iAh = ah();
        String str = (String) this.f;
        if (iAh >= str.length() || iAh == -1 || str.charAt(iAh) != ',') {
            return false;
        }
        this.b++;
        return true;
    }

    public void aj(char c) {
        String str = (String) this.f;
        int i = this.b;
        if (i > 0 && c == '\"') {
            try {
                this.b = i - 1;
                String strS = s();
                this.b = i;
                if (nullSafeIsEqual(strS, "null")) {
                    v(this.b - 1, "Expected string literal but 'null' literal was found",
                            "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.b = i;
                throw th;
            }
        }
        String strBo = cnf.bo(cnf.ap(c));
        int i2 = this.b;
        int i3 = i2 - 1;
        g(this, "Expected " + strBo + ", but had '"
                + ((i2 == str.length() || i3 < 0) ? "EOF" : String.valueOf(str.charAt(i3))) + "' instead", i3, null, 4);
        throw null;
    }

    public void ak(View view) {
        if (((ArrayList) this.e).remove(view)) {
            cyv cyvVar = (cyv) this.c;
            czx czxVarCs = RecyclerView.cs(view);
            if (czxVarCs != null) {
                RecyclerView recyclerView = cyvVar.a;
                int i = czxVarCs.s;
                if (recyclerView.dy()) {
                    czxVarCs.t = i;
                    recyclerView.cb.add(czxVarCs);
                } else {
                    czxVarCs.d.setImportantForAccessibility(i);
                }
                czxVarCs.s = 0;
            }
        }
    }

    public void h(View view, int i, boolean z) {
        RecyclerView recyclerView = ((cyv) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : z(i);
        ((yh) this.d).g(childCount, z);
        if (z) {
            ac(view);
        }
        recyclerView.addView(view, childCount);
        czx czxVarCs = RecyclerView.cs(view);
        cyw cywVar = recyclerView.w;
        if (cywVar != null && czxVarCs != null) {
            cywVar.m(czxVarCs);
        }
        ArrayList arrayList = recyclerView.am;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((czi) recyclerView.am.get(size)).af(view);
            }
        }
    }

    public int i(int i, CharSequence charSequence) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            ((StringBuilder) this.e).append((char) (w(i + 3, charSequence) + (w(i, charSequence) << 12)
                    + (w(i + 1, charSequence) << 8) + (w(i + 2, charSequence) << 4)));
            return i2;
        }
        this.b = i;
        if (i2 < charSequence.length()) {
            return i(this.b, charSequence);
        }
        g(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public void j(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = ((cyv) this.c).a;
        int childCount = i < 0 ? recyclerView.getChildCount() : z(i);
        ((yh) this.d).g(childCount, z);
        if (z) {
            ac(view);
        }
        czx czxVarCs = RecyclerView.cs(view);
        if (czxVarCs != null) {
            if (!czxVarCs.ah() && !czxVarCs.am()) {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(czxVarCs);
                throw new IllegalArgumentException(yg.i(recyclerView, sb));
            }
            if (RecyclerView.b) {
                Log.d("RecyclerView", "reAttach " + czxVarCs);
            }
            czxVarCs.m &= -257;
        } else if (RecyclerView.a) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(childCount);
            throw new IllegalArgumentException(yg.i(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public boolean k() {
        int i = this.b;
        if (i == -1) {
            return false;
        }
        String str = (String) this.f;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.b = i;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i++;
        }
        this.b = i;
        return false;
    }

    public void l(int i, String str) {
        String str2 = (String) this.f;
        if (str2.length() - i < str.length()) {
            g(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (str2.charAt(i + i2) | ' ')) {
                g(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.b = str.length() + i;
    }

    public String m() {
        StringBuilder sb = (StringBuilder) this.e;
        String str = (String) this.f;
        p('\"');
        int i = this.b;
        int iAh = dnj.ah('\"', i, 4, str);
        if (iAh == -1) {
            s();
            int i2 = this.b;
            g(this, concat("Expected quotation mark '\"', but had '",
                    (i2 == str.length() || i2 < 0) ? "EOF" : String.valueOf(str.charAt(i2)), "' instead"), i2, null, 4);
            throw null;
        }
        int i3 = i;
        while (i3 < iAh) {
            if (str.charAt(i3) == '\\') {
                int iAg = this.b;
                char cCharAt = str.charAt(i3);
                boolean z = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iAg, i3);
                        int iAg2 = ag(i3 + 1);
                        if (iAg2 == -1) {
                            g(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int i4 = iAg2 + 1;
                        char cCharAt2 = str.charAt(iAg2);
                        if (cCharAt2 == 'u') {
                            i4 = i(i4, str);
                        } else {
                            char c = cCharAt2 < 'u' ? uc.a[cCharAt2] : (char) 0;
                            if (c == 0) {
                                g(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c);
                        }
                        iAg = ag(i4);
                        if (iAg == -1) {
                            g(this, "Unexpected EOF", iAg, null, 4);
                            throw null;
                        }
                    } else {
                        i3++;
                        if (i3 >= str.length()) {
                            sb.append((CharSequence) str, iAg, i3);
                            iAg = ag(i3);
                            if (iAg == -1) {
                                g(this, "Unexpected EOF", iAg, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                        }
                        cCharAt = str.charAt(i3);
                    }
                    i3 = iAg;
                    z = true;
                    cCharAt = str.charAt(i3);
                }
                String string = !z ? str.subSequence(iAg, i3).toString() : t(iAg, i3);
                this.b = i3 + 1;
                return string;
            }
            i3++;
        }
        this.b = iAh + 1;
        String strSubstring = str.substring(i, iAh);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        return strSubstring;
    }

    public byte n() {
        String str = (String) this.f;
        int i = this.b;
        while (i != -1 && i < str.length()) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.b = i2;
                return cnf.ap(cCharAt);
            }
            i = i2;
        }
        this.b = str.length();
        return (byte) 10;
    }

    public byte o(byte b) {
        String str = (String) this.f;
        byte bN = n();
        if (bN == b) {
            return bN;
        }
        String strBo = cnf.bo(b);
        int i = this.b;
        int i2 = i - 1;
        g(this, "Expected " + strBo + ", but had '"
                + ((i == str.length() || i2 < 0) ? "EOF" : String.valueOf(str.charAt(i2))) + "' instead", i2, null, 4);
        throw null;
    }

    public void p(char c) {
        int i = this.b;
        if (i == -1) {
            aj(c);
            throw null;
        }
        String str = (String) this.f;
        while (i < str.length()) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.b = i2;
                if (cCharAt == c) {
                    return;
                }
                aj(c);
                throw null;
            }
            i = i2;
        }
        this.b = -1;
        aj(c);
        throw null;
    }

    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /*
     * JADX WARN: Type inference failed for: r6v2, types: [java.lang.String,
     * java.lang.Throwable]
     */
    /* JADX WARN: Type inference failed for: r6v9 */
    public long q() {
        boolean z;
        boolean z2;
        long j;
        double dPow;
        int iAg = ag(ah());
        String str = (String) this.f;
        ?? r6 = 0;
        if (iAg >= str.length() || iAg == -1) {
            g(this, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iAg) == '\"') {
            iAg++;
            if (iAg == str.length()) {
                g(this, "EOF", 0, null, 6);
                throw null;
            }
            z = true;
        } else {
            z = false;
        }
        int i = iAg;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long j2 = 0;
        long j3 = 0;
        while (true) {
            if (i == str.length()) {
                z2 = z;
                break;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt != 'e' && cCharAt != 'E') || z4) {
                if (cCharAt == '-' && z4) {
                    if (i == iAg) {
                        g(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    z3 = false;
                } else if (cCharAt != '+' || !z4) {
                    z2 = z;
                    if (cCharAt != '-') {
                        if (cnf.ap(cCharAt) != 0) {
                            break;
                        }
                        i++;
                        int i2 = cCharAt - '0';
                        if (i2 < 0 || i2 >= 10) {
                            g(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        if (z4) {
                            j2 = (j2 * ((long) 10)) + ((long) i2);
                        } else {
                            j3 = (j3 * ((long) 10)) - ((long) i2);
                            if (j3 > 0) {
                                g(this, "Numeric value overflow", 0, null, 6);
                                throw null;
                            }
                        }
                        z = z2;
                    } else {
                        if (i != iAg) {
                            g(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        i++;
                        z = z2;
                        r6 = 0;
                        z5 = true;
                    }
                } else {
                    if (i == iAg) {
                        g(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    r6 = 0;
                    z3 = true;
                }
                r6 = 0;
            } else {
                if (i == iAg) {
                    g(this, "Unexpected symbol " + cCharAt + " in numeric literal", 0, r6, 6);
                    throw r6;
                }
                i++;
                z3 = true;
                z4 = true;
            }
        }
        boolean z6 = i != iAg;
        if (iAg == i || (z5 && iAg == i - 1)) {
            g(this, "Expected numeric literal", 0, null, 6);
            throw null;
        }
        if (z2) {
            if (!z6) {
                g(this, "EOF", 0, null, 6);
                throw null;
            }
            if (str.charAt(i) != '\"') {
                g(this, "Expected closing quotation mark", 0, null, 6);
                throw null;
            }
            i++;
        }
        this.b = i;
        long j4 = j3;
        if (z4) {
            double d = j4;
            if (!z3) {
                dPow = Math.pow(10.0d, -j2);
            } else {
                if (!z3) {
                    throw new abt();
                }
                dPow = Math.pow(10.0d, j2);
            }
            double d2 = d * dPow;
            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                g(this, "Numeric value overflow", 0, null, 6);
                throw null;
            }
            if (Math.floor(d2) != d2) {
                g(this, "Can't convert " + d2 + " to Long", 0, null, 6);
                throw null;
            }
            j = (long) d2;
        } else {
            j = j4;
        }
        if (z5) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        g(this, "Numeric value overflow", 0, null, 6);
        throw null;
    }

    public String r() {
        String str = (String) this.d;
        if (str == null) {
            return m();
        }
        throwIfVar1IsNull(str);
        this.d = null;
        return str;
    }

    public String s() {
        String str = (String) this.f;
        String str2 = (String) this.d;
        if (str2 != null) {
            throwIfVar1IsNull(str2);
            this.d = null;
            return str2;
        }
        int iAh = ah();
        if (iAh >= str.length() || iAh == -1) {
            g(this, "EOF", iAh, null, 4);
            throw null;
        }
        byte bAp = cnf.ap(str.charAt(iAh));
        if (bAp == 1) {
            return r();
        }
        if (bAp != 0) {
            g(this, "Expected beginning of the string, but got " + str.charAt(iAh), 0, null, 6);
            throw null;
        }
        boolean z = false;
        while (cnf.ap(str.charAt(iAh)) == 0) {
            iAh++;
            if (iAh >= str.length()) {
                ((StringBuilder) this.e).append((CharSequence) str, this.b, iAh);
                int iAg = ag(iAh);
                if (iAg == -1) {
                    this.b = iAh;
                    return t(0, 0);
                }
                iAh = iAg;
                z = true;
            }
        }
        String string = !z ? str.subSequence(this.b, iAh).toString() : t(this.b, iAh);
        this.b = iAh;
        return string;
    }

    public String t(int i, int i2) {
        StringBuilder sb = (StringBuilder) this.e;
        sb.append((CharSequence) this.f, i, i2);
        String string = sb.toString();
        throwIfVar1IsNull(string, "toString(...)");
        sb.setLength(0);
        return string;
    }

    public final String toString() {
        switch (this.a) {
            case 0:
                return ((yh) this.d).toString() + ", hidden list:" + ((ArrayList) this.e).size();
            default:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.f);
                sb.append("', currentPosition=");
                return dkz.v(sb, this.b, ')');
        }
    }

    public void u(int i) {
        int iZ = z(i);
        ((yh) this.d).h(iZ);
        RecyclerView recyclerView = ((cyv) this.c).a;
        View childAt = recyclerView.getChildAt(iZ);
        if (childAt != null) {
            czx czxVarCs = RecyclerView.cs(childAt);
            if (czxVarCs != null) {
                if (czxVarCs.ah() && !czxVarCs.am()) {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(czxVarCs);
                    throw new IllegalArgumentException(yg.i(recyclerView, sb));
                }
                if (RecyclerView.b) {
                    Log.d("RecyclerView", "tmpDetach " + czxVarCs);
                }
                czxVarCs.w(256);
            }
        } else if (RecyclerView.a) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(iZ);
            throw new IllegalArgumentException(yg.i(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(iZ);
    }

    public void v(int i, String str, String str2) {
        throwIfVar1IsNull(str, "message");
        throwIfVar1IsNull(str2, "hint");
        String strConcat = str2.length() == 0 ? "" : "\n".concat(str2);
        StringBuilder sbR = concat(str, " at path: ");
        sbR.append(((ik) this.c).p());
        sbR.append(strConcat);
        throw KotlinHelpers2.ak(i, sbR.toString(), (String) this.f);
    }

    public int w(int i, CharSequence charSequence) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        g(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public View x(int i) {
        return ((cyv) this.c).a.getChildAt(z(i));
    }

    public int y() {
        return ((cyv) this.c).a.getChildCount() - ((ArrayList) this.e).size();
    }

    public int z(int i) {
        yh yhVar = (yh) this.d;
        if (i < 0) {
            return -1;
        }
        int childCount = ((cyv) this.c).a.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iD = i - (i2 - yhVar.d(i2));
            if (iD == 0) {
                while (yhVar.f(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iD;
        }
        return -1;
    }

    public yi(String str) {
        this.a = 1;
        throwIfVar1IsNull(str, "source");
        ik ikVar = new ik((byte) 0, 6);
        ikVar.c = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        ikVar.d = iArr;
        ikVar.b = -1;
        this.c = ikVar;
        this.e = new StringBuilder();
        this.f = str;
    }
}
