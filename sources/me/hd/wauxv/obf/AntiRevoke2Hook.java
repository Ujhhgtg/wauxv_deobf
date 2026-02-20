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
public final class AntiRevoke2Hook extends SwitchHook implements IDatabaseOperationsListener, bng {
    public static final AntiRevoke2Hook a = new AntiRevoke2Hook("AntiRevoke2Hook");
    public static final String b = "聊天";
    public static final String c = "阻止消息撤回2";
    public static final String d = "消息有撤回提示，通用款，三款选一款";
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
            AntiRevoke2Hook antiRevoke2HookVar = a;
            HookManager hookManagerVarAd = antiRevoke2HookVar.createImmediateHook(methodHookWrapperVar, hookPriorityEnumVar);
            antiRevoke2HookVar.hookBefore(hookManagerVarAd, new bn(18));
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
                        long j = cursor.getLong(cursor.getColumnIndex("createTime"));
                        String string = cursor
                                .getString(cursor.getColumnIndex("talker"));
                        Pattern patternCompile = Pattern.compile("([\"「])(.*?)([」\"])");
                        throwIfVar1IsNull(patternCompile, "compile(...)");
                        Matcher matcher = patternCompile.matcher(asString);
                        throwIfVar1IsNull(matcher, "matcher(...)");
                        bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, asString);
                        aye.w(ewg.j.w, string, "\"" + (bzxVarY != null ? (String) ((bzv) bzxVarY.e()).get(2) : null)
                                + "\" " + fz.a.o(), j + 1);
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
