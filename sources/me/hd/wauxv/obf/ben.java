package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ben implements bgf {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public /* synthetic */ ben(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        switch (this.a) {
            case 0:
                beq beqVar = (beq) this.b;
                bdj bdjVar = (bdj) this.c;
                cio cioVar = (cio) this.d;
                bup bupVar = (bup) obj;
                ArrayList arrayList = beqVar.h;
                boolean z = false;
                if (arrayList == null || !arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (bzo.f(((csm) it.next()).a, bdjVar.bs)) {
                            z = true;
                        }
                    }
                }
                if (bupVar != null && !z) {
                    bfg bfgVar = bdjVar.ci;
                    if (bfgVar == null) {
                        throw new IllegalStateException(yg.l("Can't access the Fragment View's LifecycleOwner for ", bdjVar, " when getView() is null i.e., before onCreateView() or after onDestroyView()"));
                    }
                    bfgVar.g();
                    bur burVar = bfgVar.d;
                    if (burVar.c.compareTo(buh.c) >= 0) {
                        burVar.j((buo) beqVar.n.invoke(cioVar));
                    }
                }
                return ens.a;
            case 1:
                Activity activity = (Activity) this.b;
                String str = (String) this.c;
                String str2 = (String) this.d;
                Intent intent = new Intent();
                intent.setClassName(activity, "com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI" /* cnb.z(-95236604820266L) */);
                intent.putExtra("title" /* cnb.z(-95554432400170L) */, "历史发言记录" /* cnb.z(-95511482727210L) */);
                intent.putExtra("RoomInfo_Id" /* cnb.z(-95464238086954L) */, str);
                intent.putExtra("room_member" /* cnb.z(-95447058217770L) */, str2);
                activity.startActivity(intent);
                break;
            default:
                Activity activity2 = (Activity) this.b;
                ArrayList<String> arrayList2 = (ArrayList) this.c;
                String str3 = (String) this.d;
                Intent intent2 = new Intent();
                intent2.setClassName(activity2, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* cnb.z(-96417720826666L) */);
                intent2.putStringArrayListExtra("sns_kemdia_path_list" /* cnb.z(-96258807036714L) */, arrayList2);
                intent2.putExtra("Kdescription" /* cnb.z(-96752728275754L) */, str3);
                activity2.startActivity(intent2);
                break;
        }
        return ens.a;
    }
}
