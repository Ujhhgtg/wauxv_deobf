package me.hd.wauxv.obf;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class SpecificEmojiMatcher implements EmojiMatchCallback {
    public final /* synthetic */ int a;
    public final String targetEmojiText;

    public /* synthetic */ SpecificEmojiMatcher(String str, int i) {
        this.a = i;
        this.targetEmojiText = str;
    }

    @Override // me.hd.wauxv.obf.aui
    public Object getResult() {
        return this;
    }

    @Override // me.hd.wauxv.obf.aui
    public boolean onMatch(CharSequence charSequence, int i, int i2, EmojiMetadata emojiMetadataVar) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.targetEmojiText)) {
            return true;
        }
        emojiMetadataVar.d = (emojiMetadataVar.d & 3) | 4;
        return false;
    }

    public String toString() {
        switch (this.a) {
            case 1:
                return concat(new StringBuilder("<"), this.targetEmojiText, '>');
            default:
                return super.toString();
        }
    }
}
