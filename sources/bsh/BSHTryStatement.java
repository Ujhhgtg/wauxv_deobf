package bsh;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BSHTryStatement extends SimpleNode {
    final int blockId;
    BSHTryWithResources tryWithResources;

    public BSHTryStatement(int i) {
        super(i);
        this.tryWithResources = null;
        this.blockId = BlockNameSpace.blockCount.incrementAndGet();
    }

    /* JADX WARN: Found duplicated region for block: B:334:0x019d A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:336:0x01af A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:341:0x01c1 A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:348:0x01d6 A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:350:0x01e0 A[Catch: all -> 0x01b5, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:353:0x01f2 A[Catch: all -> 0x01b5, LOOP:4: B:349:0x01de->B:353:0x01f2, LOOP_END, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:356:0x0207 A[Catch: all -> 0x01b5, LOOP:3: B:333:0x019b->B:356:0x0207, LOOP_END, TryCatch #10 {all -> 0x01b5, blocks: (B:332:0x0189, B:334:0x019d, B:336:0x01af, B:339:0x01b8, B:341:0x01c1, B:344:0x01c8, B:345:0x01cf, B:346:0x01d0, B:348:0x01d6, B:350:0x01e0, B:356:0x0207, B:358:0x0211, B:359:0x0226, B:361:0x022a, B:363:0x0235, B:365:0x023e, B:367:0x0244, B:368:0x0247, B:362:0x0230, B:369:0x0248, B:370:0x024f, B:353:0x01f2, B:364:0x0238), top: B:411:0x0189, inners: #0, #1 }] */
    /* JADX WARN: Found duplicated region for block: B:361:0x022a A[Catch: all -> 0x01b5, UtilEvalError -> 0x0248, TryCatch #0 {UtilEvalError -> 0x0248, blocks: (B:359:0x0226, B:361:0x022a, B:362:0x0230), top: B:404:0x0226, outer: #10 }] */
    /* JADX WARN: Found duplicated region for block: B:362:0x0230 A[Catch: all -> 0x01b5, UtilEvalError -> 0x0248, TRY_LEAVE, TryCatch #0 {UtilEvalError -> 0x0248, blocks: (B:359:0x0226, B:361:0x022a, B:362:0x0230), top: B:404:0x0226, outer: #10 }] */
    /* JADX WARN: Found duplicated region for block: B:371:0x0250 A[PHI: r0
      0x0250: PHI (r0v56 java.lang.Object) = (r0v36 java.lang.Object), (r0v38 java.lang.Object) binds: [B:331:0x0187, B:430:0x0250] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Found duplicated region for block: B:379:0x0264  */
    /* JADX WARN: Found duplicated region for block: B:381:0x026c A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:383:0x026f  */
    /* JADX WARN: Found duplicated region for block: B:386:0x0274  */
    /* JADX WARN: Found duplicated region for block: B:388:0x0277  */
    /* JADX WARN: Found duplicated region for block: B:411:0x0189 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:429:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:430:0x0250 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:432:0x0210 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:433:0x01fd A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:434:0x01ef A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:465:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r22v0, types: [bsh.CallStack] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    @Override // bsh.SimpleNode, bsh.Node
    public Object eval(CallStack callStack, Interpreter interpreter) throws Throwable {
        int i;
        Node nodeJjtGetChild;
        ?? target;
        ?? r10;
        Throwable target2;
        Object objEval;
        Class<?> cls;
        int size;
        int i2;
        BSHMultiCatch bSHMultiCatch;
        Modifiers modifiers;
        Class<?> cls2;
        NameSpace pVar;
        BlockNameSpace blockNameSpace;
        Object objEval2;
        Throwable th;
        Class<?>[] types;
        int length;
        int i3;
        boolean z;
        Object obj;
        Class<?> cls3;
        int i4;
        boolean zIsBshAssignable;
        Object objEval3;
        if (jjtGetChild(0) instanceof BSHTryWithResources) {
            BSHTryWithResources bSHTryWithResources = (BSHTryWithResources) jjtGetChild(0);
            this.tryWithResources = bSHTryWithResources;
            bSHTryWithResources.eval(callStack, interpreter);
            i = 1;
        } else {
            i = 0;
        }
        int i5 = i + 1;
        BSHBlock bSHBlock = (BSHBlock) jjtGetChild(i);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iJjtGetNumChildren = jjtGetNumChildren();
        while (true) {
            if (i5 >= iJjtGetNumChildren) {
                nodeJjtGetChild = null;
                break;
            }
            int i6 = i5 + 1;
            nodeJjtGetChild = jjtGetChild(i5);
            if (!(nodeJjtGetChild instanceof BSHMultiCatch)) {
                break;
            }
            arrayList.add((BSHMultiCatch) nodeJjtGetChild);
            i5 += 2;
            arrayList2.add((BSHBlock) jjtGetChild(i6));
        }
        BSHBlock bSHBlock2 = nodeJjtGetChild != null ? (BSHBlock) nodeJjtGetChild : null;
        ?? Depth = callStack.depth();
        try {
            try {
                try {
                    Interpreter.debug("Evaluate try block");
                    try {
                        objEval = bSHBlock.eval(callStack, interpreter);
                        target2 = null;
                        while (target2 != null && (target2.getCause() instanceof TargetError)) {
                            target2 = ((TargetError) target2.getCause()).getTarget();
                        }
                        if (this.tryWithResources != null) {
                            Interpreter.debug("Try with resources: autoClose");
                            for (Throwable th2 : this.tryWithResources.autoClose()) {
                                if (target2 != null && target2 != th2) {
                                    target2.addSuppressed(th2);
                                }
                            }
                        }
                    } catch (OutOfMemoryError e) {
                        try {
                            try {
                                r10 = Depth;
                            } catch (EvalException e2) {
                                e = e2;
                                r10 = Depth;
                            } catch (TargetError e3) {
                                e = e3;
                                r10 = Depth;
                            }
                        } catch (EvalException e4) {
                            e = e4;
                            r10 = Depth;
                        } catch (TargetError e5) {
                            e = e5;
                            r10 = Depth;
                        }
                        try {
                            throw new TargetError(e.toString(), e, bSHBlock, callStack, false);
                        } catch (EvalException e6) {
                            e = e6;
                            target2 = e;
                            Interpreter.debug("EvalException from try block: ", target2);
                            while (callStack.depth() > r10) {
                                callStack.pop();
                            }
                            while (target2 != null && (target2.getCause() instanceof TargetError)) {
                                target2 = ((TargetError) target2.getCause()).getTarget();
                            }
                            if (this.tryWithResources != null) {
                                Interpreter.debug("Try with resources: autoClose");
                                for (Throwable th3 : this.tryWithResources.autoClose()) {
                                    if (target2 != null && target2 != th3) {
                                        target2.addSuppressed(th3);
                                    }
                                }
                            }
                            objEval = null;
                            if (target2 != null) {
                                try {
                                    Interpreter.debug("Try catch thrown: ", target2);
                                    cls = target2.getClass();
                                    size = arrayList.size();
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < size) {
                                            bSHMultiCatch = (BSHMultiCatch) arrayList.get(i2);
                                            modifiers = new Modifiers(4);
                                            if (bSHMultiCatch.isFinal()) {
                                                modifiers.addModifier("final");
                                            }
                                            bSHMultiCatch.eval(callStack, interpreter);
                                            if (bSHMultiCatch.isUntyped()) {
                                                throw new EvalException("(Strict Java) Untyped catch block", this, callStack);
                                            }
                                            if (bSHMultiCatch.isUntyped()) {
                                                cls2 = null;
                                            } else {
                                                types = bSHMultiCatch.getTypes();
                                                length = types.length;
                                                i3 = 0;
                                                z = false;
                                                while (true) {
                                                    if (i3 >= length) {
                                                        obj = objEval;
                                                        cls3 = cls;
                                                        i4 = size;
                                                        cls2 = null;
                                                        break;
                                                    }
                                                    obj = objEval;
                                                    cls2 = types[i3];
                                                    i4 = size;
                                                    zIsBshAssignable = Types.isBshAssignable(cls2, cls);
                                                    cls3 = cls;
                                                    if (true == zIsBshAssignable) {
                                                        z = zIsBshAssignable;
                                                        break;
                                                    }
                                                    i3++;
                                                    z = zIsBshAssignable;
                                                    objEval = obj;
                                                    size = i4;
                                                    cls = cls3;
                                                }
                                                if (!z) {
                                                    i2++;
                                                    objEval = obj;
                                                    size = i4;
                                                    cls = cls3;
                                                }
                                            }
                                            BSHBlock bSHBlock3 = (BSHBlock) arrayList2.get(i2);
                                            pVar = callStack.top();
                                            blockNameSpace = new BlockNameSpace(callStack.top(), this.blockId);
                                            try {
                                                if (cls2 == BSHMultiCatch.UNTYPED) {
                                                    blockNameSpace.setBlockVariable(bSHMultiCatch.name, target2);
                                                } else {
                                                    blockNameSpace.setTypedVariable(bSHMultiCatch.name, cls2, target2, modifiers);
                                                }
                                                callStack.swap(blockNameSpace);
                                                try {
                                                    objEval2 = bSHBlock3.eval(callStack, interpreter, Boolean.TRUE);
                                                    callStack.swap(pVar);
                                                    th = null;
                                                } catch (Throwable th4) {
                                                    callStack.swap(pVar);
                                                    throw th4;
                                                }
                                            } catch (UtilEvalError unused) {
                                                throw new InterpreterError("Unable to set var in catch block namespace.");
                                            }
                                        } else {
                                            th = target2;
                                            objEval2 = objEval;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    if (bSHBlock2 != null) {
                                        Object objEval4 = bSHBlock2.eval(callStack, interpreter);
                                        if (objEval4 instanceof ReturnControl) {
                                            return objEval4;
                                        }
                                    }
                                    throw th5;
                                }
                            } else {
                                th = target2;
                                objEval2 = objEval;
                            }
                            if (bSHBlock2 != null) {
                                objEval3 = bSHBlock2.eval(callStack, interpreter);
                                if (objEval3 instanceof ReturnControl) {
                                    return objEval3;
                                }
                            }
                            if (th == null) {
                                return objEval2 instanceof ReturnControl ? objEval2 : Primitive.VOID;
                            }
                            throw new TargetError(th, this, callStack);
                        } catch (TargetError e7) {
                            e = e7;
                            Interpreter.debug("TargetError from try block: ", e);
                            target2 = e.getTarget();
                            while (callStack.depth() > r10) {
                                callStack.pop();
                            }
                            while (target2 != null && (target2.getCause() instanceof TargetError)) {
                                target2 = ((TargetError) target2.getCause()).getTarget();
                            }
                            if (this.tryWithResources != null) {
                                Interpreter.debug("Try with resources: autoClose");
                                for (Throwable th6 : this.tryWithResources.autoClose()) {
                                    if (target2 != null && target2 != th6) {
                                        target2.addSuppressed(th6);
                                    }
                                }
                            }
                            objEval = null;
                            if (target2 != null) {
                                Interpreter.debug("Try catch thrown: ", target2);
                                cls = target2.getClass();
                                size = arrayList.size();
                                i2 = 0;
                                while (true) {
                                    if (i2 < size) {
                                        bSHMultiCatch = (BSHMultiCatch) arrayList.get(i2);
                                        modifiers = new Modifiers(4);
                                        if (bSHMultiCatch.isFinal()) {
                                            modifiers.addModifier("final");
                                        }
                                        bSHMultiCatch.eval(callStack, interpreter);
                                        if (bSHMultiCatch.isUntyped()) {
                                            throw new EvalException("(Strict Java) Untyped catch block", this, callStack);
                                        }
                                        if (bSHMultiCatch.isUntyped()) {
                                            types = bSHMultiCatch.getTypes();
                                            length = types.length;
                                            i3 = 0;
                                            z = false;
                                            while (true) {
                                                if (i3 >= length) {
                                                    obj = objEval;
                                                    cls3 = cls;
                                                    i4 = size;
                                                    cls2 = null;
                                                    break;
                                                }
                                                obj = objEval;
                                                cls2 = types[i3];
                                                i4 = size;
                                                zIsBshAssignable = Types.isBshAssignable(cls2, cls);
                                                cls3 = cls;
                                                if (true == zIsBshAssignable) {
                                                    z = zIsBshAssignable;
                                                    break;
                                                }
                                                i3++;
                                                z = zIsBshAssignable;
                                                objEval = obj;
                                                size = i4;
                                                cls = cls3;
                                            }
                                            if (!z) {
                                                i2++;
                                                objEval = obj;
                                                size = i4;
                                                cls = cls3;
                                            }
                                        } else {
                                            cls2 = null;
                                        }
                                        BSHBlock bSHBlock32 = (BSHBlock) arrayList2.get(i2);
                                        pVar = callStack.top();
                                        blockNameSpace = new BlockNameSpace(callStack.top(), this.blockId);
                                        if (cls2 == BSHMultiCatch.UNTYPED) {
                                            blockNameSpace.setBlockVariable(bSHMultiCatch.name, target2);
                                        } else {
                                            blockNameSpace.setTypedVariable(bSHMultiCatch.name, cls2, target2, modifiers);
                                        }
                                        callStack.swap(blockNameSpace);
                                        objEval2 = bSHBlock32.eval(callStack, interpreter, Boolean.TRUE);
                                        callStack.swap(pVar);
                                        th = null;
                                    } else {
                                        th = target2;
                                        objEval2 = objEval;
                                    }
                                }
                            } else {
                                th = target2;
                                objEval2 = objEval;
                            }
                            if (bSHBlock2 != null) {
                                objEval3 = bSHBlock2.eval(callStack, interpreter);
                                if (objEval3 instanceof ReturnControl) {
                                    return objEval3;
                                }
                            }
                            if (th == null) {
                                if (objEval2 instanceof ReturnControl) {
                                }
                            }
                            throw new TargetError(th, this, callStack);
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    target = 0;
                    while (target != 0 && (target.getCause() instanceof TargetError)) {
                        target = ((TargetError) target.getCause()).getTarget();
                    }
                    if (this.tryWithResources != null) {
                        Interpreter.debug("Try with resources: autoClose");
                        for (Throwable th8 : this.tryWithResources.autoClose()) {
                            if (target != 0 && target != th8) {
                                target.addSuppressed(th8);
                            }
                        }
                    }
                    throw th;
                }
            } catch (EvalException e8) {
                e = e8;
                r10 = Depth;
            } catch (TargetError e9) {
                e = e9;
                r10 = Depth;
            }
            if (target2 != null) {
                Interpreter.debug("Try catch thrown: ", target2);
                cls = target2.getClass();
                size = arrayList.size();
                i2 = 0;
                while (true) {
                    if (i2 < size) {
                        bSHMultiCatch = (BSHMultiCatch) arrayList.get(i2);
                        modifiers = new Modifiers(4);
                        if (bSHMultiCatch.isFinal()) {
                            modifiers.addModifier("final");
                        }
                        bSHMultiCatch.eval(callStack, interpreter);
                        if (bSHMultiCatch.isUntyped() && interpreter.getStrictJava()) {
                            throw new EvalException("(Strict Java) Untyped catch block", this, callStack);
                        }
                        if (bSHMultiCatch.isUntyped()) {
                            types = bSHMultiCatch.getTypes();
                            length = types.length;
                            i3 = 0;
                            z = false;
                            while (true) {
                                if (i3 >= length) {
                                    obj = objEval;
                                    cls3 = cls;
                                    i4 = size;
                                    cls2 = null;
                                    break;
                                }
                                obj = objEval;
                                cls2 = types[i3];
                                i4 = size;
                                zIsBshAssignable = Types.isBshAssignable(cls2, cls);
                                cls3 = cls;
                                if (true == zIsBshAssignable) {
                                    z = zIsBshAssignable;
                                    break;
                                }
                                i3++;
                                z = zIsBshAssignable;
                                objEval = obj;
                                size = i4;
                                cls = cls3;
                            }
                            if (!z) {
                                i2++;
                                objEval = obj;
                                size = i4;
                                cls = cls3;
                            }
                        } else {
                            cls2 = null;
                        }
                        BSHBlock bSHBlock322 = (BSHBlock) arrayList2.get(i2);
                        pVar = callStack.top();
                        blockNameSpace = new BlockNameSpace(callStack.top(), this.blockId);
                        if (cls2 == BSHMultiCatch.UNTYPED) {
                            blockNameSpace.setBlockVariable(bSHMultiCatch.name, target2);
                        } else {
                            blockNameSpace.setTypedVariable(bSHMultiCatch.name, cls2, target2, modifiers);
                        }
                        callStack.swap(blockNameSpace);
                        objEval2 = bSHBlock322.eval(callStack, interpreter, Boolean.TRUE);
                        callStack.swap(pVar);
                        th = null;
                    } else {
                        th = target2;
                        objEval2 = objEval;
                    }
                }
            } else {
                th = target2;
                objEval2 = objEval;
            }
            if (bSHBlock2 != null) {
                objEval3 = bSHBlock2.eval(callStack, interpreter);
                if (objEval3 instanceof ReturnControl) {
                    return objEval3;
                }
            }
            if (th == null) {
                if (objEval2 instanceof ReturnControl) {
                }
            }
            throw new TargetError(th, this, callStack);
        } catch (Throwable th9) {
            th = th9;
            target = Depth;
        }
    }
}
