package me.hd.wauxv.obf;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class co extends bcy {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ View b;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public co(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.b = actionMenuItemView;
    }

    @Override // me.hd.wauxv.obf.bcy
    public final dho callOriginalMethod() {
        cq cqVar;
        switch (this.a) {
            case 0:
                cp cpVar = ((ActionMenuItemView) this.b).f;
                if (cpVar == null || (cqVar = ((cr) cpVar).a.u) == null) {
                    return null;
                }
                return cqVar.o();
            default:
                cq cqVar2 = ((ct) this.b).a.t;
                if (cqVar2 == null) {
                    return null;
                }
                return cqVar2.o();
        }
    }

    @Override // me.hd.wauxv.obf.bcy
    public final boolean getArgs() {
        dho dhoVarC;
        switch (this.a) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.b;
                cbv cbvVar = actionMenuItemView.d;
                return cbvVar != null && cbvVar.c(actionMenuItemView.a) && (dhoVarC = c()) != null && dhoVarC.e();
            default:
                ((ct) this.b).a.am();
                return true;
        }
    }

    @Override // me.hd.wauxv.obf.bcy
    public boolean getThisObject() {
        switch (this.a) {
            case 1:
                cw cwVar = ((ct) this.b).a;
                if (cwVar.v != null) {
                    return false;
                }
                cwVar.ag();
                return true;
            default:
                return super.e();
        }
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public co(ct ctVar, ct ctVar2) {
        super(ctVar2);
        this.b = ctVar;
    }
}
