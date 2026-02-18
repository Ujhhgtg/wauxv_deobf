package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.hd.wauxv.hook.core.p000native.AudioNative;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cnh {
    public static final aps e = new aps(2);
    public static final dfx[] f = new dfx[0];
    public static String g;

    public static final boolean aa(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static long ab(long j) {
        short s = (short) (j & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        short s2 = (short) ((j >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        short s3 = (short) (s + s2);
        short s4 = (short) (s2 ^ s);
        return ((((long) ((short) ((s4 >>> 22) | (s4 << 10)))) | (((long) ((short) (((short) ((s3 >>> 23) | (s3 << 9))) + s))) << 16)) << 16) | ((long) ((short) (((short) (((short) ((s << 13) | (s >>> 19))) ^ s4)) ^ (s4 << 5))));
    }

    public static final void ac(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction(cnb.z(-47480863456042L));
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static ArrayList ad(Bitmap bitmap, boolean z) {
        int width = z ? bitmap.getWidth() : bitmap.getHeight();
        ArrayList arrayList = new ArrayList();
        int i = width - 1;
        int i2 = -1;
        for (int i3 = 1; i3 < i; i3++) {
            int pixel = z ? bitmap.getPixel(i3, 0) : bitmap.getPixel(0, i3);
            int iAlpha = Color.alpha(pixel);
            int iRed = Color.red(pixel);
            int iGreen = Color.green(pixel);
            int iBlue = Color.blue(pixel);
            if (iAlpha == 255 && iRed == 0 && iGreen == 0 && iBlue == 0) {
                if (i2 == -1) {
                    i2 = i3 - 1;
                }
            } else if (i2 != -1) {
                arrayList.add(new cod(i2, i3 - 1));
                i2 = -1;
            }
        }
        if (i2 != -1) {
            arrayList.add(new cod(i2, width - 2));
        }
        return arrayList;
    }

    public static void ae(String str, Object obj, String str2) {
        kd.a.getClass();
        int i = bte.a;
        cde cdeVarT = dqc.bh(emn.bb(kc.a).getDeclaringClass()).t();
        cdeVarT.ak(cdy.c);
        Class cls = Integer.TYPE;
        cdeVarT.a = dal.b(cls);
        ((cdk) dkz.n(new Object[]{cnb.z(-120332098730794L), dal.b(String.class), dal.b(String.class), dal.b(String.class), dal.b(cls), dal.b(String.class)}, 6, cdeVarT)).e(obj, str2, cnb.z(-120130235267882L), str, 2, null);
    }

    public static File af(File file) throws IOException {
        k(file, cnb.z(-398199302912810L));
        File fileX = x(cnb.z(-398173533109034L));
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = fileX.getAbsolutePath();
        AudioNative audioNative = AudioNative.a;
        audioNative.silkToPcmConvert(absolutePath, absolutePath2, false, 24000, 0);
        File fileX2 = x(cnb.z(-398190712978218L));
        String absolutePath3 = fileX.getAbsolutePath();
        String absolutePath4 = fileX2.getAbsolutePath();
        audioNative.pcmToMp3Init(24000, 1.0f, 1, 24000, 48, 8, 5, 128, 0, 3, 0, 0);
        audioNative.pcmToMp3Convert(absolutePath3, absolutePath4);
        audioNative.pcmToMp3Close();
        fileX.delete();
        return fileX2;
    }

    public static String ag(long j, String str, ZoneId zoneId, int i) {
        if ((i & 1) != 0) {
            str = cnb.z(-47811575937834L);
        }
        if ((i & 2) != 0) {
            zoneId = ZoneId.systemDefault();
        }
        return DateTimeFormatter.ofPattern(str).withZone(zoneId).format(Instant.ofEpochMilli(j));
    }

    public static String h(String str, boolean z) {
        if (!z || str == null || str.length() <= 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        int[] iArr = cib.a;
        if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static final Set i(dfx dfxVar) {
        bzo.q(dfxVar, "<this>");
        if (dfxVar instanceof sr) {
            return ((sr) dfxVar).a();
        }
        HashSet hashSet = new HashSet(dfxVar.i());
        int i = dfxVar.i();
        for (int i2 = 0; i2 < i; i2++) {
            hashSet.add(dfxVar.j(i2));
        }
        return hashSet;
    }

    public static void j(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            StringBuilder sbQ = yg.q(i, i2, "startIndex: ", ", endIndex: ", ", size: ");
            sbQ.append(i3);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(dkz.p(i, "startIndex: ", " > endIndex: ", i2));
        }
    }

    public static void k(File file, String str) throws IOException {
        if (!file.exists() || file.length() == 0) {
            throw new IOException(str.concat(cnb.z(-398598734871338L)));
        }
    }

    public static void l(int i, int i2, int i3) {
        if (i < 0 || i2 > i3) {
            StringBuilder sbQ = yg.q(i, i2, "fromIndex: ", ", toIndex: ", ", size: ");
            sbQ.append(i3);
            throw new IndexOutOfBoundsException(sbQ.toString());
        }
        if (i > i2) {
            throw new IllegalArgumentException(dkz.p(i, "fromIndex: ", " > toIndex: ", i2));
        }
    }

    public static final void m(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                aye.j(th, th2);
            }
        }
    }

    public static final dfx[] n(List list) {
        dfx[] dfxVarArr;
        if (list == null || list.isEmpty()) {
            list = null;
        }
        return (list == null || (dfxVarArr = (dfx[]) list.toArray(new dfx[0])) == null) ? f : dfxVarArr;
    }

    public static pa o(oz ozVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i2 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i2 = current.getIntrinsicHeight();
                    }
                    Lock lock = ele.b;
                    lock.lock();
                    Bitmap bitmapX = ozVar.x(i, i2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmapX);
                        current.setBounds(0, 0, i, i2);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = bitmapX;
                    } catch (Throwable th) {
                        lock.unlock();
                        throw th;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
                z = true;
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            bitmap = null;
            z = true;
        }
        if (!z) {
            ozVar = e;
        }
        return pa.g(bitmap, ozVar);
    }

    public static bbv p(Context context) {
        ProviderInfo providerInfo;
        bbt bbtVar;
        ApplicationInfo applicationInfo;
        nu akjVar = Build.VERSION.SDK_INT >= 28 ? new akj(17) : new nu(17);
        PackageManager packageManager = context.getPackageManager();
        cna.j(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            bbtVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArrAb = akjVar.ab(packageManager, str2);
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArrAb) {
                    arrayList.add(signature.toByteArray());
                }
                bbtVar = new bbt(str, str2, "emojicompat-emoji-font", null, null, Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e2);
                bbtVar = null;
            }
        }
        if (bbtVar == null) {
            return null;
        }
        return new bbv(new bbu(context, bbtVar));
    }

    public static erk q(Class cls) throws InvocationTargetException {
        try {
            Object objNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            bzo.n(objNewInstance);
            return (erk) objNewInstance;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(bjs.l(cls, "Cannot create an instance of "), e4);
        }
    }

    public static final float r(Number number, Context context) {
        return number.floatValue() * context.getResources().getDisplayMetrics().density;
    }

    public static String s(String str, dhx dhxVar) {
        if (dhxVar == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        Matcher matcher = ((Pattern) dhxVar.d).matcher(str);
        int i = dhxVar.c ? Integer.MAX_VALUE : 1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && i3 < str.length() && matcher.find(i3)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            sb.append((CharSequence) str, i3, iStart);
            ArrayList<bcv> arrayList = (ArrayList) dhxVar.e;
            StringBuilder sb2 = new StringBuilder();
            boolean z = false;
            for (bcv bcvVar : arrayList) {
                if (bcvVar instanceof cof) {
                    sb2.append(h(((cof) bcvVar).a, z));
                } else if (bcvVar instanceof acs) {
                    acs acsVar = (acs) bcvVar;
                    String strGroup = matcher.group(acsVar.a);
                    String str2 = acsVar.d;
                    if (str2 == null) {
                        String str3 = acsVar.b;
                        if (str3 == null) {
                            str3 = strGroup;
                        }
                        String str4 = acsVar.c;
                        if (str4 == null) {
                            str4 = "";
                        }
                        if (strGroup == null) {
                            str3 = str4;
                        }
                        sb2.append(h(str3, z));
                    } else if (strGroup != null) {
                        if (str2.equals("upcase")) {
                            sb2.append(h(strGroup.toUpperCase(Locale.ROOT), z));
                        } else if (str2.equals("lowcase")) {
                            sb2.append(h(strGroup.toLowerCase(Locale.ROOT), z));
                        } else {
                            sb2.append(h(strGroup, z));
                        }
                    }
                }
                z = bcvVar instanceof coc;
            }
            sb.append((CharSequence) sb2);
            i2++;
            i3 = iEnd;
        }
        if (i3 < str.length()) {
            sb.append((CharSequence) str, i3, str.length());
        }
        return sb.toString();
    }

    public static String t(Float f2) {
        return new DecimalFormat(cnb.z(-47760036330282L)).format(f2);
    }

    public static final Integer u(Object obj, String str) {
        String strZ = cnb.z(-71932112272170L);
        if (obj instanceof View) {
            Resources resources = ((View) obj).getResources();
            bmo.a.getClass();
            return Integer.valueOf(resources.getIdentifier(str, strZ, bmo.p()));
        }
        if (!(obj instanceof Context)) {
            return null;
        }
        Resources resources2 = ((Context) obj).getResources();
        bmo.a.getClass();
        return Integer.valueOf(resources2.getIdentifier(str, strZ, bmo.p()));
    }

    public static final View v(Object obj, String str) {
        if (obj instanceof View) {
            Integer numU = u(obj, str);
            if (numU != null) {
                return ((View) obj).findViewById(numU.intValue());
            }
        } else if (obj instanceof Activity) {
            Integer numU2 = u(obj, str);
            if (numU2 != null) {
                return ((Activity) obj).findViewById(numU2.intValue());
            }
        } else {
            if (!(obj instanceof Dialog)) {
                ArrayList arrayList = ewq.a;
                ewq.e(cnb.z(-71936407239466L) + str + cnb.z(-71863392795434L), null, 14);
                return null;
            }
            Integer numU3 = u(obj, str);
            if (numU3 != null) {
                return ((Dialog) obj).findViewById(numU3.intValue());
            }
        }
        return null;
    }

    public static int w(String str) throws IOException {
        File file = new File(str);
        k(file, cnb.z(-398139173370666L));
        File fileX = x(cnb.z(-398070453893930L));
        AudioNative.a.silkToPcmConvert(file.getAbsolutePath(), fileX.getAbsolutePath(), false, 24000, 0);
        int length = (int) ((fileX.length() / ((long) 48000)) * ((long) 1000));
        fileX.delete();
        if (length < 1) {
            return 1;
        }
        return length;
    }

    public static File x(String str) {
        String str2 = cnb.z(-398611619773226L) + str + '_' + System.currentTimeMillis() + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        String str3 = g;
        if (str3 != null) {
            return new File(str3, str2);
        }
        throw new IllegalArgumentException(cnb.z(-375221227879210L).toString());
    }

    public static void y(cdk cdkVar, nh nhVar) {
        Method method;
        if (cdkVar == null || (method = cdkVar.a) == null) {
            return;
        }
        z(method, nhVar);
    }

    public static exh z(Member member, nh nhVar) {
        int i;
        exa exaVar;
        if (member == null) {
            exaVar = null;
        } else {
            int iOrdinal = bhs.r().ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal != 1) {
                    throw new abt();
                }
                throw new IllegalStateException("YukiHookAPI cannot support current Hook API or cannot found any available Hook APIs in current environment");
            }
            int iOrdinal2 = bhs.r().ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 != 1) {
                    throw new abt();
                }
                throw new IllegalStateException("YukiHookAPI cannot support current Hook API or cannot found any available Hook APIs in current environment");
            }
            int iOrdinal3 = nhVar.e().ordinal();
            if (iOrdinal3 == 0) {
                i = 50;
            } else if (iOrdinal3 == 1) {
                i = -10000;
            } else {
                if (iOrdinal3 != 2) {
                    throw new abt();
                }
                i = 10000;
            }
            XC_MethodHook.Unhook unhookHookMethod = XposedBridge.hookMethod(member, new bmj(nhVar, i));
            exaVar = new exa(new bmg(unhookHookMethod, 0), new bmg(unhookHookMethod, 1));
        }
        return new exh(exaVar);
    }

    public abstract void b(Throwable th);

    public abstract void c(chm chmVar);
}
