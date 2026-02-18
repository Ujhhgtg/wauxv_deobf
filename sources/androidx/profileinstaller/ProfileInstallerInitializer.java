package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import me.hd.wauxv.obf.bpf;
import me.hd.wauxv.obf.cbm;
import me.hd.wauxv.obf.ccy;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements bpf {
    @Override // me.hd.wauxv.obf.bpf
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // me.hd.wauxv.obf.bpf
    public final Object b(Context context) {
        Choreographer.getInstance().postFrameCallback(new ccy(this, context.getApplicationContext()));
        return new cbm(13);
    }
}
