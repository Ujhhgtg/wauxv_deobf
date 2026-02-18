package com.android.dx.io.instructions;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCodeCursor implements CodeCursor {
    private final AddressMap baseAddressMap = new AddressMap();
    private int cursor = 0;

    public final void advance(int i) {
        this.cursor += i;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final int baseAddressForCursor() {
        int i = this.baseAddressMap.get(this.cursor);
        return i >= 0 ? i : this.cursor;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final int cursor() {
        return this.cursor;
    }

    @Override // com.android.dx.io.instructions.CodeCursor
    public final void setBaseAddress(int i, int i2) {
        this.baseAddressMap.put(i, i2);
    }
}
