package bsh;

import java.io.PrintStream;
import java.io.StringReader;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class PreparsedScript {
    private final Interpreter interpreter;
    private final BshMethod prepared;

    public PreparsedScript(String str) {
        this(str, getDefaultClassLoader());
    }

    private static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException unused) {
            classLoader = null;
        }
        if (classLoader == null) {
            classLoader = PreparsedScript.class.getClassLoader();
        }
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }

    public Object invoke(Map<String, ?> map) throws EvalError {
        Interpreter interpreter = this.interpreter;
        NameSpace nameSpace = new NameSpace(interpreter.globalNameSpace, interpreter.getClassManager(), "BeanshellExecutable");
        nameSpace.isMethod = true;
        Interpreter interpreter2 = new Interpreter(nameSpace, this.interpreter);
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            interpreter2.set(entry.getKey(), entry.getValue());
        }
        return Primitive.unwrap(this.prepared.invoke(Reflect.ZERO_ARGS, interpreter2, new CallStack(nameSpace), Node.JAVACODE, true));
    }

    public void setErr(PrintStream printStream) {
        this.interpreter.setErr(printStream);
    }

    public void setOut(PrintStream printStream) {
        this.interpreter.setOut(printStream);
    }

    public PreparsedScript(String str, ClassLoader classLoader) {
        Interpreter interpreter = new Interpreter();
        this.interpreter = interpreter;
        interpreter.setClassLoader(classLoader);
        try {
            this.prepared = ((This) interpreter.eval(new StringReader("__execute() {" + interpreter.terminatedScript(str) + "} return this;"), interpreter.globalNameSpace, interpreter.showEvalString("pre-parsed script", str))).getNameSpace().getMethod("__execute", Reflect.ZERO_TYPES, false);
        } catch (UtilEvalError e) {
            throw new IllegalStateException(e);
        }
    }
}
