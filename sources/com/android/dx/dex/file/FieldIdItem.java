package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstFieldRef;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FieldIdItem extends MemberIdItem {
    public FieldIdItem(CstFieldRef cstFieldRef) {
        super(cstFieldRef);
    }

    @Override // com.android.dx.dex.file.MemberIdItem, com.android.dx.dex.file.IdItem, com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
        super.addContents(dexFile);
        dexFile.getTypeIds().intern(getFieldRef().getType());
    }

    public CstFieldRef getFieldRef() {
        return (CstFieldRef) getRef();
    }

    @Override // com.android.dx.dex.file.MemberIdItem
    public int getTypoidIdx(DexFile dexFile) {
        return dexFile.getTypeIds().indexOf(getFieldRef().getType());
    }

    @Override // com.android.dx.dex.file.MemberIdItem
    public String getTypoidName() {
        return "type_idx";
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_FIELD_ID_ITEM;
    }
}
