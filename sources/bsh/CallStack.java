package bsh;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CallStack implements Serializable {
    private static final long serialVersionUID = 1;
    private final Stack<NameSpace> stack = new Stack<>();

    public CallStack() {
    }

    public void clear() {
        this.stack.clear();
    }

    public CallStack copy() {
        CallStack callStack = new CallStack();
        callStack.stack.addAll(this.stack);
        return callStack;
    }

    public int depth() {
        return this.stack.size();
    }

    public NameSpace get(int i) {
        int size = this.stack.size();
        return i >= size ? NameSpace.JAVACODE : ((NameSpace[]) this.stack.toArray(new NameSpace[size]))[(size - 1) - i];
    }

    public NameSpace pop() {
        try {
            return this.stack.pop();
        } catch (EmptyStackException unused) {
            throw new InterpreterError("pop on empty CallStack");
        }
    }

    public void push(NameSpace nameSpace) {
        this.stack.push(nameSpace);
    }

    public synchronized void set(int i, NameSpace nameSpace) {
        this.stack.set((r0.size() - 1) - i, nameSpace);
    }

    public NameSpace swap(NameSpace nameSpace) {
        NameSpace nameSpacePop = this.stack.pop();
        this.stack.push(nameSpace);
        return nameSpacePop;
    }

    public synchronized String toString() {
        StringBuilder sb;
        try {
            sb = new StringBuilder();
            sb.append("CallStack:\n");
            for (int size = this.stack.size() - 1; size >= 0; size += -1) {
                sb.append("\t" + this.stack.get(size) + "\n");
            }
        } catch (Throwable th) {
            throw th;
        }
        return sb.toString();
    }

    public NameSpace top() {
        return this.stack.peek();
    }

    public CallStack(NameSpace nameSpace) {
        push(nameSpace);
    }
}
