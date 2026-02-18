package me.hd.wauxv.obf;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sb {
    public final ArrayDeque a;

    public sb(int i) {
        switch (i) {
            case 1:
                this.a = new ArrayDeque();
                break;
            default:
                char[] cArr = eot.a;
                this.a = new ArrayDeque(0);
                break;
        }
    }

    public synchronized void b(bhj bhjVar) {
        bhjVar.b = null;
        bhjVar.c = null;
        this.a.offer(bhjVar);
    }
}
