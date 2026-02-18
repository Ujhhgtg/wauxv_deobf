package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqi extends cyw {
    public final List a;

    public eqi(List list) {
        this.a = list;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        return this.a.size();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(czx czxVar, int i) {
        eqc eqcVar = czxVar instanceof eqc ? (eqc) czxVar : null;
        if (eqcVar != null) {
            eqcVar.a((oc) this.a.get(i));
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final czx g(ViewGroup viewGroup, int i) {
        if (i == 0) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_view_header,
                    viewGroup, false);
            MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewInflate,
                    R.id.itemHeaderViewTextViewTitle);
            if (materialTextView != null) {
                return new eqd(new bqq((LinearLayout) viewInflate, materialTextView, 1));
            }
            throw new NullPointerException("Missing required view with ID: " /* cnb.z(-641620869380906L) */.concat(
                    viewInflate.getResources().getResourceName(R.id.itemHeaderViewTextViewTitle)));
        }
        if (i != 1) {
            if (i == 2) {
                return new eqe(bqs.g(LayoutInflater.from(viewGroup.getContext()), viewGroup), 1);
            }
            if (i == 3) {
                return new eqe(bqs.g(LayoutInflater.from(viewGroup.getContext()), viewGroup), 0);
            }
            throw new IllegalArgumentException("onCreateViewHolder Failed" /* cnb.z(-394325242411818L) */);
        }
        View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_view_content,
                viewGroup, false);
        int i2 = R.id.itemContentViewImageViewNav;
        ShapeableImageView shapeableImageView = (ShapeableImageView) cnd.aq(viewInflate2,
                R.id.itemContentViewImageViewNav);
        if (shapeableImageView != null) {
            i2 = R.id.itemContentViewTextViewDesc;
            MaterialTextView materialTextView2 = (MaterialTextView) cnd.aq(viewInflate2,
                    R.id.itemContentViewTextViewDesc);
            if (materialTextView2 != null) {
                i2 = R.id.itemContentViewTextViewTitle;
                MaterialTextView materialTextView3 = (MaterialTextView) cnd.aq(viewInflate2,
                        R.id.itemContentViewTextViewTitle);
                if (materialTextView3 != null) {
                    return new eqd(new bqr((LinearLayout) viewInflate2, shapeableImageView, materialTextView2,
                            materialTextView3, 0));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: "
                /* cnb.z(-641758308334378L) */.concat(viewInflate2.getResources().getResourceName(i2)));
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int i(int i) {
        oc ocVar = (oc) this.a.get(i);
        if (ocVar instanceof nz) {
            return 0;
        }
        if (ocVar instanceof ny) {
            return 1;
        }
        if (ocVar instanceof ob) {
            return 2;
        }
        if (ocVar instanceof oa) {
            return 3;
        }
        throw new QueryDidNotReturnUniqueResultRuntimeException();
    }
}
