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
        return bzo.ai(new csm("name", this.ab), new csm("nameCondition", this.ac), new csm("modifiers", this.ad), new csm("modifiersNot", this.ae), new csm("modifiersCondition", null), new csm("isSynthetic", null), new csm("isSyntheticNot", null), new csm("annotations", this.af), new csm("annotationsNot", this.ag), new csm("genericString", null));
    }
}
