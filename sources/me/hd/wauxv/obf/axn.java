package me.hd.wauxv.obf;

import android.system.ErrnoException;
import android.system.Os;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class axn {
    public static void a(FileDescriptor fileDescriptor) throws ErrnoException {
        Os.close(fileDescriptor);
    }

    public static FileDescriptor b(FileDescriptor fileDescriptor) {
        return Os.dup(fileDescriptor);
    }

    public static long c(FileDescriptor fileDescriptor, long j, int i) {
        return Os.lseek(fileDescriptor, j, i);
    }
}
