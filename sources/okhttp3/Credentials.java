package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    private Credentials() {
    }

    public static final String basic(String str, String str2) {
        throwIfVar1IsNull(str, "username");
        throwIfVar1IsNull(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    public static /* synthetic */ String basic$default(String str, String str2, Charset charset, int i, Object obj) {
        if ((i & 4) != 0) {
            charset = StandardCharsets.ISO_8859_1;
            throwIfVar1IsNull(charset, "ISO_8859_1");
        }
        return basic(str, str2, charset);
    }

    public static final String basic(String str, String str2, Charset charset) {
        throwIfVar1IsNull(str, "username");
        throwIfVar1IsNull(str2, "password");
        throwIfVar1IsNull(charset, "charset");
        String str3 = str + ':' + str2;
        sj sjVar = sj.a;
        throwIfVar1IsNull(str3, "<this>");
        byte[] bytes = str3.getBytes(charset);
        throwIfVar1IsNull(bytes, "this as java.lang.String).getBytes(charset)");
        return yg.concat("Basic ", new sj(bytes).e());
    }
}
