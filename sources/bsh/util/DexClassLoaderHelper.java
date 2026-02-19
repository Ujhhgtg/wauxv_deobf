package bsh.util;

import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.direct.StdAttributeFactory;
import com.android.dx.command.dexer.DxContext;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.cf.CfOptions;
import com.android.dx.dex.cf.CfTranslator;
import com.android.dx.dex.file.DexFile;
import dalvik.system.InMemoryDexClassLoader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import me.hd.wauxv.obf.StaticHelpers6;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DexClassLoaderHelper {
    private final DexOptions DEX_OPTIONS = new DexOptions();
    private final DxContext DX_CONTEXT = new DxContext();
    private final CfOptions CF_OPTIONS = new CfOptions();
    private final HashMap<String, Class<?>> cachedClassMap = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class FixClassloader extends ClassLoader {
        public FixClassloader(ClassLoader classLoader) {
            super(classLoader);
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z) {
            return super.loadClass(str, z);
        }
    }

    private byte[] convertClassToDex(String str, byte[] bArr) throws IOException {
        String strS = StaticHelpers6.concat(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'), ClassFileLocator.CLASS_FILE_EXTENSION);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DirectClassFile directClassFile = new DirectClassFile(bArr, strS, true);
            directClassFile.setAttributeFactory(StdAttributeFactory.THE_ONE);
            DexFile dexFile = new DexFile(this.DEX_OPTIONS);
            dexFile.add(CfTranslator.translate(this.DX_CONTEXT, directClassFile, bArr, this.CF_OPTIONS, this.DEX_OPTIONS, dexFile));
            dexFile.writeTo(byteArrayOutputStream, null, true);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    private ClassLoader createDexClassLoader(byte[] bArr) {
        return new InMemoryDexClassLoader(ByteBuffer.wrap(bArr), new FixClassloader(DexClassLoaderHelper.class.getClassLoader()));
    }

    public Class<?> loadClassInternal(String str, byte[] bArr) {
        if (this.cachedClassMap.containsKey(str)) {
            return this.cachedClassMap.get(str);
        }
        try {
            Class<?> clsLoadClass = createDexClassLoader(convertClassToDex(str, bArr)).loadClass(str);
            this.cachedClassMap.put(str, clsLoadClass);
            return clsLoadClass;
        } catch (Exception unused) {
            return null;
        }
    }
}
