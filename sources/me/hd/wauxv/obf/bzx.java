package me.hd.wauxv.obf;

import java.util.List;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bzx {
    public final Matcher a;
    public final CharSequence b;
    public final bzw c;
    public bzv d;

    public bzx(Matcher matcher, CharSequence charSequence) {
        bzo.q(charSequence, "input");
        this.a = matcher;
        this.b = charSequence;
        this.c = new bzw(this);
    }

    public final List e() {
        if (this.d == null) {
            this.d = new bzv(this, 0);
        }
        bzv bzvVar = this.d;
        bzo.n(bzvVar);
        return bzvVar;
    }

    public final bqi f() {
        Matcher matcher = this.a;
        return dqc.bm(matcher.start(), matcher.end());
    }

    public final bzx g() {
        Matcher matcher = this.a;
        int iEnd = matcher.end() + (matcher.end() == matcher.start() ? 1 : 0);
        CharSequence charSequence = this.b;
        if (iEnd > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        bzo.p(matcher2, "matcher(...)");
        return ewz.y(matcher2, iEnd, charSequence);
    }
}
