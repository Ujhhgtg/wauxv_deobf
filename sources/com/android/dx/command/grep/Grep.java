package com.android.dx.command.grep;

import com.android.dx.io.CodeReader;
import com.android.dx.io.instructions.DecodedInstruction;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.amh;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.avs;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cdi;
import me.hd.wauxv.obf.yt;
import me.hd.wauxv.obf.yv;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Grep {
    private final CodeReader codeReader;
    private int count;
    private yx currentClass;
    private yt currentMethod;
    private final amk dex;
    private final PrintWriter out;
    private final Set<Integer> stringIds;

    public Grep(amk amkVar, Pattern pattern, PrintWriter printWriter) {
        CodeReader codeReader = new CodeReader();
        this.codeReader = codeReader;
        this.count = 0;
        this.dex = amkVar;
        this.out = printWriter;
        this.stringIds = getStringIds(amkVar, pattern);
        codeReader.setStringVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.grep.Grep.1
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                Grep.this.encounterString(decodedInstruction.getIndex());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encounterString(int i) {
        if (this.stringIds.contains(Integer.valueOf(i))) {
            this.out.println(location() + " " + ((String) this.dex.e.get(i)));
            this.count = this.count + 1;
        }
    }

    private Set<Integer> getStringIds(amk amkVar, Pattern pattern) {
        HashSet hashSet = new HashSet();
        Iterator it = amkVar.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (pattern.matcher((String) it.next()).find()) {
                hashSet.add(Integer.valueOf(i));
            }
            i++;
        }
        return hashSet;
    }

    private String location() {
        String str = (String) this.dex.g.get(this.currentClass.c);
        yt ytVar = this.currentMethod;
        if (ytVar == null) {
            return str;
        }
        cdi cdiVar = (cdi) this.dex.j.get(ytVar.a);
        StringBuilder sbR = concat(str, ".");
        sbR.append((String) this.dex.e.get(cdiVar.d));
        return sbR.toString();
    }

    private void readArray(avs avsVar) {
        avsVar.e(28);
        avsVar.b = -1;
        int iAc = ajn.ac(avsVar.a);
        for (int i = 0; i < iAc; i++) {
            int iF = avsVar.f();
            if (iF == 23) {
                encounterString(avsVar.j());
            } else if (iF == 28) {
                readArray(avsVar);
            }
        }
    }

    public int grep() {
        amk amkVar = this.dex;
        amkVar.getClass();
        Iterator it = !amkVar.c.g.e() ? Collections.EMPTY_SET.iterator() : new amh(amkVar);
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            this.currentClass = yxVar;
            this.currentMethod = null;
            if (yxVar.i != 0) {
                yv yvVarO = this.dex.o(yxVar);
                int i = yxVar.j;
                if (i != 0) {
                    readArray(new avs(this.dex.n(i)));
                }
                yt[] ytVarArr = yvVarO.c;
                int length = ytVarArr.length;
                yt[] ytVarArr2 = yvVarO.d;
                int length2 = length + ytVarArr2.length;
                yt[] ytVarArr3 = new yt[length2];
                System.arraycopy(ytVarArr, 0, ytVarArr3, 0, ytVarArr.length);
                System.arraycopy(ytVarArr2, 0, ytVarArr3, ytVarArr.length, ytVarArr2.length);
                for (int i2 = 0; i2 < length2; i2++) {
                    yt ytVar = ytVarArr3[i2];
                    this.currentMethod = ytVar;
                    if (ytVar.c != 0) {
                        this.codeReader.visitAll(this.dex.p(ytVar).e);
                    }
                }
            }
        }
        this.currentClass = null;
        this.currentMethod = null;
        return this.count;
    }
}
