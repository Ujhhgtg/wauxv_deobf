package me.hd.wauxv.obf;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.ConversationBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class age implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ age(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:118:0x0398 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Object objX;
        Object objX2;
        Object objX3;
        Class cls;
        boolean z;
        Class cls2;
        Object objX4;
        aid aidVar;
        int i = this.a;
        int i2 = 4;
        int i3 = 14;
        int i4 = 15;
        int i5 = 12;
        int i6 = 3;
        char c = 1;
        char c2 = 1;
        Object obj2 = null;
        int i7 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = FastKV.getFailureFromException(th);
                }
                Object obj3 = objX instanceof Failure ? null : objX;
                throwIfVar1IsNull(obj3);
                MenuItem menuItem = (MenuItem) obj3;
                int i8 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa(hookParam);
                fieldResolverVarAa.fieldType = StaticHelpers7.toDexMethod(agg.a).getDeclaringClass();
                Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa.resolve())).getValue();
                throwIfVar1IsNull(objD);
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(objD).r();
                agc.a.getClass();
                fieldResolverVarR.fieldType = StaticHelpers7.toDexMethod(agb.a).getDeclaringClass();
                Object objD2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
                throwIfVar1IsNull(objD2);
                ConversationBean conversationBean = new ConversationBean(objD2);
                for (bnf bnfVar : agi.b) {
                    try {
                        for (agf agfVar : bnfVar.a(conversationBean)) {
                            if (menuItem.getItemId() == agfVar.a) {
                                agfVar.c.invoke(conversationBean);
                            }
                        }
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-38555921414954L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                bnfVar instanceof SwitchHook ? ((SwitchHook) bnfVar).getResult() : "LoadHook" /*
                                                                                                               * cnb.z(-
                                                                                                               * 38508676774698L)
                                                                                                               */,
                                -39019777882922L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 1:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
                    objX2 = null;
                }
                throwIfVar1IsNull(objX2);
                ContextMenu contextMenu = (ContextMenu) objX2;
                try {
                    objX3 = hookParam2.getArgs()[2];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = FastKV.getFailureFromException(th3);
                }
                Object obj4 = objX3 instanceof Failure ? null : objX3;
                throwIfVar1IsNull(obj4);
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) obj4;
                int i9 = 0;
                FieldResolver fieldResolverVarAa2 = StaticHelpers6.aa(hookParam2);
                agc.a.getClass();
                fieldResolverVarAa2.fieldType = StaticHelpers7.toDexMethod(agb.a).getDeclaringClass();
                Object objD3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarAa2.resolve())).getValue();
                throwIfVar1IsNull(objD3);
                ConversationBean conversationBean2 = new ConversationBean(objD3);
                for (bnf bnfVar2 : agi.b) {
                    try {
                        for (agf agfVar2 : bnfVar2.a(conversationBean2)) {
                            contextMenu.add(adapterContextMenuInfo.position, agfVar2.a, 0, agfVar2.b);
                        }
                    } catch (Exception e2) {
                        ArrayList arrayList2 = Logger.a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onCreateMenuItems " /* "onCreateMenuItems " /* "onCreateMenuItems " /* cnb.z(-38744899975978L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb2,
                                bnfVar2 instanceof SwitchHook ? ((SwitchHook) bnfVar2).getResult() : "LoadHook" /*
                                                                                                                 * cnb.z
                                                                                                                 * (-
                                                                                                                 * 38628935858986L)
                                                                                                                 */,
                                -38590281153322L), e2, 12);
                    }
                }
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(5);
                return kotlinUnitVar;
            case 3:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(i2);
                return kotlinUnitVar;
            case 4:
                bah bahVar = (bah) obj;
                String[] strArr = { "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* cnb.z(-35270271433514L)  */ };
                bahVar.getClass();
                bahVar.a = SomeStaticHelpers.ab(strArr);
                DexFinder cdjVar = new DexFinder();
                cdjVar.s("onMMMenuItemSelected" /* "onMMMenuItemSelected" /* "onMMMenuItemSelected" /* cnb.z(-35669703392042L)  */);
                cdjVar.usingStrings("com.tencent.mm.plugin.repairer.ui.RepairerChatroomDebugUI" /* "com.tencent.mm.plugin.repairer.ui.RepairerChatroomDebugUI" /* "com.tencent.mm.plugin.repairer.ui.RepairerChatroomDebugUI" /* cnb.z(-35631048686378L)  */);
                bahVar.d = cdjVar;
                return kotlinUnitVar;
            case 5:
                bah bahVar2 = (bah) obj;
                String[] strArr2 = { "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* "com.tencent.mm.ui.conversation" /* cnb.z(-38985418144554L)  */ };
                bahVar2.getClass();
                bahVar2.a = SomeStaticHelpers.ab(strArr2);
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.s("onCreateContextMenu" /* "onCreateContextMenu" /* "onCreateContextMenu" /* cnb.z(-38852274158378L)  */);
                if (cnb.ab(ewk.l) || cnb.ac(ewh.m)) {
                    cdjVar2.usingStrings("MicroMsg.ConversationLongClickListener" /* "MicroMsg.ConversationLongClickListener" /* "MicroMsg.ConversationLongClickListener" /* cnb.z(-35983236004650L)  */,
                            "onCreateContextMenu, contact is null, talker = " /* "onCreateContextMenu, contact is null, talker = " /* "onCreateContextMenu, contact is null, talker = " /* cnb.z(-35867271887658L)  */);
                } else {
                    cdjVar2.usingStrings("MicroMsg.ConversationClickListener" /* "MicroMsg.ConversationClickListener" /* "MicroMsg.ConversationClickListener" /* cnb.z(-36210869271338L)  */,
                            "onCreateContextMenu, contact is null, talker = " /* "onCreateContextMenu, contact is null, talker = " /* "onCreateContextMenu, contact is null, talker = " /* cnb.z(-36026185677610L)  */);
                }
                bahVar2.d = cdjVar2;
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(7);
                return kotlinUnitVar;
            case 7:
                bah bahVar3 = (bah) obj;
                DexFinder cdjVar3 = new DexFinder();
                DexFinder.setClassEquals(cdjVar3, "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* "com.tencent.mm.ui.conversation.ConversationListView" /* cnb.z(-120813135067946L)  */);
                cdjVar3.usingStrings("[checkEmptyFooter] isRealFull:" /* "[checkEmptyFooter] isRealFull:" /* "[checkEmptyFooter] isRealFull:" /* cnb.z(-120074400693034L)  */);
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return kotlinUnitVar;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new age(i4);
                return kotlinUnitVar;
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(13);
                return kotlinUnitVar;
            case 10:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(i3);
                return kotlinUnitVar;
            case 11:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(i5);
                return kotlinUnitVar;
            case 12:
                bah bahVar4 = (bah) obj;
                DexFinder cdjVar4 = new DexFinder();
                agp.a.getClass();
                cdjVar4.o(StaticHelpers7.az(agl.a));
                cdjVar4.usingStrings("MicroMsg.ConversationStorage" /* "MicroMsg.ConversationStorage" /* "MicroMsg.ConversationStorage" /* cnb.z(-373460291287850L)  */, "get null with username:" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 373387276843818L)
                                                                                                                    */);
                bahVar4.getClass();
                bahVar4.d = cdjVar4;
                return kotlinUnitVar;
            case 13:
                bah bahVar5 = (bah) obj;
                DexFinder cdjVar5 = new DexFinder();
                agp.a.getClass();
                cdjVar5.o(StaticHelpers7.az(agl.a));
                cdjVar5.usingStrings("updateUnreadByTalker %s" /* "updateUnreadByTalker %s" /* "updateUnreadByTalker %s" /* cnb.z(-371677879860010L)  */);
                bahVar5.getClass();
                bahVar5.d = cdjVar5;
                return kotlinUnitVar;
            case 14:
                bah bahVar6 = (bah) obj;
                DexFinder cdjVar6 = new DexFinder();
                agp.a.getClass();
                cdjVar6.o(StaticHelpers7.az(agl.a));
                cdjVar6.p(new IntRange(2, 4, 1));
                cdjVar6.v("Update " /* "Update " /* "Update " /* cnb.z(-372124556458794L)  */, "rconversation" /* "rconversation" /* "rconversation" /* cnb.z(-372090196720426L)  */,
                        " set " /* " set " /* " set " /* cnb.z(-372081606785834L)  */, "parentRef" /* "parentRef" /* "parentRef" /* cnb.z(-372038657112874L)  */, " = '" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 372012887309098L)
                                                                                                                    */);
                cdjVar6.n("' where 1 != 1 " /* "' where 1 != 1 " /* "' where 1 != 1 " /* cnb.z(-371957052734250L)  */);
                cdjVar6.n("rconversation" /* "rconversation" /* "rconversation" /* cnb.z(-373537600699178L)  */);
                bahVar6.getClass();
                bahVar6.d = cdjVar6;
                return kotlinUnitVar;
            case 15:
                bag bagVar = (bag) obj;
                String[] strArr3 = { "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* "com.tencent.mm.storage" /* cnb.z(-372523988417322L)  */ };
                bagVar.getClass();
                bagVar.a = SomeStaticHelpers.ab(strArr3);
                zb zbVar = new zb();
                zbVar.k("PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* "PRAGMA table_info( rconversation)" /* cnb.z(-371875448355626L)  */);
                bagVar.b = zbVar;
                return kotlinUnitVar;
            case 16:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new age(17);
                return kotlinUnitVar;
            case 17:
                bag bagVar2 = (bag) obj;
                zb zbVar2 = new zb();
                zbVar2.k("MMKernel.CoreStorage" /* "MMKernel.CoreStorage" /* "MMKernel.CoreStorage" /* cnb.z(-102439264975658L)  */,
                        "CheckData path[%s] blocksize:%s blockcount:%s availcount:%s" /* "CheckData path[%s] blocksize:%s blockcount:%s availcount:%s" /* "CheckData path[%s] blocksize:%s blockcount:%s availcount:%s" /* cnb.z(-102331890793258L)  */);
                bagVar2.getClass();
                bagVar2.b = zbVar2;
                return kotlinUnitVar;
            case 18:
                ahf ahfVar = (ahf) obj;
                if (ahfVar instanceof Dispatcher) {
                    return (Dispatcher) ahfVar;
                }
                return null;
            case 19:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new age(20);
                return kotlinUnitVar;
            case 20:
                bah bahVar7 = (bah) obj;
                String[] strArr4 = { "com.tencent.mm.ui" /* "com.tencent.mm.ui" /* "com.tencent.mm.ui" /* cnb.z(-78855599553322L)  */ };
                bahVar7.getClass();
                bahVar7.a = SomeStaticHelpers.ab(strArr4);
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("newcursor closeCursor,clear events" /* "newcursor closeCursor,clear events" /* "newcursor closeCursor,clear events" /* cnb.z(-78726750534442L)  */);
                bahVar7.d = cdjVar7;
                return kotlinUnitVar;
            case 21:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_custom_balance, null, false);
                int i10 = R.id.moduleDialogEdtCustomBalanceMax1;
                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogEdtCustomBalanceMax1);
                if (textInputEditText != null) {
                    i10 = R.id.moduleDialogEdtCustomBalanceMax2;
                    TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtCustomBalanceMax2);
                    if (textInputEditText2 != null) {
                        i10 = R.id.moduleDialogEdtCustomBalanceMax3;
                        TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogEdtCustomBalanceMax3);
                        if (textInputEditText3 != null) {
                            i10 = R.id.moduleDialogEdtCustomBalanceMin1;
                            TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtCustomBalanceMin1);
                            if (textInputEditText4 != null) {
                                i10 = R.id.moduleDialogEdtCustomBalanceMin2;
                                TextInputEditText textInputEditText5 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogEdtCustomBalanceMin2);
                                if (textInputEditText5 != null) {
                                    i10 = R.id.moduleDialogEdtCustomBalanceMin3;
                                    TextInputEditText textInputEditText6 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogEdtCustomBalanceMin3);
                                    if (textInputEditText6 != null) {
                                        i10 = R.id.moduleDialogEdtCustomBalanceValue1;
                                        TextInputEditText textInputEditText7 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogEdtCustomBalanceValue1);
                                        if (textInputEditText7 != null) {
                                            i10 = R.id.moduleDialogEdtCustomBalanceValue2;
                                            TextInputEditText textInputEditText8 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogEdtCustomBalanceValue2);
                                            if (textInputEditText8 != null) {
                                                i10 = R.id.moduleDialogEdtCustomBalanceValue3;
                                                TextInputEditText textInputEditText9 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                        R.id.moduleDialogEdtCustomBalanceValue3);
                                                if (textInputEditText9 != null) {
                                                    i10 = R.id.moduleDialogInputCustomBalanceMax1;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                            R.id.moduleDialogInputCustomBalanceMax1)) != null) {
                                                        i10 = R.id.moduleDialogInputCustomBalanceMax2;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                R.id.moduleDialogInputCustomBalanceMax2)) != null) {
                                                            i10 = R.id.moduleDialogInputCustomBalanceMax3;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                    R.id.moduleDialogInputCustomBalanceMax3)) != null) {
                                                                i10 = R.id.moduleDialogInputCustomBalanceMin1;
                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                        R.id.moduleDialogInputCustomBalanceMin1)) != null) {
                                                                    i10 = R.id.moduleDialogInputCustomBalanceMin2;
                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                            R.id.moduleDialogInputCustomBalanceMin2)) != null) {
                                                                        i10 = R.id.moduleDialogInputCustomBalanceMin3;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                R.id.moduleDialogInputCustomBalanceMin3)) != null) {
                                                                            i10 = R.id.moduleDialogInputCustomBalanceValue1;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                    R.id.moduleDialogInputCustomBalanceValue1)) != null) {
                                                                                i10 = R.id.moduleDialogInputCustomBalanceValue2;
                                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                        R.id.moduleDialogInputCustomBalanceValue2)) != null) {
                                                                                    i10 = R.id.moduleDialogInputCustomBalanceValue3;
                                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                            R.id.moduleDialogInputCustomBalanceValue3)) != null) {
                                                                                        i10 = R.id.moduleDialogRbCustomBalanceMathAdd;
                                                                                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) KotlinHelpers2
                                                                                                .recursivelyFindViewById(viewK,
                                                                                                        R.id.moduleDialogRbCustomBalanceMathAdd);
                                                                                        if (materialRadioButton != null) {
                                                                                            i10 = R.id.moduleDialogRbCustomBalanceMathDefault;
                                                                                            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) KotlinHelpers2
                                                                                                    .recursivelyFindViewById(viewK,
                                                                                                            R.id.moduleDialogRbCustomBalanceMathDefault);
                                                                                            if (materialRadioButton2 != null) {
                                                                                                i10 = R.id.moduleDialogRbCustomBalanceMathSub;
                                                                                                MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) KotlinHelpers2
                                                                                                        .recursivelyFindViewById(viewK,
                                                                                                                R.id.moduleDialogRbCustomBalanceMathSub);
                                                                                                if (materialRadioButton3 != null) {
                                                                                                    i10 = R.id.moduleDialogRgCustomBalanceMath;
                                                                                                    RadioGroup radioGroup = (RadioGroup) KotlinHelpers2
                                                                                                            .recursivelyFindViewById(viewK,
                                                                                                                    R.id.moduleDialogRgCustomBalanceMath);
                                                                                                    if (radioGroup != null) {
                                                                                                        LinearLayout linearLayout = (LinearLayout) viewK;
                                                                                                        cel celVar = new cel(
                                                                                                                linearLayout,
                                                                                                                textInputEditText,
                                                                                                                textInputEditText2,
                                                                                                                textInputEditText3,
                                                                                                                textInputEditText4,
                                                                                                                textInputEditText5,
                                                                                                                textInputEditText6,
                                                                                                                textInputEditText7,
                                                                                                                textInputEditText8,
                                                                                                                textInputEditText9,
                                                                                                                materialRadioButton,
                                                                                                                materialRadioButton2,
                                                                                                                materialRadioButton3,
                                                                                                                radioGroup);
                                                                                                        int iK = aie.a
                                                                                                                .k();
                                                                                                        if (iK == aid.a.f) {
                                                                                                            materialRadioButton3
                                                                                                                    .setChecked(
                                                                                                                            true);
                                                                                                        } else if (iK == aid.b.f) {
                                                                                                            materialRadioButton2
                                                                                                                    .setChecked(
                                                                                                                            true);
                                                                                                        } else if (iK == aid.c.f) {
                                                                                                            materialRadioButton
                                                                                                                    .setChecked(
                                                                                                                            true);
                                                                                                        }
                                                                                                        textInputEditText4
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aii.a.j())));
                                                                                                        textInputEditText7
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        ail.a.j())));
                                                                                                        textInputEditText
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aif.a.j())));
                                                                                                        textInputEditText5
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aij.a.j())));
                                                                                                        textInputEditText8
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aim.a.j())));
                                                                                                        textInputEditText2
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aig.a.j())));
                                                                                                        textInputEditText6
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aik.a.j())));
                                                                                                        textInputEditText9
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        ain.a.j())));
                                                                                                        textInputEditText3
                                                                                                                .setText(
                                                                                                                        cnh.t(Float
                                                                                                                                .valueOf(
                                                                                                                                        aih.a.j())));
                                                                                                        bzy bzyVar = new bzy(
                                                                                                                view.getContext());
                                                                                                        eg egVar = (eg) bzyVar.d;
                                                                                                        CustomBalanceHook.a
                                                                                                                .getClass();
                                                                                                        egVar.d = CustomBalanceHook.c;
                                                                                                        bzyVar.t(
                                                                                                                "保存" /*
                                                                                                                      * cnb
                                                                                                                      * .
                                                                                                                      * z
                                                                                                                      * (
                                                                                                                      * -
                                                                                                                      * 429827442080554L)
                                                                                                                      */,
                                                                                                                new amw(new bp(
                                                                                                                        celVar,
                                                                                                                        13),
                                                                                                                        0));
                                                                                                        bjs.x((3 & 2) != 0
                                                                                                                ? new amd(
                                                                                                                        1)
                                                                                                                : null,
                                                                                                                bzyVar,
                                                                                                                "取消" /*
                                                                                                                      * cnb
                                                                                                                      * .
                                                                                                                      * z
                                                                                                                      * (
                                                                                                                      * -
                                                                                                                      * 47455093652266L)
                                                                                                                      */);
                                                                                                        if (linearLayout != null) {
                                                                                                            egVar.r = linearLayout;
                                                                                                        }
                                                                                                        bzyVar.i()
                                                                                                                .show();
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
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-639537810242346L)  */.concat(viewK.getResources().getResourceName(i10)));
            case 22:
                List list = (List) obj;
                Object obj5 = list.get(0);
                cls = String.class;
                Class<String> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (nullSafeIsEqual(obj5, clsBf != null ? clsBf : String.class)) {
                    Object obj6 = list.get(1);
                    cls2 = Boolean.class;
                    Class<Boolean> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                    if (clsBf2 == null) {
                        clsBf2 = cls2;
                    }
                    if (nullSafeIsEqual(obj6, clsBf2)) {
                        Object obj7 = list.get(2);
                        Class<Boolean> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                        z = nullSafeIsEqual(obj7, clsBf3 != null ? clsBf3 : Boolean.class);
                    }
                }
                return Boolean.valueOf(z);
            case 23:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX4 = hookParam3.getArgs()[0];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th4) {
                    objX4 = FastKV.getFailureFromException(th4);
                }
                String str = (String) (objX4 instanceof Failure ? null : objX4);
                if (str == null) {
                    str = "";
                }
                float f = Float.parseFloat(str);
                Iterator it = aid.e.iterator();
                do {
                    z zVar = (z) it;
                    if (!zVar.hasNext()) {
                        throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                                   * cnb
                                                                                                                   * .z(
                                                                                                                   * -
                                                                                                                   * 429780197440298L)
                                                                                                                   */);
                    }
                    aidVar = (aid) zVar.next();
                } while (aidVar.f != aie.a.k());
                for (Pair pairVar : OtherStaticHelpers.argsToList(new Pair(new aab(aii.a.j(), aif.a.j()), Float.valueOf(ail.a.j())),
                        new Pair(new aab(aij.a.j(), aig.a.j()), Float.valueOf(aim.a.j())),
                        new Pair(new aab(aik.a.j(), aih.a.j()), Float.valueOf(ain.a.j())))) {
                    aac aacVar = (aac) pairVar.first;
                    float fFloatValue = ((Number) pairVar.second).floatValue();
                    aab aabVar = (aab) aacVar;
                    aabVar.getClass();
                    if (f >= aabVar.a && f <= aabVar.b) {
                        int iOrdinal = aidVar.ordinal();
                        if (iOrdinal == 0) {
                            fFloatValue = f - fFloatValue;
                        } else if (iOrdinal == 2) {
                            fFloatValue += f;
                        }
                        new ek(hookParam3, i7, 8).q(cnh.t(Float.valueOf(fFloatValue)));
                        return kotlinUnitVar;
                    }
                }
                return kotlinUnitVar;
            case 24:
                View view2 = (View) obj;
                View viewK2 = StaticHelpers6.k(view2, R.layout.module_dialog_custom_contact_count, null, false);
                int i11 = R.id.moduleDialogEdtCustomFriendCount;
                TextInputEditText textInputEditText10 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                        R.id.moduleDialogEdtCustomFriendCount);
                if (textInputEditText10 != null) {
                    i11 = R.id.moduleDialogEdtCustomGroupCount;
                    TextInputEditText textInputEditText11 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                            R.id.moduleDialogEdtCustomGroupCount);
                    if (textInputEditText11 != null) {
                        i11 = R.id.moduleDialogEdtMsgInfoTextPlaceholders;
                        if (((MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK2, R.id.moduleDialogEdtMsgInfoTextPlaceholders)) != null) {
                            i11 = R.id.moduleDialogInputCustomFriendCount;
                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2, R.id.moduleDialogInputCustomFriendCount)) != null) {
                                i11 = R.id.moduleDialogInputCustomGroupCount;
                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                        R.id.moduleDialogInputCustomGroupCount)) != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) viewK2;
                                    cem cemVar = new cem(linearLayout2, textInputEditText10, textInputEditText11, i7);
                                    textInputEditText10.setText(String.valueOf(aip.a.k()));
                                    textInputEditText11.setText(String.valueOf(aiq.a.k()));
                                    bzy bzyVar2 = new bzy(view2.getContext());
                                    eg egVar2 = (eg) bzyVar2.d;
                                    CustomContactCountHook.a.getClass();
                                    egVar2.d = CustomContactCountHook.c;
                                    bzyVar2.t("保存" /* "保存" /* "保存" /* cnb.z(-430978493315882L)  */, new amw(new bp(cemVar, i3), 0));
                                    bjs.x((3 & 2) != 0 ? new amd(c == true ? 1 : 0) : null, bzyVar2, "取消" /*
                                                                                                           * cnb.z(-
                                                                                                           * 47455093652266L)
                                                                                                           */);
                                    if (linearLayout2 != null) {
                                        egVar2.r = linearLayout2;
                                    }
                                    bzyVar2.i().show();
                                    return kotlinUnitVar;
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-639400371288874L)  */.concat(viewK2.getResources().getResourceName(i11)));
            case 25:
                HookParam hookParam4 = (HookParam) obj;
                int i12 = 0;
                FieldResolver fieldResolverVarAa3 = StaticHelpers6.aa(hookParam4);
                fieldResolverVarAa3.fieldType = dal.getKClassFromClass(Integer.TYPE);
                for (Object obj8 : fieldResolverVarAa3.resolve()) {
                    Object objE = ((BoundField) obj8).getValue_();
                    throwIfVar1IsNull(objE);
                    int iIntValue = ((Number) objE).intValue();
                    if (1 <= iIntValue && iIntValue < 3) {
                        if (i7 != 0) {
                            throw new IllegalArgumentException(
                                    "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* "Collection contains more than one matching element." /* cnb.z(-430999968152362L)  */);
                        }
                        obj2 = obj8;
                        i7 = 1;
                    }
                }
                if (i7 == 0) {
                    throw new NoSuchElementException("Collection contains no element matching the predicate." /*
                                                                                                               * cnb.z(-
                                                                                                               * 430742270114602L)
                                                                                                               */);
                }
                Object objE2 = ((BoundField) obj2).getValue_();
                throwIfVar1IsNull(objE2);
                int iK2 = (((Number) objE2).intValue() == 1 ? aip.a : aiq.a).k();
                if (iK2 != 0) {
                    int i13 = 0;
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(hookParam4.getThisObject()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.name = "setFixedContactCount" /* "setFixedContactCount" /* "setFixedContactCount" /* cnb.z(-430007830706986L)  */;
                    ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).e(Integer.valueOf(iK2));
                }
                return kotlinUnitVar;
            case 26:
                View view3 = (View) obj;
                View viewK3 = StaticHelpers6.k(view3, R.layout.module_dialog_custom_unread_count, null, false);
                int i14 = R.id.moduleDialogEdtCustomUnReadCount;
                TextInputEditText textInputEditText12 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                        R.id.moduleDialogEdtCustomUnReadCount);
                if (textInputEditText12 != null) {
                    i14 = R.id.moduleDialogInputCustomUnReadCount;
                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3, R.id.moduleDialogInputCustomUnReadCount)) != null) {
                        LinearLayout linearLayout3 = (LinearLayout) viewK3;
                        cee ceeVar = new cee(linearLayout3, textInputEditText12, i6);
                        textInputEditText12.setText(String.valueOf(ait.a.k()));
                        bzy bzyVar3 = new bzy(view3.getContext());
                        eg egVar3 = (eg) bzyVar3.d;
                        CustomUnReadCountHook.a.getClass();
                        egVar3.d = CustomUnReadCountHook.c;
                        bzyVar3.t("保存" /* "保存" /* "保存" /* cnb.z(-490429430627114L)  */, new amw(new bp(ceeVar, i4), 0));
                        bjs.x((3 & 2) != 0 ? new amd(c2 == true ? 1 : 0) : null, bzyVar3, "取消" /*
                                                                                                * cnb.z(-
                                                                                                * 47455093652266L)
                                                                                                */);
                        if (linearLayout3 != null) {
                            egVar3.r = linearLayout3;
                        }
                        bzyVar3.i().show();
                        return kotlinUnitVar;
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-639812688149290L)  */.concat(viewK3.getResources().getResourceName(i14)));
            case 27:
                ro.a.getClass();
                return Boolean.valueOf(((SwitchHook) obj)._z());
            case 28:
                return ((SwitchHook) obj).setResultTrue();
            default:
                return ((SwitchHook) obj).getResult();
        }
    }
}
