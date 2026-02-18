package com.android.dx.merge;

import java.util.Comparator;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.amo;
import me.hd.wauxv.obf.emd;
import me.hd.wauxv.obf.yg;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class SortableType {
    public static final Comparator<SortableType> NULLS_LAST_ORDER = new Comparator<SortableType>() { // from class: com.android.dx.merge.SortableType.1
        @Override // java.util.Comparator
        public int compare(SortableType sortableType, SortableType sortableType2) {
            int typeIndex;
            int typeIndex2;
            if (sortableType == sortableType2) {
                return 0;
            }
            if (sortableType2 == null) {
                return -1;
            }
            if (sortableType == null) {
                return 1;
            }
            if (sortableType.depth != sortableType2.depth) {
                typeIndex = sortableType.depth;
                typeIndex2 = sortableType2.depth;
            } else {
                typeIndex = sortableType.getTypeIndex();
                typeIndex2 = sortableType2.getTypeIndex();
            }
            return typeIndex - typeIndex2;
        }
    };
    private final yx classDef;
    private int depth = -1;
    private final amk dex;
    private final IndexMap indexMap;

    public SortableType(amk amkVar, IndexMap indexMap, yx yxVar) {
        this.dex = amkVar;
        this.indexMap = indexMap;
        this.classDef = yxVar;
    }

    public yx getClassDef() {
        return this.classDef;
    }

    public amk getDex() {
        return this.dex;
    }

    public IndexMap getIndexMap() {
        return this.indexMap;
    }

    public int getTypeIndex() {
        return this.classDef.c;
    }

    public boolean isDepthAssigned() {
        return this.depth != -1;
    }

    public boolean tryAssignDepth(SortableType[] sortableTypeArr) {
        int iMax;
        emd emdVarH;
        yx yxVar = this.classDef;
        int i = yxVar.e;
        if (i == -1) {
            iMax = 0;
        } else {
            if (i == yxVar.c) {
                throw new amo(yg.m(new StringBuilder("Class with type index "), " extends itself", this.classDef.c), null);
            }
            SortableType sortableType = sortableTypeArr[i];
            if (sortableType != null) {
                iMax = sortableType.depth;
                if (iMax != -1) {
                }
                return false;
            }
            iMax = 1;
        }
        amk amkVar = yxVar.a;
        int i2 = yxVar.f;
        if (i2 == 0) {
            amkVar.getClass();
            emdVarH = emd.a;
        } else {
            emdVarH = amkVar.n(i2).h();
        }
        for (short s : emdVarH.c) {
            SortableType sortableType2 = sortableTypeArr[s];
            if (sortableType2 == null) {
                iMax = Math.max(iMax, 1);
            } else {
                int i3 = sortableType2.depth;
                if (i3 == -1) {
                    return false;
                }
                iMax = Math.max(iMax, i3);
            }
        }
        this.depth = iMax + 1;
        return true;
    }
}
