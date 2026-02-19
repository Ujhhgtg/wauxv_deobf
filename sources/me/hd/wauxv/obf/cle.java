package me.hd.wauxv.obf;

import android.widget.Toast;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cle extends btp implements bfu {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cle(Object obj, int i) {
        super(0);
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        switch (this.a) {
            case 0:
                return Long.valueOf(((clg) this.b).a.contentLength());
            default:
                Toast toast = KotlinHelpers2.ah;
                if (toast != null) {
                    toast.cancel();
                }
                Toast toastMakeText = Toast.makeText(ckv.j(), (String) this.b, 0);
                KotlinHelpers2.ah = toastMakeText;
                if (toastMakeText != null) {
                    toastMakeText.show();
                }
                return KotlinUnit.INSTANCE;
        }
    }
}
