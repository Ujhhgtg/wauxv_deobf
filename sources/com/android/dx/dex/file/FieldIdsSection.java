package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.TreeMap;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FieldIdsSection extends MemberIdsSection {
    private final TreeMap<CstFieldRef, FieldIdItem> fieldIds;

    public FieldIdsSection(DexFile dexFile) {
        super("field_ids", dexFile);
        this.fieldIds = new TreeMap<>();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant == null) {
            throw new NullPointerException("cst == null");
        }
        throwIfNotPrepared();
        FieldIdItem fieldIdItem = this.fieldIds.get((CstFieldRef) constant);
        if (fieldIdItem != null) {
            return fieldIdItem;
        }
        throw new IllegalArgumentException("not found");
    }

    public int indexOf(CstFieldRef cstFieldRef) {
        if (cstFieldRef == null) {
            throw new NullPointerException("ref == null");
        }
        throwIfNotPrepared();
        FieldIdItem fieldIdItem = this.fieldIds.get(cstFieldRef);
        if (fieldIdItem != null) {
            return fieldIdItem.getIndex();
        }
        throw new IllegalArgumentException("not found");
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public synchronized FieldIdItem intern(CstFieldRef cstFieldRef) {
        FieldIdItem fieldIdItem;
        try {
            if (cstFieldRef == null) {
                throw new NullPointerException("field == null");
            }
            throwIfPrepared();
            fieldIdItem = this.fieldIds.get(cstFieldRef);
            if (fieldIdItem == null) {
                fieldIdItem = new FieldIdItem(cstFieldRef);
                this.fieldIds.put(cstFieldRef, fieldIdItem);
            }
        } catch (Throwable th) {
            throw th;
        }
        return fieldIdItem;
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.fieldIds.values();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        throwIfNotPrepared();
        int size = this.fieldIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(4, "field_ids_size:  " + Hex.u4(size));
            dkz.ab(fileOffset, new StringBuilder("field_ids_off:   "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(size);
        annotatedOutput.writeInt(fileOffset);
    }
}
