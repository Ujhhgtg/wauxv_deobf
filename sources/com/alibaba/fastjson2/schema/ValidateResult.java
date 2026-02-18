package com.alibaba.fastjson2.schema;

import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ValidateResult {
    final Object[] args;
    final ValidateResult cause;
    final String format;
    String message;
    private final boolean success;

    public ValidateResult(ValidateResult validateResult, String str, Object... objArr) {
        this.success = false;
        this.format = str;
        this.args = objArr;
        this.cause = validateResult;
        if (objArr.length == 0) {
            this.message = str;
        }
    }

    public String getMessage() {
        String str;
        String string = this.message;
        if (string == null && (str = this.format) != null) {
            Object[] objArr = this.args;
            if (objArr.length > 0) {
                string = String.format(str, objArr);
                if (this.cause != null) {
                    StringBuilder sbR = bjs.r(string, "; ");
                    sbR.append(this.cause.getMessage());
                    string = sbR.toString();
                }
                this.message = string;
            }
        }
        return string;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public ValidateResult(boolean z, String str, Object... objArr) {
        this.success = z;
        this.format = str;
        this.args = objArr;
        this.cause = null;
        if (objArr.length == 0) {
            this.message = str;
        }
    }
}
