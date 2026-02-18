package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgo {
    public final dgw[] a = new dgw[4];
    public final Matrix[] b = new Matrix[4];
    public final Matrix[] c = new Matrix[4];
    public final PointF d = new PointF();
    public final Path e = new Path();
    public final Path f = new Path();
    public final dgw g = new dgw();
    public final float[] h = new float[2];
    public final float[] i = new float[2];
    public final Path j = new Path();
    public final Path k = new Path();
    public final boolean l = true;

    public dgo() {
        for (int i = 0; i < 4; i++) {
            this.a[i] = new dgw();
            this.b[i] = new Matrix();
            this.c[i] = new Matrix();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(dgm dgmVar, float f, RectF rectF, bmu bmuVar, Path path) {
        Matrix[] matrixArr;
        float[] fArr;
        int i;
        dgw[] dgwVarArr;
        char c;
        Matrix[] matrixArr2;
        char c2;
        int i2;
        path.rewind();
        Path path2 = this.e;
        path2.rewind();
        Path path3 = this.f;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i3 = 0;
        while (true) {
            matrixArr = this.c;
            fArr = this.h;
            dgwVarArr = this.a;
            c = 0;
            matrixArr2 = this.b;
            if (i3 >= 4) {
                break;
            }
            ahe aheVar = i3 != 1 ? i3 != 2 ? i3 != 3 ? dgmVar.f : dgmVar.e : dgmVar.h : dgmVar.g;
            bhv bhvVar = i3 != 1 ? i3 != 2 ? i3 != 3 ? dgmVar.b : dgmVar.a : dgmVar.d : dgmVar.c;
            dgw dgwVar = dgwVarArr[i3];
            bhvVar.getClass();
            bhvVar.a(dgwVar, f, aheVar.b(rectF));
            int i4 = i3 + 1;
            float f2 = (i4 % 4) * 90;
            matrixArr2[i3].reset();
            PointF pointF = this.d;
            if (i3 == 1) {
                i2 = i3;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i3 == 2) {
                i2 = i3;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i3 != 3) {
                i2 = i3;
                pointF.set(rectF.right, rectF.top);
            } else {
                i2 = i3;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i2].setTranslate(pointF.x, pointF.y);
            matrixArr2[i2].preRotate(f2);
            dgw dgwVar2 = dgwVarArr[i2];
            fArr[0] = dgwVar2.c;
            fArr[1] = dgwVar2.d;
            matrixArr2[i2].mapPoints(fArr);
            matrixArr[i2].reset();
            matrixArr[i2].setTranslate(fArr[0], fArr[1]);
            matrixArr[i2].preRotate(f2);
            i3 = i4;
        }
        char c3 = 1;
        int i5 = 0;
        for (i = 4; i5 < i; i = 4) {
            dgw dgwVar3 = dgwVarArr[i5];
            fArr[c] = dgwVar3.a;
            fArr[c3] = dgwVar3.b;
            matrixArr2[i5].mapPoints(fArr);
            if (i5 == 0) {
                path.moveTo(fArr[c], fArr[c3]);
            } else {
                path.lineTo(fArr[c], fArr[c3]);
            }
            dgwVarArr[i5].j(matrixArr2[i5], path);
            if (bmuVar != null) {
                dgw dgwVar4 = dgwVarArr[i5];
                Matrix matrix = matrixArr2[i5];
                cau cauVar = (cau) bmuVar.h;
                BitSet bitSet = cauVar.cw;
                dgwVar4.getClass();
                bitSet.set(i5, (boolean) c);
                dgv[] dgvVarArr = cauVar.cu;
                dgwVar4.i(dgwVar4.f);
                dgvVarArr[i5] = new dgp(new ArrayList(dgwVar4.h), new Matrix(matrix));
            }
            int i6 = i5 + 1;
            int i7 = i6 % 4;
            dgw dgwVar5 = dgwVarArr[i5];
            fArr[0] = dgwVar5.c;
            fArr[1] = dgwVar5.d;
            matrixArr2[i5].mapPoints(fArr);
            dgw dgwVar6 = dgwVarArr[i7];
            float f3 = dgwVar6.a;
            float[] fArr2 = this.i;
            fArr2[0] = f3;
            fArr2[1] = dgwVar6.b;
            matrixArr2[i7].mapPoints(fArr2);
            dgw[] dgwVarArr2 = dgwVarArr;
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            dgw dgwVar7 = dgwVarArr2[i5];
            fArr[0] = dgwVar7.c;
            fArr[1] = dgwVar7.d;
            matrixArr2[i5].mapPoints(fArr);
            float fAbs = (i5 == 1 || i5 == 3) ? Math.abs(rectF.centerX() - fArr[0]) : Math.abs(rectF.centerY() - fArr[1]);
            dgw dgwVar8 = this.g;
            dgwVar8.l(0.0f, 0.0f, 270.0f, 0.0f);
            arj arjVar = i5 != 1 ? i5 != 2 ? i5 != 3 ? dgmVar.j : dgmVar.i : dgmVar.l : dgmVar.k;
            arjVar.ap(fMax, fAbs, f, dgwVar8);
            Path path4 = this.j;
            path4.reset();
            dgwVar8.j(matrixArr[i5], path4);
            if (this.l && (arjVar.ao() || n(path4, i5) || n(path4, i7))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = dgwVar8.a;
                c3 = 1;
                fArr[1] = dgwVar8.b;
                matrixArr[i5].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                dgwVar8.j(matrixArr[i5], path2);
            } else {
                c3 = 1;
                dgwVar8.j(matrixArr[i5], path);
            }
            if (bmuVar != null) {
                Matrix matrix2 = matrixArr[i5];
                cau cauVar2 = (cau) bmuVar.h;
                c2 = 0;
                cauVar2.cw.set(i5 + 4, false);
                dgv[] dgvVarArr2 = cauVar2.cv;
                dgwVar8.i(dgwVar8.f);
                dgvVarArr2[i5] = new dgp(new ArrayList(dgwVar8.h), new Matrix(matrix2));
            } else {
                c2 = 0;
            }
            c = c2;
            dgwVarArr = dgwVarArr2;
            i5 = i6;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public final boolean n(Path path, int i) {
        Path path2 = this.k;
        path2.reset();
        this.a[i].j(this.b[i], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }
}
