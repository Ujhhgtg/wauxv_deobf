package com.android.dx.util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AnnotatedOutput extends Output {
    void annotate(int i, String str);

    void annotate(String str);

    boolean annotates();

    void endAnnotation();

    int getAnnotationWidth();

    boolean isVerbose();
}
