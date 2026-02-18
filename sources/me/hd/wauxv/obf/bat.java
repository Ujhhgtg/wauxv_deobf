package me.hd.wauxv.obf;

import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bat extends ua {
    public final /* synthetic */ baw a;
    public final /* synthetic */ bax l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bat(bax baxVar, baw bawVar) {
        super(1);
        this.l = baxVar;
        this.a = bawVar;
    }

    @Override // me.hd.wauxv.obf.ua
    public final void _bs() {
        int i = DialogXBaseRelativeLayout.a;
        this.l.a = false;
    }

    @Override // me.hd.wauxv.obf.ua
    public final void _bt() {
        this.l.a = true;
    }

    @Override // me.hd.wauxv.obf.ua
    public final evr _bu(evr evrVar, List list) {
        Objects.toString(evrVar);
        bax baxVar = this.l;
        baxVar.getClass();
        int i = DialogXBaseRelativeLayout.a;
        baxVar.getClass();
        baxVar.k(evrVar, new baw(this.a));
        return evrVar;
    }
}
