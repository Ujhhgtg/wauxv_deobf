package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i extends bgr implements bgk {
    public static final i a = new i(3, bdk.class, cnb.z(-395162761034538L), cnb.z(-395128401296170L), 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_about, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        RecyclerView recyclerView = (RecyclerView) cnd.aq(viewInflate, R.id.aboutRecyclerView);
        if (recyclerView != null) {
            return new bdk((LinearLayout) viewInflate, recyclerView);
        }
        throw new NullPointerException(cnb.z(-634474043800362L).concat(viewInflate.getResources().getResourceName(R.id.aboutRecyclerView)));
    }
}
