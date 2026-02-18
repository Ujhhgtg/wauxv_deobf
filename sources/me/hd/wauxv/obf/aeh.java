package me.hd.wauxv.obf;

import android.content.Context;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.textview.MaterialTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class aeh implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ aeh(Object obj, int i, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                aek aekVar = (aek) obj;
                if (((Boolean) ((IHasInvokeMethod) obj2).invoke(aekVar)).booleanValue()) {
                    return;
                }
                ccu ccuVarM = aekVar.m();
                ccuVarM.getClass();
                ng.aj(new ccq(ccuVarM, 1));
                return;
            case 1:
                bgj bgjVar = (bgj) obj2;
                aek aekVar2 = (aek) obj;
                ael aelVar = aekVar2.a;
                if (aelVar == null) {
                    throwLateinitPropNotInitYet("info" /* cnb.z(-395527833254698L) */);
                    throw null;
                }
                if (((Boolean) bgjVar.g(aelVar.n(), aekVar2)).booleanValue()) {
                    return;
                }
                ccu ccuVarM2 = aekVar2.m();
                ccuVarM2.getClass();
                ng.aj(new ccq(ccuVarM2, 1));
                return;
            default:
                cua cuaVar = (cua) obj2;
                ctx ctxVar = (ctx) obj;
                Context contextDc = cuaVar.dc();
                View viewInflate = LayoutInflater.from(contextDc).inflate(R.layout.module_dialog_plugin_readme,
                        (ViewGroup) null, false);
                MaterialTextView materialTextView = (MaterialTextView) cnd.aq(viewInflate,
                        R.id.moduleDialogTvPluginReadme);
                if (materialTextView == null) {
                    throw new NullPointerException(
                            "Missing required view with ID: " /* cnb.z(-663452188146474L) */.concat(
                                    viewInflate.getResources().getResourceName(R.id.moduleDialogTvPluginReadme)));
                }
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                ArrayList<aha> arrayList = new ArrayList(3);
                TextView.BufferType bufferType = TextView.BufferType.SPANNABLE;
                arrayList.add(new aha());
                arrayList.add(new aha());
                if (arrayList.isEmpty()) {
                    throw new IllegalStateException(
                            "No plugins were added to this builder. Use #usePlugin method to add them");
                }
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                HashSet hashSet = new HashSet(3);
                for (aha ahaVar : arrayList) {
                    if (!arrayList2.contains(ahaVar)) {
                        if (hashSet.contains(ahaVar)) {
                            throw new IllegalStateException("Cyclic dependency chain found: " + hashSet);
                        }
                        hashSet.add(ahaVar);
                        ahaVar.getClass();
                        hashSet.remove(ahaVar);
                        if (!arrayList2.contains(ahaVar)) {
                            if (aha.class.isAssignableFrom(ahaVar.getClass())) {
                                arrayList2.add(0, ahaVar);
                            } else {
                                arrayList2.add(ahaVar);
                            }
                        }
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                LinkedHashSet linkedHashSet = aph.a;
                float f = contextDc.getResources().getDisplayMetrics().density;
                bzr bzrVar = new bzr();
                bzrVar.e = (int) ((8 * f) + 0.5f);
                bzrVar.b = (int) ((24 * f) + 0.5f);
                int i2 = (int) ((4 * f) + 0.5f);
                bzrVar.c = i2;
                int i3 = (int) ((1 * f) + 0.5f);
                bzrVar.d = i3;
                bzrVar.f = i3;
                bzrVar.g = i2;
                awc awcVar = new awc();
                HashMap map = new HashMap();
                HashMap map2 = new HashMap(3);
                Iterator it = arrayList2.iterator();
                while (true) {
                    ArrayList arrayList6 = arrayList2;
                    if (it.hasNext()) {
                        aha ahaVar2 = (aha) it.next();
                        ahaVar2.getClass();
                        map.put(dqe.class, new agz(ahaVar2));
                        map.put(dns.class, new agy(6));
                        map.put(auv.class, new agy(7));
                        map.put(pj.class, new agy(8));
                        map.put(aaf.class, new agy(9));
                        map.put(aze.class, new agy(10));
                        map.put(box.class, new agy(11));
                        map.put(boe.class, new agy(12));
                        map.put(rq.class, new agy(14));
                        map.put(crx.class, new agy(14));
                        map.put(bwb.class, new agy(13));
                        map.put(drl.class, new agy(0));
                        map.put(bkl.class, new agy(1));
                        ArrayList arrayList7 = arrayList4;
                        map.put(dkx.class, new agy(2));
                        map.put(bke.class, new agy(3));
                        map.put(csr.class, new agy(4));
                        map.put(bvo.class, new agy(5));
                        pn pnVar = new pn(1);
                        map2.put(dns.class, new pn(7));
                        map2.put(auv.class, new pn(3));
                        map2.put(pj.class, new pn(0));
                        map2.put(aaf.class, new pn(2));
                        map2.put(aze.class, pnVar);
                        map2.put(box.class, pnVar);
                        map2.put(bwb.class, new pn(6));
                        map2.put(bkl.class, new pn(4));
                        map2.put(bvo.class, new pn(5));
                        map2.put(drl.class, new pn(8));
                        arrayList5 = arrayList5;
                        arrayList2 = arrayList6;
                        linkedHashSet = linkedHashSet;
                        it = it;
                        cuaVar = cuaVar;
                        linearLayout = linearLayout;
                        contextDc = contextDc;
                        bufferType = bufferType;
                        materialTextView = materialTextView;
                        ctxVar = ctxVar;
                        arrayList4 = arrayList7;
                        map = map;
                        arrayList3 = arrayList3;
                    } else {
                        Context context = contextDc;
                        ArrayList arrayList8 = arrayList3;
                        ctx ctxVar2 = ctxVar;
                        cua cuaVar2 = cuaVar;
                        HashMap map3 = map;
                        LinearLayout linearLayout2 = linearLayout;
                        ArrayList arrayList9 = arrayList4;
                        TextView textView = materialTextView;
                        TextView.BufferType bufferType2 = bufferType;
                        ArrayList arrayList10 = arrayList5;
                        LinkedHashSet linkedHashSet2 = linkedHashSet;
                        bzr bzrVar2 = new bzr();
                        bzrVar2.b = bzrVar.b;
                        bzrVar2.c = bzrVar.c;
                        bzrVar2.d = bzrVar.d;
                        bzrVar2.e = bzrVar.e;
                        bzrVar2.f = bzrVar.f;
                        bzrVar2.g = bzrVar.g;
                        bib bibVar = new bib(Collections.unmodifiableMap(map2));
                        awcVar.a = bzrVar2;
                        awcVar.g = bibVar;
                        if (((arj) awcVar.b) == null) {
                            awcVar.b = new arj();
                        }
                        if (((dop) awcVar.c) == null) {
                            awcVar.c = new dop(5);
                        }
                        if (((awp) awcVar.d) == null) {
                            awcVar.d = new awp(23);
                        }
                        if (((awp) awcVar.e) == null) {
                            awcVar.e = new awp(16);
                        }
                        if (((awp) awcVar.f) == null) {
                            awcVar.f = new awp(17);
                        }
                        blq blqVar = new blq(awcVar);
                        LinkedHashSet linkedHashSet3 = aph.a;
                        ArrayList arrayList11 = new ArrayList();
                        arrayList11.addAll(arrayList8);
                        Iterator it2 = linkedHashSet2.iterator();
                        while (it2.hasNext()) {
                            arrayList11.add(aph.b.get((Class) it2.next()));
                        }
                        cbm cbmVar = new cbm(9);
                        int i4 = 28;
                        new bpm(new DefaultConfig(arrayList9, i4, Collections.EMPTY_MAP));
                        List listUnmodifiableList = Collections.unmodifiableList(arrayList6);
                        String str = (String) ctxVar2.k.getValue();
                        Iterator it3 = listUnmodifiableList.iterator();
                        while (it3.hasNext()) {
                            ((aha) it3.next()).getClass();
                        }
                        if (str == null) {
                            throw new NullPointerException("input must not be null");
                        }
                        aph aphVar = new aph(arrayList11, cbmVar, arrayList9);
                        int i5 = 0;
                        while (true) {
                            int length = str.length();
                            int i6 = i5;
                            while (true) {
                                if (i6 < length) {
                                    char cCharAt = str.charAt(i6);
                                    if (cCharAt != '\n' && cCharAt != '\r') {
                                        i6++;
                                    }
                                } else {
                                    i6 = -1;
                                }
                            }
                            if (i6 == -1) {
                                if (str.length() > 0 && (i5 == 0 || i5 < str.length())) {
                                    aphVar.z(str.substring(i5));
                                }
                                aphVar.w(aphVar.p);
                                DefaultConfig ioVar = new DefaultConfig(aphVar.m, i4, aphVar.o);
                                aphVar.l.getClass();
                                bpm bpmVar = new bpm(ioVar);
                                Iterator it4 = aphVar.q.iterator();
                                while (it4.hasNext()) {
                                    ((p) it4.next()).f(bpmVar);
                                }
                                bmr bmrVar = (bmr) aphVar.n.i;
                                Iterator it5 = arrayList10.iterator();
                                if (it5.hasNext()) {
                                    throw yg.d(it5);
                                }
                                Iterator it6 = listUnmodifiableList.iterator();
                                while (it6.hasNext()) {
                                    ((aha) it6.next()).getClass();
                                }
                                aji ajiVar = new aji(4);
                                new nu(3);
                                dll dllVar = new dll();
                                Map mapUnmodifiableMap = Collections.unmodifiableMap(map3);
                                chm chmVar = new chm();
                                chmVar.c = blqVar;
                                chmVar.d = ajiVar;
                                chmVar.e = dllVar;
                                chmVar.f = mapUnmodifiableMap;
                                chmVar.aw(bmrVar);
                                Iterator it7 = listUnmodifiableList.iterator();
                                while (it7.hasNext()) {
                                    ((aha) it7.next()).getClass();
                                }
                                dll dllVar2 = (dll) chmVar.e;
                                dlj dljVar = new dlj(dllVar2.a);
                                for (dli dliVar : dllVar2.b) {
                                    dljVar.setSpan(dliVar.a, dliVar.b, dliVar.c, dliVar.d);
                                }
                                Iterator it8 = listUnmodifiableList.iterator();
                                while (it8.hasNext()) {
                                    ((aha) it8.next()).getClass();
                                    cry[] cryVarArr = (cry[]) dljVar.getSpans(0, dljVar.length(), cry.class);
                                    if (cryVarArr != null) {
                                        TextPaint paint = textView.getPaint();
                                        for (cry cryVar : cryVarArr) {
                                            cryVar.d = (int) (paint.measureText(cryVar.b) + 0.5f);
                                        }
                                    }
                                    drj[] drjVarArr = (drj[]) dljVar.getSpans(0, dljVar.length(), drj.class);
                                    if (drjVarArr != null) {
                                        for (drj drjVar : drjVarArr) {
                                            dljVar.removeSpan(drjVar);
                                        }
                                    }
                                    drj drjVar2 = new drj();
                                    new WeakReference(textView);
                                    dljVar.setSpan(drjVar2, 0, dljVar.length(), 18);
                                }
                                textView.setText(dljVar, bufferType2);
                                Iterator it9 = listUnmodifiableList.iterator();
                                while (it9.hasNext()) {
                                    ((aha) it9.next()).getClass();
                                    if (textView.getMovementMethod() == null) {
                                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                                    }
                                }
                                DefaultConfig ioVar2 = new DefaultConfig(context, 13);
                                ioVar2.d = linearLayout2;
                                DefaultConfig.g(ioVar2, null, 3);
                                String strZ = "编辑" /* cnb.z(-418080706525994L) */;
                                ls lsVar = new ls(cuaVar2, 7, ctxVar2);
                                bzy bzyVar = (bzy) ioVar2.c;
                                if (bzyVar != null) {
                                    bzyVar.s(strZ, new amw(lsVar, 2));
                                }
                                DefaultConfig.f(ioVar2, null, 3);
                                ioVar2.az();
                                return;
                            }
                            aphVar.z(str.substring(i5, i6));
                            i5 = i6 + 1;
                            if (i5 < str.length() && str.charAt(i6) == '\r') {
                                if (str.charAt(i5) == '\n') {
                                    i5 = i6 + 2;
                                }
                            }
                        }
                    }
                }
                break;
        }
    }
}
