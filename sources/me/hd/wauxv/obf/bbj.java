package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bbj extends BaseHook implements bnp {
    public static final bbj a;
    public static final String b;
    public static final List c;
    public static final dov h;
    public static final String i;
    public static final String j;
    public static final String l;
    public static final ayz m;

    static {
        "#FFF7F7F7" /* cnb.z(-550666346953514L) */;
        "#FF1E1E1E" /* cnb.z(-550640577149738L) */;
        "#FF1E1E1E" /* cnb.z(-550614807345962L) */;
        "#FFF7F7F7" /* cnb.z(-549970562251562L) */;
        a = new bbj("FloatActionButtonHook" /* cnb.z(-553153133017898L) */);
        dov dovVar = ctf.a;
        b = ctf.c("Resource" /* cnb.z(-48086453844778L) */, "Fab" /* cnb.z(-48047799139114L) */);
        c = aba.ag(new bbe("设置" /* cnb.z(-549944792447786L) */, "ic_setting.png" /* cnb.z(-549949087415082L) */, "activity" /* cnb.z(-549884662905642L) */, 0, "me.hd.wauxv.ui.activity.ModuleActivity" /* cnb.z(-549846008199978L) */), new bbe("扫一扫" /* cnb.z(-550228260289322L) */, "ic_scan.png" /* cnb.z(-550176720681770L) */, "activity" /* cnb.z(-550159540812586L) */, 1, "com.tencent.mm.plugin.scanner.ui.BaseScanUI" /* cnb.z(-550120886106922L) */), new bbe("朋友圈" /* cnb.z(-551546815249194L) */, "ic_timeline.png" /* cnb.z(-551563995118378L) */, "activity" /* cnb.z(-551495275641642L) */, 2, "com.tencent.mm.plugin.sns.ui.improve.ImproveSnsTimelineUI" /* cnb.z(-551473800805162L) */), new bbe("视频号" /* cnb.z(-551722908908330L) */, "ic_finder.png" /* cnb.z(-551740088777514L) */, "activity" /* cnb.z(-551113023552298L) */, 3, "com.tencent.mm.plugin.finder.ui.FinderHomeAffinityUI" /* cnb.z(-551074368846634L) */), new bbe("收藏" /* cnb.z(-551379311524650L) */, "ic_favorite.png" /* cnb.z(-551383606491946L) */, "activity" /* cnb.z(-551314887015210L) */, 4, "com.tencent.mm.plugin.fav.ui.FavoriteIndexUI" /* cnb.z(-551293412178730L) */), new bbe("钱包" /* cnb.z(-574705278909226L) */, "ic_wallet.png" /* cnb.z(-574726753745706L) */, "activity" /* cnb.z(-574649444334378L) */, 5, "com.tencent.mm.plugin.mall.ui.MallIndexUIv2" /* cnb.z(-574610789628714L) */), new bbe("清空未读" /* cnb.z(-575005926619946L) */, "ic_clear.png" /* cnb.z(-574967271914282L) */, "wauxv" /* cnb.z(-574877077601066L) */, 6, "clearUnreadCount" /* cnb.z(-574902847404842L) */));
        h = new dov(new amd(5));
        i = "界面" /* cnb.z(-574778293353258L) */;
        j = "悬浮动作按钮" /* cnb.z(-574782588320554L) */;
        l = "为主界面右下角添加一个悬浮动作按钮" /* cnb.z(-574202767735594L) */;
        m = new ayz(24);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return j;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return i;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return l;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final bgf p() {
        return m;
    }

    @Override // me.hd.wauxv.obf.bnp
    public final void t(Activity activity, ViewGroup viewGroup, Object obj) {
        if (z()) {
            ViewParent parent = viewGroup.getParent();
            throwIfVar1IsNull(parent, "null cannot be cast to non-null type android.view.ViewGroup" /*
                                                                                                     * cnb.z(-
                                                                                                     * 553449485761322L)
                                                                                                     */);
            ViewGroup viewGroup2 = (ViewGroup) parent;
            a.getClass();
            io ioVar = new io(viewGroup2, (List) h.getValue(), 18, false);
            Context context = viewGroup2.getContext();
            throwIfVar1IsNull(context, "context");
            ant antVar = new ant(context);
            antVar.b = true;
            antVar.g = new nu(26);
            antVar.h = 40L;
            antVar.i = 600L;
            antVar.j = 600L;
            antVar.k = -16777216;
            antVar.l = -1;
            cuy cuyVar = cuy.a;
            antVar.p = cuyVar;
            antVar.v = new ArrayList();
            antVar.setupBaseViews(context);
            Resources.Theme theme = antVar.getContext().getTheme();
            int[] iArr = cxv.a;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(null, iArr, 0, 0);
            throwIfVar1IsNull(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                antVar.h = typedArrayObtainStyledAttributes.getInteger(3, 40);
                antVar.i = typedArrayObtainStyledAttributes.getInteger(9, 600);
                antVar.j = typedArrayObtainStyledAttributes.getInteger(1, 600);
                Interpolator interpolatorLoadInterpolator = AnimationUtils.loadInterpolator(antVar.getContext(),
                        typedArrayObtainStyledAttributes.getResourceId(10, R.anim.default_menu_interpolator));
                throwIfVar1IsNull(interpolatorLoadInterpolator,
                        "null cannot be cast to non-null type android.view.animation.Interpolator");
                antVar.setOpenInterpolatorAnimator(interpolatorLoadInterpolator);
                Interpolator interpolatorLoadInterpolator2 = AnimationUtils.loadInterpolator(antVar.getContext(),
                        typedArrayObtainStyledAttributes.getResourceId(2, R.anim.default_menu_interpolator));
                throwIfVar1IsNull(interpolatorLoadInterpolator2,
                        "null cannot be cast to non-null type android.view.animation.Interpolator");
                antVar.setCloseInterpolatorAnimator(interpolatorLoadInterpolator2);
                antVar.setMainButtonColor(typedArrayObtainStyledAttributes.getColor(5, -16777216));
                antVar.setMainButtonIconColor(typedArrayObtainStyledAttributes.getColor(7, -1));
                if (typedArrayObtainStyledAttributes.hasValue(6)) {
                    antVar.setMainButtonIcon(antVar.getResources()
                            .getDrawable(typedArrayObtainStyledAttributes.getResourceId(6, 0), null));
                }
                int integer = typedArrayObtainStyledAttributes.getInteger(11, 0);
                for (cuy cuyVar2 : cuy.values()) {
                    if (cuyVar2.ordinal() == integer) {
                        cuyVar = cuyVar2;
                        break;
                    }
                }
                antVar.setPositionGravity(cuyVar);
                typedArrayObtainStyledAttributes.recycle();
                TypedArray typedArrayObtainStyledAttributes2 = antVar.getContext().getTheme()
                        .obtainStyledAttributes(null, iArr, 0, 0);
                throwIfVar1IsNull(typedArrayObtainStyledAttributes2, "obtainStyledAttributes(...)");
                try {
                    int integer2 = typedArrayObtainStyledAttributes2.getInteger(4, 1);
                    axq axqVar = axq.a;
                    if (integer2 != 0) {
                        axqVar = axq.b;
                    }
                    antVar.setExpandDirection(axqVar);
                    antVar.e = typedArrayObtainStyledAttributes2.getLayoutDimension(8,
                            (int) antVar.getResources().getDimension(R.dimen.default_margin_between_menu_items));
                    typedArrayObtainStyledAttributes2.recycle();
                    antVar.setMainButtonColor(Color.parseColor((cnh.aa(antVar.getContext()) ? bbf.a : bbg.a).o()));
                    antVar.setMainButtonIcon(antVar.getContext().getDrawable(R.drawable.ic_float_button_icon_24dp));
                    antVar.setMainButtonIconColor(Color.parseColor((cnh.aa(antVar.getContext()) ? bbh.a : bbi.a).o()));
                    antVar.setDelayBetweenItemsAnimation(20L);
                    antVar.setOpenAnimationDuration(300L);
                    antVar.setCloseAnimationDuration(300L);
                    antVar.setMarginBetweenMenuItems((int) cnh.r(64, antVar.getContext()));
                    antVar.setPositionGravity(cuy.e);
                    antVar.setAdapter(ioVar);
                    antVar.setOnItemSelectedListener(new bka(antVar, 1, ioVar));
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 8388693;
                    layoutParams.bottomMargin = (int) cnh.r(64, viewGroup2.getContext());
                    layoutParams.rightMargin = (int) cnh.r(8, viewGroup2.getContext());
                    viewGroup2.addView(antVar, layoutParams);
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes2.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        }
    }
}
