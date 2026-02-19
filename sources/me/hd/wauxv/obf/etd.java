package me.hd.wauxv.obf;

import java.io.File;
import java.math.BigInteger;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etd extends doi implements bgj {
    public final /* synthetic */ int a;
    public String d;
    public String e;
    public int f;
    public /* synthetic */ Object o;
    public final /* synthetic */ String p;
    public final /* synthetic */ String r;
    public final /* synthetic */ String s;
    public final /* synthetic */ String t;
    public final /* synthetic */ String u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ etd(String str, String str2, String str3, String str4, String str5, kotlinx$coroutines$internal$DispatchedContinuation afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.p = str;
        this.r = str2;
        this.s = str3;
        this.t = str4;
        this.u = str5;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        kotlinx$coroutines$internal$DispatchedContinuation afwVar = (kotlinx$coroutines$internal$DispatchedContinuation) obj2;
        switch (this.a) {
            case 0:
                break;
        }
        return ((etd) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final kotlinx$coroutines$internal$DispatchedContinuation h(Object obj, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        switch (this.a) {
            case 0:
                etd etdVar = new etd(this.p, this.r, this.s, this.t, this.u, afwVar, 0);
                etdVar.o = obj;
                return etdVar;
            default:
                etd etdVar2 = new etd(this.p, this.r, this.s, this.t, this.u, afwVar, 1);
                etdVar2.o = obj;
                return etdVar2;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Exception {
        String strN;
        Object obj_be;
        String str;
        String strN2;
        Object obj_be2;
        String str2;
        int i = this.a;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        String str3 = this.u;
        String str4 = this.t;
        ahq ahqVar = ahq.a;
        String str5 = this.p;
        String str6 = this.r;
        String str7 = this.s;
        switch (i) {
            case 0:
                ahp ahpVar = (ahp) this.o;
                int i2 = this.f;
                if (i2 == 0) {
                    FastKV.bd(obj);
                    dnc.sendToast(null, 3, "开始下载视频" /* "开始下载视频" /* "开始下载视频" /* cnb.z(-587538641189674L)  */);
                    StringBuilder sb = new StringBuilder();
                    eta etaVar = eta.a;
                    sb.append(etaVar.o());
                    sb.append('/');
                    sb.append(str5);
                    sb.append(SignatureVisitor.SUPER);
                    sb.append(str6);
                    sb.append(SignatureVisitor.SUPER);
                    sb.append(str7);
                    String strH = yg.h(-587508576418602L, sb);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(etaVar.o());
                    sb2.append('/');
                    sb2.append(str5);
                    sb2.append(SignatureVisitor.SUPER);
                    strN = yg.decryptVar3UsingCnbZAndConcatToVar1(sb2, str6, -587469921712938L);
                    String str8 = str4 + str3;
                    int i3 = 4;
                    beo beoVar = new beo(strH, i3);
                    Dispatchers$Default alcVar = aou.a;
                    akq akqVar = akq.f;
                    dob dobVar = new dob();
                    akqVar.getClass();
                    cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new bhn(str8, beoVar, (kotlinx$coroutines$internal$DispatchedContinuation) null, i3)));
                    this.o = null;
                    this.d = strH;
                    this.e = strN;
                    this.f = 1;
                    obj_be = claVar._be(this);
                    if (obj_be == ahqVar) {
                        return ahqVar;
                    }
                    str = strH;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-588998930070314L)  */);
                    }
                    String str9 = this.e;
                    str = this.d;
                    FastKV.bd(obj);
                    strN = str9;
                    obj_be = obj;
                }
                arj.v(str, strN, new BigInteger(str7));
                ((File) obj_be).delete();
                dnc.sendToast(null, 3, "下载视频完成" /* "下载视频完成" /* "下载视频完成" /* cnb.z(-589046174710570L)  */);
                return kotlinUnitVar;
            default:
                ahp ahpVar2 = (ahp) this.o;
                int i4 = this.f;
                if (i4 == 0) {
                    FastKV.bd(obj);
                    dnc.sendToast(null, 3, "开始下载视频" /* "开始下载视频" /* "开始下载视频" /* cnb.z(-611010637462314L)  */);
                    StringBuilder sb3 = new StringBuilder();
                    etf etfVar = etf.a;
                    sb3.append(etfVar.o());
                    sb3.append('/');
                    sb3.append(str5);
                    sb3.append(SignatureVisitor.SUPER);
                    sb3.append(str6);
                    sb3.append(SignatureVisitor.SUPER);
                    sb3.append(str7);
                    String strH2 = yg.h(-610963392822058L, sb3);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(etfVar.o());
                    sb4.append('/');
                    sb4.append(str5);
                    sb4.append(SignatureVisitor.SUPER);
                    strN2 = yg.decryptVar3UsingCnbZAndConcatToVar1(sb4, str6, -610941917985578L);
                    String str10 = str4 + str3;
                    int i5 = 7;
                    beo beoVar2 = new beo(strH2, i5);
                    Dispatchers$Default alcVar2 = aou.a;
                    akq akqVar2 = akq.f;
                    dob dobVar2 = new dob();
                    akqVar2.getClass();
                    cla claVar2 = new cla(ajn.g(ahpVar2, bmy.aa(akqVar2, dobVar2), new bhn(str10, beoVar2, (kotlinx$coroutines$internal$DispatchedContinuation) null, i5)));
                    this.o = null;
                    this.d = strH2;
                    this.e = strN2;
                    this.f = 1;
                    obj_be2 = claVar2._be(this);
                    if (obj_be2 == ahqVar) {
                        return ahqVar;
                    }
                    str2 = strH2;
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-610821658901290L)  */);
                    }
                    String str11 = this.e;
                    str2 = this.d;
                    FastKV.bd(obj);
                    strN2 = str11;
                    obj_be2 = obj;
                }
                arj.v(str2, strN2, new BigInteger(str7));
                ((File) obj_be2).delete();
                dnc.sendToast(null, 3, "下载视频完成" /* "下载视频完成" /* "下载视频完成" /* cnb.z(-610851723672362L)  */);
                return kotlinUnitVar;
        }
    }
}
