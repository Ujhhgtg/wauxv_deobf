package me.hd.wauxv.obf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class sf {
    public static final AtomicReference a = new AtomicReference();

    public static MappedByteBuffer b(File file) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer c(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        AtomicReference atomicReference = a;
        byte[] bArr = (byte[]) atomicReference.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[16384];
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                atomicReference.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static void e(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        d(byteBuffer);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }
}
