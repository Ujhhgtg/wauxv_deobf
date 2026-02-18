package bsh;

import bsh.BshClassManager;
import java.io.Serializable;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Variable implements Serializable, BshClassManager.Listener, Cloneable {
    public static final int ASSIGNMENT = 1;
    public static final int DECLARATION = 0;
    LHS lhs;
    Modifiers modifiers;
    String name;
    Class<?> type;
    String typeDescriptor;
    Object value;

    public Variable(String str, Class<?> cls, LHS lhs) {
        this.name = str;
        this.lhs = lhs;
        this.type = cls;
    }

    private void setModifiers(Modifiers modifiers) {
        this.modifiers = modifiers;
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        if (Reflect.isGeneratedClass(this.type)) {
            try {
                this.type = Reflect.getThisNS(this.type).getClass(this.type.getName());
            } catch (UtilEvalError unused) {
            }
        }
    }

    public Modifiers getModifiers() {
        if (this.modifiers == null) {
            setModifiers(new Modifiers(3));
        }
        return this.modifiers;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public String getTypeDescriptor() {
        if (this.typeDescriptor == null) {
            Class<?> cls = this.type;
            if (cls == null) {
                cls = Object.class;
            }
            this.typeDescriptor = BSHType.getTypeDescriptor(cls);
        }
        return this.typeDescriptor;
    }

    public Object getValue() {
        LHS lhs = this.lhs;
        return lhs != null ? this.type == null ? lhs.getValue() : Primitive.wrap(lhs.getValue(), this.type) : this.value;
    }

    public boolean hasModifier(String str) {
        return getModifiers().hasModifier(str);
    }

    public void setConstant() {
        if (!hasModifier("private") && !hasModifier("protected")) {
            getModifiers().setConstant();
            return;
        }
        throw new IllegalArgumentException("Illegal modifier for interface field " + getName() + ". Only public static & final are permitted.");
    }

    public void setValue(Object obj, int i) {
        if (hasModifier("final")) {
            if (this.value != null) {
                throw new UtilEvalError(yg.o(new StringBuilder("Cannot re-assign final variable "), this.name, "."));
            }
            if (obj == null) {
                return;
            }
        }
        Class<?> cls = this.type;
        if (cls != null && cls != Object.class && obj != null) {
            obj = Types.castObject(obj, cls, i == 0 ? 0 : 1);
            this.value = obj;
        }
        this.value = obj;
        if (obj == null && i != 0) {
            this.value = Primitive.getDefaultValue(this.type);
        }
        LHS lhs = this.lhs;
        if (lhs != null) {
            this.value = lhs.assign(this.value, false);
        }
    }

    public String toString() {
        return "Variable: " + StringUtil.variableString(this) + ", value:" + this.value + ", lhs = " + this.lhs;
    }

    public void validateFinalIsSet(boolean z) {
        if (hasModifier("final") && this.value == null && z == hasModifier("static")) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "Static f" : "F");
            sb.append("inal variable ");
            throw new RuntimeException(yg.o(sb, this.name, " is not initialized."));
        }
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Variable m3clone() {
        try {
            Variable variable = (Variable) super.clone();
            Modifiers modifiers = variable.modifiers;
            variable.modifiers = modifiers != null ? modifiers.m2clone() : null;
            return variable;
        } catch (CloneNotSupportedException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public Variable(String str, Object obj, Modifiers modifiers) {
        this(str, (Class<?>) null, obj, modifiers);
    }

    public Variable(String str, String str2, Object obj, Modifiers modifiers) {
        this(str, (Class<?>) null, obj, modifiers);
        this.typeDescriptor = str2;
    }

    public Variable(String str, Class<?> cls, Object obj, Modifiers modifiers) {
        this.name = str;
        this.type = cls;
        setModifiers(modifiers);
        setValue(obj, 0);
    }
}
