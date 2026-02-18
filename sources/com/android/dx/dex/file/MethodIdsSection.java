package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;
import java.util.TreeMap;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodIdsSection extends MemberIdsSection {
    private final TreeMap<CstBaseMethodRef, MethodIdItem> methodIds;

    public MethodIdsSection(DexFile dexFile) {
        super("method_ids", dexFile);
        this.methodIds = new TreeMap<>();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant == null) {
            throw new NullPointerException("cst == null");
        }
        throwIfNotPrepared();
        MethodIdItem methodIdItem = this.methodIds.get((CstBaseMethodRef) constant);
        if (methodIdItem != null) {
            return methodIdItem;
        }
        throw new IllegalArgumentException("not found");
    }

    public int indexOf(CstBaseMethodRef cstBaseMethodRef) {
        if (cstBaseMethodRef == null) {
            throw new NullPointerException("ref == null");
        }
        throwIfNotPrepared();
        MethodIdItem methodIdItem = this.methodIds.get(cstBaseMethodRef);
        if (methodIdItem != null) {
            return methodIdItem.getIndex();
        }
        throw new IllegalArgumentException("not found");
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public synchronized MethodIdItem intern(CstBaseMethodRef cstBaseMethodRef) {
        MethodIdItem methodIdItem;
        try {
            if (cstBaseMethodRef == null) {
                throw new NullPointerException("method == null");
            }
            throwIfPrepared();
            methodIdItem = this.methodIds.get(cstBaseMethodRef);
            if (methodIdItem == null) {
                methodIdItem = new MethodIdItem(cstBaseMethodRef);
                this.methodIds.put(cstBaseMethodRef, methodIdItem);
            }
        } catch (Throwable th) {
            throw th;
        }
        return methodIdItem;
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.methodIds.values();
    }

    public void writeHeaderPart(AnnotatedOutput annotatedOutput) {
        throwIfNotPrepared();
        int size = this.methodIds.size();
        int fileOffset = size == 0 ? 0 : getFileOffset();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(4, "method_ids_size: " + Hex.u4(size));
            dkz.ab(fileOffset, new StringBuilder("method_ids_off:  "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(size);
        annotatedOutput.writeInt(fileOffset);
    }
}
