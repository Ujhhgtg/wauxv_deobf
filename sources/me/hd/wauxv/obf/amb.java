package me.hd.wauxv.obf;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class amb implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ amb(int i) {
        this.a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Object objX;
        Object objX2;
        Object objX3;
        Object objX4;
        Object objX5;
        Object objX6;
        Class cls;
        int i = this.a;
        int i2 = 18;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                Integer num = (Integer) objX;
                int iIntValue = num != null ? num.intValue() : 0;
                try {
                    objX2 = bmmVar.d()[2];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                String str = (String) objX2;
                if (str == null) {
                    str = "";
                }
                try {
                    objX3 = bmmVar.d()[9];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                String str2 = (String) (objX3 instanceof dcx ? null : objX3);
                String str3 = str2 != null ? str2 : "";
                if (iIntValue == 0) {
                    String strZ = "WAuxiliary" /* cnb.z(-647689658170154L) */;
                    StringBuilder sbY = dkz.y(str);
                    sbY.append(": " /* cnb.z(-647659593399082L) */);
                    sbY.append(str3);
                    Log.v(strZ, sbY.toString());
                } else if (iIntValue == 1) {
                    String strZ2 = "WAuxiliary" /* cnb.z(-647681068235562L) */;
                    StringBuilder sbY2 = dkz.y(str);
                    sbY2.append(": " /* cnb.z(-648132039801642L) */);
                    sbY2.append(str3);
                    Log.d(strZ2, sbY2.toString());
                } else if (iIntValue == 2) {
                    String strZ3 = "WAuxiliary" /* cnb.z(-648153514638122L) */;
                    StringBuilder sbY3 = dkz.y(str);
                    sbY3.append(": " /* cnb.z(-648123449867050L) */);
                    sbY3.append(str3);
                    Log.i(strZ3, sbY3.toString());
                } else if (iIntValue == 3) {
                    String strZ4 = "WAuxiliary" /* cnb.z(-648076205226794L) */;
                    StringBuilder sbY4 = dkz.y(str);
                    sbY4.append(": " /* cnb.z(-648046140455722L) */);
                    sbY4.append(str3);
                    Log.w(strZ4, sbY4.toString());
                } else if (iIntValue == 4) {
                    String strZ5 = "WAuxiliary" /* cnb.z(-647998895815466L) */;
                    StringBuilder sbY5 = dkz.y(str);
                    sbY5.append(": " /* cnb.z(-647968831044394L) */);
                    sbY5.append(str3);
                    Log.e(strZ5, sbY5.toString());
                } else if (iIntValue == 5) {
                    String strZ6 = "WAuxiliary" /* cnb.z(-647990305880874L) */;
                    StringBuilder sbY6 = dkz.y(str);
                    sbY6.append(": " /* cnb.z(-647891521633066L) */);
                    sbY6.append(str3);
                    Log.wtf(strZ6, sbY6.toString());
                }
                return ensVar;
            case 1:
                String str4 = (String) obj;
                bzo.q(str4, "it");
                return ams.h(str4);
            case 2:
                Class cls2 = (Class) obj;
                bzo.n(cls2);
                return ams.g(cls2);
            case 3:
                Class cls3 = (Class) obj;
                bzo.n(cls3);
                return ams.g(cls3);
            case 4:
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                try {
                    objX4 = bmmVar2.d()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = bhu.x(th4);
                }
                Object obj2 = objX4 instanceof dcx ? null : objX4;
                bzo.n(obj2);
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) obj2;
                if (layoutParams.screenBrightness >= 0.5f) {
                    layoutParams.screenBrightness = -1.0f;
                }
                return ensVar;
            case 5:
                ((bmm) obj).h(null);
                return ensVar;
            case 6:
                amm ammVar = (amm) obj;
                ammVar.b = new amb(7);
                ammVar.c = new amb(8);
                return ensVar;
            case 7:
                bag bagVar = (bag) obj;
                String[] strArr = {"com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-446706663553834L) */};
                bagVar.getClass();
                bagVar.a = la.ab(strArr);
                zb zbVar = new zb();
                zbVar.k(".msgsource.sec_msg_node.clip-len" /* cnb.z(-448179837336362L) */);
                dnf dnfVar = new dnf("MicroMsg.ChattingItem" /* cnb.z(-448587859229482L) */, dne.Contains, false);
                List arrayList = zbVar.g;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                zbVar.g = arrayList;
                arrayList.add(dnfVar);
                bagVar.b = zbVar;
                return ensVar;
            case 8:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdjVar.t(".msgsource.sec_msg_node.clip-len" /* cnb.z(-448476190079786L) */);
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 9:
                ((bmm) obj).h(Boolean.FALSE);
                return ensVar;
            case 10:
                ((amm) obj).c = new amb(11);
                return ensVar;
            case 11:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdjVar2.t("MicroMsg.PluginPatMsg" /* cnb.z(-447995153742634L) */, "DisableSendPat" /* cnb.z(-447883484592938L) */);
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ensVar;
            case 12:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_disable_ringtone_play, null, false);
                int i3 = R.id.moduleDialogCbDisableRingtoneInCall;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbDisableRingtoneInCall);
                if (materialCheckBox != null) {
                    i3 = R.id.moduleDialogCbDisableRingtoneOutCall;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbDisableRingtoneOutCall);
                    if (materialCheckBox2 != null) {
                        LinearLayout linearLayout = (LinearLayout) viewK;
                        cek cekVar = new cek(linearLayout, materialCheckBox, materialCheckBox2, 1);
                        materialCheckBox2.setChecked(aod.a.i());
                        materialCheckBox.setChecked(aoc.a.i());
                        bzy bzyVar = new bzy(view.getContext());
                        eg egVar = (eg) bzyVar.d;
                        aoe.a.getClass();
                        egVar.d = aoe.c;
                        bzyVar.t("保存" /* cnb.z(-444404561083178L) */, new amw(new bp(cekVar, i2), 0));
                        bjs.x((3 & 2) != 0 ? new amd(i) : null, bzyVar, "取消" /* cnb.z(-47455093652266L) */);
                        if (linearLayout != null) {
                            egVar.r = linearLayout;
                        }
                        bzyVar.i().show();
                        return ensVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: " /* cnb.z(-639675249195818L) */.concat(viewK.getResources().getResourceName(i3)));
            case 13:
                bmm bmmVar3 = (bmm) obj;
                bmmVar3.getClass();
                try {
                    objX5 = bmmVar3.d()[1];
                    if (objX5 == null) {
                        objX5 = null;
                    }
                } catch (Throwable th5) {
                    objX5 = bhu.x(th5);
                }
                Object obj3 = objX5 instanceof dcx ? null : objX5;
                bzo.n(obj3);
                Bundle bundle = (Bundle) obj3;
                if (bzo.f(bundle.getString("scene" /* cnb.z(-444357316442922L) */), "start" /* cnb.z(-444314366769962L) */)) {
                    boolean z = bundle.getBoolean("isOutCall" /* cnb.z(-444340136573738L) */);
                    Object[] objArr = z && aod.a.i();
                    i = (z || !aoc.a.i()) ? 0 : 1;
                    if (objArr != false || i != 0) {
                        bmmVar3.h(Boolean.FALSE);
                    }
                }
                return ensVar;
            case 14:
                ((amm) obj).c = new amb(15);
                return ensVar;
            case 15:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cdjVar3.t("MicroMsg.BaseSceneSetting" /* cnb.z(-444245647293226L) */, "playSound Failed Throwable t = " /* cnb.z(-444700913826602L) */);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 16:
                ((bmm) obj).h(null);
                return ensVar;
            case 17:
                ((amm) obj).c = new amb(i2);
                return ensVar;
            case 18:
                bah bahVar4 = (bah) obj;
                String[] strArr2 = {"com.tencent.mm.ui.chatting.component" /* cnb.z(-446388835973930L) */};
                bahVar4.getClass();
                bahVar4.a = la.ab(strArr2);
                cdj cdjVar4 = new cdj();
                cdjVar4.t("MicroMsg.SignallingComponent" /* cnb.z(-446212742314794L) */, "[doDirectSend] mChattingContext is null!" /* cnb.z(-445572792187690L) */);
                bahVar4.d = cdjVar4;
                return ensVar;
            case 19:
                ((amm) obj).b = new amb(20);
                return ensVar;
            case 20:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k("ModelImage.DownloadImgService" /* cnb.z(-119138097822506L) */, "cancelNetScene reset curTaskInfo (%s %s %s)" /* cnb.z(-120641336376106L) */);
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return ensVar;
            case 21:
                bmm bmmVar4 = (bmm) obj;
                bmmVar4.getClass();
                try {
                    objX6 = bmmVar4.d()[0];
                    if (objX6 == null) {
                        objX6 = null;
                    }
                } catch (Throwable th6) {
                    objX6 = bhu.x(th6);
                }
                if (objX6 instanceof dcx) {
                    objX6 = null;
                }
                bzo.n(objX6);
                Iterator it = aqw.b.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    try {
                        throw null;
                    } catch (Exception e) {
                        ArrayList arrayList2 = ewq.a;
                        ewq.e("onGetDynamicConfig " /* cnb.z(-36880884169514L) */ + "LoadHook" /* cnb.z(-37379100375850L) */ + " Failed" /* cnb.z(-37288906062634L) */, e, 12);
                    }
                }
                return ensVar;
            case 22:
                amm ammVar2 = (amm) obj;
                ammVar2.b = new amb(23);
                ammVar2.c = new amb(24);
                return ensVar;
            case 23:
                bag bagVar3 = (bag) obj;
                zb zbVar3 = new zb();
                zbVar3.k("MicroMsg.DynamicConfig" /* cnb.z(-37254546324266L) */, "update dynacfg. increment:%b, md5:%s" /* cnb.z(-37207301684010L) */);
                bagVar3.getClass();
                bagVar3.b = zbVar3;
                return ensVar;
            case 24:
                bah bahVar5 = (bah) obj;
                cdj cdjVar5 = new cdj();
                cls = String.class;
                Class<String> clsBf = cnf.bf(dal.b(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cdjVar5.r(clsBf);
                Class<String> clsBf2 = cnf.bf(dal.b(cls));
                cdjVar5.q(clsBf2 != null ? clsBf2 : String.class);
                cdjVar5.t("MicroMsg.DynamicConfig" /* cnb.z(-36481452210986L) */, "DynamicConfig hadnot load" /* cnb.z(-36365488093994L) */);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return ensVar;
            case 25:
                obj.getClass();
                throw new ClassCastException();
            case 26:
                return Boolean.valueOf(!((arx) obj).a);
            case 27:
                return Boolean.valueOf(((dim) obj).a == 2);
            case 28:
                ((amm) obj).b = new amb(29);
                return ensVar;
            default:
                bag bagVar4 = (bag) obj;
                String[] strArr3 = {"com.tencent.mm.feature.emoji" /* cnb.z(-361997023574826L) */};
                bagVar4.getClass();
                bagVar4.a = la.ab(strArr3);
                zb zbVar4 = new zb();
                zbVar4.k("MicroMsg.EmojiFeatureService" /* cnb.z(-361906829261610L) */, "[onAccountInitialized]" /* cnb.z(-361765095340842L) */, "onAccountRelease: " /* cnb.z(-362198887037738L) */);
                bagVar4.b = zbVar4;
                return ensVar;
        }
    }
}
