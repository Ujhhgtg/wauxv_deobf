package bsh;

import bsh.BshClassManager;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHFormalParameters extends SimpleNode implements BshClassManager.Listener {
    boolean isVarArgs;
    private boolean listener;
    int numArgs;
    private Modifiers[] paramModifiers;
    private String[] paramNames;
    Class<?>[] paramTypes;
    String[] typeDescriptors;

    public BSHFormalParameters(int i) {
        super(i);
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        this.paramTypes = null;
    }

    public Modifiers[] getParamModifiers() {
        insureParsed();
        return this.paramModifiers;
    }

    public String[] getParamNames() {
        insureParsed();
        return this.paramNames;
    }

    public String[] getTypeDescriptors(CallStack callStack, Interpreter interpreter, String str) {
        String[] strArr = this.typeDescriptors;
        if (strArr != null) {
            return strArr;
        }
        insureParsed();
        String[] strArr2 = new String[this.numArgs];
        for (int i = 0; i < this.numArgs; i++) {
            strArr2[i] = ((BSHFormalParameter) jjtGetChild(i)).getTypeDescriptor(callStack, interpreter, str);
        }
        this.typeDescriptors = strArr2;
        return strArr2;
    }

    public void insureParsed() {
        if (this.paramNames != null) {
            return;
        }
        int iJjtGetNumChildren = jjtGetNumChildren();
        this.numArgs = iJjtGetNumChildren;
        String[] strArr = new String[iJjtGetNumChildren];
        Modifiers[] modifiersArr = new Modifiers[iJjtGetNumChildren];
        for (int i = 0; i < this.numArgs; i++) {
            BSHFormalParameter bSHFormalParameter = (BSHFormalParameter) jjtGetChild(i);
            this.isVarArgs = bSHFormalParameter.isVarArgs;
            strArr[i] = bSHFormalParameter.name;
            Modifiers modifiers = new Modifiers(4);
            modifiersArr[i] = modifiers;
            if (bSHFormalParameter.isFinal) {
                modifiers.addModifier("final");
            }
        }
        this.paramNames = strArr;
        this.paramModifiers = modifiersArr;
    }

    public boolean isListener() {
        return this.listener;
    }

    public void setListener(boolean z) {
        this.listener = z;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Class<?>[] eval(CallStack callStack, Interpreter interpreter) {
        Class<?>[] clsArr = this.paramTypes;
        if (clsArr != null) {
            return clsArr;
        }
        insureParsed();
        Class<?>[] clsArr2 = new Class[this.numArgs];
        for (int i = 0; i < this.numArgs; i++) {
            clsArr2[i] = (Class) ((BSHFormalParameter) jjtGetChild(i)).eval(callStack, interpreter);
        }
        this.paramTypes = clsArr2;
        return clsArr2;
    }
}
