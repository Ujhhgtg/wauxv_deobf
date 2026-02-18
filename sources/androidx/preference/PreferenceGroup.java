package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import me.hd.wauxv.obf.cye;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        new Handler(Looper.getMainLooper());
        new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cye.g, i, 0);
        typedArrayObtainStyledAttributes.getBoolean(2, typedArrayObtainStyledAttributes.getBoolean(2, true));
        if (typedArrayObtainStyledAttributes.hasValue(1) && typedArrayObtainStyledAttributes.getInt(1, typedArrayObtainStyledAttributes.getInt(1, Integer.MAX_VALUE)) != Integer.MAX_VALUE && TextUtils.isEmpty(this.j)) {
            Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
    }
}
