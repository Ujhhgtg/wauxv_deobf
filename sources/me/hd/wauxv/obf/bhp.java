package me.hd.wauxv.obf;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.ui.activity.MainActivity;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhp extends doi implements bgj {
    public final /* synthetic */ int a = 0;
    public int d;
    public Object e;
    public Object f;
    public Object o;
    public final /* synthetic */ View.OnCreateContextMenuListener p;

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bhp(String str, byx byxVar, MainActivity mainActivity, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(2, afwVar);
        this.f = str;
        this.o = byxVar;
        this.p = mainActivity;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        kotlinx$coroutines$internal$DispatchedContinuation afwVar = (kotlinx$coroutines$internal$DispatchedContinuation) obj2;
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((bhp) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final kotlinx$coroutines$internal$DispatchedContinuation h(Object obj, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        switch (this.a) {
            case 0:
                bhp bhpVar = new bhp((String) this.f, (byx) this.o, (MainActivity) this.p, afwVar);
                bhpVar.e = obj;
                return bhpVar;
            case 1:
                return new bhp((cua) this.p, afwVar);
            default:
                return new bhp((euh) this.e, (TextView) this.f, (ProgressBar) this.o, (AlertDialog) this.p, afwVar);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Exception {
        Object obj_be;
        bvz bvzVar;
        Object objAk;
        cua cuaVar;
        bvz bvzVar2;
        int i = this.a;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        kotlinx$coroutines$internal$DispatchedContinuation afwVar = null;
        View.OnCreateContextMenuListener onCreateContextMenuListener = this.p;
        ahq ahqVar = ahq.a;
        int i2 = 2;
        switch (i) {
            case 0:
                ahp ahpVar = (ahp) this.e;
                int i3 = this.d;
                if (i3 == 0) {
                    FastKV.bd(obj);
                    String strZ = "https://api.github.com/repos/HdShare/WAuxiliary_Public/releases/latest" /*
                                                                                                            * cnb.z(-
                                                                                                            * 44044889619242L)
                                                                                                            */;
                    Dispatchers$Default alcVar = aou.a;
                    akq akqVar = akq.f;
                    dob dobVar = new dob();
                    akqVar.getClass();
                    cla claVar = new cla(ajn.g(ahpVar, bmy.aa(akqVar, dobVar), new bho(strZ, afwVar, 0)));
                    this.e = null;
                    this.d = 1;
                    obj_be = claVar._be(this);
                    if (obj_be != ahqVar) {
                    }
                    return ahqVar;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /*
                                                                                                           * cnb.z(-
                                                                                                           * 45801531243306L)
                                                                                                           */);
                    }
                    FastKV.bd(obj);
                    return kotlinUnitVar;
                }
                FastKV.bd(obj);
                obj_be = obj;
                JSONObject jSONObject = new JSONObject((String) obj_be);
                String str = (String) this.f;
                byx byxVar = (byx) this.o;
                MainActivity mainActivity = (MainActivity) onCreateContextMenuListener;
                String string = jSONObject.getString("name" /* "name" /* "name" /* cnb.z(-44289702755114L)  */);
                String string2 = jSONObject.getString("html_url" /* "html_url" /* "html_url" /* cnb.z(-45883135621930L)  */);
                String string3 = jSONObject.getString("body" /* "body" /* "body" /* cnb.z(-45861660785450L)  */);
                bhq bhqVar = bhq.a;
                String string4 = jSONObject.getString("published_at" /* "published_at" /* "published_at" /* cnb.z(-45805826210602L)  */);
                bhqVar.getClass();
                String strAg = cnh.ag(Instant.parse(string4).toEpochMilli(), null, null, 3);
                bhl bhlVar = new bhl();
                bhlVar.a = string;
                bhlVar.b = string2;
                bhlVar.c = string3;
                bhlVar.d = strAg;
                if (bhq.b(bhqVar, string).b <= bhq.b(bhqVar, str).b) {
                    return kotlinUnitVar;
                }
                bhn bhnVar = new bhn(byxVar, bhlVar, mainActivity, (kotlinx$coroutines$internal$DispatchedContinuation) null);
                this.e = null;
                this.d = 2;
                Kotlin$Lazy kotlin$LazyVar = doh.a;
                Dispatchers$Default alcVar2 = aou.a;
                if (ajn.ak(bza.a, bhnVar, this) != ahqVar) {
                    return kotlinUnitVar;
                }
                return ahqVar;
            case 1:
                cua cuaVar2 = (cua) onCreateContextMenuListener;
                ArrayList arrayList = cuaVar2.a;
                int i4 = this.d;
                if (i4 == 0) {
                    FastKV.bd(obj);
                    bvzVar = new bvz(10);
                    lw lwVar = new lw(i2, afwVar, 5);
                    this.e = cuaVar2;
                    this.f = bvzVar;
                    this.o = bvzVar;
                    this.d = 1;
                    Kotlin$Lazy kotlin$LazyVar2 = doh.a;
                    Dispatchers$Default alcVar3 = aou.a;
                    objAk = ajn.ak(akq.f, lwVar, this);
                    if (objAk == ahqVar) {
                        return ahqVar;
                    }
                    cuaVar = cuaVar2;
                    bvzVar2 = bvzVar;
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /*
                                                                                                           * cnb.z(-
                                                                                                           * 418836620770090L)
                                                                                                           */);
                    }
                    bvz bvzVar3 = (bvz) this.o;
                    bvzVar2 = (bvz) this.f;
                    cua cuaVar3 = (cua) this.e;
                    FastKV.bd(obj);
                    cuaVar = cuaVar3;
                    bvzVar = bvzVar3;
                    objAk = obj;
                }
                List<ctx> list = (List) objAk;
                StringBuilder sb = new StringBuilder();
                sb.append("插件(" /* "插件(" /* "插件(" /* cnb.z(-418896750312234L)  */);
                sb.append(list.size());
                char c = ')';
                sb.append(')');
                bvzVar.add(new nz(sb.toString()));
                for (ctx ctxVar : list) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((String) ctxVar.g.getValue());
                    sb2.append('(');
                    String strQ = concat(sb2, ctxVar.f, c);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("版本: " /* "版本: " /* "版本: " /* cnb.z(-418913930181418L)  */);
                    yg.decryptVar2UsingCnbZAndConcatToVar1(sb3, (String) ctxVar.i.getValue(), -418858095606570L);
                    sb3.append((String) ctxVar.j.getValue());
                    bvzVar.add(new oa(strQ, sb3.toString(), ctxVar, new aeh(cuaVar, i2, ctxVar)));
                    c = ')';
                }
                throwIfVar1IsNull(bvzVar2, "builder");
                bvzVar2.j();
                bvzVar2.f = true;
                if (bvzVar2.e <= 0) {
                    bvzVar2 = bvz.c;
                }
                if (nullSafeIsEqual(arrayList, bvzVar2)) {
                    return kotlinUnitVar;
                }
                arrayList.clear();
                arrayList.addAll(bvzVar2);
                ((eqi) cuaVar2.b.getValue()).af();
                return kotlinUnitVar;
            default:
                int i5 = this.d;
                if (i5 == 0) {
                    FastKV.bd(obj);
                    euh euhVar = (euh) this.e;
                    TextView textView = (TextView) this.f;
                    ProgressBar progressBar = (ProgressBar) this.o;
                    this.d = 1;
                    if (euhVar.b(textView, progressBar, this) != ahqVar) {
                    }
                    return ahqVar;
                }
                if (i5 != 1) {
                    if (i5 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /*
                                                                                                           * cnb.z(-
                                                                                                           * 81471234636586L)
                                                                                                           */);
                    }
                    FastKV.bd(obj);
                    return kotlinUnitVar;
                }
                FastKV.bd(obj);
                Dispatchers$Default alcVar4 = aou.a;
                Dispatcher2 dispatcher2Var = bza.a;
                zl zlVar = new zl((AlertDialog) onCreateContextMenuListener, null, 1);
                this.d = 2;
                if (ajn.ak(dispatcher2Var, zlVar, this) != ahqVar) {
                    return kotlinUnitVar;
                }
                return ahqVar;
        }
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bhp(cua cuaVar, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(2, afwVar);
        this.p = cuaVar;
    }

    /*
     * JADX WARN: 'super' call moved to the top of the method (can break code
     * semantics)
     */
    public bhp(euh euhVar, TextView textView, ProgressBar progressBar, AlertDialog alertDialog, kotlinx$coroutines$internal$DispatchedContinuation afwVar) {
        super(2, afwVar);
        this.e = euhVar;
        this.f = textView;
        this.o = progressBar;
        this.p = alertDialog;
    }
}
