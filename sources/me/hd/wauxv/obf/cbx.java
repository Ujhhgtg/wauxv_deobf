package me.hd.wauxv.obf;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbx implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, ccl {
    public dnw a;
    public el b;
    public bwf e;

    @Override // me.hd.wauxv.obf.ccl
    public final void c(cbw cbwVar, boolean z) {
        el elVar;
        if ((z || cbwVar == this.a) && (elVar = this.b) != null) {
            elVar.dismiss();
        }
    }

    @Override // me.hd.wauxv.obf.ccl
    public final boolean d(cbw cbwVar) {
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dnw dnwVar = this.a;
        bwf bwfVar = this.e;
        if (bwfVar.f == null) {
            bwfVar.f = new bwe(bwfVar);
        }
        dnwVar.ap(bwfVar.f.getItem(i), null, 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.e.aa(this.a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        dnw dnwVar = this.a;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                dnwVar.ab(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return dnwVar.performShortcut(i, keyEvent, 0);
    }
}
