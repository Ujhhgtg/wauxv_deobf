package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.style.ClickableSpan;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class wf extends ClickableSpan {
    public final /* synthetic */ int a;
    public final /* synthetic */ Serializable b;
    public final /* synthetic */ eqj c;

    public /* synthetic */ wf(eqj eqjVar, Serializable serializable, int i) {
        this.a = i;
        this.c = eqjVar;
        this.b = serializable;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                bqr bqrVar = (bqr) this.c;
                int selectionStart = ((TextInputEditText) bqrVar.e).getSelectionStart();
                int selectionEnd = ((TextInputEditText) bqrVar.e).getSelectionEnd();
                Editable text = ((TextInputEditText) bqrVar.e).getText();
                if (text != null) {
                    text.replace(selectionStart, selectionEnd, (String) this.b);
                }
                break;
            case 1:
                cem cemVar = (cem) this.c;
                int selectionStart2 = cemVar.c.getSelectionStart();
                int selectionEnd2 = cemVar.c.getSelectionEnd();
                Editable text2 = cemVar.c.getText();
                if (text2 != null) {
                    text2.replace(selectionStart2, selectionEnd2, (String) this.b);
                }
                break;
            case 2:
                cen cenVar = (cen) this.c;
                int selectionStart3 = ((TextInputEditText) cenVar.l).getSelectionStart();
                int selectionEnd3 = ((TextInputEditText) cenVar.l).getSelectionEnd();
                Editable text3 = ((TextInputEditText) cenVar.l).getText();
                if (text3 != null) {
                    text3.replace(selectionStart3, selectionEnd3, (String) this.b);
                }
                break;
            case 3:
                cem cemVar2 = (cem) this.c;
                int selectionStart4 = cemVar2.c.getSelectionStart();
                int selectionEnd4 = cemVar2.c.getSelectionEnd();
                Editable text4 = cemVar2.c.getText();
                if (text4 != null) {
                    text4.replace(selectionStart4, selectionEnd4, (String) this.b);
                }
                break;
            case 4:
                bqr bqrVar2 = (bqr) this.c;
                int selectionStart5 = ((TextInputEditText) bqrVar2.c).getSelectionStart();
                int selectionEnd5 = ((TextInputEditText) bqrVar2.c).getSelectionEnd();
                Editable text5 = ((TextInputEditText) bqrVar2.c).getText();
                if (text5 != null) {
                    text5.replace(selectionStart5, selectionEnd5, (String) this.b);
                }
                break;
            default:
                cem cemVar3 = (cem) this.c;
                TextInputEditText textInputEditText = cemVar3.c;
                csm csmVar = (csm) this.b;
                textInputEditText.setText((CharSequence) csmVar.a);
                cemVar3.d.setText((CharSequence) csmVar.b);
                break;
        }
    }
}
