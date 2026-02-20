package me.hd.wauxv.obf;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Gainmap;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import me.hd.wauxv.R;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class emc {
    public static Field aa;
    public static final SpecificEmojiMatcher t;
    public static final SpecificEmojiMatcher u;
    public static final cbm v = new cbm(11);
    public static DefaultConfig config;
    public static boolean x;
    public static Method y;
    public static boolean z;
    public final /* synthetic */ int ab;

    static {
        int i = 1;
        t = new SpecificEmojiMatcher("REMOVED_TASK", i);
        u = new SpecificEmojiMatcher("CLOSED_EMPTY", i);
    }

    public /* synthetic */ emc(int i) {
        this.ab = i;
    }

    public static boolean ac(RectF rectF, float f, float f2, float f3) {
        return f >= rectF.left - f3 && f <= rectF.right + f3 && f2 >= rectF.top - f3 && f2 <= rectF.bottom + f3;
    }

    public static List ad(Object obj) {
        if ((obj instanceof bsw) && !(obj instanceof bsy)) {
            bb(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            KotlinHelpers.ao(e, emc.class.getName());
            throw e;
        }
    }

    public static Map ae(LinkedHashMap linkedHashMap) {
        if (!(linkedHashMap instanceof bsw) || (linkedHashMap instanceof bsz)) {
            return linkedHashMap;
        }
        bb(linkedHashMap, "kotlin.collections.MutableMap");
        throw null;
    }

    public static void af(int i, Object obj) {
        if (obj == null || as(i, obj)) {
            return;
        }
        bb(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static final cyk ag(dhy dhyVar) {
        throwIfVar1IsNull(dhyVar, "<this>");
        return new cyk(dhyVar);
    }

    public static final cyl ah(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, "<this>");
        return new cyl(dlcVar);
    }

    public static final ColorStateList ai(int i) {
        Pair[] pairVarArr = { new Pair(0, Integer.valueOf(i)) };
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Pair pairVar = pairVarArr[0];
        throwIfVar1IsNull(pairVar, "pair");
        Map mapSingletonMap = Collections.singletonMap(pairVar.a, pairVar.b);
        throwIfVar1IsNull(mapSingletonMap, "singletonMap(...)");
        for (Map.Entry entry : mapSingletonMap.entrySet()) {
            int iIntValue = ((Number) entry.getKey()).intValue();
            int iIntValue2 = ((Number) entry.getValue()).intValue();
            if (iIntValue == 0) {
                arrayList.add(new int[0]);
            } else {
                arrayList.add(new int[] { iIntValue });
            }
            arrayList2.add(Integer.valueOf(iIntValue2));
        }
        return new ColorStateList((int[][]) arrayList.toArray(new int[0][]), StaticHelpers5.y(arrayList2));
    }

    public static Bitmap aj(InputStream inputStream, BitmapFactory.Options options, FactoryPools factoryPoolsVar) throws Throwable {
        int i = Build.VERSION.SDK_INT;
        Bitmap bitmap = null;
        if (i == 34) {
            if (((i == 34 && options.inPreferredConfig == Bitmap.Config.HARDWARE)
                    ? ((Boolean) aye.c.get()).booleanValue()
                    : false) && at(factoryPoolsVar)) {
                Bitmap.Config config = options.inPreferredConfig;
                Bitmap.Config config2 = Bitmap.Config.HARDWARE;
                cmz.k("", config == config2);
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                    if (bitmapDecodeStream == null) {
                        if (bitmapDecodeStream != null) {
                            bitmapDecodeStream.recycle();
                        }
                        options.inPreferredConfig = config2;
                        return null;
                    }
                    try {
                        Bitmap bitmapAx = ax(bitmapDecodeStream);
                        bitmapDecodeStream.recycle();
                        options.inPreferredConfig = config2;
                        return bitmapAx;
                    } catch (Throwable th) {
                        th = th;
                        bitmap = bitmapDecodeStream;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        options.inPreferredConfig = Bitmap.Config.HARDWARE;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static boolean ak(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z2 = true;
        for (File file2 : fileArrListFiles) {
            z2 = ak(file2) && z2;
        }
        return z2;
    }

    public static boolean al(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int iIndexOfKey;
        WeakHashMap weakHashMap = ViewCompat.a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = eqy.a;
        eqy eqyVar = (eqy) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (eqyVar == null) {
            eqyVar = new eqy();
            eqyVar.b = null;
            eqyVar.c = null;
            eqyVar.d = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, eqyVar);
        }
        WeakReference weakReference2 = eqyVar.d;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        eqyVar.d = new WeakReference(keyEvent);
        if (eqyVar.c == null) {
            eqyVar.c = new SparseArray();
        }
        SparseArray sparseArray = eqyVar.c;
        if (keyEvent.getAction() == 1 && (iIndexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(iIndexOfKey);
            sparseArray.removeAt(iIndexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow()
                || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null
                || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    public static boolean am(btl btlVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        boolean zBooleanValue = false;
        if (btlVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return btlVar.b(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window = activity.getWindow();
                if (window.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!x) {
                            try {
                                y = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            x = true;
                        }
                        Method method = y;
                        if (method != null) {
                            try {
                                Object objInvoke = method.invoke(actionBar, keyEvent);
                                if (objInvoke != null) {
                                    zBooleanValue = ((Boolean) objInvoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (zBooleanValue) {
                            return true;
                        }
                    }
                }
                if (window.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window.getDecorView();
                if (ViewCompat.i(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null,
                        activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!z) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        aa = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    z = true;
                }
                Field field = aa;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                        onKeyListener = null;
                    }
                } else {
                    onKeyListener = null;
                }
                if (onKeyListener != null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                    return true;
                }
                Window window2 = dialog.getWindow();
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView2 = window2.getDecorView();
                if (ViewCompat.i(decorView2, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null,
                        dialog);
            }
            if ((view != null && ViewCompat.i(view, keyEvent)) || btlVar.b(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static int an(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static final String ao(KClass zcVar) {
        String strO;
        Map map = KClass.functionInterfaceMap;
        Class cls = zcVar.javaClass;
        throwIfVar1IsNull(cls, "jClass");
        String strConcat = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String strO2 = cnb.o(cls.getName());
            return strO2 == null ? cls.getCanonicalName() : strO2;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (strO = cnb.o(componentType.getName())) != null) {
            strConcat = strO.concat("Array");
        }
        return strConcat == null ? "kotlin.Array" : strConcat;
    }

    public static ik ap(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        ik ikVarE;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            int i2 = typedValue.type;
            if (i2 >= 28 && i2 <= 31) {
                return new ik(null, null, typedValue.data);
            }
            try {
                ikVarE = ik.e(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            } catch (Exception e) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                ikVarE = null;
            }
            if (ikVarE != null) {
                return ikVarE;
            }
        }
        return new ik(null, null, 0);
    }

    public static boolean aq(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static final boolean ar(AssertionError assertionError) {
        Logger logger = cqj.a;
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? StringsKt.contains(message, "getsockname failed", false) : false) {
                return true;
            }
        }
        return false;
    }

    public static boolean as(int i, Object obj) {
        if (obj instanceof bgp) {
            if ((obj instanceof bgq ? ((bgq) obj).getArity()
                    : obj instanceof IFunction0 ? 0
                            : obj instanceof bgf ? 1
                                    : obj instanceof bgj ? 2
                                            : obj instanceof bgk ? 3
                                                    : obj instanceof blv ? 4 : obj instanceof aak ? 7 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean at(FactoryPools factoryPoolsVar) {
        try {
            boolean zY = factoryPoolsVar.y();
            if (!Log.isLoggable("GlideBitmapFactory", 2)) {
                return zY;
            }
            Log.v("GlideBitmapFactory", "isLikelyToContainGainmap=" + zY);
            return zY;
        } catch (IOException e) {
            if (!Log.isLoggable("GlideBitmapFactory", 2)) {
                return false;
            }
            Log.v("GlideBitmapFactory", "isLikelyToContainGainmap failed", e);
            return false;
        }
    }

    public static void au(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(
                    new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
        }
    }

    public static TypedArray av(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr)
                : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static GenericMetadataIterator3 aw(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i = byteBufferDuplicate.getShort() & 65535;
        if (i > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                j = -1;
                break;
            }
            int i3 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i3) {
                break;
            }
            i2++;
        }
        if (j != -1) {
            byteBufferDuplicate
                    .position(byteBufferDuplicate.position() + ((int) (j - ((long) byteBufferDuplicate.position()))));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j2 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
            for (int i4 = 0; i4 < j2; i4++) {
                int i5 = byteBufferDuplicate.getInt();
                long j3 = ((long) byteBufferDuplicate.getInt()) & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i5 || 1701669481 == i5) {
                    byteBufferDuplicate.position((int) (j3 + j));
                    GenericMetadataIterator3 cdcVar = new GenericMetadataIterator3();
                    int iPosition = byteBufferDuplicate.position()
                            + bjs.f(byteBufferDuplicate, ByteOrder.LITTLE_ENDIAN);
                    cdcVar.e = byteBufferDuplicate;
                    cdcVar.b = iPosition;
                    int i6 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    cdcVar.c = i6;
                    cdcVar.d = ((ByteBuffer) cdcVar.e).getShort(i6);
                    return cdcVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static Bitmap ax(Bitmap bitmap) {
        Gainmap gainmap = bitmap.getGainmap();
        if (gainmap != null) {
            Bitmap.Config config = gainmap.getGainmapContents().getConfig();
            Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
            if (config == config2) {
                ColorMatrixColorFilter colorMatrixColorFilter = bhr.a;
                Bitmap gainmapContents = gainmap.getGainmapContents();
                if (gainmapContents.getConfig() == config2) {
                    cmz.k("", gainmapContents.getConfig() == config2);
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(gainmapContents.getWidth(),
                            gainmapContents.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    Paint paint = new Paint();
                    paint.setColorFilter(bhr.a);
                    canvas.drawBitmap(gainmapContents, 0.0f, 0.0f, paint);
                    canvas.setBitmap(null);
                    Gainmap gainmapK = qy.k(bitmapCreateBitmap);
                    float[] ratioMin = gainmap.getRatioMin();
                    gainmapK.setRatioMin(ratioMin[0], ratioMin[1], ratioMin[2]);
                    float[] ratioMax = gainmap.getRatioMax();
                    gainmapK.setRatioMax(ratioMax[0], ratioMax[1], ratioMax[2]);
                    float[] gamma = gainmap.getGamma();
                    gainmapK.setGamma(gamma[0], gamma[1], gamma[2]);
                    float[] epsilonSdr = gainmap.getEpsilonSdr();
                    gainmapK.setEpsilonSdr(epsilonSdr[0], epsilonSdr[1], epsilonSdr[2]);
                    float[] epsilonHdr = gainmap.getEpsilonHdr();
                    gainmapK.setEpsilonHdr(epsilonHdr[0], epsilonHdr[1], epsilonHdr[2]);
                    gainmapK.setDisplayRatioForFullHdr(gainmap.getDisplayRatioForFullHdr());
                    gainmapK.setMinDisplayRatioForHdrTransition(gainmap.getMinDisplayRatioForHdrTransition());
                    gainmap = gainmapK;
                }
                bitmap.setGainmap(gainmap);
            }
        }
        return bitmap.copy(Bitmap.Config.HARDWARE, false);
    }

    public static final dhy ay(Socket socket) throws IOException {
        Logger logger = cqj.a;
        throwIfVar1IsNull(socket, "<this>");
        dkw dkwVar = new dkw(socket);
        OutputStream outputStream = socket.getOutputStream();
        throwIfVar1IsNull(outputStream, "getOutputStream(...)");
        return dkwVar.sink(new lm(outputStream, 1, dkwVar));
    }

    public static lm az(File file) {
        Logger logger = cqj.a;
        return new lm(new FileOutputStream(file, false), 1, new ekc());
    }

    public static final dlc ba(Socket socket) throws IOException {
        Logger logger = cqj.a;
        throwIfVar1IsNull(socket, "<this>");
        dkw dkwVar = new dkw(socket);
        InputStream inputStream = socket.getInputStream();
        throwIfVar1IsNull(inputStream, "getInputStream(...)");
        return dkwVar.source(new ln(inputStream, dkwVar));
    }

    public static void bb(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(
                (obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        KotlinHelpers.ao(classCastException, emc.class.getName());
        throw classCastException;
    }

    /* JADX WARN: Found duplicated region for block: B:344:0x00dd */
    /*
     * JADX WARN: Found duplicated region for block: B:362:0x010f A[Catch: all ->
     * 0x0122, IllegalStateException -> 0x0125, IOException -> 0x0127, TRY_LEAVE,
     * TryCatch #14 {IllegalStateException -> 0x0125, blocks: (B:360:0x0105,
     * B:362:0x010f, B:373:0x0129, B:374:0x012e), top: B:572:0x0105, outer: #1 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:373:0x0129 A[Catch: all ->
     * 0x0122, IllegalStateException -> 0x0125, IOException -> 0x0127, TRY_ENTER,
     * TryCatch #14 {IllegalStateException -> 0x0125, blocks: (B:360:0x0105,
     * B:362:0x010f, B:373:0x0129, B:374:0x012e), top: B:572:0x0105, outer: #1 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:397:0x016a A[Catch: all ->
     * 0x017f, TRY_LEAVE, TryCatch #18 {all -> 0x017f, blocks: (B:395:0x015e,
     * B:397:0x016a, B:408:0x0182, B:409:0x0187), top: B:576:0x015e }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:408:0x0182 A[Catch: all ->
     * 0x017f, TRY_ENTER, TryCatch #18 {all -> 0x017f, blocks: (B:395:0x015e,
     * B:397:0x016a, B:408:0x0182, B:409:0x0187), top: B:576:0x015e }]
     */
    /* JADX WARN: Found duplicated region for block: B:415:0x0191 A[DONT_INVERT] */
    /*
     * JADX WARN: Found duplicated region for block: B:416:0x0193 A[Catch:
     * IllegalStateException -> 0x0179, IOException -> 0x017b, FileNotFoundException
     * -> 0x017d, TRY_LEAVE, TryCatch #34 {FileNotFoundException -> 0x017d,
     * IOException -> 0x017b, IllegalStateException -> 0x0179, blocks:
     * (B:393:0x0156, B:398:0x0174, B:416:0x0193, B:414:0x0190, B:413:0x018d), top:
     * B:600:0x0156 }]
     */
    /* JADX WARN: Found duplicated region for block: B:423:0x01a9 */
    /*
     * JADX WARN: Found duplicated region for block: B:433:0x01cc A[Catch: all ->
     * 0x01da, TRY_LEAVE, TryCatch #34 {all -> 0x01da, blocks: (B:431:0x01c0,
     * B:433:0x01cc, B:442:0x01dd), top: B:590:0x01c0 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:442:0x01dd A[Catch: all ->
     * 0x01da, TRY_ENTER, TRY_LEAVE, TryCatch #34 {all -> 0x01da, blocks:
     * (B:431:0x01c0, B:433:0x01cc, B:442:0x01dd), top: B:590:0x01c0 }]
     */
    /* JADX WARN: Found duplicated region for block: B:453:0x01fa */
    /* JADX WARN: Found duplicated region for block: B:457:0x0204 */
    /* JADX WARN: Found duplicated region for block: B:458:0x0208 */
    /*
     * JADX WARN: Found duplicated region for block: B:467:0x0228 A[Catch: all ->
     * 0x0266, TryCatch #6 {all -> 0x0266, blocks: (B:465:0x0222, B:467:0x0228,
     * B:468:0x022c, B:470:0x0232), top: B:560:0x0222 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:470:0x0232 A[Catch: all ->
     * 0x0266, TRY_LEAVE, TryCatch #6 {all -> 0x0266, blocks: (B:465:0x0222,
     * B:467:0x0228, B:468:0x022c, B:470:0x0232), top: B:560:0x0222 }]
     */
    /* JADX WARN: Found duplicated region for block: B:536:0x02b7 */
    /* JADX WARN: Found duplicated region for block: B:540:0x02c1 */
    /* JADX WARN: Found duplicated region for block: B:547:0x02d1 */
    /*
     * JADX WARN: Found duplicated region for block: B:560:0x0222
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:572:0x0105
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:576:0x015e
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:597:0x020c
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:599:0x01bb
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:601:0x0237 A[EDGE_INSN:
     * B:601:0x0237->B:472:0x0237 BREAK A[LOOP:0: B:468:0x022c->B:602:?], SYNTHETIC]
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v25, types: [int] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v43 */
    /* JADX WARN: Type inference failed for: r7v44 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v47 */
    /* JADX WARN: Type inference failed for: r7v48 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /*
     * JADX WARN: Type inference failed for: r7v5, types: [java.io.FileInputStream,
     * java.io.InputStream]
     */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v51 */
    /* JADX WARN: Type inference failed for: r7v52 */
    /* JADX WARN: Type inference failed for: r7v53 */
    /* JADX WARN: Type inference failed for: r7v54 */
    /* JADX WARN: Type inference failed for: r7v55 */
    /* JADX WARN: Type inference failed for: r7v56 */
    /* JADX WARN: Type inference failed for: r7v57 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.
     * java:210)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:196)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(
     * TryCatchBlockAttr.java:180)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:
     * 201)
     * at
     * jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.
     * java:347)
     * at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(
     * TryCatchBlockAttr.java:356)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(
     * MarkFinallyVisitor.java:202)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:119)
     */
    public static void bc(Context context, Executor executor, cvv cvvVar, boolean z2) {
        boolean z3;
        ?? I;
        amr[] amrVarArrAt;
        amr[] amrVarArr;
        cvv cvvVar2;
        amr[] amrVarArr2;
        byte[] bArr;
        ?? r7;
        byte[] bArr2;
        ?? r72;
        boolean z4;
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        FileChannel channel;
        FileLock fileLockTryLock;
        byte[] bArr3;
        int i;
        ?? r73;
        boolean z5;
        boolean z6;
        ?? r74;
        ByteArrayOutputStream byteArrayOutputStream;
        amg amgVar;
        ?? r75;
        String str;
        FileInputStream fileInputStreamI;
        ?? r76;
        boolean z7;
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z2) {
                File file = new File(filesDir, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
                if (file.exists()) {
                    try {
                        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
                        try {
                            long j = dataInputStream.readLong();
                            dataInputStream.close();
                            z7 = j == packageInfo.lastUpdateTime;
                            if (z7) {
                                cvvVar.logProfileResult(2, null);
                            }
                        } catch (Throwable th3) {
                            try {
                                dataInputStream.close();
                                throw th3;
                            } catch (Throwable th4) {
                                th3.addSuppressed(th4);
                                throw th3;
                            }
                        }
                    } catch (IOException unused) {
                        z7 = false;
                    }
                } else {
                    z7 = false;
                }
                if (z7) {
                    Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                    cvz.f(context, false);
                    return;
                }
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            byte[] bArr4 = StaticHelpers7.ab;
            File file2 = new File(new File("/data/misc/profiles/cur/0", packageName), "primary.prof");
            amg amgVar2 = new amg(assets, executor, cvvVar, name, file2);
            byte[] bArr5 = amgVar2.c;
            if (bArr5 != null) {
                if (!file2.exists()) {
                    try {
                        if (file2.createNewFile()) {
                            amgVar2.f = true;
                            I = amgVar2.i(assets, "dexopt/baseline.prof");
                            if (I != 0) {
                                if (Arrays.equals(bArr4, StaticAndroidHelpers.ar(I, 4))) {
                                    throw new IllegalStateException("Invalid magic");
                                }
                                amrVarArrAt = StaticHelpers7.at(I, StaticAndroidHelpers.ar(I, 4), amgVar2.e);
                                I.close();
                                amgVar2.g = amrVarArrAt;
                            }
                            amrVarArr = amgVar2.g;
                            if (amrVarArr != null) {
                                str = "dexopt/baseline.profm";
                                fileInputStreamI = amgVar2.i(assets, "dexopt/baseline.profm");
                                r75 = str;
                                if (fileInputStreamI == null) {
                                    if (fileInputStreamI != null) {
                                        fileInputStreamI.close();
                                        r75 = str;
                                    }
                                    amgVar = null;
                                    I = r75;
                                } else {
                                    if (Arrays.equals(StaticHelpers7.ac, StaticAndroidHelpers.ar(fileInputStreamI, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    byte[] bArrAr = StaticAndroidHelpers.ar(fileInputStreamI, 4);
                                    amgVar2.g = StaticHelpers7.aq(fileInputStreamI, bArrAr, bArr5, amrVarArr);
                                    fileInputStreamI.close();
                                    amgVar = amgVar2;
                                    I = bArrAr;
                                }
                                if (amgVar != null) {
                                    amgVar2 = amgVar;
                                }
                            }
                            cvvVar2 = amgVar2.b;
                            amrVarArr2 = amgVar2.g;
                            bArr = amgVar2.c;
                            r7 = I;
                            r7 = I;
                            if (amrVarArr2 != null) {
                                z6 = amgVar2.f;
                                if (z6) {
                                    throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                }
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                byteArrayOutputStream.write(bArr4);
                                byteArrayOutputStream.write(bArr);
                                if (StaticHelpers7.be(byteArrayOutputStream, bArr, amrVarArr2)) {
                                    amgVar2.h = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.close();
                                    r74 = byteArrayOutputStream;
                                    amgVar2.g = null;
                                    r7 = r74;
                                } else {
                                    cvvVar2.logProfileResult(5, null);
                                    amgVar2.g = null;
                                    byteArrayOutputStream.close();
                                    r7 = byteArrayOutputStream;
                                }
                            }
                            bArr2 = amgVar2.h;
                            if (bArr2 != null) {
                                if (amgVar2.f) {
                                    throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                }
                                byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                fileOutputStream = new FileOutputStream(amgVar2.d);
                                channel = fileOutputStream.getChannel();
                                fileLockTryLock = channel.tryLock();
                                if (fileLockTryLock != null) {
                                    if (fileLockTryLock.isValid()) {
                                        bArr3 = new byte[512];
                                        while (true) {
                                            i = byteArrayInputStream.read(bArr3);
                                            if (i > 0) {
                                                break;
                                                break;
                                            }
                                            fileOutputStream.write(bArr3, 0, i);
                                        }
                                        r73 = 1;
                                        amgVar2.j(1, null);
                                        fileLockTryLock.close();
                                        channel.close();
                                        fileOutputStream.close();
                                        byteArrayInputStream.close();
                                        amgVar2.h = null;
                                        amgVar2.g = null;
                                        z4 = true;
                                    }
                                }
                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                            }
                            z4 = false;
                            r73 = 1;
                            if (z4) {
                                au(packageInfo, filesDir);
                            }
                            z5 = z4;
                            r76 = r73;
                        } else {
                            amgVar2.j(4, null);
                        }
                    } catch (IOException unused2) {
                        z3 = true;
                        amgVar2.j(4, null);
                    }
                } else if (file2.canWrite()) {
                    amgVar2.f = true;
                    try {
                        I = amgVar2.i(assets, "dexopt/baseline.prof");
                    } catch (FileNotFoundException e) {
                        cvvVar.logProfileResult(6, e);
                        I = 0;
                    } catch (IOException e2) {
                        cvvVar.logProfileResult(7, e2);
                        I = 0;
                    }
                    try {
                        if (I != 0) {
                            try {
                                try {
                                } catch (IllegalStateException e3) {
                                    cvvVar.logProfileResult(8, e3);
                                    try {
                                        I.close();
                                    } catch (IOException e4) {
                                        cvvVar.logProfileResult(7, e4);
                                    }
                                    amrVarArrAt = null;
                                }
                            } catch (IOException e5) {
                                cvvVar.logProfileResult(7, e5);
                                I.close();
                                amrVarArrAt = null;
                            }
                            if (Arrays.equals(bArr4, StaticAndroidHelpers.ar(I, 4))) {
                                throw new IllegalStateException("Invalid magic");
                            }
                            amrVarArrAt = StaticHelpers7.at(I, StaticAndroidHelpers.ar(I, 4), amgVar2.e);
                            try {
                                I.close();
                            } catch (IOException e6) {
                                cvvVar.logProfileResult(7, e6);
                            }
                            amgVar2.g = amrVarArrAt;
                        }
                        amrVarArr = amgVar2.g;
                        if (amrVarArr != null && (I = Build.VERSION.SDK_INT) >= 31) {
                            try {
                                str = "dexopt/baseline.profm";
                                fileInputStreamI = amgVar2.i(assets, "dexopt/baseline.profm");
                                r75 = str;
                            } catch (FileNotFoundException e7) {
                                cvvVar.logProfileResult(9, e7);
                                r75 = I;
                            } catch (IOException e8) {
                                cvvVar.logProfileResult(7, e8);
                                r75 = I;
                            } catch (IllegalStateException e9) {
                                amgVar2.g = null;
                                cvvVar.logProfileResult(8, e9);
                                r75 = I;
                            }
                            if (fileInputStreamI == null) {
                                try {
                                    if (Arrays.equals(StaticHelpers7.ac, StaticAndroidHelpers.ar(fileInputStreamI, 4))) {
                                        throw new IllegalStateException("Invalid magic");
                                    }
                                    byte[] bArrAr2 = StaticAndroidHelpers.ar(fileInputStreamI, 4);
                                    amgVar2.g = StaticHelpers7.aq(fileInputStreamI, bArrAr2, bArr5, amrVarArr);
                                    fileInputStreamI.close();
                                    amgVar = amgVar2;
                                    I = bArrAr2;
                                } catch (Throwable th5) {
                                    try {
                                        fileInputStreamI.close();
                                        throw th5;
                                    } catch (Throwable th6) {
                                        th5.addSuppressed(th6);
                                        throw th5;
                                    }
                                }
                            } else {
                                if (fileInputStreamI != null) {
                                    fileInputStreamI.close();
                                    r75 = str;
                                }
                                amgVar = null;
                                I = r75;
                            }
                            if (amgVar != null) {
                                amgVar2 = amgVar;
                            }
                        }
                        cvvVar2 = amgVar2.b;
                        amrVarArr2 = amgVar2.g;
                        bArr = amgVar2.c;
                        r7 = I;
                        r7 = I;
                        if (amrVarArr2 != null && bArr != null) {
                            z6 = amgVar2.f;
                            if (z6) {
                                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                            }
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byteArrayOutputStream.write(bArr4);
                                    byteArrayOutputStream.write(bArr);
                                } catch (Throwable th7) {
                                    try {
                                        byteArrayOutputStream.close();
                                        throw th7;
                                    } catch (Throwable th8) {
                                        th7.addSuppressed(th8);
                                        throw th7;
                                    }
                                }
                            } catch (IOException e10) {
                                cvvVar2.logProfileResult(7, e10);
                                r74 = z6;
                            } catch (IllegalStateException e11) {
                                cvvVar2.logProfileResult(8, e11);
                                r74 = z6;
                            }
                            if (StaticHelpers7.be(byteArrayOutputStream, bArr, amrVarArr2)) {
                                cvvVar2.logProfileResult(5, null);
                                amgVar2.g = null;
                                byteArrayOutputStream.close();
                                r7 = byteArrayOutputStream;
                            } else {
                                amgVar2.h = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                r74 = byteArrayOutputStream;
                                amgVar2.g = null;
                                r7 = r74;
                            }
                        }
                        bArr2 = amgVar2.h;
                        if (bArr2 != null) {
                            z4 = false;
                            r73 = 1;
                        } else {
                            try {
                                if (amgVar2.f) {
                                    throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
                                }
                                try {
                                    try {
                                        byteArrayInputStream = new ByteArrayInputStream(bArr2);
                                        try {
                                            try {
                                                fileOutputStream = new FileOutputStream(amgVar2.d);
                                                try {
                                                    try {
                                                        channel = fileOutputStream.getChannel();
                                                        try {
                                                            fileLockTryLock = channel.tryLock();
                                                        } catch (Throwable th9) {
                                                            th = th9;
                                                        }
                                                        try {
                                                            try {
                                                                if (fileLockTryLock != null) {
                                                                    try {
                                                                        if (fileLockTryLock.isValid()) {
                                                                            bArr3 = new byte[512];
                                                                            while (true) {
                                                                                i = byteArrayInputStream.read(bArr3);
                                                                                if (i > 0) {
                                                                                    break;
                                                                                } else {
                                                                                    fileOutputStream.write(bArr3, 0, i);
                                                                                }
                                                                            }
                                                                            r73 = 1;
                                                                            amgVar2.j(1, null);
                                                                            fileLockTryLock.close();
                                                                            channel.close();
                                                                            fileOutputStream.close();
                                                                            byteArrayInputStream.close();
                                                                            amgVar2.h = null;
                                                                            amgVar2.g = null;
                                                                            z4 = true;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        Throwable th11 = th;
                                                                        if (fileLockTryLock == null) {
                                                                            throw th11;
                                                                        }
                                                                        try {
                                                                            fileLockTryLock.close();
                                                                            throw th11;
                                                                        } catch (Throwable th12) {
                                                                            th11.addSuppressed(th12);
                                                                            throw th11;
                                                                        }
                                                                    }
                                                                }
                                                                throw new IOException("Unable to acquire a lock on the underlying file channel.");
                                                            } catch (Throwable th13) {
                                                                th = th13;
                                                            }
                                                        } catch (Throwable th14) {
                                                            th = th14;
                                                            Throwable th15 = th;
                                                            if (channel == null) {
                                                                throw th15;
                                                            }
                                                            try {
                                                                channel.close();
                                                                throw th15;
                                                            } catch (Throwable th16) {
                                                                th15.addSuppressed(th16);
                                                                throw th15;
                                                            }
                                                        }
                                                    } catch (Throwable th17) {
                                                        th = th17;
                                                        th2 = th;
                                                        try {
                                                            fileOutputStream.close();
                                                            throw th2;
                                                        } catch (Throwable th18) {
                                                            th2.addSuppressed(th18);
                                                            throw th2;
                                                        }
                                                    }
                                                } catch (Throwable th19) {
                                                    th = th19;
                                                    th2 = th;
                                                    fileOutputStream.close();
                                                    throw th2;
                                                }
                                            } catch (Throwable th20) {
                                                th = th20;
                                                th = th;
                                                try {
                                                    byteArrayInputStream.close();
                                                    throw th;
                                                } catch (Throwable th21) {
                                                    th.addSuppressed(th21);
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th22) {
                                            th = th22;
                                            th = th;
                                            byteArrayInputStream.close();
                                            throw th;
                                        }
                                    } catch (FileNotFoundException e12) {
                                        e = e12;
                                        r7 = 1;
                                        amgVar2.j(6, e);
                                        r72 = r7;
                                        amgVar2.h = null;
                                        amgVar2.g = null;
                                        z4 = false;
                                        r73 = r72;
                                    } catch (IOException e13) {
                                        e = e13;
                                        r7 = 1;
                                        amgVar2.j(7, e);
                                        r72 = r7;
                                        amgVar2.h = null;
                                        amgVar2.g = null;
                                        z4 = false;
                                        r73 = r72;
                                    }
                                } catch (FileNotFoundException e14) {
                                    e = e14;
                                    amgVar2.j(6, e);
                                    r72 = r7;
                                    amgVar2.h = null;
                                    amgVar2.g = null;
                                    z4 = false;
                                    r73 = r72;
                                } catch (IOException e15) {
                                    e = e15;
                                    amgVar2.j(7, e);
                                    r72 = r7;
                                    amgVar2.h = null;
                                    amgVar2.g = null;
                                    z4 = false;
                                    r73 = r72;
                                }
                            } catch (Throwable th23) {
                                amgVar2.h = null;
                                amgVar2.g = null;
                                throw th23;
                            }
                        }
                        if (z4) {
                            au(packageInfo, filesDir);
                        }
                        z5 = z4;
                        r76 = r73;
                    } catch (Throwable th24) {
                        try {
                            I.close();
                            throw th24;
                        } catch (IOException e16) {
                            cvvVar.logProfileResult(7, e16);
                            throw th24;
                        }
                    }
                } else {
                    amgVar2.j(4, null);
                }
                cvz.f(context, (z5 || !z2) ? 0 : r76);
            }
            amgVar2.j(3, Integer.valueOf(Build.VERSION.SDK_INT));
            z3 = true;
            z5 = false;
            r76 = z3;
            cvz.f(context, (z5 || !z2) ? 0 : r76);
        } catch (PackageManager.NameNotFoundException e17) {
            cvvVar.logProfileResult(7, e17);
            cvz.f(context, false);
        }
    }

    public abstract InputFilter[] _x(InputFilter[] inputFilterArr);

    public abstract boolean _y();

    public abstract boolean f(al alVar, ah ahVar);

    public abstract boolean g(al alVar, Object obj, Object obj2);

    public abstract boolean h(al alVar, ak akVar, ak akVar2);

    public int hashCode() {
        switch (this.ab) {
            case 13:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public abstract void i(ak akVar, ak akVar2);

    public abstract void j(ak akVar, Thread thread);

    public abstract void k(boolean z2);

    public abstract void l(boolean z2);

    public abstract TransformationMethod m(TransformationMethod transformationMethod);

    public String toString() {
        switch (this.ab) {
            case 13:
                String strD = dal.getKClassFromClass(getClass()).getKotlinSimpleName();
                throwIfVar1IsNull(strD);
                return strD;
            default:
                return super.toString();
        }
    }
}
