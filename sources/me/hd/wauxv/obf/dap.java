package me.hd.wauxv.obf;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dap implements Serializable {
    public final Pattern a;

    public dap(String str) {
        throwIfVar1IsNull(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        throwIfVar1IsNull(patternCompile, "compile(...)");
        this.a = patternCompile;
    }

    public static alu b(dap dapVar, String str) {
        throwIfVar1IsNull(str, "input");
        if (str.length() >= 0) {
            return new alu(new ls(dapVar, 8, str), dao.a);
        }
        StringBuilder sbR = yg.concatVar213(0, "Start index out of bounds: ", ", input length: ");
        sbR.append(str.length());
        throw new IndexOutOfBoundsException(sbR.toString());
    }

    public final boolean c(CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "input");
        return this.a.matcher(charSequence).find();
    }

    public final bzx d(CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "input");
        Matcher matcher = this.a.matcher(charSequence);
        throwIfVar1IsNull(matcher, "matcher(...)");
        return StaticAndroidHelpers.y(matcher, 0, charSequence);
    }

    public final bzx e(String str) {
        throwIfVar1IsNull(str, "input");
        Matcher matcher = this.a.matcher(str);
        throwIfVar1IsNull(matcher, "matcher(...)");
        if (matcher.matches()) {
            return new bzx(matcher, str);
        }
        return null;
    }

    public final boolean f(CharSequence charSequence) {
        throwIfVar1IsNull(charSequence, "input");
        return this.a.matcher(charSequence).matches();
    }

    public final String toString() {
        String string = this.a.toString();
        throwIfVar1IsNull(string, "toString(...)");
        return string;
    }

    public dap(String str, int i) {
        throwIfVar1IsNull(str, "pattern");
        Pattern patternCompile = Pattern.compile(str, 66);
        throwIfVar1IsNull(patternCompile, "compile(...)");
        this.a = patternCompile;
    }
}
