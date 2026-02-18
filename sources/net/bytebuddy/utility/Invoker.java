package net.bytebuddy.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface Invoker {
    @MaybeNull
    Object invoke(Method method, @MaybeNull Object obj, @MaybeNull Object[] objArr);

    Object newInstance(Constructor<?> constructor, Object[] objArr);
}
