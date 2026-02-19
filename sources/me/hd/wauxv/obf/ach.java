package me.hd.wauxv.obf;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ach extends btp implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ hb b;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public /* synthetic */ ach(hb hbVar, int i) {
        super(0);
        this.a = i;
        this.b = hbVar;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                hb hbVar = this.b;
                return new deq(hbVar.getApplication(), hbVar,
                        hbVar.getIntent() != null ? hbVar.getIntent().getExtras() : null);
            case 1:
                this.b.reportFullyDrawn();
                return KotlinUnit.INSTANCE;
            case 2:
                hb hbVar2 = this.b;
                return new bft(hbVar2.v, new ach(hbVar2, 1));
            default:
                hb hbVar3 = this.b;
                cqt cqtVar = new cqt(new abx(hbVar3, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (nullSafeIsEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        hbVar3.q.j(new acb(cqtVar, 0, hbVar3));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new hl(hbVar3, 2, cqtVar));
                    }
                }
                return cqtVar;
        }
    }
}
