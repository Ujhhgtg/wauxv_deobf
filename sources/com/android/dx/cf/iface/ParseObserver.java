package com.android.dx.cf.iface;

import com.android.dx.util.ByteArray;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ParseObserver {
    void changeIndent(int i);

    void endParsingMember(ByteArray byteArray, int i, String str, String str2, Member member);

    void parsed(ByteArray byteArray, int i, int i2, String str);

    void startParsingMember(ByteArray byteArray, int i, String str, String str2);
}
