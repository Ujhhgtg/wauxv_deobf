package me.hd.wauxv.plugin.api.method;

import java.util.Set;
import me.hd.wauxv.obf.bhs;
import me.hd.wauxv.obf.KotlinHelpers;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.cty;
import me.hd.wauxv.obf.dkz;
import me.hd.wauxv.obf.DefaultConfig;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class PluginConfigMethod {
    public final String a;

    public PluginConfigMethod(String str) {
        this.a = yg.h(-396983827168042L, dkz.y(str));
    }

    @cty
    public final boolean getBoolean(String str, boolean z) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar != null) {
            return ioVar.ah(str2, z);
        }
        throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
    }

    @cty
    public final float getFloat(String str, float f) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar != null) {
            return ioVar.aj().getFloat(str2, f);
        }
        throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
    }

    @cty
    public final int getInt(String str, int i) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar != null) {
            return ioVar.aj().getInt(str2, i);
        }
        throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
    }

    @cty
    public final long getLong(String str, long j) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar != null) {
            return ioVar.aj().getLong(str2, j);
        }
        throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
    }

    @cty
    public final String getString(String str, String str2) {
        String str3 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        String string = ioVar.aj().getString(str3, str2);
        throwIfVar1IsNull(string);
        return string;
    }

    @cty
    public final Set<String> getStringSet(String str, Set<String> set) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        Set<String> stringSet = ioVar.aj().getStringSet(str2, set);
        throwIfVar1IsNull(stringSet);
        return stringSet;
    }

    @cty
    public final void putBoolean(String str, boolean z) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.at(str2, z);
    }

    @cty
    public final void putFloat(String str, float f) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.aj().putFloat(str2, f);
    }

    @cty
    public final void putInt(String str, int i) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.aj().putInt(str2, i);
    }

    @cty
    public final void putLong(String str, long j) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.aj().putLong(str2, j);
    }

    @cty
    public final void putString(String str, String str2) {
        String str3 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.aj().putString(str3, str2);
    }

    @cty
    public final void putStringSet(String str, Set<String> set) {
        String str2 = this.a + TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH + str;
        DefaultConfig ioVar = bhs.h;
        if (ioVar == null) {
            throw new IllegalArgumentException("PluginConfig must be init" /* cnb.z(-29368986368810L) */.toString());
        }
        ioVar.aj().putStringSet(str2, set);
    }
}
