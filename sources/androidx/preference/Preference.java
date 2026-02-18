package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.cvg;
import me.hd.wauxv.obf.cye;
import me.hd.wauxv.obf.emc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Preference implements Comparable<Preference> {
    public final Context f;
    public final int g;
    public final CharSequence h;
    public final CharSequence i;
    public final String j;
    public final Object k;
    public cvg l;

    public Preference(Context context, AttributeSet attributeSet, int i) {
        this.g = Integer.MAX_VALUE;
        this.f = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cye.f, i, 0);
        typedArrayObtainStyledAttributes.getResourceId(23, typedArrayObtainStyledAttributes.getResourceId(0, 0));
        String string = typedArrayObtainStyledAttributes.getString(26);
        this.j = string == null ? typedArrayObtainStyledAttributes.getString(6) : string;
        CharSequence text = typedArrayObtainStyledAttributes.getText(34);
        this.h = text == null ? typedArrayObtainStyledAttributes.getText(4) : text;
        CharSequence text2 = typedArrayObtainStyledAttributes.getText(33);
        this.i = text2 == null ? typedArrayObtainStyledAttributes.getText(7) : text2;
        this.g = typedArrayObtainStyledAttributes.getInt(28, typedArrayObtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        if (typedArrayObtainStyledAttributes.getString(22) == null) {
            typedArrayObtainStyledAttributes.getString(13);
        }
        typedArrayObtainStyledAttributes.getResourceId(27, typedArrayObtainStyledAttributes.getResourceId(3, R.layout.preference));
        typedArrayObtainStyledAttributes.getResourceId(35, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        typedArrayObtainStyledAttributes.getBoolean(21, typedArrayObtainStyledAttributes.getBoolean(2, true));
        boolean z = typedArrayObtainStyledAttributes.getBoolean(30, typedArrayObtainStyledAttributes.getBoolean(5, true));
        typedArrayObtainStyledAttributes.getBoolean(29, typedArrayObtainStyledAttributes.getBoolean(1, true));
        if (typedArrayObtainStyledAttributes.getString(19) == null) {
            typedArrayObtainStyledAttributes.getString(10);
        }
        typedArrayObtainStyledAttributes.getBoolean(16, typedArrayObtainStyledAttributes.getBoolean(16, z));
        typedArrayObtainStyledAttributes.getBoolean(17, typedArrayObtainStyledAttributes.getBoolean(17, z));
        if (typedArrayObtainStyledAttributes.hasValue(18)) {
            this.k = a(typedArrayObtainStyledAttributes, 18);
        } else if (typedArrayObtainStyledAttributes.hasValue(11)) {
            this.k = a(typedArrayObtainStyledAttributes, 11);
        }
        typedArrayObtainStyledAttributes.getBoolean(31, typedArrayObtainStyledAttributes.getBoolean(12, true));
        if (typedArrayObtainStyledAttributes.hasValue(32)) {
            typedArrayObtainStyledAttributes.getBoolean(32, typedArrayObtainStyledAttributes.getBoolean(14, true));
        }
        typedArrayObtainStyledAttributes.getBoolean(24, typedArrayObtainStyledAttributes.getBoolean(15, false));
        typedArrayObtainStyledAttributes.getBoolean(25, typedArrayObtainStyledAttributes.getBoolean(25, true));
        typedArrayObtainStyledAttributes.getBoolean(20, typedArrayObtainStyledAttributes.getBoolean(20, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public Object a(TypedArray typedArray, int i) {
        return null;
    }

    public void b() {
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i = preference2.g;
        CharSequence charSequence = preference2.h;
        int i2 = this.g;
        if (i2 != i) {
            return i2 - i;
        }
        CharSequence charSequence2 = this.h;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public CharSequence e() {
        cvg cvgVar = this.l;
        return cvgVar != null ? cvgVar.r(this) : this.i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = this.h;
        if (!TextUtils.isEmpty(charSequence)) {
            sb.append(charSequence);
            sb.append(' ');
        }
        CharSequence charSequenceE = e();
        if (!TextUtils.isEmpty(charSequenceE)) {
            sb.append(charSequenceE);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, emc.an(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
