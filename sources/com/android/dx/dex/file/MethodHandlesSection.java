package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodHandle;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodHandlesSection extends UniformItemSection {
    private final TreeMap<CstMethodHandle, MethodHandleItem> methodHandles;

    public MethodHandlesSection(DexFile dexFile) {
        super("method_handles", dexFile, 8);
        this.methodHandles = new TreeMap<>();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant == null) {
            throw new NullPointerException("cst == null");
        }
        throwIfNotPrepared();
        MethodHandleItem methodHandleItem = this.methodHandles.get((CstMethodHandle) constant);
        if (methodHandleItem != null) {
            return methodHandleItem;
        }
        throw new IllegalArgumentException("not found");
    }

    public int indexOf(CstMethodHandle cstMethodHandle) {
        return this.methodHandles.get(cstMethodHandle).getIndex();
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public synchronized void intern(CstMethodHandle cstMethodHandle) {
        try {
            if (cstMethodHandle == null) {
                throw new NullPointerException("methodHandle == null");
            }
            throwIfPrepared();
            if (this.methodHandles.get(cstMethodHandle) == null) {
                this.methodHandles.put(cstMethodHandle, new MethodHandleItem(cstMethodHandle));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.methodHandles.values();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public void orderItems() {
        Iterator<MethodHandleItem> it = this.methodHandles.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().setIndex(i);
            i++;
        }
    }
}
