package me.hd.wauxv.obf;

import android.view.View;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nh implements cdw {
    public final Object g;

    public /* synthetic */ nh(Object obj) {
        this.g = obj;
    }

    public abstract void c(blq blqVar);

    public void d(blq blqVar) {
    }

    public exg e() {
        return (exg) this.g;
    }

    public boolean h() {
        int i;
        dlr dlrVar = (dlr) this.g;
        View view = dlrVar.c.bz;
        if (view != null) {
            i = 4;
            if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                int visibility = view.getVisibility();
                if (visibility == 0) {
                    i = 2;
                } else if (visibility != 4) {
                    if (visibility != 8) {
                        throw new IllegalArgumentException(concatVar2Var1(visibility, "Unknown visibility "));
                    }
                    i = 3;
                }
            }
        } else {
            i = 0;
        }
        int i2 = dlrVar.a;
        if (i != i2) {
            return (i == 2 || i2 == 2) ? false : true;
        }
        return true;
    }

    public void i(cut cutVar) {
        ArrayDeque arrayDeque = (ArrayDeque) this.g;
        if (arrayDeque.size() < 20) {
            arrayDeque.offer(cutVar);
        }
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        return new rv((awp) this.g, 2);
    }

    /*
     * JADX WARN: 'this' call moved to the top of the method (can break code
     * semantics)
     */
    public nh(int i) {
        this(exg.a);
        switch (i) {
            case 3:
                break;
            default:
                char[] cArr = eot.a;
                this.g = new ArrayDeque(20);
                break;
        }
    }

    public nh(dlr dlrVar) {
        throwIfVar1IsNull(dlrVar, "operation");
        this.g = dlrVar;
    }
}
