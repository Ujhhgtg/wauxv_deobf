package me.hd.wauxv.obf;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AntiRevoke3Hook extends SwitchHook implements IDexFind {
    public static final AntiRevoke3Hook INSTANCE = new AntiRevoke3Hook("AntiRevoke3Hook");
    public static final String b = "聊天";
    public static final String c = "阻止消息撤回3";
    public static final String d = "消息有撤回提示，微叉款，三款选一款";
    public static final bn i = new bn(22);

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
        List listBf = dqc.toSingletonList(StaticHelpers7.toDexMethod(AntiRevoke3Hook$MethodXmlParser.INSTANCE));
        AntiRevoke3Hook antiRevoke3HookVar = INSTANCE;
        HookManager hookManagerVarAb = PackageParam.createHook(antiRevoke3HookVar, listBf);
        antiRevoke3HookVar.hookAfter(hookManagerVarAb, (obj -> {
            HookParam hookParam3 = (HookParam) obj;
            Object objX3;
            Object objX4;
            try {
                objX3 = hookParam3.getArgs()[0];
                if (objX3 == null) {
                    objX3 = null;
                }
            } catch (Throwable th4) {
                objX3 = FastKV.getFailureFromException(th4);
            }
            if (objX3 instanceof Failure) {
                objX3 = null;
            }
            String str5 = (String) objX3;
            String str6 = str5 == null ? "" : str5;
            try {
                objX4 = hookParam3.getArgs()[1];
                if (objX4 == null) {
                    objX4 = null;
                }
            } catch (Throwable th5) {
                objX4 = FastKV.getFailureFromException(th5);
            }
            if (objX4 instanceof Failure) {
                objX4 = null;
            }
            String str7 = (String) objX4;
            if ((str7 != null ? str7 : "").equals("sysmsg")
                    && StringsKt.contains(str6, "revokemsg", false)) {
                Object objF = hookParam3.getResult();
                if (!(objF instanceof Map) || ((objF instanceof IEmpty) && !(objF instanceof bsz))) {
                    objF = null;
                }
                Map map = (Map) objF;
                if (map != null) {
                    String strZ14 = ".sysmsg.$type";
                    if (map.containsKey(strZ14)
                            && nullSafeIsEqual(map.get(strZ14), "revokemsg")) {
                        Object obj3 = map.get(".sysmsg.revokemsg.session");
                        throwIfVar1IsNull(obj3);
                        String str8 = (String) obj3;
                        Object obj4 = map.get(".sysmsg.revokemsg.replacemsg");
                        throwIfVar1IsNull(obj4);
                        String str9 = (String) obj4;
                        Object obj5 = map.get(".sysmsg.revokemsg.newmsgid");
                        throwIfVar1IsNull(obj5);
                        String str10 = (String) obj5;
                        if (dnr.bp(str9, "\"", false)
                                || dnr.bp(str9, "「", false)) {
                            map.put(strZ14, null);
                            hookParam3.setResult(map);
                            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(ClassSqliteDBDexFind.getDb()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                            methodResolverVarT.name = "rawQuery";
                            Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) },
                                    2, methodResolverVarT)).invoke("SELECT createTime FROM message WHERE msgSvrId = ?" /*
                                     * cnb.z(-
                                     * 442695164099370L)
                                     */,
                                    new Object[] { str10 });
                            throwIfVar1IsNull(objJ);
                            Cursor cursor = (Cursor) objJ;
                            try {
                                if (cursor.moveToFirst()) {
                                    long j = cursor.getLong(cursor.getColumnIndex("createTime"));
                                    Pattern patternCompile = Pattern.compile("([\"「])(.*?)([」\"])");
                                    throwIfVar1IsNull(patternCompile, "compile(...)");
                                    Matcher matcher = patternCompile.matcher(str9);
                                    throwIfVar1IsNull(matcher, "matcher(...)");
                                    bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, str9);
                                    aye.w(ewg.j.w, str8,
                                            "\"" + (bzxVarY != null ? (String) ((bzv) bzxVarY.e()).get(2) : null)
                                                    + "\" " + gc.a.o(),
                                            j + 1);
                                }
                                cursor.close();
                            } catch (Throwable th6) {
                                try {
                                    throw th6;
                                } catch (Throwable th7) {
                                    cnh.m(cursor, th6);
                                    throw th7;
                                }
                            }
                        }
                    }
                }
            }
        }));
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
        StaticHelpers7.resolveDexAndCache(AntiRevoke3Hook$MethodXmlParser.INSTANCE, dexKitBridge, (obj -> {
            ((FindDexClassMethodDslWrapper) obj).onMethodCallback = (obj1 -> {
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj1;
                String[] strArr = { "com.tencent.mm.sdk.platformtools" };
                dexMethodQueryBuilderVar.a = SomeStaticHelpers.arrayToList(strArr);
                DexFinder cdjVar = new DexFinder();
                cdjVar.usingStrings("MicroMsg.SDK.XmlParser", "[ %s ]");
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
            })
        }));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return d;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return (obj -> {
            View view4 = (View) obj;
            final cee ceeVarD2 = cee.d(LayoutInflater.from(view4.getContext()));
            ceeVarD2.c.setText(gc.a.o());
            bzy bzyVar3 = new bzy(view4.getContext());
            AntiRevoke3Hook.INSTANCE.getClass();
            String str4 = AntiRevoke3Hook.c;
            eg egVar3 = (eg) bzyVar3.d;
            egVar3.d = str4;
            LinearLayout linearLayout3 = ceeVarD2.b;
            bzyVar3.t("保存", new amw(new IFunction0() {
                @Override // me.hd.wauxv.obf.bfu
                public final Object invoke() {
                    switch (i7) {
                        case 0:
                            fz.a.u(String.valueOf(ceeVarD2.c.getText()));
                            break;
                        default:
                            gc.a.u(String.valueOf(ceeVarD2.c.getText()));
                            break;
                    }
                    return Kotlin$Unit.INSTANCE;
                }
            }, 0));
            bjs.x(new amd(1), bzyVar3, "取消");
            if (linearLayout3 != null) {
                egVar3.r = linearLayout3;
            }
            bzyVar3.i().show();
        });
    }
}
