package com.alibaba.fastjson2.support.csv;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.reader.ByteArrayValueConsumer;
import com.alibaba.fastjson2.reader.FieldReader;
import com.alibaba.fastjson2.reader.FieldReaderAtomicReferenceMethodReadOnly;
import com.alibaba.fastjson2.reader.ObjectReaderAdapter;
import com.alibaba.fastjson2.reader.ObjectReaderProvider;
import com.alibaba.fastjson2.stream.StreamReader;
import com.alibaba.fastjson2.util.DateUtils;
import com.alibaba.fastjson2.util.Fnv;
import com.alibaba.fastjson2.util.IOUtils;
import com.alibaba.fastjson2.util.TypeUtils;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class CSVReaderUTF8<T> extends CSVReader<T> {
    static final int ESCAPE_INDEX_NOT_SET = -2;
    static final Map<Long, Function<Consumer, ByteArrayValueConsumer>> valueConsumerCreators = new ConcurrentHashMap();
    byte[] buf;
    Charset charset;
    InputStream input;
    int nextEscapeIndex;
    ByteArrayValueConsumer valueConsumer;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class ByteArrayConsumerImpl implements ByteArrayValueConsumer {
        final Consumer consumer;
        protected Object object;

        public ByteArrayConsumerImpl(Consumer consumer) {
            this.consumer = consumer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.alibaba.fastjson2.reader.ByteArrayValueConsumer
        public void accept(int i, int i2, byte[] bArr, int i3, int i4, Charset charset) {
            if (i2 >= ((StreamReader) CSVReaderUTF8.this).fieldReaders.length || i4 == 0) {
                return;
            }
            FieldReaderAtomicReferenceMethodReadOnly fieldReaderAtomicReferenceMethodReadOnly = ((StreamReader) CSVReaderUTF8.this).fieldReaders[i2];
            fieldReaderAtomicReferenceMethodReadOnly.accept(this.object, CSVReaderUTF8.this.readValue(bArr, i3, i4, fieldReaderAtomicReferenceMethodReadOnly.fieldType));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.alibaba.fastjson2.reader.ByteArrayValueConsumer
        public final void afterRow(int i) {
            this.consumer.accept(this.object);
            this.object = null;
        }

        @Override // com.alibaba.fastjson2.reader.ByteArrayValueConsumer
        public final void beforeRow(int i) {
            if (((StreamReader) CSVReaderUTF8.this).objectCreator != null) {
                this.object = ((StreamReader) CSVReaderUTF8.this).objectCreator.get();
            }
        }
    }

    public CSVReaderUTF8(StreamReader.Feature... featureArr) {
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        this.charset = StandardCharsets.UTF_8;
        for (StreamReader.Feature feature : featureArr) {
            this.features |= feature.mask;
        }
    }

    public static boolean containsQuoteOrLineSeparator(long j) {
        long j2 = 2459565876494606882L ^ j;
        long j3 = 723401728380766730L ^ j;
        long j4 = j ^ 940422246894996749L;
        return ((((~j4) & (j4 - 72340172838076673L)) | (((~j2) & (j2 - 72340172838076673L)) | ((~j3) & (j3 - 72340172838076673L)))) & (-9187201950435737472L)) != 0;
    }

    private byte[] getBuf() {
        byte[] bArr = this.buf;
        return bArr != null ? bArr : initBuf();
    }

    private byte[] initBuf() throws IOException {
        if (this.input == null) {
            throw new JSONException("init buf error");
        }
        byte[] bArr = new byte[Opcodes.ASM8];
        int i = 0;
        while (i < 524288) {
            InputStream inputStream = this.input;
            int i2 = this.off;
            int i3 = inputStream.read(bArr, i2, Opcodes.ASM8 - i2);
            if (i3 == -1) {
                this.inputEnd = true;
                break;
            }
            i += i3;
        }
        this.end = i;
        if (i > 4 && IOUtils.isUTF8BOM(bArr, 0)) {
            this.off = 3;
            this.lineNextStart = 3;
        }
        this.buf = bArr;
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$statAll$0(int i, int i2, byte[] bArr, int i3, int i4, Charset charset) {
        getColumnStat(i2).stat(bArr, i3, i4, charset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$statAll$1(int i, int i2, byte[] bArr, int i3, int i4, Charset charset) {
        getColumnStat(i2).stat(bArr, i3, i4, charset);
    }

    private void readLine(ByteArrayValueConsumer byteArrayValueConsumer) {
        ByteArrayValueConsumer byteArrayValueConsumer2;
        int i = this.lineStart;
        byte[] bArr = this.buf;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (i < this.lineEnd) {
            if (bArr[i] == 44) {
                byteArrayValueConsumer2 = byteArrayValueConsumer;
                byteArrayValueConsumer2.accept(this.rowCount, i3, bArr, i2, i4, this.charset);
                i3++;
                i2 = i + 1;
                i4 = 0;
            } else {
                byteArrayValueConsumer2 = byteArrayValueConsumer;
                i4++;
            }
            i++;
            byteArrayValueConsumer = byteArrayValueConsumer2;
        }
        ByteArrayValueConsumer byteArrayValueConsumer3 = byteArrayValueConsumer;
        if (i4 > 0) {
            byteArrayValueConsumer3.accept(this.rowCount, i3, bArr, i2, i4, this.charset);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:17:0x002f A[PHI: r0
      0x002f: PHI (r0v5 int) = (r0v6 int), (r0v1 int) binds: [B:20:0x0036, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Found duplicated region for block: B:22:0x003a A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Found duplicated region for block: B:24:0x003e A[PHI: r2
      0x003e: PHI (r2v7 int) = (r2v1 int), (r2v14 int) binds: [B:21:0x0038, B:23:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Found duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Found duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Found duplicated region for block: B:31:0x005b  */
    /* JADX WARN: Found duplicated region for block: B:62:0x005c A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:63:0x005c A[SYNTHETIC] */
    private void readLineEscaped(ByteArrayValueConsumer byteArrayValueConsumer) {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        byte[] bArr2;
        byte b;
        int i8;
        int i9 = this.lineStart;
        int i10 = 0;
        int i11 = i9;
        boolean z = false;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i = this.lineEnd;
            if (i9 >= i) {
                break;
            }
            byte[] bArr3 = this.buf;
            byte b2 = bArr3[i9];
            if (z) {
                if (b2 != 34) {
                    i12++;
                } else {
                    int i15 = i9 + 1;
                    if (i15 >= i) {
                        if (i15 == i) {
                            break;
                        }
                    } else {
                        byte b3 = bArr3[i15];
                        if (b3 == 34) {
                            i12 += 2;
                            i13++;
                            i9 = i15;
                        } else if (b3 == 44) {
                            b2 = b3;
                            i9 = i15;
                        }
                    }
                    if (b2 == 44) {
                        if (!z) {
                            i3 = i11;
                            i4 = i12;
                        } else if (i13 == 0) {
                            i11++;
                            i3 = i11;
                            i4 = i12;
                        } else {
                            int i16 = i12 - i13;
                            bArr3 = new byte[i16];
                            i5 = i12 + i11;
                            i6 = i11 + 1;
                            i7 = 0;
                            while (i6 < i5) {
                                bArr2 = this.buf;
                                b = bArr2[i6];
                                int i17 = i7 + 1;
                                bArr3[i7] = b;
                                if (b == 34) {
                                    i8 = i6 + 1;
                                    if (bArr2[i8] == 34) {
                                        i6 = i8;
                                    }
                                }
                                i6++;
                                i7 = i17;
                            }
                            i3 = 0;
                            i4 = i16;
                        }
                        byteArrayValueConsumer.accept(this.rowCount, i14, bArr3, i3, i4, this.charset);
                        i11 = i9 + 1;
                        i14++;
                        z = false;
                        i12 = 0;
                        i13 = 0;
                    } else {
                        i12++;
                    }
                }
            } else if (b2 == 34) {
                z = true;
            } else if (b2 == 44) {
                if (!z) {
                    i3 = i11;
                    i4 = i12;
                } else if (i13 == 0) {
                    i11++;
                    i3 = i11;
                    i4 = i12;
                } else {
                    int i162 = i12 - i13;
                    bArr3 = new byte[i162];
                    i5 = i12 + i11;
                    i6 = i11 + 1;
                    i7 = 0;
                    while (i6 < i5) {
                        bArr2 = this.buf;
                        b = bArr2[i6];
                        int i172 = i7 + 1;
                        bArr3[i7] = b;
                        if (b == 34) {
                            i8 = i6 + 1;
                            if (bArr2[i8] == 34) {
                                i6 = i8;
                            }
                        }
                        i6++;
                        i7 = i172;
                    }
                    i3 = 0;
                    i4 = i162;
                }
                byteArrayValueConsumer.accept(this.rowCount, i14, bArr3, i3, i4, this.charset);
                i11 = i9 + 1;
                i14++;
                z = false;
                i12 = 0;
                i13 = 0;
            } else {
                i12++;
            }
            i9++;
        }
        if (i12 > 0) {
            byte[] bArr4 = this.buf;
            if (z) {
                if (i13 == 0) {
                    i10 = i11 + 1;
                } else {
                    i12 -= i13;
                    bArr4 = new byte[i12];
                    int i18 = i11 + 1;
                    int i19 = 0;
                    while (i18 < i) {
                        byte[] bArr5 = this.buf;
                        byte b4 = bArr5[i18];
                        int i20 = i19 + 1;
                        bArr4[i19] = b4;
                        if (b4 == 34) {
                            int i21 = i18 + 1;
                            if (bArr5[i21] == 34) {
                                i18 = i21;
                            }
                        }
                        i18++;
                        i19 = i20;
                    }
                }
                bArr = bArr4;
                i2 = i10;
            } else {
                bArr = bArr4;
                i2 = i11;
            }
            byteArrayValueConsumer.accept(this.rowCount, i14, bArr, i2, i12, this.charset);
        }
    }

    private Object[] readLineValue(boolean z) {
        List<Object> arrayList;
        Object[] objArr;
        boolean z2;
        List<String> list = this.columns;
        if (list != null) {
            int size = list.size();
            objArr = z ? new String[size] : new Object[size];
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            objArr = null;
        }
        int i = this.lineStart;
        int i2 = this.lineEnd;
        byte[] bArr = this.buf;
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        while (i < i2) {
            if (bArr[i] == 44) {
                z2 = z;
                readValue(z2, i4, i5, bArr, i3, objArr, arrayList);
                i4++;
                i3 = i + 1;
                i5 = 0;
            } else {
                z2 = z;
                i5++;
            }
            i++;
            z = z2;
        }
        boolean z3 = z;
        if (i5 > 0) {
            readValue(z3, i4, i5, bArr, i3, objArr, arrayList);
        }
        if (objArr == null && arrayList != null) {
            int size2 = arrayList.size();
            objArr = z3 ? new String[size2] : new Object[size2];
            arrayList.toArray(objArr);
        }
        if (this.input == null && this.off == this.end) {
            this.inputEnd = true;
        }
        return objArr;
    }

    /* JADX WARN: Found duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Found duplicated region for block: B:104:0x0137  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Found duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Found duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Found duplicated region for block: B:42:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Found duplicated region for block: B:43:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:44:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:53:0x008f  */
    /* JADX WARN: Found duplicated region for block: B:54:0x009a  */
    /* JADX WARN: Found duplicated region for block: B:56:0x00a4  */
    /* JADX WARN: Found duplicated region for block: B:58:0x00ae  */
    /* JADX WARN: Found duplicated region for block: B:60:0x00b6  */
    /* JADX WARN: Found duplicated region for block: B:61:0x00b8  */
    /* JADX WARN: Found duplicated region for block: B:65:0x00c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:73:0x00d3  */
    /* JADX WARN: Found duplicated region for block: B:74:0x00db  */
    /* JADX WARN: Found duplicated region for block: B:74:0x00db A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:75:0x00dd A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:78:0x00e3 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:84:0x00f3  */
    /* JADX WARN: Found duplicated region for block: B:87:0x00fd  */
    /* JADX WARN: Found duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Found duplicated region for block: B:94:0x0111  */
    /* JADX WARN: Found duplicated region for block: B:96:0x011a  */
    /* JADX WARN: Found duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Found duplicated region for block: B:99:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    private Object[] readLineValueEscaped(boolean z) {
        Object[] objArr;
        Object str;
        byte b;
        byte b2;
        byte b3;
        int i;
        Type type;
        Object str2;
        byte b4;
        byte b5;
        byte b6;
        ?? r12;
        byte[] bArr;
        int i2;
        int i3;
        int i4;
        byte b7;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        List<String> list = this.columns;
        if (list != null) {
            int size = list.size();
            objArr = z ? new String[size] : new Object[size];
        } else {
            objArr = null;
        }
        int i10 = this.lineStart;
        int i11 = this.lineEnd;
        byte[] bArr2 = this.buf;
        int i12 = i10;
        boolean z2 = false;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        ?? arrayList = 0;
        while (i10 < i11) {
            byte b8 = bArr2[i10];
            if (!z2) {
                i = i10;
                if (b8 == 34) {
                    z2 = true;
                    i10 = i;
                } else if (b8 == 44) {
                    Type[] typeArr = this.types;
                    if (typeArr != null) {
                    }
                    if (z2) {
                        if (i15 == 0) {
                            int i16 = i13 - i15;
                            bArr = new byte[i16];
                            i2 = i13 + i12;
                            i3 = i12 + 1;
                            i4 = 0;
                            while (i3 < i2) {
                                b7 = bArr2[i3];
                                int i17 = i4 + 1;
                                bArr[i4] = b7;
                                if (b7 == 34) {
                                    i7 = i3 + 1;
                                    i5 = i3;
                                    if (bArr2[i7] == 34) {
                                        i6 = i7;
                                    }
                                    i3 = i6 + 1;
                                    i4 = i17;
                                } else {
                                    i5 = i3;
                                }
                                i6 = i5;
                                i3 = i6 + 1;
                                i4 = i17;
                            }
                            if (type == null) {
                            }
                        } else if (type == null) {
                        }
                    } else if (type != null) {
                        if (i13 == 1) {
                        }
                    } else if (i13 == 1) {
                    }
                    if (objArr == null) {
                        if (arrayList == 0) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(str2);
                        r12 = arrayList;
                    } else if (i14 < objArr.length) {
                        r12 = arrayList;
                        objArr[i14] = str2;
                        r12 = arrayList;
                    }
                    r12 = arrayList;
                    i14++;
                    i12 = i + 1;
                    i10 = i;
                    z2 = false;
                    i13 = 0;
                    i15 = 0;
                    arrayList = r12;
                } else {
                    i13++;
                    i10 = i;
                    arrayList = arrayList;
                }
            } else if (b8 == 34) {
                int i18 = i10 + 1;
                if (i18 >= i11) {
                    i8 = i10;
                    if (i18 == i11) {
                        break;
                    }
                } else {
                    i8 = i10;
                    byte b9 = bArr2[i18];
                    if (b9 == 34) {
                        i13 += 2;
                        i15++;
                        i10 = i18;
                    } else {
                        if (b9 == 44) {
                            b8 = b9;
                            i9 = i18;
                        }
                        i = i9;
                        if (b8 == 44) {
                            Type[] typeArr2 = this.types;
                            type = (typeArr2 != null || i14 >= typeArr2.length) ? null : typeArr2[i14];
                            if (z2) {
                                if (i15 == 0) {
                                    int i162 = i13 - i15;
                                    bArr = new byte[i162];
                                    i2 = i13 + i12;
                                    i3 = i12 + 1;
                                    i4 = 0;
                                    while (i3 < i2) {
                                        b7 = bArr2[i3];
                                        int i172 = i4 + 1;
                                        bArr[i4] = b7;
                                        if (b7 == 34) {
                                            i7 = i3 + 1;
                                            i5 = i3;
                                            if (bArr2[i7] == 34) {
                                                i6 = i7;
                                            }
                                            i3 = i6 + 1;
                                            i4 = i172;
                                        } else {
                                            i5 = i3;
                                        }
                                        i6 = i5;
                                        i3 = i6 + 1;
                                        i4 = i172;
                                    }
                                    if (type == null && type != String.class && type != Object.class) {
                                        try {
                                            str2 = readValue(bArr, 0, i162, type);
                                        } catch (Exception e) {
                                            str2 = error(i14, e);
                                        }
                                    }
                                } else if (type == null && type != String.class && type != Object.class && !z) {
                                    try {
                                        str2 = readValue(bArr2, i12 + 1, i13, type);
                                    } catch (Exception e2) {
                                        str2 = error(i14, e2);
                                    }
                                }
                            } else if (type != null || type == String.class || type == Object.class || z) {
                                str2 = (i13 == 1 || (b6 = bArr2[i12]) < 0) ? (i13 == 2 || (b4 = bArr2[i12]) < 0 || (b5 = bArr2[i12 + 1]) < 0) ? new String(bArr2, i12, i13, this.charset) : TypeUtils.toString((char) b4, (char) b5) : TypeUtils.toString((char) b6);
                            } else {
                                try {
                                    str2 = readValue(bArr2, i12, i13, type);
                                } catch (Exception e3) {
                                    str2 = error(i14, e3);
                                }
                            }
                            if (objArr == null) {
                                if (arrayList == 0) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(str2);
                                r12 = arrayList;
                            } else if (i14 < objArr.length) {
                                r12 = arrayList;
                                objArr[i14] = str2;
                                r12 = arrayList;
                            }
                            r12 = arrayList;
                            i14++;
                            i12 = i + 1;
                            i10 = i;
                            z2 = false;
                            i13 = 0;
                            i15 = 0;
                            arrayList = r12;
                        } else {
                            i13++;
                            i10 = i;
                            arrayList = arrayList;
                        }
                    }
                }
                i9 = i8;
                i = i9;
                if (b8 == 44) {
                    Type[] typeArr22 = this.types;
                    if (typeArr22 != null) {
                    }
                    if (z2) {
                        if (i15 == 0) {
                            str2 = type == null ? new String(bArr2, i12 + 1, i13, this.charset) : new String(bArr2, i12 + 1, i13, this.charset);
                        } else {
                            int i1622 = i13 - i15;
                            bArr = new byte[i1622];
                            i2 = i13 + i12;
                            i3 = i12 + 1;
                            i4 = 0;
                            while (i3 < i2) {
                                b7 = bArr2[i3];
                                int i1722 = i4 + 1;
                                bArr[i4] = b7;
                                if (b7 == 34) {
                                    i7 = i3 + 1;
                                    i5 = i3;
                                    if (bArr2[i7] == 34) {
                                        i6 = i7;
                                    }
                                    i3 = i6 + 1;
                                    i4 = i1722;
                                } else {
                                    i5 = i3;
                                }
                                i6 = i5;
                                i3 = i6 + 1;
                                i4 = i1722;
                            }
                            str2 = type == null ? new String(bArr, this.charset) : new String(bArr, this.charset);
                        }
                    } else if (type != null) {
                        if (i13 == 1) {
                        }
                    } else if (i13 == 1) {
                    }
                    if (objArr == null) {
                        if (arrayList == 0) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(str2);
                        r12 = arrayList;
                    } else if (i14 < objArr.length) {
                        r12 = arrayList;
                        objArr[i14] = str2;
                        r12 = arrayList;
                    }
                    r12 = arrayList;
                    i14++;
                    i12 = i + 1;
                    i10 = i;
                    z2 = false;
                    i13 = 0;
                    i15 = 0;
                    arrayList = r12;
                } else {
                    i13++;
                    i10 = i;
                    arrayList = arrayList;
                }
            } else {
                i13++;
            }
            i10++;
            arrayList = arrayList;
        }
        if (i13 > 0 || z2) {
            Type[] typeArr3 = this.types;
            Type type2 = (typeArr3 == null || i14 >= typeArr3.length) ? null : typeArr3[i14];
            if (z2) {
                if (i15 != 0) {
                    int i19 = i13 - i15;
                    byte[] bArr3 = new byte[i19];
                    int i20 = i12 + 1;
                    int i21 = 0;
                    while (i20 < i11) {
                        byte b10 = bArr2[i20];
                        int i22 = i21 + 1;
                        bArr3[i21] = b10;
                        if (b10 == 34) {
                            int i23 = i20 + 1;
                            if (bArr2[i23] == 34) {
                                i20 = i23;
                            }
                        }
                        i20++;
                        i21 = i22;
                    }
                    if (type2 == null || type2 == String.class || type2 == Object.class || z) {
                        str = new String(bArr3, 0, i19, this.charset);
                    } else {
                        try {
                            str = readValue(bArr3, 0, i19, type2);
                        } catch (Exception e4) {
                            str = error(i14, e4);
                        }
                    }
                } else if (type2 == null || type2 == String.class || type2 == Object.class || z) {
                    str = new String(bArr2, i12 + 1, i13, this.charset);
                } else {
                    try {
                        str = readValue(bArr2, i12 + 1, i13, type2);
                    } catch (Exception e5) {
                        str = error(i14, e5);
                    }
                }
            } else if (type2 == null || type2 == String.class || type2 == Object.class || z) {
                str = (i13 != 1 || (b3 = bArr2[i12]) < 0) ? (i13 != 2 || (b = bArr2[i12]) < 0 || (b2 = bArr2[i12 + 1]) < 0) ? new String(bArr2, i12, i13, this.charset) : TypeUtils.toString((char) b, (char) b2) : TypeUtils.toString((char) b3);
            } else {
                try {
                    str = readValue(bArr2, i12, i13, type2);
                } catch (Exception e6) {
                    str = error(i14, e6);
                }
            }
            if (objArr == null) {
                if (arrayList == 0) {
                    arrayList = new ArrayList();
                }
                arrayList.add(str);
            } else if (i14 < objArr.length) {
                objArr[i14] = str;
            }
        }
        if (objArr == null && arrayList != 0) {
            int size2 = arrayList.size();
            objArr = z ? new String[size2] : new Object[size2];
            arrayList.toArray(objArr);
        }
        if (this.input == null && this.off == this.end) {
            this.inputEnd = true;
        }
        return objArr;
    }

    private boolean seekLine0(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i2;
        int i4 = 0;
        int i5 = i;
        while (true) {
            if (i4 < 3) {
                this.lineTerminated = false;
                int i6 = i;
                while (i6 < i3) {
                    byte b = bArr[i6];
                    if (b == 34) {
                        int i7 = this.lineSize;
                        this.lineSize = i7 + 1;
                        if (this.quote) {
                            int i8 = i6 + 1;
                            if (i8 >= i3) {
                                break;
                            }
                            if (bArr[i8] == 34) {
                                this.lineSize = i7 + 2;
                                i6 = i8;
                            } else {
                                this.quote = false;
                            }
                        } else {
                            this.quote = true;
                        }
                        i6++;
                    } else {
                        if (this.quote) {
                            this.lineSize++;
                        } else {
                            if (b == 13 || b == 10) {
                                if (this.lineSize > 0 || (this.features & StreamReader.Feature.IgnoreEmptyLine.mask) == 0) {
                                    this.rowCount++;
                                }
                                this.lineTerminated = true;
                                this.lineSize = 0;
                                this.lineEnd = i6;
                                if (b == 13) {
                                    int i9 = i6 + 1;
                                    if (i9 >= i3) {
                                        break;
                                    }
                                    if (bArr[i9] == 10) {
                                        i6 = i9;
                                    }
                                    this.lineStart = i5;
                                    i = i6 + 1;
                                    i5 = i;
                                    break;
                                }
                                this.lineStart = i5;
                                i = i6 + 1;
                                i5 = i;
                                break;
                            }
                            this.lineSize++;
                        }
                        i6++;
                    }
                }
                if (!this.lineTerminated) {
                    if (this.input != null && !this.inputEnd) {
                        int i10 = i3 - i;
                        int i11 = this.nextEscapeIndex;
                        if (i > 0) {
                            if (i10 > 0) {
                                System.arraycopy(bArr, i, bArr, 0, i10);
                                this.nextEscapeIndex = i11 >= i ? i11 - i : ESCAPE_INDEX_NOT_SET;
                            }
                            this.lineStart = 0;
                            this.quote = false;
                            i = 0;
                            i5 = 0;
                            i3 = i10;
                        }
                        int i12 = this.input.read(bArr, i3, bArr.length - i3);
                        if (i12 == -1) {
                            this.inputEnd = true;
                            if (i == i3) {
                                this.off = i;
                                return false;
                            }
                        } else {
                            i3 += i12;
                            this.end = i3;
                            i4++;
                        }
                    }
                    this.lineStart = i5;
                    this.lineEnd = i3;
                    this.rowCount++;
                    this.lineSize = 0;
                    i = i3;
                    break;
                }
                break;
            }
            this.off = i;
            return true;
        }
        this.lineTerminated = i == i3;
        this.off = i;
        return true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.input;
        if (inputStream != null) {
            IOUtils.close(inputStream);
        }
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public boolean isEnd() {
        return this.inputEnd;
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public void readAll() {
        ByteArrayValueConsumer byteArrayValueConsumer = this.valueConsumer;
        if (byteArrayValueConsumer == null) {
            throw new JSONException("unsupported operation, consumer is null");
        }
        readAll(byteArrayValueConsumer, Integer.MAX_VALUE);
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public void readLineObjectAll(boolean z, Consumer<T> consumer) {
        Class<T> cls;
        if (z) {
            readHeader();
        }
        int i = 0;
        if (this.fieldReaders != null) {
            ObjectReaderProvider defaultObjectReaderProvider = JSONFactory.getDefaultObjectReaderProvider();
            if (this.fieldReaders == null && (cls = this.objectClass) != null) {
                this.fieldReaders = ((ObjectReaderAdapter) defaultObjectReaderProvider.getObjectReader(cls)).getFieldReaders();
                this.objectCreator = defaultObjectReaderProvider.createObjectCreator(this.objectClass, this.features);
            }
            String[] strArr = new String[this.fieldReaders.length + 1];
            strArr[0] = this.objectClass.getName();
            while (true) {
                FieldReader[] fieldReaderArr = this.fieldReaders;
                if (i >= fieldReaderArr.length) {
                    break;
                }
                int i2 = i + 1;
                strArr[i2] = fieldReaderArr[i].fieldName;
                i = i2;
            }
            long jHashCode64 = Fnv.hashCode64(strArr);
            Map<Long, Function<Consumer, ByteArrayValueConsumer>> map = valueConsumerCreators;
            Function<Consumer, ByteArrayValueConsumer> functionCreateValueConsumerCreator = map.get(Long.valueOf(jHashCode64));
            if (functionCreateValueConsumerCreator == null && (functionCreateValueConsumerCreator = defaultObjectReaderProvider.createValueConsumerCreator(this.objectClass, this.fieldReaders)) != null) {
                map.putIfAbsent(Long.valueOf(jHashCode64), functionCreateValueConsumerCreator);
            }
            ByteArrayValueConsumer byteArrayValueConsumerApply = functionCreateValueConsumerCreator != null ? functionCreateValueConsumerCreator.apply(consumer) : null;
            if (byteArrayValueConsumerApply == null) {
                byteArrayValueConsumerApply = new ByteArrayConsumerImpl(consumer);
            }
            readAll(byteArrayValueConsumerApply, Integer.MAX_VALUE);
            return;
        }
        while (true) {
            Object[] lineValues = readLineValues(false);
            if (lineValues == null) {
                return;
            } else {
                consumer.accept(lineValues);
            }
        }
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public Object[] readLineValues(boolean z) {
        try {
            if (this.inputEnd && this.off == this.end) {
                return null;
            }
            if ((this.input == null && this.off >= this.end) || !seekLine()) {
                return null;
            }
            int i = this.nextEscapeIndex;
            return (i == -1 || i >= this.lineEnd) ? readLineValue(z) : readLineValueEscaped(z);
        } catch (IOException e) {
            throw new JSONException("seekLine error", e);
        }
    }

    public Object readValue(byte[] bArr, int i, int i2, Type type) {
        if (i2 == 0) {
            return null;
        }
        return type == Integer.class ? Integer.valueOf(TypeUtils.parseInt(bArr, i, i2)) : type == Long.class ? Long.valueOf(TypeUtils.parseLong(bArr, i, i2)) : type == BigDecimal.class ? TypeUtils.parseBigDecimal(bArr, i, i2) : type == Float.class ? Float.valueOf(TypeUtils.parseFloat(bArr, i, i2)) : type == Double.class ? Double.valueOf(TypeUtils.parseDouble(bArr, i, i2)) : type == Date.class ? new Date(DateUtils.parseMillis(bArr, i, i2, this.charset, DateUtils.DEFAULT_ZONE_ID)) : type == Boolean.class ? TypeUtils.parseBoolean(bArr, i, i2) : TypeUtils.cast(new String(bArr, i, i2, this.charset), type);
    }

    /* JADX WARN: Found duplicated region for block: B:41:0x0076  */
    @Override // com.alibaba.fastjson2.stream.StreamReader
    public boolean seekLine() throws IOException {
        int i;
        byte[] buf = getBuf();
        int i2 = this.off;
        int i3 = this.end;
        int iIndexOfDoubleQuote = this.nextEscapeIndex;
        if (iIndexOfDoubleQuote == ESCAPE_INDEX_NOT_SET || (iIndexOfDoubleQuote != -1 && iIndexOfDoubleQuote < i2)) {
            iIndexOfDoubleQuote = IOUtils.indexOfDoubleQuote(buf, i2, i3);
            this.nextEscapeIndex = iIndexOfDoubleQuote;
        }
        int iIndexOfLineSeparator = IOUtils.indexOfLineSeparator(buf, i2, i3);
        if (iIndexOfLineSeparator == -1) {
            if (this.input != null && !this.inputEnd) {
                int i4 = i3 - i2;
                if (i4 > 0) {
                    System.arraycopy(buf, i2, buf, 0, i4);
                }
                int i5 = i4;
                while (i5 < buf.length) {
                    int i6 = this.input.read(buf, i5, buf.length - i5);
                    if (i6 == -1) {
                        this.inputEnd = true;
                        break;
                    }
                    i5 += i6;
                }
                this.nextEscapeIndex = iIndexOfDoubleQuote >= i2 ? iIndexOfDoubleQuote - i2 : IOUtils.indexOfDoubleQuote(buf, i4, i5);
                int iIndexOfLineSeparator2 = IOUtils.indexOfLineSeparator(buf, i4, i5);
                this.off = 0;
                this.end = i5;
                i3 = i5;
                iIndexOfLineSeparator = iIndexOfLineSeparator2;
                i2 = 0;
            }
            if (iIndexOfLineSeparator == -1 && this.inputEnd) {
                if (i2 >= i3) {
                    return false;
                }
                iIndexOfLineSeparator = i3;
            }
        }
        if (iIndexOfLineSeparator == -1 || (iIndexOfDoubleQuote != -1 && iIndexOfDoubleQuote <= iIndexOfLineSeparator)) {
            return seekLine0(buf, i2, i3);
        }
        this.lineTerminated = true;
        this.lineStart = i2;
        if (iIndexOfLineSeparator != i2) {
            i = iIndexOfLineSeparator - 1;
            if (buf[i] != 13) {
                i = iIndexOfLineSeparator;
            }
        } else {
            i = iIndexOfLineSeparator;
        }
        this.lineEnd = i;
        this.off = iIndexOfLineSeparator + 1;
        return true;
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public void statAll() {
        readAll(new b(this, 1), Integer.MAX_VALUE);
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public void statAll(int i) {
        readAll(new b(this, 0), i);
    }

    @Override // com.alibaba.fastjson2.support.csv.CSVReader
    public void readAll(int i) {
        ByteArrayValueConsumer byteArrayValueConsumer = this.valueConsumer;
        if (byteArrayValueConsumer != null) {
            readAll(byteArrayValueConsumer, i);
            return;
        }
        throw new JSONException("unsupported operation, consumer is null");
    }

    public CSVReaderUTF8(byte[] bArr, int i, int i2, Charset charset, Class<T> cls) {
        super(cls);
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        Charset charset2 = StandardCharsets.UTF_8;
        this.buf = bArr;
        this.off = i;
        this.end = i + i2;
        this.charset = charset;
    }

    private void readAll(ByteArrayValueConsumer byteArrayValueConsumer, int i) {
        byteArrayValueConsumer.start();
        int i2 = 0;
        while (true) {
            if (i2 >= i && i >= 0) {
                break;
            }
            try {
                boolean z = this.inputEnd;
                int i3 = this.off;
                int i4 = this.end;
                if ((z && (i3 == i4)) || ((this.input == null && i3 >= i4) || !seekLine())) {
                    break;
                    break;
                    break;
                }
                byteArrayValueConsumer.beforeRow(this.rowCount);
                int i5 = this.nextEscapeIndex;
                if (i5 != -1 && i5 < this.lineEnd) {
                    readLineEscaped(byteArrayValueConsumer);
                } else {
                    readLine(byteArrayValueConsumer);
                }
                byteArrayValueConsumer.afterRow(this.rowCount);
                i2++;
            } catch (IOException e) {
                throw new JSONException("seekLine error", e);
            }
        }
        byteArrayValueConsumer.end();
    }

    public CSVReaderUTF8(byte[] bArr, int i, int i2, Charset charset, ByteArrayValueConsumer byteArrayValueConsumer) {
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        Charset charset2 = StandardCharsets.UTF_8;
        this.valueConsumer = byteArrayValueConsumer;
        this.buf = bArr;
        this.off = i;
        this.end = i + i2;
        this.charset = charset;
    }

    private void readValue(boolean z, int i, int i2, byte[] bArr, int i3, Object[] objArr, List<Object> list) {
        Object str;
        byte b;
        byte b2;
        byte b3;
        Type[] typeArr = this.types;
        Type type = (typeArr == null || i >= typeArr.length) ? null : typeArr[i];
        if (type != null && type != String.class && type != Object.class && !z) {
            try {
                str = readValue(bArr, i3, i2, type);
            } catch (Exception e) {
                str = error(i, e);
            }
        } else if (i2 == 1 && (b3 = bArr[i3]) >= 0) {
            str = TypeUtils.toString((char) b3);
        } else if (i2 == 2 && (b = bArr[i3]) >= 0 && (b2 = bArr[i3 + 1]) >= 0) {
            str = TypeUtils.toString((char) b, (char) b2);
        } else {
            str = new String(bArr, i3, i2, this.charset);
        }
        if (objArr != null) {
            if (i < objArr.length) {
                objArr[i] = str;
                return;
            }
            return;
        }
        list.add(str);
    }

    public CSVReaderUTF8(byte[] bArr, int i, int i2, Type[] typeArr) {
        super(typeArr);
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        this.charset = StandardCharsets.UTF_8;
        this.buf = bArr;
        this.off = i;
        this.end = i + i2;
        this.types = typeArr;
    }

    public CSVReaderUTF8(byte[] bArr, int i, int i2, Class<T> cls) {
        super(cls);
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        this.charset = StandardCharsets.UTF_8;
        this.buf = bArr;
        this.off = i;
        this.end = i + i2;
    }

    public CSVReaderUTF8(InputStream inputStream, Charset charset, Type[] typeArr) {
        super(typeArr);
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        Charset charset2 = StandardCharsets.UTF_8;
        this.charset = charset;
        this.input = inputStream;
    }

    public CSVReaderUTF8(InputStream inputStream, Charset charset, Class<T> cls) {
        super(cls);
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        Charset charset2 = StandardCharsets.UTF_8;
        this.charset = charset;
        this.input = inputStream;
    }

    public CSVReaderUTF8(InputStream inputStream, Charset charset, ByteArrayValueConsumer byteArrayValueConsumer) {
        this.nextEscapeIndex = ESCAPE_INDEX_NOT_SET;
        Charset charset2 = StandardCharsets.UTF_8;
        this.charset = charset;
        this.input = inputStream;
        this.valueConsumer = byteArrayValueConsumer;
    }
}
