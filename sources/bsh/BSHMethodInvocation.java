package bsh;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHMethodInvocation extends SimpleNode {
    public BSHMethodInvocation(int i) {
        super(i);
    }

    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws EvalError {
        NameSpace pVar = callStack.top();
        BSHAmbiguousName nameNode = getNameNode();
        if ("fail".equals(nameNode.text)) {
            interpreter.getNameSpace().setNode(this);
        }
        if (pVar.getParent() != null && pVar.getParent().isClass && (nameNode.text.equals("super") || nameNode.text.equals("this"))) {
            return Primitive.VOID;
        }
        Name name = nameNode.getName(pVar);
        try {
            return name.invokeMethod(interpreter, getArgsNode().getArguments(callStack, interpreter), callStack, this);
        } catch (ReflectError e) {
            throw new EvalException("Error in method invocation: " + e.getMessage(), this, callStack, e);
        } catch (UtilEvalError e2) {
            throw e2.toEvalError(this, callStack);
        } catch (InvocationTargetException e3) {
            throw Reflect.targetErrorFromTargetException(e3, name.toString(), callStack, this);
        }
    }

    public BSHArguments getArgsNode() {
        return (BSHArguments) jjtGetChild(1);
    }

    public BSHAmbiguousName getNameNode() {
        return (BSHAmbiguousName) jjtGetChild(0);
    }
}
