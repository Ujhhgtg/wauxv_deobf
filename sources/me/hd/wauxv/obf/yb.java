package me.hd.wauxv.obf;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class yb extends AccessibilityDelegateCompat {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ yb(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void onInitializeAccessibilityNodeInfo(View view, bd bdVar) {
        int i = this.a;
        Object obj = this.b;
        View.AccessibilityDelegate accessibilityDelegate = this.accessibilityDelegate;
        switch (i) {
            case 0:
                AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                accessibilityNodeInfo.setCheckable(checkableImageButton.c);
                accessibilityNodeInfo.setChecked(checkableImageButton.b);
                break;
            case 1:
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, bdVar.a);
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                int i2 = MaterialButtonToggleGroup.a;
                int i3 = -1;
                if (view instanceof MaterialButton) {
                    int i4 = 0;
                    for (int i5 = 0; i5 < materialButtonToggleGroup.getChildCount(); i5++) {
                        if (materialButtonToggleGroup.getChildAt(i5) == view) {
                            i3 = i4;
                        } else {
                            if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.n(i5)) {
                                i4++;
                            }
                        }
                    }
                }
                bdVar.l(bc.g(0, 1, i3, 1, ((MaterialButton) view).n));
                break;
            case 2:
                AccessibilityNodeInfo accessibilityNodeInfo2 = bdVar.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                cal calVar = (cal) obj;
                accessibilityNodeInfo2.setHintText(calVar.r.getVisibility() == 0 ? calVar.dc().getResources().getString(R.string.mtrl_picker_toggle_to_year_selection) : calVar.dc().getResources().getString(R.string.mtrl_picker_toggle_to_day_selection));
                break;
            default:
                AccessibilityNodeInfo accessibilityNodeInfo3 = bdVar.a;
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                accessibilityNodeInfo3.setCheckable(((NavigationMenuItemView) obj).d);
                break;
        }
    }

    @Override // me.hd.wauxv.obf.aq
    public void initializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        switch (this.a) {
            case 0:
                super.initializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setChecked(((CheckableImageButton) this.b).b);
                break;
            default:
                super.initializeAccessibilityEvent(view, accessibilityEvent);
                break;
        }
    }
}
