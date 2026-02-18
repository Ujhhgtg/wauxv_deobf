package net.bytebuddy.dynamic.scaffold.inline;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface MethodNameTransformer {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Prefixing implements MethodNameTransformer {
        private static final String DEFAULT_PREFIX = "original";
        private final String prefix;

        public Prefixing() {
            this(DEFAULT_PREFIX);
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.prefix.equals(((Prefixing) obj).prefix);
        }

        public int hashCode() {
            return this.prefix.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer
        public String transform(MethodDescription methodDescription) {
            return this.prefix + methodDescription.getInternalName();
        }

        public Prefixing(String str) {
            this.prefix = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @HashCodeAndEqualsPlugin.Enhance
    public static class Suffixing implements MethodNameTransformer {
        private static final String DEFAULT_SUFFIX = "original$";
        private final String suffix;

        public Suffixing(String str) {
            this.suffix = str;
        }

        public static MethodNameTransformer withRandomSuffix() {
            return new Suffixing(DEFAULT_SUFFIX + RandomString.make());
        }

        public boolean equals(@MaybeNull Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.suffix.equals(((Suffixing) obj).suffix);
        }

        public int hashCode() {
            return this.suffix.hashCode() + (getClass().hashCode() * 31);
        }

        @Override // net.bytebuddy.dynamic.scaffold.inline.MethodNameTransformer
        public String transform(MethodDescription methodDescription) {
            return methodDescription.getInternalName() + "$" + this.suffix;
        }
    }

    String transform(MethodDescription methodDescription);
}
