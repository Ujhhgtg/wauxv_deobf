package com.umeng.ccg;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface ActionInfo {
    String getModule(Context context);

    String[] getSupportAction(Context context);

    boolean getSwitchState(Context context, String str);

    void onCommand(Context context, String str, Object obj);
}
