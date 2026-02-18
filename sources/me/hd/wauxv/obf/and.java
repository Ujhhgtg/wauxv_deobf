package me.hd.wauxv.obf;

import android.app.Activity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class and implements View.OnTouchListener {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ ane b;

    public and(ane aneVar, Activity activity) {
        this.b = aneVar;
        this.a = activity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        ng ngVar = this.b.ao;
        for (ng ngVar2 : ng.c == null ? new ArrayList() : new CopyOnWriteArrayList(ng.c)) {
            if (ngVar2.as() == this.a && ngVar2 != ngVar && ngVar2.v == ngVar.v && ngVar2.ar() != null) {
                Log.e(">>>", "onTouch: dialog=" + ngVar2 + "  baseDialog=" + ngVar);
                ngVar2.ar().dispatchTouchEvent(motionEvent);
                return true;
            }
        }
        return false;
    }
}
