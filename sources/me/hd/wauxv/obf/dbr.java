package me.hd.wauxv.obf;

import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dbr {
    public static final int a;
    public static final int b;

    static {
        int i;
        String[] strArr = {"System.out", "stdout", "sysout"};
        String property = System.getProperty("slf4j.internal.report.stream");
        int i2 = 2;
        if (property != null && !property.isEmpty()) {
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    i = 1;
                    break;
                } else {
                    if (strArr[i3].equalsIgnoreCase(property)) {
                        i = 2;
                        break;
                    }
                    i3++;
                }
            }
        } else {
            i = 1;
            break;
        }
        a = i;
        String property2 = System.getProperty("slf4j.internal.verbosity");
        if (property2 != null && !property2.isEmpty()) {
            if (property2.equalsIgnoreCase("DEBUG")) {
                i2 = 1;
            } else if (property2.equalsIgnoreCase("ERROR")) {
                i2 = 4;
            } else if (property2.equalsIgnoreCase("WARN")) {
                i2 = 3;
            }
        }
        b = i2;
    }

    public static final void c(String str, Throwable th) {
        d().println("SLF4J(E): " + str);
        d().println("SLF4J(E): Reported exception:");
        th.printStackTrace(d());
    }

    public static PrintStream d() {
        return StaticHelpers6.ae(a) != 1 ? System.err : System.out;
    }

    public static final void e(String str) {
        if (StaticHelpers6.ae(3) >= StaticHelpers6.ae(b)) {
            d().println("SLF4J(W): " + str);
        }
    }
}
