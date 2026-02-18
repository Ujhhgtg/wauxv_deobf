package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ez implements dcg {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ ez(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    @Override // me.hd.wauxv.obf.dcg
    public final void c() {
        switch (this.a) {
            case 0:
                ((AnimatedImageDrawable) this.b).stop();
                ((AnimatedImageDrawable) this.b).clearAnimationCallbacks();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final int d() {
        switch (this.a) {
            case 0:
                return eot.g(Bitmap.Config.ARGB_8888) * ((AnimatedImageDrawable) this.b).getIntrinsicHeight() * ((AnimatedImageDrawable) this.b).getIntrinsicWidth() * 2;
            case 1:
                return ((byte[]) this.b).length;
            case 2:
                return 1;
            default:
                return eot.f((Bitmap) this.b);
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Class e() {
        switch (this.a) {
            case 0:
                return Drawable.class;
            case 1:
                return byte[].class;
            case 2:
                return ((File) this.b).getClass();
            default:
                return Bitmap.class;
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Object get() {
        switch (this.a) {
            case 0:
                return (AnimatedImageDrawable) this.b;
            case 1:
                return (byte[]) this.b;
            case 2:
                return (File) this.b;
            default:
                return (Bitmap) this.b;
        }
    }

    public ez(byte[] bArr) {
        this.a = 1;
        cmz.n(bArr, "Argument must not be null");
        this.b = bArr;
    }

    public ez(File file) {
        this.a = 2;
        cmz.n(file, "Argument must not be null");
        this.b = file;
    }
}
