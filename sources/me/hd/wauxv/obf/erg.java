package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class erg extends dcw implements bgj {
    public int a;
    public /* synthetic */ Object d;
    public final /* synthetic */ View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public erg(View view, afw afwVar) {
        super(2, afwVar);
        this.e = view;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        return ((erg) h((dfu) obj, (afw) obj2)).i(ens.a);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        erg ergVar = new erg(this.e, afwVar);
        ergVar.d = obj;
        return ergVar;
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        Object obj2;
        int i = this.a;
        View view = this.e;
        ahq ahqVar = ahq.a;
        if (i == 0) {
            bhu.bd(obj);
            dfu dfuVar = (dfu) this.d;
            this.d = dfuVar;
            this.a = 1;
            dfuVar.d = view;
            dfuVar.a = 3;
            dfuVar.f = this;
            return ahqVar;
        }
        ens ensVar = ens.a;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            bhu.bd(obj);
            return ensVar;
        }
        dfu dfuVar2 = (dfu) this.d;
        bhu.bd(obj);
        if (view instanceof ViewGroup) {
            this.d = null;
            this.a = 2;
            dfuVar2.getClass();
            elf elfVar = new elf(new z((ViewGroup) view, 8));
            if (elfVar.b.hasNext()) {
                dfuVar2.e = elfVar;
                dfuVar2.a = 2;
                dfuVar2.f = this;
                obj2 = ahqVar;
            } else {
                obj2 = ensVar;
            }
            if (obj2 != ahqVar) {
                obj2 = ensVar;
            }
            if (obj2 == ahqVar) {
                return ahqVar;
            }
        }
        return ensVar;
    }
}
