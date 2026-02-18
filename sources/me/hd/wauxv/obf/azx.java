package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azx extends azw {
    public boolean a;
    public File[] b;
    public int c;
    public boolean d;

    @Override // me.hd.wauxv.obf.bab
    public final File e() {
        boolean z = this.d;
        File file = this.f;
        if (!z && this.b == null) {
            File[] fileArrListFiles = file.listFiles();
            this.b = fileArrListFiles;
            if (fileArrListFiles == null) {
                this.d = true;
            }
        }
        File[] fileArr = this.b;
        if (fileArr == null || this.c >= fileArr.length) {
            if (this.a) {
                return null;
            }
            this.a = true;
            return file;
        }
        bzo.n(fileArr);
        int i = this.c;
        this.c = i + 1;
        return fileArr[i];
    }
}
