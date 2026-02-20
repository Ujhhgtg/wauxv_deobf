package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.dx.io.Opcodes;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) throws IllegalAccessException {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        ImageView imageView;
        Bitmap bitmap;
        Class cls5;
        Class cls6;
        Object objX;
        boolean zBooleanValue;
        Object obj2;
        Object objX2;
        Object obj3;
        Class cls7;
        int i = this.a;
        int i2 = 8;
        int i3 = 4;
        int i4 = 6;
        cls = Boolean.class;
        int i5 = 1;
        final int i6 = 0;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                int i7 = 0;
                FieldResolver fieldResolverVarAa = StaticHelpers6.aa((HookParam) obj);
                fieldResolverVarAa.fieldType = dal.getKClassFromClass(Button.class);
                Iterator it = fieldResolverVarAa.resolve().iterator();
                while (it.hasNext()) {
                    Button button = (Button) ((BoundField) it.next()).getValue_();
                    if (button != null && button.getVisibility() == 0) {
                        List listAg = OtherStaticHelpers.argsToList("查看原图" /* "查看原图" /* "查看原图" /* cnb.z(-440083823983402L)  */,
                                "Full Image" /* "Full Image" /* "Full Image" /* cnb.z(-440113888754474L)  */, "查看原视频" /* "查看原视频" /* "查看原视频" /* cnb.z(-441664371948330L)  */,
                                "Original quality" /* "Original quality" /* "Original quality" /* cnb.z(-441690141752106L)  */);
                        if (!listAg.isEmpty()) {
                            Iterator it2 = listAg.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (StringsKt.contains(button.getText(), (String) it2.next(), true)) {
                                        button.performClick();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 1:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(3);
                return kotlinUnitVar;
            case 2:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i3);
                return kotlinUnitVar;
            case 3:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                DexFinder.setClassEquals(cdjVar, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* cnb.z(-441565587700522L)  */);
                if (cnb.ab(ewk.h) || cnb.ac(ewh.g)) {
                    cdjVar.usingStrings("setHdImageActionDownloadable" /* "setHdImageActionDownloadable" /* "setHdImageActionDownloadable" /* cnb.z(-441917775018794L)  */);
                } else {
                    cdjVar.usingStrings("setImageHdImgBtnVisibility" /* "setImageHdImgBtnVisibility" /* "setImageHdImgBtnVisibility" /* cnb.z(-441827580705578L)  */);
                }
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return kotlinUnitVar;
            case 4:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar2 = new DexFinder();
                DexFinder.setClassEquals(cdjVar2, "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* "com.tencent.mm.ui.chatting.gallery.ImageGalleryUI" /* cnb.z(-441127501036330L)  */);
                cdjVar2.usingStrings("checkNeedShowOriginVideoBtn" /* "checkNeedShowOriginVideoBtn" /* "checkNeedShowOriginVideoBtn" /* cnb.z(-440929932540714L)  */);
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return kotlinUnitVar;
            case 5:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i4);
                return kotlinUnitVar;
            case 6:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar3 = new DexFinder();
                cls2 = ImageView.class;
                Class<ImageView> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cls2 = clsBf != null ? clsBf : ImageView.class;
                cls3 = String.class;
                Class<String> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cls3 = clsBf2 != null ? clsBf2 : String.class;
                cls4 = Float.class;
                Class<Float> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                cls4 = clsBf3 != null ? clsBf3 : Float.class;
                Class<Boolean> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar3.q(cls2, cls3, cls4, clsBf4 != null ? clsBf4 : Boolean.class);
                cdjVar3.usingStrings("MicroMsg.AvatarDrawable" /* "MicroMsg.AvatarDrawable" /* "MicroMsg.AvatarDrawable" /* cnb.z(-118858924948266L)  */);
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return kotlinUnitVar;
            case 7:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(i2);
                return kotlinUnitVar;
            case 8:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.modelavatar" /* "com.tencent.mm.modelavatar" /* "com.tencent.mm.modelavatar" /* cnb.z(-361683490962218L)  */ };
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.s("onAccountInitialized" /* "onAccountInitialized" /* "onAccountInitialized" /* cnb.z(-361601886583594L)  */);
                cdjVar4.usingStrings("//avatar" /* "//avatar" /* "//avatar" /* cnb.z(-361477332532010L)  */);
                MethodMatcher fjVar = zbVar.f;
                if (fjVar == null) {
                    fjVar = new MethodMatcher();
                }
                zbVar.f = fjVar;
                fjVar.f(cdjVar4);
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.s("onAccountReleased" /* "onAccountReleased" /* "onAccountReleased" /* cnb.z(-360906101881642L)  */);
                cdjVar5.usingStrings("//avatar" /* "//avatar" /* "//avatar" /* cnb.z(-360845972339498L)  */);
                MethodMatcher fjVar2 = zbVar.f;
                if (fjVar2 == null) {
                    fjVar2 = new MethodMatcher();
                }
                zbVar.f = fjVar2;
                fjVar2.f(cdjVar5);
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return kotlinUnitVar;
            case 9:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(10);
                return kotlinUnitVar;
            case 10:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.modelavatar" /* "com.tencent.mm.modelavatar" /* "com.tencent.mm.modelavatar" /* cnb.z(-380091720792874L)  */ };
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr2);
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.AvatarStorage" /* "MicroMsg.AvatarStorage" /* "MicroMsg.AvatarStorage" /* cnb.z(-380010116414250L)  */, "Failed to save avatar: %s" /*
                                                                                                               * cnb.z(-
                                                                                                               * 379894152297258L)
                                                                                                               */);
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return kotlinUnitVar;
            case 11:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_bottom_tab_custom, null, false);
                int i8 = R.id.moduleDialogCbBottomTabViewHideTab;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                        R.id.moduleDialogCbBottomTabViewHideTab);
                if (materialCheckBox != null) {
                    i8 = R.id.moduleDialogCbBottomTabViewHideTitle;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogCbBottomTabViewHideTitle);
                    if (materialCheckBox2 != null) {
                        i8 = R.id.moduleDialogCbBottomTabViewModIcon;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                                R.id.moduleDialogCbBottomTabViewModIcon);
                        if (materialCheckBox3 != null) {
                            i8 = R.id.moduleDialogCbBottomTabViewModTitle;
                            MaterialCheckBox materialCheckBox4 = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogCbBottomTabViewModTitle);
                            if (materialCheckBox4 != null) {
                                i8 = R.id.moduleDialogEdtBottomTabViewChats;
                                TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogEdtBottomTabViewChats);
                                if (textInputEditText != null) {
                                    i8 = R.id.moduleDialogEdtBottomTabViewContacts;
                                    TextInputEditText textInputEditText2 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogEdtBottomTabViewContacts);
                                    if (textInputEditText2 != null) {
                                        i8 = R.id.moduleDialogEdtBottomTabViewDiscover;
                                        TextInputEditText textInputEditText3 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogEdtBottomTabViewDiscover);
                                        if (textInputEditText3 != null) {
                                            i8 = R.id.moduleDialogEdtBottomTabViewMe;
                                            TextInputEditText textInputEditText4 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                    R.id.moduleDialogEdtBottomTabViewMe);
                                            if (textInputEditText4 != null) {
                                                i8 = R.id.moduleDialogInputBottomTabViewChats;
                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                        R.id.moduleDialogInputBottomTabViewChats)) != null) {
                                                    i8 = R.id.moduleDialogInputBottomTabViewContacts;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                            R.id.moduleDialogInputBottomTabViewContacts)) != null) {
                                                        i8 = R.id.moduleDialogInputBottomTabViewDiscover;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                R.id.moduleDialogInputBottomTabViewDiscover)) != null) {
                                                            i8 = R.id.moduleDialogInputBottomTabViewMe;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                                    R.id.moduleDialogInputBottomTabViewMe)) != null) {
                                                                LinearLayout linearLayout = (LinearLayout) viewK;
                                                                ceg cegVar = new ceg(linearLayout, materialCheckBox,
                                                                        materialCheckBox2, materialCheckBox3,
                                                                        materialCheckBox4, textInputEditText,
                                                                        textInputEditText2, textInputEditText3,
                                                                        textInputEditText4);
                                                                textInputEditText.setText(qg.a.o());
                                                                textInputEditText2.setText(qh.a.o());
                                                                textInputEditText3.setText(qi.a.o());
                                                                textInputEditText4.setText(ql.a.o());
                                                                materialCheckBox3.setChecked(qm.a.i());
                                                                materialCheckBox4.setChecked(qn.a.i());
                                                                materialCheckBox2.setChecked(qk.a.i());
                                                                materialCheckBox.setChecked(qj.a.i());
                                                                bzy bzyVar = new bzy(view.getContext());
                                                                eg egVar = (eg) bzyVar.d;
                                                                BottomTabCustomHook.INSTANCE.getClass();
                                                                egVar.d = BottomTabCustomHook.m;
                                                                bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-437992174910250L)  */,
                                                                        new amw(new bp(cegVar, 5), 0));
                                                                bzyVar.s("重置" /* "重置" /* "重置" /* cnb.z(-437996469877546L)  */,
                                                                        new amw(new h(13), 2));
                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar,
                                                                        "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                                                                if (linearLayout != null) {
                                                                    egVar.r = linearLayout;
                                                                }
                                                                bzyVar.i().show();
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
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-638438298614570L)  */.concat(viewK.getResources().getResourceName(i8)));
            case 12:
                BottomTabCustomHook bottomTabCustomHookVar = BottomTabCustomHook.INSTANCE;
                Object objE = ((HookParam) obj).getThisObject();
                RelativeLayout relativeLayout = (RelativeLayout) (!(objE instanceof RelativeLayout) ? null : objE);
                if (relativeLayout == null) {
                    cls5 = RelativeLayout.class;
                    Class<RelativeLayout> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf5 != null ? clsBf5 : RelativeLayout.class).getName()).toString());
                }
                if (qj.a.i()) {
                    int childCount = relativeLayout.getChildCount();
                    while (i6 < childCount) {
                        relativeLayout.getChildAt(i6).setVisibility(8);
                        i6++;
                    }
                } else {
                    int i9 = 0;
                    while (i9 < 4) {
                        if (qm.a.i() && (imageView = (ImageView) erb.b(relativeLayout, "" /* "" /* "" /* cnb.z(-86539296045866L)  */,
                                0, i9, 0, 0, 0)) != null) {
                            imageView.setVisibility(4);
                            ViewParent parent = imageView.getParent();
                            throwIfVar1IsNull(parent,
                                    "null cannot be cast to non-null type android.widget.RelativeLayout" /*
                                                                                                          * cnb.z(-
                                                                                                          * 437932045368106L)
                                                                                                          */);
                            RelativeLayout relativeLayout2 = (RelativeLayout) parent;
                            ImageView imageView2 = new ImageView(relativeLayout2.getContext());
                            imageView2.setLayoutParams(imageView.getLayoutParams());
                            if (i9 == 0) {
                                bottomTabCustomHookVar.getClass();
                                bitmap = (Bitmap) BottomTabCustomHook.d.getValue();
                            } else if (i9 == 1) {
                                bottomTabCustomHookVar.getClass();
                                bitmap = (Bitmap) BottomTabCustomHook.h.getValue();
                            } else if (i9 == 2) {
                                bottomTabCustomHookVar.getClass();
                                bitmap = (Bitmap) BottomTabCustomHook.i.getValue();
                            } else if (i9 != 3) {
                                bottomTabCustomHookVar.getClass();
                                bitmap = (Bitmap) BottomTabCustomHook.c.getValue();
                            } else {
                                bottomTabCustomHookVar.getClass();
                                bitmap = (Bitmap) BottomTabCustomHook.j.getValue();
                            }
                            imageView2.setImageBitmap(bitmap);
                            relativeLayout2.addView(imageView2, 0);
                        }
                        TextView textView = (TextView) erb.b(relativeLayout, "" /* "" /* "" /* cnb.z(-86539296045866L)  */, 0, i9, 0,
                                1);
                        if (textView != null) {
                            if (qk.a.i()) {
                                textView.setVisibility(8);
                            } else if (qn.a.i()) {
                                textView.setText(i9 != 0 ? i9 != 1
                                        ? i9 != 2 ? i9 != 3 ? "" /* "" /* "" /* cnb.z(-439310729870122L)  */ : ql.a.o() : qi.a.o()
                                        : qh.a.o() : qg.a.o());
                            }
                        }
                        i9++;
                    }
                }
                return kotlinUnitVar;
            case 13:
                View view2 = (View) obj;
                View viewK2 = StaticHelpers6.k(view2, R.layout.module_dialog_bottom_tab_material, null, false);
                int i10 = R.id.moduleDialogEdtBottomTabViewBottomDarkColor;
                TextInputEditText textInputEditText5 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                        R.id.moduleDialogEdtBottomTabViewBottomDarkColor);
                if (textInputEditText5 != null) {
                    i10 = R.id.moduleDialogEdtBottomTabViewBottomLightColor;
                    TextInputEditText textInputEditText6 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                            R.id.moduleDialogEdtBottomTabViewBottomLightColor);
                    if (textInputEditText6 != null) {
                        i10 = R.id.moduleDialogEdtBottomTabViewIconDarkColor;
                        TextInputEditText textInputEditText7 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                R.id.moduleDialogEdtBottomTabViewIconDarkColor);
                        if (textInputEditText7 != null) {
                            i10 = R.id.moduleDialogEdtBottomTabViewIconLightColor;
                            TextInputEditText textInputEditText8 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                    R.id.moduleDialogEdtBottomTabViewIconLightColor);
                            if (textInputEditText8 != null) {
                                i10 = R.id.moduleDialogEdtBottomTabViewSelectDarkColor;
                                TextInputEditText textInputEditText9 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                        R.id.moduleDialogEdtBottomTabViewSelectDarkColor);
                                if (textInputEditText9 != null) {
                                    i10 = R.id.moduleDialogEdtBottomTabViewSelectLightColor;
                                    TextInputEditText textInputEditText10 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                            R.id.moduleDialogEdtBottomTabViewSelectLightColor);
                                    if (textInputEditText10 != null) {
                                        i10 = R.id.moduleDialogInputBottomTabViewBottomDarkColor;
                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                R.id.moduleDialogInputBottomTabViewBottomDarkColor)) != null) {
                                            i10 = R.id.moduleDialogInputBottomTabViewBottomLightColor;
                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                    R.id.moduleDialogInputBottomTabViewBottomLightColor)) != null) {
                                                i10 = R.id.moduleDialogInputBottomTabViewIconDarkColor;
                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                        R.id.moduleDialogInputBottomTabViewIconDarkColor)) != null) {
                                                    i10 = R.id.moduleDialogInputBottomTabViewIconLightColor;
                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                            R.id.moduleDialogInputBottomTabViewIconLightColor)) != null) {
                                                        i10 = R.id.moduleDialogInputBottomTabViewSelectDarkColor;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                R.id.moduleDialogInputBottomTabViewSelectDarkColor)) != null) {
                                                            i10 = R.id.moduleDialogInputBottomTabViewSelectLightColor;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK2,
                                                                    R.id.moduleDialogInputBottomTabViewSelectLightColor)) != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) viewK2;
                                                                ceh cehVar = new ceh(linearLayout2, textInputEditText5,
                                                                        textInputEditText6, textInputEditText7,
                                                                        textInputEditText8, textInputEditText9,
                                                                        textInputEditText10);
                                                                textInputEditText6.setText(qr.a.o());
                                                                textInputEditText10.setText(qv.a.o());
                                                                textInputEditText8.setText(qt.a.o());
                                                                textInputEditText5.setText(qq.a.o());
                                                                textInputEditText9.setText(qu.a.o());
                                                                textInputEditText7.setText(qs.a.o());
                                                                bzy bzyVar2 = new bzy(view2.getContext());
                                                                eg egVar2 = (eg) bzyVar2.d;
                                                                BottomTabMaterialHook.a.getClass();
                                                                egVar2.d = BottomTabMaterialHook.m;
                                                                bzyVar2.t("保存" /* "保存" /* "保存" /* cnb.z(-437451009030954L)  */,
                                                                        new amw(new bp(cehVar, i4), 0));
                                                                bzyVar2.s("重置" /* "重置" /* "重置" /* cnb.z(-437455303998250L)  */,
                                                                        new amw(new h(19), 2));
                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2,
                                                                        "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-638300859661098L)  */.concat(viewK2.getResources().getResourceName(i10)));
            case 14:
                Object objE2 = ((HookParam) obj).getThisObject();
                Activity activity = (Activity) (!(objE2 instanceof Activity) ? null : objE2);
                if (activity != null) {
                    activity.getIntent().putExtra("key_fav_item_id" /* "key_fav_item_id" /* "key_fav_item_id" /* cnb.z(-489892559715114L)  */, "" /*
                                                                                                        * cnb.z(-
                                                                                                        * 490373596052266L)
                                                                                                        */);
                    return kotlinUnitVar;
                }
                cls6 = Activity.class;
                Class<Activity> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                throw new IllegalStateException("HookParam instance cannot cast to "
                        .concat((clsBf6 != null ? clsBf6 : Activity.class).getName()).toString());
            case 15:
                un unVar = un.a;
                HookManager hookManagerVarAb = PackageParam.createHook(unVar, dqc.toSingletonList((Method) obj));
                unVar.hookBefore(hookManagerVarAb, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(17));
                hookManagerVarAb.initInstantCollectionAndApplyHooks();
                return kotlinUnitVar;
            case 16:
                un unVar2 = un.a;
                HookManager hookManagerVarAb2 = PackageParam.createHook(unVar2, dqc.toSingletonList((Method) obj));
                unVar2.hookBefore(hookManagerVarAb2, new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(18));
                hookManagerVarAb2.initInstantCollectionAndApplyHooks();
                return kotlinUnitVar;
            case 17:
                ((HookParam) obj).setResult(Boolean.FALSE);
                return kotlinUnitVar;
            case 18:
                HookParam hookParam = (HookParam) obj;
                hookParam.getClass();
                try {
                    objX = hookParam.getArgs()[1];
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
                View view3 = (View) objX;
                Object tag = view3.getTag();
                int i11 = 0;
                FieldResolver fieldResolverVarR = dqc.getWrapperConfiguration(tag).r();
                fieldResolverVarR.name = "a" /* "a" /* "a" /* cnb.z(-490369301084970L)  */;
                Object objD = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR)).getValue();
                throwIfVar1IsNull(objD);
                FieldResolver fieldResolverVarR2 = dqc.getWrapperConfiguration(hookParam.getThisObject()).r();
                fieldResolverVarR2.name = "d" /* "d" /* "d" /* cnb.z(-490377891019562L)  */;
                Object objD2 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR2.resolve())).getValue();
                throwIfVar1IsNull(objD2);
                if (cnb.ab(ewk.a) || cnb.ac(ewh.c)) {
                    FieldResolver fieldResolverVarR3 = dqc.getWrapperConfiguration(objD2).r();
                    fieldResolverVarR3.name = "w" /* "w" /* "w" /* cnb.z(-490317761477418L)  */;
                    Object objE3 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR3.resolve())).getValue_();
                    throwIfVar1IsNull(objE3);
                    zBooleanValue = ((Boolean) objE3).booleanValue();
                } else {
                    FieldResolver fieldResolverVarR4 = dqc.getWrapperConfiguration(objD2).r();
                    fieldResolverVarR4.name = "d" /* "d" /* "d" /* cnb.z(-490326351412010L)  */;
                    Object objE4 = ((BoundField) StaticHelpers5.safeGetFirstInList(fieldResolverVarR4.resolve())).getValue_();
                    throwIfVar1IsNull(objE4);
                    zBooleanValue = ((Number) objE4).intValue() == 1;
                }
                if (zBooleanValue) {
                    FieldResolver fieldResolverVarR5 = dqc.getWrapperConfiguration(objD).r();
                    fieldResolverVarR5.name = "field_type" /* "field_type" /* "field_type" /* cnb.z(-490334941346602L)  */;
                    Object objE5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR5)).getValue_();
                    throwIfVar1IsNull(objE5);
                    if (((Number) objE5).intValue() == 3) {
                        FieldResolver fieldResolverVarR6 = dqc.getWrapperConfiguration(objD).r();
                        fieldResolverVarR6.name = "field_favProto" /* "field_favProto" /* "field_favProto" /* cnb.z(-490253336967978L)  */;
                        Object objD3 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR6)).getValue();
                        throwIfVar1IsNull(objD3);
                        MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(objD3).getMethodResolverBasedOnPreviouslyProvidedConfig();
                        methodResolverVarT.name = "getData" /* "getData" /* "getData" /* cnb.z(-490240452066090L)  */;
                        Object objJ = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT)).invoke(new Object[0]);
                        throwIfVar1IsNull(objJ);
                        cwd cwdVar = cwd.a;
                        cwdVar.getClass();
                        final ays aysVar = ((ayt) cwdVar.c(ayt.Companion.serializer(), (byte[]) objJ)).b;
                        final String string = aysVar.f;
                        String str = aysVar.e;
                        if (string == null) {
                            String strZ = cmz.z();
                            String strValueOf = String.valueOf(str.hashCode() & Opcodes.CONST_METHOD_TYPE);
                            StringBuilder sbY = StaticHelpers6.toSb(strZ);
                            sbY.append("/favorite/" /* "/favorite/" /* "/favorite/" /* cnb.z(-490206092327722L)  */);
                            sbY.append(strValueOf);
                            sbY.append('/');
                            sbY.append(str);
                            sbY.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                            sbY.append(aysVar.b);
                            string = sbY.toString();
                        }
                        if (new File(string).exists()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view3.getContext());
                            builder.setTitle("提示" /* "提示" /* "提示" /* cnb.z(-490124487949098L)  */);
                            builder.setMessage("是否发送收藏语音" /* "是否发送收藏语音" /* "是否发送收藏语音" /* cnb.z(-490128782916394L)  */);
                            builder.setPositiveButton("发送" /* "发送" /* "发送" /* cnb.z(-489557552266026L)  */,
                                    new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.uk
                                        @Override // android.content.DialogInterface.OnClickListener
                                        public final void onClick(DialogInterface dialogInterface, int i12)
                                                throws IllegalAccessException, InstantiationException,
                                                InvocationTargetException {
                                            switch (i6) {
                                                case 0:
                                                    dpv.a.getClass();
                                                    arj.ah(dpv.b, string, aysVar.a);
                                                    dnc.sendToast(null, 3, "已发送" /* "已发送" /* "已发送" /* cnb.z(-489450178083626L)  */);
                                                    break;
                                                default:
                                                    dpv.a.getClass();
                                                    arj.ah(dpv.b, string, aysVar.a);
                                                    dnc.sendToast(null, 3, "已发送" /* "已发送" /* "已发送" /* cnb.z(-479305465330474L)  */);
                                                    break;
                                            }
                                        }
                                    });
                            obj2 = null;
                            builder.setNegativeButton("取消" /* "取消" /* "取消" /* cnb.z(-489493127756586L)  */,
                                    (DialogInterface.OnClickListener) null);
                            builder.show();
                        } else {
                            obj2 = null;
                            dnc.sendToast(null, 3, "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* cnb.z(-489514602593066L)  */);
                        }
                        hookParam.setResult(obj2);
                    }
                }
                return kotlinUnitVar;
            case 19:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(21);
                return kotlinUnitVar;
            case 20:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(22);
                return kotlinUnitVar;
            case 21:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar6 = new DexFinder();
                cdjVar6.usingStrings("MicroMsg.FavSendFilter" /* "MicroMsg.FavSendFilter" /* "MicroMsg.FavSendFilter" /* cnb.z(-489398638476074L)  */,
                        "[FAV_ITEM_TYPE_VOICE] canFilterVoice = true, back" /* "[FAV_ITEM_TYPE_VOICE] canFilterVoice = true, back" /* "[FAV_ITEM_TYPE_VOICE] canFilterVoice = true, back" /* cnb.z(-489299854228266L)  */);
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.dexFinder = cdjVar6;
                return kotlinUnitVar;
            case 22:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* "com.tencent.mm.plugin.fav.ui" /* cnb.z(-489652041546538L)  */ };
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.s("onItemClick" /* "onItemClick" /* "onItemClick" /* cnb.z(-477948255664938L)  */);
                cdjVar7.usingStrings("onItemClick" /* "onItemClick" /* "onItemClick" /* cnb.z(-477931075795754L)  */, (cnb.ab(ewk.a) || cnb.ac(ewh.c))
                        ? "com/tencent/mm/plugin/fav/ui/FavTopSearchUIC$initOnItemClickListener$1"
                        /* "com/tencent/mm/plugin/fav/ui/FavTopSearchUIC$initOnItemClickListener$1" /* "com/tencent/mm/plugin/fav/ui/FavTopSearchUIC$initOnItemClickListener$1" /* cnb.z(-477845176449834L)  */ : "com/tencent/mm/plugin/fav/ui/FavSearchUI$10" /*
                                                                                                        * cnb.z(-
                                                                                                        * 478089989585706L)
                                                                                                        */);
                dexMethodQueryBuilderVar5.dexFinder = cdjVar7;
                return kotlinUnitVar;
            case 23:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[1];
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
                View view4 = (View) objX2;
                Object tag2 = view4.getTag();
                int i12 = 0;
                FieldResolver fieldResolverVarR7 = dqc.getWrapperConfiguration(tag2).r();
                fieldResolverVarR7.name = "a" /* "a" /* "a" /* cnb.z(-479082127031082L)  */;
                Object objD4 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR7)).getValue();
                throwIfVar1IsNull(objD4);
                FieldResolver fieldResolverVarR8 = dqc.getWrapperConfiguration(objD4).r();
                fieldResolverVarR8.name = "field_type" /* "field_type" /* "field_type" /* cnb.z(-479090716965674L)  */;
                Object objE6 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR8)).getValue_();
                throwIfVar1IsNull(objE6);
                if (((Number) objE6).intValue() == 3) {
                    FieldResolver fieldResolverVarR9 = dqc.getWrapperConfiguration(objD4).r();
                    fieldResolverVarR9.name = "field_favProto" /* "field_favProto" /* "field_favProto" /* cnb.z(-479077832063786L)  */;
                    Object objD5 = ((BoundField) yg.enableSuperclassAndResolveFirstField(fieldResolverVarR9)).getValue();
                    throwIfVar1IsNull(objD5);
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(objD5).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.name = "getData" /* "getData" /* "getData" /* cnb.z(-478996227685162L)  */;
                    Object objJ2 = ((MethodHookWrapper) StaticHelpers6.resolveFirstMethod(methodResolverVarT2)).invoke(new Object[0]);
                    throwIfVar1IsNull(objJ2);
                    cwd cwdVar2 = cwd.a;
                    cwdVar2.getClass();
                    final ays aysVar2 = ((ayt) cwdVar2.c(ayt.Companion.serializer(), (byte[]) objJ2)).b;
                    final String string2 = aysVar2.f;
                    String str2 = aysVar2.e;
                    if (string2 == null) {
                        String strZ2 = cmz.z();
                        String strValueOf2 = String.valueOf(str2.hashCode() & Opcodes.CONST_METHOD_TYPE);
                        StringBuilder sbY2 = StaticHelpers6.toSb(strZ2);
                        sbY2.append("/favorite/" /* "/favorite/" /* "/favorite/" /* cnb.z(-478961867946794L)  */);
                        sbY2.append(strValueOf2);
                        sbY2.append('/');
                        sbY2.append(str2);
                        sbY2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                        sbY2.append(aysVar2.b);
                        string2 = sbY2.toString();
                    }
                    if (new File(string2).exists()) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(view4.getContext());
                        builder2.setTitle("提示" /* "提示" /* "提示" /* cnb.z(-478880263568170L)  */);
                        builder2.setMessage("是否发送收藏语音" /* "是否发送收藏语音" /* "是否发送收藏语音" /* cnb.z(-478884558535466L)  */);
                        final int i13 = 1;
                        builder2.setPositiveButton("发送" /* "发送" /* "发送" /* cnb.z(-478863083698986L)  */,
                                new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.uk
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public final void onClick(DialogInterface dialogInterface, int i122)
                                            throws IllegalAccessException, InstantiationException,
                                            InvocationTargetException {
                                        switch (i13) {
                                            case 0:
                                                dpv.a.getClass();
                                                arj.ah(dpv.b, string2, aysVar2.a);
                                                dnc.sendToast(null, 3, "已发送" /* "已发送" /* "已发送" /* cnb.z(-489450178083626L)  */);
                                                break;
                                            default:
                                                dpv.a.getClass();
                                                arj.ah(dpv.b, string2, aysVar2.a);
                                                dnc.sendToast(null, 3, "已发送" /* "已发送" /* "已发送" /* cnb.z(-479305465330474L)  */);
                                                break;
                                        }
                                    }
                                });
                        obj3 = null;
                        builder2.setNegativeButton("取消" /* "取消" /* "取消" /* cnb.z(-478867378666282L)  */,
                                (DialogInterface.OnClickListener) null);
                        builder2.show();
                    } else {
                        obj3 = null;
                        dnc.sendToast(null, 3, "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* "获取语音路径失败, 请尝试播放后重发" /* cnb.z(-479369889839914L)  */);
                    }
                    hookParam2.setResult(obj3);
                }
                return kotlinUnitVar;
            case 24:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new SomeHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(25);
                return kotlinUnitVar;
            case 25:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar8 = new DexFinder();
                uq.a.getClass();
                cdjVar8.setDeclaredClassName(ajn.tryGetClassByClassName("com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* "com.tencent.mm.pluginsdk.ui.chat.ChatFooter" /* cnb.z(-75127567940394L)  */));
                cdjVar8.r(Void.TYPE);
                Class<Boolean> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf7 == null) {
                    clsBf7 = cls;
                }
                Class<Boolean> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar8.q(clsBf7, clsBf8 != null ? clsBf8 : Boolean.class);
                MethodMatcher fjVar3 = new MethodMatcher();
                DexFinder cdjVar9 = new DexFinder();
                cdjVar9.usingStrings("MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* "MicroMsg.ChatFooter" /* cnb.z(-76476187671338L)  */, "this is a quote msg" /*
                                                                                                      * cnb.z(-
                                                                                                      * 76905684400938L)
                                                                                                      */);
                fjVar3.f(cdjVar9);
                cdjVar8.j = fjVar3;
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.dexFinder = cdjVar8;
                return kotlinUnitVar;
            case 26:
                Object obj4 = ((List) obj).get(0);
                MicroMsgMsgInfoDexClassFind.INSTANCE.getClass();
                return Boolean.valueOf(nullSafeIsEqual(obj4, StaticHelpers7.toDexClass(MsgInfo$ClassMsgInfo.INSTANCE)));
            case 27:
                Object objE7 = ((HookParam) obj).getThisObject();
                FrameLayout frameLayout = (FrameLayout) (!(objE7 instanceof FrameLayout) ? null : objE7);
                if (frameLayout == null) {
                    cls7 = FrameLayout.class;
                    Class<FrameLayout> clsBf9 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls7));
                    throw new IllegalStateException("HookParam instance cannot cast to "
                            .concat((clsBf9 != null ? clsBf9 : FrameLayout.class).getName()).toString());
                }
                for (Object obj5 : ur.b) {
                    try {
                        ((xf) obj5).n(frameLayout);
                    } catch (Exception e) {
                        ArrayList arrayList = Logger.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onInit " /* "onInit " /* "onInit " /* cnb.z(-51075751082794L)  */);
                        Logger.logE(yg.decryptVar3UsingCnbZAndConcatToVar1(sb,
                                obj5 instanceof SwitchHook ? ((SwitchHook) obj5).getResult() : "LoadHook" /*
                                                                                                           * cnb.z(-
                                                                                                           * 51041391344426L)
                                                                                                           */,
                                -51002736638762L), e, 12);
                    }
                }
                return kotlinUnitVar;
            case 28:
                View view5 = (View) obj;
                View viewK3 = StaticHelpers6.k(view5, R.layout.module_dialog_chat_group_nav, null, false);
                int i14 = R.id.moduleDialogEdtChatGroupNavActiveDarkColor;
                TextInputEditText textInputEditText11 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                        R.id.moduleDialogEdtChatGroupNavActiveDarkColor);
                if (textInputEditText11 != null) {
                    i14 = R.id.moduleDialogEdtChatGroupNavActiveLightColor;
                    TextInputEditText textInputEditText12 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                            R.id.moduleDialogEdtChatGroupNavActiveLightColor);
                    if (textInputEditText12 != null) {
                        i14 = R.id.moduleDialogEdtChatGroupNavIconDarkColor;
                        TextInputEditText textInputEditText13 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                R.id.moduleDialogEdtChatGroupNavIconDarkColor);
                        if (textInputEditText13 != null) {
                            i14 = R.id.moduleDialogEdtChatGroupNavIconLightColor;
                            TextInputEditText textInputEditText14 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                    R.id.moduleDialogEdtChatGroupNavIconLightColor);
                            if (textInputEditText14 != null) {
                                i14 = R.id.moduleDialogEdtChatGroupNavNavDarkColor;
                                TextInputEditText textInputEditText15 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                        R.id.moduleDialogEdtChatGroupNavNavDarkColor);
                                if (textInputEditText15 != null) {
                                    i14 = R.id.moduleDialogEdtChatGroupNavNavLightColor;
                                    TextInputEditText textInputEditText16 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                            R.id.moduleDialogEdtChatGroupNavNavLightColor);
                                    if (textInputEditText16 != null) {
                                        i14 = R.id.moduleDialogEdtChatGroupNavTextDarkColor;
                                        TextInputEditText textInputEditText17 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                R.id.moduleDialogEdtChatGroupNavTextDarkColor);
                                        if (textInputEditText17 != null) {
                                            i14 = R.id.moduleDialogEdtChatGroupNavTextLightColor;
                                            TextInputEditText textInputEditText18 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                    R.id.moduleDialogEdtChatGroupNavTextLightColor);
                                            if (textInputEditText18 != null) {
                                                i14 = R.id.moduleDialogEdtChatGroupNavWidth;
                                                TextInputEditText textInputEditText19 = (TextInputEditText) KotlinHelpers2
                                                        .recursivelyFindViewById(viewK3, R.id.moduleDialogEdtChatGroupNavWidth);
                                                if (textInputEditText19 != null) {
                                                    i14 = R.id.moduleDialogEdtChatGroupTopPadding;
                                                    TextInputEditText textInputEditText20 = (TextInputEditText) KotlinHelpers2
                                                            .recursivelyFindViewById(viewK3, R.id.moduleDialogEdtChatGroupTopPadding);
                                                    if (textInputEditText20 != null) {
                                                        i14 = R.id.moduleDialogInputChatGroupNavActiveDarkColor;
                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                R.id.moduleDialogInputChatGroupNavActiveDarkColor)) != null) {
                                                            i14 = R.id.moduleDialogInputChatGroupNavActiveLightColor;
                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                    R.id.moduleDialogInputChatGroupNavActiveLightColor)) != null) {
                                                                i14 = R.id.moduleDialogInputChatGroupNavIconDarkColor;
                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                        R.id.moduleDialogInputChatGroupNavIconDarkColor)) != null) {
                                                                    i14 = R.id.moduleDialogInputChatGroupNavIconLightColor;
                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                            R.id.moduleDialogInputChatGroupNavIconLightColor)) != null) {
                                                                        i14 = R.id.moduleDialogInputChatGroupNavNavDarkColor;
                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                                R.id.moduleDialogInputChatGroupNavNavDarkColor)) != null) {
                                                                            i14 = R.id.moduleDialogInputChatGroupNavNavLightColor;
                                                                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                                    R.id.moduleDialogInputChatGroupNavNavLightColor)) != null) {
                                                                                i14 = R.id.moduleDialogInputChatGroupNavTextDarkColor;
                                                                                if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                                                                        R.id.moduleDialogInputChatGroupNavTextDarkColor)) != null) {
                                                                                    i14 = R.id.moduleDialogInputChatGroupNavTextLightColor;
                                                                                    if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(
                                                                                            viewK3,
                                                                                            R.id.moduleDialogInputChatGroupNavTextLightColor)) != null) {
                                                                                        i14 = R.id.moduleDialogInputChatGroupNavWidth;
                                                                                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(
                                                                                                viewK3,
                                                                                                R.id.moduleDialogInputChatGroupNavWidth)) != null) {
                                                                                            i14 = R.id.moduleDialogInputChatGroupTopPadding;
                                                                                            if (((TextInputLayout) KotlinHelpers2
                                                                                                    .recursivelyFindViewById(viewK3,
                                                                                                            R.id.moduleDialogInputChatGroupTopPadding)) != null) {
                                                                                                LinearLayout linearLayout3 = (LinearLayout) viewK3;
                                                                                                cei ceiVar = new cei(
                                                                                                        linearLayout3,
                                                                                                        textInputEditText11,
                                                                                                        textInputEditText12,
                                                                                                        textInputEditText13,
                                                                                                        textInputEditText14,
                                                                                                        textInputEditText15,
                                                                                                        textInputEditText16,
                                                                                                        textInputEditText17,
                                                                                                        textInputEditText18,
                                                                                                        textInputEditText19,
                                                                                                        textInputEditText20);
                                                                                                textInputEditText19
                                                                                                        .setText(String
                                                                                                                .valueOf(
                                                                                                                        vc.a.k()));
                                                                                                textInputEditText20
                                                                                                        .setText(String
                                                                                                                .valueOf(
                                                                                                                        vf.a.k()));
                                                                                                textInputEditText16
                                                                                                        .setText(vb.a
                                                                                                                .o());
                                                                                                textInputEditText12
                                                                                                        .setText(uw.a
                                                                                                                .o());
                                                                                                textInputEditText14
                                                                                                        .setText(uz.a
                                                                                                                .o());
                                                                                                textInputEditText18
                                                                                                        .setText(ve.a
                                                                                                                .o());
                                                                                                textInputEditText15
                                                                                                        .setText(va.a
                                                                                                                .o());
                                                                                                textInputEditText11
                                                                                                        .setText(uv.a
                                                                                                                .o());
                                                                                                textInputEditText13
                                                                                                        .setText(uy.a
                                                                                                                .o());
                                                                                                textInputEditText17
                                                                                                        .setText(vd.a
                                                                                                                .o());
                                                                                                bzy bzyVar3 = new bzy(
                                                                                                        view5.getContext());
                                                                                                eg egVar3 = (eg) bzyVar3.d;
                                                                                                vg.a.getClass();
                                                                                                egVar3.d = vg.c;
                                                                                                bzyVar3.t(
                                                                                                        "保存" /*
                                                                                                              * cnb.z(-
                                                                                                              * 576393201056554L)
                                                                                                              */,
                                                                                                        new amw(new bp(
                                                                                                                ceiVar,
                                                                                                                7), 0));
                                                                                                bzyVar3.s(
                                                                                                        "重置" /*
                                                                                                              * cnb.z(-
                                                                                                              * 576397496023850L)
                                                                                                              */,
                                                                                                        new amw(new h(
                                                                                                                20),
                                                                                                                2));
                                                                                                bjs.x((3 & 2) != 0
                                                                                                        ? new amd(1)
                                                                                                        : null, bzyVar3,
                                                                                                        "取消" /*
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
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-638713176521514L)  */.concat(viewK3.getResources().getResourceName(i14)));
            default:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new us(i5);
                return kotlinUnitVar;
        }
    }
}
