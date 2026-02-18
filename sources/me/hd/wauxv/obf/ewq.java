package me.hd.wauxv.obf;

import android.util.Log;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewq {
    public static final ArrayList a = new ArrayList();
    public static final dop b = new dop(24);
    public static boolean c;

    public static void d(int i, String str) {
        i(ewp.a, new ewr(cna.d, "D", String.valueOf(str), null, 51), false);
    }

    public static void e(String str, Exception exc, int i) {
        if ((i & 2) != 0) {
            exc = null;
        }
        i(ewp.a, new ewr(cna.d, "E", String.valueOf(str), exc, 51), false);
    }

    public static void f() {
        int i = bte.a;
        dov dovVar = bth.a;
        if (!((Boolean) bth.b.getValue()).booleanValue()) {
            System.setProperty("org.slf4j.simpleLogger.defaultLogLevel", "info");
        }
        bth.d = btf.INFO;
        if (c) {
            return;
        }
        bth.c = b;
        c = true;
    }

    public static void g(int i, String str, Throwable th) {
        if ((i & 2) != 0) {
            th = null;
        }
        Throwable th2 = th;
        i(ewp.a, new ewr(null, "E", String.valueOf(str), th2, 55), (i & 4) == 0);
    }

    public static void h(String str) {
        i(ewp.a, new ewr(null, "W", String.valueOf(str), null, 55), false);
    }

    public static void i(ewp ewpVar, ewr ewrVar, boolean z) {
        f();
        String str = ewrVar.g;
        boolean z2 = !dnj.ak(str) || (dnj.ak(str) && ewrVar.h != null);
        int iOrdinal = ewpVar.ordinal();
        if (iOrdinal == 0) {
            k(ewrVar);
            return;
        }
        if (iOrdinal == 1) {
            j(z2, ewrVar, z);
            return;
        }
        if (iOrdinal == 2) {
            boolean z3 = exm.a;
            if (exm.l()) {
                j(z2, ewrVar, z);
                return;
            } else {
                k(ewrVar);
                return;
            }
        }
        if (iOrdinal != 3) {
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        k(ewrVar);
        boolean z4 = exm.a;
        if (exm.l()) {
            j(z2, ewrVar, z);
        }
    }

    public static final void j(boolean z, ewr ewrVar, boolean z2) {
        if (z) {
            ewrVar.i = z2;
            String string = ewrVar.toString();
            Throwable th = ewrVar.h;
            if (bhs.r() != bmc.b) {
                int iOrdinal = bhs.r().ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal == 1) {
                        throw new IllegalStateException(
                                "YukiHookAPI cannot support current Hook API or cannot found any available Hook APIs in current environment");
                    }
                    throw new QueryDidNotReturnUniqueResultRuntimeException();
                }
                XposedBridge.log(string);
                if (th != null) {
                    XposedBridge.log(th);
                }
            }
        }
    }

    public static final void k(ewr ewrVar) {
        String str = ewrVar.d;
        Throwable th = ewrVar.h;
        String str2 = ewrVar.g;
        String str3 = ewrVar.c;
        int iHashCode = str.hashCode();
        if (iHashCode != 68) {
            if (iHashCode != 69) {
                if (iHashCode != 73) {
                    if (iHashCode == 87 && str.equals("W")) {
                        Log.w(str3, str2, th);
                        return;
                    }
                } else if (str.equals("I")) {
                    Log.i(str3, str2, th);
                    return;
                }
            } else if (str.equals("E")) {
                Log.e(str3, str2, th);
                return;
            }
        } else if (str.equals("D")) {
            Log.d(str3, str2, th);
            return;
        }
        Log.wtf(str3, str2, th);
    }
}
