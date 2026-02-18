package com.android.dx.cf.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstMethodHandle;
import com.android.dx.rop.cst.CstProtoRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.FixedSizeList;
import me.hd.wauxv.obf.bjs;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BootstrapMethodArgumentsList extends FixedSizeList {
    public BootstrapMethodArgumentsList(int i) {
        super(i);
    }

    public Constant get(int i) {
        return (Constant) get0(i);
    }

    public void set(int i, Constant constant) {
        if (!(constant instanceof CstString) && !(constant instanceof CstType) && !(constant instanceof CstInteger)
                && !(constant instanceof CstLong) && !(constant instanceof CstFloat) && !(constant instanceof CstDouble)
                && !(constant instanceof CstMethodHandle) && !(constant instanceof CstProtoRef)) {
            throw new IllegalArgumentException(
                    concatVar2Var1(constant.getClass(), "bad type for bootstrap argument: "));
        }
        set0(i, constant);
    }
}
