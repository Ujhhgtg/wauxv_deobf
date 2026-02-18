package me.hd.wauxv.obf;

import android.content.ContentValues;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface IDatabaseOperationsListener {
    default void j(HookParamWrapper hookParam, String str, ContentValues contentValues, String str2, String[] strArr,
            int i) {
    }

    default void l(HookParamWrapper hookParam, String str, ContentValues contentValues, String str2, String[] strArr,
            int i) {
    }

    default void n(HookParamWrapper hookParam, String str) {
    }

    default void s(String str, ContentValues contentValues) {
    }

    default void t(HookParamWrapper hookParam, String str) {
    }
}
