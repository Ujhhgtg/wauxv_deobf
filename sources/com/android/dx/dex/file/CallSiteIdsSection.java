package com.android.dx.dex.file;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstCallSite;
import com.android.dx.rop.cst.CstCallSiteRef;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CallSiteIdsSection extends UniformItemSection {
    private final TreeMap<CstCallSiteRef, CallSiteIdItem> callSiteIds;
    private final TreeMap<CstCallSite, CallSiteItem> callSites;

    public CallSiteIdsSection(DexFile dexFile) {
        super("call_site_ids", dexFile, 4);
        this.callSiteIds = new TreeMap<>();
        this.callSites = new TreeMap<>();
    }

    public void addCallSiteItem(CstCallSite cstCallSite, CallSiteItem callSiteItem) {
        if (cstCallSite == null) {
            throw new NullPointerException("callSite == null");
        }
        if (callSiteItem == null) {
            throw new NullPointerException("callSiteItem == null");
        }
        this.callSites.put(cstCallSite, callSiteItem);
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public IndexedItem get(Constant constant) {
        if (constant == null) {
            throw new NullPointerException("cst == null");
        }
        throwIfNotPrepared();
        CallSiteIdItem callSiteIdItem = this.callSiteIds.get((CstCallSiteRef) constant);
        if (callSiteIdItem != null) {
            return callSiteIdItem;
        }
        throw new IllegalArgumentException("not found");
    }

    public CallSiteItem getCallSiteItem(CstCallSite cstCallSite) {
        if (cstCallSite != null) {
            return this.callSites.get(cstCallSite);
        }
        throw new NullPointerException("callSite == null");
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
     */
    public synchronized void intern(CstCallSiteRef cstCallSiteRef) {
        try {
            if (cstCallSiteRef == null) {
                throw new NullPointerException("cstRef");
            }
            throwIfPrepared();
            if (this.callSiteIds.get(cstCallSiteRef) == null) {
                this.callSiteIds.put(cstCallSiteRef, new CallSiteIdItem(cstCallSiteRef));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.android.dx.dex.file.Section
    public Collection<? extends Item> items() {
        return this.callSiteIds.values();
    }

    @Override // com.android.dx.dex.file.UniformItemSection
    public void orderItems() {
        Iterator<CallSiteIdItem> it = this.callSiteIds.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().setIndex(i);
            i++;
        }
    }
}
