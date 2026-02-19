package me.hd.wauxv.obf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import de.robv.android.xposed.XposedBridge;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class adw extends cyw {
    public List a = EmptyReadonlyList.a;
    public final aek b;

    public adw(aek aekVar) {
        this.b = aekVar;
    }

    public static void c(adw adwVar) {
        List list = adwVar.a;
        adwVar.getClass();
        throwIfVar1IsNull(list, "list");
    }

    public static void h(adw adwVar, List list) {
        adwVar.getClass();
        if (list == null) {
            list = EmptyReadonlyList.a;
        }
        c(adwVar);
        List list2 = adwVar.a;
        adwVar.a = list;
        adwVar.af();
        List list3 = adwVar.a;
        throwIfVar1IsNull(list2, "previousList");
        throwIfVar1IsNull(list3, "currentList");
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        c(this);
        List list = this.a;
        throwIfVar1IsNull(list, "items");
        return list.size();
    }

    @Override // me.hd.wauxv.obf.cyw
    public final long e(int i) {
        return i;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(czx czxVar, int i) {
        if (czxVar instanceof dmm) {
            cbm.g(((dmm) czxVar).b);
        } else {
            o(czxVar, aaz.h(i, this.a));
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final czx g(ViewGroup viewGroup, int i) {
        if (i == R.id.BaseQuickAdapter_empty_view) {
            return new dmm(viewGroup);
        }
        Context context = viewGroup.getContext();
        throwIfVar1IsNull(context, "getContext(...)");
        return new cxd(LayoutInflater.from(context).inflate(R.layout.item_rv_contact, viewGroup, false));
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int i(int i) {
        c(this);
        return i;
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void j(RecyclerView recyclerView) {
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void k(czx czxVar, int i, List list) {
        throwIfVar1IsNull(list, "payloads");
        if (list.isEmpty()) {
            f(czxVar, i);
        } else if (czxVar instanceof dmm) {
            cbm.g(((dmm) czxVar).b);
        } else {
            o(czxVar, aaz.h(i, this.a));
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void l(RecyclerView recyclerView) {
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void m(czx czxVar) {
        if (!(czxVar instanceof dmm)) {
            int iY = czxVar.y();
            c(this);
            if (iY != R.id.BaseQuickAdapter_empty_view) {
                return;
            }
        }
        View view = czxVar.d;
        if (view.getLayoutParams() instanceof dmb) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            throwIfVar1IsNull(layoutParams,
                    "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            ((dmb) layoutParams).b = true;
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void n(czx czxVar) {
    }

    public final void o(czx czxVar, Object obj) {
        cxd cxdVar = (cxd) czxVar;
        adx adxVar = (adx) obj;
        if (adxVar != null) {
            CheckBox checkBox = (CheckBox) cxdVar.b(R.id.itemContactCheckBoxSelect);
            checkBox.setChecked(adxVar.d);
            checkBox.setOnCheckedChangeListener(new zj(adxVar, 1, this));
            cxdVar.d.setOnClickListener(new bq(cxdVar, 3));
            mo moVar = mo.a;
            ImageView imageView = (ImageView) cxdVar.b(R.id.itemContactImageViewAvatar);
            String str = adxVar.a;
            moVar.getClass();
            XposedBridge.invokeOriginalMethod(emn.bb(mn.a), (Object) null,
                    new Object[] { imageView, str, Float.valueOf(0.1f), Boolean.FALSE });
            ((TextView) cxdVar.b(R.id.itemContactTextViewName)).setText(adxVar.b);
            ((TextView) cxdVar.b(R.id.itemContactTextViewDesc)).setText(adxVar.c);
        }
    }
}
