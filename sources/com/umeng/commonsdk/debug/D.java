package com.umeng.commonsdk.debug;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class D implements UInterface {
    @Override // com.umeng.commonsdk.debug.UInterface
    public void log(String str, String str2) {
        Log.d(str, str2);
    }
}
