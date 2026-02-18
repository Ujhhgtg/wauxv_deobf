package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.ekc;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.sj;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final sj PREFIX_CLEAN;
    public static final sj PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final rh buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final sj metadata;
    private int sourceCount;
    private dlc upstream;
    private final rh upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final Relay edit(File file, dlc dlcVar, sj sjVar, long j) throws IOException {
            bzo.q(file, "file");
            bzo.q(dlcVar, "upstream");
            bzo.q(sjVar, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, dlcVar, 0L, sjVar, j, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            bzo.q(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            bzo.p(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            rh rhVar = new rh();
            fileOperator.read(0L, rhVar, Relay.FILE_HEADER_SIZE);
            if (!bzo.f(rhVar.e(r11.g()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long j = rhVar.readLong();
            long j2 = rhVar.readLong();
            rh rhVar2 = new rh();
            fileOperator.read(Relay.FILE_HEADER_SIZE + j, rhVar2, j2);
            return new Relay(randomAccessFile, null, j, rhVar2.e(rhVar2.b), 0L, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public final class RelaySource implements dlc {
        private FileOperator fileOperator;
        private long sourcePos;
        private final ekc timeout = new ekc();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            bzo.n(file);
            FileChannel channel = file.getChannel();
            bzo.p(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
        	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
         */
        @Override // me.hd.wauxv.obf.dlc
        public long read(rh rhVar, long j) throws IOException {
            char c;
            bzo.q(rhVar, "sink");
            if (this.fileOperator == null) {
                throw new IllegalStateException("Check failed.");
            }
            Relay relay = Relay.this;
            synchronized (relay) {
                while (true) {
                    try {
                        if (this.sourcePos != relay.getUpstreamPos()) {
                            long upstreamPos = relay.getUpstreamPos() - relay.getBuffer().b;
                            if (this.sourcePos < upstreamPos) {
                                c = 2;
                                break;
                            }
                            long jMin = Math.min(j, relay.getUpstreamPos() - this.sourcePos);
                            relay.getBuffer().l(this.sourcePos - upstreamPos, rhVar, jMin);
                            this.sourcePos += jMin;
                            return jMin;
                        }
                        if (!relay.getComplete()) {
                            if (relay.getUpstreamReader() == null) {
                                relay.setUpstreamReader(Thread.currentThread());
                                c = 1;
                                break;
                            }
                            this.timeout.waitUntilNotified(relay);
                        } else {
                            return -1L;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (c == 2) {
                    long jMin2 = Math.min(j, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    bzo.n(fileOperator);
                    fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, rhVar, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    dlc upstream = Relay.this.getUpstream();
                    bzo.n(upstream);
                    long j2 = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (j2 == -1) {
                        Relay relay2 = Relay.this;
                        relay2.commit(relay2.getUpstreamPos());
                        Relay relay3 = Relay.this;
                        synchronized (relay3) {
                            try {
                                relay3.setUpstreamReader(null);
                                relay3.notifyAll();
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j2, j);
                    Relay.this.getUpstreamBuffer().l(0L, rhVar, jMin3);
                    this.sourcePos += jMin3;
                    FileOperator fileOperator2 = this.fileOperator;
                    bzo.n(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + Relay.FILE_HEADER_SIZE, Relay.this.getUpstreamBuffer().clone(), j2);
                    Relay relay4 = Relay.this;
                    synchronized (relay4) {
                        try {
                            relay4.getBuffer().write(relay4.getUpstreamBuffer(), j2);
                            if (relay4.getBuffer().b > relay4.getBufferMaxSize()) {
                                relay4.getBuffer().skip(relay4.getBuffer().b - relay4.getBufferMaxSize());
                            }
                            relay4.setUpstreamPos(relay4.getUpstreamPos() + j2);
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                    Relay relay5 = Relay.this;
                    synchronized (relay5) {
                        try {
                            relay5.setUpstreamReader(null);
                            relay5.notifyAll();
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                    return jMin3;
                } catch (Throwable th5) {
                    Relay relay6 = Relay.this;
                    synchronized (relay6) {
                        try {
                            relay6.setUpstreamReader(null);
                            relay6.notifyAll();
                            throw th5;
                        } catch (Throwable th6) {
                            throw th6;
                        }
                    }
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
        PREFIX_CLEAN = nu.g("OkHttp cache v1\n");
        PREFIX_DIRTY = nu.g("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, dlc dlcVar, long j, sj sjVar, long j2, akd akdVar) {
        this(randomAccessFile, dlcVar, j, sjVar, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(sj sjVar, long j, long j2) throws IOException {
        rh rhVar = new rh();
        rhVar.al(sjVar);
        rhVar.aq(j);
        rhVar.aq(j2);
        if (rhVar.b != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        RandomAccessFile randomAccessFile = this.file;
        bzo.n(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        bzo.p(channel, "file!!.channel");
        new FileOperator(channel).write(0L, rhVar, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long j) throws IOException {
        rh rhVar = new rh();
        rhVar.al(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        bzo.n(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        bzo.p(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j, rhVar, this.metadata.g());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        bzo.n(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.g());
        RandomAccessFile randomAccessFile2 = this.file;
        bzo.n(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        dlc dlcVar = this.upstream;
        if (dlcVar != null) {
            Util.closeQuietly(dlcVar);
        }
        this.upstream = null;
    }

    public final rh getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final dlc getUpstream() {
        return this.upstream;
    }

    public final rh getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final sj metadata() {
        return this.metadata;
    }

    public final dlc newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(dlc dlcVar) {
        this.upstream = dlcVar;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, dlc dlcVar, long j, sj sjVar, long j2) {
        this.file = randomAccessFile;
        this.upstream = dlcVar;
        this.upstreamPos = j;
        this.metadata = sjVar;
        this.bufferMaxSize = j2;
        this.upstreamBuffer = new rh();
        this.complete = dlcVar == null;
        this.buffer = new rh();
    }
}
