package com.android.dx.command.findusages;

import com.android.dx.io.CodeReader;
import com.android.dx.io.OpcodeInfo;
import com.android.dx.io.instructions.DecodedInstruction;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;
import me.hd.wauxv.obf.amh;
import me.hd.wauxv.obf.ami;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.azh;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cdi;
import me.hd.wauxv.obf.emd;
import me.hd.wauxv.obf.ys;
import me.hd.wauxv.obf.yt;
import me.hd.wauxv.obf.yv;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FindUsages {
    private final CodeReader codeReader = new CodeReader();
    private yx currentClass;
    private yt currentMethod;
    private final amk dex;
    private final Set<Integer> fieldIds;
    private final Set<Integer> methodIds;
    private final PrintWriter out;

    public FindUsages(final amk amkVar, String str, String str2, final PrintWriter printWriter) {
        this.dex = amkVar;
        this.out = printWriter;
        HashSet<Integer> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Pattern patternCompile = Pattern.compile(str);
        Pattern patternCompile2 = Pattern.compile(str2);
        ami amiVar = amkVar.e;
        for (int i = 0; i < amiVar.size(); i++) {
            String str3 = (String) amiVar.get(i);
            if (patternCompile.matcher(str3).matches()) {
                hashSet.add(Integer.valueOf(i));
            }
            if (patternCompile2.matcher(str3).matches()) {
                hashSet2.add(Integer.valueOf(i));
            }
        }
        if (hashSet.isEmpty() || hashSet2.isEmpty()) {
            this.fieldIds = null;
            this.methodIds = null;
            return;
        }
        this.methodIds = new HashSet();
        this.fieldIds = new HashSet();
        for (Integer num : hashSet) {
            num.intValue();
            int iBinarySearch = Collections.binarySearch(amkVar.f, num);
            if (iBinarySearch >= 0) {
                this.methodIds.addAll(getMethodIds(amkVar, hashSet2, iBinarySearch));
                this.fieldIds.addAll(getFieldIds(amkVar, hashSet2, iBinarySearch));
            }
        }
        this.codeReader.setFieldVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.findusages.FindUsages.1
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                int index = decodedInstruction.getIndex();
                if (FindUsages.this.fieldIds.contains(Integer.valueOf(index))) {
                    printWriter.println(FindUsages.this.location() + ": field reference " + amkVar.i.get(index) + " (" + OpcodeInfo.getName(decodedInstruction.getOpcode()) + ")");
                }
            }
        });
        this.codeReader.setMethodVisitor(new CodeReader.Visitor() { // from class: com.android.dx.command.findusages.FindUsages.2
            @Override // com.android.dx.io.CodeReader.Visitor
            public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
                int index = decodedInstruction.getIndex();
                if (FindUsages.this.methodIds.contains(Integer.valueOf(index))) {
                    printWriter.println(FindUsages.this.location() + ": method reference " + amkVar.j.get(index) + " (" + OpcodeInfo.getName(decodedInstruction.getOpcode()) + ")");
                }
            }
        });
    }

    private Set<Integer> findAssignableTypes(amk amkVar, int i) {
        emd emdVarH;
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i));
        amkVar.getClass();
        Iterator it = !amkVar.c.g.e() ? Collections.EMPTY_SET.iterator() : new amh(amkVar);
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            int i2 = yxVar.e;
            int i3 = yxVar.c;
            if (hashSet.contains(Integer.valueOf(i2))) {
                hashSet.add(Integer.valueOf(i3));
            } else {
                amk amkVar2 = yxVar.a;
                int i4 = yxVar.f;
                if (i4 == 0) {
                    amkVar2.getClass();
                    emdVarH = emd.a;
                } else {
                    emdVarH = amkVar2.n(i4).h();
                }
                for (short s : emdVarH.c) {
                    if (hashSet.contains(Integer.valueOf(s))) {
                        hashSet.add(Integer.valueOf(i3));
                        break;
                    }
                }
            }
        }
        return hashSet;
    }

    private Set<Integer> getFieldIds(amk amkVar, Set<Integer> set, int i) {
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (azh azhVar : amkVar.i) {
            if (set.contains(Integer.valueOf(azhVar.d)) && i == azhVar.b) {
                hashSet.add(Integer.valueOf(i2));
            }
            i2++;
        }
        return hashSet;
    }

    private Set<Integer> getMethodIds(amk amkVar, Set<Integer> set, int i) {
        Set<Integer> setFindAssignableTypes = findAssignableTypes(amkVar, i);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        for (cdi cdiVar : amkVar.j) {
            if (set.contains(Integer.valueOf(cdiVar.d)) && setFindAssignableTypes.contains(Integer.valueOf(cdiVar.b))) {
                hashSet.add(Integer.valueOf(i2));
            }
            i2++;
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String location() {
        String str = (String) this.dex.g.get(this.currentClass.c);
        yt ytVar = this.currentMethod;
        if (ytVar == null) {
            return str;
        }
        cdi cdiVar = (cdi) this.dex.j.get(ytVar.a);
        StringBuilder sbR = bjs.r(str, ".");
        sbR.append((String) this.dex.e.get(cdiVar.d));
        return sbR.toString();
    }

    public void findUsages() {
        if (this.fieldIds == null || this.methodIds == null) {
            return;
        }
        amk amkVar = this.dex;
        amkVar.getClass();
        Iterator it = !amkVar.c.g.e() ? Collections.EMPTY_SET.iterator() : new amh(amkVar);
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            this.currentClass = yxVar;
            this.currentMethod = null;
            if (yxVar.i != 0) {
                yv yvVarO = this.dex.o(yxVar);
                ys[] ysVarArr = yvVarO.a;
                int length = ysVarArr.length;
                ys[] ysVarArr2 = yvVarO.b;
                int length2 = length + ysVarArr2.length;
                ys[] ysVarArr3 = new ys[length2];
                System.arraycopy(ysVarArr, 0, ysVarArr3, 0, ysVarArr.length);
                System.arraycopy(ysVarArr2, 0, ysVarArr3, ysVarArr.length, ysVarArr2.length);
                for (int i = 0; i < length2; i++) {
                    int i2 = ysVarArr3[i].a;
                    if (this.fieldIds.contains(Integer.valueOf(i2))) {
                        this.out.println(location() + " field declared " + this.dex.i.get(i2));
                    }
                }
                yt[] ytVarArr = yvVarO.c;
                int length3 = ytVarArr.length;
                yt[] ytVarArr2 = yvVarO.d;
                int length4 = length3 + ytVarArr2.length;
                yt[] ytVarArr3 = new yt[length4];
                System.arraycopy(ytVarArr, 0, ytVarArr3, 0, ytVarArr.length);
                System.arraycopy(ytVarArr2, 0, ytVarArr3, ytVarArr.length, ytVarArr2.length);
                for (int i3 = 0; i3 < length4; i3++) {
                    yt ytVar = ytVarArr3[i3];
                    this.currentMethod = ytVar;
                    int i4 = ytVar.a;
                    if (this.methodIds.contains(Integer.valueOf(i4))) {
                        this.out.println(location() + " method declared " + this.dex.j.get(i4));
                    }
                    if (ytVar.c != 0) {
                        this.codeReader.visitAll(this.dex.p(ytVar).e);
                    }
                }
            }
        }
        this.currentClass = null;
        this.currentMethod = null;
    }
}
