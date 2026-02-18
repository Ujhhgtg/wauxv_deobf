package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cat extends Drawable.ConstantState {
    public dgm b;
    public asy c;
    public ColorStateList d;
    public ColorStateList e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public Rect h;
    public final float i;
    public float j;
    public float k;
    public int l;
    public float m;
    public float n;
    public int o;
    public int p;
    public int q;
    public final Paint.Style r;

    public cat(dgm dgmVar) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.i = 1.0f;
        this.j = 1.0f;
        this.l = Opcodes.CONST_METHOD_TYPE;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = Paint.Style.FILL_AND_STROKE;
        this.b = dgmVar;
        this.c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        cau cauVar = new cau(this);
        cauVar.cx = true;
        return cauVar;
    }

    public cat(cat catVar) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.h = null;
        this.i = 1.0f;
        this.j = 1.0f;
        this.l = Opcodes.CONST_METHOD_TYPE;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = Paint.Style.FILL_AND_STROKE;
        this.b = catVar.b;
        this.c = catVar.c;
        this.k = catVar.k;
        this.d = catVar.d;
        this.e = catVar.e;
        this.g = catVar.g;
        this.f = catVar.f;
        this.l = catVar.l;
        this.i = catVar.i;
        this.q = catVar.q;
        this.o = catVar.o;
        this.j = catVar.j;
        this.m = catVar.m;
        this.n = catVar.n;
        this.p = catVar.p;
        this.r = catVar.r;
        if (catVar.h != null) {
            this.h = new Rect(catVar.h);
        }
    }
}
