package com.android.dx.dex.file;

import com.android.dx.rop.cst.CstString;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import com.umeng.ccg.a;
import me.hd.wauxv.obf.dkz;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HeaderItem extends IndexedItem {
    @Override // com.android.dx.dex.file.Item
    public void addContents(DexFile dexFile) {
    }

    @Override // com.android.dx.dex.file.Item
    public ItemType itemType() {
        return ItemType.TYPE_HEADER_ITEM;
    }

    @Override // com.android.dx.dex.file.Item
    public int writeSize() {
        return 112;
    }

    @Override // com.android.dx.dex.file.Item
    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        int fileOffset = dexFile.getMap().getFileOffset();
        Section firstDataSection = dexFile.getFirstDataSection();
        Section lastDataSection = dexFile.getLastDataSection();
        int fileOffset2 = firstDataSection.getFileOffset();
        int iWriteSize = (lastDataSection.writeSize() + lastDataSection.getFileOffset()) - fileOffset2;
        String magic = dexFile.getDexOptions().getMagic();
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(8, "magic: " + new CstString(magic).toQuoted());
            annotatedOutput.annotate(4, "checksum");
            annotatedOutput.annotate(20, a.A);
            annotatedOutput.annotate(4, "file_size:       " + Hex.u4(dexFile.getFileSize()));
            annotatedOutput.annotate(4, "header_size:     " + Hex.u4(112));
            dkz.ab(305419896, new StringBuilder("endian_tag:      "), annotatedOutput, 4);
            annotatedOutput.annotate(4, "link_size:       0");
            annotatedOutput.annotate(4, "link_off:        0");
            dkz.ab(fileOffset, new StringBuilder("map_off:         "), annotatedOutput, 4);
        }
        for (int i = 0; i < 8; i++) {
            annotatedOutput.writeByte(magic.charAt(i));
        }
        annotatedOutput.writeZeroes(24);
        annotatedOutput.writeInt(dexFile.getFileSize());
        annotatedOutput.writeInt(112);
        annotatedOutput.writeInt(305419896);
        annotatedOutput.writeZeroes(8);
        annotatedOutput.writeInt(fileOffset);
        dexFile.getStringIds().writeHeaderPart(annotatedOutput);
        dexFile.getTypeIds().writeHeaderPart(annotatedOutput);
        dexFile.getProtoIds().writeHeaderPart(annotatedOutput);
        dexFile.getFieldIds().writeHeaderPart(annotatedOutput);
        dexFile.getMethodIds().writeHeaderPart(annotatedOutput);
        dexFile.getClassDefs().writeHeaderPart(annotatedOutput);
        if (annotatedOutput.annotates()) {
            annotatedOutput.annotate(4, "data_size:       " + Hex.u4(iWriteSize));
            dkz.ab(fileOffset2, new StringBuilder("data_off:        "), annotatedOutput, 4);
        }
        annotatedOutput.writeInt(iWriteSize);
        annotatedOutput.writeInt(fileOffset2);
    }
}
