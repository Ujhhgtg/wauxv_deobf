package me.hd.wauxv.obf;

import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ale implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ ale(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FactoryPools factoryPoolsVar;
        switch (this.a) {
            case 0:
                ViewGroup viewGroup = (ViewGroup) this.b;
                View view = (View) this.c;
                alg algVar = (alg) this.d;
                throwIfVar1IsNull(viewGroup, "$container");
                throwIfVar1IsNull(algVar, "this$0");
                viewGroup.endViewTransition(view);
                ((dlr) algVar.a.g).o(algVar);
                return;
            case 1:
                CodeEditor codeEditor = (CodeEditor) this.b;
                dnv dnvVar = (dnv) this.c;
                cjn cjnVar = (cjn) this.d;
                if (codeEditor.cm != dnvVar) {
                    codeEditor.setStyles(dnvVar);
                    return;
                }
                if (codeEditor.at) {
                    codeEditor.l = codeEditor.dq();
                }
                dbg dbgVar = codeEditor.cn;
                dbgVar.getClass();
                if (Build.VERSION.SDK_INT >= 29 && (factoryPoolsVar = dbgVar.b) != null) {
                    Iterator it = ((ArrayList) factoryPoolsVar.f).iterator();
                    throwIfVar1IsNull(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        throwIfVar1IsNull(next, "next(...)");
                        dbh dbhVar = (dbh) next;
                        int i = dbhVar.a;
                        int i2 = cjnVar.a;
                        if (i <= cjnVar.b && i2 <= i) {
                            it.remove();
                            dbhVar.b.discardDisplayList();
                            ((Stack) factoryPoolsVar.h).push(dbhVar);
                        }
                    }
                }
                codeEditor.co.bn();
                codeEditor.invalidate();
                return;
            case 2:
                anr anrVar = (anr) this.b;
                cnh cnhVar = (cnh) this.c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.d;
                try {
                    bbv bbvVarP = cnh.p(anrVar.b);
                    if (bbvVarP == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    bbu bbuVar = (bbu) ((ate) bbvVarP.b);
                    synchronized (bbuVar.e) {
                        bbuVar.g = threadPoolExecutor;
                        break;
                    }
                    ((ate) bbvVarP.b).c(new ath(cnhVar, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    cnhVar.b(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 3:
                ayd aydVar = (ayd) this.b;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = (SharedPreferences.OnSharedPreferenceChangeListener) this.c;
                String str = (String) this.d;
                aydVar.getClass();
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(aydVar, str);
                return;
            default:
                ewa ewaVar = (ewa) this.b;
                CodeEditor codeEditor2 = (CodeEditor) this.c;
                ArrayList arrayList = (ArrayList) this.d;
                if (ewaVar.b != codeEditor2) {
                    return;
                }
                List list = ewaVar.x;
                if (list != null) {
                    list.clear();
                } else {
                    ewaVar.x = new ArrayList();
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ewaVar.x.addAll(((evz) it2.next()).b);
                }
                codeEditor2.setLayoutBusy(false);
                codeEditor2.getEventHandler().bb(0.0f, 0.0f, false);
                return;
        }
    }
}
