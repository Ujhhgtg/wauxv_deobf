package me.hd.wauxv.obf;

import io.github.rosemoe.sora.widget.CodeEditor;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y implements btr {
    public static final ThreadPoolExecutor a = new ThreadPoolExecutor(2, Math.max(2, Runtime.getRuntime().availableProcessors()), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(128));
    public CodeEditor b;
    public aff c;

    public y(CodeEditor codeEditor, aff affVar) {
        this.b = codeEditor;
        this.c = affVar;
    }

    public final void d() {
        this.b.getInlayHints();
        List list = Collections.EMPTY_LIST;
    }
}
