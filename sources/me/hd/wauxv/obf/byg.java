package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class byg implements oz {
    public static final Bitmap.Config a = Bitmap.Config.ARGB_8888;
    public final dib b;
    public final Set c;
    public final SyntheticClass d;
    public final long e;
    public long f;
    public int g;
    public int h;
    public int i;
    public int j;

    public byg(long j) {
        dib dibVar = new dib();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.e = j;
        this.b = dibVar;
        this.c = setUnmodifiableSet;
        this.d = new SyntheticClass(27);
    }

    @Override // me.hd.wauxv.obf.oz
    public final void aa() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m(0L);
    }

    public final void k() {
        Log.v("LruBitmapPool", "Hits=" + this.g + ", misses=" + this.h + ", puts=" + this.i + ", evictions=" + this.j + ", currentSize=" + this.f + ", maxSize=" + this.e + "\nStrategy=" + this.b);
    }

    public final synchronized Bitmap l(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapK;
        try {
            if (config == Bitmap.Config.HARDWARE) {
                throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
            }
            bitmapK = this.b.k(i, i2, config != null ? config : a);
            if (bitmapK == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder("Missing bitmap=");
                    this.b.getClass();
                    sb.append(dib.i(eot.g(config) * i * i2, config));
                    Log.d("LruBitmapPool", sb.toString());
                }
                this.h++;
            } else {
                this.g++;
                long j = this.f;
                this.b.getClass();
                this.f = j - ((long) eot.f(bitmapK));
                this.d.getClass();
                bitmapK.setHasAlpha(true);
                bitmapK.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Get bitmap=");
                this.b.getClass();
                sb2.append(dib.i(eot.g(config) * i * i2, config));
                Log.v("LruBitmapPool", sb2.toString());
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                k();
            }
        } catch (Throwable th) {
            throw th;
        }
        return bitmapK;
    }

    public final synchronized void m(long j) {
        while (this.f > j) {
            try {
                dib dibVar = this.b;
                Bitmap bitmap = (Bitmap) dibVar.g.av();
                if (bitmap != null) {
                    dibVar.j(Integer.valueOf(eot.f(bitmap)), bitmap);
                }
                if (bitmap == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        k();
                    }
                    this.f = 0L;
                    return;
                }
                this.d.getClass();
                long j2 = this.f;
                this.b.getClass();
                this.f = j2 - ((long) eot.f(bitmap));
                this.j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Evicting bitmap=");
                    this.b.getClass();
                    sb.append(dib.i(eot.f(bitmap), bitmap.getConfig()));
                    Log.d("LruBitmapPool", sb.toString());
                }
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    k();
                }
                bitmap.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // me.hd.wauxv.obf.oz
    public final Bitmap n(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapL = l(i, i2, config);
        if (bitmapL != null) {
            return bitmapL;
        }
        if (config == null) {
            config = a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Override // me.hd.wauxv.obf.oz
    public final synchronized void p(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable()) {
                this.b.getClass();
                if (eot.f(bitmap) <= this.e && this.c.contains(bitmap.getConfig())) {
                    this.b.getClass();
                    int iF = eot.f(bitmap);
                    this.b.m(bitmap);
                    this.d.getClass();
                    this.i++;
                    this.f += (long) iF;
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        StringBuilder sb = new StringBuilder("Put bitmap in pool=");
                        this.b.getClass();
                        sb.append(dib.i(eot.f(bitmap), bitmap.getConfig()));
                        Log.v("LruBitmapPool", sb.toString());
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        k();
                    }
                    m(this.e);
                    return;
                }
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                StringBuilder sb2 = new StringBuilder("Reject bitmap from pool, bitmap: ");
                this.b.getClass();
                sb2.append(dib.i(eot.f(bitmap), bitmap.getConfig()));
                sb2.append(", is mutable: ");
                sb2.append(bitmap.isMutable());
                sb2.append(", is allowed config: ");
                sb2.append(this.c.contains(bitmap.getConfig()));
                Log.v("LruBitmapPool", sb2.toString());
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // me.hd.wauxv.obf.oz
    public final Bitmap x(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapL = l(i, i2, config);
        if (bitmapL != null) {
            bitmapL.eraseColor(0);
            return bitmapL;
        }
        if (config == null) {
            config = a;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // me.hd.wauxv.obf.oz
    public final void z(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40 || i >= 20) {
            aa();
        } else if (i >= 20 || i == 15) {
            m(this.e / 2);
        }
    }
}
