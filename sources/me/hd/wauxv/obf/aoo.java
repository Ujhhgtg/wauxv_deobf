package me.hd.wauxv.obf;

import android.os.StrictMode;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aoo implements Closeable {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final long f;
    public BufferedWriter i;
    public int k;
    public long h = 0;
    public final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aol());
    public final aok n = new aok(this);
    public final int e = 1;
    public final int g = 1;

    public aoo(File file, long j) {
        this.a = file;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
        this.f = j;
    }

    public static void o(aoo aooVar, aom aomVar, boolean z) {
        synchronized (aooVar) {
            aon aonVar = (aon) aomVar.b;
            if (aonVar.f != aomVar) {
                throw new IllegalStateException();
            }
            if (z && !aonVar.e) {
                for (int i = 0; i < aooVar.g; i++) {
                    if (!((boolean[]) aomVar.c)[i]) {
                        aomVar.e();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!aonVar.d[i].exists()) {
                        aomVar.e();
                        return;
                    }
                }
            }
            for (int i2 = 0; i2 < aooVar.g; i2++) {
                File file = aonVar.d[i2];
                if (!z) {
                    q(file);
                } else if (file.exists()) {
                    File file2 = aonVar.c[i2];
                    file.renameTo(file2);
                    long j = aonVar.b[i2];
                    long length = file2.length();
                    aonVar.b[i2] = length;
                    aooVar.h = (aooVar.h - j) + length;
                }
            }
            aooVar.k++;
            aonVar.f = null;
            if (aonVar.e || z) {
                aonVar.e = true;
                aooVar.i.append((CharSequence) "CLEAN");
                aooVar.i.append(' ');
                aooVar.i.append((CharSequence) aonVar.a);
                aooVar.i.append((CharSequence) aonVar.h());
                aooVar.i.append('\n');
                if (z) {
                    aooVar.l++;
                }
            } else {
                aooVar.j.remove(aonVar.a);
                aooVar.i.append((CharSequence) "REMOVE");
                aooVar.i.append(' ');
                aooVar.i.append((CharSequence) aonVar.a);
                aooVar.i.append('\n');
            }
            r(aooVar.i);
            if (aooVar.h > aooVar.f || aooVar.w()) {
                aooVar.m.submit(aooVar.n);
            }
        }
    }

    public static void p(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void q(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void r(BufferedWriter bufferedWriter) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            bufferedWriter.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static aoo s(File file, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                t(file2, file3, false);
            }
        }
        aoo aooVar = new aoo(file, j);
        if (aooVar.b.exists()) {
            try {
                aooVar.y();
                aooVar.x();
                return aooVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                aooVar.close();
                eou.b(aooVar.a);
            }
        }
        file.mkdirs();
        aoo aooVar2 = new aoo(file, j);
        aooVar2.aa();
        return aooVar2;
    }

    public static void t(File file, File file2, boolean z) throws IOException {
        if (z) {
            q(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public final synchronized void aa() {
        try {
            BufferedWriter bufferedWriter = this.i;
            if (bufferedWriter != null) {
                p(bufferedWriter);
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), eou.a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(SdkVersion.MINI_VERSION);
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (aon aonVar : this.j.values()) {
                    if (aonVar.f != null) {
                        bufferedWriter2.write("DIRTY " + aonVar.a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + aonVar.a + aonVar.h() + '\n');
                    }
                }
                p(bufferedWriter2);
                if (this.b.exists()) {
                    t(this.b, this.d, true);
                }
                t(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), eou.a));
            } catch (Throwable th) {
                p(bufferedWriter2);
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void ab() {
        while (this.h > this.f) {
            String str = (String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey();
            synchronized (this) {
                try {
                    if (this.i == null) {
                        throw new IllegalStateException("cache is closed");
                    }
                    aon aonVar = (aon) this.j.get(str);
                    if (aonVar != null && aonVar.f == null) {
                        for (int i = 0; i < this.g; i++) {
                            File file = aonVar.c[i];
                            if (file.exists() && !file.delete()) {
                                throw new IOException("failed to delete " + file);
                            }
                            long j = this.h;
                            long[] jArr = aonVar.b;
                            this.h = j - jArr[i];
                            jArr[i] = 0;
                        }
                        this.k++;
                        this.i.append((CharSequence) "REMOVE");
                        this.i.append(' ');
                        this.i.append((CharSequence) str);
                        this.i.append('\n');
                        this.j.remove(str);
                        if (w()) {
                            this.m.submit(this.n);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                aom aomVar = ((aon) it.next()).f;
                if (aomVar != null) {
                    aomVar.e();
                }
            }
            ab();
            p(this.i);
            this.i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final aom u(String str) {
        synchronized (this) {
            try {
                if (this.i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                aon aonVar = (aon) this.j.get(str);
                if (aonVar == null) {
                    aonVar = new aon(this, str);
                    this.j.put(str, aonVar);
                } else if (aonVar.f != null) {
                    return null;
                }
                aom aomVar = new aom(this, aonVar);
                aonVar.f = aomVar;
                this.i.append((CharSequence) "DIRTY");
                this.i.append(' ');
                this.i.append((CharSequence) str);
                this.i.append('\n');
                r(this.i);
                return aomVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized erp v(String str) {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
        aon aonVar = (aon) this.j.get(str);
        if (aonVar == null) {
            return null;
        }
        if (!aonVar.e) {
            return null;
        }
        for (File file : aonVar.c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (w()) {
            this.m.submit(this.n);
        }
        return new erp(aonVar.c, 16);
    }

    public final boolean w() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    public final void x() throws IOException {
        q(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            aon aonVar = (aon) it.next();
            aom aomVar = aonVar.f;
            int i = this.g;
            int i2 = 0;
            if (aomVar == null) {
                while (i2 < i) {
                    this.h += aonVar.b[i2];
                    i2++;
                }
            } else {
                aonVar.f = null;
                while (i2 < i) {
                    q(aonVar.c[i2]);
                    q(aonVar.d[i2]);
                    i2++;
                }
                it.remove();
            }
        }
    }

    public final void y() {
        File file = this.b;
        dnb dnbVar = new dnb(new FileInputStream(file), eou.a);
        try {
            String strF = dnbVar.f();
            String strF2 = dnbVar.f();
            String strF3 = dnbVar.f();
            String strF4 = dnbVar.f();
            String strF5 = dnbVar.f();
            if (!"libcore.io.DiskLruCache".equals(strF) || !SdkVersion.MINI_VERSION.equals(strF2) || !Integer.toString(this.e).equals(strF3) || !Integer.toString(this.g).equals(strF4) || !"".equals(strF5)) {
                throw new IOException("unexpected journal header: [" + strF + ", " + strF2 + ", " + strF4 + ", " + strF5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    z(dnbVar.f());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (dnbVar.e == -1) {
                        aa();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), eou.a));
                    }
                    try {
                        dnbVar.close();
                        return;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                dnbVar.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final void z(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        aon aonVar = (aon) linkedHashMap.get(strSubstring);
        if (aonVar == null) {
            aonVar = new aon(this, strSubstring);
            linkedHashMap.put(strSubstring, aonVar);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                aonVar.f = new aom(this, aonVar);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith("READ")) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        aonVar.e = true;
        aonVar.f = null;
        if (strArrSplit.length != aonVar.g.g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                aonVar.b[i2] = Long.parseLong(strArrSplit[i2]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }
}
