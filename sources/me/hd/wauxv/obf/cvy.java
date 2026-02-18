package me.hd.wauxv.obf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cvy {
    public final int a;
    public final int b;
    public final long c;
    public final long d;

    public cvy(int i, int i2, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    public static cvy e(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            cvy cvyVar = new cvy(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return cvyVar;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof cvy)) {
            cvy cvyVar = (cvy) obj;
            if (this.b == cvyVar.b && this.c == cvyVar.c && this.a == cvyVar.a && this.d == cvyVar.d) {
                return true;
            }
        }
        return false;
    }

    public final void f(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.a);
            dataOutputStream.writeInt(this.b);
            dataOutputStream.writeLong(this.c);
            dataOutputStream.writeLong(this.d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.b), Long.valueOf(this.c), Integer.valueOf(this.a), Long.valueOf(this.d));
    }
}
