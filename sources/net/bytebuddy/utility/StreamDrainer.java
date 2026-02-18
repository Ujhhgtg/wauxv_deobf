package net.bytebuddy.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class StreamDrainer {
    public static final StreamDrainer DEFAULT = new StreamDrainer();
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    private static final int END_OF_STREAM = -1;
    private static final int FROM_BEGINNING = 0;
    private final int bufferSize;

    public StreamDrainer() {
        this(1024);
    }

    public byte[] drain(InputStream inputStream) throws IOException {
        int i;
        ArrayList<byte[]> arrayList = new ArrayList();
        byte[] bArr = new byte[this.bufferSize];
        int i2 = 0;
        do {
            i = inputStream.read(bArr, i2, this.bufferSize - i2);
            int iMax = Math.max(i, 0) + i2;
            if (iMax == this.bufferSize) {
                arrayList.add(bArr);
                bArr = new byte[this.bufferSize];
                i2 = 0;
            } else {
                i2 = iMax;
            }
        } while (i != -1);
        byte[] bArr2 = new byte[(arrayList.size() * this.bufferSize) + i2];
        int i3 = 0;
        for (byte[] bArr3 : arrayList) {
            int i4 = this.bufferSize;
            System.arraycopy(bArr3, 0, bArr2, i3 * i4, i4);
            i3++;
        }
        System.arraycopy(bArr, 0, bArr2, i3 * this.bufferSize, i2);
        return bArr2;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.bufferSize == ((StreamDrainer) obj).bufferSize;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.bufferSize;
    }

    public StreamDrainer(int i) {
        this.bufferSize = i;
    }
}
