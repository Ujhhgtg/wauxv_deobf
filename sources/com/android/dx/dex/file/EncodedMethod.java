package com.android.dx.dex.file;

import com.android.dx.dex.code.DalvCode;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class EncodedMethod extends EncodedMember implements Comparable<EncodedMethod> {
    private final CodeItem code;
    private final CstMethodRef method;

    public EncodedMethod(CstMethodRef cstMethodRef, int i, DalvCode dalvCode, TypeList typeList) {
        super(i);
        if (cstMethodRef == null) {
            throw new NullPointerException("method == null");
        }
        this.method = cstMethodRef;
        if (dalvCode == null) {
            this.code = null;
        } else {
            this.code = new CodeItem(cstMethodRef, dalvCode, (i & 8) != 0, typeList);
        }
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void addContents(DexFile dexFile) {
        MethodIdsSection methodIds = dexFile.getMethodIds();
        MixedItemSection wordData = dexFile.getWordData();
        methodIds.intern(this.method);
        CodeItem codeItem = this.code;
        if (codeItem != null) {
            wordData.add(codeItem);
        }
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public void debugPrint(PrintWriter printWriter, boolean z) {
        CodeItem codeItem = this.code;
        if (codeItem != null) {
            codeItem.debugPrint(printWriter, "  ", z);
            return;
        }
        printWriter.println(getRef().toHuman() + ": abstract or native");
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public int encode(DexFile dexFile, AnnotatedOutput annotatedOutput, int i, int i2) {
        int iIndexOf = dexFile.getMethodIds().indexOf(this.method);
        int i3 = iIndexOf - i;
        int accessFlags = getAccessFlags();
        int absoluteOffsetOr0 = OffsettedItem.getAbsoluteOffsetOr0(this.code);
        if ((absoluteOffsetOr0 != 0) != ((accessFlags & 1280) == 0)) {
            throw new UnsupportedOperationException("code vs. access_flags mismatch");
        }
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(0, String.format("  [%x] %s", Integer.valueOf(i2), this.method.toHuman()));
            annotatedOutput.annotate(ajn.ai(i3), "    method_idx:   " + Hex.u4(iIndexOf));
            annotatedOutput.annotate(ajn.ai(accessFlags), "    access_flags: " + AccessFlags.methodString(accessFlags));
            dkz.ab(absoluteOffsetOr0, new StringBuilder("    code_off:     "), annotatedOutput, ajn.ai(absoluteOffsetOr0));
        }
        annotatedOutput.writeUleb128(i3);
        annotatedOutput.writeUleb128(accessFlags);
        annotatedOutput.writeUleb128(absoluteOffsetOr0);
        return iIndexOf;
    }

    public boolean equals(Object obj) {
        return (obj instanceof EncodedMethod) && compareTo((EncodedMethod) obj) == 0;
    }

    @Override // com.android.dx.dex.file.EncodedMember
    public final CstString getName() {
        return this.method.getNat().getName();
    }

    public final CstMethodRef getRef() {
        return this.method;
    }

    @Override // com.android.dx.util.ToHuman
    public final String toHuman() {
        return this.method.toHuman();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(EncodedMethod.class.getName());
        sb.append('{');
        sb.append(Hex.u2(getAccessFlags()));
        sb.append(' ');
        sb.append(this.method);
        if (this.code != null) {
            sb.append(' ');
            sb.append(this.code);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(EncodedMethod encodedMethod) {
        return this.method.compareTo((Constant) encodedMethod.method);
    }
}
