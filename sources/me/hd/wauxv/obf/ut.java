package me.hd.wauxv.obf;

import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ut implements cke, awz, aww, cqk, afd {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ut(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        bax baxVar = (bax) this.a;
        baw bawVar = (baw) this.b;
        if (baxVar.a) {
            return evrVar;
        }
        baxVar.k(evrVar, new baw(bawVar));
        return evrVar;
    }

    @Override // me.hd.wauxv.obf.afd
    public void c(int i, afo afoVar, afc afcVar) {
        evy evyVar = (evy) this.a;
        ((ArrayList) this.b).addAll(evyVar.i.y(i, afoVar, evyVar.h));
        if (evyVar.d()) {
            return;
        }
        afcVar.b = true;
    }

    @Override // me.hd.wauxv.obf.cke
    public boolean d(MenuItem menuItem) throws IllegalAccessException, InvocationTargetException {
        Object next;
        BaseAdapter baseAdapter = (BaseAdapter) this.a;
        ListView listView = (ListView) this.b;
        biw.a.getClass();
        Iterator it = biw.f().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!nullSafeIsEqual(((biv) next).b, String.valueOf(menuItem.getTitle())));
        if (((biv) next) == null) {
            return false;
        }
        ux.a.u(String.valueOf(menuItem.getTitle()));
        aic.a.getClass();
        StaticHelpers7.toDexMethod(aib.a).invoke(baseAdapter, Boolean.TRUE);
        agk.a.getClass();
        StaticHelpers7.toDexMethod(agj.a).invoke(listView, null);
        baseAdapter.notifyDataSetChanged();
        return true;
    }

    @Override // me.hd.wauxv.obf.aww
    public void e(ua uaVar) {
        arw arwVar = (arw) this.a;
        dh dhVar = (dh) this.b;
        bmp bmpVar = (bmp) uaVar;
        CodeEditor codeEditor = arwVar.aa;
        if (codeEditor.dy()) {
            MotionEvent motionEvent = bmpVar.l;
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 9) {
                    codeEditor.removeCallbacks(dhVar);
                    arwVar.k();
                    arw.g(arwVar, bmpVar);
                    return;
                } else {
                    if (action != 10) {
                        return;
                    }
                    arwVar.e = null;
                    if (arwVar.c.b) {
                        return;
                    }
                    arw.h(arwVar, dhVar);
                    arw.g(arwVar, bmpVar);
                    return;
                }
            }
            if (arwVar.c.b) {
                return;
            }
            if (!codeEditor.dz(motionEvent.getX(), motionEvent.getY())) {
                arwVar.e = null;
                arw.h(arwVar, dhVar);
            } else if (Math.abs(motionEvent.getX() - ((Number) arwVar.f.first).floatValue()) > 20.0f
                    || Math.abs(motionEvent.getY() - ((Number) arwVar.f.second).floatValue()) > 20.0f) {
                arw.g(arwVar, bmpVar);
                long jDr = codeEditor.dr(motionEvent.getX(), motionEvent.getY());
                arwVar.e = codeEditor.getText().x().o((int) (jDr >> 32), (int) (jDr & 4294967295L));
                arw.h(arwVar, dhVar);
            }
        }
    }

    @Override // me.hd.wauxv.obf.awz
    public void g(ua uaVar, afc afcVar) {
        aro aroVar = (aro) this.a;
        IInvokable bgfVar = (IInvokable) this.b;
        if (bgfVar != null) {
            aroVar.getClass();
            if (!((Boolean) bgfVar.invoke(uaVar)).booleanValue()) {
                return;
            }
        }
        aroVar.t();
    }
}
