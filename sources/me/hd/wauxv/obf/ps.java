package me.hd.wauxv.obf;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ps extends cjv {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ps(int i, boolean z) {
        super(z);
        this.a = i;
    }

    @Override // me.hd.wauxv.obf.cjv
    public String b(Object obj) {
        switch (this.a) {
            case 5:
                String str = (String) obj;
                return str != null ? arj.w(str) : "null";
            default:
                return super.b(obj);
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object f(String str, Bundle bundle) {
        switch (this.a) {
            case 0:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                boolean z = bundle.getBoolean(str, false);
                if (z || !bundle.getBoolean(str, true)) {
                    return Boolean.valueOf(z);
                }
                cmz.ad(str);
                throw null;
            case 1:
                bzo.q(bundle, "bundle");
                float f = bundle.getFloat(str, Float.MIN_VALUE);
                if (f != Float.MIN_VALUE || bundle.getFloat(str, Float.MAX_VALUE) != Float.MAX_VALUE) {
                    return Float.valueOf(f);
                }
                cmz.ad(str);
                throw null;
            case 2:
                bzo.q(bundle, "bundle");
                return Integer.valueOf(bzo.v(str, bundle));
            case 3:
                bzo.q(bundle, "bundle");
                long j = bundle.getLong(str, Long.MIN_VALUE);
                if (j != Long.MIN_VALUE || bundle.getLong(str, Long.MAX_VALUE) != Long.MAX_VALUE) {
                    return Long.valueOf(j);
                }
                cmz.ad(str);
                throw null;
            case 4:
                bzo.q(bundle, "bundle");
                return Integer.valueOf(bzo.v(str, bundle));
            default:
                bzo.q(bundle, "bundle");
                if (!bundle.containsKey(str) || bzo.ae(str, bundle)) {
                    return null;
                }
                String string = bundle.getString(str);
                if (string != null) {
                    return string;
                }
                cmz.ad(str);
                throw null;
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final String g() {
        switch (this.a) {
            case 0:
                return "boolean";
            case 1:
                return "float";
            case 2:
                return "integer";
            case 3:
                return "long";
            case 4:
                return "reference";
            default:
                return "string";
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final Object i(String str) {
        boolean z;
        int i;
        String strSubstring;
        long j;
        int i2;
        switch (this.a) {
            case 0:
                bzo.q(str, "value");
                if (str.equals("true")) {
                    z = true;
                } else {
                    if (!str.equals("false")) {
                        throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                bzo.q(str, "value");
                return Float.valueOf(Float.parseFloat(str));
            case 2:
                bzo.q(str, "value");
                if (dnr.bp(str, "0x", false)) {
                    String strSubstring2 = str.substring(2);
                    bzo.p(strSubstring2, "substring(...)");
                    cmz.o(16);
                    i = Integer.parseInt(strSubstring2, 16);
                } else {
                    i = Integer.parseInt(str);
                }
                return Integer.valueOf(i);
            case 3:
                bzo.q(str, "value");
                if (dnr.bi(str, "L")) {
                    strSubstring = str.substring(0, str.length() - 1);
                    bzo.p(strSubstring, "substring(...)");
                } else {
                    strSubstring = str;
                }
                if (dnr.bp(str, "0x", false)) {
                    String strSubstring3 = strSubstring.substring(2);
                    bzo.p(strSubstring3, "substring(...)");
                    cmz.o(16);
                    j = Long.parseLong(strSubstring3, 16);
                } else {
                    j = Long.parseLong(strSubstring);
                }
                return Long.valueOf(j);
            case 4:
                bzo.q(str, "value");
                if (dnr.bp(str, "0x", false)) {
                    String strSubstring4 = str.substring(2);
                    bzo.p(strSubstring4, "substring(...)");
                    cmz.o(16);
                    i2 = Integer.parseInt(strSubstring4, 16);
                } else {
                    i2 = Integer.parseInt(str);
                }
                return Integer.valueOf(i2);
            default:
                bzo.q(str, "value");
                if (str.equals("null")) {
                    return null;
                }
                return str;
        }
    }

    @Override // me.hd.wauxv.obf.cjv
    public final void j(Bundle bundle, String str, Object obj) {
        switch (this.a) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                bzo.q(str, "key");
                bundle.putBoolean(str, zBooleanValue);
                break;
            case 1:
                float fFloatValue = ((Number) obj).floatValue();
                bzo.q(str, "key");
                bundle.putFloat(str, fFloatValue);
                break;
            case 2:
                int iIntValue = ((Number) obj).intValue();
                bzo.q(str, "key");
                bundle.putInt(str, iIntValue);
                break;
            case 3:
                long jLongValue = ((Number) obj).longValue();
                bzo.q(str, "key");
                bundle.putLong(str, jLongValue);
                break;
            case 4:
                int iIntValue2 = ((Number) obj).intValue();
                bzo.q(str, "key");
                bundle.putInt(str, iIntValue2);
                break;
            default:
                String str2 = (String) obj;
                bzo.q(str, "key");
                if (str2 == null) {
                    cnb.af(str, bundle);
                } else {
                    cnb.ah(str, str2, bundle);
                }
                break;
        }
    }
}
