package com.android.dx.cf.attrib;

import com.android.dx.rop.annotation.AnnotationsList;
import com.android.dx.util.MutabilityException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseParameterAnnotations extends BaseAttribute {
    private final int byteLength;
    private final AnnotationsList parameterAnnotations;

    public BaseParameterAnnotations(String str, AnnotationsList annotationsList, int i) {
        super(str);
        try {
            if (annotationsList.isMutable()) {
                throw new MutabilityException("parameterAnnotations.isMutable()");
            }
            this.parameterAnnotations = annotationsList;
            this.byteLength = i;
        } catch (NullPointerException unused) {
            throw new NullPointerException("parameterAnnotations == null");
        }
    }

    @Override // com.android.dx.cf.iface.Attribute
    public final int byteLength() {
        return this.byteLength + 6;
    }

    public final AnnotationsList getParameterAnnotations() {
        return this.parameterAnnotations;
    }
}
