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
public final /* synthetic */ class mj implements bgf {
    public final /* synthetic */ int a;

    public /* synthetic */ mj(int i) {
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
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                int i7 = bte.a;
                azg azgVarAa = dkz.aa((bmm) obj);
                azgVarAa.a = dal.b(Button.class);
                Iterator it = azgVarAa.c().iterator();
                while (it.hasNext()) {
                    Button button = (Button) ((azk) it.next()).e();
                    if (button != null && button.getVisibility() == 0) {
                        List listAg = aba.ag(cnb.z(-440083823983402L), cnb.z(-440113888754474L), cnb.z(-441664371948330L), cnb.z(-441690141752106L));
                        if (!listAg.isEmpty()) {
                            Iterator it2 = listAg.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (dnj.ab(button.getText(), (String) it2.next(), true)) {
                                        button.performClick();
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                return ensVar;
            case 1:
                ((amm) obj).c = new mj(3);
                return ensVar;
            case 2:
                ((amm) obj).c = new mj(i3);
                return ensVar;
            case 3:
                bah bahVar = (bah) obj;
                cdj cdjVar = new cdj();
                cdj.l(cdjVar, cnb.z(-441565587700522L));
                if (cnb.ab(ewk.h) || cnb.ac(ewh.g)) {
                    cdjVar.t(cnb.z(-441917775018794L));
                } else {
                    cdjVar.t(cnb.z(-441827580705578L));
                }
                bahVar.getClass();
                bahVar.d = cdjVar;
                return ensVar;
            case 4:
                bah bahVar2 = (bah) obj;
                cdj cdjVar2 = new cdj();
                cdj.l(cdjVar2, cnb.z(-441127501036330L));
                cdjVar2.t(cnb.z(-440929932540714L));
                bahVar2.getClass();
                bahVar2.d = cdjVar2;
                return ensVar;
            case 5:
                ((amm) obj).c = new mj(i4);
                return ensVar;
            case 6:
                bah bahVar3 = (bah) obj;
                cdj cdjVar3 = new cdj();
                cls2 = ImageView.class;
                Class<ImageView> clsBf = cnf.bf(dal.b(cls2));
                cls2 = clsBf != null ? clsBf : ImageView.class;
                cls3 = String.class;
                Class<String> clsBf2 = cnf.bf(dal.b(cls3));
                cls3 = clsBf2 != null ? clsBf2 : String.class;
                cls4 = Float.class;
                Class<Float> clsBf3 = cnf.bf(dal.b(cls4));
                cls4 = clsBf3 != null ? clsBf3 : Float.class;
                Class<Boolean> clsBf4 = cnf.bf(dal.b(cls));
                cdjVar3.q(cls2, cls3, cls4, clsBf4 != null ? clsBf4 : Boolean.class);
                cdjVar3.t(cnb.z(-118858924948266L));
                bahVar3.getClass();
                bahVar3.d = cdjVar3;
                return ensVar;
            case 7:
                ((amm) obj).b = new mj(i2);
                return ensVar;
            case 8:
                bag bagVar = (bag) obj;
                String[] strArr = {cnb.z(-361683490962218L)};
                bagVar.getClass();
                bagVar.a = la.ab(strArr);
                zb zbVar = new zb();
                cdj cdjVar4 = new cdj();
                cdjVar4.s(cnb.z(-361601886583594L));
                cdjVar4.t(cnb.z(-361477332532010L));
                fj fjVar = zbVar.f;
                if (fjVar == null) {
                    fjVar = new fj();
                }
                zbVar.f = fjVar;
                fjVar.f(cdjVar4);
                cdj cdjVar5 = new cdj();
                cdjVar5.s(cnb.z(-360906101881642L));
                cdjVar5.t(cnb.z(-360845972339498L));
                fj fjVar2 = zbVar.f;
                if (fjVar2 == null) {
                    fjVar2 = new fj();
                }
                zbVar.f = fjVar2;
                fjVar2.f(cdjVar5);
                bagVar.b = zbVar;
                return ensVar;
            case 9:
                ((amm) obj).b = new mj(10);
                return ensVar;
            case 10:
                bag bagVar2 = (bag) obj;
                String[] strArr2 = {cnb.z(-380091720792874L)};
                bagVar2.getClass();
                bagVar2.a = la.ab(strArr2);
                zb zbVar2 = new zb();
                zbVar2.k(cnb.z(-380010116414250L), cnb.z(-379894152297258L));
                bagVar2.b = zbVar2;
                return ensVar;
            case 11:
                View view = (View) obj;
                View viewK = dkz.k(view, R.layout.module_dialog_bottom_tab_custom, null, false);
                int i8 = R.id.moduleDialogCbBottomTabViewHideTab;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbBottomTabViewHideTab);
                if (materialCheckBox != null) {
                    i8 = R.id.moduleDialogCbBottomTabViewHideTitle;
                    MaterialCheckBox materialCheckBox2 = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbBottomTabViewHideTitle);
                    if (materialCheckBox2 != null) {
                        i8 = R.id.moduleDialogCbBottomTabViewModIcon;
                        MaterialCheckBox materialCheckBox3 = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbBottomTabViewModIcon);
                        if (materialCheckBox3 != null) {
                            i8 = R.id.moduleDialogCbBottomTabViewModTitle;
                            MaterialCheckBox materialCheckBox4 = (MaterialCheckBox) cnd.aq(viewK, R.id.moduleDialogCbBottomTabViewModTitle);
                            if (materialCheckBox4 != null) {
                                i8 = R.id.moduleDialogEdtBottomTabViewChats;
                                TextInputEditText textInputEditText = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtBottomTabViewChats);
                                if (textInputEditText != null) {
                                    i8 = R.id.moduleDialogEdtBottomTabViewContacts;
                                    TextInputEditText textInputEditText2 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtBottomTabViewContacts);
                                    if (textInputEditText2 != null) {
                                        i8 = R.id.moduleDialogEdtBottomTabViewDiscover;
                                        TextInputEditText textInputEditText3 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtBottomTabViewDiscover);
                                        if (textInputEditText3 != null) {
                                            i8 = R.id.moduleDialogEdtBottomTabViewMe;
                                            TextInputEditText textInputEditText4 = (TextInputEditText) cnd.aq(viewK, R.id.moduleDialogEdtBottomTabViewMe);
                                            if (textInputEditText4 != null) {
                                                i8 = R.id.moduleDialogInputBottomTabViewChats;
                                                if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputBottomTabViewChats)) != null) {
                                                    i8 = R.id.moduleDialogInputBottomTabViewContacts;
                                                    if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputBottomTabViewContacts)) != null) {
                                                        i8 = R.id.moduleDialogInputBottomTabViewDiscover;
                                                        if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputBottomTabViewDiscover)) != null) {
                                                            i8 = R.id.moduleDialogInputBottomTabViewMe;
                                                            if (((TextInputLayout) cnd.aq(viewK, R.id.moduleDialogInputBottomTabViewMe)) != null) {
                                                                LinearLayout linearLayout = (LinearLayout) viewK;
                                                                ceg cegVar = new ceg(linearLayout, materialCheckBox, materialCheckBox2, materialCheckBox3, materialCheckBox4, textInputEditText, textInputEditText2, textInputEditText3, textInputEditText4);
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
                                                                qo.a.getClass();
                                                                egVar.d = qo.m;
                                                                bzyVar.t(cnb.z(-437992174910250L), new amw(new bp(cegVar, 5), 0));
                                                                bzyVar.s(cnb.z(-437996469877546L), new amw(new h(13), 2));
                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar, cnb.z(-47455093652266L));
                                                                if (linearLayout != null) {
                                                                    egVar.r = linearLayout;
                                                                }
                                                                bzyVar.i().show();
                                                                return ensVar;
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
                throw new NullPointerException(cnb.z(-638438298614570L).concat(viewK.getResources().getResourceName(i8)));
            case 12:
                qo qoVar = qo.a;
                Object objE = ((bmm) obj).e();
                RelativeLayout relativeLayout = (RelativeLayout) (!(objE instanceof RelativeLayout) ? null : objE);
                if (relativeLayout == null) {
                    cls5 = RelativeLayout.class;
                    Class<RelativeLayout> clsBf5 = cnf.bf(dal.b(cls5));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf5 != null ? clsBf5 : RelativeLayout.class).getName()).toString());
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
                        if (qm.a.i() && (imageView = (ImageView) erb.b(relativeLayout, cnb.z(-86539296045866L), 0, i9, 0, 0, 0)) != null) {
                            imageView.setVisibility(4);
                            ViewParent parent = imageView.getParent();
                            bzo.o(parent, cnb.z(-437932045368106L));
                            RelativeLayout relativeLayout2 = (RelativeLayout) parent;
                            ImageView imageView2 = new ImageView(relativeLayout2.getContext());
                            imageView2.setLayoutParams(imageView.getLayoutParams());
                            if (i9 == 0) {
                                qoVar.getClass();
                                bitmap = (Bitmap) qo.d.getValue();
                            } else if (i9 == 1) {
                                qoVar.getClass();
                                bitmap = (Bitmap) qo.h.getValue();
                            } else if (i9 == 2) {
                                qoVar.getClass();
                                bitmap = (Bitmap) qo.i.getValue();
                            } else if (i9 != 3) {
                                qoVar.getClass();
                                bitmap = (Bitmap) qo.c.getValue();
                            } else {
                                qoVar.getClass();
                                bitmap = (Bitmap) qo.j.getValue();
                            }
                            imageView2.setImageBitmap(bitmap);
                            relativeLayout2.addView(imageView2, 0);
                        }
                        TextView textView = (TextView) erb.b(relativeLayout, cnb.z(-86539296045866L), 0, i9, 0, 1);
                        if (textView != null) {
                            if (qk.a.i()) {
                                textView.setVisibility(8);
                            } else if (qn.a.i()) {
                                textView.setText(i9 != 0 ? i9 != 1 ? i9 != 2 ? i9 != 3 ? cnb.z(-439310729870122L) : ql.a.o() : qi.a.o() : qh.a.o() : qg.a.o());
                            }
                        }
                        i9++;
                    }
                }
                return ensVar;
            case 13:
                View view2 = (View) obj;
                View viewK2 = dkz.k(view2, R.layout.module_dialog_bottom_tab_material, null, false);
                int i10 = R.id.moduleDialogEdtBottomTabViewBottomDarkColor;
                TextInputEditText textInputEditText5 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewBottomDarkColor);
                if (textInputEditText5 != null) {
                    i10 = R.id.moduleDialogEdtBottomTabViewBottomLightColor;
                    TextInputEditText textInputEditText6 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewBottomLightColor);
                    if (textInputEditText6 != null) {
                        i10 = R.id.moduleDialogEdtBottomTabViewIconDarkColor;
                        TextInputEditText textInputEditText7 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewIconDarkColor);
                        if (textInputEditText7 != null) {
                            i10 = R.id.moduleDialogEdtBottomTabViewIconLightColor;
                            TextInputEditText textInputEditText8 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewIconLightColor);
                            if (textInputEditText8 != null) {
                                i10 = R.id.moduleDialogEdtBottomTabViewSelectDarkColor;
                                TextInputEditText textInputEditText9 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewSelectDarkColor);
                                if (textInputEditText9 != null) {
                                    i10 = R.id.moduleDialogEdtBottomTabViewSelectLightColor;
                                    TextInputEditText textInputEditText10 = (TextInputEditText) cnd.aq(viewK2, R.id.moduleDialogEdtBottomTabViewSelectLightColor);
                                    if (textInputEditText10 != null) {
                                        i10 = R.id.moduleDialogInputBottomTabViewBottomDarkColor;
                                        if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewBottomDarkColor)) != null) {
                                            i10 = R.id.moduleDialogInputBottomTabViewBottomLightColor;
                                            if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewBottomLightColor)) != null) {
                                                i10 = R.id.moduleDialogInputBottomTabViewIconDarkColor;
                                                if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewIconDarkColor)) != null) {
                                                    i10 = R.id.moduleDialogInputBottomTabViewIconLightColor;
                                                    if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewIconLightColor)) != null) {
                                                        i10 = R.id.moduleDialogInputBottomTabViewSelectDarkColor;
                                                        if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewSelectDarkColor)) != null) {
                                                            i10 = R.id.moduleDialogInputBottomTabViewSelectLightColor;
                                                            if (((TextInputLayout) cnd.aq(viewK2, R.id.moduleDialogInputBottomTabViewSelectLightColor)) != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) viewK2;
                                                                ceh cehVar = new ceh(linearLayout2, textInputEditText5, textInputEditText6, textInputEditText7, textInputEditText8, textInputEditText9, textInputEditText10);
                                                                textInputEditText6.setText(qr.a.o());
                                                                textInputEditText10.setText(qv.a.o());
                                                                textInputEditText8.setText(qt.a.o());
                                                                textInputEditText5.setText(qq.a.o());
                                                                textInputEditText9.setText(qu.a.o());
                                                                textInputEditText7.setText(qs.a.o());
                                                                bzy bzyVar2 = new bzy(view2.getContext());
                                                                eg egVar2 = (eg) bzyVar2.d;
                                                                qw.a.getClass();
                                                                egVar2.d = qw.m;
                                                                bzyVar2.t(cnb.z(-437451009030954L), new amw(new bp(cehVar, i4), 0));
                                                                bzyVar2.s(cnb.z(-437455303998250L), new amw(new h(19), 2));
                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar2, cnb.z(-47455093652266L));
                                                                if (linearLayout2 != null) {
                                                                    egVar2.r = linearLayout2;
                                                                }
                                                                bzyVar2.i().show();
                                                                return ensVar;
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
                throw new NullPointerException(cnb.z(-638300859661098L).concat(viewK2.getResources().getResourceName(i10)));
            case 14:
                Object objE2 = ((bmm) obj).e();
                Activity activity = (Activity) (!(objE2 instanceof Activity) ? null : objE2);
                if (activity != null) {
                    activity.getIntent().putExtra(cnb.z(-489892559715114L), cnb.z(-490373596052266L));
                    return ensVar;
                }
                cls6 = Activity.class;
                Class<Activity> clsBf6 = cnf.bf(dal.b(cls6));
                throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf6 != null ? clsBf6 : Activity.class).getName()).toString());
            case 15:
                un unVar = un.a;
                aki akiVarAb = csb.ab(unVar, dqc.bf((Method) obj));
                unVar.y(akiVarAb, new mj(17));
                akiVarAb.o();
                return ensVar;
            case 16:
                un unVar2 = un.a;
                aki akiVarAb2 = csb.ab(unVar2, dqc.bf((Method) obj));
                unVar2.y(akiVarAb2, new mj(18));
                akiVarAb2.o();
                return ensVar;
            case 17:
                ((bmm) obj).h(Boolean.FALSE);
                return ensVar;
            case 18:
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[1];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                if (objX instanceof dcx) {
                    objX = null;
                }
                bzo.n(objX);
                View view3 = (View) objX;
                Object tag = view3.getTag();
                int i11 = bte.a;
                azg azgVarR = dqc.bi(tag).r();
                azgVarR.ab = cnb.z(-490369301084970L);
                Object objD = ((azk) yg.e(azgVarR)).d();
                bzo.n(objD);
                azg azgVarR2 = dqc.bi(bmmVar.e()).r();
                azgVarR2.ab = cnb.z(-490377891019562L);
                Object objD2 = ((azk) aaz.e(azgVarR2.c())).d();
                bzo.n(objD2);
                if (cnb.ab(ewk.a) || cnb.ac(ewh.c)) {
                    azg azgVarR3 = dqc.bi(objD2).r();
                    azgVarR3.ab = cnb.z(-490317761477418L);
                    Object objE3 = ((azk) aaz.e(azgVarR3.c())).e();
                    bzo.n(objE3);
                    zBooleanValue = ((Boolean) objE3).booleanValue();
                } else {
                    azg azgVarR4 = dqc.bi(objD2).r();
                    azgVarR4.ab = cnb.z(-490326351412010L);
                    Object objE4 = ((azk) aaz.e(azgVarR4.c())).e();
                    bzo.n(objE4);
                    zBooleanValue = ((Number) objE4).intValue() == 1;
                }
                if (zBooleanValue) {
                    azg azgVarR5 = dqc.bi(objD).r();
                    azgVarR5.ab = cnb.z(-490334941346602L);
                    Object objE5 = ((azk) yg.e(azgVarR5)).e();
                    bzo.n(objE5);
                    if (((Number) objE5).intValue() == 3) {
                        azg azgVarR6 = dqc.bi(objD).r();
                        azgVarR6.ab = cnb.z(-490253336967978L);
                        Object objD3 = ((azk) yg.e(azgVarR6)).d();
                        bzo.n(objD3);
                        cde cdeVarT = dqc.bi(objD3).t();
                        cdeVarT.ab = cnb.z(-490240452066090L);
                        Object objJ = ((cdk) dkz.m(cdeVarT)).j(new Object[0]);
                        bzo.n(objJ);
                        cwd cwdVar = cwd.a;
                        cwdVar.getClass();
                        final ays aysVar = ((ayt) cwdVar.c(ayt.Companion.serializer(), (byte[]) objJ)).b;
                        final String string = aysVar.f;
                        String str = aysVar.e;
                        if (string == null) {
                            String strZ = cmz.z();
                            String strValueOf = String.valueOf(str.hashCode() & Opcodes.CONST_METHOD_TYPE);
                            StringBuilder sbY = dkz.y(strZ);
                            sbY.append(cnb.z(-490206092327722L));
                            sbY.append(strValueOf);
                            sbY.append('/');
                            sbY.append(str);
                            sbY.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                            sbY.append(aysVar.b);
                            string = sbY.toString();
                        }
                        if (new File(string).exists()) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(view3.getContext());
                            builder.setTitle(cnb.z(-490124487949098L));
                            builder.setMessage(cnb.z(-490128782916394L));
                            builder.setPositiveButton(cnb.z(-489557552266026L), new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.uk
                                @Override // android.content.DialogInterface.OnClickListener
                                public final void onClick(DialogInterface dialogInterface, int i12) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                                    switch (i6) {
                                        case 0:
                                            dpv.a.getClass();
                                            arj.ah(dpv.b, string, aysVar.a);
                                            dnc.g(null, 3, cnb.z(-489450178083626L));
                                            break;
                                        default:
                                            dpv.a.getClass();
                                            arj.ah(dpv.b, string, aysVar.a);
                                            dnc.g(null, 3, cnb.z(-479305465330474L));
                                            break;
                                    }
                                }
                            });
                            obj2 = null;
                            builder.setNegativeButton(cnb.z(-489493127756586L), (DialogInterface.OnClickListener) null);
                            builder.show();
                        } else {
                            obj2 = null;
                            dnc.g(null, 3, cnb.z(-489514602593066L));
                        }
                        bmmVar.h(obj2);
                    }
                }
                return ensVar;
            case 19:
                ((amm) obj).c = new mj(21);
                return ensVar;
            case 20:
                ((amm) obj).c = new mj(22);
                return ensVar;
            case 21:
                bah bahVar4 = (bah) obj;
                cdj cdjVar6 = new cdj();
                cdjVar6.t(cnb.z(-489398638476074L), cnb.z(-489299854228266L));
                bahVar4.getClass();
                bahVar4.d = cdjVar6;
                return ensVar;
            case 22:
                bah bahVar5 = (bah) obj;
                String[] strArr3 = {cnb.z(-489652041546538L)};
                bahVar5.getClass();
                bahVar5.a = la.ab(strArr3);
                cdj cdjVar7 = new cdj();
                cdjVar7.s(cnb.z(-477948255664938L));
                cdjVar7.t(cnb.z(-477931075795754L), (cnb.ab(ewk.a) || cnb.ac(ewh.c)) ? cnb.z(-477845176449834L) : cnb.z(-478089989585706L));
                bahVar5.d = cdjVar7;
                return ensVar;
            case 23:
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                try {
                    objX2 = bmmVar2.d()[1];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                if (objX2 instanceof dcx) {
                    objX2 = null;
                }
                bzo.n(objX2);
                View view4 = (View) objX2;
                Object tag2 = view4.getTag();
                int i12 = bte.a;
                azg azgVarR7 = dqc.bi(tag2).r();
                azgVarR7.ab = cnb.z(-479082127031082L);
                Object objD4 = ((azk) yg.e(azgVarR7)).d();
                bzo.n(objD4);
                azg azgVarR8 = dqc.bi(objD4).r();
                azgVarR8.ab = cnb.z(-479090716965674L);
                Object objE6 = ((azk) yg.e(azgVarR8)).e();
                bzo.n(objE6);
                if (((Number) objE6).intValue() == 3) {
                    azg azgVarR9 = dqc.bi(objD4).r();
                    azgVarR9.ab = cnb.z(-479077832063786L);
                    Object objD5 = ((azk) yg.e(azgVarR9)).d();
                    bzo.n(objD5);
                    cde cdeVarT2 = dqc.bi(objD5).t();
                    cdeVarT2.ab = cnb.z(-478996227685162L);
                    Object objJ2 = ((cdk) dkz.m(cdeVarT2)).j(new Object[0]);
                    bzo.n(objJ2);
                    cwd cwdVar2 = cwd.a;
                    cwdVar2.getClass();
                    final ays aysVar2 = ((ayt) cwdVar2.c(ayt.Companion.serializer(), (byte[]) objJ2)).b;
                    final String string2 = aysVar2.f;
                    String str2 = aysVar2.e;
                    if (string2 == null) {
                        String strZ2 = cmz.z();
                        String strValueOf2 = String.valueOf(str2.hashCode() & Opcodes.CONST_METHOD_TYPE);
                        StringBuilder sbY2 = dkz.y(strZ2);
                        sbY2.append(cnb.z(-478961867946794L));
                        sbY2.append(strValueOf2);
                        sbY2.append('/');
                        sbY2.append(str2);
                        sbY2.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
                        sbY2.append(aysVar2.b);
                        string2 = sbY2.toString();
                    }
                    if (new File(string2).exists()) {
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(view4.getContext());
                        builder2.setTitle(cnb.z(-478880263568170L));
                        builder2.setMessage(cnb.z(-478884558535466L));
                        final int i13 = 1;
                        builder2.setPositiveButton(cnb.z(-478863083698986L), new DialogInterface.OnClickListener() { // from class: me.hd.wauxv.obf.uk
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i122) throws IllegalAccessException, InstantiationException, InvocationTargetException {
                                switch (i13) {
                                    case 0:
                                        dpv.a.getClass();
                                        arj.ah(dpv.b, string2, aysVar2.a);
                                        dnc.g(null, 3, cnb.z(-489450178083626L));
                                        break;
                                    default:
                                        dpv.a.getClass();
                                        arj.ah(dpv.b, string2, aysVar2.a);
                                        dnc.g(null, 3, cnb.z(-479305465330474L));
                                        break;
                                }
                            }
                        });
                        obj3 = null;
                        builder2.setNegativeButton(cnb.z(-478867378666282L), (DialogInterface.OnClickListener) null);
                        builder2.show();
                    } else {
                        obj3 = null;
                        dnc.g(null, 3, cnb.z(-479369889839914L));
                    }
                    bmmVar2.h(obj3);
                }
                return ensVar;
            case 24:
                ((amm) obj).c = new mj(25);
                return ensVar;
            case 25:
                bah bahVar6 = (bah) obj;
                cdj cdjVar8 = new cdj();
                uq.a.getClass();
                cdjVar8.o(ajn.ag(cnb.z(-75127567940394L)));
                cdjVar8.r(Void.TYPE);
                Class<Boolean> clsBf7 = cnf.bf(dal.b(cls));
                if (clsBf7 == null) {
                    clsBf7 = cls;
                }
                Class<Boolean> clsBf8 = cnf.bf(dal.b(cls));
                cdjVar8.q(clsBf7, clsBf8 != null ? clsBf8 : Boolean.class);
                fj fjVar3 = new fj();
                cdj cdjVar9 = new cdj();
                cdjVar9.t(cnb.z(-76476187671338L), cnb.z(-76905684400938L));
                fjVar3.f(cdjVar9);
                cdjVar8.j = fjVar3;
                bahVar6.getClass();
                bahVar6.d = cdjVar8;
                return ensVar;
            case 26:
                Object obj4 = ((List) obj).get(0);
                cge.a.getClass();
                return Boolean.valueOf(bzo.f(obj4, emn.az(cgd.a)));
            case 27:
                Object objE7 = ((bmm) obj).e();
                FrameLayout frameLayout = (FrameLayout) (!(objE7 instanceof FrameLayout) ? null : objE7);
                if (frameLayout == null) {
                    cls7 = FrameLayout.class;
                    Class<FrameLayout> clsBf9 = cnf.bf(dal.b(cls7));
                    throw new IllegalStateException("HookParam instance cannot cast to ".concat((clsBf9 != null ? clsBf9 : FrameLayout.class).getName()).toString());
                }
                for (Object obj5 : ur.b) {
                    try {
                        ((xf) obj5).n(frameLayout);
                    } catch (Exception e) {
                        ArrayList arrayList = ewq.a;
                        StringBuilder sb = new StringBuilder();
                        sb.append(cnb.z(-51075751082794L));
                        ewq.e(yg.n(sb, obj5 instanceof doo ? ((doo) obj5).f() : cnb.z(-51041391344426L), -51002736638762L), e, 12);
                    }
                }
                return ensVar;
            case 28:
                View view5 = (View) obj;
                View viewK3 = dkz.k(view5, R.layout.module_dialog_chat_group_nav, null, false);
                int i14 = R.id.moduleDialogEdtChatGroupNavActiveDarkColor;
                TextInputEditText textInputEditText11 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavActiveDarkColor);
                if (textInputEditText11 != null) {
                    i14 = R.id.moduleDialogEdtChatGroupNavActiveLightColor;
                    TextInputEditText textInputEditText12 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavActiveLightColor);
                    if (textInputEditText12 != null) {
                        i14 = R.id.moduleDialogEdtChatGroupNavIconDarkColor;
                        TextInputEditText textInputEditText13 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavIconDarkColor);
                        if (textInputEditText13 != null) {
                            i14 = R.id.moduleDialogEdtChatGroupNavIconLightColor;
                            TextInputEditText textInputEditText14 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavIconLightColor);
                            if (textInputEditText14 != null) {
                                i14 = R.id.moduleDialogEdtChatGroupNavNavDarkColor;
                                TextInputEditText textInputEditText15 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavNavDarkColor);
                                if (textInputEditText15 != null) {
                                    i14 = R.id.moduleDialogEdtChatGroupNavNavLightColor;
                                    TextInputEditText textInputEditText16 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavNavLightColor);
                                    if (textInputEditText16 != null) {
                                        i14 = R.id.moduleDialogEdtChatGroupNavTextDarkColor;
                                        TextInputEditText textInputEditText17 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavTextDarkColor);
                                        if (textInputEditText17 != null) {
                                            i14 = R.id.moduleDialogEdtChatGroupNavTextLightColor;
                                            TextInputEditText textInputEditText18 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavTextLightColor);
                                            if (textInputEditText18 != null) {
                                                i14 = R.id.moduleDialogEdtChatGroupNavWidth;
                                                TextInputEditText textInputEditText19 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupNavWidth);
                                                if (textInputEditText19 != null) {
                                                    i14 = R.id.moduleDialogEdtChatGroupTopPadding;
                                                    TextInputEditText textInputEditText20 = (TextInputEditText) cnd.aq(viewK3, R.id.moduleDialogEdtChatGroupTopPadding);
                                                    if (textInputEditText20 != null) {
                                                        i14 = R.id.moduleDialogInputChatGroupNavActiveDarkColor;
                                                        if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavActiveDarkColor)) != null) {
                                                            i14 = R.id.moduleDialogInputChatGroupNavActiveLightColor;
                                                            if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavActiveLightColor)) != null) {
                                                                i14 = R.id.moduleDialogInputChatGroupNavIconDarkColor;
                                                                if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavIconDarkColor)) != null) {
                                                                    i14 = R.id.moduleDialogInputChatGroupNavIconLightColor;
                                                                    if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavIconLightColor)) != null) {
                                                                        i14 = R.id.moduleDialogInputChatGroupNavNavDarkColor;
                                                                        if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavNavDarkColor)) != null) {
                                                                            i14 = R.id.moduleDialogInputChatGroupNavNavLightColor;
                                                                            if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavNavLightColor)) != null) {
                                                                                i14 = R.id.moduleDialogInputChatGroupNavTextDarkColor;
                                                                                if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavTextDarkColor)) != null) {
                                                                                    i14 = R.id.moduleDialogInputChatGroupNavTextLightColor;
                                                                                    if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavTextLightColor)) != null) {
                                                                                        i14 = R.id.moduleDialogInputChatGroupNavWidth;
                                                                                        if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupNavWidth)) != null) {
                                                                                            i14 = R.id.moduleDialogInputChatGroupTopPadding;
                                                                                            if (((TextInputLayout) cnd.aq(viewK3, R.id.moduleDialogInputChatGroupTopPadding)) != null) {
                                                                                                LinearLayout linearLayout3 = (LinearLayout) viewK3;
                                                                                                cei ceiVar = new cei(linearLayout3, textInputEditText11, textInputEditText12, textInputEditText13, textInputEditText14, textInputEditText15, textInputEditText16, textInputEditText17, textInputEditText18, textInputEditText19, textInputEditText20);
                                                                                                textInputEditText19.setText(String.valueOf(vc.a.k()));
                                                                                                textInputEditText20.setText(String.valueOf(vf.a.k()));
                                                                                                textInputEditText16.setText(vb.a.o());
                                                                                                textInputEditText12.setText(uw.a.o());
                                                                                                textInputEditText14.setText(uz.a.o());
                                                                                                textInputEditText18.setText(ve.a.o());
                                                                                                textInputEditText15.setText(va.a.o());
                                                                                                textInputEditText11.setText(uv.a.o());
                                                                                                textInputEditText13.setText(uy.a.o());
                                                                                                textInputEditText17.setText(vd.a.o());
                                                                                                bzy bzyVar3 = new bzy(view5.getContext());
                                                                                                eg egVar3 = (eg) bzyVar3.d;
                                                                                                vg.a.getClass();
                                                                                                egVar3.d = vg.c;
                                                                                                bzyVar3.t(cnb.z(-576393201056554L), new amw(new bp(ceiVar, 7), 0));
                                                                                                bzyVar3.s(cnb.z(-576397496023850L), new amw(new h(20), 2));
                                                                                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3, cnb.z(-47455093652266L));
                                                                                                if (linearLayout3 != null) {
                                                                                                    egVar3.r = linearLayout3;
                                                                                                }
                                                                                                bzyVar3.i().show();
                                                                                                return ensVar;
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
                throw new NullPointerException(cnb.z(-638713176521514L).concat(viewK3.getResources().getResourceName(i14)));
            default:
                ((amm) obj).c = new us(i5);
                return ensVar;
        }
    }
}
