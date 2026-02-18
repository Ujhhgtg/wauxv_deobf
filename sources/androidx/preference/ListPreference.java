package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.awp;
import me.hd.wauxv.obf.cvg;
import me.hd.wauxv.obf.cye;
import me.hd.wauxv.obf.emc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public final CharSequence[] c;
    public final String d;

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cye.d, i, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.c = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        if (typedArrayObtainStyledAttributes.getTextArray(3) == null) {
            typedArrayObtainStyledAttributes.getTextArray(1);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            if (awp.a == null) {
                awp.a = new awp(24);
            }
            this.l = awp.a;
            b();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, cye.f, i, 0);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.d = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final CharSequence e() {
        cvg cvgVar = this.l;
        if (cvgVar != null) {
            return cvgVar.r(this);
        }
        CharSequence charSequenceE = super.e();
        String str = this.d;
        if (str != null) {
            String str2 = String.format(str, "");
            if (!TextUtils.equals(str2, charSequenceE)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceE;
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, emc.an(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
