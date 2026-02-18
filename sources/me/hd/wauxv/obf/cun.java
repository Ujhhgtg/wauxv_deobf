package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import me.hd.wauxv.ui.fragment.policy.PolicyFragment;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cun implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ PolicyFragment b;

    public /* synthetic */ cun(PolicyFragment policyFragment, int i) {
        this.a = i;
        this.b = policyFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Bundle bundleK;
        Intent intent;
        int i = this.a;
        PolicyFragment policyFragment = this.b;
        int i2 = 0;
        switch (i) {
            case 0:
                cbm cbmVar = PolicyFragment.a;
                cjl cjlVarAr = cnd.ar(policyFragment);
                cix cixVar = cjlVarAr.b;
                Activity activity = cjlVarAr.d;
                if (cjlVarAr.i() != 1) {
                    cix cixVar2 = cjlVarAr.b;
                    if (cixVar2.f.isEmpty()) {
                        return;
                    }
                    cjg cjgVarAf = cixVar2.af();
                    throwIfVar1IsNull(cjgVarAf);
                    if (cixVar2.al(cjgVarAf.g.a, true, false)) {
                        cixVar2.ac();
                        return;
                    }
                    return;
                }
                Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null
                        : intent.getExtras();
                if ((extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds")
                        : null) == null) {
                    cjg cjgVarAf2 = cixVar.af();
                    throwIfVar1IsNull(cjgVarAf2);
                    int i3 = cjgVarAf2.g.a;
                    for (cji cjiVar = cjgVarAf2.h; cjiVar != null; cjiVar = cjiVar.h) {
                        ea eaVar = cjiVar.g;
                        if (cjiVar.b.c != i3) {
                            Bundle bundleR = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            if (activity != null && activity.getIntent() != null
                                    && activity.getIntent().getData() != null) {
                                Intent intent2 = activity.getIntent();
                                throwIfVar1IsNull(intent2, "getIntent(...)");
                                bundleR.putParcelable("android-support-nav:controller:deepLinkIntent", intent2);
                                cji cjiVarAi = cixVar.ai();
                                Intent intent3 = activity.getIntent();
                                throwIfVar1IsNull(intent3, "getIntent(...)");
                                cjf cjfVarQ = cjiVarAi.q(
                                        new jx(intent3.getData(), intent3.getAction(), intent3.getType(), 17),
                                        cjiVarAi);
                                if ((cjfVarQ != null ? cjfVarQ.b : null) != null
                                        && (bundleK = cjfVarQ.a.k(cjfVarQ.b)) != null) {
                                    bundleR.putAll(bundleK);
                                }
                            }
                            blq blqVar = new blq(cjlVarAr);
                            int i4 = eaVar.a;
                            ArrayList arrayList = (ArrayList) blqVar.e;
                            arrayList.clear();
                            arrayList.add(new cje(i4, null));
                            if (((cji) blqVar.d) != null) {
                                blqVar.l();
                            }
                            ((Intent) blqVar.c).putExtra("android-support-nav:controller:deepLinkExtras", bundleR);
                            blqVar.g().d();
                            if (activity != null) {
                                activity.finish();
                                return;
                            }
                            return;
                        }
                        i3 = eaVar.a;
                    }
                    return;
                }
                if (cjlVarAr.e) {
                    throwIfVar1IsNull(activity);
                    Intent intent4 = activity.getIntent();
                    Bundle extras2 = intent4.getExtras();
                    throwIfVar1IsNull(extras2);
                    int[] intArray = extras2.getIntArray("android-support-nav:controller:deepLinkIds");
                    throwIfVar1IsNull(intArray);
                    ArrayList arrayListAd = la.ad(intArray);
                    ArrayList parcelableArrayList = extras2
                            .getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
                    if (arrayListAd.size() < 2) {
                        return;
                    }
                    int iIntValue = ((Number) abf.ar(arrayListAd)).intValue();
                    if (parcelableArrayList != null) {
                    }
                    cjg cjgVarZ = cix.z(iIntValue, cixVar.ag(), null, false);
                    if (cjgVarZ instanceof cji) {
                        int i5 = cji.a;
                        iIntValue = ((cjg) dfv.aj(dfv.ai((cji) cjgVarZ, new cgu(20)))).g.a;
                    }
                    cjg cjgVarAf3 = cixVar.af();
                    if (cjgVarAf3 == null || iIntValue != cjgVarAf3.g.a) {
                        return;
                    }
                    blq blqVar2 = new blq(cjlVarAr);
                    Bundle bundleR2 = bht.r((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    bundleR2.putParcelable("android-support-nav:controller:deepLinkIntent", intent4);
                    Bundle bundle = extras2.getBundle("android-support-nav:controller:deepLinkExtras");
                    if (bundle != null) {
                        bundleR2.putAll(bundle);
                    }
                    ((Intent) blqVar2.c).putExtra("android-support-nav:controller:deepLinkExtras", bundleR2);
                    for (Object obj : arrayListAd) {
                        int i6 = i2 + 1;
                        if (i2 < 0) {
                            aba.aj();
                            throw null;
                        }
                        ((ArrayList) blqVar2.e).add(new cje(((Number) obj).intValue(),
                                parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i2) : null));
                        if (((cji) blqVar2.d) != null) {
                            blqVar2.l();
                        }
                        i2 = i6;
                    }
                    blqVar2.g().d();
                    activity.finish();
                    return;
                }
                return;
            default:
                PolicyFragment.a.getClass();
                String strZ = "policyAcceptKey" /* cnb.z(-419583945079594L) */;
                int iHashCode = ((String) PolicyFragment.b.getValue()).hashCode();
                DefaultConfig ioVar = cnf.ah;
                if (ioVar == null) {
                    throw new IllegalArgumentException(
                            "DefaultConfig must be init" /* cnb.z(-5763846109994L) */.toString());
                }
                ioVar.aj().putInt(strZ, iHashCode);
                bzy bzyVar = new bzy(policyFragment.dc());
                eg egVar = (eg) bzyVar.d;
                egVar.d = "提示" /* cnb.z(-420000556907306L) */;
                egVar.f = "核心模块就绪, 是否重启加载?" /* cnb.z(-419953312267050L) */;
                bzyVar.t("确定" /* cnb.z(-419884592790314L) */, new amw(new cfh(19), 0));
                bjs.x((2 & 3) != 0 ? new amd(1) : null, bzyVar, "取消" /* cnb.z(-47455093652266L) */);
                egVar.m = false;
                bzyVar.i().show();
                return;
        }
    }
}
