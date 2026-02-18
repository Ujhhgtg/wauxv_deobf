package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import com.google.android.material.slider.Slider;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class nq extends axs {
    public final Slider a;
    public final Rect b;

    public nq(Slider slider) {
        super(slider);
        this.b = new Rect();
        this.a = slider;
    }

    @Override // me.hd.wauxv.obf.axs
    public final int c(float f, float f2) {
        int i = 0;
        while (true) {
            Slider slider = this.a;
            if (i >= slider.getValues().size()) {
                return -1;
            }
            Rect rect = this.b;
            slider.cl(i, rect);
            if (rect.contains((int) f, (int) f2)) {
                return i;
            }
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.axs
    public final void p(ArrayList arrayList) {
        for (int i = 0; i < this.a.getValues().size(); i++) {
            arrayList.add(Integer.valueOf(i));
        }
    }

    @Override // me.hd.wauxv.obf.axs
    public final boolean q(int i, int i2, Bundle bundle) {
        Slider slider = this.a;
        if (!slider.isEnabled()) {
            return false;
        }
        if (i2 != 4096 && i2 != 8192) {
            if (i2 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") || !slider.cj(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                return false;
            }
            slider.cm();
            slider.postInvalidate();
            ak(i);
            return true;
        }
        float fRound = slider.av;
        if (fRound == 0.0f) {
            fRound = 1.0f;
        }
        if ((slider.ar - slider.aq) / fRound > 20) {
            fRound *= Math.round(r1 / r4);
        }
        if (i2 == 8192) {
            fRound = -fRound;
        }
        if (slider.cb()) {
            fRound = -fRound;
        }
        if (!slider.cj(i, cnf.ar(slider.getValues().get(i).floatValue() + fRound, slider.getValueFrom(), slider.getValueTo()))) {
            return false;
        }
        slider.cm();
        slider.postInvalidate();
        ak(i);
        return true;
    }

    @Override // me.hd.wauxv.obf.axs
    public final void r(int i, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        bdVar.e(ax.j);
        Slider slider = this.a;
        List<Float> values = slider.getValues();
        Float f = values.get(i);
        float fFloatValue = f.floatValue();
        float valueFrom = slider.getValueFrom();
        float valueTo = slider.getValueTo();
        if (slider.isEnabled()) {
            if (fFloatValue > valueFrom) {
                bdVar.d(8192);
            }
            if (fFloatValue < valueTo) {
                bdVar.d(4096);
            }
        }
        accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, fFloatValue));
        bdVar.k(SeekBar.class.getName());
        StringBuilder sb = new StringBuilder();
        if (slider.getContentDescription() != null) {
            sb.append(slider.getContentDescription());
            sb.append(",");
        }
        String str = String.format(((float) ((int) fFloatValue)) == fFloatValue ? "%.0f" : "%.2f", f);
        String string = slider.getContext().getString(R.string.material_slider_value);
        if (values.size() > 1) {
            string = i == slider.getValues().size() - 1 ? slider.getContext().getString(R.string.material_slider_range_end) : i == 0 ? slider.getContext().getString(R.string.material_slider_range_start) : "";
        }
        Locale locale = Locale.US;
        sb.append(string + ", " + str);
        accessibilityNodeInfo.setContentDescription(sb.toString());
        Rect rect = this.b;
        slider.cl(i, rect);
        accessibilityNodeInfo.setBoundsInParent(rect);
    }
}
