package me.hd.wauxv.obf;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bpn extends InputConnectionWrapper {
    public final /* synthetic */ qp a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bpn(InputConnection inputConnection, qp qpVar) {
        super(inputConnection, false);
        this.a = qpVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        Bundle bundle2;
        afj erpVar;
        bmu bmuVar = inputContentInfo == null ? null : new bmu(new bmu(inputContentInfo));
        ih ihVar = (ih) this.a.c;
        if ((i & 1) != 0) {
            try {
                ((InputContentInfo) ((bmu) bmuVar.h).h).requestPermission();
                InputContentInfo inputContentInfo2 = (InputContentInfo) ((bmu) bmuVar.h).h;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
            }
        } else {
            bundle2 = bundle;
        }
        InputContentInfo inputContentInfo3 = (InputContentInfo) ((bmu) bmuVar.h).h;
        ClipData clipData = new ClipData(inputContentInfo3.getDescription(), new ClipData.Item(inputContentInfo3.getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            erpVar = new erp(clipData, 2);
        } else {
            afk afkVar = new afk();
            afkVar.b = clipData;
            afkVar.c = 2;
            erpVar = afkVar;
        }
        erpVar.j(inputContentInfo3.getLinkUri());
        erpVar.setExtras(bundle2);
        if (eqz.o(ihVar, erpVar.build()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
