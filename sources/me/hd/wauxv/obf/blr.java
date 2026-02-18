package me.hd.wauxv.obf;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class blr {
    public final Class a;
    public final ViewGroup b;
    public final boolean c;
    public final Context d;
    public int e;
    public final /* synthetic */ blu f;

    public blr(blu bluVar, Class cls, ViewGroup viewGroup, boolean z, Context context) {
        this.f = bluVar;
        this.a = cls;
        this.b = viewGroup;
        this.c = z;
        this.d = context;
    }

    public static blq g(blr blrVar, int i, int i2, IHasInvokeMethod bgfVar, int i3) {
        if ((i3 & 1) != 0) {
            i = -3;
        }
        if ((i3 & 2) != 0) {
            i2 = -3;
        }
        boolean z = (i3 & 8) == 0;
        if ((i3 & 32) != 0) {
            bgfVar = new bep(24);
        }
        blq blqVar = new blq(blrVar.f, blrVar.a, blrVar.b);
        emc.af(1, bgfVar);
        blqVar.d = new po(i, i2, z, bgfVar);
        return blqVar;
    }

    public static final void h(blr blrVar, View view) {
        ViewGroup viewGroup;
        if (!blrVar.c || (viewGroup = blrVar.b) == null) {
            return;
        }
        viewGroup.addView(view);
    }

    public static final void i(blr blrVar, String str, Class cls) throws cth {
        String strO;
        ViewGroup viewGroup = blrVar.b;
        int i = blrVar.e + 1;
        blrVar.e = i;
        if (i > 1) {
            if (viewGroup == null || !blrVar.c) {
                if (str == null || (strO = concat("\"", str, "\"")) == null) {
                    strO = "<anonymous>";
                }
                String str2 = viewGroup == null ? "No parent view group found"
                        : "Parent view group declares attachToParent = false";
                StringBuilder sb = new StringBuilder("Provide view ");
                sb.append(cls);
                sb.append("(");
                sb.append(strO);
                sb.append(") failed. ");
                throw new cth(yg.o(sb, str2, ", you can only provide one view for the root view."));
            }
        }
    }

    public final Context j() throws cth {
        Context context;
        ViewGroup viewGroup = this.b;
        if (viewGroup != null && (context = viewGroup.getContext()) != null) {
            return context;
        }
        Context context2 = this.d;
        if (context2 != null) {
            return context2;
        }
        throw new cth("Parent layout is null or broken, Hikage.Performer need a Context to create the layout.");
    }

    public final Number k(Integer num) {
        return bhu.am(num, j());
    }
}
