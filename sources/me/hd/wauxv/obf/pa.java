package me.hd.wauxv.obf;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class pa implements dcg, bpe {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final Object f;

    public pa(Bitmap bitmap, oz ozVar) {
        cmz.n(bitmap, "Bitmap must not be null");
        this.b = bitmap;
        cmz.n(ozVar, "BitmapPool must not be null");
        this.f = ozVar;
    }

    public static pa g(Bitmap bitmap, oz ozVar) {
        if (bitmap == null) {
            return null;
        }
        return new pa(bitmap, ozVar);
    }

    @Override // me.hd.wauxv.obf.dcg
    public final void c() {
        switch (this.a) {
            case 0:
                ((oz) this.f).p((Bitmap) this.b);
                break;
            default:
                ((dcg) this.f).c();
                break;
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final int d() {
        switch (this.a) {
            case 0:
                return eot.f((Bitmap) this.b);
            default:
                return ((dcg) this.f).d();
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Class e() {
        switch (this.a) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Object get() {
        switch (this.a) {
            case 0:
                return (Bitmap) this.b;
            default:
                return new BitmapDrawable((Resources) this.b, (Bitmap) ((dcg) this.f).get());
        }
    }

    @Override // me.hd.wauxv.obf.bpe
    public final void initialize() {
        switch (this.a) {
            case 0:
                ((Bitmap) this.b).prepareToDraw();
                break;
            default:
                dcg dcgVar = (dcg) this.f;
                if (dcgVar instanceof bpe) {
                    ((bpe) dcgVar).initialize();
                }
                break;
        }
    }

    public pa(Resources resources, dcg dcgVar) {
        cmz.n(resources, "Argument must not be null");
        this.b = resources;
        cmz.n(dcgVar, "Argument must not be null");
        this.f = dcgVar;
    }
}
