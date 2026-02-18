package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ua {
    public int b;
    public Object c;

    public ua(int i, boolean z) {
        switch (i) {
            case 2:
                this.c = new long[8];
                this.b = -1;
                break;
            default:
                this.c = new km();
                break;
        }
    }

    public long _br() {
        int i = this.b;
        if (i == -1) {
            return 19500L;
        }
        return ((long[]) this.c)[i];
    }

    public abstract void _bs();

    public abstract void _bt();

    public abstract evr _bu(evr evrVar, List list);

    public but _bv(but butVar) {
        return butVar;
    }

    public long _bw() {
        int i = this.b;
        if (i < 0) {
            throw new dgb("No tag in stack for requested element");
        }
        long[] jArr = (long[]) this.c;
        this.b = i - 1;
        return jArr[i];
    }

    public long _bx() {
        int i = this.b;
        if (i == -1) {
            return 19500L;
        }
        long[] jArr = (long[]) this.c;
        this.b = i - 1;
        return jArr[i];
    }

    public void _by(long j) {
        if (j == 19500) {
            return;
        }
        int i = this.b + 1;
        this.b = i;
        long[] jArr = (long[]) this.c;
        if (i >= jArr.length) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length * 2);
            bzo.p(jArrCopyOf, "copyOf(...)");
            this.c = jArrCopyOf;
        }
        ((long[]) this.c)[i] = j;
    }

    public ua(CodeEditor codeEditor) {
        System.currentTimeMillis();
        Objects.requireNonNull(codeEditor);
        this.c = codeEditor;
        this.b = 0;
    }

    public ua(int i) {
        this.b = i;
    }
}
