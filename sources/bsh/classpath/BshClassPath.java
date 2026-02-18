package bsh.classpath;

import bsh.ClassPathException;
import bsh.NameSource;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.FileSystemAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import me.hd.wauxv.obf.bjs;
import me.hd.wauxv.obf.ky;
import me.hd.wauxv.obf.oj;
import me.hd.wauxv.obf.ol;
import me.hd.wauxv.obf.ra;
import me.hd.wauxv.obf.rb;
import me.hd.wauxv.obf.rc;
import me.hd.wauxv.obf.rd;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class BshClassPath implements ClassPathListener, NameSource {
    private static BshClassPath bootClassPath;
    private static MappingFeedback mappingFeedbackListener;
    private static BshClassPath userClassPath;
    private static URL[] userClassPathComp;
    private final Map<String, ClassSource> classSource;
    private final Set<BshClassPath> compPaths;
    Vector<WeakReference<ClassPathListener>> listeners;
    private boolean mapsInitialized;
    String name;
    private boolean nameCompletionIncludesUnqNames;
    private List<NameSource.Listener> nameSourceListeners;
    private final Map<String, Set<String>> packageMap;
    private final Set<URL> path;
    private UnqualifiedNameTable unqNameTable;
    private static final Pattern slashDot = Pattern.compile("[/\\\\]");
    private static final Pattern moduleName = Pattern.compile("^modules/[^/]+/");
    private static final Pattern dotClass = Pattern.compile("\\.[^\\.]+$");
    private static final Pattern splitClass = Pattern.compile("\\.(?=[^.]+$)");

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class AmbiguousName {
        List<String> list;

        public AmbiguousName(String str) {
            ArrayList arrayList = new ArrayList();
            this.list = arrayList;
            arrayList.add(str);
        }

        public void add(String str) {
            this.list.add(str);
        }

        public List<String> get() {
            return this.list;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static abstract class ClassSource {
        Object source;

        public abstract byte[] getCode(String str);
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class DirClassSource extends ClassSource {
        public DirClassSource(File file) {
            this.source = file;
        }

        public static byte[] readBytesFromFile(File file, String str) {
            File file2 = new File(file,
                    str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH,
                            File.separatorChar) + ClassFileLocator.CLASS_FILE_EXTENSION);
            if (!file2.exists()) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file2);
                try {
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    try {
                        byte[] bArr = new byte[(int) file2.length()];
                        dataInputStream.readFully(bArr);
                        dataInputStream.close();
                        dataInputStream.close();
                        fileInputStream.close();
                        return bArr;
                    } catch (Throwable th) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException e) {
                throw new RuntimeException("Couldn't load file: " + file2, e);
            }
        }

        @Override // bsh.classpath.BshClassPath.ClassSource
        public byte[] getCode(String str) {
            return readBytesFromFile(getDir(), str);
        }

        public File getDir() {
            return (File) this.source;
        }

        public String toString() {
            return "Dir: " + this.source;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class GeneratedClassSource extends ClassSource {
        public GeneratedClassSource(byte[] bArr) {
            this.source = bArr;
        }

        @Override // bsh.classpath.BshClassPath.ClassSource
        public byte[] getCode(String str) {
            return (byte[]) this.source;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class JarClassSource extends ClassSource {
        public JarClassSource(URL url) {
            this.source = url;
        }

        /*
         * JADX WARN: Undo finally extract visitor
         * jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough
         * terminus for handler TryEdge: [PREMATURE_EXIT B:27:0x0035 -> B:9:0x0045] -
         * Handler: None
         * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
         * MarkFinallyVisitor.java:419)
         * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
         * MarkFinallyVisitor.java:302)
         * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
         * MarkFinallyVisitor.java:222)
         * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
         * java:150)
         */
        @Override // bsh.classpath.BshClassPath.ClassSource
        public byte[] getCode(String str) {
            String str2 = "/" + str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/')
                    + ClassFileLocator.CLASS_FILE_EXTENSION;
            try {
                URLClassLoader uRLClassLoader = new URLClassLoader(new URL[] { getURL() });
                try {
                    DataInputStream dataInputStream = new DataInputStream(
                            uRLClassLoader.loadClass(str).getResourceAsStream(str2));
                    try {
                        byte[] bArr = new byte[dataInputStream.available()];
                        dataInputStream.readFully(bArr);
                        dataInputStream.close();
                        uRLClassLoader.close();
                        return bArr;
                    } catch (Throwable th) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    try {
                        uRLClassLoader.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                    throw th3;
                }
            } catch (IOException | ClassNotFoundException unused) {
                return new byte[0];
            }
        }

        public URL getURL() {
            return (URL) this.source;
        }

        public String toString() {
            return "Jar: " + this.source;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class JrtClassSource extends ClassSource {
        public JrtClassSource(URL url) {
            this.source = url;
        }

        @Override // bsh.classpath.BshClassPath.ClassSource
        public byte[] getCode(String str) {
            try {
                DataInputStream dataInputStream = new DataInputStream((InputStream) new URL(this.source + ("/"
                        + str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/')
                        + ClassFileLocator.CLASS_FILE_EXTENSION)).getContent());
                try {
                    byte[] bArr = new byte[dataInputStream.available()];
                    dataInputStream.readFully(bArr);
                    dataInputStream.close();
                    return bArr;
                } catch (Throwable th) {
                    try {
                        dataInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return new byte[0];
            }
        }

        public URL getURL() {
            return (URL) this.source;
        }

        public String toString() {
            return "Jrt: " + this.source;
        }
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public interface MappingFeedback {
        void classMapping(String str);

        void endClassMapping();

        void errorWhileMapping(String str);

        void startClassMapping();
    }

    /*
     * JADX INFO: compiled from:
     * r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6
     */
    public static class UnqualifiedNameTable extends HashMap<String, AmbiguousName> {
        private static final long serialVersionUID = 1;

        public void add(String str) {
            String str2 = BshClassPath.splitClassname(str)[1];
            if (super.containsKey(str2)) {
                ((AmbiguousName) super.get(str2)).add(str);
            } else {
                super.put(str2, new AmbiguousName(str));
            }
        }
    }

    public BshClassPath(String str) {
        this.path = ConcurrentHashMap.newKeySet();
        this.compPaths = ConcurrentHashMap.newKeySet();
        this.packageMap = new ConcurrentHashMap();
        this.classSource = new ConcurrentHashMap();
        this.nameCompletionIncludesUnqNames = true;
        this.listeners = new Vector<>();
        this.name = str;
        reset();
    }

    public static void addMappingFeedback(MappingFeedback mappingFeedback) {
        if (mappingFeedbackListener != null) {
            throw new RuntimeException("Unimplemented: already a listener");
        }
        mappingFeedbackListener = mappingFeedback;
    }

    private UnqualifiedNameTable buildUnqualifiedNameTable() {
        UnqualifiedNameTable unqualifiedNameTable = new UnqualifiedNameTable();
        this.compPaths.forEach(new a(unqualifiedNameTable, 0));
        this.classSource.keySet().forEach(new a(unqualifiedNameTable, 1));
        return unqualifiedNameTable;
    }

    public static String canonicalizeClassName(String str) {
        if (str.startsWith("modules/")) {
            str = moduleName.matcher(str).replaceFirst("");
        }
        if (str.indexOf(47) >= 0 || str.indexOf(92) >= 0) {
            str = slashDot.matcher(str).replaceAll(".");
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        if (str.startsWith("class ")) {
            str = str.substring(6);
        }
        if (str.startsWith("classes.")) {
            str = str.substring(8);
        }
        return str.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION) ? dotClass.matcher(str).replaceFirst("") : str;
    }

    private void clearCachedStructures() {
        this.mapsInitialized = false;
        this.packageMap.clear();
        this.classSource.clear();
        this.unqNameTable = null;
        nameSpaceChanged();
    }

    public static BshClassPath getBootClassPath() throws ClassPathException {
        if (bootClassPath == null) {
            try {
                bootClassPath = new BshClassPath("Boot Class Path", new URL[] { getRTJarPath() });
            } catch (MalformedURLException e) {
                throw new ClassPathException(" can't find boot jar: " + e, e);
            }
        }
        return bootClassPath;
    }

    private static URL getRTJarPath() {
        String externalForm = Class.class.getResource("/java/lang/String.class").toExternalForm();
        return externalForm.startsWith("jrt:/") ? new URL(externalForm.substring(0, externalForm.indexOf(47, 5)))
                : new URL(externalForm.replaceFirst("[^!]*$", "/"));
    }

    private UnqualifiedNameTable getUnqualifiedNameTable() {
        if (this.unqNameTable == null) {
            this.unqNameTable = buildUnqualifiedNameTable();
        }
        return this.unqNameTable;
    }

    public static BshClassPath getUserClassPath() {
        if (userClassPath == null) {
            userClassPath = new BshClassPath("User Class Path", getUserClassPathComponents());
        }
        return userClassPath;
    }

    public static URL[] getUserClassPathComponents() throws ClassPathException {
        URL[] urlArr = userClassPathComp;
        if (urlArr != null) {
            return urlArr;
        }
        String property = System.getProperty("java.class.path");
        String[] strArrSplit = property == null ? new String[0] : property.split(File.pathSeparator);
        URL[] urlArr2 = new URL[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                urlArr2[i] = new File(new File(strArrSplit[i]).getCanonicalPath()).toURI().toURL();
            } catch (IOException e) {
                throw new ClassPathException("can't parse class path: " + e, e);
            }
        }
        userClassPathComp = urlArr2;
        return urlArr2;
    }

    public static boolean isArchiveFileName(String str) {
        String lowerCase = str.toLowerCase();
        return lowerCase.endsWith(".jar") || lowerCase.endsWith(".zip") || lowerCase.endsWith(".jmod");
    }

    public static boolean isClassFileName(String str) {
        return str.toLowerCase().endsWith(ClassFileLocator.CLASS_FILE_EXTENSION);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildUnqualifiedNameTable$4(UnqualifiedNameTable unqualifiedNameTable,
            BshClassPath bshClassPath) {
        bshClassPath.classSource.keySet().forEach(new a(unqualifiedNameTable, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getAllNames$6(List list, String str) {
        list.addAll(removeInnerClassNames(getClassesForPackage(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getClassesForPackage$0(String str, Set set, BshClassPath bshClassPath) {
        Set<String> classesForPackage = bshClassPath.getClassesForPackage(str);
        if (classesForPackage != null) {
            set.addAll(classesForPackage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getFullPath$2(List list, BshClassPath bshClassPath) {
        for (URL url : bshClassPath.getFullPath()) {
            if (!list.contains(url)) {
                list.add(url);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getPackagesSet$9(Set set, BshClassPath bshClassPath) {
        set.addAll(bshClassPath.packageMap.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$searchJarFSForClasses$8(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$searchJrtFSForClasses$7(int i) {
        return new String[i];
    }

    private void mapClass(String str, ClassSource classSource) {
        String str2 = splitClassname(str)[0];
        Set<String> hashSet = this.packageMap.get(str2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.packageMap.put(str2, hashSet);
        }
        hashSet.add(str);
        if (this.classSource.get(str) == null) {
            this.classSource.put(str, classSource);
        }
    }

    public static Collection<String> removeInnerClassNames(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(collection);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).indexOf("$") != -1) {
                it.remove();
            }
        }
        return arrayList;
    }

    private void reset() {
        this.path.clear();
        this.compPaths.clear();
        clearCachedStructures();
    }

    public static String[] searchArchiveForClasses(URL url) throws IOException {
        ArrayList arrayList = new ArrayList();
        ZipInputStream zipInputStream = new ZipInputStream(url.openStream());
        while (zipInputStream.available() == 1) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry != null && isClassFileName(nextEntry.getName())) {
                arrayList.add(canonicalizeClassName(nextEntry.getName()));
            }
        }
        zipInputStream.close();
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] searchJarFSForClasses(URL url) throws Exception {
        try {
            try {
                FileSystems.newFileSystem(url.toURI(), new HashMap());
            } catch (URISyntaxException unused) {
                return new String[0];
            }
        } catch (FileSystemAlreadyExistsException unused2) {
        }
        try {
            Stream<Path> streamWalk = Files.walk(FileSystems.getFileSystem(url.toURI()).getPath("/", new String[0]),
                    new FileVisitOption[0]);
            try {
                String[] strArr = (String[]) streamWalk.map(new ky(1)).filter(new ra(1)).map(new ky(2))
                        .toArray(new rb(0));
                streamWalk.close();
                return strArr;
            } catch (Throwable th) {
                if (streamWalk != null) {
                    try {
                        streamWalk.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static String[] searchJrtFSForClasses(URL url) throws Exception {
        try {
            try {
                Stream<Path> streamWalk = Files.walk(
                        FileSystems.getFileSystem(new URI("jrt:/")).getPath("modules", url.getPath()),
                        new FileVisitOption[0]);
                try {
                    String[] strArr = (String[]) streamWalk.map(new ky(1)).filter(new ra(1)).map(new ky(2))
                            .toArray(new rb(1));
                    streamWalk.close();
                    return strArr;
                } catch (Throwable th) {
                    if (streamWalk != null) {
                        try {
                            streamWalk.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (URISyntaxException unused) {
            return new String[0];
        }
    }

    public static String[] splitClassname(String str) {
        String strCanonicalizeClassName = canonicalizeClassName(str);
        return strCanonicalizeClassName.indexOf(46) == -1 ? new String[] { "<unpackaged>", strCanonicalizeClassName }
                : splitClass.split(strCanonicalizeClassName);
    }

    public static String[] traverseDirForClasses(File file) throws IOException {
        List<String> listTraverseDirForClassesAux = traverseDirForClassesAux(file, file);
        return (String[]) listTraverseDirForClassesAux.toArray(new String[listTraverseDirForClassesAux.size()]);
    }

    public static List<String> traverseDirForClassesAux(File file, File file2) throws IOException {
        ArrayList arrayList = new ArrayList();
        String absolutePath = file.getAbsolutePath();
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles == null) {
            fileArrListFiles = new File[0];
        }
        for (File file3 : fileArrListFiles) {
            if (file3.isDirectory()) {
                arrayList.addAll(traverseDirForClassesAux(file, file3));
            } else {
                String absolutePath2 = file3.getAbsolutePath();
                if (!isClassFileName(absolutePath2)) {
                    continue;
                } else {
                    if (!absolutePath2.startsWith(absolutePath)) {
                        throw new IOException("problem parsing paths");
                    }
                    arrayList.add(canonicalizeClassName(absolutePath2.substring(absolutePath.length() + 1)));
                }
            }
        }
        return arrayList;
    }

    public void add(URL[] urlArr) {
        this.path.addAll(Arrays.asList(urlArr));
        if (this.mapsInitialized) {
            map(urlArr);
        }
    }

    public void addComponent(BshClassPath bshClassPath) {
        if (bshClassPath == null) {
            return;
        }
        this.compPaths.add(bshClassPath);
        bshClassPath.addListener(this);
    }

    public void addListener(ClassPathListener classPathListener) {
        this.listeners.addElement(new WeakReference<>(classPathListener));
    }

    @Override // bsh.NameSource
    public void addNameSourceListener(NameSource.Listener listener) {
        if (this.nameSourceListeners == null) {
            this.nameSourceListeners = new ArrayList();
        }
        this.nameSourceListeners.add(listener);
    }

    public void classMapping(String str) {
        MappingFeedback mappingFeedback = mappingFeedbackListener;
        if (mappingFeedback != null) {
            mappingFeedback.classMapping(str);
            return;
        }
        System.err.println("Mapping: " + str);
    }

    @Override // bsh.classpath.ClassPathListener
    public void classPathChanged() {
        clearCachedStructures();
        notifyListeners();
    }

    public void endClassMapping() {
        MappingFeedback mappingFeedback = mappingFeedbackListener;
        if (mappingFeedback != null) {
            mappingFeedback.endClassMapping();
        } else {
            System.err.println("End ClassPath Mapping");
        }
    }

    public void errorWhileMapping(String str) {
        MappingFeedback mappingFeedback = mappingFeedbackListener;
        if (mappingFeedback != null) {
            mappingFeedback.errorWhileMapping(str);
        } else {
            System.err.println(str);
        }
    }

    @Override // bsh.NameSource
    public String[] getAllNames() {
        insureInitialized();
        ArrayList arrayList = new ArrayList();
        getPackagesSet().forEach(new oj(this, 5, arrayList));
        if (this.nameCompletionIncludesUnqNames) {
            arrayList.addAll(getUnqualifiedNameTable().keySet());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public String getClassNameByUnqName(String str) throws ClassPathException {
        insureInitialized();
        AmbiguousName ambiguousName = getUnqualifiedNameTable().get(str);
        if (ambiguousName == null) {
            return null;
        }
        List<String> list = ambiguousName.get();
        if (list.size() == 1) {
            return list.get(0);
        }
        throw new ClassPathException("Ambiguous class names: " + list);
    }

    public ClassSource getClassSource(String str) {
        ClassSource classSource = this.classSource.get(str);
        if (classSource != null) {
            return classSource;
        }
        insureInitialized();
        Iterator<BshClassPath> it = this.compPaths.iterator();
        ClassSource classSource2 = this.classSource.get(str);
        while (classSource2 == null && it.hasNext()) {
            classSource2 = it.next().getClassSource(str);
        }
        return classSource2;
    }

    public Set<String> getClassesForPackage(String str) {
        insureInitialized();
        HashSet hashSet = new HashSet();
        Set<String> set = this.packageMap.get(str);
        if (set != null) {
            hashSet.addAll(set);
        }
        this.compPaths.forEach(new oj(str, 6, hashSet));
        return hashSet;
    }

    public List<URL> getFullPath() {
        ArrayList arrayList = new ArrayList();
        this.compPaths.forEach(new rc(0, arrayList));
        arrayList.addAll(this.path);
        return arrayList;
    }

    public List<NameSource.Listener> getNameSourceListeners() {
        return this.nameSourceListeners;
    }

    public Set<String> getPackagesSet() {
        insureInitialized();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.packageMap.keySet());
        this.compPaths.forEach(new ol(hashSet, 1));
        return hashSet;
    }

    public URL[] getPathComponents() {
        return (URL[]) getFullPath().toArray(new URL[0]);
    }

    public UnqualifiedNameTable getUnqNameTable() {
        return this.unqNameTable;
    }

    public void insureInitialized() {
        insureInitialized(true);
    }

    public boolean isMapsInitialized() {
        return this.mapsInitialized;
    }

    public boolean isNameCompletionIncludesUnqNames() {
        return this.nameCompletionIncludesUnqNames;
    }

    public void map(URL[] urlArr) {
        for (int i = 0; i < urlArr.length; i++) {
            try {
                map(urlArr[i]);
            } catch (Exception e) {
                errorWhileMapping("Error constructing classpath: " + urlArr[i] + ": " + e);
                throw new RuntimeException(concatVar2Var1(i, "Failed to map class path "), e);
            }
        }
    }

    public void nameSpaceChanged() {
        if (this.nameSourceListeners == null) {
            return;
        }
        for (int i = 0; i < this.nameSourceListeners.size(); i++) {
            this.nameSourceListeners.get(i).nameSourceChanged(this);
        }
    }

    public void notifyListeners() {
        Iterator<WeakReference<ClassPathListener>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ClassPathListener classPathListener = it.next().get();
            if (classPathListener == null) {
                it.remove();
            } else {
                classPathListener.classPathChanged();
            }
        }
    }

    public void removeListener(ClassPathListener classPathListener) {
        Iterator<WeakReference<ClassPathListener>> it = this.listeners.iterator();
        while (it.hasNext()) {
            if (it.next().get() == classPathListener) {
                it.remove();
            }
        }
    }

    public void setClassSource(String str, ClassSource classSource) {
        this.classSource.put(str, classSource);
    }

    public void setMapsInitialized(boolean z) {
        this.mapsInitialized = z;
    }

    public void setNameCompletionIncludesUnqNames(boolean z) {
        this.nameCompletionIncludesUnqNames = z;
    }

    public void setNameSourceListeners(List<NameSource.Listener> list) {
        this.nameSourceListeners = list;
    }

    public void setPath(URL[] urlArr) {
        reset();
        add(urlArr);
    }

    public void setUnqNameTable(UnqualifiedNameTable unqualifiedNameTable) {
        this.unqNameTable = unqualifiedNameTable;
    }

    public void startClassMapping() {
        MappingFeedback mappingFeedback = mappingFeedbackListener;
        if (mappingFeedback != null) {
            mappingFeedback.startClassMapping();
        } else {
            System.err.println("Start ClassPath Mapping");
        }
    }

    public String toString() {
        return "BshClassPath " + this.name + "(" + super.toString() + ") path= " + this.path + "\ncompPaths = {"
                + this.compPaths + " }";
    }

    public void insureInitialized(boolean z) {
        if (z && !this.mapsInitialized) {
            startClassMapping();
        }
        this.compPaths.forEach(new rd());
        if (!this.mapsInitialized) {
            map((URL[]) this.path.toArray(new URL[0]));
        }
        if (z && !this.mapsInitialized) {
            endClassMapping();
        }
        this.mapsInitialized = true;
    }

    public void add(URL url) {
        this.path.add(url);
        if (this.mapsInitialized) {
            map(url);
        }
    }

    public BshClassPath(String str, URL[] urlArr) {
        this(str);
        add(urlArr);
    }

    public void map(URL url) {
        if ("jrt".equals(url.getProtocol())) {
            classMapping("FileSystem: " + url);
            map(searchJrtFSForClasses(url), new JrtClassSource(url));
            return;
        }
        if ("jar".equals(url.getProtocol())) {
            classMapping("FileSystem: " + url);
            map(searchJarFSForClasses(url), new JarClassSource(url));
            return;
        }
        String file = url.getFile();
        File file2 = new File(file);
        if (file2.isDirectory()) {
            classMapping("Directory " + file2.toString());
            map(traverseDirForClasses(file2), new DirClassSource(file2));
            return;
        }
        if (isArchiveFileName(file)) {
            classMapping("Archive: " + url);
            map(searchArchiveForClasses(url), new JarClassSource(url));
            return;
        }
        errorWhileMapping("Not a classpath component: " + file);
    }

    private void map(String[] strArr, ClassSource classSource) {
        for (String str : strArr) {
            mapClass(str, classSource);
        }
    }
}
