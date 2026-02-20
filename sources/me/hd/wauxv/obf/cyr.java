package me.hd.wauxv.obf;

import android.text.Editable;
import android.view.View;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cyr implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ cyr(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.b;
                eb ebVar = (eb) this.c;
                ea eaVar = (ea) this.d;
                Iterator it = linkedHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    bgk bgkVar = (bgk) ((Map.Entry) it.next()).getValue();
                    int iIntValue = ((Number) ebVar.b.invoke()).intValue();
                    Object objG = ea.g(eaVar, iIntValue);
                    if (objG != null) {
                        bgkVar.b(view, objG, Integer.valueOf(iIntValue));
                    }
                }
                break;
            default:
                bqr bqrVar = (bqr) this.b;
                ArrayList arrayList = (ArrayList) this.c;
                zm zmVar = (zm) this.d;
                TextInputEditText textInputEditText = (TextInputEditText) bqrVar.d;
                String strValueOf = String.valueOf(textInputEditText.getText());
                if (!StringsKt.isBlank(strValueOf)) {
                    arrayList.add(strValueOf);
                    zmVar.af();
                    Editable text = textInputEditText.getText();
                    if (text != null) {
                        text.clear();
                    }
                }
                break;
        }
    }
}
