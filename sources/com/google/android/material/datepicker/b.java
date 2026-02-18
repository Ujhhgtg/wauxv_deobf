package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.WeakHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.obf.czx;
import me.hd.wauxv.obf.eqm;
import me.hd.wauxv.obf.eqz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends czx {
    public final TextView a;
    public final MaterialCalendarGridView b;

    public b(LinearLayout linearLayout, boolean z) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.a = textView;
        WeakHashMap weakHashMap = eqz.a;
        new eqm(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).k(textView, Boolean.TRUE);
        this.b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z) {
            return;
        }
        textView.setVisibility(8);
    }
}
