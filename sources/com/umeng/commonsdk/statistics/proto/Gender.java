package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.cl;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum Gender implements cl {
    MALE(0),
    FEMALE(1),
    UNKNOWN(2);

    private final int value;

    Gender(int i) {
        this.value = i;
    }

    public static Gender findByValue(int i) {
        if (i == 0) {
            return MALE;
        }
        if (i == 1) {
            return FEMALE;
        }
        if (i != 2) {
            return null;
        }
        return UNKNOWN;
    }

    @Override // com.umeng.analytics.pro.cl
    public int getValue() {
        return this.value;
    }
}
