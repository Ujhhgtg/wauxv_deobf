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
public final /* synthetic */ class atn implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ atn(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:222:0x069d  */
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
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                ((amm) obj).b = new atn(1 == true ? 1 : 0);
                return ensVar;
            case 1:
                bag bagVar = (bag) obj;
                zb zbVar = new zb();
                zbVar.k("MicroMsg.emoji.EmojiFileEncryptMgr" /* cnb.z(-90284507527978L) */, "decode emoji file failed. path is no exist :%s " /* cnb.z(-90649579748138L) */);
                bagVar.getClass();
                bagVar.b = zbVar;
                return ensVar;
            case 2:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_emoji_game, null, false);
                int i6 = R.id.moduleDialogRbEmojiGameDice1;
                MaterialRadioButton materialRadioButton = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice1);
                if (materialRadioButton != null) {
                    i6 = R.id.moduleDialogRbEmojiGameDice2;
                    MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice2);
                    if (materialRadioButton2 != null) {
                        i6 = R.id.moduleDialogRbEmojiGameDice3;
                        MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice3);
                        if (materialRadioButton3 != null) {
                            i6 = R.id.moduleDialogRbEmojiGameDice4;
                            MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice4);
                            if (materialRadioButton4 != null) {
                                i6 = R.id.moduleDialogRbEmojiGameDice5;
                                MaterialRadioButton materialRadioButton5 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice5);
                                if (materialRadioButton5 != null) {
                                    i6 = R.id.moduleDialogRbEmojiGameDice6;
                                    MaterialRadioButton materialRadioButton6 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameDice6);
                                    if (materialRadioButton6 != null) {
                                        i6 = R.id.moduleDialogRbEmojiGameMorra0;
                                        MaterialRadioButton materialRadioButton7 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameMorra0);
                                        if (materialRadioButton7 != null) {
                                            i6 = R.id.moduleDialogRbEmojiGameMorra1;
                                            MaterialRadioButton materialRadioButton8 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameMorra1);
                                            if (materialRadioButton8 != null) {
                                                i6 = R.id.moduleDialogRbEmojiGameMorra2;
                                                MaterialRadioButton materialRadioButton9 = (MaterialRadioButton) cnd.aq(viewK, R.id.moduleDialogRbEmojiGameMorra2);
                                                if (materialRadioButton9 != null) {
                                                    i6 = R.id.moduleDialogRgEmojiGameDice;
                                                    RadioGroup radioGroup = (RadioGroup) cnd.aq(viewK, R.id.moduleDialogRgEmojiGameDice);
                                                    if (radioGroup != null) {
                                                        i6 = R.id.moduleDialogRgEmojiGameMorra;
                                                        RadioGroup radioGroup2 = (RadioGroup) cnd.aq(viewK, R.id.moduleDialogRgEmojiGameMorra);
                                                        if (radioGroup2 != null) {
                                                            LinearLayout linearLayout = (LinearLayout) viewK;
                                                            cen cenVar = new cen(linearLayout, materialRadioButton, materialRadioButton2, materialRadioButton3, materialRadioButton4, materialRadioButton5, materialRadioButton6, materialRadioButton7, materialRadioButton8, materialRadioButton9, radioGroup, radioGroup2);
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
                                                            bzyVar.t("保存" /* cnb.z(-507875587783466L) */, new amw(new bp(cenVar, 19), 0));
                                                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* cnb.z(-47455093652266L) */);
                                                            if (linearLayout != null) {
                                                                egVar.r = linearLayout;
                                                            }
                                                            bzyVar.i().show();
                                                            return ensVar;
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
                throw new NullPointerException("Missing required view with ID: " /* cnb.z(-638988054428458L) */.concat(viewK.getResources().getResourceName(i6)));
            case 3:
                bah bahVar = (bah) obj;
                String[] strArr = {"com.tencent.mm.sdk.platformtools" /* cnb.z(-506887745305386L) */};
                bahVar.getClass();
                bahVar.a = la.ab(strArr);
                cdj cdjVar = new cdj();
                cls2 = Integer.class;
                Class<Integer> clsBf = cnf.bf(dal.b(cls2));
                if (clsBf == null) {
                    clsBf = cls2;
                }
                cdjVar.r(clsBf);
                Class<Integer> clsBf2 = cnf.bf(dal.b(cls2));
                if (clsBf2 == null) {
                    clsBf2 = cls2;
                }
                Class<Integer> clsBf3 = cnf.bf(dal.b(cls2));
                cdjVar.q(clsBf2, clsBf3 != null ? clsBf3 : Integer.class);
                fj fjVar = new fj();
                cdj cdjVar2 = new cdj();
                cdjVar2.s("currentTimeMillis" /* cnb.z(-507312947067690L) */);
                fjVar.f(cdjVar2);
                cdj cdjVar3 = new cdj();
                cdjVar3.s("nextInt" /* cnb.z(-507252817525546L) */);
                fjVar.f(cdjVar3);
                fjVar.d = bzu.Contains;
                cdjVar.i = fjVar;
                bahVar.d = cdjVar;
                return ensVar;
            case 4:
                bah bahVar2 = (bah) obj;
                cdj cdjVar4 = new cdj();
                cdjVar4.t("MicroMsg.EmojiPanelClickListener" /* cnb.z(-507218457787178L) */, "penn send capture emoji click emoji: %s status: %d." /* cnb.z(-495531851774762L) */);
                bahVar2.getClass();
                bahVar2.d = cdjVar4;
                return ensVar;
            case 5:
                final bmm bmmVar = (bmm) obj;
                atx atxVar = atx.a;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[3];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                bzo.n(objX);
                int i7 = bte.a;
                azg azgVarR = dqc.bi(objX).r();
                abf.ao(azgVarR.ad, (cdy[]) Arrays.copyOf(new cdy[]{cdy.d}, 1));
                azgVarR.a = dal.b(cls4);
                Object objE = ((azk) aaz.e(azgVarR.c())).e();
                bzo.n(objE);
                if (((Number) objE).intValue() == 0) {
                    azg azgVarR2 = dqc.bi(objX).r();
                    azgVarR2.a = "com.tencent.mm.api.IEmojiInfo" /* cnb.z(-507897062619946L) */;
                    Object objD = ((azk) aaz.e(azgVarR2.c())).d();
                    bzo.n(objD);
                    cde cdeVarT = dqc.bi(objD).t();
                    cdeVarT.ab = "getMd5" /* cnb.z(-507751033731882L) */;
                    Object objJ = ((cdk) aaz.e(cdeVarT.aj())).j(new Object[0]);
                    bzo.n(objJ);
                    String str = (String) objJ;
                    if (str.equals("9bd1281af3a31710a45b84d736363691" /* cnb.z(-507703789091626L) */)) {
                        atxVar.getClass();
                        bmmVar.h(null);
                        AlertDialog.Builder builder = new AlertDialog.Builder(aye.v());
                        builder.setTitle("选择猜拳" /* cnb.z(-507480450792234L) */);
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
                                builder.setPositiveButton("发送" /* cnb.z(-507441796086570L) */, new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i8) {
                                        switch (iIntValue) {
                                            case 0:
                                                bmmVar.c();
                                                break;
                                            case 1:
                                                atw.a.r(cyj.f._bi(3));
                                                bmmVar.c();
                                                break;
                                            case 2:
                                                bmmVar.c();
                                                break;
                                            default:
                                                atv.a.r(cyj.f._bi(6));
                                                bmmVar.c();
                                                break;
                                        }
                                    }
                                });
                                CharSequence charSequenceZ = "随机" /* cnb.z(-507446091053866L) */;
                                final char c = 1 == true ? 1 : 0;
                                builder.setNeutralButton(charSequenceZ, new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i8) {
                                        switch (c) {
                                            case 0:
                                                bmmVar.c();
                                                break;
                                            case 1:
                                                atw.a.r(cyj.f._bi(3));
                                                bmmVar.c();
                                                break;
                                            case 2:
                                                bmmVar.c();
                                                break;
                                            default:
                                                atv.a.r(cyj.f._bi(6));
                                                bmmVar.c();
                                                break;
                                        }
                                    }
                                });
                                builder.setNegativeButton("取消" /* cnb.z(-507948602227498L) */, (DialogInterface.OnClickListener) null);
                                builder.show();
                            }
                        }
                    } else if (str.equals("08f223fa83f1ca34e143d1e580252c7c" /* cnb.z(-507029479226154L) */)) {
                        atxVar.getClass();
                        bmmVar.h(null);
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(aye.v());
                        builder2.setTitle("选择骰子" /* cnb.z(-507952897194794L) */);
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
                                builder2.setPositiveButton("发送" /* cnb.z(-507914242489130L) */, new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i8) {
                                        switch (i5) {
                                            case 0:
                                                bmmVar.c();
                                                break;
                                            case 1:
                                                atw.a.r(cyj.f._bi(3));
                                                bmmVar.c();
                                                break;
                                            case 2:
                                                bmmVar.c();
                                                break;
                                            default:
                                                atv.a.r(cyj.f._bi(6));
                                                bmmVar.c();
                                                break;
                                        }
                                    }
                                });
                                builder2.setNeutralButton("随机" /* cnb.z(-507918537456426L) */, new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.atq
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i8) {
                                        switch (i3) {
                                            case 0:
                                                bmmVar.c();
                                                break;
                                            case 1:
                                                atw.a.r(cyj.f._bi(3));
                                                bmmVar.c();
                                                break;
                                            case 2:
                                                bmmVar.c();
                                                break;
                                            default:
                                                atv.a.r(cyj.f._bi(6));
                                                bmmVar.c();
                                                break;
                                        }
                                    }
                                });
                                builder2.setNegativeButton("取消" /* cnb.z(-507940012292906L) */, (DialogInterface.OnClickListener) null);
                                builder2.show();
                            }
                        }
                    }
                }
                return ensVar;
            case 6:
                ((amm) obj).c = new atn(i3);
                return ensVar;
            case 7:
                ((amm) obj).c = new atn(4);
                return ensVar;
            case 8:
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                try {
                    objX2 = bmmVar2.d()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                Integer num = (Integer) objX2;
                iIntValue = num != null ? num.intValue() : 0;
                Object objF = bmmVar2.f();
                Integer numValueOf = (Integer) (objF instanceof Integer ? objF : null);
                if (iIntValue == 2) {
                    numValueOf = Integer.valueOf(atw.a.k());
                } else if (iIntValue == 5) {
                    numValueOf = Integer.valueOf(atv.a.k());
                }
                bmmVar2.h(numValueOf);
                return ensVar;
            case 9:
                ((amm) obj).c = new atn(10);
                return ensVar;
            case 10:
                bah bahVar3 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cdj.l(cdjVar5, "com.tencent.mm.storage.emotion.EmojiInfo" /* cnb.z(-75471165324074L) */);
                cdjVar5.t("save emoji thumb error" /* cnb.z(-75844827478826L) */);
                bahVar3.getClass();
                bahVar3.d = cdjVar5;
                return ensVar;
            case 11:
                ((amm) obj).b = new atn(i4);
                return ensVar;
            case 12:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k("MicroMsg.emoji.EmojiInfoStorage" /* cnb.z(-91976724642602L) */, "md5 is null or invalue. md5:%s" /* cnb.z(-91839285689130L) */);
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return ensVar;
            case 13:
                List list = (List) obj;
                Object obj2 = list.get(0);
                Class<String> clsBf4 = cnf.bf(dal.b(cls));
                if (bzo.f(obj2, clsBf4 != null ? clsBf4 : String.class)) {
                    Object obj3 = list.get(1);
                    atz.a.getClass();
                    if (bzo.f(obj3, emn.bb(aty.a).getDeclaringClass())) {
                        Object obj4 = list.get(2);
                        cge.a.getClass();
                        z = bzo.f(obj4, emn.az(cgd.a));
                    }
                }
                return Boolean.valueOf(z);
            case 14:
                ((amm) obj).b = new atn(15);
                return ensVar;
            case 15:
                bag bagVar3 = (bag) obj;
                zb zbVar3 = new zb();
                zbVar3.k("MicroMsg.emoji.EmojiMgrImpl" /* cnb.z(-92105573661482L) */, "sendEmoji: context is null" /* cnb.z(-91401199024938L) */);
                bagVar3.getClass();
                bagVar3.b = zbVar3;
                return ensVar;
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
                bzyVar2.t("保存" /* cnb.z(-519081157458730L) */, new amw(new aul(ceeVarE, 0), 0));
                bzyVar2.s("重置" /* cnb.z(-519085452426026L) */, new amw(new amd(2), 2));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* cnb.z(-47455093652266L) */);
                if (linearLayout2 != null) {
                    egVar2.r = linearLayout2;
                }
                bzyVar2.i().show();
                return ensVar;
            case 17:
                ((amm) obj).b = new atn(18);
                return ensVar;
            case 18:
                bag bagVar4 = (bag) obj;
                String[] strArr2 = {"com.tencent.mm.storage" /* cnb.z(-91676076931882L) */};
                bagVar4.getClass();
                bagVar4.a = la.ab(strArr2);
                zb zbVar4 = new zb();
                zbVar4.k("MicroMsg.emoji.EmojiStorageMgr" /* cnb.z(-91577292684074L) */, "EmojiStorageMgr: %s" /* cnb.z(-88746909236010L) */);
                bagVar4.b = zbVar4;
                return ensVar;
            case 19:
                bmm bmmVar3 = (bmm) obj;
                bmmVar3.getClass();
                try {
                    objX3 = bmmVar3.d()[0];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                if (objX3 instanceof dcx) {
                    objX3 = null;
                }
                bzo.n(objX3);
                String str3 = (String) objX3;
                try {
                    objX4 = bmmVar3.d()[1];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                for (bni bniVar : axu.b) {
                    try {
                        if (((diw) bniVar).z() && str3.equals("clicfg_sns_use_expandable_video_seek_bar" /* cnb.z(-608734304795434L) */)) {
                            bmmVar3.h("1" /* cnb.z(-609107966950186L) */);
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onGetExptConfig " /* cnb.z(-36717675412266L) */);
                        ewq.e(yg.n(sb, bniVar instanceof doo ? ((doo) bniVar).f() : "LoadHook" /* cnb.z(-36661840837418L) */, -36623186131754L), e, 12);
                    }
                }
                return ensVar;
            case 20:
                ((amm) obj).c = new atn(21);
                return ensVar;
            case 21:
                bah bahVar4 = (bah) obj;
                cdj cdjVar6 = new cdj();
                Class<String> clsBf5 = cnf.bf(dal.b(cls));
                if (clsBf5 == null) {
                    clsBf5 = cls;
                }
                cdjVar6.r(clsBf5);
                Class<String> clsBf6 = cnf.bf(dal.b(cls));
                if (clsBf6 == null) {
                    clsBf6 = cls;
                }
                Class<String> clsBf7 = cnf.bf(dal.b(cls));
                cls = clsBf7 != null ? clsBf7 : String.class;
                cls3 = Boolean.class;
                Class<Boolean> clsBf8 = cnf.bf(dal.b(cls3));
                cdjVar6.q(clsBf6, cls, clsBf8 != null ? clsBf8 : Boolean.class);
                cdjVar6.t("MicroMsg.ExptService" /* cnb.z(-36588826393386L) */, "Fail to query value, return default value '%s' instead." /* cnb.z(-42528766163754L) */);
                bahVar4.getClass();
                bahVar4.d = cdjVar6;
                return ensVar;
            case 22:
                bmm bmmVar4 = (bmm) obj;
                LinkedHashSet<bnj> linkedHashSet = ayy.b;
                bmmVar4.getClass();
                try {
                    objX5 = bmmVar4.d()[0];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                Object obj5 = objX5 instanceof dcx ? null : objX5;
                bzo.n(obj5);
                ContextMenu contextMenu = (ContextMenu) obj5;
                if (cnb.ab(ewk.b) || cnb.ac(ewh.c)) {
                    int i8 = bte.a;
                    azg azgVarR3 = dqc.bi(contextMenu).r();
                    azgVarR3.a = dal.b(Context.class);
                    Object objE2 = ((azk) aaz.e(azgVarR3.c())).e();
                    bzo.n(objE2);
                    Resources resources = ((Context) objE2).getResources();
                    if (resources != null) {
                        cnf.bi(resources);
                    }
                    dov dovVar = new dov(new ayu(contextMenu, 0));
                    for (bnj bnjVar : linkedHashSet) {
                        try {
                            for (ayv ayvVar : ((cif) bnjVar).i()) {
                                cdk cdkVarD = ((cdk) dovVar.getValue()).d();
                                cdkVarD.h(contextMenu);
                                try {
                                    Integer numValueOf2 = Integer.valueOf(R.id.MenuItem_Group);
                                    ayvVar.getClass();
                                    cdkVarD.e(numValueOf2, Integer.valueOf(R.id.MenuItem_Fav_Forward), 0, ayvVar.a, Integer.valueOf(R.drawable.ic_menu_forward_24dp));
                                } catch (Exception e2) {
                                    e = e2;
                                    ArrayList arrayList2 = ewq.a;
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("onCreateMenuItems " /* cnb.z(-42013370088234L) */);
                                    ewq.e(yg.n(sb2, bnjVar instanceof doo ? ((doo) bnjVar).f() : "LoadHook" /* cnb.z(-41948945578794L) */, -41858751265578L), e, 12);
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
                            sb3.append("onCreateMenuItems " /* cnb.z(-41824391527210L) */);
                            ewq.e(yg.n(sb3, bnjVar2 instanceof doo ? ((doo) bnjVar2).f() : "LoadHook" /* cnb.z(-42309722831658L) */, -42288247995178L), e4, 12);
                        }
                    }
                }
                return ensVar;
            case 23:
                bmm bmmVar5 = (bmm) obj;
                bmmVar5.getClass();
                try {
                    objX6 = bmmVar5.d()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                Object obj6 = objX6 instanceof dcx ? null : objX6;
                bzo.n(obj6);
                MenuItem menuItem = (MenuItem) obj6;
                int i9 = bte.a;
                azg azgVarAa = dkz.aa(bmmVar5);
                azgVarAa.a = dal.b(cls4);
                Object objE3 = ((azk) aaz.e(azgVarAa.c())).e();
                bzo.n(objE3);
                int iIntValue = ((Number) objE3).intValue();
                azg azgVarAa2 = dkz.aa(bmmVar5);
                azgVarAa2.a = "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI" /* cnb.z(-42253888256810L) */;
                Object objE4 = ((azk) aaz.e(azgVarAa2.c())).e();
                bzo.n(objE4);
                azg azgVarR4 = dqc.bi((Activity) objE4).r();
                azgVarR4.b = new atn(26);
                Object objE5 = ((azk) aaz.e(azgVarR4.c())).e();
                bzo.n(objE5);
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
                        sb4.append("onCreateMenuItems " /* cnb.z(-43675522431786L) */);
                        ewq.e(yg.n(sb4, bnjVar3 instanceof doo ? ((doo) bnjVar3).f() : "LoadHook" /* cnb.z(-43628277791530L) */, -43589623085866L), e5, 12);
                    }
                }
                return ensVar;
            case 24:
                ((amm) obj).c = new atn(28);
                return ensVar;
            case 25:
                ((amm) obj).c = new atn(27);
                return ensVar;
            case 26:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(), "com.tencent.mm.plugin.fav.ui.adapter." /* cnb.z(-43555263347498L) */, false));
            case 27:
                bah bahVar5 = (bah) obj;
                String[] strArr3 = {"com.tencent.mm.plugin.fav.ui" /* cnb.z(-43383464655658L) */};
                bahVar5.getClass();
                bahVar5.a = la.ab(strArr3);
                cdj cdjVar7 = new cdj();
                cdjVar7.t("MicroMsg.FavoriteIndexUI" /* cnb.z(-43241730734890L) */, "onMMMenuItemSelected" /* cnb.z(-40385577483050L) */);
                bahVar5.d = cdjVar7;
                return ensVar;
            case 28:
                bah bahVar6 = (bah) obj;
                String[] strArr4 = {"com.tencent.mm.plugin.fav.ui" /* cnb.z(-43924630534954L) */};
                bahVar6.getClass();
                bahVar6.a = la.ab(strArr4);
                cdj cdjVar8 = new cdj();
                cdjVar8.t("MicroMsg.FavoriteIndexUI" /* cnb.z(-43782896614186L) */, (cnb.ab(ewk.b) || cnb.ac(ewh.c)) ? "[OnCreateContextMMMenu] pos = " /* cnb.z(-43125766617898L) */ : "onCreateContextMenu() pos:%s id:%s fav_id:%s" /* cnb.z(-42992622631722L) */);
                bahVar6.d = cdjVar8;
                return ensVar;
            default:
                bmm bmmVar6 = (bmm) obj;
                bmmVar6.getClass();
                try {
                    objX7 = bmmVar6.d()[0];
                    if (objX7 == null) {
                        objX7 = null;
                    }
                } catch (Throwable th7) {
                    objX7 = bhu.x(th7);
                }
                Object obj7 = objX7 instanceof dcx ? null : objX7;
                bzo.n(obj7);
                ContextMenu contextMenu2 = (ContextMenu) obj7;
                int i10 = bte.a;
                azg azgVarR5 = dqc.bi(contextMenu2).r();
                azgVarR5.a = dal.b(Context.class);
                Object objE6 = ((azk) aaz.e(azgVarR5.c())).e();
                bzo.n(objE6);
                Resources resources2 = ((Context) objE6).getResources();
                if (resources2 != null) {
                    cnf.bi(resources2);
                }
                dov dovVar2 = new dov(new ayu(contextMenu2, 1));
                for (bnk bnkVar : azd.b) {
                    try {
                        for (aza azaVar : ((cie) bnkVar).i()) {
                            cdk cdkVarD2 = ((cdk) dovVar2.getValue()).d();
                            cdkVarD2.h(contextMenu2);
                            Integer numValueOf3 = Integer.valueOf(i2);
                            azaVar.getClass();
                            try {
                                cdkVarD2.e(numValueOf3, Integer.valueOf(R.id.MenuItem_Fav_Forward), 0, azaVar.a, Integer.valueOf(R.drawable.ic_menu_forward_24dp));
                            } catch (Exception e6) {
                                e = e6;
                                ArrayList arrayList5 = ewq.a;
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("onCreateMenuItems " /* cnb.z(-40535901338410L) */);
                                ewq.e(yg.n(sb5, bnkVar instanceof doo ? ((doo) bnkVar).f() : "LoadHook" /* cnb.z(-40471476828970L) */, -39831526701866L), e, 12);
                                i2 = R.id.MenuItem_Group;
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                    }
                    i2 = R.id.MenuItem_Group;
                }
                return ensVar;
        }
    }
}
