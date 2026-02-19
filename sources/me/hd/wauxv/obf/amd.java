package me.hd.wauxv.obf;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class amd implements bfu {
    public final /* synthetic */ int a;

    public /* synthetic */ amd(int i) {
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        List list;
        List list2;
        int i = this.a;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        switch (i) {
            case 0:
                dov dovVar = ajf.a;
                return new eqi(ajf.b(Boolean.TRUE));
            case 2:
                aum.a.u(aun.b);
            case 1:
                return kotlinUnitVar;
            case 3:
                bmo.a.getClass();
                return bmo.getClassLoader();
            case 4:
                azq.a.u(azr.b);
                return kotlinUnitVar;
            case 5:
                File file = new File(bbj.b, "menuItems.json" /* "menuItems.json" /* "menuItems.json" /* cnb.z(-550477368392490L)  */);
                if (file.exists()) {
                    brn brnVar = brn.a;
                    String strC = bad.c(file);
                    brnVar.getClass();
                    list = (List) brnVar.e(new ko(bbe.Companion.serializer()), strC);
                } else {
                    brn brnVar2 = brn.a;
                    List list3 = bbj.c;
                    brnVar2.getClass();
                    bad.e(file, brnVar2.f(new ko(bbe.Companion.serializer()), list3));
                    list = list3;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((bbe) obj).f) {
                        arrayList.add(obj);
                    }
                }
                return aaz.t(arrayList, new ex(5));
            case 6:
                bbg.a.u("#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-550352814340906L)  */);
                bbi.a.u("#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-550327044537130L)  */);
                bbf.a.u("#FF1E1E1E" /* "#FF1E1E1E" /* "#FF1E1E1E" /* cnb.z(-550851030547242L)  */);
                bbh.a.u("#FFF7F7F7" /* "#FFF7F7F7" /* "#FFF7F7F7" /* cnb.z(-550756541266730L)  */);
                return kotlinUnitVar;
            case 7:
                bct.a.u("E HH:mm" /* "E HH:mm" /* "E HH:mm" /* cnb.z(-463714734045994L)  */);
                bcs.a.r(bcr.b.e);
                return kotlinUnitVar;
            case 8:
                return new Handler(Looper.getMainLooper());
            case 9:
                File file2 = new File(biw.c, "groupItems.json" /* "groupItems.json" /* "groupItems.json" /* cnb.z(-590072671894314L)  */);
                if (file2.exists()) {
                    brn brnVar3 = brn.a;
                    String strC2 = bad.c(file2);
                    brnVar3.getClass();
                    list2 = (List) brnVar3.e(new ko(biv.Companion.serializer()), strC2);
                } else {
                    brn brnVar4 = brn.a;
                    List list4 = biw.d;
                    brnVar4.getClass();
                    bad.e(file2, brnVar4.f(new ko(biv.Companion.serializer()), list4));
                    list2 = list4;
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    if (((biv) obj2).e) {
                        arrayList2.add(obj2);
                    }
                }
                return aaz.t(arrayList2, new ex(7));
            case 10:
                zc zcVarB = dal.b(String.class);
                dnh dnhVar = dnh.b;
                return new daj(zcVarB);
            case 11:
                return new bix(new int[] { Color.parseColor(bjh.a.o()), Color.parseColor(bji.a.o()) },
                        Color.parseColor(bjj.a.o()), 12);
            case 12:
                return new bix(new int[] { Color.parseColor(biy.a.o()), Color.parseColor(biz.a.o()) },
                        Color.parseColor(bja.a.o()), 12);
            case 13:
                return new bix(new int[] { Color.parseColor(bjb.a.o()), Color.parseColor(bjc.a.o()) },
                        Color.parseColor(bjd.a.o()), 12);
            case 14:
                return new bix(new int[] { Color.parseColor(bje.a.o()), Color.parseColor(bjf.a.o()) },
                        Color.parseColor(bjg.a.o()), 12);
            case 15:
                bjh.a.u("#FFF9E8C8" /* "#FFF9E8C8" /* "#FFF9E8C8" /* cnb.z(-505547715509034L)  */);
                bji.a.u("#FFFEF3D6" /* "#FFFEF3D6" /* "#FFFEF3D6" /* cnb.z(-505521945705258L)  */);
                bjj.a.u("#FFE87A20" /* "#FFE87A20" /* "#FFE87A20" /* cnb.z(-504946420087594L)  */);
                biy.a.u("#FFA3F0E6" /* "#FFA3F0E6" /* "#FFA3F0E6" /* cnb.z(-504851930807082L)  */);
                biz.a.u("#FFE0F7F4" /* "#FFE0F7F4" /* "#FFE0F7F4" /* cnb.z(-504826161003306L)  */);
                bja.a.u("#FF3AAE9D" /* "#FF3AAE9D" /* "#FF3AAE9D" /* cnb.z(-504800391199530L)  */);
                bjb.a.u("#FFF2D5F8" /* "#FFF2D5F8" /* "#FFF2D5F8" /* cnb.z(-504774621395754L)  */);
                bjc.a.u("#FFF9EBFC" /* "#FFF9EBFC" /* "#FFF9EBFC" /* cnb.z(-504680132115242L)  */);
                bjd.a.u("#FFA64BDB" /* "#FFA64BDB" /* "#FFA64BDB" /* cnb.z(-505204118125354L)  */);
                bje.a.u("#FFD8D8D8" /* "#FFD8D8D8" /* "#FFD8D8D8" /* cnb.z(-505178348321578L)  */);
                bjf.a.u("#FFE0E0E0" /* "#FFE0E0E0" /* "#FFE0E0E0" /* cnb.z(-505152578517802L)  */);
                bjg.a.u("#FF666666" /* "#FF666666" /* "#FF666666" /* cnb.z(-505058089237290L)  */);
                return kotlinUnitVar;
            case 16:
                bjh.a.u("#FFFFD56A" /* "#FFFFD56A" /* "#FFFFD56A" /* cnb.z(-505032319433514L)  */);
                bji.a.u("#FFFFE87A" /* "#FFFFE87A" /* "#FFFFE87A" /* cnb.z(-505006549629738L)  */);
                bjj.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-504980779825962L)  */);
                biy.a.u("#FF4DD5CC" /* "#FF4DD5CC" /* "#FF4DD5CC" /* cnb.z(-502137511476010L)  */);
                biz.a.u("#FF68E8DF" /* "#FF68E8DF" /* "#FF68E8DF" /* cnb.z(-502111741672234L)  */);
                bja.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-502085971868458L)  */);
                bjb.a.u("#FFD0A3FF" /* "#FFD0A3FF" /* "#FFD0A3FF" /* cnb.z(-502060202064682L)  */);
                bjc.a.u("#FFEFBFFF" /* "#FFEFBFFF" /* "#FFEFBFFF" /* cnb.z(-501965712784170L)  */);
                bjd.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-501939942980394L)  */);
                bje.a.u("#FF95A0B8" /* "#FF95A0B8" /* "#FF95A0B8" /* cnb.z(-502463928990506L)  */);
                bjf.a.u("#FFA8B2C9" /* "#FFA8B2C9" /* "#FFA8B2C9" /* cnb.z(-502438159186730L)  */);
                bjg.a.u("#FFFFFFFF" /* "#FFFFFFFF" /* "#FFFFFFFF" /* cnb.z(-502343669906218L)  */);
                return kotlinUnitVar;
            case 17:
                bjv.a.u("#28C445" /* "#28C445" /* "#28C445" /* cnb.z(-508352329153322L)  */);
                bjw.a.u("退出了此群" /* "退出了此群" /* "退出了此群" /* cnb.z(-508317969414954L)  */);
                return kotlinUnitVar;
            case 18:
                int i2 = 0;
                bmu bmuVarBg = dqc.bg(dal.b(Intent.class));
                bmuVarBg.v(true);
                azg azgVarR = bmuVarBg.r();
                azgVarR.ab = "mExtras";
                return (azk) aaz.g(azgVarR.c());
            case 19:
                dov dovVar2 = ajf.a;
                return new eqi(ajf.b(Boolean.FALSE));
            case 20:
                bld.a.t(ble.b);
                return kotlinUnitVar;
            case 21:
                return bsq.d;
            case 22:
                return bsj.d;
            case 23:
                return bsg.d;
            case 24:
                return bsn.d;
            case 25:
                return brr.d;
            case 26:
                return bxv.g();
            case 27:
                return Boolean.valueOf(ReflectionWrapper.g(bth.class.getClassLoader(), "android.os.Build"));
            case 28:
                bxf bxfVar = bxf.a;
                cem cemVar = bxj.c;
                if (cemVar == null) {
                    throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-496249111313194L)  */);
                    throw null;
                }
                bxfVar.q(Float.parseFloat(String.valueOf(cemVar.c.getText())));
                bxg bxgVar = bxg.a;
                cem cemVar2 = bxj.c;
                if (cemVar2 != null) {
                    bxgVar.q(Float.parseFloat(String.valueOf(cemVar2.d.getText())));
                    return kotlinUnitVar;
                }
                throwLateinitPropNotInitYet("binding" /* "binding" /* "binding" /* cnb.z(-496214751574826L)  */);
                throw null;
            default:
                bxf.a.q(31.135633f);
                bxg.a.q(121.66625f);
                return kotlinUnitVar;
        }
    }
}
