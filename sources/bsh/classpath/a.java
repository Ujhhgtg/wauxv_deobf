package bsh.classpath;

import bsh.classpath.BshClassPath;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ BshClassPath.UnqualifiedNameTable b;

    public /* synthetic */ a(BshClassPath.UnqualifiedNameTable unqualifiedNameTable, int i) {
        this.a = i;
        this.b = unqualifiedNameTable;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.a) {
            case 0:
                BshClassPath.lambda$buildUnqualifiedNameTable$4(this.b, (BshClassPath) obj);
                break;
            case 1:
                this.b.add((String) obj);
                break;
            default:
                this.b.add((String) obj);
                break;
        }
    }
}
