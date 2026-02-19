package me.hd.wauxv.obf;

import android.widget.BaseAdapter;
import android.widget.ListView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class vs implements dpi {
    public final /* synthetic */ BaseAdapter a;
    public final /* synthetic */ ListView b;

    public vs(BaseAdapter baseAdapter, ListView listView) {
        this.a = baseAdapter;
        this.b = listView;
    }

    @Override // me.hd.wauxv.obf.dph
    public final void c(dpl dplVar) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object next;
        biw.a.getClass();
        Iterator it = biw.f().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!nullSafeIsEqual(((biv) next).b, String.valueOf(dplVar.b)));
        if (((biv) next) != null) {
            vi.a.u(String.valueOf(dplVar.b));
            aic.a.getClass();
            Method methodBb = StaticHelpers7.bb(aib.a);
            Object[] objArr = { Boolean.TRUE };
            BaseAdapter baseAdapter = this.a;
            methodBb.invoke(baseAdapter, objArr);
            agk.a.getClass();
            StaticHelpers7.bb(agj.a).invoke(this.b, null);
            baseAdapter.notifyDataSetChanged();
        }
    }
}
