package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cuo extends bgr implements bgk {
    public static final cuo a = new cuo(3, bew.class, cnb.z(-417964742409002L), cnb.z(-417930382670634L), 0);

    @Override // me.hd.wauxv.obf.bgk
    public final Object b(Object obj, Object obj2, Object obj3) {
        ViewGroup viewGroup = (ViewGroup) obj2;
        boolean zBooleanValue = ((Boolean) obj3).booleanValue();
        View viewInflate = ((LayoutInflater) obj).inflate(R.layout.fragment_policy, viewGroup, false);
        if (zBooleanValue) {
            viewGroup.addView(viewInflate);
        }
        int i = R.id.policyButtonAccept;
        MaterialButton materialButton = (MaterialButton) cnd.aq(viewInflate, R.id.policyButtonAccept);
        if (materialButton != null) {
            i = R.id.policyTextViewDesc;
            MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewInflate, R.id.policyTextViewDesc);
            if (materialTextView != null) {
                i = R.id.policyToolbar;
                if (((MaterialToolbar) cnd.aq(viewInflate, R.id.policyToolbar)) != null) {
                    return new bew((CoordinatorLayout) viewInflate, materialButton, materialTextView);
                }
            }
        }
        throw new NullPointerException(cnb.z(-640796235660074L).concat(viewInflate.getResources().getResourceName(i)));
    }
}
