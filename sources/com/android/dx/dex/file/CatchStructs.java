package com.android.dx.dex.file;

import com.android.dx.dex.code.CatchHandlerList;
import com.android.dx.dex.code.CatchTable;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.android.dx.util.Hex;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import me.hd.wauxv.obf.StaticHelpers6;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CatchStructs {
    private static final int TRY_ITEM_WRITE_SIZE = 8;
    private final DalvCode code;
    private CatchTable table = null;
    private byte[] encodedHandlers = null;
    private int encodedHandlerHeaderSize = 0;
    private TreeMap<CatchHandlerList, Integer> handlerOffsets = null;

    public CatchStructs(DalvCode dalvCode) {
        this.code = dalvCode;
    }

    private static void annotateAndConsumeHandlers(CatchHandlerList catchHandlerList, int i, int i2, String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        String human = catchHandlerList.toHuman(str, Hex.u2(i) + ": ");
        if (printWriter != null) {
            printWriter.println(human);
        }
        annotatedOutput.annotate(i2, human);
    }

    private void annotateEntries(String str, PrintWriter printWriter, AnnotatedOutput annotatedOutput) {
        PrintWriter printWriter2;
        AnnotatedOutput annotatedOutput2;
        finishProcessingIfNecessary();
        int iIntValue = 0;
        boolean z = annotatedOutput != null;
        int i = z ? 6 : 0;
        int i2 = z ? 2 : 0;
        int size = this.table.size();
        String strS = StaticHelpers6.concat(str, "  ");
        if (z) {
            annotatedOutput.annotate(0, str + "tries:");
        } else {
            printWriter.println(str + "tries:");
        }
        for (int i3 = 0; i3 < size; i3++) {
            CatchTable.Entry entry = this.table.get(i3);
            CatchHandlerList handlers = entry.getHandlers();
            StringBuilder sbR = concat(strS, "try ");
            sbR.append(Hex.u2or4(entry.getStart()));
            sbR.append("..");
            sbR.append(Hex.u2or4(entry.getEnd()));
            String string = sbR.toString();
            String human = handlers.toHuman(strS, "");
            if (z) {
                annotatedOutput.annotate(i, string);
                annotatedOutput.annotate(i2, human);
            } else {
                printWriter.println(string);
                printWriter.println(human);
            }
        }
        if (!z) {
            return;
        }
        annotatedOutput.annotate(0, str + "handlers:");
        int i4 = this.encodedHandlerHeaderSize;
        StringBuilder sbR2 = concat(strS, "size: ");
        sbR2.append(Hex.u2(this.handlerOffsets.size()));
        annotatedOutput.annotate(i4, sbR2.toString());
        Iterator<Map.Entry<CatchHandlerList, Integer>> it = this.handlerOffsets.entrySet().iterator();
        CatchHandlerList key = null;
        while (true) {
            int i5 = iIntValue;
            CatchHandlerList catchHandlerList = key;
            if (!it.hasNext()) {
                annotateAndConsumeHandlers(catchHandlerList, i5, this.encodedHandlers.length - i5, strS, printWriter, annotatedOutput);
                return;
            }
            Map.Entry<CatchHandlerList, Integer> next = it.next();
            key = next.getKey();
            iIntValue = next.getValue().intValue();
            if (catchHandlerList != null) {
                printWriter2 = printWriter;
                annotatedOutput2 = annotatedOutput;
                annotateAndConsumeHandlers(catchHandlerList, i5, iIntValue - i5, strS, printWriter2, annotatedOutput2);
            } else {
                printWriter2 = printWriter;
                annotatedOutput2 = annotatedOutput;
            }
            printWriter = printWriter2;
            annotatedOutput = annotatedOutput2;
        }
    }

    private void finishProcessingIfNecessary() {
        if (this.table == null) {
            this.table = this.code.getCatches();
        }
    }

    public void debugPrint(PrintWriter printWriter, String str) {
        annotateEntries(str, printWriter, null);
    }

    public void encode(DexFile dexFile) {
        finishProcessingIfNecessary();
        TypeIdsSection typeIds = dexFile.getTypeIds();
        int size = this.table.size();
        this.handlerOffsets = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            this.handlerOffsets.put(this.table.get(i).getHandlers(), null);
        }
        if (this.handlerOffsets.size() > 65535) {
            throw new UnsupportedOperationException("too many catch handlers");
        }
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput();
        this.encodedHandlerHeaderSize = byteArrayAnnotatedOutput.writeUleb128(this.handlerOffsets.size());
        for (Map.Entry<CatchHandlerList, Integer> entry : this.handlerOffsets.entrySet()) {
            CatchHandlerList key = entry.getKey();
            int size2 = key.size();
            boolean zCatchesAll = key.catchesAll();
            entry.setValue(Integer.valueOf(byteArrayAnnotatedOutput.getCursor()));
            if (zCatchesAll) {
                byteArrayAnnotatedOutput.writeSleb128(-(size2 - 1));
                size2--;
            } else {
                byteArrayAnnotatedOutput.writeSleb128(size2);
            }
            for (int i2 = 0; i2 < size2; i2++) {
                CatchHandlerList.Entry entry2 = key.get(i2);
                byteArrayAnnotatedOutput.writeUleb128(typeIds.indexOf(entry2.getExceptionType()));
                byteArrayAnnotatedOutput.writeUleb128(entry2.getHandler());
            }
            if (zCatchesAll) {
                byteArrayAnnotatedOutput.writeUleb128(key.get(size2).getHandler());
            }
        }
        this.encodedHandlers = byteArrayAnnotatedOutput.toByteArray();
    }

    public int triesSize() {
        finishProcessingIfNecessary();
        return this.table.size();
    }

    public int writeSize() {
        return (triesSize() * 8) + this.encodedHandlers.length;
    }

    public void writeTo(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        finishProcessingIfNecessary();
        if (annotatedOutput.annotates()) {
            annotateEntries("  ", null, annotatedOutput);
        }
        int size = this.table.size();
        for (int i = 0; i < size; i++) {
            CatchTable.Entry entry = this.table.get(i);
            int start = entry.getStart();
            int end = entry.getEnd();
            int i2 = end - start;
            if (i2 >= 65536) {
                throw new UnsupportedOperationException("bogus exception range: " + Hex.u4(start) + ".." + Hex.u4(end));
            }
            annotatedOutput.writeInt(start);
            annotatedOutput.writeShort(i2);
            annotatedOutput.writeShort(this.handlerOffsets.get(entry.getHandlers()).intValue());
        }
        annotatedOutput.write(this.encodedHandlers);
    }
}
