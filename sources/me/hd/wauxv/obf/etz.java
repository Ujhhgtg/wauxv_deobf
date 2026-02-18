package me.hd.wauxv.obf;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class etz {
    public final String a;
    public final int b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;

    public etz(String str, int i, int i2) {
        this.a = (i2 & 1) != 0 ? "免费模块仅供学习,勿在国内平台传播" /* cnb.z(-51376398793514L) */ : str;
        this.b = i;
        this.c = 32.0f;
        this.d = -40.0f;
        this.e = 120.0f;
        this.f = 120.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof etz)) {
            return false;
        }
        etz etzVar = (etz) obj;
        return bzo.f(this.a, etzVar.a) && this.b == etzVar.b && Float.compare(this.c, etzVar.c) == 0 && Float.compare(this.d, etzVar.d) == 0 && Float.compare(this.e, etzVar.e) == 0 && Float.compare(this.f, etzVar.f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f) + ((Float.hashCode(this.e) + ((Float.hashCode(this.d) + ((Float.hashCode(this.c) + dts.a(this.b, this.a.hashCode() * 31, 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WatermarkConfig(text=" /* cnb.z(-51316269251370L) */);
        yg.u(sb, this.a, -51204600101674L);
        dkz.ac(sb, this.b, -51183125265194L);
        sb.append(this.c);
        sb.append(", rotationAngle=" /* cnb.z(-51646981733162L) */);
        sb.append(this.d);
        sb.append(", horizontalSpacing=" /* cnb.z(-51591147158314L) */);
        sb.append(this.e);
        sb.append(", verticalSpacing=" /* cnb.z(-51535312583466L) */);
        sb.append(this.f);
        sb.append(')');
        return sb.toString();
    }
}
