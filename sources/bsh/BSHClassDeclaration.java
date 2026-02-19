package bsh;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHClassDeclaration extends SimpleNode {
    static final String CLASSINITNAME = "_bshClassInit";
    boolean extend;
    private Class<?> generatedClass;
    Modifiers modifiers;
    String name;
    int numInterfaces;
    ClassGenerator.Type type;

    public BSHClassDeclaration(int i) {
        super(i);
        this.modifiers = new Modifiers(0);
    }

    private Class<?> generateClass(CallStack callStack, Interpreter interpreter) throws EvalError {
        int i;
        Class<?> cls;
        int i2 = 0;
        ArrayList<BshMethod> arrayList = new ArrayList(0);
        if (this.extend) {
            Class<?> cls2 = ((BSHAmbiguousName) jjtGetChild(0)).toClass(callStack, interpreter);
            try {
                Interpreter.mainSecurityGuard.canExtends(cls2);
                if (Reflect.isGeneratedClass(cls2)) {
                    if (Reflect.getClassModifiers(cls2).hasModifier("final")) {
                        throw new EvalException("Cannot inherit from final class ".concat(cls2.getName()), null, null);
                    }
                    arrayList.addAll((Collection) Stream.of((Object[]) Reflect.getDeclaredMethods(cls2)).filter(new a()).collect(Collectors.toList()));
                }
                cls = cls2;
                i = 1;
            } catch (UtilEvalError e) {
                throw e.toEvalError(this, callStack);
            }
        } else {
            i = 0;
            cls = null;
        }
        Class<?>[] clsArr = new Class[this.numInterfaces];
        while (i2 < this.numInterfaces) {
            int i3 = i + 1;
            BSHAmbiguousName bSHAmbiguousName = (BSHAmbiguousName) jjtGetChild(i);
            Class<?> cls3 = bSHAmbiguousName.toClass(callStack, interpreter);
            clsArr[i2] = cls3;
            if (!cls3.isInterface()) {
                throw new EvalException(yg.concatToVar1(new StringBuilder("Type: "), bSHAmbiguousName.text, " is not an interface!"), this, callStack);
            }
            try {
                Interpreter.mainSecurityGuard.canImplements(clsArr[i2]);
                i2++;
                i = i3;
            } catch (UtilEvalError e2) {
                throw e2.toEvalError(this, callStack);
            }
        }
        BSHBlock bSHBlock = (BSHBlock) jjtGetChild(i);
        if (this.type == ClassGenerator.Type.INTERFACE) {
            this.modifiers.changeContext(1);
        }
        Class<?> clsGenerateClass = ClassGenerator.getClassGenerator().generateClass(this.name, this.modifiers, clsArr, cls, bSHBlock, this.type, callStack, interpreter);
        for (BshMethod bshMethod : arrayList) {
            if (Reflect.getDeclaredMethod(clsGenerateClass, bshMethod.getName(), bshMethod.getParameterTypes()) != null) {
                throw new EvalException("Cannot override " + bshMethod.getName() + "() in " + StringUtil.typeString(cls) + " overridden method is final", null, null);
            }
        }
        return clsGenerateClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$generateClass$0(BshMethod bshMethod) {
        return bshMethod.hasModifier("final") && !bshMethod.hasModifier("private");
    }

    @Override // bsh.SimpleNode, bsh.Node
    public synchronized Object eval(CallStack callStack, Interpreter interpreter) {
        try {
            if (this.generatedClass == null) {
                this.generatedClass = generateClass(callStack, interpreter);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.generatedClass;
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.name;
    }
}
