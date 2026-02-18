package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dik {
    public static final dap a = new dap("\\r|\\n|\\r\\n");
    public final CodeEditor b;
    public aao c;
    public int d;
    public ArrayList e;
    public int f;
    public boolean g;
    public final acp h;

    public dik(CodeEditor codeEditor) {
        this.b = codeEditor;
        abm abmVar = new abm(0);
        this.d = -1;
        this.f = -1;
        acp acpVar = new acp();
        acpVar.b(new zy(codeEditor.getClipboardManager(), 0));
        acpVar.b(new zy(codeEditor, 1));
        acpVar.b(new abm(1));
        acpVar.b(new abm(2));
        acpVar.b(abmVar);
        this.h = acpVar;
        final int i = 0;
        codeEditor.i.l(dfn.class, new awz(this) { // from class: me.hd.wauxv.obf.dij
            public final /* synthetic */ dik b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                enn ennVar;
                int length;
                boolean z;
                switch (i) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        bzo.q(dfnVar, "event");
                        dik dikVar = this.b;
                        if (dikVar.l()) {
                            if (dikVar.i(dfnVar.a.a) && dikVar.i(dfnVar.l.a)) {
                                return;
                            }
                            dikVar.o();
                            return;
                        }
                        return;
                    default:
                        afh afhVar = (afh) uaVar;
                        bzo.q(afhVar, "event");
                        ud udVar = afhVar.l;
                        CharSequence charSequence = afhVar.n;
                        dik dikVar2 = this.b;
                        boolean zL = dikVar2.l();
                        CodeEditor codeEditor2 = dikVar2.b;
                        if (!zL || dikVar2.g) {
                            return;
                        }
                        int i2 = afhVar.a;
                        if (i2 == 1) {
                            dikVar2.o();
                            return;
                        }
                        if (i2 != 2) {
                            if (i2 == 3) {
                                if (!dikVar2.i(udVar.a) || !dikVar2.i(afhVar.m.a)) {
                                    dikVar2.o();
                                    return;
                                }
                                enr enrVar = codeEditor2.getText().i;
                                if (enrVar.f && (ennVar = enrVar.d) != null) {
                                    enrVar.l(enrVar.e, ennVar);
                                }
                                enrVar.f = false;
                                enrVar.e = null;
                                int length2 = charSequence.length();
                                ctr ctrVarJ = dikVar2.j();
                                bzo.n(ctrVarJ);
                                int i3 = ctrVarJ.c;
                                int i4 = ctrVarJ.d - length2;
                                ctrVarJ.c = i3;
                                ctrVarJ.d = i4;
                                aao aaoVar = dikVar2.c;
                                bzo.n(aaoVar);
                                List<din> list = aaoVar.a;
                                bzo.p(list, "getItems(...)");
                                boolean z2 = false;
                                for (din dinVar : list) {
                                    if (z2) {
                                        int i5 = -length2;
                                        dinVar.c += i5;
                                        dinVar.d += i5;
                                    } else if (bzo.f(dinVar, ctrVarJ)) {
                                        z2 = true;
                                    }
                                }
                                dikVar2.g = true;
                                aff text = codeEditor2.getText();
                                bzo.p(text, "getText(...)");
                                String strAn = text.an(ctrVarJ.c, ctrVarJ.d);
                                text.l();
                                aao aaoVar2 = dikVar2.c;
                                bzo.n(aaoVar2);
                                List list2 = aaoVar2.a;
                                bzo.p(list2, "getItems(...)");
                                int i6 = 0;
                                for (Object obj : list2) {
                                    int i7 = i6 + 1;
                                    if (i6 < 0) {
                                        aba.aj();
                                        throw null;
                                    }
                                    din dinVar2 = (din) obj;
                                    bzo.n(dinVar2);
                                    if (dikVar2.k(dinVar2)) {
                                        int length3 = strAn.length();
                                        int i8 = dinVar2.d;
                                        int i9 = dinVar2.c;
                                        int i10 = length3 - (i8 - i9);
                                        text.ag(i9, i8, strAn);
                                        int i11 = dinVar2.c;
                                        int i12 = dinVar2.d + i10;
                                        dinVar2.c = i11;
                                        dinVar2.d = i12;
                                        dikVar2.m(i7, i10);
                                    }
                                    i6 = i7;
                                }
                                text.u();
                                dikVar2.g = false;
                                return;
                            }
                            return;
                        }
                        if (!dikVar2.i(udVar.a)) {
                            dikVar2.o();
                            return;
                        }
                        bzo.p(charSequence, "getChangedText(...)");
                        if (dik.a.c(charSequence)) {
                            int length4 = charSequence.length();
                            length = 0;
                            while (true) {
                                if (length >= length4) {
                                    length = -1;
                                } else {
                                    char cCharAt = charSequence.charAt(length);
                                    if (cCharAt != '\r' && cCharAt != '\n') {
                                        length++;
                                    }
                                }
                            }
                            z = true;
                        } else {
                            length = charSequence.length();
                            z = false;
                        }
                        ctr ctrVarJ2 = dikVar2.j();
                        bzo.n(ctrVarJ2);
                        int i13 = ctrVarJ2.c;
                        int i14 = ctrVarJ2.d + length;
                        ctrVarJ2.c = i13;
                        ctrVarJ2.d = i14;
                        aao aaoVar3 = dikVar2.c;
                        bzo.n(aaoVar3);
                        List<din> list3 = aaoVar3.a;
                        bzo.p(list3, "getItems(...)");
                        boolean z3 = false;
                        for (din dinVar3 : list3) {
                            if (z3) {
                                int length5 = charSequence.length();
                                dinVar3.c += length5;
                                dinVar3.d += length5;
                            } else if (bzo.f(dinVar3, ctrVarJ2)) {
                                z3 = true;
                            }
                        }
                        dikVar2.g = true;
                        aff text2 = codeEditor2.getText();
                        bzo.p(text2, "getText(...)");
                        String strAn2 = text2.an(ctrVarJ2.c, ctrVarJ2.d);
                        text2.l();
                        aao aaoVar4 = dikVar2.c;
                        bzo.n(aaoVar4);
                        List list4 = aaoVar4.a;
                        bzo.p(list4, "getItems(...)");
                        int i15 = 0;
                        boolean z4 = false;
                        for (Object obj2 : list4) {
                            int i16 = i15 + 1;
                            if (i15 < 0) {
                                aba.aj();
                                throw null;
                            }
                            din dinVar4 = (din) obj2;
                            bzo.n(dinVar4);
                            if (dikVar2.k(dinVar4)) {
                                int length6 = strAn2.length();
                                int i17 = dinVar4.d;
                                int i18 = dinVar4.c;
                                int i19 = length6 - (i17 - i18);
                                text2.ag(i18, i17, strAn2);
                                int i20 = dinVar4.c;
                                int i21 = dinVar4.d + i19;
                                dinVar4.c = i20;
                                dinVar4.d = i21;
                                dikVar2.m(i16, i19);
                                z4 = true;
                            }
                            i15 = i16;
                        }
                        text2.u();
                        dikVar2.g = false;
                        if (z) {
                            dikVar2.o();
                            return;
                        } else {
                            if (z4) {
                                aro aroVar = codeEditor2.bx;
                                bzo.p(aroVar, "getComponent(...)");
                                aroVar.v();
                                return;
                            }
                            return;
                        }
                }
            }
        });
        final int i2 = 1;
        codeEditor.i.l(afh.class, new awz(this) { // from class: me.hd.wauxv.obf.dij
            public final /* synthetic */ dik b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.awz
            public final void g(ua uaVar, afc afcVar) {
                enn ennVar;
                int length;
                boolean z;
                switch (i2) {
                    case 0:
                        dfn dfnVar = (dfn) uaVar;
                        bzo.q(dfnVar, "event");
                        dik dikVar = this.b;
                        if (dikVar.l()) {
                            if (dikVar.i(dfnVar.a.a) && dikVar.i(dfnVar.l.a)) {
                                return;
                            }
                            dikVar.o();
                            return;
                        }
                        return;
                    default:
                        afh afhVar = (afh) uaVar;
                        bzo.q(afhVar, "event");
                        ud udVar = afhVar.l;
                        CharSequence charSequence = afhVar.n;
                        dik dikVar2 = this.b;
                        boolean zL = dikVar2.l();
                        CodeEditor codeEditor2 = dikVar2.b;
                        if (!zL || dikVar2.g) {
                            return;
                        }
                        int i22 = afhVar.a;
                        if (i22 == 1) {
                            dikVar2.o();
                            return;
                        }
                        if (i22 != 2) {
                            if (i22 == 3) {
                                if (!dikVar2.i(udVar.a) || !dikVar2.i(afhVar.m.a)) {
                                    dikVar2.o();
                                    return;
                                }
                                enr enrVar = codeEditor2.getText().i;
                                if (enrVar.f && (ennVar = enrVar.d) != null) {
                                    enrVar.l(enrVar.e, ennVar);
                                }
                                enrVar.f = false;
                                enrVar.e = null;
                                int length2 = charSequence.length();
                                ctr ctrVarJ = dikVar2.j();
                                bzo.n(ctrVarJ);
                                int i3 = ctrVarJ.c;
                                int i4 = ctrVarJ.d - length2;
                                ctrVarJ.c = i3;
                                ctrVarJ.d = i4;
                                aao aaoVar = dikVar2.c;
                                bzo.n(aaoVar);
                                List<din> list = aaoVar.a;
                                bzo.p(list, "getItems(...)");
                                boolean z2 = false;
                                for (din dinVar : list) {
                                    if (z2) {
                                        int i5 = -length2;
                                        dinVar.c += i5;
                                        dinVar.d += i5;
                                    } else if (bzo.f(dinVar, ctrVarJ)) {
                                        z2 = true;
                                    }
                                }
                                dikVar2.g = true;
                                aff text = codeEditor2.getText();
                                bzo.p(text, "getText(...)");
                                String strAn = text.an(ctrVarJ.c, ctrVarJ.d);
                                text.l();
                                aao aaoVar2 = dikVar2.c;
                                bzo.n(aaoVar2);
                                List list2 = aaoVar2.a;
                                bzo.p(list2, "getItems(...)");
                                int i6 = 0;
                                for (Object obj : list2) {
                                    int i7 = i6 + 1;
                                    if (i6 < 0) {
                                        aba.aj();
                                        throw null;
                                    }
                                    din dinVar2 = (din) obj;
                                    bzo.n(dinVar2);
                                    if (dikVar2.k(dinVar2)) {
                                        int length3 = strAn.length();
                                        int i8 = dinVar2.d;
                                        int i9 = dinVar2.c;
                                        int i10 = length3 - (i8 - i9);
                                        text.ag(i9, i8, strAn);
                                        int i11 = dinVar2.c;
                                        int i12 = dinVar2.d + i10;
                                        dinVar2.c = i11;
                                        dinVar2.d = i12;
                                        dikVar2.m(i7, i10);
                                    }
                                    i6 = i7;
                                }
                                text.u();
                                dikVar2.g = false;
                                return;
                            }
                            return;
                        }
                        if (!dikVar2.i(udVar.a)) {
                            dikVar2.o();
                            return;
                        }
                        bzo.p(charSequence, "getChangedText(...)");
                        if (dik.a.c(charSequence)) {
                            int length4 = charSequence.length();
                            length = 0;
                            while (true) {
                                if (length >= length4) {
                                    length = -1;
                                } else {
                                    char cCharAt = charSequence.charAt(length);
                                    if (cCharAt != '\r' && cCharAt != '\n') {
                                        length++;
                                    }
                                }
                            }
                            z = true;
                        } else {
                            length = charSequence.length();
                            z = false;
                        }
                        ctr ctrVarJ2 = dikVar2.j();
                        bzo.n(ctrVarJ2);
                        int i13 = ctrVarJ2.c;
                        int i14 = ctrVarJ2.d + length;
                        ctrVarJ2.c = i13;
                        ctrVarJ2.d = i14;
                        aao aaoVar3 = dikVar2.c;
                        bzo.n(aaoVar3);
                        List<din> list3 = aaoVar3.a;
                        bzo.p(list3, "getItems(...)");
                        boolean z3 = false;
                        for (din dinVar3 : list3) {
                            if (z3) {
                                int length5 = charSequence.length();
                                dinVar3.c += length5;
                                dinVar3.d += length5;
                            } else if (bzo.f(dinVar3, ctrVarJ2)) {
                                z3 = true;
                            }
                        }
                        dikVar2.g = true;
                        aff text2 = codeEditor2.getText();
                        bzo.p(text2, "getText(...)");
                        String strAn2 = text2.an(ctrVarJ2.c, ctrVarJ2.d);
                        text2.l();
                        aao aaoVar4 = dikVar2.c;
                        bzo.n(aaoVar4);
                        List list4 = aaoVar4.a;
                        bzo.p(list4, "getItems(...)");
                        int i15 = 0;
                        boolean z4 = false;
                        for (Object obj2 : list4) {
                            int i16 = i15 + 1;
                            if (i15 < 0) {
                                aba.aj();
                                throw null;
                            }
                            din dinVar4 = (din) obj2;
                            bzo.n(dinVar4);
                            if (dikVar2.k(dinVar4)) {
                                int length6 = strAn2.length();
                                int i17 = dinVar4.d;
                                int i18 = dinVar4.c;
                                int i19 = length6 - (i17 - i18);
                                text2.ag(i18, i17, strAn2);
                                int i20 = dinVar4.c;
                                int i21 = dinVar4.d + i19;
                                dinVar4.c = i20;
                                dinVar4.d = i21;
                                dikVar2.m(i16, i19);
                                z4 = true;
                            }
                            i15 = i16;
                        }
                        text2.u();
                        dikVar2.g = false;
                        if (z) {
                            dikVar2.o();
                            return;
                        } else {
                            if (z4) {
                                aro aroVar = codeEditor2.bx;
                                bzo.p(aroVar, "getComponent(...)");
                                aroVar.v();
                                return;
                            }
                            return;
                        }
                }
            }
        });
    }

    public final boolean i(int i) {
        ctr ctrVarJ = j();
        bzo.n(ctrVarJ);
        return i >= ctrVarJ.c && i <= ctrVarJ.d;
    }

    public final ctr j() {
        if (this.d == -1) {
            return null;
        }
        ArrayList arrayList = this.e;
        bzo.n(arrayList);
        return (ctr) arrayList.get(this.f);
    }

    public final boolean k(din dinVar) {
        ctr ctrVarJ = j();
        return ctrVarJ != null && (dinVar instanceof ctr) && bzo.f(((ctr) dinVar).a, ctrVarJ.a) && !dinVar.equals(ctrVarJ);
    }

    public final boolean l() {
        return (this.d == -1 || this.f == -1) ? false : true;
    }

    public final void m(int i, int i2) {
        if (i2 == 0) {
            return;
        }
        aao aaoVar = this.c;
        bzo.n(aaoVar);
        List list = aaoVar.a;
        bzo.n(list);
        int size = list.size();
        while (i < size) {
            din dinVar = (din) list.get(i);
            dinVar.c += i2;
            dinVar.d += i2;
            i++;
        }
    }

    public final void n(int i) {
        if (this.d == -1) {
            return;
        }
        int i2 = this.f;
        CodeEditor codeEditor = this.b;
        if (i != i2 && i2 != -1) {
            ArrayList arrayList = this.e;
            bzo.n(arrayList);
            ctr ctrVar = (ctr) arrayList.get(this.f);
            if (ctrVar.a.d != null) {
                codeEditor.getText().ag(ctrVar.c, ctrVar.d, cnh.s(codeEditor.getText().an(ctrVar.c, ctrVar.d), ctrVar.a.d));
            }
        }
        ArrayList arrayList2 = this.e;
        bzo.n(arrayList2);
        ctr ctrVar2 = (ctr) arrayList2.get(i);
        sq sqVarX = codeEditor.getText().x();
        ud udVarN = sqVarX.n(ctrVar2.c);
        ud udVarN2 = sqVarX.n(ctrVar2.d);
        this.f = i;
        codeEditor.er(udVarN.b, udVarN.c, udVarN2.b, udVarN2.c);
        ArrayList arrayList3 = this.e;
        bzo.n(arrayList3);
        arrayList3.size();
        codeEditor.i.g(new dim(codeEditor, 2));
        bzo.n(this.e);
        if (i == r0.size() - 1) {
            o();
        }
    }

    public final void o() {
        if (l()) {
            this.c = null;
            this.d = -1;
            this.e = null;
            this.f = -1;
            CodeEditor codeEditor = this.b;
            codeEditor.i.g(new dim(codeEditor, 3));
            codeEditor.invalidate();
        }
    }
}
