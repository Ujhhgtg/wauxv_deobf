package me.hd.wauxv.obf;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class lw extends doi implements bgj {
    public final /* synthetic */ int a;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public /* synthetic */ lw(int i, kotlinx$coroutines$internal$DispatchedContinuation afwVar, int i2) {
        super(i, afwVar);
        this.a = i2;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) throws Throwable {
        ahp ahpVar = (ahp) obj;
        kotlinx$coroutines$internal$DispatchedContinuation afwVar = (kotlinx$coroutines$internal$DispatchedContinuation) obj2;
        switch (this.a) {
            case 0:
                lw lwVar = (lw) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
                lwVar.i(kotlinUnitVar);
                return kotlinUnitVar;
            case 1:
                lw lwVar2 = (lw) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar2 = Kotlin$Unit.INSTANCE;
                lwVar2.i(kotlinUnitVar2);
                return kotlinUnitVar2;
            case 2:
                lw lwVar3 = (lw) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar3 = Kotlin$Unit.INSTANCE;
                lwVar3.i(kotlinUnitVar3);
                return kotlinUnitVar3;
            case 3:
                lw lwVar4 = (lw) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar4 = Kotlin$Unit.INSTANCE;
                lwVar4.i(kotlinUnitVar4);
                return kotlinUnitVar4;
            case 4:
                lw lwVar5 = (lw) h(ahpVar, afwVar);
                Kotlin$Unit kotlinUnitVar5 = Kotlin$Unit.INSTANCE;
                lwVar5.i(kotlinUnitVar5);
                return kotlinUnitVar5;
            case 5:
                return ((lw) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
            default:
                return ((lw) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final kotlinx$coroutines$internal$DispatchedContinuation h(Object obj, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
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
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        switch (i) {
            case 0:
                FastKV.bd(obj);
                baa baaVar = new baa(new bae(StaticHelpers5.a(zo.c()), true, new gi(23)));
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
                                            if (!KotlinHelpers2.ap(fileArrListFiles[i2])) {
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
                    ArrayList arrayList = Logger.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("auto clean: name(" /* "auto clean: name(" /* "auto clean: name(" /* "auto clean: name(" /* cnb.z(-513583599319850L)   */);
                    yg.decryptVar2UsingCnbZAndConcatToVar1(sb, znVar.a, -513523469777706L);
                    sb.append(jCurrentTimeMillis2);
                    sb.append("ms)" /* "ms)" /* "ms)" /* "ms)" /* cnb.z(-513506289908522L)   */);
                    Logger.logD(14, sb.toString());
                }
                return kotlinUnitVar;
            case 1:
                FastKV.bd(obj);
                agp.a.getClass();
                agp.b();
                return kotlinUnitVar;
            case 2:
                FastKV.bd(obj);
                agp.a.getClass();
                agp.b();
                return kotlinUnitVar;
            case 3:
                FastKV.bd(obj);
                agp.a.getClass();
                agp.b();
                return kotlinUnitVar;
            case 4:
                FastKV.bd(obj);
                String strZ = "emoji";
                ArrayList arrayList2 = PanelEmojiHook.someArrayList;
                File[] fileArrListFiles2 = new File(PanelEmojiHook.RESOURCE_DIR, strZ).listFiles();
                if (fileArrListFiles2 != null) {
                    for (File file2 : fileArrListFiles2) {
                        if (file2.isFile()) {
                            List listAg = OtherStaticHelpers.argsToList("png", "jpg", "gif");
                            String name = file2.getName();
                            throwIfVar1IsNull(name, "getName(...)");
                            String lowerCase = dnj
                                    .av('.', name,
                                            "")
                                    .toLowerCase(Locale.ROOT);
                            throwIfVar1IsNull(lowerCase, "toLowerCase(...)" /* "toLowerCase(...)" /* "toLowerCase(...)" /* "toLowerCase(...)" /* cnb.z(-474271763659562L)   */);
                            if (listAg.contains(lowerCase)) {
                                String absolutePath = file2.getAbsolutePath();
                                String strB = EmojiMgrImplHook.getMd5FromPath(absolutePath);
                                Object objB = EmojiInfoStorageDexFind.getEmojiInfoByMd5(strB);
                                StaticHelpers7.toDexMethod(EmojiInfo$MethodSaveEmojiThumb.INSTANCE).invoke(objB, null, Boolean.TRUE);
                                arrayList2.add(StaticHelpers7.toDexConstructor(PanelEmojiHook$ConstructorGroupItemInfo.INSTANCE).newInstance(objB, 2, "" /* "" /* "" /* "" /* cnb.z(-474215929084714L)   */, 0));
                            }
                        }
                    }
                }
                return kotlinUnitVar;
            case 5:
                FastKV.bd(obj);
                return StaticHelpers5.t(cuk.d(), new ex(8));
            default:
                FastKV.bd(obj);
                return StaticHelpers5.t(cuk.d(), new ex(10));
        }
    }
}
