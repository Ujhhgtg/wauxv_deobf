package bsh;

import bsh.util.ReferenceCache;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
class BlockNameSpace extends NameSpace {
    public static final AtomicInteger blockCount = new AtomicInteger();
    private static final ReferenceCache<UniqueBlock, NameSpace> blockspaces;
    public final AtomicInteger used;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class UniqueBlock {
        int id;
        NameSpace ns;

        public UniqueBlock(NameSpace nameSpace, int i) {
            this.ns = nameSpace;
            this.id = i;
        }

        public int hashCode() {
            return this.ns.hashCode() + this.id;
        }
    }

    static {
        ReferenceCache.Type type = ReferenceCache.Type.Weak;
        blockspaces = new ReferenceCache<UniqueBlock, NameSpace>(type, type, 100) { // from class: bsh.BlockNameSpace.1
            @Override // bsh.util.ReferenceCache
            public NameSpace create(UniqueBlock uniqueBlock) {
                return new BlockNameSpace(uniqueBlock.ns, uniqueBlock.id);
            }
        };
    }

    public BlockNameSpace(NameSpace nameSpace, int i) {
        super(nameSpace, nameSpace.getName() + "/BlockNameSpace" + i);
        this.used = new AtomicInteger(1);
        this.isMethod = nameSpace.isMethod;
    }

    public static NameSpace getInstance(NameSpace nameSpace, int i) {
        BlockNameSpace blockNameSpace = (BlockNameSpace) blockspaces.get(new UniqueBlock(nameSpace, i));
        if (1 < blockNameSpace.used.getAndIncrement()) {
            blockNameSpace.clear();
        }
        return blockNameSpace;
    }

    private NameSpace getNonBlockParent() {
        NameSpace parent = super.getParent();
        return parent instanceof BlockNameSpace ? ((BlockNameSpace) parent).getNonBlockParent() : parent;
    }

    private boolean weHaveVar(String str) {
        return super.getVariableImpl(str, false) != null;
    }

    @Override // bsh.NameSpace
    public This getSuper(Interpreter interpreter) {
        return getNonBlockParent().getSuper(interpreter);
    }

    @Override // bsh.NameSpace
    public This getThis(Interpreter interpreter) {
        return getNonBlockParent().getThis(interpreter);
    }

    @Override // bsh.NameSpace
    public void importClass(String str) {
        getParent().importClass(str);
    }

    @Override // bsh.NameSpace
    public void importPackage(String str) {
        getParent().importPackage(str);
    }

    public void setBlockVariable(String str, Object obj) throws UtilEvalError {
        super.setVariable(str, obj, false, false);
    }

    @Override // bsh.NameSpace
    public void setMethod(BshMethod bshMethod) {
        getParent().setMethod(bshMethod);
    }

    @Override // bsh.NameSpace
    public Variable setVariable(String str, Object obj, boolean z, boolean z2) {
        return weHaveVar(str) ? super.setVariable(str, obj, z, false) : getParent().setVariable(str, obj, z, z2);
    }
}
