package me.hd.wauxv.obf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfw extends bws implements bnr {
    public static final cfw a = new cfw();

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.bnr
    public final void h(Object obj) throws IllegalAccessException {
        int i = 0;
        SyntheticPileOfMess bmuVarBi = dqc.getWrapperConfiguration(obj);
        FieldResolver fieldResolverVarR = bmuVarBi.r();
        fieldResolverVarR.name = "field_isSend" /* "field_isSend" /* "field_isSend" /* "field_isSend" /* cnb.z(-61177514162986L)   */;
        Integer num = (Integer) ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue_();
        if (num != null && num.intValue() == 1) {
            return;
        }
        FieldResolver fieldResolverVarR2 = bmuVarBi.r();
        fieldResolverVarR2.name = "field_type" /* "field_type" /* "field_type" /* "field_type" /* cnb.z(-61156039326506L)   */;
        Object objE = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR2)).getValue_();
        throwIfVar1IsNull(objE);
        if (((Number) objE).intValue() == ewg.k.w) {
            FieldResolver fieldResolverVarR3 = bmuVarBi.r();
            fieldResolverVarR3.name = "field_content" /* "field_content" /* "field_content" /* "field_content" /* cnb.z(-61074434947882L)   */;
            Object objE2 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR3)).getValue_();
            throwIfVar1IsNull(objE2);
            String str = (String) objE2;
            Pattern patternCompile = Pattern.compile("\\Q<content>|WA|\\E(.*?)\\Q</content>\\E" /*
                                                                                                 * cnb.z(-
                                                                                                 * 61546881350442L)
                                                                                                 */);
            throwIfVar1IsNull(patternCompile, "compile(...)");
            Matcher matcher = patternCompile.matcher(str);
            throwIfVar1IsNull(matcher, "matcher(...)");
            bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, str);
            String str2 = bzxVarY != null ? (String) StaticHelpers5.h(1, bzxVarY.e()) : null;
            if (str2 != null) {
                FieldResolver fieldResolverVarR4 = bmuVarBi.r();
                fieldResolverVarR4.name = "field_type" /* "field_type" /* "field_type" /* "field_type" /* cnb.z(-61422327298858L)   */;
                ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR4)).setValue(Integer.valueOf(ewg.a.w));
                FieldResolver fieldResolverVarR5 = bmuVarBi.r();
                fieldResolverVarR5.name = "field_content" /* "field_content" /* "field_content" /* "field_content" /* cnb.z(-61340722920234L)   */;
                ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).setValue(str2);
            }
        }
    }
}
