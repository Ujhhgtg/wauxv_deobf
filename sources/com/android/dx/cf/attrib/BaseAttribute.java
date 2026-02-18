package com.android.dx.cf.attrib;

import com.android.dx.cf.iface.Attribute;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAttribute implements Attribute {
    private final String name;

    public BaseAttribute(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.name = str;
    }

    @Override // com.android.dx.cf.iface.Attribute
    public String getName() {
        return this.name;
    }
}
