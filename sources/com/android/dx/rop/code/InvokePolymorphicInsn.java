package com.android.dx.rop.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstProtoRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.umeng.analytics.pro.dn;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class InvokePolymorphicInsn extends Insn {
    private final CstMethodRef callSiteMethod;
    private final CstProtoRef callSiteProto;
    private final TypeList catches;
    private final CstMethodRef polymorphicMethod;
    private static final CstString DEFAULT_DESCRIPTOR = new CstString(TypeProxy.SilentConstruction.Appender.NEW_INSTANCE_METHOD_DESCRIPTOR);
    private static final CstString VARHANDLE_SET_DESCRIPTOR = new CstString("([Ljava/lang/Object;)V");
    private static final CstString VARHANDLE_COMPARE_AND_SET_DESCRIPTOR = new CstString("([Ljava/lang/Object;)Z");

    public InvokePolymorphicInsn(Rop rop, SourcePosition sourcePosition, RegisterSpecList registerSpecList, TypeList typeList, CstMethodRef cstMethodRef) {
        super(rop, sourcePosition, null, registerSpecList);
        if (rop.getBranchingness() != 6) {
            throw new IllegalArgumentException("opcode with invalid branchingness: " + rop.getBranchingness());
        }
        if (typeList == null) {
            throw new NullPointerException("catches == null");
        }
        this.catches = typeList;
        if (cstMethodRef == null) {
            throw new NullPointerException("callSiteMethod == null");
        }
        if (!cstMethodRef.isSignaturePolymorphic()) {
            throw new IllegalArgumentException("callSiteMethod is not signature polymorphic");
        }
        this.callSiteMethod = cstMethodRef;
        this.polymorphicMethod = makePolymorphicMethod(cstMethodRef);
        this.callSiteProto = makeCallSiteProto(cstMethodRef);
    }

    private static CstProtoRef makeCallSiteProto(CstMethodRef cstMethodRef) {
        return new CstProtoRef(cstMethodRef.getPrototype(true));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static CstMethodRef makePolymorphicMethod(CstMethodRef cstMethodRef) {
        CstType definingClass = cstMethodRef.getDefiningClass();
        CstString name = cstMethodRef.getNat().getName();
        String string = cstMethodRef.getNat().getName().getString();
        if (definingClass.equals(CstType.METHOD_HANDLE) && (string.equals("invoke") || string.equals("invokeExact"))) {
            return new CstMethodRef(definingClass, new CstNat(name, DEFAULT_DESCRIPTOR));
        }
        if (definingClass.equals(CstType.VAR_HANDLE)) {
            string.getClass();
            byte b = -1;
            switch (string.hashCode()) {
                case -1946504908:
                    if (string.equals("getAndBitwiseOrRelease")) {
                        b = 0;
                    }
                    break;
                case -1686727776:
                    if (string.equals("getAndBitwiseAndRelease")) {
                        b = 1;
                    }
                    break;
                case -1671098288:
                    if (string.equals("compareAndSet")) {
                        b = 2;
                    }
                    break;
                case -1292078254:
                    if (string.equals("compareAndExchangeRelease")) {
                        b = 3;
                    }
                    break;
                case -1117944904:
                    if (string.equals("weakCompareAndSet")) {
                        b = 4;
                    }
                    break;
                case -1103072857:
                    if (string.equals("getAndAddRelease")) {
                        b = 5;
                    }
                    break;
                case -1032914329:
                    if (string.equals("getAndBitwiseAnd")) {
                        b = 6;
                    }
                    break;
                case -1032892181:
                    if (string.equals("getAndBitwiseXor")) {
                        b = 7;
                    }
                    break;
                case -794517348:
                    if (string.equals("getAndBitwiseXorRelease")) {
                        b = 8;
                    }
                    break;
                case -567150350:
                    if (string.equals("weakCompareAndSetPlain")) {
                        b = 9;
                    }
                    break;
                case -240822786:
                    if (string.equals("weakCompareAndSetAcquire")) {
                        b = 10;
                    }
                    break;
                case -230706875:
                    if (string.equals("setRelease")) {
                        b = 11;
                    }
                    break;
                case -127361888:
                    if (string.equals("getAcquire")) {
                        b = 12;
                    }
                    break;
                case -37641530:
                    if (string.equals("getAndSetRelease")) {
                        b = dn.k;
                    }
                    break;
                case 102230:
                    if (string.equals("get")) {
                        b = dn.l;
                    }
                    break;
                case 113762:
                    if (string.equals("set")) {
                        b = dn.m;
                    }
                    break;
                case 93645315:
                    if (string.equals("getAndBitwiseOrAcquire")) {
                        b = 16;
                    }
                    break;
                case 101293086:
                    if (string.equals("setVolatile")) {
                        b = 17;
                    }
                    break;
                case 189872914:
                    if (string.equals("getVolatile")) {
                        b = 18;
                    }
                    break;
                case 282707520:
                    if (string.equals("getAndAdd")) {
                        b = 19;
                    }
                    break;
                case 282724865:
                    if (string.equals("getAndSet")) {
                        b = 20;
                    }
                    break;
                case 353422447:
                    if (string.equals("getAndBitwiseAndAcquire")) {
                        b = 21;
                    }
                    break;
                case 470702883:
                    if (string.equals("setOpaque")) {
                        b = 22;
                    }
                    break;
                case 685319959:
                    if (string.equals("getOpaque")) {
                        b = 23;
                    }
                    break;
                case 748071969:
                    if (string.equals("compareAndExchangeAcquire")) {
                        b = 24;
                    }
                    break;
                case 937077366:
                    if (string.equals("getAndAddAcquire")) {
                        b = 25;
                    }
                    break;
                case 1245632875:
                    if (string.equals("getAndBitwiseXorAcquire")) {
                        b = 26;
                    }
                    break;
                case 1352153939:
                    if (string.equals("getAndBitwiseOr")) {
                        b = 27;
                    }
                    break;
                case 1483964149:
                    if (string.equals("compareAndExchange")) {
                        b = 28;
                    }
                    break;
                case 2002508693:
                    if (string.equals("getAndSetAcquire")) {
                        b = 29;
                    }
                    break;
                case 2013994287:
                    if (string.equals("weakCompareAndSetRelease")) {
                        b = 30;
                    }
                    break;
            }
            switch (b) {
                case 0:
                case 1:
                case 3:
                case 5:
                case 6:
                case 7:
                case 8:
                case 12:
                case 13:
                case 14:
                case 16:
                case 18:
                case 19:
                case 20:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    return new CstMethodRef(definingClass, new CstNat(name, DEFAULT_DESCRIPTOR));
                case 2:
                case 4:
                case 9:
                case 10:
                case 30:
                    return new CstMethodRef(definingClass, new CstNat(name, VARHANDLE_COMPARE_AND_SET_DESCRIPTOR));
                case 11:
                case 15:
                case 17:
                case 22:
                    return new CstMethodRef(definingClass, new CstNat(name, VARHANDLE_SET_DESCRIPTOR));
            }
        }
        throw new IllegalArgumentException("Unknown signature polymorphic method: " + cstMethodRef.toHuman());
    }

    @Override // com.android.dx.rop.code.Insn
    public void accept(Insn.Visitor visitor) {
        visitor.visitInvokePolymorphicInsn(this);
    }

    public CstMethodRef getCallSiteMethod() {
        return this.callSiteMethod;
    }

    public CstProtoRef getCallSiteProto() {
        return this.callSiteProto;
    }

    @Override // com.android.dx.rop.code.Insn
    public TypeList getCatches() {
        return this.catches;
    }

    @Override // com.android.dx.rop.code.Insn
    public String getInlineString() {
        return getPolymorphicMethod().toString() + " " + getCallSiteProto().toString() + " " + ThrowingInsn.toCatchString(this.catches);
    }

    public CstMethodRef getPolymorphicMethod() {
        return this.polymorphicMethod;
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withAddedCatch(Type type) {
        return new InvokePolymorphicInsn(getOpcode(), getPosition(), getSources(), this.catches.withAddedType(type), getCallSiteMethod());
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withNewRegisters(RegisterSpec registerSpec, RegisterSpecList registerSpecList) {
        return new InvokePolymorphicInsn(getOpcode(), getPosition(), registerSpecList, this.catches, getCallSiteMethod());
    }

    @Override // com.android.dx.rop.code.Insn
    public Insn withRegisterOffset(int i) {
        return new InvokePolymorphicInsn(getOpcode(), getPosition(), getSources().withOffset(i), this.catches, getCallSiteMethod());
    }
}
