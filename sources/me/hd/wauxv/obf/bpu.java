package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bpu extends cbq {
    public Object g;

    public abstract bpu c(Object obj);

    public final void h(Object obj) {
        if (this.g == null) {
            this.g = obj;
            return;
        }
        throw new IllegalStateException(("Instance already set for this resolver \"" + getClass() + "\" of \"" + b() + "(" + this.g + ")\". To prevent problems, the instance object can only be set once in a resolver, otherwise use copy() to reuse the resolver.").toString());
    }
}
