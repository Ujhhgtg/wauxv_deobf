package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class erb {
    public static final LinkedHashMap a = new LinkedHashMap();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v0, types: [me.hd.wauxv.obf.dcx] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /*
     * JADX WARN: Type inference failed for: r4v3, types: [android.view.View,
     * java.lang.Object]
     */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v1 */
    public static final View b(View view, String str, int... iArr) {
        ?? X;
        Integer num;
        boolean zAk = dnj.ak(str);
        LinkedHashMap linkedHashMap = a;
        if (!zAk && (num = (Integer) linkedHashMap.get(str)) != null) {
            return view.findViewById(num.intValue());
        }
        try {
            int length = iArr.length;
            int i = 0;
            X = view;
            while (i < length) {
                int i2 = iArr[i];
                if (!(X instanceof ViewGroup) || i2 < 0 || i2 >= ((ViewGroup) X).getChildCount()) {
                    break;
                }
                i++;
                X = ((ViewGroup) X).getChildAt(i2);
            }
            if (!dnj.ak(str) && !nullSafeIsEqual(X, view)) {
                linkedHashMap.put(str, Integer.valueOf(X.getId()));
            }
            if (X == 0) {
                X = 0;
            }
        } catch (Throwable th) {
            X = FastKV.getFailureFromException(th);
        }
        return (View) (X instanceof Failure ? 0 : X);
    }
}
