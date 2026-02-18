package bsh;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class FileReader extends InputStreamReader {
    public FileReader(String str) {
        this(new FileInputStream(str));
    }

    public FileReader(File file) {
        this(new FileInputStream(file));
    }

    public FileReader(FileDescriptor fileDescriptor) {
        this(new FileInputStream(fileDescriptor));
    }

    public FileReader(InputStream inputStream) {
        super(inputStream, StandardCharsets.UTF_8);
    }
}
