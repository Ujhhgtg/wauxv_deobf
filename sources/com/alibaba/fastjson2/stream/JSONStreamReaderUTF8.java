package com.alibaba.fastjson2.stream;

import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONFactory;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReaderAdapter;
import com.alibaba.fastjson2.stream.StreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import net.bytebuddy.jar.asm.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class JSONStreamReaderUTF8<T> extends JSONStreamReader<T> {
    byte[] buf;
    final Charset charset;
    final JSONReader.Context context;
    final InputStream input;

    public JSONStreamReaderUTF8(InputStream inputStream, Charset charset, Type[] typeArr) {
        super(typeArr);
        this.charset = charset;
        this.input = inputStream;
        this.context = JSONFactory.createReadContext();
    }

    @Override // com.alibaba.fastjson2.stream.StreamReader
    public <T> T readLineObject() {
        Type[] typeArr;
        try {
            if (this.inputEnd && this.off >= this.end) {
                return null;
            }
            if ((this.input == null && this.off >= this.end) || !seekLine()) {
                return null;
            }
            byte[] bArr = this.buf;
            int i = this.lineStart;
            JSONReader jSONReaderOf = JSONReader.of(bArr, i, this.lineEnd - i, this.charset, this.context);
            ObjectReaderAdapter objectReaderAdapter = this.objectReader;
            return objectReaderAdapter != null ? objectReaderAdapter.readObject(jSONReaderOf, null, null, this.features) : (!jSONReaderOf.isArray() || (typeArr = this.types) == null || typeArr.length == 0) ? (T) jSONReaderOf.readAny() : (T) jSONReaderOf.readList(typeArr);
        } catch (IOException e) {
            throw new JSONException("seekLine error", e);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Found duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Found duplicated region for block: B:40:0x009a  */
    /* JADX WARN: Found duplicated region for block: B:46:0x00af  */
    /* JADX WARN: Found duplicated region for block: B:50:0x00bf  */
    /* JADX WARN: Found duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Found duplicated region for block: B:54:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:86:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:87:0x009e A[SYNTHETIC] */
    @Override // com.alibaba.fastjson2.stream.StreamReader
    public boolean seekLine() throws IOException {
        int i;
        byte[] bArr;
        byte b;
        int i2;
        InputStream inputStream;
        if (this.buf == null && (inputStream = this.input) != null) {
            byte[] bArr2 = new byte[Opcodes.ASM8];
            this.buf = bArr2;
            int i3 = inputStream.read(bArr2);
            if (i3 == -1) {
                this.inputEnd = true;
                return false;
            }
            this.end = i3;
            if (i3 > 3) {
                byte[] bArr3 = this.buf;
                if (bArr3[0] == -17 && bArr3[1] == -69 && bArr3[2] == -65) {
                    this.off = 3;
                    this.lineNextStart = 3;
                }
            }
        }
        for (int i4 = 0; i4 < 3; i4++) {
            this.lineTerminated = false;
            int i5 = this.off;
            while (true) {
                i = this.end;
                if (i5 >= i) {
                    break;
                }
                if (i5 + 4 < i) {
                    byte[] bArr4 = this.buf;
                    byte b2 = bArr4[i5];
                    byte b3 = bArr4[i5 + 1];
                    byte b4 = bArr4[i5 + 2];
                    int i6 = i5 + 3;
                    byte b5 = bArr4[i6];
                    if (b2 <= 34 || b3 <= 34 || b4 <= 34 || b5 <= 34) {
                        bArr = this.buf;
                        b = bArr[i5];
                        if (b == 10) {
                            if (this.lineSize <= 0 || (this.features & StreamReader.Feature.IgnoreEmptyLine.mask) == 0) {
                                this.rowCount++;
                            }
                            this.lineTerminated = true;
                            this.lineSize = 0;
                            this.lineEnd = i5;
                            this.lineStart = this.lineNextStart;
                            int i7 = i5 + 1;
                            this.off = i7;
                            this.lineNextStart = i7;
                            break;
                        }
                        if (b == 13) {
                            if (this.lineSize <= 0 || (this.features & StreamReader.Feature.IgnoreEmptyLine.mask) == 0) {
                                this.rowCount++;
                            }
                            this.lineTerminated = true;
                            this.lineSize = 0;
                            this.lineEnd = i5;
                            i2 = i5 + 1;
                            if (i2 < i) {
                                break;
                            }
                            if (bArr[i2] == 10) {
                                i5 = i2;
                            }
                            this.lineStart = this.lineNextStart;
                            int i8 = i5 + 1;
                            this.off = i8;
                            this.lineNextStart = i8;
                            break;
                        }
                        this.lineSize++;
                    } else {
                        this.lineSize += 4;
                        i5 = i6;
                    }
                    i5++;
                } else {
                    bArr = this.buf;
                    b = bArr[i5];
                    if (b == 10) {
                        if (this.lineSize <= 0) {
                            this.rowCount++;
                        } else {
                            this.rowCount++;
                        }
                        this.lineTerminated = true;
                        this.lineSize = 0;
                        this.lineEnd = i5;
                        this.lineStart = this.lineNextStart;
                        int i72 = i5 + 1;
                        this.off = i72;
                        this.lineNextStart = i72;
                        break;
                    }
                    if (b == 13) {
                        if (this.lineSize <= 0) {
                            this.rowCount++;
                        } else {
                            this.rowCount++;
                        }
                        this.lineTerminated = true;
                        this.lineSize = 0;
                        this.lineEnd = i5;
                        i2 = i5 + 1;
                        if (i2 < i) {
                            break;
                        }
                        if (bArr[i2] == 10) {
                            i5 = i2;
                        }
                        this.lineStart = this.lineNextStart;
                        int i82 = i5 + 1;
                        this.off = i82;
                        this.lineNextStart = i82;
                        break;
                    }
                    this.lineSize++;
                    i5++;
                }
            }
            if (!this.lineTerminated) {
                if (this.input != null && (!this.inputEnd || this.off < i)) {
                    int i9 = this.off;
                    int i10 = i - i9;
                    if (i9 > 0) {
                        if (i10 > 0) {
                            byte[] bArr5 = this.buf;
                            System.arraycopy(bArr5, i9, bArr5, 0, i10);
                        }
                        this.lineNextStart = 0;
                        this.lineStart = 0;
                        this.off = 0;
                        this.end = i10;
                    }
                    InputStream inputStream2 = this.input;
                    byte[] bArr6 = this.buf;
                    int i11 = this.end;
                    int i12 = inputStream2.read(bArr6, i11, bArr6.length - i11);
                    if (i12 == -1) {
                        this.inputEnd = true;
                        if (this.off == this.end) {
                            return false;
                        }
                    } else {
                        this.end += i12;
                    }
                }
                this.lineStart = this.lineNextStart;
                int i13 = this.end;
                this.lineEnd = i13;
                this.rowCount++;
                this.lineSize = 0;
                this.off = i13;
            }
            this.lineTerminated = this.off == this.end;
            break;
        }
        return true;
    }

    public JSONStreamReaderUTF8(InputStream inputStream, Charset charset, ObjectReaderAdapter objectReaderAdapter) {
        super(objectReaderAdapter);
        this.charset = charset;
        this.input = inputStream;
        this.context = JSONFactory.createReadContext();
    }
}
