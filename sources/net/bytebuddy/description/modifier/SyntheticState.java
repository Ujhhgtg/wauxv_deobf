package net.bytebuddy.description.modifier;

import net.bytebuddy.description.modifier.ModifierContributor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum SyntheticState implements ModifierContributor.ForType, ModifierContributor.ForModule, ModifierContributor.ForModule.OfRequire, ModifierContributor.ForModule.OfExport, ModifierContributor.ForModule.OfOpen, ModifierContributor.ForMethod, ModifierContributor.ForField, ModifierContributor.ForParameter {
    PLAIN(0),
    SYNTHETIC(4096);

    private final int mask;

    SyntheticState(int i) {
        this.mask = i;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public int getMask() {
        return this.mask;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public int getRange() {
        return 4096;
    }

    @Override // net.bytebuddy.description.modifier.ModifierContributor
    public boolean isDefault() {
        return this == PLAIN;
    }

    public boolean isSynthetic() {
        return this == SYNTHETIC;
    }
}
