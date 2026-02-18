package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ClassLoaderParentMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {

    @MaybeNull
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;

    public ClassLoaderParentMatcher(@MaybeNull ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    /* JADX WARN: Found duplicated region for block: B:19:0x0027 A[RETURN] */
    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ClassLoader classLoader = this.classLoader;
        ClassLoader classLoader2 = ((ClassLoaderParentMatcher) obj).classLoader;
        if (classLoader2 != null) {
            return classLoader != null && classLoader.equals(classLoader2);
        }
        if (classLoader != null) {
            return false;
        }
    }

    public int hashCode() {
        int iHashCode = getClass().hashCode() * 31;
        ClassLoader classLoader = this.classLoader;
        return classLoader != null ? classLoader.hashCode() + iHashCode : iHashCode;
    }

    public String toString() {
        return "isParentOf(" + this.classLoader + ')';
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull T t) {
        for (ClassLoader parent = this.classLoader; parent != null; parent = parent.getParent()) {
            if (parent == t) {
                return true;
            }
        }
        return t == null;
    }
}
