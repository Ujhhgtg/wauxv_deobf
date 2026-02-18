package me.hd.wauxv.obf;

import android.R;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.material.appbar.AppBarLayout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cmz {
    public static final cwa a = new cwa("list-item-type");
    public static final cwa b = new cwa("bullet-list-item-level");
    public static final cwa c = new cwa("ordered-list-item-number");
    public static final cwa d = new cwa("heading-level");
    public static final cwa e = new cwa("link-destination");
    public static final cwa f = new cwa("paragraph-is-in-tight-list");
    public static final cwa g = new cwa("code-block-info");
    public static final int[] h = {R.attr.theme, me.hd.wauxv.R.attr.theme};
    public static final int[] i = {me.hd.wauxv.R.attr.materialThemeOverlay};
    public static final int[] j = {R.attr.stateListAnimator};

    public static final void aa(ahh ahhVar, Throwable th) {
        Throwable runtimeException;
        Iterator it = ahl.a.iterator();
        while (it.hasNext()) {
            try {
                ((ahk) it.next()).f(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    aye.j(runtimeException, th);
                }
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, runtimeException);
            }
        }
        try {
            aye.j(th, new amt(ahhVar));
        } catch (Throwable unused) {
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }

    public static afw ab(afw afwVar) {
        bzo.q(afwVar, "<this>");
        afx afxVar = afwVar instanceof afx ? (afx) afwVar : null;
        if (afxVar == null || (afwVar = afxVar.n) != null) {
            return afwVar;
        }
        ahh ahhVar = afxVar.m;
        bzo.n(ahhVar);
        afy afyVar = (afy) ahhVar._w(arj.a);
        afw aorVar = afyVar != null ? new aor((ahj) afyVar, afxVar) : afxVar;
        afxVar.n = aorVar;
        return aorVar;
    }

    public static boolean ac(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final void ad(String str) {
        bzo.q(str, "key");
        throw new IllegalArgumentException(bjs.o("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static boolean ae(File file) {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            return (parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile();
        }
        return false;
    }

    public static long af(int i2, boolean z, boolean z2, boolean z3) {
        l(i2);
        l(0);
        return (z ? 274877906944L : 0L) | (((long) i2) + (((long) 0) << 19)) | (z2 ? 549755813888L : 0L) | (z3 ? 2199023255552L : 0L);
    }

    public static void ag(File file, File file2) {
        if (!file.exists() || file2.exists() || file.renameTo(file2)) {
            return;
        }
        byte[] bArrV = v(file);
        try {
            int length = bArrV.length;
            File file3 = new File(file2.getParent(), file2.getName() + ".tmp");
            if (ae(file3)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                try {
                    randomAccessFile.setLength(length);
                    randomAccessFile.write(bArrV, 0, length);
                    randomAccessFile.getFD().sync();
                    randomAccessFile.close();
                    if (!file3.renameTo(file2) && (!file2.exists() || file2.delete())) {
                        file3.renameTo(file2);
                    }
                } catch (Throwable th) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } else {
                new Exception("create file failed");
            }
        } catch (Exception e2) {
            new Exception("save bytes failed", e2);
        }
        s(file);
    }

    public static final cjo ah(bgf bgfVar) {
        cjp cjpVar = new cjp();
        bgfVar.invoke(cjpVar);
        boolean z = cjpVar.b;
        boolean z2 = cjpVar.c;
        int i2 = cjpVar.d;
        boolean z3 = cjpVar.e;
        cjn cjnVar = cjpVar.a;
        return new cjo(z, z2, i2, false, z3, cjnVar.a, cjnVar.b, -1, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static bca ai(XmlResourceParser xmlResourceParser, Resources resources) throws Exception {
        int next;
        int i2;
        ArrayList arrayList;
        int i3;
        String str;
        String str2;
        List list;
        ?? r4;
        long j2;
        Throwable th;
        ?? r42;
        boolean zIsTerminated;
        boolean zIsTerminated2;
        do {
            next = xmlResourceParser.next();
            i2 = 2;
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        xmlResourceParser.require(2, null, "font-family");
        if (!xmlResourceParser.getName().equals("font-family")) {
            ap(xmlResourceParser);
            return null;
        }
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), cxz.b);
        int i4 = 0;
        String string = typedArrayObtainAttributes.getString(0);
        String string2 = typedArrayObtainAttributes.getString(5);
        String string3 = typedArrayObtainAttributes.getString(6);
        String string4 = typedArrayObtainAttributes.getString(2);
        int resourceId = typedArrayObtainAttributes.getResourceId(1, 0);
        int i5 = 3;
        int integer = typedArrayObtainAttributes.getInteger(3, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(4, 500);
        String string5 = typedArrayObtainAttributes.getString(7);
        typedArrayObtainAttributes.recycle();
        if (string == null || string2 == null) {
            ArrayList arrayList2 = new ArrayList();
            while (xmlResourceParser.next() != 3) {
                if (xmlResourceParser.getEventType() == 2) {
                    if (xmlResourceParser.getName().equals("font")) {
                        TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), cxz.c);
                        int i6 = typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(8) ? 8 : 1, 400);
                        boolean z = 1 == typedArrayObtainAttributes2.getInt(typedArrayObtainAttributes2.hasValue(6) ? 6 : 2, 0);
                        int i7 = typedArrayObtainAttributes2.hasValue(9) ? 9 : 3;
                        String string6 = typedArrayObtainAttributes2.getString(typedArrayObtainAttributes2.hasValue(7) ? 7 : 4);
                        int i8 = typedArrayObtainAttributes2.getInt(i7, 0);
                        int i9 = typedArrayObtainAttributes2.hasValue(5) ? 5 : 0;
                        int resourceId2 = typedArrayObtainAttributes2.getResourceId(i9, 0);
                        String string7 = typedArrayObtainAttributes2.getString(i9);
                        typedArrayObtainAttributes2.recycle();
                        while (xmlResourceParser.next() != 3) {
                            ap(xmlResourceParser);
                        }
                        arrayList2.add(new bcc(i6, i8, resourceId2, string7, string6, z));
                    } else {
                        ap(xmlResourceParser);
                    }
                }
            }
            if (arrayList2.isEmpty()) {
                return null;
            }
            return new bcb((bcc[]) arrayList2.toArray(new bcc[0]));
        }
        List listAk = ak(resources, resourceId);
        ArrayList arrayList3 = new ArrayList();
        while (xmlResourceParser.next() != i5) {
            if (xmlResourceParser.getEventType() == i2) {
                if (xmlResourceParser.getName().equals("fallback")) {
                    TypedArray typedArrayObtainAttributes3 = resources.obtainAttributes(Xml.asAttributeSet(xmlResourceParser), cxz.d);
                    int i10 = integer;
                    try {
                        String string8 = typedArrayObtainAttributes3.getString(i4);
                        String string9 = typedArrayObtainAttributes3.getString(1);
                        try {
                            String string10 = typedArrayObtainAttributes3.getString(i2);
                            if (string8 == null) {
                                r4 = typedArrayObtainAttributes3;
                                j2 = 1;
                                throw new XmlPullParserException("query attribute must be set in fallback element");
                            }
                            while (xmlResourceParser.next() != 3) {
                                try {
                                    ap(xmlResourceParser);
                                } catch (Throwable th2) {
                                    th = th2;
                                    r42 = typedArrayObtainAttributes3;
                                    j2 = 1;
                                }
                            }
                            list = listAk;
                            r4 = typedArrayObtainAttributes3;
                            arrayList = arrayList3;
                            str = string3;
                            str2 = string4;
                            i3 = i10;
                            j2 = 1;
                            try {
                                bbt bbtVar = new bbt(string, string2, string8, string9, string10, list);
                                if (r4 instanceof AutoCloseable) {
                                    ((AutoCloseable) r4).close();
                                } else if (r4 instanceof ExecutorService) {
                                    ExecutorService executorService = (ExecutorService) r4;
                                    if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated2 = executorService.isTerminated())) {
                                        executorService.shutdown();
                                        boolean z2 = false;
                                        while (!zIsTerminated2) {
                                            try {
                                                zIsTerminated2 = executorService.awaitTermination(1L, TimeUnit.DAYS);
                                            } catch (InterruptedException unused) {
                                                if (!z2) {
                                                    executorService.shutdownNow();
                                                    z2 = true;
                                                }
                                            }
                                        }
                                        if (z2) {
                                            Thread.currentThread().interrupt();
                                        }
                                    }
                                } else {
                                    r4.recycle();
                                }
                                arrayList.add(bbtVar);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                            th = th3;
                        } catch (Throwable th4) {
                            th = th4;
                            r4 = typedArrayObtainAttributes3;
                            j2 = 1;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r4 = typedArrayObtainAttributes3;
                        j2 = 1;
                    }
                    th = th;
                    r42 = r4;
                    if (r42 == 0) {
                        throw th;
                    }
                    try {
                        if (r42 instanceof AutoCloseable) {
                            ((AutoCloseable) r42).close();
                            throw th;
                        }
                        if (!(r42 instanceof ExecutorService)) {
                            r42.recycle();
                            throw th;
                        }
                        ExecutorService executorService2 = (ExecutorService) r42;
                        if (executorService2 == ForkJoinPool.commonPool() || (zIsTerminated = executorService2.isTerminated())) {
                            throw th;
                        }
                        executorService2.shutdown();
                        boolean z3 = false;
                        while (!zIsTerminated) {
                            try {
                                zIsTerminated = executorService2.awaitTermination(j2, TimeUnit.DAYS);
                            } catch (InterruptedException unused2) {
                                if (!z3) {
                                    executorService2.shutdownNow();
                                    z3 = true;
                                }
                            }
                        }
                        if (!z3) {
                            throw th;
                        }
                        Thread.currentThread().interrupt();
                        throw th;
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                        throw th;
                    }
                }
                arrayList = arrayList3;
                i3 = integer;
                str = string3;
                str2 = string4;
                list = listAk;
                ap(xmlResourceParser);
                arrayList3 = arrayList;
                listAk = list;
                string3 = str;
                string4 = str2;
                i2 = 2;
                i5 = 3;
                integer = i3;
                i4 = 0;
            }
        }
        ArrayList arrayList4 = arrayList3;
        int i11 = integer;
        String str3 = string3;
        String str4 = string4;
        List list2 = listAk;
        if (!arrayList4.isEmpty()) {
            return new bcd(arrayList4, i11, integer2, string5);
        }
        if (str3 == null) {
            throw new IllegalArgumentException("The provider font XML requires query attribute or fallback children.");
        }
        arrayList4.add(new bbt(string, string2, str3, null, null, list2));
        if (str4 != null) {
            arrayList4.add(new bbt(string, string2, str4, null, null, list2));
        }
        return new bcd(arrayList4, i11, integer2, string5);
    }

    public static void aj(File file, byte[] bArr, int i2) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i3 = 0;
        while (i3 < i2) {
            try {
                int i4 = randomAccessFile.read(bArr, i3, i2 - i3);
                if (i4 < 0) {
                    break;
                } else {
                    i3 += i4;
                }
            } finally {
                p(randomAccessFile);
            }
        }
    }

    public static List ak(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.EMPTY_LIST;
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            if (typedArrayObtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < typedArrayObtainTypedArray.length(); i3++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        String[] stringArray = resources.getStringArray(resourceId);
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArray) {
                            arrayList2.add(Base64.decode(str, 0));
                        }
                        arrayList.add(arrayList2);
                    }
                }
            } else {
                String[] stringArray2 = resources.getStringArray(i2);
                ArrayList arrayList3 = new ArrayList();
                for (String str2 : stringArray2) {
                    arrayList3.add(Base64.decode(str2, 0));
                }
                arrayList.add(arrayList3);
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    public static TypedValue al(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean am(Context context, int i2, boolean z) {
        TypedValue typedValueAl = al(context, i2);
        return (typedValueAl == null || typedValueAl.type != 18) ? z : typedValueAl.data != 0;
    }

    public static TypedValue an(Context context, int i2, String str) {
        TypedValue typedValueAl = al(context, i2);
        if (typedValueAl != null) {
            return typedValueAl;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static void ao(AppBarLayout appBarLayout, float f2) {
        int integer = appBarLayout.getResources().getInteger(me.hd.wauxv.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, me.hd.wauxv.R.attr.state_liftable, -1610876047}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }

    public static void ap(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static Context aq(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i, i2, i3);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z = (context instanceof afv) && ((afv) context).b == resourceId;
        if (resourceId == 0 || z) {
            return context;
        }
        afv afvVar = new afv(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, h);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            afvVar.getTheme().applyStyle(resourceId2, true);
        }
        return afvVar;
    }

    public static void k(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void l(int i2) {
        if (i2 > 524287 || i2 < 0) {
            throw new IllegalArgumentException("color id must be positive and bit count is less than 19");
        }
    }

    public static void m(Object obj) {
        n(obj, "Argument must not be null");
    }

    public static void n(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void o(int i2) {
        if (2 > i2 || i2 >= 37) {
            StringBuilder sbR = yg.r(i2, "radix ", " was not in valid range ");
            sbR.append(new bqi(2, 36, 1));
            throw new IllegalArgumentException(sbR.toString());
        }
    }

    public static void p(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static Drawable q(Drawable drawable, Drawable drawable2, int i2, int i3) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        if (i2 == -1 && (i2 = drawable2.getIntrinsicWidth()) == -1) {
            i2 = drawable.getIntrinsicWidth();
        }
        if (i3 == -1 && (i3 = drawable2.getIntrinsicHeight()) == -1) {
            i3 = drawable.getIntrinsicHeight();
        }
        if (i2 > drawable.getIntrinsicWidth() || i3 > drawable.getIntrinsicHeight()) {
            float f2 = i2 / i3;
            if (f2 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                i3 = (int) (intrinsicWidth / f2);
                i2 = intrinsicWidth;
            } else {
                i3 = drawable.getIntrinsicHeight();
                i2 = (int) (f2 * i3);
            }
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        layerDrawable.setLayerSize(1, i2, i3);
        layerDrawable.setLayerGravity(1, 17);
        return layerDrawable;
    }

    public static Drawable r(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = drawable.mutate();
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        return drawable;
    }

    public static void s(File file) {
        try {
            if (file.exists()) {
                t(file);
            }
        } catch (Throwable unused) {
        }
    }

    public static void t(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                t(file2);
            }
        }
        file.delete();
    }

    public static final boolean u(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static byte[] v(File file) {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) != 0) {
            throw new IllegalArgumentException("file too large, path:" + file.getPath());
        }
        int i2 = (int) length;
        byte[] bArr = new byte[i2];
        aj(file, bArr, i2);
        return bArr;
    }

    public static int[] w(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 16842912) {
                return iArr;
            }
            if (i3 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i2] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    public static ColorStateList x(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !at.u(drawable)) {
            return null;
        }
        return at.g(drawable).getColorStateList();
    }

    public static Drawable y(Context context, int i2) {
        return dcp.i().l(context, i2);
    }

    public static String z() {
        Integer numValueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(cnb.z(-119443040500522L));
        String strZ = cnb.z(-122110215191338L);
        String strZ2 = cnb.z(-122539711920938L);
        bmo.a.getClass();
        SharedPreferences sharedPreferences = bmo.n().getSharedPreferences(strZ, 0);
        zc zcVarB = dal.b(Integer.class);
        String string = null;
        if (zcVarB.equals(dal.b(String.class))) {
            Object string2 = sharedPreferences.getString(strZ2, null);
            if (string2 == null) {
                throw new NullPointerException(cnb.z(-122522532051754L));
            }
            numValueOf = (Integer) string2;
        } else if (zcVarB.equals(dal.b(Integer.TYPE))) {
            numValueOf = Integer.valueOf(sharedPreferences.getInt(strZ2, 0));
        } else if (zcVarB.equals(dal.b(Boolean.TYPE))) {
            numValueOf = (Integer) Boolean.valueOf(sharedPreferences.getBoolean(strZ2, false));
        } else if (zcVarB.equals(dal.b(Float.TYPE))) {
            numValueOf = (Integer) Float.valueOf(sharedPreferences.getFloat(strZ2, 0.0f));
        } else {
            if (!zcVarB.equals(dal.b(Long.TYPE))) {
                throw new IllegalArgumentException(cnb.z(-119567594552106L));
            }
            numValueOf = (Integer) Long.valueOf(sharedPreferences.getLong(strZ2, 0L));
        }
        sb.append(numValueOf.intValue());
        byte[] bytes = sb.toString().getBytes(uj.a);
        bzo.p(bytes, cnb.z(-80569291504426L));
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(cnb.z(-47145856006954L));
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : bArrDigest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.getDefault());
                bzo.p(upperCase, cnb.z(-47218870450986L));
                if (upperCase.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(upperCase);
            }
            string = stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        bzo.n(string);
        String lowerCase = string.toLowerCase(Locale.ROOT);
        bzo.p(lowerCase, cnb.z(-119447335467818L));
        StringBuilder sb2 = new StringBuilder();
        bmo.a.getClass();
        sb2.append(bmo.n().getDataDir().getAbsolutePath());
        sb2.append(cnb.z(-119391500892970L));
        sb2.append(lowerCase);
        sb2.append('/');
        return sb2.toString();
    }
}
