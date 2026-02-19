package me.hd.wauxv.obf;

import com.alibaba.fastjson2.JSONB;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class sj implements Serializable, Comparable {
    public static final sj a = new sj(new byte[0]);
    public final byte[] b;
    public transient int c;
    public transient String d;

    public sj(byte[] bArr) {
        throwIfVar1IsNull(bArr, "data");
        this.b = bArr;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        sj sjVar = (sj) obj;
        throwIfVar1IsNull(sjVar, "other");
        int iG = g();
        int iG2 = sjVar.g();
        int iMin = Math.min(iG, iG2);
        for (int i = 0; i < iMin; i++) {
            int iJ = j(i) & 255;
            int iJ2 = sjVar.j(i) & 255;
            if (iJ != iJ2) {
                return iJ < iJ2 ? -1 : 1;
            }
        }
        if (iG == iG2) {
            return 0;
        }
        return iG < iG2 ? -1 : 1;
    }

    public String e() {
        byte[] bArr = a.a;
        byte[] bArr2 = this.b;
        throwIfVar1IsNull(bArr2, "<this>");
        throwIfVar1IsNull(bArr, "map");
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr2[i];
            int i3 = i + 2;
            byte b2 = bArr2[i + 1];
            i += 3;
            byte b3 = bArr2[i3];
            bArr3[i2] = bArr[(b & 255) >> 2];
            bArr3[i2 + 1] = bArr[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int i4 = i2 + 3;
            bArr3[i2 + 2] = bArr[((b2 & com.umeng.analytics.pro.dn.m) << 2) | ((b3 & 255) >> 6)];
            i2 += 4;
            bArr3[i4] = bArr[b3 & JSONB.Constants.BC_INT32_BYTE_MAX];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b4 = bArr2[i];
            bArr3[i2] = bArr[(b4 & 255) >> 2];
            bArr3[i2 + 1] = bArr[(b4 & 3) << 4];
            bArr3[i2 + 2] = 61;
            bArr3[i2 + 3] = 61;
        } else if (length2 == 2) {
            int i5 = i + 1;
            byte b5 = bArr2[i];
            byte b6 = bArr2[i5];
            bArr3[i2] = bArr[(b5 & 255) >> 2];
            bArr3[i2 + 1] = bArr[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            bArr3[i2 + 2] = bArr[(b6 & com.umeng.analytics.pro.dn.m) << 2];
            bArr3[i2 + 3] = 61;
        }
        return new String(bArr3, uj.a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sj) {
            sj sjVar = (sj) obj;
            int iG = sjVar.g();
            byte[] bArr = this.b;
            if (iG == bArr.length && sjVar.l(bArr, 0, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public sj f(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.b, 0, g());
        byte[] bArrDigest = messageDigest.digest();
        throwIfVar1IsNull(bArrDigest);
        return new sj(bArrDigest);
    }

    public int g() {
        return this.b.length;
    }

    public String h() {
        byte[] bArr = this.b;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ajn.a;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & com.umeng.analytics.pro.dn.m];
        }
        return new String(cArr);
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b);
        this.c = iHashCode;
        return iHashCode;
    }

    public byte[] i() {
        return this.b;
    }

    public byte j(int i) {
        return this.b[i];
    }

    public boolean k(sj sjVar, int i) {
        throwIfVar1IsNull(sjVar, "other");
        return sjVar.l(this.b, 0, 0, i);
    }

    public boolean l(byte[] bArr, int i, int i2, int i3) {
        throwIfVar1IsNull(bArr, "other");
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.b;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && aye.l(bArr2, i, i2, bArr, i3);
    }

    public sj m() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                throwIfVar1IsNull(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new sj(bArrCopyOf);
            }
            i++;
        }
    }

    public final String n() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        byte[] bArrI = i();
        throwIfVar1IsNull(bArrI, "<this>");
        String str2 = new String(bArrI, uj.a);
        this.d = str2;
        return str2;
    }

    public void o(int i, rh rhVar) {
        rhVar.write(this.b, 0, i);
    }

    /*
     * JADX WARN: Found duplicated region for block: B:179:0x01b6 A[EDGE_INSN:
     * B:179:0x01b6->B:180:0x01b7 BREAK A[LOOP:0: B:7:0x000e->B:241:0x000e]]
     */
    public String toString() {
        byte b;
        int i;
        byte[] bArr = this.b;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i2 < length) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i5 = i2 + 3;
                        if (length > i5) {
                            byte b3 = bArr[i2 + 1];
                            if ((b3 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b4 = bArr[i2 + 2];
                            if ((b4 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b5 = bArr[i5];
                            if ((b5 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                            if (i6 <= 1114111) {
                                if (55296 <= i6 && i6 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                if (i6 >= 65536) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if ((i6 != 10 && i6 != 13 && ((i6 >= 0 && i6 < 32) || (127 <= i6 && i6 < 160)))
                                            || i6 == 65533) {
                                        i3 = -1;
                                        break;
                                    }
                                    i3 += i6 < 65536 ? 1 : 2;
                                    i2 += 4;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        int i7 = i2 + 2;
                        if (length > i7) {
                            byte b6 = bArr[i2 + 1];
                            if ((b6 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i8 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b2 << 12);
                            if (i8 >= 2048) {
                                if (55296 <= i8 && i8 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160)))
                                        || i8 == 65533) {
                                    i3 = -1;
                                    break;
                                }
                                i3 += i8 < 65536 ? 1 : 2;
                                i2 += 3;
                                i4 = i;
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    }
                } else {
                    int i9 = i2 + 1;
                    if (length > i9) {
                        byte b8 = bArr[i9];
                        if ((b8 & JSONB.Constants.BC_INT64_SHORT_MIN) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i10 = (b8 ^ 3968) ^ (b2 << 6);
                        if (i10 >= 128) {
                            i = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160)))
                                    || i10 == 65533) {
                                i3 = -1;
                                break;
                            }
                            i3 += i10 < 65536 ? 1 : 2;
                            i2 += 2;
                            i4 = i;
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i3 = -1;
                        break;
                    }
                }
            } else {
                int i11 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (127 > b2 || b2 >= 160))) && b2 != 65533) {
                    i3 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i11;
                        if (i2 < length && (b = bArr[i2]) >= 0) {
                            i2++;
                            i11 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if ((b == 10 || b == 13 || ((b < 0 || b >= 32) && (127 > b || b >= 160))) && b != 65533) {
                                i3 += b < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            String strN = n();
            String strSubstring = strN.substring(0, i3);
            throwIfVar1IsNull(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strBo = dnr.bo(dnr.bo(dnr.bo(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i3 >= strN.length()) {
                return StaticHelpers6.o(']', "[text=", strBo);
            }
            return "[size=" + bArr.length + " text=" + strBo + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + h() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(
                    StaticHelpers6.concatFromSb(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        sb.append((64 == bArr.length ? this : new sj(SomeStaticHelpers._ap(0, 64, bArr))).h());
        sb.append("…]");
        return sb.toString();
    }
}
