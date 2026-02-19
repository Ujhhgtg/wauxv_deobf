package me.hd.wauxv.obf;

import java.util.Locale;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class djh extends SwitchHook implements IDexFind {
    public static final djh a;
    public static final String[] b;
    public static final String c;
    public static final String i;
    public static final String j;
    public static final dhg m;

    static {
        "${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* "${originalText} | ${time} | ${type}" /* cnb.z(-556919819336490L)   */;
        "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-557349316066090L)   */;
        a = new djh("SnsInfoHook" /* "SnsInfoHook" /* "SnsInfoHook" /* "SnsInfoHook" /* cnb.z(-535788580240170L)   */);
        b = new String[]{"${originalText}" /* "${originalText}" /* "${originalText}" /* "${originalText}" /* cnb.z(-557310661360426L)   */, "${time}" /* "${time}" /* "${time}" /* "${time}" /* cnb.z(-557241941883690L)   */, "${type}" /* "${type}" /* "${type}" /* "${type}" /* cnb.z(-557207582145322L)   */, "${snsId}" /* "${snsId}" /* "${snsId}" /* "${snsId}" /* cnb.z(-556623466593066L)   */, "${userName}" /* "${userName}" /* "${userName}" /* "${userName}" /* cnb.z(-556533272279850L)   */};
        c = "朋友圈" /* "朋友圈" /* "朋友圈" /* "朋友圈" /* cnb.z(-556516092410666L)   */;
        i = "朋友圈底部详情" /* "朋友圈底部详情" /* "朋友圈底部详情" /* "朋友圈底部详情" /* cnb.z(-556464552803114L)   */;
        j = "为朋友圈列表项的底部添加自定义文本" /* "为朋友圈列表项的底部添加自定义文本" /* "为朋友圈列表项的底部添加自定义文本" /* "为朋友圈列表项的底部添加自定义文本" /* cnb.z(-556430193064746L)   */;
        m = new dhg(16);
    }

    public static String n(Object obj) throws IllegalAccessException {
        int i2 = 0;
        FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR.name = "field_snsId" /* "field_snsId" /* "field_snsId" /* "field_snsId" /* cnb.z(-535771400370986L)   */;
        Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
        throwIfVar1IsNull(objE);
        long jLongValue = ((Number) objE).longValue();
        FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR2.name = "field_userName" /* "field_userName" /* "field_userName" /* "field_userName" /* cnb.z(-532936721955626L)   */;
        Object objE2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue_();
        throwIfVar1IsNull(objE2);
        FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR3.name = "field_createTime" /* "field_createTime" /* "field_createTime" /* "field_createTime" /* cnb.z(-532855117577002L)   */;
        Object objE3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
        throwIfVar1IsNull(objE3);
        int iIntValue = ((Number) objE3).intValue();
        FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(obj).r();
        fieldResolverVarR4.name = "field_type" /* "field_type" /* "field_type" /* "field_type" /* cnb.z(-532799283002154L)   */;
        Object objE4 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).getValue_();
        throwIfVar1IsNull(objE4);
        int iIntValue2 = ((Number) objE4).intValue();
        String strBo = dnr.bo(djf.a.o(), "${time}" /* "${time}" /* "${time}" /* "${time}" /* cnb.z(-532769218231082L)   */,
                cnh.ag(((long) iIntValue) * 1000, djg.a.o(), null, 2));
        String strZ = "${type}" /* "${type}" /* "${type}" /* "${type}" /* cnb.z(-532734858492714L)   */;
        String strZ2 = "0x" /* "0x" /* "0x" /* "0x" /* cnb.z(-533250254568234L)   */;
        cmz.o(16);
        String string = Integer.toString(iIntValue2, 16);
        throwIfVar1IsNull(string, "toString(...)" /* "toString(...)" /* "toString(...)" /* "toString(...)" /* cnb.z(-533203009927978L)   */);
        String upperCase = string.toUpperCase(Locale.ROOT);
        throwIfVar1IsNull(upperCase, "toUpperCase(...)" /* "toUpperCase(...)" /* "toUpperCase(...)" /* "toUpperCase(...)" /* cnb.z(-533194419993386L)   */);
        return dnr.bo(dnr.bo(dnr.bo(strBo, strZ, strZ2.concat(upperCase)), "${snsId}" /* "${snsId}" /* "${snsId}" /* "${snsId}" /* cnb.z(-533121405549354L)   */,
                String.valueOf(jLongValue)), "${userName}" /* "${userName}" /* "${userName}" /* "${userName}" /* cnb.z(-533031211236138L)   */, (String) objE2);
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        boolean zAb = cnb.ab(ewk.d);
        djh djhVar = a;
        if (zAb || cnb.ac(ewh.d)) {
            HookManager hookManagerVarAb = PackageParam.createHook(djhVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(djc.a)));
            djhVar.hookAfter(hookManagerVarAb, new dhg(18));
            hookManagerVarAb.initInstantCollectionAndApplyHooks();
        } else {
            HookManager hookManagerVarAb2 = PackageParam.createHook(djhVar, dqc.toSingletonList(StaticHelpers7.toDexMethod(djd.a)));
            djhVar.hookAfter(hookManagerVarAb2, new dhg(19));
            hookManagerVarAb2.initInstantCollectionAndApplyHooks();
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        if (!cnb.ab(ewk.d) && !cnb.ac(ewh.d)) {
            StaticHelpers7.resolveDexAndCache(djd.a, dexKitBridge, new dhg(22));
        } else {
            StaticHelpers7.resolveDexAndCache(djc.a, dexKitBridge, new dhg(20));
            StaticHelpers7.resolveDexAndCache(djb.a, dexKitBridge, new dhg(21));
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return m;
    }
}
