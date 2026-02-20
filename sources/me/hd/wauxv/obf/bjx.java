package me.hd.wauxv.obf;

import android.content.ContentValues;
import android.database.Cursor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;
import net.bytebuddy.pool.TypePool;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjx extends SwitchHook implements IDexFind, bob {
    public static final bjx a;
    public static final String b;
    public static final String c;
    public static final String i;
    public static final bep m;

    static {
        "#28C445" /* "#28C445" /* "#28C445" /* cnb.z(-506788961057578L)  */;
        "退出了此群" /* "退出了此群" /* "退出了此群" /* cnb.z(-506754601319210L)  */;
        a = new bjx("HandleGroupMemberHook" /* "HandleGroupMemberHook" /* "HandleGroupMemberHook" /* cnb.z(-502979325066026L)  */);
        b = "群组" /* "群组" /* "群组" /* cnb.z(-506711651646250L)  */;
        c = "监听群成员" /* "监听群成员" /* "监听群成员" /* cnb.z(-506715946613546L)  */;
        i = "自动监听群成员退群时插入自定义提示" /* "自动监听群成员退群时插入自定义提示" /* "自动监听群成员退群时插入自定义提示" /* cnb.z(-506672996940586L)  */;
        m = new bep(4);
    }

    public static String r(String str, String str2, String str3)
            throws IllegalAccessException, InvocationTargetException {
        xj.a.getClass();
        String strB = xj.b(str2, str);
        String strB2 = xj.b(str2, "" /* "" /* "" /* cnb.z(-99252399242026L)  */);
        if (!strB.equals(strB2)) {
            strB = strB + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + strB2 + ']';
        }
        String strO = bjv.a.o();
        String str4 = "weixin://weixinhongbao/wauxv/chatroom_userinfo/"
                /* "weixin://weixinhongbao/wauxv/chatroom_userinfo/" /* "weixin://weixinhongbao/wauxv/chatroom_userinfo/" /* cnb.z(-502841886112554L)  */ + dnj.ax(str, "@chatroom" /* "@chatroom" /* "@chatroom" /* cnb.z(-502867655916330L)  */)
                + "__" /* "__" /* "__" /* cnb.z(-508683041635114L)  */ + str2;
        StringBuilder sbY = StaticHelpers6.toSb(strB);
        sbY.append("(<_wc_custom_link_ color=\"" /* "(<_wc_custom_link_ color=\"" /* "(<_wc_custom_link_ color=\"" /* cnb.z(-508635796994858L)  */);
        sbY.append(strO);
        sbY.append("\" href=\"" /* "\" href=\"" /* "\" href=\"" /* cnb.z(-508537012747050L)  */);
        sbY.append(str4);
        sbY.append("\">" /* "\">" /* "\">" /* cnb.z(-509065293724458L)  */);
        sbY.append(str2);
        sbY.append("</_wc_custom_link_>)" /* "</_wc_custom_link_>)" /* "</_wc_custom_link_>)" /* cnb.z(-509069588691754L)  */);
        sbY.append(str3);
        return sbY.toString();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(bju.a));
        bjx bjxVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(bjxVar, listBf);
        bjxVar.hookBefore(hookManagerVarAb, new bep(6));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
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
        StaticHelpers7.resolveDexAndCache(bju.a, dexKitBridge, new bep(5));
    }

    @Override // me.hd.wauxv.obf.IDatabaseOperationsListener
    public final void j(HookParam hookParam, String str, ContentValues contentValues, String str2,
            String[] strArr,
            int i2)
            throws IOException {
        if (getIsEnabled() && str.equals("chatroom" /* "chatroom" /* "chatroom" /* cnb.z(-508962214509354L)  */)) {
            String asString = contentValues.getAsString("chatroomname" /* "chatroomname" /* "chatroomname" /* cnb.z(-508923559803690L)  */);
            Integer asInteger = contentValues.getAsInteger("memberCount" /* "memberCount" /* "memberCount" /* cnb.z(-508850545359658L)  */);
            String asString2 = contentValues.getAsString("memberlist" /* "memberlist" /* "memberlist" /* cnb.z(-508833365490474L)  */);
            if (asString2 == null || dnj.ak(asString2)) {
                return;
            }
            Set setAd = StaticHelpers5.ad(dnj.as(asString2, new String[] { ";" /* ";" /* ";" /* cnb.z(-508184825428778L)  */ }));
            int i3 = 0;
            ClassSqliteDBDexFind.INSTANCE.getClass();
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ClassSqliteDBDexFind.getDb()).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-103246718827306L)  */;
            Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) }, 2, methodResolverVarT)).invoke(
                    "SELECT memberlist, memberCount FROM chatroom WHERE chatroomname = ?" /* "SELECT memberlist, memberCount FROM chatroom WHERE chatroomname = ?" /* "SELECT memberlist, memberCount FROM chatroom WHERE chatroomname = ?" /* cnb.z(-508193415363370L)  */,
                    new Object[] { asString });
            throwIfVar1IsNull(objJ);
            Cursor cursor = (Cursor) objJ;
            try {
                if (cursor.moveToFirst()) {
                    int i4 = cursor.getInt(cursor.getColumnIndex("memberCount" /* "memberCount" /* "memberCount" /* cnb.z(-508485473139498L)  */));
                    if (i4 == 0) {
                        cursor.close();
                        return;
                    }
                    String string = cursor
                            .getString(cursor.getColumnIndex("memberlist" /* "memberlist" /* "memberlist" /* cnb.z(-508399573793578L)  */));
                    if (string != null && !dnj.ak(string)) {
                        Set setAd2 = StaticHelpers5.ad(dnj.as(string, new String[] { ";" /* ";" /* ";" /* cnb.z(-508386688891690L)  */ }));
                        if (asInteger.intValue() < i4) {
                            for (String str3 : dgg.a(setAd2, setAd)) {
                                bjx bjxVar = a;
                                String strO = bjw.a.o();
                                bjxVar.getClass();
                                aye.w(ewg.j.w, asString, r(asString, str3, strO), System.currentTimeMillis());
                            }
                        }
                    }
                    cursor.close();
                    return;
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

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final bgf getOnClick() {
        return m;
    }
}
