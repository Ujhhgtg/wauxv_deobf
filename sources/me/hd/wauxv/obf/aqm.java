package me.hd.wauxv.obf;

import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class aqm implements Comparable {
    public static final long a;
    public static final long b;
    public static final /* synthetic */ int c = 0;
    public final long d;

    static {
        int i = aqn.a;
        a = cna.o(4611686018427387903L);
        b = cna.o(-4611686018427387903L);
    }

    public static final long e(long j, long j2) {
        long j3 = 1000000;
        long j4 = j2 / j3;
        long j5 = j + j4;
        if (-4611686018426L > j5 || j5 >= 4611686018427L) {
            return cna.o(dqc.az(j5));
        }
        long j6 = ((j5 * j3) + (j2 - (j4 * j3))) << 1;
        int i = aqn.a;
        return j6;
    }

    public static final void f(StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        CharSequence charSequenceSubSequence;
        sb.append(i);
        if (i2 != 0) {
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
            String strValueOf = String.valueOf(i2);
            bzo.q(strValueOf, "<this>");
            if (i3 < 0) {
                throw new IllegalArgumentException(yg.f(i3, "Desired length ", " is less than zero."));
            }
            if (i3 <= strValueOf.length()) {
                charSequenceSubSequence = strValueOf.subSequence(0, strValueOf.length());
            } else {
                StringBuilder sb2 = new StringBuilder(i3);
                int length = i3 - strValueOf.length();
                int i4 = 1;
                if (1 <= length) {
                    while (true) {
                        sb2.append('0');
                        if (i4 == length) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                sb2.append((CharSequence) strValueOf);
                charSequenceSubSequence = sb2;
            }
            String string = charSequenceSubSequence.toString();
            int i5 = -1;
            int length2 = string.length() - 1;
            if (length2 >= 0) {
                while (true) {
                    int i6 = length2 - 1;
                    if (string.charAt(length2) != '0') {
                        i5 = length2;
                        break;
                    } else if (i6 < 0) {
                        break;
                    } else {
                        length2 = i6;
                    }
                }
            }
            int i7 = i5 + 1;
            if (z || i7 >= 3) {
                sb.append((CharSequence) string, 0, ((i5 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) string, 0, i7);
            }
        }
        sb.append(str);
    }

    public static final int g(long j) {
        if (h(j)) {
            return 0;
        }
        return (int) ((((int) j) & 1) == 1 ? ((j >> 1) % ((long) 1000)) * ((long) 1000000) : (j >> 1) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
    }

    public static final boolean h(long j) {
        return j == a || j == b;
    }

    public static final long i(long j, long j2) {
        if (h(j)) {
            if (!h(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (h(j2)) {
            return j2;
        }
        int i = ((int) j) & 1;
        if (i != (((int) j2) & 1)) {
            return i == 1 ? e(j >> 1, j2 >> 1) : e(j2 >> 1, j >> 1);
        }
        long j3 = (j >> 1) + (j2 >> 1);
        if (i != 0) {
            return cna.p(j3);
        }
        if (-4611686018426999999L > j3 || j3 >= 4611686018427000000L) {
            return cna.o(j3 / ((long) 1000000));
        }
        long j4 = j3 << 1;
        int i2 = aqn.a;
        return j4;
    }

    public static final long j(long j, aqp aqpVar) {
        bzo.q(aqpVar, "unit");
        if (j == a) {
            return Long.MAX_VALUE;
        }
        if (j == b) {
            return Long.MIN_VALUE;
        }
        long j2 = j >> 1;
        aqp aqpVar2 = (((int) j) & 1) == 0 ? aqp.NANOSECONDS : aqp.MILLISECONDS;
        bzo.q(aqpVar2, "sourceUnit");
        return aqpVar.h.convert(j2, aqpVar2.h);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = ((aqm) obj).d;
        long j2 = this.d;
        long j3 = j2 ^ j;
        if (j3 >= 0 && (((int) j3) & 1) != 0) {
            int i = (((int) j2) & 1) - (((int) j) & 1);
            return j2 < 0 ? -i : i;
        }
        if (j2 < j) {
            return -1;
        }
        return j2 == j ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof aqm) {
            return this.d == ((aqm) obj).d;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.d);
    }

    public final String toString() {
        long j;
        int iJ;
        long j2 = this.d;
        if (j2 == 0) {
            return "0s";
        }
        if (j2 == a) {
            return "Infinity";
        }
        if (j2 == b) {
            return "-Infinity";
        }
        int i = 0;
        boolean z = j2 < 0;
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(SignatureVisitor.SUPER);
        }
        if (j2 < 0) {
            j2 = ((long) (((int) j2) & 1)) + ((-(j2 >> 1)) << 1);
            int i2 = aqn.a;
        }
        long j3 = j(j2, aqp.DAYS);
        int iJ2 = h(j2) ? 0 : (int) (j(j2, aqp.HOURS) % ((long) 24));
        if (h(j2)) {
            j = 0;
            iJ = 0;
        } else {
            j = 0;
            iJ = (int) (j(j2, aqp.MINUTES) % ((long) 60));
        }
        int iJ3 = h(j2) ? 0 : (int) (j(j2, aqp.SECONDS) % ((long) 60));
        int iG = g(j2);
        boolean z2 = j3 != j;
        boolean z3 = iJ2 != 0;
        boolean z4 = iJ != 0;
        boolean z5 = (iJ3 == 0 && iG == 0) ? false : true;
        if (z2) {
            sb.append(j3);
            sb.append(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
            i = 1;
        }
        if (z3 || (z2 && (z4 || z5))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iJ2);
            sb.append('h');
            i = i3;
        }
        if (z4 || (z5 && (z3 || z2))) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(iJ);
            sb.append(Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL);
            i = i4;
        }
        if (z5) {
            int i5 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (iJ3 != 0 || z2 || z3 || z4) {
                f(sb, iJ3, iG, 9, com.umeng.analytics.pro.bt.az, false);
            } else if (iG >= 1000000) {
                f(sb, iG / 1000000, iG % 1000000, 6, "ms", false);
            } else if (iG >= 1000) {
                f(sb, iG / 1000, iG % 1000, 3, "us", false);
            } else {
                sb.append(iG);
                sb.append("ns");
            }
            i = i5;
        }
        if (z && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
