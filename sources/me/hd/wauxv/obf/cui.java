package me.hd.wauxv.obf;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cui implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        return file.isDirectory();
    }
}
