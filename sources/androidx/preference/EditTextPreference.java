package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.cye;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.nu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iAn = emc.an(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iAn);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cye.c, iAn, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            if (nu.a == null) {
                nu.a = new nu(22);
            }
            this.l = nu.a;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }
}
