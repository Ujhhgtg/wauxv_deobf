package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.rh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        throwIfVar1IsNull(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j, rh rhVar, long j2) throws IOException {
        throwIfVar1IsNull(rhVar, "sink");
        if (j2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j3, j4, rhVar);
            j3 += jTransferTo;
            j4 -= jTransferTo;
        }
    }

    public final void write(long j, rh rhVar, long j2) throws IOException {
        throwIfVar1IsNull(rhVar, "source");
        if (j2 < 0 || j2 > rhVar.b) {
            throw new IndexOutOfBoundsException();
        }
        long j3 = j;
        long j4 = j2;
        while (j4 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(rhVar, j3, j4);
            j3 += jTransferFrom;
            j4 -= jTransferFrom;
        }
    }
}
