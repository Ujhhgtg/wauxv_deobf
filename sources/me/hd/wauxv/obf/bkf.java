package me.hd.wauxv.obf;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkf {
    public static final boolean a;
    public static final boolean b;
    public static final File c;
    public static volatile bkf d;
    public int f;
    public boolean g = true;
    public final AtomicBoolean h = new AtomicBoolean(false);
    public final int e = 20000;

    static {
        int i = Build.VERSION.SDK_INT;
        a = i < 29;
        b = i >= 28;
        c = new File("/proc/self/fd");
    }

    public static bkf i() {
        if (d == null) {
            synchronized (bkf.class) {
                try {
                    if (d == null) {
                        d = new bkf();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final int j() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.e;
    }

    public final boolean k(int i, int i2, boolean z, boolean z2) {
        boolean z3;
        if (z) {
            if (b) {
                if (!a || this.h.get()) {
                    if (z2) {
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (i >= 0 && i2 >= 0) {
                        synchronized (this) {
                            try {
                                int i3 = this.f + 1;
                                this.f = i3;
                                if (i3 >= 50) {
                                    this.f = 0;
                                    int length = c.list().length;
                                    long j = j();
                                    boolean z4 = ((long) length) < j;
                                    this.g = z4;
                                    if (!z4 && Log.isLoggable("Downsampler", 5)) {
                                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + j);
                                    }
                                }
                                z3 = this.g;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z3) {
                            return true;
                        }
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by app state");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }
}
