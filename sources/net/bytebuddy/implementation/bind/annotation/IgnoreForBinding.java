package net.bytebuddy.implementation.bind.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreForBinding {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Verifier {
        private Verifier() {
            throw new UnsupportedOperationException();
        }

        public static boolean check(MethodDescription methodDescription) {
            return methodDescription.getDeclaredAnnotations().isAnnotationPresent(IgnoreForBinding.class);
        }
    }
}
