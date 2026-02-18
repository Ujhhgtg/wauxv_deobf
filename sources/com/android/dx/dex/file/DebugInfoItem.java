package com.android.dx.dex.file;

import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.DalvInsnList;
import com.android.dx.dex.code.LocalList;
import com.android.dx.dex.code.PositionList;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.util.AnnotatedOutput;
import java.io.PrintWriter;
import me.hd.wauxv.obf.axc;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DebugInfoItem extends OffsettedItem {
    private static final int ALIGNMENT = 1;
    private static final boolean ENABLE_ENCODER_SELF_CHECK = false;
    private final DalvCode code;
    private byte[] encoded;
    private final boolean isStatic;
    private final CstMethodRef ref;

    public DebugInfoItem(DalvCode dalvCode, boolean z, CstMethodRef cstMethodRef) {
        super(1, -1);
        if (dalvCode == null) {
            throw new NullPointerException("code == null");
        }
        this.code = dalvCode;
        this.isStatic = z;
        this.ref = cstMethodRef;
    }

    private byte[] encode(DexFile dexFile, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z) {
        return encode0(dexFile, str, printWriter, annotatedOutput, z);
    }

    private byte[] encode0(DexFile dexFile, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput, boolean z) {
        PositionList positions = this.code.getPositions();
        LocalList locals = this.code.getLocals();
        DalvInsnList insns = this.code.getInsns();
        DebugInfoEncoder debugInfoEncoder = new DebugInfoEncoder(positions, locals, dexFile, insns.codeSize(), insns.getRegistersSize(), this.isStatic, this.ref);
        return (printWriter == null && annotatedOutput == null) ? debugInfoEncoder.convert() : debugInfoEncoder.convertAndAnnotate(str, printWriter, annotatedOutput, z);
    }

    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
    }

    public void annotateTo(DexFile dexFile, AnnotatedOutput annotatedOutput, String str) {
        encode(dexFile, str, null, annotatedOutput, false);
    }

    public void debugPrint(PrintWriter printWriter, String str) {
        encode(null, str, printWriter, null, false);
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_DEBUG_INFO_ITEM;
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void place0(Section section, int i) {
        DebugInfoItem debugInfoItem;
        try {
            debugInfoItem = this;
        } catch (RuntimeException e) {
            e = e;
            debugInfoItem = this;
        }
        try {
            byte[] bArrEncode = debugInfoItem.encode(section.getFile(), null, null, null, false);
            debugInfoItem.encoded = bArrEncode;
            setWriteSize(bArrEncode.length);
        } catch (RuntimeException e2) {
            e = e2;
            throw axc.withContext(e, "...while placing debug info for " + debugInfoItem.ref.toHuman());
        }
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public String toHuman() {
        throw new RuntimeException("unsupported");
    }

    @Override // com.android.dx.dex.file.OffsettedItem
    public void writeTo0(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        DebugInfoItem debugInfoItem;
        AnnotatedOutput annotatedOutput2;
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(offsetString() + " debug info");
            debugInfoItem = this;
            annotatedOutput2 = annotatedOutput;
            debugInfoItem.encode(dexFile, null, null, annotatedOutput2, true);
        } else {
            debugInfoItem = this;
            annotatedOutput2 = annotatedOutput;
        }
        annotatedOutput2.write(debugInfoItem.encoded);
    }
}
