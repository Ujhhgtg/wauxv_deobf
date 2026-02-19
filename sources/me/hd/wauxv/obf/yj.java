package me.hd.wauxv.obf;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yj implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ yj(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = ((Chip) obj).h;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                }
                break;
            case 1:
                ctx ctxVar = (ctx) obj;
                if (compoundButton.isPressed()) {
                    if (!z) {
                        ctxVar.q(false);
                        cuk.g(ctxVar);
                    } else if (!cuk.e(ctxVar)) {
                        compoundButton.setChecked(false);
                        ctxVar.q(false);
                        StringBuilder sb = new StringBuilder();
                        sb.append("加载[" /* "加载[" /* "加载[" /* cnb.z(-60842506713898L)  */);
                        dnc.g(null, 3, yg.decryptVar3UsingCnbZAndConcatToVar1(sb, ctxVar.f, -60790967106346L));
                    } else {
                        ctxVar.q(true);
                    }
                    break;
                }
                break;
            default:
                ctx ctxVar2 = ((oa) obj).c;
                if (compoundButton.isPressed()) {
                    if (!z) {
                        ctxVar2.q(false);
                        ArrayList arrayList = cuk.a;
                        cuk.g(ctxVar2);
                    } else {
                        ArrayList arrayList2 = cuk.a;
                        if (!cuk.e(ctxVar2)) {
                            compoundButton.setChecked(false);
                            ctxVar2.q(false);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("加载[" /* "加载[" /* "加载[" /* cnb.z(-388539921464106L)  */);
                            dnc.g(null, 3, yg.decryptVar3UsingCnbZAndConcatToVar1(sb2, ctxVar2.f, -388488381856554L));
                        } else {
                            ctxVar2.q(true);
                        }
                    }
                    break;
                }
                break;
        }
    }
}
