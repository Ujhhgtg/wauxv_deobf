package me.hd.wauxv.obf;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class azz extends azw {
    public boolean a;
    public File[] b;
    public int c;

    @Override // me.hd.wauxv.obf.bab
    public final File e() {
        boolean z = this.a;
        File file = this.f;
        if (!z) {
            this.a = true;
            return file;
        }
        File[] fileArr = this.b;
        if (fileArr != null && this.c >= fileArr.length) {
            return null;
        }
        if (fileArr == null) {
            File[] fileArrListFiles = file.listFiles();
            this.b = fileArrListFiles;
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                return null;
            }
        }
        File[] fileArr2 = this.b;
        bzo.n(fileArr2);
        int i = this.c;
        this.c = i + 1;
        return fileArr2[i];
    }
}
