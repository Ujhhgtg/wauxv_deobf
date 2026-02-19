package me.hd.wauxv.obf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ewt extends cyw {
    public final cal a;

    public ewt(cal calVar) {
        this.a = calVar;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        return this.a.b.f;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(SomeView someViewVar, int i) {
        cal calVar = this.a;
        int i2 = calVar.b.a.c + i;
        TextView textView = ((ews) someViewVar).a;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        Context context = textView.getContext();
        textView.setContentDescription(eoq.c().get(1) == i2 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2)));
        DefaultConfig ioVar = calVar.l;
        if (eoq.c().get(1) == i2) {
            Object obj = ioVar.d;
        } else {
            Object obj2 = ioVar.c;
        }
        throw null;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final SomeView g(ViewGroup viewGroup, int i) {
        return new ews((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
