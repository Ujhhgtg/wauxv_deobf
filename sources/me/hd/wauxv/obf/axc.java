package me.hd.wauxv.obf;

import java.io.PrintStream;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class axc extends RuntimeException {
    private StringBuffer context;

    public axc(String str, Throwable th) {
        super(str == null ? th != null ? th.getMessage() : null : str, th);
        if (!(th instanceof axc)) {
            this.context = new StringBuffer(200);
            return;
        }
        String string = ((axc) th).context.toString();
        StringBuffer stringBuffer = new StringBuffer(string.length() + 200);
        this.context = stringBuffer;
        stringBuffer.append(string);
    }

    public static axc withContext(Throwable th, String str) {
        axc axcVar = th instanceof axc ? (axc) th : new axc(null, th);
        axcVar.addContext(str);
        return axcVar;
    }

    public void addContext(String str) {
        if (str == null) {
            throw new NullPointerException("str == null");
        }
        this.context.append(str);
        if (str.endsWith("\n")) {
            return;
        }
        this.context.append('\n');
    }

    public String getContext() {
        return this.context.toString();
    }

    public void printContext(PrintStream printStream) {
        printStream.println(getMessage());
        printStream.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        printStream.println(this.context);
    }

    public void printContext(PrintWriter printWriter) {
        printWriter.println(getMessage());
        printWriter.print(this.context);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        printWriter.println(this.context);
    }
}
