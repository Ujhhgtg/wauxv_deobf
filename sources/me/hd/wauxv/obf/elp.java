package me.hd.wauxv.obf;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class elp {
    public static final mi a = new mi();
    public static final ThreadLocal b = new ThreadLocal();
    public static final ArrayList c = new ArrayList();

    public static void d(ViewGroup viewGroup, ell ellVar) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (ellVar == null) {
            ellVar = a;
        }
        ell ellVarClone = ellVar.clone();
        ArrayList arrayList2 = (ArrayList) e().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((ell) it.next()).l(viewGroup);
            }
        }
        ellVarClone.bj(viewGroup, true);
        if (viewGroup.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        viewGroup.setTag(R.id.transition_current_scene, null);
        elo eloVar = new elo();
        eloVar.a = ellVarClone;
        eloVar.b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(eloVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(eloVar);
    }

    public static ku e() {
        ku kuVar;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (kuVar = (ku) weakReference.get()) != null) {
            return kuVar;
        }
        ku kuVar2 = new ku(0);
        threadLocal.set(new WeakReference(kuVar2));
        return kuVar2;
    }
}
