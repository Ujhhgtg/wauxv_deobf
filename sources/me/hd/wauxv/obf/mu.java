package me.hd.wauxv.obf;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mu implements bec {
    public final ArrayList a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList n;
    public ArrayList o;
    public boolean p;
    public ArrayList q;
    public final beg r;
    public boolean s;
    public int t;
    public boolean u;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mu(beg begVar) {
        this();
        begVar.ce();
        bdm bdmVar = begVar.w;
        if (bdmVar != null) {
            bdmVar.e.getClassLoader();
        }
        this.t = -1;
        this.u = false;
        this.r = begVar;
    }

    public final int aa(boolean z, boolean z2) {
        if (this.s) {
            throw new IllegalStateException("commit already called");
        }
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new bxr());
            ad(printWriter, "  ", true);
            printWriter.close();
        }
        this.s = true;
        boolean z3 = this.g;
        beg begVar = this.r;
        if (z3) {
            this.t = begVar.k.getAndIncrement();
        } else {
            this.t = -1;
        }
        if (z2) {
            begVar.bu(this, z);
        }
        return this.t;
    }

    public final void ab() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.h = false;
        this.r.bx(this, false);
    }

    public final void ac(int i, SomeFragmentManager someFragmentManagerVar, String str, int i2) {
        String str2 = someFragmentManagerVar.cf;
        if (str2 != null) {
            bfd.d(someFragmentManagerVar, str2);
        }
        Class<?> cls = someFragmentManagerVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = someFragmentManagerVar.bs;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + someFragmentManagerVar + ": was " + someFragmentManagerVar.bs + " now " + str);
            }
            someFragmentManagerVar.bs = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + someFragmentManagerVar + " with tag " + str + " to container view with no id");
            }
            int i3 = someFragmentManagerVar.bq;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + someFragmentManagerVar + ": was " + someFragmentManagerVar.bq + " now " + i);
            }
            someFragmentManagerVar.bq = i;
            someFragmentManagerVar.br = i;
        }
        w(new bfe(i2, someFragmentManagerVar));
        someFragmentManagerVar.bm = this.r;
    }

    public final void ad(PrintWriter printWriter, String str, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.i);
            printWriter.print(" mIndex=");
            printWriter.print(this.t);
            printWriter.print(" mCommitted=");
            printWriter.println(this.s);
            if (this.f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f));
            }
            if (this.b != 0 || this.c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.c));
            }
            if (this.d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.j != 0 || this.k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.k);
            }
            if (this.l != 0 || this.m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.m);
            }
        }
        ArrayList arrayList = this.a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            bfe bfeVar = (bfe) arrayList.get(i);
            switch (bfeVar.a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + bfeVar.a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(bfeVar.b);
            if (z) {
                if (bfeVar.d != 0 || bfeVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(bfeVar.d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(bfeVar.e));
                }
                if (bfeVar.f != 0 || bfeVar.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(bfeVar.f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(bfeVar.g));
                }
            }
        }
    }

    public final void ae(SomeFragmentManager someFragmentManagerVar) {
        beg begVar = someFragmentManagerVar.bm;
        if (begVar == null || begVar == this.r) {
            w(new bfe(3, someFragmentManagerVar));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + someFragmentManagerVar.toString() + " is already attached to a FragmentManager.");
    }

    public final void af(SomeFragmentManager someFragmentManagerVar, buh buhVar) {
        beg begVar = someFragmentManagerVar.bm;
        beg begVar2 = this.r;
        if (begVar != begVar2) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + begVar2);
        }
        if (buhVar == buh.b && someFragmentManagerVar.as > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + buhVar + " after the Fragment has been created");
        }
        if (buhVar == buh.a) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + buhVar + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
        }
        bfe bfeVar = new bfe();
        bfeVar.a = 10;
        bfeVar.b = someFragmentManagerVar;
        bfeVar.c = false;
        bfeVar.h = someFragmentManagerVar.cg;
        bfeVar.i = buhVar;
        w(bfeVar);
    }

    public final void ag(SomeFragmentManager someFragmentManagerVar) {
        beg begVar = someFragmentManagerVar.bm;
        if (begVar == null || begVar == this.r) {
            w(new bfe(8, someFragmentManagerVar));
            return;
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + someFragmentManagerVar.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.t >= 0) {
            sb.append(" #");
            sb.append(this.t);
        }
        if (this.i != null) {
            sb.append(" ");
            sb.append(this.i);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // me.hd.wauxv.obf.bec
    public final boolean v(ArrayList arrayList, ArrayList arrayList2) {
        if (beg.ar(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        this.r.d.add(this);
        return true;
    }

    public final void w(bfe bfeVar) {
        this.a.add(bfeVar);
        bfeVar.d = this.b;
        bfeVar.e = this.c;
        bfeVar.f = this.d;
        bfeVar.g = this.e;
    }

    public final void x(int i) {
        if (this.g) {
            if (beg.ar(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                bfe bfeVar = (bfe) arrayList.get(i2);
                SomeFragmentManager someFragmentManagerVar = bfeVar.b;
                if (someFragmentManagerVar != null) {
                    someFragmentManagerVar.bl += i;
                    if (beg.ar(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + bfeVar.b + " to " + bfeVar.b.bl);
                    }
                }
            }
        }
    }

    public final void y() {
        ArrayList arrayList = this.a;
        int size = arrayList.size() - 1;
        while (size >= 0) {
            bfe bfeVar = (bfe) arrayList.get(size);
            if (bfeVar.c) {
                if (bfeVar.a == 8) {
                    bfeVar.c = false;
                    arrayList.remove(size - 1);
                    size--;
                } else {
                    int i = bfeVar.b.br;
                    bfeVar.a = 2;
                    bfeVar.c = false;
                    for (int i2 = size - 1; i2 >= 0; i2--) {
                        bfe bfeVar2 = (bfe) arrayList.get(i2);
                        if (bfeVar2.c && bfeVar2.b.br == i) {
                            arrayList.remove(i2);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public final void z() {
        aa(false, true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public mu(mu muVar) {
        this();
        muVar.r.ce();
        bdm bdmVar = muVar.r.w;
        if (bdmVar != null) {
            bdmVar.e.getClassLoader();
        }
        for (bfe bfeVar : muVar.a) {
            ArrayList arrayList = this.a;
            bfe bfeVar2 = new bfe();
            bfeVar2.a = bfeVar.a;
            bfeVar2.b = bfeVar.b;
            bfeVar2.c = bfeVar.c;
            bfeVar2.d = bfeVar.d;
            bfeVar2.e = bfeVar.e;
            bfeVar2.f = bfeVar.f;
            bfeVar2.g = bfeVar.g;
            bfeVar2.h = bfeVar.h;
            bfeVar2.i = bfeVar.i;
            arrayList.add(bfeVar2);
        }
        this.b = muVar.b;
        this.c = muVar.c;
        this.d = muVar.d;
        this.e = muVar.e;
        this.f = muVar.f;
        this.g = muVar.g;
        this.h = muVar.h;
        this.i = muVar.i;
        this.l = muVar.l;
        this.m = muVar.m;
        this.j = muVar.j;
        this.k = muVar.k;
        if (muVar.n != null) {
            ArrayList arrayList2 = new ArrayList();
            this.n = arrayList2;
            arrayList2.addAll(muVar.n);
        }
        if (muVar.o != null) {
            ArrayList arrayList3 = new ArrayList();
            this.o = arrayList3;
            arrayList3.addAll(muVar.o);
        }
        this.p = muVar.p;
        this.t = -1;
        this.u = false;
        this.r = muVar.r;
        this.s = muVar.s;
        this.t = muVar.t;
        this.u = muVar.u;
    }

    public mu() {
        this.a = new ArrayList();
        this.h = true;
        this.p = false;
    }
}
