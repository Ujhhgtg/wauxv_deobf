package bsh;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import me.hd.wauxv.obf.rb;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ExternalNameSpace extends NameSpace {
    private Map<String, Object> externalMap;

    public ExternalNameSpace() {
        this(null, "External Map Namespace", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$getVariableNames$0(int i) {
        return new String[i];
    }

    @Override // bsh.NameSpace
    public void clear() {
        super.clear();
        this.externalMap.clear();
    }

    @Override // bsh.NameSpace
    public Variable createVariable(String str, Class cls, Object obj, Modifiers modifiers) {
        LHS lhs = new LHS(this.externalMap, str);
        try {
            lhs.assign(obj, false);
            return new Variable(str, (Class<?>) cls, lhs);
        } catch (UtilEvalError e) {
            throw new InterpreterError(e.toString());
        }
    }

    public Map<String, Object> getMap() {
        return this.externalMap;
    }

    @Override // bsh.NameSpace
    public Variable getVariableImpl(String str, boolean z) {
        Object obj = this.externalMap.get(str);
        if (obj == null && this.externalMap.containsKey(str)) {
            obj = Primitive.NULL;
        }
        if (obj == null) {
            super.unsetVariable(str);
            return super.getVariableImpl(str, z);
        }
        Variable variableImpl = super.getVariableImpl(str, false);
        return variableImpl == null ? createVariable(str, null, obj, null) : variableImpl;
    }

    @Override // bsh.NameSpace
    public String[] getVariableNames() {
        return (String[]) Stream.concat(Stream.of((Object[]) super.getVariableNames()), this.externalMap.keySet().stream()).toArray(new rb(4));
    }

    public void setMap(Map<String, Object> map) {
        clear();
        this.externalMap = map;
    }

    @Override // bsh.NameSpace
    public void unsetVariable(String str) {
        super.unsetVariable(str);
        this.externalMap.remove(str);
    }

    public ExternalNameSpace(NameSpace nameSpace, String str, Map<String, Object> map) {
        super(nameSpace, str);
        this.externalMap = map == null ? new HashMap<>() : map;
    }
}
