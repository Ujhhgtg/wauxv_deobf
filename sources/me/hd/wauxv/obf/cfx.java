package me.hd.wauxv.obf;

import android.app.Notification;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RadioGroup;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cfx implements IFunction0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ cfx(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v23 */
    /*
     * JADX WARN: Type inference failed for: r10v24, types: [android.net.Uri,
     * java.lang.CharSequence[], long[]]
     */
    /* JADX WARN: Type inference failed for: r10v26 */
    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i;
        Bundle bundle;
        bur burVarAp;
        ?? r10;
        Bundle bundle2;
        int i2 = this.a;
        int i3 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        Object obj = this.b;
        switch (i2) {
            case 0:
                cem cemVar = (cem) obj;
                cfz.a.u(String.valueOf(cemVar.c.getText()));
                cga.a.u(String.valueOf(cemVar.d.getText()));
                return kotlinUnitVar;
            case 1:
                cen cenVar = (cen) obj;
                cgk.a.u(String.valueOf(((TextInputEditText) cenVar.i).getText()));
                cgl.a.u(String.valueOf(((TextInputEditText) cenVar.j).getText()));
                cgg.a.u(String.valueOf(((TextInputEditText) cenVar.e).getText()));
                cgh.a.u(String.valueOf(((TextInputEditText) cenVar.f).getText()));
                cgp.a.u(String.valueOf(((TextInputEditText) cenVar.l).getText()));
                cgq.a.u(String.valueOf(((TextInputEditText) cenVar.m).getText()));
                cgj cgjVar = cgj.a;
                Integer numBf = dnq.bf(String.valueOf(((TextInputEditText) cenVar.h).getText()));
                cgjVar.r(numBf != null ? numBf.intValue() : 64);
                cgm cgmVar = cgm.a;
                Integer numBf2 = dnq.bf(String.valueOf(((TextInputEditText) cenVar.k).getText()));
                cgmVar.r(numBf2 != null ? numBf2.intValue() : 64);
                cgi cgiVar = cgi.a;
                Integer numBf3 = dnq.bf(String.valueOf(((TextInputEditText) cenVar.g).getText()));
                cgiVar.r(numBf3 != null ? numBf3.intValue() : 10);
                cgn.a.p(((MaterialCheckBox) cenVar.c).isChecked());
                cgo.a.p(((MaterialCheckBox) cenVar.d).isChecked());
                return kotlinUnitVar;
            case 2:
                ceo ceoVar = (ceo) obj;
                che.a.u(String.valueOf(ceoVar.d.getText()));
                chg.a.u(String.valueOf(ceoVar.f.getText()));
                chd.a.u(String.valueOf(ceoVar.c.getText()));
                chf.a.u(String.valueOf(ceoVar.e.getText()));
                return kotlinUnitVar;
            case 3:
                int i4 = 2;
                NavHostFragment navHostFragment = (NavHostFragment) obj;
                Context contextCq = navHostFragment.cq();
                if (contextCq == null) {
                    throw new IllegalStateException("NavController cannot be created before the fragment is attached");
                }
                cjl cjlVar = new cjl(contextCq);
                cix cixVar = cjlVar.b;
                bel belVar = cixVar.q;
                ckm ckmVar = cixVar.r;
                if (!navHostFragment.equals(cixVar.m)) {
                    bup bupVar = cixVar.m;
                    if (bupVar != null && (burVarAp = bupVar.ap()) != null) {
                        burVarAp.o(belVar);
                    }
                    cixVar.m = navHostFragment;
                    navHostFragment.ch.j(belVar);
                }
                erq erqVarAj = navHostFragment.aj();
                if (!nullSafeIsEqual(cixVar.n, bhv.x(erqVarAj))) {
                    if (!cixVar.f.isEmpty()) {
                        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
                    }
                    cixVar.n = bhv.x(erqVarAj);
                }
                Context contextDc = navHostFragment.dc();
                beg begVarCp = navHostFragment.cp();
                throwIfVar1IsNull(begVarCp, "getChildFragmentManager(...)");
                ckmVar.c(new ani(contextDc, begVarCp));
                Context contextDc2 = navHostFragment.dc();
                beg begVarCp2 = navHostFragment.cp();
                throwIfVar1IsNull(begVarCp2, "getChildFragmentManager(...)");
                int i5 = navHostFragment.bq;
                if (i5 == 0 || i5 == -1) {
                    i5 = R.id.nav_host_fragment_container;
                }
                ckmVar.c(new beq(contextDc2, begVarCp2, i5));
                Bundle bundleG = ((but) navHostFragment.ck.c).g("android-support-nav:fragment:navControllerState");
                if (bundleG != null) {
                    bundleG.setClassLoader(contextCq.getClassLoader());
                    LinkedHashMap linkedHashMap = cixVar.l;
                    if (bundleG.containsKey("android-support-nav:controller:navigatorState")) {
                        bundle = bundleG.getBundle("android-support-nav:controller:navigatorState");
                        if (bundle == null) {
                            cmz.ad("android-support-nav:controller:navigatorState");
                            throw null;
                        }
                    } else {
                        bundle = null;
                    }
                    cixVar.d = bundle;
                    cixVar.e = bundleG.containsKey("android-support-nav:controller:backStack") ? (Bundle[]) KotlinHelpers.w("android-support-nav:controller:backStack", bundleG).toArray(new Bundle[0]) : null;
                    linkedHashMap.clear();
                    if (bundleG.containsKey("android-support-nav:controller:backStackDestIds") && bundleG.containsKey("android-support-nav:controller:backStackIds")) {
                        int[] intArray = bundleG.getIntArray("android-support-nav:controller:backStackDestIds");
                        if (intArray == null) {
                            cmz.ad("android-support-nav:controller:backStackDestIds");
                            throw null;
                        }
                        ArrayList<String> stringArrayList = bundleG.getStringArrayList("android-support-nav:controller:backStackIds");
                        if (stringArrayList == null) {
                            cmz.ad("android-support-nav:controller:backStackIds");
                            throw null;
                        }
                        int length = intArray.length;
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < length) {
                            int i8 = i7 + 1;
                            cixVar.k.put(Integer.valueOf(intArray[i6]), !nullSafeIsEqual(stringArrayList.get(i7), "") ? stringArrayList.get(i7) : null);
                            i6++;
                            i7 = i8;
                        }
                    }
                    if (bundleG.containsKey("android-support-nav:controller:backStackStates")) {
                        ArrayList<String> stringArrayList2 = bundleG.getStringArrayList("android-support-nav:controller:backStackStates");
                        if (stringArrayList2 == null) {
                            cmz.ad("android-support-nav:controller:backStackStates");
                            throw null;
                        }
                        for (String str : stringArrayList2) {
                            String str2 = "android-support-nav:controller:backStackStates:" + str;
                            throwIfVar1IsNull(str2, "key");
                            if (bundleG.containsKey(str2)) {
                                ArrayList arrayListW = KotlinHelpers.w("android-support-nav:controller:backStackStates:" + str, bundleG);
                                km kmVar = new km(arrayListW.size());
                                Iterator it = arrayListW.iterator();
                                while (it.hasNext()) {
                                    kmVar.addLast(new cir((Bundle) it.next()));
                                }
                                linkedHashMap.put(str, kmVar);
                            }
                        }
                    }
                    i = 0;
                    boolean z = bundleG.getBoolean("android-support-nav:controller:deepLinkHandled", false);
                    Boolean boolValueOf = (z || !bundleG.getBoolean("android-support-nav:controller:deepLinkHandled", true)) ? Boolean.valueOf(z) : null;
                    cjlVar.e = boolValueOf != null ? boolValueOf.booleanValue() : false;
                } else {
                    i = 0;
                }
                ((but) navHostFragment.ck.c).ad("android-support-nav:fragment:navControllerState", new bdv(cjlVar, 1));
                Bundle bundleG2 = ((but) navHostFragment.ck.c).g("android-support-nav:fragment:graphId");
                if (bundleG2 != null) {
                    navHostFragment.c = bundleG2.getInt("android-support-nav:fragment:graphId");
                }
                ((but) navHostFragment.ck.c).ad("android-support-nav:fragment:graphId", new bdv(navHostFragment, i4));
                int i9 = navHostFragment.c;
                Kotlin$Lazy kotlin$LazyVar = cjlVar.h;
                if (i9 != 0) {
                    cixVar.ap(((cjm) kotlin$LazyVar.getValue()).f(i9), null);
                } else {
                    Bundle bundle3 = navHostFragment.ax;
                    if (bundle3 != null) {
                        i = bundle3.getInt("android-support-nav:fragment:graphId");
                    }
                    Bundle bundle4 = bundle3 != null ? bundle3.getBundle("android-support-nav:fragment:startDestinationArgs") : null;
                    if (i != 0) {
                        cixVar.ap(((cjm) kotlin$LazyVar.getValue()).f(i), bundle4);
                    }
                }
                return cjlVar;
            case 4:
                bpy bpyVar = (bpy) ((but) obj).b;
                cot cotVar = new cot(bpyVar.a, 3);
                String str3 = bpyVar.b;
                if (StringsKt.isBlank(str3)) {
                    str3 = null;
                }
                if (str3 != null) {
                    cotVar.b = str3;
                }
                String str4 = !StringsKt.isBlank("") ? "" : null;
                if (str4 != null) {
                    cotVar.d = str4;
                }
                return cotVar;
            case 5:
                return new cpc((Context) ((chm) ((but) ((but) obj).b).b).c);
            case 6:
                chm chmVar = (chm) ((but) obj).b;
                Context context = (Context) chmVar.c;
                String str5 = ((bpy) ((but) chmVar.d).b).a;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                Notification notification = new Notification();
                notification.when = System.currentTimeMillis();
                notification.audioStreamType = -1;
                ArrayList arrayList4 = new ArrayList();
                String str6 = (String) chmVar.e;
                if (StringsKt.isBlank(str6)) {
                    str6 = null;
                }
                CharSequence charSequenceBe = str6 != null ? dqc.coerceIn5120Chars(str6) : null;
                String str7 = (String) chmVar.f;
                if (StringsKt.isBlank(str7)) {
                    str7 = null;
                }
                CharSequence charSequenceBe2 = str7 != null ? dqc.coerceIn5120Chars(str7) : null;
                CharSequence charSequence = !StringsKt.isBlank("") ? "" : null;
                CharSequence charSequenceBe3 = charSequence != null ? dqc.coerceIn5120Chars(charSequence) : null;
                CharSequence charSequence2 = !StringsKt.isBlank("") ? "" : null;
                CharSequence charSequenceBe4 = charSequence2 != null ? dqc.coerceIn5120Chars(charSequence2) : null;
                CharSequence charSequence3 = !StringsKt.isBlank("") ? "" : null;
                CharSequence charSequenceBe5 = charSequence3 != null ? dqc.coerceIn5120Chars(charSequence3) : null;
                String str8 = !StringsKt.isBlank("") ? "" : null;
                String str9 = str8 != null ? str8 : null;
                String str10 = !StringsKt.isBlank("") ? "" : null;
                String str11 = str10 != null ? str10 : null;
                CharSequence charSequence4 = !StringsKt.isBlank("") ? "" : null;
                if (charSequence4 != null) {
                    notification.tickerText = dqc.coerceIn5120Chars(charSequence4);
                }
                String str12 = !StringsKt.isBlank("") ? "" : null;
                if (str12 == null) {
                    str12 = null;
                }
                String str13 = StringsKt.isBlank("") ? null : "";
                if (str13 == null) {
                    str13 = null;
                }
                eu.b(23);
                eu.b(23);
                notification.icon = R.drawable.ic_simple_notification;
                if (((Number) eu.a.getValue()).intValue() < 26) {
                    notification.defaults = -1;
                    notification.flags |= 1;
                }
                new ArrayList();
                Bundle bundle5 = new Bundle();
                int i10 = Build.VERSION.SDK_INT;
                Notification.Builder builder = new Notification.Builder(context, str5);
                builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequenceBe).setContentText(charSequenceBe2).setContentInfo(charSequenceBe3).setContentIntent(null).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
                builder.setLargeIcon((Icon) null);
                builder.setSubText(charSequenceBe4).setUsesChronometer(false).setPriority(0);
                Iterator it2 = arrayList.iterator();
                if (it2.hasNext()) {
                    throw yg.d(it2);
                }
                builder.setShowWhen(true);
                builder.setLocalOnly(false);
                builder.setGroup(str9);
                builder.setSortKey(str12);
                builder.setGroupSummary(false);
                builder.setCategory(str11);
                builder.setColor(0);
                builder.setVisibility(0);
                builder.setPublicVersion(null);
                builder.setSound(notification.sound, notification.audioAttributes);
                if (i10 < 28) {
                    ArrayList arrayList5 = new ArrayList(arrayList2.size());
                    Iterator it3 = arrayList2.iterator();
                    if (it3.hasNext()) {
                        throw yg.d(it3);
                    }
                    kz kzVar = new kz(arrayList4.size() + arrayList5.size());
                    kzVar.addAll(arrayList5);
                    kzVar.addAll(arrayList4);
                    arrayList4 = new ArrayList(kzVar);
                }
                if (!arrayList4.isEmpty()) {
                    Iterator it4 = arrayList4.iterator();
                    while (it4.hasNext()) {
                        builder.addPerson((String) it4.next());
                    }
                }
                if (arrayList3.size() > 0) {
                    bundle2 = new Bundle();
                    Bundle bundle6 = bundle2.getBundle("android.car.EXTENSIONS");
                    if (bundle6 == null) {
                        bundle6 = new Bundle();
                    }
                    Bundle bundle7 = new Bundle(bundle6);
                    Bundle bundle8 = new Bundle();
                    if (arrayList3.size() > 0) {
                        Integer.toString(0);
                        if (arrayList3.get(0) != null) {
                            throw new ClassCastException();
                        }
                        new Bundle();
                        throw null;
                    }
                    bundle6.putBundle("invisible_actions", bundle8);
                    bundle7.putBundle("invisible_actions", bundle8);
                    bundle2.putBundle("android.car.EXTENSIONS", bundle6);
                    bundle5.putBundle("android.car.EXTENSIONS", bundle7);
                    r10 = 0;
                } else {
                    r10 = 0;
                    bundle2 = null;
                }
                int i11 = Build.VERSION.SDK_INT;
                builder.setExtras(bundle2);
                builder.setRemoteInputHistory(r10);
                builder.setBadgeIconType(0);
                builder.setSettingsText(charSequenceBe5);
                builder.setShortcutId(str13);
                builder.setTimeoutAfter(0L);
                builder.setGroupAlertBehavior(0);
                if (!TextUtils.isEmpty(str5)) {
                    builder.setSound(r10).setDefaults(0).setLights(0, 0, 0).setVibrate(r10);
                }
                if (i11 >= 28) {
                    Iterator it5 = arrayList2.iterator();
                    if (it5.hasNext()) {
                        throw yg.d(it5);
                    }
                }
                if (i11 >= 29) {
                    ke.f(builder);
                    ke.g(builder);
                }
                if (i11 >= 36) {
                    bb.f(builder);
                }
                return builder.build();
            case 7:
                cef cefVar = (cef) obj;
                cto.a.p(cefVar.e.isChecked());
                ctn.a.p(cefVar.d.isChecked());
                ctm.a.p(cefVar.c.isChecked());
                return kotlinUnitVar;
            case 8:
                return new eqi(((cua) obj).a);
            case 9:
                cem cemVar2 = (cem) obj;
                cxk.a.u(String.valueOf(cemVar2.d.getText()));
                cxj.a.u(String.valueOf(cemVar2.c.getText()));
                return kotlinUnitVar;
            case 10:
                ddg.a.q(((ceq) obj).c.getValue());
                return kotlinUnitVar;
            case 11:
                return aye.u((err) obj);
            case 12:
                dep depVar = (dep) obj;
                depVar.ap().j(new cyo(depVar, i3));
                return kotlinUnitVar;
            case 13:
                cem cemVar3 = (cem) obj;
                des.a.u(String.valueOf(cemVar3.c.getText()));
                det.a.u(String.valueOf(cemVar3.d.getText()));
                return kotlinUnitVar;
            case 14:
                dfz dfzVar = (dfz) obj;
                return Integer.valueOf(FastKV.af(dfzVar, dfzVar.u));
            case 15:
                bqr bqrVar = (bqr) obj;
                djf.a.u(String.valueOf(((TextInputEditText) bqrVar.c).getText()));
                djg.a.u(String.valueOf(((TextInputEditText) bqrVar.e).getText()));
                dje.a.p(((MaterialCheckBox) bqrVar.d).isChecked());
                return kotlinUnitVar;
            case 16:
                cem cemVar4 = (cem) obj;
                dkf.a.u(String.valueOf(cemVar4.c.getText()));
                dkg.a.u(String.valueOf(cemVar4.d.getText()));
                return kotlinUnitVar;
            case 17:
                bqr bqrVar2 = (bqr) obj;
                int checkedRadioButtonId = ((RadioGroup) bqrVar2.e).getCheckedRadioButtonId();
                if (checkedRadioButtonId == ((MaterialRadioButton) bqrVar2.d).getId()) {
                    dkk.a.r(dkj.a.d);
                } else if (checkedRadioButtonId == ((MaterialRadioButton) bqrVar2.c).getId()) {
                    dkk.a.r(dkj.b.d);
                }
                return kotlinUnitVar;
            case 18:
                dlu dluVar = dlu.a;
                Long lBg = dnq.bg(String.valueOf(((cee) obj).c.getText()));
                dluVar.s(lBg != null ? lBg.longValue() : 88888L);
                return kotlinUnitVar;
            case 19:
                ((eqg) obj).invoke();
                return kotlinUnitVar;
            default:
                etq.a.r((int) ((ceq) obj).c.getValue());
                return kotlinUnitVar;
        }
    }
}
