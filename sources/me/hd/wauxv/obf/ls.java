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
                lt.a.t(StaticHelpers5.ad((Set) zmVar.c));
                return KotlinUnit.INSTANCE;
            case 1:
                cit citVar = (cit) this.b;
                SomeFragmentManager someFragmentManagerVar = (SomeFragmentManager) this.c;
                for (cio cioVar : (Iterable) ((dml) citVar.f.obj).c()) {
                    if (beq.p()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + cioVar
                                + " due to fragment " + someFragmentManagerVar + " viewmodel being cleared");
                    }
                    citVar.k(cioVar);
                }
                return KotlinUnit.INSTANCE;
            case 2:
                cnh.ac((MainActivity) this.b, ((bhl) this.c).b);
                return KotlinUnit.INSTANCE;
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
                    bsh bshVar = (bsh) StaticHelpers5.s(arrayList);
                    if (bshVar != null && (strArrNames = bshVar.names()) != null) {
                        for (String str : strArrNames) {
                            String str2 = nullSafeIsEqual(dfxVar.h(), dga.b) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str)) {
                                String str3 = "The suggested name '" + str + "' for " + str2 + ' ' + dfxVar.j(i2)
                                        + " is already one of the names for " + str2 + ' '
                                        + dfxVar.j(((Number) KotlinHelpers.x(linkedHashMap, str)).intValue()) + " in "
                                        + dfxVar;
                                throwIfVar1IsNull(str3, "message");
                                throw new bsd(str3);
                            }
                            linkedHashMap.put(str, Integer.valueOf(i2));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? EmptyReadonlyMap.INSTANCE : linkedHashMap;
            case 4:
                ayc aycVar = new ayc((String) ((Kotlin$Lazy) ((DefaultConfig) this.b).c).getValue(), (String) this.c);
                String strZ = "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* "WAuxiliary" /* cnb.z(-29381871270698L)   */;
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
                            if (nullSafeIsEqual((cio) obj2, cioVar2)) {
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
                return KotlinUnit.INSTANCE;
            case 6:
                cee ceeVar2 = (cee) this.b;
                View view = (View) this.c;
                String strValueOf = String.valueOf(ceeVar2.c.getText());
                if (dnr.bi(strValueOf, "@chatroom" /* "@chatroom" /* "@chatroom" /* "@chatroom" /* cnb.z(-513020958604074L)   */)) {
                    Context context = view.getContext();
                    Intent intent = new Intent();
                    intent.setClassName(context, "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /*
                                                                                              * "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /* "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /* "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /* cnb.z(-89438398970666L)  */
                                                                                              */);
                    intent.putExtra("RoomInfo_Id" /* "RoomInfo_Id" /* "RoomInfo_Id" /* "RoomInfo_Id" /* cnb.z(-95253784689450L)   */, strValueOf);
                    context.startActivity(intent);
                } else {
                    Context context2 = view.getContext();
                    Intent intent2 = new Intent();
                    intent2.setClassName(context2, "com.tencent.mm.plugin.profile.ui.ContactInfoUI" /*
                                                                                                     * cnb.z(-
                                                                                                     * 89111981456170L)
                                                                                                     */);
                    intent2.putExtra("Contact_User" /* "Contact_User" /* "Contact_User" /* "Contact_User" /* cnb.z(-89442693937962L)   */, strValueOf);
                    context2.startActivity(intent2);
                }
                return KotlinUnit.INSTANCE;
            case 7:
                cua cuaVar = (cua) this.b;
                ctx ctxVar = (ctx) this.c;
                KotlinHelpers2.ar(cuaVar).j(R.id.codeFragment, ResourcesCompat.r(new Pair("pluginId" /* "pluginId" /* "pluginId" /* "pluginId" /* cnb.z(-418085001493290L)   */, ctxVar.f),
                        new Pair("pluginPath" /* "pluginPath" /* "pluginPath" /* "pluginPath" /* cnb.z(-417994807180074L)   */, ctxVar.b.getAbsolutePath())));
                return KotlinUnit.INSTANCE;
            case 8:
                return ((dap) this.b).d((CharSequence) this.c);
            default:
                bqr bqrVar = (bqr) this.b;
                ArrayList arrayList3 = (ArrayList) this.c;
                if (((MaterialRadioButton) bqrVar.e).isChecked()) {
                    dpd.a.r(doz.a.d);
                    dpe.a.t(StaticHelpers5.ad(arrayList3));
                } else if (((MaterialRadioButton) bqrVar.c).isChecked()) {
                    dpd.a.r(doz.b.d);
                    dpc.a.t(StaticHelpers5.ad(arrayList3));
                }
                return KotlinUnit.INSTANCE;
        }
    }

    public /* synthetic */ ls(cio cioVar, cit citVar, beq beqVar, SomeFragmentManager someFragmentManagerVar) {
        this.a = 1;
        this.b = citVar;
        this.c = someFragmentManagerVar;
    }

    public /* synthetic */ ls(cit citVar, cio cioVar, boolean z) {
        this.a = 5;
        this.b = citVar;
        this.c = cioVar;
    }
}
