package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.fastjson2.JSONObject;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class bjs {
    public static final void a(int i, View view, ViewGroup viewGroup) {
        throwIfVar1IsNull(view, "view");
        throwIfVar1IsNull(viewGroup, "container");
        if (beg.ar(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Calling apply state");
        }
        int iAe = StaticHelpers6.ae(i);
        if (iAe == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                if (beg.ar(2)) {
                    Log.v("FragmentManager",
                            "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
                }
                viewGroup2.removeView(view);
                return;
            }
            return;
        }
        if (iAe == 1) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            ViewParent parent2 = view.getParent();
            if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                if (beg.ar(2)) {
                    Log.v("FragmentManager",
                            "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                }
                viewGroup.addView(view);
            }
            view.setVisibility(0);
            return;
        }
        if (iAe == 2) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iAe != 3) {
            return;
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static /* synthetic */ String aa(int i) {
        switch (i) {
            case 1:
                return "METHOD_HANDLE_TYPE_STATIC_PUT";
            case 2:
                return "METHOD_HANDLE_TYPE_STATIC_GET";
            case 3:
                return "METHOD_HANDLE_TYPE_INSTANCE_PUT";
            case 4:
                return "METHOD_HANDLE_TYPE_INSTANCE_GET";
            case 5:
                return "METHOD_HANDLE_TYPE_INVOKE_STATIC";
            case 6:
                return "METHOD_HANDLE_TYPE_INVOKE_INSTANCE";
            case 7:
                return "METHOD_HANDLE_TYPE_INVOKE_DIRECT";
            case 8:
                return "METHOD_HANDLE_TYPE_INVOKE_CONSTRUCTOR";
            case 9:
                return "METHOD_HANDLE_TYPE_INVOKE_INTERFACE";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String ab(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String ac(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static /* synthetic */ boolean b(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static int c(int i, int i2, int i3, int i4) {
        return (i * i2) + i3 + i4;
    }

    public static int d(int i, int i2, Class cls) {
        return (cls.hashCode() + i) * i2;
    }

    public static int e(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static int f(ByteBuffer byteBuffer, ByteOrder byteOrder) {
        byteBuffer.order(byteOrder);
        return byteBuffer.getInt(byteBuffer.position());
    }

    public static int g(List list, int i, int i2) {
        return (list.hashCode() + i) * i2;
    }

    public static Object resolveFirstMethodWithoutParams(MethodResolver methodResolverVar) {
        methodResolverVar.setParamCountTo0();
        return StaticHelpers5.safeGetFirstInList(methodResolverVar.findMethods());
    }

    public static String i(int i, String str) {
        return str + i;
    }

    public static String j(int i, StringBuilder sb) {
        sb.append(Integer.toString(i));
        return sb.toString();
    }

    public static String k(long j, JSONObject jSONObject) {
        return String.valueOf(jSONObject.getByPath(cnb.z(j)));
    }

    // replaced with human readable concat()
    // public static String l(Class cls, String str) {
    // return str + cls;
    // }

    // replaced with human readable concat()
    // public static String m(Object obj, StringBuilder sb) {
    // sb.append(obj.getClass());
    // return sb.toString();
    // }

    // replaced with human readable concat()
    // public static String n(Object obj, StringBuilder sb, String str) {
    // sb.append(obj.getClass());
    // sb.append(str);
    // return sb.toString();
    // }

    // replaced with human readable concat()
    // public static String o(String str, String str2, String str3) {
    // return str + str2 + str3;
    // }

    // replaced with human readable concat()
    // public static String p(StringBuilder sb, Integer num, char c) {
    // sb.append(num);
    // sb.append(c);
    // return sb.toString();
    // }

    // replaced with human readable concat()
    // public static String q(StringBuilder sb, String str, char c) {
    // sb.append(str);
    // sb.append(c);
    // return sb.toString();
    // }

    // replaced with human readable concat()
    // public static StringBuilder r(String str, String str2) {
    // StringBuilder sb = new StringBuilder();
    // sb.append(str);
    // sb.append(str2);
    // return sb;
    // }

    public static BigInteger s(long j, BigInteger bigInteger, BigInteger bigInteger2) {
        throwIfVar1IsNull(bigInteger, cnb.z(j));
        return bigInteger.and(bigInteger2);
    }

    public static /* synthetic */ void t(int i, String str) {
        if (i == 0) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = KotlinHelpers.class.getName();
            int i2 = 0;
            while (!stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            while (stackTrace[i2].getClassName().equals(name)) {
                i2++;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            NullPointerException nullPointerException = new NullPointerException(
                    "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "."
                            + stackTraceElement.getMethodName() + ", parameter " + str);
            KotlinHelpers.trimStackTraceToClass(nullPointerException, KotlinHelpers.class.getName());
            throw nullPointerException;
        }
    }

    public static void u(long j, cuc cucVar, boolean z, int i) {
        cucVar.x(cnb.z(j), z);
        cucVar.y(new aoz(i, 5));
    }

    public static void v(StringBuilder sb, Float f, long j) {
        sb.append(f);
        sb.append(cnb.z(j));
    }

    public static void w(StringBuilder sb, Integer num, long j) {
        sb.append(num);
        sb.append(cnb.z(j));
    }

    public static void x(amd amdVar, bzy bzyVar, String str) {
        bzyVar.r(str, new amw(amdVar, 1));
    }

    public static void y(long j, cuc cucVar, boolean z, int i) {
        cucVar.x(cnb.z(j), z);
        cucVar.y(new aoz(i, 8));
    }

    public static /* synthetic */ String z(int i) {
        switch (i) {
            case 1:
                return "GET";
            case 2:
                return "HEAD";
            case 3:
                return "OPTIONS";
            case 4:
                return "TRACE";
            case 5:
                return "POST";
            case 6:
                return "DELETE";
            case 7:
                return "PUT";
            case 8:
                return "PATCH";
            default:
                throw null;
        }
    }
}
