package me.hd.wauxv.ui.fragment.policy;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.view.View;
import com.google.android.material.textview.MaterialTextView;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.acx;
import me.hd.wauxv.obf.amd;
import me.hd.wauxv.obf.amw;
import me.hd.wauxv.obf.bdo;
import me.hd.wauxv.obf.bew;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.bmo;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.bzy;
import me.hd.wauxv.obf.cbm;
import me.hd.wauxv.obf.cfh;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cnd;
import me.hd.wauxv.obf.cnf;
import me.hd.wauxv.obf.cun;
import me.hd.wauxv.obf.cuo;
import me.hd.wauxv.obf.cup;
import me.hd.wauxv.obf.dov;
import me.hd.wauxv.obf.eg;
import me.hd.wauxv.obf.eqj;
import me.hd.wauxv.obf.eui;
import me.hd.wauxv.obf.io;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PolicyFragment extends bdo {
    public static final cbm a;
    public static final dov b;
    public CountDownTimer l;

    static {
        "policyAcceptKey" /* cnb.z(-412097817082666L) */;
        a = new cbm(10);
        b = new dov(new cfh(17));
    }

    public PolicyFragment() {
        super(cuo.a);
    }

    @Override // me.hd.wauxv.obf.bdo, me.hd.wauxv.obf.bdj
    public final void h() {
        super.h();
        CountDownTimer countDownTimer = this.l;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        Bundle bundle = this.ax;
        dov dovVar = b;
        cbm cbmVar = a;
        if (bundle != null && bundle.getBoolean("showOnly" /* cnb.z(-419072843971370L) */, false)) {
            eqj eqjVar = this.d;
            throwIfVar1IsNull(eqjVar);
            MaterialTextView materialTextView = ((bew) eqjVar).c;
            cbmVar.getClass();
            materialTextView.setText(Html.fromHtml((String) dovVar.getValue(), 63));
            eqj eqjVar2 = this.d;
            throwIfVar1IsNull(eqjVar2);
            ((bew) eqjVar2).b.setText("你已阅读并同意以上协议" /* cnb.z(-419051369134890L) */);
            eqj eqjVar3 = this.d;
            throwIfVar1IsNull(eqjVar3);
            ((bew) eqjVar3).b.setEnabled(true);
            eqj eqjVar4 = this.d;
            throwIfVar1IsNull(eqjVar4);
            ((bew) eqjVar4).b.setOnClickListener(new cun(this, 0));
            return;
        }
        cbmVar.getClass();
        String strZ = "policyAcceptKey" /* cnb.z(-419652664556330L) */;
        io ioVar = cnf.ah;
        if (ioVar == null) {
            throw new IllegalArgumentException("DefaultConfig must be init" /* cnb.z(-5763846109994L) */.toString());
        }
        if (ioVar.aj().getInt(strZ, 0) != ((String) dovVar.getValue()).hashCode()) {
            eqj eqjVar5 = this.d;
            throwIfVar1IsNull(eqjVar5);
            MaterialTextView materialTextView2 = ((bew) eqjVar5).c;
            cbmVar.getClass();
            materialTextView2.setText(Html.fromHtml((String) dovVar.getValue(), 63));
            this.l = new cup(this).start();
            return;
        }
        Context contextDc = dc();
        String strZ2 = "68393b1dbc47b67d83776862" /* cnb.z(-72331544230698L) */;
        bmo.a.getClass();
        UMConfigure.init(contextDc, strZ2, bmo.o(), 1, "" /* cnb.z(-71691594103594L) */);
        eui.a.getClass();
        if (eui.c()) {
            String strZ3 = "wx" /* cnb.z(-71687299136298L) */;
            acx.a.getClass();
            MobclickAgent.onProfileSignIn(strZ3, acx.b());
            cnd.ar(this).j(R.id.action_policyFragment_to_moduleNavFragment, null);
            return;
        }
        bzy bzyVar = new bzy(dc());
        eg egVar = (eg) bzyVar.d;
        egVar.d = "提示" /* cnb.z(-418965469788970L) */;
        egVar.f = "核心模块异常, 是否重启加载?" /* cnb.z(-418969764756266L) */;
        bzyVar.t("确定" /* cnb.z(-419450801093418L) */, new amw(new cfh(18), 0));
        bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* cnb.z(-47455093652266L) */);
        egVar.m = false;
        bzyVar.i().show();
    }
}
