package me.hd.wauxv.obf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhq {
    public static final bhq a;

    static {
        "HdShare" /* cnb.z(-45492293597994L) */;
        "WAuxiliary_Public" /* cnb.z(-45457933859626L) */;
        a = new bhq();
    }

    public static final bhm b(bhq bhqVar, String str) {
        bhqVar.getClass();
        Pattern patternCompile = Pattern.compile("^(\\d+\\.\\d+\\.\\d+)\\.r(\\d+)\\.(\\w+)$" /*
                                                                                              * cnb.z(-45140106279722L)
                                                                                              */);
        throwIfVar1IsNull(patternCompile, "compile(...)");
        throwIfVar1IsNull(str, "input");
        Matcher matcher = patternCompile.matcher(str);
        throwIfVar1IsNull(matcher, "matcher(...)");
        bzx bzxVar = !matcher.matches() ? null : new bzx(matcher, str);
        if (bzxVar == null) {
            return new bhm("1.0.0" /* cnb.z(-45548128172842L) */, 1, "standalone" /* cnb.z(-45505178499882L) */);
        }
        String str2 = (String) ((bzv) bzxVar.e()).get(1);
        Integer numBf = dnq.bf((String) ((bzv) bzxVar.e()).get(2));
        return new bhm(str2, numBf != null ? numBf.intValue() : 1, (String) ((bzv) bzxVar.e()).get(3));
    }
}
