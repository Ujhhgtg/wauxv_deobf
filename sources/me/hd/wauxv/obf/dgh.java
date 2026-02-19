package me.hd.wauxv.obf;

import android.os.Process;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dgh extends doi implements bgj {
    public final /* synthetic */ int a;
    public int d;
    public final /* synthetic */ View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ dgh(View view, afw afwVar, int i) {
        super(2, afwVar);
        this.a = i;
        this.e = view;
    }

    @Override // me.hd.wauxv.obf.bgj
    public final Object g(Object obj, Object obj2) {
        ahp ahpVar = (ahp) obj;
        afw afwVar = (afw) obj2;
        switch (this.a) {
            case 0:
                break;
        }
        return ((dgh) h(ahpVar, afwVar)).i(Kotlin$Unit.INSTANCE);
    }

    @Override // me.hd.wauxv.obf.nc
    public final afw h(Object obj, afw afwVar) {
        switch (this.a) {
            case 0:
                return new dgh((LinearLayout) this.e, afwVar, 0);
            default:
                return new dgh((TextView) this.e, afwVar, 1);
        }
    }

    @Override // me.hd.wauxv.obf.nc
    public final Object i(Object obj) throws Throwable {
        int i = this.a;
        Kotlin$Unit kotlinUnitVar = Kotlin$Unit.INSTANCE;
        View view = this.e;
        ahq ahqVar = ahq.a;
        switch (i) {
            case 0:
                int i2 = this.d;
                if (i2 == 0) {
                    FastKV.bd(obj);
                    lw lwVar = new lw(2, null, 6);
                    this.d = 1;
                    Kotlin$Lazy kotlin$LazyVar = doh.a;
                    Dispatchers$Default alcVar = aou.a;
                    obj = ajn.ak(akq.f, lwVar, this);
                    if (obj == ahqVar) {
                        return ahqVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-60498909330218L)  */);
                    }
                    FastKV.bd(obj);
                }
                LinearLayout linearLayout = (LinearLayout) view;
                for (ctx ctxVar : (Iterable) obj) {
                    LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                    linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    linearLayout2.setOrientation(1);
                    linearLayout2.setPadding(FastKV.al(new Integer(16), linearLayout2.getContext()).intValue(), FastKV.al(new Integer(32), linearLayout2.getContext()).intValue(), FastKV.al(new Integer(16), linearLayout2.getContext()).intValue(), FastKV.al(new Integer(32), linearLayout2.getContext()).intValue());
                    Switch r5 = new Switch(linearLayout2.getContext());
                    r5.setText(((String) ctxVar.g.getValue()) + '(' + ctxVar.f + ')');
                    r5.setEnabled(cud.a.z());
                    r5.setChecked(ctxVar.p());
                    r5.setOnCheckedChangeListener(new yj(ctxVar, 1));
                    linearLayout2.addView(r5);
                    TextView textView = new TextView(linearLayout2.getContext());
                    StringBuilder sb = new StringBuilder();
                    sb.append("版本: " /* "版本: " /* "版本: " /* cnb.z(-60576218741546L)  */);
                    yg.decryptVar2UsingCnbZAndConcatToVar1(sb, (String) ctxVar.i.getValue(), -60520384166698L);
                    sb.append((String) ctxVar.j.getValue());
                    textView.setText(sb.toString());
                    linearLayout2.addView(textView);
                    linearLayout.addView(linearLayout2);
                }
                return kotlinUnitVar;
            default:
                int i3 = this.d;
                if (i3 == 0) {
                    FastKV.bd(obj);
                    ((TextView) view).setText("加载完成, 准备重启中..." /* "加载完成, 准备重启中..." /* "加载完成, 准备重启中..." /* cnb.z(-58488864635690L)  */);
                    this.d = 1;
                    if (dqc.delayCoroutine(1000L, this) == ahqVar) {
                        return ahqVar;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* "call to 'resume' before 'invoke' with coroutine" /* cnb.z(-58475979733802L)  */);
                    }
                    FastKV.bd(obj);
                }
                Process.killProcess(Process.myPid());
                return kotlinUnitVar;
        }
    }
}
