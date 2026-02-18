package com.alibaba.fastjson2.reader;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface CharArrayValueConsumer<T> {
    void accept(int i, int i2, char[] cArr, int i3, int i4);

    default void afterRow(int i) {
    }

    default void beforeRow(int i) {
    }

    default void end() {
    }

    default void start() {
    }
}
