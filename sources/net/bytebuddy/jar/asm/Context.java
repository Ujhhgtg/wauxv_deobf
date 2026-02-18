package net.bytebuddy.jar.asm;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class Context {
    Attribute[] attributePrototypes;
    char[] charBuffer;
    int currentFrameLocalCount;
    int currentFrameLocalCountDelta;
    Object[] currentFrameLocalTypes;
    int currentFrameOffset;
    int currentFrameStackCount;
    Object[] currentFrameStackTypes;
    int currentFrameType;
    Label[] currentLocalVariableAnnotationRangeEnds;
    int[] currentLocalVariableAnnotationRangeIndices;
    Label[] currentLocalVariableAnnotationRangeStarts;
    int currentMethodAccessFlags;
    String currentMethodDescriptor;
    Label[] currentMethodLabels;
    String currentMethodName;
    int currentTypeAnnotationTarget;
    TypePath currentTypeAnnotationTargetPath;
    int parsingOptions;
}
