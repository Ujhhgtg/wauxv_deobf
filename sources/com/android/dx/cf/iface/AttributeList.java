package com.android.dx.cf.iface;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AttributeList {
    int byteLength();

    Attribute findFirst(String str);

    Attribute findNext(Attribute attribute);

    Attribute get(int i);

    boolean isMutable();

    int size();
}
