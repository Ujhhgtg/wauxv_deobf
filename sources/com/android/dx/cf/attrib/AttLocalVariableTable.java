package com.android.dx.cf.attrib;

import com.android.dx.cf.code.LocalVariableList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class AttLocalVariableTable extends BaseLocalVariables {
    public static final String ATTRIBUTE_NAME = "LocalVariableTable";

    public AttLocalVariableTable(LocalVariableList localVariableList) {
        super(ATTRIBUTE_NAME, localVariableList);
    }
}
