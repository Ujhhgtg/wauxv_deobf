package net.bytebuddy.jar.asm;

import java.util.Arrays;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConstantDynamic {
    private final Handle bootstrapMethod;
    private final Object[] bootstrapMethodArguments;
    private final String descriptor;
    private final String name;

    public ConstantDynamic(String str, String str2, Handle handle, Object... objArr) {
        this.name = str;
        this.descriptor = str2;
        this.bootstrapMethod = handle;
        this.bootstrapMethodArguments = objArr;
    }

    private static /* synthetic */ String stringConcat$0(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        sb.append(" ");
        sb.append(str3);
        return yg.concatToVar1(sb, " ", str4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConstantDynamic)) {
            return false;
        }
        ConstantDynamic constantDynamic = (ConstantDynamic) obj;
        return this.name.equals(constantDynamic.name) && this.descriptor.equals(constantDynamic.descriptor) && this.bootstrapMethod.equals(constantDynamic.bootstrapMethod) && Arrays.equals(this.bootstrapMethodArguments, constantDynamic.bootstrapMethodArguments);
    }

    public Handle getBootstrapMethod() {
        return this.bootstrapMethod;
    }

    public Object getBootstrapMethodArgument(int i) {
        return this.bootstrapMethodArguments[i];
    }

    public int getBootstrapMethodArgumentCount() {
        return this.bootstrapMethodArguments.length;
    }

    public Object[] getBootstrapMethodArgumentsUnsafe() {
        return this.bootstrapMethodArguments;
    }

    public String getDescriptor() {
        return this.descriptor;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        char cCharAt = this.descriptor.charAt(0);
        return (cCharAt == 'J' || cCharAt == 'D') ? 2 : 1;
    }

    public int hashCode() {
        return ((this.name.hashCode() ^ Integer.rotateLeft(this.descriptor.hashCode(), 8)) ^ Integer.rotateLeft(this.bootstrapMethod.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.bootstrapMethodArguments), 24);
    }

    public String toString() {
        return stringConcat$0(this.name, this.descriptor, String.valueOf(this.bootstrapMethod), Arrays.toString(this.bootstrapMethodArguments));
    }
}
