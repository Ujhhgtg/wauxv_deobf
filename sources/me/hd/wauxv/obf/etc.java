package me.hd.wauxv.obf;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etc extends doi implements bgj {
    public final /* synthetic */ int a;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String o;
    public final /* synthetic */ JSONObject p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ etc(String str, String str2, JSONObject jSONObject, afw afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.f = str;
        this.o = str2;
        this.p = jSONObject;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                break;
        }
        return ((etc) h(ahpVar, afwVar)).i(ens.a);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                etc etcVar = new etc(this.f, this.o, this.p, afwVar, 0);
                etcVar.e = obj;
                return etcVar;
            default:
                etc etcVar2 = new etc(this.f, this.o, this.p, afwVar, 1);
                etcVar2.e = obj;
                return etcVar2;
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Exception {
        int i = this.a;
        ens ensVar = ens.a;
        JSONObject jSONObject = this.p;
        String str = this.o;
        String str2 = this.f;
        ahq ahqVar = ahq.a;
        afw afwVar = null;
        int i2 = 3;
        switch (i) {
            case 0:
                ahp ahpVar = (ahp) this.e;
                int i3 = this.d;
                if (i3 == 0) {
                    bhu.bd(obj);
                    dnc.g(null, 3, "开始下载视频" /* cnb.z(-587899418442538L) */);
                    StringBuilder sb = new StringBuilder();
                    sb.append(eta.a.o());
                    sb.append('/');
                    sb.append(str2);
                    sb.append(SignatureVisitor.SUPER);
                    String strN = yg.n(sb, str, -587869353671466L);
                    String string = jSONObject.getString("pcdn_url" /* cnb.z(-587882238573354L) */);
                    beo beoVar = new beo(strN, i2);
                    alc alcVar = aou.a;
                    akq akqVar = akq.f;
                    dob dobVar = new dob();
                    akqVar.getClass();
                    cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new bhn(string, beoVar, afwVar, i2)));
                    this.e = null;
                    this.d = 1;
                    obj = claVar._be(this);
                    if (obj == ahqVar) {
                        return ahqVar;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* cnb.z(-587813519096618L) */);
                    }
                    bhu.bd(obj);
                }
                dnc.g(null, 3, "下载视频完成" /* cnb.z(-587860763736874L) */);
                return ensVar;
            default:
                ahp ahpVar2 = (ahp) this.e;
                int i4 = this.d;
                if (i4 == 0) {
                    bhu.bd(obj);
                    dnc.g(null, 3, "开始下载视频" /* cnb.z(-609722147273514L) */);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(etf.a.o());
                    sb2.append('/');
                    sb2.append(str2);
                    sb2.append(SignatureVisitor.SUPER);
                    String strN2 = yg.n(sb2, str, -609743622109994L);
                    String string2 = jSONObject.getString("pcdn_url" /* cnb.z(-609704967404330L) */);
                    int i5 = 6;
                    beo beoVar2 = new beo(strN2, i5);
                    alc alcVar2 = aou.a;
                    akq akqVar2 = akq.f;
                    dob dobVar2 = new dob();
                    akqVar2.getClass();
                    cla claVar2 = new cla(ajn.g(ahpVar2, bmy.aa(akqVar2, dobVar2), new bhn(string2, beoVar2, afwVar, i5)));
                    this.e = null;
                    this.d = 1;
                    obj = claVar2._be(this);
                    if (obj == ahqVar) {
                        return ahqVar;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* cnb.z(-610186003741482L) */);
                    }
                    bhu.bd(obj);
                }
                dnc.g(null, 3, "下载视频完成" /* cnb.z(-610216068512554L) */);
                return ensVar;
        }
    }
}
