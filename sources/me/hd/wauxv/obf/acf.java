package me.hd.wauxv.obf;

import android.content.Intent;
import android.content.IntentSender;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class acf implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ acf(Object obj, int i, Object obj2, int i2) {
        this.a = i2;
        this.b = obj;
        this.c = i;
        this.d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                acg acgVar = (acg) this.b;
                Object obj = ((bc) this.d).e;
                String str = (String) acgVar.a.get(Integer.valueOf(this.c));
                if (str != null) {
                    dv dvVar = (dv) acgVar.e.get(str);
                    if ((dvVar != null ? dvVar.a : null) != null) {
                        dq dqVar = dvVar.a;
                        if (acgVar.d.remove(str)) {
                            dqVar.c(obj);
                        }
                    } else {
                        acgVar.g.remove(str);
                        acgVar.f.put(str, obj);
                    }
                    break;
                }
                break;
            case 1:
                acg acgVar2 = (acg) this.b;
                IntentSender.SendIntentException sendIntentException = (IntentSender.SendIntentException) this.d;
                throwIfVar1IsNull(acgVar2, "this$0");
                throwIfVar1IsNull(sendIntentException, "$e");
                acgVar2.i(this.c, 0,
                        new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST")
                                .putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION",
                                        sendIntentException));
                break;
            case 2:
                ((amg) this.b).b.logProfileResult(this.c, this.d);
                break;
            default:
                bvb bvbVar = (bvb) this.b;
                CodeEditor codeEditor = (CodeEditor) this.d;
                if (bvbVar.b == codeEditor) {
                    if (this.c == bvbVar.t.get()) {
                        codeEditor.setLayoutBusy(false);
                        codeEditor.getEventHandler().bb(0.0f, 0.0f, false);
                        break;
                    }
                }
                break;
        }
    }

    public /* synthetic */ acf(bvb bvbVar, CodeEditor codeEditor, int i) {
        this.a = 3;
        this.b = bvbVar;
        this.d = codeEditor;
        this.c = i;
    }
}
