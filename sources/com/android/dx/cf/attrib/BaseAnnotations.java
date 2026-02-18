package com.android.dx.cf.attrib;

import com.android.dx.rop.annotation.Annotations;
import com.android.dx.util.MutabilityException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAnnotations extends BaseAttribute {
    private final Annotations annotations;
    private final int byteLength;

    public BaseAnnotations(String str, Annotations annotations, int i) {
        super(str);
        try {
            if (annotations.isMutable()) {
                throw new MutabilityException("annotations.isMutable()");
            }
            this.annotations = annotations;
            this.byteLength = i;
        } catch (NullPointerException unused) {
            throw new NullPointerException("annotations == null");
        }
    }

    @Override // com.android.dx.cf.iface.Attribute
    public final int byteLength() {
        return this.byteLength + 6;
    }

    public final Annotations getAnnotations() {
        return this.annotations;
    }
}
