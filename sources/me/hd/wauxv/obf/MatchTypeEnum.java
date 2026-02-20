package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public enum MatchTypeEnum {
    Contains(0),
    /* JADX INFO: Fake field, exist only in values array */
    StartsWith(1),
    /* JADX INFO: Fake field, exist only in values array */
    EndsWith(2),
    /* JADX INFO: Fake field, exist only in values array */
    SimilarRegex(3),
    Equals(4);

    public final byte d;

    MatchTypeEnum(int i) {
        this.d = b;
    }
}
