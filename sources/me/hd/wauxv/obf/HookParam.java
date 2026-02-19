package me.hd.wauxv.obf;

import de.robv.android.xposed.XposedBridge;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
// orig name: bmm
public final class HookParam {
    public static final /* synthetic */ int a = 0;
    public blq b;

    static {
        new LinkedHashMap();
    }

    public final Object callOriginalMethod() {
        Object objX;
        int iOrdinal;
        Object[] objArrD = getArgs();
        Object[] objArrCopyOf = Arrays.copyOf(objArrD, objArrD.length);
        blq blqVar = this.b;
        Member member = ((bmh) blqVar.a).b.method;
        if (member == null) {
            throw new IllegalStateException("Current hooked Member is null");
        }
        Object obj = ((bmh) blqVar.b).b.thisObject;
        try {
            iOrdinal = bhs.r().ordinal();
        } catch (Throwable th) {
            objX = FastKV.x(th);
        }
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                throw new QueryDidNotReturnUniqueResultRuntimeException();
            }
            throw new IllegalStateException(
                    "YukiHookAPI cannot support current Hook API or cannot found any available Hook APIs in current environment");
        }
        objX = XposedBridge.invokeOriginalMethod(member, obj, objArrCopyOf);
        Throwable thB = dcy.b(objX);
        if (thB != null) {
            String message = thB.getMessage();
            if (message != null) {
                String lowerCase = message.toLowerCase(Locale.ROOT);
                throwIfVar1IsNull(lowerCase, "toLowerCase(...)");
                if (dnj.ab(lowerCase, "wrong number of arguments", false)) {
                    String message2 = thB.getMessage();
                    if (message2 == null) {
                        message2 = thB.toString();
                    }
                    throw new IllegalStateException(message2.toString());
                }
            }
            ArrayList arrayList = ewq.a;
            ewq.g(4, "Invoke original Member [" + member + "] failed", thB);
        }
        if (objX instanceof dcx) {
            return null;
        }
        return objX;
    }

    public final Object[] getArgs() {
        Object[] objArrI = this.b.i();
        if (objArrI != null) {
            return objArrI;
        }
        throw new IllegalStateException("Current hooked Member args is null");
    }

    public final Object getThisObject() {
        Object obj = ((bmh) this.b.b).b.thisObject;
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("HookParam instance got null! Is this a static member?");
    }

    public final Object getResult() {
        return ((bmi) this.b.d).g(null, Boolean.FALSE);
    }

    public final void setResultTrue() {
        setResult(Boolean.TRUE);
    }

    public final void setResult(Object obj) {
        ((bmi) this.b.d).g(obj, Boolean.TRUE);
    }

    public final String toString() {
        return "HookParam(" + super.toString() + ") by " + this.b;
    }
}
