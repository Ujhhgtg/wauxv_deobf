package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HeaderSection extends UniformItemSection {
    private final List<HeaderItem> list;

    public HeaderSection(DexFile dexFile) {
        super(null, dexFile, 4);
        HeaderItem headerItem = new HeaderItem();
        headerItem.setIndex(0);
        this.list = Collections.singletonList(headerItem);
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        return null;
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.list;
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public void orderItems() {
    }
}
