package me.hd.wauxv.obf;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqm extends bzf {
    public final /* synthetic */ int a;

    public eqm(int i, Class cls, int i2, int i3, int i4) {
        this.a = i4;
        this.b = i;
        this.e = cls;
        this.d = i2;
        this.c = i3;
    }

    @Override // me.hd.wauxv.obf.bzf
    public final Object h(View view) {
        switch (this.a) {
            case 0:
                return Boolean.valueOf(equ.c(view));
            case 1:
                return equ.a(view);
            case 2:
                return eqw.b(view);
            default:
                return Boolean.valueOf(equ.b(view));
        }
    }

    @Override // me.hd.wauxv.obf.bzf
    public final void i(View view, Object obj) {
        switch (this.a) {
            case 0:
                equ.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                equ.e(view, (CharSequence) obj);
                break;
            case 2:
                eqw.createInstanceWithArgs(view, (CharSequence) obj);
                break;
            default:
                equ.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // me.hd.wauxv.obf.bzf
    public final boolean l(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.a) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !zEquals;
    }
}
