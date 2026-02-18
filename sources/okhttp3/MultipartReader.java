package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.b;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.crv;
import me.hd.wauxv.obf.dfj;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.dts;
import me.hd.wauxv.obf.ekb;
import me.hd.wauxv.obf.ekc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final crv afterBoundaryOptions;
    private final String boundary;
    private boolean closed;
    private final sj crlfDashDashBoundary;
    private PartSource currentPart;
    private final sj dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final rm source;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final crv getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }

        private Companion() {
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Part implements Closeable {
        private final rm body;
        private final Headers headers;

        public Part(Headers headers, rm rmVar) {
            throwIfVar1IsNull(headers, "headers");
            throwIfVar1IsNull(rmVar, "body");
            this.headers = headers;
            this.body = rmVar;
        }

        public final rm body() {
            return this.body;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.body.close();
        }

        public final Headers headers() {
            return this.headers;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public final class PartSource implements dlc {
        private final ekc timeout = new ekc();

        public PartSource() {
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (nullSafeIsEqual(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override // me.hd.wauxv.obf.dlc
        public long read(rh rhVar, long j) {
            long j2;
            long j3;
            throwIfVar1IsNull(rhVar, "sink");
            if (j < 0) {
                throw new IllegalArgumentException(dts.b(j, "byteCount < 0: ").toString());
            }
            if (!nullSafeIsEqual(MultipartReader.this.currentPart, this)) {
                throw new IllegalStateException("closed");
            }
            ekc ekcVarTimeout = MultipartReader.this.source.timeout();
            ekc ekcVar = this.timeout;
            MultipartReader multipartReader = MultipartReader.this;
            long jTimeoutNanos = ekcVarTimeout.timeoutNanos();
            ekb ekbVar = ekc.Companion;
            long jTimeoutNanos2 = ekcVar.timeoutNanos();
            long jTimeoutNanos3 = ekcVarTimeout.timeoutNanos();
            ekbVar.getClass();
            if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
                jTimeoutNanos2 = jTimeoutNanos3;
            }
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            ekcVarTimeout.timeout(jTimeoutNanos2, timeUnit);
            if (!ekcVarTimeout.hasDeadline()) {
                if (ekcVar.hasDeadline()) {
                    ekcVarTimeout.deadlineNanoTime(ekcVar.deadlineNanoTime());
                }
                try {
                    long jCurrentPartBytesRemaining = multipartReader.currentPartBytesRemaining(j);
                    return jCurrentPartBytesRemaining == 0 ? -1L
                            : multipartReader.source.read(rhVar, jCurrentPartBytesRemaining);
                } finally {
                    ekcVarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                    if (ekcVar.hasDeadline()) {
                        ekcVarTimeout.clearDeadline();
                    }
                }
            }
            long jDeadlineNanoTime = ekcVarTimeout.deadlineNanoTime();
            if (ekcVar.hasDeadline()) {
                j2 = jDeadlineNanoTime;
                ekcVarTimeout.deadlineNanoTime(Math.min(ekcVarTimeout.deadlineNanoTime(), ekcVar.deadlineNanoTime()));
            } else {
                j2 = jDeadlineNanoTime;
            }
            try {
                long jCurrentPartBytesRemaining2 = multipartReader.currentPartBytesRemaining(j);
                long j4 = jCurrentPartBytesRemaining2 == 0 ? -1L
                        : multipartReader.source.read(rhVar, jCurrentPartBytesRemaining2);
                ekcVarTimeout.timeout(jTimeoutNanos, timeUnit);
                if (ekcVar.hasDeadline()) {
                    j3 = j2;
                }
                return j4;
            } finally {
                j3 = j2;
                ekcVarTimeout.timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (ekcVar.hasDeadline()) {
                    ekcVarTimeout.deadlineNanoTime(j3);
                }
            }
        }

        @Override // me.hd.wauxv.obf.dlc
        public ekc timeout() {
            return this.timeout;
        }
    }

    static {
        sj sjVar = sj.a;
        afterBoundaryOptions = emn.ao(nu.g("\r\n"), nu.g("--"), nu.g(" "), nu.g("\t"));
    }

    public MultipartReader(rm rmVar, String str) {
        throwIfVar1IsNull(rmVar, "source");
        throwIfVar1IsNull(str, "boundary");
        this.source = rmVar;
        this.boundary = str;
        rh rhVar = new rh();
        rhVar.at("--");
        rhVar.at(str);
        this.dashDashBoundary = rhVar.e(rhVar.b);
        rh rhVar2 = new rh();
        rhVar2.at("\r\n--");
        rhVar2.at(str);
        this.crlfDashDashBoundary = rhVar2.e(rhVar2.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Found duplicated region for block: B:44:0x0117 */
    /* JADX WARN: Found duplicated region for block: B:46:0x012e */
    public final long currentPartBytesRemaining(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        this.source.ah(this.crlfDashDashBoundary.g());
        rh rhVarC = this.source.c();
        sj sjVar = this.crlfDashDashBoundary;
        rhVarC.getClass();
        throwIfVar1IsNull(sjVar, "bytes");
        if (sjVar.g() <= 0) {
            throw new IllegalArgumentException("bytes is empty");
        }
        dfj dfjVar = rhVarC.a;
        if (dfjVar != null) {
            long j7 = rhVarC.b;
            long j8 = 0;
            if (j7 < 0) {
                while (j7 > 0) {
                    dfjVar = dfjVar.g;
                    throwIfVar1IsNull(dfjVar);
                    j7 -= (long) (dfjVar.c - dfjVar.b);
                }
                j2 = 1;
                byte[] bArrI = sjVar.i();
                byte b = bArrI[0];
                int iG = sjVar.g();
                j3 = -1;
                long j9 = (rhVarC.b - ((long) iG)) + 1;
                while (true) {
                    if (j7 < j9) {
                        byte[] bArr = dfjVar.a;
                        j4 = j7;
                        int iMin = (int) Math.min(dfjVar.c, (((long) dfjVar.b) + j9) - j4);
                        int i = (int) ((((long) dfjVar.b) + j8) - j4);
                        while (true) {
                            if (i >= iMin) {
                                j8 = j4 + ((long) (dfjVar.c - dfjVar.b));
                                dfjVar = dfjVar.f;
                                throwIfVar1IsNull(dfjVar);
                                j7 = j8;
                            } else if (bArr[i] == b && b.tryGetClassByName(dfjVar, i + 1, bArrI, iG)) {
                                j5 = i - dfjVar.b;
                                j6 = j5 + j4;
                            } else {
                                i++;
                            }
                        }
                    }
                }
            } else {
                j2 = 1;
                j3 = -1;
                long j10 = 0;
                while (true) {
                    long j11 = ((long) (dfjVar.c - dfjVar.b)) + j10;
                    if (j11 > 0) {
                        break;
                    }
                    dfjVar = dfjVar.f;
                    throwIfVar1IsNull(dfjVar);
                    j10 = j11;
                }
                byte[] bArrI2 = sjVar.i();
                byte b2 = bArrI2[0];
                int iG2 = sjVar.g();
                long j12 = (rhVarC.b - ((long) iG2)) + 1;
                while (true) {
                    if (j10 < j12) {
                        byte[] bArr2 = dfjVar.a;
                        j4 = j10;
                        int iMin2 = (int) Math.min(dfjVar.c, (((long) dfjVar.b) + j12) - j4);
                        int i2 = (int) ((((long) dfjVar.b) + j8) - j4);
                        while (true) {
                            if (i2 >= iMin2) {
                                j8 = j4 + ((long) (dfjVar.c - dfjVar.b));
                                dfjVar = dfjVar.f;
                                throwIfVar1IsNull(dfjVar);
                                j10 = j8;
                            } else if (bArr2[i2] == b2 && b.b(dfjVar, i2 + 1, bArrI2, iG2)) {
                                j5 = i2 - dfjVar.b;
                                j6 = j5 + j4;
                            } else {
                                i2++;
                            }
                        }
                    }
                }
            }
            return j6 == j3 ? Math.min(j, (this.source.c().b - ((long) this.crlfDashDashBoundary.g())) + j2)
                    : Math.min(j, j6);
        }
        j2 = 1;
        j3 = -1;
        j6 = j3;
        if (j6 == j3) {
        }
    }

    public final String boundary() {
        return this.boundary;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    public final Part nextPart() throws ProtocolException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.noMoreParts) {
            return null;
        }
        if (this.partCount == 0 && this.source.s(0L, this.dashDashBoundary)) {
            this.source.skip(this.dashDashBoundary.g());
        } else {
            while (true) {
                long jCurrentPartBytesRemaining = currentPartBytesRemaining(8192L);
                if (jCurrentPartBytesRemaining == 0) {
                    break;
                }
                this.source.skip(jCurrentPartBytesRemaining);
            }
            this.source.skip(this.crlfDashDashBoundary.g());
        }
        boolean z = false;
        while (true) {
            int iAb = this.source.ab(afterBoundaryOptions);
            if (iAb == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iAb == 0) {
                this.partCount++;
                Headers headers = new HeadersReader(this.source).readHeaders();
                PartSource partSource = new PartSource();
                this.currentPart = partSource;
                return new Part(headers, emc.ah(partSource));
            }
            if (iAb == 1) {
                if (z) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.partCount == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.noMoreParts = true;
                return null;
            }
            if (iAb == 2 || iAb == 3) {
                z = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MultipartReader(ResponseBody responseBody) throws ProtocolException {
        String strParameter;
        throwIfVar1IsNull(responseBody, "response");
        rm rmVarSource = responseBody.source();
        MediaType mediaTypeContentType = responseBody.contentType();
        if (mediaTypeContentType != null && (strParameter = mediaTypeContentType.parameter("boundary")) != null) {
            this(rmVarSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
