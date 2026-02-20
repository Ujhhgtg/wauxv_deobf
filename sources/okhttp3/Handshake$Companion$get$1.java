package okhttp3;

import java.security.cert.Certificate;
import java.util.List;
import me.hd.wauxv.obf.IFunction0;
import me.hd.wauxv.obf.btp;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Handshake$Companion$get$1 extends btp implements IFunction0 {
    final /* synthetic */ List<Certificate> $peerCertificatesCopy;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Handshake$Companion$get$1(List<? extends Certificate> list) {
        super(0);
        this.$peerCertificatesCopy = list;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final List<Certificate> invoke() {
        return this.$peerCertificatesCopy;
    }
}
