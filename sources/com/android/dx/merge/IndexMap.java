package com.android.dx.merge;

import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.util.HashMap;
import me.hd.wauxv.obf.ajn;
import me.hd.wauxv.obf.amk;
import me.hd.wauxv.obf.amo;
import me.hd.wauxv.obf.avr;
import me.hd.wauxv.obf.avs;
import me.hd.wauxv.obf.azh;
import me.hd.wauxv.obf.cdh;
import me.hd.wauxv.obf.cdi;
import me.hd.wauxv.obf.cwe;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.dps;
import me.hd.wauxv.obf.ek;
import me.hd.wauxv.obf.emd;
import me.hd.wauxv.obf.emn;
import me.hd.wauxv.obf.fg;
import me.hd.wauxv.obf.sg;
import me.hd.wauxv.obf.sh;
import me.hd.wauxv.obf.su;
import me.hd.wauxv.obf.yx;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class IndexMap {
    private final HashMap<Integer, Integer> annotationDirectoryOffsets;
    private final HashMap<Integer, Integer> annotationOffsets;
    private final HashMap<Integer, Integer> annotationSetOffsets;
    private final HashMap<Integer, Integer> annotationSetRefListOffsets;
    public final int[] callSiteIds;
    private final HashMap<Integer, Integer> encodedArrayValueOffset;
    public final short[] fieldIds;
    public final HashMap<Integer, Integer> methodHandleIds = new HashMap<>();
    public final short[] methodIds;
    public final short[] protoIds;
    public final int[] stringIds;
    private final amk target;
    public final short[] typeIds;
    private final HashMap<Integer, Integer> typeListOffsets;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public final class EncodedValueTransformer {
        private final sh out;

        public EncodedValueTransformer(sh shVar) {
            this.out = shVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformAnnotation(avs avsVar) {
            int iG = avsVar.g();
            ajn.am(this.out, IndexMap.this.adjustType(avsVar.c));
            ajn.am(this.out, iG);
            for (int i = 0; i < iG; i++) {
                ajn.am(this.out, IndexMap.this.adjustString(ajn.ac(avsVar.a)));
                transform(avsVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformArray(avs avsVar) {
            avsVar.e(28);
            avsVar.b = -1;
            int iAc = ajn.ac(avsVar.a);
            ajn.am(this.out, iAc);
            for (int i = 0; i < iAc; i++) {
                transform(avsVar);
            }
        }

        private void writeTypeAndArg(int i, int i2) {
            this.out.writeByte(i | (i2 << 5));
        }

        public void transform(avs avsVar) {
            int iF = avsVar.f();
            sg sgVar = avsVar.a;
            if (iF == 0) {
                sh shVar = this.out;
                avsVar.e(0);
                avsVar.b = -1;
                emn.bl(shVar, 0, (byte) emn.au(sgVar, avsVar.d));
                return;
            }
            if (iF == 6) {
                emn.bl(this.out, 6, avsVar.i());
                return;
            }
            if (iF == 2) {
                sh shVar2 = this.out;
                avsVar.e(2);
                avsVar.b = -1;
                emn.bl(shVar2, 2, (short) emn.au(sgVar, avsVar.d));
                return;
            }
            if (iF == 3) {
                sh shVar3 = this.out;
                avsVar.e(3);
                avsVar.b = -1;
                emn.bm(shVar3, 3, (char) emn.aw(sgVar, avsVar.d, false));
                return;
            }
            if (iF == 4) {
                sh shVar4 = this.out;
                avsVar.e(4);
                avsVar.b = -1;
                emn.bl(shVar4, 4, emn.au(sgVar, avsVar.d));
                return;
            }
            if (iF == 16) {
                avsVar.e(16);
                avsVar.b = -1;
                emn.bk(this.out, 16, ((long) Float.floatToIntBits(Float.intBitsToFloat(emn.aw(sgVar, avsVar.d, true)))) << 32);
                return;
            }
            if (iF == 17) {
                emn.bk(this.out, 17, Double.doubleToLongBits(avsVar.h()));
                return;
            }
            switch (iF) {
                case 21:
                    sh shVar5 = this.out;
                    IndexMap indexMap = IndexMap.this;
                    avsVar.e(21);
                    avsVar.b = -1;
                    emn.bm(shVar5, 21, indexMap.adjustProto(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 22:
                    sh shVar6 = this.out;
                    IndexMap indexMap2 = IndexMap.this;
                    avsVar.e(22);
                    avsVar.b = -1;
                    emn.bm(shVar6, 22, indexMap2.adjustMethodHandle(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 23:
                    emn.bm(this.out, 23, IndexMap.this.adjustString(avsVar.j()));
                    return;
                case 24:
                    sh shVar7 = this.out;
                    IndexMap indexMap3 = IndexMap.this;
                    avsVar.e(24);
                    avsVar.b = -1;
                    emn.bm(shVar7, 24, indexMap3.adjustType(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 25:
                    sh shVar8 = this.out;
                    IndexMap indexMap4 = IndexMap.this;
                    avsVar.e(25);
                    avsVar.b = -1;
                    emn.bm(shVar8, 25, indexMap4.adjustField(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 26:
                    sh shVar9 = this.out;
                    IndexMap indexMap5 = IndexMap.this;
                    avsVar.e(26);
                    avsVar.b = -1;
                    emn.bm(shVar9, 26, indexMap5.adjustMethod(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 27:
                    sh shVar10 = this.out;
                    IndexMap indexMap6 = IndexMap.this;
                    avsVar.e(27);
                    avsVar.b = -1;
                    emn.bm(shVar10, 27, indexMap6.adjustField(emn.aw(sgVar, avsVar.d, false)));
                    return;
                case 28:
                    writeTypeAndArg(28, 0);
                    transformArray(avsVar);
                    return;
                case 29:
                    writeTypeAndArg(29, 0);
                    transformAnnotation(avsVar);
                    return;
                case 30:
                    avsVar.e(30);
                    avsVar.b = -1;
                    writeTypeAndArg(30, 0);
                    return;
                case 31:
                    avsVar.e(31);
                    avsVar.b = -1;
                    writeTypeAndArg(31, avsVar.d != 0 ? 1 : 0);
                    return;
                default:
                    throw new amo("Unexpected type: " + Integer.toHexString(avsVar.f()), null);
            }
        }
    }

    public IndexMap(amk amkVar, dps dpsVar) {
        this.target = amkVar;
        this.stringIds = new int[dpsVar.b.b];
        this.typeIds = new short[dpsVar.c.b];
        this.protoIds = new short[dpsVar.d.b];
        this.fieldIds = new short[dpsVar.e.b];
        this.methodIds = new short[dpsVar.f.b];
        this.callSiteIds = new int[dpsVar.h.b];
        HashMap<Integer, Integer> map = new HashMap<>();
        this.typeListOffsets = map;
        this.annotationOffsets = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        this.annotationSetOffsets = map2;
        this.annotationSetRefListOffsets = new HashMap<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        this.annotationDirectoryOffsets = map3;
        HashMap<Integer, Integer> map4 = new HashMap<>();
        this.encodedArrayValueOffset = map4;
        map.put(0, 0);
        map2.put(0, 0);
        map3.put(0, 0);
        map4.put(0, 0);
    }

    public cdi adjust(cdi cdiVar) {
        return new cdi(this.target, adjustType(cdiVar.b), adjustProto(cdiVar.c), adjustString(cdiVar.d));
    }

    public int adjustAnnotation(int i) {
        return this.annotationOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationDirectory(int i) {
        return this.annotationDirectoryOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationSet(int i) {
        return this.annotationSetOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustAnnotationSetRefList(int i) {
        return this.annotationSetRefListOffsets.get(Integer.valueOf(i)).intValue();
    }

    public int adjustCallSite(int i) {
        return this.callSiteIds[i];
    }

    public int adjustEncodedArray(int i) {
        return this.encodedArrayValueOffset.get(Integer.valueOf(i)).intValue();
    }

    public avr adjustEncodedValue(avr avrVar) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transform(new avs(new ek(avrVar.a)));
        return new avr(byteArrayAnnotatedOutput.toByteArray());
    }

    public int adjustField(int i) {
        return this.fieldIds[i] & 65535;
    }

    public int adjustMethod(int i) {
        return this.methodIds[i] & 65535;
    }

    public int adjustMethodHandle(int i) {
        return this.methodHandleIds.get(Integer.valueOf(i)).intValue();
    }

    public int adjustProto(int i) {
        return this.protoIds[i] & 65535;
    }

    public int adjustString(int i) {
        if (i == -1) {
            return -1;
        }
        return this.stringIds[i];
    }

    public int adjustType(int i) {
        if (i == -1) {
            return -1;
        }
        return this.typeIds[i] & 65535;
    }

    public emd adjustTypeList(emd emdVar) {
        if (emdVar == emd.a) {
            return emdVar;
        }
        short[] sArr = (short[]) emdVar.c.clone();
        for (int i = 0; i < sArr.length; i++) {
            sArr[i] = (short) adjustType(sArr[i]);
        }
        return new emd(this.target, sArr);
    }

    public int adjustTypeListOffset(int i) {
        return this.typeListOffsets.get(Integer.valueOf(i)).intValue();
    }

    public void putAnnotationDirectoryOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationDirectoryOffsets.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void putAnnotationOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationOffsets.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void putAnnotationSetOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationSetOffsets.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void putAnnotationSetRefListOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.annotationSetRefListOffsets.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void putEncodedArrayValueOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.encodedArrayValueOffset.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void putTypeListOffset(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        this.typeListOffsets.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public avr adjustEncodedArray(avr avrVar) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformArray(new avs(avrVar, 28));
        return new avr(byteArrayAnnotatedOutput.toByteArray());
    }

    public su adjust(su suVar) {
        return new su(this.target, adjustEncodedArray(suVar.b));
    }

    public cdh adjust(cdh cdhVar) {
        int iAdjustField;
        amk amkVar = this.target;
        int i = cdhVar.b;
        int i2 = cdhVar.d;
        int i3 = cdhVar.c;
        int iAe = dkz.ae(i);
        if (iAe != 0 && iAe != 1 && iAe != 2 && iAe != 3) {
            iAdjustField = adjustMethod(i2);
        } else {
            iAdjustField = adjustField(i2);
        }
        return new cdh(amkVar, i, i3, iAdjustField, cdhVar.e);
    }

    public azh adjust(azh azhVar) {
        return new azh(this.target, adjustType(azhVar.b), adjustType(azhVar.c), adjustString(azhVar.d));
    }

    public cwe adjust(cwe cweVar) {
        return new cwe(this.target, adjustString(cweVar.b), adjustType(cweVar.c), adjustTypeListOffset(cweVar.d));
    }

    public yx adjust(yx yxVar) {
        return new yx(this.target, yxVar.b, adjustType(yxVar.c), yxVar.d, adjustType(yxVar.e), adjustTypeListOffset(yxVar.f), yxVar.g, yxVar.h, yxVar.i, yxVar.j);
    }

    public SortableType adjust(SortableType sortableType) {
        return new SortableType(sortableType.getDex(), sortableType.getIndexMap(), adjust(sortableType.getClassDef()));
    }

    public fg adjust(fg fgVar) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformAnnotation(new avs(fgVar.c, 29));
        return new fg(this.target, fgVar.b, new avr(byteArrayAnnotatedOutput.toByteArray()));
    }
}
