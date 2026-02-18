package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bds implements LayoutInflater.Factory2 {
    public final beg a;

    public bds(beg begVar) {
        this.a = begVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        bfb bfbVarBc;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        beg begVar = this.a;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, begVar);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cya.a);
            if (attributeValue == null) {
                attributeValue = typedArrayObtainStyledAttributes.getString(0);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            int i = 2;
            String string = typedArrayObtainStyledAttributes.getString(2);
            typedArrayObtainStyledAttributes.recycle();
            if (attributeValue != null) {
                try {
                    zIsAssignableFrom = bdj.class
                            .isAssignableFrom(bdz.createInstanceWithArgs(context.getClassLoader(), attributeValue));
                } catch (ClassNotFoundException unused) {
                    zIsAssignableFrom = false;
                }
                if (zIsAssignableFrom) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription()
                                + ": Must specify unique android:id, android:tag, or have a parent with an id for "
                                + attributeValue);
                    }
                    bdj bdjVarCa = resourceId != -1 ? begVar.ca(resourceId) : null;
                    if (bdjVarCa == null && string != null) {
                        bdjVarCa = begVar.cb(string);
                    }
                    if (bdjVarCa == null && id != -1) {
                        bdjVarCa = begVar.ca(id);
                    }
                    if (bdjVarCa == null) {
                        bdz bdzVarCe = begVar.ce();
                        context.getClassLoader();
                        bdjVarCa = bdzVarCe.e(attributeValue);
                        bdjVarCa.bg = true;
                        bdjVarCa.bq = resourceId != 0 ? resourceId : id;
                        bdjVarCa.br = id;
                        bdjVarCa.bs = string;
                        bdjVarCa.bh = true;
                        bdjVarCa.bm = begVar;
                        bdm bdmVar = begVar.w;
                        bdjVarCa.bn = bdmVar;
                        bdjVarCa.i(bdmVar.e, attributeSet, bdjVarCa.at);
                        bfbVarBc = begVar.aw(bdjVarCa);
                        if (beg.ar(2)) {
                            Log.v("FragmentManager",
                                    "Fragment " + bdjVarCa + " has been inflated via the <fragment> tag: id=0x"
                                            + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (bdjVarCa.bh) {
                            throw new IllegalArgumentException(
                                    attributeSet.getPositionDescription() + ": Duplicate id 0x"
                                            + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x"
                                            + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                        }
                        bdjVarCa.bh = true;
                        bdjVarCa.bm = begVar;
                        bdm bdmVar2 = begVar.w;
                        bdjVarCa.bn = bdmVar2;
                        bdjVarCa.i(bdmVar2.e, attributeSet, bdjVarCa.at);
                        bfbVarBc = begVar.bc(bdjVarCa);
                        if (beg.ar(2)) {
                            Log.v("FragmentManager",
                                    "Retained Fragment " + bdjVarCa
                                            + " has been re-attached via the <fragment> tag: id=0x"
                                            + Integer.toHexString(resourceId));
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    bfc bfcVar = bfd.a;
                    bfd.c(new bex(bdjVarCa, "Attempting to use <fragment> tag to add fragment " + bdjVarCa
                            + " to container " + viewGroup));
                    bfd.b(bdjVarCa).getClass();
                    bdjVarCa.by = viewGroup;
                    bfbVarBc.p();
                    bfbVarBc.o();
                    View view2 = bdjVarCa.bz;
                    if (view2 == null) {
                        throw new IllegalStateException(concat("Fragment ", attributeValue, " did not create a view."));
                    }
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (bdjVarCa.bz.getTag() == null) {
                        bdjVarCa.bz.setTag(string);
                    }
                    bdjVarCa.bz.addOnAttachStateChangeListener(new bau(this, i, bfbVarBc));
                    return bdjVarCa.bz;
                }
            }
        }
        return null;
    }
}
