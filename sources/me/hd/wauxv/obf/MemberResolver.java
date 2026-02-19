package me.hd.wauxv.obf;

import java.util.LinkedHashSet;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MemberResolver {
    public Configuration config;
    public String name;
    public SyntheticMessOfLambdas nameCondition;
    public final LinkedHashSet modifiers = new LinkedHashSet();
    public final LinkedHashSet modifiersNot = new LinkedHashSet();
    public final LinkedHashSet annotations = new LinkedHashSet();
    public final LinkedHashSet annotationsNot = new LinkedHashSet();

    public final void enableSuperclass() {
        Configuration configurationVar = this.config;
        if (configurationVar != null) {
            configurationVar.superclass = true;
        }
    }

    public Map toFieldsNameValueMap() {
        return KotlinHelpers.mapOf(new Pair("name", this.name), new Pair("nameCondition", this.nameCondition),
                new Pair("modifiers", this.modifiers), new Pair("modifiersNot", this.modifiersNot), new Pair("modifiersCondition", null),
                new Pair("isSynthetic", null), new Pair("isSyntheticNot", null), new Pair("annotations", this.annotations),
                new Pair("annotationsNot", this.annotationsNot), new Pair("genericString", null));
    }
}
