package me.hd.wauxv.obf;

import android.telephony.CellIdentityNr;
import android.telephony.CellInfo;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class exb {
    public static /* bridge */ /* synthetic */ CellIdentityNr e(Object obj) {
        return (CellIdentityNr) obj;
    }

    public static /* bridge */ /* synthetic */ CellInfoNr g(CellInfo cellInfo) {
        return (CellInfoNr) cellInfo;
    }

    public static /* bridge */ /* synthetic */ CellInfoTdscdma h(CellInfo cellInfo) {
        return (CellInfoTdscdma) cellInfo;
    }

    public static /* bridge */ /* synthetic */ boolean j(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoNr;
    }

    public static /* bridge */ /* synthetic */ boolean m(CellInfo cellInfo) {
        return cellInfo instanceof CellInfoTdscdma;
    }
}
