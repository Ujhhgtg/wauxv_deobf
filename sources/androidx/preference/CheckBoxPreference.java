package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.cye;
import me.hd.wauxv.obf.emc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class CheckBoxPreference extends TwoStatePreference {
    /* JADX WARN: Illegal instructions before constructor call */
    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        int iAn = emc.an(context, R.attr.checkBoxPreferenceStyle, android.R.attr.checkBoxPreferenceStyle);
        super(context, attributeSet, iAn);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cye.a, iAn, 0);
        if (typedArrayObtainStyledAttributes.getString(5) == null) {
            typedArrayObtainStyledAttributes.getString(0);
        }
        if (typedArrayObtainStyledAttributes.getString(4) == null) {
            typedArrayObtainStyledAttributes.getString(1);
        }
        typedArrayObtainStyledAttributes.getBoolean(3, typedArrayObtainStyledAttributes.getBoolean(2, false));
        typedArrayObtainStyledAttributes.recycle();
    }
}
