package me.hd.wauxv.obf;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.google.android.material.radiobutton.MaterialRadioButton;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.hd.wauxv.R;
import me.hd.wauxv.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ls implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ls(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        String[] strArrNames;
        switch (this.a) {
            case 0:
                cee ceeVar = (cee) this.b;
                zm zmVar = (zm) this.c;
                lu luVar = lu.a;
                Long lBg = dnq.bg(String.valueOf(ceeVar.c.getText()));
                luVar.s(lBg != null ? lBg.longValue() : 86400L);
                lt.a.t(aaz.ad((Set) zmVar.c));
                return ens.a;
            case 1:
                cit citVar = (cit) this.b;
                bdj bdjVar = (bdj) this.c;
                for (cio cioVar : (Iterable) ((dml) citVar.f.h).c()) {
                    if (beq.p()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + cioVar + " due to fragment " + bdjVar + " viewmodel being cleared");
                    }
                    citVar.k(cioVar);
                }
                return ens.a;
            case 2:
                cnh.ac((MainActivity) this.b, ((bhl) this.c).b);
                return ens.a;
            case 3:
                dfx dfxVar = (dfx) this.b;
                brn brnVar = (brn) this.c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                brnVar.b.getClass();
                bmy.y(brnVar, dfxVar);
                int i = dfxVar.i();
                for (int i2 = 0; i2 < i; i2++) {
                    List listK = dfxVar.k(i2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listK) {
                        if (obj instanceof bsh) {
                            arrayList.add(obj);
                        }
                    }
                    bsh bshVar = (bsh) aaz.s(arrayList);
                    if (bshVar != null && (strArrNames = bshVar.names()) != null) {
                        for (String str : strArrNames) {
                            String str2 = bzo.f(dfxVar.h(), dga.b) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str)) {
                                String str3 = "The suggested name '" + str + "' for " + str2 + ' ' + dfxVar.j(i2) + " is already one of the names for " + str2 + ' ' + dfxVar.j(((Number) bzo.x(linkedHashMap, str)).intValue()) + " in " + dfxVar;
                                bzo.q(str3, "message");
                                throw new bsd(str3);
                            }
                            linkedHashMap.put(str, Integer.valueOf(i2));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? ave.a : linkedHashMap;
            case 4:
                ayc aycVar = new ayc((String) ((dov) ((io) this.b).c).getValue(), (String) this.c);
                String strZ = "WAuxiliary" /* cnb.z(-29381871270698L) */;
                if (strZ.length() == 0) {
                    throw new NoSuchElementException("Char sequence is empty.");
                }
                aycVar.d = new ewo(strZ.charAt(0));
                String str4 = aycVar.b + aycVar.c;
                ConcurrentHashMap concurrentHashMap = ayc.a;
                ayd aydVar = (ayd) concurrentHashMap.get(str4);
                if (aydVar == null) {
                    synchronized (ayc.class) {
                        try {
                            aydVar = (ayd) concurrentHashMap.get(str4);
                            if (aydVar == null) {
                                ayd aydVar2 = new ayd(aycVar.b, aycVar.c, null, aycVar.d, 0);
                                concurrentHashMap.put(str4, aydVar2);
                                aydVar = aydVar2;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                        break;
                    }
                }
                return aydVar;
            case 5:
                cit citVar2 = (cit) this.b;
                cio cioVar2 = (cio) this.c;
                synchronized (citVar2.a) {
                    try {
                        dml dmlVar = citVar2.b;
                        Iterable iterable = (Iterable) dmlVar.c();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : iterable) {
                            if (bzo.f((cio) obj2, cioVar2)) {
                                dmlVar.g(arrayList2);
                            } else {
                                arrayList2.add(obj2);
                            }
                        }
                        dmlVar.g(arrayList2);
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return ens.a;
            case 6:
                cee ceeVar2 = (cee) this.b;
                View view = (View) this.c;
                String strValueOf = String.valueOf(ceeVar2.c.getText());
                if (dnr.bi(strValueOf, "@chatroom" /* cnb.z(-513020958604074L) */)) {
                    Context context = view.getContext();
                    Intent intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /* cnb.z(-89438398970666L) */);
                    intent.putExtra("RoomInfo_Id" /* cnb.z(-95253784689450L) */, strValueOf);
                    context.startActivity(intent);
                } else {
                    Context context2 = view.getContext();
                    Intent intent2 = new Intent();
                    intent2.setClassName(context2, "com.tencent.mm.plugin.profile.ui.ContactInfoUI" /* cnb.z(-89111981456170L) */);
                    intent2.putExtra("Contact_User" /* cnb.z(-89442693937962L) */, strValueOf);
                    context2.startActivity(intent2);
                }
                return ens.a;
            case 7:
                cua cuaVar = (cua) this.b;
                ctx ctxVar = (ctx) this.c;
                cnd.ar(cuaVar).j(R.id.codeFragment, bht.r(new csm("pluginId" /* cnb.z(-418085001493290L) */, ctxVar.f), new csm("pluginPath" /* cnb.z(-417994807180074L) */, ctxVar.b.getAbsolutePath())));
                return ens.a;
            case 8:
                return ((dap) this.b).d((CharSequence) this.c);
            default:
                bqr bqrVar = (bqr) this.b;
                ArrayList arrayList3 = (ArrayList) this.c;
                if (((MaterialRadioButton) bqrVar.e).isChecked()) {
                    dpd.a.r(doz.a.d);
                    dpe.a.t(aaz.ad(arrayList3));
                } else if (((MaterialRadioButton) bqrVar.c).isChecked()) {
                    dpd.a.r(doz.b.d);
                    dpc.a.t(aaz.ad(arrayList3));
                }
                return ens.a;
        }
    }

    public /* synthetic */ ls(cio cioVar, cit citVar, beq beqVar, bdj bdjVar) {
        this.a = 1;
        this.b = citVar;
        this.c = bdjVar;
    }

    public /* synthetic */ ls(cit citVar, cio cioVar, boolean z) {
        this.a = 5;
        this.b = citVar;
        this.c = cioVar;
    }
}
