package bsh;

import bsh.Types;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class LHS implements ParserConstants, Serializable {
    static final int FIELD = 1;
    static final int INDEX = 3;
    static final int LOOSETYPE_FIELD = 5;
    static final int MAP_ENTRY = 6;
    static final int METHOD_EVAL = 4;
    static final int PROPERTY = 2;
    static final int VARIABLE = 0;
    private static final long serialVersionUID = 1;
    Invocable field;
    int index;
    boolean localVar;
    NameSpace nameSpace;
    Object object;
    Object propName;
    int type;
    Variable var;
    String varName;

    public LHS(NameSpace nameSpace, String str, boolean z) {
        this.type = 0;
        this.localVar = z;
        this.varName = str;
        this.nameSpace = nameSpace;
    }

    private Object getValueImpl() throws UtilEvalError {
        int i = this.type;
        if (i == 0) {
            return this.nameSpace.getVariableOrProperty(this.varName, null);
        }
        if (i == 1) {
            try {
                Invocable invocable = this.field;
                Objects.requireNonNull(invocable, "get value, field cannot be null");
                return invocable.invoke(this.object, new Object[0]);
            } catch (ReflectiveOperationException e) {
                throw new UtilEvalError("Can't read field: " + this.field, e);
            }
        }
        if (i == 2) {
            try {
                return Reflect.getObjectProperty(this.object, this.propName);
            } catch (ReflectError e2) {
                Interpreter.debug(e2.getMessage());
                throw new UtilEvalError("No such property: " + this.propName, e2);
            }
        }
        if (i != 3) {
            if (i == 5) {
                return this.nameSpace.getVariable(this.varName);
            }
            throw new InterpreterError("LHS type");
        }
        try {
            return BshArray.getIndex(this.object, this.index);
        } catch (Exception e3) {
            throw new UtilEvalError("Array access: " + e3, e3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object obj = this.object;
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        Object obj2 = this.object;
        if (obj2 instanceof Class) {
            cls = (Class) obj2;
        }
        this.field = BshClassManager.memberCache.get(cls).findField(this.varName);
    }

    private synchronized void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            Invocable invocable = this.field;
            if (invocable != null) {
                this.object = invocable.getDeclaringClass();
                this.varName = this.field.getName();
                this.field = null;
            }
            objectOutputStream.defaultWriteObject();
        } catch (Throwable th) {
            throw th;
        }
    }

    public Object assign(Object obj) {
        return assign(obj, false);
    }

    public String getName() {
        Invocable invocable = this.field;
        if (invocable != null) {
            return invocable.getName();
        }
        Variable variable = this.var;
        return variable != null ? variable.getName() : this.varName;
    }

    public Class<?> getType() {
        Invocable invocable = this.field;
        if (invocable != null) {
            return invocable.getReturnType();
        }
        if (getVariable() != null) {
            return this.var.getType();
        }
        try {
            return Types.getType(getValueImpl());
        } catch (UtilEvalError unused) {
            return null;
        }
    }

    public Object getValue() {
        if (this.type == 1) {
            if (Reflect.isStatic(this.field)) {
                Interpreter.mainSecurityGuard.canGetStaticField(this.field.getDeclaringClass(), this.field.getName());
            } else {
                Interpreter.mainSecurityGuard.canGetField(this.object, this.field.getName());
            }
        }
        return getValueImpl();
    }

    public Variable getVariable() {
        Variable variable = this.var;
        if (variable != null) {
            return variable;
        }
        NameSpace nameSpace = this.nameSpace;
        if (nameSpace != null) {
            this.var = Reflect.getVariable(nameSpace, getName());
        } else if (isStatic()) {
            if (Reflect.isGeneratedClass(this.field.getDeclaringClass())) {
                this.var = Reflect.getVariable(this.field.getDeclaringClass(), getName());
            } else {
                this.var = new Variable(this.field.getName(), this.field.getReturnType(), this);
            }
        } else if (Reflect.isGeneratedClass(this.object.getClass())) {
            this.var = Reflect.getVariable(this.object, getName());
        } else {
            Invocable invocable = this.field;
            if (invocable != null) {
                this.var = new Variable(invocable.getName(), this.field.getReturnType(), this);
            }
        }
        return this.var;
    }

    public boolean isFinal() {
        if (getVariable() == null) {
            return false;
        }
        return this.var.hasModifier("final");
    }

    public boolean isStatic() {
        Invocable invocable = this.field;
        if (invocable != null) {
            return invocable.isStatic();
        }
        Variable variable = this.var;
        if (variable == null) {
            return false;
        }
        return variable.hasModifier("static");
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("LHS: ");
        String str3 = "";
        if (this.field != null) {
            str = "field = " + this.field.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.varName != null) {
            str2 = " varName = " + this.varName;
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.nameSpace != null) {
            str3 = " nameSpace = " + this.nameSpace.toString();
        }
        sb.append(str3);
        return sb.toString();
    }

    public Object assign(Object obj, boolean z) {
        int i = this.type;
        if (i == 0) {
            if (this.localVar) {
                this.nameSpace.setLocalVariableOrProperty(this.varName, obj, z);
            } else {
                this.nameSpace.setVariableOrProperty(this.varName, obj, z);
            }
            return getValueImpl();
        }
        if (i == 1) {
            try {
                Invocable invocable = this.field;
                Objects.requireNonNull(invocable, "assign value, field cannot be null");
                invocable.invoke(this.object, obj);
                return getValueImpl();
            } catch (ReflectiveOperationException e) {
                throw new UtilEvalError("LHS (" + this.field.getName() + ") can't access field: " + e, e);
            }
        }
        if (i == 2) {
            try {
                Object obj2 = this.propName;
                return obj2 instanceof String ? Reflect.setObjectProperty(this.object, (String) obj2, obj) : Reflect.setObjectProperty(this.object, obj2, obj);
            } catch (ReflectError e2) {
                Interpreter.debug("Assignment: " + e2.getMessage());
                throw new UtilEvalError("No such property: " + this.propName, e2);
            }
        }
        if (i != 3) {
            if (i != 5) {
                if (i != 6) {
                    throw new InterpreterError("unknown lhs type");
                }
                Object obj3 = this.object;
                return obj3 instanceof Map.Entry ? ((Map.Entry) obj3).setValue(obj) : new Types.MapEntry(this.object, obj);
            }
            Modifiers modifiers = new Modifiers(3);
            modifiers.addModifier("public");
            if (this.nameSpace.isInterface) {
                modifiers.setConstant();
            }
            this.nameSpace.setTypedVariable(this.varName, Types.getType(obj), obj, modifiers);
            return obj;
        }
        try {
            if (this.object.getClass().isArray() && obj != null) {
                try {
                    obj = Types.castObject(obj, Types.arrayElementType(this.object.getClass()), 1);
                } catch (Exception unused) {
                }
            }
            BshArray.setIndex(this.object, this.index, obj);
            return obj;
        } catch (UtilTargetError e3) {
            if (!IndexOutOfBoundsException.class.isAssignableFrom(e3.getCause().getClass())) {
                throw e3;
            }
            throw new UtilEvalError("Error array set index: " + e3.getMessage(), e3);
        } catch (Exception e4) {
            throw new UtilEvalError("Assignment: " + e4.getMessage(), e4);
        }
    }

    public LHS(NameSpace nameSpace, String str) {
        this.type = 5;
        this.varName = str;
        this.nameSpace = nameSpace;
    }

    public LHS(Invocable invocable) {
        this.type = 1;
        this.object = invocable.getDeclaringClass();
        this.field = invocable;
        this.varName = invocable.getName();
    }

    public LHS(Object obj, Invocable invocable) {
        if (obj != null) {
            this.type = 1;
            this.object = obj;
            this.field = invocable;
            if (invocable != null) {
                this.varName = invocable.getName();
                return;
            }
            return;
        }
        throw new NullPointerException("constructed empty LHS");
    }

    public LHS(Object obj, Object obj2) {
        if (obj != null) {
            this.type = 2;
            this.object = obj;
            this.propName = obj2;
            return;
        }
        throw new NullPointerException("constructed empty LHS");
    }

    public LHS(Object obj) {
        this.type = 6;
        this.object = obj;
    }

    public LHS(Object obj, int i) {
        this.type = 3;
        this.object = obj;
        this.index = i;
    }
}
