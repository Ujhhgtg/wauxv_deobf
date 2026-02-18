package bsh;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHBinaryExpression extends SimpleNode implements ParserConstants {
    public int kind;

    public BSHBinaryExpression(int i) {
        super(i);
    }

    private Object checkNullValues(Object obj, Object obj2, int i, CallStack callStack) throws TargetError, EvalException {
        Class<?> type;
        int i2;
        Primitive primitive = Primitive.NULL;
        if (primitive == obj && Primitive.VOID != obj2) {
            try {
                boolean z = obj2 instanceof String;
                if (primitive == obj2) {
                    Variable variableAtNode = getVariableAtNode(i ^ 1, callStack);
                    if (variableAtNode != null) {
                        z = variableAtNode.getType() == String.class;
                        type = variableAtNode.getType();
                    } else {
                        type = null;
                    }
                } else {
                    type = Primitive.unwrap(obj2).getClass();
                }
                Variable variableAtNode2 = getVariableAtNode(i, callStack);
                if (variableAtNode2 != null && (((i2 = this.kind) != 92 && i2 != 97) || !isComparableTypes(variableAtNode2.getType(), type, callStack))) {
                    if (this.kind == 104 && (z || variableAtNode2.getType() == String.class)) {
                        return "null";
                    }
                    if (isWrapper(variableAtNode2.getType())) {
                        throw new NullPointerException("null value with binary operator " + ParserConstants.tokenImage[this.kind]);
                    }
                    throw new EvalException("bad operand types for binary operator " + ParserConstants.tokenImage[this.kind], this, callStack);
                }
            } catch (UtilEvalError e) {
                e.toEvalError(this, callStack);
                return obj;
            } catch (NullPointerException e2) {
                throw new TargetError(e2, this, callStack);
            }
        }
        return obj;
    }

    private Variable getVariableAtNode(int i, CallStack callStack) {
        if (jjtGetChild(i).jjtGetNumChildren() <= 0) {
            return null;
        }
        Node nodeJjtGetChild = jjtGetChild(i).jjtGetChild(0);
        if (nodeJjtGetChild instanceof BSHAmbiguousName) {
            return callStack.top().getVariableImpl(((BSHAmbiguousName) nodeJjtGetChild).text, true);
        }
        return null;
    }

    private boolean isComparableTypes(Class<?> cls, Class<?> cls2, CallStack callStack) throws EvalException {
        if (cls2 == cls || isSimilarTypes(cls, cls2)) {
            return true;
        }
        throw new EvalException("incomparable types: " + StringUtil.typeString(cls) + " and " + StringUtil.typeString(cls2), this, callStack);
    }

    private boolean isPrimitiveValue(Object obj) {
        return (!(obj instanceof Primitive) || obj == Primitive.NULL || obj == Primitive.VOID) ? false : true;
    }

    private boolean isSimilarTypes(Class<?> cls, Class<?> cls2) {
        return cls2 == null || cls.isAssignableFrom(cls2) || cls2.isAssignableFrom(cls);
    }

    private boolean isWrapper(Object obj) {
        return (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Character);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bd, code lost:
    
        if ((bsh.Primitive.castWrapper(r5, r2) instanceof java.lang.Boolean) != false) goto L103;
     */
    /* JADX WARN: Found duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Found duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Found duplicated region for block: B:42:0x0082 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Found duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Found duplicated region for block: B:53:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Found duplicated region for block: B:57:0x00b1  */
    /* JADX WARN: Found duplicated region for block: B:60:0x00b7  */
    /* JADX WARN: Found duplicated region for block: B:63:0x00c1 A[FALL_THROUGH] */
    /* JADX WARN: Found duplicated region for block: B:65:0x00cf  */
    /* JADX WARN: Found duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Found duplicated region for block: B:82:0x00fe  */
    @Override // bsh.SimpleNode, bsh.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object eval(bsh.CallStack r9, bsh.Interpreter r10) throws bsh.EvalError {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHBinaryExpression.eval(bsh.CallStack, bsh.Interpreter):java.lang.Object");
    }

    @Override // bsh.SimpleNode
    public String toString() {
        return super.toString() + ": " + ParserConstants.tokenImage[this.kind];
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1068)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1093)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private boolean isWrapper(java.lang.Class<?> r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.Class<java.lang.Number> r1 = java.lang.Number.class
            boolean r1 = r1.isAssignableFrom(r4)
            r2 = 1
            if (r1 != 0) goto L2d
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            boolean r1 = r1.isAssignableFrom(r4)
            if (r1 == 0) goto L16
            goto L2d
        L16:
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            boolean r4 = r1.isAssignableFrom(r4)
            if (r4 == 0) goto L2c
            int r4 = r3.kind
            r1 = 92
            if (r4 == r1) goto L2b
            switch(r4) {
                case 97: goto L2b;
                case 98: goto L2b;
                case 99: goto L2b;
                case 100: goto L2b;
                case 101: goto L2b;
                default: goto L27;
            }
        L27:
            switch(r4) {
                case 108: goto L2b;
                case 109: goto L2b;
                case 110: goto L2b;
                case 111: goto L2b;
                case 112: goto L2b;
                case 113: goto L2b;
                default: goto L2a;
            }
        L2a:
            goto L2c
        L2b:
            return r2
        L2c:
            return r0
        L2d:
            int r4 = r3.kind
            switch(r4) {
                case 98: goto L33;
                case 99: goto L33;
                case 100: goto L33;
                case 101: goto L33;
                default: goto L32;
            }
        L32:
            return r2
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bsh.BSHBinaryExpression.isWrapper(java.lang.Class):boolean");
    }
}
