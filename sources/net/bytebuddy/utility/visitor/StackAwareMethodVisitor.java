package net.bytebuddy.utility.visitor;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.dkz;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.OpenedClassReader;
import net.bytebuddy.utility.nullability.MaybeNull;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class StackAwareMethodVisitor extends MethodVisitor {
    private static final boolean ACCESS_CONTROLLER;
    private static final int[] SIZE_CHANGE;
    public static final boolean UNADJUSTED;
    public static final String UNADJUSTED_PROPERTY = "net.bytebuddy.unadjusted";
    private List<StackSize> current;
    private int freeIndex;
    private final Map<Label, List<StackSize>> sizes;

    /* JADX INFO: renamed from: net.bytebuddy.utility.visitor.StackAwareMethodVisitor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static /* synthetic */ class AnonymousClass1 {
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
        }
    }

    static {
        boolean z;
        int i = 0;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = false;
        } catch (SecurityException unused2) {
            ACCESS_CONTROLLER = true;
        }
        try {
            z = Boolean.parseBoolean((String) doPrivileged(new GetSystemPropertyAction(UNADJUSTED_PROPERTY)));
        } catch (Exception unused3) {
            z = false;
        }
        UNADJUSTED = z;
        SIZE_CHANGE = new int[202];
        while (true) {
            int[] iArr = SIZE_CHANGE;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEEEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE".charAt(i) - 'E';
            i++;
        }
    }

    public StackAwareMethodVisitor(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        super(OpenedClassReader.ASM_API, methodVisitor);
        this.current = new ArrayList();
        this.sizes = new HashMap();
        this.freeIndex = methodDescription.getStackSize();
    }

    private void adjustStack(int i) {
        adjustStack(i, 0);
    }

    private void doDrain(List<StackSize> list) {
        ListIterator<StackSize> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            StackSize stackSizePrevious = listIterator.previous();
            int i = AnonymousClass1.$SwitchMap$net$bytebuddy$implementation$bytecode$StackSize[stackSizePrevious.ordinal()];
            if (i == 1) {
                super.visitInsn(87);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("Unexpected stack size: " + stackSizePrevious);
                }
                super.visitInsn(88);
            }
        }
    }

    @AccessControllerPlugin.Enhance
    private static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    public static MethodVisitor of(MethodVisitor methodVisitor, MethodDescription methodDescription) {
        return UNADJUSTED ? methodVisitor : new StackAwareMethodVisitor(methodVisitor, methodDescription);
    }

    public void drainStack() {
        doDrain(this.current);
    }

    public void register(Label label, List<StackSize> list) {
        this.sizes.put(label, list);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFieldInsn(int i, String str, String str2, String str3) {
        int size = Type.getType(str3).getSize();
        switch (i) {
            case 178:
                adjustStack(size);
                break;
            case 179:
                adjustStack(-size);
                break;
            case 180:
                adjustStack(-1);
                adjustStack(size);
                break;
            case 181:
                adjustStack((-size) - 1);
                break;
            default:
                throw new IllegalStateException(bjs.i(i, "Unexpected opcode: "));
        }
        super.visitFieldInsn(i, str, str2, str3);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitFrame(int i, int i2, @MaybeNull Object[] objArr, int i3, @MaybeNull Object[] objArr2) {
        if (i == -1 || i == 0) {
            this.current.clear();
            for (int i4 = 0; i4 < i3; i4++) {
                Object obj = objArr2[i4];
                if (obj == Opcodes.LONG || obj == Opcodes.DOUBLE) {
                    this.current.add(StackSize.DOUBLE);
                } else {
                    this.current.add(StackSize.SINGLE);
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            this.current.clear();
        } else {
            if (i != 4) {
                throw new IllegalStateException(bjs.i(i, "Unknown frame type: "));
            }
            this.current.clear();
            Object obj2 = objArr2[0];
            if (obj2 == Opcodes.LONG || obj2 == Opcodes.DOUBLE) {
                this.current.add(StackSize.DOUBLE);
            } else {
                this.current.add(StackSize.SINGLE);
            }
        }
        super.visitFrame(i, i2, objArr, i3, objArr2);
    }

    /* JADX WARN: Found duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Found duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Found duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Found duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Found duplicated region for block: B:28:0x0059  */
    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInsn(int i) {
        if (i == 47 || i == 49) {
            adjustStack(-2);
            adjustStack(2);
        } else if (i == 133) {
            adjustStack(-1);
            adjustStack(2);
        } else if (i == 144) {
            adjustStack(-2);
            adjustStack(1);
        } else if (i == 191) {
            this.current.clear();
        } else if (i == 90) {
            int i2 = SIZE_CHANGE[i];
            adjustStack(i2, i2 + 1);
        } else if (i == 91) {
            int i3 = SIZE_CHANGE[i];
            adjustStack(i3, i3 + 2);
        } else if (i == 93) {
            int i22 = SIZE_CHANGE[i];
            adjustStack(i22, i22 + 1);
        } else if (i != 94) {
            switch (i) {
                case 135:
                    adjustStack(-1);
                    adjustStack(2);
                    break;
                case 136:
                case 137:
                    adjustStack(-2);
                    adjustStack(1);
                    break;
                default:
                    switch (i) {
                        case 140:
                        case 141:
                            adjustStack(-1);
                            adjustStack(2);
                            break;
                        case 142:
                            adjustStack(-2);
                            adjustStack(1);
                            break;
                        default:
                            switch (i) {
                                case 172:
                                case 173:
                                case 174:
                                case 175:
                                case 176:
                                case 177:
                                    this.current.clear();
                                    break;
                                default:
                                    adjustStack(SIZE_CHANGE[i]);
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            int i32 = SIZE_CHANGE[i];
            adjustStack(i32, i32 + 2);
        }
        super.visitInsn(i);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitIntInsn(int i, int i2) {
        adjustStack(SIZE_CHANGE[i]);
        super.visitIntInsn(i, i2);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String str, String str2, Handle handle, Object... objArr) {
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str2);
        adjustStack((-(argumentsAndReturnSizes >> 2)) + 1);
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitInvokeDynamicInsn(str, str2, handle, objArr);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitJumpInsn(int i, Label label) {
        adjustStack(SIZE_CHANGE[i]);
        this.sizes.put(label, new ArrayList(i == 168 ? CompoundList.of(this.current, StackSize.SINGLE) : this.current));
        if (i == 167) {
            this.current.clear();
        }
        super.visitJumpInsn(i, label);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLabel(Label label) {
        List<StackSize> list = this.sizes.get(label);
        if (list != null) {
            this.current = new ArrayList(list);
        }
        super.visitLabel(label);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLdcInsn(Object obj) {
        adjustStack(((obj instanceof Long) || (obj instanceof Double)) ? 2 : 1);
        super.visitLdcInsn(obj);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label label, int[] iArr, Label[] labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label label2 : labelArr) {
            this.sizes.put(label2, arrayList);
        }
        super.visitLookupSwitchInsn(label, iArr, labelArr);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMethodInsn(int i, String str, String str2, String str3, boolean z) {
        int argumentsAndReturnSizes = Type.getArgumentsAndReturnSizes(str3);
        adjustStack((-(argumentsAndReturnSizes >> 2)) + (i == 184 ? 1 : 0));
        adjustStack(argumentsAndReturnSizes & 3);
        super.visitMethodInsn(i, str, str2, str3, z);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String str, int i) {
        adjustStack(1 - i);
        super.visitMultiANewArrayInsn(str, i);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr) {
        adjustStack(-1);
        ArrayList arrayList = new ArrayList(this.current);
        this.sizes.put(label, arrayList);
        for (Label label2 : labelArr) {
            this.sizes.put(label2, arrayList);
        }
        super.visitTableSwitchInsn(i, i2, label, labelArr);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTryCatchBlock(Label label, Label label2, Label label3, @MaybeNull String str) {
        this.sizes.put(label3, Collections.singletonList(StackSize.SINGLE));
        super.visitTryCatchBlock(label, label2, label3, str);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitTypeInsn(int i, String str) {
        adjustStack(SIZE_CHANGE[i]);
        super.visitTypeInsn(i, str);
    }

    @Override // net.bytebuddy.jar.asm.MethodVisitor
    public void visitVarInsn(int i, int i2) {
        if (i != 169) {
            switch (i) {
                case 54:
                case 56:
                case 58:
                    this.freeIndex = Math.max(this.freeIndex, i2 + 1);
                    break;
                case 55:
                case 57:
                    this.freeIndex = Math.max(this.freeIndex, i2 + 2);
                    break;
            }
        } else {
            this.current.clear();
        }
        adjustStack(SIZE_CHANGE[i]);
        super.visitVarInsn(i, i2);
    }

    private void adjustStack(int i, int i2) {
        if (i > 2) {
            throw new IllegalStateException(bjs.i(i, "Cannot push multiple values onto the operand stack: "));
        }
        if (i > 0) {
            int size = this.current.size();
            while (i2 > 0 && size > 0) {
                size--;
                i2 -= this.current.get(size).getSize();
            }
            if (i2 < 0) {
                throw new IllegalStateException(bjs.i(i2, "Unexpected offset underflow: "));
            }
            this.current.add(size, StackSize.of(i));
            return;
        }
        if (i2 != 0) {
            throw new IllegalStateException(dkz.p(i2, "Cannot specify non-zero offset ", " for non-incrementing value: ", i));
        }
        while (i < 0) {
            if (this.current.isEmpty()) {
                return;
            }
            List<StackSize> list = this.current;
            i += list.remove(list.size() - 1).getSize();
        }
        if (i == 1) {
            this.current.add(StackSize.SINGLE);
        } else if (i != 0) {
            throw new IllegalStateException(bjs.i(i, "Unexpected remainder on the operand stack: "));
        }
    }

    public int drainStack(int i, int i2, StackSize stackSize) {
        if (this.current.isEmpty()) {
            return 0;
        }
        List<StackSize> list = this.current;
        int size = list.get(list.size() - 1).getSize() - stackSize.getSize();
        if (this.current.size() == 1 && size == 0) {
            return 0;
        }
        super.visitVarInsn(i, this.freeIndex);
        if (size == 1) {
            super.visitInsn(87);
        } else if (size != 0) {
            throw new IllegalStateException(bjs.i(size, "Unexpected remainder on the operand stack: "));
        }
        List<StackSize> list2 = this.current;
        doDrain(list2.subList(0, list2.size() - 1));
        super.visitVarInsn(i2, this.freeIndex);
        return stackSize.getSize() + this.freeIndex;
    }
}
