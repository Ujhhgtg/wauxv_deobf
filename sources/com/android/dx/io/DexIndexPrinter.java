package com.android.dx.io;

import java.io.File;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import me.hd.wauxv.obf.amh;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.azh;
import me.hd.wauxv.obf.cdi;
import me.hd.wauxv.obf.cwe;
import me.hd.wauxv.obf.dpr;
import me.hd.wauxv.obf.dps;
import me.hd.wauxv.obf.yg;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DexIndexPrinter {
    private final amk dex;
    private final dps tableOfContents;

    public DexIndexPrinter(File file) {
        amk amkVar = new amk(file);
        this.dex = amkVar;
        this.tableOfContents = amkVar.c;
    }

    public static void main(String[] strArr) {
        DexIndexPrinter dexIndexPrinter = new DexIndexPrinter(new File(strArr[0]));
        dexIndexPrinter.printMap();
        dexIndexPrinter.printStrings();
        dexIndexPrinter.printTypeIds();
        dexIndexPrinter.printProtoIds();
        dexIndexPrinter.printFieldIds();
        dexIndexPrinter.printMethodIds();
        dexIndexPrinter.printTypeLists();
        dexIndexPrinter.printClassDefs();
    }

    private void printClassDefs() {
        amk amkVar = this.dex;
        amkVar.getClass();
        Iterator it = !amkVar.c.g.e() ? Collections.EMPTY_SET.iterator() : new amh(amkVar);
        int i = 0;
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            System.out.println("class def " + i + ": " + yxVar);
            i++;
        }
    }

    private void printFieldIds() {
        int i = 0;
        for (azh azhVar : this.dex.i) {
            System.out.println("field " + i + ": " + azhVar);
            i++;
        }
    }

    private void printMap() {
        for (dpr dprVar : this.tableOfContents.u) {
            if (dprVar.c != -1) {
                System.out.println("section " + Integer.toHexString(dprVar.a) + " off=" + Integer.toHexString(dprVar.c) + " size=" + Integer.toHexString(dprVar.b) + " byteCount=" + Integer.toHexString(dprVar.d));
            }
        }
    }

    private void printMethodIds() {
        int i = 0;
        for (cdi cdiVar : this.dex.j) {
            System.out.println("methodId " + i + ": " + cdiVar);
            i++;
        }
    }

    private void printProtoIds() {
        int i = 0;
        for (cwe cweVar : this.dex.h) {
            System.out.println("proto " + i + ": " + cweVar);
            i++;
        }
    }

    private void printStrings() {
        int i = 0;
        for (String str : this.dex.e) {
            System.out.println("string " + i + ": " + str);
            i++;
        }
    }

    private void printTypeIds() {
        int i = 0;
        for (Integer num : this.dex.f) {
            PrintStream printStream = System.out;
            StringBuilder sbR = yg.concatVar213(i, "type ", ": ");
            sbR.append((String) this.dex.e.get(num.intValue()));
            printStream.println(sbR.toString());
            i++;
        }
    }

    private void printTypeLists() {
        int i = this.tableOfContents.k.c;
        if (i == -1) {
            System.out.println("No type lists");
            return;
        }
        ByteBuffer byteBuffer = this.dex.n(i).b;
        for (int i2 = 0; i2 < this.tableOfContents.k.b; i2++) {
            int i3 = byteBuffer.getInt();
            System.out.print("Type list i=" + i2 + ", size=" + i3 + ", elements=");
            for (int i4 = 0; i4 < i3; i4++) {
                System.out.print(" ".concat((String) this.dex.g.get(byteBuffer.getShort())));
            }
            if (i3 % 2 == 1) {
                byteBuffer.getShort();
            }
            System.out.println();
        }
    }
}
