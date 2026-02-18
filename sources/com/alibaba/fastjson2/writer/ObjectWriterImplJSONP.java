package com.alibaba.fastjson2.writer;

import com.alibaba.fastjson2.JSONPObject;
import com.alibaba.fastjson2.JSONWriter;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ObjectWriterImplJSONP extends ObjectWriterPrimitiveImpl<JSONPObject> {
    @Override // com.alibaba.fastjson2.writer.ObjectWriter
    public void write(JSONWriter jSONWriter, Object obj, Object obj2, Type type, long j) {
        if ((jSONWriter.getFeatures(j) & JSONWriter.Feature.BrowserSecure.mask) != 0) {
            jSONWriter.writeRaw("/**/");
        }
        JSONPObject jSONPObject = (JSONPObject) obj;
        jSONWriter.writeRaw(jSONPObject.getFunction());
        jSONWriter.writeRaw('(');
        List<Object> parameters = jSONPObject.getParameters();
        for (int i = 0; i < parameters.size(); i++) {
            if (i != 0) {
                jSONWriter.writeRaw(',');
            }
            jSONWriter.writeAny(parameters.get(i));
        }
        jSONWriter.writeRaw(')');
    }
}
