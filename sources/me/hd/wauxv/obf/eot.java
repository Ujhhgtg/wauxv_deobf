package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eot {
    public static final char[] a = "0123456789abcdef".toCharArray();
    public static final char[] b = new char[64];
    public static volatile Handler c;

    public static void d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean e(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int f(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int g(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = eos.a[config.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 3) {
                return i != 4 ? 4 : 8;
            }
        }
        return i2;
    }

    public static ArrayList h(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Handler i() {
        if (c == null) {
            synchronized (eot.class) {
                try {
                    if (c == null) {
                        c = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return c;
    }

    public static int j(int i, int i2) {
        return (i2 * 31) + i;
    }

    public static int k(int i, Object obj) {
        return j(obj == null ? 0 : obj.hashCode(), i);
    }

    public static boolean l(int i, int i2) {
        if (i > 0 || i == Integer.MIN_VALUE) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }
        return false;
    }
}
