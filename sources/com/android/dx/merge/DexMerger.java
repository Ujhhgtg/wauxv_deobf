package com.android.dx.merge;

import com.android.dx.command.dexer.DxContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.Adler32;
import me.hd.wauxv.obf.aad;
import me.hd.wauxv.obf.aae;
import me.hd.wauxv.obf.aag;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.amh;
import me.hd.wauxv.obf.amj;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.amo;
import me.hd.wauxv.obf.amp;
import me.hd.wauxv.obf.avr;
import me.hd.wauxv.obf.avs;
import me.hd.wauxv.obf.azh;
import me.hd.wauxv.obf.ResourcesCompat;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.cdh;
import me.hd.wauxv.obf.cdi;
import me.hd.wauxv.obf.cwe;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.dpr;
import me.hd.wauxv.obf.dps;
import me.hd.wauxv.obf.emd;
import me.hd.wauxv.obf.StaticAndroidHelpers;
import me.hd.wauxv.obf.fg;
import me.hd.wauxv.obf.su;
import me.hd.wauxv.obf.ys;
import me.hd.wauxv.obf.yt;
import me.hd.wauxv.obf.yv;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class DexMerger {
    private static final byte DBG_ADVANCE_LINE = 2;
    private static final byte DBG_ADVANCE_PC = 1;
    private static final byte DBG_END_LOCAL = 5;
    private static final byte DBG_END_SEQUENCE = 0;
    private static final byte DBG_RESTART_LOCAL = 6;
    private static final byte DBG_SET_EPILOGUE_BEGIN = 8;
    private static final byte DBG_SET_FILE = 9;
    private static final byte DBG_SET_PROLOGUE_END = 7;
    private static final byte DBG_START_LOCAL = 3;
    private static final byte DBG_START_LOCAL_EXTENDED = 4;
    private final amj annotationOut;
    private final amj annotationSetOut;
    private final amj annotationSetRefListOut;
    private final amj annotationsDirectoryOut;
    private final amj classDataOut;
    private final amj codeOut;
    private final CollisionPolicy collisionPolicy;
    private int compactWasteThreshold;
    private final dps contentsOut;
    private final DxContext context;
    private final amj debugInfoOut;
    private final amk dexOut;
    private final amk[] dexes;
    private final amj encodedArrayOut;
    private final amj headerOut;
    private final amj idsDefsOut;
    private final IndexMap[] indexMaps;
    private final InstructionTransformer instructionTransformer;
    private final amj mapListOut;
    private final amj stringDataOut;
    private final amj typeListOut;
    private final WriterSizes writerSizes;

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public abstract class IdMerger<T extends Comparable<T>> {
        private final amj out;

        /*
         * JADX INFO: compiled from:
         * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
         */
        public class UnsortedValue implements Comparable<IdMerger<T>.UnsortedValue> {
            final int index;
            final IndexMap indexMap;
            final int offset;
            final amk source;
            final T value;

            public UnsortedValue(amk amkVar, IndexMap indexMap, T t, int i, int i2) {
                this.source = amkVar;
                this.indexMap = indexMap;
                this.value = t;
                this.index = i;
                this.offset = i2;
            }

            @Override // java.lang.Comparable
            public int compareTo(IdMerger<T>.UnsortedValue unsortedValue) {
                return this.value.compareTo(unsortedValue.value);
            }
        }

        public IdMerger(amj amjVar) {
            this.out = amjVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int readIntoMap(amj amjVar, dpr dprVar, IndexMap indexMap, int i, TreeMap<T, List<Integer>> treeMap,
                int i2) {
            int iPosition = amjVar != null ? amjVar.b.position() : -1;
            if (i < dprVar.b) {
                Comparable comparable = read(amjVar, indexMap, i);
                List arrayList = (List) treeMap.get(comparable);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    treeMap.put(comparable, arrayList);
                }
                arrayList.add(Integer.valueOf(i2));
            }
            return iPosition;
        }

        private List<IdMerger<T>.UnsortedValue> readUnsortedValues(amk amkVar, IndexMap indexMap) {
            dpr section = getSection(amkVar.c);
            if (!section.e()) {
                return Collections.EMPTY_LIST;
            }
            ArrayList arrayList = new ArrayList();
            amj amjVarN = amkVar.n(section.c);
            for (int i = 0; i < section.b; i++) {
                arrayList.add(new UnsortedValue(amkVar, indexMap, read(amjVarN, indexMap, 0), i, amjVarN.b.position()));
            }
            return arrayList;
        }

        public abstract dpr getSection(dps dpsVar);

        public final void mergeSorted() {
            dpr[] dprVarArr = new dpr[DexMerger.this.dexes.length];
            amj[] amjVarArr = new amj[DexMerger.this.dexes.length];
            int[] iArr = new int[DexMerger.this.dexes.length];
            int[] iArr2 = new int[DexMerger.this.dexes.length];
            TreeMap<T, List<Integer>> treeMap = new TreeMap<>();
            int i = 0;
            for (int i2 = 0; i2 < DexMerger.this.dexes.length; i2++) {
                dpr section = getSection(DexMerger.this.dexes[i2].c);
                dprVarArr[i2] = section;
                amj amjVarN = section.e() ? DexMerger.this.dexes[i2].n(dprVarArr[i2].c) : null;
                amjVarArr[i2] = amjVarN;
                iArr[i2] = readIntoMap(amjVarN, dprVarArr[i2], DexMerger.this.indexMaps[i2], iArr2[i2], treeMap, i2);
            }
            if (treeMap.isEmpty()) {
                getSection(DexMerger.this.contentsOut).c = 0;
                getSection(DexMerger.this.contentsOut).b = 0;
                return;
            }
            getSection(DexMerger.this.contentsOut).c = this.out.b.position();
            while (!treeMap.isEmpty()) {
                Map.Entry<T, List<Integer>> entryPollFirstEntry = treeMap.pollFirstEntry();
                for (Integer num : entryPollFirstEntry.getValue()) {
                    int i3 = iArr[num.intValue()];
                    IndexMap indexMap = DexMerger.this.indexMaps[num.intValue()];
                    int iIntValue = num.intValue();
                    int i4 = iArr2[iIntValue];
                    iArr2[iIntValue] = i4 + 1;
                    updateIndex(i3, indexMap, i4, i);
                    iArr[num.intValue()] = readIntoMap(amjVarArr[num.intValue()], dprVarArr[num.intValue()],
                            DexMerger.this.indexMaps[num.intValue()], iArr2[num.intValue()], treeMap, num.intValue());
                }
                write(entryPollFirstEntry.getKey());
                i++;
            }
            getSection(DexMerger.this.contentsOut).b = i;
        }

        public final void mergeUnsorted() {
            int i;
            getSection(DexMerger.this.contentsOut).c = this.out.b.position();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < DexMerger.this.dexes.length; i2++) {
                arrayList.addAll(readUnsortedValues(DexMerger.this.dexes[i2], DexMerger.this.indexMaps[i2]));
            }
            if (arrayList.isEmpty()) {
                getSection(DexMerger.this.contentsOut).c = 0;
                getSection(DexMerger.this.contentsOut).b = 0;
                return;
            }
            Collections.sort(arrayList);
            int i3 = 0;
            for (int i4 = 0; i4 < arrayList.size(); i4 = i) {
                i = i4 + 1;
                UnsortedValue unsortedValue = (UnsortedValue) arrayList.get(i4);
                int i5 = i3 - 1;
                updateIndex(unsortedValue.offset, unsortedValue.indexMap, unsortedValue.index, i5);
                while (i < arrayList.size() && unsortedValue.compareTo((UnsortedValue) arrayList.get(i)) == 0) {
                    int i6 = i + 1;
                    UnsortedValue unsortedValue2 = (UnsortedValue) arrayList.get(i);
                    updateIndex(unsortedValue2.offset, unsortedValue2.indexMap, unsortedValue2.index, i5);
                    i = i6;
                }
                write(unsortedValue.value);
                i3++;
            }
            getSection(DexMerger.this.contentsOut).b = i3;
        }

        public abstract T read(amj amjVar, IndexMap indexMap, int i);

        public abstract void updateIndex(int i, IndexMap indexMap, int i2, int i3);

        public abstract void write(T t);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class WriterSizes {
        private int annotation;
        private int annotationsDirectory;
        private int annotationsSet;
        private int annotationsSetRefList;
        private int classData;
        private int code;
        private int debugInfo;
        private int encodedArray;
        private int header;
        private int idsDefs;
        private int mapList;
        private int stringData;
        private int typeList;

        public WriterSizes(amk[] amkVarArr) {
            this.header = 112;
            for (amk amkVar : amkVarArr) {
                plus(amkVar.c, false);
            }
            fourByteAlign();
        }

        private static int fourByteAlign(int i) {
            return (i + 3) & (-4);
        }

        private void plus(dps dpsVar, boolean z) {
            int i = this.idsDefs;
            dpr dprVar = dpsVar.b;
            dpr dprVar2 = dpsVar.q;
            dpr dprVar3 = dpsVar.r;
            dpr dprVar4 = dpsVar.s;
            dpr dprVar5 = dpsVar.n;
            dpr dprVar6 = dpsVar.o;
            this.idsDefs = bjs.c(dpsVar.g.b, 32,
                    (dpsVar.f.b * 8) + (dpsVar.e.b * 8) + (dpsVar.d.b * 12) + (dpsVar.c.b * 4) + (dprVar.b * 4), i);
            this.mapList = (dpsVar.u.length * 12) + 4;
            this.typeList += fourByteAlign(dpsVar.k.d);
            this.stringData += dpsVar.p.d;
            this.annotationsDirectory += dpsVar.t.d;
            this.annotationsSet += dpsVar.m.d;
            this.annotationsSetRefList += dpsVar.l.d;
            if (z) {
                this.code += dprVar6.d;
                this.classData += dprVar5.d;
                this.encodedArray += dprVar4.d;
                this.annotation += dprVar3.d;
                this.debugInfo += dprVar2.d;
                return;
            }
            this.code += (int) Math.ceil(((double) dprVar6.d) * 1.25d);
            this.classData += (int) Math.ceil(((double) dprVar5.d) * 1.67d);
            this.encodedArray = (dprVar4.d * 2) + this.encodedArray;
            this.annotation += (int) Math.ceil(dprVar3.d * 2);
            this.debugInfo = bjs.c(dprVar2.d, 2, 8, this.debugInfo);
        }

        public int size() {
            return this.header + this.idsDefs + this.mapList + this.typeList + this.classData + this.code
                    + this.stringData + this.debugInfo + this.encodedArray + this.annotationsDirectory
                    + this.annotationsSet + this.annotationsSetRefList + this.annotation;
        }

        private void fourByteAlign() {
            this.header = fourByteAlign(this.header);
            this.idsDefs = fourByteAlign(this.idsDefs);
            this.mapList = fourByteAlign(this.mapList);
            this.typeList = fourByteAlign(this.typeList);
            this.classData = fourByteAlign(this.classData);
            this.code = fourByteAlign(this.code);
            this.stringData = fourByteAlign(this.stringData);
            this.debugInfo = fourByteAlign(this.debugInfo);
            this.encodedArray = fourByteAlign(this.encodedArray);
            this.annotationsDirectory = fourByteAlign(this.annotationsDirectory);
            this.annotationsSet = fourByteAlign(this.annotationsSet);
            this.annotationsSetRefList = fourByteAlign(this.annotationsSetRefList);
            this.annotation = fourByteAlign(this.annotation);
        }

        public WriterSizes(DexMerger dexMerger) {
            this.header = 112;
            this.header = dexMerger.headerOut.j();
            this.idsDefs = dexMerger.idsDefsOut.j();
            this.mapList = dexMerger.mapListOut.j();
            this.typeList = dexMerger.typeListOut.j();
            this.classData = dexMerger.classDataOut.j();
            this.code = dexMerger.codeOut.j();
            this.stringData = dexMerger.stringDataOut.j();
            this.debugInfo = dexMerger.debugInfoOut.j();
            this.encodedArray = dexMerger.encodedArrayOut.j();
            this.annotationsDirectory = dexMerger.annotationsDirectoryOut.j();
            this.annotationsSet = dexMerger.annotationSetOut.j();
            this.annotationsSetRefList = dexMerger.annotationSetRefListOut.j();
            this.annotation = dexMerger.annotationOut.j();
            fourByteAlign();
        }
    }

    public DexMerger(amk[] amkVarArr, CollisionPolicy collisionPolicy, DxContext dxContext) {
        this(amkVarArr, collisionPolicy, dxContext, new WriterSizes(amkVarArr));
    }

    private SortableType[] getSortedTypes() {
        boolean zTryAssignDepth;
        int i = this.contentsOut.c.b;
        SortableType[] sortableTypeArr = new SortableType[i];
        int i2 = 0;
        while (true) {
            amk[] amkVarArr = this.dexes;
            if (i2 >= amkVarArr.length) {
                break;
            }
            readSortableTypes(sortableTypeArr, amkVarArr[i2], this.indexMaps[i2]);
            i2++;
        }
        do {
            zTryAssignDepth = true;
            for (int i3 = 0; i3 < i; i3++) {
                SortableType sortableType = sortableTypeArr[i3];
                if (sortableType != null && !sortableType.isDepthAssigned()) {
                    zTryAssignDepth &= sortableType.tryAssignDepth(sortableTypeArr);
                }
            }
        } while (!zTryAssignDepth);
        Arrays.sort(sortableTypeArr, SortableType.NULLS_LAST_ORDER);
        int iIndexOf = Arrays.asList(sortableTypeArr).indexOf(null);
        return iIndexOf != -1 ? (SortableType[]) Arrays.copyOfRange(sortableTypeArr, 0, iIndexOf) : sortableTypeArr;
    }

    public static void main(String[] strArr) throws IOException {
        if (strArr.length < 2) {
            printUsage();
            return;
        }
        amk[] amkVarArr = new amk[strArr.length - 1];
        for (int i = 1; i < strArr.length; i++) {
            amkVarArr[i - 1] = new amk(new File(strArr[i]));
        }
        amk amkVarMerge = new DexMerger(amkVarArr, CollisionPolicy.KEEP_FIRST, new DxContext()).merge();
        File file = new File(strArr[0]);
        amkVarMerge.getClass();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            amkVarMerge.q(fileOutputStream);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private void mergeAnnotations() {
        new IdMerger<fg>(this.annotationOut) { // from class: com.android.dx.merge.DexMerger.9
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.r;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public fg read(amj amjVar, IndexMap indexMap, int i) {
                ByteBuffer byteBuffer = amjVar.b;
                byte b = byteBuffer.get();
                int iPosition = byteBuffer.position();
                new avs(amjVar, 29).k();
                amk amkVar = amjVar.d;
                ByteBuffer byteBuffer2 = amjVar.b;
                byte[] bArr = new byte[byteBuffer2.position() - iPosition];
                byteBuffer2.position(iPosition);
                byteBuffer2.get(bArr);
                return indexMap.adjust(new fg(amkVar, b, new avr(bArr)));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                indexMap.putAnnotationOffset(i, DexMerger.this.annotationOut.b.position());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(fg fgVar) {
                amj amjVar = DexMerger.this.annotationOut;
                amjVar.writeByte(fgVar.b);
                amjVar.write(fgVar.c.a);
            }
        }.mergeUnsorted();
    }

    private int mergeApiLevels() {
        int i = -1;
        int i2 = 0;
        while (true) {
            amk[] amkVarArr = this.dexes;
            if (i2 >= amkVarArr.length) {
                return i;
            }
            int i3 = amkVarArr[i2].c.v;
            if (i < i3) {
                i = i3;
            }
            i2++;
        }
    }

    private void mergeCallSiteIds() {
        new IdMerger<su>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.5
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.h;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public su read(amj amjVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new su(amjVar.d, amjVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                indexMap.callSiteIds[i2] = i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(su suVar) {
                DexMerger.this.idsDefsOut.writeInt(suVar.b);
            }
        }.mergeSorted();
    }

    private void mergeClassDefs() {
        SortableType[] sortedTypes = getSortedTypes();
        this.contentsOut.g.c = this.idsDefsOut.b.position();
        this.contentsOut.g.b = sortedTypes.length;
        for (SortableType sortableType : sortedTypes) {
            transformClassDef(sortableType.getDex(), sortableType.getClassDef(), sortableType.getIndexMap());
        }
    }

    private amk mergeDexes() {
        mergeStringIds();
        mergeTypeIds();
        mergeTypeLists();
        mergeProtoIds();
        mergeFieldIds();
        mergeMethodIds();
        mergeMethodHandles();
        mergeAnnotations();
        unionAnnotationSetsAndDirectories();
        mergeCallSiteIds();
        mergeClassDefs();
        Arrays.sort(this.contentsOut.u);
        dps dpsVar = this.contentsOut;
        dpr dprVar = dpsVar.a;
        dprVar.c = 0;
        dprVar.b = 1;
        dpsVar.y = this.dexOut.b.capacity();
        this.contentsOut.ad();
        dps dpsVar2 = this.contentsOut;
        amj amjVar = this.headerOut;
        int iMergeApiLevels = mergeApiLevels();
        dpsVar2.getClass();
        amjVar.write(StaticAndroidHelpers.z(iMergeApiLevels).getBytes("UTF-8"));
        amjVar.writeInt(dpsVar2.w);
        amjVar.write(dpsVar2.x);
        amjVar.writeInt(dpsVar2.y);
        amjVar.writeInt(112);
        amjVar.writeInt(305419896);
        amjVar.writeInt(dpsVar2.z);
        amjVar.writeInt(dpsVar2.aa);
        amjVar.writeInt(dpsVar2.j.c);
        dpr dprVar2 = dpsVar2.b;
        amjVar.writeInt(dprVar2.b);
        amjVar.writeInt(dprVar2.c);
        dpr dprVar3 = dpsVar2.c;
        amjVar.writeInt(dprVar3.b);
        amjVar.writeInt(dprVar3.c);
        dpr dprVar4 = dpsVar2.d;
        amjVar.writeInt(dprVar4.b);
        amjVar.writeInt(dprVar4.c);
        dpr dprVar5 = dpsVar2.e;
        amjVar.writeInt(dprVar5.b);
        amjVar.writeInt(dprVar5.c);
        dpr dprVar6 = dpsVar2.f;
        amjVar.writeInt(dprVar6.b);
        amjVar.writeInt(dprVar6.c);
        dpr dprVar7 = dpsVar2.g;
        amjVar.writeInt(dprVar7.b);
        amjVar.writeInt(dprVar7.c);
        amjVar.writeInt(dpsVar2.ab);
        amjVar.writeInt(dpsVar2.ac);
        dps dpsVar3 = this.contentsOut;
        amj amjVar2 = this.mapListOut;
        dpr[] dprVarArr = dpsVar3.u;
        int i = 0;
        for (dpr dprVar8 : dprVarArr) {
            if (dprVar8.e()) {
                i++;
            }
        }
        amjVar2.writeInt(i);
        for (dpr dprVar9 : dprVarArr) {
            if (dprVar9.e()) {
                amjVar2.k(dprVar9.a);
                amjVar2.k((short) 0);
                amjVar2.writeInt(dprVar9.b);
                amjVar2.writeInt(dprVar9.c);
            }
        }
        amk amkVar = this.dexOut;
        amj amjVarN = amkVar.n(12);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer byteBufferDuplicate = amkVar.b.duplicate();
            byteBufferDuplicate.limit(byteBufferDuplicate.capacity());
            byteBufferDuplicate.position(32);
            while (byteBufferDuplicate.hasRemaining()) {
                int iMin = Math.min(8192, byteBufferDuplicate.remaining());
                byteBufferDuplicate.get(bArr, 0, iMin);
                messageDigest.update(bArr, 0, iMin);
            }
            amjVarN.write(messageDigest.digest());
            amj amjVarN2 = amkVar.n(8);
            Adler32 adler32 = new Adler32();
            byte[] bArr2 = new byte[8192];
            ByteBuffer byteBufferDuplicate2 = amkVar.b.duplicate();
            byteBufferDuplicate2.limit(byteBufferDuplicate2.capacity());
            byteBufferDuplicate2.position(12);
            while (byteBufferDuplicate2.hasRemaining()) {
                int iMin2 = Math.min(8192, byteBufferDuplicate2.remaining());
                byteBufferDuplicate2.get(bArr2, 0, iMin2);
                adler32.update(bArr2, 0, iMin2);
            }
            amjVarN2.writeInt((int) adler32.getValue());
            return this.dexOut;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private void mergeFieldIds() {
        new IdMerger<azh>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.7
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.e;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public azh read(amj amjVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new azh(amjVar.d, amjVar.i(), amjVar.i(), amjVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                if (i3 < 0 || i3 > 65535) {
                    throw new amp(concatVar2Var1(i3, "field ID not in [0, 0xffff]: "), null);
                }
                indexMap.fieldIds[i2] = (short) i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(azh azhVar) {
                amj amjVar = DexMerger.this.idsDefsOut;
                amjVar.n(azhVar.b);
                amjVar.n(azhVar.c);
                amjVar.writeInt(azhVar.d);
            }
        }.mergeSorted();
    }

    private void mergeMethodHandles() {
        new IdMerger<cdh>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.6
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.i;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public cdh read(amj amjVar, IndexMap indexMap, int i) {
                int i2 = amjVar.i();
                for (int i3 : StaticHelpers6.af(9)) {
                    if (StaticHelpers6.ae(i3) == i2) {
                        return indexMap.adjust(new cdh(amjVar.d, i3, amjVar.i(), amjVar.i(), amjVar.i()));
                    }
                }
                throw new IllegalArgumentException(String.valueOf(i2));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                indexMap.methodHandleIds.put(Integer.valueOf(i2), Integer.valueOf(indexMap.methodHandleIds.size()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(cdh cdhVar) {
                amj amjVar = DexMerger.this.idsDefsOut;
                amjVar.n(StaticHelpers6.ae(cdhVar.b));
                amjVar.n(cdhVar.c);
                amjVar.n(cdhVar.d);
                amjVar.n(cdhVar.e);
            }
        }.mergeUnsorted();
    }

    private void mergeMethodIds() {
        new IdMerger<cdi>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.8
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.f;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public cdi read(amj amjVar, IndexMap indexMap, int i) {
                return indexMap.adjust(new cdi(amjVar.d, amjVar.i(), amjVar.i(), amjVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                if (i3 < 0 || i3 > 65535) {
                    throw new amp(concatVar2Var1(i3, "method ID not in [0, 0xffff]: "), null);
                }
                indexMap.methodIds[i2] = (short) i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(cdi cdiVar) {
                amj amjVar = DexMerger.this.idsDefsOut;
                amjVar.n(cdiVar.b);
                amjVar.n(cdiVar.c);
                amjVar.writeInt(cdiVar.d);
            }
        }.mergeSorted();
    }

    private void mergeProtoIds() {
        new IdMerger<cwe>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.4
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.d;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public cwe read(amj amjVar, IndexMap indexMap, int i) {
                ByteBuffer byteBuffer = amjVar.b;
                return indexMap
                        .adjust(new cwe(amjVar.d, byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                if (i3 < 0 || i3 > 65535) {
                    throw new amp(concatVar2Var1(i3, "proto ID not in [0, 0xffff]: "), null);
                }
                indexMap.protoIds[i2] = (short) i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(cwe cweVar) {
                amj amjVar = DexMerger.this.idsDefsOut;
                amjVar.writeInt(cweVar.b);
                amjVar.writeInt(cweVar.c);
                amjVar.writeInt(cweVar.d);
            }
        }.mergeSorted();
    }

    private void mergeStringIds() {
        new IdMerger<String>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.1
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.b;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                indexMap.stringIds[i2] = i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public String read(amj amjVar, IndexMap indexMap, int i) {
                return amjVar.g();
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(String str) {
                DexMerger.this.contentsOut.p.b++;
                DexMerger.this.idsDefsOut.writeInt(DexMerger.this.stringDataOut.b.position());
                amj amjVar = DexMerger.this.stringDataOut;
                amjVar.getClass();
                try {
                    amjVar.m(str.length());
                    amjVar.write(ResourcesCompat.u(str));
                    amjVar.writeByte(0);
                } catch (UTFDataFormatException unused) {
                    throw new AssertionError();
                }
            }
        }.mergeSorted();
    }

    private void mergeTypeIds() {
        new IdMerger<Integer>(this.idsDefsOut) { // from class: com.android.dx.merge.DexMerger.2
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.c;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public Integer read(amj amjVar, IndexMap indexMap, int i) {
                return Integer.valueOf(indexMap.adjustString(amjVar.b.getInt()));
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                if (i3 < 0 || i3 > 65535) {
                    throw new amp(concatVar2Var1(i3, "type ID not in [0, 0xffff]: "), null);
                }
                indexMap.typeIds[i2] = (short) i3;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(Integer num) {
                DexMerger.this.idsDefsOut.writeInt(num.intValue());
            }
        }.mergeSorted();
    }

    private void mergeTypeLists() {
        new IdMerger<emd>(this.typeListOut) { // from class: com.android.dx.merge.DexMerger.3
            @Override // com.android.dx.merge.DexMerger.IdMerger
            public dpr getSection(dps dpsVar) {
                return dpsVar.k;
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void updateIndex(int i, IndexMap indexMap, int i2, int i3) {
                indexMap.putTypeListOffset(i, DexMerger.this.typeListOut.b.position());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public emd read(amj amjVar, IndexMap indexMap, int i) {
                return indexMap.adjustTypeList(amjVar.h());
            }

            @Override // com.android.dx.merge.DexMerger.IdMerger
            public void write(emd emdVar) {
                amj amjVar = DexMerger.this.typeListOut;
                amjVar.getClass();
                short[] sArr = emdVar.c;
                amjVar.writeInt(sArr.length);
                for (short s : sArr) {
                    amjVar.k(s);
                }
                ByteBuffer byteBuffer = amjVar.b;
                while ((byteBuffer.position() & 3) != 0) {
                    byteBuffer.put((byte) 0);
                }
            }
        }.mergeUnsorted();
    }

    private static void printUsage() {
        System.out.println("Usage: DexMerger <out.dex> <a.dex> <b.dex> ...");
        System.out.println();
        System.out.println("If a class is defined in several dex, the class found in the first dex will be used.");
    }

    private void readSortableTypes(SortableType[] sortableTypeArr, amk amkVar, IndexMap indexMap) {
        amkVar.getClass();
        Iterator it = !amkVar.c.g.e() ? Collections.EMPTY_SET.iterator() : new amh(amkVar);
        while (it.hasNext()) {
            yx yxVar = (yx) it.next();
            SortableType sortableTypeAdjust = indexMap.adjust(new SortableType(amkVar, indexMap, yxVar));
            int typeIndex = sortableTypeAdjust.getTypeIndex();
            if (sortableTypeArr[typeIndex] == null) {
                sortableTypeArr[typeIndex] = sortableTypeAdjust;
            } else if (this.collisionPolicy != CollisionPolicy.KEEP_FIRST) {
                throw new amo("Multiple dex files define ".concat((String) amkVar.g.get(yxVar.c)), null);
            }
        }
    }

    private void transformAnnotationDirectories(amk amkVar, IndexMap indexMap) {
        dpr dprVar = amkVar.c.t;
        if (dprVar.e()) {
            amj amjVarN = amkVar.n(dprVar.c);
            for (int i = 0; i < dprVar.b; i++) {
                transformAnnotationDirectory(amjVarN, indexMap);
            }
        }
    }

    private void transformAnnotationDirectory(amj amjVar, IndexMap indexMap) {
        this.contentsOut.t.b++;
        this.annotationsDirectoryOut.e();
        indexMap.putAnnotationDirectoryOffset(amjVar.b.position(), this.annotationsDirectoryOut.b.position());
        ByteBuffer byteBuffer = amjVar.b;
        this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        int i = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i);
        int i2 = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i2);
        int i3 = byteBuffer.getInt();
        this.annotationsDirectoryOut.writeInt(i3);
        for (int i4 = 0; i4 < i; i4++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustField(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
        for (int i5 = 0; i5 < i2; i5++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
        for (int i6 = 0; i6 < i3; i6++) {
            this.annotationsDirectoryOut.writeInt(indexMap.adjustMethod(byteBuffer.getInt()));
            this.annotationsDirectoryOut.writeInt(indexMap.adjustAnnotationSetRefList(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSet(IndexMap indexMap, amj amjVar) {
        this.contentsOut.m.b++;
        this.annotationSetOut.e();
        indexMap.putAnnotationSetOffset(amjVar.b.position(), this.annotationSetOut.b.position());
        ByteBuffer byteBuffer = amjVar.b;
        int i = byteBuffer.getInt();
        this.annotationSetOut.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.annotationSetOut.writeInt(indexMap.adjustAnnotation(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSetRefList(IndexMap indexMap, amj amjVar) {
        this.contentsOut.l.b++;
        this.annotationSetRefListOut.e();
        indexMap.putAnnotationSetRefListOffset(amjVar.b.position(), this.annotationSetRefListOut.b.position());
        ByteBuffer byteBuffer = amjVar.b;
        int i = byteBuffer.getInt();
        this.annotationSetRefListOut.writeInt(i);
        for (int i2 = 0; i2 < i; i2++) {
            this.annotationSetRefListOut.writeInt(indexMap.adjustAnnotationSet(byteBuffer.getInt()));
        }
    }

    private void transformAnnotationSetRefLists(amk amkVar, IndexMap indexMap) {
        dpr dprVar = amkVar.c.l;
        if (dprVar.e()) {
            amj amjVarN = amkVar.n(dprVar.c);
            for (int i = 0; i < dprVar.b; i++) {
                transformAnnotationSetRefList(indexMap, amjVarN);
            }
        }
    }

    private void transformAnnotationSets(amk amkVar, IndexMap indexMap) {
        dpr dprVar = amkVar.c.m;
        if (dprVar.e()) {
            amj amjVarN = amkVar.n(dprVar.c);
            for (int i = 0; i < dprVar.b; i++) {
                transformAnnotationSet(indexMap, amjVarN);
            }
        }
    }

    private int[] transformCatchHandlers(IndexMap indexMap, aad[] aadVarArr) {
        int iPosition = this.codeOut.b.position();
        this.codeOut.m(aadVarArr.length);
        int[] iArr = new int[aadVarArr.length];
        for (int i = 0; i < aadVarArr.length; i++) {
            iArr[i] = this.codeOut.b.position() - iPosition;
            transformEncodedCatchHandler(aadVarArr[i], indexMap);
        }
        return iArr;
    }

    private void transformClassData(amk amkVar, yv yvVar, IndexMap indexMap) {
        this.contentsOut.n.b++;
        ys[] ysVarArr = yvVar.a;
        ys[] ysVarArr2 = yvVar.b;
        yt[] ytVarArr = yvVar.c;
        yt[] ytVarArr2 = yvVar.d;
        this.classDataOut.m(ysVarArr.length);
        this.classDataOut.m(ysVarArr2.length);
        this.classDataOut.m(ytVarArr.length);
        this.classDataOut.m(ytVarArr2.length);
        transformFields(indexMap, ysVarArr);
        transformFields(indexMap, ysVarArr2);
        transformMethods(amkVar, indexMap, ytVarArr);
        transformMethods(amkVar, indexMap, ytVarArr2);
    }

    private void transformClassDef(amk amkVar, yx yxVar, IndexMap indexMap) {
        this.idsDefsOut.e();
        this.idsDefsOut.writeInt(yxVar.c);
        this.idsDefsOut.writeInt(yxVar.d);
        this.idsDefsOut.writeInt(yxVar.e);
        this.idsDefsOut.writeInt(yxVar.f);
        this.idsDefsOut.writeInt(indexMap.adjustString(yxVar.g));
        this.idsDefsOut.writeInt(indexMap.adjustAnnotationDirectory(yxVar.h));
        if (yxVar.i == 0) {
            this.idsDefsOut.writeInt(0);
        } else {
            this.idsDefsOut.writeInt(this.classDataOut.b.position());
            transformClassData(amkVar, amkVar.o(yxVar), indexMap);
        }
        this.idsDefsOut.writeInt(indexMap.adjustEncodedArray(yxVar.j));
    }

    private void transformCode(amk amkVar, aag aagVar, IndexMap indexMap) {
        this.contentsOut.o.b++;
        this.codeOut.e();
        this.codeOut.n(aagVar.a);
        this.codeOut.n(aagVar.b);
        this.codeOut.n(aagVar.c);
        aae[] aaeVarArr = aagVar.f;
        aad[] aadVarArr = aagVar.g;
        this.codeOut.n(aaeVarArr.length);
        int i = aagVar.d;
        if (i != 0) {
            this.codeOut.writeInt(this.debugInfoOut.b.position());
            transformDebugInfoItem(amkVar.n(i), indexMap);
        } else {
            this.codeOut.writeInt(0);
        }
        short[] sArrTransform = this.instructionTransformer.transform(indexMap, aagVar.e);
        this.codeOut.writeInt(sArrTransform.length);
        amj amjVar = this.codeOut;
        amjVar.getClass();
        for (short s : sArrTransform) {
            amjVar.k(s);
        }
        if (aaeVarArr.length > 0) {
            if (sArrTransform.length % 2 == 1) {
                this.codeOut.k((short) 0);
            }
            amj amjVarN = this.dexOut.n(this.codeOut.b.position());
            amj amjVar2 = this.codeOut;
            int length = aaeVarArr.length * 8;
            if (length < 0) {
                amjVar2.getClass();
                throw new IllegalArgumentException();
            }
            ByteBuffer byteBuffer = amjVar2.b;
            byteBuffer.position(byteBuffer.position() + length);
            transformTries(amjVarN, aaeVarArr, transformCatchHandlers(indexMap, aadVarArr));
        }
    }

    private void transformDebugInfoItem(amj amjVar, IndexMap indexMap) {
        this.contentsOut.q.b++;
        amjVar.getClass();
        this.debugInfoOut.m(ajn.ac(amjVar));
        int iAc = ajn.ac(amjVar);
        this.debugInfoOut.m(iAc);
        for (int i = 0; i < iAc; i++) {
            this.debugInfoOut.m(indexMap.adjustString(ajn.ac(amjVar) - 1) + 1);
        }
        while (true) {
            byte b = amjVar.b.get();
            this.debugInfoOut.writeByte(b);
            if (b != 9) {
                switch (b) {
                    case 0:
                        return;
                    case 1:
                        this.debugInfoOut.m(ajn.ac(amjVar));
                        break;
                    case 2:
                        this.debugInfoOut.l(ajn.ab(amjVar));
                        break;
                    case 3:
                    case 4:
                        this.debugInfoOut.m(ajn.ac(amjVar));
                        this.debugInfoOut.m(indexMap.adjustString(ajn.ac(amjVar) - 1) + 1);
                        this.debugInfoOut.m(indexMap.adjustType(ajn.ac(amjVar) - 1) + 1);
                        if (b == 4) {
                            this.debugInfoOut.m(indexMap.adjustString(ajn.ac(amjVar) - 1) + 1);
                        }
                        break;
                    case 5:
                    case 6:
                        this.debugInfoOut.m(ajn.ac(amjVar));
                        break;
                }
            } else {
                this.debugInfoOut.m(indexMap.adjustString(ajn.ac(amjVar) - 1) + 1);
            }
        }
    }

    private void transformEncodedCatchHandler(aad aadVar, IndexMap indexMap) {
        int i = aadVar.c;
        int[] iArr = aadVar.a;
        int[] iArr2 = aadVar.b;
        if (i != -1) {
            this.codeOut.l(-iArr.length);
        } else {
            this.codeOut.l(iArr.length);
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.codeOut.m(indexMap.adjustType(iArr[i2]));
            this.codeOut.m(iArr2[i2]);
        }
        if (i != -1) {
            this.codeOut.m(i);
        }
    }

    private void transformFields(IndexMap indexMap, ys[] ysVarArr) {
        int length = ysVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            ys ysVar = ysVarArr[i];
            int iAdjustField = indexMap.adjustField(ysVar.a);
            this.classDataOut.m(iAdjustField - i2);
            this.classDataOut.m(ysVar.b);
            i++;
            i2 = iAdjustField;
        }
    }

    private void transformMethods(amk amkVar, IndexMap indexMap, yt[] ytVarArr) {
        int length = ytVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            yt ytVar = ytVarArr[i];
            int iAdjustMethod = indexMap.adjustMethod(ytVar.a);
            this.classDataOut.m(iAdjustMethod - i2);
            this.classDataOut.m(ytVar.b);
            if (ytVar.c == 0) {
                this.classDataOut.m(0);
            } else {
                ByteBuffer byteBuffer = this.codeOut.b;
                while ((byteBuffer.position() & 3) != 0) {
                    byteBuffer.put((byte) 0);
                }
                this.classDataOut.m(this.codeOut.b.position());
                transformCode(amkVar, amkVar.p(ytVar), indexMap);
            }
            i++;
            i2 = iAdjustMethod;
        }
    }

    private void transformStaticValues(amk amkVar, IndexMap indexMap) {
        dpr dprVar = amkVar.c.s;
        if (dprVar.e()) {
            amj amjVarN = amkVar.n(dprVar.c);
            for (int i = 0; i < dprVar.b; i++) {
                transformStaticValues(amjVarN, indexMap);
            }
        }
    }

    private void transformTries(amj amjVar, aae[] aaeVarArr, int[] iArr) {
        for (aae aaeVar : aaeVarArr) {
            amjVar.writeInt(aaeVar.a);
            amjVar.n(aaeVar.b);
            amjVar.n(iArr[aaeVar.c]);
        }
    }

    private void unionAnnotationSetsAndDirectories() {
        int i = 0;
        int i2 = 0;
        while (true) {
            amk[] amkVarArr = this.dexes;
            if (i2 >= amkVarArr.length) {
                break;
            }
            transformAnnotationSets(amkVarArr[i2], this.indexMaps[i2]);
            i2++;
        }
        int i3 = 0;
        while (true) {
            amk[] amkVarArr2 = this.dexes;
            if (i3 >= amkVarArr2.length) {
                break;
            }
            transformAnnotationSetRefLists(amkVarArr2[i3], this.indexMaps[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            amk[] amkVarArr3 = this.dexes;
            if (i4 >= amkVarArr3.length) {
                break;
            }
            transformAnnotationDirectories(amkVarArr3[i4], this.indexMaps[i4]);
            i4++;
        }
        while (true) {
            amk[] amkVarArr4 = this.dexes;
            if (i >= amkVarArr4.length) {
                return;
            }
            transformStaticValues(amkVarArr4[i], this.indexMaps[i]);
            i++;
        }
    }

    public amk merge() {
        amk[] amkVarArr = this.dexes;
        int i = 0;
        if (amkVarArr.length == 1) {
            return amkVarArr[0];
        }
        if (amkVarArr.length == 0) {
            return null;
        }
        long jNanoTime = System.nanoTime();
        amk amkVarMergeDexes = mergeDexes();
        WriterSizes writerSizes = new WriterSizes(this);
        int size = this.writerSizes.size() - writerSizes.size();
        if (size > this.compactWasteThreshold) {
            amkVarMergeDexes = new DexMerger(new amk[] { this.dexOut, new amk(0) }, CollisionPolicy.FAIL, this.context,
                    writerSizes).mergeDexes();
            this.context.out.printf("Result compacted from %.1fKiB to %.1fKiB to save %.1fKiB%n",
                    Float.valueOf(this.dexOut.b.capacity() / 1024.0f),
                    Float.valueOf(amkVarMergeDexes.b.capacity() / 1024.0f), Float.valueOf(size / 1024.0f));
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        while (i < this.dexes.length) {
            int i2 = i + 1;
            this.context.out.printf("Merged dex #%d (%d defs/%.1fKiB)%n", Integer.valueOf(i2),
                    Integer.valueOf(this.dexes[i].c.g.b), Float.valueOf(this.dexes[i].b.capacity() / 1024.0f));
            i = i2;
        }
        this.context.out.printf("Result is %d defs/%.1fKiB. Took %.1fs%n", Integer.valueOf(amkVarMergeDexes.c.g.b),
                Float.valueOf(amkVarMergeDexes.b.capacity() / 1024.0f), Float.valueOf(jNanoTime2 / 1.0E9f));
        return amkVarMergeDexes;
    }

    public void setCompactWasteThreshold(int i) {
        this.compactWasteThreshold = i;
    }

    private DexMerger(amk[] amkVarArr, CollisionPolicy collisionPolicy, DxContext dxContext, WriterSizes writerSizes) {
        this.compactWasteThreshold = 1048576;
        this.dexes = amkVarArr;
        this.collisionPolicy = collisionPolicy;
        this.context = dxContext;
        this.writerSizes = writerSizes;
        this.dexOut = new amk(writerSizes.size());
        this.indexMaps = new IndexMap[amkVarArr.length];
        for (int i = 0; i < amkVarArr.length; i++) {
            this.indexMaps[i] = new IndexMap(this.dexOut, amkVarArr[i].c);
        }
        this.instructionTransformer = new InstructionTransformer();
        this.headerOut = this.dexOut.l(writerSizes.header, "header");
        this.idsDefsOut = this.dexOut.l(writerSizes.idsDefs, "ids defs");
        amk amkVar = this.dexOut;
        dps dpsVar = amkVar.c;
        this.contentsOut = dpsVar;
        int i2 = amkVar.d;
        dpsVar.ac = i2;
        dpr dprVar = dpsVar.j;
        dprVar.c = i2;
        dprVar.b = 1;
        this.mapListOut = amkVar.l(writerSizes.mapList, "map list");
        dpr dprVar2 = dpsVar.k;
        amk amkVar2 = this.dexOut;
        dprVar2.c = amkVar2.d;
        this.typeListOut = amkVar2.l(writerSizes.typeList, "type list");
        dpr dprVar3 = dpsVar.l;
        amk amkVar3 = this.dexOut;
        dprVar3.c = amkVar3.d;
        this.annotationSetRefListOut = amkVar3.l(writerSizes.annotationsSetRefList, "annotation set ref list");
        dpr dprVar4 = dpsVar.m;
        amk amkVar4 = this.dexOut;
        dprVar4.c = amkVar4.d;
        this.annotationSetOut = amkVar4.l(writerSizes.annotationsSet, "annotation sets");
        dpr dprVar5 = dpsVar.n;
        amk amkVar5 = this.dexOut;
        dprVar5.c = amkVar5.d;
        this.classDataOut = amkVar5.l(writerSizes.classData, "class data");
        dpr dprVar6 = dpsVar.o;
        amk amkVar6 = this.dexOut;
        dprVar6.c = amkVar6.d;
        this.codeOut = amkVar6.l(writerSizes.code, "code");
        dpr dprVar7 = dpsVar.p;
        amk amkVar7 = this.dexOut;
        dprVar7.c = amkVar7.d;
        this.stringDataOut = amkVar7.l(writerSizes.stringData, "string data");
        dpr dprVar8 = dpsVar.q;
        amk amkVar8 = this.dexOut;
        dprVar8.c = amkVar8.d;
        this.debugInfoOut = amkVar8.l(writerSizes.debugInfo, "debug info");
        dpr dprVar9 = dpsVar.r;
        amk amkVar9 = this.dexOut;
        dprVar9.c = amkVar9.d;
        this.annotationOut = amkVar9.l(writerSizes.annotation, "annotation");
        dpr dprVar10 = dpsVar.s;
        amk amkVar10 = this.dexOut;
        dprVar10.c = amkVar10.d;
        this.encodedArrayOut = amkVar10.l(writerSizes.encodedArray, "encoded array");
        dpr dprVar11 = dpsVar.t;
        amk amkVar11 = this.dexOut;
        dprVar11.c = amkVar11.d;
        this.annotationsDirectoryOut = amkVar11.l(writerSizes.annotationsDirectory, "annotations directory");
        dpsVar.ab = this.dexOut.d - dpsVar.ac;
    }

    private void transformStaticValues(amj amjVar, IndexMap indexMap) {
        this.contentsOut.s.b++;
        indexMap.putEncodedArrayValueOffset(amjVar.b.position(), this.encodedArrayOut.b.position());
        ByteBuffer byteBuffer = amjVar.b;
        int iPosition = byteBuffer.position();
        new avs(amjVar, 28).k();
        byte[] bArr = new byte[byteBuffer.position() - iPosition];
        byteBuffer.position(iPosition);
        byteBuffer.get(bArr);
        this.encodedArrayOut.write(indexMap.adjustEncodedArray(new avr(bArr)).a);
    }
}
