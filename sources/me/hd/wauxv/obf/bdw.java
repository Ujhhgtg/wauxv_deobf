package me.hd.wauxv.obf;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bdw implements dq {
    public final /* synthetic */ int a;
    public final /* synthetic */ beg b;

    public /* synthetic */ bdw(beg begVar, int i) {
        this.a = i;
        this.b = begVar;
    }

    @Override // me.hd.wauxv.obf.dq
    public final void c(Object obj) {
        switch (this.a) {
            case 0:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                beg begVar = this.b;
                beb bebVar = (beb) begVar.af.pollFirst();
                if (bebVar == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    String str = bebVar.a;
                    if (begVar.c.aa(str) == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    }
                }
                break;
            case 1:
                dp dpVar = (dp) obj;
                beg begVar2 = this.b;
                beb bebVar2 = (beb) begVar2.af.pollLast();
                if (bebVar2 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    String str2 = bebVar2.a;
                    int i2 = bebVar2.b;
                    SomeFragmentManager someFragmentManagerVarAa = begVar2.c.aa(str2);
                    if (someFragmentManagerVarAa == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    } else {
                        someFragmentManagerVarAa.cy(i2, dpVar.a, dpVar.b);
                    }
                }
                break;
            default:
                dp dpVar2 = (dp) obj;
                beg begVar3 = this.b;
                beb bebVar3 = (beb) begVar3.af.pollFirst();
                if (bebVar3 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    String str3 = bebVar3.a;
                    int i3 = bebVar3.b;
                    SomeFragmentManager someFragmentManagerVarAa2 = begVar3.c.aa(str3);
                    if (someFragmentManagerVarAa2 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                    } else {
                        someFragmentManagerVarAa2.cy(i3, dpVar2.a, dpVar2.b);
                    }
                }
                break;
        }
    }
}
