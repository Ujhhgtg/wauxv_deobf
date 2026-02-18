package net.bytebuddy.jar.asm;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MethodTooLargeException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 6807380416709738314L;
    private final String className;
    private final int codeSize;
    private final String descriptor;
    private final String methodName;

    public MethodTooLargeException(String str, String str2, String str3, int i) {
        super(stringConcat$0(str, str2, str3));
        this.className = str;
        this.methodName = str2;
        this.descriptor = str3;
        this.codeSize = i;
    }

    private static /* synthetic */ String stringConcat$0(String str, String str2, String str3) {
        return "Method too large: " + str + "." + str2 + " " + str3;
    }

    public String getClassName() {
        return this.className;
    }

    public int getCodeSize() {
        return this.codeSize;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public String getMethodName() {
        return this.methodName;
    }
}
