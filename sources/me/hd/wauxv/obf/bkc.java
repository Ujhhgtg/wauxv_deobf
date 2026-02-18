package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bkc {
    public static final bkc a;
    public static final /* synthetic */ btc[] b;
    public static final jx c;
    public static final jx d;
    public static final dov e;

    static {
        cwb cwbVar = new cwb(bkc.class, "ActivityThreadClass", "getActivityThreadClass()Ljava/lang/Class;");
        dal.a.getClass();
        b = new btc[]{cwbVar, new cwb(bkc.class, "ClientTransactionClass", "getClientTransactionClass()Ljava/lang/Class;")};
        a = new bkc();
        c = zf.h("android.app.ActivityThread", null, 6);
        d = zf.h("android.app.servertransaction.ClientTransaction", null, 6);
        e = new dov(new amd(18));
    }
}
