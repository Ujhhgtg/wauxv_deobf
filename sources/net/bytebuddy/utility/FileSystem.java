package net.bytebuddy.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.AccessControllerPlugin;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FileSystem {
    private static final boolean ACCESS_CONTROLLER;
    private static /* synthetic */ FileSystem INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForLegacyVm extends FileSystem {
        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
        	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
         */
        @Override // net.bytebuddy.utility.FileSystem
        public void copy(File file, File file2) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            fileInputStream.close();
                            return;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        /* JADX WARN: Undo finally extract visitor
        jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough terminus for handler TryEdge: [PREMATURE_EXIT B:23:0x000c -> B:17:0x002c] - Handler: None
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:419)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
         */
        @Override // net.bytebuddy.utility.FileSystem
        public void move(File file, File file2) throws IOException {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                    if (file.delete()) {
                        return;
                    }
                    file.deleteOnExit();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream.close();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class ForNio2CapableVm extends FileSystem {
        private static final Dispatcher DISPATCHER = (Dispatcher) FileSystem.doPrivileged(JavaDispatcher.of(Dispatcher.class));
        private static final Files FILES = (Files) FileSystem.doPrivileged(JavaDispatcher.of(Files.class));
        private static final StandardCopyOption STANDARD_COPY_OPTION = (StandardCopyOption) FileSystem.doPrivileged(JavaDispatcher.of(StandardCopyOption.class));

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.io.File")
        public interface Dispatcher {
            @JavaDispatcher.Proxied("toPath")
            Object toPath(File file);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.nio.file.Files")
        public interface Files {
            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("copy")
            Object copy(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr);

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("createLink")
            Object createLink(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2);

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("deleteIfExists")
            Object deleteIfExists(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj);

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("move")
            Object move(@JavaDispatcher.Proxied("java.nio.file.Path") Object obj, @JavaDispatcher.Proxied("java.nio.file.Path") Object obj2, @JavaDispatcher.Proxied("java.nio.file.CopyOption") Object[] objArr);
        }

        /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
        @JavaDispatcher.Proxied("java.nio.file.StandardCopyOption")
        public interface StandardCopyOption {
            @JavaDispatcher.Container
            @JavaDispatcher.Proxied("toArray")
            Object[] toArray(int i);

            @JavaDispatcher.IsStatic
            @JavaDispatcher.Proxied("valueOf")
            Object valueOf(String str);
        }

        @Override // net.bytebuddy.utility.FileSystem
        public void copy(File file, File file2) {
            StandardCopyOption standardCopyOption = STANDARD_COPY_OPTION;
            Object[] array = standardCopyOption.toArray(1);
            array[0] = standardCopyOption.valueOf("REPLACE_EXISTING");
            Files files = FILES;
            Dispatcher dispatcher = DISPATCHER;
            files.copy(dispatcher.toPath(file), dispatcher.toPath(file2), array);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass();
        }

        public int hashCode() {
            return getClass().hashCode();
        }

        @Override // net.bytebuddy.utility.FileSystem
        public void link(File file, File file2) {
            Files files = FILES;
            Dispatcher dispatcher = DISPATCHER;
            files.createLink(files.deleteIfExists(dispatcher.toPath(file2)), dispatcher.toPath(file));
        }

        @Override // net.bytebuddy.utility.FileSystem
        public void move(File file, File file2) {
            StandardCopyOption standardCopyOption = STANDARD_COPY_OPTION;
            Object[] array = standardCopyOption.toArray(1);
            array[0] = standardCopyOption.valueOf("REPLACE_EXISTING");
            Files files = FILES;
            Dispatcher dispatcher = DISPATCHER;
            files.move(dispatcher.toPath(file), dispatcher.toPath(file2), array);
        }
    }

    static {
        boolean z = false;
        try {
            Class.forName("java.security.AccessController", false, null);
            ACCESS_CONTROLLER = Boolean.parseBoolean(System.getProperty("net.bytebuddy.securitymanager", "true"));
        } catch (ClassNotFoundException unused) {
            ACCESS_CONTROLLER = z;
        } catch (SecurityException unused2) {
            z = true;
            ACCESS_CONTROLLER = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @AccessControllerPlugin.Enhance
    public static <T> T doPrivileged(PrivilegedAction<T> privilegedAction) {
        return ACCESS_CONTROLLER ? (T) AccessController.doPrivileged(privilegedAction) : privilegedAction.run();
    }

    @CachedReturnPlugin.Enhance("INSTANCE")
    public static FileSystem getInstance() {
        FileSystem forLegacyVm;
        if (INSTANCE != null) {
            forLegacyVm = null;
        } else {
            try {
                Class.forName("java.nio.file.Files", false, ClassLoadingStrategy.BOOTSTRAP_LOADER);
                forLegacyVm = new ForNio2CapableVm();
            } catch (ClassNotFoundException unused) {
                forLegacyVm = new ForLegacyVm();
            }
        }
        if (forLegacyVm == null) {
            return INSTANCE;
        }
        INSTANCE = forLegacyVm;
        return forLegacyVm;
    }

    public abstract void copy(File file, File file2);

    public void link(File file, File file2) {
        copy(file, file2);
    }

    public abstract void move(File file, File file2);
}
