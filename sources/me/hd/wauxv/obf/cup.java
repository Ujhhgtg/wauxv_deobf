package me.hd.wauxv.obf;

import android.os.CountDownTimer;
import me.hd.wauxv.ui.fragment.policy.PolicyFragment;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cup extends CountDownTimer {
    public final /* synthetic */ PolicyFragment a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cup(PolicyFragment policyFragment) {
        super(30000L, 1000L);
        this.a = policyFragment;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        cbm cbmVar = PolicyFragment.a;
        PolicyFragment policyFragment = this.a;
        eqj eqjVar = policyFragment.d;
        bzo.n(eqjVar);
        ((bew) eqjVar).b.setEnabled(true);
        eqj eqjVar2 = policyFragment.d;
        bzo.n(eqjVar2);
        ((bew) eqjVar2).b.setText("已同意并重启" /* cnb.z(-419498045733674L) */);
        eqj eqjVar3 = policyFragment.d;
        bzo.n(eqjVar3);
        ((bew) eqjVar3).b.setOnClickListener(new cun(policyFragment, 1));
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        cbm cbmVar = PolicyFragment.a;
        eqj eqjVar = this.a.d;
        bzo.n(eqjVar);
        ((bew) eqjVar).b.setText("已同意并重启 (" /* cnb.z(-419515225602858L) */ + (j / ((long) 1000)) + "s)" /* cnb.z(-419476570897194L) */);
    }
}
