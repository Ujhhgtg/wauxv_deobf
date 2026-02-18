package me.hd.wauxv.obf;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import me.hd.wauxv.R;
import okhttp3.Call;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cnf {
    public static final auj ae = new auj("UNDEFINED", 1);
    public static final auj af = new auj("REUSABLE_CLAIMED", 1);
    public static final boolean[] ag = new boolean[3];
    public static io ah;
    public static long ai;
    public static long aj;
    public static Method ak;

    public static final cwo al(cwo cwoVar, long j) {
        return new cwo(j == 19500 ? cwoVar.j() : cwoVar.i());
    }

    public static cec am(Context context) {
        Resources resources;
        int i = cec.a;
        if (context instanceof cec) {
            throw new IllegalStateException("ModuleContextThemeWrapper already loaded");
        }
        cec cecVar = new cec(context, R.style.AppTheme);
        boolean z = exm.a;
        if (exm.l() && (resources = cecVar.getResources()) != null) {
            bi(resources);
        }
        return cecVar;
    }

    public static void an(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static final void ao(ahf ahfVar) {
        if (ahfVar == null) {
            return;
        }
        Iterator it = ckv.g.iterator();
        bzo.p(it, "NetConfig.runningCalls.iterator()");
        while (it.hasNext()) {
            Call call = (Call) ((WeakReference) it.next()).get();
            if (call == null) {
                it.remove();
            } else {
                Request request = call.request();
                bzo.q(request, "<this>");
                cni cniVar = (cni) request.tag(cni.class);
                Object obj = cniVar != null ? cniVar.a : null;
                if (ahfVar.equals(obj != null ? obj : null)) {
                    call.cancel();
                    it.remove();
                }
            }
        }
    }

    public static final byte ap(char c) {
        if (c < '~') {
            return uc.b[c];
        }
        return (byte) 0;
    }

    public static void aq(adr adrVar, bvm bvmVar, adq adqVar) {
        adqVar.y = -1;
        adb adbVar = adqVar.aw;
        int[] iArr = adqVar.bz;
        adb adbVar2 = adqVar.av;
        adb adbVar3 = adqVar.at;
        adb adbVar4 = adqVar.au;
        adb adbVar5 = adqVar.as;
        adqVar.z = -1;
        int[] iArr2 = adrVar.bz;
        if (iArr2[0] != 2 && iArr[0] == 4) {
            int i = adbVar5.g;
            int iCq = adrVar.cq() - adbVar4.g;
            adbVar5.i = bvmVar.ac(adbVar5);
            adbVar4.i = bvmVar.ac(adbVar4);
            bvmVar.v(adbVar5.i, i);
            bvmVar.v(adbVar4.i, iCq);
            adqVar.y = 2;
            adqVar.bi = i;
            int i2 = iCq - i;
            adqVar.be = i2;
            int i3 = adqVar.bl;
            if (i2 < i3) {
                adqVar.be = i3;
            }
        }
        if (iArr2[1] == 2 || iArr[1] != 4) {
            return;
        }
        int i4 = adbVar3.g;
        int iCm = adrVar.cm() - adbVar2.g;
        adbVar3.i = bvmVar.ac(adbVar3);
        adbVar2.i = bvmVar.ac(adbVar2);
        bvmVar.v(adbVar3.i, i4);
        bvmVar.v(adbVar2.i, iCm);
        if (adqVar.bk > 0 || adqVar.bq == 8) {
            dla dlaVarAc = bvmVar.ac(adbVar);
            adbVar.i = dlaVarAc;
            bvmVar.v(dlaVarAc, adqVar.bk + i4);
        }
        adqVar.z = 2;
        adqVar.bj = i4;
        int i5 = iCm - i4;
        adqVar.bf = i5;
        int i6 = adqVar.bm;
        if (i5 < i6) {
            adqVar.bf = i6;
        }
    }

    public static float ar(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int as(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static String at(ClipData clipData) {
        if (clipData == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clipData.getItemCount(); i++) {
            if (i > 0) {
                sb.append('\n');
            }
            ClipData.Item itemAt = clipData.getItemAt(i);
            if (itemAt.getText() != null) {
                sb.append(itemAt.getText());
            } else if (itemAt.getUri() != null) {
                sb.append(itemAt.getUri().toString());
            } else if (itemAt.getIntent() != null) {
                sb.append(itemAt.getIntent().toUri(1));
            }
        }
        return sb.toString();
    }

    public static int au(czt cztVar, atb atbVar, View view, View view2, czg czgVar, boolean z) {
        if (czgVar.es() == 0 || cztVar.p() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(czg.el(view) - czg.el(view2)) + 1;
        }
        return Math.min(atbVar.o(), atbVar.e(view2) - atbVar.h(view));
    }

    public static int av(czt cztVar, atb atbVar, View view, View view2, czg czgVar, boolean z, boolean z2) {
        if (czgVar.es() == 0 || cztVar.p() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (cztVar.p() - Math.max(czg.el(view), czg.el(view2))) - 1) : Math.max(0, Math.min(czg.el(view), czg.el(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(atbVar.e(view2) - atbVar.h(view)) / (Math.abs(czg.el(view) - czg.el(view2)) + 1))) + (atbVar.n() - atbVar.h(view)));
        }
        return iMax;
    }

    public static int aw(czt cztVar, atb atbVar, View view, View view2, czg czgVar, boolean z) {
        if (czgVar.es() == 0 || cztVar.p() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return cztVar.p();
        }
        return (int) (((atbVar.e(view2) - atbVar.h(view)) / (Math.abs(czg.el(view) - czg.el(view2)) + 1)) * cztVar.p());
    }

    public static final void ax(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }

    public static final void ay(Throwable th) {
        bzo.q(th, "message");
        if (ckv.e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            String string = stringWriter.toString();
            bzo.p(string, "toString(...)");
            Log.d(ckv.f, string);
        }
    }

    public static final boolean az(int i, int i2) {
        return (i & i2) == i2;
    }

    public static void ba(OutputStream outputStream) throws IOException {
        File file = new File((String) ((dov) bc().c).getValue());
        ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
        try {
            baa baaVar = new baa(new bae(new alu(file), true, new blx(26)));
            while (baaVar.hasNext()) {
                File file2 = (File) baaVar.next();
                zipOutputStream.putNextEntry(new ZipEntry(bad.d(file2, file).getPath()));
                FileInputStream fileInputStream = new FileInputStream(file2);
                try {
                    bhu.w(fileInputStream, zipOutputStream);
                    fileInputStream.close();
                    zipOutputStream.closeEntry();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        cnh.m(fileInputStream, th);
                        throw th2;
                    }
                }
            }
            zipOutputStream.close();
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                cnh.m(zipOutputStream, th3);
                throw th4;
            }
        }
    }

    public static final zc bb(Annotation annotation) {
        bzo.q(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        bzo.p(clsAnnotationType, "annotationType(...)");
        return dal.b(clsAnnotationType);
    }

    public static io bc() {
        io ioVar = ah;
        if (ioVar != null) {
            return ioVar;
        }
        throw new IllegalArgumentException("DefaultConfig must be init" /* cnb.z(-5763846109994L) */.toString());
    }

    public static final Class bd(bsv bsvVar) {
        bzo.q(bsvVar, "<this>");
        Class clsA = ((yq) bsvVar).a();
        bzo.o(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class be(bsv bsvVar) {
        bzo.q(bsvVar, "<this>");
        Class clsA = ((yq) bsvVar).a();
        if (clsA.isPrimitive()) {
            String name = clsA.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return clsA;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Class bf(zc zcVar) {
        Class clsA = zcVar.a();
        if (clsA.isPrimitive()) {
            return clsA;
        }
        String name = clsA.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    public static void bg(InputStream inputStream) throws IOException {
        File file = new File((String) ((dov) bc().c).getValue());
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return;
                }
                File file2 = new File(file, nextEntry.getName());
                File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    bhu.w(zipInputStream, fileOutputStream);
                    fileOutputStream.close();
                    zipInputStream.closeEntry();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        cnh.m(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    cnh.m(zipInputStream, th3);
                    throw th4;
                }
            }
        }
    }

    public static final void bh(Context context) {
        Resources resources = context.getResources();
        if (resources != null) {
            bi(resources);
        }
    }

    public static final void bi(Resources resources) {
        Object objX;
        ki.a.getClass();
        boolean z = exm.a;
        if (!exm.l()) {
            ewq.h("You can only inject module resources in Xposed Environment");
            return;
        }
        try {
            objX = null;
        } catch (Throwable th) {
            objX = bhu.x(th);
        }
        if (ki.i().equals(exm.h)) {
            ewq.g(6, "You cannot inject module resources into yourself", null);
            return;
        }
        int i = bte.a;
        bmu bmuVarBi = dqc.bi(resources.getAssets());
        dov dovVar = ep.a;
        ((cbg) bmuVarBi.h).c = bhu.aa();
        bmuVarBi.v(true);
        cde cdeVarT = bmuVarBi.t();
        cdeVarT.ab = "addAssetPath";
        cdeVarT.z(Arrays.copyOf(new Object[]{dal.b(String.class)}, 1));
        cdk cdkVar = (cdk) aaz.g(cdeVarT.aj());
        if (cdkVar != null) {
            objX = cdkVar.e(exm.i);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            ArrayList arrayList = ewq.a;
            ewq.g(4, "Failed to inject module resources into [" + resources + "]", thB);
        }
    }

    public static boolean bj() {
        if (Build.VERSION.SDK_INT >= 29) {
            return ekw.a();
        }
        try {
            if (ak == null) {
                aj = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                ak = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) ak.invoke(null, Long.valueOf(aj))).booleanValue();
        } catch (Exception e) {
            if (!(e instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
                return false;
            }
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static final void bk(Object obj, afw afwVar) throws aoq {
        if (!(afwVar instanceof aor)) {
            afwVar._bn(obj);
            return;
        }
        aor aorVar = (aor) afwVar;
        ahj ahjVar = aorVar.d;
        afx afxVar = aorVar.e;
        ahh ahhVar = afxVar.m;
        Throwable thB = dcy.b(obj);
        Object abrVar = thB == null ? obj : new abr(thB, false);
        bzo.n(ahhVar);
        try {
            if (ahjVar.j(ahhVar)) {
                aorVar.f = abrVar;
                aorVar.z = 1;
                bzo.n(ahhVar);
                bl(ahjVar, ahhVar, aorVar);
                return;
            }
            awv awvVarB = dro.b();
            if (awvVarB.x >= 4294967296L) {
                aorVar.f = abrVar;
                aorVar.z = 1;
                km kmVar = awvVarB.z;
                if (kmVar == null) {
                    kmVar = new km();
                    awvVarB.z = kmVar;
                }
                kmVar.addLast(aorVar);
                return;
            }
            awvVarB.ab(true);
            try {
                bzo.n(ahhVar);
                brf brfVar = (brf) ahhVar._w(arj.i);
                if (brfVar == null || brfVar.m()) {
                    Object obj2 = aorVar.g;
                    bzo.n(ahhVar);
                    Object objAl = bhv.al(ahhVar, obj2);
                    enk enkVarAu = objAl != bhv.q ? bzo.au(afxVar, ahhVar, objAl) : null;
                    try {
                        afxVar._bn(obj);
                        if (enkVarAu == null || enkVarAu.as()) {
                            bhv.ag(ahhVar, objAl);
                        }
                    } catch (Throwable th) {
                        if (enkVarAu == null || enkVarAu.as()) {
                            bhv.ag(ahhVar, objAl);
                        }
                        throw th;
                    }
                } else {
                    aorVar._bn(bhu.x(brfVar.n()));
                }
                while (awvVarB.ac()) {
                }
            } catch (Throwable th2) {
                try {
                    aorVar.aa(th2);
                } finally {
                    awvVarB.aa();
                }
            }
        } catch (Throwable th3) {
            throw new aoq(th3, ahjVar, ahhVar);
        }
    }

    public static final void bl(ahj ahjVar, ahh ahhVar, Runnable runnable) throws aoq {
        try {
            ahjVar.i(ahhVar, runnable);
        } catch (Throwable th) {
            throw new aoq(th, ahjVar, ahhVar);
        }
    }

    public static void bm(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }

    public static float bn() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        float f = ((float) ai) > 0.0f ? (jUptimeMillis - r2) / 1000.0f : 0.0f;
        ai = jUptimeMillis;
        return Math.min(0.021f, f);
    }

    public static final String bo(byte b) {
        return b == 1 ? "quotation mark '\"'" : b == 2 ? "string escape sequence '\\'" : b == 4 ? "comma ','" : b == 5 ? "colon ':'" : b == 6 ? "start of the object '{'" : b == 7 ? "end of the object '}'" : b == 8 ? "start of the array '['" : b == 9 ? "end of the array ']'" : b == 10 ? "end of the input" : b == 127 ? "invalid token" : "valid token";
    }

    public void bp(View view, int i) {
    }

    public abstract int c(View view, int i);

    public abstract int d(View view, int i);

    public int e(View view) {
        return 0;
    }

    public int f() {
        return 0;
    }

    public abstract void g(int i);

    public abstract void h(View view, int i, int i2);

    public abstract void i(View view, float f, float f2);

    public abstract boolean j(View view, int i);
}
