package okhttp3.internal.ws;

import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.nu;
import me.hd.wauxv.obf.rf;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.sj;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        throwIfVar1IsNull(str, "key");
        sj sjVar = sj.a;
        return nu.g(str.concat(ACCEPT_MAGIC)).f("SHA-1").e();
    }

    public final String closeCodeExceptionMessage(int i) {
        if (i < 1000 || i >= 5000) {
            return concatVar2Var1(i, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i || i >= 1007) && (1015 > i || i >= 3000)) {
            return null;
        }
        return yg.f(i, "Code ", " is reserved and may not be used.");
    }

    public final void toggleMask(rf rfVar, byte[] bArr) {
        long j;
        throwIfVar1IsNull(rfVar, "cursor");
        throwIfVar1IsNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = rfVar.e;
            int i2 = rfVar.f;
            int i3 = rfVar.g;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = rfVar.d;
            rh rhVar = rfVar.a;
            throwIfVar1IsNull(rhVar);
            if (j2 == rhVar.b) {
                throw new IllegalStateException("no more bytes");
            }
            j = rfVar.d;
        } while (rfVar.i(j == -1 ? 0L : j + ((long) (rfVar.g - rfVar.f))) != -1);
    }

    public final void validateCloseCode(int i) {
        String strCloseCodeExceptionMessage = closeCodeExceptionMessage(i);
        if (strCloseCodeExceptionMessage == null) {
            return;
        }
        throwIfVar1IsNull(strCloseCodeExceptionMessage);
        throw new IllegalArgumentException(strCloseCodeExceptionMessage.toString());
    }
}
