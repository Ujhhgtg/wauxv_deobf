package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum MethodStrictness implements ModifierContributor.ForMethod, ModifierContributor.ForType {
    PLAIN(0),
    STRICT(2048);

    private final int mask;

    MethodStrictness(int i) {
        this.mask = i;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public int getMask() {
        return this.mask;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public int getRange() {
        return 2048;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isStrict() {
        return this == STRICT;
    }
}
