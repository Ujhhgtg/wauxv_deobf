package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afa extends afb {
    @Override // me.hd.wauxv.obf.aet
    public final byte a() {
        return (byte) 6;
    }

    @Override // me.hd.wauxv.obf.aet
    public final boolean c() {
        String str = (String) this.i;
        if (str == null) {
            return false;
        }
        return "true".equalsIgnoreCase(str);
    }

    @Override // me.hd.wauxv.obf.aet
    public final float d() {
        String str = (String) this.i;
        if (str == null || str.isEmpty()) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str.trim());
        } catch (NumberFormatException unused) {
            return 0.0f;
        }
    }

    @Override // me.hd.wauxv.obf.aet
    public final int e() {
        String str = (String) this.i;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        try {
            return str.contains(".") ? (int) Double.parseDouble(str) : Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // me.hd.wauxv.obf.aet
    public final long f() {
        String str = (String) this.i;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        try {
            return str.contains(".") ? (long) Double.parseDouble(str) : Long.parseLong(str.trim());
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // me.hd.wauxv.obf.aet
    public final String g() {
        Object obj = this.i;
        return obj != null ? (String) obj : "";
    }
}
