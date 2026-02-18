package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import android.view.Window;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cag implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cag(cal calVar, com.google.android.material.datepicker.c cVar, int i) {
        this.a = i;
        this.c = calVar;
        this.b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                cal calVar = (cal) this.c;
                int iCu = ((LinearLayoutManager) calVar.n.getLayoutManager()).cu() - 1;
                if (iCu >= 0) {
                    Calendar calendarB = eoq.b(((com.google.android.material.datepicker.c) this.b).a.a.a);
                    calendarB.add(2, iCu);
                    calVar.s(new cet(calendarB));
                }
                break;
            case 1:
                cal calVar2 = (cal) this.c;
                int iCt = ((LinearLayoutManager) calVar2.n.getLayoutManager()).ct() + 1;
                if (iCt < calVar2.n.getAdapter().d()) {
                    Calendar calendarB2 = eoq.b(((com.google.android.material.datepicker.c) this.b).a.a.a);
                    calendarB2.add(2, iCt);
                    calVar2.s(new cet(calendarB2));
                }
                break;
            default:
                ekt ektVar = (ekt) this.c;
                Window.Callback callback = ektVar.k;
                if (callback != null && ektVar.l) {
                    callback.onMenuItemSelected(0, (cn) this.b);
                    break;
                }
                break;
        }
    }

    public cag(ekt ektVar) {
        this.a = 2;
        this.c = ektVar;
        Context context = ektVar.a.getContext();
        CharSequence charSequence = ektVar.h;
        cn cnVar = new cn();
        cnVar.e = 4096;
        cnVar.g = 4096;
        cnVar.l = null;
        cnVar.m = null;
        cnVar.n = false;
        cnVar.o = false;
        cnVar.p = 16;
        cnVar.i = context;
        cnVar.a = charSequence;
        this.b = cnVar;
    }
}
