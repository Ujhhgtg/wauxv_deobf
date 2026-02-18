package com.android.dx.cf.iface;

import com.android.dx.util.FixedSizeList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class StdFieldList extends FixedSizeList implements FieldList {
    public StdFieldList(int i) {
        super(i);
    }

    @Override // com.android.dx.cf.iface.FieldList
    public Field get(int i) {
        return (Field) get0(i);
    }

    public void set(int i, Field field) {
        set0(i, field);
    }
}
