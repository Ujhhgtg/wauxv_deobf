package net.bytebuddy.matcher;

import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ClassFileVersionMatcher<T extends TypeDescription> extends ElementMatcher.Junction.ForNonNullValues<T> {
    private final boolean atMost;
    private final ClassFileVersion classFileVersion;

    public ClassFileVersionMatcher(ClassFileVersion classFileVersion, boolean z) {
        this.classFileVersion = classFileVersion;
        this.atMost = z;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassFileVersionMatcher classFileVersionMatcher = (ClassFileVersionMatcher) obj;
        return this.atMost == classFileVersionMatcher.atMost && this.classFileVersion.equals(classFileVersionMatcher.classFileVersion);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return ((this.classFileVersion.hashCode() + (super.hashCode() * 31)) * 31) + (this.atMost ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("hasClassFileVersion(at ");
        sb.append(this.atMost ? "most" : "least");
        sb.append(" ");
        sb.append(this.classFileVersion);
        sb.append(")");
        return sb.toString();
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(T t) {
        ClassFileVersion classFileVersion = t.getClassFileVersion();
        if (classFileVersion != null) {
            return this.atMost ? classFileVersion.isAtMost(this.classFileVersion) : classFileVersion.isAtLeast(this.classFileVersion);
        }
        return false;
    }
}
