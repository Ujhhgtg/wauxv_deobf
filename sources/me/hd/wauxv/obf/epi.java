package me.hd.wauxv.obf;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import com.android.dx.io.Opcodes;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epi {
    public static final Matrix a = new Matrix();
    public final Path b;
    public final Path c;
    public final Matrix d;
    public Paint e;
    public Paint f;
    public PathMeasure g;
    public final epf h;
    public float i;
    public float j;
    public float k;
    public float l;
    public int m;
    public String n;
    public Boolean o;
    public final ku p;

    public epi() {
        this.d = new Matrix();
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = Opcodes.CONST_METHOD_TYPE;
        this.n = null;
        this.o = null;
        this.p = new ku(0);
        this.h = new epf();
        this.b = new Path();
        this.c = new Path();
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(epf epfVar, Matrix matrix, Canvas canvas, int i, int i2) {
        int i3;
        float f;
        int i4;
        float f2;
        Matrix matrix2 = epfVar.a;
        ArrayList arrayList = epfVar.b;
        matrix2.set(matrix);
        Matrix matrix3 = epfVar.a;
        matrix3.preConcat(epfVar.j);
        canvas.save();
        char c = 0;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            epg epgVar = (epg) arrayList.get(i5);
            if (epgVar instanceof epf) {
                q((epf) epgVar, matrix3, canvas, i, i2);
            } else {
                if (epgVar instanceof eph) {
                    eph ephVar = (eph) epgVar;
                    float f3 = i / this.k;
                    float f4 = i2 / this.l;
                    float fMin = Math.min(f3, f4);
                    Matrix matrix4 = this.d;
                    matrix4.set(matrix3);
                    matrix4.postScale(f3, f4);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix3.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[c], fArr[1]);
                    boolean z = c;
                    i3 = i5;
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f5 = (fArr[z ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f5) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        Path path = this.b;
                        path.reset();
                        cte[] cteVarArr = ephVar.n;
                        if (cteVarArr != null) {
                            cte.d(cteVarArr, path);
                        }
                        Path path2 = this.c;
                        path2.reset();
                        if (ephVar instanceof epd) {
                            path2.setFillType(ephVar.p == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix4);
                            canvas.clipPath(path2);
                        } else {
                            epe epeVar = (epe) ephVar;
                            float f6 = epeVar.f;
                            if (f6 != 0.0f || epeVar.g != 1.0f) {
                                float f7 = epeVar.h;
                                float f8 = (f6 + f7) % 1.0f;
                                float f9 = (epeVar.g + f7) % 1.0f;
                                if (this.g == null) {
                                    this.g = new PathMeasure();
                                }
                                this.g.setPath(path, z);
                                float length = this.g.getLength();
                                float f10 = f8 * length;
                                float f11 = f9 * length;
                                path.reset();
                                if (f10 > f11) {
                                    this.g.getSegment(f10, length, path, true);
                                    f = 0.0f;
                                    this.g.getSegment(0.0f, f11, path, true);
                                } else {
                                    f = 0.0f;
                                    this.g.getSegment(f10, f11, path, true);
                                }
                                path.rLineTo(f, f);
                            }
                            path2.addPath(path, matrix4);
                            ik ikVar = epeVar.c;
                            if (((Shader) ikVar.c) == null && ikVar.b == 0) {
                                f2 = 255.0f;
                                i4 = 16777215;
                            } else {
                                if (this.f == null) {
                                    i4 = 16777215;
                                    Paint paint = new Paint(1);
                                    this.f = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                } else {
                                    i4 = 16777215;
                                }
                                Paint paint2 = this.f;
                                Shader shader = (Shader) ikVar.c;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix4);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(epeVar.e * 255.0f));
                                    f2 = 255.0f;
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(Opcodes.CONST_METHOD_TYPE);
                                    int i6 = ikVar.b;
                                    float f12 = epeVar.e;
                                    PorterDuff.Mode mode = epl.a;
                                    f2 = 255.0f;
                                    paint2.setColor((i6 & i4) | (((int) (Color.alpha(i6) * f12)) << 24));
                                }
                                paint2.setColorFilter(null);
                                path2.setFillType(epeVar.p == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(path2, paint2);
                            }
                            ik ikVar2 = epeVar.a;
                            if (((Shader) ikVar2.c) != null || ikVar2.b != 0) {
                                if (this.e == null) {
                                    Paint paint3 = new Paint(1);
                                    this.e = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.e;
                                Paint.Join join = epeVar.j;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = epeVar.i;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(epeVar.k);
                                Shader shader2 = (Shader) ikVar2.c;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix4);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(epeVar.d * f2));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(Opcodes.CONST_METHOD_TYPE);
                                    int i7 = ikVar2.b;
                                    float f13 = epeVar.d;
                                    PorterDuff.Mode mode2 = epl.a;
                                    paint4.setColor((i7 & i4) | (((int) (Color.alpha(i7) * f13)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(epeVar.b * fMin * fAbs);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                }
                i5 = i3 + 1;
                c = 0;
            }
            i3 = i5;
            i5 = i3 + 1;
            c = 0;
        }
        canvas.restore();
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (f * 255.0f));
    }

    public void setRootAlpha(int i) {
        this.m = i;
    }

    public epi(epi epiVar) {
        this.d = new Matrix();
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = Opcodes.CONST_METHOD_TYPE;
        this.n = null;
        this.o = null;
        ku kuVar = new ku(0);
        this.p = kuVar;
        this.h = new epf(epiVar.h, kuVar);
        this.b = new Path(epiVar.b);
        this.c = new Path(epiVar.c);
        this.i = epiVar.i;
        this.j = epiVar.j;
        this.k = epiVar.k;
        this.l = epiVar.l;
        this.m = epiVar.m;
        this.n = epiVar.n;
        String str = epiVar.n;
        if (str != null) {
            kuVar.put(str, this);
        }
        this.o = epiVar.o;
    }
}
