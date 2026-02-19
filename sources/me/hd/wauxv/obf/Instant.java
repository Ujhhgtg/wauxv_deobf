package me.hd.wauxv.obf;

import java.io.Serializable;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Instant implements Comparable, Serializable {
    public static final Instant a = new Instant(-31557014167219200L, 0);
    public static final Instant b = new Instant(31556889864403199L, 999999999);
    public final long c;
    public final int d;

    public Instant(long j, int i) {
        this.c = j;
        this.d = i;
        if (-31557014167219200L > j || j >= 31556889864403200L) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant");
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        Instant instantVar = (Instant) obj;
        throwIfVar1IsNull(instantVar, "other");
        long j = this.c;
        long j2 = instantVar.c;
        int i = j < j2 ? -1 : j == j2 ? 0 : 1;
        return i != 0 ? i : KotlinHelpers.r(this.d, instantVar.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instantVar = (Instant) obj;
        return this.c == instantVar.c && this.d == instantVar.d;
    }

    public final int hashCode() {
        return (this.d * 51) + Long.hashCode(this.c);
    }

    public final String toString() {
        long j;
        int[] iArr;
        StringBuilder sb = new StringBuilder();
        long j2 = this.c;
        long j3 = j2 / 86400;
        long j4 = 0;
        if ((j2 ^ 86400) < 0 && j3 * 86400 != j2) {
            j3--;
        }
        long j5 = j2 % 86400;
        int i = (int) (j5 + (86400 & (((j5 ^ 86400) & ((-j5) | j5)) >> 63)));
        long j6 = (j3 + ((long) 719528)) - ((long) 60);
        if (j6 < 0) {
            long j7 = 146097;
            long j8 = ((j6 + 1) / j7) - 1;
            j = 0;
            j4 = ((long) 400) * j8;
            j6 += (-j8) * j7;
        } else {
            j = 0;
        }
        long j9 = j6;
        long j10 = 400;
        long j11 = ((j10 * j9) + ((long) 591)) / ((long) 146097);
        long j12 = 365;
        long j13 = 4;
        long j14 = 100;
        long j15 = StaticHelpers6.j(j11, j10, ((j11 / j13) + (j12 * j11)) - (j11 / j14), j9);
        if (j15 < j) {
            j11--;
            j15 = StaticHelpers6.j(j11, j10, ((j11 / j13) + (j12 * j11)) - (j11 / j14), j9);
        }
        int i2 = (int) j15;
        int i3 = ((i2 * 5) + 2) / 153;
        int i4 = ((i3 + 2) % 12) + 1;
        int i5 = (i2 - (((i3 * 306) + 5) / 10)) + 1;
        int i6 = (int) (j11 + j4 + ((long) (i3 / 10)));
        int i7 = i / 3600;
        int i8 = i - (i7 * 3600);
        int i9 = i8 / 60;
        int i10 = i8 - (i9 * 60);
        int i11 = 0;
        if (Math.abs(i6) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (i6 >= 0) {
                sb2.append(i6 + 10000);
                throwIfVar1IsNull(sb2.deleteCharAt(0), "deleteCharAt(...)");
            } else {
                sb2.append(i6 - 10000);
                throwIfVar1IsNull(sb2.deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (i6 >= 10000) {
                sb.append(SignatureVisitor.EXTENDS);
            }
            sb.append(i6);
        }
        sb.append(SignatureVisitor.SUPER);
        FastKV.z(sb, sb, i4);
        sb.append(SignatureVisitor.SUPER);
        FastKV.z(sb, sb, i5);
        sb.append('T');
        FastKV.z(sb, sb, i7);
        sb.append(':');
        FastKV.z(sb, sb, i9);
        sb.append(':');
        FastKV.z(sb, sb, i10);
        int i12 = this.d;
        if (i12 != 0) {
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            while (true) {
                iArr = FastKV.h;
                int i13 = i11 + 1;
                if (i12 % iArr[i13] != 0) {
                    break;
                }
                i11 = i13;
            }
            int i14 = i11 - (i11 % 3);
            String strValueOf = String.valueOf((i12 / iArr[i14]) + iArr[9 - i14]);
            throwIfVar1IsNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String strSubstring = strValueOf.substring(1);
            throwIfVar1IsNull(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        sb.append('Z');
        return sb.toString();
    }
}
