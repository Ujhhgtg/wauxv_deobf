package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class BottomTabMaterialHook extends SwitchHook implements bnp {
    public static final BottomTabMaterialHook INSTANCE;
    public static final String b;
    public static final Kotlin$Lazy emptyBitmap;
    public static final Kotlin$Lazy icon1;
    public static final Kotlin$Lazy icon2;
    public static final Kotlin$Lazy icon3;
    public static final Kotlin$Lazy icon4;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg r;
    public static final boolean s;

    static {
        // "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-436961382759210L)   */;
        // "#FFCCE8E3" /* "#FFCCE8E3" /* "#FFCCE8E3" /* "#FFCCE8E3" /* cnb.z(-436935612955434L)   */;
        // "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-436909843151658L)   */;
        // "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-436884073347882L)   */;
        // "#FF324B48" /* "#FF324B48" /* "#FF324B48" /* "#FF324B48" /* cnb.z(-436789584067370L)   */;
        // "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-425218942171946L)   */;
        INSTANCE = new BottomTabMaterialHook("BottomTabMaterialHook");
        b = PathUtils.getModuleSubDir("Resource", "BottomTab");
        emptyBitmap = new Kotlin$Lazy(new h(14));
        icon1 = new Kotlin$Lazy(new h(15));
        icon2 = new Kotlin$Lazy(new h(16));
        icon3 = new Kotlin$Lazy(new h(17));
        icon4 = new Kotlin$Lazy(new h(18));
        l = "美化";
        m = "底栏 Material You";
        n = "替换主页底部标签栏为 Material You 样式";
        r = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(13);
        s = true;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return m;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return l;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return n;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg getOnClick() {
        return r;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final boolean q() {
        return s;
    }

    @Override // me.hd.wauxv.obf.bnp
    public final void t(Activity activity, ViewGroup viewGroup, Object obj) {
        if (getIsEnabled()) {
            qb qbVar = new qb(aqu.e(HugeSyntheticPileOfHelpers.wrapModuleContext(activity)), R.attr.bottomNavigationStyle,
                    R.style.Widget_Design_BottomNavigationView);
            FactoryPools factoryPoolsVarAo = FastKV.ao(qbVar.getContext(), null, cxs.d, R.attr.bottomNavigationStyle,
                    R.style.Widget_Design_BottomNavigationView, new int[0]);
            TypedArray typedArray = (TypedArray) factoryPoolsVarAo.e;
            qbVar.setItemHorizontalTranslationEnabled(typedArray.getBoolean(2, true));
            if (typedArray.hasValue(0)) {
                qbVar.setMinimumHeight(typedArray.getDimensionPixelSize(0, 0));
            }
            typedArray.getBoolean(1, true);
            factoryPoolsVarAo.ae();
            StaticAndroidHelpers.af(qbVar, new nu(4));
            qbVar.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) cnh.r(56, qbVar.getContext())));
            qbVar.setLabelVisibilityMode(2);
            if (cnh.aa(qbVar.getContext())) {
                qbVar.setBackgroundColor(Color.parseColor(qq.a.o()));
                qbVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(qu.a.o())));
                qbVar.setItemIconTintList(emc.ai(Color.parseColor(qs.a.o())));
            } else {
                qbVar.setBackgroundColor(Color.parseColor(qr.a.o()));
                qbVar.setItemActiveIndicatorColor(emc.ai(Color.parseColor(qv.a.o())));
                qbVar.setItemIconTintList(emc.ai(Color.parseColor(qt.a.o())));
            }
            Menu menu = qbVar.getMenu();
            MenuItem menuItemAdd = menu.add(0, 0, 0, "");
            menuItemAdd.setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) icon1.getValue()));
            menu.add(0, 1, 1, "")
                    .setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) icon2.getValue()));
            menu.add(0, 2, 2, "")
                    .setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) icon3.getValue()));
            menu.add(0, 3, 3, "")
                    .setIcon(new BitmapDrawable(qbVar.getResources(), (Bitmap) icon4.getValue()));
            qbVar.setOnItemSelectedListener(new qp(obj, 0));
            ViewParent parent = viewGroup.getParent();
            View childAt = ((ViewGroup) parent).getChildAt(1);
            ((ViewGroup) childAt).addView(qbVar);
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "onPageSelected";
            HookManager hookManagerVarAd = createImmediateHook((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods()), HookPriorityEnum.ENUM_DEFAULT);
            INSTANCE.hookAfter(hookManagerVarAd, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(qbVar, 1));
            hookManagerVarAd.initInstantCollectionAndApplyHooks();
        }
    }
}
