package net.bytebuddy.utility;

import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unexpected branching in enum static init block */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class GraalImageCode {
    private static final /* synthetic */ GraalImageCode[] $VALUES;
    private static final boolean ACCESS_CONTROLLER;
    public static final GraalImageCode AGENT;
    public static final GraalImageCode BUILD;
    public static final GraalImageCode NONE;
    public static final GraalImageCode RUNTIME;
    public static final GraalImageCode UNKNOWN;

    @MaybeNull
    private static GraalImageCode current;
    private final boolean defined;
    private final boolean nativeImageExecution;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum ImageCodeContextAction implements PrivilegedAction<GraalImageCode> {
        INSTANCE;

        @Override // java.security.PrivilegedAction
        public GraalImageCode run() {
            Iterator it;
            try {
                Method method = Class.forName("java.lang.management.ManagementFactory").getMethod("getRuntimeMXBean", null);
                it = ((List) method.getReturnType().getMethod("getInputArguments", null).invoke(method.invoke(null, null), null)).iterator();
            } catch (Throwable unused) {
            }
            while (it.hasNext()) {
                if (((String) it.next()).startsWith("-agentlib:native-image-agent")) {
                    return GraalImageCode.AGENT;
                }
                return GraalImageCode.NONE;
            }
            return GraalImageCode.NONE;
        }
    }

    static {
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        GraalImageCode graalImageCode = new GraalImageCode("AGENT", 0, true, false);
        AGENT = graalImageCode;
        GraalImageCode graalImageCode2 = new GraalImageCode("BUILD", 1, true, false);
        BUILD = graalImageCode2;
        GraalImageCode graalImageCode3 = new GraalImageCode("RUNTIME", 2, true, true);
        RUNTIME = graalImageCode3;
        GraalImageCode graalImageCode4 = new GraalImageCode("UNKNOWN", 3, false, false);
        UNKNOWN = graalImageCode4;
        GraalImageCode graalImageCode5 = new GraalImageCode("NONE", 4, false, false);
        NONE = graalImageCode5;
        $VALUES = new GraalImageCode[]{graalImageCode, graalImageCode2, graalImageCode3, graalImageCode4, graalImageCode5};
    }

    private GraalImageCode(String str, int i, boolean z, boolean z2) {
        this.defined = z;
        this.nativeImageExecution = z2;
    }

    @MaybeNull
    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static GraalImageCode getCurrent() {
        GraalImageCode graalImageCode = current;
        if (graalImageCode == null) {
            String str = (String) doPrivileged(new GetSystemPropertyAction("org.graalvm.nativeimage.imagecode"));
            if (str == null) {
                String str2 = (String) doPrivileged(new GetSystemPropertyAction("java.vm.vendor"));
                graalImageCode = (str2 == null || !str2.toLowerCase(Locale.US).contains("graalvm")) ? NONE : (GraalImageCode) doPrivileged(ImageCodeContextAction.INSTANCE);
            } else {
                graalImageCode = str.equalsIgnoreCase("agent") ? AGENT : str.equalsIgnoreCase("runtime") ? RUNTIME : str.equalsIgnoreCase("buildtime") ? BUILD : UNKNOWN;
            }
            current = graalImageCode;
        }
        return graalImageCode;
    }

    public static GraalImageCode valueOf(String str) {
        return (GraalImageCode) Enum.valueOf(GraalImageCode.class, str);
    }

    public static GraalImageCode[] values() {
        return (GraalImageCode[]) $VALUES.clone();
    }

    public boolean isDefined() {
        return this.defined;
    }

    public boolean isNativeImageExecution() {
        return this.nativeImageExecution;
    }

    public <T> T[] sorted(T[] tArr, Comparator<? super T> comparator) {
        if (this.defined) {
            Arrays.sort(tArr, comparator);
        }
        return tArr;
    }
}
