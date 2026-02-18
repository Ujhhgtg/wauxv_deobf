package com.android.dx.rop.code;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ConservativeTranslationAdvice implements TranslationAdvice {
    public static final ConservativeTranslationAdvice THE_ONE = new ConservativeTranslationAdvice();

    private ConservativeTranslationAdvice() {
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public int getMaxOptimalRegisterCount() {
        return Integer.MAX_VALUE;
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public boolean hasConstantOperation(Rop rop, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        return false;
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public boolean requiresSourcesInOrder(Rop rop, RegisterSpecList registerSpecList) {
        return false;
    }
}
