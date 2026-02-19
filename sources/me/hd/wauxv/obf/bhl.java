package me.hd.wauxv.obf;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bhl implements Serializable {
    public String a;
    public String b;
    public String c;
    public String d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bhl)) {
            return false;
        }
        bhl bhlVar = (bhl) obj;
        return nullSafeIsEqual(this.a, bhlVar.a) && nullSafeIsEqual(this.b, bhlVar.b)
                && nullSafeIsEqual(this.c, bhlVar.c) && nullSafeIsEqual(this.d, bhlVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + bjs.e(this.c, bjs.e(this.b, this.a.hashCode() * 31, 31), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GithubReleaseBean(name=" /* "GithubReleaseBean(name=" /* "GithubReleaseBean(name=" /* cnb.z(-46145128626986L)  */);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.a, -46042049411882L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.b, -45943265164074L);
        yg.decryptVar2UsingCnbZAndConcatToVar1(sb, this.c, -45930380262186L);
        return concat(sb, this.d, ')');
    }
}
