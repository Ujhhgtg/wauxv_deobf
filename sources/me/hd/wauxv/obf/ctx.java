package me.hd.wauxv.obf;

import bsh.BshMethod;
import bsh.EvalError;
import bsh.Interpreter;
import bsh.Primitive;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import me.hd.wauxv.plugin.api.method.PluginAudioMethod;
import me.hd.wauxv.plugin.api.method.PluginConfigMethod;
import me.hd.wauxv.plugin.api.method.PluginContactMethod;
import me.hd.wauxv.plugin.api.method.PluginHttpMethod;
import me.hd.wauxv.plugin.api.method.PluginMediaMsgMethod;
import me.hd.wauxv.plugin.api.method.PluginMsgMethod;
import me.hd.wauxv.plugin.api.method.PluginOtherMethod;
import me.hd.wauxv.plugin.api.method.PluginSnsMethod;
import me.hd.wauxv.plugin.api.method.PluginVipMethod;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ctx {
    public final File a;
    public final File b;
    public final File c;
    public final File d;
    public final dov e;
    public final String f;
    public final dov g;
    public final dov h;
    public final dov i;
    public final dov j;
    public final dov k;
    public final String l;
    public final bmu m;

    public ctx(File file) {
        this.a = file;
        this.b = new File(file, "main.java" /* "main.java" /* "main.java" /* cnb.z(-400376851331882L)  */);
        this.c = new File(file, "info.prop" /* "info.prop" /* "info.prop" /* cnb.z(-400351081528106L)  */);
        this.d = new File(file, "readme.md" /* "readme.md" /* "readme.md" /* cnb.z(-400325311724330L)  */);
        final int i = 0;
        this.e = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        String name = file.getName();
        this.f = name;
        final int i2 = 1;
        this.g = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i2) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        final int i3 = 2;
        this.h = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i3) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        final int i4 = 3;
        this.i = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i4) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        final int i5 = 4;
        this.j = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i5) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        final int i6 = 5;
        this.k = new dov(new bfu(this) { // from class: me.hd.wauxv.obf.ctw
            public final /* synthetic */ ctx b;

            {
                this.b = this;
            }

            @Override // me.hd.wauxv.obf.bfu
            public final Object invoke() throws IOException {
                switch (i6) {
                    case 0:
                        Properties properties = new Properties();
                        ctx ctxVar = this.b;
                        if (ctxVar.c.exists()) {
                            properties.load(new BufferedReader(
                                    new InputStreamReader(new FileInputStream(ctxVar.c), uj.a), 8192));
                        }
                        return properties;
                    case 1:
                        return ((Properties) this.b.e.getValue()).getProperty("name" /* "name" /* "name" /* cnb.z(-401639571716906L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401652456618794L)  */);
                    case 2:
                        return ((Properties) this.b.e.getValue()).getProperty("author" /* "author" /* "author" /* cnb.z(-401605211978538L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-401626686815018L)  */);
                    case 3:
                        return ((Properties) this.b.e.getValue()).getProperty("version" /* "version" /* "version" /* cnb.z(-390034570083114L)  */,
                                "未知" /* "未知" /* "未知" /* cnb.z(-390000210344746L)  */);
                    case 4:
                        return ((Properties) this.b.e.getValue()).getProperty("updateTime" /*
                                                                                            * "updateTime" /* "updateTime" /* cnb.z(-390004505312042L)  */
                                                                                            */, "未知" /*
                                                                                                      * cnb.z(-
                                                                                                      * 389922900933418L)
                                                                                                      */);
                    default:
                        ctx ctxVar2 = this.b;
                        File file2 = ctxVar2.d;
                        if (file2.exists()) {
                            return bad.c(file2);
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("# " /* "# " /* "# " /* cnb.z(-389927195900714L)  */ + ((String) ctxVar2.g.getValue()));
                        sb.append("\n\n");
                        sb.append("**作者**: " /* "**作者**: " /* "**作者**: " /* cnb.z(-389948670737194L)  */ + ((String) ctxVar2.h.getValue()));
                        sb.append("\n\n");
                        sb.append("---" /* "---" /* "---" /* cnb.z(-389910016031530L)  */);
                        sb.append("\n\n");
                        sb.append("暂无相关描述" /* "暂无相关描述" /* "暂无相关描述" /* cnb.z(-389858476423978L)  */);
                        sb.append('\n');
                        return sb.toString();
                }
            }
        });
        this.l = yg.h(-400230822443818L, dkz.y(name));
        this.m = new bmu(this);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ctx) && nullSafeIsEqual(((ctx) obj).b.getAbsolutePath(), this.b.getAbsolutePath());
    }

    public final int hashCode() {
        return this.b.getAbsolutePath().hashCode();
    }

    /* JADX WARN: Found duplicated region for block: B:29:0x0068 */
    /* JADX WARN: Found duplicated region for block: B:33:0x00e0 */
    /* JADX WARN: Found duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    public final Object n(String str, Object... objArr) throws IOException {
        Object objX;
        Throwable thB;
        BshMethod[] methods;
        int length;
        int i;
        BshMethod bshMethod;
        boolean z;
        if (this.b.exists()) {
            try {
                methods = o().getNameSpace().getMethods();
                length = methods.length;
                i = 0;
                bshMethod = null;
                z = false;
            } catch (Throwable th) {
                objX = bhu.x(th);
            }
            while (true) {
                if (i >= length) {
                    if (!z) {
                    }
                    thB = dcy.b(objX);
                    if (thB != null) {
                        ArrayList arrayList = ewq.a;
                        ewq.e("Plugin[" /* "Plugin[" /* "Plugin[" /* cnb.z(-402288111778602L)  */ + this.f
                                + "]: callBshMethod " /* "]: callBshMethod " /* "]: callBshMethod " /* cnb.z(-402253752040234L)  */ + str
                                + " Failed: " /* " Failed: " /* " Failed: " /* cnb.z(-402193622498090L)  */ + thB.getMessage(), null, 14);
                        StringBuilder sb = new StringBuilder();
                        sb.append("callBshMethod " /* "callBshMethod " /* "callBshMethod " /* cnb.z(-402167852694314L)  */);
                        sb.append(str);
                        sb.append(" Failed: " /* " Failed: " /* " Failed: " /* cnb.z(-401553672370986L)  */);
                        sb.append(thB.getMessage());
                        this.m.p(sb.toString());
                    }
                    if (objX instanceof dcx) {
                        return null;
                    }
                    return objX;
                }
                BshMethod bshMethod2 = methods[i];
                if (nullSafeIsEqual(bshMethod2.getName(), str)) {
                    if (!z) {
                        z = true;
                        bshMethod = bshMethod2;
                    }
                }
                i++;
                bshMethod = null;
                break;
            }
            if (bshMethod != null) {
                objX = bshMethod.invoke(objArr, o());
                if (objX instanceof Primitive) {
                    objX = nullSafeIsEqual(((Primitive) objX).getType(), Void.TYPE) ? KotlinUnit.INSTANCE
                            : ((Primitive) objX).getValue();
                }
                thB = dcy.b(objX);
                if (thB != null) {
                    ArrayList arrayList2 = ewq.a;
                    ewq.e("Plugin[" /* "Plugin[" /* "Plugin[" /* cnb.z(-402288111778602L)  */ + this.f
                            + "]: callBshMethod " /* "]: callBshMethod " /* "]: callBshMethod " /* cnb.z(-402253752040234L)  */ + str
                            + " Failed: " /* " Failed: " /* " Failed: " /* cnb.z(-402193622498090L)  */ + thB.getMessage(), null, 14);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("callBshMethod " /* "callBshMethod " /* "callBshMethod " /* cnb.z(-402167852694314L)  */);
                    sb2.append(str);
                    sb2.append(" Failed: " /* " Failed: " /* " Failed: " /* cnb.z(-401553672370986L)  */);
                    sb2.append(thB.getMessage());
                    this.m.p(sb2.toString());
                }
                if (objX instanceof dcx) {
                    return null;
                }
                return objX;
            }
        }
        return null;
    }

    public final Interpreter o() throws EvalError {
        HashMap map = cuk.c;
        HashMap map2 = cuk.b;
        String str = this.f;
        boolean zContainsKey = map2.containsKey(str);
        File file = this.b;
        if (zContainsKey && nullSafeIsEqual(map.get(str), bht.w(file))) {
            Object obj = map2.get(str);
            throwIfVar1IsNull(obj);
            return (Interpreter) obj;
        }
        Interpreter interpreter = new Interpreter();
        interpreter.setClassLoader(cud.class.getClassLoader());
        String strZ = "hostContext" /* "hostContext" /* "hostContext" /* cnb.z(-390245023480618L)  */;
        bmo.a.getClass();
        interpreter.set(strZ, bmo.n());
        String strZ2 = "hostVerName" /* "hostVerName" /* "hostVerName" /* cnb.z(-390159124134698L)  */;
        bc bcVar = bmo.i;
        btc[] btcVarArr = bmo.b;
        interpreter.set(strZ2, (String) bcVar.h(btcVarArr[6]));
        interpreter.set("hostVerCode" /* "hostVerCode" /* "hostVerCode" /* cnb.z(-390141944265514L)  */, bmo.q());
        interpreter.set("hostVerClient" /* "hostVerClient" /* "hostVerClient" /* cnb.z(-390056044919594L)  */, (String) bmo.k.h(btcVarArr[8]));
        interpreter.set("moduleVer" /* "moduleVer" /* "moduleVer" /* cnb.z(-389497699171114L)  */, 1238);
        String strZ3 = "cacheDir" /* "cacheDir" /* "cacheDir" /* cnb.z(-389403209890602L)  */;
        dov dovVar = ctf.a;
        interpreter.set(strZ3, ctf.c("Cache" /* "Cache" /* "Cache" /* cnb.z(-47098611366698L)  */));
        interpreter.set("pluginDir" /* "pluginDir" /* "pluginDir" /* cnb.z(-389381735054122L)  */, this.a);
        interpreter.set("pluginId" /* "pluginId" /* "pluginId" /* cnb.z(-389355965250346L)  */, str);
        interpreter.set("pluginName" /* "pluginName" /* "pluginName" /* cnb.z(-389317310544682L)  */, (String) this.g.getValue());
        interpreter.set("pluginAuthor" /* "pluginAuthor" /* "pluginAuthor" /* cnb.z(-389235706166058L)  */, (String) this.h.getValue());
        interpreter.set("pluginVersion" /* "pluginVersion" /* "pluginVersion" /* cnb.z(-389763987143466L)  */, (String) this.i.getValue());
        interpreter.set("pluginUpdateTime" /* "pluginUpdateTime" /* "pluginUpdateTime" /* cnb.z(-389686677732138L)  */, (String) this.j.getValue());
        cuk.f(interpreter, new PluginAudioMethod());
        cuk.f(interpreter, new PluginConfigMethod(str));
        cuk.f(interpreter, new PluginContactMethod());
        cuk.f(interpreter, new PluginHttpMethod());
        cuk.f(interpreter, new PluginMediaMsgMethod());
        cuk.f(interpreter, new PluginMsgMethod());
        cuk.f(interpreter, new PluginOtherMethod(this));
        cuk.f(interpreter, new PluginSnsMethod());
        cuk.f(interpreter, new PluginVipMethod());
        map2.put(str, interpreter);
        map.put(str, bht.w(file));
        interpreter.eval(new InputStreamReader(new FileInputStream(file), uj.a));
        return interpreter;
    }

    public final boolean p() {
        DefaultConfig ioVar = bhs.h;
        if (ioVar != null) {
            return ioVar.ah(this.l, false);
        }
        throw new IllegalArgumentException("PluginConfig must be init" /* "PluginConfig must be init" /* "PluginConfig must be init" /* cnb.z(-29368986368810L)  */.toString());
    }

    public final void q(boolean z) {
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* "PluginConfig must be init" /* "PluginConfig must be init" /* cnb.z(-29368986368810L)  */.toString());
        }
        ioVar.at(this.l, z);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Plugin(pluginDir=" /* "Plugin(pluginDir=" /* "Plugin(pluginDir=" /* cnb.z(-401527902567210L)  */);
        sb.append(this.a);
        sb.append(", id='" /* ", id='" /* ", id='" /* cnb.z(-401399053548330L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.f, -401420528384810L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, (String) this.g.getValue(), -401326039104298L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, (String) this.h.getValue(), -401858615049002L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, (String) this.i.getValue(), -401785600604970L);
        sb.append((String) this.j.getValue());
        sb.append("', isEnabled=" /* "', isEnabled=" /* "', isEnabled=" /* cnb.z(-401716881128234L)  */);
        sb.append(p());
        sb.append(')');
        return sb.toString();
    }
}
