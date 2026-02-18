package me.hd.wauxv.obf;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class alb implements ImageDecoder$OnHeaderDecodedListener {
    public final bkf a = bkf.i();
    public final int b;
    public final int c;
    public final ajo d;
    public final apo e;
    public final boolean f;
    public final cvi g;

    public alb(int i, int i2, crw crwVar) {
        this.b = i;
        this.c = i2;
        this.d = (ajo) crwVar.b(apq.a);
        this.e = (apo) crwVar.b(apo.f);
        cru cruVar = apq.d;
        this.f = crwVar.b(cruVar) != null && ((Boolean) crwVar.b(cruVar)).booleanValue();
        this.g = (cvi) crwVar.b(apq.b);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        if (this.a.k(this.b, this.c, this.f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == ajo.b) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new ala());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fJ = this.e.j(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fJ);
        int iRound2 = Math.round(size.getHeight() * fJ);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fJ);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        cvi cviVar = this.g;
        if (cviVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((cviVar == cvi.a && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
