package me.hd.wauxv.obf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class blv implements bgp {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ blv(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object c(Object obj, Object obj2, Object obj3, Serializable serializable) {
        switch (this.a) {
            case 0:
                LayoutInflater layoutInflater = (LayoutInflater) this.b;
                ViewGroup viewGroup = (ViewGroup) obj;
                View view = (View) obj2;
                Context context = (Context) obj3;
                bls blsVar = (bls) serializable;
                if (view != null) {
                    return view;
                }
                LayoutInflater.Factory2 factory2 = layoutInflater.getFactory2();
                if (factory2 == null) {
                    return null;
                }
                String name = blsVar.c.getName();
                if (dnr.bp(name, "android.widget.", false)) {
                    name = dnr.bo(name, "android.widget.", "");
                }
                return factory2.onCreateView(viewGroup, name, context, blsVar.b);
            default:
                q qVar = (q) this.b;
                ((Integer) obj).getClass();
                ((Integer) obj2).getClass();
                cwd cwdVar = cwd.a;
                cwdVar.getClass();
                Iterator it = ((cnw) cwdVar.c(cnw.Companion.serializer(), (byte[]) serializable)).d.iterator();
                while (it.hasNext()) {
                    qVar.invoke(((cnv) it.next()).h);
                }
                return ens.a;
        }
    }
}
