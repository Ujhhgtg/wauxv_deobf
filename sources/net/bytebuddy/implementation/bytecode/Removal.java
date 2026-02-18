package net.bytebuddy.implementation.bytecode;

import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'ZERO' uses external variables
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
public class Removal implements StackManipulation {
    private static final /* synthetic */ Removal[] $VALUES;
    public static final Removal DOUBLE;
    public static final Removal SINGLE;
    public static final Removal ZERO;
    private final int opcode;
    private final StackManipulation.Size size;

    /* JADX INFO: renamed from: net.bytebuddy.implementation.bytecode.Removal$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize;

        static {
            int[] iArr = new int[StackSize.values().length];
            $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize = iArr;
            try {
                iArr[StackSize.SINGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.DOUBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[StackSize.ZERO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i = 0;
        Removal removal = new Removal("ZERO", i, StackSize.ZERO, i) { // from class: net.bytebuddy.implementation.bytecode.Removal.1
            @Override // net.bytebuddy.implementation.bytecode.Removal, net.bytebuddy.implementation.bytecode.StackManipulation
            public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
                return StackManipulation.Size.ZERO;
            }
        };
        ZERO = removal;
        Removal removal2 = new Removal("SINGLE", 1, StackSize.SINGLE, 87);
        SINGLE = removal2;
        Removal removal3 = new Removal("DOUBLE", 2, StackSize.DOUBLE, 88);
        DOUBLE = removal3;
        $VALUES = new Removal[]{removal, removal2, removal3};
    }

    public static StackManipulation of(TypeDefinition typeDefinition) {
        int i = AnonymousClass2.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[typeDefinition.getStackSize().ordinal()];
        if (i == 1) {
            return SINGLE;
        }
        if (i == 2) {
            return DOUBLE;
        }
        if (i == 3) {
            return ZERO;
        }
        throw new AssertionError();
    }

    public static Removal valueOf(String str) {
        return (Removal) Enum.valueOf(Removal.class, str);
    }

    public static Removal[] values() {
        return (Removal[]) $VALUES.clone();
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        methodVisitor.visitInsn(this.opcode);
        return this.size;
    }

    @Override // net.bytebuddy.implementation.bytecode.StackManipulation
    public boolean isValid() {
        return true;
    }

    private Removal(String str, int i, StackSize stackSize, int i2) {
        this.size = stackSize.toDecreasingSize();
        this.opcode = i2;
    }
}
