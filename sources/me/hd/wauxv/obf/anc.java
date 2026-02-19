package me.hd.wauxv.obf;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class anc extends SomeFragmentManager implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public Handler a;
    public boolean q;
    public Dialog s;
    public boolean t;
    public boolean u;
    public boolean v;
    public final dc b = new dc(this, 4);
    public final amy c = new amy(this);
    public final amz d = new amz(this);
    public int l = 0;
    public int m = 0;
    public boolean n = true;
    public boolean o = true;
    public int p = -1;
    public final ana r = new ana(this);
    public boolean w = false;

    @Override // me.hd.wauxv.obf.bdj
    public final LayoutInflater aa(Bundle bundle) {
        LayoutInflater layoutInflaterAa = super.aa(bundle);
        boolean z = this.o;
        if (z && !this.q) {
            if (z && !this.w) {
                try {
                    this.q = true;
                    Dialog dialogAh = ah();
                    this.s = dialogAh;
                    if (this.o) {
                        int i = this.l;
                        if (i == 1 || i == 2) {
                            dialogAh.requestWindowFeature(1);
                        } else if (i == 3) {
                            Window window = dialogAh.getWindow();
                            if (window != null) {
                                window.addFlags(24);
                            }
                            dialogAh.requestWindowFeature(1);
                        }
                        Context contextCq = cq();
                        if (contextCq != null) {
                            this.s.setOwnerActivity((Activity) contextCq);
                        }
                        this.s.setCancelable(this.n);
                        this.s.setOnCancelListener(this.c);
                        this.s.setOnDismissListener(this.d);
                        this.w = true;
                    } else {
                        this.s = null;
                    }
                    this.q = false;
                } catch (Throwable th) {
                    this.q = false;
                    throw th;
                }
            }
            if (beg.ar(2)) {
                Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
            }
            Dialog dialog = this.s;
            if (dialog != null) {
                return layoutInflaterAa.cloneInContext(dialog.getContext());
            }
        } else if (beg.ar(2)) {
            String str = "getting layout inflater for DialogFragment " + this;
            if (!this.o) {
                Log.d("FragmentManager", "mShowsDialog = false: " + str);
                return layoutInflaterAa;
            }
            Log.d("FragmentManager", "mCreatingDialog = true: " + str);
        }
        return layoutInflaterAa;
    }

    @Override // me.hd.wauxv.obf.bdj
    public void ab() {
        this.bx = true;
        Dialog dialog = this.s;
        if (dialog != null) {
            this.t = false;
            dialog.show();
            View decorView = this.s.getWindow().getDecorView();
            throwIfVar1IsNull(decorView, "<this>");
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public void ac() {
        this.bx = true;
        Dialog dialog = this.s;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void ad(Bundle bundle) {
        Bundle bundle2;
        this.bx = true;
        if (this.s == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.s.onRestoreInstanceState(bundle2);
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void ae(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.ae(layoutInflater, viewGroup, bundle);
        if (this.bz != null || this.s == null || bundle == null
                || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.s.onRestoreInstanceState(bundle2);
    }

    public void af() {
        ag(false, false);
    }

    public final void ag(boolean z, boolean z2) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.v = false;
        Dialog dialog = this.s;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.s.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.a.getLooper()) {
                    onDismiss(this.s);
                } else {
                    this.a.post(this.b);
                }
            }
        }
        this.t = true;
        if (this.p >= 0) {
            beg begVarCs = cs();
            int i = this.p;
            if (i < 0) {
                throw new IllegalArgumentException(concatVar2Var1(i, "Bad id: "));
            }
            begVarCs.bu(new bed(begVarCs, null, i), z);
            this.p = -1;
            return;
        }
        mu muVar = new mu(cs());
        muVar.p = true;
        muVar.ae(this);
        if (z) {
            muVar.aa(true, true);
        } else {
            muVar.z();
        }
    }

    public Dialog ah() {
        if (beg.ar(3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new acj(dc(), this.m);
    }

    public final Dialog al() {
        Dialog dialog = this.s;
        if (dialog != null) {
            return dialog;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void am(beg begVar, String str) {
        this.u = false;
        this.v = true;
        mu muVar = new mu(begVar);
        muVar.p = true;
        muVar.ac(0, this, str, 1);
        muVar.z();
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void e(Context context) {
        Object obj;
        super.e(context);
        chv chvVar = this.cj;
        chvVar.getClass();
        chv.k("observeForever");
        ana anaVar = this.r;
        bwp bwpVar = new bwp(chvVar, anaVar);
        dee deeVar = chvVar.c;
        deb debVarB = deeVar.b(anaVar);
        if (debVarB != null) {
            obj = debVarB.b;
        } else {
            deb debVar = new deb(anaVar, bwpVar);
            deeVar.g++;
            deb debVar2 = deeVar.e;
            if (debVar2 == null) {
                deeVar.d = debVar;
                deeVar.e = debVar;
            } else {
                debVar2.c = debVar;
                debVar.d = debVar2;
                deeVar.e = debVar;
            }
            obj = null;
        }
        bwr bwrVar = (bwr) obj;
        if (bwrVar instanceof bwq) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (bwrVar == null) {
            bwpVar.k(true);
        }
        if (this.v) {
            return;
        }
        this.u = false;
    }

    @Override // me.hd.wauxv.obf.bdj
    public void f(Bundle bundle) {
        super.f(bundle);
        this.a = new Handler();
        this.o = this.br == 0;
        if (bundle != null) {
            this.l = bundle.getInt("android:style", 0);
            this.m = bundle.getInt("android:theme", 0);
            this.n = bundle.getBoolean("android:cancelable", true);
            this.o = bundle.getBoolean("android:showsDialog", this.o);
            this.p = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void h() {
        this.bx = true;
        Dialog dialog = this.s;
        if (dialog != null) {
            this.t = true;
            dialog.setOnDismissListener(null);
            this.s.dismiss();
            if (!this.u) {
                onDismiss(this.s);
            }
            this.s = null;
            this.w = false;
        }
    }

    @Override // me.hd.wauxv.obf.bdj
    public void j(Bundle bundle) {
        Dialog dialog = this.s;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.l;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.m;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.n;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.o;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.p;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.t) {
            return;
        }
        if (beg.ar(3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        ag(true, true);
    }

    @Override // me.hd.wauxv.obf.bdj
    public final cnb x() {
        return new anb(this, new bde(this));
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void y() {
        this.bx = true;
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void z() {
        this.bx = true;
        if (!this.v && !this.u) {
            this.u = true;
        }
        chv chvVar = this.cj;
        chvVar.getClass();
        chv.k("removeObserver");
        bwr bwrVar = (bwr) chvVar.c.c(this.r);
        if (bwrVar == null) {
            return;
        }
        bwrVar.d();
        bwrVar.k(false);
    }
}
