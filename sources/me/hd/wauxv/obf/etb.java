package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etb extends doi implements bgj {
    public final /* synthetic */ int a;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String o;
    public final /* synthetic */ String p;
    public final /* synthetic */ String r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ etb(String str, String str2, String str3, String str4, afw afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.f = str;
        this.o = str2;
        this.p = str3;
        this.r = str4;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                break;
        }
        return ((etb) h(ahpVar, afwVar)).i(KotlinUnit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                etb etbVar = new etb(this.f, this.o, this.p, this.r, afwVar, 0);
                etbVar.e = obj;
                return etbVar;
            default:
                etb etbVar2 = new etb(this.f, this.o, this.p, this.r, afwVar, 1);
                etbVar2.e = obj;
                return etbVar2;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        int i = this.a;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        String str = this.r;
        String str2 = this.p;
        String str3 = this.o;
        ahq ahqVar = ahq.a;
        afw afwVar = null;
        String str4 = this.f;
        switch (i) {
            case 0:
                ahp ahpVar = (ahp) this.e;
                int i2 = this.d;
                if (i2 != 0) {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-582676738210602L)  */);
                    }
                    bhu.bd(obj);
                    return kotlinUnitVar;
                }
                bhu.bd(obj);
                dnc.g(null, 3, "开始下载" /* "开始下载" /* "开始下载" /* cnb.z(-582217176709930L)  */ + str4 + "图片" /* "图片" /* "图片" /* cnb.z(-582711097948970L)  */);
                StringBuilder sb = new StringBuilder();
                sb.append(eta.a.o());
                sb.append('/');
                sb.append(str4);
                sb.append(SignatureVisitor.SUPER);
                String strN = yg.decryptVar3UsingCnbZAndConcatToVar1(sb, str3, -582732572785450L);
                String str5 = str2 + str;
                int i3 = 2;
                beo beoVar = new beo(strN, i3);
                alc alcVar = aou.a;
                akq akqVar = akq.f;
                dob dobVar = new dob();
                akqVar.getClass();
                cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new bhn(str5, beoVar, afwVar, i3)));
                this.e = null;
                this.d = 1;
                return claVar._be(this) == ahqVar ? ahqVar : kotlinUnitVar;
            default:
                ahp ahpVar2 = (ahp) this.e;
                int i4 = this.d;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-586907280997162L)  */);
                    }
                    bhu.bd(obj);
                    return kotlinUnitVar;
                }
                bhu.bd(obj);
                dnc.g(null, 3, "开始下载" /* "开始下载" /* "开始下载" /* cnb.z(-586980295441194L)  */ + str4 + "图片" /* "图片" /* "图片" /* cnb.z(-586941640735530L)  */);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(etf.a.o());
                sb2.append('/');
                sb2.append(str4);
                sb2.append(SignatureVisitor.SUPER);
                String strN2 = yg.decryptVar3UsingCnbZAndConcatToVar1(sb2, str3, -586945935702826L);
                String str6 = str2 + str;
                int i5 = 5;
                beo beoVar2 = new beo(strN2, i5);
                alc alcVar2 = aou.a;
                akq akqVar2 = akq.f;
                dob dobVar2 = new dob();
                akqVar2.getClass();
                cla claVar2 = new cla(ajn.g(ahpVar2, bmy.aa(akqVar2, dobVar2), new bhn(str6, beoVar2, afwVar, i5)));
                this.e = null;
                this.d = 1;
                return claVar2._be(this) == ahqVar ? ahqVar : kotlinUnitVar;
        }
    }
}
