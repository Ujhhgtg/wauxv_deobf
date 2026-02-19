package me.hd.wauxv.obf;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.alibaba.fastjson2.JSONB;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class StaticAndroidHelpers {
    public static final SyntheticClass q = new SyntheticClass(3);
    public static final byte[] r = { JSONB.Constants.BC_INT32_BYTE_MIN, 49, 53, 0 };
    public static final byte[] s = { JSONB.Constants.BC_INT32_BYTE_MIN, 49, JSONB.Constants.BC_INT32_BYTE_MIN, 0 };
    public static final byte[] t = { JSONB.Constants.BC_INT32_BYTE_MIN, JSONB.Constants.BC_INT32_BYTE_MIN, 57, 0 };
    public static final byte[] u = { JSONB.Constants.BC_INT32_BYTE_MIN, JSONB.Constants.BC_INT32_BYTE_MIN, 53, 0 };
    public static final byte[] v = { JSONB.Constants.BC_INT32_BYTE_MIN, JSONB.Constants.BC_INT32_BYTE_MIN, 49, 0 };
    public static final byte[] w = { JSONB.Constants.BC_INT32_BYTE_MIN, JSONB.Constants.BC_INT32_BYTE_MIN, 49, 0 };
    public static final byte[] x = { JSONB.Constants.BC_INT32_BYTE_MIN, JSONB.Constants.BC_INT32_BYTE_MIN, 50, 0 };

    public static final String aa(CharSequence charSequence) {
        if (charSequence == null) {
            return " ";
        }
        String str = charSequence instanceof String ? (String) charSequence : null;
        return str == null ? charSequence.toString() : str;
    }

    public static void ab(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
     * "finallyBlockTerminus" is null
     * at
     * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
     * (TraverserActivePathState.java:253)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:422)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    public static byte[] ac(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    deflaterOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            deflater.end();
            throw th3;
        }
    }

    public static boolean ad(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zAe = ae(file, inputStreamOpenRawResource);
                ab(inputStreamOpenRawResource);
                return zAe;
            } catch (Throwable th) {
                th = th;
                ab(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean ae(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    ab(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            ab(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            ab(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static void af(View view, esn esnVar) {
        WeakHashMap weakHashMap = ViewCompat.a;
        int paddingStart = view.getPaddingStart();
        int paddingTop = view.getPaddingTop();
        int paddingEnd = view.getPaddingEnd();
        int paddingBottom = view.getPaddingBottom();
        baw bawVar = new baw();
        bawVar.a = paddingStart;
        bawVar.b = paddingTop;
        bawVar.c = paddingEnd;
        bawVar.d = paddingBottom;
        eqq.l(view, new but(esnVar, 20, bawVar));
        if (view.isAttachedToWindow()) {
            eqo.c(view);
        } else {
            view.addOnAttachStateChangeListener(new esl());
        }
    }

    public static float ag(Context context, int i) {
        return TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static ViewGroup ah(View view) {
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static File ai(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static boolean aj(int i, CharSequence charSequence) {
        if (i >= charSequence.length()) {
            return false;
        }
        char cCharAt = charSequence.charAt(i);
        switch (cCharAt) {
            case '!':
            case '\"':
            case '#':
            case '$':
            case '%':
            case '&':
            case '\'':
            case '(':
            case ')':
            case '*':
            case '+':
            case ',':
            case '-':
            case '.':
            case '/':
                return true;
            default:
                switch (cCharAt) {
                    case ':':
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                    case '?':
                    case '@':
                        return true;
                    default:
                        switch (cCharAt) {
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                                return true;
                            default:
                                switch (cCharAt) {
                                    case '{':
                                    case '|':
                                    case '}':
                                    case '~':
                                        return true;
                                    default:
                                        return false;
                                }
                        }
                }
        }
    }

    public static boolean ak(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }

    public static boolean al(View view) {
        WeakHashMap weakHashMap = ViewCompat.a;
        return view.getLayoutDirection() == 1;
    }

    public static IHasGetValue am(btx btxVar, bfu bfuVar) {
        arj arjVar = arj.n;
        int iOrdinal = btxVar.ordinal();
        if (iOrdinal == 0) {
            return new Kotlin$Lazy(bfuVar);
        }
        if (iOrdinal == 1) {
            deg degVar = new deg();
            degVar.b = bfuVar;
            degVar.c = arjVar;
            return degVar;
        }
        if (iOrdinal != 2) {
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        enz enzVar = new enz();
        enzVar.a = bfuVar;
        enzVar.b = arjVar;
        return enzVar;
    }

    public static int an(byte[] bArr) {
        if (bArr.length != 8 || bArr[0] != 100 || bArr[1] != 101 || bArr[2] != 120 || bArr[3] != 10 || bArr[7] != 0) {
            return -1;
        }
        String str = "" + ((char) bArr[4]) + ((char) bArr[5]) + ((char) bArr[6]);
        if (str.equals("035")) {
            return 13;
        }
        if (str.equals("037")) {
            return 24;
        }
        if (str.equals("038")) {
            return 26;
        }
        if (str.equals("039")) {
            return 28;
        }
        if (str.equals("040")) {
            return 10000;
        }
        return str.equals("039") ? 28 : -1;
    }

    public static MappedByteBuffer ao(Context context, Uri uri) {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (parcelFileDescriptorOpenFileDescriptor == null) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                parcelFileDescriptorOpenFileDescriptor.close();
                return null;
            }
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(
                    parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                parcelFileDescriptorOpenFileDescriptor.close();
                return map;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } catch (Throwable th3) {
            try {
                parcelFileDescriptorOpenFileDescriptor.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static PorterDuff.Mode ap(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static final void runOnUiThread(Object obj, IInvokable bgfVar) {
        ((Handler) StaticMainLooperHandlerProvider.HANDLER.getValue()).post(() -> { bgfVar.invoke(obj); });
    }

    public static byte[] ar(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw new IllegalStateException(concatVar2Var1(i, "Not enough bytes to read: "));
            }
            i2 += i3;
        }
        return bArr;
    }

    public static byte[] as(FileInputStream fileInputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = fileInputStream.read(bArr2);
                if (i4 < 0) {
                    throw new IllegalStateException(
                            "Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw new IllegalStateException(e.getMessage());
                }
            }
            if (i3 == i) {
                if (!inflater.finished()) {
                    throw new IllegalStateException("Inflater did not finish");
                }
                inflater.end();
                return bArr;
            }
            throw new IllegalStateException(
                    "Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static long at(InputStream inputStream, int i) throws IOException {
        byte[] bArrAr = ar(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += ((long) (bArrAr[i2] & 255)) << (i2 * 8);
        }
        return j;
    }

    public static int au(char c, int i, int i2, CharSequence charSequence) {
        while (i < i2) {
            if (charSequence.charAt(i) != c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int av(int i, int i2, CharSequence charSequence) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '\t' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static FactoryPools aw(int i, axv axvVar) {
        return new FactoryPools(new cux(i), axvVar, q);
    }

    public static void ax(ArrayList arrayList, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aah aahVar = (aah) it.next();
            int i3 = aahVar.c;
            if (i3 >= i) {
                aahVar.c = i3 + i2;
            }
            int i4 = aahVar.e;
            if (i4 >= i) {
                aahVar.e = i4 + i2;
            }
            if (aahVar.c >= aahVar.e) {
                it.remove();
            }
        }
    }

    public static void ay(ByteArrayOutputStream byteArrayOutputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void az(ByteArrayOutputStream byteArrayOutputStream, int i) throws IOException {
        ay(byteArrayOutputStream, i, 2);
    }

    public static final bzx y(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new bzx(matcher, charSequence);
        }
        return null;
    }

    public static String z(int i) {
        String str = "039";
        if (i < 28) {
            if (i >= 10000) {
                str = "040";
            } else if (i < 28) {
                str = i >= 26 ? "038" : i >= 24 ? "037" : "035";
            }
        }
        return concat("dex\n", str, "\u0000");
    }

    public abstract int c(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float d(int i);

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i(View view);

    public abstract int j(CoordinatorLayout coordinatorLayout);

    public abstract int k();

    public abstract boolean l(float f);

    public abstract boolean m(View view);

    public abstract boolean n(float f, float f2);

    public abstract boolean o(View view, float f);

    public abstract void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2);
}
