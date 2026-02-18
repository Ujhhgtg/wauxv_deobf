package me.hd.wauxv.obf;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bjr implements dlc {
    public byte a;
    public final cyl b;
    public final Inflater c;
    public final bpd d;
    public final CRC32 e;

    public bjr(dlc dlcVar) {
        throwIfVar1IsNull(dlcVar, "source");
        cyl cylVar = new cyl(dlcVar);
        this.b = cylVar;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.d = new bpd(cylVar, inflater);
        this.e = new CRC32();
    }

    public static void f(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x",
                    Arrays.copyOf(new Object[] { str, Integer.valueOf(i2), Integer.valueOf(i) }, 3)));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.d.close();
    }

    public final void g(long j, rh rhVar, long j2) {
        dfj dfjVar = rhVar.a;
        throwIfVar1IsNull(dfjVar);
        while (true) {
            int i = dfjVar.c;
            int i2 = dfjVar.b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
        }
        while (j2 > 0) {
            int i3 = (int) (((long) dfjVar.b) + j);
            int iMin = (int) Math.min(dfjVar.c - i3, j2);
            this.e.update(dfjVar.a, i3, iMin);
            j2 -= (long) iMin;
            dfjVar = dfjVar.f;
            throwIfVar1IsNull(dfjVar);
            j = 0;
        }
    }

    @Override // me.hd.wauxv.obf.dlc
    public final long read(rh rhVar, long j) throws IOException {
        long j2;
        bjr bjrVar = this;
        throwIfVar1IsNull(rhVar, "sink");
        if (j < 0) {
            throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
        }
        if (j == 0) {
            return 0L;
        }
        byte b = bjrVar.a;
        CRC32 crc32 = bjrVar.e;
        cyl cylVar = bjrVar.b;
        if (b == 0) {
            cylVar.ah(10L);
            rh rhVar2 = cylVar.b;
            byte bN = rhVar2.n(3L);
            boolean z = ((bN >> 1) & 1) == 1;
            if (z) {
                bjrVar.g(0L, rhVar2, 10L);
            }
            f("ID1ID2", 8075, cylVar.readShort());
            cylVar.skip(8L);
            if (((bN >> 2) & 1) == 1) {
                cylVar.ah(2L);
                if (z) {
                    g(0L, rhVar2, 2L);
                }
                short s = rhVar2.readShort();
                long j3 = ((short) (((s & 255) << 8) | ((s & 65280) >>> 8))) & 65535;
                cylVar.ah(j3);
                if (z) {
                    g(0L, rhVar2, j3);
                }
                cylVar.skip(j3);
            }
            if (((bN >> 3) & 1) == 1) {
                long jF = cylVar.f(0L, Long.MAX_VALUE, (byte) 0);
                if (jF == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j2 = 2;
                    g(0L, rhVar2, jF + 1);
                } else {
                    j2 = 2;
                }
                cylVar.skip(jF + 1);
            } else {
                j2 = 2;
            }
            if (((bN >> 4) & 1) == 1) {
                long j4 = j2;
                long jF2 = cylVar.f(0L, Long.MAX_VALUE, (byte) 0);
                if (jF2 == -1) {
                    throw new EOFException();
                }
                j2 = j4;
                if (z) {
                    bjrVar = this;
                    bjrVar.g(0L, rhVar2, jF2 + 1);
                } else {
                    bjrVar = this;
                }
                cylVar.skip(jF2 + 1);
            } else {
                bjrVar = this;
            }
            if (z) {
                cylVar.ah(j2);
                short s2 = rhVar2.readShort();
                f("FHCRC", (short) (((s2 & 255) << 8) | ((s2 & 65280) >>> 8)), (short) crc32.getValue());
                crc32.reset();
            }
            bjrVar.a = (byte) 1;
        }
        if (bjrVar.a == 1) {
            long j5 = rhVar.b;
            long j6 = bjrVar.d.read(rhVar, j);
            if (j6 != -1) {
                bjrVar.g(j5, rhVar, j6);
                return j6;
            }
            bjrVar.a = (byte) 2;
        }
        if (bjrVar.a == 2) {
            f("CRC", cylVar.g(), (int) crc32.getValue());
            f("ISIZE", cylVar.g(), (int) bjrVar.c.getBytesWritten());
            bjrVar.a = (byte) 3;
            if (!cylVar.i()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // me.hd.wauxv.obf.dlc
    public final ekc timeout() {
        return this.b.a.timeout();
    }
}
