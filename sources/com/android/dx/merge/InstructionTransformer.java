package com.android.dx.merge;

import com.android.dx.io.CodeReader;
import com.android.dx.io.instructions.DecodedInstruction;
import com.android.dx.io.instructions.ShortArrayCodeOutput;
import me.hd.wauxv.obf.amp;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
final class InstructionTransformer {
    private IndexMap indexMap;
    private int mappedAt;
    private DecodedInstruction[] mappedInstructions;
    private final CodeReader reader;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class CallSiteVisitor implements CodeReader.Visitor {
        private CallSiteVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withIndex(InstructionTransformer.this.indexMap.adjustCallSite(decodedInstruction.getIndex()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class FieldVisitor implements CodeReader.Visitor {
        private FieldVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            int iAdjustField = InstructionTransformer.this.indexMap.adjustField(decodedInstruction.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction.getOpcode() == 27, iAdjustField);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withIndex(iAdjustField);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class GenericVisitor implements CodeReader.Visitor {
        private GenericVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class MethodAndProtoVisitor implements CodeReader.Visitor {
        private MethodAndProtoVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withProtoIndex(InstructionTransformer.this.indexMap.adjustMethod(decodedInstruction.getIndex()), InstructionTransformer.this.indexMap.adjustProto(decodedInstruction.getProtoIndex()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class MethodVisitor implements CodeReader.Visitor {
        private MethodVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            int iAdjustMethod = InstructionTransformer.this.indexMap.adjustMethod(decodedInstruction.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction.getOpcode() == 27, iAdjustMethod);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withIndex(iAdjustMethod);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class StringVisitor implements CodeReader.Visitor {
        private StringVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            int iAdjustString = InstructionTransformer.this.indexMap.adjustString(decodedInstruction.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction.getOpcode() == 27, iAdjustString);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withIndex(iAdjustString);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public class TypeVisitor implements CodeReader.Visitor {
        private TypeVisitor() {
        }

        @Override // com.android.dx.io.CodeReader.Visitor
        public void visit(DecodedInstruction[] decodedInstructionArr, DecodedInstruction decodedInstruction) {
            int iAdjustType = InstructionTransformer.this.indexMap.adjustType(decodedInstruction.getIndex());
            InstructionTransformer.jumboCheck(decodedInstruction.getOpcode() == 27, iAdjustType);
            InstructionTransformer.this.mappedInstructions[InstructionTransformer.access$808(InstructionTransformer.this)] = decodedInstruction.withIndex(iAdjustType);
        }
    }

    public InstructionTransformer() {
        CodeReader codeReader = new CodeReader();
        this.reader = codeReader;
        codeReader.setAllVisitors(new GenericVisitor());
        codeReader.setStringVisitor(new StringVisitor());
        codeReader.setTypeVisitor(new TypeVisitor());
        codeReader.setFieldVisitor(new FieldVisitor());
        codeReader.setMethodVisitor(new MethodVisitor());
        codeReader.setMethodAndProtoVisitor(new MethodAndProtoVisitor());
        codeReader.setCallSiteVisitor(new CallSiteVisitor());
    }

    public static /* synthetic */ int access$808(InstructionTransformer instructionTransformer) {
        int i = instructionTransformer.mappedAt;
        instructionTransformer.mappedAt = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void jumboCheck(boolean z, int i) {
        if (!z && i > 65535) {
            throw new amp(yg.f(i, "Cannot merge new index ", " into a non-jumbo instruction!"), null);
        }
    }

    public short[] transform(IndexMap indexMap, short[] sArr) {
        DecodedInstruction[] decodedInstructionArrDecodeAll = DecodedInstruction.decodeAll(sArr);
        int length = decodedInstructionArrDecodeAll.length;
        this.indexMap = indexMap;
        this.mappedInstructions = new DecodedInstruction[length];
        this.mappedAt = 0;
        this.reader.visitAll(decodedInstructionArrDecodeAll);
        ShortArrayCodeOutput shortArrayCodeOutput = new ShortArrayCodeOutput(length);
        for (DecodedInstruction decodedInstruction : this.mappedInstructions) {
            if (decodedInstruction != null) {
                decodedInstruction.encode(shortArrayCodeOutput);
            }
        }
        this.indexMap = null;
        return shortArrayCodeOutput.getArray();
    }
}
