package me.hd.wauxv.obf;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class bms extends p {
    public static final Pattern[][] h = {new Pattern[]{null, null}, new Pattern[]{Pattern.compile("^<(?:script|pre|style)(?:\\s|>|$)", 2), Pattern.compile("</(?:script|pre|style)>", 2)}, new Pattern[]{Pattern.compile("^<!--"), Pattern.compile("-->")}, new Pattern[]{Pattern.compile("^<[?]"), Pattern.compile("\\?>")}, new Pattern[]{Pattern.compile("^<![A-Z]"), Pattern.compile(">")}, new Pattern[]{Pattern.compile("^<!\\[CDATA\\["), Pattern.compile("\\]\\]>")}, new Pattern[]{Pattern.compile("^</?(?:address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|nav|noframes|ol|optgroup|option|p|param|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul)(?:\\s|[/]?[>]|$)", 2), null}, new Pattern[]{Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>])\\s*$", 2), null}};
    public final Pattern j;
    public final bmr i = new bmr(0);
    public boolean k = false;
    public pe l = new pe();

    public bms(Pattern pattern) {
        this.j = pattern;
    }

    @Override // me.hd.wauxv.obf.p
    public final void a(CharSequence charSequence) {
        pe peVar = this.l;
        StringBuilder sb = peVar.a;
        if (peVar.b != 0) {
            sb.append('\n');
        }
        sb.append(charSequence);
        peVar.b++;
        Pattern pattern = this.j;
        if (pattern == null || !pattern.matcher(charSequence).find()) {
            return;
        }
        this.k = true;
    }

    @Override // me.hd.wauxv.obf.p
    public final void c() {
        this.l.a.toString();
        this.i.getClass();
        this.l = null;
    }

    @Override // me.hd.wauxv.obf.p
    public final pd d() {
        return this.i;
    }

    @Override // me.hd.wauxv.obf.p
    public final pf g(aph aphVar) {
        if (this.k) {
            return null;
        }
        if (aphVar.j && this.j == null) {
            return null;
        }
        return pf.d(aphVar.d);
    }
}
