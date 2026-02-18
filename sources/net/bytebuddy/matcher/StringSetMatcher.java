package net.bytebuddy.matcher;

import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class StringSetMatcher extends ElementMatcher.Junction.ForNonNullValues<String> {
    private final Set<String> values;

    public StringSetMatcher(Set<String> set) {
        this.values = set;
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean equals(@MaybeNull Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.values.equals(((StringSetMatcher) obj).values);
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public int hashCode() {
        return this.values.hashCode() + (super.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("in(");
        boolean z = true;
        for (String str : this.values) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // net.bytebuddy.matcher.ElementMatcher.Junction.ForNonNullValues
    public boolean doMatch(String str) {
        return this.values.contains(str);
    }
}
