package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhb implements dcg, bpe {
    public final Drawable a;
    public final /* synthetic */ int b;

    public bhb(Drawable drawable, int i) {
        this.b = i;
        cmz.n(drawable, "Argument must not be null");
        this.a = drawable;
    }

    private final void f() {
    }

    @Override // me.hd.wauxv.obf.dcg
    public final void c() {
        bva bvaVar;
        bva bvaVar2;
        bva bvaVar3;
        switch (this.b) {
            case 0:
                bha bhaVar = (bha) this.a;
                bhaVar.stop();
                bhaVar.d = true;
                bhh bhhVar = (bhh) bhaVar.a.b;
                dca dcaVar = bhhVar.d;
                bhhVar.c.clear();
                Bitmap bitmap = bhhVar.l;
                if (bitmap != null) {
                    bhhVar.e.p(bitmap);
                    bhhVar.l = null;
                }
                bhhVar.f = false;
                bhe bheVar = bhhVar.i;
                if (bheVar != null) {
                    dcaVar.n(bheVar);
                    bhhVar.i = null;
                }
                bhe bheVar2 = bhhVar.k;
                if (bheVar2 != null) {
                    dcaVar.n(bheVar2);
                    bhhVar.k = null;
                }
                bhe bheVar3 = bhhVar.m;
                if (bheVar3 != null) {
                    dcaVar.n(bheVar3);
                    bhhVar.m = null;
                }
                dmg dmgVar = bhhVar.a;
                io ioVar = dmgVar.c;
                dmgVar.l = null;
                byte[] bArr = dmgVar.i;
                if (bArr != null && (bvaVar3 = (bva) ioVar.d) != null) {
                    bvaVar3.m(bArr);
                }
                int[] iArr = dmgVar.j;
                if (iArr != null && (bvaVar2 = (bva) ioVar.d) != null) {
                    bvaVar2.m(iArr);
                }
                Bitmap bitmap2 = dmgVar.m;
                if (bitmap2 != null) {
                    ((oz) ioVar.c).p(bitmap2);
                }
                dmgVar.m = null;
                dmgVar.d = null;
                dmgVar.s = null;
                byte[] bArr2 = dmgVar.e;
                if (bArr2 != null && (bvaVar = (bva) ioVar.d) != null) {
                    bvaVar.m(bArr2);
                }
                bhhVar.j = true;
                break;
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final int d() {
        switch (this.b) {
            case 0:
                bhh bhhVar = (bhh) ((bha) this.a).a.b;
                dmg dmgVar = bhhVar.a;
                return (dmgVar.j.length * 4) + dmgVar.d.limit() + dmgVar.i.length + bhhVar.n;
            default:
                Drawable drawable = this.a;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Class e() {
        switch (this.b) {
            case 0:
                return bha.class;
            default:
                return this.a.getClass();
        }
    }

    @Override // me.hd.wauxv.obf.dcg
    public final Object get() {
        Drawable drawable = this.a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // me.hd.wauxv.obf.bpe
    public void initialize() {
        switch (this.b) {
            case 0:
                ((bhh) ((bha) this.a).a.b).l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.a;
                if (drawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                } else if (drawable instanceof bha) {
                    ((bhh) ((bha) drawable).a.b).l.prepareToDraw();
                }
                break;
        }
    }
}
