package me.hd.wauxv.obf;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.android.dx.io.Opcodes;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hb extends aci implements he {
    public boolean e;
    public boolean f;
    public AppCompatDelegate h;
    public final erp c = new erp(new bdm(this), 25);
    public final bur d = new bur(this);
    public boolean g = true;

    public hb() {
        ((but) this.t.c).ad("android:support:lifecycle", new abz(this, 1));
        final int i = 0;
        al(new adv(this) { // from class: me.hd.wauxv.obf.bdl
            public final /* synthetic */ hb b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.b.c.z();
                        break;
                    default:
                        this.b.c.z();
                        break;
                }
            }
        });
        final int i2 = 1;
        this.aa.add(new adv(this) { // from class: me.hd.wauxv.obf.bdl
            public final /* synthetic */ hb b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.adv
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.b.c.z();
                        break;
                    default:
                        this.b.c.z();
                        break;
                }
            }
        });
        am(new aca(this, 1));
    }

    public static boolean i(beg begVar) {
        boolean zI = false;
        for (SomeFragmentManager someFragmentManagerVar : begVar.c.af()) {
            if (someFragmentManagerVar != null) {
                bdm bdmVar = someFragmentManagerVar.bn;
                if ((bdmVar == null ? null : bdmVar.h) != null) {
                    zI |= i(someFragmentManagerVar.cp());
                }
                bfg bfgVar = someFragmentManagerVar.ci;
                buh buhVar = buh.d;
                buh buhVar2 = buh.c;
                if (bfgVar != null) {
                    bfgVar.g();
                    if (bfgVar.d.c.compareTo(buhVar) >= 0) {
                        someFragmentManagerVar.ci.d.p(buhVar2);
                        zI = true;
                    }
                }
                if (someFragmentManagerVar.ch.c.compareTo(buhVar) >= 0) {
                    someFragmentManagerVar.ch.p(buhVar2);
                    zI = true;
                }
            }
        }
        return zI;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ao();
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        appCompatDelegateVar.cf();
        ((ViewGroup) appCompatDelegateVar.an.findViewById(R.id.content)).addView(view, layoutParams);
        appCompatDelegateVar.z.f(appCompatDelegateVar.y.getCallback());
    }

    /* JADX WARN: Found duplicated region for block: B:102:0x0193 */
    /* JADX WARN: Found duplicated region for block: B:105:0x01a2 */
    /* JADX WARN: Found duplicated region for block: B:108:0x01ad */
    /* JADX WARN: Found duplicated region for block: B:111:0x01b5 */
    /* JADX WARN: Found duplicated region for block: B:114:0x01bd */
    /* JADX WARN: Found duplicated region for block: B:117:0x01c5 */
    /* JADX WARN: Found duplicated region for block: B:118:0x01c8 */
    /* JADX WARN: Found duplicated region for block: B:122:0x01de */
    /* JADX WARN: Found duplicated region for block: B:124:0x01e8 */
    /* JADX WARN: Found duplicated region for block: B:125:0x01ec */
    /*
     * JADX WARN: Found duplicated region for block: B:136:0x020d A[Catch: all ->
     * 0x0201, TRY_LEAVE, TryCatch #0 {, blocks: (B:127:0x01ef, B:129:0x01f3,
     * B:135:0x020b, B:136:0x020d, B:138:0x0211, B:144:0x0221, B:143:0x0218,
     * B:134:0x0204), top: B:154:0x01ef, inners: #5 }]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:154:0x01ef
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:162:0x01f3
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /*
     * JADX WARN: Found duplicated region for block: B:165:0x0211
     * A[EXC_TOP_SPLITTER, SYNTHETIC]
     */
    /* JADX WARN: Found duplicated region for block: B:44:0x0098 */
    /* JADX WARN: Found duplicated region for block: B:47:0x00a4 */
    /* JADX WARN: Found duplicated region for block: B:50:0x00aa */
    /* JADX WARN: Found duplicated region for block: B:52:0x00d3 */
    /* JADX WARN: Found duplicated region for block: B:55:0x00e2 */
    /* JADX WARN: Found duplicated region for block: B:57:0x00ea */
    /* JADX WARN: Found duplicated region for block: B:60:0x00f2 */
    /* JADX WARN: Found duplicated region for block: B:63:0x00fa */
    /* JADX WARN: Found duplicated region for block: B:66:0x0105 */
    /* JADX WARN: Found duplicated region for block: B:69:0x010d */
    /* JADX WARN: Found duplicated region for block: B:72:0x0115 */
    /* JADX WARN: Found duplicated region for block: B:75:0x011d */
    /* JADX WARN: Found duplicated region for block: B:78:0x0125 */
    /* JADX WARN: Found duplicated region for block: B:81:0x012d */
    /* JADX WARN: Found duplicated region for block: B:84:0x0139 */
    /* JADX WARN: Found duplicated region for block: B:87:0x0148 */
    /* JADX WARN: Found duplicated region for block: B:90:0x0157 */
    /* JADX WARN: Found duplicated region for block: B:93:0x0166 */
    /* JADX WARN: Found duplicated region for block: B:96:0x0175 */
    /* JADX WARN: Found duplicated region for block: B:99:0x0184 */
    @Override // android.app.Activity, android.view.ContextThemeWrapper,
              // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Configuration configuration;
        Configuration configuration2;
        Configuration configuration3;
        afv afvVar;
        Resources.Theme theme;
        Method method;
        float f;
        float f2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        int i39;
        int i40;
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        appCompatDelegateVar.bb = true;
        int i41 = appCompatDelegateVar.bf;
        if (i41 == -100) {
            i41 = ho.b;
        }
        int iCl = appCompatDelegateVar.cl(context, i41);
        int i42 = 0;
        if (ho.j(context) && ho.j(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (ho.i) {
                    try {
                        bwy bwyVar = ho.c;
                        if (bwyVar == null) {
                            if (ho.d == null) {
                                ho.d = bwy.c(FastKV.au(context));
                            }
                            if (!ho.d.b.a.isEmpty()) {
                                ho.c = ho.d;
                            }
                        } else if (!bwyVar.equals(ho.d)) {
                            bwy bwyVar2 = ho.c;
                            ho.d = bwyVar2;
                            FastKV.as(context, bwyVar2.b.a.toLanguageTags());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!ho.f) {
                ho.a.execute(new hi(context, i42));
            }
        }
        bwy bwyVarBu = AppCompatDelegate.bu(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegate.bv(context, iCl, bwyVarBu, null, false));
            } catch (IllegalStateException unused) {
                if (context instanceof afv) {
                    try {
                        ((afv) context).g(AppCompatDelegate.bv(context, iCl, bwyVarBu, null, false));
                    } catch (IllegalStateException unused2) {
                        if (AppCompatDelegate.v) {
                            Configuration configuration4 = new Configuration();
                            configuration4.uiMode = -1;
                            configuration4.fontScale = 0.0f;
                            configuration = context.createConfigurationContext(configuration4).getResources()
                                    .getConfiguration();
                            configuration2 = context.getResources().getConfiguration();
                            configuration.uiMode = configuration2.uiMode;
                            if (configuration.equals(configuration2)) {
                                configuration3 = null;
                            } else {
                                configuration3 = new Configuration();
                                configuration3.fontScale = 0.0f;
                                if (configuration.diff(configuration2) != 0) {
                                    f = configuration.fontScale;
                                    f2 = configuration2.fontScale;
                                    if (f != f2) {
                                        configuration3.fontScale = f2;
                                    }
                                    i = configuration.mcc;
                                    i2 = configuration2.mcc;
                                    if (i != i2) {
                                        configuration3.mcc = i2;
                                    }
                                    i3 = configuration.mnc;
                                    i4 = configuration2.mnc;
                                    if (i3 != i4) {
                                        configuration3.mnc = i4;
                                    }
                                    ht.a(configuration, configuration2, configuration3);
                                    i5 = configuration.touchscreen;
                                    i6 = configuration2.touchscreen;
                                    if (i5 != i6) {
                                        configuration3.touchscreen = i6;
                                    }
                                    i7 = configuration.keyboard;
                                    i8 = configuration2.keyboard;
                                    if (i7 != i8) {
                                        configuration3.keyboard = i8;
                                    }
                                    i9 = configuration.keyboardHidden;
                                    i10 = configuration2.keyboardHidden;
                                    if (i9 != i10) {
                                        configuration3.keyboardHidden = i10;
                                    }
                                    i11 = configuration.navigation;
                                    i12 = configuration2.navigation;
                                    if (i11 != i12) {
                                        configuration3.navigation = i12;
                                    }
                                    i13 = configuration.navigationHidden;
                                    i14 = configuration2.navigationHidden;
                                    if (i13 != i14) {
                                        configuration3.navigationHidden = i14;
                                    }
                                    i15 = configuration.orientation;
                                    i16 = configuration2.orientation;
                                    if (i15 != i16) {
                                        configuration3.orientation = i16;
                                    }
                                    i17 = configuration.screenLayout & 15;
                                    i18 = configuration2.screenLayout & 15;
                                    if (i17 != i18) {
                                        configuration3.screenLayout |= i18;
                                    }
                                    i19 = configuration.screenLayout & 192;
                                    i20 = configuration2.screenLayout & 192;
                                    if (i19 != i20) {
                                        configuration3.screenLayout |= i20;
                                    }
                                    i21 = configuration.screenLayout & 48;
                                    i22 = configuration2.screenLayout & 48;
                                    if (i21 != i22) {
                                        configuration3.screenLayout |= i22;
                                    }
                                    i23 = configuration.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                                    i24 = configuration2.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                                    if (i23 != i24) {
                                        configuration3.screenLayout |= i24;
                                    }
                                    i25 = configuration.colorMode & 3;
                                    i26 = configuration2.colorMode & 3;
                                    if (i25 != i26) {
                                        configuration3.colorMode |= i26;
                                    }
                                    i27 = configuration.colorMode & 12;
                                    i28 = configuration2.colorMode & 12;
                                    if (i27 != i28) {
                                        configuration3.colorMode |= i28;
                                    }
                                    i29 = configuration.uiMode & 15;
                                    i30 = configuration2.uiMode & 15;
                                    if (i29 != i30) {
                                        configuration3.uiMode |= i30;
                                    }
                                    i31 = configuration.uiMode & 48;
                                    i32 = configuration2.uiMode & 48;
                                    if (i31 != i32) {
                                        configuration3.uiMode |= i32;
                                    }
                                    i33 = configuration.screenWidthDp;
                                    i34 = configuration2.screenWidthDp;
                                    if (i33 != i34) {
                                        configuration3.screenWidthDp = i34;
                                    }
                                    i35 = configuration.screenHeightDp;
                                    i36 = configuration2.screenHeightDp;
                                    if (i35 != i36) {
                                        configuration3.screenHeightDp = i36;
                                    }
                                    i37 = configuration.smallestScreenWidthDp;
                                    i38 = configuration2.smallestScreenWidthDp;
                                    if (i37 != i38) {
                                        configuration3.smallestScreenWidthDp = i38;
                                    }
                                    i39 = configuration.densityDpi;
                                    i40 = configuration2.densityDpi;
                                    if (i39 != i40) {
                                        configuration3.densityDpi = i40;
                                    }
                                }
                            }
                            Configuration configurationBv = AppCompatDelegate.bv(context, iCl, bwyVarBu, configuration3, true);
                            afvVar = new afv(context, me.hd.wauxv.R.style.Theme_AppCompat_Empty);
                            afvVar.g(configurationBv);
                            try {
                                if (context.getTheme() != null) {
                                    theme = afvVar.getTheme();
                                    if (Build.VERSION.SDK_INT >= 29) {
                                        ke.d(theme);
                                    } else {
                                        synchronized (ajn.c) {
                                            if (ajn.e) {
                                                method = ajn.d;
                                                if (method != null) {
                                                    method.invoke(theme, null);
                                                }
                                            } else {
                                                try {
                                                    Method declaredMethod = Resources.Theme.class
                                                            .getDeclaredMethod("rebase", null);
                                                    ajn.d = declaredMethod;
                                                    declaredMethod.setAccessible(true);
                                                } catch (NoSuchMethodException e) {
                                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                                }
                                                ajn.e = true;
                                                method = ajn.d;
                                                if (method != null) {
                                                    try {
                                                        method.invoke(theme, null);
                                                    } catch (IllegalAccessException | InvocationTargetException e2) {
                                                        Log.i("ResourcesCompat",
                                                                "Failed to invoke rebase() method via reflection", e2);
                                                        ajn.d = null;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (NullPointerException unused3) {
                            }
                            context = afvVar;
                        }
                    }
                } else if (AppCompatDelegate.v) {
                    Configuration configuration42 = new Configuration();
                    configuration42.uiMode = -1;
                    configuration42.fontScale = 0.0f;
                    configuration = context.createConfigurationContext(configuration42).getResources()
                            .getConfiguration();
                    configuration2 = context.getResources().getConfiguration();
                    configuration.uiMode = configuration2.uiMode;
                    if (configuration.equals(configuration2)) {
                        configuration3 = new Configuration();
                        configuration3.fontScale = 0.0f;
                        if (configuration.diff(configuration2) != 0) {
                            f = configuration.fontScale;
                            f2 = configuration2.fontScale;
                            if (f != f2) {
                                configuration3.fontScale = f2;
                            }
                            i = configuration.mcc;
                            i2 = configuration2.mcc;
                            if (i != i2) {
                                configuration3.mcc = i2;
                            }
                            i3 = configuration.mnc;
                            i4 = configuration2.mnc;
                            if (i3 != i4) {
                                configuration3.mnc = i4;
                            }
                            ht.a(configuration, configuration2, configuration3);
                            i5 = configuration.touchscreen;
                            i6 = configuration2.touchscreen;
                            if (i5 != i6) {
                                configuration3.touchscreen = i6;
                            }
                            i7 = configuration.keyboard;
                            i8 = configuration2.keyboard;
                            if (i7 != i8) {
                                configuration3.keyboard = i8;
                            }
                            i9 = configuration.keyboardHidden;
                            i10 = configuration2.keyboardHidden;
                            if (i9 != i10) {
                                configuration3.keyboardHidden = i10;
                            }
                            i11 = configuration.navigation;
                            i12 = configuration2.navigation;
                            if (i11 != i12) {
                                configuration3.navigation = i12;
                            }
                            i13 = configuration.navigationHidden;
                            i14 = configuration2.navigationHidden;
                            if (i13 != i14) {
                                configuration3.navigationHidden = i14;
                            }
                            i15 = configuration.orientation;
                            i16 = configuration2.orientation;
                            if (i15 != i16) {
                                configuration3.orientation = i16;
                            }
                            i17 = configuration.screenLayout & 15;
                            i18 = configuration2.screenLayout & 15;
                            if (i17 != i18) {
                                configuration3.screenLayout |= i18;
                            }
                            i19 = configuration.screenLayout & 192;
                            i20 = configuration2.screenLayout & 192;
                            if (i19 != i20) {
                                configuration3.screenLayout |= i20;
                            }
                            i21 = configuration.screenLayout & 48;
                            i22 = configuration2.screenLayout & 48;
                            if (i21 != i22) {
                                configuration3.screenLayout |= i22;
                            }
                            i23 = configuration.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                            i24 = configuration2.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                            if (i23 != i24) {
                                configuration3.screenLayout |= i24;
                            }
                            i25 = configuration.colorMode & 3;
                            i26 = configuration2.colorMode & 3;
                            if (i25 != i26) {
                                configuration3.colorMode |= i26;
                            }
                            i27 = configuration.colorMode & 12;
                            i28 = configuration2.colorMode & 12;
                            if (i27 != i28) {
                                configuration3.colorMode |= i28;
                            }
                            i29 = configuration.uiMode & 15;
                            i30 = configuration2.uiMode & 15;
                            if (i29 != i30) {
                                configuration3.uiMode |= i30;
                            }
                            i31 = configuration.uiMode & 48;
                            i32 = configuration2.uiMode & 48;
                            if (i31 != i32) {
                                configuration3.uiMode |= i32;
                            }
                            i33 = configuration.screenWidthDp;
                            i34 = configuration2.screenWidthDp;
                            if (i33 != i34) {
                                configuration3.screenWidthDp = i34;
                            }
                            i35 = configuration.screenHeightDp;
                            i36 = configuration2.screenHeightDp;
                            if (i35 != i36) {
                                configuration3.screenHeightDp = i36;
                            }
                            i37 = configuration.smallestScreenWidthDp;
                            i38 = configuration2.smallestScreenWidthDp;
                            if (i37 != i38) {
                                configuration3.smallestScreenWidthDp = i38;
                            }
                            i39 = configuration.densityDpi;
                            i40 = configuration2.densityDpi;
                            if (i39 != i40) {
                                configuration3.densityDpi = i40;
                            }
                        }
                    } else {
                        configuration3 = null;
                    }
                    Configuration configurationBv2 = AppCompatDelegate.bv(context, iCl, bwyVarBu, configuration3, true);
                    afvVar = new afv(context, me.hd.wauxv.R.style.Theme_AppCompat_Empty);
                    afvVar.g(configurationBv2);
                    if (context.getTheme() != null) {
                        theme = afvVar.getTheme();
                        if (Build.VERSION.SDK_INT >= 29) {
                            ke.d(theme);
                        } else {
                            synchronized (ajn.c) {
                                if (ajn.e) {
                                    Method declaredMethod2 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                                    ajn.d = declaredMethod2;
                                    declaredMethod2.setAccessible(true);
                                    ajn.e = true;
                                    method = ajn.d;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                } else {
                                    method = ajn.d;
                                    if (method != null) {
                                        method.invoke(theme, null);
                                    }
                                }
                            }
                        }
                    }
                    context = afvVar;
                }
            }
        } else if (context instanceof afv) {
            ((afv) context).g(AppCompatDelegate.bv(context, iCl, bwyVarBu, null, false));
        } else if (AppCompatDelegate.v) {
            Configuration configuration422 = new Configuration();
            configuration422.uiMode = -1;
            configuration422.fontScale = 0.0f;
            configuration = context.createConfigurationContext(configuration422).getResources().getConfiguration();
            configuration2 = context.getResources().getConfiguration();
            configuration.uiMode = configuration2.uiMode;
            if (configuration.equals(configuration2)) {
                configuration3 = new Configuration();
                configuration3.fontScale = 0.0f;
                if (configuration.diff(configuration2) != 0) {
                    f = configuration.fontScale;
                    f2 = configuration2.fontScale;
                    if (f != f2) {
                        configuration3.fontScale = f2;
                    }
                    i = configuration.mcc;
                    i2 = configuration2.mcc;
                    if (i != i2) {
                        configuration3.mcc = i2;
                    }
                    i3 = configuration.mnc;
                    i4 = configuration2.mnc;
                    if (i3 != i4) {
                        configuration3.mnc = i4;
                    }
                    ht.a(configuration, configuration2, configuration3);
                    i5 = configuration.touchscreen;
                    i6 = configuration2.touchscreen;
                    if (i5 != i6) {
                        configuration3.touchscreen = i6;
                    }
                    i7 = configuration.keyboard;
                    i8 = configuration2.keyboard;
                    if (i7 != i8) {
                        configuration3.keyboard = i8;
                    }
                    i9 = configuration.keyboardHidden;
                    i10 = configuration2.keyboardHidden;
                    if (i9 != i10) {
                        configuration3.keyboardHidden = i10;
                    }
                    i11 = configuration.navigation;
                    i12 = configuration2.navigation;
                    if (i11 != i12) {
                        configuration3.navigation = i12;
                    }
                    i13 = configuration.navigationHidden;
                    i14 = configuration2.navigationHidden;
                    if (i13 != i14) {
                        configuration3.navigationHidden = i14;
                    }
                    i15 = configuration.orientation;
                    i16 = configuration2.orientation;
                    if (i15 != i16) {
                        configuration3.orientation = i16;
                    }
                    i17 = configuration.screenLayout & 15;
                    i18 = configuration2.screenLayout & 15;
                    if (i17 != i18) {
                        configuration3.screenLayout |= i18;
                    }
                    i19 = configuration.screenLayout & 192;
                    i20 = configuration2.screenLayout & 192;
                    if (i19 != i20) {
                        configuration3.screenLayout |= i20;
                    }
                    i21 = configuration.screenLayout & 48;
                    i22 = configuration2.screenLayout & 48;
                    if (i21 != i22) {
                        configuration3.screenLayout |= i22;
                    }
                    i23 = configuration.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                    i24 = configuration2.screenLayout & Opcodes.FILL_ARRAY_DATA_PAYLOAD;
                    if (i23 != i24) {
                        configuration3.screenLayout |= i24;
                    }
                    i25 = configuration.colorMode & 3;
                    i26 = configuration2.colorMode & 3;
                    if (i25 != i26) {
                        configuration3.colorMode |= i26;
                    }
                    i27 = configuration.colorMode & 12;
                    i28 = configuration2.colorMode & 12;
                    if (i27 != i28) {
                        configuration3.colorMode |= i28;
                    }
                    i29 = configuration.uiMode & 15;
                    i30 = configuration2.uiMode & 15;
                    if (i29 != i30) {
                        configuration3.uiMode |= i30;
                    }
                    i31 = configuration.uiMode & 48;
                    i32 = configuration2.uiMode & 48;
                    if (i31 != i32) {
                        configuration3.uiMode |= i32;
                    }
                    i33 = configuration.screenWidthDp;
                    i34 = configuration2.screenWidthDp;
                    if (i33 != i34) {
                        configuration3.screenWidthDp = i34;
                    }
                    i35 = configuration.screenHeightDp;
                    i36 = configuration2.screenHeightDp;
                    if (i35 != i36) {
                        configuration3.screenHeightDp = i36;
                    }
                    i37 = configuration.smallestScreenWidthDp;
                    i38 = configuration2.smallestScreenWidthDp;
                    if (i37 != i38) {
                        configuration3.smallestScreenWidthDp = i38;
                    }
                    i39 = configuration.densityDpi;
                    i40 = configuration2.densityDpi;
                    if (i39 != i40) {
                        configuration3.densityDpi = i40;
                    }
                }
            } else {
                configuration3 = null;
            }
            Configuration configurationBv22 = AppCompatDelegate.bv(context, iCl, bwyVarBu, configuration3, true);
            afvVar = new afv(context, me.hd.wauxv.R.style.Theme_AppCompat_Empty);
            afvVar.g(configurationBv22);
            if (context.getTheme() != null) {
                theme = afvVar.getTheme();
                if (Build.VERSION.SDK_INT >= 29) {
                    ke.d(theme);
                } else {
                    synchronized (ajn.c) {
                        if (ajn.e) {
                            Method declaredMethod22 = Resources.Theme.class.getDeclaredMethod("rebase", null);
                            ajn.d = declaredMethod22;
                            declaredMethod22.setAccessible(true);
                            ajn.e = true;
                            method = ajn.d;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        } else {
                            method = ajn.d;
                            if (method != null) {
                                method.invoke(theme, null);
                            }
                        }
                    }
                }
            }
            context = afvVar;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((AppCompatDelegate) j()).cj();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((AppCompatDelegate) j()).cj();
        return super.dispatchKeyEvent(keyEvent);
    }

    /*
     * JADX WARN: Can't fix incorrect switch cases order, some code will duplicate
     */
    /*
     * JADX WARN: Failed to restore switch over string. Please report as a
     * decompilation issue
     */
    /* JADX WARN: Found duplicated region for block: B:25:0x003f */
    /* JADX WARN: Found duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    @Override // android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (strArr != null && strArr.length != 0) {
            String str2 = strArr[0];
            switch (str2.hashCode()) {
                case -645125871:
                    if (str2.equals("--translation") && Build.VERSION.SDK_INT >= 31) {
                        return;
                    }
                    break;
                case 100470631:
                    if (str2.equals("--dump-dumpable")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            return;
                        }
                    }
                    break;
                case 472614934:
                    if (str2.equals("--list-dumpables")) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            return;
                        }
                    }
                    break;
                case 1159329357:
                    if (str2.equals("--contentcapture") && Build.VERSION.SDK_INT >= 29) {
                        return;
                    }
                    break;
                case 1455016274:
                    if (str2.equals("--autofill")) {
                        return;
                    }
                    break;
            }
        }
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str3 = str + "  ";
        printWriter.print(str3);
        printWriter.print("mCreated=");
        printWriter.print(this.e);
        printWriter.print(" mResumed=");
        printWriter.print(this.f);
        printWriter.print(" mStopped=");
        printWriter.print(this.g);
        if (getApplication() != null) {
            erq erqVarAj = aj();
            throwIfVar1IsNull(erqVarAj, "store");
            ahv ahvVar = ahv.a;
            throwIfVar1IsNull(ahvVar, "defaultCreationExtras");
            chm chmVar = new chm(erqVarAj, bwv.a, ahvVar);
            zc zcVarB = dal.b(bwv.class);
            String strAo = emc.ao(zcVarB);
            if (strAo == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            dlo dloVar = ((bwv) chmVar.ah("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strAo), zcVarB)).b;
            if (dloVar.i() > 0) {
                printWriter.print(str3);
                printWriter.println("Loaders:");
                if (dloVar.i() > 0) {
                    if (dloVar.j(0) != null) {
                        throw new ClassCastException();
                    }
                    printWriter.print(str3);
                    printWriter.print("  #");
                    printWriter.print(dloVar.g(0));
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        ((bdm) this.c.v).g.bs(str, fileDescriptor, printWriter, strArr);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        appCompatDelegateVar.cf();
        return appCompatDelegateVar.y.findViewById(i);
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        if (appCompatDelegateVar.ac == null) {
            appCompatDelegateVar.cj();
            eut eutVar = appCompatDelegateVar.ab;
            appCompatDelegateVar.ac = new dof(eutVar != null ? eutVar.bo() : appCompatDelegateVar.x);
        }
        return appCompatDelegateVar.ac;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper,
              // android.content.Context
    public final Resources getResources() {
        int i = epm.a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        if (appCompatDelegateVar.ab != null) {
            appCompatDelegateVar.cj();
            appCompatDelegateVar.ab.getClass();
            appCompatDelegateVar.ck(0);
        }
    }

    public final ho j() {
        if (this.h == null) {
            hm hmVar = ho.a;
            this.h = new AppCompatDelegate(this, null, this, this);
        }
        return this.h;
    }

    public final void k() {
        super.onDestroy();
        ((bdm) this.c.v).g.bh();
        this.d.m(LifeEventEnum.ON_DESTROY);
    }

    public final boolean l(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return ((bdm) this.c.v).g.bf();
        }
        return false;
    }

    public final void m() {
        super.onPostResume();
        this.d.m(LifeEventEnum.ON_RESUME);
        beg begVar = ((bdm) this.c.v).g;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(7);
    }

    public final void n() {
        erp erpVar = this.c;
        erpVar.z();
        bdm bdmVar = (bdm) erpVar.v;
        super.onStart();
        this.g = false;
        if (!this.e) {
            this.e = true;
            beg begVar = bdmVar.g;
            begVar.ah = false;
            begVar.ai = false;
            begVar.ao.g = false;
            begVar.bq(4);
        }
        bdmVar.g.bw(true);
        this.d.m(LifeEventEnum.ON_START);
        beg begVar2 = bdmVar.g;
        begVar2.ah = false;
        begVar2.ai = false;
        begVar2.ao.g = false;
        begVar2.bq(5);
    }

    public final void o() {
        erp erpVar;
        super.onStop();
        this.g = true;
        do {
            erpVar = this.c;
        } while (i(((bdm) erpVar.v).g));
        beg begVar = ((bdm) erpVar.v).g;
        begVar.ai = true;
        begVar.ao.g = true;
        begVar.bq(4);
        this.d.m(LifeEventEnum.ON_STOP);
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        this.c.z();
        super.onActivityResult(i, i2, intent);
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        if (appCompatDelegateVar.as && appCompatDelegateVar.am) {
            appCompatDelegateVar.cj();
            eut eutVar = appCompatDelegateVar.ab;
            if (eutVar != null) {
                eutVar.br(eutVar.ap.getResources().getBoolean(me.hd.wauxv.R.bool.abc_action_bar_embed_tabs));
            }
        }
        C0023if c0023ifD = C0023if.d();
        Context context = appCompatDelegateVar.x;
        synchronized (c0023ifD) {
            dcp dcpVar = c0023ifD.c;
            synchronized (dcpVar) {
                byc bycVar = (byc) dcpVar.e.get(context);
                if (bycVar != null) {
                    bycVar.e();
                }
            }
        }
        appCompatDelegateVar.be = new Configuration(appCompatDelegateVar.x.getResources().getConfiguration());
        appCompatDelegateVar.by(false, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d.m(LifeEventEnum.ON_CREATE);
        beg begVar = ((bdm) this.c.v).g;
        begVar.ah = false;
        begVar.ai = false;
        begVar.ao.g = false;
        begVar.bq(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((bdm) this.c.v).g.f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        k();
        j().n();
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent intentX;
        if (!l(i, menuItem)) {
            AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
            appCompatDelegateVar.cj();
            eut eutVar = appCompatDelegateVar.ab;
            if (menuItem.getItemId() != 16908332 || eutVar == null || (((ekt) eutVar.at).b & 4) == 0
                    || (intentX = cna.x(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(intentX)) {
                navigateUpTo(intentX);
                return true;
            }
            dqa dqaVar = new dqa(this);
            Intent intentX2 = cna.x(this);
            if (intentX2 == null) {
                intentX2 = cna.x(this);
            }
            if (intentX2 != null) {
                ComponentName component = intentX2.getComponent();
                if (component == null) {
                    component = intentX2.resolveActivity(dqaVar.b.getPackageManager());
                }
                dqaVar.c(component);
                dqaVar.a.add(intentX2);
            }
            dqaVar.d();
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f = false;
        ((bdm) this.c.v).g.bq(5);
        this.d.m(LifeEventEnum.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegate) j()).cf();
    }

    @Override // android.app.Activity
    public final void onPostResume() {
        m();
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        appCompatDelegateVar.cj();
        eut eutVar = appCompatDelegateVar.ab;
        if (eutVar != null) {
            eutVar.bi = true;
        }
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.c.z();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final void onResume() {
        erp erpVar = this.c;
        erpVar.z();
        super.onResume();
        this.f = true;
        ((bdm) erpVar.v).g.bw(true);
    }

    @Override // android.app.Activity
    public final void onStart() {
        n();
        ((AppCompatDelegate) j()).by(true, false);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.c.z();
    }

    @Override // android.app.Activity
    public final void onStop() {
        o();
        AppCompatDelegate appCompatDelegateVar = (AppCompatDelegate) j();
        appCompatDelegateVar.cj();
        eut eutVar = appCompatDelegateVar.ab;
        if (eutVar != null) {
            eutVar.bi = false;
            esh eshVar = eutVar.bh;
            if (eshVar != null) {
                eshVar.g();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        j().s(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((AppCompatDelegate) j()).cj();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i) {
        ao();
        j().p(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper,
              // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegate) j()).bg = i;
    }

    @Override // me.hd.wauxv.obf.aci, android.app.Activity
    public void setContentView(View view) {
        ao();
        j().q(view);
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ao();
        j().r(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((bdm) this.c.v).g.f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }
}
