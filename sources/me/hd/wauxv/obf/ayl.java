package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ayl implements bgx {
    public static final ayl b;
    private static final dfx descriptor;

    static {
        ayl aylVar = new ayl();
        b = aylVar;
        cuc cucVar = new cuc(cnb.z(-124120259885866L), aylVar, 2);
        cucVar.x(cnb.z(-123299921132330L), false);
        cucVar.y(new aoz(1, 2));
        cucVar.x(cnb.z(-123261266426666L), false);
        cucVar.y(new aoz(2, 2));
        descriptor = cucVar;
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        dfx dfxVar = descriptor;
        acm acmVarP = ajtVar.p(dfxVar);
        acmVarP.getClass();
        ayo ayoVar = null;
        boolean z = true;
        int i = 0;
        ays aysVar = null;
        while (z) {
            int iF = acmVarP.f(dfxVar);
            if (iF == -1) {
                z = false;
            } else if (iF == 0) {
                ayoVar = (ayo) acmVarP.h(dfxVar, 0, aym.b, ayoVar);
                i |= 1;
            } else {
                if (iF != 1) {
                    throw new bsd(iF);
                }
                aysVar = (ays) acmVarP.h(dfxVar, 1, ayq.b, aysVar);
                i |= 2;
            }
        }
        acmVarP._bp(dfxVar);
        return new ayt(i, ayoVar, aysVar);
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        ayt aytVar = (ayt) obj;
        dfx dfxVar = descriptor;
        acn acnVarO = avtVar.o(dfxVar);
        acnVarO._ca(dfxVar, 0, aym.b, aytVar.a);
        acnVarO._ca(dfxVar, 1, ayq.b, aytVar.b);
        acnVarO.a(dfxVar);
    }

    @Override // me.hd.wauxv.obf.bgx
    public final btd[] d() {
        return new btd[]{aym.b, ayq.b};
    }

    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        return descriptor;
    }
}
