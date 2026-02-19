package me.hd.wauxv.obf;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzm implements btd {
    public final /* synthetic */ int b;
    public final Object d;

    public bzm(int i) {
        this.b = i;
        switch (i) {
            case 1:
                this.d = StaticAndroidHelpers.am(btx.a, new Function1$VarIsInt$2(this));
                break;
            default:
                dnh dnhVar = dnh.b;
                bsb bsbVar = bsb.b;
                this.d = dqc.aw("kotlin.collections.Map.Entry", dnt.c, new dfx[0], new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(0));
                break;
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final Object a(ajt ajtVar) {
        switch (this.b) {
            case 0:
                Object obj = KotlinHelpers.d;
                bsb bsbVar = bsb.b;
                dnh dnhVar = dnh.b;
                dfz dfzVar = (dfz) this.d;
                acm acmVarP = ajtVar.p(dfzVar);
                acmVarP.getClass();
                Object objH = obj;
                Object objH2 = objH;
                while (true) {
                    int iF = acmVarP.f(dfzVar);
                    if (iF == -1) {
                        if (objH == obj) {
                            throw new SomeIllegalArgumentException("Element 'key' is missing");
                        }
                        if (objH2 == obj) {
                            throw new SomeIllegalArgumentException("Element 'value' is missing");
                        }
                        bzl bzlVar = new bzl(objH, objH2);
                        acmVarP._bp(dfzVar);
                        return bzlVar;
                    }
                    if (iF == 0) {
                        objH = acmVarP.h(dfzVar, 0, dnhVar, null);
                    } else {
                        if (iF != 1) {
                            throw new SomeIllegalArgumentException(concatVar2Var1(iF, "Invalid index: "));
                        }
                        objH2 = acmVarP.h(dfzVar, 1, bsbVar, null);
                    }
                }
                break;
            default:
                dfx descriptor = getDescriptor();
                acm acmVarP2 = ajtVar.p(descriptor);
                acmVarP2.getClass();
                int iF2 = acmVarP2.f(getDescriptor());
                if (iF2 != -1) {
                    throw new SomeIllegalArgumentException(concatVar2Var1(iF2, "Unexpected index "));
                }
                acmVarP2._bp(descriptor);
                return Kotlin$Unit.INSTANCE;
        }
    }

    @Override // me.hd.wauxv.obf.btd
    public final void c(avt avtVar, Object obj) {
        switch (this.b) {
            case 0:
                dfz dfzVar = (dfz) this.d;
                acn acnVarO = avtVar.o(dfzVar);
                dnh dnhVar = dnh.b;
                Map.Entry entry = (Map.Entry) obj;
                throwIfVar1IsNull(entry, "<this>");
                acnVarO._ca(dfzVar, 0, dnhVar, entry.getKey());
                acnVarO._ca(dfzVar, 1, bsb.b, entry.getValue());
                acnVarO.a(dfzVar);
                break;
            default:
                throwIfVar1IsNull(obj, "value");
                avtVar.o(getDescriptor()).a(getDescriptor());
                break;
        }
    }

    /*
     * JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object,
     * me.hd.wauxv.obf.btt]
     */
    @Override // me.hd.wauxv.obf.btd
    public final dfx getDescriptor() {
        switch (this.b) {
            case 0:
                return (dfz) this.d;
            default:
                return (dfx) this.d.getValue();
        }
    }
}
