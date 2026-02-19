package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cbj implements IInvokable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ cbj(Activity activity, String str, String str2, String str3) {
        this.a = 2;
        this.b = activity;
        this.e = str;
        this.c = str2;
        this.d = str3;
    }

    @Override // me.hd.wauxv.obf.bgf
    public final Object invoke(Object obj) {
        int i = this.a;
        boolean zBooleanValue = true;
        KotlinUnit kotlinUnitVar = KotlinUnit.INSTANCE;
        Object obj2 = this.d;
        Object obj3 = this.c;
        Object obj4 = this.e;
        Object obj5 = this.b;
        switch (i) {
            case 0:
                bgj bgjVar = (bgj) obj3;
                Configuration configurationVar = (Configuration) obj2;
                String str = (String) obj4;
                if ((obj5 instanceof Collection) && ((Collection) obj5).isEmpty()) {
                    obj5 = null;
                }
                if (obj5 != null) {
                    zBooleanValue = ((Boolean) bgjVar.g(obj5, obj)).booleanValue();
                    String strB = eoz.b(obj5);
                    String strBo = strB != null ? dnr.bo(strB.toString(), " (Kotlin reflection is not available)", "")
                            : null;
                    String strBo2 = obj != null ? dnr.bo(obj.toString(), " (Kotlin reflection is not available)", "")
                            : null;
                    if (configurationVar.optional != OptionalType.ENUM_SILENT) {
                        Kotlin$Lazy kotlin$LazyVar = bth.a;
                        String str2 = "[FILTER] [" + (zBooleanValue ? "HIT" : "MISS") + "] " + str + ": " + strBo
                                + " [RESOLVED] " + strBo2;
                        if (bth.d.ordinal() <= 0) {
                            bth.c.debug(str2);
                        }
                    }
                }
                return Boolean.valueOf(zBooleanValue);
            case 1:
                cio cioVar = (cio) obj;
                throwIfVar1IsNull(cioVar, "it");
                ((dag) obj5).a = true;
                ((cix) obj3).ab((cjg) obj2, (Bundle) obj4, cioVar, EmptyReadonlyList.INSTANCE);
                return kotlinUnitVar;
            default:
                Activity activity = (Activity) obj5;
                Intent intent = new Intent();
                intent.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* "com.tencent.mm.plugin.sns.ui.SnsUploadUI" /* cnb.z(-96675418864426L)  */);
                intent.putExtra("Ksnsupload_type" /* "Ksnsupload_type" /* "Ksnsupload_type" /* cnb.z(-96516505074474L)  */, 14);
                intent.putExtra("KSightPath" /* "KSightPath" /* "KSightPath" /* cnb.z(-95898029783850L)  */, (String) obj4);
                intent.putExtra("KSightThumbPath" /* "KSightThumbPath" /* "KSightThumbPath" /* cnb.z(-95799245536042L)  */, (String) obj3);
                intent.putExtra("Kdescription" /* "Kdescription" /* "Kdescription" /* cnb.z(-95730526059306L)  */, (String) obj2);
                activity.startActivity(intent);
                return kotlinUnitVar;
        }
    }

    public /* synthetic */ cbj(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }
}
