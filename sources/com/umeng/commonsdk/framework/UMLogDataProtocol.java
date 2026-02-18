package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface UMLogDataProtocol {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
