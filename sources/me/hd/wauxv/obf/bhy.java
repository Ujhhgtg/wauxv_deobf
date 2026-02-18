package me.hd.wauxv.obf;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhy extends Exception {
    public static final StackTraceElement[] a = new StackTraceElement[0];
    public final List b;
    public btj c;
    public int d;
    public Class e;
    public final String f;

    public bhy(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    public static void g(Throwable th, ArrayList arrayList) {
        if (th instanceof bhy) {
            Iterator it = ((bhy) th).b.iterator();
            while (it.hasNext()) {
                g((Throwable) it.next(), arrayList);
            }
        } else if (th != null) {
            arrayList.add(th);
        }
    }

    public static void h(List list, bhx bhxVar) throws IOException {
        int size = list.size();
        int i = 0;
        while (i < size) {
            bhxVar.append("Cause (");
            int i2 = i + 1;
            bhxVar.append(String.valueOf(i2));
            bhxVar.append(" of ");
            bhxVar.append(String.valueOf(size));
            bhxVar.append("): ");
            Throwable th = (Throwable) list.get(i);
            if (th instanceof bhy) {
                ((bhy) th).k(bhxVar);
            } else {
                i(th, bhxVar);
            }
            i = i2;
        }
    }

    public static void i(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f);
        sb.append(this.e != null ? ", " + this.e : "");
        int i = this.d;
        sb.append(i != 0 ? ", ".concat(yg.x(i)) : "");
        sb.append(this.c != null ? ", " + this.c : "");
        ArrayList<Throwable> arrayList = new ArrayList();
        g(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" root causes:");
        }
        for (Throwable th : arrayList) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public final void j() {
        ArrayList arrayList = new ArrayList();
        g(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i2 = i + 1;
            sb.append(i2);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i("Glide", sb.toString(), (Throwable) arrayList.get(i));
            i = i2;
        }
    }

    public final void k(Appendable appendable) {
        i(this, appendable);
        try {
            h(this.b, new bhx(appendable));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        k(System.err);
    }

    public bhy(String str, List list) {
        this.f = str;
        setStackTrace(a);
        this.b = list;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        k(printStream);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        k(printWriter);
    }
}
