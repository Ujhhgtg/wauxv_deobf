package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cbt extends BaseAdapter {
    public final cbw a;
    public int b = -1;
    public boolean c;
    public final boolean d;
    public final LayoutInflater e;
    public final int f;

    public cbt(cbw cbwVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.d = z;
        this.e = layoutInflater;
        this.a = cbwVar;
        this.f = i;
        g();
    }

    public final void g() {
        cbw cbwVar = this.a;
        cbz cbzVar = cbwVar.w;
        if (cbzVar != null) {
            cbwVar.ah();
            ArrayList arrayList = cbwVar.k;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((cbz) arrayList.get(i)) == cbzVar) {
                    this.b = i;
                    return;
                }
            }
        }
        this.b = -1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListAk;
        boolean z = this.d;
        cbw cbwVar = this.a;
        if (z) {
            cbwVar.ah();
            arrayListAk = cbwVar.k;
        } else {
            arrayListAk = cbwVar.ak();
        }
        return this.b < 0 ? arrayListAk.size() : arrayListAk.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.e.inflate(this.f, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        int i4 = i3 >= 0 ? getItem(i3).b : i2;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.a.al() && i2 != i4) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        ccn ccnVar = (ccn) view;
        if (this.c) {
            listMenuItemView.setForceShowIcon(true);
        }
        ccnVar.n(getItem(i));
        return view;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final cbz getItem(int i) {
        ArrayList arrayListAk;
        boolean z = this.d;
        cbw cbwVar = this.a;
        if (z) {
            cbwVar.ah();
            arrayListAk = cbwVar.k;
        } else {
            arrayListAk = cbwVar.ak();
        }
        int i2 = this.b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (cbz) arrayListAk.get(i);
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        g();
        super.notifyDataSetChanged();
    }
}
