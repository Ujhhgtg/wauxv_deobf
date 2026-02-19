package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class agy implements bzs {
    public final /* synthetic */ int a;

    public /* synthetic */ agy(int i) {
        this.a = i;
    }

    /* JADX WARN: Found duplicated region for block: B:51:0x0169  */
    @Override // me.hd.wauxv.obf.bzs
    public final void b(chm chmVar, coi coiVar) {
        boolean z;
        switch (this.a) {
            case 0:
                coi coiVar2 = (drl) coiVar;
                chmVar.y();
                int iAi = chmVar.ai();
                ((dll) chmVar.e).d((char) 160);
                chmVar.at(coiVar2, iAi);
                chmVar.u(coiVar2);
                break;
            case 1:
                bkl bklVar = (bkl) coiVar;
                chmVar.y();
                int iAi2 = chmVar.ai();
                chmVar.ax(bklVar);
                cmz.d.c((aji) chmVar.d, Integer.valueOf(bklVar.d));
                chmVar.at(bklVar, iAi2);
                chmVar.u(bklVar);
                break;
            case 2:
                ((dll) chmVar.e).d(' ');
                break;
            case 3:
                chmVar.y();
                break;
            case 4:
                coi coiVar3 = (csr) coiVar;
                pd pdVar = (pd) coiVar3.i;
                if (pdVar != null) {
                    pd pdVar2 = (pd) pdVar.i;
                    z = pdVar2 instanceof bvu ? ((bvu) pdVar2).e : false;
                }
                if (!z) {
                    chmVar.y();
                }
                int iAi3 = chmVar.ai();
                chmVar.ax(coiVar3);
                cmz.f.c((aji) chmVar.d, Boolean.valueOf(z));
                chmVar.at(coiVar3, iAi3);
                if (!z) {
                    chmVar.u(coiVar3);
                }
                break;
            case 5:
                bvo bvoVar = (bvo) coiVar;
                int iAi4 = chmVar.ai();
                chmVar.ax(bvoVar);
                cmz.e.c((aji) chmVar.d, bvoVar.d);
                chmVar.at(bvoVar, iAi4);
                break;
            case 6:
                coi coiVar4 = (dns) coiVar;
                int iAi5 = chmVar.ai();
                chmVar.ax(coiVar4);
                chmVar.at(coiVar4, iAi5);
                break;
            case 7:
                coi coiVar5 = (auv) coiVar;
                int iAi6 = chmVar.ai();
                chmVar.ax(coiVar5);
                chmVar.at(coiVar5, iAi6);
                break;
            case 8:
                coi coiVar6 = (pj) coiVar;
                chmVar.y();
                int iAi7 = chmVar.ai();
                chmVar.ax(coiVar6);
                chmVar.at(coiVar6, iAi7);
                chmVar.u(coiVar6);
                break;
            case 9:
                aaf aafVar = (aaf) coiVar;
                int iAi8 = chmVar.ai();
                dll dllVar = (dll) chmVar.e;
                StringBuilder sb = dllVar.a;
                sb.append((char) 160);
                sb.append(aafVar.d);
                dllVar.d((char) 160);
                chmVar.at(aafVar, iAi8);
                break;
            case 10:
                aze azeVar = (aze) coiVar;
                aha.b(chmVar, azeVar.g, azeVar.h, azeVar);
                break;
            case 11:
                box boxVar = (box) coiVar;
                aha.b(chmVar, null, boxVar.d, boxVar);
                break;
            case 12:
                dll dllVar2 = (dll) chmVar.e;
                boe boeVar = (boe) coiVar;
                blq blqVar = (blq) chmVar.c;
                pn pnVar = (pn) ((bib) blqVar.e).a.get(boe.class);
                if (pnVar == null) {
                    chmVar.ax(boeVar);
                    break;
                } else {
                    int iAi9 = chmVar.ai();
                    chmVar.ax(boeVar);
                    if (iAi9 == chmVar.ai()) {
                        dllVar2.d((char) 65532);
                    }
                    boolean z2 = boeVar.i instanceof bvo;
                    GifEncoder gifEncoderVar = (GifEncoder) blqVar.d;
                    String str = boeVar.d;
                    gifEncoderVar.getClass();
                    aji ajiVar = (aji) chmVar.d;
                    ResourcesCompat.m.c(ajiVar, str);
                    ResourcesCompat.n.c(ajiVar, Boolean.valueOf(z2));
                    ResourcesCompat.o.c(ajiVar, null);
                    Object objB = pnVar.b(blqVar, ajiVar);
                    StringBuilder sb2 = dllVar2.a;
                    int length = sb2.length();
                    int length2 = sb2.length();
                    if (length > iAi9 && iAi9 >= 0 && length <= length2) {
                        dll.c(dllVar2, objB, iAi9, length);
                        break;
                    }
                }
                break;
            case 13:
                coi coiVar7 = (bwb) coiVar;
                cwa cwaVar = cmz.a;
                int iAi10 = chmVar.ai();
                aji ajiVar2 = (aji) chmVar.d;
                chmVar.ax(coiVar7);
                pd pdVar3 = (pd) coiVar7.i;
                if (pdVar3 instanceof crx) {
                    crx crxVar = (crx) pdVar3;
                    int i = crxVar.d;
                    cwaVar.c(ajiVar2, ahb.b);
                    cmz.c.c(ajiVar2, Integer.valueOf(i));
                    crxVar.d++;
                } else {
                    cwaVar.c(ajiVar2, ahb.a);
                    cwa cwaVar2 = cmz.b;
                    int i2 = 0;
                    for (coi coiVarA = (pd) coiVar7.i; coiVarA != null; coiVarA = coiVarA.a()) {
                        if (coiVarA instanceof bwb) {
                            i2++;
                        }
                    }
                    cwaVar2.c(ajiVar2, Integer.valueOf(i2));
                }
                chmVar.at(coiVar7, iAi10);
                if (coiVar7.m != null) {
                    chmVar.y();
                }
                break;
            default:
                chmVar.y();
                int iAi11 = chmVar.ai();
                chmVar.ax(coiVar);
                chmVar.at(coiVar, iAi11);
                chmVar.u(coiVar);
                break;
        }
    }
}
