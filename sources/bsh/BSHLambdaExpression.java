package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHLambdaExpression extends SimpleNode {
    private Node body;
    private boolean initializedValues;
    private Modifiers[] paramsModifiers;
    private String[] paramsNames;
    private Class<?>[] paramsTypes;
    String singleParamName;

    public BSHLambdaExpression(int i) {
        super(i);
        this.initializedValues = false;
    }

    private void initValues(CallStack callStack, Interpreter interpreter) {
        if (this.initializedValues) {
            return;
        }
        if (jjtGetNumChildren() == 2) {
            BSHFormalParameters bSHFormalParameters = (BSHFormalParameters) jjtGetChild(0);
            this.paramsTypes = bSHFormalParameters.eval(callStack, interpreter);
            this.paramsModifiers = bSHFormalParameters.getParamModifiers();
            this.paramsNames = bSHFormalParameters.getParamNames();
            this.body = jjtGetChild(1);
        } else {
            this.paramsTypes = new Class[]{null};
            this.paramsModifiers = new Modifiers[]{null};
            this.paramsNames = new String[]{this.singleParamName};
            this.body = jjtGetChild(0);
        }
        this.initializedValues = true;
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) {
        initValues(callStack, interpreter);
        return BshLambda.fromLambdaExpression(this, callStack.top(), this.paramsModifiers, this.paramsTypes, this.paramsNames, this.body);
    }
}
