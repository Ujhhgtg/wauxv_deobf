package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cyg extends ConstraintLayout {
    public final dh an;
    public int ao;
    public final cau ap;

    public cyg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        cau cauVar = new cau();
        this.ap = cauVar;
        dat datVar = new dat(0.5f);
        dgl dglVarQ = cauVar.ct.b.q();
        dglVarQ.e = datVar;
        dglVarQ.f = datVar;
        dglVarQ.g = datVar;
        dglVarQ.h = datVar;
        cauVar.setShapeAppearanceModel(dglVarQ.m());
        this.ap.dz(ColorStateList.valueOf(-1));
        cau cauVar2 = this.ap;
        WeakHashMap weakHashMap = ViewCompat.a;
        setBackground(cauVar2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, cxs.ag, R.attr.materialClockStyle, 0);
        this.ao = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.an = new dh(this, 16);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            WeakHashMap weakHashMap = ViewCompat.a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            dh dhVar = this.an;
            handler.removeCallbacks(dhVar);
            handler.post(dhVar);
        }
    }

    public abstract void al();

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        al();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            dh dhVar = this.an;
            handler.removeCallbacks(dhVar);
            handler.post(dhVar);
        }
    }

    @Override // android.view.View
    public final void setBackgroundColor(int i) {
        this.ap.dz(ColorStateList.valueOf(i));
    }
}
