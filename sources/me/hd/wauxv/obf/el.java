package me.hd.wauxv.obf;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.android.dx.io.Opcodes;
import java.util.WeakHashMap;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class el extends acj implements DialogInterface, he {
    public ic a;
    public final id b;
    public final ej c;

    /* JADX WARN: Type inference failed for: r2v2, types: [me.hd.wauxv.obf.id] */
    public el(ContextThemeWrapper contextThemeWrapper, int i) {
        int i2;
        int iD = d(contextThemeWrapper, i);
        if (iD == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i2 = typedValue.resourceId;
        } else {
            i2 = iD;
        }
        super(contextThemeWrapper, i2);
        this.b = new btl() { // from class: me.hd.wauxv.obf.id
            @Override // me.hd.wauxv.obf.btl
            public final boolean b(KeyEvent keyEvent) {
                return this.a.dexFind(keyEvent);
            }
        };
        ho hoVarE = initOnce();
        if (iD == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iD = typedValue2.resourceId;
        }
        ((ic) hoVarE).bg = iD;
        hoVarE.m();
        this.c = new ej(getContext(), this, getWindow());
    }

    public static int d(Context context, int i) {
        if (((i >>> 24) & Opcodes.CONST_METHOD_TYPE) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        ic icVar = (ic) initOnce();
        icVar.cf();
        ((ViewGroup) icVar.an.findViewById(android.R.id.content)).addView(view, layoutParams);
        icVar.z.f(icVar.y.getCallback());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        initOnce().n();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return emc.am(this.b, getWindow().getDecorView(), this, keyEvent);
    }

    public final ho getThisObject() {
        if (this.a == null) {
            hm hmVar = ho.a;
            this.a = new ic(getContext(), getWindow(), this, this);
        }
        return this.a;
    }

    public final void f(Bundle bundle) {
        initOnce().l();
        super.onCreate(bundle);
        initOnce().m();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i) {
        ic icVar = (ic) initOnce();
        icVar.cf();
        return icVar.y.findViewById(i);
    }

    public final void g(CharSequence charSequence) {
        super.setTitle(charSequence);
        initOnce().s(charSequence);
    }

    public final boolean h(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        ic icVar = (ic) initOnce();
        if (icVar.ab != null) {
            icVar.cj();
            icVar.ab.getClass();
            icVar.ck(0);
        }
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i;
        ListAdapter listAdapter;
        View viewFindViewById;
        f(bundle);
        ej ejVar = this.c;
        ejVar.b.setContentView(ejVar.z);
        Context context = ejVar.a;
        Window window = ejVar.c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View view = ejVar.g;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !ej.ag(view)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (ejVar.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (ejVar.f != null) {
                ((LinearLayout.LayoutParams) ((bvf) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupAh = ej.ah(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupAh2 = ej.ah(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupAh3 = ej.ah(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        ejVar.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        ejVar.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupAh2.findViewById(android.R.id.message);
        ejVar.v = textView;
        if (textView != null) {
            String str = ejVar.e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                ejVar.r.removeView(ejVar.v);
                if (ejVar.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) ejVar.r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(ejVar.r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(ejVar.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupAh2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupAh3.findViewById(android.R.id.button1);
        ejVar.i = button;
        ch chVar = ejVar.af;
        button.setOnClickListener(chVar);
        if (TextUtils.isEmpty(ejVar.j)) {
            ejVar.i.setVisibility(8);
            i = 0;
        } else {
            ejVar.i.setText(ejVar.j);
            ejVar.i.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroupAh3.findViewById(android.R.id.button2);
        ejVar.l = button2;
        button2.setOnClickListener(chVar);
        if (TextUtils.isEmpty(ejVar.m)) {
            ejVar.l.setVisibility(8);
        } else {
            ejVar.l.setText(ejVar.m);
            ejVar.l.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroupAh3.findViewById(android.R.id.button3);
        ejVar.o = button3;
        button3.setOnClickListener(chVar);
        if (TextUtils.isEmpty(ejVar.p)) {
            ejVar.o.setVisibility(8);
        } else {
            ejVar.o.setText(ejVar.p);
            ejVar.o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = ejVar.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = ejVar.l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = ejVar.o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupAh3.setVisibility(8);
        }
        if (ejVar.w != null) {
            viewGroupAh.addView(ejVar.w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            ejVar.t = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(ejVar.d) || !ejVar.ad) {
                window.findViewById(R.id.title_template).setVisibility(8);
                ejVar.t.setVisibility(8);
                viewGroupAh.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                ejVar.u = textView2;
                textView2.setText(ejVar.d);
                Drawable drawable = ejVar.s;
                if (drawable != null) {
                    ejVar.t.setImageDrawable(drawable);
                } else {
                    ejVar.u.setPadding(ejVar.t.getPaddingLeft(), ejVar.t.getPaddingTop(), ejVar.t.getPaddingRight(),
                            ejVar.t.getPaddingBottom());
                    ejVar.t.setVisibility(8);
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i2 = (viewGroupAh == null || viewGroupAh.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupAh3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupAh2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i2 != 0) {
            NestedScrollView nestedScrollView2 = ejVar.r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (ejVar.e == null && ejVar.f == null) ? null
                    : viewGroupAh.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupAh2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = ejVar.f;
        if (alertController$RecycleListView != null && (!z3 || i2 == 0)) {
            alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(),
                    i2 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.a,
                    alertController$RecycleListView.getPaddingRight(),
                    z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.b);
        }
        if (!z2) {
            View view2 = ejVar.f;
            if (view2 == null) {
                view2 = ejVar.r;
            }
            if (view2 != null) {
                int i3 = z3 ? 2 : 0;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = eqz.a;
                eqr.b(view2, i2 | i3, 3);
                if (viewFindViewById11 != null) {
                    viewGroupAh2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupAh2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = ejVar.f;
        if (alertController$RecycleListView2 == null || (listAdapter = ejVar.x) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i4 = ejVar.y;
        if (i4 > -1) {
            alertController$RecycleListView2.setItemChecked(i4, true);
            alertController$RecycleListView2.setSelection(i4);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.c.r;
        if (nestedScrollView == null || !nestedScrollView.ao(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.c.r;
        if (nestedScrollView == null || !nestedScrollView.ao(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void onStop() {
        super.onStop();
        ic icVar = (ic) initOnce();
        icVar.cj();
        eut eutVar = icVar.ab;
        if (eutVar != null) {
            eutVar.bi = false;
            esh eshVar = eutVar.bh;
            if (eshVar != null) {
                eshVar.g();
            }
        }
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void setContentView(int i) {
        m();
        initOnce().p(i);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i) {
        super.setTitle(i);
        initOnce().s(getContext().getString(i));
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void setContentView(View view) {
        m();
        initOnce().q(view);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        g(charSequence);
        ej ejVar = this.c;
        ejVar.d = charSequence;
        TextView textView = ejVar.u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // me.hd.wauxv.obf.acj, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m();
        initOnce().r(view, layoutParams);
    }
}
