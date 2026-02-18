package me.hd.wauxv.obf;

import android.util.Log;
import com.alibaba.fastjson2.JSONB;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class axh {
    public final int a;
    public final int b;
    public final long c;
    public final byte[] d;

    public axh(int i, int i2, byte[] bArr) {
        this(-1L, bArr, i, i2);
    }

    public static axh e(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[axl.t[4]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putInt((int) jArr[0]);
        return new axh(4, 1, byteBufferWrap.array());
    }

    public static axh f(axj axjVar, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[axl.t[5]]);
        byteBufferWrap.order(byteOrder);
        axj axjVar2 = new axj[]{axjVar}[0];
        byteBufferWrap.putInt((int) axjVar2.a);
        byteBufferWrap.putInt((int) axjVar2.b);
        return new axh(5, 1, byteBufferWrap.array());
    }

    public static axh g(int i, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[axl.t[3]]);
        byteBufferWrap.order(byteOrder);
        byteBufferWrap.putShort((short) new int[]{i}[0]);
        return new axh(3, 1, byteBufferWrap.array());
    }

    public final double h(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (objK instanceof String) {
            return Double.parseDouble((String) objK);
        }
        if (objK instanceof long[]) {
            if (((long[]) objK).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objK instanceof int[]) {
            if (((int[]) objK).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (objK instanceof double[]) {
            double[] dArr = (double[]) objK;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objK instanceof axj[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        axj[] axjVarArr = (axj[]) objK;
        if (axjVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        axj axjVar = axjVarArr[0];
        return axjVar.a / axjVar.b;
    }

    public final int i(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (objK instanceof String) {
            return Integer.parseInt((String) objK);
        }
        if (objK instanceof long[]) {
            long[] jArr = (long[]) objK;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(objK instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) objK;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String j(ByteOrder byteOrder) throws Throwable {
        Object objK = k(byteOrder);
        if (objK == null) {
            return null;
        }
        if (objK instanceof String) {
            return (String) objK;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (objK instanceof long[]) {
            long[] jArr = (long[]) objK;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objK instanceof int[]) {
            int[] iArr = (int[]) objK;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (objK instanceof double[]) {
            double[] dArr = (double[]) objK;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(objK instanceof axj[])) {
            return null;
        }
        axj[] axjVarArr = (axj[]) objK;
        while (i < axjVarArr.length) {
            sb.append(axjVarArr[i].a);
            sb.append('/');
            sb.append(axjVarArr[i].b);
            i++;
            if (i != axjVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Found duplicated region for block: B:219:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:133:0x0032 */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [me.hd.wauxv.obf.axj[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [me.hd.wauxv.obf.axj[]] */
    /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public final Serializable k(ByteOrder byteOrder) throws Throwable {
        axg axgVar;
        InputStream inputStream;
        ?? str;
        byte b;
        byte[] bArr = this.d;
        InputStream inputStream2 = null;
        try {
            try {
                axgVar = new axg(bArr);
                try {
                    axgVar.d = byteOrder;
                    int i = this.a;
                    int length = 0;
                    int i2 = this.b;
                    switch (i) {
                        case 1:
                        case 6:
                            if (bArr.length == 1 && (b = bArr[0]) >= 0 && b <= 1) {
                                String str2 = new String(new char[]{(char) (b + JSONB.Constants.BC_INT32_BYTE_MIN)});
                                try {
                                    axgVar.close();
                                    return str2;
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                    return str2;
                                }
                            }
                            str = new String(bArr, axl.ac);
                            break;
                            break;
                        case 2:
                        case 7:
                            if (i2 >= axl.u.length) {
                                int i3 = 0;
                                while (true) {
                                    byte[] bArr2 = axl.u;
                                    if (i3 >= bArr2.length) {
                                        length = bArr2.length;
                                    } else if (bArr[i3] == bArr2[i3]) {
                                        i3++;
                                    }
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < i2) {
                                byte b2 = bArr[length];
                                if (b2 == 0) {
                                    str = sb.toString();
                                } else {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                break;
                            }
                            str = sb.toString();
                            break;
                        case 3:
                            str = new int[i2];
                            while (length < i2) {
                                str[length] = axgVar.readUnsignedShort();
                                length++;
                            }
                            break;
                        case 4:
                            str = new long[i2];
                            while (length < i2) {
                                str[length] = ((long) axgVar.readInt()) & 4294967295L;
                                length++;
                            }
                            break;
                        case 5:
                            str = new axj[i2];
                            while (length < i2) {
                                str[length] = new axj(((long) axgVar.readInt()) & 4294967295L, ((long) axgVar.readInt()) & 4294967295L);
                                length++;
                            }
                            break;
                        case 8:
                            str = new int[i2];
                            while (length < i2) {
                                str[length] = axgVar.readShort();
                                length++;
                            }
                            break;
                        case 9:
                            str = new int[i2];
                            while (length < i2) {
                                str[length] = axgVar.readInt();
                                length++;
                            }
                            break;
                        case 10:
                            str = new axj[i2];
                            while (length < i2) {
                                str[length] = new axj(axgVar.readInt(), axgVar.readInt());
                                length++;
                            }
                            break;
                        case 11:
                            str = new double[i2];
                            while (length < i2) {
                                str[length] = axgVar.readFloat();
                                length++;
                            }
                            break;
                        case 12:
                            str = new double[i2];
                            while (length < i2) {
                                str[length] = axgVar.readDouble();
                                length++;
                            }
                            break;
                        default:
                            try {
                                axgVar.close();
                                return null;
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                return null;
                            }
                    }
                    try {
                        axgVar.close();
                        return str;
                    } catch (IOException e3) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                        return str;
                    }
                } catch (IOException e4) {
                    e = e4;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (axgVar != null) {
                        try {
                            axgVar.close();
                        } catch (IOException e5) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e6) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                    }
                }
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            axgVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(axl.s[this.a]);
        sb.append(", data length:");
        return yg.m(sb, ")", this.d.length);
    }

    public axh(long j, byte[] bArr, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = bArr;
    }
}
