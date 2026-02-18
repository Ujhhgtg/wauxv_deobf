package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class jw {
    public static final Class[] f = {Context.class, AttributeSet.class};
    public static final int[] g = {R.attr.onClick};
    public static final int[] h = {R.attr.accessibilityHeading};
    public static final int[] i = {R.attr.accessibilityPaneTitle};
    public static final int[] j = {R.attr.screenReaderFocusable};
    public static final String[] k = {"android.widget.", "android.view.", "android.webkit."};
    public static final dhq l = new dhq(0);
    public final Object[] m = new Object[2];

    public hc a(Context context, AttributeSet attributeSet) {
        return new hc(context, attributeSet);
    }

    public hd b(Context context, AttributeSet attributeSet) {
        return new hd(context, attributeSet, me.hd.wauxv.R.attr.buttonStyle);
    }

    public hf c(Context context, AttributeSet attributeSet) {
        return new hf(context, attributeSet, me.hd.wauxv.R.attr.checkboxStyle);
    }

    public ip d(Context context, AttributeSet attributeSet) {
        return new ip(context, attributeSet, 0);
    }

    public jp e(Context context, AttributeSet attributeSet) {
        return new jp(context, attributeSet);
    }

    public final View n(Context context, String str, String str2) {
        String strConcat;
        dhq dhqVar = l;
        Constructor constructor = (Constructor) dhqVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f);
            dhqVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.m);
    }
}
