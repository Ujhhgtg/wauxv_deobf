package bsh;

import java.lang.reflect.Array;
import net.bytebuddy.implementation.auxiliary.TypeProxy;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHFormalParameter extends SimpleNode {
    public static final Class UNTYPED = null;
    int dimensions;
    boolean isFinal;
    boolean isVarArgs;
    public String name;
    public Class type;

    public BSHFormalParameter(int i) {
        super(i);
        this.isFinal = false;
        this.isVarArgs = false;
        this.dimensions = 0;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        if (jjtGetNumChildren() > 0) {
            this.type = ((BSHType) jjtGetChild(0)).getType(callStack, interpreter);
        } else {
            this.type = UNTYPED;
        }
        if (this.isVarArgs) {
            this.type = Array.newInstance((Class<?>) this.type, 0).getClass();
        }
        return this.type;
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        if (jjtGetNumChildren() <= 0) {
            return (this.isVarArgs ? "[" : "").concat(TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.isVarArgs ? "[" : "");
        sb.append(((BSHType) jjtGetChild(0)).getTypeDescriptor(callStack, interpreter, str));
        return sb.toString();
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + this.name + ", final=" + this.isFinal + ", varargs=" + this.isVarArgs;
    }
}
