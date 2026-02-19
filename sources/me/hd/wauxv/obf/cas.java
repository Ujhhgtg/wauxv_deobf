package me.hd.wauxv.obf;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cas<S> extends anc {
    public final LinkedHashSet an;
    public final LinkedHashSet ao;
    public int aq;
    public cti dg;
    public st dh;
    public cal di;
    public int dj;
    public CharSequence dk;
    public boolean dl;
    public int dm;
    public int dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public CharSequence f2do;
    public int dp;
    public CharSequence dq;
    public int dr;
    public CharSequence ds;
    public int dt;
    public CharSequence du;
    public TextView dv;
    public CheckableImageButton dw;
    public cau dx;
    public boolean dy;
    public CharSequence dz;
    public CharSequence ea;

    public cas() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.an = new LinkedHashSet();
        this.ao = new LinkedHashSet();
    }

    public static int eb(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        Calendar calendarC = eoq.c();
        calendarC.set(5, 1);
        Calendar calendarB = eoq.b(calendarC);
        calendarB.get(2);
        calendarB.get(1);
        int maximum = calendarB.getMaximum(7);
        calendarB.getActualMaximum(5);
        calendarB.getTimeInMillis();
        return yg.b(maximum, 1, resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding), (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * maximum) + (dimensionPixelOffset * 2));
    }

    public static boolean ec(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(cmz.an(context, R.attr.materialCalendarStyle, cal.class.getCanonicalName()).data, new int[]{i});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    @Override // me.hd.wauxv.obf.anc, me.hd.wauxv.obf.bdj
    public final void ab() {
        cti ctiVar;
        Integer numValueOf;
        super.ab();
        Window window = al().getWindow();
        if (this.dl) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.dx);
            if (!this.dy) {
                View viewFindViewById = dd().findViewById(R.id.fullscreen_header);
                ColorStateList colorStateListX = cmz.x(viewFindViewById.getBackground());
                Integer numValueOf2 = colorStateListX != null ? Integer.valueOf(colorStateListX.getDefaultColor()) : null;
                boolean z = numValueOf2 == null || numValueOf2.intValue() == 0;
                Context context = window.getContext();
                TypedValue typedValueAl = cmz.al(context, android.R.attr.colorBackground);
                if (typedValueAl != null) {
                    int i = typedValueAl.resourceId;
                    numValueOf = Integer.valueOf(i != 0 ? context.getColor(i) : typedValueAl.data);
                } else {
                    numValueOf = null;
                }
                int iIntValue = numValueOf != null ? numValueOf.intValue() : -16777216;
                if (z) {
                    numValueOf2 = Integer.valueOf(iIntValue);
                }
                ResourcesCompat.ac(window, false);
                window.getContext();
                window.getContext();
                window.setStatusBarColor(0);
                window.setNavigationBarColor(0);
                boolean z2 = cna.ab(0) || cna.ab(numValueOf2.intValue());
                cbm cbmVar = new cbm(window.getDecorView(), 24);
                int i2 = Build.VERSION.SDK_INT;
                (i2 >= 35 ? new evv(window, cbmVar) : i2 >= 30 ? new evu(window, cbmVar) : new evs(window, cbmVar)).ao(z2);
                boolean z3 = cna.ab(0) || cna.ab(iIntValue);
                cbm cbmVar2 = new cbm(window.getDecorView(), 24);
                int i3 = Build.VERSION.SDK_INT;
                (i3 >= 35 ? new evv(window, cbmVar2) : i3 >= 30 ? new evu(window, cbmVar2) : new evs(window, cbmVar2)).an(z3);
                int paddingTop = viewFindViewById.getPaddingTop();
                int i4 = viewFindViewById.getLayoutParams().height;
                or orVar = new or();
                orVar.a = i4;
                orVar.b = viewFindViewById;
                orVar.c = paddingTop;
                WeakHashMap weakHashMap = ViewCompat.a;
                eqq.l(viewFindViewById, orVar);
                this.dy = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = dc().getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.dx, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new bpr(al(), rect));
        }
        dc();
        int i5 = this.aq;
        if (i5 == 0) {
            ed();
            throw null;
        }
        ed();
        st stVar = this.dh;
        cal calVar = new cal();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i5);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", stVar);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", stVar.d);
        calVar.df(bundle);
        this.di = calVar;
        if (this.dm == 1) {
            ctiVar = calVar;
            ed();
            st stVar2 = this.dh;
            cax caxVar = new cax();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i5);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", stVar2);
            caxVar.df(bundle2);
            ctiVar = caxVar;
        }
        ctiVar = calVar;
        this.dg = ctiVar;
        this.dv.setText((this.dm == 1 && dc().getResources().getConfiguration().orientation == 2) ? this.ea : this.dz);
        ed();
        throw null;
    }

    @Override // me.hd.wauxv.obf.anc, me.hd.wauxv.obf.bdj
    public final void ac() {
        this.dg.u.clear();
        super.ac();
    }

    @Override // me.hd.wauxv.obf.anc
    public final Dialog ah() {
        Context contextDc = dc();
        dc();
        int i = this.aq;
        if (i == 0) {
            ed();
            throw null;
        }
        Dialog dialog = new Dialog(contextDc, i);
        Context context = dialog.getContext();
        this.dl = ec(context, android.R.attr.windowFullscreen);
        this.dx = new cau(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, cxs.t, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        int color = typedArrayObtainStyledAttributes.getColor(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.dx.dx(context);
        this.dx.dz(ColorStateList.valueOf(color));
        cau cauVar = this.dx;
        View decorView = dialog.getWindow().getDecorView();
        WeakHashMap weakHashMap = ViewCompat.a;
        cauVar.dy(eqq.e(decorView));
        return dialog;
    }

    public final void ed() {
        if (this.ax.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // me.hd.wauxv.obf.anc, me.hd.wauxv.obf.bdj
    public final void f(Bundle bundle) {
        super.f(bundle);
        if (bundle == null) {
            bundle = this.ax;
        }
        this.aq = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.dh = (st) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.dj = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.dk = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.dm = bundle.getInt("INPUT_MODE_KEY");
        this.dn = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f2do = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.dp = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.dq = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.dr = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.ds = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.dt = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.du = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence text = this.dk;
        if (text == null) {
            text = dc().getResources().getText(this.dj);
        }
        this.dz = text;
        if (text != null) {
            CharSequence[] charSequenceArrSplit = TextUtils.split(String.valueOf(text), "\n");
            if (charSequenceArrSplit.length > 1) {
                text = charSequenceArrSplit[0];
            }
        } else {
            text = null;
        }
        this.ea = text;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final View g(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(this.dl ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.dl) {
            viewInflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(eb(context), -2));
        } else {
            viewInflate.findViewById(R.id.mtrl_calendar_main_pane).setLayoutParams(new LinearLayout.LayoutParams(eb(context), -1));
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.mtrl_picker_header_selection_text);
        WeakHashMap weakHashMap = ViewCompat.a;
        textView.setAccessibilityLiveRegion(1);
        this.dw = (CheckableImageButton) viewInflate.findViewById(R.id.mtrl_picker_header_toggle);
        this.dv = (TextView) viewInflate.findViewById(R.id.mtrl_picker_title_text);
        this.dw.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.dw;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_checked}, cmz.y(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], cmz.y(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.dw.setChecked(this.dm != 0);
        ViewCompat.setAccessibilityDelegate(this.dw, null);
        CheckableImageButton checkableImageButton2 = this.dw;
        this.dw.setContentDescription(this.dm == 1 ? checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton2.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode));
        this.dw.setOnClickListener(new bq(this, 9));
        ed();
        throw null;
    }

    @Override // me.hd.wauxv.obf.anc, me.hd.wauxv.obf.bdj
    public final void j(Bundle bundle) {
        super.j(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.aq);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        st stVar = this.dh;
        ss ssVar = new ss();
        int i = ss.a;
        int i2 = ss.a;
        long j = stVar.a.f;
        long j2 = stVar.b.f;
        ssVar.b = Long.valueOf(stVar.d.f);
        int i3 = stVar.e;
        ajk ajkVar = stVar.c;
        cal calVar = this.di;
        cet cetVar = calVar == null ? null : calVar.c;
        if (cetVar != null) {
            ssVar.b = Long.valueOf(cetVar.f);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", ajkVar);
        cet cetVarI = cet.i(j);
        cet cetVarI2 = cet.i(j2);
        ajk ajkVar2 = (ajk) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = ssVar.b;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new st(cetVarI, cetVarI2, ajkVar2, l == null ? null : cet.i(l.longValue()), i3));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.dj);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.dk);
        bundle.putInt("INPUT_MODE_KEY", this.dm);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.dn);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f2do);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.dp);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.dq);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.dr);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.ds);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.dt);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.du);
    }

    @Override // me.hd.wauxv.obf.anc, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.an.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
    }

    @Override // me.hd.wauxv.obf.anc, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.ao.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) this.bz;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }
}
