package me.hd.wauxv.obf;

import android.util.SparseArray;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cxd extends czx {
    public final SparseArray a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public cxd(View view) {
        super(view);
        throwIfVar1IsNull(view, "view");
        this.a = new SparseArray();
    }

    public final View b(int i) {
        SparseArray sparseArray = this.a;
        View viewFindViewById = (View) sparseArray.get(i);
        if (viewFindViewById == null) {
            viewFindViewById = this.d.findViewById(i);
            if (viewFindViewById != null) {
                sparseArray.put(i, viewFindViewById);
            } else {
                viewFindViewById = null;
            }
        }
        if (viewFindViewById != null) {
            return viewFindViewById;
        }
        throw new IllegalStateException(concatVar2Var1(i, "No view found with id ").toString());
    }
}
