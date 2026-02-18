package me.hd.wauxv.obf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class buh {
    public static final buh a;
    public static final buh b;
    public static final buh c;
    public static final buh d;
    public static final buh e;
    public static final /* synthetic */ buh[] f;

    static {
        buh buhVar = new buh("DESTROYED", 0);
        a = buhVar;
        buh buhVar2 = new buh("INITIALIZED", 1);
        b = buhVar2;
        buh buhVar3 = new buh("CREATED", 2);
        c = buhVar3;
        buh buhVar4 = new buh("STARTED", 3);
        d = buhVar4;
        buh buhVar5 = new buh("RESUMED", 4);
        e = buhVar5;
        f = new buh[]{buhVar, buhVar2, buhVar3, buhVar4, buhVar5};
    }

    public static buh valueOf(String str) {
        return (buh) Enum.valueOf(buh.class, str);
    }

    public static buh[] values() {
        return (buh[]) f.clone();
    }
}
