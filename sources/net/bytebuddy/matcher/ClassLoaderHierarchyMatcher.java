package net.bytebuddy.matcher;

import java.lang.ClassLoader;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class ClassLoaderHierarchyMatcher<T extends ClassLoader> extends ElementMatcher.Junction.AbstractBase<T> {
    private final ElementMatcher<? super ClassLoader> matcher;

    public ClassLoaderHierarchyMatcher(ElementMatcher<? super ClassLoader> elementMatcher) {
        this.matcher = elementMatcher;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.matcher.equals(((ClassLoaderHierarchyMatcher) obj).matcher);
    }

    public int hashCode() {
        return this.matcher.hashCode() + (getClass().hashCode() * 31);
    }

    public String toString() {
        return "hasChild(" + this.matcher + ')';
    }

    @Override // net.bytebuddy.matcher.ElementMatcher
    public boolean matches(@MaybeNull T t) {
        while (t != null) {
            if (this.matcher.matches(t)) {
                return true;
            }
            t = (T) t.getParent();
        }
        return this.matcher.matches(null);
    }
}
