package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ayq implements bgx {
    public static final ayq b;
    private static final dfx descriptor;

    static {
        ayq ayqVar = new ayq();
        b = ayqVar;
        cuc cucVar = new cuc("me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.FavInfoProto.VoiceInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.FavInfoProto.VoiceInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.FavInfoProto.VoiceInfoProto" /* "me.hd.wauxv.hook.micromsg.core.protobuf.old.proto.FavInfoProto.VoiceInfoProto" /* cnb.z(-125275606088490L)   */, ayqVar, 6);
        cucVar.x("duration" /* "duration" /* "duration" /* "duration" /* cnb.z(-124373662956330L)   */, false);
        cucVar.y(new aoz(10, 2));
        cucVar.x("fileCacheType" /* "fileCacheType" /* "fileCacheType" /* "fileCacheType" /* cnb.z(-124335008250666L)   */, false);
        cucVar.y(new aoz(16, 2));
        cucVar.x("md5Checksum" /* "md5Checksum" /* "md5Checksum" /* "md5Checksum" /* cnb.z(-124257698839338L)   */, false);
        cucVar.y(new aoz(17, 2));
        cucVar.x("fileSize" /* "fileSize" /* "fileSize" /* "fileSize" /* cnb.z(-124790274784042L)   */, false);
        cucVar.y(new aoz(19, 2));
        cucVar.x("fileCacheName" /* "fileCacheName" /* "fileCacheName" /* "fileCacheName" /* cnb.z(-124700080470826L)   */, false);
        cucVar.y(new aoz(20, 2));
        cucVar.x("filePath" /* "filePath" /* "filePath" /* "filePath" /* cnb.z(-124691490536234L)   */, true);
        cucVar.y(new aoz(21, 2));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        int i = 0;
        int iG = 0;
        int iG2 = 0;
        String strD = null;
        String strD2 = null;
        String strD3 = null;
        String str = null;
        boolean z = true;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            switch (iF) {
                case -1:
                    z = false;
                    break;
                case 0:
                    iG = acmVarP.g(dfxVar, 0);
                    i |= 1;
                    break;
                case 1:
                    strD = acmVarP.d(dfxVar, 1);
                    i |= 2;
                    break;
                case 2:
                    strD2 = acmVarP.d(dfxVar, 2);
                    i |= 4;
                    break;
                case 3:
                    iG2 = acmVarP.g(dfxVar, 3);
                    i |= 8;
                    break;
                case 4:
                    strD3 = acmVarP.d(dfxVar, 4);
                    i |= 16;
                    break;
                case 5:
                    str = (String) acmVarP.i(dfxVar, 5, dnh.b, str);
                    i |= 32;
                    break;
                default:
                    throw new bsd(iF);
            }
        }
        acmVarP._bp(dfxVar);
        return new ays(i, iG, strD, strD2, iG2, strD3, str);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ays aysVar = (ays) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        int i = aysVar.a;
        String str = aysVar.f;
        acnVarO.k(0, i, dfxVar);
        acnVarO.l(dfxVar, 1, aysVar.b);
        acnVarO.l(dfxVar, 2, aysVar.c);
        acnVarO.k(3, aysVar.d, dfxVar);
        acnVarO.l(dfxVar, 4, aysVar.e);
        if (acnVarO.f(dfxVar) || str != null) {
            acnVarO.m(dfxVar, 5, dnh.b, str);
        }
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        dnh dnhVar = dnh.b;
        btd btdVarT = aye.t(dnhVar);
        bqj bqjVar = bqj.b;
        return new btd[]{bqjVar, dnhVar, dnhVar, bqjVar, dnhVar, btdVarT};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
