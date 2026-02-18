package net.bytebuddy;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ClassFileVersion implements Comparable<ClassFileVersion>, Serializable {
    private static final boolean ACCESS_CONTROLLER;
    protected static final int BASE_VERSION = 44;
    private static final ClassFileVersion[] CLASS_FILE_VERSIONS;
    public static final ClassFileVersion JAVA_V1;
    public static final ClassFileVersion JAVA_V10;
    public static final ClassFileVersion JAVA_V11;
    public static final ClassFileVersion JAVA_V12;
    public static final ClassFileVersion JAVA_V13;
    public static final ClassFileVersion JAVA_V14;
    public static final ClassFileVersion JAVA_V15;
    public static final ClassFileVersion JAVA_V16;
    public static final ClassFileVersion JAVA_V17;
    public static final ClassFileVersion JAVA_V18;
    public static final ClassFileVersion JAVA_V19;
    public static final ClassFileVersion JAVA_V2;
    public static final ClassFileVersion JAVA_V20;
    public static final ClassFileVersion JAVA_V21;
    public static final ClassFileVersion JAVA_V22;
    public static final ClassFileVersion JAVA_V23;
    public static final ClassFileVersion JAVA_V24;
    public static final ClassFileVersion JAVA_V25;
    public static final ClassFileVersion JAVA_V26;
    public static final ClassFileVersion JAVA_V3;
    public static final ClassFileVersion JAVA_V4;
    public static final ClassFileVersion JAVA_V5;
    public static final ClassFileVersion JAVA_V6;
    public static final ClassFileVersion JAVA_V7;
    public static final ClassFileVersion JAVA_V8;
    public static final ClassFileVersion JAVA_V9;
    private static final VersionLocator VERSION_LOCATOR;
    private static final long serialVersionUID = 1;
    private final int versionNumber;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface VersionLocator {
        public static final String EARLY_ACCESS = "-ea";
        public static final String INTERNAL = "-internal";
        public static final String JAVA_VERSION = "java.version";

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Resolved implements VersionLocator {
            private final ClassFileVersion classFileVersion;

            public Resolved(ClassFileVersion classFileVersion) {
                this.classFileVersion = classFileVersion;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((Resolved) obj).classFileVersion);
            }

            public int hashCode() {
                return this.classFileVersion.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                return this.classFileVersion;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public enum Resolver implements PrivilegedAction<VersionLocator> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            public VersionLocator run() {
                Method method;
                try {
                    Class<?> cls = Class.forName(Runtime.class.getName().concat("$Version"));
                    try {
                        try {
                            method = cls.getMethod("feature", null);
                        } catch (NoSuchMethodException unused) {
                            method = cls.getMethod("major", null);
                        }
                        return new Resolved(ClassFileVersion.ofJavaVersion(((Integer) method.invoke(Runtime.class.getMethod("version", null).invoke(null, null), null)).intValue()));
                    } catch (Throwable th) {
                        return new Unresolved(th.getMessage());
                    }
                } catch (Throwable unused2) {
                    String property = System.getProperty(VersionLocator.JAVA_VERSION);
                    if (property == null) {
                        throw new IllegalStateException("Java version property is not set");
                    }
                    if (property.equals("0")) {
                        return new Resolved(ClassFileVersion.JAVA_V6);
                    }
                    if (property.endsWith(VersionLocator.EARLY_ACCESS)) {
                        property = property.substring(0, property.length() - 3);
                    } else if (property.endsWith(VersionLocator.INTERNAL)) {
                        property = property.substring(0, property.length() - 9);
                    }
                    int[] iArr = new int[3];
                    iArr[0] = -1;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    for (int i = 1; i < 3; i++) {
                        int iIndexOf = property.indexOf(46, iArr[i - 1] + 1);
                        iArr[i] = iIndexOf;
                        if (iIndexOf == -1) {
                            throw new IllegalStateException("This JVM's version string does not seem to be valid: " + property);
                        }
                    }
                    return new Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(property.substring(iArr[1] + 1, iArr[2]))));
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @HashCodeAndEqualsPlugin.Enhance
        public static class Unresolved implements VersionLocator {
            private final String message;

            public Unresolved(String str) {
                this.message = str;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode() + (getClass().hashCode() * 31);
            }

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
            }
        }

        ClassFileVersion resolve();
    }

    static {
        boolean z = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z;
        } catch (SecurityException unused2) {
            z = true;
            ACCESS_CONTROLLER = z;
        }
        ClassFileVersion classFileVersion = new ClassFileVersion(196653);
        JAVA_V1 = classFileVersion;
        ClassFileVersion classFileVersion2 = new ClassFileVersion(46);
        JAVA_V2 = classFileVersion2;
        ClassFileVersion classFileVersion3 = new ClassFileVersion(47);
        JAVA_V3 = classFileVersion3;
        ClassFileVersion classFileVersion4 = new ClassFileVersion(48);
        JAVA_V4 = classFileVersion4;
        ClassFileVersion classFileVersion5 = new ClassFileVersion(49);
        JAVA_V5 = classFileVersion5;
        ClassFileVersion classFileVersion6 = new ClassFileVersion(50);
        JAVA_V6 = classFileVersion6;
        ClassFileVersion classFileVersion7 = new ClassFileVersion(51);
        JAVA_V7 = classFileVersion7;
        ClassFileVersion classFileVersion8 = new ClassFileVersion(52);
        JAVA_V8 = classFileVersion8;
        ClassFileVersion classFileVersion9 = new ClassFileVersion(53);
        JAVA_V9 = classFileVersion9;
        ClassFileVersion classFileVersion10 = new ClassFileVersion(54);
        JAVA_V10 = classFileVersion10;
        ClassFileVersion classFileVersion11 = new ClassFileVersion(55);
        JAVA_V11 = classFileVersion11;
        ClassFileVersion classFileVersion12 = new ClassFileVersion(56);
        JAVA_V12 = classFileVersion12;
        ClassFileVersion classFileVersion13 = new ClassFileVersion(57);
        JAVA_V13 = classFileVersion13;
        ClassFileVersion classFileVersion14 = new ClassFileVersion(58);
        JAVA_V14 = classFileVersion14;
        ClassFileVersion classFileVersion15 = new ClassFileVersion(59);
        JAVA_V15 = classFileVersion15;
        ClassFileVersion classFileVersion16 = new ClassFileVersion(60);
        JAVA_V16 = classFileVersion16;
        ClassFileVersion classFileVersion17 = new ClassFileVersion(61);
        JAVA_V17 = classFileVersion17;
        ClassFileVersion classFileVersion18 = new ClassFileVersion(62);
        JAVA_V18 = classFileVersion18;
        ClassFileVersion classFileVersion19 = new ClassFileVersion(63);
        JAVA_V19 = classFileVersion19;
        ClassFileVersion classFileVersion20 = new ClassFileVersion(64);
        JAVA_V20 = classFileVersion20;
        ClassFileVersion classFileVersion21 = new ClassFileVersion(65);
        JAVA_V21 = classFileVersion21;
        ClassFileVersion classFileVersion22 = new ClassFileVersion(66);
        JAVA_V22 = classFileVersion22;
        ClassFileVersion classFileVersion23 = new ClassFileVersion(67);
        JAVA_V23 = classFileVersion23;
        ClassFileVersion classFileVersion24 = new ClassFileVersion(68);
        JAVA_V24 = classFileVersion24;
        ClassFileVersion classFileVersion25 = new ClassFileVersion(69);
        JAVA_V25 = classFileVersion25;
        ClassFileVersion classFileVersion26 = new ClassFileVersion(70);
        JAVA_V26 = classFileVersion26;
        CLASS_FILE_VERSIONS = new ClassFileVersion[]{classFileVersion, classFileVersion2, classFileVersion3, classFileVersion4, classFileVersion5, classFileVersion6, classFileVersion7, classFileVersion8, classFileVersion9, classFileVersion10, classFileVersion11, classFileVersion12, classFileVersion13, classFileVersion14, classFileVersion15, classFileVersion16, classFileVersion17, classFileVersion18, classFileVersion19, classFileVersion20, classFileVersion21, classFileVersion22, classFileVersion23, classFileVersion24, classFileVersion25, classFileVersion26};
        VERSION_LOCATOR = (VersionLocator) doPrivileged(VersionLocator.Resolver.INSTANCE);
    }

    public ClassFileVersion(int i) {
        this.versionNumber = i;
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static ClassFileVersion latest() {
        return JAVA_V26;
    }

    public static ClassFileVersion of(Class<?> cls) {
        return of(cls, ClassFileLocator.ForClassLoader.of(cls.getClassLoader()));
    }

    public static ClassFileVersion ofClassFile(byte[] bArr) {
        if (bArr.length < 7) {
            throw new IllegalArgumentException(yg.m(new StringBuilder("Supplied byte array is too short to be a class file with "), " byte", bArr.length));
        }
        return ofMinorMajor(bArr[7] | (bArr[4] << 24) | (bArr[5] << 16) | (bArr[6] << 8));
    }

    public static ClassFileVersion ofJavaVersion(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(bjs.i(i, "Java version must be positive: "));
        }
        int i2 = i - 1;
        ClassFileVersion[] classFileVersionArr = CLASS_FILE_VERSIONS;
        return i2 < classFileVersionArr.length ? classFileVersionArr[i2] : new ClassFileVersion(i + 44);
    }

    public static ClassFileVersion ofJavaVersionString(String str) {
        int i;
        int iIndexOf = str.indexOf(46);
        try {
            if (iIndexOf == -1) {
                i = Integer.parseInt(str);
            } else {
                int i2 = Integer.parseInt(str.substring(iIndexOf + 1));
                if (Integer.parseInt(str.substring(0, iIndexOf)) != 1 || i2 > 8) {
                    throw new IllegalArgumentException("Java versions with minor version must be of format 1.[1-7]: ".concat(str));
                }
                i = i2;
            }
            return ofJavaVersion(i);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Failed to read Java version from: ".concat(str), e);
        }
    }

    public static ClassFileVersion ofMinorMajor(int i) {
        ClassFileVersion classFileVersion = new ClassFileVersion(i);
        if (classFileVersion.getMajorVersion() <= 0 || classFileVersion.getMajorVersion() > 44) {
            return classFileVersion;
        }
        throw new IllegalArgumentException(yg.f(i, "Class version ", " is not valid"));
    }

    public static ClassFileVersion ofThisVm() {
        return VERSION_LOCATOR.resolve();
    }

    public ClassFileVersion asPreviewVersion() {
        return new ClassFileVersion(this.versionNumber | (-65536));
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.versionNumber == ((ClassFileVersion) obj).versionNumber;
    }

    public int getJavaVersion() {
        return getMajorVersion() - 44;
    }

    public short getMajorVersion() {
        return (short) (this.versionNumber & 65535);
    }

    public int getMinorMajorVersion() {
        return this.versionNumber;
    }

    public short getMinorVersion() {
        return (short) (this.versionNumber >>> 16);
    }

    public int hashCode() {
        return this.versionNumber;
    }

    public boolean isAtLeast(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > -1;
    }

    public boolean isAtMost(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 1;
    }

    public boolean isGreaterThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > 0;
    }

    public boolean isLessThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 0;
    }

    public boolean isPreviewVersion() {
        return (this.versionNumber & (-65536)) == -65536;
    }

    public String toString() {
        return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
    }

    public static ClassFileVersion of(Class<?> cls, ClassFileLocator classFileLocator) {
        return of(TypeDescription.ForLoadedType.of(cls), classFileLocator);
    }

    public static ClassFileVersion ofThisVm(ClassFileVersion classFileVersion) {
        try {
            return ofThisVm();
        } catch (Exception unused) {
            return classFileVersion;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ClassFileVersion classFileVersion) {
        short majorVersion;
        short majorVersion2;
        if (getMajorVersion() == classFileVersion.getMajorVersion()) {
            majorVersion = getMinorVersion();
            majorVersion2 = classFileVersion.getMinorVersion();
        } else {
            majorVersion = getMajorVersion();
            majorVersion2 = classFileVersion.getMajorVersion();
        }
        return Integer.signum(majorVersion - majorVersion2);
    }

    public static ClassFileVersion of(TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return ofClassFile(classFileLocator.locate(typeDescription.getName()).resolve());
    }
}
