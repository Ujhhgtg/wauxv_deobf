package bsh;

import bsh.security.MainSecurityGuard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import me.hd.wauxv.obf.bqn;
import me.hd.wauxv.obf.StaticHelpers6;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Interpreter implements Runnable, Serializable, BshClassManager.Listener {
    public static boolean COMPATIBIILTY = false;
    public static boolean TRACE = false;
    public static final String VERSION = "3.0.0-eee36c8";
    private static final long serialVersionUID = 1;
    private boolean EOF;
    private boolean compatibility;
    ConsoleAssignable console;
    protected boolean evalOnly;
    private boolean exitOnEOF;
    NameSpace globalNameSpace;
    protected boolean interactive;
    Interpreter parent;
    transient Parser parser;
    private boolean showResults;
    String sourceFileInfo;
    private boolean strictJava;
    private int yield_for;
    public static final ThreadLocal<Boolean> DEBUG = ThreadLocal.withInitial(new bqn(0));
    private static final This SYSTEM_OBJECT = This.getThis(new NameSpace(null, null, "bsh.system"), null);
    public static final MainSecurityGuard mainSecurityGuard = new MainSecurityGuard();

    public Interpreter(ConsoleAssignable consoleAssignable, boolean z, NameSpace nameSpace, Interpreter interpreter, String str) {
        this.strictJava = false;
        this.yield_for = -1;
        this.exitOnEOF = true;
        this.showResults = true;
        this.compatibility = COMPATIBIILTY;
        ThreadLocal<Boolean> threadLocal = DEBUG;
        long jNanoTime = threadLocal.get().booleanValue() ? System.nanoTime() : 0L;
        this.interactive = z;
        this.parent = interpreter;
        if (interpreter != null) {
            setStrictJava(interpreter.strictJava);
            this.parser = interpreter.parser;
            this.evalOnly = interpreter.evalOnly;
        }
        this.sourceFileInfo = str;
        nameSpace = nameSpace == null ? new NameSpace(nameSpace, BshClassManager.createClassManager(this), "global") : nameSpace;
        setConsole(consoleAssignable);
        setNameSpace(nameSpace);
        getClassManager().addListener(this);
        if (threadLocal.get().booleanValue()) {
            debug("Time to initialize interpreter: interactive=", Boolean.valueOf(z), " ", Long.valueOf(System.nanoTime() - jNanoTime), " nanoseconds.");
        }
    }

    private void _yield() {
        int i = this.yield_for;
        if (i < 0) {
            return;
        }
        try {
            Thread.sleep(i);
        } catch (InterruptedException unused) {
        }
    }

    public static final void debug(Object... objArr) {
        if (DEBUG.get().booleanValue()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                sb.append(obj);
            }
            Console.debug.println("// Debug: " + sb.toString());
        }
    }

    private String getBshPrompt() {
        ThreadLocal<Boolean> threadLocal = DEBUG;
        Boolean bool = threadLocal.get();
        boolean zBooleanValue = bool.booleanValue();
        if (zBooleanValue) {
            threadLocal.set(Boolean.FALSE);
        }
        try {
            String str = (String) eval("getBshPrompt()");
            if (zBooleanValue) {
                threadLocal.set(bool);
            }
            return str;
        } catch (Exception unused) {
            if (zBooleanValue) {
                DEBUG.set(bool);
            }
            return "bsh % ";
        } catch (Throwable th) {
            if (zBooleanValue) {
                DEBUG.set(bool);
            }
            throw th;
        }
    }

    public static boolean getSaveClasses() {
        return (getSaveClassesDir() == null || getSaveClassesDir().isEmpty()) ? false : true;
    }

    public static String getSaveClassesDir() {
        return System.getProperty("bsh.debugClasses");
    }

    private JJTParserState get_jjtree() {
        return this.parser.jjtree;
    }

    private void initRootSystemObject() {
        BshClassManager classManager = getClassManager();
        setu("bsh", new NameSpace(null, classManager, "Bsh Object").getThis(this));
        This r1 = SYSTEM_OBJECT;
        setu("bsh.system", r1);
        setu("bsh.shared", r1);
        setu("bsh.help", new NameSpace(null, classManager, "Bsh Command Help Text").getThis(this));
        setu("bsh.cwd", System.getProperty("user.dir"));
        setu("bsh.interactive", this.interactive ? Primitive.TRUE : Primitive.FALSE);
        setu("bsh.evalOnly", Primitive.FALSE);
    }

    public static void invokeMain(Class<?> cls, String[] strArr) throws UtilEvalError {
        Invocable invocableResolveJavaMethod = Reflect.resolveJavaMethod(cls, "main", new Class[]{String[].class}, true);
        if (invocableResolveJavaMethod != null) {
            invocableResolveJavaMethod.invoke(null, strArr);
        }
    }

    public static void main(String[] strArr) {
        String[] strArr2;
        if (strArr.length <= 0) {
            try {
                FileReader fileReader = new FileReader(System.in);
                try {
                    CommandLineReader commandLineReader = new CommandLineReader(fileReader);
                    try {
                        new Interpreter(commandLineReader, System.out, System.err, true).run();
                        commandLineReader.close();
                        fileReader.close();
                        return;
                    } catch (Throwable th) {
                        try {
                            commandLineReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        fileReader.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                System.err.println("I/O Error closing command line reader: " + e);
                return;
            }
        }
        String str = strArr[0];
        if (strArr.length > 1) {
            strArr2 = new String[strArr.length - 1];
            System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        } else {
            strArr2 = new String[0];
        }
        try {
            Interpreter interpreter = new Interpreter();
            interpreter.setu("bsh.args", strArr2);
            Object objSource = interpreter.source(str, interpreter.globalNameSpace);
            if (objSource instanceof Class) {
                try {
                    invokeMain((Class) objSource, strArr2);
                } catch (Exception e2) {
                    e = e2;
                    if (e instanceof InvocationTargetException) {
                        e = e.getCause();
                    }
                    System.err.println("Class: " + objSource + " main method threw exception:" + e);
                }
            }
        } catch (TargetError e3) {
            System.err.println("Script threw exception: " + e3);
            if (e3.inNativeCode()) {
                e3.printStackTrace(DEBUG.get().booleanValue(), System.err);
            }
        } catch (EvalError e4) {
            System.err.println("Evaluation Error: " + e4);
        } catch (FileNotFoundException e5) {
            System.err.println("File not found: " + e5);
        } catch (IOException e6) {
            System.err.println("I/O Error: " + e6);
        }
    }

    private boolean readLine() throws ParseException {
        try {
            return this.parser.Line();
        } catch (ParseException e) {
            _yield();
            if (this.EOF) {
                return true;
            }
            throw e;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setOut(System.out);
        setErr(System.err);
    }

    public static void redirectOutputToFile(String str) {
        try {
            PrintStream printStream = new PrintStream((OutputStream) new FileOutputStream(str), true, "UTF-8");
            System.setOut(printStream);
            System.setErr(printStream);
        } catch (IOException unused) {
            System.err.println("Can't redirect output to file: " + str);
        }
    }

    public static void setShutdownOnExit(boolean z) {
        try {
            SYSTEM_OBJECT.getNameSpace().setVariable("shutdownOnExit", Boolean.valueOf(z), false);
        } catch (UtilEvalError e) {
            throw new IllegalStateException(e);
        }
    }

    public static void staticInit() {
        try {
            Console.systemLineSeparator = System.getProperty("line.separator");
            Console.debug = System.err;
            DEBUG.set(Boolean.valueOf(Boolean.getBoolean("debug")));
            TRACE = Boolean.getBoolean("trace");
            COMPATIBIILTY = Boolean.getBoolean("bsh.compatibility");
            String property = System.getProperty("outfile");
            if (property != null) {
                redirectOutputToFile(property);
            }
        } catch (SecurityException e) {
            System.err.println("Could not init static:" + e);
        } catch (Exception e2) {
            System.err.println("Could not init static(2):" + e2);
        } catch (Throwable th) {
            System.err.println("Could not init static(3):" + th);
        }
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        Reflect.instanceCache.clear();
    }

    public final void error(Object obj) {
        this.console.error(obj);
    }

    public Object eval(Reader reader, NameSpace nameSpace, String str) {
        debug("eval: nameSpace = ", nameSpace);
        Interpreter interpreter = new Interpreter(reader, getOut(), getErr(), false, nameSpace, this, str);
        CallStack callStack = new CallStack(nameSpace);
        Object objEval = null;
        boolean line = false;
        Node nodeRootNode = null;
        while (!line) {
            try {
                try {
                    try {
                        try {
                            line = interpreter.readLine();
                            if (interpreter.get_jjtree().nodeArity() > 0) {
                                nodeRootNode = interpreter.get_jjtree().rootNode();
                                nodeRootNode.setSourceFile(str);
                                if (TRACE) {
                                    println("// " + nodeRootNode.getText());
                                }
                                objEval = nodeRootNode.eval(callStack, interpreter);
                                if (callStack.depth() > 1) {
                                    throw new InterpreterError("Callstack growing: " + callStack);
                                }
                                if (objEval instanceof ReturnControl) {
                                    objEval = ((ReturnControl) objEval).value;
                                    interpreter.get_jjtree().reset();
                                    if (callStack.depth() <= 1) {
                                        break;
                                    }
                                    callStack.clear();
                                    callStack.push(nameSpace);
                                    break;
                                }
                            }
                            interpreter.get_jjtree().reset();
                            if (callStack.depth() > 1) {
                                callStack.clear();
                                callStack.push(nameSpace);
                            }
                        } catch (InterpreterError e) {
                            throw new EvalError("Sourced file: " + str + " internal Error: " + e.getMessage(), nodeRootNode, callStack, e);
                        } catch (ParseException e2) {
                            ThreadLocal<Boolean> threadLocal = DEBUG;
                            if (threadLocal.get().booleanValue()) {
                                error(e2.getMessage(threadLocal.get().booleanValue()));
                            }
                            e2.setErrorSourceFile(str);
                            throw e2;
                        }
                    } catch (EvalError e3) {
                        if (DEBUG.get().booleanValue()) {
                            e3.printStackTrace();
                        }
                        if (e3.getNode() == null) {
                            e3.setNode(nodeRootNode);
                        }
                        throw e3.reThrow("Sourced file: " + str);
                    } catch (TokenMgrException e4) {
                        throw new EvalError("Sourced file: " + str + " Token Parsing Error: " + e4.getMessage(), nodeRootNode, callStack, e4);
                    }
                } catch (TargetError e5) {
                    if (e5.getNode() == null) {
                        e5.setNode(nodeRootNode);
                    }
                    throw e5.reThrow("Sourced file: " + str);
                } catch (Exception e6) {
                    if (DEBUG.get().booleanValue()) {
                        e6.printStackTrace();
                    }
                    throw new EvalError("Sourced file: " + str + " unknown error: " + e6.getMessage(), nodeRootNode, callStack, e6);
                }
            } catch (Throwable th) {
                interpreter.get_jjtree().reset();
                if (callStack.depth() <= 1) {
                    throw th;
                }
                callStack.clear();
                callStack.push(nameSpace);
                throw th;
            }
        }
        return Primitive.unwrap(objEval);
    }

    public Object get(String str) throws EvalError {
        try {
            return Primitive.unwrap(this.globalNameSpace.get(str, this));
        } catch (UtilEvalError e) {
            throw e.toEvalError(Node.JAVACODE, new CallStack());
        }
    }

    public BshClassManager getClassManager() {
        return getNameSpace().getClassManager();
    }

    public boolean getCompatibility() {
        return this.compatibility;
    }

    public PrintStream getErr() {
        return this.console.getErr();
    }

    public Reader getIn() {
        return this.console.getIn();
    }

    public Object getInterface(Class<?> cls) {
        return this.globalNameSpace.getThis(this).getInterface(cls);
    }

    public NameSpace getNameSpace() {
        return this.globalNameSpace;
    }

    public PrintStream getOut() {
        return this.console.getOut();
    }

    public Interpreter getParent() {
        return this.parent;
    }

    public boolean getShowResults() {
        return this.showResults;
    }

    public String getSourceFileInfo() {
        String str = this.sourceFileInfo;
        return str != null ? str : "<unknown source>";
    }

    public boolean getStrictJava() {
        return this.strictJava;
    }

    public Object getu(String str) {
        try {
            return get(str);
        } catch (EvalError e) {
            throw new InterpreterError("set: " + e, e);
        }
    }

    public void loadRCFiles() {
        try {
            source(System.getProperty("user.home") + File.separator + ".bshrc", this.globalNameSpace);
        } catch (Exception e) {
            debug("Could not find rc file: ", e);
        }
    }

    public File pathToFile(String str) {
        String str2 = (String) getu("bsh.cwd");
        File file = new File(str);
        if (!file.isAbsolute()) {
            file = new File(yg.concatToVar1(StaticHelpers6.toSb(str2), File.separator, str));
        }
        return new File(file.getCanonicalPath());
    }

    public final void print(Object obj) {
        this.console.print(obj);
    }

    public final void println(Object obj) {
        this.console.println(obj);
    }

    public void reset() {
        getClassManager().reset();
        this.globalNameSpace.clear();
        Name.clearParts();
        Reflect.instanceCache.clear();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.evalOnly) {
            throw new RuntimeException("bsh Interpreter: No stream");
        }
        if (this.interactive && getParent() == null) {
            try {
                eval("printBanner();");
            } catch (EvalError unused) {
                println("BeanShell 3.0.0-eee36c8");
            }
        }
        CallStack callStack = new CallStack(this.globalNameSpace);
        this.EOF = false;
        int i = -1;
        while (!Thread.interrupted() && !this.EOF) {
            try {
                try {
                    try {
                        try {
                            try {
                                if (this.interactive) {
                                    this.console.prompt(getBshPrompt());
                                }
                                this.EOF = readLine();
                                if (get_jjtree().nodeArity() > 0) {
                                    Node nodeRootNode = get_jjtree().rootNode();
                                    nodeRootNode.setSourceFile(this.sourceFileInfo);
                                    if (DEBUG.get().booleanValue()) {
                                        nodeRootNode.dump(">");
                                    }
                                    if (TRACE) {
                                        println("// " + nodeRootNode.getText());
                                    }
                                    Object objEval = nodeRootNode.eval(callStack, this);
                                    if (callStack.depth() > 1) {
                                        throw new InterpreterError("Callstack growing: " + callStack);
                                    }
                                    if (objEval instanceof ReturnControl) {
                                        objEval = ((ReturnControl) objEval).value;
                                    }
                                    if (this.interactive) {
                                        if (objEval != Primitive.VOID) {
                                            setu("$_", objEval);
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("$");
                                            i++;
                                            sb.append(i % 10);
                                            setu(sb.toString(), objEval);
                                            if (this.showResults) {
                                                println("--> $" + (i % 10) + " = " + StringUtil.typeValueString(objEval));
                                            }
                                        } else if (this.showResults) {
                                            println("--> void");
                                        }
                                    }
                                }
                                get_jjtree().reset();
                            } catch (ParseException e) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Parser Error: ");
                                ThreadLocal<Boolean> threadLocal = DEBUG;
                                sb2.append(e.getMessage(threadLocal.get().booleanValue()));
                                error(sb2.toString());
                                if (threadLocal.get().booleanValue()) {
                                    e.printStackTrace();
                                }
                                if (!this.interactive) {
                                    this.EOF = true;
                                }
                                this.parser.reInitInput(getIn());
                                get_jjtree().reset();
                                if (callStack.depth() > 1) {
                                }
                            }
                        } catch (InterpreterError e2) {
                            error("Internal Error: " + e2.getMessage());
                            if (!this.interactive) {
                                this.EOF = true;
                            }
                            get_jjtree().reset();
                            if (callStack.depth() > 1) {
                            }
                        }
                    } catch (TargetError e3) {
                        error("Target Exception: " + e3.getMessage());
                        if (e3.inNativeCode()) {
                            e3.printStackTrace(DEBUG.get().booleanValue(), getErr());
                        }
                        if (!this.interactive) {
                            this.EOF = true;
                        }
                        setu("$_e", e3.getTarget());
                        get_jjtree().reset();
                        if (callStack.depth() > 1) {
                        }
                    } catch (Exception e4) {
                        error("Unknown error: " + e4);
                        if (DEBUG.get().booleanValue()) {
                            e4.printStackTrace();
                        }
                        if (!this.interactive) {
                            this.EOF = true;
                        }
                        get_jjtree().reset();
                        if (callStack.depth() > 1) {
                        }
                    }
                } catch (EvalError e5) {
                    if (this.interactive) {
                        error("Evaluation Error: " + e5.getMessage());
                    } else {
                        error("Evaluation Error: " + e5.getRawMessage());
                    }
                    if (DEBUG.get().booleanValue()) {
                        e5.printStackTrace();
                    }
                    if (!this.interactive) {
                        this.EOF = true;
                    }
                    get_jjtree().reset();
                    if (callStack.depth() > 1) {
                    }
                } catch (TokenMgrException e6) {
                    error("Error parsing input: " + e6);
                    this.parser.reInitTokenInput(getIn());
                    if (!this.interactive) {
                        this.EOF = true;
                    }
                    get_jjtree().reset();
                    if (callStack.depth() > 1) {
                    }
                }
                if (callStack.depth() > 1) {
                    callStack.clear();
                    callStack.push(this.globalNameSpace);
                }
            } catch (Throwable th) {
                get_jjtree().reset();
                if (callStack.depth() > 1) {
                    callStack.clear();
                    callStack.push(this.globalNameSpace);
                }
                throw th;
            }
        }
        if (this.interactive && this.exitOnEOF) {
            System.exit(0);
        }
    }

    public void set(String str, Object obj) throws EvalError {
        CallStack callStack = new CallStack(this.globalNameSpace);
        try {
            if (Name.isCompound(str)) {
                this.globalNameSpace.getNameResolver(str).toLHS(callStack, this).assign(obj, false);
            } else {
                this.globalNameSpace.setVariable(str, obj, false);
            }
        } catch (UtilEvalError e) {
            throw e.toEvalError(Node.JAVACODE, callStack);
        }
    }

    public void setClassLoader(ClassLoader classLoader) {
        getClassManager().setClassLoader(classLoader);
    }

    public void setCompatibility(boolean z) {
        this.compatibility = z;
    }

    public void setConsole(ConsoleAssignable consoleAssignable) {
        Interpreter interpreter;
        this.console = consoleAssignable;
        if (this.parser == null || get_jjtree().nodeArity() != 0 || ((interpreter = this.parent) != null && interpreter.interactive)) {
            this.parser = new Parser(getIn());
        } else {
            this.parser.ReInit(getIn());
        }
    }

    public void setErr(PrintStream printStream) {
        this.console.setErr(printStream);
    }

    public void setExitOnEOF(boolean z) {
        this.exitOnEOF = z;
    }

    public void setIn(Reader reader) {
        this.console.setIn(reader);
    }

    public void setNameSpace(NameSpace nameSpace) {
        this.globalNameSpace = nameSpace;
        if (nameSpace != null) {
            try {
                if (nameSpace.getVariable("bsh") instanceof This) {
                    return;
                }
                initRootSystemObject();
                if (this.interactive) {
                    loadRCFiles();
                }
            } catch (UtilEvalError e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void setOut(PrintStream printStream) {
        this.console.setOut(printStream);
    }

    public void setShowResults(boolean z) {
        this.showResults = z;
    }

    public void setStrictJava(boolean z) {
        this.strictJava = z;
    }

    public void setYieldDelay(int i) {
        this.yield_for = i;
    }

    public void setu(String str, Object obj) {
        try {
            set(str, obj);
        } catch (EvalError e) {
            throw new InterpreterError("set: " + e, e);
        }
    }

    public String showEvalString(String str, String str2) {
        if (str2.length() > 80) {
            str2 = str2.substring(0, 80) + " . . . ";
        }
        return str.concat(" of: ``").concat(str2.replace('\n', ' ').replace('\r', ' ')).concat("''");
    }

    /* JADX WARN: Undo finally extract visitor
    jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [PREMATURE_EXIT B:26:0x001b -> B:8:0x002a] - Handler: None
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    public Object source(URL url, NameSpace nameSpace) throws IOException {
        debug("Sourcing file: ", url.toString());
        FileReader fileReader = new FileReader(url.openStream());
        try {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                Object objEval = eval(bufferedReader, nameSpace, url.toString());
                bufferedReader.close();
                fileReader.close();
                return objEval;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                fileReader.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public String terminatedScript(String str) {
        return str.endsWith(";") ? str : str.concat(";");
    }

    public void unset(String str) throws EvalError {
        try {
            LHS lhs = this.globalNameSpace.getNameResolver(str).toLHS(new CallStack(), this);
            if (lhs.type == 0) {
                lhs.nameSpace.unsetVariable(lhs.getName());
            } else {
                throw new EvalError("Can't unset, not a variable: " + str, Node.JAVACODE, new CallStack());
            }
        } catch (UtilEvalError e) {
            throw new EvalError(e.getMessage(), Node.JAVACODE, new CallStack(), e);
        }
    }

    public void setConsole(ConsoleInterface consoleInterface) {
        setConsole((ConsoleAssignable) new Console(consoleInterface));
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static class Console implements ConsoleAssignable, Serializable {
        public static transient PrintStream debug = System.err;
        private static final long serialVersionUID = 1;
        public static String systemLineSeparator = "\n";
        private ConsoleInterface console;
        private transient PrintStream err;
        private transient Reader in;
        private transient PrintStream out;

        public Console(ConsoleInterface consoleInterface) {
            this.console = consoleInterface;
            this.in = consoleInterface.getIn();
            this.out = consoleInterface.getOut();
            PrintStream err = consoleInterface.getErr();
            this.err = err;
            debug = err;
        }

        @Override // bsh.ConsoleInterface
        public void error(Object obj) {
            ConsoleInterface consoleInterface = this.console;
            if (consoleInterface != null) {
                consoleInterface.error("// Error: " + obj + systemLineSeparator);
                return;
            }
            if (this.out != null) {
                println("// Error: " + obj);
            }
        }

        @Override // bsh.ConsoleInterface
        public PrintStream getErr() {
            if (this.err == null) {
                this.err = System.err;
            }
            return this.err;
        }

        @Override // bsh.ConsoleInterface
        public Reader getIn() {
            return this.in;
        }

        @Override // bsh.ConsoleInterface
        public PrintStream getOut() {
            if (this.out == null) {
                this.out = System.out;
            }
            return this.out;
        }

        @Override // bsh.ConsoleInterface
        public void print(Object obj) {
            ConsoleInterface consoleInterface = this.console;
            if (consoleInterface != null) {
                consoleInterface.print(obj);
                return;
            }
            PrintStream printStream = this.out;
            if (printStream != null) {
                printStream.print(obj);
                this.out.flush();
            }
        }

        @Override // bsh.ConsoleInterface
        public void println(Object obj) {
            ConsoleInterface consoleInterface = this.console;
            if (consoleInterface != null) {
                consoleInterface.println(obj);
                return;
            }
            print(obj + systemLineSeparator);
        }

        @Override // bsh.ConsoleInterface
        public void prompt(String str) {
            ConsoleInterface consoleInterface = this.console;
            if (consoleInterface != null) {
                consoleInterface.prompt(str);
            } else {
                print(str);
            }
        }

        @Override // bsh.ConsoleAssignable
        public void setErr(PrintStream printStream) {
            this.err = printStream;
        }

        @Override // bsh.ConsoleAssignable
        public void setIn(Reader reader) {
            this.in = reader;
        }

        @Override // bsh.ConsoleAssignable
        public void setOut(PrintStream printStream) {
            this.out = printStream;
        }

        public Console(Reader reader, PrintStream printStream, PrintStream printStream2) {
            this.console = null;
            this.in = reader;
            this.out = printStream;
            this.err = printStream2;
            debug = printStream2;
        }
    }

    public void set(String str, long j) throws EvalError {
        set(str, new Primitive(j));
    }

    public Object source(File file, NameSpace nameSpace) throws IOException {
        debug("Sourcing file: ", file);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            return eval(bufferedReader, nameSpace, file.getPath());
        } finally {
            bufferedReader.close();
        }
    }

    public void set(String str, int i) throws EvalError {
        set(str, new Primitive(i));
    }

    public void set(String str, double d) throws EvalError {
        set(str, new Primitive(d));
    }

    public void set(String str, float f) throws EvalError {
        set(str, new Primitive(f));
    }

    public void set(String str, boolean z) throws EvalError {
        set(str, z ? Primitive.TRUE : Primitive.FALSE);
    }

    public Object source(String str, NameSpace nameSpace) {
        return source(pathToFile(str), nameSpace);
    }

    public Object source(URL url) {
        return source(url, this.globalNameSpace);
    }

    public Object source(File file) {
        return source(file, this.globalNameSpace);
    }

    public Object source(String str) {
        return source(str, this.globalNameSpace);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z, NameSpace nameSpace, Interpreter interpreter, String str) {
        this(new Console(reader, printStream, printStream2), z, nameSpace, interpreter, str);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z, NameSpace nameSpace) {
        this(reader, printStream, printStream2, z, nameSpace, null, null);
    }

    public Interpreter(Reader reader, PrintStream printStream, PrintStream printStream2, boolean z) {
        this(reader, printStream, printStream2, z, (NameSpace) null);
    }

    public Interpreter(ConsoleInterface consoleInterface, NameSpace nameSpace, Interpreter interpreter) {
        this((ConsoleAssignable) new Console(consoleInterface), true, nameSpace, interpreter, interpreter == null ? null : interpreter.sourceFileInfo);
    }

    public Interpreter(ConsoleInterface consoleInterface, Interpreter interpreter) {
        this(consoleInterface, interpreter.globalNameSpace, interpreter);
    }

    public Interpreter(ConsoleInterface consoleInterface, NameSpace nameSpace) {
        this(consoleInterface, nameSpace, (Interpreter) null);
    }

    public Interpreter(ConsoleInterface consoleInterface) {
        this(consoleInterface, (NameSpace) null, (Interpreter) null);
    }

    public Interpreter() {
        this((NameSpace) null, (Interpreter) null, "");
        this.sourceFileInfo = null;
    }

    public Interpreter(NameSpace nameSpace) {
        this(nameSpace, (Interpreter) null, (String) null);
    }

    public Interpreter(NameSpace nameSpace, String str) {
        this(nameSpace, (Interpreter) null, str);
    }

    public Interpreter(NameSpace nameSpace, Interpreter interpreter) {
        this(nameSpace, interpreter, (String) null);
    }

    public Interpreter(NameSpace nameSpace, Interpreter interpreter, String str) {
        this(null, System.out, System.err, false, nameSpace, interpreter, str);
        this.evalOnly = true;
        setu("bsh.evalOnly", Primitive.TRUE);
    }

    public Interpreter(Interpreter interpreter) {
        this(interpreter.console, interpreter.interactive, interpreter.globalNameSpace, interpreter, interpreter.sourceFileInfo);
    }

    public Object eval(Reader reader) {
        NameSpace nameSpace = this.globalNameSpace;
        String str = this.sourceFileInfo;
        if (str == null) {
            str = "eval stream";
        }
        return eval(reader, nameSpace, str);
    }

    public Object eval(String str) {
        debug("eval(String): ", str);
        return eval(str, this.globalNameSpace, "Memory");
    }

    public Object eval(String str, String str2) {
        debug("eval(String,String): ", str, str2);
        return eval(str, this.globalNameSpace, str2);
    }

    public Object eval(String str, NameSpace nameSpace, String str2) {
        return eval(new StringReader(terminatedScript(str)), nameSpace, str2);
    }
}
