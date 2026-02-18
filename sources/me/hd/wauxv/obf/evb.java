package me.hd.wauxv.obf;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class evb extends evg {
    public static boolean _ck;
    public static Constructor _cl;
    public static Field a;
    public static boolean d;
    public WindowInsets e;
    public bps f;

    public evb() {
        this.e = m();
    }

    private static WindowInsets m() {
        if (!_ck) {
            try {
                a = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e);
            }
            _ck = true;
        }
        Field field = a;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e2);
            }
        }
        if (!d) {
            try {
                _cl = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e3);
            }
            d = true;
        }
        Constructor constructor = _cl;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e4);
            }
        }
        return null;
    }

    @Override // me.hd.wauxv.obf.evg
    public evr g() {
        l();
        evr evrVarD = evr.d(null, this.e);
        bps[] bpsVarArr = this.k;
        evo evoVar = evrVarD.b;
        evoVar.s(bpsVarArr);
        evoVar.ad(this.f);
        return evrVarD;
    }

    @Override // me.hd.wauxv.obf.evg
    public void h(bps bpsVar) {
        this.f = bpsVar;
    }

    @Override // me.hd.wauxv.obf.evg
    public void i(bps bpsVar) {
        WindowInsets windowInsets = this.e;
        if (windowInsets != null) {
            this.e = windowInsets.replaceSystemWindowInsets(bpsVar.b, bpsVar.c, bpsVar.d, bpsVar.e);
        }
    }

    public evb(evr evrVar) {
        super(evrVar);
        this.e = evrVar.i();
    }
}
