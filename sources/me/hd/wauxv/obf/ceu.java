package me.hd.wauxv.obf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ceu extends BaseAdapter {
    public static final int a = eoq.d(null).getMaximum(4);
    public static final int b = (eoq.d(null).getMaximum(7) + eoq.d(null).getMaximum(5)) - 1;
    public final cet c;
    public io d;
    public final st e;

    public ceu(cet cetVar, st stVar) {
        this.c = cetVar;
        this.e = stVar;
        throw null;
    }

    public final int f() {
        int firstDayOfWeek = this.e.e;
        cet cetVar = this.c;
        Calendar calendar = cetVar.a;
        int i = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i2 = i - firstDayOfWeek;
        return i2 < 0 ? i2 + cetVar.d : i2;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < f() || i > h()) {
            return null;
        }
        int iF = (i - f()) + 1;
        Calendar calendarB = eoq.b(this.c.a);
        calendarB.set(5, iF);
        return Long.valueOf(calendarB.getTimeInMillis());
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return b;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.c.d;
    }

    /* JADX WARN: Found duplicated region for block: B:14:0x005f  */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.d == null) {
            this.d = new io(context, 9);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iF = i - f();
        if (iF >= 0) {
            cet cetVar = this.c;
            if (iF >= cetVar.e) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                textView.setTag(cetVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(iF + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        if (getItem(i) == null || textView == null) {
            return textView;
        }
        textView.getContext();
        eoq.c().getTimeInMillis();
        throw null;
    }

    public final int h() {
        return (f() + this.c.e) - 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
