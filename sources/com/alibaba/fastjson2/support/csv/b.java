package com.alibaba.fastjson2.support.csv;

import com.alibaba.fastjson2.reader.ByteArrayValueConsumer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements ByteArrayValueConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ CSVReaderUTF8 b;

    public /* synthetic */ b(CSVReaderUTF8 cSVReaderUTF8, int i) {
        this.a = i;
        this.b = cSVReaderUTF8;
    }

    @Override // com.alibaba.fastjson2.reader.ByteArrayValueConsumer
    public final void accept(int i, int i2, byte[] bArr, int i3, int i4, Charset charset) {
        switch (this.a) {
            case 0:
                this.b.lambda$statAll$1(i, i2, bArr, i3, i4, charset);
                break;
            default:
                this.b.lambda$statAll$0(i, i2, bArr, i3, i4, charset);
                break;
        }
    }
}
