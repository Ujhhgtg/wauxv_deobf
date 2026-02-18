package me.hd.wauxv.obf;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cak extends czl {
    public final /* synthetic */ com.google.android.material.datepicker.c a;
    public final /* synthetic */ MaterialButton c;
    public final /* synthetic */ cal d;

    public cak(cal calVar, com.google.android.material.datepicker.c cVar, MaterialButton materialButton) {
        this.d = calVar;
        this.a = cVar;
        this.c = materialButton;
    }

    @Override // me.hd.wauxv.obf.czl
    public final void b(RecyclerView recyclerView, int i, int i2) {
        st stVar = this.a.a;
        cal calVar = this.d;
        int iCt = i < 0 ? ((LinearLayoutManager) calVar.n.getLayoutManager()).ct() : ((LinearLayoutManager) calVar.n.getLayoutManager()).cu();
        Calendar calendarB = eoq.b(stVar.a.a);
        calendarB.add(2, iCt);
        calVar.c = new cet(calendarB);
        Calendar calendarB2 = eoq.b(stVar.a.a);
        calendarB2.add(2, iCt);
        calendarB2.set(5, 1);
        Calendar calendarB3 = eoq.b(calendarB2);
        calendarB3.get(2);
        calendarB3.get(1);
        calendarB3.getMaximum(7);
        calendarB3.getActualMaximum(5);
        calendarB3.getTimeInMillis();
        long timeInMillis = calendarB3.getTimeInMillis();
        Locale locale = Locale.getDefault();
        AtomicReference atomicReference = eoq.a;
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
        instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        this.c.setText(instanceForSkeleton.format(new Date(timeInMillis)));
    }

    @Override // me.hd.wauxv.obf.czl
    public final void e(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.c.getText());
        }
    }
}
