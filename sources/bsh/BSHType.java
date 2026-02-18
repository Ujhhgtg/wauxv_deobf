package bsh;

import bsh.BshClassManager;
import java.lang.reflect.Array;
import me.hd.wauxv.obf.yg;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHType extends SimpleNode implements BshClassManager.Listener {
    private static final long serialVersionUID = 1;
    private int arrayDims;
    private Class<?> baseType;
    String descriptor;
    private boolean isListener;
    private Class<?> type;

    public BSHType(int i) {
        super(i);
        this.isListener = false;
    }

    public void addArrayDimension() {
        this.arrayDims++;
    }

    @Override // bsh.BshClassManager.Listener
    public void classLoaderChanged() {
        this.type = null;
        this.baseType = null;
    }

    public int getArrayDims() {
        return this.arrayDims;
    }

    public Class<?> getBaseType() {
        return this.baseType;
    }

    public Class<?> getType(CallStack callStack, Interpreter interpreter) throws EvalError {
        Class<?> cls = this.type;
        if (cls != null) {
            return cls;
        }
        Node typeNode = getTypeNode();
        Class<?> cls2 = Object.class;
        if (typeNode instanceof BSHPrimitiveType) {
            this.baseType = ((BSHPrimitiveType) typeNode).getType();
        } else {
            try {
                this.baseType = ((BSHAmbiguousName) typeNode).toClass(callStack, interpreter);
            } catch (EvalError e) {
                if (typeNode.getText().trim().length() != 1 || !(e.getCause() instanceof ClassNotFoundException)) {
                    throw e;
                }
                this.baseType = cls2;
            }
        }
        int i = this.arrayDims;
        if (i > 0) {
            try {
                int[] iArr = new int[i];
                Class<?> cls3 = this.baseType;
                if (cls3 != null) {
                    cls2 = cls3;
                }
                this.type = Array.newInstance(cls2, iArr).getClass();
            } catch (Exception e2) {
                throw new EvalException("Couldn't construct array type", this, callStack, e2);
            }
        } else {
            this.type = this.baseType;
        }
        if (!this.isListener) {
            interpreter.getClassManager().addListener(this);
            this.isListener = true;
        }
        return this.type;
    }

    public String getTypeDescriptor(CallStack callStack, Interpreter interpreter, String str) {
        String strO;
        String str2 = this.descriptor;
        if (str2 != null) {
            return str2;
        }
        Node typeNode = getTypeNode();
        if (typeNode instanceof BSHPrimitiveType) {
            strO = getTypeDescriptor(((BSHPrimitiveType) typeNode).type);
        } else {
            String strReplace = ((BSHAmbiguousName) typeNode).text;
            String str3 = callStack.top().importedClasses.get(strReplace);
            Class<?> cls = null;
            if (str3 == null) {
                try {
                    cls = ((BSHAmbiguousName) typeNode).toClass(callStack, interpreter);
                } catch (EvalError unused) {
                    if (strReplace.length() == 1) {
                        strReplace = "java.lang.Object";
                    }
                }
            } else {
                strReplace = str3.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '$');
            }
            if (cls != null) {
                strO = getTypeDescriptor(cls);
            } else if (str == null || Name.isCompound(strReplace)) {
                strO = "L" + strReplace.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/') + ";";
            } else {
                StringBuilder sb = new StringBuilder("L");
                sb.append(str.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/'));
                sb.append("/");
                strO = yg.o(sb, strReplace, ";");
            }
        }
        for (int i = 0; i < this.arrayDims; i++) {
            strO = yg.k("[", strO);
        }
        this.descriptor = strO;
        return strO;
    }

    public Node getTypeNode() {
        return jjtGetChild(0);
    }

    public static String getTypeDescriptor(Class<?> cls) {
        if (cls == Boolean.TYPE) {
            return "Z";
        }
        if (cls == Character.TYPE) {
            return "C";
        }
        if (cls == Byte.TYPE) {
            return "B";
        }
        if (cls == Short.TYPE) {
            return "S";
        }
        if (cls == Integer.TYPE) {
            return "I";
        }
        if (cls == Long.TYPE) {
            return "J";
        }
        if (cls == Float.TYPE) {
            return "F";
        }
        if (cls == Double.TYPE) {
            return "D";
        }
        if (cls == Void.TYPE) {
            return "V";
        }
        String strReplace = cls.getName().replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/');
        if (strReplace.startsWith("[") || strReplace.endsWith(";")) {
            return strReplace;
        }
        return "L" + strReplace.replace(TypePool.Default.LazyTypeDescription.GenericTypeToken.INNER_CLASS_PATH, '/') + ";";
    }
}
