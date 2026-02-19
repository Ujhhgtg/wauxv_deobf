package me.hd.wauxv.obf;

import android.graphics.Typeface;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hl implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ hl(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() throws aoq {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                hm hmVar = (hm) obj2;
                Runnable runnable = (Runnable) obj;
                hmVar.getClass();
                try {
                    runnable.run();
                    return;
                } finally {
                    hmVar.e();
                }
            case 1:
                abw abwVar = (abw) obj2;
                za zaVar = (za) obj;
                if (abwVar.i) {
                    return;
                }
                Collections.sort(abwVar.a, zaVar);
                abwVar.e.run();
                return;
            case 2:
                hb hbVar = (hb) obj2;
                int i2 = aci.p;
                hbVar.q.j(new acb((cqt) obj, 0, hbVar));
                return;
            case 3:
                ((CodeEditor) obj2).setStyles((dnv) obj);
                return;
            case 4:
                ayd aydVar = (ayd) obj2;
                cmz.s(new File(aydVar.d + aydVar.e, (String) obj));
                return;
            case 5:
                ((CancellableContinuation) obj2).y((Dispatcher2) obj);
                return;
            case 6:
                buv buvVar = (buv) obj2;
                Runnable runnable2 = (Runnable) obj;
                buvVar.getClass();
                try {
                    runnable2.run();
                    return;
                } finally {
                    buvVar.c();
                }
            default:
                ((ResourcesCompat) obj2).f((Typeface) obj);
                return;
        }
    }
}
