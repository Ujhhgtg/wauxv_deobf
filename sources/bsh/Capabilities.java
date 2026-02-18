package bsh;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Capabilities implements Supplier<Boolean>, Consumer<Boolean> {
    private static final ThreadLocal<Boolean> ACCESSIBILITY;
    private static final Map<String, Class<?>> classes;
    static final Capabilities instance;
    private volatile boolean accessibility = false;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Unavailable extends UtilEvalError {
        public Unavailable(String str) {
            super(str);
        }

        public Unavailable(String str, Throwable th) {
            super(str, th);
        }
    }

    static {
        Capabilities capabilities = new Capabilities();
        instance = capabilities;
        ACCESSIBILITY = ThreadLocal.withInitial(capabilities);
        classes = new WeakHashMap();
    }

    private Capabilities() {
    }

    public static boolean classExists(String str) {
        Map<String, Class<?>> map = classes;
        if (!map.containsKey(str)) {
            try {
                map.put(str, Class.forName(str));
            } catch (ClassNotFoundException unused) {
                classes.put(str, null);
            }
        }
        return getExisting(str) != null;
    }

    public static Class<?> getExisting(String str) {
        return classes.get(str);
    }

    public static boolean haveAccessibility() {
        return ACCESSIBILITY.get().booleanValue();
    }

    public static boolean haveSwing() {
        return classExists("javax.swing.JButton");
    }

    public static void setAccessibility(boolean z) {
        if (z) {
            String.class.getDeclaredMethods();
            try {
                Field declaredField = String.class.getDeclaredField("value");
                declaredField.setAccessible(true);
                declaredField.setAccessible(false);
            } catch (NoSuchFieldException unused) {
            }
            ACCESSIBILITY.set(Boolean.TRUE);
        } else {
            ACCESSIBILITY.set(Boolean.FALSE);
        }
        BshClassManager.memberCache.clear();
    }

    @Override // java.util.function.Consumer
    public void accept(Boolean bool) {
        this.accessibility = bool.booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.function.Supplier
    public Boolean get() {
        return Boolean.valueOf(this.accessibility);
    }
}
