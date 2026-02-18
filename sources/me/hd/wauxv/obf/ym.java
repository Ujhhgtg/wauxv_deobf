package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ym extends axs {
    public final /* synthetic */ Chip a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ym(Chip chip, Chip chip2) {
        super(chip2);
        this.a = chip;
    }

    @Override // me.hd.wauxv.obf.axs
    public final void _au(bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        Chip chip = this.a;
        yo yoVar = chip.d;
        accessibilityNodeInfo.setCheckable(yoVar != null && yoVar.w);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        bdVar.k(chip.getAccessibilityClassName());
        accessibilityNodeInfo.setText(chip.getText());
    }

    @Override // me.hd.wauxv.obf.axs
    public final int c(float f, float f2) {
        Rect rect = Chip.a;
        Chip chip = this.a;
        return (chip.y() && chip.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
    }

    @Override // me.hd.wauxv.obf.axs
    public final void p(ArrayList arrayList) {
        yo yoVar;
        arrayList.add(0);
        Rect rect = Chip.a;
        Chip chip = this.a;
        if (!chip.y() || (yoVar = chip.d) == null || !yoVar.q || chip.g == null) {
            return;
        }
        arrayList.add(1);
    }

    @Override // me.hd.wauxv.obf.axs
    public final boolean q(int i, int i2, Bundle bundle) {
        boolean z = false;
        if (i2 == 16) {
            Chip chip = this.a;
            if (i == 0) {
                return chip.performClick();
            }
            if (i == 1) {
                chip.playSoundEffect(0);
                View.OnClickListener onClickListener = chip.g;
                if (onClickListener != null) {
                    onClickListener.onClick(chip);
                    z = true;
                }
                if (chip.r) {
                    chip.q.ao(1, 1);
                }
            }
        }
        return z;
    }

    @Override // me.hd.wauxv.obf.axs
    public final void r(int i, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        if (i != 1) {
            accessibilityNodeInfo.setContentDescription("");
            accessibilityNodeInfo.setBoundsInParent(Chip.a);
            return;
        }
        Chip chip = this.a;
        CharSequence closeIconContentDescription = chip.getCloseIconContentDescription();
        if (closeIconContentDescription != null) {
            accessibilityNodeInfo.setContentDescription(closeIconContentDescription);
        } else {
            CharSequence text = chip.getText();
            accessibilityNodeInfo.setContentDescription(chip.getContext().getString(R.string.mtrl_chip_close_icon_content_description, TextUtils.isEmpty(text) ? "" : text).trim());
        }
        accessibilityNodeInfo.setBoundsInParent(chip.getCloseIconTouchBoundsInt());
        bdVar.e(ax.a);
        accessibilityNodeInfo.setEnabled(chip.isEnabled());
    }

    @Override // me.hd.wauxv.obf.axs
    public final void s(int i, boolean z) {
        if (i == 1) {
            Chip chip = this.a;
            chip.l = z;
            chip.refreshDrawableState();
        }
    }
}
