package com.android.dx.io.instructions;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AddressMap {
    private final HashMap<Integer, Integer> map = new HashMap<>();

    public int get(int i) {
        Integer num = this.map.get(Integer.valueOf(i));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public void put(int i, int i2) {
        this.map.put(Integer.valueOf(i), Integer.valueOf(i2));
    }
}
