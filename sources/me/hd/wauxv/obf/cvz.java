package me.hd.wauxv.obf;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cvz {
    public static final dcf a = new dcf();
    public static final Object b = new Object();
    public static cbm c = null;

    public static long d(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? az.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    public static cbm e() {
        cbm cbmVar = new cbm(14);
        c = cbmVar;
        dcf dcfVar = a;
        dcfVar.getClass();
        if (al.c.g(dcfVar, null, cbmVar)) {
            al.h(dcfVar);
        }
        return c;
    }

    /* JADX WARN: Found duplicated region for block: B:101:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:109:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:20:0x002c  */
    /* JADX WARN: Found duplicated region for block: B:21:0x002e  */
    /* JADX WARN: Found duplicated region for block: B:43:0x006f  */
    /* JADX WARN: Found duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Found duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Found duplicated region for block: B:67:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Found duplicated region for block: B:69:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:70:0x00ca  */
    /* JADX WARN: Found duplicated region for block: B:71:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:72:0x00ce  */
    public static void f(Context context, boolean z) {
        int i;
        boolean z2;
        int i2;
        boolean z3;
        long length;
        boolean z4;
        File file;
        cvy cvyVarE;
        cvy cvyVar;
        int i3;
        AssetFileDescriptor assetFileDescriptorOpenFd;
        if (z || c == null) {
            synchronized (b) {
                if (z) {
                    i = 0;
                    assetFileDescriptorOpenFd = context.getAssets().openFd("dexopt/baseline.prof");
                    if (assetFileDescriptorOpenFd.getLength() > 0) {
                    }
                    assetFileDescriptorOpenFd.close();
                    i2 = Build.VERSION.SDK_INT;
                    if (i2 >= 28) {
                        File file2 = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                        long length2 = file2.length();
                        if (file2.exists()) {
                        }
                        File file3 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                        length = file3.length();
                        if (file3.exists()) {
                        }
                        long jD = d(context);
                        file = new File(context.getFilesDir(), "profileInstalled");
                        cvyVarE = file.exists() ? cvy.e(file) : null;
                        if (cvyVarE == null) {
                            if (!z2) {
                                i = 327680;
                            } else if (z3) {
                                i = 1;
                            } else if (z4) {
                                i = 2;
                            }
                        } else if (!z2) {
                            i = 327680;
                        } else if (z3) {
                            i = 1;
                        } else if (z4) {
                            i = 2;
                        }
                        if (z) {
                            i = 2;
                        }
                        if (cvyVarE != null) {
                            i = 3;
                        }
                        cvyVar = new cvy(1, i, jD, length);
                        if (cvyVarE != null) {
                            cvyVar.f(file);
                        } else {
                            cvyVar.f(file);
                        }
                        e();
                        return;
                    }
                    e();
                    return;
                }
                if (c != null) {
                    return;
                }
                i = 0;
                try {
                    assetFileDescriptorOpenFd = context.getAssets().openFd("dexopt/baseline.prof");
                    try {
                        z2 = assetFileDescriptorOpenFd.getLength() > 0;
                        assetFileDescriptorOpenFd.close();
                    } catch (Throwable th) {
                        if (assetFileDescriptorOpenFd == null) {
                            throw th;
                        }
                        try {
                            assetFileDescriptorOpenFd.close();
                            throw th;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                            throw th;
                        }
                    }
                } catch (IOException unused) {
                    z2 = false;
                }
                i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28 && i2 != 30) {
                    File file22 = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                    long length22 = file22.length();
                    z3 = !file22.exists() && length22 > 0;
                    File file32 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                    length = file32.length();
                    z4 = !file32.exists() && length > 0;
                    try {
                        long jD2 = d(context);
                        file = new File(context.getFilesDir(), "profileInstalled");
                        if (file.exists()) {
                            try {
                            } catch (IOException unused2) {
                                e();
                                return;
                            }
                        }
                        if (cvyVarE == null && cvyVarE.c == jD2 && (i3 = cvyVarE.b) != 2) {
                            i = i3;
                        } else if (!z2) {
                            i = 327680;
                        } else if (z3) {
                            i = 1;
                        } else if (z4) {
                            i = 2;
                        }
                        if (z && z4 && i != 1) {
                            i = 2;
                        }
                        if (cvyVarE != null && cvyVarE.b == 2 && i == 1 && length22 < cvyVarE.d) {
                            i = 3;
                        }
                        cvyVar = new cvy(1, i, jD2, length);
                        if (cvyVarE != null || !cvyVarE.equals(cvyVar)) {
                            try {
                                cvyVar.f(file);
                            } catch (IOException unused3) {
                            }
                        }
                        e();
                        return;
                    } catch (PackageManager.NameNotFoundException unused4) {
                        e();
                        return;
                    }
                }
                e();
                return;
                throw th;
            }
        }
    }
}
