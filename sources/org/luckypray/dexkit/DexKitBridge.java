package org.luckypray.dexkit;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import me.hd.wauxv.obf.abe;
import me.hd.wauxv.obf.bag;
import me.hd.wauxv.obf.bah;
import me.hd.wauxv.obf.bbb;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.c;
import me.hd.wauxv.obf.cdg;
import me.hd.wauxv.obf.cna;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.ex;
import me.hd.wauxv.obf.yw;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DexKitBridge implements Closeable {
    public long a;

    public static final long b(DexKitBridge dexKitBridge) {
        long j = dexKitBridge.a;
        if (j != 0) {
            return j;
        }
        throw new IllegalStateException("DexKitBridge is not valid");
    }

    private static final native byte[] nativeFindClass(long j, byte[] bArr);

    private static final native byte[] nativeFindMethod(long j, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native byte[] nativeGetClassByIds(long j, long[] jArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static final native long nativeInitDexKitByClassLoader(ClassLoader classLoader, boolean z);

    private static final native void nativeRelease(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        long j = this.a;
        if (j != 0) {
            nativeRelease(j);
            this.a = 0L;
        }
    }

    public final yw e(bag bagVar) {
        bbb bbbVar = new bbb();
        bagVar.c(bbbVar);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(nativeFindClass(b(this), bbbVar.z()));
        throwIfVar1IsNull(byteBufferWrap, "wrap(...)");
        c cVar = new c();
        cVar.h(byteBufferWrap.position() + bjs.f(byteBufferWrap, ByteOrder.LITTLE_ENDIAN), byteBufferWrap);
        yw ywVar = new yw();
        int iM = cVar.m();
        for (int i = 0; i < iM; i++) {
            c cVarL = cVar.l(i);
            throwIfVar1IsNull(cVarL);
            ywVar.add(cna.t(this, cVarL));
        }
        if (ywVar.size() > 1) {
            abe.am(ywVar, new ex(3));
        }
        return ywVar;
    }

    public final cdg f(bah bahVar) {
        bbb bbbVar = new bbb();
        bahVar.c(bbbVar);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(nativeFindMethod(b(this), bbbVar.z()));
        throwIfVar1IsNull(byteBufferWrap, "wrap(...)");
        c cVar = new c();
        cVar.h(byteBufferWrap.position() + bjs.f(byteBufferWrap, ByteOrder.LITTLE_ENDIAN), byteBufferWrap);
        cdg cdgVar = new cdg();
        int iG = cVar.g(4);
        int iK = iG != 0 ? cVar.k(iG) : 0;
        for (int i = 0; i < iK; i++) {
            c cVar2 = new c();
            int iG2 = cVar.g(4);
            if (iG2 != 0) {
                int iF = cVar.f((i * 4) + cVar.j(iG2));
                ByteBuffer byteBuffer = cVar.b;
                throwIfVar1IsNull(byteBuffer, "bb");
                cVar2.h(iF, byteBuffer);
            } else {
                cVar2 = null;
            }
            throwIfVar1IsNull(cVar2);
            cdgVar.add(emn.ak(this, cVar2));
        }
        if (cdgVar.size() > 1) {
            abe.am(cdgVar, new ex(4));
        }
        return cdgVar;
    }

    public final void finalize() {
        close();
    }
}
