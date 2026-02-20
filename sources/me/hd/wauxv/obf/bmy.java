package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.data.bean.info.FriendInfo;
import me.hd.wauxv.data.bean.info.GroupInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bmy {
    public static final Object[] g = new Object[0];
    public static final nu h = new nu(18);
    public static final ex i = new ex(11);

    public static ahh aa(ahf ahfVar, ahh ahhVar) {
        throwIfVar1IsNull(ahhVar, "context");
        return ahhVar == EmptyCoroutineContext.INSTANCE ? ahfVar : (ahh) ahhVar._u(ahfVar, new fq(3));
    }

    public static Cursor ab(aer[] aerVarArr) {
        if (aerVarArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(
                "SELECT contact.*\nFROM rcontact contact\nLEFT JOIN rconversation conversation ON contact.username = conversation.username\nWHERE " /*
                                                                                                                                                     * cnb
                                                                                                                                                     * .
                                                                                                                                                     * z
                                                                                                                                                     * (
                                                                                                                                                     * -
                                                                                                                                                     * 73525545138986L)
                                                                                                                                                     */);
        int length = aerVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            String[] strArr = aerVarArr[i2].d;
            int length2 = strArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length2) {
                int i7 = i6 + 1;
                sb.append(strArr[i5]);
                if (i6 != r5.d.length - 1) {
                    sb.append("\nAND " /* "\nAND " /* "\nAND " /* cnb.z(-72980084292394L)  */);
                }
                i5++;
                i6 = i7;
            }
            if (i3 != aerVarArr.length - 1) {
                sb.append("\nOR " /* "\nOR " /* "\nOR " /* cnb.z(-72937134619434L)  */);
            }
            if (i3 == aerVarArr.length - 1) {
                sb.append("\n" /* "\n" /* "\n" /* cnb.z(-72881300044586L)  */);
            }
            i2++;
            i3 = i4;
        }
        sb.append(
                "ORDER BY\nCASE WHEN conversation.username IS NOT NULL THEN 0 ELSE 1 END,\nCOALESCE(conversation.conversationTime, 0) DESC,\ncontact.username" /*
                                                                                                                                                                * cnb
                                                                                                                                                                * .
                                                                                                                                                                * z
                                                                                                                                                                * (
                                                                                                                                                                * -
                                                                                                                                                                * 72889889979178L)
                                                                                                                                                                */);
        return arj.ac(sb.toString());
    }

    public static void ac(Drawable drawable, int i2) {
        drawable.setTint(i2);
    }

    public static void ad(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void ae(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static void af(Activity activity, View view) {
        ResourcesCompat resourcesCompatVar = anj.a;
        FrameLayout frameLayout = new FrameLayout(activity);
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 16;
        layoutParams.format = -2;
        layoutParams.type = 1003;
        layoutParams.flags = 201327872;
        layoutParams.softInputMode = 16;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        windowManager.addView(frameLayout, layoutParams);
    }

    public static void ag(Class cls, ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException(concatVar2Var1(cls, "Unable to instantiate GlideModule implementation for "),
                reflectiveOperationException);
    }

    public static final Object[] ah(Collection collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                        throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i3);
                        throwIfVar1IsNull(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i2 = i3;
                }
            }
        }
        return g;
    }

    public static final Object[] ai(Collection collection, Object[] objArr) {
        Object[] objArrCopyOf;
        int size = collection.size();
        int i2 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArrCopyOf = objArr;
                } else {
                    Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    throwIfVar1IsNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                    objArrCopyOf = (Object[]) objNewInstance;
                }
                while (true) {
                    int i3 = i2 + 1;
                    objArrCopyOf[i2] = it.next();
                    if (i3 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i4 = ((i3 * 3) + 1) >>> 1;
                        if (i4 <= i3) {
                            i4 = 2147483645;
                            if (i3 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i4);
                        throwIfVar1IsNull(objArrCopyOf, "copyOf(...)");
                    } else if (!it.hasNext()) {
                        if (objArrCopyOf == objArr) {
                            objArr[i3] = null;
                            return objArr;
                        }
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i3);
                        throwIfVar1IsNull(objArrCopyOf2, "copyOf(...)");
                        return objArrCopyOf2;
                    }
                    i2 = i3;
                }
            } else if (objArr.length > 0) {
                objArr[0] = null;
            }
        } else if (objArr.length > 0) {
            objArr[0] = null;
            return objArr;
        }
        return objArr;
    }

    public static final azt aj(File file) {
        int length;
        List list;
        int iAh;
        throwIfVar1IsNull(file, "<this>");
        String path = file.getPath();
        throwIfVar1IsNull(path);
        char c = File.separatorChar;
        int iAh2 = dnj.ah(c, 0, 4, path);
        if (iAh2 != 0) {
            length = (iAh2 <= 0 || path.charAt(iAh2 + (-1)) != ':')
                    ? (iAh2 == -1 && path.length() > 0 && cmz.u(path.charAt(dnj.ae(path)), ':', false)) ? path.length()
                            : 0
                    : iAh2 + 1;
        } else if (path.length() <= 1 || path.charAt(1) != c || (iAh = dnj.ah(c, 2, 4, path)) < 0) {
            length = 1;
        } else {
            int iAh3 = dnj.ah(c, iAh + 1, 4, path);
            length = iAh3 >= 0 ? iAh3 + 1 : path.length();
        }
        String strSubstring = path.substring(0, length);
        throwIfVar1IsNull(strSubstring, "substring(...)");
        String strSubstring2 = path.substring(length);
        throwIfVar1IsNull(strSubstring2, "substring(...)");
        if (strSubstring2.length() == 0) {
            list = EmptyReadonlyList.INSTANCE;
        } else {
            List listAr = dnj.ar(strSubstring2, new char[] { c });
            ArrayList arrayList = new ArrayList(StaticHelpers4.ak(listAr, 10));
            Iterator it = listAr.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new azt(new File(strSubstring), list);
    }

    public static final bpj j(String str, btd btdVar) {
        return new bpj(str, new bpk(btdVar));
    }

    /* JADX WARN: Found duplicated region for block: B:188:0x0292 */
    /* JADX WARN: Found duplicated region for block: B:205:0x02db */
    /* JADX WARN: Found duplicated region for block: B:207:0x02de */
    /* JADX WARN: Found duplicated region for block: B:209:0x02e4 */
    /* JADX WARN: Found duplicated region for block: B:232:0x0376 */
    /* JADX WARN: Found duplicated region for block: B:234:0x0392 */
    /* JADX WARN: Found duplicated region for block: B:236:0x0397 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:240:0x03c3 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:251:0x042b */
    /* JADX WARN: Found duplicated region for block: B:406:0x06a7 */
    /* JADX WARN: Found duplicated region for block: B:409:0x06b2 */
    /* JADX WARN: Found duplicated region for block: B:410:0x06b5 */
    /* JADX WARN: Found duplicated region for block: B:413:0x06bb */
    /* JADX WARN: Found duplicated region for block: B:414:0x06be */
    /* JADX WARN: Found duplicated region for block: B:416:0x06c2 */
    /* JADX WARN: Found duplicated region for block: B:418:0x06ca */
    /* JADX WARN: Found duplicated region for block: B:421:0x06d2 */
    /*
     * JADX WARN: Found duplicated region for block: B:423:0x06d6 A[ADDED_TO_REGION]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:433:0x06f2 A[ADDED_TO_REGION,
     * REMOVE, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:66:0x00f3 */
    /* JADX WARN: Found duplicated region for block: B:75:0x0114 */
    public static void k(adr adrVar, bvm bvmVar, ArrayList arrayList, int i2) {
        int i3;
        tp[] tpVarArr;
        int i4;
        int i5;
        adb[] adbVarArr;
        boolean z;
        adq adqVar;
        float f;
        boolean z2;
        boolean z3;
        int i6;
        adq adqVar2;
        bvm bvmVar2;
        adq adqVar3;
        dla dlaVar;
        adb adbVar;
        dla dlaVar2;
        adq adqVar4;
        int i7;
        adb adbVar2;
        dla dlaVar3;
        adq adqVar5;
        adb[] adbVarArr2;
        adq adqVar6;
        int i8;
        adb[] adbVarArr3;
        int i9;
        adb adbVar3;
        dla dlaVar4;
        dla dlaVar5;
        int size;
        ArrayList arrayList2;
        int i10;
        adq adqVar7;
        int i11;
        float f2;
        int i12;
        dla dlaVar6;
        dla dlaVar7;
        dla dlaVar8;
        dla dlaVar9;
        kw kwVarAd;
        float f3;
        float f4;
        adb adbVar4;
        adq adqVar8;
        int i13;
        boolean z4;
        int i14;
        int i15;
        adq adqVar9;
        adr adrVar2 = adrVar;
        bvm bvmVar3 = bvmVar;
        ArrayList arrayList3 = arrayList;
        if (i2 == 0) {
            i3 = adrVar2.dq;
            tpVarArr = adrVar2.dt;
            i4 = 0;
        } else {
            i3 = adrVar2.dr;
            tpVarArr = adrVar2.ds;
            i4 = 2;
        }
        int i16 = i3;
        tp[] tpVarArr2 = tpVarArr;
        int i17 = 0;
        while (i17 < i16) {
            tp tpVar = tpVarArr2[i17];
            boolean z5 = tpVar.q;
            adq adqVar10 = tpVar.a;
            adb[] adbVarArr4 = adqVar10.ba;
            int i18 = 3;
            int i19 = 8;
            float f5 = 0.0f;
            if (z5) {
                i5 = i17;
            } else {
                int i20 = tpVar.l;
                int i21 = i20 * 2;
                adq adqVar11 = adqVar10;
                adq adqVar12 = adqVar11;
                boolean z6 = false;
                while (!z6) {
                    tpVar.i++;
                    adq[] adqVarArr = adqVar11.bw;
                    adb[] adbVarArr5 = adqVar11.ba;
                    adqVarArr[i20] = null;
                    adqVar11.bv[i20] = null;
                    if (adqVar11.bq != i19) {
                        adqVar11.cl(i20);
                        adbVarArr5[i21].n();
                        int i22 = i21 + 1;
                        adbVarArr5[i22].n();
                        adbVarArr5[i21].n();
                        adbVarArr5[i22].n();
                        if (tpVar.b == null) {
                            tpVar.b = adqVar11;
                        }
                        tpVar.d = adqVar11;
                        int i23 = adqVar11.bz[i20];
                        if (i23 == i18) {
                            int i24 = adqVar11.ad[i20];
                            if (i24 == 0 || i24 == i18 || i24 == 2) {
                                tpVar.j++;
                                float f6 = adqVar11.bu[i20];
                                if (f6 > 0.0f) {
                                    i14 = i17;
                                    tpVar.k += f6;
                                } else {
                                    i14 = i17;
                                }
                                i15 = i20;
                                if (adqVar11.bq != 8 && i23 == 3 && (i24 == 0 || i24 == 3)) {
                                    if (f6 < 0.0f) {
                                        tpVar.n = true;
                                    } else {
                                        tpVar.o = true;
                                    }
                                    if (tpVar.h == null) {
                                        tpVar.h = new ArrayList();
                                    }
                                    tpVar.h.add(adqVar11);
                                }
                                if (tpVar.f == null) {
                                    tpVar.f = adqVar11;
                                }
                                adq adqVar13 = tpVar.g;
                                if (adqVar13 != null) {
                                    adqVar13.bv[i15] = adqVar11;
                                }
                                tpVar.g = adqVar11;
                            } else {
                                i14 = i17;
                                i15 = i20;
                            }
                            if (i15 == 0) {
                                if (adqVar11.ab == 0 && adqVar11.ae == 0) {
                                    int i25 = adqVar11.af;
                                }
                            } else if (adqVar11.ac == 0 && adqVar11.ah == 0) {
                                int i26 = adqVar11.ai;
                            }
                        } else {
                            i14 = i17;
                            i15 = i20;
                        }
                    } else {
                        i14 = i17;
                        i15 = i20;
                    }
                    adq adqVar14 = adqVar12;
                    if (adqVar14 != adqVar11) {
                        adqVar14.bw[i15] = adqVar11;
                    }
                    adb adbVar5 = adbVarArr5[i21 + 1].f;
                    if (adbVar5 != null) {
                        adqVar9 = adbVar5.d;
                        adb adbVar6 = adqVar9.ba[i21].f;
                        if (adbVar6 == null || adbVar6.d != adqVar11) {
                            adqVar9 = null;
                        }
                    } else {
                        adqVar9 = null;
                    }
                    if (adqVar9 == null) {
                        adqVar9 = adqVar11;
                        z6 = true;
                    }
                    adqVar12 = adqVar11;
                    i20 = i15;
                    i18 = 3;
                    i19 = 8;
                    adqVar11 = adqVar9;
                    i17 = i14;
                }
                i5 = i17;
                int i27 = i20;
                adq adqVar15 = tpVar.b;
                if (adqVar15 != null) {
                    adqVar15.ba[i21].n();
                }
                adq adqVar16 = tpVar.d;
                if (adqVar16 != null) {
                    adqVar16.ba[i21 + 1].n();
                }
                tpVar.c = adqVar11;
                if (i27 == 0 && tpVar.m) {
                    tpVar.e = adqVar11;
                } else {
                    tpVar.e = adqVar10;
                }
                tpVar.p = tpVar.o && tpVar.n;
            }
            tpVar.q = true;
            if (arrayList3 == null || arrayList3.contains(adqVar10)) {
                adq adqVar17 = tpVar.c;
                adq adqVar18 = tpVar.b;
                adq adqVar19 = tpVar.d;
                adq adqVar20 = tpVar.e;
                float f7 = tpVar.k;
                int[] iArr = adrVar2.bz;
                adb[] adbVarArr6 = adrVar2.ba;
                boolean z7 = iArr[i2] == 2;
                if (i2 == 0) {
                    int i28 = adqVar20.bs;
                    boolean z8 = i28 == 0;
                    adbVarArr = adbVarArr4;
                    boolean z9 = i28 == 1;
                    z = i28 == 2;
                    adqVar = adqVar10;
                    f = f7;
                    z3 = z9;
                    z2 = z8;
                } else {
                    adbVarArr = adbVarArr4;
                    int i29 = adqVar20.bt;
                    boolean z10 = i29 == 0;
                    boolean z11 = i29 == 1;
                    z = i29 == 2;
                    adqVar = adqVar10;
                    f = f7;
                    z2 = z10;
                    z3 = z11;
                }
                boolean z12 = false;
                while (!z12) {
                    adb[] adbVarArr7 = adqVar.ba;
                    int[] iArr2 = adqVar.bz;
                    adb adbVar7 = adbVarArr7[i4];
                    int i30 = z ? 1 : 4;
                    int iN = adbVar7.n();
                    boolean z13 = z7;
                    boolean z14 = z;
                    boolean z15 = iArr2[i2] == 3 && adqVar.ad[i2] == 0;
                    adb adbVar8 = adbVar7.f;
                    if (adbVar8 != null && adqVar != adqVar10) {
                        iN = adbVar8.n() + iN;
                    }
                    int i31 = iN;
                    if (z14 && adqVar != adqVar10 && adqVar != adqVar18) {
                        i30 = 8;
                    }
                    adq adqVar21 = adqVar10;
                    adb adbVar9 = adbVar7.f;
                    if (adbVar9 != null) {
                        if (adqVar == adqVar18) {
                            z4 = z15;
                            bvmVar3.x(adbVar7.i, adbVar9.i, i31, 6);
                        } else {
                            z4 = z15;
                            bvmVar3.x(adbVar7.i, adbVar9.i, i31, 8);
                        }
                        if (z4 && !z14) {
                            i30 = 5;
                        }
                        bvmVar3.w(adbVar7.i, adbVar7.f.i, i31, (adqVar == adqVar18 && z14 && adqVar.bc[i2]) ? 5 : i30);
                    }
                    if (z13) {
                        if (adqVar.bq == 8 || iArr2[i2] != 3) {
                            i13 = 0;
                        } else {
                            i13 = 0;
                            bvmVar3.x(adbVarArr7[i4 + 1].i, adbVarArr7[i4].i, 0, 5);
                        }
                        bvmVar3.x(adbVarArr7[i4].i, adbVarArr6[i4].i, i13, 8);
                    }
                    adb adbVar10 = adbVarArr7[i4 + 1].f;
                    if (adbVar10 != null) {
                        adqVar8 = adbVar10.d;
                        adb adbVar11 = adqVar8.ba[i4].f;
                        if (adbVar11 == null || adbVar11.d != adqVar) {
                            adqVar8 = null;
                        }
                    } else {
                        adqVar8 = null;
                    }
                    if (adqVar8 != null) {
                        adqVar = adqVar8;
                    } else {
                        z12 = true;
                    }
                    adqVar10 = adqVar21;
                    z7 = z13;
                    z = z14;
                }
                boolean z16 = z7;
                boolean z17 = z;
                if (adqVar19 != null) {
                    int i32 = i4 + 1;
                    if (adqVar17.ba[i32].f != null) {
                        adb adbVar12 = adqVar19.ba[i32];
                        if (adqVar19.bz[i2] == 3 && adqVar19.ad[i2] == 0 && !z17) {
                            adb adbVar13 = adbVar12.f;
                            if (adbVar13.d == adrVar2) {
                                bvmVar3.w(adbVar12.i, adbVar13.i, -adbVar12.n(), 5);
                            } else if (z17) {
                                adbVar4 = adbVar12.f;
                                if (adbVar4.d == adrVar2) {
                                    bvmVar3.w(adbVar12.i, adbVar4.i, -adbVar12.n(), 4);
                                }
                            }
                        } else if (z17) {
                            adbVar4 = adbVar12.f;
                            if (adbVar4.d == adrVar2) {
                                bvmVar3.w(adbVar12.i, adbVar4.i, -adbVar12.n(), 4);
                            }
                        }
                        bvmVar3.y(adbVar12.i, adqVar17.ba[i32].f.i, -adbVar12.n(), 6);
                    }
                }
                if (z16) {
                    int i33 = i4 + 1;
                    dla dlaVar10 = adbVarArr6[i33].i;
                    adb adbVar14 = adqVar17.ba[i33];
                    bvmVar3.x(dlaVar10, adbVar14.i, adbVar14.n(), 8);
                }
                ArrayList arrayList4 = tpVar.h;
                if (arrayList4 != null && (size = arrayList4.size()) > 1) {
                    if (tpVar.n && !tpVar.p) {
                        f = tpVar.j;
                    }
                    adq adqVar22 = null;
                    float f8 = 0.0f;
                    int i34 = 0;
                    while (i34 < size) {
                        adq adqVar23 = (adq) arrayList4.get(i34);
                        float[] fArr = adqVar23.bu;
                        adb[] adbVarArr8 = adqVar23.ba;
                        float f9 = fArr[i2];
                        if (f9 >= f5) {
                            arrayList2 = arrayList4;
                            i10 = size;
                            if (f9 == f5) {
                                f4 = f8;
                                bvmVar3.w(adbVarArr8[i4 + 1].i, adbVarArr8[i4].i, 0, 8);
                                i11 = i34;
                                f2 = f5;
                                f8 = f4;
                                i12 = i16;
                            } else {
                                float f10 = f8;
                                if (adqVar22 != null) {
                                    adb[] adbVarArr9 = adqVar22.ba;
                                    dlaVar6 = adbVarArr9[i4].i;
                                    int i35 = i4 + 1;
                                    dlaVar7 = adbVarArr9[i35].i;
                                    dlaVar8 = adbVarArr8[i4].i;
                                    dlaVar9 = adbVarArr8[i35].i;
                                    kwVarAd = bvmVar3.ad();
                                    adqVar7 = adqVar23;
                                    f3 = f5;
                                    kwVarAd.b = f3;
                                    f2 = f3;
                                    if (f != f3 || f10 == f9) {
                                        i11 = i34;
                                        i12 = i16;
                                        kwVarAd.d.q(dlaVar6, 1.0f);
                                        kwVarAd.d.q(dlaVar7, -1.0f);
                                        kwVarAd.d.q(dlaVar9, 1.0f);
                                        kwVarAd.d.q(dlaVar8, -1.0f);
                                    } else {
                                        if (f10 == f2) {
                                            kwVarAd.d.q(dlaVar6, 1.0f);
                                            kwVarAd.d.q(dlaVar7, -1.0f);
                                        } else if (f9 == f5) {
                                            kwVarAd.d.q(dlaVar8, 1.0f);
                                            kwVarAd.d.q(dlaVar9, -1.0f);
                                        } else {
                                            i11 = i34;
                                            float f11 = (f10 / f) / (f9 / f);
                                            i12 = i16;
                                            kwVarAd.d.q(dlaVar6, 1.0f);
                                            kwVarAd.d.q(dlaVar7, -1.0f);
                                            kwVarAd.d.q(dlaVar9, f11);
                                            kwVarAd.d.q(dlaVar8, -f11);
                                        }
                                        i11 = i34;
                                        i12 = i16;
                                    }
                                    bvmVar3.u(kwVarAd);
                                } else {
                                    adqVar7 = adqVar23;
                                    i11 = i34;
                                    f2 = f5;
                                    i12 = i16;
                                }
                                f8 = f9;
                                adqVar22 = adqVar7;
                            }
                        } else {
                            if (tpVar.p) {
                                arrayList2 = arrayList4;
                                i10 = size;
                                bvmVar3.w(adbVarArr8[i4 + 1].i, adbVarArr8[i4].i, 0, 4);
                                f4 = f8;
                            } else {
                                f9 = 1.0f;
                                arrayList2 = arrayList4;
                                i10 = size;
                                if (f9 == f5) {
                                    f4 = f8;
                                    bvmVar3.w(adbVarArr8[i4 + 1].i, adbVarArr8[i4].i, 0, 8);
                                } else {
                                    float f102 = f8;
                                    if (adqVar22 != null) {
                                        adb[] adbVarArr92 = adqVar22.ba;
                                        dlaVar6 = adbVarArr92[i4].i;
                                        int i352 = i4 + 1;
                                        dlaVar7 = adbVarArr92[i352].i;
                                        dlaVar8 = adbVarArr8[i4].i;
                                        dlaVar9 = adbVarArr8[i352].i;
                                        kwVarAd = bvmVar3.ad();
                                        adqVar7 = adqVar23;
                                        f3 = f5;
                                        kwVarAd.b = f3;
                                        f2 = f3;
                                        if (f != f3) {
                                            i11 = i34;
                                            i12 = i16;
                                            kwVarAd.d.q(dlaVar6, 1.0f);
                                            kwVarAd.d.q(dlaVar7, -1.0f);
                                            kwVarAd.d.q(dlaVar9, 1.0f);
                                            kwVarAd.d.q(dlaVar8, -1.0f);
                                        } else {
                                            i11 = i34;
                                            i12 = i16;
                                            kwVarAd.d.q(dlaVar6, 1.0f);
                                            kwVarAd.d.q(dlaVar7, -1.0f);
                                            kwVarAd.d.q(dlaVar9, 1.0f);
                                            kwVarAd.d.q(dlaVar8, -1.0f);
                                        }
                                        bvmVar3.u(kwVarAd);
                                    } else {
                                        adqVar7 = adqVar23;
                                        i11 = i34;
                                        f2 = f5;
                                        i12 = i16;
                                    }
                                    f8 = f9;
                                    adqVar22 = adqVar7;
                                }
                            }
                            i11 = i34;
                            f2 = f5;
                            f8 = f4;
                            i12 = i16;
                        }
                        i34 = i11 + 1;
                        i16 = i12;
                        arrayList4 = arrayList2;
                        size = i10;
                        f5 = f2;
                    }
                }
                i6 = i16;
                if (adqVar18 == null || !(adqVar18 == adqVar19 || z17)) {
                    adqVar2 = adqVar19;
                    if (!z2 || adqVar18 == null) {
                        adb[] adbVarArr10 = adbVarArr;
                        int i36 = 8;
                        if (z3 && adqVar18 != null) {
                            int i37 = tpVar.j;
                            boolean z18 = i37 > 0 && tpVar.i == i37;
                            adq adqVar24 = adqVar18;
                            adq adqVar25 = adqVar24;
                            while (adqVar25 != null) {
                                adb[] adbVarArr11 = adqVar25.ba;
                                adq adqVar26 = adqVar25.bw[i2];
                                while (adqVar26 != null && adqVar26.bq == i36) {
                                    adqVar26 = adqVar26.bw[i2];
                                }
                                if (adqVar25 == adqVar18 || adqVar25 == adqVar2 || adqVar26 == null) {
                                    adqVar3 = adqVar24;
                                } else {
                                    if (adqVar26 == adqVar2) {
                                        adqVar26 = null;
                                    }
                                    adb adbVar15 = adbVarArr11[i4];
                                    dla dlaVar11 = adbVar15.i;
                                    int i38 = i4 + 1;
                                    dla dlaVar12 = adqVar24.ba[i38].i;
                                    int iN2 = adbVar15.n();
                                    int iN3 = adbVarArr11[i38].n();
                                    if (adqVar26 != null) {
                                        adbVar = adqVar26.ba[i4];
                                        dlaVar2 = adbVar.i;
                                        adb adbVar16 = adbVar.f;
                                        dlaVar = adbVar16 != null ? adbVar16.i : null;
                                    } else {
                                        adb adbVar17 = adqVar2.ba[i4];
                                        dla dlaVar13 = adbVar17 != null ? adbVar17.i : null;
                                        dlaVar = adbVarArr11[i38].i;
                                        adbVar = adbVar17;
                                        dlaVar2 = dlaVar13;
                                    }
                                    if (adbVar != null) {
                                        iN3 += adbVar.n();
                                    }
                                    int iN4 = iN2 + adqVar24.ba[i38].n();
                                    adq adqVar27 = adqVar26;
                                    dla dlaVar14 = dlaVar2;
                                    int i39 = z18 ? 8 : 4;
                                    if (dlaVar11 == null || dlaVar12 == null || dlaVar14 == null || dlaVar == null) {
                                        adqVar3 = adqVar24;
                                        adqVar4 = adqVar27;
                                    } else {
                                        adqVar4 = adqVar27;
                                        dla dlaVar15 = dlaVar;
                                        adqVar3 = adqVar24;
                                        bvmVar.t(dlaVar11, dlaVar12, iN4, 0.5f, dlaVar14, dlaVar15, iN3, i39);
                                    }
                                    adqVar26 = adqVar4;
                                }
                                if (adqVar25.bq != 8) {
                                    adqVar3 = adqVar25;
                                }
                                adqVar25 = adqVar26;
                                adqVar24 = adqVar3;
                                i36 = 8;
                            }
                            bvmVar2 = bvmVar;
                            adb adbVar18 = adqVar18.ba[i4];
                            adb adbVar19 = adbVarArr10[i4].f;
                            int i40 = i4 + 1;
                            adb adbVar20 = adqVar2.ba[i40];
                            adb adbVar21 = adqVar17.ba[i40].f;
                            if (adbVar19 != null) {
                                if (adqVar18 != adqVar2) {
                                    bvmVar2.w(adbVar18.i, adbVar19.i, adbVar18.n(), 5);
                                } else if (adbVar21 != null) {
                                    bvmVar2.t(adbVar18.i, adbVar19.i, adbVar18.n(), 0.5f, adbVar20.i, adbVar21.i,
                                            adbVar20.n(), 5);
                                }
                            }
                            if (adbVar21 != null && adqVar18 != adqVar2) {
                                bvmVar2.w(adbVar20.i, adbVar21.i, -adbVar20.n(), 5);
                            }
                        }
                        if ((z2 || z3) && adqVar18 != null && adqVar18 != adqVar2) {
                            adbVarArr3 = adqVar18.ba;
                            adb adbVar22 = adbVarArr3[i4];
                            if (adqVar2 == null) {
                                adqVar2 = adqVar18;
                            }
                            adb[] adbVarArr12 = adqVar2.ba;
                            i9 = i4 + 1;
                            adbVar3 = adbVarArr12[i9];
                            adb adbVar23 = adbVar22.f;
                            dlaVar4 = adbVar23 != null ? adbVar23.i : null;
                            adb adbVar24 = adbVar3.f;
                            dlaVar5 = adbVar24 != null ? adbVar24.i : null;
                            if (adqVar17 != adqVar2) {
                                adb adbVar25 = adqVar17.ba[i9].f;
                                dlaVar5 = adbVar25 != null ? adbVar25.i : null;
                            }
                            if (adqVar18 == adqVar2) {
                                adbVar3 = adbVarArr3[i9];
                            }
                            if (dlaVar4 == null && dlaVar5 != null) {
                                bvmVar2.t(adbVar22.i, dlaVar4, adbVar22.n(), 0.5f, dlaVar5, adbVar3.i,
                                        adbVarArr12[i9].n(), 5);
                            }
                        }
                    } else {
                        int i41 = tpVar.j;
                        boolean z19 = i41 > 0 && tpVar.i == i41;
                        adq adqVar28 = adqVar18;
                        adq adqVar29 = adqVar28;
                        while (adqVar28 != null) {
                            adb[] adbVarArr13 = adqVar28.ba;
                            adq adqVar30 = adqVar28.bw[i2];
                            while (true) {
                                if (adqVar30 == null) {
                                    i7 = 8;
                                    break;
                                }
                                i7 = 8;
                                if (adqVar30.bq != 8) {
                                    break;
                                } else {
                                    adqVar30 = adqVar30.bw[i2];
                                }
                            }
                            if (adqVar30 != null || adqVar28 == adqVar2) {
                                adb adbVar26 = adbVarArr13[i4];
                                dla dlaVar16 = adbVar26.i;
                                adb adbVar27 = adbVar26.f;
                                dla dlaVar17 = adbVar27 != null ? adbVar27.i : null;
                                if (adqVar29 != adqVar28) {
                                    dlaVar17 = adqVar29.ba[i4 + 1].i;
                                } else if (adqVar28 == adqVar18) {
                                    adb adbVar28 = adbVarArr[i4].f;
                                    dlaVar17 = adbVar28 != null ? adbVar28.i : null;
                                }
                                int iN5 = adbVar26.n();
                                int i42 = i4 + 1;
                                int iN6 = adbVarArr13[i42].n();
                                if (adqVar30 != null) {
                                    adbVar2 = adqVar30.ba[i4];
                                    dlaVar3 = adbVar2.i;
                                } else {
                                    adbVar2 = adqVar17.ba[i42].f;
                                    dlaVar3 = adbVar2 != null ? adbVar2.i : null;
                                }
                                dla dlaVar18 = adbVarArr13[i42].i;
                                if (adbVar2 != null) {
                                    iN6 += adbVar2.n();
                                }
                                int iN7 = adqVar29.ba[i42].n() + iN5;
                                if (dlaVar16 == null || dlaVar17 == null || dlaVar3 == null || dlaVar18 == null) {
                                    adqVar5 = adqVar30;
                                    adbVarArr2 = adbVarArr;
                                    adqVar6 = adqVar29;
                                    i8 = 8;
                                } else {
                                    if (adqVar28 == adqVar18) {
                                        iN7 = adqVar18.ba[i4].n();
                                    }
                                    if (adqVar28 == adqVar2) {
                                        iN6 = adqVar2.ba[i42].n();
                                    }
                                    adqVar5 = adqVar30;
                                    adbVarArr2 = adbVarArr;
                                    adqVar6 = adqVar29;
                                    i8 = 8;
                                    bvmVar.t(dlaVar16, dlaVar17, iN7, 0.5f, dlaVar3, dlaVar18, iN6, z19 ? 8 : 5);
                                }
                            } else {
                                adqVar5 = adqVar30;
                                adbVarArr2 = adbVarArr;
                                adqVar6 = adqVar29;
                                i8 = i7;
                            }
                            if (adqVar28.bq != i8) {
                                adqVar6 = adqVar28;
                            }
                            adqVar28 = adqVar5;
                            adqVar29 = adqVar6;
                            adbVarArr = adbVarArr2;
                        }
                    }
                } else {
                    adb adbVar29 = adbVarArr[i4];
                    int i43 = i4 + 1;
                    adb adbVar30 = adqVar17.ba[i43];
                    adb adbVar31 = adbVar29.f;
                    dla dlaVar19 = adbVar31 != null ? adbVar31.i : null;
                    adb adbVar32 = adbVar30.f;
                    dla dlaVar20 = adbVar32 != null ? adbVar32.i : null;
                    adb adbVar33 = adqVar18.ba[i4];
                    if (adqVar19 != null) {
                        adbVar30 = adqVar19.ba[i43];
                    }
                    if (dlaVar19 == null || dlaVar20 == null) {
                        adqVar2 = adqVar19;
                    } else {
                        float f12 = i2 == 0 ? adqVar20.bn : adqVar20.bo;
                        int iN8 = adbVar33.n();
                        int iN9 = adbVar30.n();
                        dla dlaVar21 = adbVar33.i;
                        dla dlaVar22 = adbVar30.i;
                        dla dlaVar23 = dlaVar19;
                        adqVar2 = adqVar19;
                        bvmVar3.t(dlaVar21, dlaVar23, iN8, f12, dlaVar20, dlaVar22, iN9, 7);
                    }
                }
                bvmVar2 = bvmVar;
                if (z2) {
                    adbVarArr3 = adqVar18.ba;
                    adb adbVar222 = adbVarArr3[i4];
                    if (adqVar2 == null) {
                        adqVar2 = adqVar18;
                    }
                    adb[] adbVarArr122 = adqVar2.ba;
                    i9 = i4 + 1;
                    adbVar3 = adbVarArr122[i9];
                    adb adbVar232 = adbVar222.f;
                    if (adbVar232 != null) {
                    }
                    adb adbVar242 = adbVar3.f;
                    if (adbVar242 != null) {
                    }
                    if (adqVar17 != adqVar2) {
                        adb adbVar252 = adqVar17.ba[i9].f;
                        dlaVar5 = adbVar252 != null ? adbVar252.i : null;
                    }
                    if (adqVar18 == adqVar2) {
                        adbVar3 = adbVarArr3[i9];
                    }
                    if (dlaVar4 == null) {
                    }
                } else {
                    adbVarArr3 = adqVar18.ba;
                    adb adbVar2222 = adbVarArr3[i4];
                    if (adqVar2 == null) {
                        adqVar2 = adqVar18;
                    }
                    adb[] adbVarArr1222 = adqVar2.ba;
                    i9 = i4 + 1;
                    adbVar3 = adbVarArr1222[i9];
                    adb adbVar2322 = adbVar2222.f;
                    if (adbVar2322 != null) {
                    }
                    adb adbVar2422 = adbVar3.f;
                    if (adbVar2422 != null) {
                    }
                    if (adqVar17 != adqVar2) {
                        adb adbVar2522 = adqVar17.ba[i9].f;
                        dlaVar5 = adbVar2522 != null ? adbVar2522.i : null;
                    }
                    if (adqVar18 == adqVar2) {
                        adbVar3 = adbVarArr3[i9];
                    }
                    if (dlaVar4 == null) {
                    }
                }
            } else {
                i6 = i16;
            }
            i17 = i5 + 1;
            adrVar2 = adrVar;
            bvmVar3 = bvmVar;
            arrayList3 = arrayList;
            i16 = i6;
        }
    }

    public static boolean l(char c) {
        if ((1424 <= c && c <= 2303) || c == 8206 || c == 8207) {
            return true;
        }
        if (8234 <= c && c <= 8238) {
            return true;
        }
        if (8294 <= c && c <= 8297) {
            return true;
        }
        if (55296 <= c && c <= 57343) {
            return true;
        }
        if (64285 > c || c > 65023) {
            return 65136 <= c && c <= 65278;
        }
        return true;
    }

    public static deh m(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            deh dehVar = new deh();
            new LinkedHashMap();
            dehVar.a = new blq(EmptyReadonlyMap.INSTANCE);
            return dehVar;
        }
        ClassLoader classLoader = deh.class.getClassLoader();
        throwIfVar1IsNull(classLoader);
        bundle.setClassLoader(classLoader);
        bzg bzgVar = new bzg(bundle.size());
        for (String str : bundle.keySet()) {
            throwIfVar1IsNull(str);
            bzgVar.put(str, bundle.get(str));
        }
        bzgVar.p();
        bzgVar.n = true;
        if (bzgVar.j <= 0) {
            bzgVar = bzg.a;
            throwIfVar1IsNull(bzgVar,
                    "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        deh dehVar2 = new deh();
        new LinkedHashMap();
        dehVar2.a = new blq(bzgVar);
        return dehVar2;
    }

    public static void n(View view) {
        ng ngVar = (ng) view.getTag();
        if (ngVar == null || ngVar.as() == null) {
            return;
        }
        ((WindowManager) ngVar.as().getSystemService("window")).removeViewImmediate((View) view.getParent());
    }

    public static final void o(cus cusVar, acm acmVar, String str) {
        throwIfVar1IsNull(cusVar, "<this>");
        cbm cbmVarA = acmVar.a();
        cusVar.getClass();
        cbmVarA.getClass();
        emc.as(1, null);
        dqc.throwSomething(str, null);
        throw null;
    }

    public static final void p(cus cusVar, avt avtVar, Object obj) {
        throwIfVar1IsNull(cusVar, "<this>");
        throwIfVar1IsNull(obj, "value");
        cbm cbmVarP = avtVar.p();
        cusVar.getClass();
        cbmVarP.getClass();
        throw null;
    }

    public static final SwitchHook[] getAllSwitchHookInstances() {
        return new SwitchHook[] { AppBrandAntiGlobalAdHook.a, AppBrandAntiSplashAdHook.a, AppBrandForceShareHook.a,
                AppBrandVideoRewardHook.a,
                cf.a, BottomTabCustomHook.INSTANCE, BottomTabMaterialHook.a,
                wh.a,
                CustomBalanceHook.a,
                CustomContactCountHook.a, cfm.a, cfv.a,
                chh.a, ddh.a,
                AntiRevoke1Hook.a, ga.a, gd.a, lz.a, AutoSelectOriginalPhotoHook.a, mh.a, AutoViewOriginalPhotoHook.a,
                xg.a,
                DisableMsgClipHook.a, DisablePatHook.a,
                DisablePlayRingtoneHook.a, DisableSendStatusHook.a,
                MsgFormatHook.a, cgr.c,
                cgz.c, PanelEmojiHook.INSTANCE,
                cww.a, cxg.a, cxl.a, dhm.a, die.a, bcu.a, ble.a, blg.a, blh.a, blk.a, blm.a, blo.a, cud.a, fs.a,
                CustomUnReadCountHook.a,
                azr.a, elx.a, un.a, uo.a, cie.a, cif.a, fp.a, cnl.a, bjm.a, bjx.a, atx.a, bxj.a, etr.a, dlv.a,
                RemoveMultiSelectLimitHook.a,
                dax.a, day.a, dbe.a, aun.a, cgc.a, chc.a, etl.a, etw.a, ctp.b, cxb.b, zr.a, cha.a, crm.a, cwy.a, cez.b,
                cfa.b, cfc.b, lx.a, md.a, zw.a, DisableBrightnessHook.a, cdo.a, cho.a, deu.a, dha.a, dpf.a, dad.a,
                dae.a, daf.a, ge.a,
                gf.a, gh.a, diq.a, div.a, diz.b, dja.b, djh.a, djv.a, SnsUploadAppInfoHook.a, dkl.a, xf.a, bbj.a, vg.a,
                vt.a, dhh.a,
                dhi.b, ShowContactInfoHook.b, VnHomeShareMenuCopyOrDownHook.a, VnPreviewShareMenuCopyOrDownHook.a, ee.a,
                cia.a, doj.a, dok.a, bie.a,
                bii.a,
                EcsHardcodeGlobalSwitch.a, cym.a,
                cyn.a, elv.a, dhn.a, eud.a, eue.a, euf.a, elu.a, AccbilityDisableClick.a, cnq.a, xs.a, xt.a, eti.a,
                etx.a, dka.a, dkd.a,
                DistinctAtMeOrAtAllToNotify.a, ddc.a, boq.a, boh.a, cwt.a, cwu.a, eky.a, emo.a, arb.a, cou.a, cov.a,
                chb.a, cnn.a, cny.a,
                DisableDetailNotification.a,
                euc.a, ety.a, cxm.a, cxo.a, eth.a, ara.a, bcw.a, cnx.a, cxn.a, eub.a, chz.a, cxh.a, dru.a, etm.a, etn.a,
                eto.a, csy.a, epv.a, ya.a, crn.a, cro.a, crp.a, crq.a, crr.a, crs.a, lq.a, sk.a, sl.a, sm.a, eol.a,
                aqz.a, cnp.a, cno.a, dez.a, xl.a, dqr.a, cow.a, cnm.a, cvx.a, azu.a, ewu.a, ewv.a, ewx.a, avj.a, big.a,
                bih.a, coa.a, cvw.a, eww.a, ayk.a, cob.a, dgj.a, og.a, cnz.a, dda.a, xk.a, csa.a, fn.a, DevLogHook.a,
                dig.a,
                gm.a, CommandProcessorHook.a };
    }

    public static String r(anr anrVar, int i2) {
        throwIfVar1IsNull(anrVar, "context");
        if (i2 <= 16777215) {
            return String.valueOf(i2);
        }
        try {
            String resourceName = anrVar.b.getResources().getResourceName(i2);
            throwIfVar1IsNull(resourceName);
            return resourceName;
        } catch (Resources.NotFoundException unused) {
            return String.valueOf(i2);
        }
    }

    public static ArrayList s() throws IOException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorAb = ab(new aer[] { aer.a });
        if (cursorAb == null) {
            return arrayList;
        }
        while (cursorAb.moveToNext()) {
            try {
                FriendInfo friendInfoS = cnb.s(cursorAb);
                Object objB = acv.b(acv.a, eom.a.f);
                throwIfVar1IsNull(objB, "null cannot be cast to non-null type kotlin.String" /*
                                                                                              * "null cannot be cast to non-null type kotlin.String" /* "null cannot be cast to non-null type kotlin.String" /* cnb.z(-121955596368682L)  */
                                                                                              */);
                if (!((String) objB).equals(friendInfoS.getWxid())) {
                    arrayList.add(friendInfoS);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cursorAb, th);
                    throw th2;
                }
            }
        }
        cursorAb.close();
        return arrayList;
    }

    public static ArrayList t() throws IOException {
        ArrayList arrayList = new ArrayList();
        Cursor cursorAb = ab(new aer[] { aer.b });
        if (cursorAb == null) {
            return arrayList;
        }
        while (cursorAb.moveToNext()) {
            try {
                GroupInfo groupInfoT = cnb.t(cursorAb);
                if (groupInfoT.getGroupData().getMemberCount() > 0) {
                    arrayList.add(groupInfoT);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(cursorAb, th);
                    throw th2;
                }
            }
        }
        cursorAb.close();
        return arrayList;
    }

    public static final int u(dfx dfxVar, brn brnVar, String str) {
        throwIfVar1IsNull(dfxVar, "<this>");
        throwIfVar1IsNull(brnVar, "json");
        throwIfVar1IsNull(str, "name");
        brt brtVar = brnVar.b;
        brtVar.getClass();
        y(brnVar, dfxVar);
        int iG = dfxVar.g(str);
        if (iG != -3 || !brtVar.d) {
            return iG;
        }
        erp erpVar = brnVar.d;
        ls lsVar = new ls(dfxVar, 3, brnVar);
        erpVar.getClass();
        erpVar.getClass();
        throwIfVar1IsNull(dfxVar, "descriptor");
        Map map = (Map) ((ConcurrentHashMap) erpVar.v).get(dfxVar);
        nu nuVar = h;
        Object obj = map != null ? map.get(nuVar) : null;
        Object objInvoke = obj != null ? obj : null;
        if (objInvoke == null) {
            objInvoke = lsVar.invoke();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) erpVar.v;
            Object concurrentHashMap2 = concurrentHashMap.get(dfxVar);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(dfxVar, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(nuVar, objInvoke);
        }
        Integer num = (Integer) ((Map) objInvoke).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static ArrayList v(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < materialToolbar.getChildCount(); i2++) {
            View childAt = materialToolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static final boolean w(brn brnVar, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "<this>");
        throwIfVar1IsNull(brnVar, "json");
        brnVar.b.getClass();
        List annotations = dfxVar.getAnnotations();
        if (annotations != null && annotations.isEmpty()) {
            return false;
        }
        Iterator it = annotations.iterator();
        while (it.hasNext()) {
            if (((Annotation) it.next()) instanceof bse) {
                return true;
            }
        }
        return false;
    }

    public static ahh x(ahf ahfVar, IEmpty8 ahgVar) {
        throwIfVar1IsNull(ahgVar, "key");
        return nullSafeIsEqual(ahfVar.getKey(), ahgVar) ? EmptyCoroutineContext.INSTANCE : ahfVar;
    }

    public static final void y(brn brnVar, dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "<this>");
        throwIfVar1IsNull(brnVar, "json");
        if (nullSafeIsEqual(dfxVar.h(), dnt.a)) {
            brnVar.b.getClass();
        }
    }

    public static void z(String str) {
        try {
            Class<?> cls = Class.forName(str);
            try {
                throw new RuntimeException(StaticHelpers6.concatVar2Var1(cls.getDeclaredConstructor(null).newInstance(null),
                        "Expected instanceof GlideModule, but found: "));
            } catch (IllegalAccessException e) {
                ag(cls, e);
                throw null;
            } catch (InstantiationException e2) {
                ag(cls, e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                ag(cls, e3);
                throw null;
            } catch (InvocationTargetException e4) {
                ag(cls, e4);
                throw null;
            }
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }
}
