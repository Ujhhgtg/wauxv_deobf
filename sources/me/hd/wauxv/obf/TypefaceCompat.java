package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypefaceCompat {
    public static final StaticHelpers7 a;
    public static final byj b;
    public static Paint c;

    static {
        HugeSyntheticPileOfHelpers.beginTrace("TypefaceCompat static init");
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            a = new emj();
        } else if (i >= 29) {
            a = new emi();
        } else if (i >= 28) {
            a = new emh();
        } else {
            a = new emg();
        }
        b = new byj(16);
        c = null;
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface d(Context context, bca bcaVar, Resources resources, int i, String str, int i2, int i3,
                             ResourcesCompat resourcesCompatVar, boolean z) {
        Typeface typefaceS;
        Typeface typefaceBuild;
        FontFamily fontFamilyBuild;
        int i4 = 7;
        int i5 = -3;
        if (bcaVar instanceof bcd) {
            bcd bcdVar = (bcd) bcaVar;
            String str2 = bcdVar.d;
            typefaceS = null;
            int i6 = 1;
            boolean z2 = false;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            if (TextUtils.isEmpty(str2) || (typefaceBuild = f(str2)) == null) {
                ArrayList arrayList = bcdVar.a;
                if (arrayList.size() != 1) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i7 = 0;
                        while (true) {
                            if (i7 >= arrayList.size()) {
                                Typeface.CustomFallbackBuilder customFallbackBuilderC = null;
                                int i8 = 0;
                                while (true) {
                                    if (i8 < arrayList.size()) {
                                        bbt bbtVar = (bbt) arrayList.get(i8);
                                        if (i8 == arrayList.size() - 1 && TextUtils.isEmpty(bbtVar.f)) {
                                            customFallbackBuilderC.setSystemFallback(bbtVar.e);
                                        } else {
                                            String str3 = bbtVar.e;
                                            String str4 = bbtVar.f;
                                            Font fontG = g(f(str3));
                                            if (fontG == null) {
                                                Log.w("TypefaceCompat", "Unable identify the primary font for "
                                                        + bbtVar.e + ". Falling back to provider font.");
                                            } else {
                                                if (TextUtils.isEmpty(str4)) {
                                                    try {
                                                        dql.n();
                                                        dql.w();
                                                        fontFamilyBuild = dql.dexFind(
                                                                qc.i(fontG).setFontVariationSettings(str4).build())
                                                                .build();
                                                    } catch (IOException unused) {
                                                        Log.e("TypefaceCompat",
                                                                "Failed to clone Font instance. Fall back to provider font.");
                                                    }
                                                } else {
                                                    fontFamilyBuild = dql.dexFind(fontG).build();
                                                }
                                                if (customFallbackBuilderC == null) {
                                                    customFallbackBuilderC = dql.c(fontFamilyBuild);
                                                } else {
                                                    customFallbackBuilderC.addCustomFallback(fontFamilyBuild);
                                                }
                                                i8++;
                                            }
                                        }
                                    }
                                    typefaceBuild = customFallbackBuilderC.build();
                                    break;
                                }
                            }
                            if (f(((bbt) arrayList.get(i7)).e) != null) {
                                i7++;
                            }
                            typefaceBuild = null;
                            break;
                        }
                    }
                    typefaceBuild = null;
                    break;
                }
                typefaceBuild = f(((bbt) arrayList.get(0)).e);
            }
            if (typefaceBuild != null) {
                if (resourcesCompatVar != null) {
                    new Handler(Looper.getMainLooper()).post(new hl(resourcesCompatVar, i4, typefaceBuild));
                }
                b.v(e(resources, i, str, i2, i3), typefaceBuild);
                return typefaceBuild;
            }
            Object[] objArr3 = !z ? resourcesCompatVar != null : bcdVar.c != 0;
            int i9 = z ? bcdVar.b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            SyntheticPileOfMess bmuVar = new SyntheticPileOfMess();
            bmuVar.obj = resourcesCompatVar;
            ArrayList arrayList2 = bcdVar.a;
            dby dbyVar = new dby(handler);
            DefaultConfig ioVar = new DefaultConfig(bmuVar, 10, dbyVar);
            int i10 = 4;
            if (objArr3 != true) {
                String strE = bbz.e(i3, arrayList2);
                Typeface typeface = (Typeface) bbz.a.o(strE);
                if (typeface != null) {
                    dbyVar.execute(new cs(bmuVar, typeface, i10, objArr2 == true ? 1 : 0));
                    typefaceS = typeface;
                } else {
                    bbx bbxVar = new bbx(ioVar, objArr == true ? 1 : 0);
                    synchronized (bbz.c) {
                        try {
                            dhq dhqVar = bbz.d;
                            ArrayList arrayList3 = (ArrayList) dhqVar.get(strE);
                            if (arrayList3 != null) {
                                arrayList3.add(bbxVar);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(bbxVar);
                                dhqVar.put(strE, arrayList4);
                                bbw bbwVar = new bbw(strE, context, arrayList2, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = bbz.b;
                                bbx bbxVar2 = new bbx(strE, i6);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper())
                                        : new Handler();
                                bkh bkhVar = new bkh();
                                bkhVar.b = bbwVar;
                                bkhVar.c = bbxVar2;
                                bkhVar.d = handler2;
                                threadPoolExecutor.execute(bkhVar);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    throw new IllegalArgumentException(
                            "Fallbacks with blocking fetches are not supported for performance reasons");
                }
                bbt bbtVar2 = (bbt) arrayList2.get(0);
                byj byjVar = bbz.a;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[] { bbtVar2 }[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String strE2 = bbz.e(i3, Collections.unmodifiableList(arrayList5));
                Typeface typeface2 = (Typeface) bbz.a.o(strE2);
                if (typeface2 != null) {
                    dbyVar.execute(new cs(bmuVar, typeface2, i10, z2));
                    typefaceS = typeface2;
                } else if (i9 == -1) {
                    Object[] objArr4 = { bbtVar2 };
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = objArr4[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    bby bbyVarF = bbz.f(strE2, context, Collections.unmodifiableList(arrayList6), i3);
                    ioVar.aq(bbyVarF);
                    typefaceS = bbyVarF.a;
                } else {
                    try {
                        try {
                            try {
                                bby bbyVar = (bby) bbz.b.submit(new bbw(strE2, context, bbtVar2, i3, 0)).get(i9,
                                        TimeUnit.MILLISECONDS);
                                ioVar.aq(bbyVar);
                                typefaceS = bbyVar.a;
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        } catch (TimeoutException unused2) {
                            throw new InterruptedException("timeout");
                        }
                    } catch (InterruptedException unused3) {
                        ((dby) ioVar.d).execute(new np((SyntheticPileOfMess) ioVar.c, i5, i6));
                    }
                }
            }
        } else {
            typefaceS = a.s(context, (bcb) bcaVar, resources, i3);
            if (resourcesCompatVar != null) {
                if (typefaceS != null) {
                    new Handler(Looper.getMainLooper()).post(new hl(resourcesCompatVar, i4, typefaceS));
                } else {
                    resourcesCompatVar.ai(-3);
                }
            }
        }
        if (typefaceS != null) {
            b.v(e(resources, i, str, i2, i3), typefaceS);
        }
        return typefaceS;
    }

    public static String e(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + SignatureVisitor.SUPER + str + SignatureVisitor.SUPER + i2
                + SignatureVisitor.SUPER + i + SignatureVisitor.SUPER + i3;
    }

    public static Typeface f(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface typefaceCreate = Typeface.create(str, 0);
            Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
            if (typefaceCreate != null && !typefaceCreate.equals(typefaceCreate2)) {
                return typefaceCreate;
            }
        }
        return null;
    }

    public static Font g(Typeface typeface) {
        if (c == null) {
            c = new Paint();
        }
        c.setTextSize(10.0f);
        c.setTypeface(typeface);
        PositionedGlyphs positionedGlyphsShapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f,
                0.0f, false, c);
        if (positionedGlyphsShapeTextRun.glyphCount() == 0) {
            return null;
        }
        return positionedGlyphsShapeTextRun.getFont(0);
    }
}
