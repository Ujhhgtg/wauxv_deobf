package com.android.dx.ssa;

import com.android.dx.util.IntSet;
import java.util.ArrayList;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DomFront {
    private static final boolean DEBUG = false;
    private final DomInfo[] domInfos;
    private final SsaMethod meth;
    private final ArrayList<SsaBasicBlock> nodes;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class DomInfo {
        public IntSet dominanceFrontiers;
        public int idom = -1;
    }

    public DomFront(SsaMethod ssaMethod) {
        this.meth = ssaMethod;
        ArrayList<SsaBasicBlock> blocks = ssaMethod.getBlocks();
        this.nodes = blocks;
        int size = blocks.size();
        this.domInfos = new DomInfo[size];
        for (int i = 0; i < size; i++) {
            this.domInfos[i] = new DomInfo();
        }
    }

    private void buildDomTree() {
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            int i2 = this.domInfos[i].idom;
            if (i2 != -1) {
                this.nodes.get(i2).addDomChild(this.nodes.get(i));
            }
        }
    }

    private void calcDomFronts() {
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            SsaBasicBlock ssaBasicBlock = this.nodes.get(i);
            DomInfo domInfo = this.domInfos[i];
            BitSet predecessors = ssaBasicBlock.getPredecessors();
            if (predecessors.cardinality() > 1) {
                for (int iNextSetBit = predecessors.nextSetBit(0); iNextSetBit >= 0; iNextSetBit = predecessors.nextSetBit(iNextSetBit + 1)) {
                    int i2 = iNextSetBit;
                    while (i2 != domInfo.idom && i2 != -1) {
                        DomInfo domInfo2 = this.domInfos[i2];
                        if (domInfo2.dominanceFrontiers.has(i)) {
                            break;
                        }
                        domInfo2.dominanceFrontiers.add(i);
                        i2 = domInfo2.idom;
                    }
                }
            }
        }
    }

    private void debugPrintDomChildren() {
        int size = this.nodes.size();
        for (int i = 0; i < size; i++) {
            SsaBasicBlock ssaBasicBlock = this.nodes.get(i);
            StringBuffer stringBuffer = new StringBuffer("{");
            boolean z = false;
            for (SsaBasicBlock ssaBasicBlock2 : ssaBasicBlock.getDomChildren()) {
                if (z) {
                    stringBuffer.append(',');
                }
                stringBuffer.append(ssaBasicBlock2);
                z = true;
            }
            stringBuffer.append('}');
            System.out.println("domChildren[" + ssaBasicBlock + "]: " + ((Object) stringBuffer));
        }
    }

    public DomInfo[] run() {
        int size = this.nodes.size();
        Dominators.make(this.meth, this.domInfos, false);
        buildDomTree();
        for (int i = 0; i < size; i++) {
            this.domInfos[i].dominanceFrontiers = SetFactory.makeDomFrontSet(size);
        }
        calcDomFronts();
        return this.domInfos;
    }
}
