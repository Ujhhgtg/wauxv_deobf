package me.hd.wauxv.obf;

import android.view.View;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqd extends eqc {
    public final eqj ao;
    public final /* synthetic */ int b = 1;

    public eqd(bqq bqqVar) {
        super(bqqVar.b);
        this.ao = bqqVar;
    }

    @Override // me.hd.wauxv.obf.eqc
    public final void a(oc ocVar) {
        switch (this.b) {
            case 0:
                bqr bqrVar = (bqr) this.ao;
                ny nyVar = ocVar instanceof ny ? (ny) ocVar : null;
                if (nyVar != null) {
                    View.OnClickListener onClickListener = nyVar.c;
                    String str = nyVar.b;
                    ((MaterialTextView) bqrVar.e).setText(nyVar.a);
                    if (str == null || str.length() == 0) {
                        ((MaterialTextView) bqrVar.c).setVisibility(8);
                    } else {
                        MaterialTextView materialTextView = (MaterialTextView) bqrVar.c;
                        materialTextView.setVisibility(0);
                        materialTextView.setText(str);
                    }
                    if (onClickListener == null) {
                        ((ShapeableImageView) bqrVar.d).setVisibility(8);
                        bqrVar.b.setOnClickListener(null);
                    } else {
                        ((ShapeableImageView) bqrVar.d).setVisibility(0);
                        bqrVar.b.setOnClickListener(onClickListener);
                    }
                }
                break;
            default:
                nz nzVar = ocVar instanceof nz ? (nz) ocVar : null;
                if (nzVar != null) {
                    ((MaterialTextView) ((bqq) this.ao).c).setText(nzVar.a);
                }
                break;
        }
    }

    public eqd(bqr bqrVar) {
        super(bqrVar.b);
        this.ao = bqrVar;
    }
}
