package com.alibaba.fastjson2.support.csv;

import com.alibaba.fastjson2.reader.CharArrayValueConsumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CharArrayValueConsumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ CSVReaderUTF16 b;

    public /* synthetic */ a(CSVReaderUTF16 cSVReaderUTF16, int i) {
        this.a = i;
        this.b = cSVReaderUTF16;
    }

    @Override // com.alibaba.fastjson2.reader.CharArrayValueConsumer
    public final void accept(int i, int i2, char[] cArr, int i3, int i4) {
        switch (this.a) {
            case 0:
                this.b.lambda$statAll$0(i, i2, cArr, i3, i4);
                break;
            default:
                this.b.lambda$statAll$1(i, i2, cArr, i3, i4);
                break;
        }
    }
}
