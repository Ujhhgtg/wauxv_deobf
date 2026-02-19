package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class aci extends Activity implements err, bkg, dep, bup, btl {
    public static final /* synthetic */ int p = 0;
    public final CopyOnWriteArrayList aa;
    public final CopyOnWriteArrayList ab;
    public final CopyOnWriteArrayList ac;
    public final CopyOnWriteArrayList ad;
    public boolean ae;
    public boolean af;
    public final Kotlin$Lazy ag;
    public final bur q = new bur(this);
    public final afr r = new afr();
    public final FactoryPools s;
    public final but t;
    public erq u;
    public final ace v;
    public final Kotlin$Lazy w;
    public final acg x;
    public final CopyOnWriteArrayList y;
    public final CopyOnWriteArrayList z;

    public aci() {
        final hb hbVar = (hb) this;
        this.s = new FactoryPools(new abx(hbVar, 0));
        deo deoVar = new deo(this, new cfx(this, 12));
        but butVar = new but(deoVar, 10);
        this.t = butVar;
        this.v = new ace(hbVar);
        this.w = new Kotlin$Lazy(new ach(hbVar, 2));
        new AtomicInteger();
        this.x = new acg(hbVar);
        this.y = new CopyOnWriteArrayList();
        this.z = new CopyOnWriteArrayList();
        this.aa = new CopyOnWriteArrayList();
        this.ab = new CopyOnWriteArrayList();
        this.ac = new CopyOnWriteArrayList();
        this.ad = new CopyOnWriteArrayList();
        bur burVar = this.q;
        if (burVar == null) {
            throw new IllegalStateException(
                    "getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        final int i = 0;
        burVar.j(new bul() { // from class: me.hd.wauxv.obf.aby
            @Override // me.hd.wauxv.obf.bul
            public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
                Window window;
                View viewPeekDecorView;
                switch (i) {
                    case 0:
                        hb hbVar2 = hbVar;
                        if (lifeEventEnumVar == LifeEventEnum.ON_STOP && (window = hbVar2.getWindow()) != null
                                && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        hb hbVar3 = hbVar;
                        if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                            hbVar3.r.b = null;
                            if (!hbVar3.isChangingConfigurations()) {
                                hbVar3.aj().b();
                            }
                            ace aceVar = hbVar3.v;
                            hb hbVar4 = aceVar.d;
                            hbVar4.getWindow().getDecorView().removeCallbacks(aceVar);
                            hbVar4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(aceVar);
                        }
                        break;
                }
            }
        });
        final int i2 = 1;
        this.q.j(new bul() { // from class: me.hd.wauxv.obf.aby
            @Override // me.hd.wauxv.obf.bul
            public final void e(bup bupVar, LifeEventEnum lifeEventEnumVar) {
                Window window;
                View viewPeekDecorView;
                switch (i2) {
                    case 0:
                        hb hbVar2 = hbVar;
                        if (lifeEventEnumVar == LifeEventEnum.ON_STOP && (window = hbVar2.getWindow()) != null
                                && (viewPeekDecorView = window.peekDecorView()) != null) {
                            viewPeekDecorView.cancelPendingInputEvents();
                            break;
                        }
                        break;
                    default:
                        hb hbVar3 = hbVar;
                        if (lifeEventEnumVar == LifeEventEnum.ON_DESTROY) {
                            hbVar3.r.b = null;
                            if (!hbVar3.isChangingConfigurations()) {
                                hbVar3.aj().b();
                            }
                            ace aceVar = hbVar3.v;
                            hb hbVar4 = aceVar.d;
                            hbVar4.getWindow().getDecorView().removeCallbacks(aceVar);
                            hbVar4.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(aceVar);
                        }
                        break;
                }
            }
        });
        this.q.j(new cyo(hbVar, 2));
        deoVar.i();
        aye.r(this);
        ((but) butVar.c).ad("android:support:activity-result", new abz(hbVar, 0));
        int i3 = 0;
        am(new aca(hbVar, i3));
        new Kotlin$Lazy(new ach(hbVar, i3));
        this.ag = new Kotlin$Lazy(new ach(hbVar, 3));
    }

    @Override // me.hd.wauxv.obf.bkg
    public final chq ai() {
        chq chqVar = new chq(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = chqVar.c;
        if (application != null) {
            Application application2 = getApplication();
            throwIfVar1IsNull(application2, "application");
            linkedHashMap.put(ern.n, application2);
        }
        linkedHashMap.put(aye.d, this);
        linkedHashMap.put(aye.e, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(aye.f, extras);
        }
        return chqVar;
    }

    @Override // me.hd.wauxv.obf.err
    public final erq aj() {
        if (getApplication() == null) {
            throw new IllegalStateException(
                    "Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.u == null) {
            acd acdVar = (acd) getLastNonConfigurationInstance();
            if (acdVar != null) {
                this.u = acdVar.a;
            }
            if (this.u == null) {
                this.u = new erq();
            }
        }
        erq erqVar = this.u;
        throwIfVar1IsNull(erqVar);
        return erqVar;
    }

    @Override // me.hd.wauxv.obf.dep
    public final but ak() {
        return (but) this.t.c;
    }

    public final void al(adv advVar) {
        throwIfVar1IsNull(advVar, "listener");
        this.y.add(advVar);
    }

    public final void am(cqw cqwVar) {
        afr afrVar = this.r;
        afrVar.getClass();
        aci aciVar = (aci) afrVar.b;
        if (aciVar != null) {
            cqwVar.b(aciVar);
        }
        ((CopyOnWriteArraySet) afrVar.a).add(cqwVar);
    }

    public final cqt an() {
        return (cqt) this.ag.getValue();
    }

    public final void ao() {
        View decorView = getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "window.decorView");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        throwIfVar1IsNull(decorView2, "window.decorView");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        throwIfVar1IsNull(decorView3, "window.decorView");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        throwIfVar1IsNull(decorView4, "window.decorView");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        throwIfVar1IsNull(decorView5, "window.decorView");
        decorView5.setTag(R.id.report_drawn, this);
    }

    @Override // me.hd.wauxv.obf.bup
    public final bur ap() {
        return this.q;
    }

    public final void aq(Bundle bundle) {
        super.onCreate(bundle);
        int i = dbq.a;
        dbo.b(this);
    }

    public final void ar(Bundle bundle) {
        throwIfVar1IsNull(bundle, "outState");
        this.q.p(buh.c);
        super.onSaveInstanceState(bundle);
    }

    @Override // me.hd.wauxv.obf.btl
    public final boolean b(KeyEvent keyEvent) {
        throwIfVar1IsNull(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        throwIfVar1IsNull(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "getDecorView(...)");
        if (emc.al(decorView, keyEvent)) {
            return true;
        }
        return emc.am(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        throwIfVar1IsNull(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "getDecorView(...)");
        if (emc.al(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.x.i(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        an().i();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        throwIfVar1IsNull(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            ((adv) it.next()).accept(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.t.aa(bundle);
        afr afrVar = this.r;
        afrVar.getClass();
        afrVar.b = this;
        Iterator it = ((CopyOnWriteArraySet) afrVar.a).iterator();
        while (it.hasNext()) {
            ((cqw) it.next()).b(this);
        }
        aq(bundle);
        int i = dbq.a;
        dbo.b(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        throwIfVar1IsNull(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.s.h).iterator();
        while (it.hasNext()) {
            ((bdy) it.next()).a.bg();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        throwIfVar1IsNull(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = ((CopyOnWriteArrayList) this.s.h).iterator();
            while (it.hasNext()) {
                if (((bdy) it.next()).a.bl()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        if (this.ae) {
            return;
        }
        Iterator it = this.ab.iterator();
        while (it.hasNext()) {
            ((adv) it.next()).accept(new chp(z));
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        throwIfVar1IsNull(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.aa.iterator();
        while (it.hasNext()) {
            ((adv) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        throwIfVar1IsNull(menu, "menu");
        Iterator it = ((CopyOnWriteArrayList) this.s.h).iterator();
        while (it.hasNext()) {
            ((bdy) it.next()).a.bm();
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z) {
        if (this.af) {
            return;
        }
        Iterator it = this.ac.iterator();
        while (it.hasNext()) {
            ((adv) it.next()).accept(new ctj(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        throwIfVar1IsNull(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.s.h).iterator();
        while (it.hasNext()) {
            ((bdy) it.next()).a.bp();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        throwIfVar1IsNull(strArr, "permissions");
        throwIfVar1IsNull(iArr, "grantResults");
        if (this.x.i(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr)
                .putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        acd acdVar;
        erq erqVar = this.u;
        if (erqVar == null && (acdVar = (acd) getLastNonConfigurationInstance()) != null) {
            erqVar = acdVar.a;
        }
        if (erqVar == null) {
            return null;
        }
        acd acdVar2 = new acd();
        acdVar2.a = erqVar;
        return acdVar2;
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        throwIfVar1IsNull(bundle, "outState");
        bur burVar = this.q;
        if (burVar != null) {
            burVar.p(buh.c);
        }
        ar(bundle);
        this.t.ab(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator it = this.z.iterator();
        while (it.hasNext()) {
            ((adv) it.next()).accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.ad.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * jadx.core.utils.exceptions.JadxRuntimeException: Expected to find fallthrough
     * terminus for handler TryEdge: [PREMATURE_EXIT B:24:0x001d -> B:5:0x000c] -
     * Handler: None
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:419)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (HugeSyntheticPileOfHelpers.isTraceEnabled()) {
                HugeSyntheticPileOfHelpers.beginTrace("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            bft bftVar = (bft) this.w.getValue();
            synchronized (bftVar.a) {
                try {
                    bftVar.b = true;
                    Iterator it = bftVar.c.iterator();
                    while (it.hasNext()) {
                        ((bfu) it.next()).invoke();
                    }
                    bftVar.c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        ao();
        View decorView = getWindow().getDecorView();
        throwIfVar1IsNull(decorView, "window.decorView");
        ace aceVar = this.v;
        aceVar.getClass();
        if (!aceVar.c) {
            aceVar.c = true;
            decorView.getViewTreeObserver().addOnDrawListener(aceVar);
        }
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i) {
        throwIfVar1IsNull(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3,
            int i4) throws IntentSender.SendIntentException {
        throwIfVar1IsNull(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i, Bundle bundle) {
        throwIfVar1IsNull(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3,
            int i4, Bundle bundle) throws IntentSender.SendIntentException {
        throwIfVar1IsNull(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        throwIfVar1IsNull(configuration, "newConfig");
        this.ae = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.ae = false;
            Iterator it = this.ab.iterator();
            while (it.hasNext()) {
                ((adv) it.next()).accept(new chp(z));
            }
        } catch (Throwable th) {
            this.ae = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        throwIfVar1IsNull(configuration, "newConfig");
        this.af = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.af = false;
            Iterator it = this.ac.iterator();
            while (it.hasNext()) {
                ((adv) it.next()).accept(new ctj(z));
            }
        } catch (Throwable th) {
            this.af = false;
            throw th;
        }
    }
}
