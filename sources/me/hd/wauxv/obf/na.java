package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class na extends add {
    public int a;
    public int c;
    public nb d;

    @Override // me.hd.wauxv.obf.add
    public final void b(adq adqVar, boolean z) {
        int i = this.a;
        this.c = i;
        if (z) {
            if (i == 5) {
                this.c = 1;
            } else if (i == 6) {
                this.c = 0;
            }
        } else if (i == 5) {
            this.c = 0;
        } else if (i == 6) {
            this.c = 1;
        }
        if (adqVar instanceof nb) {
            ((nb) adqVar).a = this.c;
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.d.b;
    }

    public int getMargin() {
        return this.d.c;
    }

    public int getType() {
        return this.a;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.d.b = z;
    }

    public void setDpMargin(int i) {
        this.d.c = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.d.c = i;
    }

    public void setType(int i) {
        this.a = i;
    }
}
