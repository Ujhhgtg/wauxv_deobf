package com.android.dx.cf.code;

import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import java.util.ArrayList;
import me.hd.wauxv.obf.axc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class LocalsArraySet extends LocalsArray {
    private final OneLocalsArray primary;
    private final ArrayList<LocalsArray> secondaries;

    public LocalsArraySet(int i) {
        super(i != 0);
        this.primary = new OneLocalsArray(i);
        this.secondaries = new ArrayList<>();
    }

    private LocalsArray getSecondaryForLabel(int i) {
        if (i >= this.secondaries.size()) {
            return null;
        }
        return this.secondaries.get(i);
    }

    private LocalsArraySet mergeWithOne(OneLocalsArray oneLocalsArray) {
        LocalsArray localsArrayMerge;
        OneLocalsArray oneLocalsArrayMerge = this.primary.merge(oneLocalsArray.getPrimary());
        ArrayList arrayList = new ArrayList(this.secondaries.size());
        int size = this.secondaries.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = this.secondaries.get(i);
            if (localsArray != null) {
                try {
                    localsArrayMerge = localsArray.merge(oneLocalsArray);
                } catch (SimException e) {
                    e.addContext("Merging one locals against caller block " + Hex.u2(i));
                    localsArrayMerge = null;
                }
            } else {
                localsArrayMerge = null;
            }
            z = z || localsArray != localsArrayMerge;
            arrayList.add(localsArrayMerge);
        }
        return (this.primary != oneLocalsArrayMerge || z) ? new LocalsArraySet(oneLocalsArrayMerge, arrayList) : this;
    }

    /* JADX WARN: Found duplicated region for block: B:16:0x0046  */
    private LocalsArraySet mergeWithSet(LocalsArraySet localsArraySet) {
        OneLocalsArray oneLocalsArrayMerge = this.primary.merge(localsArraySet.getPrimary());
        int size = this.secondaries.size();
        int size2 = localsArraySet.secondaries.size();
        int iMax = Math.max(size, size2);
        ArrayList arrayList = new ArrayList(iMax);
        int i = 0;
        boolean z = false;
        while (i < iMax) {
            LocalsArray localsArrayMerge = null;
            LocalsArray localsArray = i < size ? this.secondaries.get(i) : null;
            LocalsArray localsArray2 = i < size2 ? localsArraySet.secondaries.get(i) : null;
            if (localsArray == localsArray2) {
                localsArrayMerge = localsArray;
            } else if (localsArray == null) {
                localsArrayMerge = localsArray2;
            } else if (localsArray2 == null) {
                localsArrayMerge = localsArray;
            } else {
                try {
                    localsArrayMerge = localsArray.merge(localsArray2);
                } catch (SimException e) {
                    e.addContext("Merging locals set for caller block " + Hex.u2(i));
                }
            }
            z = z || localsArray != localsArrayMerge;
            arrayList.add(localsArrayMerge);
            i++;
        }
        return (this.primary != oneLocalsArrayMerge || z) ? new LocalsArraySet(oneLocalsArrayMerge, arrayList) : this;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void annotate(axc axcVar) {
        axcVar.addContext("(locals array set; primary)");
        this.primary.annotate(axcVar);
        int size = this.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = this.secondaries.get(i);
            if (localsArray != null) {
                axcVar.addContext("(locals array set: primary for caller " + Hex.u2(i) + ')');
                localsArray.getPrimary().annotate(axcVar);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArray copy() {
        return new LocalsArraySet(this);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer get(int i) {
        return this.primary.get(i);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory1(int i) {
        return this.primary.getCategory1(i);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getCategory2(int i) {
        return this.primary.getCategory2(i);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public int getMaxLocals() {
        return this.primary.getMaxLocals();
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public TypeBearer getOrNull(int i) {
        return this.primary.getOrNull(i);
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public OneLocalsArray getPrimary() {
        return this.primary;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void invalidate(int i) {
        throwIfImmutable();
        this.primary.invalidate(i);
        for (LocalsArray localsArray : this.secondaries) {
            if (localsArray != null) {
                localsArray.invalidate(i);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void makeInitialized(Type type) {
        if (this.primary.getMaxLocals() == 0) {
            return;
        }
        throwIfImmutable();
        this.primary.makeInitialized(type);
        for (LocalsArray localsArray : this.secondaries) {
            if (localsArray != null) {
                localsArray.makeInitialized(type);
            }
        }
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArraySet mergeWithSubroutineCaller(LocalsArray localsArray, int i) {
        LocalsArray secondaryForLabel = getSecondaryForLabel(i);
        OneLocalsArray oneLocalsArrayMerge = this.primary.merge(localsArray.getPrimary());
        if (secondaryForLabel == localsArray) {
            localsArray = secondaryForLabel;
        } else if (secondaryForLabel != null) {
            localsArray = secondaryForLabel.merge(localsArray);
        }
        if (localsArray == secondaryForLabel && oneLocalsArrayMerge == this.primary) {
            return this;
        }
        int size = this.secondaries.size();
        int iMax = Math.max(i + 1, size);
        ArrayList arrayList = new ArrayList(iMax);
        int i2 = 0;
        OneLocalsArray primary = null;
        while (i2 < iMax) {
            LocalsArray localsArray2 = i2 == i ? localsArray : i2 < size ? this.secondaries.get(i2) : null;
            if (localsArray2 != null) {
                primary = primary == null ? localsArray2.getPrimary() : primary.merge(localsArray2.getPrimary());
            }
            arrayList.add(localsArray2);
            i2++;
        }
        LocalsArraySet localsArraySet = new LocalsArraySet(primary, arrayList);
        localsArraySet.setImmutable();
        return localsArraySet;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(int i, TypeBearer typeBearer) {
        throwIfImmutable();
        this.primary.set(i, typeBearer);
        for (LocalsArray localsArray : this.secondaries) {
            if (localsArray != null) {
                localsArray.set(i, typeBearer);
            }
        }
    }

    @Override // com.android.dx.util.MutabilityControl
    public void setImmutable() {
        this.primary.setImmutable();
        for (LocalsArray localsArray : this.secondaries) {
            if (localsArray != null) {
                localsArray.setImmutable();
            }
        }
        super.setImmutable();
    }

    public LocalsArray subArrayForLabel(int i) {
        return getSecondaryForLabel(i);
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        StringBuilder sb = new StringBuilder("(locals array set; primary)\n");
        sb.append(getPrimary().toHuman());
        sb.append('\n');
        int size = this.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = this.secondaries.get(i);
            if (localsArray != null) {
                sb.append("(locals array set: primary for caller " + Hex.u2(i) + ")\n");
                sb.append(localsArray.getPrimary().toHuman());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public LocalsArraySet merge(LocalsArray localsArray) {
        try {
            LocalsArraySet localsArraySetMergeWithSet = localsArray instanceof LocalsArraySet ? mergeWithSet((LocalsArraySet) localsArray) : mergeWithOne((OneLocalsArray) localsArray);
            localsArraySetMergeWithSet.setImmutable();
            return localsArraySetMergeWithSet;
        } catch (SimException e) {
            e.addContext("underlay locals:");
            annotate(e);
            e.addContext("overlay locals:");
            localsArray.annotate(e);
            throw e;
        }
    }

    public LocalsArraySet(OneLocalsArray oneLocalsArray, ArrayList<LocalsArray> arrayList) {
        super(oneLocalsArray.getMaxLocals() > 0);
        this.primary = oneLocalsArray;
        this.secondaries = arrayList;
    }

    @Override // com.android.dx.cf.code.LocalsArray
    public void set(RegisterSpec registerSpec) {
        set(registerSpec.getReg(), registerSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private LocalsArraySet(LocalsArraySet localsArraySet) {
        super(localsArraySet.getMaxLocals() > 0);
        this.primary = localsArraySet.primary.copy();
        this.secondaries = new ArrayList<>(localsArraySet.secondaries.size());
        int size = localsArraySet.secondaries.size();
        for (int i = 0; i < size; i++) {
            LocalsArray localsArray = localsArraySet.secondaries.get(i);
            if (localsArray == null) {
                this.secondaries.add(null);
            } else {
                this.secondaries.add(localsArray.copy());
            }
        }
    }
}
