package net.bytebuddy.implementation.bytecode.assign.primitive;

import java.util.Arrays;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BOOLEAN' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PrimitiveNarrowingDelegate {
    private static final /* synthetic */ PrimitiveNarrowingDelegate[] $VALUES;
    public static final PrimitiveNarrowingDelegate BOOLEAN;
    public static final PrimitiveNarrowingDelegate BYTE;
    public static final PrimitiveNarrowingDelegate CHARACTER;
    public static final PrimitiveNarrowingDelegate DOUBLE;
    public static final PrimitiveNarrowingDelegate FLOAT;
    public static final PrimitiveNarrowingDelegate INTEGER;
    public static final PrimitiveNarrowingDelegate LONG;
    public static final PrimitiveNarrowingDelegate SHORT;
    private final StackManipulation toBooleanStackManipulation;
    private final StackManipulation toByteStackManipulation;
    private final StackManipulation toCharacterStackManipulation;
    private final StackManipulation toDoubleStackManipulation;
    private final StackManipulation toFloatStackManipulation;
    private final StackManipulation toIntegerStackManipulation;
    private final StackManipulation toLongStackManipulation;
    private final StackManipulation toShortStackManipulation;

    static {
        StackManipulation.Trivial trivial = StackManipulation.Trivial.INSTANCE;
        StackManipulation.Illegal illegal = StackManipulation.Illegal.INSTANCE;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate = new PrimitiveNarrowingDelegate("BOOLEAN", 0, trivial, illegal, illegal, illegal, illegal, illegal, illegal, illegal);
        BOOLEAN = primitiveNarrowingDelegate;
        StackSize stackSize = StackSize.ZERO;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate2 = new PrimitiveNarrowingDelegate("BYTE", 1, illegal, trivial, illegal, new StackManipulation.AbstractBase(new int[]{146}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, illegal, illegal, illegal, illegal);
        BYTE = primitiveNarrowingDelegate2;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate3 = new PrimitiveNarrowingDelegate("SHORT", 2, illegal, new StackManipulation.AbstractBase(new int[]{145}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial, new StackManipulation.AbstractBase(new int[]{146}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, illegal, illegal, illegal, illegal);
        SHORT = primitiveNarrowingDelegate3;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate4 = new PrimitiveNarrowingDelegate("CHARACTER", 3, illegal, new StackManipulation.AbstractBase(new int[]{145}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{147}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial, illegal, illegal, illegal, illegal);
        CHARACTER = primitiveNarrowingDelegate4;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate5 = new PrimitiveNarrowingDelegate("INTEGER", 4, illegal, new StackManipulation.AbstractBase(new int[]{145}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{147}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{146}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial, illegal, illegal, illegal);
        INTEGER = primitiveNarrowingDelegate5;
        StackSize stackSize2 = StackSize.SINGLE;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate6 = new PrimitiveNarrowingDelegate("LONG", 5, illegal, new StackManipulation.AbstractBase(new int[]{136, 145}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{136, 147}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{136, 146}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{136}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial, illegal, illegal);
        LONG = primitiveNarrowingDelegate6;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate7 = new PrimitiveNarrowingDelegate("FLOAT", 6, illegal, new StackManipulation.AbstractBase(new int[]{139, 145}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{139, 147}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{139, 146}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{139}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{140}, stackSize2.toIncreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial, illegal);
        FLOAT = primitiveNarrowingDelegate7;
        PrimitiveNarrowingDelegate primitiveNarrowingDelegate8 = new PrimitiveNarrowingDelegate("DOUBLE", 7, illegal, new StackManipulation.AbstractBase(new int[]{142, 145}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{142, 147}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{142, 146}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{142}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{143}, stackSize.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, new StackManipulation.AbstractBase(new int[]{144}, stackSize2.toDecreasingSize()) { // from class: net.bytebuddy.implementation.bytecode.assign.primitive.PrimitiveNarrowingDelegate.NarrowingStackManipulation
            private final int[] conversionOpcodes;
            private final StackManipulation.Size size;

            {
                this.conversionOpcodes = iArr;
                this.size = size;
            }

            @Override // net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                for (int i : this.conversionOpcodes) {
                    methodVisitor.visitInsn(i);
                }
                return this.size;
            }

            public boolean equals(@MaybeNull Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                NarrowingStackManipulation narrowingStackManipulation = (NarrowingStackManipulation) obj;
                return Arrays.equals(this.conversionOpcodes, narrowingStackManipulation.conversionOpcodes) && this.size.equals(narrowingStackManipulation.size);
            }

            public int hashCode() {
                return this.size.hashCode() + ((Arrays.hashCode(this.conversionOpcodes) + (getClass().hashCode() * 31)) * 31);
            }
        }, trivial);
        DOUBLE = primitiveNarrowingDelegate8;
        $VALUES = new PrimitiveNarrowingDelegate[]{primitiveNarrowingDelegate, primitiveNarrowingDelegate2, primitiveNarrowingDelegate3, primitiveNarrowingDelegate4, primitiveNarrowingDelegate5, primitiveNarrowingDelegate6, primitiveNarrowingDelegate7, primitiveNarrowingDelegate8};
    }

    private PrimitiveNarrowingDelegate(String str, int i, StackManipulation stackManipulation, StackManipulation stackManipulation2, StackManipulation stackManipulation3, StackManipulation stackManipulation4, StackManipulation stackManipulation5, StackManipulation stackManipulation6, StackManipulation stackManipulation7, StackManipulation stackManipulation8) {
        this.toBooleanStackManipulation = stackManipulation;
        this.toByteStackManipulation = stackManipulation2;
        this.toShortStackManipulation = stackManipulation3;
        this.toCharacterStackManipulation = stackManipulation4;
        this.toIntegerStackManipulation = stackManipulation5;
        this.toLongStackManipulation = stackManipulation6;
        this.toFloatStackManipulation = stackManipulation7;
        this.toDoubleStackManipulation = stackManipulation8;
    }

    public static PrimitiveNarrowingDelegate forPrimitive(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return BOOLEAN;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return BYTE;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return SHORT;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return CHARACTER;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return INTEGER;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return LONG;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return FLOAT;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return DOUBLE;
        }
        throw new IllegalArgumentException("Not a primitive, non-void type: " + typeDefinition);
    }

    public static PrimitiveNarrowingDelegate valueOf(String str) {
        return (PrimitiveNarrowingDelegate) Enum.valueOf(PrimitiveNarrowingDelegate.class, str);
    }

    public static PrimitiveNarrowingDelegate[] values() {
        return (PrimitiveNarrowingDelegate[]) $VALUES.clone();
    }

    public StackManipulation narrowTo(TypeDefinition typeDefinition) {
        if (typeDefinition.represents(Boolean.TYPE)) {
            return this.toBooleanStackManipulation;
        }
        if (typeDefinition.represents(Byte.TYPE)) {
            return this.toByteStackManipulation;
        }
        if (typeDefinition.represents(Short.TYPE)) {
            return this.toShortStackManipulation;
        }
        if (typeDefinition.represents(Character.TYPE)) {
            return this.toCharacterStackManipulation;
        }
        if (typeDefinition.represents(Integer.TYPE)) {
            return this.toIntegerStackManipulation;
        }
        if (typeDefinition.represents(Long.TYPE)) {
            return this.toLongStackManipulation;
        }
        if (typeDefinition.represents(Float.TYPE)) {
            return this.toFloatStackManipulation;
        }
        if (typeDefinition.represents(Double.TYPE)) {
            return this.toDoubleStackManipulation;
        }
        throw new IllegalArgumentException("Not a primitive non-void type: " + typeDefinition);
    }
}
