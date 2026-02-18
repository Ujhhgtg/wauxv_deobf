package net.bytebuddy.jar.asm;

import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ClassTooLargeException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = 160715609518896765L;
    private final String className;
    private final int constantPoolCount;

    public ClassTooLargeException(String str, int i) {
        super(stringConcat$0(str));
        this.className = str;
        this.constantPoolCount = i;
    }

    private static /* synthetic */ String stringConcat$0(String str) {
        return yg.k("Class too large: ", str);
    }

    public String getClassName() {
        return this.className;
    }

    public int getConstantPoolCount() {
        return this.constantPoolCount;
    }
}
