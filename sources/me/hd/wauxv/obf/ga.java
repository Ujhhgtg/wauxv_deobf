package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ga extends SwitchHook implements IDatabaseOperationsListener, bng {
    public static final ga a = new ga("AntiRevoke2Hook" /* "AntiRevoke2Hook" /* "AntiRevoke2Hook" /* cnb.z(-454085417368362L)  */);
    public static final String b = "聊天" /* "聊天" /* "聊天" /* cnb.z(-454776907103018L)  */;
    public static final String c = "阻止消息撤回2" /* "阻止消息撤回2" /* "阻止消息撤回2" /* cnb.z(-454781202070314L)  */;
    public static final String d = "消息有撤回提示，通用款，三款选一款" /* "消息有撤回提示，通用款，三款选一款" /* "消息有撤回提示，通用款，三款选一款" /* cnb.z(-454746842331946L)  */;
    public static final bn i = new bn(14);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void getThisObject() throws NoSuchMethodException {
        Iterator it = OtherStaticHelpers.argsToList(fw.a, fy.a, fx.a).iterator();
        while (it.hasNext()) {
            Class clsAz = StaticHelpers7.toDexClass((DexDescData) it.next());
            int i2 = 0;
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(clsAz).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.returnType = Void.TYPE;
            methodResolverVarT.parameterCount = 1;
            MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods());
            HookPriorityEnum hookPriorityEnumVar = HookPriorityEnum.ENUM_DEFAULT;
            ga gaVar = a;
            HookManager hookManagerVarAd = gaVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
            gaVar.hookBefore(hookManagerVarAd, new bn(18));
            hookManagerVarAd.initInstantCollectionAndApplyHooks();
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(fw.a, dexKitBridge, new bn(15));
        StaticHelpers7.resolveDexAndCache(fy.a, dexKitBridge, new bn(16));
        StaticHelpers7.resolveDexAndCache(fx.a, dexKitBridge, new bn(17));
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void j(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr,
            int i2)
            throws IOException {
        if (getIsEnabled() && str.equals("message" /* "message" /* "message" /* cnb.z(-454016697891626L)  */)
                && nullSafeIsEqual(contentValues.get("type" /* "type" /* "type" /* cnb.z(-453982338153258L)  */),
                        Integer.valueOf(ewg.l.w))) {
            String asString = contentValues.getAsString("content" /* "content" /* "content" /* cnb.z(-453943683447594L)  */);
            if (dnr.bp(asString, "\"" /* "\"" /* "\"" /* cnb.z(-453909323709226L)  */, false) || dnr.bp(asString, "「" /*
                                                                                                      * cnb.z(-
                                                                                                      * 453917913643818L)
                                                                                                      */, false)) {
                Long asLong = contentValues.getAsLong("msgId" /* "msgId" /* "msgId" /* cnb.z(-453926503578410L)  */);
                int i3 = 0;
                ClassSqliteDBDexFind.INSTANCE.getClass();
                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ClassSqliteDBDexFind.getDb()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                methodResolverVarT.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-103246718827306L)  */;
                Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) }, 2, methodResolverVarT)).invoke(
                        "SELECT createTime, talker FROM message WHERE msgId = ?" /* "SELECT createTime, talker FROM message WHERE msgId = ?" /* "SELECT createTime, talker FROM message WHERE msgId = ?" /* cnb.z(-453883553905450L)  */,
                        new Object[] { asLong });
                throwIfVar1IsNull(objJ);
                Cursor cursor = (Cursor) objJ;
                try {
                    if (cursor.moveToFirst()) {
                        long j = cursor.getLong(cursor.getColumnIndex("createTime" /* "createTime" /* "createTime" /* cnb.z(-453080395021098L)  */));
                        String string = cursor
                                .getString(cursor.getColumnIndex("talker" /* "talker" /* "talker" /* cnb.z(-453067510119210L)  */));
                        Pattern patternCompile = Pattern.compile("([\"「])(.*?)([」\"])" /* "([\"「])(.*?)([」\"])" /* "([\"「])(.*?)([」\"])" /* cnb.z(-453020265478954L)  */);
                        throwIfVar1IsNull(patternCompile, "compile(...)");
                        Matcher matcher = patternCompile.matcher(asString);
                        throwIfVar1IsNull(matcher, "matcher(...)");
                        bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, asString);
                        aye.w(ewg.j.w, string, "\"" + (bzxVarY != null ? (String) ((bzv) bzxVarY.e()).get(2) : null)
                                + "\" " /* "\" " /* "\" " /* cnb.z(-453509891750698L)  */ + fz.a.o(), j + 1);
                        hookParam.setResult(1);
                    }
                    cursor.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        cnh.m(cursor, th);
                        throw th2;
                    }
                }
            }
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return i;
    }
}
