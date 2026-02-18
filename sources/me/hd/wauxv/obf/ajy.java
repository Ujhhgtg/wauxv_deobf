package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ajy extends BaseAdapter implements Adapter {
    public aro a;
    public ArrayList b;

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return (dhr) this.b.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return ((dhr) this.b.get(i)).hashCode();
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        aro aroVar = this.a;
        boolean z = i == aroVar.h;
        if (view == null) {
            view = LayoutInflater.from(aroVar.a.getContext()).inflate(R.layout.default_completion_result_item, viewGroup, false);
        }
        dhr dhrVar = (dhr) this.b.get(i);
        TextView textView = (TextView) view.findViewById(R.id.result_item_label);
        textView.setText(dhrVar.b);
        textView.setTextColor(this.a.aa.getColorScheme().b.get(42));
        TextView textView2 = (TextView) view.findViewById(R.id.result_item_desc);
        textView2.setText(dhrVar.c);
        textView2.setTextColor(this.a.aa.getColorScheme().b.get(43));
        view.setTag(Integer.valueOf(i));
        if (z) {
            view.setBackgroundColor(this.a.aa.getColorScheme().b.get(44));
        } else {
            view.setBackgroundColor(0);
        }
        ((ImageView) view.findViewById(R.id.result_item_image)).setImageDrawable(dhrVar.a);
        return view;
    }
}
