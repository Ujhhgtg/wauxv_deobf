package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sc implements dcj {
    public static final nu a = new nu(11);
    public static final sb b = new sb(0);
    public final Context e;
    public final ArrayList f;
    public final DefaultConfig i;
    public final nu h = a;
    public final sb g = b;

    public sc(Context context, ArrayList arrayList, oz ozVar, bva bvaVar) {
        this.e = context.getApplicationContext();
        this.f = arrayList;
        this.i = new DefaultConfig(ozVar, 22, bvaVar);
    }

    public static int j(bhi bhiVar, int i, int i2) {
        int iMin = Math.min(bhiVar.g / i2, bhiVar.f / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            StringBuilder sbQ = yg.q(iMax, i, "Downsampling GIF, sampleSize: ", ", target dimens: [", "x");
            sbQ.append(i2);
            sbQ.append("], actual dimens: [");
            sbQ.append(bhiVar.f);
            sbQ.append("x");
            sbQ.append(bhiVar.g);
            sbQ.append("]");
            Log.v("BufferGifDecoder", sbQ.toString());
        }
        return iMax;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:25:0x0059
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1478)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // me.hd.wauxv.obf.dcj
    public final me.hd.wauxv.obf.dcg c(java.lang.Object r8, int r9, int r10, me.hd.wauxv.obf.crw r11) {
        /*
            r7 = this;
            r2 = r8
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            me.hd.wauxv.obf.sb r8 = r7.g
            monitor-enter(r8)
            java.util.ArrayDeque r0 = r8.a     // Catch: java.lang.Throwable -> L54
            java.lang.Object r0 = r0.poll()     // Catch: java.lang.Throwable -> L54
            me.hd.wauxv.obf.bhj r0 = (me.hd.wauxv.obf.bhj) r0     // Catch: java.lang.Throwable -> L54
            if (r0 != 0) goto L15
            me.hd.wauxv.obf.bhj r0 = new me.hd.wauxv.obf.bhj     // Catch: java.lang.Throwable -> L17
            r0.<init>()     // Catch: java.lang.Throwable -> L17
        L15:
            r5 = r0
            goto L1b
        L17:
            r0 = move-exception
            r9 = r0
            r1 = r7
            goto L57
        L1b:
            r0 = 0
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            byte[] r0 = r5.a     // Catch: java.lang.Throwable -> L54
            r1 = 0
            java.util.Arrays.fill(r0, r1)     // Catch: java.lang.Throwable -> L54
            me.hd.wauxv.obf.bhi r0 = new me.hd.wauxv.obf.bhi     // Catch: java.lang.Throwable -> L54
            r0.<init>()     // Catch: java.lang.Throwable -> L54
            r5.c = r0     // Catch: java.lang.Throwable -> L54
            r5.d = r1     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r2.asReadOnlyBuffer()     // Catch: java.lang.Throwable -> L54
            r5.b = r0     // Catch: java.lang.Throwable -> L54
            r0.position(r1)     // Catch: java.lang.Throwable -> L54
            java.nio.ByteBuffer r0 = r5.b     // Catch: java.lang.Throwable -> L54
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch: java.lang.Throwable -> L54
            r0.order(r1)     // Catch: java.lang.Throwable -> L54
            monitor-exit(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r6 = r11
            me.hd.wauxv.obf.bhb r8 = r1.k(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L4c
            me.hd.wauxv.obf.sb r9 = r1.g
            r9.b(r5)
            return r8
        L4c:
            r0 = move-exception
            r8 = r0
            me.hd.wauxv.obf.sb r9 = r1.g
            r9.b(r5)
            throw r8
        L54:
            r0 = move-exception
            r1 = r7
        L56:
            r9 = r0
        L57:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L59
            throw r9
        L59:
            r0 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: me.hd.wauxv.obf.sc.c(java.lang.Object, int, int, me.hd.wauxv.obf.crw):me.hd.wauxv.obf.dcg");
    }

    @Override // me.hd.wauxv.obf.dcj
    public final boolean d(Object obj, crw crwVar) {
        return !((Boolean) crwVar.b(bhk.b)).booleanValue() && bhv.aa(this.f, (ByteBuffer) obj) == ImageHeaderParser$ImageType.GIF;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
    	at jadx.core.utils.Pair.hashCode(Pair.java:35)
    	at java.base/java.util.HashMap.hash(HashMap.java:338)
    	at java.base/java.util.HashMap.getNode(HashMap.java:568)
    	at java.base/java.util.HashMap.containsKey(HashMap.java:594)
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:37)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:178)
    	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:173)
    	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:82)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:428)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public final bhb k(ByteBuffer byteBuffer, int i, int i2, bhj bhjVar, crw crwVar) {
        StringBuilder sb;
        int i3 = bxq.b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            bhi bhiVarF = bhjVar.f();
            if (bhiVarF.c > 0 && bhiVarF.b == 0) {
                Bitmap.Config config = crwVar.b(bhk.a) == ajo.b ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                int iJ = j(bhiVarF, i, i2);
                nu nuVar = this.h;
                DefaultConfig ioVar = this.i;
                nuVar.getClass();
                dmg dmgVar = new dmg(ioVar, bhiVarF, byteBuffer, iJ);
                dmgVar.w(config);
                dmgVar.k = (dmgVar.k + 1) % dmgVar.l.c;
                Bitmap bitmapV = dmgVar.v();
                if (bitmapV == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                        sb.append(bxq.c(jElapsedRealtimeNanos));
                        Log.v("BufferGifDecoder", sb.toString());
                        return null;
                    }
                    return null;
                }
                bhb bhbVar = new bhb(new bha(new fd(new bhh(com.bumptech.glide.a.j(this.e), dmgVar, i, i2, bitmapV), 1)), 0);
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + bxq.c(jElapsedRealtimeNanos));
                }
                return bhbVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                sb = new StringBuilder("Decoded GIF from stream in ");
                sb.append(bxq.c(jElapsedRealtimeNanos));
                Log.v("BufferGifDecoder", sb.toString());
                return null;
            }
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + bxq.c(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
