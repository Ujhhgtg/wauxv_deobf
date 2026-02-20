package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cs implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ cs(Object obj, int i, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getInstructions()" because "finallyBlockTerminus" is null
    	at jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>(TraverserActivePathState.java:253)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:422)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:302)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:222)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:150)
     */
    @Override // java.lang.Runnable
    public final void run() {
        cbu cbuVar;
        int i = 0;
        switch (this.a) {
            case 0:
                cq cqVar = (cq) this.b;
                cw cwVar = (cw) this.c;
                cbw cbwVar = cwVar.c;
                if (cbwVar != null && (cbuVar = cbwVar.f) != null) {
                    cbuVar.bw(cbwVar);
                }
                View view = (View) cwVar.h;
                if (view != null && view.getWindowToken() != null) {
                    if (cqVar.p()) {
                        cwVar.t = cqVar;
                    } else if (cqVar.h != null) {
                        cqVar.q(0, 0, false, false);
                        cwVar.t = cqVar;
                    }
                }
                cwVar.v = null;
                return;
            case 1:
                ((dn) this.b).a = this.c;
                return;
            case 2:
                ((Application) this.b).unregisterActivityLifecycleCallbacks((dn) this.c);
                return;
            case 3:
                Object obj = this.c;
                Object obj2 = this.b;
                try {
                    Method method = AbstractC0022do.d;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC0022do.e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 4:
                SyntheticPileOfMess bmuVar = (SyntheticPileOfMess) this.b;
                Typeface typeface = (Typeface) this.c;
                ResourcesCompat resourcesCompatVar = (ResourcesCompat) bmuVar.obj;
                if (resourcesCompatVar != null) {
                    resourcesCompatVar.f(typeface);
                    return;
                }
                return;
            case 5:
                bkf bkfVarI = bkf.i();
                bkfVarI.getClass();
                eot.d();
                bkfVarI.h.set(true);
                ((baq) this.c).b.b = true;
                ((baq) this.c).a.getViewTreeObserver().removeOnDrawListener((baq) this.b);
                ((baq) this.c).b.a.clear();
                return;
            case 6:
                bhz bhzVar = (bhz) this.c;
                if (bhzVar.d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.b).run();
                    return;
                } catch (Throwable th2) {
                    bhzVar.c.getClass();
                    if (Log.isLoggable("GlideExecutor", 6)) {
                        Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
                        return;
                    }
                    return;
                }
            case 7:
                bqu bquVar = (bqu) this.b;
                bqx bqxVar = (bqx) this.c;
                RecyclerView recyclerView = bqxVar.s;
                if (recyclerView == null || !recyclerView.ac || bquVar.k || bquVar.e.x() == -1) {
                    return;
                }
                czc itemAnimator = bqxVar.s.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.r()) {
                    ArrayList arrayList = bqxVar.q;
                    int size = arrayList.size();
                    while (i < size) {
                        if (((bqu) arrayList.get(i)).l) {
                            i++;
                        }
                    }
                    bqxVar.n.getClass();
                    return;
                }
                bqxVar.s.post(this);
                return;
            case 8:
                break;
            case 9:
                ((bbx) this.b).accept(this.c);
                return;
            case 10:
                era eraVar = ((SwipeDismissBehavior) this.c).a;
                if (eraVar == null || !eraVar.ab()) {
                    return;
                }
                View view2 = (View) this.b;
                WeakHashMap weakHashMap = ViewCompat.a;
                view2.postOnAnimation(this);
                return;
            default:
                bmy.af((Activity) this.b, (View) this.c);
                return;
        }
        while (true) {
            try {
                ((Runnable) this.b).run();
            } catch (Throwable th3) {
                cna.z(EmptyCoroutineContext.INSTANCE, th3);
            }
            try {
                Runnable runnableP = ((buw) this.c).p();
                if (runnableP == null) {
                    return;
                }
                this.b = runnableP;
                i++;
                if (i >= 16) {
                    buw buwVar = (buw) this.c;
                    Dispatcher dispatcherVar = buwVar.l;
                    try {
                        if (dispatcherVar.j(buwVar)) {
                            buw buwVar2 = (buw) this.c;
                            HugeSyntheticPileOfHelpers.bl(buwVar2.l, buwVar2, this);
                            return;
                        }
                    } catch (Throwable th4) {
                        throw new aoq(th4, dispatcherVar, buwVar);
                    }
                }
            } catch (Throwable th5) {
                buw buwVar3 = (buw) this.c;
                synchronized (buwVar3.o) {
                    try {
                        buw.f.decrementAndGet(buwVar3);
                        throw th5;
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
            }
        }
    }

    public /* synthetic */ cs(Object obj, Object obj2, int i, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public cs(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.a = 10;
        this.c = swipeDismissBehavior;
        this.b = view;
    }

    public cs(bqx bqxVar, bqu bquVar, int i) {
        this.a = 7;
        this.c = bqxVar;
        this.b = bquVar;
    }
}
