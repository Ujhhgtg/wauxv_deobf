package net.bytebuddy.utility;

import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.AsmClassReader;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class OpenedClassReader implements AsmClassReader.Factory {
    private static final boolean ACCESS_CONTROLLER;
    public static final int ASM_API;
    public static final boolean EXPERIMENTAL;
    public static final String EXPERIMENTAL_PROPERTY = "net.bytebuddy.experimental";
    public static final String PROCESSOR_PROPERTY = "net.bytebuddy.processor";

    static {
        boolean z = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        try {
            z = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(EXPERIMENTAL_PROPERTY)));
        } catch (Exception unused3) {
        }
        EXPERIMENTAL = z;
        ASM_API = Opcodes.ASM9;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassReader of(byte[] bArr) {
        return of(bArr, EXPERIMENTAL);
    }

    @Override // net.bytebuddy.utility.AsmClassReader.Factory
    public AsmClassReader make(byte[] bArr) {
        return new AsmClassReader.ForAsm(of(bArr));
    }

    public static ClassReader of(byte[] bArr, boolean z) {
        ClassFileVersion classFileVersionOfClassFile = ClassFileVersion.ofClassFile(bArr);
        ClassFileVersion classFileVersionLatest = ClassFileVersion.latest();
        if (!classFileVersionOfClassFile.isGreaterThan(classFileVersionLatest)) {
            return new ClassReader(bArr);
        }
        if (!z) {
            throw new IllegalArgumentException(classFileVersionOfClassFile + " is not supported by the current version of Byte Buddy which officially supports " + classFileVersionLatest + " - update Byte Buddy or set net.bytebuddy.experimental as a VM property");
        }
        bArr[4] = (byte) (classFileVersionLatest.getMinorVersion() >>> 8);
        bArr[5] = (byte) classFileVersionLatest.getMinorVersion();
        bArr[6] = (byte) (classFileVersionLatest.getMajorVersion() >>> 8);
        bArr[7] = (byte) classFileVersionLatest.getMajorVersion();
        ClassReader classReader = new ClassReader(bArr);
        bArr[4] = (byte) (classFileVersionOfClassFile.getMinorVersion() >>> 8);
        bArr[5] = (byte) classFileVersionOfClassFile.getMinorVersion();
        bArr[6] = (byte) (classFileVersionOfClassFile.getMajorVersion() >>> 8);
        bArr[7] = (byte) classFileVersionOfClassFile.getMajorVersion();
        return classReader;
    }

    @Override // net.bytebuddy.utility.AsmClassReader.Factory
    public AsmClassReader make(byte[] bArr, boolean z) {
        return new AsmClassReader.ForAsm(of(bArr, z));
    }
}
