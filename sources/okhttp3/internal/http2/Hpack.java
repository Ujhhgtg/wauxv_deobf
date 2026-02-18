package okhttp3.internal.http2;

import com.android.dx.io.Opcodes;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.obf.aaz;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.la;
import me.hd.wauxv.obf.rh;
import me.hd.wauxv.obf.rm;
import me.hd.wauxv.obf.sj;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<sj, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Reader {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final rm source;

        /*
         * JADX WARN: 'this' call moved to the top of the method (can break code
         * semantics)
         */
        public Reader(dlc dlcVar, int i) {
            this(dlcVar, i, 0, 4, null);
            throwIfVar1IsNull(dlcVar, "source");
        }

        private final void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            la.l(headerArr, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i) {
            return this.nextHeaderIndex + 1 + i;
        }

        private final int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    throwIfVar1IsNull(header);
                    int i4 = header.hpackSize;
                    i -= i4;
                    this.dynamicTableByteCount -= i4;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.headerCount);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private final sj getName(int i) throws IOException {
            if (isStaticHeader(i)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    Header header = headerArr[iDynamicTableIndex];
                    throwIfVar1IsNull(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private final void insertIntoDynamicTable(int i, Header header) {
            this.headerList.add(header);
            int i2 = header.hpackSize;
            if (i != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i)];
                throwIfVar1IsNull(header2);
                i2 -= header2.hpackSize;
            }
            int i3 = this.maxDynamicTableByteCount;
            if (i2 > i3) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i2) - i3);
            if (i == -1) {
                int i4 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i4 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i5 = this.nextHeaderIndex;
                this.nextHeaderIndex = i5 - 1;
                this.dynamicTable[i5] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[dynamicTableIndex(i) + iEvictToRecoverBytes + i] = header;
            }
            this.dynamicTableByteCount += i2;
        }

        private final boolean isStaticHeader(int i) {
            return i >= 0 && i <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() {
            return Util.and(this.source.readByte(), Opcodes.CONST_METHOD_TYPE);
        }

        private final void readIndexedHeader(int i) throws IOException {
            if (isStaticHeader(i)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[iDynamicTableIndex];
                    throwIfVar1IsNull(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i) {
            insertIntoDynamicTable(-1, new Header(getName(i), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i) throws IOException {
            this.headerList.add(new Header(getName(i), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> listZ = aaz.z(this.headerList);
            this.headerList.clear();
            return listZ;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final sj readByteString() {
            int i = readByte();
            boolean z = (i & 128) == 128;
            long j = readInt(i, 127);
            if (!z) {
                return this.source.e(j);
            }
            rh rhVar = new rh();
            Huffman.INSTANCE.decode(this.source, j, rhVar);
            return rhVar.e(rhVar.b);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.i()) {
                int iAnd = Util.and(this.source.readByte(), Opcodes.CONST_METHOD_TYPE);
                if (iAnd == 128) {
                    throw new IOException("index == 0");
                }
                if ((iAnd & 128) == 128) {
                    readIndexedHeader(readInt(iAnd, 127) - 1);
                } else if (iAnd == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iAnd & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iAnd, 63) - 1);
                } else if ((iAnd & 32) == 32) {
                    int i = readInt(iAnd, 31);
                    this.maxDynamicTableByteCount = i;
                    if (i < 0 || i > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (iAnd == 16 || iAnd == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iAnd, 15) - 1);
                }
            }
        }

        public final int readInt(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = readByte();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        public Reader(dlc dlcVar, int i, int i2) {
            throwIfVar1IsNull(dlcVar, "source");
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.headerList = new ArrayList();
            this.source = emc.ah(dlcVar);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = 7;
        }

        public /* synthetic */ Reader(dlc dlcVar, int i, int i2, int i3, akd akdVar) {
            this(dlcVar, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static final class Writer {
        public Header[] dynamicTable;
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        public int headerCount;
        public int headerTableSizeSetting;
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final rh out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        /*
         * JADX WARN: 'this' call moved to the top of the method (can break code
         * semantics)
         */
        public Writer(int i, rh rhVar) {
            this(i, false, rhVar, 2, null);
            throwIfVar1IsNull(rhVar, "out");
        }

        private final void adjustDynamicTableByteCount() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i2 - i);
                }
            }
        }

        private final void clearDynamicTable() {
            Header[] headerArr = this.dynamicTable;
            la.l(headerArr, 0, headerArr.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i2 = this.nextHeaderIndex;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    throwIfVar1IsNull(header);
                    i -= header.hpackSize;
                    int i4 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    throwIfVar1IsNull(header2);
                    this.dynamicTableByteCount = i4 - header2.hpackSize;
                    this.headerCount--;
                    i3++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i2 + 1, headerArr, i2 + 1 + i3, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i5 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.nextHeaderIndex += i3;
            }
            return i3;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i = header.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i3 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void resizeHeaderTable(int i) {
            this.headerTableSizeSetting = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.maxDynamicTableByteCount;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(sj sjVar) throws EOFException {
            throwIfVar1IsNull(sjVar, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(sjVar) < sjVar.g()) {
                    rh rhVar = new rh();
                    huffman.encode(sjVar, rhVar);
                    sj sjVarE = rhVar.e(rhVar.b);
                    writeInt(sjVarE.g(), 127, 128);
                    this.out.al(sjVarE);
                    return;
                }
            }
            writeInt(sjVar.g(), 127, 0);
            this.out.al(sjVar);
        }

        /* JADX WARN: Found duplicated region for block: B:22:0x0077 */
        public final void writeHeaders(List<Header> list) throws EOFException {
            int length;
            int length2;
            throwIfVar1IsNull(list, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i = this.smallestHeaderTableSizeSetting;
                if (i < this.maxDynamicTableByteCount) {
                    writeInt(i, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Header header = list.get(i2);
                sj sjVarM = header.name.m();
                sj sjVar = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(sjVarM);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else if (nullSafeIsEqual(hpack.getSTATIC_HEADER_TABLE()[iIntValue].value, sjVar)) {
                        length = length2;
                    } else if (nullSafeIsEqual(hpack.getSTATIC_HEADER_TABLE()[length2].value, sjVar)) {
                        length = length2;
                        length2 = iIntValue + 2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.dynamicTable.length;
                    for (int i3 = this.nextHeaderIndex + 1; i3 < length3; i3++) {
                        Header header2 = this.dynamicTable[i3];
                        throwIfVar1IsNull(header2);
                        if (nullSafeIsEqual(header2.name, sjVarM)) {
                            Header header3 = this.dynamicTable[i3];
                            throwIfVar1IsNull(header3);
                            if (nullSafeIsEqual(header3.value, sjVar)) {
                                length2 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i3 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.am(64);
                    writeByteString(sjVarM);
                    writeByteString(sjVar);
                    insertIntoDynamicTable(header);
                } else {
                    sj sjVar2 = Header.PSEUDO_PREFIX;
                    sjVarM.getClass();
                    throwIfVar1IsNull(sjVar2, "prefix");
                    if (!sjVarM.k(sjVar2, sjVar2.g()) || nullSafeIsEqual(Header.TARGET_AUTHORITY, sjVarM)) {
                        writeInt(length, 63, 64);
                        writeByteString(sjVar);
                        insertIntoDynamicTable(header);
                    } else {
                        writeInt(length, 15, 0);
                        writeByteString(sjVar);
                    }
                }
            }
        }

        public final void writeInt(int i, int i2, int i3) {
            if (i < i2) {
                this.out.am(i | i3);
                return;
            }
            this.out.am(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.out.am(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.out.am(i4);
        }

        /*
         * JADX WARN: 'this' call moved to the top of the method (can break code
         * semantics)
         */
        public Writer(rh rhVar) {
            this(0, false, rhVar, 3, null);
            throwIfVar1IsNull(rhVar, "out");
        }

        public Writer(int i, boolean z, rh rhVar) {
            throwIfVar1IsNull(rhVar, "out");
            this.headerTableSizeSetting = i;
            this.useCompression = z;
            this.out = rhVar;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i, boolean z, rh rhVar, int i2, akd akdVar) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, rhVar);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        sj sjVar = Header.TARGET_METHOD;
        Header header2 = new Header(sjVar, "GET");
        Header header3 = new Header(sjVar, "POST");
        sj sjVar2 = Header.TARGET_PATH;
        Header header4 = new Header(sjVar2, "/");
        Header header5 = new Header(sjVar2, "/index.html");
        sj sjVar3 = Header.TARGET_SCHEME;
        Header header6 = new Header(sjVar3, "http");
        Header header7 = new Header(sjVar3, "https");
        sj sjVar4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[] { header, header2, header3, header4, header5, header6, header7,
                new Header(sjVar4, "200"), new Header(sjVar4, "204"), new Header(sjVar4, "206"),
                new Header(sjVar4, "304"), new Header(sjVar4, "400"), new Header(sjVar4, "404"),
                new Header(sjVar4, "500"), new Header("accept-charset", ""),
                new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""),
                new Header("accept-ranges", ""), new Header("accept", ""),
                new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""),
                new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""),
                new Header("content-encoding", ""), new Header("content-language", ""),
                new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""),
                new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""),
                new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""),
                new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""),
                new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""),
                new Header("last-modified", ""), new Header("link", ""), new Header("location", ""),
                new Header("max-forwards", ""), new Header("proxy-authenticate", ""),
                new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""),
                new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""),
                new Header("set-cookie", ""), new Header("strict-transport-security", ""),
                new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""),
                new Header("via", ""), new Header("www-authenticate", "") };
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<sj, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i = 0; i < length; i++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i].name)) {
                linkedHashMap.put(headerArr2[i].name, Integer.valueOf(i));
            }
        }
        Map<sj, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        throwIfVar1IsNull(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final sj checkLowercase(sj sjVar) throws IOException {
        throwIfVar1IsNull(sjVar, "name");
        int iG = sjVar.g();
        for (int i = 0; i < iG; i++) {
            byte bJ = sjVar.j(i);
            if (65 <= bJ && bJ < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: ".concat(sjVar.n()));
            }
        }
        return sjVar;
    }

    public final Map<sj, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
