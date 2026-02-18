package net.bytebuddy.utility.nullability;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Nonnull
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NeverNull {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    @Target({ElementType.PACKAGE})
    @TypeQualifierDefault({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Nonnull
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ByDefault {
    }
}
