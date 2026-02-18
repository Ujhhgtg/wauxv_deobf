package com.alibaba.fastjson2.internal.asm;

import net.bytebuddy.description.method.ParameterDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class MethodCollector {
    protected boolean debugInfoPresent;
    private final int ignoreCount;
    private final int paramCount;
    private final StringBuilder result = new StringBuilder();
    private int currentParameter = 0;

    public MethodCollector(int i, int i2) {
        this.ignoreCount = i;
        this.paramCount = i2;
        this.debugInfoPresent = i2 == 0;
    }

    public String getResult() {
        return this.result.length() != 0 ? this.result.substring(1) : "";
    }

    public void visitLocalVariable(String str, int i) {
        int i2 = this.ignoreCount;
        if (i < i2 || i >= i2 + this.paramCount) {
            return;
        }
        if (!(ParameterDescription.NAME_PREFIX + this.currentParameter).equals(str)) {
            this.debugInfoPresent = true;
        }
        this.result.append(',');
        this.result.append(str);
        this.currentParameter++;
    }
}
