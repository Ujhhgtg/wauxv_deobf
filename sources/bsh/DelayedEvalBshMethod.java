package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DelayedEvalBshMethod extends BshMethod {
    private static final long serialVersionUID = 1;
    private BSHArguments argsNode;
    transient CallStack callstack;
    private Invocable constructor;
    private Object[] constructorArgs;
    transient Interpreter interpreter;
    String[] paramTypeDescriptors;
    BSHFormalParameters paramTypesNode;
    String returnTypeDescriptor;
    BSHReturnType returnTypeNode;

    public DelayedEvalBshMethod(String str, String str2, BSHReturnType bSHReturnType, String[] strArr, String[] strArr2, BSHFormalParameters bSHFormalParameters, BSHBlock bSHBlock, NameSpace nameSpace, Modifiers modifiers, boolean z, CallStack callStack, Interpreter interpreter) {
        super(str, null, strArr, null, null, bSHBlock, nameSpace, modifiers, z);
        this.argsNode = null;
        this.constructor = null;
        this.constructorArgs = null;
        this.returnTypeDescriptor = str2;
        this.returnTypeNode = bSHReturnType;
        this.paramTypeDescriptors = strArr2;
        this.paramTypesNode = bSHFormalParameters;
        this.callstack = callStack;
        this.interpreter = interpreter;
    }

    @Override // bsh.BshMethod
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        DelayedEvalBshMethod delayedEvalBshMethod = (DelayedEvalBshMethod) obj;
        if (!getName().equals(delayedEvalBshMethod.getName()) || getParameterCount() != delayedEvalBshMethod.getParameterCount()) {
            return false;
        }
        for (int i = 0; i < getParamTypeDescriptors().length; i++) {
            if (!BshMethod.equal(getParamTypeDescriptors()[i], delayedEvalBshMethod.getParamTypeDescriptors()[i])) {
                return false;
            }
        }
        return this.isVarArgs == delayedEvalBshMethod.isVarArgs;
    }

    public String getAltConstructor() {
        boolean z;
        if (this.constructor != null) {
            return "super";
        }
        if (this.methodBody.jjtGetNumChildren() == 0) {
            return null;
        }
        Node nodeJjtGetChild = this.methodBody.jjtGetChild(0);
        while (true) {
            z = nodeJjtGetChild instanceof BSHMethodInvocation;
            if (z || nodeJjtGetChild.jjtGetNumChildren() <= 0) {
                break;
            }
            nodeJjtGetChild = nodeJjtGetChild.jjtGetChild(0);
        }
        if (z) {
            BSHMethodInvocation bSHMethodInvocation = (BSHMethodInvocation) nodeJjtGetChild;
            String str = bSHMethodInvocation.getNameNode().text;
            if (str.equals("super") || str.equals("this")) {
                this.argsNode = bSHMethodInvocation.getArgsNode();
                return str;
            }
        }
        return null;
    }

    public BSHArguments getArgsNode() {
        return this.argsNode;
    }

    public Object[] getConstructorArgs() {
        return this.constructorArgs;
    }

    public String[] getParamTypeDescriptors() {
        return this.paramTypeDescriptors;
    }

    @Override // bsh.BshMethod
    public Class<?>[] getParameterTypes() {
        Invocable invocable = this.constructor;
        if (invocable != null) {
            return invocable.getParameterTypes();
        }
        try {
            return this.paramTypesNode.eval(this.callstack, this.interpreter);
        } catch (EvalError e) {
            throw new InterpreterError("can't eval param types: " + e, e);
        }
    }

    @Override // bsh.BshMethod
    public Class<?> getReturnType() {
        BSHReturnType bSHReturnType = this.returnTypeNode;
        if (bSHReturnType == null) {
            return null;
        }
        try {
            return bSHReturnType.evalReturnType(this.callstack, this.interpreter);
        } catch (EvalError e) {
            throw new InterpreterError("can't eval return type: " + e, e);
        }
    }

    public String getReturnTypeDescriptor() {
        return this.returnTypeDescriptor;
    }

    @Override // bsh.BshMethod
    public int hashCode() {
        int iHashCode = getClass().hashCode() + getName().hashCode();
        String[] paramTypeDescriptors = getParamTypeDescriptors();
        int length = paramTypeDescriptors.length;
        for (int i = 0; i < length; i++) {
            String str = paramTypeDescriptors[i];
            iHashCode += (str == null ? 0 : str.hashCode()) + 3;
        }
        return getParameterCount() + iHashCode;
    }

    public DelayedEvalBshMethod(String str, Invocable invocable, NameSpace nameSpace) {
        this(str, invocable.getReturnTypeDescriptor(), null, new String[invocable.getParameterCount()], invocable.getParamTypeDescriptors(), null, new BSHBlock(0), nameSpace, null, invocable.isVarArgs(), null, null);
        this.constructor = invocable;
        this.modifiers = new Modifiers(5);
        getModifiers().addModifier("public");
        getParameterModifiers();
        nameSpace.setMethod(this);
        this.constructorArgs = This.CONTEXT_ARGS.get().remove(str);
    }
}
