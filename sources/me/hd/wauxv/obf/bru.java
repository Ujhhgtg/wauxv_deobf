package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bru extends KotlinHelpers2 {
    public final yi ac;
    public final cbm ad;

    public bru(yi yiVar, brn brnVar) {
        throwIfVar1IsNull(brnVar, "json");
        this.ac = yiVar;
        this.ad = brnVar.c;
    }

    @Override // me.hd.wauxv.obf.acm
    public final cbm a() {
        return this.ad;
    }

    @Override // me.hd.wauxv.obf.acm
    public final int f(dfx dfxVar) {
        throwIfVar1IsNull(dfxVar, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final int s() {
        yi yiVar = this.ac;
        String strS = yiVar.s();
        try {
            throwIfVar1IsNull(strS, "<this>");
            emu emuVarZ = bhs.z(strS);
            if (emuVarZ != null) {
                return emuVarZ.a;
            }
            dnq.be(strS);
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, StaticHelpers6.o('\'', "Failed to parse type 'UInt' for input '", strS), 0, null, 6);
            throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final long w() {
        yi yiVar = this.ac;
        String strS = yiVar.s();
        try {
            throwIfVar1IsNull(strS, "<this>");
            emz emzVarAa = bhs.aa(strS);
            if (emzVarAa != null) {
                return emzVarAa.a;
            }
            dnq.be(strS);
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, StaticHelpers6.o('\'', "Failed to parse type 'ULong' for input '", strS), 0, null, 6);
            throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final byte y() {
        emp empVar;
        yi yiVar = this.ac;
        String strS = yiVar.s();
        try {
            throwIfVar1IsNull(strS, "<this>");
            emu emuVarZ = bhs.z(strS);
            if (emuVarZ != null) {
                int i = emuVarZ.a;
                empVar = Integer.compareUnsigned(i, Opcodes.CONST_METHOD_TYPE) > 0 ? null : new emp((byte) i);
            }
            if (empVar != null) {
                return empVar.a;
            }
            dnq.be(strS);
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, StaticHelpers6.o('\'', "Failed to parse type 'UByte' for input '", strS), 0, null, 6);
            throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cnd, me.hd.wauxv.obf.ajt
    public final short z() {
        ene eneVar;
        yi yiVar = this.ac;
        String strS = yiVar.s();
        try {
            throwIfVar1IsNull(strS, "<this>");
            emu emuVarZ = bhs.z(strS);
            if (emuVarZ != null) {
                int i = emuVarZ.a;
                eneVar = Integer.compareUnsigned(i, 65535) > 0 ? null : new ene((short) i);
            }
            if (eneVar != null) {
                return eneVar.a;
            }
            dnq.be(strS);
            throw null;
        } catch (IllegalArgumentException unused) {
            yi.g(yiVar, StaticHelpers6.o('\'', "Failed to parse type 'UShort' for input '", strS), 0, null, 6);
            throw null;
        }
    }
}
