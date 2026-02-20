package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qp implements cke, aww, awz, EventListener.Factory, w {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ qp(Object obj, int i) {
        this.b = i;
        this.c = obj;
    }

    @Override // me.hd.wauxv.obf.w
    public void a(Object[] objArr, int i) {
        ewa ewaVar = (ewa) this.c;
        CodeEditor codeEditor = ewaVar.b;
        if (codeEditor != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : objArr) {
                arrayList.add((evz) obj);
            }
            Collections.sort(arrayList);
            codeEditor.ei(new ale(ewaVar, codeEditor, arrayList, 4));
        }
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return Util.asFactory$lambda$8((EventListener) this.c, call);
    }

    @Override // me.hd.wauxv.obf.cke
    public boolean d(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Object obj = this.c;
        if (itemId == 0) {
            int i = 0;
            MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT.name = "onTabClick" /* "onTabClick" /* "onTabClick" /* "onTabClick" /* cnb.z(-436634965244714L)   */;
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invokeAndThrowIfFailed(0);
            return true;
        }
        if (itemId == 1) {
            int i2 = 0;
            MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT2.name = "onTabClick" /* "onTabClick" /* "onTabClick" /* "onTabClick" /* cnb.z(-436604900473642L)   */;
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invokeAndThrowIfFailed(1);
            return true;
        }
        if (itemId == 2) {
            int i3 = 0;
            MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
            methodResolverVarT3.name = "onTabClick" /* "onTabClick" /* "onTabClick" /* "onTabClick" /* cnb.z(-436523296095018L)   */;
            ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT3.findMethods())).invokeAndThrowIfFailed(2);
            return true;
        }
        if (itemId != 3) {
            return true;
        }
        int i4 = 0;
        MethodResolver methodResolverVarT4 = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT4.name = "onTabClick" /* "onTabClick" /* "onTabClick" /* "onTabClick" /* cnb.z(-437042987137834L)   */;
        ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT4.findMethods())).invokeAndThrowIfFailed(3);
        return true;
    }

    @Override // me.hd.wauxv.obf.aww
    public void e(ua uaVar) {
        switch (this.b) {
            case 3:
                final erp erpVar = (erp) this.c;
                ahu ahuVar = (ahu) uaVar;
                throwIfVar1IsNull(ahuVar, "event");
                ContextMenu contextMenu = ahuVar.a;
                throwIfVar1IsNull(contextMenu, "menu");
                CodeEditor codeEditor = (CodeEditor) erpVar.v;
                Context context = codeEditor.getContext();
                throwIfVar1IsNull(context, "getContext(...)");
                ArrayList<art> arrayList = new ArrayList();
                art artVar = new art(context);
                artVar.f(R.string.selectAll);
                artVar.d = me.hd.wauxv.R.drawable.round_select_all_20;
                aff text = codeEditor.getText();
                throwIfVar1IsNull(text, "getText(...)");
                artVar.c = !(text.d == 0);
                final int i = 3;
                int i2 = 0;
                artVar.e = new ars(new IFunction0() { // from class: me.hd.wauxv.obf.arr
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i) {
                            case 0:
                                ((CodeEditor) erpVar.v).eg();
                                break;
                            case 1:
                                ((CodeEditor) erpVar.v).df(true);
                                break;
                            case 2:
                                ((CodeEditor) erpVar.v).di();
                                break;
                            default:
                                ((CodeEditor) erpVar.v).em();
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, i2);
                arrayList.add(artVar);
                art artVar2 = new art(context);
                artVar2.f(R.string.copy);
                artVar2.d = me.hd.wauxv.R.drawable.round_content_copy_20;
                artVar2.c = codeEditor.bo.h();
                final int i3 = 1;
                artVar2.e = new ars(new IFunction0() { // from class: me.hd.wauxv.obf.arr
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i3) {
                            case 0:
                                ((CodeEditor) erpVar.v).eg();
                                break;
                            case 1:
                                ((CodeEditor) erpVar.v).df(true);
                                break;
                            case 2:
                                ((CodeEditor) erpVar.v).di();
                                break;
                            default:
                                ((CodeEditor) erpVar.v).em();
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, i2);
                arrayList.add(artVar2);
                art artVar3 = new art(context);
                artVar3.f(R.string.cut);
                artVar3.d = me.hd.wauxv.R.drawable.round_content_cut_20;
                artVar3.c = codeEditor.bo.h();
                final int i4 = 2;
                artVar3.e = new ars(new IFunction0() { // from class: me.hd.wauxv.obf.arr
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i4) {
                            case 0:
                                ((CodeEditor) erpVar.v).eg();
                                break;
                            case 1:
                                ((CodeEditor) erpVar.v).df(true);
                                break;
                            case 2:
                                ((CodeEditor) erpVar.v).di();
                                break;
                            default:
                                ((CodeEditor) erpVar.v).em();
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, i2);
                arrayList.add(artVar3);
                art artVar4 = new art(context);
                artVar4.f(R.string.paste);
                artVar4.d = me.hd.wauxv.R.drawable.round_content_paste_20;
                artVar4.c = codeEditor.bm.hasPrimaryClip();
                final int i5 = 0;
                artVar4.e = new ars(new IFunction0() { // from class: me.hd.wauxv.obf.arr
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i5) {
                            case 0:
                                ((CodeEditor) erpVar.v).eg();
                                break;
                            case 1:
                                ((CodeEditor) erpVar.v).df(true);
                                break;
                            case 2:
                                ((CodeEditor) erpVar.v).di();
                                break;
                            default:
                                ((CodeEditor) erpVar.v).em();
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, i5);
                arrayList.add(artVar4);
                for (art artVar5 : arrayList) {
                    artVar5.getClass();
                    MenuItem onMenuItemClickListener = contextMenu.add(0, 0, 0, artVar5.b).setEnabled(artVar5.c)
                            .setOnMenuItemClickListener(artVar5.e);
                    int i6 = artVar5.d;
                    if (i6 != 0) {
                        onMenuItemClickListener.setIcon(i6);
                    }
                }
                break;
            default:
                byw bywVar = (byw) this.c;
                Drawable background = bywVar.b.getContentView().getBackground();
                if (background != null) {
                    background.setTint(bywVar.a.getColorScheme().b.get(4));
                }
                break;
        }
    }

    public void f(ng ngVar) {
        Drawable.ConstantState constantState;
        Drawable.ConstantState constantState2;
        final aek aekVar = (aek) this.c;
        Kotlin$Lazy kotlin$LazyVar = aekVar.f;
        Kotlin$Lazy kotlin$LazyVar2 = aekVar.h;
        Kotlin$Lazy kotlin$LazyVar3 = aekVar.g;
        Kotlin$Lazy kotlin$LazyVar4 = aekVar.i;
        RelativeLayout relativeLayout = ((ccu) ngVar).bl.g;
        final int i = 0;
        relativeLayout.setVisibility(0);
        relativeLayout.addView(aekVar.n(), new RelativeLayout.LayoutParams(-1, -2));
        aekVar.n().removeViewAt(3);
        LinearLayout linearLayoutN = aekVar.n();
        Kotlin$Lazy kotlin$LazyVar5 = aekVar.d;
        linearLayoutN.addView((LinearLayout) kotlin$LazyVar5.getValue(), 3);
        Kotlin$Lazy kotlin$LazyVar6 = aekVar.e;
        RecyclerView recyclerView = (RecyclerView) kotlin$LazyVar6.getValue();
        HostInfoRegistry.INSTANCE.getClass();
        HostInfoRegistry.getContext();
        final int i2 = 1;
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        aekVar.l.ag();
        ((RecyclerView) kotlin$LazyVar6.getValue()).setAdapter(aekVar.l);
        ael aelVar = aekVar.a;
        if (aelVar == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-394565760580394L)   */);
            throw null;
        }
        ((EditText) kotlin$LazyVar.getValue()).setHint(aelVar.f);
        ((EditText) kotlin$LazyVar.getValue()).addTextChangedListener(new wg(aekVar, i2));
        ael aelVar2 = aekVar.a;
        if (aelVar2 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-394527105874730L)   */);
            throw null;
        }
        ((Button) kotlin$LazyVar3.getValue()).setText(aelVar2.h);
        int i3 = 0;
        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration((Button) kotlin$LazyVar2.getValue()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT.name = "setIconResource" /* "setIconResource" /* "setIconResource" /* "setIconResource" /* cnb.z(-394539990776618L)   */;
        Class cls = Integer.TYPE;
        MethodHookWrapper methodHookWrapperVar = (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(cls) }, 1, methodResolverVarT);
        ael aelVar3 = aekVar.a;
        if (aelVar3 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-394471271299882L)   */);
            throw null;
        }
        methodHookWrapperVar.invokeAndThrowIfFailed(Integer.valueOf(aelVar3.g));
        MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration((Button) kotlin$LazyVar3.getValue()).getMethodResolverBasedOnPreviouslyProvidedConfig();
        methodResolverVarT2.name = "setIconResource" /* "setIconResource" /* "setIconResource" /* "setIconResource" /* cnb.z(-393882860780330L)   */;
        MethodHookWrapper methodHookWrapperVar2 = (MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(cls) }, 1, methodResolverVarT2);
        ael aelVar4 = aekVar.a;
        if (aelVar4 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393814141303594L)   */);
            throw null;
        }
        methodHookWrapperVar2.invokeAndThrowIfFailed(Integer.valueOf(aelVar4.i));
        ael aelVar5 = aekVar.a;
        if (aelVar5 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393827026205482L)   */);
            throw null;
        }
        ((Button) kotlin$LazyVar3.getValue()).setOnClickListener(new aeh(aelVar5.k, i, aekVar));
        ael aelVar6 = aekVar.a;
        if (aelVar6 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393788371499818L)   */);
            throw null;
        }
        ((Button) kotlin$LazyVar2.getValue()).setText(aelVar6.j);
        ael aelVar7 = aekVar.a;
        if (aelVar7 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393732536924970L)   */);
            throw null;
        }
        ((Button) kotlin$LazyVar2.getValue()).setOnClickListener(new aeh(aelVar7.l, i2, aekVar));
        RadioGroup radioGroup = (RadioGroup) kotlin$LazyVar4.getValue();
        int childCount = radioGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = radioGroup.getChildAt(i4);
            if (childAt.getId() != me.hd.wauxv.R.id.rbAll) {
                childAt.setVisibility(8);
            }
        }
        ael aelVar8 = aekVar.a;
        if (aelVar8 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393762601696042L)   */);
            throw null;
        }
        for (String str : StaticHelpers5.z(aelVar8.d.keySet())) {
            RadioButton radioButton = (RadioButton) ((RadioGroup) kotlin$LazyVar4.getValue())
                    .findViewById(me.hd.wauxv.R.id.rbAll);
            ip ipVar = new ip(radioButton.getContext(), null, 0);
            ipVar.setTextColor(radioButton.getTextColors());
            ipVar.setTextSize(radioButton.getTextSize() / ipVar.getResources().getDisplayMetrics().scaledDensity);
            ipVar.setButtonTintList(radioButton.getButtonTintList());
            ipVar.setLayoutParams(radioButton.getLayoutParams());
            ipVar.setPadding(ipVar.getPaddingLeft(), ipVar.getPaddingTop(), ipVar.getPaddingRight(),
                    ipVar.getPaddingBottom());
            ipVar.setGravity(radioButton.getGravity());
            Drawable buttonDrawable = radioButton.getButtonDrawable();
            ipVar.setButtonDrawable(
                    (buttonDrawable == null || (constantState2 = buttonDrawable.getConstantState()) == null) ? null
                            : constantState2.newDrawable());
            Drawable background = radioButton.getBackground();
            ipVar.setBackground((background == null || (constantState = background.getConstantState()) == null) ? null
                    : constantState.newDrawable());
            ipVar.setText(str);
            ((RadioGroup) kotlin$LazyVar4.getValue()).addView(ipVar);
        }
        adw adwVar = aekVar.l;
        ael aelVar9 = aekVar.a;
        if (aelVar9 == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* "info" /* cnb.z(-393706767121194L)   */);
            throw null;
        }
        ArrayList arrayList = aelVar9.c;
        if (!aelVar9.b || arrayList.isEmpty()) {
            arrayList = aelVar9.e;
        }
        adw.h(adwVar, arrayList);
        aekVar.q();
        aekVar.o();
        ((CheckBox) aekVar.j.getValue()).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from
                                                                                                                   // class:
                                                                                                                   // me.hd.wauxv.obf.aei
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                switch (i) {
                    case 0:
                        if (compoundButton.isPressed()) {
                            aek aekVar2 = aekVar;
                            List<adx> list = aekVar2.l.a;
                            ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(list, 10));
                            for (adx adxVar : list) {
                                adxVar.d = z;
                                arrayList2.add(adxVar);
                            }
                            aekVar2.l.af();
                        }
                        break;
                    default:
                        if (z) {
                            StaticAndroidHelpers.runOnUiThread(aekVar, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(compoundButton, 2));
                        }
                        break;
                }
            }
        });
        RadioGroup radioGroup2 = (RadioGroup) kotlin$LazyVar4.getValue();
        int childCount2 = radioGroup2.getChildCount();
        while (i < childCount2) {
            View childAt2 = radioGroup2.getChildAt(i);
            if (childAt2 instanceof RadioButton) {
                ((RadioButton) childAt2).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from
                                                                                                                   // class:
                                                                                                                   // me.hd.wauxv.obf.aei
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        switch (i2) {
                            case 0:
                                if (compoundButton.isPressed()) {
                                    aek aekVar2 = aekVar;
                                    List<adx> list = aekVar2.l.a;
                                    ArrayList arrayList2 = new ArrayList(StaticHelpers4.ak(list, 10));
                                    for (adx adxVar : list) {
                                        adxVar.d = z;
                                        arrayList2.add(adxVar);
                                    }
                                    aekVar2.l.af();
                                }
                                break;
                            default:
                                if (z) {
                                    StaticAndroidHelpers.runOnUiThread(aekVar, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(compoundButton, 2));
                                }
                                break;
                        }
                    }
                });
            }
            i++;
        }
        HostInfoRegistry.INSTANCE.getClass();
        ((LinearLayout) kotlin$LazyVar5.getValue())
                .getLayoutParams().height = HostInfoRegistry.getContext().getResources().getDisplayMetrics().heightPixels / 2;
    }

    @Override // me.hd.wauxv.obf.awz
    public void g(ua uaVar, afc afcVar) {
        int i;
        switch (this.b) {
            case 4:
                afh afhVar = (afh) uaVar;
                pf pfVar = ((asa) this.c).c;
                int i2 = afhVar.a;
                ud udVar = afhVar.m;
                ud udVar2 = afhVar.l;
                if (i2 == 2) {
                    int i3 = udVar2.a;
                    int i4 = udVar.a - i3;
                    int i5 = pfVar.a;
                    if (i5 <= i3 && (i = pfVar.b) >= i3) {
                        pfVar.b = i + i4;
                    }
                    if (i5 > i3) {
                        pfVar.a = i5 + i4;
                        pfVar.b += i4;
                    }
                } else if (i2 == 3) {
                    int i6 = udVar2.a;
                    int i7 = udVar.a;
                    int i8 = i7 - i6;
                    int iMax = Math.max(i6, pfVar.a);
                    int iMin = Math.min(i7, pfVar.b);
                    if (iMin > iMax) {
                        int i9 = pfVar.b - (iMin - iMax);
                        pfVar.b = i9;
                        int i10 = pfVar.a;
                        if (i10 > i6) {
                            int i11 = i10 - i6;
                            pfVar.a = i10 - i11;
                            pfVar.b = i9 - i11;
                        }
                    } else {
                        int i12 = pfVar.a;
                        if (i12 >= i7) {
                            pfVar.a = i12 - i8;
                            pfVar.b -= i8;
                        }
                    }
                }
                break;
            case 5:
                ase aseVar = (ase) this.c;
                dfb dfbVar = (dfb) uaVar;
                if (!aseVar.ad) {
                    afcVar.b = true;
                    aseVar.ae = false;
                } else {
                    int i13 = dfbVar.o;
                    if ((i13 == 2 || i13 == 3 || i13 == 4 || i13 == 5) && aseVar.ao(4)
                            && ((Math.abs(dfbVar.m - dfbVar.a) > 80 || Math.abs(dfbVar.n - dfbVar.l) > 80)
                                    && aseVar.z.isShowing())) {
                        aseVar.i();
                    } else if (aseVar.ao(1)) {
                        aseVar.an(false);
                    }
                }
                break;
            case 6:
                FactoryPools factoryPoolsVar = (FactoryPools) this.c;
                if (!((dfn) uaVar).n()) {
                    factoryPoolsVar.af(new dh(factoryPoolsVar, 10));
                }
                break;
            default:
                ((aww) this.c).e(uaVar);
                break;
        }
    }
}
