package me.hd.wauxv.obf;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class eut extends ajn implements ck {
    public static final AccelerateInterpolator an = new AccelerateInterpolator();
    public static final DecelerateInterpolator ao = new DecelerateInterpolator();
    public Context ap;
    public Context aq;
    public ActionBarOverlayLayout ar;
    public ActionBarContainer as;
    public ajv at;
    public ActionBarContextView au;
    public final View av;
    public boolean aw;
    public eus ax;
    public eus ay;
    public DefaultConfig az;
    public boolean ba;
    public final ArrayList bb;
    public int bc;
    public boolean bd;
    public boolean be;
    public boolean bf;
    public boolean bg;
    public esh bh;
    public boolean bi;
    public boolean bj;
    public final eur bk;
    public final eur bl;
    public final InstantCollection bm;

    public eut(Activity activity, boolean z) {
        new ArrayList();
        this.bb = new ArrayList();
        this.bc = 0;
        this.bd = true;
        this.bg = true;
        this.bk = new eur(this, 0);
        this.bl = new eur(this, 1);
        this.bm = new InstantCollection(this);
        View decorView = activity.getWindow().getDecorView();
        bp(decorView);
        if (z) {
            return;
        }
        this.av = decorView.findViewById(R.id.content);
    }

    public final void bn(boolean z) {
        esg esgVarAc;
        esg esgVarAc2;
        if (z) {
            if (!this.bf) {
                this.bf = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.ar;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                bs(false);
            }
        } else if (this.bf) {
            this.bf = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.ar;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            bs(false);
        }
        if (!this.as.isLaidOut()) {
            if (z) {
                ((ekt) this.at).a.setVisibility(4);
                this.au.setVisibility(0);
                return;
            } else {
                ((ekt) this.at).a.setVisibility(0);
                this.au.setVisibility(8);
                return;
            }
        }
        if (z) {
            ekt ektVar = (ekt) this.at;
            esgVarAc = ViewCompat.getOrCreateAnimationHelper(ektVar.a);
            esgVarAc.b(0.0f);
            esgVarAc.d(100L);
            esgVarAc.e(new eks(ektVar, 4));
            esgVarAc2 = this.au.ac(0, 200L);
        } else {
            ekt ektVar2 = (ekt) this.at;
            esg esgVarG = ViewCompat.getOrCreateAnimationHelper(ektVar2.a);
            esgVarG.b(1.0f);
            esgVarG.d(200L);
            esgVarG.e(new eks(ektVar2, 0));
            esgVarAc = this.au.ac(8, 100L);
            esgVarAc2 = esgVarG;
        }
        esh eshVar = new esh();
        ArrayList arrayList = eshVar.a;
        arrayList.add(esgVarAc);
        View view = (View) esgVarAc.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) esgVarAc2.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(esgVarAc2);
        eshVar.h();
    }

    public final Context bo() {
        if (this.aq == null) {
            TypedValue typedValue = new TypedValue();
            this.ap.getTheme().resolveAttribute(me.hd.wauxv.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.aq = new ContextThemeWrapper(this.ap, i);
            } else {
                this.aq = this.ap;
            }
        }
        return this.aq;
    }

    public final void bp(View view) {
        ajv wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(me.hd.wauxv.R.id.decor_content_parent);
        this.ar = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(me.hd.wauxv.R.id.action_bar);
        if (callbackFindViewById instanceof ajv) {
            wrapper = (ajv) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.at = wrapper;
        this.au = (ActionBarContextView) view.findViewById(me.hd.wauxv.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(me.hd.wauxv.R.id.action_bar_container);
        this.as = actionBarContainer;
        ajv ajvVar = this.at;
        if (ajvVar == null || this.au == null || actionBarContainer == null) {
            throw new IllegalStateException(eut.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((ekt) ajvVar).a.getContext();
        this.ap = context;
        if ((((ekt) this.at).b & 4) != 0) {
            this.aw = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.at.getClass();
        br(context.getResources().getBoolean(me.hd.wauxv.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.ap.obtainStyledAttributes(null, cyf.a, me.hd.wauxv.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.ar;
            if (!actionBarOverlayLayout2.j) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.bj = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.as;
            WeakHashMap weakHashMap = ViewCompat.a;
            eqq.k(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void bq(boolean z) {
        if (this.aw) {
            return;
        }
        int i = z ? 4 : 0;
        ekt ektVar = (ekt) this.at;
        int i2 = ektVar.b;
        this.aw = true;
        ektVar.p((i & 4) | (i2 & (-5)));
    }

    public final void br(boolean z) {
        if (z) {
            this.as.setTabContainer(null);
            ((ekt) this.at).getClass();
        } else {
            ((ekt) this.at).getClass();
            this.as.setTabContainer(null);
        }
        this.at.getClass();
        ((ekt) this.at).a.setCollapsible(false);
        this.ar.setHasNonEmbeddedTabs(false);
    }

    public final void bs(boolean z) {
        boolean z2 = this.be;
        boolean z3 = this.bf;
        InstantCollection instantCollectionVar = this.bm;
        View view = this.av;
        if (!z3 && z2) {
            if (this.bg) {
                this.bg = false;
                esh eshVar = this.bh;
                if (eshVar != null) {
                    eshVar.g();
                }
                int i = this.bc;
                eur eurVar = this.bk;
                if (i != 0 || (!this.bi && !z)) {
                    eurVar.f();
                    return;
                }
                this.as.setAlpha(1.0f);
                this.as.setTransitioning(true);
                esh eshVar2 = new esh();
                float f = -this.as.getHeight();
                if (z) {
                    this.as.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                esg esgVarG = ViewCompat.getOrCreateAnimationHelper(this.as);
                esgVarG.f(f);
                View view2 = (View) esgVarG.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(instantCollectionVar != null ? new aqi(instantCollectionVar, view2) : null);
                }
                boolean z4 = eshVar2.e;
                ArrayList arrayList = eshVar2.a;
                if (!z4) {
                    arrayList.add(esgVarG);
                }
                if (this.bd && view != null) {
                    esg esgVarG2 = ViewCompat.getOrCreateAnimationHelper(view);
                    esgVarG2.f(f);
                    if (!eshVar2.e) {
                        arrayList.add(esgVarG2);
                    }
                }
                boolean z5 = eshVar2.e;
                if (!z5) {
                    eshVar2.c = an;
                }
                if (!z5) {
                    eshVar2.b = 250L;
                }
                if (!z5) {
                    eshVar2.d = eurVar;
                }
                this.bh = eshVar2;
                eshVar2.h();
                return;
            }
            return;
        }
        if (this.bg) {
            return;
        }
        this.bg = true;
        esh eshVar3 = this.bh;
        if (eshVar3 != null) {
            eshVar3.g();
        }
        this.as.setVisibility(0);
        int i2 = this.bc;
        eur eurVar2 = this.bl;
        if (i2 == 0 && (this.bi || z)) {
            this.as.setTranslationY(0.0f);
            float f2 = -this.as.getHeight();
            if (z) {
                this.as.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.as.setTranslationY(f2);
            esh eshVar4 = new esh();
            esg esgVarG3 = ViewCompat.getOrCreateAnimationHelper(this.as);
            esgVarG3.f(0.0f);
            View view3 = (View) esgVarG3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(instantCollectionVar != null ? new aqi(instantCollectionVar, view3) : null);
            }
            boolean z6 = eshVar4.e;
            ArrayList arrayList2 = eshVar4.a;
            if (!z6) {
                arrayList2.add(esgVarG3);
            }
            if (this.bd && view != null) {
                view.setTranslationY(f2);
                esg esgVarG4 = ViewCompat.getOrCreateAnimationHelper(view);
                esgVarG4.f(0.0f);
                if (!eshVar4.e) {
                    arrayList2.add(esgVarG4);
                }
            }
            boolean z7 = eshVar4.e;
            if (!z7) {
                eshVar4.c = ao;
            }
            if (!z7) {
                eshVar4.b = 250L;
            }
            if (!z7) {
                eshVar4.d = eurVar2;
            }
            this.bh = eshVar4;
            eshVar4.h();
        } else {
            this.as.setAlpha(1.0f);
            this.as.setTranslationY(0.0f);
            if (this.bd && view != null) {
                view.setTranslationY(0.0f);
            }
            eurVar2.f();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.ar;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = ViewCompat.a;
            eqo.c(actionBarOverlayLayout);
        }
    }

    public eut(Dialog dialog) {
        new ArrayList();
        this.bb = new ArrayList();
        this.bc = 0;
        this.bd = true;
        this.bg = true;
        this.bk = new eur(this, 0);
        this.bl = new eur(this, 1);
        this.bm = new InstantCollection(this);
        bp(dialog.getWindow().getDecorView());
    }
}
