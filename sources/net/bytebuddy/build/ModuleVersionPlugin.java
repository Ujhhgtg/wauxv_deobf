package net.bytebuddy.build;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ModuleVersionPlugin implements Plugin, Plugin.Factory {

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final String version;

    public ModuleVersionPlugin(@MaybeNull String str) {
        this.version = str;
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return builder.adjustModule(new ModifierContributor.ForModule[0]).version(this.version);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0027 A[RETURN] */
    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.version;
        String str2 = ((ModuleVersionPlugin) obj).version;
        if (str2 != null) {
            return str != null && str.equals(str2);
        }
        if (str != null) {
            return false;
        }
    }

    public int hashCode() {
        int iHashCode = getClass().hashCode() * 31;
        String str = this.version;
        return str != null ? str.hashCode() + iHashCode : iHashCode;
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull TypeDescription typeDescription) {
        return typeDescription != null && typeDescription.isModuleType();
    }
}
