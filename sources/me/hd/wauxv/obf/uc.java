package me.hd.wauxv.obf;

import com.alibaba.fastjson2.JSONB;
import net.bytebuddy.asm.Advice;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class uc {
    public static final char[] a = new char[117];
    public static final byte[] b = new byte[126];

    static {
        for (int i = 0; i < 32; i++) {
        }
        c('b', 8);
        c(Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 9);
        c('n', 10);
        c('f', 12);
        c(Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, 13);
        c('/', 47);
        c('\"', 34);
        c('\\', 92);
        byte[] bArr = b;
        for (int i2 = 0; i2 < 33; i2++) {
            bArr[i2] = JSONB.Constants.BC_SYMBOL;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void c(char c, int i) {
        if (c != 'u') {
            a[c] = (char) i;
        }
    }
}
