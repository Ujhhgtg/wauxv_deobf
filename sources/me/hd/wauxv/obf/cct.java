package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cct {
    public final ArrayList a;
    public final DialogXBaseRelativeLayout b;
    public final MaxRelativeLayout c;
    public final TextView d;
    public final TextView e;
    public final ViewGroup f;
    public final RelativeLayout g;
    public final EditText h;
    public final LinearLayout i;
    public final TextView j;
    public final View k;
    public final View l;
    public final TextView m;
    public final TextView n;
    public final /* synthetic */ ccu o;

    public cct(ccu ccuVar, View view) {
        this.o = ccuVar;
        if (view == null) {
            return;
        }
        ccuVar.getClass();
        ccuVar.g = new WeakReference(view);
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
        this.b = dialogXBaseRelativeLayout;
        this.c = (MaxRelativeLayout) view.findViewById(R.id.bkg);
        TextView textView = (TextView) view.findViewById(R.id.txt_dialog_title);
        this.d = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.txt_dialog_tip);
        this.e = textView2;
        this.f = (ViewGroup) view.findViewById(R.id.box_list);
        this.g = (RelativeLayout) view.findViewById(R.id.box_custom);
        this.h = (EditText) view.findViewById(R.id.txt_input);
        this.i = (LinearLayout) view.findViewById(R.id.box_button);
        TextView textView3 = (TextView) view.findViewById(R.id.btn_selectOther);
        this.j = textView3;
        this.k = view.findViewById(R.id.space_other_button);
        this.l = view.findViewWithTag("split");
        TextView textView4 = (TextView) view.findViewById(R.id.btn_selectNegative);
        this.m = textView4;
        TextView textView5 = (TextView) view.findViewById(R.id.btn_selectPositive);
        this.n = textView5;
        this.a = ng.z(view);
        ccuVar.ar().setTranslationZ(0);
        bht bhtVar = anj.a;
        TextPaint paint = textView.getPaint();
        int i = 1;
        paint.setFakeBoldText(true);
        textView4.getPaint().setFakeBoldText(true);
        textView5.getPaint().setFakeBoldText(true);
        textView3.getPaint().setFakeBoldText(true);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        dialogXBaseRelativeLayout.s(0.0f);
        dialogXBaseRelativeLayout.t(ccuVar.bd);
        dialogXBaseRelativeLayout.g = new bfl(this, i);
        dialogXBaseRelativeLayout.h = new bmu(this);
        textView5.setOnClickListener(new ccr(this, 0));
        textView4.setOnClickListener(new ccr(this, i));
        textView3.setOnClickListener(new ccr(this, 2));
        ccuVar.bl = this;
        r();
    }

    public final void p(View view) {
        ccu ccuVar = this.o;
        ccuVar.getClass();
        if (view != null) {
            view.setEnabled(false);
        }
        if (ccuVar.as() == null || ccuVar.u) {
            return;
        }
        int i = 1;
        if (ccuVar.be == null) {
            ccuVar.be = new bfk(this, i);
        }
        bfk bfkVar = ccuVar.be;
        if (bfkVar != null) {
            ccuVar.u = true;
            if (bfkVar == null) {
                ccuVar.be = new bfk(this, i);
            }
            ccuVar.be.ap(ccuVar);
            dc dcVar = new dc(this, 13);
            long jQ = q(null);
            if (jQ < 0) {
                return;
            }
            bht bhtVar = anj.a;
            ng.ac().postDelayed(dcVar, jQ);
        }
    }

    public final long q(Animation animation) {
        if (animation == null) {
            MaxRelativeLayout maxRelativeLayout = this.c;
            if (maxRelativeLayout.getAnimation() != null) {
                animation = maxRelativeLayout.getAnimation();
            }
        }
        long duration = (animation == null || animation.getDuration() == 0) ? 300L : animation.getDuration();
        long j = this.o.r;
        return j != -1 ? j : duration;
    }

    public final void r() {
        int color;
        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = this.b;
        if (dialogXBaseRelativeLayout != null) {
            ccu ccuVar = this.o;
            Activity activityAs = ccuVar.as();
            bht bhtVar = ccuVar.o;
            if (activityAs == null) {
                return;
            }
            dialogXBaseRelativeLayout.d = ccuVar.k;
            int[] iArr = ccuVar.t;
            int i = iArr[0];
            int i2 = iArr[1];
            int i3 = 2;
            int i4 = iArr[2];
            int i5 = 3;
            int i6 = iArr[3];
            int[] iArr2 = dialogXBaseRelativeLayout.r;
            iArr2[0] = i;
            iArr2[1] = i2;
            iArr2[2] = i4;
            iArr2[3] = i6;
            bht bhtVar2 = anj.a;
            MaxRelativeLayout maxRelativeLayout = this.c;
            maxRelativeLayout.getClass();
            int i7 = ccuVar.s;
            if (i7 == 0) {
                i7 = 0;
            }
            if (i7 > 0) {
                maxRelativeLayout.c = i7;
            }
            maxRelativeLayout.setMinimumWidth(0);
            maxRelativeLayout.setMinimumHeight(0);
            View viewFindViewWithTag = dialogXBaseRelativeLayout.findViewWithTag("dialogx_editbox");
            boolean z = ccuVar.bd instanceof bpo;
            EditText editText = this.h;
            int i8 = 8;
            if (z) {
                if (viewFindViewWithTag != null) {
                    viewFindViewWithTag.setVisibility(0);
                }
                editText.setVisibility(0);
                if (editText != dialogXBaseRelativeLayout) {
                    dialogXBaseRelativeLayout.n = new WeakReference(editText);
                }
            } else {
                if (viewFindViewWithTag != null) {
                    viewFindViewWithTag.setVisibility(8);
                }
                editText.setVisibility(8);
            }
            dialogXBaseRelativeLayout.setClickable(true);
            if (ccuVar.bj > -1.0f) {
                maxRelativeLayout.setOutlineProvider(new yl(this, i3));
                maxRelativeLayout.setClipToOutline(true);
                ArrayList arrayList = this.a;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        ((View) it.next()).getClass();
                        throw new ClassCastException();
                    }
                }
            }
            String str = ccuVar.bf;
            if (str == null) {
                str = null;
            }
            ng.al(this.d, str);
            ng.al(this.e, ccuVar.bg);
            String str2 = ccuVar.bh;
            TextView textView = this.n;
            ng.al(textView, str2);
            TextView textView2 = this.m;
            ng.al(textView2, null);
            TextView textView3 = this.j;
            ng.al(textView3, null);
            editText.setText(ccuVar.bi);
            editText.setHint((CharSequence) null);
            View view = this.k;
            if (view != null) {
                view.setVisibility(8);
            }
            LinearLayout linearLayout = this.i;
            if (linearLayout != null) {
                linearLayout.setVisibility(((textView2 == null || textView2.getVisibility() != 0) && (textView3 == null || textView3.getVisibility() != 0) && (textView == null || textView.getVisibility() != 0)) ? 8 : 0);
            }
            ng.ah(ccuVar.bh);
            View view2 = this.l;
            if (view2 != null) {
                ccuVar.ax();
                bhtVar.getClass();
                if (ng.aa() == null) {
                    ng.y("DialogX 未初始化(E7)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                    color = -16777216;
                } else {
                    color = ccuVar.at().getColor(0);
                }
                view2.setBackgroundColor(color);
            }
            linearLayout.setOrientation(0);
            bhtVar.aj();
            if (bhtVar.aj().length != 0) {
                linearLayout.removeAllViews();
                int[] iArrAj = bhtVar.aj();
                int length = iArrAj.length;
                int i9 = 0;
                while (i9 < length) {
                    int i10 = iArrAj[i9];
                    if (i10 == 1) {
                        linearLayout.addView(textView);
                        bhtVar.al();
                        textView.setBackgroundResource(bhtVar.al().ad(ccuVar.ax()));
                    } else if (i10 == i3) {
                        linearLayout.addView(textView2);
                        bhtVar.al();
                        textView2.setBackgroundResource(bhtVar.al().ac(ccuVar.ax()));
                    } else if (i10 == i5) {
                        linearLayout.addView(textView3);
                        bhtVar.al();
                        textView3.setBackgroundResource(bhtVar.al().ae(ccuVar.ax()));
                    } else if (i10 != 4) {
                        if (i10 == 5 && linearLayout.getChildCount() >= 1 && linearLayout.getChildAt(linearLayout.getChildCount() - 1).getVisibility() != i8) {
                            View view3 = new View(ccuVar.as());
                            Resources resourcesAt = ccuVar.at();
                            ccuVar.ax();
                            bhtVar.getClass();
                            view3.setBackgroundColor(resourcesAt.getColor(0));
                            bhtVar.getClass();
                            linearLayout.addView(view3, new LinearLayout.LayoutParams(1, -1));
                        }
                    } else if (linearLayout.getChildCount() >= 1 && linearLayout.getChildAt(linearLayout.getChildCount() - 1).getVisibility() != 8) {
                        Space space = new Space(ccuVar.as());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        layoutParams.weight = 1.0f;
                        linearLayout.addView(space, layoutParams);
                    }
                    i9++;
                    i3 = 2;
                    i5 = 3;
                    i8 = 8;
                }
            }
            if (!ccuVar.bc) {
                dialogXBaseRelativeLayout.setClickable(false);
            } else if (ccuVar.ba()) {
                dialogXBaseRelativeLayout.setOnClickListener(new ccr(this, 3));
            } else {
                dialogXBaseRelativeLayout.setOnClickListener(null);
            }
            this.g.setVisibility(8);
        }
    }
}
