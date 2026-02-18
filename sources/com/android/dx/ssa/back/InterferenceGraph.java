package com.android.dx.ssa.back;

import com.android.dx.ssa.SetFactory;
import com.android.dx.util.IntSet;
import java.util.ArrayList;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class InterferenceGraph {
    private final ArrayList<IntSet> interference;

    public InterferenceGraph(int i) {
        this.interference = new ArrayList<>(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.interference.add(SetFactory.makeInterferenceSet(i));
        }
    }

    private void ensureCapacity(int i) {
        this.interference.ensureCapacity(i);
        for (int size = this.interference.size(); size < i; size++) {
            this.interference.add(SetFactory.makeInterferenceSet(i));
        }
    }

    public void add(int i, int i2) {
        ensureCapacity(Math.max(i, i2) + 1);
        this.interference.get(i).add(i2);
        this.interference.get(i2).add(i);
    }

    public void dumpToStdout() {
        int size = this.interference.size();
        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbR = yg.r(i, "Reg ", ":");
            sbR.append(this.interference.get(i).toString());
            sb.append(sbR.toString());
            System.out.println(sb.toString());
        }
    }

    public void mergeInterferenceSet(int i, IntSet intSet) {
        if (i < this.interference.size()) {
            intSet.merge(this.interference.get(i));
        }
    }
}
