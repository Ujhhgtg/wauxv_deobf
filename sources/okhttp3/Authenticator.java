package okhttp3;

import me.hd.wauxv.obf.bzo;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Authenticator {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final Authenticator NONE = new Companion.AuthenticatorNone();
    public static final Authenticator JAVA_NET_AUTHENTICATOR = new JavaNetAuthenticator(null, 1, null);

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static final class AuthenticatorNone implements Authenticator {
            @Override // okhttp3.Authenticator
            public Request authenticate(Route route, Response response) {
                bzo.q(response, "response");
                return null;
            }
        }

        private Companion() {
        }
    }

    Request authenticate(Route route, Response response);
}
