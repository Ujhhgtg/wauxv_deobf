package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class cbh {
    public cbg aa;
    public String ab;
    public dko ac;
    public final LinkedHashSet ad = new LinkedHashSet();
    public final LinkedHashSet ae = new LinkedHashSet();
    public final LinkedHashSet af = new LinkedHashSet();
    public final LinkedHashSet ag = new LinkedHashSet();

    public final void ah() {
        cbg cbgVar = this.aa;
        if (cbgVar != null) {
            cbgVar.d = true;
        }
    }

    public Map x() {
        return KotlinHelpers.ai(new Pair("name", this.ab), new Pair("nameCondition", this.ac),
                new Pair("modifiers", this.ad), new Pair("modifiersNot", this.ae), new Pair("modifiersCondition", null),
                new Pair("isSynthetic", null), new Pair("isSyntheticNot", null), new Pair("annotations", this.af),
                new Pair("annotationsNot", this.ag), new Pair("genericString", null));
    }
}
