package me.hd.wauxv.obf;

import java.nio.ByteBuffer;
import java.util.AbstractList;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ami extends AbstractList implements RandomAccess {
    public final /* synthetic */ int a;
    public final /* synthetic */ amk b;

    public /* synthetic */ ami(amk amkVar, int i) {
        this.a = i;
        this.b = amkVar;
    }

    public String c(int i) {
        amk amkVar = this.b;
        amk.k(i, amkVar.c.b.b);
        return amkVar.n((i * 4) + amkVar.c.b.c).g();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        switch (this.a) {
            case 0:
                amk amkVar = this.b;
                dps dpsVar = amkVar.c;
                amk.k(i, dpsVar.e.b);
                amj amjVarN = amkVar.n((i * 8) + dpsVar.e.c);
                return new azh(amjVarN.d, amjVarN.i(), amjVarN.i(), amjVarN.b.getInt());
            case 1:
                amk amkVar2 = this.b;
                dps dpsVar2 = amkVar2.c;
                amk.k(i, dpsVar2.f.b);
                amj amjVarN2 = amkVar2.n((i * 8) + dpsVar2.f.c);
                return new cdi(amjVarN2.d, amjVarN2.i(), amjVarN2.i(), amjVarN2.b.getInt());
            case 2:
                amk amkVar3 = this.b;
                dps dpsVar3 = amkVar3.c;
                amk.k(i, dpsVar3.d.b);
                amj amjVarN3 = amkVar3.n((i * 12) + dpsVar3.d.c);
                ByteBuffer byteBuffer = amjVarN3.b;
                return new cwe(amjVarN3.d, byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt());
            case 3:
                return c(i);
            case 4:
                amk amkVar4 = this.b;
                dps dpsVar4 = amkVar4.c;
                amk.k(i, dpsVar4.c.b);
                return Integer.valueOf(amkVar4.b.getInt((i * 4) + dpsVar4.c.c));
            default:
                amk amkVar5 = this.b;
                ami amiVar = amkVar5.e;
                dps dpsVar5 = amkVar5.c;
                amk.k(i, dpsVar5.c.b);
                return amiVar.c(amkVar5.b.getInt((i * 4) + dpsVar5.c.c));
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        switch (this.a) {
            case 0:
                return this.b.c.e.b;
            case 1:
                return this.b.c.f.b;
            case 2:
                return this.b.c.d.b;
            case 3:
                return this.b.c.b.b;
            case 4:
                return this.b.c.c.b;
            default:
                return this.b.c.c.b;
        }
    }
}
