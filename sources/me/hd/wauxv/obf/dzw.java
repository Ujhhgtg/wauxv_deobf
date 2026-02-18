package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dzw implements bgx {
    public static final dzw b;
    private static final dfx descriptor;

    static {
        dzw dzwVar = new dzw();
        b = dzwVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.TimeLineObjectProto.lk0Proto" /* cnb.z(-223449968540458L) */, dzwVar, 6);
        bjs.y(-223711961545514L, cucVar, false, 1);
        bjs.y(-223638947101482L, cucVar, false, 2);
        bjs.y(-223557342722858L, cucVar, false, 3);
        bjs.y(-223497213180714L, cucVar, false, 4);
        bjs.y(-220692599536426L, cucVar, false, 5);
        bjs.y(-220606700190506L, cucVar, false, 6);
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        Long l = null;
        String str4 = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    str = (String) acmVarP.i(dfxVar, 0, dnh.b, str);
                    i |= 1;
                    break;
                case 1:
                    str2 = (String) acmVarP.i(dfxVar, 1, dnh.b, str2);
                    i |= 2;
                    break;
                case 2:
                    str3 = (String) acmVarP.i(dfxVar, 2, dnh.b, str3);
                    i |= 4;
                    break;
                case 3:
                    num = (Integer) acmVarP.i(dfxVar, 3, bqj.b, num);
                    i |= 8;
                    break;
                case 4:
                    l = (Long) acmVarP.i(dfxVar, 4, bya.b, l);
                    i |= 16;
                    break;
                case 5:
                    str4 = (String) acmVarP.i(dfxVar, 5, dnh.b, str4);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new dzy(i, str, str2, str3, num, l, str4);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        dzy dzyVar = (dzy) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        dnh dnhVar = dnh.b;
        acnVarO.m(dfxVar, 0, dnhVar, dzyVar.a);
        acnVarO.m(dfxVar, 1, dnhVar, dzyVar.b);
        acnVarO.m(dfxVar, 2, dnhVar, dzyVar.c);
        acnVarO.m(dfxVar, 3, bqj.b, dzyVar.d);
        acnVarO.m(dfxVar, 4, bya.b, dzyVar.e);
        acnVarO.m(dfxVar, 5, dnhVar, dzyVar.f);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        return new btd[]{aye.t(dnhVar), aye.t(dnhVar), aye.t(dnhVar), aye.t(bqj.b), aye.t(bya.b), aye.t(dnhVar)};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
