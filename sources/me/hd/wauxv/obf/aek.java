package me.hd.wauxv.obf;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aek {
    public ael a;
    public final Kotlin$Lazy e;
    public final Kotlin$Lazy f;
    public final Kotlin$Lazy g;
    public final Kotlin$Lazy h;
    public final Kotlin$Lazy i;
    public final Kotlin$Lazy j;
    public final Kotlin$Lazy k;
    public final Kotlin$Lazy b = new Kotlin$Lazy(new h(26));
    public final Kotlin$Lazy c = new Kotlin$Lazy(new h(27));
    public final Kotlin$Lazy d = new Kotlin$Lazy(new h(28));
    public adw l = new adw(this);

    public aek() {
        final int i = 0;
        this.e = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i2 = 1;
        this.f = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i3 = 2;
        this.g = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i4 = 3;
        this.h = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i5 = 4;
        this.i = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i5) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i6 = 5;
        this.j = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i6) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
        final int i7 = 6;
        this.k = new Kotlin$Lazy(new IFunction0(this) { // from class: me.hd.wauxv.obf.aej
            public final /* synthetic */ aek b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() {
                switch (i7) {
                    case 0:
                        return (RecyclerView) ((LinearLayout) this.b.d.getValue())
                                .findViewById(R.id.itemContactRecyclerView);
                    case 1:
                        return (EditText) this.b.n().findViewById(R.id.etSearch);
                    case 2:
                        return (Button) this.b.n().findViewById(R.id.btnCancel);
                    case 3:
                        return (Button) this.b.n().findViewById(R.id.btnConfirm);
                    case 4:
                        return (RadioGroup) this.b.n().findViewById(R.id.rgTabs);
                    case 5:
                        return (CheckBox) this.b.n().findViewById(R.id.cbSelectAll);
                    default:
                        return (TextView) this.b.n().findViewById(R.id.tvCounter);
                }
            }
        });
    }

    public final ccu m() {
        return (ccu) this.b.getValue();
    }

    public final LinearLayout n() {
        return (LinearLayout) this.c.getValue();
    }

    public final void o() {
        List list = this.l.a;
        boolean z = true;
        if (list == null || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (!((adx) it.next()).d) {
                    z = false;
                    break;
                }
            }
        }
        ((CheckBox) this.j.getValue()).setChecked(z);
    }

    public final void p(String str) {
        List list;
        Object obj;
        ArrayList arrayList;
        ael aelVar = this.a;
        Pair pairVar = null;
        if (aelVar == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* cnb.z(-393668112415530L)  */);
            throw null;
        }
        RadioGroup radioGroup = (RadioGroup) aelVar.a.i.getValue();
        int childCount = radioGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = radioGroup.getChildAt(i);
            if (childAt instanceof RadioButton) {
                RadioButton radioButton = (RadioButton) childAt;
                CharSequence text = radioButton.getText();
                if (radioButton.isChecked()) {
                    String string = text.toString();
                    String string2 = text.toString();
                    if (nullSafeIsEqual(string2, "全部" /* "全部" /* "全部" /* cnb.z(-395471998679850L)  */)) {
                        arrayList = aelVar.c;
                        if (!aelVar.b || arrayList.isEmpty()) {
                            obj = arrayList;
                            obj = aelVar.e;
                        }
                    } else {
                        list = (List) aelVar.d.get(string2);
                        if (list == null) {
                            obj = list;
                            obj = EmptyReadonlyList.INSTANCE;
                        }
                    }
                    obj = list;
                    obj = arrayList;
                    pairVar = new Pair(string, obj);
                    break;
                }
            }
        }
        throwIfVar1IsNull(pairVar);
        List list2 = (List) pairVar.second;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            adx adxVar = (adx) obj2;
            String str2 = adxVar.b;
            String str3 = adxVar.c;
            if (StringsKt.contains(str2, str, true) || StringsKt.contains(str3, str, true)) {
                arrayList2.add(obj2);
            }
        }
        this.l = new adw(this);
        ((RecyclerView) this.e.getValue()).setAdapter(this.l);
        adw.h(this.l, arrayList2);
        o();
    }

    public final void q() {
        TextView textView = (TextView) this.k.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append("已选择 " /* "已选择 " /* "已选择 " /* cnb.z(-393680997317418L)  */);
        ael aelVar = this.a;
        if (aelVar == null) {
            throwLateinitPropNotInitYet("info" /* "info" /* "info" /* cnb.z(-393642342611754L)  */);
            throw null;
        }
        sb.append(aelVar.n().size());
        sb.append(" 项" /* " 项" /* " 项" /* cnb.z(-393655227513642L)  */);
        textView.setText(sb.toString());
    }
}
