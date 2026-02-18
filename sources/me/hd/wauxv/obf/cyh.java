package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cyh {
    public static final BigInteger a = new BigInteger(cnb.z(-580692463319850L), 16);
    public final BigInteger[] b;
    public final BigInteger[] c;
    public final BigInteger[] d;
    public final BigInteger[] e;
    public int f;

    public cyh(BigInteger bigInteger) {
        BigInteger[] bigIntegerArr = new BigInteger[8];
        for (int i = 0; i < 8; i++) {
            bigIntegerArr[i] = new BigInteger(cnb.z(-582947321150250L), 16);
        }
        this.b = bigIntegerArr;
        BigInteger[] bigIntegerArr2 = new BigInteger[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bigIntegerArr2[i2] = BigInteger.ZERO;
        }
        this.c = bigIntegerArr2;
        BigInteger[] bigIntegerArr3 = new BigInteger[256];
        for (int i3 = 0; i3 < 256; i3++) {
            bigIntegerArr3[i3] = BigInteger.ZERO;
        }
        this.d = bigIntegerArr3;
        BigInteger[] bigIntegerArr4 = new BigInteger[256];
        for (int i4 = 0; i4 < 256; i4++) {
            bigIntegerArr4[i4] = BigInteger.ZERO;
        }
        this.e = bigIntegerArr4;
        this.f = Opcodes.CONST_METHOD_TYPE;
        BigInteger[] bigIntegerArr5 = this.d;
        BigInteger[] bigIntegerArr6 = this.b;
        BigInteger[] bigIntegerArr7 = this.c;
        bigIntegerArr7[0] = bigInteger;
        for (int i5 = 0; i5 < 4; i5++) {
            g(bigIntegerArr6);
        }
        bqf bqfVarBj = dqc.bj(dqc.bm(0, bigIntegerArr7.length), 8);
        int i6 = bqfVarBj.a;
        int i7 = bqfVarBj.b;
        int i8 = bqfVarBj.c;
        BigInteger bigInteger2 = a;
        if ((i8 > 0 && i6 <= i7) || (i8 < 0 && i7 <= i6)) {
            while (true) {
                for (int i9 = 0; i9 < 8; i9++) {
                    bigIntegerArr6[i9] = bjs.s(-584265876110122L, bigIntegerArr6[i9].add(bigIntegerArr7[i6 + i9]), bigInteger2);
                }
                g(bigIntegerArr6);
                for (int i10 = 0; i10 < 8; i10++) {
                    bigIntegerArr5[i6 + i10] = bigIntegerArr6[i10];
                }
                if (i6 == i7) {
                    break;
                } else {
                    i6 += i8;
                }
            }
        }
        bqf bqfVarBj2 = dqc.bj(dqc.bm(0, bigIntegerArr5.length), 8);
        int i11 = bqfVarBj2.a;
        int i12 = bqfVarBj2.b;
        int i13 = bqfVarBj2.c;
        if ((i13 > 0 && i11 <= i12) || (i13 < 0 && i12 <= i11)) {
            while (true) {
                for (int i14 = 0; i14 < 8; i14++) {
                    bigIntegerArr6[i14] = bjs.s(-584244401273642L, bigIntegerArr6[i14].add(bigIntegerArr5[i11 + i14]), bigInteger2);
                }
                g(bigIntegerArr6);
                for (int i15 = 0; i15 < 8; i15++) {
                    bigIntegerArr5[i11 + i15] = bigIntegerArr6[i15];
                }
                if (i11 == i12) {
                    break;
                } else {
                    i11 += i13;
                }
            }
        }
        h();
    }

    public static void g(BigInteger[] bigIntegerArr) {
        BigInteger bigIntegerSubtract = bigIntegerArr[0].subtract(bigIntegerArr[4]);
        BigInteger bigInteger = a;
        bigIntegerArr[0] = bjs.s(-582874306706218L, bigIntegerSubtract, bigInteger);
        BigInteger bigInteger2 = bigIntegerArr[5];
        BigInteger bigIntegerShiftRight = bigIntegerArr[7].shiftRight(9);
        bzo.p(bigIntegerShiftRight, cnb.z(-582796997294890L));
        bigIntegerArr[5] = bigInteger2.xor(bigIntegerShiftRight).and(bigInteger);
        bigIntegerArr[7] = bjs.s(-583278033632042L, bigIntegerArr[7].add(bigIntegerArr[0]), bigInteger);
        bigIntegerArr[1] = bjs.s(-583256558795562L, bigIntegerArr[1].subtract(bigIntegerArr[5]), bigInteger);
        BigInteger bigInteger3 = bigIntegerArr[6];
        BigInteger bigIntegerShiftLeft = bigIntegerArr[0].shiftLeft(9);
        bzo.p(bigIntegerShiftLeft, cnb.z(-583179249384234L));
        bigIntegerArr[6] = bigInteger3.xor(bigIntegerShiftLeft).and(bigInteger);
        bigIntegerArr[0] = bjs.s(-583097645005610L, bigIntegerArr[0].add(bigIntegerArr[1]), bigInteger);
        bigIntegerArr[2] = bjs.s(-583076170169130L, bigIntegerArr[2].subtract(bigIntegerArr[6]), bigInteger);
        BigInteger bigInteger4 = bigIntegerArr[7];
        BigInteger bigIntegerShiftRight2 = bigIntegerArr[1].shiftRight(23);
        bzo.p(bigIntegerShiftRight2, cnb.z(-584648128199466L));
        bigIntegerArr[7] = bigInteger4.xor(bigIntegerShiftRight2).and(bigInteger);
        bigIntegerArr[1] = bjs.s(-584579408722730L, bigIntegerArr[1].add(bigIntegerArr[2]), bigInteger);
        bigIntegerArr[3] = bjs.s(-584540754017066L, bigIntegerArr[3].subtract(bigIntegerArr[7]), bigInteger);
        BigInteger bigInteger5 = bigIntegerArr[0];
        BigInteger bigIntegerShiftLeft2 = bigIntegerArr[2].shiftLeft(15);
        bzo.p(bigIntegerShiftLeft2, cnb.z(-584463444605738L));
        bigIntegerArr[0] = bigInteger5.xor(bigIntegerShiftLeft2).and(bigInteger);
        bigIntegerArr[2] = bjs.s(-584399020096298L, bigIntegerArr[2].add(bigIntegerArr[3]), bigInteger);
        bigIntegerArr[4] = bjs.s(-584910121204522L, bigIntegerArr[4].subtract(bigIntegerArr[0]), bigInteger);
        BigInteger bigInteger6 = bigIntegerArr[1];
        BigInteger bigIntegerShiftRight3 = bigIntegerArr[3].shiftRight(14);
        bzo.p(bigIntegerShiftRight3, cnb.z(-584901531269930L));
        bigIntegerArr[1] = bigInteger6.xor(bigIntegerShiftRight3).and(bigInteger);
        bigIntegerArr[3] = bjs.s(-584832811793194L, bigIntegerArr[3].add(bigIntegerArr[4]), bigInteger);
        bigIntegerArr[5] = bjs.s(-584742617479978L, bigIntegerArr[5].subtract(bigIntegerArr[1]), bigInteger);
        BigInteger bigInteger7 = bigIntegerArr[2];
        BigInteger bigIntegerShiftLeft3 = bigIntegerArr[4].shiftLeft(20);
        bzo.p(bigIntegerShiftLeft3, cnb.z(-584734027545386L));
        bigIntegerArr[2] = bigInteger7.xor(bigIntegerShiftLeft3).and(bigInteger);
        bigIntegerArr[4] = bjs.s(-584102667352874L, bigIntegerArr[4].add(bigIntegerArr[5]), bigInteger);
        bigIntegerArr[6] = bjs.s(-584081192516394L, bigIntegerArr[6].subtract(bigIntegerArr[2]), bigInteger);
        BigInteger bigInteger8 = bigIntegerArr[3];
        BigInteger bigIntegerShiftRight4 = bigIntegerArr[5].shiftRight(17);
        bzo.p(bigIntegerShiftRight4, cnb.z(-584003883105066L));
        bigIntegerArr[3] = bigInteger8.xor(bigIntegerShiftRight4).and(bigInteger);
        bigIntegerArr[5] = bjs.s(-583935163628330L, bigIntegerArr[5].add(bigIntegerArr[6]), bigInteger);
        bigIntegerArr[7] = bjs.s(-583896508922666L, bigIntegerArr[7].subtract(bigIntegerArr[3]), bigInteger);
        BigInteger bigInteger9 = bigIntegerArr[4];
        BigInteger bigIntegerShiftLeft4 = bigIntegerArr[6].shiftLeft(14);
        bzo.p(bigIntegerShiftLeft4, cnb.z(-584368955325226L));
        bigIntegerArr[4] = bigInteger9.xor(bigIntegerShiftLeft4).and(bigInteger);
        bigIntegerArr[6] = bjs.s(-584304530815786L, bigIntegerArr[6].add(bigIntegerArr[7]), bigInteger);
    }

    public final void h() {
        BigInteger[] bigIntegerArr = this.e;
        BigInteger bigIntegerAdd = bigIntegerArr[2].add(BigInteger.ONE);
        bzo.p(bigIntegerAdd, cnb.z(-584205746567978L));
        BigInteger bigInteger = a;
        bigIntegerArr[2] = bigIntegerAdd.and(bigInteger);
        bigIntegerArr[1] = bjs.s(-584184271731498L, bigIntegerArr[1].add(bigIntegerArr[2]), bigInteger);
        for (int i = 0; i < 256; i++) {
            int i2 = i % 4;
            if (i2 == 0) {
                BigInteger bigInteger2 = bigIntegerArr[0];
                BigInteger bigIntegerShiftLeft = bigInteger2.shiftLeft(21);
                bzo.p(bigIntegerShiftLeft, cnb.z(-584145617025834L));
                bigIntegerArr[0] = bigInteger2.xor(bigIntegerShiftLeft).not().and(bigInteger);
            } else if (i2 == 1) {
                BigInteger bigInteger3 = bigIntegerArr[0];
                BigInteger bigIntegerShiftRight = bigInteger3.shiftRight(5);
                bzo.p(bigIntegerShiftRight, cnb.z(-581332413446954L));
                bigIntegerArr[0] = bigInteger3.xor(bigIntegerShiftRight);
            } else if (i2 == 2) {
                BigInteger bigInteger4 = bigIntegerArr[0];
                BigInteger bigIntegerShiftLeft2 = bigInteger4.shiftLeft(12);
                bzo.p(bigIntegerShiftLeft2, cnb.z(-581263693970218L));
                bigIntegerArr[0] = bigInteger4.xor(bigIntegerShiftLeft2);
            } else if (i2 == 3) {
                BigInteger bigInteger5 = bigIntegerArr[0];
                BigInteger bigIntegerShiftRight2 = bigInteger5.shiftRight(33);
                bzo.p(bigIntegerShiftRight2, cnb.z(-581182089591594L));
                bigIntegerArr[0] = bigInteger5.xor(bigIntegerShiftRight2);
            }
            BigInteger bigInteger6 = bigIntegerArr[0];
            BigInteger[] bigIntegerArr2 = this.d;
            bigIntegerArr[0] = bjs.s(-581113370114858L, bigInteger6.add(bigIntegerArr2[(i + 128) % 256]), bigInteger);
            BigInteger bigInteger7 = bigIntegerArr2[i];
            BigInteger bigIntegerShiftRight3 = bigInteger7.shiftRight(3);
            bzo.p(bigIntegerShiftRight3, cnb.z(-581641651092266L));
            long j = 256;
            BigInteger bigIntegerValueOf = BigInteger.valueOf(j);
            bzo.p(bigIntegerValueOf, cnb.z(-581572931615530L));
            BigInteger bigIntegerAdd2 = bigIntegerArr2[bigIntegerShiftRight3.mod(bigIntegerValueOf).intValue()].add(bigIntegerArr[0]);
            bzo.p(bigIntegerAdd2, cnb.z(-581482737302314L));
            BigInteger bigIntegerS = bjs.s(-581461262465834L, bigIntegerAdd2.add(bigIntegerArr[1]), bigInteger);
            bigIntegerArr2[i] = bigIntegerS;
            BigInteger bigIntegerShiftRight4 = bigIntegerS.shiftRight(11);
            bzo.p(bigIntegerShiftRight4, cnb.z(-581422607760170L));
            BigInteger bigIntegerValueOf2 = BigInteger.valueOf(j);
            bzo.p(bigIntegerValueOf2, cnb.z(-580804132469546L));
            bigIntegerArr[1] = bjs.s(-580731118025514L, bigIntegerArr2[bigIntegerShiftRight4.mod(bigIntegerValueOf2).intValue()].add(bigInteger7), bigInteger);
            this.c[i] = bigIntegerArr[1];
        }
    }
}
