package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class emg extends StaticHelpers7 {
    public static Class a;
    public static Constructor b;
    public static Method c;
    public static Method g;
    public static boolean h;
    public final Class i;
    public final Constructor j;
    public final Method k;
    public final Method l;
    public final Method m;
    public final Method n;
    public final Method o;

    public emg() throws NoSuchMethodException {
        Method methodY;
        Constructor<?> constructor;
        Method methodR;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodR = r(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodY = y(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl",
                    "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            methodY = null;
            constructor = null;
            methodR = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.i = cls;
        this.j = constructor;
        this.k = methodR;
        this.l = method;
        this.m = method2;
        this.n = method3;
        this.o = methodY;
    }

    public static boolean p(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        q();
        try {
            return ((Boolean) c.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void q() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (h) {
            return;
        }
        h = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        b = constructor;
        a = cls;
        c = method2;
        g = method;
    }

    public static Method r(Class cls) {
        Class cls2 = Boolean.TYPE;
        Class cls3 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls3, cls2, cls3, cls3, cls3,
                FontVariationAxis[].class);
    }

    @Override // me.hd.wauxv.obf.emn
    public final Typeface s(Context context, bcb bcbVar, Resources resources, int i)
            throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.k;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl",
                    "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            try {
                objNewInstance = this.j.newInstance(null);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                objNewInstance = null;
            }
            if (objNewInstance != null) {
                bcc[] bccVarArr = bcbVar.a;
                int length = bccVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    bcc bccVar = bccVarArr[i2];
                    Context context2 = context;
                    if (v(context2, objNewInstance, bccVar.a, bccVar.e, bccVar.b, bccVar.c ? 1 : 0,
                            FontVariationAxis.fromFontVariationSettings(bccVar.d))) {
                        i2++;
                        context = context2;
                    } else {
                        try {
                            this.n.invoke(objNewInstance, null);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    }
                }
                if (x(objNewInstance)) {
                    return w(objNewInstance);
                }
            }
            return null;
        }
        q();
        try {
            Object objNewInstance2 = b.newInstance(null);
            for (bcc bccVar2 : bcbVar.a) {
                File fileAi = ewz.ai(context);
                if (fileAi == null) {
                    return null;
                }
                try {
                } catch (RuntimeException unused3) {
                } finally {
                    fileAi.delete();
                }
                if (!ewz.ad(fileAi, resources, bccVar2.f)
                        || !p(objNewInstance2, fileAi.getPath(), bccVar2.b, bccVar2.c)) {
                    return null;
                }
                fileAi.delete();
            }
            q();
            try {
                Object objNewInstance3 = Array.newInstance((Class<?>) a, 1);
                Array.set(objNewInstance3, 0, objNewInstance2);
                return (Typeface) g.invoke(null, objNewInstance3);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // me.hd.wauxv.obf.emn
    public final Typeface t(Context context, bce[] bceVarArr, int i) throws IOException {
        Object objNewInstance;
        Typeface typefaceW;
        boolean zBooleanValue;
        if (bceVarArr.length >= 1) {
            Method method = this.k;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl",
                        "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap map = new HashMap();
                    for (bce bceVar : bceVarArr) {
                        if (bceVar.f == 0) {
                            Uri uri = bceVar.a;
                            if (!map.containsKey(uri)) {
                                map.put(uri, ewz.trimStackTraceToClass(context, uri));
                            }
                        }
                    }
                    Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
                    try {
                        objNewInstance = this.j.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        objNewInstance = null;
                    }
                    if (objNewInstance != null) {
                        int length = bceVarArr.length;
                        int i2 = 0;
                        boolean z = false;
                        while (true) {
                            Method method2 = this.n;
                            if (i2 >= length) {
                                if (!z) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                if (!x(objNewInstance) || (typefaceW = w(objNewInstance)) == null) {
                                    break;
                                    break;
                                }
                                return Typeface.create(typefaceW, i);
                            }
                            bce bceVar2 = bceVarArr[i2];
                            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(bceVar2.a);
                            if (byteBuffer != null) {
                                try {
                                    zBooleanValue = ((Boolean) this.l.invoke(objNewInstance, byteBuffer,
                                            Integer.valueOf(bceVar2.b), null, Integer.valueOf(bceVar2.c),
                                            Integer.valueOf(bceVar2.d ? 1 : 0))).booleanValue();
                                } catch (IllegalAccessException | InvocationTargetException unused2) {
                                    zBooleanValue = false;
                                }
                                if (!zBooleanValue) {
                                    method2.invoke(objNewInstance, null);
                                    break;
                                }
                                z = true;
                            }
                            i2++;
                            z = z;
                        }
                    }
                } else {
                    bce bceVar_cf = _cf(bceVarArr, i);
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver()
                            .openFileDescriptor(bceVar_cf.a, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        try {
                            Typeface typefaceBuild = new Typeface.Builder(
                                    parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bceVar_cf.c)
                                    .setItalic(bceVar_cf.d).build();
                            parcelFileDescriptorOpenFileDescriptor.close();
                            return typefaceBuild;
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.emn
    public final Typeface u(Context context, Resources resources, int i, String str, int i2)
            throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance;
        Method method = this.k;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl",
                    "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.u(context, resources, i, str, i2);
        }
        try {
            objNewInstance = this.j.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            objNewInstance = null;
        }
        if (objNewInstance != null) {
            if (!v(context, objNewInstance, str, 0, -1, -1, null)) {
                try {
                    this.n.invoke(objNewInstance, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (x(objNewInstance)) {
                return w(objNewInstance);
            }
        }
        return null;
    }

    public final boolean v(Context context, Object obj, String str, int i, int i2, int i3,
            FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.k.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i),
                    Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface w(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.i, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.o.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean x(Object obj) {
        try {
            return ((Boolean) this.m.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method y(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
