package me.hd.wauxv.obf;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epf extends epg {
    public final Matrix a;
    public final ArrayList b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public final Matrix j;
    public String k;

    public epf() {
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = new Matrix();
        this.k = null;
    }

    public String getGroupName() {
        return this.k;
    }

    public Matrix getLocalMatrix() {
        return this.j;
    }

    public float getPivotX() {
        return this.d;
    }

    public float getPivotY() {
        return this.e;
    }

    public float getRotation() {
        return this.c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.i;
    }

    @Override // me.hd.wauxv.obf.epg
    public final boolean l() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((epg) arrayList.get(i)).l()) {
                return true;
            }
            i++;
        }
    }

    @Override // me.hd.wauxv.obf.epg
    public final boolean m(int[] iArr) {
        int i = 0;
        boolean zM = false;
        while (true) {
            ArrayList arrayList = this.b;
            if (i >= arrayList.size()) {
                return zM;
            }
            zM |= ((epg) arrayList.get(i)).m(iArr);
            i++;
        }
    }

    public final void n() {
        Matrix matrix = this.j;
        matrix.reset();
        matrix.postTranslate(-this.d, -this.e);
        matrix.postScale(this.f, this.g);
        matrix.postRotate(this.c, 0.0f, 0.0f);
        matrix.postTranslate(this.h + this.d, this.i + this.e);
    }

    public void setPivotX(float f) {
        if (f != this.d) {
            this.d = f;
            n();
        }
    }

    public void setPivotY(float f) {
        if (f != this.e) {
            this.e = f;
            n();
        }
    }

    public void setRotation(float f) {
        if (f != this.c) {
            this.c = f;
            n();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            n();
        }
    }

    public void setScaleY(float f) {
        if (f != this.g) {
            this.g = f;
            n();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.h) {
            this.h = f;
            n();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            n();
        }
    }

    public epf(epf epfVar, ku kuVar) {
        eph epdVar;
        this.a = new Matrix();
        this.b = new ArrayList();
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 1.0f;
        this.g = 1.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.j = matrix;
        this.k = null;
        this.c = epfVar.c;
        this.d = epfVar.d;
        this.e = epfVar.e;
        this.f = epfVar.f;
        this.g = epfVar.g;
        this.h = epfVar.h;
        this.i = epfVar.i;
        String str = epfVar.k;
        this.k = str;
        if (str != null) {
            kuVar.put(str, this);
        }
        matrix.set(epfVar.j);
        ArrayList arrayList = epfVar.b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof epf) {
                this.b.add(new epf((epf) obj, kuVar));
            } else {
                if (obj instanceof epe) {
                    epe epeVar = (epe) obj;
                    epe epeVar2 = new epe(epeVar);
                    epeVar2.b = 0.0f;
                    epeVar2.d = 1.0f;
                    epeVar2.e = 1.0f;
                    epeVar2.f = 0.0f;
                    epeVar2.g = 1.0f;
                    epeVar2.h = 0.0f;
                    epeVar2.i = Paint.Cap.BUTT;
                    epeVar2.j = Paint.Join.MITER;
                    epeVar2.k = 4.0f;
                    epeVar2.a = epeVar.a;
                    epeVar2.b = epeVar.b;
                    epeVar2.d = epeVar.d;
                    epeVar2.c = epeVar.c;
                    epeVar2.p = epeVar.p;
                    epeVar2.e = epeVar.e;
                    epeVar2.f = epeVar.f;
                    epeVar2.g = epeVar.g;
                    epeVar2.h = epeVar.h;
                    epeVar2.i = epeVar.i;
                    epeVar2.j = epeVar.j;
                    epeVar2.k = epeVar.k;
                    epdVar = epeVar2;
                } else if (obj instanceof epd) {
                    epdVar = new epd((epd) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.b.add(epdVar);
                Object obj2 = epdVar.o;
                if (obj2 != null) {
                    kuVar.put(obj2, epdVar);
                }
            }
        }
    }
}
