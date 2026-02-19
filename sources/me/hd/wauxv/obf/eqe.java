package me.hd.wauxv.obf;

import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eqe extends eqc {
    public final bqs ao;
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eqe(bqs bqsVar, int i) {
        super(bqsVar.b);
        this.b = i;
        switch (i) {
            case 1:
                super(bqsVar.b);
                this.ao = bqsVar;
                break;
            default:
                this.ao = bqsVar;
                break;
        }
    }

    @Override // me.hd.wauxv.obf.eqc
    public final void a(final oc ocVar) {
        switch (this.b) {
            case 0:
                oa oaVar = ocVar instanceof oa ? (oa) ocVar : null;
                if (oaVar != null) {
                    aeh aehVar = oaVar.d;
                    String str = oaVar.b;
                    bqs bqsVar = this.ao;
                    MaterialTextView materialTextView = (MaterialTextView) bqsVar.f;
                    MaterialTextView materialTextView2 = (MaterialTextView) bqsVar.e;
                    MaterialSwitch materialSwitch = (MaterialSwitch) bqsVar.d;
                    materialTextView.setText(oaVar.a);
                    materialSwitch.setEnabled(cud.a.z());
                    materialSwitch.setChecked(oaVar.c.p());
                    materialSwitch.setOnCheckedChangeListener(new yj(oaVar, 2));
                    if (str == null || str.length() == 0) {
                        materialTextView2.setVisibility(8);
                    } else {
                        materialTextView2.setVisibility(0);
                        materialTextView2.setText(str);
                    }
                    ((LinearLayout) bqsVar.c).setVisibility(0);
                    bqsVar.b.setOnClickListener(aehVar);
                }
                break;
            default:
                final ob obVar = ocVar instanceof ob ? (ob) ocVar : null;
                if (obVar != null) {
                    View.OnClickListener onClickListener = obVar.d;
                    String str2 = obVar.b;
                    bqs bqsVar2 = this.ao;
                    MaterialTextView materialTextView3 = (MaterialTextView) bqsVar2.f;
                    LinearLayout linearLayout = bqsVar2.b;
                    LinearLayout linearLayout2 = (LinearLayout) bqsVar2.c;
                    MaterialTextView materialTextView4 = (MaterialTextView) bqsVar2.e;
                    MaterialSwitch materialSwitch2 = (MaterialSwitch) bqsVar2.d;
                    materialTextView3.setText(obVar.a);
                    materialSwitch2.setChecked(obVar.c.z());
                    materialSwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: me.hd.wauxv.obf.eqf
                        /* JADX WARN: Type inference failed for: r0v3, types: [me.hd.wauxv.obf.amx] */
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            if (compoundButton.isPressed()) {
                                ob obVar2 = obVar;
                                eqe eqeVar = this;
                                eqg eqgVar = new eqg(obVar2, z, eqeVar);
                                if (!z || obVar2.c._ab()) {
                                    eqgVar.invoke();
                                    return;
                                }
                                DefaultConfig ioVar = new DefaultConfig(eqeVar.ao.b.getContext(), 13);
                                ioVar.ay("提示" /* "提示" /* "提示" /* "提示" /* cnb.z(-388458317085482L)   */);
                                StringBuilder sb = new StringBuilder();
                                sb.append("此功能 (" /* "此功能 (" /* "此功能 (" /* "此功能 (" /* cnb.z(-388411072445226L)   */);
                                yg.decryptVar2UsingCnbZAndConcatToVar1(sb, ((ob) ocVar).a, -388436842249002L);
                                bmo.a.getClass();
                                sb.append(bmo.s());
                                sb.append(" 上使用, 仍要开启?" /* " 上使用, 仍要开启?" /* " 上使用, 仍要开启?" /* " 上使用, 仍要开启?" /* cnb.z(-394445501496106L)   */);
                                String string = sb.toString();
                                bzy bzyVar = (bzy) ioVar.c;
                                if (bzyVar != null) {
                                    ((eg) bzyVar.d).f = string;
                                }
                                DefaultConfig.g(ioVar, new cfx(eqgVar, 19), 1);
                                DefaultConfig.f(ioVar, new eqh(compoundButton, 0), 1);
                                final eqh eqhVar = new eqh(compoundButton, 1);
                                bzy bzyVar2 = (bzy) ioVar.c;
                                if (bzyVar2 != null) {
                                    ((eg) bzyVar2.d).n = new DialogInterface.OnCancelListener() { // from class: me.hd.wauxv.obf.amx
                                        @Override // android.content.DialogInterface.OnCancelListener
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            eqhVar.invoke();
                                        }
                                    };
                                }
                                ioVar.az();
                            }
                        }
                    });
                    if (str2 == null || str2.length() == 0) {
                        materialTextView4.setVisibility(8);
                    } else {
                        materialTextView4.setVisibility(0);
                        materialTextView4.setText(str2);
                    }
                    if (onClickListener == null) {
                        linearLayout2.setVisibility(8);
                        linearLayout.setOnClickListener(null);
                    } else {
                        linearLayout2.setVisibility(0);
                        linearLayout.setOnClickListener(onClickListener);
                    }
                }
                break;
        }
    }
}
