package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class InstanceResolver extends MemberWrapper {
    public Object boundInstance;

    public abstract InstanceResolver copy(Object obj);

    public final void bindInstance(Object obj) {
        if (this.boundInstance == null) {
            this.boundInstance = obj;
            return;
        }
        throw new IllegalStateException(("Instance already set for this resolver \"" + getClass() + "\" of \"" + getMember() + "(" + this.boundInstance + ")\". To prevent problems, the instance object can only be set once in a resolver, otherwise use copy() to reuse the resolver.").toString());
    }
}
