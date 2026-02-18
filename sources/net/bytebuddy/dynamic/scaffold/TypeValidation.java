package net.bytebuddy.dynamic.scaffold;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum TypeValidation {
    ENABLED(true),
    DISABLED(false);

    private final boolean enabled;

    TypeValidation(boolean z) {
        this.enabled = z;
    }

    public static TypeValidation of(boolean z) {
        return z ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
