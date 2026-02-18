package net.bytebuddy.utility.privilege;

import java.lang.reflect.Method;
import java.security.PrivilegedAction;
import java.util.Arrays;
import me.hd.wauxv.obf.bjs;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.utility.nullability.MaybeNull;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
@HashCodeAndEqualsPlugin.Enhance
public class GetMethodAction implements PrivilegedAction<Method> {
    private final String name;
    private final Class<?>[] parameter;
    private final String type;

    public GetMethodAction(String str, String str2, Class<?>... clsArr) {
        this.type = str;
        this.name = str2;
        this.parameter = clsArr;
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GetMethodAction getMethodAction = (GetMethodAction) obj;
        return this.type.equals(getMethodAction.type) && this.name.equals(getMethodAction.name) && Arrays.equals(this.parameter, getMethodAction.parameter);
    }

    public int hashCode() {
        return bjs.e(this.name, bjs.e(this.type, getClass().hashCode() * 31, 31), 31) + Arrays.hashCode(this.parameter);
    }

    @Override // java.security.PrivilegedAction
    @MaybeNull
    public Method run() {
        try {
            return Class.forName(this.type).getMethod(this.name, this.parameter);
        } catch (Exception unused) {
            return null;
        }
    }
}
