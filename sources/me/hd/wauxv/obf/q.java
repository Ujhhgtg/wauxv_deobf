package me.hd.wauxv.obf;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.plugin.api.callback.PluginCallBack;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ q(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, me.hd.wauxv.obf.dfx] */
    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        Object objX;
        List list;
        List list2;
        ArrayList arrayList;
        Object objX2;
        Object objX3;
        int i = this.a;
        boolean zAb = true;
        boolean z = true;
        int i2 = 8;
        ens ensVar = ens.a;
        ?? r7 = this.b;
        switch (i) {
            case 0:
                return obj == ((r) r7) ? "(this Collection)" : String.valueOf(obj);
            case 1:
                qb qbVar = (qb) r7;
                bmm bmmVar = (bmm) obj;
                bmmVar.getClass();
                try {
                    objX = bmmVar.d()[0];
                    if (objX == null) {
                        objX = null;
                    }
                } catch (Throwable th) {
                    objX = bhu.x(th);
                }
                Integer num = (Integer) (objX instanceof dcx ? null : objX);
                qbVar.setSelectedItemId(num != null ? num.intValue() : 0);
                return ensVar;
            case 2:
                CompoundButton compoundButton = (CompoundButton) r7;
                aek aekVar = (aek) obj;
                if (dnj.ak(((EditText) aekVar.f.getValue()).getText())) {
                    String string = compoundButton.getText().toString();
                    ael aelVar = aekVar.a;
                    if (aelVar == null) {
                        bzo.ar(cnb.z(-395489178549034L));
                        throw null;
                    }
                    if (bzo.f(string, cnb.z(-395471998679850L))) {
                        arrayList = aelVar.c;
                        if (!aelVar.b || arrayList.isEmpty()) {
                            list2 = arrayList;
                            list2 = aelVar.e;
                        }
                    } else {
                        list = (List) aelVar.d.get(string);
                        if (list == null) {
                            list2 = list;
                            list2 = avd.a;
                        }
                    }
                    list2 = list;
                    list2 = arrayList;
                    aekVar.l = new adw(aekVar);
                    ((RecyclerView) aekVar.e.getValue()).setAdapter(aekVar.l);
                    adw.h(aekVar.l, list2);
                } else {
                    aekVar.p(((EditText) aekVar.f.getValue()).getText().toString());
                }
                aekVar.o();
                return ensVar;
            case 3:
                Boolean bool = (Boolean) r7;
                doo dooVar = (doo) obj;
                if (bool.equals(Boolean.TRUE)) {
                    zAb = dnj.ab(dooVar.g(), cnb.z(-22578643073834L), false);
                } else {
                    if (!bool.equals(Boolean.FALSE)) {
                        throw new abt();
                    }
                    if (dnj.ab(dooVar.g(), cnb.z(-22600117910314L), false)) {
                        zAb = false;
                    }
                }
                return Boolean.valueOf(zAb);
            case 4:
                cio cioVar = (cio) obj;
                bzo.q(cioVar, "entry");
                return new acb((beq) r7, z ? 1 : 0, cioVar);
            case 5:
                aki akiVar = (aki) r7;
                bmm bmmVar2 = (bmm) obj;
                bmmVar2.getClass();
                try {
                    objX2 = bmmVar2.d()[0];
                    if (objX2 == null) {
                        objX2 = null;
                    }
                } catch (Throwable th2) {
                    objX2 = bhu.x(th2);
                }
                Object obj2 = objX2 instanceof dcx ? null : objX2;
                if (obj2 != null) {
                    int i3 = bte.a;
                    bmu bmuVarBi = dqc.bi(obj2);
                    bxj bxjVar = bxj.a;
                    cde cdeVarT = bmuVarBi.t();
                    cdeVarT.ab = cnb.z(-493470267472682L);
                    cdk cdkVar = (cdk) aaz.e(cdeVarT.aj());
                    exg exgVar = exg.a;
                    aki akiVarAd = bxjVar.ad(cdkVar, exgVar);
                    bxjVar.y(akiVarAd, new bty(i));
                    akiVarAd.o();
                    cde cdeVarT2 = bmuVarBi.t();
                    cdeVarT2.ab = cnb.z(-492834612312874L);
                    aki akiVarAd2 = bxjVar.ad((cdk) aaz.e(cdeVarT2.aj()), exgVar);
                    bxjVar.y(akiVarAd2, new bty(i2));
                    akiVarAd2.o();
                }
                aki.l(akiVar);
                return ensVar;
            case 6:
                return ((bzw) r7).c(((Integer) obj).intValue());
            case 7:
                bmm bmmVar3 = (bmm) obj;
                int parameterCount = ((Constructor) r7).getParameterCount();
                i = (parameterCount == 13 || parameterCount == 14) ? 8 : 7;
                bmmVar3.getClass();
                try {
                    objX3 = bmmVar3.d()[i];
                    if (objX3 == null) {
                        objX3 = null;
                    }
                } catch (Throwable th3) {
                    objX3 = bhu.x(th3);
                }
                if (objX3 instanceof dcx) {
                    objX3 = null;
                }
                String str = (String) objX3;
                if (str == null) {
                    str = "";
                }
                ek ekVar = new ek(bmmVar3, i, i2);
                cgb.a.getClass();
                ekVar.q(dnr.bo(dnr.bo(dnr.bo(cfz.a.o(), cnb.z(-469414155647786L), str), cnb.z(-469328256301866L), cnb.z(-469293896563498L)), cnb.z(-469302486498090L), cnh.ag(System.currentTimeMillis(), cga.a.o(), null, 2)));
                return ensVar;
            case 8:
                int iIntValue = ((Integer) obj).intValue();
                return r7.j(iIntValue) + ": " + r7.l(iIntValue).b();
            case 9:
                ((PluginCallBack.SendTextCallback) r7).onSvrId((Long) obj);
                return ensVar;
            default:
                Toast.makeText((Context) r7, (String) obj, 0).show();
                return ensVar;
        }
    }
}
