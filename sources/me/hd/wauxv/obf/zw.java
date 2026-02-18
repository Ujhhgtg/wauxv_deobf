package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zw extends BaseHook implements bnx {
    public static final zw a = new zw("ClearUserInfoHook" /* cnb.z(-512110425537322L) */);
    public static final String b = "杂项" /* cnb.z(-511453295541034L) */;
    public static final String c = "清空用户信息" /* cnb.z(-511457590508330L) */;
    public static final String d = "清空用户的性别及国家省份等相关信息" /* cnb.z(-511427525737258L) */;

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getCategory() {
        return b;
    }

    public final void h(HookParamWrapper hookParam, int i, byte[] bArr) {
        if (z() && i == 1) {
            cwd cwdVar = cwd.a;
            cwdVar.getClass();
            cdq cdqVar = cdr.Companion;
            cdr cdrVar = (cdr) cwdVar.c(cdqVar.serializer(), bArr);
            cdrVar.j = 0;
            cdrVar.k = "" /* cnb.z(-511500540181290L) */;
            cdrVar.l = "" /* cnb.z(-511513425083178L) */;
            cdrVar.al = "" /* cnb.z(-511509130115882L) */;
            btd btdVarSerializer = cdqVar.serializer();
            throwIfVar1IsNull(btdVarSerializer, "serializer");
            rw rwVar = new rw();
            new cwn(cwdVar, new bmu(rwVar), btdVarSerializer.getDescriptor()).x(btdVarSerializer, cdrVar);
            int i2 = rwVar.c;
            byte[] bArr2 = new byte[i2];
            la._an(rwVar.b, 0, i2, bArr2, 2);
            hookParam.setResult(bArr2);
        }
    }

    @Override // me.hd.wauxv.obf.BaseHook
    public final String getDescription() {
        return d;
    }
}
