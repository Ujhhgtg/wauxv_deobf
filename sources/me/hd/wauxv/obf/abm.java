package me.hd.wauxv.obf;

import java.util.Calendar;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class abm implements bnz {
    public final /* synthetic */ int a;

    public static String b(int i, boolean z) {
        Calendar calendar = Calendar.getInstance();
        String displayName = calendar.getDisplayName(i, z ? 1 : 2, Locale.getDefault());
        if (displayName == null && z) {
            displayName = calendar.getDisplayName(i, 2, Locale.getDefault());
        }
        if (displayName == null) {
            displayName = calendar.getDisplayName(i, z ? 1 : 2, Locale.US);
        }
        return displayName == null ? Integer.toString(calendar.get(i)) : displayName;
    }

    @Override // me.hd.wauxv.obf.bnz
    public final String[] c() {
        switch (this.a) {
            case 0:
                return new String[]{"LINE_COMMENT", "BLOCK_COMMENT_START", "BLOCK_COMMENT_END"};
            case 1:
                return new String[]{"RANDOM", "RANDOM_HEX", "UUID"};
            default:
                return new String[]{"CURRENT_YEAR", "CURRENT_YEAR_SHORT", "CURRENT_MONTH", "CURRENT_DATE", "CURRENT_HOUR", "CURRENT_MINUTE", "CURRENT_SECOND", "CURRENT_DAY_NAME", "CURRENT_DAY_NAME_SHORT", "CURRENT_MONTH_NAME", "CURRENT_MONTH_NAME_SHORT", "CURRENT_SECONDS_UNIX"};
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // me.hd.wauxv.obf.bnz
    public final String resolve(String str) {
        switch (this.a) {
            case 0:
                throw new IllegalStateException("language comment style is not configured properly");
            case 1:
                str.getClass();
                switch (str) {
                    case "RANDOM":
                        return Integer.toString(new Random().nextInt());
                    case "UUID":
                        return UUID.randomUUID().toString();
                    case "RANDOM_HEX":
                        return Integer.toString(new Random().nextInt(), 16);
                    default:
                        throw new IllegalArgumentException("Unsupported variable name:".concat(str));
                }
            default:
                str.getClass();
                switch (str.hashCode()) {
                    case -1977241606:
                        if (str.equals("CURRENT_MONTH")) {
                        }
                        break;
                    case -1938173171:
                        if (str.equals("CURRENT_MONTH_NAME_SHORT")) {
                        }
                        break;
                    case -1170487366:
                        if (str.equals("CURRENT_MINUTE")) {
                        }
                        break;
                    case -1002740198:
                        if (str.equals("CURRENT_SECOND")) {
                        }
                        break;
                    case -543437420:
                        if (str.equals("CURRENT_DAY_NAME")) {
                        }
                        break;
                    case -479705388:
                        if (str.equals("CURRENT_DATE")) {
                        }
                        break;
                    case -479572726:
                        if (str.equals("CURRENT_HOUR")) {
                        }
                        break;
                    case -479076509:
                        if (str.equals("CURRENT_YEAR")) {
                        }
                        break;
                    case 414727665:
                        if (str.equals("CURRENT_DAY_NAME_SHORT")) {
                        }
                        break;
                    case 436056206:
                        if (str.equals("CURRENT_SECONDS_UNIX")) {
                        }
                        break;
                    case 1426745264:
                        if (str.equals("CURRENT_MONTH_NAME")) {
                        }
                        break;
                    case 1948743808:
                        if (str.equals("CURRENT_YEAR_SHORT")) {
                        }
                        break;
                }
                /*  JADX ERROR: Method code generation error
                    java.lang.NullPointerException: Switch insn not found in header
                    	at java.base/java.util.Objects.requireNonNull(Objects.java:235)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                    	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    */
                /*
                    Method dump skipped, instruction units count: 556
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.abm.resolve(java.lang.String):java.lang.String");
            }
        }
