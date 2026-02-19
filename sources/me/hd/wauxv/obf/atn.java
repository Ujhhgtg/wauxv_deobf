package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class atn implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ atn(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:222:0x069d */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Class cls;
        Class cls2;
        Object objX;
        Object objX2;
        boolean z;
        Object objX3;
        Object objX4;
        Class cls3;
        Object objX5;
        Object objX6;
        Object objX7;
        int i = this.a;
        cls = String.class;
        Class cls4 = Integer.TYPE;
        int i2 = R.id.MenuItem_Group;
        final int i3 = 3;
        int i4 = 12;
        final int i5 = 2;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        switch (i) {
            case 0:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new atn(1 == true ? 1 : 0);
                return kotlinUnitVar;
            case 1:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.emoji.EmojiFileEncryptMgr" /* "MicroMsg.emoji.EmojiFileEncryptMgr" /* "MicroMsg.emoji.EmojiFileEncryptMgr" /* cnb.z(-90284507527978L)  */,
                        "decode emoji file failed. path is no exist :%s " /* "decode emoji file failed. path is no exist :%s " /* "decode emoji file failed. path is no exist :%s " /* cnb.z(-90649579748138L)  */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 2:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_emoji_game, null, false);
                int i6 = R.id.moduleDialogRbEmojiGameDice1;
                MaterialRadioButton materialRadioButton = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogRbEmojiGameDice1);
                if (materialRadioButton != null) {
                    i6 = R.id.moduleDialogRbEmojiGameDice2;
                    MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogRbEmojiGameDice2);
                    if (materialRadioButton2 != null) {
                        i6 = R.id.moduleDialogRbEmojiGameDice3;
                        MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogRbEmojiGameDice3);
                        if (materialRadioButton3 != null) {
                            i6 = R.id.moduleDialogRbEmojiGameDice4;
                            MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogRbEmojiGameDice4);
                            if (materialRadioButton4 != null) {
                                i6 = R.id.moduleDialogRbEmojiGameDice5;
                                MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogRbEmojiGameDice5);
                                if (materialRadioButton5 != null) {
                                    i6 = R.id.moduleDialogRbEmojiGameDice6;
                                    MaterialRadioButton materialRadioButton6 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogRbEmojiGameDice6);
                                    if (materialRadioButton6 != null) {
                                        i6 = R.id.moduleDialogRbEmojiGameMorra0;
                                        MaterialRadioButton materialRadioButton7 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogRbEmojiGameMorra0);
                                        if (materialRadioButton7 != null) {
                                            i6 = R.id.moduleDialogRbEmojiGameMorra1;
                                            MaterialRadioButton materialRadioButton8 = (MaterialRadioButton) KotlinHelpers2
                                                    .recursivelyFindViewById(viewK, R.id.moduleDialogRbEmojiGameMorra1);
                                            if (materialRadioButton8 != null) {
                                                i6 = R.id.moduleDialogRbEmojiGameMorra2;
                                                MaterialRadioButton materialRadioButton9 = (MaterialRadioButton) KotlinHelpers2
                                                        .recursivelyFindViewById(viewK, R.id.moduleDialogRbEmojiGameMorra2);
                                                if (materialRadioButton9 != null) {
                                                    i6 = R.id.moduleDialogRgEmojiGameDice;
                                                    RadioGroup radioGroup = (RadioGroup) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                            R.id.moduleDialogRgEmojiGameDice);
                                                    if (radioGroup != null) {
                                                        i6 = R.id.moduleDialogRgEmojiGameMorra;
                                                        RadioGroup radioGroup2 = (RadioGroup) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                R.id.moduleDialogRgEmojiGameMorra);
                                                        if (radioGroup2 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) viewK;
                                                            cen cenVar = new cen(linearLayout, materialRadioButton,
                                                                    materialRadioButton2, materialRadioButton3,
                                                                    materialRadioButton4, materialRadioButton5,
                                                                    materialRadioButton6, materialRadioButton7,
                                                                    materialRadioButton8, materialRadioButton9,
                                                                    radioGroup, radioGroup2);
                                                            int iK = atw.a.k();
                                                            if (iK == atu.a.f) {
                                                                materialRadioButton7.setChecked(true);
                                                            } else if (iK == atu.b.f) {
                                                                materialRadioButton8.setChecked(true);
                                                            } else if (iK == atu.c.f) {
                                                                materialRadioButton9.setChecked(true);
                                                            }
                                                            int iK2 = atv.a.k();
                                                            if (iK2 == atr.a.i) {
                                                                materialRadioButton.setChecked(true);
                                                            } else if (iK2 == atr.b.i) {
                                                                materialRadioButton2.setChecked(true);
                                                            } else if (iK2 == atr.c.i) {
                                                                materialRadioButton3.setChecked(true);
                                                            } else if (iK2 == atr.d.i) {
                                                                materialRadioButton4.setChecked(true);
                                                            } else if (iK2 == atr.e.i) {
                                                                materialRadioButton5.setChecked(true);
                                                            } else if (iK2 == atr.f.i) {
                                                                materialRadioButton6.setChecked(true);
                                                            }
                                                            bzy bzyVar = new bzy(view.getContext());
                                                            eg egVar = (eg) bzyVar.d;
                                                            atx.a.getClass();
                                                            egVar.d = atx.c;
                                                            bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-507875587783466L)  */,
                                                                    new amw(new bp(cenVar, 19), 0));
                                                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /*
                                                                                                                  * cnb.
                                                                                                                  * z(-
                                                                                                                  * 47455093652266L)
                                                                                                                  */);
                                                            if (linearLayout != null) {
                                                                egVar.r = linearLayout;
                                                            }
                                                            bzyVar.i().show();
                                                            return kotlinUnitVar;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-638988054428458L)  */.concat(viewK.getResources().getResourceName(i6)));
            case 3:
                bah bahVar = (bah) obj;
                String[] strArr = { "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* cnb.z(-506887745305386L)  */ };
                bahVar.getClass();
                bahVar.a = SomeStaticHelpers.ab(strArr);
                cdj cdjVar = new cdj();
                cls2 = Integer.class;
                Class<Integer> clsBf = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
                if (clsBf == null) {
                    clsBf = cls2;
                }
                cdjVar.r(clsBf);
                Class<Integer> clsBf2 = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
                if (clsBf2 == null) {
                    clsBf2 = cls2;
                }
                Class<Integer> clsBf3 = HugeSyntheticPileOfHelpers.bf(dal.b(cls2));
                cdjVar.q(clsBf2, clsBf3 != null ? clsBf3 : Integer.class);
                fj fjVar = new fj();
                cdj cdjVar2 = new cdj();
                cdjVar2.s("currentTimeMillis" /* "currentTimeMillis" /* "currentTimeMillis" /* cnb.z(-507312947067690L)  */);
                fjVar.f(cdjVar2);
                cdj cdjVar3 = new cdj();
                cdjVar3.s("nextInt" /* "nextInt" /* "nextInt" /* cnb.z(-507252817525546L)  */);
                fjVar.f(cdjVar3);
                fjVar.d = bzu.Contains;
                cdjVar.i = fjVar;
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 4:
                bah bahVar2 = (bah) obj;
                cdj cdjVar4 = new cdj();
                cdjVar4.t("MicroMsg.EmojiPanelClickListener" /* "MicroMsg.EmojiPanelClickListener" /* "MicroMsg.EmojiPanelClickListener" /* cnb.z(-507218457787178L)  */,
                        "penn send capture emoji click emoji: %s status: %d." /* "penn send capture emoji click emoji: %s status: %d." /* "penn send capture emoji click emoji: %s status: %d." /* cnb.z(-495531851774762L)  */);
                bahVar2.getClass();
                bahVar2.d = cdjVar4;
                return kotlinUnitVar;
            case 5:
                final HookParam hookParam = (HookParam) obj;
                atx atxVar = atx.a;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[3];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                throwIfVar1IsNull(objX);
                int i7 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objX).r();
                StaticHelpers2.ao(fieldResolverVarR.modifiers, (cdy[]) Arrays.copyOf(new cdy[] { cdy.d }, 1));
                fieldResolverVarR.fieldType = dal.b(cls4);
                Object objE = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).e();
                throwIfVar1IsNull(objE);
                if (((Number) objE).intValue() == 0) {
                    FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objX).r();
                    fieldResolverVarR2.fieldType = "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-507897062619946L)  */;
                    Object objD = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).d();
                    throwIfVar1IsNull(objD);
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.name = "getMd5" /* "getMd5" /* "getMd5" /* cnb.z(-507751033731882L)  */;
                    Object objJ = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).j(new Object[0]);
                    throwIfVar1IsNull(objJ);
                    String str = (String) objJ;
                    if (str.equals("9bd1281af3a31710a45b84d736363691" /* "9bd1281af3a31710a45b84d736363691" /* "9bd1281af3a31710a45b84d736363691" /* cnb.z(-507703789091626L)  */)) {
                        atxVar.getClass();
                        hookParam.setResult(null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(aye.v());
                        builder.setTitle("选择猜拳" /* "选择猜拳" /* "选择猜拳" /* cnb.z(-507480450792234L)  */);
                        RadioGroup radioGroup3 = new RadioGroup(builder.getContext());
                        radioGroup3.setGravity(17);
                        radioGroup3.setOrientation(0);
                        Iterator it = atu.e.iterator();
                        while (true) {
                            z zVar = (z) it;
                            if (zVar.hasNext()) {
                                atu atuVar = (atu) zVar.next();
                                RadioButton radioButton = new RadioButton(radioGroup3.getContext());
                                radioButton.setId(atuVar.f);
                                radioButton.setText(atuVar.g);
                                radioButton.setOnClickListener(new bq(atuVar, 7));
                                radioGroup3.addView(radioButton);
                            } else {
                                builder.setView(radioGroup3);
                                builder.setPositiveButton("发送" /* "发送" /* "发送" /* cnb.z(-507441796086570L)  */,
                                        new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i8) {
                                                switch (iIntValue) {
                                                    case 0:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 1:
                                                        atw.a.r(cyj.f._bi(3));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 2:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    default:
                                                        atv.a.r(cyj.f._bi(6));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                }
                                            }
                                        });
                                CharSequence charSequenceZ = "随机" /* "随机" /* "随机" /* cnb.z(-507446091053866L)  */;
                                final char c = 1 == true ? 1 : 0;
                                builder.setNeutralButton(charSequenceZ, new DialogInterface.OnClickListener() { // from
                                                                                                                // class:
                                                                                                                // me.hd.wauxv.obf.atq
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i8) {
                                        switch (c) {
                                            case 0:
                                                hookParam.callOriginalMethod();
                                                break;
                                            case 1:
                                                atw.a.r(cyj.f._bi(3));
                                                hookParam.callOriginalMethod();
                                                break;
                                            case 2:
                                                hookParam.callOriginalMethod();
                                                break;
                                            default:
                                                atv.a.r(cyj.f._bi(6));
                                                hookParam.callOriginalMethod();
                                                break;
                                        }
                                    }
                                });
                                builder.setNegativeButton("取消" /* "取消" /* "取消" /* cnb.z(-507948602227498L)  */,
                                        (DialogInterface.OnClickListener) null);
                                builder.show();
                            }
                        }
                    } else if (str.equals("08f223fa83f1ca34e143d1e580252c7c" /* "08f223fa83f1ca34e143d1e580252c7c" /* "08f223fa83f1ca34e143d1e580252c7c" /* cnb.z(-507029479226154L)  */)) {
                        atxVar.getClass();
                        hookParam.setResult(null);
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(aye.v());
                        builder2.setTitle("选择骰子" /* "选择骰子" /* "选择骰子" /* cnb.z(-507952897194794L)  */);
                        RadioGroup radioGroup4 = new RadioGroup(builder2.getContext());
                        radioGroup4.setGravity(17);
                        radioGroup4.setOrientation(0);
                        Iterator it2 = atr.h.iterator();
                        while (true) {
                            z zVar2 = (z) it2;
                            if (zVar2.hasNext()) {
                                atr atrVar = (atr) zVar2.next();
                                RadioButton radioButton2 = new RadioButton(radioGroup4.getContext());
                                radioButton2.setId(atrVar.i);
                                radioButton2.setText(atrVar.j);
                                radioButton2.setOnClickListener(new bq(atrVar, 6));
                                radioGroup4.addView(radioButton2);
                            } else {
                                builder2.setView(radioGroup4);
                                builder2.setPositiveButton("发送" /* "发送" /* "发送" /* cnb.z(-507914242489130L)  */,
                                        new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i8) {
                                                switch (i5) {
                                                    case 0:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 1:
                                                        atw.a.r(cyj.f._bi(3));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 2:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    default:
                                                        atv.a.r(cyj.f._bi(6));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                }
                                            }
                                        });
                                builder2.setNeutralButton("随机" /* "随机" /* "随机" /* cnb.z(-507918537456426L)  */,
                                        new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                            @Override // android.content.DialogInterface.OnClickListener
                                            public final void onClick(DialogInterface dialogInterface, int i8) {
                                                switch (i3) {
                                                    case 0:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 1:
                                                        atw.a.r(cyj.f._bi(3));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    case 2:
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                    default:
                                                        atv.a.r(cyj.f._bi(6));
                                                        hookParam.callOriginalMethod();
                                                        break;
                                                }
                                            }
                                        });
                                builder2.setNegativeButton("取消" /* "取消" /* "取消" /* cnb.z(-507940012292906L)  */,
                                        (DialogInterface.OnClickListener) null);
                                builder2.show();
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(i3);
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(4);
                return kotlinUnitVar;
            case 8:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                Integer num = (Integer) objX2;
                iIntValue = num != null ? num.intValue() : 0;
                Object objF = hookParam2.getResult();
                Integer numValueOf = (Integer) (objF instanceof Integer ? objF : null);
                if (iIntValue == 2) {
                    numValueOf = Integer.valueOf(atw.a.k());
                } else if (iIntValue == 5) {
                    numValueOf = Integer.valueOf(atv.a.k());
                }
                hookParam2.setResult(numValueOf);
                return kotlinUnitVar;
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(10);
                return kotlinUnitVar;
            case 10:
                bah bahVar3 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdj.l(cdjVar5, "com.tencent.mm.storage.emotion.EmojiInfo" /* "com.tencent.mm.storage.emotion.EmojiInfo" /* "com.tencent.mm.storage.emotion.EmojiInfo" /* cnb.z(-75471165324074L)  */);
                cdjVar5.t("save emoji thumb error" /* "save emoji thumb error" /* "save emoji thumb error" /* cnb.z(-75844827478826L)  */);
                bahVar3.getClass();
                bahVar3.d = cdjVar5;
                return kotlinUnitVar;
            case 11:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new atn(i4);
                return kotlinUnitVar;
            case 12:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k("MicroMsg.emoji.EmojiInfoStorage" /* "MicroMsg.emoji.EmojiInfoStorage" /* "MicroMsg.emoji.EmojiInfoStorage" /* cnb.z(-91976724642602L)  */,
                        "md5 is null or invalue. md5:%s" /* "md5 is null or invalue. md5:%s" /* "md5 is null or invalue. md5:%s" /* cnb.z(-91839285689130L)  */);
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return kotlinUnitVar;
            case 13:
                List list = (List) obj;
                Object obj2 = list.get(0);
                Class<String> clsBf4 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                if (nullSafeIsEqual(obj2, clsBf4 != null ? clsBf4 : String.class)) {
                    Object obj3 = list.get(1);
                    atz.a.getClass();
                    if (nullSafeIsEqual(obj3, StaticHelpers7.bb(aty.a).getDeclaringClass())) {
                        Object obj4 = list.get(2);
                        cge.a.getClass();
                        z = nullSafeIsEqual(obj4, StaticHelpers7.az(cgd.a));
                    }
                }
                return Boolean.valueOf(z);
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new atn(15);
                return kotlinUnitVar;
            case 15:
                bag bagVar3 = (bag) obj;
                zb zbVar3 = new zb();
                zbVar3.k("MicroMsg.emoji.EmojiMgrImpl" /* "MicroMsg.emoji.EmojiMgrImpl" /* "MicroMsg.emoji.EmojiMgrImpl" /* cnb.z(-92105573661482L)  */, "sendEmoji: context is null" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 91401199024938L)
                                                                                                                    */);
                bagVar3.getClass();
                bagVar3.b = zbVar3;
                return kotlinUnitVar;
            case 16:
                View view2 = (View) obj;
                cee ceeVarE = cee.e(LayoutInflater.from(view2.getContext()));
                ceeVarE.c.setText(aum.a.o());
                bzy bzyVar2 = new bzy(view2.getContext());
                aun.a.getClass();
                String str2 = aun.h;
                eg egVar2 = (eg) bzyVar2.d;
                egVar2.d = str2;
                LinearLayout linearLayout2 = ceeVarE.b;
                bzyVar2.t("保存" /* "保存" /* "保存" /* cnb.z(-519081157458730L)  */, new amw(new aul(ceeVarE, 0), 0));
                bzyVar2.s("重置" /* "重置" /* "重置" /* cnb.z(-519085452426026L)  */, new amw(new amd(2), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout2 != null) {
                    egVar2.r = linearLayout2;
                }
                bzyVar2.i().show();
                return kotlinUnitVar;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new atn(18);
                return kotlinUnitVar;
            case 18:
                bag bagVar4 = (bag) obj;
                String[] strArr2 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-91676076931882L)  */ };
                bagVar4.getClass();
                bagVar4.a = SomeStaticHelpers.ab(strArr2);
                zb zbVar4 = new zb();
                zbVar4.k("MicroMsg.emoji.EmojiStorageMgr" /* "MicroMsg.emoji.EmojiStorageMgr" /* "MicroMsg.emoji.EmojiStorageMgr" /* cnb.z(-91577292684074L)  */, "EmojiStorageMgr: %s" /*
                                                                                                                * cnb.z(
                                                                                                                * -
                                                                                                                * 88746909236010L)
                                                                                                                */);
                bagVar4.b = zbVar4;
                return kotlinUnitVar;
            case 19:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX3 = hookParam3.getArgs()[0];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.x(th3);
                }
                if (objX3 instanceof dcx) {
                    objX3 = null;
                }
                throwIfVar1IsNull(objX3);
                String str3 = (String) objX3;
                try {
                    objX4 = hookParam3.getArgs()[1];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.x(th4);
                }
                for (bni bniVar : axu.b) {
                    try {
                        if (((diw) bniVar).z() && str3.equals("clicfg_sns_use_expandable_video_seek_bar" /*
                                                                                                          * cnb.z(-
                                                                                                          * 608734304795434L)
                                                                                                          */)) {
                            hookParam3.setResult("1" /* "1" /* "1" /* cnb.z(-609107966950186L)  */);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onGetExptConfig " /* "onGetExptConfig " /* "onGetExptConfig " /* cnb.z(-36717675412266L)  */);
                        ewq.e(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bniVar instanceof SwitchHook ? ((SwitchHook) bniVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 36661840837418L)
                                                                                                               */,
                                -36623186131754L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(21);
                return kotlinUnitVar;
            case 21:
                bah bahVar4 = (bah) obj;
                cdj cdjVar6 = new cdj();
                Class<String> clsBf5 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                if (clsBf5 == null) {
                    clsBf5 = cls;
                }
                cdjVar6.r(clsBf5);
                Class<String> clsBf6 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                if (clsBf6 == null) {
                    clsBf6 = cls;
                }
                Class<String> clsBf7 = HugeSyntheticPileOfHelpers.bf(dal.b(cls));
                cls = clsBf7 != null ? clsBf7 : String.class;
                cls3 = Boolean.class;
                Class<Boolean> clsBf8 = HugeSyntheticPileOfHelpers.bf(dal.b(cls3));
                cdjVar6.q(clsBf6, cls, clsBf8 != null ? clsBf8 : Boolean.class);
                cdjVar6.t("MicroMsg.ExptService" /* "MicroMsg.ExptService" /* "MicroMsg.ExptService" /* cnb.z(-36588826393386L)  */,
                        "Fail to query value, return default value '%s' instead." /* "Fail to query value, return default value '%s' instead." /* "Fail to query value, return default value '%s' instead." /* cnb.z(-42528766163754L)  */);
                bahVar4.getClass();
                bahVar4.d = cdjVar6;
                return kotlinUnitVar;
            case 22:
                HookParam hookParam4 = (HookParam) obj;
                LinkedHashSet<bnj> linkedHashSet = ayy.b;
                hookParam4.getClass();
                try {
                    objX5 = hookParam4.getArgs()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = FastKV.x(th5);
                }
                Object obj5 = objX5 instanceof dcx ? null : objX5;
                throwIfVar1IsNull(obj5);
                ContextMenu contextMenu = (ContextMenu) obj5;
                if (cnb.ab(ewk.b) || cnb.ac(ewh.c)) {
                    int i8 = 0;
                    FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(contextMenu).r();
                    fieldResolverVarR3.fieldType = dal.b(Context.class);
                    Object objE2 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).e();
                    throwIfVar1IsNull(objE2);
                    Resources resources = ((Context) objE2).getResources();
                    if (resources != null) {
                        HugeSyntheticPileOfHelpers.injectModuleAssets(resources);
                    }
                    Kotlin$Lazy kotlin$LazyVar = new Kotlin$Lazy(new ayu(contextMenu, 0));
                    for (bnj bnjVar : linkedHashSet) {
                        try {
                            for (ayv ayvVar : ((cif) bnjVar).i()) {
                                MethodHookWrapper methodHookWrapperVarD = ((MethodHookWrapper) kotlin$LazyVar.getValue()).d();
                                methodHookWrapperVarD.dexFind(contextMenu);
                                try {
                                    Integer numValueOf2 = Integer.valueOf(R.id.MenuItem_Group);
                                    ayvVar.getClass();
                                    methodHookWrapperVarD.e(numValueOf2, Integer.valueOf(R.id.MenuItem_Fav_Forward), 0, ayvVar.a,
                                            Integer.valueOf(R.drawable.ic_menu_forward_24dp));
                                } catch (Exception e2) {
                                    e = e2;
                                    ArrayList arrayList2 = ewq.a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-42013370088234L)  */);
                                    ewq.e(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                            bnjVar instanceof SwitchHook ? ((SwitchHook) bnjVar).getResult()
                                                    : "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-41948945578794L)  */,
                                            -41858751265578L), e, 12);
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                } else {
                    for (bnj bnjVar2 : linkedHashSet) {
                        try {
                            for (ayv ayvVar2 : ((cif) bnjVar2).i()) {
                                ayvVar2.getClass();
                                contextMenu.add(R.id.MenuItem_Group, R.id.MenuItem_Fav_Forward, 0, ayvVar2.a);
                            }
                        } catch (Exception e4) {
                            ArrayList arrayList3 = ewq.a;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-41824391527210L)  */);
                            ewq.e(yg.decryptVar3UsingCnbZAndConcatToVar1(sb3, bnjVar2 instanceof SwitchHook ? ((SwitchHook) bnjVar2).getResult()
                                    : "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-42309722831658L)  */, -42288247995178L), e4, 12);
                        }
                    }
                }
                return kotlinUnitVar;
            case 23:
                HookParam hookParam5 = (HookParam) obj;
                hookParam5.getClass();
                try {
                    objX6 = hookParam5.getArgs()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = FastKV.x(th6);
                }
                Object obj6 = objX6 instanceof dcx ? null : objX6;
                throwIfVar1IsNull(obj6);
                MenuItem menuItem = (MenuItem) obj6;
                int i9 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam5);
                fieldResolverVarAa.fieldType = dal.b(cls4);
                Object objE3 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).e();
                throwIfVar1IsNull(objE3);
                int iIntValue = ((Number) objE3).intValue();
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam5);
                fieldResolverVarAa2.fieldType = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI" /* "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI" /* "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI" /* cnb.z(-42253888256810L)  */;
                Object objE4 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).e();
                throwIfVar1IsNull(objE4);
                FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration((Activity) objE4).r();
                fieldResolverVarR4.b = new atn(26);
                Object objE5 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).e();
                throwIfVar1IsNull(objE5);
                Object item = ((BaseAdapter) objE5).getItem(iIntValue);
                for (bnj bnjVar3 : ayy.b) {
                    try {
                        for (ayv ayvVar3 : ((cif) bnjVar3).i()) {
                            int itemId = menuItem.getItemId();
                            ayvVar3.getClass();
                            if (itemId == R.id.MenuItem_Fav_Forward) {
                                ayvVar3.b.invoke(item);
                            }
                        }
                    } catch (Exception e5) {
                        ArrayList arrayList4 = ewq.a;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-43675522431786L)  */);
                        ewq.e(yg.decryptVar3UsingCnbZAndConcatToVar1(sb4,
                                bnjVar3 instanceof SwitchHook ? ((SwitchHook) bnjVar3).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 43628277791530L)
                                                                                                                 */,
                                -43589623085866L), e5, 12);
                    }
                }
                return kotlinUnitVar;
            case 24:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(28);
                return kotlinUnitVar;
            case 25:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new atn(27);
                return kotlinUnitVar;
            case 26:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(),
                        "com.tencent.mm.plugin.fav.ui.adapter." /* "com.tencent.mm.plugin.fav.ui.adapter." /* "com.tencent.mm.plugin.fav.ui.adapter." /* cnb.z(-43555263347498L)  */, false));
            case 27:
                bah bahVar5 = (bah) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* cnb.z(-43383464655658L)  */ };
                bahVar5.getClass();
                bahVar5.a = SomeStaticHelpers.ab(strArr3);
                cdj cdjVar7 = new cdj();
                cdjVar7.t("MicroMsg.FavoriteIndexUI" /* "MicroMsg.FavoriteIndexUI" /* "MicroMsg.FavoriteIndexUI" /* cnb.z(-43241730734890L)  */, "onMMMenuItemSelected" /*
                                                                                                            * cnb.z(-
                                                                                                            * 40385577483050L)
                                                                                                            */);
                bahVar5.d = cdjVar7;
                return kotlinUnitVar;
            case 28:
                bah bahVar6 = (bah) obj;
                String[] strArr4 = { "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* cnb.z(-43924630534954L)  */ };
                bahVar6.getClass();
                bahVar6.a = SomeStaticHelpers.ab(strArr4);
                cdj cdjVar8 = new cdj();
                cdjVar8.t("MicroMsg.FavoriteIndexUI" /* "MicroMsg.FavoriteIndexUI" /* "MicroMsg.FavoriteIndexUI" /* cnb.z(-43782896614186L)  */, (cnb.ab(ewk.b) || cnb.ac(ewh.c))
                        ? "[OnCreateContextMMMenu] pos = "
                        /* "[OnCreateContextMMMenu] pos = " /* "[OnCreateContextMMMenu] pos = " /* cnb.z(-43125766617898L)  */ : "onCreateContextMenu() pos:%s id:%s fav_id:%s" /*
                                                                                                        * cnb.z(-
                                                                                                        * 42992622631722L)
                                                                                                        */);
                bahVar6.d = cdjVar8;
                return kotlinUnitVar;
            default:
                HookParam hookParam6 = (HookParam) obj;
                hookParam6.getClass();
                try {
                    objX7 = hookParam6.getArgs()[0];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = FastKV.x(th7);
                }
                Object obj7 = objX7 instanceof dcx ? null : objX7;
                throwIfVar1IsNull(obj7);
                ContextMenu contextMenu2 = (ContextMenu) obj7;
                int i10 = 0;
                FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(contextMenu2).r();
                fieldResolverVarR5.fieldType = dal.b(Context.class);
                Object objE6 = ((azk) StaticHelpers5.safeGetFirstInList(fieldResolverVarR5.resolve())).e();
                throwIfVar1IsNull(objE6);
                Resources resources2 = ((Context) objE6).getResources();
                if (resources2 != null) {
                    HugeSyntheticPileOfHelpers.injectModuleAssets(resources2);
                }
                Kotlin$Lazy kotlin$LazyVar2 = new Kotlin$Lazy(new ayu(contextMenu2, 1));
                for (bnk bnkVar : azd.b) {
                    try {
                        for (aza azaVar : ((cie) bnkVar).i()) {
                            MethodHookWrapper methodHookWrapperVarD2 = ((MethodHookWrapper) kotlin$LazyVar2.getValue()).d();
                            methodHookWrapperVarD2.dexFind(contextMenu2);
                            Integer numValueOf3 = Integer.valueOf(i2);
                            azaVar.getClass();
                            try {
                                methodHookWrapperVarD2.e(numValueOf3, Integer.valueOf(R.id.MenuItem_Fav_Forward), 0, azaVar.a,
                                        Integer.valueOf(R.drawable.ic_menu_forward_24dp));
                            } catch (Exception e6) {
                                e = e6;
                                ArrayList arrayList5 = ewq.a;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-40535901338410L)  */);
                                ewq.e(yg.decryptVar3UsingCnbZAndConcatToVar1(sb5, bnkVar instanceof SwitchHook ? ((SwitchHook) bnkVar).getResult()
                                        : "LoadHook" /* "LoadHook" /* "LoadHook" /* cnb.z(-40471476828970L)  */, -39831526701866L), e, 12);
                                i2 = R.id.MenuItem_Group;
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                    i2 = R.id.MenuItem_Group;
                }
                return kotlinUnitVar;
        }
    }
}
