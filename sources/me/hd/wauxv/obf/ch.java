package me.hd.wauxv.obf;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ch implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ch(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        switch (this.a) {
            case 0:
                ((da) this.b).c();
                break;
            case 1:
                ej ejVar = (ej) this.b;
                Message messageObtain = (view != ejVar.i || (message3 = ejVar.k) == null) ? (view != ejVar.l || (message2 = ejVar.n) == null) ? (view != ejVar.o || (message = ejVar.q) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
                if (messageObtain != null) {
                    messageObtain.sendToTarget();
                }
                ejVar.ae.obtainMessage(1, ejVar.b).sendToTarget();
                break;
            case 2:
                bfo bfoVar = (bfo) this.b;
                bfoVar.l.getClass();
                bfoVar.m(view);
                break;
            case 3:
                cal calVar = (cal) this.b;
                int i = calVar.d;
                if (i == 2) {
                    calVar.t(1);
                } else if (i == 1) {
                    calVar.t(2);
                }
                break;
            case 4:
                cbz itemData = ((cjy) view).getItemData();
                cka ckaVar = (cka) this.b;
                if (!ckaVar.ao.ap(itemData, ckaVar.an, 0)) {
                    itemData.setChecked(true);
                }
                break;
            default:
                eko ekoVar = ((Toolbar) this.b).al;
                cbz cbzVar = ekoVar == null ? null : ekoVar.b;
                if (cbzVar != null) {
                    cbzVar.collapseActionView();
                }
                break;
        }
    }
}
