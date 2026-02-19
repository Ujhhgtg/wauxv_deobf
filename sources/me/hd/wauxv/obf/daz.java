package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class daz implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public /* synthetic */ daz(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                FindDexClassMethodDslWrapper findDexClassMethodDslWrapperVar = (FindDexClassMethodDslWrapper) obj;
                findDexClassMethodDslWrapperVar.onClassCallback = new daz(1, this.b, this.c);
                findDexClassMethodDslWrapperVar.onMethodCallback = new cvc(28);
                break;
            default:
                bag bagVar = (bag) obj;
                String[] strArr = {this.b};
                bagVar.getClass();
                bagVar.a = SomeStaticHelpers.ab(strArr);
                zb zbVar = new zb();
                fj fjVar = new fj(1);
                fjVar.d = bzu.Contains;
                fm fmVar = new fm();
                String strZ = "dalvik.annotation.Signature" /* "dalvik.annotation.Signature" /* "dalvik.annotation.Signature" /* "dalvik.annotation.Signature" /* cnb.z(-519794122029866L)   */;
                zb zbVar2 = new zb();
                dne dneVar = dne.Equals;
                zbVar2.j(strZ, dneVar);
                fmVar.a = zbVar2;
                fh fhVar = new fh();
                fhVar.a = new dnf("value" /* "value" /* "value" /* "value" /* cnb.z(-519639503207210L)   */, dneVar, false);
                fj fjVar2 = new fj(0);
                fjVar2.d = bzu.Equals;
                fj.e(fjVar2, "Lcom/tencent/mm/sdk/event/IListener<" /* "Lcom/tencent/mm/sdk/event/IListener<" /* "Lcom/tencent/mm/sdk/event/IListener<" /* "Lcom/tencent/mm/sdk/event/IListener<" /* cnb.z(-519596553534250L)   */);
                fj.e(fjVar2, this.c);
                fj.e(fjVar2, ">;" /* ">;" /* ">;" /* ">;" /* cnb.z(-520021755296554L)   */);
                fk fkVar = new fk();
                fkVar.a = fjVar2;
                fkVar.b = fl.ArrayValue;
                fhVar.b = fkVar;
                fi fiVar = fmVar.b;
                if (fiVar == null) {
                    fiVar = new fi();
                }
                fmVar.b = fiVar;
                List arrayList = fiVar.a;
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                fiVar.a = arrayList;
                arrayList.add(fhVar);
                List arrayList2 = fjVar.b;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                fjVar.b = arrayList2;
                arrayList2.add(fmVar);
                zbVar.d = fjVar;
                bagVar.b = zbVar;
                break;
        }
        return KotlinUnit.INSTANCE;
    }
}
