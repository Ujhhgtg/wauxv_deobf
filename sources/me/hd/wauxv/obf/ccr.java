package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ccr implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ cct b;

    public /* synthetic */ ccr(cct cctVar, int i) {
        this.a = i;
        this.b = cctVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        cct cctVar = this.b;
        switch (i) {
            case 0:
                ccu ccuVar = cctVar.o;
                ccuVar.getClass();
                EditText editText = cctVar.h;
                if (editText != null) {
                    ccuVar.av(editText, false);
                }
                ccuVar.getClass();
                if (view != null) {
                    bht bhtVar = anj.a;
                    view.performHapticFeedback(3);
                }
                if (ccuVar.bk == null) {
                    cctVar.p(view);
                } else {
                    String string = editText == null ? "" : editText.getText().toString();
                    df dfVar = ccuVar.bk;
                    ccu ccuVar2 = ccuVar.bd;
                    dfVar.getClass();
                    Activity activityV = aye.v();
                    throwIfVar1IsNull(activityV);
                    if (dnr.bi(string, "@chatroom" /* cnb.z(-513454750300970L) */)) {
                        Intent intent = new Intent();
                        intent.setClassName(activityV, "com.tencent.mm.chatroom.ui.ChatroomInfoUI" /*
                                                                                                    * cnb.z(-
                                                                                                    * 89438398970666L)
                                                                                                    */);
                        intent.putExtra("RoomInfo_Id" /* cnb.z(-95253784689450L) */, string);
                        activityV.startActivity(intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.setClassName(activityV, "com.tencent.mm.plugin.profile.ui.ContactInfoUI" /*
                                                                                                          * cnb.z(-
                                                                                                          * 89111981456170L)
                                                                                                          */);
                        intent2.putExtra("Contact_User" /* cnb.z(-89442693937962L) */, string);
                        activityV.startActivity(intent2);
                    }
                    cctVar.p(view);
                }
                break;
            case 1:
                ccu ccuVar3 = cctVar.o;
                ccuVar3.getClass();
                EditText editText2 = cctVar.h;
                if (editText2 != null) {
                    ccuVar3.av(editText2, false);
                }
                ccuVar3.getClass();
                if (view != null) {
                    bht bhtVar2 = anj.a;
                    view.performHapticFeedback(3);
                }
                ccuVar3.getClass();
                cctVar.p(view);
                break;
            case 2:
                ccu ccuVar4 = cctVar.o;
                ccuVar4.getClass();
                EditText editText3 = cctVar.h;
                if (editText3 != null) {
                    ccuVar4.av(editText3, false);
                }
                ccuVar4.getClass();
                if (view != null) {
                    bht bhtVar3 = anj.a;
                    view.performHapticFeedback(3);
                }
                ccuVar4.getClass();
                cctVar.p(view);
                break;
            default:
                cctVar.o.getClass();
                cctVar.p(view);
                break;
        }
    }
}
