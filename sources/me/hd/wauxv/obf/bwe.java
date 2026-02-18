package me.hd.wauxv.obf;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bwe extends BaseAdapter {
    public int a = -1;
    public final /* synthetic */ bwf b;

    public bwe(bwf bwfVar) {
        this.b = bwfVar;
        c();
    }

    public final void callOriginalMethod() {
        cbw cbwVar = this.b.c;
        cbz cbzVar = cbwVar.w;
        if (cbzVar != null) {
            cbwVar.ah();
            ArrayList arrayList = cbwVar.k;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((cbz) arrayList.get(i)) == cbzVar) {
                    this.a = i;
                    return;
                }
            }
        }
        this.a = -1;
    }

    @Override // android.widget.Adapter
    /*
     * JADX INFO: renamed from: d, reason: merged with bridge method
     * [inline-methods]
     */
    public final cbz getItem(int i) {
        bwf bwfVar = this.b;
        cbw cbwVar = bwfVar.c;
        cbwVar.ah();
        ArrayList arrayList = cbwVar.k;
        bwfVar.getClass();
        int i2 = this.a;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (cbz) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        bwf bwfVar = this.b;
        cbw cbwVar = bwfVar.c;
        cbwVar.ah();
        int size = cbwVar.k.size();
        bwfVar.getClass();
        return this.a < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.b.b.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((ccn) view).n(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        c();
        super.notifyDataSetChanged();
    }
}
