package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dao extends bgr implements IHasInvokeMethod {
    public static final dao a = new dao(1, bzx.class, "next", "next()Lkotlin/text/MatchResult;", 0);

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        bzx bzxVar = (bzx) obj;
        throwIfVar1IsNull(bzxVar, "p0");
        return bzxVar.g();
    }
}
