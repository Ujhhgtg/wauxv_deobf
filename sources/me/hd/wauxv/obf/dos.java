package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dos implements IInvokable {
    public final /* synthetic */ int a;

    public /* synthetic */ dos(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Class cls;
        Class cls2;
        Object objX;
        Object objX2;
        Object objX3;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        switch (this.a) {
            case 0:
                DexClassQueryBuilder dexClassQueryBuilderVar = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar = new DexMethodGroupMatcher();
                zbVar.usingEqStrings("MicroMsg.ConfigStorage" /* "MicroMsg.ConfigStorage" /* "MicroMsg.ConfigStorage" /* cnb.z(-59923383712554L)  */,
                        "checkType failed, input type and value[%s, %s] are not match" /* "checkType failed, input type and value[%s, %s] are not match" /* "checkType failed, input type and value[%s, %s] are not match" /* cnb.z(-59807419595562L)  */);
                dexClassQueryBuilderVar.getClass();
                dexClassQueryBuilderVar.methodGroupMatcher = zbVar;
                return Kotlin$Unit.INSTANCE;
            case 1:
                DexMethodQueryBuilder dexMethodQueryBuilderVar = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar = new DexFinder();
                cls = Object.class;
                Class<Object> clsBf = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                if (clsBf == null) {
                    clsBf = cls;
                }
                cdjVar.r(clsBf);
                cls2 = String.class;
                Class<String> clsBf2 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls2));
                cls2 = clsBf2 != null ? clsBf2 : String.class;
                Class<Object> clsBf3 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls));
                cdjVar.q(cls2, clsBf3 != null ? clsBf3 : Object.class);
                dexMethodQueryBuilderVar.getClass();
                dexMethodQueryBuilderVar.dexFinder = cdjVar;
                return Kotlin$Unit.INSTANCE;
            case 2:
                View view = (View) obj;
                View viewK = StaticHelpers6.k(view, R.layout.module_dialog_system_browser, null, false);
                int i = R.id.moduleDialogBtnSystemBrowserAdd;
                MaterialButton materialButton = (MaterialButton) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogBtnSystemBrowserAdd);
                if (materialButton != null) {
                    i = R.id.moduleDialogEdtSystemBrowserHost;
                    TextInputEditText textInputEditText = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK,
                            R.id.moduleDialogEdtSystemBrowserHost);
                    if (textInputEditText != null) {
                        i = R.id.moduleDialogInputSystemBrowserHost;
                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK, R.id.moduleDialogInputSystemBrowserHost)) != null) {
                            i = R.id.moduleDialogRbSystemBrowserBlack;
                            MaterialRadioButton materialRadioButton = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                    R.id.moduleDialogRbSystemBrowserBlack);
                            if (materialRadioButton != null) {
                                i = R.id.moduleDialogRbSystemBrowserWhite;
                                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) KotlinHelpers2.recursivelyFindViewById(viewK,
                                        R.id.moduleDialogRbSystemBrowserWhite);
                                if (materialRadioButton2 != null) {
                                    i = R.id.moduleDialogRgSystemBrowserMode;
                                    RadioGroup radioGroup = (RadioGroup) KotlinHelpers2.recursivelyFindViewById(viewK,
                                            R.id.moduleDialogRgSystemBrowserMode);
                                    if (radioGroup != null) {
                                        i = R.id.moduleDialogRvSystemBrowserList;
                                        RecyclerView recyclerView = (RecyclerView) KotlinHelpers2.recursivelyFindViewById(viewK,
                                                R.id.moduleDialogRvSystemBrowserList);
                                        if (recyclerView != null) {
                                            LinearLayout linearLayout = (LinearLayout) viewK;
                                            final bqr bqrVar = new bqr(linearLayout, materialButton, textInputEditText,
                                                    materialRadioButton, materialRadioButton2, radioGroup,
                                                    recyclerView);
                                            dpd dpdVar = dpd.a;
                                            int iK = dpdVar.k();
                                            doz dozVar = doz.a;
                                            if (iK == dozVar.d) {
                                                materialRadioButton2.setChecked(true);
                                            } else if (iK == doz.b.d) {
                                                materialRadioButton.setChecked(true);
                                            }
                                            int iK2 = dpdVar.k();
                                            final ArrayList arrayListAb = iK2 == dozVar.d ? StaticHelpers5.ab(dpe.a.n())
                                                    : iK2 == doz.b.d ? StaticHelpers5.ab(dpc.a.n()) : new ArrayList();
                                            final zm zmVar = new zm();
                                            zmVar.b = arrayListAb;
                                            zmVar.c = new but(arrayListAb, 15, zmVar);
                                            view.getContext();
                                            recyclerView.setLayoutManager(new LinearLayoutManager(1));
                                            recyclerView.setAdapter(zmVar);
                                            radioGroup.setOnCheckedChangeListener(
                                                    new RadioGroup.OnCheckedChangeListener() { // from class:
                                                                                               // me.hd.wauxv.obf.doy
                                                        @Override // android.widget.RadioGroup.OnCheckedChangeListener
                                                        public final void onCheckedChanged(RadioGroup radioGroup2,
                                                                int i2) {
                                                            bqr bqrVar2 = bqrVar;
                                                            int id = ((MaterialRadioButton) bqrVar2.e).getId();
                                                            ArrayList arrayList = arrayListAb;
                                                            if (i2 == id) {
                                                                arrayList.clear();
                                                                arrayList.addAll(StaticHelpers5.ab(dpe.a.n()));
                                                            } else if (i2 == ((MaterialRadioButton) bqrVar2.c)
                                                                    .getId()) {
                                                                arrayList.clear();
                                                                arrayList.addAll(StaticHelpers5.ab(dpc.a.n()));
                                                            }
                                                            zmVar.af();
                                                        }
                                                    });
                                            materialButton.setOnClickListener(new cyr(bqrVar, arrayListAb, zmVar, 1));
                                            bzy bzyVar = new bzy(view.getContext());
                                            eg egVar = (eg) bzyVar.d;
                                            dpf.a.getClass();
                                            egVar.d = dpf.j;
                                            bzyVar.t("保存" /* "保存" /* "保存" /* cnb.z(-539520906820394L)  */,
                                                    new amw(new ls(bqrVar, 9, arrayListAb), 0));
                                            bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, "取消" /*
                                                                                                  * cnb.z(-
                                                                                                  * 47455093652266L)
                                                                                                  */);
                                            if (linearLayout != null) {
                                                egVar.r = linearLayout;
                                            }
                                            bzyVar.i().show();
                                            return Kotlin$Unit.INSTANCE;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: "
                        /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-660153653263146L)  */.concat(viewK.getResources().getResourceName(i)));
            case 3:
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
                String str = (String) (objX instanceof Failure ? null : objX);
                if (str == null) {
                    str = "";
                }
                dpv.b = str;
                return Kotlin$Unit.INSTANCE;
            case 4:
                return Boolean.valueOf(dnr.bp(((Class) obj).getName(),
                        "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* "com.tencent.mm.ui.chatting.viewitems" /* cnb.z(-104170136795946L)  */, false));
            case 5:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new dos(6);
                return Kotlin$Unit.INSTANCE;
            case 6:
                DexClassQueryBuilder dexClassQueryBuilderVar2 = (DexClassQueryBuilder) obj;
                String[] strArr = { "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* "com.tencent.mm.ui.chatting.component" /* cnb.z(-103976863267626L)  */ };
                dexClassQueryBuilderVar2.getClass();
                dexClassQueryBuilderVar2.strings = SomeStaticHelpers.arrayToList(strArr);
                DexMethodGroupMatcher zbVar2 = new DexMethodGroupMatcher();
                zbVar2.usingEqStrings("MicroMsg.TransformComponent" /* "MicroMsg.TransformComponent" /* "MicroMsg.TransformComponent" /* cnb.z(-104419244899114L)  */, "[onChattingPause]" /*
                                                                                                            * cnb.z(-
                                                                                                            * 104264626076458L)
                                                                                                            */);
                dexClassQueryBuilderVar2.methodGroupMatcher = zbVar2;
                return Kotlin$Unit.INSTANCE;
            case 7:
                HookParam hookParam2 = (HookParam) obj;
                hookParam2.getClass();
                try {
                    objX2 = hookParam2.getArgs()[2];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = FastKV.getFailureFromException(th2);
                }
                if (objX2 instanceof Failure) {
                    objX2 = null;
                }
                if (objX2 == Bitmap.CompressFormat.JPEG) {
                    try {
                        objX3 = hookParam2.getArgs()[3];
                        if (objX3 == null) {
                            objX3 = null;
                        }
                    } catch (Throwable th3) {
                        objX3 = FastKV.getFailureFromException(th3);
                    }
                    String str2 = (String) (objX3 instanceof Failure ? null : objX3);
                    if (str2 == null) {
                        str2 = "";
                    }
                    if (StringsKt.contains(str2, "avatar" /* "avatar" /* "avatar" /* cnb.z(-491967028919082L)  */, false)
                            || StringsKt.contains(str2, "user_hd_" /* "user_hd_" /* "user_hd_" /* cnb.z(-491936964148010L)  */, false)) {
                        new ek(hookParam2, 2, 8).q(Bitmap.CompressFormat.PNG);
                    }
                }
                return Kotlin$Unit.INSTANCE;
            case 8:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(9);
                return Kotlin$Unit.INSTANCE;
            case 9:
                DexMethodQueryBuilder dexMethodQueryBuilderVar2 = (DexMethodQueryBuilder) obj;
                String[] strArr2 = { "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* "com.tencent.mm.sdk.platformtools" /* cnb.z(-491898309442346L)  */ };
                dexMethodQueryBuilderVar2.getClass();
                dexMethodQueryBuilderVar2.a = SomeStaticHelpers.arrayToList(strArr2);
                DexFinder cdjVar2 = new DexFinder();
                if (cnb.ab(ewk.e) || cnb.ac(ewh.d)) {
                    cdjVar2.usingStrings("MicroMsg.BitmapUtil" /* "MicroMsg.BitmapUtil" /* "MicroMsg.BitmapUtil" /* cnb.z(-491773755390762L)  */, "saveBitmapToImage failed: %s" /*
                                                                                                                    * cnb
                                                                                                                    * .z
                                                                                                                    * (-
                                                                                                                    * 488973436713770L)
                                                                                                                    */);
                } else {
                    DexFinder.setClassEquals(cdjVar2, "com.tencent.mm.sdk.platformtools.BitmapUtil" /* "com.tencent.mm.sdk.platformtools.BitmapUtil" /* "com.tencent.mm.sdk.platformtools.BitmapUtil" /* cnb.z(-488814522923818L)  */);
                    cdjVar2.s("saveBitmapToImage" /* "saveBitmapToImage" /* "saveBitmapToImage" /* cnb.z(-489209659915050L)  */);
                }
                dexMethodQueryBuilderVar2.dexFinder = cdjVar2;
                return Kotlin$Unit.INSTANCE;
            case 10:
                if (obj != null) {
                    throw new ClassCastException();
                }
                throwIfVar1IsNull(null, "it");
                throw null;
            case 11:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(20);
                return Kotlin$Unit.INSTANCE;
            case 12:
                DexMethodQueryBuilder dexMethodQueryBuilderVar3 = (DexMethodQueryBuilder) obj;
                String[] strArr3 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-382067405749034L)  */ };
                dexMethodQueryBuilderVar3.getClass();
                dexMethodQueryBuilderVar3.a = SomeStaticHelpers.arrayToList(strArr3);
                DexFinder cdjVar3 = new DexFinder();
                cdjVar3.usingStrings("setSdkId" /* "setSdkId" /* "setSdkId" /* cnb.z(-381929966795562L)  */,
                        "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* cnb.z(-381908491959082L)  */);
                dexMethodQueryBuilderVar3.dexFinder = cdjVar3;
                return Kotlin$Unit.INSTANCE;
            case 13:
                DexMethodQueryBuilder dexMethodQueryBuilderVar4 = (DexMethodQueryBuilder) obj;
                String[] strArr4 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-382350873590570L)  */ };
                dexMethodQueryBuilderVar4.getClass();
                dexMethodQueryBuilderVar4.a = SomeStaticHelpers.arrayToList(strArr4);
                DexFinder cdjVar4 = new DexFinder();
                cdjVar4.usingStrings("setContentDes" /* "setContentDes" /* "setContentDes" /* cnb.z(-382213434637098L)  */,
                        "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* cnb.z(-382136125225770L)  */);
                dexMethodQueryBuilderVar4.dexFinder = cdjVar4;
                return Kotlin$Unit.INSTANCE;
            case 14:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(13);
                return Kotlin$Unit.INSTANCE;
            case 15:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(22);
                return Kotlin$Unit.INSTANCE;
            case 16:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(12);
                return Kotlin$Unit.INSTANCE;
            case 17:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(21);
                return Kotlin$Unit.INSTANCE;
            case 18:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new dos(19);
                return Kotlin$Unit.INSTANCE;
            case 19:
                DexMethodQueryBuilder dexMethodQueryBuilderVar5 = (DexMethodQueryBuilder) obj;
                String[] strArr5 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-379090993412906L)  */ };
                dexMethodQueryBuilderVar5.getClass();
                dexMethodQueryBuilderVar5.a = SomeStaticHelpers.arrayToList(strArr5);
                DexFinder cdjVar5 = new DexFinder();
                cdjVar5.usingStrings("MicroMsg.UploadPackHelper" /* "MicroMsg.UploadPackHelper" /* "MicroMsg.UploadPackHelper" /* cnb.z(-378403798645546L)  */,
                        "commit sns info ret %d, typeFlag %d sightMd5 %s" /* "commit sns info ret %d, typeFlag %d sightMd5 %s" /* "commit sns info ret %d, typeFlag %d sightMd5 %s" /* cnb.z(-378240589888298L)  */);
                dexMethodQueryBuilderVar5.dexFinder = cdjVar5;
                return Kotlin$Unit.INSTANCE;
            case 20:
                DexMethodQueryBuilder dexMethodQueryBuilderVar6 = (DexMethodQueryBuilder) obj;
                String[] strArr6 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-380512627587882L)  */ };
                dexMethodQueryBuilderVar6.getClass();
                dexMethodQueryBuilderVar6.a = SomeStaticHelpers.arrayToList(strArr6);
                DexFinder cdjVar6 = new DexFinder();
                cls3 = Integer.class;
                Class<Integer> clsBf4 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls3));
                cls3 = clsBf4 != null ? clsBf4 : Integer.class;
                cls4 = Context.class;
                Class<Context> clsBf5 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls4));
                cdjVar6.ensureParameterNotNull(cls3, clsBf5 != null ? clsBf5 : Context.class);
                cdjVar6.usingStrings("initSnsObj" /* "initSnsObj" /* "initSnsObj" /* cnb.z(-380924944448298L)  */,
                        "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* cnb.z(-380912059546410L)  */);
                dexMethodQueryBuilderVar6.dexFinder = cdjVar6;
                return Kotlin$Unit.INSTANCE;
            case 21:
                DexMethodQueryBuilder dexMethodQueryBuilderVar7 = (DexMethodQueryBuilder) obj;
                String[] strArr7 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-378949259492138L)  */ };
                dexMethodQueryBuilderVar7.getClass();
                dexMethodQueryBuilderVar7.a = SomeStaticHelpers.arrayToList(strArr7);
                DexFinder cdjVar7 = new DexFinder();
                cdjVar7.usingStrings("setSdkAppName" /* "setSdkAppName" /* "setSdkAppName" /* cnb.z(-378811820538666L)  */,
                        "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* cnb.z(-379284266941226L)  */);
                dexMethodQueryBuilderVar7.dexFinder = cdjVar7;
                return Kotlin$Unit.INSTANCE;
            case 22:
                DexMethodQueryBuilder dexMethodQueryBuilderVar8 = (DexMethodQueryBuilder) obj;
                String[] strArr8 = { "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* "com.tencent.mm.plugin.sns.model" /* cnb.z(-382492607511338L)  */ };
                dexMethodQueryBuilderVar8.getClass();
                dexMethodQueryBuilderVar8.a = SomeStaticHelpers.arrayToList(strArr8);
                DexFinder cdjVar8 = new DexFinder();
                cdjVar8.usingStrings("setUploadList" /* "setUploadList" /* "setUploadList" /* cnb.z(-381805412743978L)  */,
                        "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* "com.tencent.mm.plugin.sns.model.UploadPackHelper" /* cnb.z(-381728103332650L)  */);
                dexMethodQueryBuilderVar8.dexFinder = cdjVar8;
                return Kotlin$Unit.INSTANCE;
            case 23:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new dos(24);
                findDexClassMethodDslWrapperVar.onMethodCallback = new dos(25);
                return Kotlin$Unit.INSTANCE;
            case 24:
                DexClassQueryBuilder dexClassQueryBuilderVar3 = (DexClassQueryBuilder) obj;
                String[] strArr9 = { "com.tencent.mm.vfs" /* "com.tencent.mm.vfs" /* "com.tencent.mm.vfs" /* cnb.z(-107511621352234L)  */ };
                dexClassQueryBuilderVar3.getClass();
                dexClassQueryBuilderVar3.strings = SomeStaticHelpers.arrayToList(strArr9);
                DexMethodGroupMatcher zbVar3 = new DexMethodGroupMatcher();
                zbVar3.usingEqStrings("MicroMsg.VFSFileOp" /* "MicroMsg.VFSFileOp" /* "MicroMsg.VFSFileOp" /* cnb.z(-106828721552170L)  */, "Cannot move dir: " /*
                                                                                                   * cnb.z(-
                                                                                                   * 106781476911914L)
                                                                                                   */);
                dexClassQueryBuilderVar3.methodGroupMatcher = zbVar3;
                return Kotlin$Unit.INSTANCE;
            case 25:
                DexMethodQueryBuilder dexMethodQueryBuilderVar9 = (DexMethodQueryBuilder) obj;
                DexFinder cdjVar9 = new DexFinder();
                cls5 = String.class;
                Class<String> clsBf6 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                if (clsBf6 == null) {
                    clsBf6 = cls5;
                }
                cdjVar9.r(clsBf6);
                Class<String> clsBf7 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls5));
                cls5 = clsBf7 != null ? clsBf7 : String.class;
                cls6 = Boolean.class;
                Class<Boolean> clsBf8 = HugeSyntheticPileOfHelpers.getPrimitiveTypeClassByJWrapperClass(dal.getKClassFromClass(cls6));
                cdjVar9.q(cls5, clsBf8 != null ? clsBf8 : Boolean.class);
                dexMethodQueryBuilderVar9.getClass();
                dexMethodQueryBuilderVar9.dexFinder = cdjVar9;
                return Kotlin$Unit.INSTANCE;
            case 26:
                ((FindDexClassMethodDslWrapper) obj).onClassCallback = new dos(27);
                return Kotlin$Unit.INSTANCE;
            case 27:
                DexClassQueryBuilder dexClassQueryBuilderVar4 = (DexClassQueryBuilder) obj;
                DexMethodGroupMatcher zbVar4 = new DexMethodGroupMatcher();
                zbVar4.usingEqStrings("MicroMsg.VideoService" /* "MicroMsg.VideoService" /* "MicroMsg.VideoService" /* cnb.z(-354704169106218L)  */, "MicroMsg.SubCoreVideo" /*
                                                                                                          * cnb.z(-
                                                                                                          * 354661219433258L)
                                                                                                          */,
                        "quitVideoSendThread" /* "quitVideoSendThread" /* "quitVideoSendThread" /* cnb.z(-355099306097450L)  */);
                dexClassQueryBuilderVar4.getClass();
                dexClassQueryBuilderVar4.methodGroupMatcher = zbVar4;
                return Kotlin$Unit.INSTANCE;
            case 28:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new epy(0);
                return Kotlin$Unit.INSTANCE;
            default:
                ((FindDexClassMethodDslWrapper) obj).onMethodCallback = new epy(1);
                return Kotlin$Unit.INSTANCE;
        }
    }
}
