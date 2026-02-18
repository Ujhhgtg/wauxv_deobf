package me.hd.wauxv.obf;

import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dre {
    public final int a;
    public final Paint.FontMetricsInt b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    public final float i;
    public final bph j;
    public final arq k;
    public final Paint l;
    public final Paint m;
    public final Paint.FontMetricsInt n;

    public dre(int i, Paint.FontMetricsInt fontMetricsInt, int i2, int i3, int i4, int i5, int i6, int i7, float f,
            bph bphVar, arq arqVar, Paint paint, Paint paint2, Paint.FontMetricsInt fontMetricsInt2) {
        throwIfVar1IsNull(fontMetricsInt, "textMetrics");
        throwIfVar1IsNull(bphVar, "inlayHintRendererProvider");
        throwIfVar1IsNull(arqVar, "colorScheme");
        throwIfVar1IsNull(paint, "miscPaint");
        throwIfVar1IsNull(paint2, "graphPaint");
        throwIfVar1IsNull(fontMetricsInt2, "graphMetrics");
        this.a = i;
        this.b = fontMetricsInt;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = i7;
        this.i = f;
        this.j = bphVar;
        this.k = arqVar;
        this.l = paint;
        this.m = paint2;
        this.n = fontMetricsInt2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dre)) {
            return false;
        }
        dre dreVar = (dre) obj;
        return this.a == dreVar.a && nullSafeIsEqual(this.b, dreVar.b) && this.c == dreVar.c && this.d == dreVar.d
                && this.e == dreVar.e && this.f == dreVar.f && this.g == dreVar.g && this.h == dreVar.h
                && Float.compare(this.i, dreVar.i) == 0 && nullSafeIsEqual(this.j, dreVar.j)
                && nullSafeIsEqual(this.k, dreVar.k)
                && nullSafeIsEqual(this.l, dreVar.l) && nullSafeIsEqual(this.m, dreVar.m)
                && nullSafeIsEqual(this.n, dreVar.n);
    }

    public final int hashCode() {
        return this.n.hashCode() + ((this.m.hashCode() + ((this.l.hashCode()
                + ((this.k.hashCode() + ((this.j.hashCode() + ((Float.hashCode(this.i) + dts.a(this.h,
                        dts.a(this.g, dts.a(0, dts.a(this.f, dts.a(this.e, dts.a(this.d,
                                dts.a(this.c, (this.b.hashCode() + (Integer.hashCode(this.a) * 31)) * 31, 31), 31), 31),
                                31), 31), 31),
                        31)) * 31)) * 31)) * 31))
                * 31)) * 31);
    }

    public final String toString() {
        return "TextRowParams(tabWidth=" + this.a + ", textMetrics=" + this.b + ", textTop=" + this.c + ", textBottom="
                + this.d + ", textHeight=" + this.e + ", textBaseline=" + this.f + ", rowTop=0, rowBottom=" + this.g
                + ", rowHeight=" + this.h + ", roundTextBackgroundFactor=" + this.i + ", inlayHintRendererProvider="
                + this.j + ", colorScheme=" + this.k + ", miscPaint=" + this.l + ", graphPaint=" + this.m
                + ", graphMetrics=" + this.n + ")";
    }
}
