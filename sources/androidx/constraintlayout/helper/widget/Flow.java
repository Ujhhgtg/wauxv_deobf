package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import me.hd.wauxv.obf.adb;
import me.hd.wauxv.obf.adg;
import me.hd.wauxv.obf.adq;
import me.hd.wauxv.obf.adr;
import me.hd.wauxv.obf.bbo;
import me.hd.wauxv.obf.bbp;
import me.hd.wauxv.obf.bjp;
import me.hd.wauxv.obf.cxx;
import me.hd.wauxv.obf.esw;
import me.hd.wauxv.obf.of;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Flow extends esw {
    public final bbp a;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new int[32];
        this.k = new HashMap();
        this.g = context;
        super.r(attributeSet);
        bbp bbpVar = new bbp();
        bbpVar.a = 0;
        bbpVar.b = 0;
        bbpVar.c = 0;
        bbpVar.d = 0;
        bbpVar.i = 0;
        bbpVar.j = 0;
        bbpVar.dn = false;
        bbpVar.f1do = 0;
        bbpVar.dp = 0;
        bbpVar.dq = new of();
        bbpVar.dr = null;
        bbpVar.ds = -1;
        bbpVar.dt = -1;
        bbpVar.du = -1;
        bbpVar.dv = -1;
        bbpVar.dw = -1;
        bbpVar.dx = -1;
        bbpVar.dy = 0.5f;
        bbpVar.dz = 0.5f;
        bbpVar.ea = 0.5f;
        bbpVar.eb = 0.5f;
        bbpVar.ec = 0.5f;
        bbpVar.ed = 0.5f;
        bbpVar.ee = 0;
        bbpVar.ef = 0;
        bbpVar.eg = 2;
        bbpVar.eh = 2;
        bbpVar.ei = 0;
        bbpVar.ej = -1;
        bbpVar.ek = 0;
        bbpVar.el = new ArrayList();
        bbpVar.em = null;
        bbpVar.en = null;
        bbpVar.eo = null;
        bbpVar.eq = 0;
        this.a = bbpVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, cxx.b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    this.a.ek = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    bbp bbpVar2 = this.a;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    bbpVar2.a = dimensionPixelSize;
                    bbpVar2.b = dimensionPixelSize;
                    bbpVar2.c = dimensionPixelSize;
                    bbpVar2.d = dimensionPixelSize;
                } else if (index == 18) {
                    bbp bbpVar3 = this.a;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    bbpVar3.c = dimensionPixelSize2;
                    bbpVar3.i = dimensionPixelSize2;
                    bbpVar3.j = dimensionPixelSize2;
                } else if (index == 19) {
                    this.a.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.a.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.a.a = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.a.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.a.b = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.a.ei = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.a.ds = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.a.dt = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.a.du = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.a.dw = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.a.dv = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.a.dx = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.a.dy = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.a.ea = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.a.ec = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.a.eb = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.a.ed = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.a.dz = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.a.eg = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.a.eh = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.a.ee = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.a.ef = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.a.ej = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.h = this.a;
        s();
    }

    @Override // me.hd.wauxv.obf.add
    public final void b(adq adqVar, boolean z) {
        bbp bbpVar = this.a;
        int i = bbpVar.c;
        if (i > 0 || bbpVar.d > 0) {
            if (z) {
                bbpVar.i = bbpVar.d;
                bbpVar.j = i;
            } else {
                bbpVar.i = i;
                bbpVar.j = bbpVar.d;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:109:0x01e4  */
    /* JADX WARN: Found duplicated region for block: B:111:0x0201  */
    /* JADX WARN: Found duplicated region for block: B:113:0x0209  */
    /* JADX WARN: Found duplicated region for block: B:116:0x021e  */
    /* JADX WARN: Found duplicated region for block: B:118:0x0226  */
    /* JADX WARN: Found duplicated region for block: B:120:0x0237  */
    /* JADX WARN: Found duplicated region for block: B:136:0x025a  */
    /* JADX WARN: Found duplicated region for block: B:138:0x0273  */
    /* JADX WARN: Found duplicated region for block: B:140:0x0277  */
    /* JADX WARN: Found duplicated region for block: B:149:0x02a0  */
    /* JADX WARN: Found duplicated region for block: B:154:0x02a9  */
    /* JADX WARN: Found duplicated region for block: B:156:0x02b1  */
    /* JADX WARN: Found duplicated region for block: B:157:0x02bb  */
    /* JADX WARN: Found duplicated region for block: B:161:0x02dc  */
    /* JADX WARN: Found duplicated region for block: B:163:0x02e4  */
    /* JADX WARN: Found duplicated region for block: B:165:0x02e8  */
    /* JADX WARN: Found duplicated region for block: B:166:0x02f9  */
    /* JADX WARN: Found duplicated region for block: B:169:0x031b  */
    /* JADX WARN: Found duplicated region for block: B:171:0x0324  */
    /* JADX WARN: Found duplicated region for block: B:173:0x0328  */
    /* JADX WARN: Found duplicated region for block: B:174:0x0339  */
    /* JADX WARN: Found duplicated region for block: B:177:0x035b  */
    /* JADX WARN: Found duplicated region for block: B:182:0x0372  */
    /* JADX WARN: Found duplicated region for block: B:184:0x0386  */
    /* JADX WARN: Found duplicated region for block: B:186:0x038a  */
    /* JADX WARN: Found duplicated region for block: B:188:0x038f A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:189:0x0391  */
    /* JADX WARN: Found duplicated region for block: B:193:0x0399  */
    /* JADX WARN: Found duplicated region for block: B:196:0x03a1  */
    /* JADX WARN: Found duplicated region for block: B:199:0x03a9  */
    /* JADX WARN: Found duplicated region for block: B:200:0x03ab  */
    /* JADX WARN: Found duplicated region for block: B:202:0x03af  */
    /* JADX WARN: Found duplicated region for block: B:204:0x03b4 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:205:0x03b6  */
    /* JADX WARN: Found duplicated region for block: B:209:0x03be  */
    /* JADX WARN: Found duplicated region for block: B:212:0x03c6  */
    /* JADX WARN: Found duplicated region for block: B:218:0x03d2  */
    /* JADX WARN: Found duplicated region for block: B:227:0x03e6 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:228:0x03e8  */
    /* JADX WARN: Found duplicated region for block: B:229:0x03f2  */
    /* JADX WARN: Found duplicated region for block: B:234:0x0402  */
    /* JADX WARN: Found duplicated region for block: B:243:0x0419  */
    /* JADX WARN: Found duplicated region for block: B:246:0x0420  */
    /* JADX WARN: Found duplicated region for block: B:248:0x0423  */
    /* JADX WARN: Found duplicated region for block: B:250:0x0429  */
    /* JADX WARN: Found duplicated region for block: B:261:0x0445  */
    /* JADX WARN: Found duplicated region for block: B:266:0x0459  */
    /* JADX WARN: Found duplicated region for block: B:271:0x0467  */
    /* JADX WARN: Found duplicated region for block: B:273:0x046d A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:274:0x046f  */
    /* JADX WARN: Found duplicated region for block: B:279:0x047f  */
    /* JADX WARN: Found duplicated region for block: B:281:0x0485 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:282:0x0487  */
    /* JADX WARN: Found duplicated region for block: B:295:0x04ba A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:298:0x04d4  */
    /* JADX WARN: Found duplicated region for block: B:300:0x04e9  */
    /* JADX WARN: Found duplicated region for block: B:302:0x04ee  */
    /* JADX WARN: Found duplicated region for block: B:304:0x04fd  */
    /* JADX WARN: Found duplicated region for block: B:321:0x0520  */
    /* JADX WARN: Found duplicated region for block: B:323:0x0535 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:324:0x0537  */
    /* JADX WARN: Found duplicated region for block: B:326:0x0545  */
    /* JADX WARN: Found duplicated region for block: B:328:0x054a  */
    /* JADX WARN: Found duplicated region for block: B:330:0x0558  */
    /* JADX WARN: Found duplicated region for block: B:347:0x057b A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:349:0x0592 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:351:0x0596  */
    /* JADX WARN: Found duplicated region for block: B:359:0x05bf  */
    /* JADX WARN: Found duplicated region for block: B:364:0x05c7  */
    /* JADX WARN: Found duplicated region for block: B:366:0x05cf  */
    /* JADX WARN: Found duplicated region for block: B:367:0x05d9  */
    /* JADX WARN: Found duplicated region for block: B:371:0x05fa  */
    /* JADX WARN: Found duplicated region for block: B:373:0x0602  */
    /* JADX WARN: Found duplicated region for block: B:375:0x0606  */
    /* JADX WARN: Found duplicated region for block: B:376:0x0617  */
    /* JADX WARN: Found duplicated region for block: B:379:0x0639  */
    /* JADX WARN: Found duplicated region for block: B:381:0x0642  */
    /* JADX WARN: Found duplicated region for block: B:383:0x0646  */
    /* JADX WARN: Found duplicated region for block: B:384:0x0657  */
    /* JADX WARN: Found duplicated region for block: B:387:0x0679  */
    /* JADX WARN: Found duplicated region for block: B:391:0x068f A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:394:0x06a5  */
    /* JADX WARN: Found duplicated region for block: B:396:0x06ab  */
    /* JADX WARN: Found duplicated region for block: B:397:0x06bc A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:39:0x00c9  */
    /* JADX WARN: Found duplicated region for block: B:400:0x0700 A[LOOP:18: B:399:0x06fe->B:400:0x0700, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:405:0x072a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:406:0x072c  */
    /* JADX WARN: Found duplicated region for block: B:407:0x0731 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:408:0x0733  */
    /* JADX WARN: Found duplicated region for block: B:409:0x0735  */
    /* JADX WARN: Found duplicated region for block: B:411:0x0738  */
    /* JADX WARN: Found duplicated region for block: B:412:0x073b A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:413:0x073d  */
    /* JADX WARN: Found duplicated region for block: B:414:0x0744 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:415:0x0746  */
    /* JADX WARN: Found duplicated region for block: B:416:0x0748  */
    /* JADX WARN: Found duplicated region for block: B:419:0x0757  */
    /* JADX WARN: Found duplicated region for block: B:420:0x0759  */
    /* JADX WARN: Found duplicated region for block: B:42:0x00d0  */
    /* JADX WARN: Found duplicated region for block: B:430:0x010f A[EDGE_INSN: B:430:0x010f->B:63:0x010f BREAK  A[LOOP:1: B:57:0x00f8->B:62:0x010a], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:432:0x010a A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:435:0x012c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:448:0x03a7 A[EDGE_INSN: B:448:0x03a7->B:198:0x03a7 BREAK  A[LOOP:7: B:187:0x038d->B:197:0x03a4], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:44:0x00d4  */
    /* JADX WARN: Found duplicated region for block: B:451:0x03a4 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:452:0x04a7 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:458:0x049c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:46:0x00da  */
    /* JADX WARN: Found duplicated region for block: B:474:0x0478 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:477:0x0490 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:478:0x03cc A[EDGE_INSN: B:478:0x03cc->B:214:0x03cc BREAK  A[LOOP:13: B:203:0x03b2->B:213:0x03c9], SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:481:0x03c9 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00e3  */
    /* JADX WARN: Found duplicated region for block: B:52:0x00ea  */
    /* JADX WARN: Found duplicated region for block: B:55:0x00f0  */
    /* JADX WARN: Found duplicated region for block: B:59:0x0100  */
    /* JADX WARN: Found duplicated region for block: B:61:0x0108  */
    /* JADX WARN: Found duplicated region for block: B:64:0x0111  */
    /* JADX WARN: Found duplicated region for block: B:67:0x011a A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Found duplicated region for block: B:72:0x0135  */
    /* JADX WARN: Found duplicated region for block: B:75:0x0140  */
    /* JADX WARN: Found duplicated region for block: B:77:0x0143  */
    /* JADX WARN: Found duplicated region for block: B:79:0x0146  */
    /* JADX WARN: Found duplicated region for block: B:81:0x0149  */
    /* JADX WARN: Found duplicated region for block: B:84:0x015a  */
    /* JADX WARN: Found duplicated region for block: B:86:0x015f  */
    /* JADX WARN: Found duplicated region for block: B:87:0x016f A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:89:0x01a6  */
    /* JADX WARN: Found duplicated region for block: B:91:0x01ac  */
    /* JADX WARN: Found duplicated region for block: B:93:0x01c1  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.esw
    public final void c(bbp bbpVar, int i, int i2) {
        adb adbVar;
        adb adbVar2;
        adb adbVar3;
        ArrayList arrayList;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        int i9;
        int i10;
        adq[] adqVarArr;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        adq[] adqVarArr2;
        int i16;
        adq[] adqVarArr3;
        int i17;
        int i18;
        int[] iArr2;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        bbo bboVar;
        int i24;
        char c;
        char c2;
        int i25;
        int i26;
        adq[] adqVarArr4;
        int i27;
        bbo bboVar2;
        int i28;
        int i29;
        int i30;
        adq adqVar;
        int iEs;
        boolean z;
        int i31;
        int size;
        int i32;
        int i33;
        int i34;
        int i35;
        adb adbVar4;
        adb adbVar5;
        adb adbVar6;
        adb adbVar7;
        int i36;
        int iMax;
        int i37;
        bbo bboVar3;
        int iV;
        int iU;
        int i38;
        bbo bboVar4;
        int i39;
        int i40;
        adq adqVar2;
        int iEt;
        boolean z2;
        int i41;
        adq[] adqVarArr5;
        int i42;
        int i43;
        int iCeil;
        int iCeil2;
        int i44;
        int i45;
        int i46;
        adq adqVar3;
        int iEs2;
        boolean z3;
        adq[] adqVarArr6;
        Object obj;
        adq[] adqVarArr7;
        int i47;
        int i48;
        int iEt2;
        int i49;
        int iEs3;
        adq adqVar4;
        adq adqVar5;
        int i50;
        int i51;
        adq adqVar6;
        adq adqVar7;
        adq adqVar8;
        int i52;
        int i53;
        int i54;
        adq adqVar9;
        int iEt3;
        int i55;
        int i56;
        adq[] adqVarArr8;
        bbo bboVar5;
        char c3;
        int i57;
        int i58;
        int i59;
        int i60;
        int i61;
        adq adqVar10;
        int iEs4;
        int i62;
        boolean z4;
        int i63;
        int size2;
        int i64;
        int i65;
        int i66;
        int i67;
        adb adbVar8;
        adb adbVar9;
        adb adbVar10;
        adb adbVar11;
        int i68;
        int iMax2;
        int i69;
        bbo bboVar6;
        int iV2;
        int iU2;
        int i70;
        bbo bboVar7;
        int i71;
        int i72;
        int i73;
        adq adqVar11;
        int iEt4;
        int i74;
        int i75;
        boolean z5;
        int i76;
        int i77;
        int i78;
        int i79;
        int i80;
        adq adqVar12;
        adq[] adqVarArr9;
        int i81;
        adb adbVar12;
        adb adbVar13;
        adb adbVar14;
        ArrayList arrayList2;
        int i82;
        int mode = View.MeasureSpec.getMode(i);
        int size3 = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size4 = View.MeasureSpec.getSize(i2);
        if (bbpVar == null) {
            setMeasuredDimension(0, 0);
            return;
        }
        int[] iArr3 = bbpVar.bz;
        adb adbVar15 = bbpVar.at;
        adb adbVar16 = bbpVar.as;
        adb adbVar17 = bbpVar.au;
        adb adbVar18 = bbpVar.av;
        ArrayList arrayList3 = bbpVar.el;
        if (bbpVar.ew > 0) {
            of ofVar = bbpVar.dq;
            adq adqVar13 = bbpVar.bd;
            adg adgVar = adqVar13 != null ? ((adr) adqVar13).i : null;
            if (adgVar == null) {
                bbpVar.f1do = 0;
                bbpVar.dp = 0;
                bbpVar.dn = false;
            } else {
                int i83 = 0;
                while (i83 < bbpVar.ew) {
                    adq adqVar14 = bbpVar.ev[i83];
                    if (adqVar14 == null) {
                        adbVar12 = adbVar16;
                    } else {
                        adbVar12 = adbVar16;
                        if (!(adqVar14 instanceof bjp)) {
                            adbVar13 = adbVar17;
                            int iCl = adqVar14.cl(0);
                            adbVar14 = adbVar18;
                            int iCl2 = adqVar14.cl(1);
                            arrayList2 = arrayList3;
                            if (iCl == 3) {
                                i82 = i83;
                                if (adqVar14.ab == 1 || iCl2 != 3 || adqVar14.ac == 1) {
                                }
                            } else {
                                i82 = i83;
                            }
                            if (iCl == 3) {
                                iCl = 2;
                            }
                            if (iCl2 == 3) {
                                iCl2 = 2;
                            }
                            ofVar.a = iCl;
                            ofVar.b = iCl2;
                            ofVar.c = adqVar14.cq();
                            ofVar.d = adqVar14.cm();
                            adgVar.j(adqVar14, ofVar);
                            adqVar14.dk(ofVar.e);
                            adqVar14.dh(ofVar.f);
                            adqVar14.de(ofVar.g);
                        }
                        i83 = i82 + 1;
                        adbVar16 = adbVar12;
                        adbVar17 = adbVar13;
                        adbVar18 = adbVar14;
                        arrayList3 = arrayList2;
                    }
                    adbVar13 = adbVar17;
                    adbVar14 = adbVar18;
                    arrayList2 = arrayList3;
                    i82 = i83;
                    i83 = i82 + 1;
                    adbVar16 = adbVar12;
                    adbVar17 = adbVar13;
                    adbVar18 = adbVar14;
                    arrayList3 = arrayList2;
                }
                adbVar = adbVar16;
                adbVar2 = adbVar17;
                adbVar3 = adbVar18;
                arrayList = arrayList3;
                i3 = bbpVar.i;
                i4 = bbpVar.j;
                i5 = bbpVar.a;
                i6 = bbpVar.b;
                iArr = new int[2];
                i7 = (size3 - i3) - i4;
                i8 = bbpVar.ek;
                if (i8 == 1) {
                    i7 = (size4 - i5) - i6;
                }
                i9 = i7;
                if (i8 == 0) {
                    if (bbpVar.ds == -1) {
                        i81 = 0;
                        bbpVar.ds = 0;
                    } else {
                        i81 = 0;
                    }
                    i10 = i4;
                    if (bbpVar.dt == -1) {
                        bbpVar.dt = i81;
                    }
                } else {
                    i10 = i4;
                    if (bbpVar.ds == -1) {
                        bbpVar.ds = 0;
                    }
                    if (bbpVar.dt == -1) {
                        bbpVar.dt = 0;
                    }
                }
                adqVarArr = bbpVar.ev;
                i11 = 0;
                i12 = 0;
                while (true) {
                    i13 = bbpVar.ew;
                    i14 = i5;
                    if (i11 < i13) {
                        break;
                    }
                    if (bbpVar.ev[i11].bq == 8) {
                        i12++;
                    }
                    i11++;
                    i5 = i14;
                }
                if (i12 > 0) {
                    adqVarArr2 = new adq[i13 - i12];
                    i79 = 0;
                    i80 = 0;
                    while (i79 < bbpVar.ew) {
                        adqVar12 = bbpVar.ev[i79];
                        adqVarArr9 = adqVarArr2;
                        if (adqVar12.bq != 8) {
                            adqVarArr9[i80] = adqVar12;
                            i80++;
                        }
                        i79++;
                        adqVarArr2 = adqVarArr9;
                    }
                    i15 = i80;
                } else {
                    i15 = i13;
                    adqVarArr2 = adqVarArr;
                }
                bbpVar.ep = adqVarArr2;
                bbpVar.eq = i15;
                i16 = bbpVar.ei;
                if (i16 != 0) {
                    adqVarArr3 = adqVarArr2;
                    i17 = i15;
                    i18 = i6;
                    iArr2 = iArr;
                    i19 = size4;
                    i20 = i3;
                    i21 = i10;
                    i22 = i14;
                    i23 = bbpVar.ek;
                    if (i17 == 0) {
                        if (arrayList.size() == 0) {
                            bboVar = new bbo(bbpVar, i23, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                            arrayList.add(bboVar);
                        } else {
                            bbo bboVar8 = (bbo) arrayList.get(0);
                            bboVar8.c = 0;
                            bboVar8.b = null;
                            bboVar8.l = 0;
                            bboVar8.m = 0;
                            bboVar8.n = 0;
                            bboVar8.o = 0;
                            bboVar8.p = 0;
                            bboVar8.x(i23, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, bbpVar.i, bbpVar.a, bbpVar.j, bbpVar.b, i9);
                            bboVar = bboVar8;
                        }
                        for (i24 = 0; i24 < i17; i24++) {
                            bboVar.s(adqVarArr3[i24]);
                        }
                        c = 0;
                        iArr2[0] = bboVar.v();
                        c2 = 1;
                        iArr2[1] = bboVar.u();
                    }
                    i25 = iArr2[c] + i20 + i21;
                    int i84 = iArr2[c2] + i22 + i18;
                    if (mode != 1073741824) {
                        if (mode == Integer.MIN_VALUE) {
                        }
                    }
                    if (mode2 == 1073741824) {
                    }
                    bbpVar.f1do = size3;
                    bbpVar.dp = iMin;
                    bbpVar.dk(size3);
                    bbpVar.dh(iMin);
                    bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
                } else if (i16 != 1) {
                    if (i16 != 2) {
                        adqVarArr5 = adqVarArr2;
                        i42 = i15;
                        i18 = i6;
                        iArr2 = iArr;
                        i19 = size4;
                        i20 = i3;
                        i21 = i10;
                        i22 = i14;
                        i43 = bbpVar.ek;
                        if (i43 == 0) {
                            i52 = bbpVar.ej;
                            if (i52 <= 0) {
                                i54 = 0;
                                iCeil2 = 0;
                                for (i53 = 0; i53 < i42; i53++) {
                                    if (i53 > 0) {
                                        i54 += bbpVar.ee;
                                    }
                                    adqVar9 = adqVarArr5[i53];
                                    if (adqVar9 != null) {
                                        iEt3 = bbpVar.et(adqVar9, i9) + i54;
                                        if (iEt3 > i9) {
                                            break;
                                        }
                                        iCeil2++;
                                        i54 = iEt3;
                                    }
                                }
                            } else {
                                iCeil2 = i52;
                            }
                            iCeil = 0;
                        } else {
                            iCeil = bbpVar.ej;
                            if (iCeil <= 0) {
                                i45 = 0;
                                i46 = 0;
                                for (i44 = 0; i44 < i42; i44++) {
                                    if (i44 > 0) {
                                        i45 += bbpVar.ef;
                                    }
                                    adqVar3 = adqVarArr5[i44];
                                    if (adqVar3 != null) {
                                        iEs2 = bbpVar.es(adqVar3, i9) + i45;
                                        if (iEs2 > i9) {
                                            break;
                                        }
                                        i46++;
                                        i45 = iEs2;
                                    }
                                }
                                iCeil = i46;
                            }
                            iCeil2 = 0;
                        }
                        if (bbpVar.eo == null) {
                            bbpVar.eo = new int[2];
                        }
                        z3 = (iCeil != 0 && i43 == 1) || (iCeil2 == 0 && i43 == 0);
                        while (!z3) {
                            if (i43 == 0) {
                                iCeil = (int) Math.ceil(i42 / iCeil2);
                            } else {
                                iCeil2 = (int) Math.ceil(i42 / iCeil);
                            }
                            adqVarArr6 = bbpVar.en;
                            if (adqVarArr6 != null || adqVarArr6.length < iCeil2) {
                                obj = null;
                                bbpVar.en = new adq[iCeil2];
                            } else {
                                obj = null;
                                Arrays.fill(adqVarArr6, (Object) null);
                            }
                            adqVarArr7 = bbpVar.em;
                            if (adqVarArr7 != null || adqVarArr7.length < iCeil) {
                                bbpVar.em = new adq[iCeil];
                            } else {
                                Arrays.fill(adqVarArr7, obj);
                            }
                            for (i47 = 0; i47 < iCeil2; i47++) {
                                for (i50 = 0; i50 < iCeil; i50++) {
                                    i51 = (i50 * iCeil2) + i47;
                                    if (i43 == 1) {
                                        i51 = (i47 * iCeil) + i50;
                                    }
                                    if (i51 < adqVarArr5.length && (adqVar6 = adqVarArr5[i51]) != null) {
                                        int iEt5 = bbpVar.et(adqVar6, i9);
                                        adqVar7 = bbpVar.en[i47];
                                        if (adqVar7 != null || adqVar7.cq() < iEt5) {
                                            bbpVar.en[i47] = adqVar6;
                                        }
                                        int iEs5 = bbpVar.es(adqVar6, i9);
                                        adqVar8 = bbpVar.em[i50];
                                        if (adqVar8 != null || adqVar8.cm() < iEs5) {
                                            bbpVar.em[i50] = adqVar6;
                                        }
                                    }
                                }
                            }
                            iEt2 = 0;
                            for (i48 = 0; i48 < iCeil2; i48++) {
                                adqVar5 = bbpVar.en[i48];
                                if (adqVar5 == null) {
                                    if (i48 > 0) {
                                        iEt2 += bbpVar.ee;
                                    }
                                    iEt2 = bbpVar.et(adqVar5, i9) + iEt2;
                                }
                            }
                            iEs3 = 0;
                            for (i49 = 0; i49 < iCeil; i49++) {
                                adqVar4 = bbpVar.em[i49];
                                if (adqVar4 == null) {
                                    if (i49 > 0) {
                                        iEs3 += bbpVar.ef;
                                    }
                                    iEs3 = bbpVar.es(adqVar4, i9) + iEs3;
                                }
                            }
                            iArr2[0] = iEt2;
                            iArr2[1] = iEs3;
                            if (i43 == 0) {
                                if (iEt2 > i9 || iCeil2 <= 1) {
                                    z3 = true;
                                } else {
                                    iCeil2--;
                                }
                            } else if (iEs3 > i9 || iCeil <= 1) {
                                z3 = true;
                            } else {
                                iCeil--;
                            }
                        }
                        c2 = 1;
                        int[] iArr4 = bbpVar.eo;
                        iArr4[0] = iCeil2;
                        iArr4[1] = iCeil;
                    } else if (i16 != 3) {
                        i18 = i6;
                        iArr2 = iArr;
                        i19 = size4;
                        i20 = i3;
                        i21 = i10;
                        i22 = i14;
                    } else {
                        i55 = i15;
                        i56 = bbpVar.ek;
                        if (i55 == 0) {
                            i18 = i6;
                            iArr2 = iArr;
                            i19 = size4;
                            i20 = i3;
                            i21 = i10;
                            i22 = i14;
                            c3 = 1;
                        } else {
                            arrayList.clear();
                            adqVarArr8 = adqVarArr2;
                            i20 = i3;
                            i18 = i6;
                            i21 = i10;
                            i22 = i14;
                            iArr2 = iArr;
                            c3 = 1;
                            bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                            arrayList.add(bboVar5);
                            if (i56 == 0) {
                                i71 = 0;
                                i72 = 0;
                                i61 = 0;
                                i73 = 0;
                                while (i71 < i55) {
                                    i72++;
                                    adqVar11 = adqVarArr8[i71];
                                    iEt4 = bbpVar.et(adqVar11, i9);
                                    i74 = i56;
                                    i75 = i71;
                                    if (adqVar11.bz[0] == 3) {
                                        i61++;
                                    }
                                    int i85 = i61;
                                    z5 = (i73 != i9 || (bbpVar.ee + i73) + iEt4 > i9) && bboVar5.b != null;
                                    if (!z5 && i75 > 0 && (i78 = bbpVar.ej) > 0 && i72 > i78) {
                                        z5 = true;
                                    }
                                    if (z5) {
                                        i76 = size4;
                                        i56 = i74;
                                        i77 = i75;
                                        bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                        bboVar5.n = i77;
                                        arrayList.add(bboVar5);
                                        i72 = 1;
                                    } else {
                                        i76 = size4;
                                        i56 = i74;
                                        i77 = i75;
                                        if (i77 > 0) {
                                            i73 = bbpVar.ee + iEt4 + i73;
                                        }
                                        bboVar5.s(adqVar11);
                                        i71 = i77 + 1;
                                        i61 = i85;
                                        size4 = i76;
                                    }
                                    i73 = iEt4;
                                    bboVar5.s(adqVar11);
                                    i71 = i77 + 1;
                                    i61 = i85;
                                    size4 = i76;
                                }
                                i19 = size4;
                            } else {
                                i19 = size4;
                                i57 = 0;
                                i58 = 0;
                                i59 = 0;
                                i60 = 0;
                                while (i57 < i55) {
                                    i58++;
                                    adqVar10 = adqVarArr8[i57];
                                    iEs4 = bbpVar.es(adqVar10, i9);
                                    i62 = i56;
                                    if (adqVar10.bz[1] == 3) {
                                        i59++;
                                    }
                                    int i86 = i59;
                                    z4 = (i60 != i9 || (bbpVar.ef + i60) + iEs4 > i9) && bboVar5.b != null;
                                    if (!z4 && i57 > 0 && (i63 = bbpVar.ej) > 0 && i58 > i63) {
                                        z4 = true;
                                    }
                                    if (z4) {
                                        i56 = i62;
                                        bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                        bboVar5.n = i57;
                                        arrayList.add(bboVar5);
                                        i58 = 1;
                                    } else {
                                        i56 = i62;
                                        if (i57 > 0) {
                                            i60 = bbpVar.ef + iEs4 + i60;
                                        }
                                        bboVar5.s(adqVar10);
                                        i57++;
                                        i59 = i86;
                                    }
                                    i60 = iEs4;
                                    bboVar5.s(adqVar10);
                                    i57++;
                                    i59 = i86;
                                }
                                i61 = i59;
                            }
                            size2 = arrayList.size();
                            int i87 = bbpVar.i;
                            int i88 = bbpVar.a;
                            int i89 = bbpVar.j;
                            int i90 = bbpVar.b;
                            boolean z6 = iArr3[0] != 2 || iArr3[1] == 2;
                            if (i61 > 0 && z6) {
                                for (i70 = 0; i70 < size2; i70++) {
                                    bboVar7 = (bbo) arrayList.get(i70);
                                    if (i56 == 0) {
                                        bboVar7.w(i9 - bboVar7.v());
                                    } else {
                                        bboVar7.w(i9 - bboVar7.u());
                                    }
                                }
                            }
                            i64 = i87;
                            i65 = i88;
                            i66 = i89;
                            i67 = i90;
                            adbVar8 = adbVar;
                            adbVar9 = adbVar2;
                            adbVar10 = adbVar3;
                            adbVar11 = adbVar15;
                            iMax2 = 0;
                            i69 = 0;
                            for (i68 = 0; i68 < size2; i68++) {
                                bboVar6 = (bbo) arrayList.get(i68);
                                if (i56 == 0) {
                                    if (i68 < size2 - 1) {
                                        adbVar10 = ((bbo) arrayList.get(i68 + 1)).b.at;
                                        i67 = 0;
                                    } else {
                                        i67 = bbpVar.b;
                                        adbVar10 = adbVar3;
                                    }
                                    adb adbVar19 = bboVar6.b.av;
                                    bboVar6.x(i56, adbVar8, adbVar11, adbVar9, adbVar10, i64, i65, i66, i67, i9);
                                    iMax2 = Math.max(iMax2, bboVar6.v());
                                    iU2 = bboVar6.u() + i69;
                                    if (i68 > 0) {
                                        iU2 += bbpVar.ef;
                                    }
                                    i69 = iU2;
                                    adbVar11 = adbVar19;
                                    i65 = 0;
                                } else {
                                    if (i68 < size2 - 1) {
                                        adbVar9 = ((bbo) arrayList.get(i68 + 1)).b.as;
                                        i66 = 0;
                                    } else {
                                        i66 = bbpVar.j;
                                        adbVar9 = adbVar2;
                                    }
                                    adb adbVar20 = bboVar6.b.au;
                                    bboVar6.x(i56, adbVar8, adbVar11, adbVar9, adbVar10, i64, i65, i66, i67, i9);
                                    iV2 = bboVar6.v() + iMax2;
                                    int iMax3 = Math.max(i69, bboVar6.u());
                                    if (i68 > 0) {
                                        iV2 += bbpVar.ee;
                                    }
                                    i69 = iMax3;
                                    iMax2 = iV2;
                                    adbVar8 = adbVar20;
                                    i64 = 0;
                                }
                            }
                            iArr2[0] = iMax2;
                            iArr2[1] = i69;
                        }
                        c2 = c3;
                    }
                    c = 0;
                    i25 = iArr2[c] + i20 + i21;
                    int i842 = iArr2[c2] + i22 + i18;
                    if (mode != 1073741824) {
                        size3 = mode == Integer.MIN_VALUE ? Math.min(i25, size3) : mode == 0 ? i25 : 0;
                    }
                    int iMin = mode2 == 1073741824 ? i19 : mode2 == Integer.MIN_VALUE ? Math.min(i842, i19) : mode2 == 0 ? i842 : 0;
                    bbpVar.f1do = size3;
                    bbpVar.dp = iMin;
                    bbpVar.dk(size3);
                    bbpVar.dh(iMin);
                    bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
                } else {
                    i18 = i6;
                    iArr2 = iArr;
                    i19 = size4;
                    i20 = i3;
                    i21 = i10;
                    i22 = i14;
                    i26 = i15;
                    adqVarArr4 = adqVarArr2;
                    i27 = bbpVar.ek;
                    if (i26 != 0) {
                        arrayList.clear();
                        bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                        arrayList.add(bboVar2);
                        if (i27 == 0) {
                            i39 = 0;
                            i29 = 0;
                            i40 = 0;
                            while (i39 < i26) {
                                adqVar2 = adqVarArr4[i39];
                                iEt = bbpVar.et(adqVar2, i9);
                                if (adqVar2.bz[0] == 3) {
                                    i29++;
                                }
                                int i91 = i29;
                                z2 = (i40 != i9 || (bbpVar.ee + i40) + iEt > i9) && bboVar2.b != null;
                                if (!z2 && i39 > 0 && (i41 = bbpVar.ej) > 0 && i39 % i41 == 0) {
                                    z2 = true;
                                }
                                if (z2) {
                                    bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                    bboVar2.n = i39;
                                    arrayList.add(bboVar2);
                                } else {
                                    if (i39 > 0) {
                                        i40 = bbpVar.ee + iEt + i40;
                                    }
                                    bboVar2.s(adqVar2);
                                    i39++;
                                    i29 = i91;
                                }
                                i40 = iEt;
                                bboVar2.s(adqVar2);
                                i39++;
                                i29 = i91;
                            }
                        } else {
                            i28 = 0;
                            i29 = 0;
                            i30 = 0;
                            while (i28 < i26) {
                                adqVar = adqVarArr4[i28];
                                iEs = bbpVar.es(adqVar, i9);
                                if (adqVar.bz[1] == 3) {
                                    i29++;
                                }
                                int i92 = i29;
                                z = (i30 != i9 || (bbpVar.ef + i30) + iEs > i9) && bboVar2.b != null;
                                if (!z && i28 > 0 && (i31 = bbpVar.ej) > 0 && i28 % i31 == 0) {
                                    z = true;
                                }
                                if (z) {
                                    bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                    bboVar2.n = i28;
                                    arrayList.add(bboVar2);
                                } else {
                                    if (i28 > 0) {
                                        i30 = bbpVar.ef + iEs + i30;
                                    }
                                    bboVar2.s(adqVar);
                                    i28++;
                                    i29 = i92;
                                }
                                i30 = iEs;
                                bboVar2.s(adqVar);
                                i28++;
                                i29 = i92;
                            }
                        }
                        size = arrayList.size();
                        int i93 = bbpVar.i;
                        int i94 = bbpVar.a;
                        int i95 = bbpVar.j;
                        int i96 = bbpVar.b;
                        boolean z7 = iArr3[0] != 2 || iArr3[1] == 2;
                        if (i29 > 0 && z7) {
                            for (i38 = 0; i38 < size; i38++) {
                                bboVar4 = (bbo) arrayList.get(i38);
                                if (i27 == 0) {
                                    bboVar4.w(i9 - bboVar4.v());
                                } else {
                                    bboVar4.w(i9 - bboVar4.u());
                                }
                            }
                        }
                        i32 = i93;
                        i33 = i94;
                        i34 = i95;
                        i35 = i96;
                        adbVar4 = adbVar;
                        adbVar5 = adbVar2;
                        adbVar6 = adbVar3;
                        adbVar7 = adbVar15;
                        iMax = 0;
                        i37 = 0;
                        for (i36 = 0; i36 < size; i36++) {
                            bboVar3 = (bbo) arrayList.get(i36);
                            if (i27 == 0) {
                                if (i36 < size - 1) {
                                    adbVar6 = ((bbo) arrayList.get(i36 + 1)).b.at;
                                    i35 = 0;
                                } else {
                                    i35 = bbpVar.b;
                                    adbVar6 = adbVar3;
                                }
                                adb adbVar21 = bboVar3.b.av;
                                bboVar3.x(i27, adbVar4, adbVar7, adbVar5, adbVar6, i32, i33, i34, i35, i9);
                                iMax = Math.max(iMax, bboVar3.v());
                                iU = bboVar3.u() + i37;
                                if (i36 > 0) {
                                    iU += bbpVar.ef;
                                }
                                i37 = iU;
                                adbVar7 = adbVar21;
                                i33 = 0;
                            } else {
                                if (i36 < size - 1) {
                                    adbVar5 = ((bbo) arrayList.get(i36 + 1)).b.as;
                                    i34 = 0;
                                } else {
                                    i34 = bbpVar.j;
                                    adbVar5 = adbVar2;
                                }
                                adb adbVar22 = bboVar3.b.au;
                                bboVar3.x(i27, adbVar4, adbVar7, adbVar5, adbVar6, i32, i33, i34, i35, i9);
                                iV = bboVar3.v() + iMax;
                                int iMax4 = Math.max(i37, bboVar3.u());
                                if (i36 > 0) {
                                    iV += bbpVar.ee;
                                }
                                i37 = iMax4;
                                iMax = iV;
                                adbVar4 = adbVar22;
                                i32 = 0;
                            }
                        }
                        iArr2[0] = iMax;
                        iArr2[1] = i37;
                    }
                }
                c2 = 1;
                c = 0;
                i25 = iArr2[c] + i20 + i21;
                int i8422 = iArr2[c2] + i22 + i18;
                if (mode != 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                    }
                }
                if (mode2 == 1073741824) {
                }
                bbpVar.f1do = size3;
                bbpVar.dp = iMin;
                bbpVar.dk(size3);
                bbpVar.dh(iMin);
                bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
            }
        } else {
            adbVar = adbVar16;
            adbVar2 = adbVar17;
            adbVar3 = adbVar18;
            arrayList = arrayList3;
            i3 = bbpVar.i;
            i4 = bbpVar.j;
            i5 = bbpVar.a;
            i6 = bbpVar.b;
            iArr = new int[2];
            i7 = (size3 - i3) - i4;
            i8 = bbpVar.ek;
            if (i8 == 1) {
                i7 = (size4 - i5) - i6;
            }
            i9 = i7;
            if (i8 == 0) {
                if (bbpVar.ds == -1) {
                    i81 = 0;
                    bbpVar.ds = 0;
                } else {
                    i81 = 0;
                }
                i10 = i4;
                if (bbpVar.dt == -1) {
                    bbpVar.dt = i81;
                }
            } else {
                i10 = i4;
                if (bbpVar.ds == -1) {
                    bbpVar.ds = 0;
                }
                if (bbpVar.dt == -1) {
                    bbpVar.dt = 0;
                }
            }
            adqVarArr = bbpVar.ev;
            i11 = 0;
            i12 = 0;
            while (true) {
                i13 = bbpVar.ew;
                i14 = i5;
                if (i11 < i13) {
                    break;
                    break;
                }
                if (bbpVar.ev[i11].bq == 8) {
                    i12++;
                }
                i11++;
                i5 = i14;
            }
            if (i12 > 0) {
                adqVarArr2 = new adq[i13 - i12];
                i79 = 0;
                i80 = 0;
                while (i79 < bbpVar.ew) {
                    adqVar12 = bbpVar.ev[i79];
                    adqVarArr9 = adqVarArr2;
                    if (adqVar12.bq != 8) {
                        adqVarArr9[i80] = adqVar12;
                        i80++;
                    }
                    i79++;
                    adqVarArr2 = adqVarArr9;
                }
                i15 = i80;
            } else {
                i15 = i13;
                adqVarArr2 = adqVarArr;
            }
            bbpVar.ep = adqVarArr2;
            bbpVar.eq = i15;
            i16 = bbpVar.ei;
            if (i16 != 0) {
                adqVarArr3 = adqVarArr2;
                i17 = i15;
                i18 = i6;
                iArr2 = iArr;
                i19 = size4;
                i20 = i3;
                i21 = i10;
                i22 = i14;
                i23 = bbpVar.ek;
                if (i17 == 0) {
                    if (arrayList.size() == 0) {
                        bboVar = new bbo(bbpVar, i23, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                        arrayList.add(bboVar);
                    } else {
                        bbo bboVar82 = (bbo) arrayList.get(0);
                        bboVar82.c = 0;
                        bboVar82.b = null;
                        bboVar82.l = 0;
                        bboVar82.m = 0;
                        bboVar82.n = 0;
                        bboVar82.o = 0;
                        bboVar82.p = 0;
                        bboVar82.x(i23, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, bbpVar.i, bbpVar.a, bbpVar.j, bbpVar.b, i9);
                        bboVar = bboVar82;
                    }
                    while (i24 < i17) {
                        bboVar.s(adqVarArr3[i24]);
                    }
                    c = 0;
                    iArr2[0] = bboVar.v();
                    c2 = 1;
                    iArr2[1] = bboVar.u();
                }
                i25 = iArr2[c] + i20 + i21;
                int i84222 = iArr2[c2] + i22 + i18;
                if (mode != 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                    }
                }
                if (mode2 == 1073741824) {
                }
                bbpVar.f1do = size3;
                bbpVar.dp = iMin;
                bbpVar.dk(size3);
                bbpVar.dh(iMin);
                bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
            } else if (i16 != 1) {
                if (i16 != 2) {
                    adqVarArr5 = adqVarArr2;
                    i42 = i15;
                    i18 = i6;
                    iArr2 = iArr;
                    i19 = size4;
                    i20 = i3;
                    i21 = i10;
                    i22 = i14;
                    i43 = bbpVar.ek;
                    if (i43 == 0) {
                        i52 = bbpVar.ej;
                        if (i52 <= 0) {
                            i54 = 0;
                            iCeil2 = 0;
                            while (i53 < i42) {
                                if (i53 > 0) {
                                    i54 += bbpVar.ee;
                                }
                                adqVar9 = adqVarArr5[i53];
                                if (adqVar9 != null) {
                                    iEt3 = bbpVar.et(adqVar9, i9) + i54;
                                    if (iEt3 > i9) {
                                        break;
                                        break;
                                    } else {
                                        iCeil2++;
                                        i54 = iEt3;
                                    }
                                }
                            }
                        } else {
                            iCeil2 = i52;
                        }
                        iCeil = 0;
                    } else {
                        iCeil = bbpVar.ej;
                        if (iCeil <= 0) {
                            i45 = 0;
                            i46 = 0;
                            while (i44 < i42) {
                                if (i44 > 0) {
                                    i45 += bbpVar.ef;
                                }
                                adqVar3 = adqVarArr5[i44];
                                if (adqVar3 != null) {
                                    iEs2 = bbpVar.es(adqVar3, i9) + i45;
                                    if (iEs2 > i9) {
                                        break;
                                        break;
                                    } else {
                                        i46++;
                                        i45 = iEs2;
                                    }
                                }
                            }
                            iCeil = i46;
                        }
                        iCeil2 = 0;
                    }
                    if (bbpVar.eo == null) {
                        bbpVar.eo = new int[2];
                    }
                    if (iCeil != 0) {
                    }
                    while (!z3) {
                        if (i43 == 0) {
                            iCeil = (int) Math.ceil(i42 / iCeil2);
                        } else {
                            iCeil2 = (int) Math.ceil(i42 / iCeil);
                        }
                        adqVarArr6 = bbpVar.en;
                        if (adqVarArr6 != null) {
                            obj = null;
                            bbpVar.en = new adq[iCeil2];
                        } else {
                            obj = null;
                            bbpVar.en = new adq[iCeil2];
                        }
                        adqVarArr7 = bbpVar.em;
                        if (adqVarArr7 != null) {
                            bbpVar.em = new adq[iCeil];
                        } else {
                            bbpVar.em = new adq[iCeil];
                        }
                        while (i47 < iCeil2) {
                            while (i50 < iCeil) {
                                i51 = (i50 * iCeil2) + i47;
                                if (i43 == 1) {
                                    i51 = (i47 * iCeil) + i50;
                                }
                                if (i51 < adqVarArr5.length) {
                                    int iEt52 = bbpVar.et(adqVar6, i9);
                                    adqVar7 = bbpVar.en[i47];
                                    if (adqVar7 != null) {
                                        bbpVar.en[i47] = adqVar6;
                                    } else {
                                        bbpVar.en[i47] = adqVar6;
                                    }
                                    int iEs52 = bbpVar.es(adqVar6, i9);
                                    adqVar8 = bbpVar.em[i50];
                                    if (adqVar8 != null) {
                                        bbpVar.em[i50] = adqVar6;
                                    } else {
                                        bbpVar.em[i50] = adqVar6;
                                    }
                                }
                            }
                        }
                        iEt2 = 0;
                        while (i48 < iCeil2) {
                            adqVar5 = bbpVar.en[i48];
                            if (adqVar5 == null) {
                                if (i48 > 0) {
                                    iEt2 += bbpVar.ee;
                                }
                                iEt2 = bbpVar.et(adqVar5, i9) + iEt2;
                            }
                        }
                        iEs3 = 0;
                        while (i49 < iCeil) {
                            adqVar4 = bbpVar.em[i49];
                            if (adqVar4 == null) {
                                if (i49 > 0) {
                                    iEs3 += bbpVar.ef;
                                }
                                iEs3 = bbpVar.es(adqVar4, i9) + iEs3;
                            }
                        }
                        iArr2[0] = iEt2;
                        iArr2[1] = iEs3;
                        if (i43 == 0) {
                            if (iEt2 > i9) {
                            }
                            z3 = true;
                        } else {
                            if (iEs3 > i9) {
                            }
                            z3 = true;
                        }
                    }
                    c2 = 1;
                    int[] iArr42 = bbpVar.eo;
                    iArr42[0] = iCeil2;
                    iArr42[1] = iCeil;
                } else if (i16 != 3) {
                    i18 = i6;
                    iArr2 = iArr;
                    i19 = size4;
                    i20 = i3;
                    i21 = i10;
                    i22 = i14;
                } else {
                    i55 = i15;
                    i56 = bbpVar.ek;
                    if (i55 == 0) {
                        i18 = i6;
                        iArr2 = iArr;
                        i19 = size4;
                        i20 = i3;
                        i21 = i10;
                        i22 = i14;
                        c3 = 1;
                    } else {
                        arrayList.clear();
                        adqVarArr8 = adqVarArr2;
                        i20 = i3;
                        i18 = i6;
                        i21 = i10;
                        i22 = i14;
                        iArr2 = iArr;
                        c3 = 1;
                        bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                        arrayList.add(bboVar5);
                        if (i56 == 0) {
                            i71 = 0;
                            i72 = 0;
                            i61 = 0;
                            i73 = 0;
                            while (i71 < i55) {
                                i72++;
                                adqVar11 = adqVarArr8[i71];
                                iEt4 = bbpVar.et(adqVar11, i9);
                                i74 = i56;
                                i75 = i71;
                                if (adqVar11.bz[0] == 3) {
                                    i61++;
                                }
                                int i852 = i61;
                                if (i73 != i9) {
                                }
                                if (!z5) {
                                    z5 = true;
                                }
                                if (z5) {
                                    i76 = size4;
                                    i56 = i74;
                                    i77 = i75;
                                    bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                    bboVar5.n = i77;
                                    arrayList.add(bboVar5);
                                    i72 = 1;
                                } else {
                                    i76 = size4;
                                    i56 = i74;
                                    i77 = i75;
                                    if (i77 > 0) {
                                        i73 = bbpVar.ee + iEt4 + i73;
                                    }
                                    bboVar5.s(adqVar11);
                                    i71 = i77 + 1;
                                    i61 = i852;
                                    size4 = i76;
                                }
                                i73 = iEt4;
                                bboVar5.s(adqVar11);
                                i71 = i77 + 1;
                                i61 = i852;
                                size4 = i76;
                            }
                            i19 = size4;
                        } else {
                            i19 = size4;
                            i57 = 0;
                            i58 = 0;
                            i59 = 0;
                            i60 = 0;
                            while (i57 < i55) {
                                i58++;
                                adqVar10 = adqVarArr8[i57];
                                iEs4 = bbpVar.es(adqVar10, i9);
                                i62 = i56;
                                if (adqVar10.bz[1] == 3) {
                                    i59++;
                                }
                                int i862 = i59;
                                if (i60 != i9) {
                                }
                                if (!z4) {
                                    z4 = true;
                                }
                                if (z4) {
                                    i56 = i62;
                                    bboVar5 = new bbo(bbpVar, i56, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                    bboVar5.n = i57;
                                    arrayList.add(bboVar5);
                                    i58 = 1;
                                } else {
                                    i56 = i62;
                                    if (i57 > 0) {
                                        i60 = bbpVar.ef + iEs4 + i60;
                                    }
                                    bboVar5.s(adqVar10);
                                    i57++;
                                    i59 = i862;
                                }
                                i60 = iEs4;
                                bboVar5.s(adqVar10);
                                i57++;
                                i59 = i862;
                            }
                            i61 = i59;
                        }
                        size2 = arrayList.size();
                        int i872 = bbpVar.i;
                        int i882 = bbpVar.a;
                        int i892 = bbpVar.j;
                        int i902 = bbpVar.b;
                        if (iArr3[0] != 2) {
                        }
                        if (i61 > 0) {
                            while (i70 < size2) {
                                bboVar7 = (bbo) arrayList.get(i70);
                                if (i56 == 0) {
                                    bboVar7.w(i9 - bboVar7.v());
                                } else {
                                    bboVar7.w(i9 - bboVar7.u());
                                }
                            }
                        }
                        i64 = i872;
                        i65 = i882;
                        i66 = i892;
                        i67 = i902;
                        adbVar8 = adbVar;
                        adbVar9 = adbVar2;
                        adbVar10 = adbVar3;
                        adbVar11 = adbVar15;
                        iMax2 = 0;
                        i69 = 0;
                        while (i68 < size2) {
                            bboVar6 = (bbo) arrayList.get(i68);
                            if (i56 == 0) {
                                if (i68 < size2 - 1) {
                                    adbVar10 = ((bbo) arrayList.get(i68 + 1)).b.at;
                                    i67 = 0;
                                } else {
                                    i67 = bbpVar.b;
                                    adbVar10 = adbVar3;
                                }
                                adb adbVar192 = bboVar6.b.av;
                                bboVar6.x(i56, adbVar8, adbVar11, adbVar9, adbVar10, i64, i65, i66, i67, i9);
                                iMax2 = Math.max(iMax2, bboVar6.v());
                                iU2 = bboVar6.u() + i69;
                                if (i68 > 0) {
                                    iU2 += bbpVar.ef;
                                }
                                i69 = iU2;
                                adbVar11 = adbVar192;
                                i65 = 0;
                            } else {
                                if (i68 < size2 - 1) {
                                    adbVar9 = ((bbo) arrayList.get(i68 + 1)).b.as;
                                    i66 = 0;
                                } else {
                                    i66 = bbpVar.j;
                                    adbVar9 = adbVar2;
                                }
                                adb adbVar202 = bboVar6.b.au;
                                bboVar6.x(i56, adbVar8, adbVar11, adbVar9, adbVar10, i64, i65, i66, i67, i9);
                                iV2 = bboVar6.v() + iMax2;
                                int iMax32 = Math.max(i69, bboVar6.u());
                                if (i68 > 0) {
                                    iV2 += bbpVar.ee;
                                }
                                i69 = iMax32;
                                iMax2 = iV2;
                                adbVar8 = adbVar202;
                                i64 = 0;
                            }
                        }
                        iArr2[0] = iMax2;
                        iArr2[1] = i69;
                    }
                    c2 = c3;
                }
                c = 0;
                i25 = iArr2[c] + i20 + i21;
                int i842222 = iArr2[c2] + i22 + i18;
                if (mode != 1073741824) {
                    if (mode == Integer.MIN_VALUE) {
                    }
                }
                if (mode2 == 1073741824) {
                }
                bbpVar.f1do = size3;
                bbpVar.dp = iMin;
                bbpVar.dk(size3);
                bbpVar.dh(iMin);
                bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
            } else {
                i18 = i6;
                iArr2 = iArr;
                i19 = size4;
                i20 = i3;
                i21 = i10;
                i22 = i14;
                i26 = i15;
                adqVarArr4 = adqVarArr2;
                i27 = bbpVar.ek;
                if (i26 != 0) {
                    arrayList.clear();
                    bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                    arrayList.add(bboVar2);
                    if (i27 == 0) {
                        i39 = 0;
                        i29 = 0;
                        i40 = 0;
                        while (i39 < i26) {
                            adqVar2 = adqVarArr4[i39];
                            iEt = bbpVar.et(adqVar2, i9);
                            if (adqVar2.bz[0] == 3) {
                                i29++;
                            }
                            int i912 = i29;
                            if (i40 != i9) {
                            }
                            if (!z2) {
                                z2 = true;
                            }
                            if (z2) {
                                bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                bboVar2.n = i39;
                                arrayList.add(bboVar2);
                            } else {
                                if (i39 > 0) {
                                    i40 = bbpVar.ee + iEt + i40;
                                }
                                bboVar2.s(adqVar2);
                                i39++;
                                i29 = i912;
                            }
                            i40 = iEt;
                            bboVar2.s(adqVar2);
                            i39++;
                            i29 = i912;
                        }
                    } else {
                        i28 = 0;
                        i29 = 0;
                        i30 = 0;
                        while (i28 < i26) {
                            adqVar = adqVarArr4[i28];
                            iEs = bbpVar.es(adqVar, i9);
                            if (adqVar.bz[1] == 3) {
                                i29++;
                            }
                            int i922 = i29;
                            if (i30 != i9) {
                            }
                            if (!z) {
                                z = true;
                            }
                            if (z) {
                                bboVar2 = new bbo(bbpVar, i27, bbpVar.as, bbpVar.at, bbpVar.au, bbpVar.av, i9);
                                bboVar2.n = i28;
                                arrayList.add(bboVar2);
                            } else {
                                if (i28 > 0) {
                                    i30 = bbpVar.ef + iEs + i30;
                                }
                                bboVar2.s(adqVar);
                                i28++;
                                i29 = i922;
                            }
                            i30 = iEs;
                            bboVar2.s(adqVar);
                            i28++;
                            i29 = i922;
                        }
                    }
                    size = arrayList.size();
                    int i932 = bbpVar.i;
                    int i942 = bbpVar.a;
                    int i952 = bbpVar.j;
                    int i962 = bbpVar.b;
                    if (iArr3[0] != 2) {
                    }
                    if (i29 > 0) {
                        while (i38 < size) {
                            bboVar4 = (bbo) arrayList.get(i38);
                            if (i27 == 0) {
                                bboVar4.w(i9 - bboVar4.v());
                            } else {
                                bboVar4.w(i9 - bboVar4.u());
                            }
                        }
                    }
                    i32 = i932;
                    i33 = i942;
                    i34 = i952;
                    i35 = i962;
                    adbVar4 = adbVar;
                    adbVar5 = adbVar2;
                    adbVar6 = adbVar3;
                    adbVar7 = adbVar15;
                    iMax = 0;
                    i37 = 0;
                    while (i36 < size) {
                        bboVar3 = (bbo) arrayList.get(i36);
                        if (i27 == 0) {
                            if (i36 < size - 1) {
                                adbVar6 = ((bbo) arrayList.get(i36 + 1)).b.at;
                                i35 = 0;
                            } else {
                                i35 = bbpVar.b;
                                adbVar6 = adbVar3;
                            }
                            adb adbVar212 = bboVar3.b.av;
                            bboVar3.x(i27, adbVar4, adbVar7, adbVar5, adbVar6, i32, i33, i34, i35, i9);
                            iMax = Math.max(iMax, bboVar3.v());
                            iU = bboVar3.u() + i37;
                            if (i36 > 0) {
                                iU += bbpVar.ef;
                            }
                            i37 = iU;
                            adbVar7 = adbVar212;
                            i33 = 0;
                        } else {
                            if (i36 < size - 1) {
                                adbVar5 = ((bbo) arrayList.get(i36 + 1)).b.as;
                                i34 = 0;
                            } else {
                                i34 = bbpVar.j;
                                adbVar5 = adbVar2;
                            }
                            adb adbVar222 = bboVar3.b.au;
                            bboVar3.x(i27, adbVar4, adbVar7, adbVar5, adbVar6, i32, i33, i34, i35, i9);
                            iV = bboVar3.v() + iMax;
                            int iMax42 = Math.max(i37, bboVar3.u());
                            if (i36 > 0) {
                                iV += bbpVar.ee;
                            }
                            i37 = iMax42;
                            iMax = iV;
                            adbVar4 = adbVar222;
                            i32 = 0;
                        }
                    }
                    iArr2[0] = iMax;
                    iArr2[1] = i37;
                }
            }
            c2 = 1;
            c = 0;
            i25 = iArr2[c] + i20 + i21;
            int i8422222 = iArr2[c2] + i22 + i18;
            if (mode != 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                }
            }
            if (mode2 == 1073741824) {
            }
            bbpVar.f1do = size3;
            bbpVar.dp = iMin;
            bbpVar.dk(size3);
            bbpVar.dh(iMin);
            bbpVar.dn = bbpVar.ew > 0 ? c2 : 0;
        }
        setMeasuredDimension(bbpVar.f1do, bbpVar.dp);
    }

    @Override // me.hd.wauxv.obf.add, android.view.View
    public final void onMeasure(int i, int i2) {
        c(this.a, i, i2);
    }

    public void setFirstHorizontalBias(float f) {
        this.a.ea = f;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.a.du = i;
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.a.eb = f;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.a.dv = i;
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.a.eg = i;
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.a.dy = f;
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.a.ee = i;
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.a.ds = i;
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.a.ec = f;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.a.dw = i;
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.a.ed = f;
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.a.dx = i;
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.a.ej = i;
        requestLayout();
    }

    public void setOrientation(int i) {
        this.a.ek = i;
        requestLayout();
    }

    public void setPadding(int i) {
        bbp bbpVar = this.a;
        bbpVar.a = i;
        bbpVar.b = i;
        bbpVar.c = i;
        bbpVar.d = i;
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.a.b = i;
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.a.i = i;
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.a.j = i;
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.a.a = i;
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.a.eh = i;
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.a.dz = f;
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.a.ef = i;
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.a.dt = i;
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.a.ei = i;
        requestLayout();
    }
}
