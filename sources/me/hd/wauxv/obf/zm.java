package me.hd.wauxv.obf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zm extends cyw {
    public final /* synthetic */ int a = 1;
    public List b;
    public Object c;

    public /* synthetic */ zm() {
    }

    @Override // me.hd.wauxv.obf.cyw
    public final int d() {
        switch (this.a) {
            case 0:
                return this.b.size();
            default:
                return ((ArrayList) this.b).size();
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final void f(SomeView someViewVar, final int i) {
        switch (this.a) {
            case 0:
                bqq bqqVar = ((zk) someViewVar).a;
                zn znVar = (zn) this.b.get(i);
                ((MaterialCheckBox) bqqVar.c).setText(znVar.a.concat(" (计算中...)" /* " (计算中...)" /* " (计算中...)" /* cnb.z(-11935714114346L)  */));
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) bqqVar.c;
                materialCheckBox.setOnCheckedChangeListener(null);
                materialCheckBox.setChecked(((Set) this.c).contains(znVar.a));
                materialCheckBox.setOnCheckedChangeListener(new zj(this, 0, znVar));
                eq eqVar = new eq(bqqVar, znVar, null);
                Dispatchers$Default alcVar = aou.a;
                KotlinHelpers2.bf(bza.a, eqVar);
                break;
            default:
                dpb dpbVar = (dpb) someViewVar;
                ((MaterialTextView) dpbVar.a.c).setText((CharSequence) ((ArrayList) this.b).get(i));
                dpbVar.d.setOnLongClickListener(new View.OnLongClickListener() { // from class: me.hd.wauxv.obf.dpa
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        but butVar = (but) this.a.c;
                        if (butVar == null) {
                            return true;
                        }
                        ((ArrayList) butVar.b).remove(i);
                        ((zm) butVar.c).af();
                        return true;
                    }
                });
                break;
        }
    }

    @Override // me.hd.wauxv.obf.cyw
    public final SomeView g(ViewGroup viewGroup, int i) {
        switch (this.a) {
            case 0:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_auto_clean, viewGroup, false);
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) KotlinHelpers2.recursivelyFindViewById(viewInflate, R.id.itemAutoCleanCheckBox);
                if (materialCheckBox != null) {
                    return new zk(new bqq((LinearLayout) viewInflate, materialCheckBox, 2));
                }
                throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-640109040892714L)  */.concat(viewInflate.getResources().getResourceName(R.id.itemAutoCleanCheckBox)));
            default:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_system_browser, viewGroup, false);
                MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewInflate2, R.id.itemSystemBrowserTvHost);
                if (materialTextView != null) {
                    return new dpb(new bqq((LinearLayout) viewInflate2, materialTextView, 0));
                }
                throw new NullPointerException("Missing required view with ID: " /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-640246479846186L)  */.concat(viewInflate2.getResources().getResourceName(R.id.itemSystemBrowserTvHost)));
        }
    }

    public zm(List list, Set set) {
        this.b = list;
        this.c = new LinkedHashSet(set);
    }
}
