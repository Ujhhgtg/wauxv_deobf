package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cts implements ctk {
    public String a;

    public cts(String str) {
        throwIfVar1IsNull(str, "text");
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof cts) && nullSafeIsEqual(this.a, ((cts) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return concat("PlainPlaceholderElement(text=", this.a, ")");
    }
}
