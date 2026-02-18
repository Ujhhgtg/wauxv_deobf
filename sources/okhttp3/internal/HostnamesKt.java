package okhttp3.internal;

import com.android.dx.io.Opcodes;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dnr;
import me.hd.wauxv.obf.rh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (bzo.r(cCharAt, 31) <= 0 || bzo.r(cCharAt, 127) >= 0 || dnj.ah(cCharAt, 0, 6, " #%/:?@[\\]") != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (bzo.r(cCharAt, 48) < 0 || bzo.r(cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Found duplicated region for block: B:31:0x0057 A[LOOP:1: B:28:0x004b->B:31:0x0057, LOOP_END] */
    /* JADX WARN: Found duplicated region for block: B:53:0x005d A[EDGE_INSN: B:53:0x005d->B:32:0x005d BREAK  A[LOOP:1: B:28:0x004b->B:31:0x0057], SYNTHETIC] */
    private static final InetAddress decodeIpv6(String str, int i, int i2) {
        int i3;
        int i4;
        int hexDigit;
        byte[] bArr = new byte[16];
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (i < i2) {
            if (i5 == 16) {
                return null;
            }
            int i8 = i + 2;
            if (i8 <= i2 && dnr.bq(str, false, i, "::")) {
                if (i6 != -1) {
                    return null;
                }
                i5 += 2;
                i6 = i5;
                if (i8 == i2) {
                    break;
                }
                i7 = i8;
                i3 = 0;
                i = i7;
                while (i < i2) {
                    hexDigit = Util.parseHexDigit(str.charAt(i));
                    if (hexDigit != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + hexDigit;
                    i++;
                }
                i4 = i - i7;
                return i4 == 0 ? null : null;
            }
            if (i5 != 0) {
                if (!dnr.bq(str, false, i, ":")) {
                    if (!dnr.bq(str, false, i, ".") || !decodeIpv4Suffix(str, i7, i2, bArr, i5 - 2)) {
                        return null;
                    }
                    i5 += 2;
                    break;
                }
                i++;
            }
            i7 = i;
            i3 = 0;
            i = i7;
            while (i < i2) {
                hexDigit = Util.parseHexDigit(str.charAt(i));
                if (hexDigit != -1) {
                    break;
                }
                i3 = (i3 << 4) + hexDigit;
                i++;
            }
            i4 = i - i7;
            if (i4 == 0 && i4 <= 4) {
                int i9 = i5 + 1;
                bArr[i5] = (byte) ((i3 >>> 8) & Opcodes.CONST_METHOD_TYPE);
                i5 += 2;
                bArr[i9] = (byte) (i3 & Opcodes.CONST_METHOD_TYPE);
            }
        }
        if (i5 != 16) {
            if (i6 == -1) {
                return null;
            }
            int i10 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, 16 - i10, i10);
            Arrays.fill(bArr, i6, (16 - i5) + i6, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        rh rhVar = new rh();
        while (i2 < bArr.length) {
            if (i2 == i) {
                rhVar.am(58);
                i2 += i4;
                if (i2 == 16) {
                    rhVar.am(58);
                }
            } else {
                if (i2 > 0) {
                    rhVar.am(58);
                }
                rhVar.ao((Util.and(bArr[i2], Opcodes.CONST_METHOD_TYPE) << 8) | Util.and(bArr[i2 + 1], Opcodes.CONST_METHOD_TYPE));
                i2 += 2;
            }
        }
        return rhVar.ac();
    }

    public static final String toCanonicalHost(String str) {
        bzo.q(str, "<this>");
        if (dnj.ab(str, ":", false)) {
            InetAddress inetAddressDecodeIpv6 = (dnr.bp(str, "[", false) && dnr.bi(str, "]")) ? decodeIpv6(str, 1, str.length() - 1) : decodeIpv6(str, 0, str.length());
            if (inetAddressDecodeIpv6 == null) {
                return null;
            }
            byte[] address = inetAddressDecodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return inetAddressDecodeIpv6.getHostAddress();
            }
            throw new AssertionError(dkz.o('\'', "Invalid IPv6 address: '", str));
        }
        try {
            String ascii = IDN.toASCII(str);
            bzo.p(ascii, "toASCII(host)");
            Locale locale = Locale.US;
            bzo.p(locale, "US");
            String lowerCase = ascii.toLowerCase(locale);
            bzo.p(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() == 0 || containsInvalidHostnameAsciiCodes(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
