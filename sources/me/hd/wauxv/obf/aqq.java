package me.hd.wauxv.obf;

import com.alibaba.fastjson2.util.DynamicClassLoader;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aqq implements PrivilegedAction {
    @Override // java.security.PrivilegedAction
    public final Object run() {
        return DynamicClassLoader.class.getProtectionDomain();
    }
}
