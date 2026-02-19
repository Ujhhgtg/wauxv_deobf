package me.hd.wauxv.obf;

import com.android.dx.io.Opcodes;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ProtoReader {
    public final SourceBuffer sourceBuffer;
    public int tag = -1;
    public ProtoWireType protoWireType = ProtoWireType.ENUM_INVALID;
    public boolean isPushed;
    public int pushedTag;

    public ProtoReader(SourceBuffer sourceBufferVar) {
        this.sourceBuffer = sourceBufferVar;
    }

    public static void validateLength(int i) {
        if (i < 0) {
            throw new AnotherIllegalArgumentException(concatVar2Var1(i, "Unexpected negative length: "), null);
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x003b */
    /* JADX WARN: Found duplicated region for block: B:24:0x0040 */
    /*
     * JADX WARN: Found duplicated region for block: B:29:0x0058 A[LOOP:0:
     * B:22:0x003c->B:29:0x0058, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:37:0x004c A[SYNTHETIC] */
    public final int readVarint32(IntEncodingEnum intEncodingVar) {
        int i;
        int iE;
        int iOrdinal = intEncodingVar.ordinal();
        SourceBuffer sourceBufferVar = this.sourceBuffer;
        if (iOrdinal == 0) {
            return (int) sourceBufferVar.g(false);
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return readFixed32();
            }
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        int i2 = sourceBufferVar.b;
        int i3 = sourceBufferVar.a;
        if (i2 == i3) {
            throw new SomeIllegalArgumentException("Unexpected EOF");
        }
        byte[] bArr = sourceBufferVar.c;
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 >= 0) {
            sourceBufferVar.b = i4;
        } else {
            if (i3 - i2 <= 1) {
                i = 0;
                for (int i6 = 0; i6 < 32; i6 += 7) {
                    iE = sourceBufferVar.e();
                    i |= (iE & 127) << i6;
                    if ((iE & 128) == 0) {
                        i5 = i;
                    }
                }
                throw new SomeIllegalArgumentException("Input stream is malformed: Varint too long (exceeded 32 bits)");
            }
            int i7 = i2 + 2;
            int i8 = (bArr[i4] << 7) ^ i5;
            if (i8 >= 0) {
                i = 0;
                while (i6 < 32) {
                    iE = sourceBufferVar.e();
                    i |= (iE & 127) << i6;
                    if ((iE & 128) == 0) {
                        i5 = i;
                    }
                }
                throw new SomeIllegalArgumentException("Input stream is malformed: Varint too long (exceeded 32 bits)");
            }
            sourceBufferVar.b = i7;
            i5 = i8 ^ (-128);
        }
        return ((((i5 << 31) >> 31) ^ i5) >> 1) ^ (Integer.MIN_VALUE & i5);
    }

    public final long readVarint64(IntEncodingEnum intEncodingVar) {
        int iOrdinal = intEncodingVar.ordinal();
        SourceBuffer sourceBufferVar = this.sourceBuffer;
        if (iOrdinal == 0) {
            return sourceBufferVar.g(false);
        }
        if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return readFixed64();
            }
            throw new QueryDidNotReturnUniqueResultRuntimeException();
        }
        long jG = sourceBufferVar.g(false);
        return (jG & Long.MIN_VALUE) ^ ((((jG << 63) >> 63) ^ jG) >> 1);
    }

    public final SourceBuffer beginMessage() {
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_LENGTH_DELIMITED;
        if (this.protoWireType == protoWireTypeVar) {
            return readBytesAsBuffer();
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final SourceBuffer readBytesAsBuffer() {
        int iG = readVarint32(IntEncodingEnum.DEFAULT);
        validateLength(iG);
        SourceBuffer sourceBufferVar = this.sourceBuffer;
        sourceBufferVar.d(iG);
        SourceBuffer sourceBufferVar2 = new SourceBuffer(sourceBufferVar.c, sourceBufferVar.b + iG);
        sourceBufferVar2.b = sourceBufferVar.b;
        sourceBufferVar.b += iG;
        return sourceBufferVar2;
    }

    public final byte[] readBytes() {
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_LENGTH_DELIMITED;
        if (this.protoWireType == protoWireTypeVar) {
            return readRawBytes();
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final byte[] readRawBytes() {
        int iG = readVarint32(IntEncodingEnum.DEFAULT);
        validateLength(iG);
        SourceBuffer sourceBufferVar = this.sourceBuffer;
        sourceBufferVar.d(iG);
        byte[] bArr = new byte[iG];
        int i = sourceBufferVar.a;
        int i2 = sourceBufferVar.b;
        int i3 = i - i2;
        if (i3 < iG) {
            iG = i3;
        }
        SomeStaticHelpers._ak(sourceBufferVar.c, 0, i2, bArr, i2 + iG);
        sourceBufferVar.b += iG;
        return bArr;
    }

    public final double m() {
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_FIXED64;
        if (this.protoWireType == protoWireTypeVar) {
            return Double.longBitsToDouble(readFixed64());
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final float n() {
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_FIXED32;
        if (this.protoWireType == protoWireTypeVar) {
            return Float.intBitsToFloat(readFixed32());
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final int o(IntEncodingEnum intEncodingVar) {
        ProtoWireType protoWireTypeVar = intEncodingVar == IntEncodingEnum.FIXED ? ProtoWireType.ENUM_FIXED32 : ProtoWireType.ENUM_VARINT;
        if (this.protoWireType == protoWireTypeVar) {
            return readVarint32(intEncodingVar);
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final int readFixed32() {
        int iE = 0;
        for (int i = 0; i < 4; i++) {
            iE |= (this.sourceBuffer.e() & Opcodes.CONST_METHOD_TYPE) << (i * 8);
        }
        return iE;
    }

    public final long q(IntEncodingEnum intEncodingVar) {
        ProtoWireType protoWireTypeVar = intEncodingVar == IntEncodingEnum.FIXED ? ProtoWireType.ENUM_FIXED64 : ProtoWireType.ENUM_VARINT;
        if (this.protoWireType == protoWireTypeVar) {
            return readVarint64(intEncodingVar);
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final long readFixed64() {
        long jE = 0;
        for (int i = 0; i < 8; i++) {
            jE |= ((long) (this.sourceBuffer.e() & Opcodes.CONST_METHOD_TYPE)) << (i * 8);
        }
        return jE;
    }

    public final String readString() {
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_LENGTH_DELIMITED;
        if (this.protoWireType == protoWireTypeVar) {
            int iG = readVarint32(IntEncodingEnum.DEFAULT);
            validateLength(iG);
            return this.sourceBuffer.f(iG);
        }
        throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
    }

    public final int nextField() {
        if (!this.isPushed) {
            this.pushedTag = (this.tag << 3) | this.protoWireType.value;
            return decodeTag((int) this.sourceBuffer.g(true));
        }
        this.isPushed = false;
        int i = (this.tag << 3) | this.protoWireType.value;
        int iV = decodeTag(this.pushedTag);
        this.pushedTag = i;
        return iV;
    }

    public final void skipField() {
        int iOrdinal = this.protoWireType.ordinal();
        IntEncodingEnum intEncodingVar = IntEncodingEnum.DEFAULT;
        if (iOrdinal == 1) {
            o(intEncodingVar);
            return;
        }
        IntEncodingEnum intEncodingVar2 = IntEncodingEnum.FIXED;
        if (iOrdinal == 2) {
            q(intEncodingVar2);
            return;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4) {
                o(intEncodingVar2);
                return;
            } else {
                throw new AnotherIllegalArgumentException("Unsupported start group or end group wire type: " + this.protoWireType, null);
            }
        }
        ProtoWireType protoWireTypeVar = ProtoWireType.ENUM_LENGTH_DELIMITED;
        if (this.protoWireType != protoWireTypeVar) {
            throw new AnotherIllegalArgumentException("Expected wire type " + protoWireTypeVar + ", but found " + this.protoWireType, null);
        }
        int iG = readVarint32(intEncodingVar);
        validateLength(iG);
        SourceBuffer sourceBufferVar = this.sourceBuffer;
        sourceBufferVar.d(iG);
        sourceBufferVar.b += iG;
    }

    public final int decodeTag(int i) {
        if (i == -1) {
            this.tag = -1;
            this.protoWireType = ProtoWireType.ENUM_INVALID;
            return -1;
        }
        this.tag = i >>> 3;
        ProtoWireType.function.getClass();
        this.protoWireType = ProtoWireType.b[i & 7];
        return this.tag;
    }
}
