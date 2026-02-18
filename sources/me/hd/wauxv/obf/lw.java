package me.hd.wauxv.obf;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lw extends doi implements bgj {
    public final /* synthetic */ int a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public /* synthetic */ lw(int i, afw afwVar, int i2) {
        super(i, afwVar);
        this.a = i2;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws Throwable {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                lw lwVar = (lw) h(ahpVar, afwVar);
                ens ensVar = ens.a;
                lwVar.i(ensVar);
                return ensVar;
            case 1:
                lw lwVar2 = (lw) h(ahpVar, afwVar);
                ens ensVar2 = ens.a;
                lwVar2.i(ensVar2);
                return ensVar2;
            case 2:
                lw lwVar3 = (lw) h(ahpVar, afwVar);
                ens ensVar3 = ens.a;
                lwVar3.i(ensVar3);
                return ensVar3;
            case 3:
                lw lwVar4 = (lw) h(ahpVar, afwVar);
                ens ensVar4 = ens.a;
                lwVar4.i(ensVar4);
                return ensVar4;
            case 4:
                lw lwVar5 = (lw) h(ahpVar, afwVar);
                ens ensVar5 = ens.a;
                lwVar5.i(ensVar5);
                return ensVar5;
            case 5:
                return ((lw) h(ahpVar, afwVar)).i(ens.a);
            default:
                return ((lw) h(ahpVar, afwVar)).i(ens.a);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                return new lw(2, afwVar, 0);
            case 1:
                return new lw(2, afwVar, 1);
            case 2:
                return new lw(2, afwVar, 2);
            case 3:
                return new lw(2, afwVar, 3);
            case 4:
                return new lw(2, afwVar, 4);
            case 5:
                return new lw(2, afwVar, 5);
            default:
                return new lw(2, afwVar, 6);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        int i = this.a;
        ens ensVar = ens.a;
        switch (i) {
            case 0:
                bhu.bd(obj);
                baa baaVar = new baa(new bae(aaz.a(zo.c()), true, new gi(23)));
                while (baaVar.hasNext()) {
                    zn znVar = (zn) baaVar.next();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Iterator it = znVar.b.iterator();
                    while (it.hasNext()) {
                        File file = new File((String) it.next());
                        if (file.exists()) {
                            if (!file.isFile()) {
                                File[] fileArrListFiles = file.listFiles();
                                if (fileArrListFiles != null) {
                                    int length = fileArrListFiles.length;
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            if (!cnd.ap(fileArrListFiles[i2])) {
                                            }
                                            i2++;
                                            break;
                                        }
                                    }
                                }
                                file.delete();
                            } else {
                                file.delete();
                            }
                            break;
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                    ArrayList arrayList = ewq.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("auto clean: name(" /* cnb.z(-513583599319850L) */);
                    yg.u(sb, znVar.a, -513523469777706L);
                    sb.append(jCurrentTimeMillis2);
                    sb.append("ms)" /* cnb.z(-513506289908522L) */);
                    ewq.d(14, sb.toString());
                }
                return ensVar;
            case 1:
                bhu.bd(obj);
                agp.a.getClass();
                agp.b();
                return ensVar;
            case 2:
                bhu.bd(obj);
                agp.a.getClass();
                agp.b();
                return ensVar;
            case 3:
                bhu.bd(obj);
                agp.a.getClass();
                agp.b();
                return ensVar;
            case 4:
                bhu.bd(obj);
                csq csqVar = csq.a;
                String strZ = "emoji" /* cnb.z(-474967548361514L) */;
                ArrayList arrayList2 = csq.r;
                csqVar.getClass();
                File[] fileArrListFiles2 = new File(csq.b, strZ).listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file2 : fileArrListFiles2) {
                        if (file2.isFile()) {
                            List listAg = aba.ag("png" /* cnb.z(-474357663005482L) */, "jpg" /*
                                                                                              * cnb.z(-474306123397930L)
                                                                                              */, "gif" /*
                                                                                                         * cnb.z(-
                                                                                                         * 474323303267114L)
                                                                                                         */);
                            String name = file2.getName();
                            throwIfVar1IsNull(name, "getName(...)");
                            String lowerCase = dnj
                                    .av(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, name,
                                            "")
                                    .toLowerCase(Locale.ROOT);
                            throwIfVar1IsNull(lowerCase, "toLowerCase(...)" /* cnb.z(-474271763659562L) */);
                            if (listAg.contains(lowerCase)) {
                                auh auhVar = auh.a;
                                String absolutePath = file2.getAbsolutePath();
                                auhVar.getClass();
                                String strB = auh.b(absolutePath);
                                aub.a.getClass();
                                Object objB = aub.b(strB);
                                atz.a.getClass();
                                emn.bb(aty.a).invoke(objB, null, Boolean.TRUE);
                                arrayList2
                                        .add(emn.ba(csn.a).newInstance(objB, 2, "" /* cnb.z(-474215929084714L) */, 0));
                            }
                        }
                    }
                }
                return ensVar;
            case 5:
                bhu.bd(obj);
                return aaz.t(cuk.d(), new ex(8));
            default:
                bhu.bd(obj);
                return aaz.t(cuk.d(), new ex(10));
        }
    }
}
