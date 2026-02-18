package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class awv extends ahj {
    public long x;
    public boolean y;
    public km z;

    public final void aa() {
        long j = this.x - 4294967296L;
        this.x = j;
        if (j <= 0 && this.y) {
            shutdown();
        }
    }

    public final void ab(boolean z) {
        this.x = (z ? 4294967296L : 1L) + this.x;
        if (z) {
            return;
        }
        this.y = true;
    }

    public final boolean ac() {
        km kmVar = this.z;
        if (kmVar == null) {
            return false;
        }
        aot aotVar = (aot) (kmVar.isEmpty() ? null : kmVar.removeFirst());
        if (aotVar == null) {
            return false;
        }
        aotVar.run();
        return true;
    }

    public abstract Thread g();

    public void m(long j, aws awsVar) {
        akk.f.w(j, awsVar);
    }

    public abstract void shutdown();
}
