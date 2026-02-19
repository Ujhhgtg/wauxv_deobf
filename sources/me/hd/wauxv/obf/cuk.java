package me.hd.wauxv.obf;

import bsh.BshMethod;
import bsh.Interpreter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cuk {
    public static final ArrayList a = new ArrayList();
    public static final HashMap b = new HashMap();
    public static final HashMap c = new HashMap();

    public static List d() {
        Kotlin$Lazy kotlin$LazyVar = PathUtils.externalStorageRoot;
        File[] fileArrListFiles = new File(PathUtils.getModuleSubDir("Plugin" /* "Plugin" /* "Plugin" /* cnb.z(-47055661693738L)  */)).listFiles(new cui());
        if (fileArrListFiles == null) {
            return EmptyReadonlyList.INSTANCE;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            File file2 = new File(file, "main.java" /* "main.java" /* "main.java" /* cnb.z(-390270793284394L)  */);
            ctx ctxVar = (file2.exists() && file2.isFile()) ? new ctx(file) : null;
            if (ctxVar != null) {
                arrayList.add(ctxVar);
            }
        }
        return arrayList;
    }

    public static boolean e(ctx ctxVar) throws IOException {
        Object objX;
        ctxVar.getClass();
        try {
            ctxVar.o();
            ctxVar.n("onLoad" /* "onLoad" /* "onLoad" /* cnb.z(-402056183544618L)  */, new Object[0]);
            objX = Boolean.TRUE;
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            ArrayList arrayList = ewq.a;
            ewq.e("Plugin[" /* "Plugin[" /* "Plugin[" /* cnb.z(-400741923552042L)  */ + ctxVar.f + "]: load Failed: " /* "]: load Failed: " /* "]: load Failed: " /* cnb.z(-400707563813674L)  */ + thB.getMessage(), null, 14);
            SyntheticPileOfMess bmuVar = ctxVar.m;
            StringBuilder sb = new StringBuilder();
            sb.append("load Failed: " /* "load Failed: " /* "load Failed: " /* cnb.z(-400651729238826L)  */);
            sb.append(thB.getMessage());
            bmuVar.p(sb.toString());
            objX = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objX).booleanValue();
        if (zBooleanValue) {
            a.add(ctxVar);
        }
        return zBooleanValue;
    }

    public static void f(Interpreter interpreter, Object obj) {
        baa baaVar = new baa(new bae(SomeStaticHelpers.b(obj.getClass().getDeclaredMethods()), true, new Function1$VarIsInt(23)));
        while (baaVar.hasNext()) {
            interpreter.getNameSpace().setMethod(new BshMethod((Method) baaVar.next(), obj));
        }
    }

    public static void g(ctx ctxVar) {
        Object objX;
        String str = ctxVar.f;
        try {
            ctxVar.n("onUnLoad" /* "onUnLoad" /* "onUnLoad" /* cnb.z(-402026118773546L)  */, new Object[0]);
            ctxVar.o().getNameSpace().clear();
            objX = Boolean.TRUE;
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            ArrayList arrayList = ewq.a;
            ewq.e("Plugin[" /* "Plugin[" /* "Plugin[" /* cnb.z(-400574419827498L)  */ + str + "]: unLoad Failed: " /* "]: unLoad Failed: " /* "]: unLoad Failed: " /* cnb.z(-400540060089130L)  */ + thB.getMessage(), null, 14);
            SyntheticPileOfMess bmuVar = ctxVar.m;
            StringBuilder sb = new StringBuilder();
            sb.append("unLoad Failed: " /* "unLoad Failed: " /* "unLoad Failed: " /* cnb.z(-402124903021354L)  */);
            sb.append(thB.getMessage());
            bmuVar.p(sb.toString());
            objX = Boolean.FALSE;
        }
        if (((Boolean) objX).booleanValue()) {
            a.remove(ctxVar);
            b.remove(str);
            c.remove(str);
        }
    }
}
