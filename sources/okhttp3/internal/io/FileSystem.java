package okhttp3.internal.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cqj;
import me.hd.wauxv.obf.dhy;
import me.hd.wauxv.obf.dlc;
import me.hd.wauxv.obf.ekc;
import me.hd.wauxv.obf.emc;
import me.hd.wauxv.obf.lm;
import me.hd.wauxv.obf.ln;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public dhy appendingSink(File file) {
                bzo.q(file, "file");
                int i = 1;
                try {
                    Logger logger = cqj.a;
                    return new lm(new FileOutputStream(file, true), i, new ekc());
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    Logger logger2 = cqj.a;
                    return new lm(new FileOutputStream(file, true), i, new ekc());
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) throws IOException {
                bzo.q(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File file) throws IOException {
                bzo.q(file, "directory");
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("not a readable directory: " + file);
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                bzo.q(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File file, File file2) throws IOException {
                bzo.q(file, "from");
                bzo.q(file2, "to");
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override // okhttp3.internal.io.FileSystem
            public dhy sink(File file) {
                bzo.q(file, "file");
                try {
                    return emc.az(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return emc.az(file);
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                bzo.q(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public dlc source(File file) {
                bzo.q(file, "file");
                Logger logger = cqj.a;
                return new ln(new FileInputStream(file), ekc.NONE);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    dhy appendingSink(File file);

    void delete(File file);

    void deleteContents(File file);

    boolean exists(File file);

    void rename(File file, File file2);

    dhy sink(File file);

    long size(File file);

    dlc source(File file);
}
