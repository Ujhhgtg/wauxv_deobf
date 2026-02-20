package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.info.GroupInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bn implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ bn(int i) {
        this.a = i;
    }

    private final Object b(Object obj) {
        DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
        String[] strArr = { "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* cnb.z(-442909912464170L)  */ };
        dexMethodQueryBuilderVar.getClass();
        dexMethodQueryBuilderVar.a = SomeStaticHelpers.arrayToList(strArr);
        DexFinder cdjVar = new DexFinder();
        cdjVar.usingStrings("MicroMsg.SDK.XmlParser" /* "MicroMsg.SDK.XmlParser" /* "MicroMsg.SDK.XmlParser" /* cnb.z(-442235602598698L)  */, "[ %s ]" /* "[ %s ]" /* "[ %s ]" /* cnb.z(-442119638481706L)  */);
        dexMethodQueryBuilderVar.dexFinder = cdjVar;
        return Kotlin$Unit.INSTANCE;
    }

    private final Object c(Object obj) {
        HookParam hookParam = (HookParam) obj;
        hookParam.getClass();
        new ek(hookParam, 0, 8).q("" /* "" /* "" /* cnb.z(-544253960780586L)  */);
        return Kotlin$Unit.INSTANCE;
    }

    private final Object d(Object obj) {
        Object objX;
        HookParam hookParam = (HookParam) obj;
        hookParam.getClass();
        try {
            objX = hookParam.getArgs()[2];
            if (objX == null) {
                objX = null;
            }
        } catch (Throwable th) {
            objX = FastKV.getFailureFromException(th);
        }
        if (objX instanceof Failure) {
            objX = null;
        }
        Integer num = (Integer) objX;
        int iIntValue = num != null ? num.intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            hookParam.setResult(null);
        }
        return Kotlin$Unit.INSTANCE;
    }

    private final Object e(Object obj) {
        View view = (View) obj;
        View viewK = StaticHelpers6.k(view, R.layout.module_dialog_anti_sns_delete, null, false);
        int i = R.id.moduleDialogEdtAntiSnsDeleteTip;
        TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogEdtAntiSnsDeleteTip);
        if (textInputEditText != null) {
            i = R.id.moduleDialogInputAntiSnsDeleteTip;
            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputAntiSnsDeleteTip)) != null) {
                LinearLayout linearLayout = (LinearLayout) viewK;
                cee ceeVar = new cee(linearLayout, textInputEditText, 1);
                textInputEditText.setText(gg.a.o());
                bzy bzyVar = new bzy(view.getContext());
                eg egVar = (eg) bzyVar.d;
                gh.a.getClass();
                egVar.d = gh.c;
                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-544739292085034L)  */, new amw(new bp(ceeVar, 2), 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout != null) {
                    egVar.r = linearLayout;
                }
                bzyVar.i().show();
                return Kotlin$Unit.INSTANCE;
            }
        }
        throw new NullPointerException("Missing required view with ID: "
                /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-641049638730538L)  */.concat(viewK.getResources().getResourceName(i)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException, JSONException, cth, NoSuchMethodException,
            IOException, InvocationTargetException {
        Object objX;
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        nj njVarV;
        oy oyVar;
        Object objX2;
        Object objX3;
        Object objX4;
        int i = this.a;
        int i2 = 7;
        int i3 = 4;
        int i4 = 10;
        int i5 = 13;
        int i6 = 20;
        final int i7 = 1;
        cst cstVar = null;
        final int i8 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                ((RelativeLayout.LayoutParams) obj).addRule(14);
                return kotlinUnitVar;
            case 1:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_account_info_center, null, false);
                int i9 = R.id.moduleDialogCbAccountInfoCenterAliasShow;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogCbAccountInfoCenterAliasShow);
                if (materialCheckBox != null) {
                    i9 = R.id.moduleDialogCbAccountInfoCenterNameShow;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogCbAccountInfoCenterNameShow);
                    if (materialCheckBox2 != null) {
                        i9 = R.id.moduleDialogCbAccountInfoCenterSignShow;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogCbAccountInfoCenterSignShow);
                        if (materialCheckBox3 != null) {
                            i9 = R.id.moduleDialogEdtAccountInfoCenterAlias;
                            TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogEdtAccountInfoCenterAlias);
                            if (textInputEditText != null) {
                                i9 = R.id.moduleDialogEdtAccountInfoCenterAliasTopMargin;
                                TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogEdtAccountInfoCenterAliasTopMargin);
                                if (textInputEditText2 != null) {
                                    i9 = R.id.moduleDialogEdtAccountInfoCenterAvatarRadian;
                                    TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogEdtAccountInfoCenterAvatarRadian);
                                    if (textInputEditText3 != null) {
                                        i9 = R.id.moduleDialogEdtAccountInfoCenterAvatarSize;
                                        TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogEdtAccountInfoCenterAvatarSize);
                                        if (textInputEditText4 != null) {
                                            i9 = R.id.moduleDialogEdtAccountInfoCenterAvatarTopMargin;
                                            TextInputEditText textInputEditText5 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogEdtAccountInfoCenterAvatarTopMargin);
                                            if (textInputEditText5 != null) {
                                                i9 = R.id.moduleDialogEdtAccountInfoCenterBgDarkColor;
                                                TextInputEditText textInputEditText6 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                        R.id.moduleDialogEdtAccountInfoCenterBgDarkColor);
                                                if (textInputEditText6 != null) {
                                                    i9 = R.id.moduleDialogEdtAccountInfoCenterBgLightColor;
                                                    TextInputEditText textInputEditText7 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(
                                                            viewK, R.id.moduleDialogEdtAccountInfoCenterBgLightColor);
                                                    if (textInputEditText7 != null) {
                                                        i9 = R.id.moduleDialogEdtAccountInfoCenterName;
                                                        TextInputEditText textInputEditText8 = (TextInputEditText) KotlinHelpers2
                                                                .recursivelyFindViewById(viewK, R.id.moduleDialogEdtAccountInfoCenterName);
                                                        if (textInputEditText8 != null) {
                                                            i9 = R.id.moduleDialogEdtAccountInfoCenterNameTopMargin;
                                                            TextInputEditText textInputEditText9 = (TextInputEditText) KotlinHelpers2
                                                                    .recursivelyFindViewById(viewK,
                                                                            R.id.moduleDialogEdtAccountInfoCenterNameTopMargin);
                                                            if (textInputEditText9 != null) {
                                                                i9 = R.id.moduleDialogEdtAccountInfoCenterSign;
                                                                TextInputEditText textInputEditText10 = (TextInputEditText) KotlinHelpers2
                                                                        .recursivelyFindViewById(viewK,
                                                                                R.id.moduleDialogEdtAccountInfoCenterSign);
                                                                if (textInputEditText10 != null) {
                                                                    i9 = R.id.moduleDialogEdtAccountInfoCenterSignTopMargin;
                                                                    TextInputEditText textInputEditText11 = (TextInputEditText) KotlinHelpers2
                                                                            .recursivelyFindViewById(viewK,
                                                                                    R.id.moduleDialogEdtAccountInfoCenterSignTopMargin);
                                                                    if (textInputEditText11 != null) {
                                                                        i9 = R.id.moduleDialogInputAccountInfoCenterAlias;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                R.id.moduleDialogInputAccountInfoCenterAlias)) != null) {
                                                                            i9 = R.id.moduleDialogInputAccountInfoCenterAliasTopMargin;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                    R.id.moduleDialogInputAccountInfoCenterAliasTopMargin)) != null) {
                                                                                i9 = R.id.moduleDialogInputAccountInfoCenterAvatarRadian;
                                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                        R.id.moduleDialogInputAccountInfoCenterAvatarRadian)) != null) {
                                                                                    i9 = R.id.moduleDialogInputAccountInfoCenterAvatarSize;
                                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                                            R.id.moduleDialogInputAccountInfoCenterAvatarSize)) != null) {
                                                                                        i9 = R.id.moduleDialogInputAccountInfoCenterAvatarTopMargin;
                                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(
                                                                                                viewK,
                                                                                                R.id.moduleDialogInputAccountInfoCenterAvatarTopMargin)) != null) {
                                                                                            i9 = R.id.moduleDialogInputAccountInfoCenterBgDarkColor;
                                                                                            if (((TextInputLayout) KotlinHelpers2
                                                                                                    .recursivelyFindViewById(viewK,
                                                                                                            R.id.moduleDialogInputAccountInfoCenterBgDarkColor)) != null) {
                                                                                                i9 = R.id.moduleDialogInputAccountInfoCenterBgLightColor;
                                                                                                if (((TextInputLayout) KotlinHelpers2
                                                                                                        .recursivelyFindViewById(viewK,
                                                                                                                R.id.moduleDialogInputAccountInfoCenterBgLightColor)) != null) {
                                                                                                    i9 = R.id.moduleDialogInputAccountInfoCenterName;
                                                                                                    if (((TextInputLayout) KotlinHelpers2
                                                                                                            .recursivelyFindViewById(viewK,
                                                                                                                    R.id.moduleDialogInputAccountInfoCenterName)) != null) {
                                                                                                        i9 = R.id.moduleDialogInputAccountInfoCenterNameTopMargin;
                                                                                                        if (((TextInputLayout) KotlinHelpers2
                                                                                                                .recursivelyFindViewById(viewK,
                                                                                                                        R.id.moduleDialogInputAccountInfoCenterNameTopMargin)) != null) {
                                                                                                            i9 = R.id.moduleDialogInputAccountInfoCenterSign;
                                                                                                            if (((TextInputLayout) KotlinHelpers2
                                                                                                                    .recursivelyFindViewById(viewK,
                                                                                                                            R.id.moduleDialogInputAccountInfoCenterSign)) != null) {
                                                                                                                i9 = R.id.moduleDialogInputAccountInfoCenterSignTopMargin;
                                                                                                                if (((TextInputLayout) KotlinHelpers2
                                                                                                                        .recursivelyFindViewById(viewK,
                                                                                                                                R.id.moduleDialogInputAccountInfoCenterSignTopMargin)) != null) {
                                                                                                                    LinearLayout linearLayout = (LinearLayout) viewK;
                                                                                                                    ced cedVar = new ced(
                                                                                                                            linearLayout,
                                                                                                                            materialCheckBox,
                                                                                                                            materialCheckBox2,
                                                                                                                            materialCheckBox3,
                                                                                                                            textInputEditText,
                                                                                                                            textInputEditText2,
                                                                                                                            textInputEditText3,
                                                                                                                            textInputEditText4,
                                                                                                                            textInputEditText5,
                                                                                                                            textInputEditText6,
                                                                                                                            textInputEditText7,
                                                                                                                            textInputEditText8,
                                                                                                                            textInputEditText9,
                                                                                                                            textInputEditText10,
                                                                                                                            textInputEditText11);
                                                                                                                    textInputEditText5
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            bw.a.k()));
                                                                                                                    textInputEditText4
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            bv.a.k()));
                                                                                                                    textInputEditText3
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            bu.a.j()));
                                                                                                                    materialCheckBox2
                                                                                                                            .setChecked(
                                                                                                                                    ca.a.i());
                                                                                                                    textInputEditText9
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            cb.a.k()));
                                                                                                                    textInputEditText8
                                                                                                                            .setText(
                                                                                                                                    bz.a.o());
                                                                                                                    materialCheckBox
                                                                                                                            .setChecked(
                                                                                                                                    bs.a.i());
                                                                                                                    textInputEditText2
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            bt.a.k()));
                                                                                                                    textInputEditText
                                                                                                                            .setText(
                                                                                                                                    br.a.o());
                                                                                                                    materialCheckBox3
                                                                                                                            .setChecked(
                                                                                                                                    cd.a.i());
                                                                                                                    textInputEditText11
                                                                                                                            .setText(
                                                                                                                                    String.valueOf(
                                                                                                                                            ce.a.k()));
                                                                                                                    textInputEditText10
                                                                                                                            .setText(
                                                                                                                                    cc.a.o());
                                                                                                                    textInputEditText7
                                                                                                                            .setText(
                                                                                                                                    by.a.o());
                                                                                                                    textInputEditText6
                                                                                                                            .setText(
                                                                                                                                    bx.a.o());
                                                                                                                    bzy bzyVar = new bzy(
                                                                                                                            view.getContext());
                                                                                                                    eg egVar = (eg) bzyVar.d;
                                                                                                                    cf.a.getClass();
                                                                                                                    egVar.d = cf.j;
                                                                                                                    bzyVar.t(
                                                                                                                            "保存" /*
                                                                                                                                  * cnb
                                                                                                                                  * .
                                                                                                                                  * z
                                                                                                                                  * (
                                                                                                                                  * -
                                                                                                                                  * 432803854416682L)
                                                                                                                                  */,
                                                                                                                            new amw(new bp(
                                                                                                                                    cedVar,
                                                                                                                                    0),
                                                                                                                                    0));
                                                                                                                    bzyVar.s(
                                                                                                                            "重置" /*
                                                                                                                                  * cnb
                                                                                                                                  * .
                                                                                                                                  * z
                                                                                                                                  * (
                                                                                                                                  * -
                                                                                                                                  * 432808149383978L)
                                                                                                                                  */,
                                                                                                                            new amw(new h(
                                                                                                                                    5),
                                                                                                                                    2));
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
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-641874272451370L)  */.concat(viewK.getResources().getResourceName(i9)));
            case 2:
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
                if (objX instanceof Failure) {
                    objX = null;
                }
                throwIfVar1IsNull(objX);
                RelativeLayout relativeLayout = (RelativeLayout) objX;
                Iterator zVar = new z(relativeLayout, 8);
                ArrayList arrayList = new ArrayList();
                while (zVar.hasNext()) {
                    View view2 = (View) zVar.next();
                    ViewGroup viewGroup = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
                    z zVar2 = viewGroup != null ? new z(viewGroup, 8) : null;
                    if (zVar2 == null || !zVar2.hasNext()) {
                        while (!zVar.hasNext() && !arrayList.isEmpty()) {
                            zVar = (Iterator) StaticHelpers5.l(arrayList);
                            StaticHelpers2.ar(arrayList);
                        }
                    } else {
                        arrayList.add(zVar);
                        zVar = zVar2;
                    }
                    view2.setVisibility(8);
                }
                cf cfVar = cf.a;
                Context context = relativeLayout.getContext();
                bp bpVar = new bp(relativeLayout, i7);
                cfVar.getClass();
                LinkedHashMap linkedHashMap = blu.a;
                cls = ViewGroup.LayoutParams.class;
                Class<ViewGroup.LayoutParams> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cls = clsBf != null ? clsBf : ViewGroup.LayoutParams.class;
                ArrayList arrayList2 = new ArrayList();
                if (blu.c) {
                    arrayList2.add(new blv(StaticHelpers7.an(context), 0));
                }
                blu bluVar = new blu(StaticHelpers5.z(arrayList2));
                blr blrVarI = blu.i(bluVar, cls, null, false, context);
                blu bluVar2 = blrVarI.f;
                blq blqVarD = SyntheticClass.d(bluVar2, blrVarI.a, blrVarI.b, blr.g(blrVarI, 0, 0, null, 55));
                cls2 = RelativeLayout.class;
                Class<RelativeLayout> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                if (clsBf2 == null) {
                    clsBf2 = cls2;
                }
                View viewH = blu.dexFind(bluVar2, clsBf2, null, blrVarI.j());
                LinkedHashMap linkedHashMap2 = bluVar2.f;
                ViewGroup viewGroup2 = (ViewGroup) viewH;
                viewGroup2.setLayoutParams(blqVarD.f());
                Class<RelativeLayout> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                if (clsBf3 == null) {
                    clsBf3 = cls2;
                }
                String name = clsBf3.getName();
                int size = linkedHashMap2.size();
                RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup2;
                int iIntValue = blrVarI.k(20).intValue();
                int iIntValue2 = blrVarI.k(12).intValue();
                if (iIntValue >= 0) {
                    relativeLayout2.setPadding(iIntValue, relativeLayout2.getPaddingTop(), iIntValue,
                            relativeLayout2.getPaddingBottom());
                }
                if (iIntValue2 >= 0) {
                    relativeLayout2.setPadding(relativeLayout2.getPaddingLeft(), iIntValue2,
                            relativeLayout2.getPaddingRight(), iIntValue2);
                }
                relativeLayout2
                        .setBackgroundColor(Color.parseColor((cnh.aa(relativeLayout2.getContext()) ? bx.a : by.a).o()));
                relativeLayout2.setOnClickListener(new bq(bpVar, 0));
                if (linkedHashMap2.size() != size) {
                    throw new cth(concat("Performers are not allowed to appear in ", name, " DSL creation process."));
                }
                Class<RelativeLayout> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                blr.i(blrVarI, null, clsBf4 != null ? clsBf4 : RelativeLayout.class);
                blr.h(blrVarI, viewGroup2);
                cls3 = RelativeLayout.LayoutParams.class;
                Class<RelativeLayout.LayoutParams> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                blr blrVarI2 = blu.i(bluVar2, clsBf5 != null ? clsBf5 : RelativeLayout.LayoutParams.class, viewGroup2,
                        true, null);
                blu bluVar3 = blrVarI2.f;
                blq blqVarD2 = SyntheticClass.d(bluVar3, blrVarI2.a, blrVarI2.b, blr.g(blrVarI2, 0, 0, new bn(i8), 31));
                cls4 = FrameLayout.class;
                Class<FrameLayout> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                if (clsBf6 == null) {
                    clsBf6 = cls4;
                }
                View viewH2 = blu.dexFind(bluVar3, clsBf6, null, blrVarI2.j());
                LinkedHashMap linkedHashMap3 = bluVar3.f;
                ViewGroup viewGroup3 = (ViewGroup) viewH2;
                viewGroup3.setLayoutParams(blqVarD2.f());
                Class<FrameLayout> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                if (clsBf7 == null) {
                    clsBf7 = cls4;
                }
                String name2 = clsBf7.getName();
                int size2 = linkedHashMap3.size();
                FrameLayout frameLayout = (FrameLayout) viewGroup3;
                ajn.aj(frameLayout, 0, blrVarI2.k(Integer.valueOf(bw.a.k())).intValue(), 0, 13);
                frameLayout.setId(R.id.AccountInfoCenter_flAvatar);
                if (linkedHashMap3.size() != size2) {
                    throw new cth(concat("Performers are not allowed to appear in ", name2, " DSL creation process."));
                }
                Class<FrameLayout> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                blr.i(blrVarI2, null, clsBf8 != null ? clsBf8 : FrameLayout.class);
                blr.h(blrVarI2, viewGroup3);
                cls5 = FrameLayout.LayoutParams.class;
                Class<FrameLayout.LayoutParams> clsBf9 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                blr blrVarI3 = blu.i(bluVar3, clsBf9 != null ? clsBf9 : FrameLayout.LayoutParams.class, viewGroup3,
                        true, null);
                blu bluVar4 = blrVarI3.f;
                bv bvVar = bv.a;
                blq blqVarD3 = SyntheticClass.d(bluVar4, blrVarI3.a, blrVarI3.b,
                        blr.g(blrVarI3, blrVarI3.k(Integer.valueOf(bvVar.k())).intValue(),
                                blrVarI3.k(Integer.valueOf(bvVar.k())).intValue(), null, 60));
                cls6 = ImageView.class;
                Class<ImageView> clsBf10 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                if (clsBf10 == null) {
                    clsBf10 = cls6;
                }
                View viewH3 = blu.dexFind(bluVar4, clsBf10, null, blrVarI3.j());
                LinkedHashMap linkedHashMap4 = bluVar4.f;
                viewH3.setLayoutParams(blqVarD3.f());
                Class<ImageView> clsBf11 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                if (clsBf11 == null) {
                    clsBf11 = cls6;
                }
                String name3 = clsBf11.getName();
                int size3 = linkedHashMap4.size();
                ImageView imageView = (ImageView) viewH3;
                bym bymVar = bym.a;
                acx.a.getClass();
                String strB = acx.b();
                bymVar.getClass();
                String strB2 = bym.b(strB, true);
                ddl ddlVar = new ddl(
                        Math.max(1, (int) (2 * bu.a.j() * (blrVarI3.k(Integer.valueOf(bvVar.k())).intValue() / 2))));
                Context context2 = imageView.getContext();
                cmz.n(context2,
                        "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
                dca dcaVarF = com.bumptech.glide.a.j(context2).g.f(context2);
                dcaVarF.getClass();
                dbu dbuVarAs = new dbu(dcaVarF.b, dcaVarF, Drawable.class, dcaVarF.c).aw(strB2)
                        .q((dcd) new dcd().ad(ddlVar, true));
                dbuVarAs.getClass();
                eot.d();
                if (!nj.p(dbuVarAs.a, 2048) && imageView.getScaleType() != null) {
                    switch (dbt.a[imageView.getScaleType().ordinal()]) {
                        case 1:
                            njVarV = dbuVarAs.clone().v(apo.c, new tn());
                            break;
                        case 2:
                            njVarV = dbuVarAs.clone().v(apo.b, new to());
                            njVarV.n = true;
                            break;
                        case 3:
                        case 4:
                        case 5:
                            njVarV = dbuVarAs.clone().v(apo.a, new bas());
                            njVarV.n = true;
                            break;
                        case 6:
                            njVarV = dbuVarAs.clone().v(apo.b, new to());
                            njVarV.n = true;
                            break;
                        default:
                            njVarV = dbuVarAs;
                            break;
                    }
                } else {
                    njVarV = dbuVarAs;
                }
                bhw bhwVar = dbuVarAs.ai;
                Class cls7 = dbuVarAs.ah;
                bhwVar.d.getClass();
                if (Bitmap.class.equals(cls7)) {
                    oyVar = new oy(imageView, 0);
                } else {
                    if (!Drawable.class.isAssignableFrom(cls7)) {
                        throw new IllegalArgumentException(
                                "Unhandled class: " + cls7 + ", try .as*(Class).transcode(ResourceTranscoder)");
                    }
                    oyVar = new oy(imageView, 1);
                }
                dbuVarAs.av(oyVar, njVarV);
                if (oyVar.c == null) {
                    tj tjVar = new tj(oyVar, 4);
                    oyVar.c = tjVar;
                    if (!oyVar.e) {
                        oyVar.a.addOnAttachStateChangeListener(tjVar);
                        oyVar.e = true;
                    }
                }
                if (linkedHashMap4.size() != size3) {
                    throw new cth(concat("Performers are not allowed to appear in ", name3, " DSL creation process."));
                }
                Class<ImageView> clsBf12 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                blr.i(blrVarI3, null, clsBf12 != null ? clsBf12 : ImageView.class);
                blr.h(blrVarI3, viewH3);
                cf.n(cfVar, blrVarI2, R.id.AccountInfoCenter_tvName, R.id.AccountInfoCenter_flAvatar, cb.a.k(), 18.0f,
                        bz.a.o(), ca.a.i(), new File(cf.h, "nickName.ttf" /* "nickName.ttf" /* "nickName.ttf" /* cnb.z(-431347860503338L)  */), 64);
                cf.n(cfVar, blrVarI2, R.id.AccountInfoCenter_tvAlias, R.id.AccountInfoCenter_tvName, bt.a.k(), 16.0f,
                        br.a.o(), bs.a.i(), null, 960);
                cf.n(cfVar, blrVarI2, R.id.AccountInfoCenter_tvSign, R.id.AccountInfoCenter_tvAlias, ce.a.k(), 14.0f,
                        cc.a.o(), cd.a.i(), null, 896);
                relativeLayout.addView(bluVar.k(), -1);
                return kotlinUnitVar;
            case 3:
                Context context3 = (Context) obj;
                throwIfVar1IsNull(context3, "it");
                if (context3 instanceof ContextWrapper) {
                    return ((ContextWrapper) context3).getBaseContext();
                }
                return null;
            case 4:
                int i10 = ewg.m.w;
                String strZ = "weixin" /* "weixin" /* "weixin" /* cnb.z(-88626650151722L)  */;
                Object objZ = "微信安全提醒" /* "微信安全提醒" /* "微信安全提醒" /* cnb.z(-88596585380650L)  */;
                String strZ2 = "该微信号因使用外挂、模拟器等非官方客户端程序或其他违规技术（请卸载停用违规内容，若继续使用将升级至永久限制），当前无法使用所有社交场景。该限制为临时限制。\n\n你可以点击“详情”查看更多信息，进行安全验证以继续使用该功能。" /*
                                                                                                                                                   * cnb
                                                                                                                                                   * .
                                                                                                                                                   * z
                                                                                                                                                   * (
                                                                                                                                                   * -
                                                                                                                                                   * 88549340740394L)
                                                                                                                                                   */;
                String strZ3 = "https://www.bilibili.com/video/BV1UT42167xb/" /* "https://www.bilibili.com/video/BV1UT42167xb/" /* "https://www.bilibili.com/video/BV1UT42167xb/" /* cnb.z(-88072599370538L)  */;
                JSONObject jSONObject = new JSONObject();
                String strZ4 = "msg" /* "msg" /* "msg" /* cnb.z(-118064355998506L)  */;
                JSONObject jSONObject2 = new JSONObject();
                String strZ5 = "appmsg" /* "appmsg" /* "appmsg" /* cnb.z(-118081535867690L)  */;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("type" /* "type" /* "type" /* cnb.z(-118051471096618L)  */, 5);
                jSONObject3.put("title" /* "title" /* "title" /* cnb.z(-117995636521770L)  */, objZ);
                String strZ6 = "mmreader" /* "mmreader" /* "mmreader" /* cnb.z(-118021406325546L)  */;
                JSONObject jSONObject4 = new JSONObject();
                String strZ7 = "category" /* "category" /* "category" /* cnb.z(-117931212012330L)  */;
                JSONObject jSONObject5 = new JSONObject();
                String strZ8 = "item" /* "item" /* "item" /* cnb.z(-115143778237226L)  */;
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("title" /* "title" /* "title" /* cnb.z(-115173843008298L)  */, objZ);
                jSONObject6.put("digest" /* "digest" /* "digest" /* cnb.z(-115130893335338L)  */, strZ2);
                jSONObject6.put("url" /* "url" /* "url" /* cnb.z(-115083648695082L)  */, strZ3);
                jSONObject5.put(strZ8, jSONObject6);
                jSONObject4.put(strZ7, jSONObject5);
                jSONObject3.put(strZ6, jSONObject4);
                jSONObject2.put(strZ5, jSONObject3);
                jSONObject.put(strZ4, jSONObject2);
                HashSet hashSet = new HashSet();
                HashSet hashSet2 = new HashSet();
                bsr bsrVar = new bsr();
                bsrVar.b = jSONObject;
                bsrVar.c = hashSet;
                bsrVar.d = hashSet2;
                aye.w(i10, strZ, bsrVar.toString(), System.currentTimeMillis());
                Context context4 = ((View) obj).getContext();
                byo byoVar = byo.a;
                String strZ9 = "" /* "" /* "" /* cnb.z(-88463441394474L)  */;
                List listAg = OtherStaticHelpers.argsToList(
                        "该微信号因使用了微信外挂、非官方客户端或模拟器，被限制登录，请尽快卸载对应的非法软件。若后续仍继续使用将永久限制登录。如需继续使用，请轻触 “确定” 申请解除限制。" /*
                                                                                                              * cnb.z(-
                                                                                                              * 88476326296362L)
                                                                                                              */,
                        "该账号违反了《微信个人账号使用规范》，请轻触 “确定” 了解详情后，继续登录微信。" /* "该账号违反了《微信个人账号使用规范》，请轻触 “确定” 了解详情后，继续登录微信。" /* "该账号违反了《微信个人账号使用规范》，请轻触 “确定” 了解详情后，继续登录微信。" /* cnb.z(-89717571844906L)  */,
                        "你的账号可能有安全风险，为了你的账号安全，暂时无法在新设备登录，你可以在常用手机登录微信，或者轻触「了解详情」查看更多信息。" /* "你的账号可能有安全风险，为了你的账号安全，暂时无法在新设备登录，你可以在常用手机登录微信，或者轻触「了解详情」查看更多信息。" /* "你的账号可能有安全风险，为了你的账号安全，暂时无法在新设备登录，你可以在常用手机登录微信，或者轻触「了解详情」查看更多信息。" /* cnb.z(-90104118901546L)  */,
                        "账号状态异常，本次登录已失效。请尝试重新登录，并根据弹窗提示操作。" /* "账号状态异常，本次登录已失效。请尝试重新登录，并根据弹窗提示操作。" /* "账号状态异常，本次登录已失效。请尝试重新登录，并根据弹窗提示操作。" /* cnb.z(-89283780148010L)  */);
                ae aeVar = cyj.f;
                String str = (String) StaticHelpers5.q(listAg);
                String strZ10 = "确定" /* "确定" /* "确定" /* cnb.z(-89154931129130L)  */;
                String strZ11 = "取消" /* "取消" /* "取消" /* cnb.z(-89159226096426L)  */;
                aqx aqxVar = new aqx();
                aqx aqxVar2 = new aqx();
                byoVar.getClass();
                int i11 = 0;
                ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(Context.class), dal.getKClassFromClass(String.class), dal.getKClassFromClass(String.class),
                        dal.getKClassFromClass(String.class), dal.getKClassFromClass(String.class), dal.getKClassFromClass(DialogInterface.OnClickListener.class),
                        dal.getKClassFromClass(DialogInterface.OnClickListener.class) }, 7, dqc.bh(StaticHelpers7.toDexClass(byn.a)).getMethodResolverBasedOnPreviouslyProvidedConfig()))
                        .invokeAndThrowIfFailed(context4, str, strZ9, strZ10, strZ11, aqxVar, aqxVar2);
                return kotlinUnitVar;
            case 5:
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
                Object obj2 = objX2 instanceof Failure ? null : objX2;
                throwIfVar1IsNull(obj2);
                int i12 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(obj2).r();
                fieldResolverVarR.name = "f" /* "f" /* "f" /* cnb.z(-477029132663594L)  */;
                Object objD = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR.resolve())).getValue();
                throwIfVar1IsNull(objD);
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(objD).r();
                fieldResolverVarR2.name = "f" /* "f" /* "f" /* cnb.z(-477037722598186L)  */;
                Object objE = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue_();
                throwIfVar1IsNull(objE);
                try {
                    if (new JSONObject((String) objE)
                            .optJSONArray("ad_slot_data" /* "ad_slot_data" /* "ad_slot_data" /* cnb.z(-477046312532778L)  */) != null) {
                        FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objD).r();
                        fieldResolverVarR3.name = "f" /* "f" /* "f" /* cnb.z(-476973298088746L)  */;
                        ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).setValue("{}" /* "{}" /* "{}" /* cnb.z(-476981888023338L)  */);
                    }
                    break;
                } catch (Throwable th3) {
                    FastKV.getFailureFromException(th3);
                }
                return kotlinUnitVar;
            case 6:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bn(i2);
                return kotlinUnitVar;
            case 7:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                String[] strArr = { "com.tencent.mm.plugin.brandservice.api.TransferResultInfo" /*
                                                                                                 * cnb.z(-
                                                                                                 * 476917463513898L)
                                                                                                 */ };
                MethodMatcher fjVar = new MethodMatcher(i3);
                fjVar.b = StaticHelpers5.ab(EmptyReadonlyList.INSTANCE);
                String str2 = strArr[0];
                if (str2 != null) {
                    cstVar = new cst();
                    DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                    zbVar.j(str2, dne.Equals);
                    cstVar.a = zbVar;
                }
                List arrayList3 = fjVar.b;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                fjVar.b = arrayList3;
                arrayList3.add(cstVar);
                cdjVar.f = fjVar;
                cdjVar.usingStrings("MicroMsg.BaseTransferRequest" /* "MicroMsg.BaseTransferRequest" /* "MicroMsg.BaseTransferRequest" /* cnb.z(-476135779466026L)  */);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 8:
                StaticAndroidHelpers.runOnUiThread(fs.a, new bn(9));
                return kotlinUnitVar;
            case 9:
                bn bnVar = new bn(i4);
                aek aekVar = new aek();
                ael aelVar = new ael(aekVar);
                bnVar.invoke(aelVar);
                aekVar.a = aelVar;
                aekVar.m().bb(new qp(aekVar, 1)).bm();
                return kotlinUnitVar;
            case 10:
                ael aelVar2 = (ael) obj;
                aelVar2.f = "搜索群聊" /* "搜索群聊" /* "搜索群聊" /* cnb.z(-491039315983146L)  */;
                String strZ12 = "群聊" /* "群聊" /* "群聊" /* cnb.z(-491069380754218L)  */;
                ArrayList<GroupInfo> arrayListT = bmy.t();
                ArrayList arrayList4 = new ArrayList(StaticHelpers4.ak(arrayListT, 10));
                for (GroupInfo groupInfo : arrayListT) {
                    String roomId = groupInfo.getRoomId();
                    StringBuilder sb = new StringBuilder();
                    sb.append(groupInfo.getName());
                    String remark = groupInfo.getRemark();
                    if (remark.length() <= 0) {
                        remark = null;
                    }
                    if (remark != null) {
                        sb.append("(" + remark + ')');
                    }
                    sb.append("(" + groupInfo.getGroupData().getMemberCount() + ')');
                    arrayList4.add(new adx(roomId, sb.toString(), groupInfo.getRoomId(),
                            fr.a.n().contains(groupInfo.getRoomId())));
                }
                aelVar2.m(strZ12, arrayList4);
                aelVar2.g = R.drawable.ic_contact_confirm_24dp;
                String strZ13 = "屏蔽" /* "屏蔽" /* "屏蔽" /* cnb.z(-491004956244778L)  */;
                fq fqVar = new fq(i8);
                aelVar2.j = strZ13;
                aelVar2.l = fqVar;
                return kotlinUnitVar;
            case 11:
                ((HookParam) obj).setResult(null);
                return kotlinUnitVar;
            case 12:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bn(i5);
                return kotlinUnitVar;
            case 13:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                cdjVar2.usingStrings("doRevokeMsg xmlSrvMsgId=%d talker=%s isGet=%s" /* "doRevokeMsg xmlSrvMsgId=%d talker=%s isGet=%s" /* "doRevokeMsg xmlSrvMsgId=%d talker=%s isGet=%s" /* cnb.z(-457229333429034L)  */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 14:
                View view3 = (View) obj;
                final cee ceeVarD = cee.d(LayoutInflater.from(view3.getContext()));
                ceeVarD.c.setText(fz.a.o());
                bzy bzyVar2 = new bzy(view3.getContext());
                ga.a.getClass();
                String str3 = ga.c;
                eg egVar2 = (eg) bzyVar2.d;
                egVar2.d = str3;
                LinearLayout linearLayout2 = ceeVarD.b;
                bzyVar2.t("保存" /* "保存" /* "保存" /* cnb.z(-453462647110442L)  */, new amw(new bfu() { // from class: me.hd.wauxv.obf.fv
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i8) {
                            case 0:
                                fz.a.u(String.valueOf(ceeVarD.c.getText()));
                                break;
                            default:
                                gc.a.u(String.valueOf(ceeVarD.c.getText()));
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout2 != null) {
                    egVar2.r = linearLayout2;
                }
                bzyVar2.i().show();
                return kotlinUnitVar;
            case 15:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new bn(21);
                return kotlinUnitVar;
            case 16:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new bn(19);
                return kotlinUnitVar;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new bn(i6);
                return kotlinUnitVar;
            case 18:
                ((HookParam) obj).setResult(null);
                return kotlinUnitVar;
            case 19:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.VoiceMsgExtension" /* "MicroMsg.VoiceMsgExtension" /* "MicroMsg.VoiceMsgExtension" /* cnb.z(-453376747764522L)  */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 20:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.VideoMsgExtension" /* "MicroMsg.VideoMsgExtension" /* "MicroMsg.VideoMsgExtension" /* cnb.z(-454858511481642L)  */);
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar3;
                return kotlinUnitVar;
            case 21:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.ImgMsgExtension" /* "MicroMsg.ImgMsgExtension" /* "MicroMsg.ImgMsgExtension" /* cnb.z(-453466942077738L)  */);
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar4;
                return kotlinUnitVar;
            case 22:
                View view4 = (View) obj;
                final cee ceeVarD2 = cee.d(LayoutInflater.from(view4.getContext()));
                ceeVarD2.c.setText(gc.a.o());
                bzy bzyVar3 = new bzy(view4.getContext());
                gd.a.getClass();
                String str4 = gd.c;
                eg egVar3 = (eg) bzyVar3.d;
                egVar3.d = str4;
                LinearLayout linearLayout3 = ceeVarD2.b;
                bzyVar3.t("保存" /* "保存" /* "保存" /* cnb.z(-454300165733162L)  */, new amw(new bfu() { // from class: me.hd.wauxv.obf.fv
                    @Override // me.hd.wauxv.obf.bfu
                    public final Object invoke() {
                        switch (i7) {
                            case 0:
                                fz.a.u(String.valueOf(ceeVarD2.c.getText()));
                                break;
                            default:
                                gc.a.u(String.valueOf(ceeVarD2.c.getText()));
                                break;
                        }
                        return Kotlin$Unit.INSTANCE;
                    }
                }, 0));
                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3, "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                if (linearLayout3 != null) {
                    egVar3.r = linearLayout3;
                }
                bzyVar3.i().show();
                return kotlinUnitVar;
            case 23:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new bn(25);
                return kotlinUnitVar;
            case 24:
                HookParam hookParam3 = (HookParam) obj;
                hookParam3.getClass();
                try {
                    objX3 = hookParam3.getArgs()[0];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th4) {
                    objX3 = FastKV.getFailureFromException(th4);
                }
                if (objX3 instanceof Failure) {
                    objX3 = null;
                }
                String str5 = (String) objX3;
                String str6 = str5 == null ? "" : str5;
                try {
                    objX4 = hookParam3.getArgs()[1];
                    if (objX4 == null) {
                        objX4 = null;
                    }
                } catch (Throwable th5) {
                    objX4 = FastKV.getFailureFromException(th5);
                }
                if (objX4 instanceof Failure) {
                    objX4 = null;
                }
                String str7 = (String) objX4;
                if ((str7 != null ? str7 : "").equals("sysmsg" /* "sysmsg" /* "sysmsg" /* cnb.z(-454252921092906L)  */)
                        && dnj.ab(str6, "revokemsg" /* "revokemsg" /* "revokemsg" /* cnb.z(-454205676452650L)  */, false)) {
                    Object objF = hookParam3.getResult();
                    if (!(objF instanceof Map) || ((objF instanceof IEmpty) && !(objF instanceof bsz))) {
                        objF = null;
                    }
                    Map map = (Map) objF;
                    if (map != null) {
                        String strZ14 = ".sysmsg.$type" /* ".sysmsg.$type" /* ".sysmsg.$type" /* cnb.z(-454179906648874L)  */;
                        if (map.containsKey(strZ14)
                                && nullSafeIsEqual(map.get(strZ14), "revokemsg" /* "revokemsg" /* "revokemsg" /* cnb.z(-454102597237546L)  */)) {
                            Object obj3 = map.get(".sysmsg.revokemsg.session" /* ".sysmsg.revokemsg.session" /* ".sysmsg.revokemsg.session" /* cnb.z(-454626583247658L)  */);
                            throwIfVar1IsNull(obj3);
                            String str8 = (String) obj3;
                            Object obj4 = map.get(".sysmsg.revokemsg.replacemsg" /* ".sysmsg.revokemsg.replacemsg" /* ".sysmsg.revokemsg.replacemsg" /* cnb.z(-454532093967146L)  */);
                            throwIfVar1IsNull(obj4);
                            String str9 = (String) obj4;
                            Object obj5 = map.get(".sysmsg.revokemsg.newmsgid" /* ".sysmsg.revokemsg.newmsgid" /* ".sysmsg.revokemsg.newmsgid" /* cnb.z(-454390360046378L)  */);
                            throwIfVar1IsNull(obj5);
                            String str10 = (String) obj5;
                            if (dnr.bp(str9, "\"" /* "\"" /* "\"" /* cnb.z(-442746703706922L)  */, false)
                                    || dnr.bp(str9, "「" /* "「" /* "「" /* cnb.z(-442755293641514L)  */, false)) {
                                map.put(strZ14, null);
                                hookParam3.setResult(map);
                                int i13 = 0;
                                dlx.a.getClass();
                                MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(dlx.b()).getMethodResolverBasedOnPreviouslyProvidedConfig();
                                methodResolverVarT.name = "rawQuery" /* "rawQuery" /* "rawQuery" /* cnb.z(-103246718827306L)  */;
                                Object objJ = ((MethodHookWrapper) StaticHelpers6.setParamsBasedOnVar1Var2AndResolveFirstMethod(new Object[] { dal.getKClassFromClass(String.class), dal.getKClassFromClass(Object[].class) },
                                        2, methodResolverVarT)).invoke("SELECT createTime FROM message WHERE msgSvrId = ?" /*
                                                                                                            * cnb.z(-
                                                                                                            * 442695164099370L)
                                                                                                            */,
                                                new Object[] { str10 });
                                throwIfVar1IsNull(objJ);
                                Cursor cursor = (Cursor) objJ;
                                try {
                                    if (cursor.moveToFirst()) {
                                        long j = cursor.getLong(cursor.getColumnIndex("createTime" /*
                                                                                                    * cnb.z(-
                                                                                                    * 443047351417642L)
                                                                                                    */));
                                        Pattern patternCompile = Pattern.compile("([\"「])(.*?)([」\"])" /*
                                                                                                        * cnb.z(-
                                                                                                        * 443034466515754L)
                                                                                                        */);
                                        throwIfVar1IsNull(patternCompile, "compile(...)");
                                        Matcher matcher = patternCompile.matcher(str9);
                                        throwIfVar1IsNull(matcher, "matcher(...)");
                                        bzx bzxVarY = StaticAndroidHelpers.y(matcher, 0, str9);
                                        aye.w(ewg.j.w, str8,
                                                "\"" + (bzxVarY != null ? (String) ((bzv) bzxVarY.e()).get(2) : null)
                                                        + "\" " /* "\" " /* "\" " /* cnb.z(-442905617496874L)  */ + gc.a.o(),
                                                j + 1);
                                    }
                                    cursor.close();
                                    break;
                                } catch (Throwable th6) {
                                    try {
                                        throw th6;
                                    } catch (Throwable th7) {
                                        cnh.m(cursor, th6);
                                        throw th7;
                                    }
                                }
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 25:
                return b(obj);
            case 26:
                return c(obj);
            case 27:
                return d(obj);
            case 28:
                return e(obj);
            default:
                ((HookParam) obj).setResult(null);
                return kotlinUnitVar;
        }
    }
}
