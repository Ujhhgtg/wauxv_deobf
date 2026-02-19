package me.hd.wauxv.obf;

import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class csc {
    public HookScopeEnum hookScope;
    public String packageName;
    public String processName;
    public ClassLoader appClassLoader;
    public ApplicationInfo appInfo;

    public final String toString() {
        return "[type] " + this.hookScope + " [packageName] " + this.packageName + " [processName] " + this.processName + " [appClassLoader] " + this.appClassLoader + " [appInfo] " + this.appInfo + " [appResources] " + ((Object) null);
    }
}
