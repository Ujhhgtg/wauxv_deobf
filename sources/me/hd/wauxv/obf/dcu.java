package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dcu {
    public static final ThreadLocal a = new ThreadLocal();
    public static final WeakHashMap b = new WeakHashMap(0);
    public static final Object c = new Object();

    public static Typeface d(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Found duplicated region for block: B:39:0x00c9  */
    public static Typeface e(Context context, int i, TypedValue typedValue, int i2, bht bhtVar, boolean z, boolean z2) throws Exception {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceD = null;
        if (string.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            byj byjVar = emf.b;
            Typeface typeface = (Typeface) byjVar.o(emf.e(resources, i, string, i3, i2));
            if (typeface != null) {
                if (bhtVar != null) {
                    new Handler(Looper.getMainLooper()).post(new hl(bhtVar, 7, typeface));
                }
                typefaceD = typeface;
            } else if (!z2) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        bca bcaVarAi = cmz.ai(resources.getXml(i), resources);
                        if (bcaVarAi == null) {
                            Log.e("ResourcesCompat", "Failed to find font-family tag");
                            if (bhtVar != null) {
                                bhtVar.ai(-3);
                            }
                        } else {
                            typefaceD = emf.d(context, bcaVarAi, resources, i, string, typedValue.assetCookie, i2, bhtVar, z);
                        }
                    } else {
                        int i4 = typedValue.assetCookie;
                        Typeface typefaceU = emf.a.u(context, resources, i, string, i2);
                        if (typefaceU != null) {
                            byjVar.v(emf.e(resources, i, string, i4, i2), typefaceU);
                        }
                        if (bhtVar != null) {
                            if (typefaceU != null) {
                                new Handler(Looper.getMainLooper()).post(new hl(bhtVar, 7, typefaceU));
                            } else {
                                bhtVar.ai(-3);
                            }
                        }
                        typefaceD = typefaceU;
                    }
                } catch (IOException e) {
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e);
                    if (bhtVar != null) {
                        bhtVar.ai(-3);
                    }
                } catch (XmlPullParserException e2) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e2);
                    if (bhtVar != null) {
                        bhtVar.ai(-3);
                    }
                }
            }
        } else if (bhtVar != null) {
            bhtVar.ai(-3);
        }
        if (typefaceD != null || bhtVar != null || z2) {
            return typefaceD;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }
}
