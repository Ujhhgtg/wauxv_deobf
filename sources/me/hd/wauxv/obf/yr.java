package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yr implements bfu {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ DexKitBridge b;
    public final /* synthetic */ yu c;
    public final /* synthetic */ int d;

    public /* synthetic */ yr(yu yuVar, DexKitBridge dexKitBridge, int i) {
        this.c = yuVar;
        this.b = dexKitBridge;
        this.d = i;
    }

    @Override // me.hd.wauxv.obf.bfu
    public final Object invoke() {
        int i = this.a;
        int i2 = this.d;
        yu yuVar = this.c;
        DexKitBridge dexKitBridge = this.b;
        switch (i) {
            case 0:
                Integer num = yuVar.g;
                Object obj = null;
                if (num == null) {
                    return null;
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(DexKitBridge
                        .nativeGetClassByIds(DexKitBridge.b(dexKitBridge), new long[] { nd.d(i2, num.intValue()) }));
                throwIfVar1IsNull(byteBufferWrap, "wrap(...)");
                c cVar = new c();
                cVar.h(byteBufferWrap.position() + bjs.f(byteBufferWrap, ByteOrder.LITTLE_ENDIAN), byteBufferWrap);
                yw ywVar = new yw();
                int iM = cVar.m();
                for (int i3 = 0; i3 < iM; i3++) {
                    c cVarL = cVar.l(i3);
                    throwIfVar1IsNull(cVarL);
                    ywVar.add(cna.t(dexKitBridge, cVarL));
                }
                if (!ywVar.isEmpty()) {
                    if (ywVar.isEmpty()) {
                        throw new IllegalStateException("list is empty");
                    }
                    obj = ywVar.get(0);
                }
                return (yu) obj;
            default:
                ArrayList arrayList = yuVar.h;
                ArrayList arrayList2 = new ArrayList(abb.ak(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Long.valueOf(nd.d(i2, ((Number) it.next()).intValue())));
                }
                ByteBuffer byteBufferWrap2 = ByteBuffer
                        .wrap(DexKitBridge.nativeGetClassByIds(DexKitBridge.b(dexKitBridge), aaz.aa(arrayList2)));
                throwIfVar1IsNull(byteBufferWrap2, "wrap(...)");
                c cVar2 = new c();
                cVar2.h(byteBufferWrap2.position() + bjs.f(byteBufferWrap2, ByteOrder.LITTLE_ENDIAN), byteBufferWrap2);
                yw ywVar2 = new yw();
                int iM2 = cVar2.m();
                for (int i4 = 0; i4 < iM2; i4++) {
                    c cVarL2 = cVar2.l(i4);
                    throwIfVar1IsNull(cVarL2);
                    ywVar2.add(cna.t(dexKitBridge, cVarL2));
                }
                return ywVar2;
        }
    }

    public /* synthetic */ yr(DexKitBridge dexKitBridge, yu yuVar, int i) {
        this.b = dexKitBridge;
        this.c = yuVar;
        this.d = i;
    }
}
