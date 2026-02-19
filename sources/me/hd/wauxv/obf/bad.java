package me.hd.wauxv.obf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: loaded from: classes.dex */
public abstract class bad extends bmy {
    public static void a(File file, File file2) {
        throwIfVar1IsNull(file, "<this>");
        if (!file.exists()) {
            throw new azm(file, null, "The source file doesn't exist.");
        }
        if (file2.exists() && !file2.delete()) {
            throw new azm(file, file2, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new azv(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                bhu.w(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    cnh.m(fileOutputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                cnh.m(fileInputStream, th3);
                throw th4;
            }
        }
    }

    /*
     * JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object,
     * java.util.List]
     */
    public static final azt b(azt aztVar) {
        File file = aztVar.a;
        ?? r6 = aztVar.b;
        ArrayList arrayList = new ArrayList(r6.size());
        for (File file2 : r6) {
            String name = file2.getName();
            if (!nullSafeIsEqual(name, ".")) {
                if (!nullSafeIsEqual(name, "..")) {
                    arrayList.add(file2);
                } else if (arrayList.isEmpty() || nullSafeIsEqual(((File) aaz.l(arrayList)).getName(), "..")) {
                    arrayList.add(file2);
                }
            }
        }
        return new azt(file, arrayList);
    }

    public static String c(File file) {
        Charset charset = uj.a;
        throwIfVar1IsNull(file, "<this>");
        throwIfVar1IsNull(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String strAn = KotlinHelpers.an(inputStreamReader);
            inputStreamReader.close();
            return strAn;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(inputStreamReader, th);
                throw th2;
            }
        }
    }

    /* JADX WARN: Found duplicated region for block: B:21:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:22:0x0078 */
    /* JADX WARN: Found duplicated region for block: B:24:0x007f A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:25:0x0081 */
    /* JADX WARN: Found duplicated region for block: B:26:0x0086 A[MOVE_INLINED] */
    /* JADX WARN: Found duplicated region for block: B:28:0x0090 */
    /* JADX WARN: Found duplicated region for block: B:29:0x0093 */
    /* JADX WARN: Found duplicated region for block: B:31:0x0096 */
    /* JADX WARN: Found duplicated region for block: B:32:0x00a1 */
    /* JADX WARN: Found duplicated region for block: B:34:0x00aa */
    /*
     * JADX WARN: Found duplicated region for block: B:36:0x00b2 A[LOOP:2:
     * B:35:0x00b0->B:36:0x00b2, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:37:0x00bc */
    /*
     * JADX WARN: Found duplicated region for block: B:40:0x00c8 A[LOOP:3:
     * B:38:0x00c2->B:40:0x00c8, LOOP_END]
     */
    /* JADX WARN: Found duplicated region for block: B:43:0x00dc */
    /*
     * JADX WARN: Type inference failed for: r2v0, types: [java.lang.Iterable,
     * java.lang.Object, java.util.List]
     */
    /*
     * JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object,
     * java.util.List]
     */
    public static File d(File file, File file2) {
        int size;
        ArrayList arrayList;
        ListIterator listIterator;
        List listBf;
        List list;
        int size2;
        throwIfVar1IsNull(file, "<this>");
        azt aztVarB = b(bmy.aj(file));
        ?? r2 = aztVarB.b;
        azt aztVarB2 = b(bmy.aj(file2));
        ?? r4 = aztVarB2.b;
        boolean zEquals = aztVarB.a.equals(aztVarB2.a);
        String string = null;
        if (zEquals) {
            int size3 = r4.size();
            int size4 = r2.size();
            int iMin = Math.min(size4, size3);
            int i = 0;
            while (i < iMin && nullSafeIsEqual(r2.get(i), r4.get(i))) {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = size3 - 1;
            if (i <= i2) {
                while (true) {
                    if (!nullSafeIsEqual(((File) r4.get(i2)).getName(), "..")) {
                        sb.append("..");
                        if (i2 != i) {
                            sb.append(File.separatorChar);
                        }
                        if (i2 != i) {
                            i2--;
                        } else {
                            if (i < size4) {
                                if (i < size3) {
                                    sb.append(File.separatorChar);
                                }
                                if (i >= 0) {
                                    throw new IllegalArgumentException(yg.f(i, "Requested element count ", " is less than zero.").toString());
                                }
                                if (i == 0) {
                                    listBf = aaz.z(r2);
                                } else {
                                    size = ((Collection) r2).size() - i;
                                    if (size <= 0) {
                                        listBf = EmptyReadonlyList.a;
                                    } else if (size == 1) {
                                        listBf = dqc.toSingletonList(aaz.l((List) r2));
                                    } else {
                                        arrayList = new ArrayList(size);
                                        if (r2 instanceof RandomAccess) {
                                            list = (List) r2;
                                            size2 = list.size();
                                            while (i < size2) {
                                                arrayList.add(list.get(i));
                                                i++;
                                            }
                                        } else {
                                            listIterator = ((List) r2).listIterator(i);
                                            while (listIterator.hasNext()) {
                                                arrayList.add(listIterator.next());
                                            }
                                        }
                                        listBf = arrayList;
                                    }
                                }
                                String str = File.separator;
                                throwIfVar1IsNull(str, "separator");
                                aaz.i(listBf, sb, str, "", "", "...", null);
                            }
                            string = sb.toString();
                        }
                    }
                }
            } else {
                if (i < size4) {
                    if (i < size3) {
                        sb.append(File.separatorChar);
                    }
                    if (i >= 0) {
                        throw new IllegalArgumentException(yg.f(i, "Requested element count ", " is less than zero.").toString());
                    }
                    if (i == 0) {
                        listBf = aaz.z(r2);
                    } else {
                        size = ((Collection) r2).size() - i;
                        if (size <= 0) {
                            listBf = EmptyReadonlyList.a;
                        } else if (size == 1) {
                            listBf = dqc.toSingletonList(aaz.l((List) r2));
                        } else {
                            arrayList = new ArrayList(size);
                            if (r2 instanceof RandomAccess) {
                                list = (List) r2;
                                size2 = list.size();
                                while (i < size2) {
                                    arrayList.add(list.get(i));
                                    i++;
                                }
                            } else {
                                listIterator = ((List) r2).listIterator(i);
                                while (listIterator.hasNext()) {
                                    arrayList.add(listIterator.next());
                                }
                            }
                            listBf = arrayList;
                        }
                    }
                    String str2 = File.separator;
                    throwIfVar1IsNull(str2, "separator");
                    aaz.i(listBf, sb, str2, "", "", "...", null);
                }
                string = sb.toString();
            }
        }
        if (string != null) {
            return new File(string);
        }
        throw new IllegalArgumentException("this and base files have different roots: " + file + " and " + file2 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH);
    }

    public static void e(File file, String str) {
        Charset charset = uj.a;
        throwIfVar1IsNull(str, "text");
        throwIfVar1IsNull(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            f(fileOutputStream, str, charset);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                cnh.m(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void f(FileOutputStream fileOutputStream, String str, Charset charset) throws IOException {
        throwIfVar1IsNull(str, "text");
        throwIfVar1IsNull(charset, "charset");
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            throwIfVar1IsNull(bytes, "getBytes(...)");
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder charsetEncoderOnUnmappableCharacter = charsetEncoderNewEncoder
                .onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        throwIfVar1IsNull(charsetEncoderOnUnmappableCharacter);
        ByteBuffer byteBufferAllocate = ByteBuffer
                .allocate(8192 * ((int) Math.ceil(charsetEncoderOnUnmappableCharacter.maxBytesPerChar())));
        throwIfVar1IsNull(byteBufferAllocate, "allocate(...)");
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int iMin = Math.min(8192 - i2, str.length() - i);
            int i3 = i + iMin;
            char[] cArrArray = charBufferAllocate.array();
            throwIfVar1IsNull(cArrArray, "array(...)");
            str.getChars(i, i3, cArrArray, i2);
            charBufferAllocate.limit(iMin + i2);
            i2 = 1;
            if (!charsetEncoderOnUnmappableCharacter.encode(charBufferAllocate, byteBufferAllocate, i3 == str.length())
                    .isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            fileOutputStream.write(byteBufferAllocate.array(), 0, byteBufferAllocate.position());
            if (charBufferAllocate.position() != charBufferAllocate.limit()) {
                charBufferAllocate.put(0, charBufferAllocate.get());
            } else {
                i2 = 0;
            }
            charBufferAllocate.clear();
            byteBufferAllocate.clear();
            i = i3;
        }
    }
}
