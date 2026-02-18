package me.hd.wauxv.obf;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cks {
    public ViewParent a;
    public ViewParent b;
    public final ViewGroup c;
    public boolean d;
    public int[] e;

    public cks(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public final boolean f(float f, float f2, boolean z) {
        ViewParent viewParentJ;
        if (this.d && (viewParentJ = j(0)) != null) {
            try {
                return viewParentJ.onNestedFling(this.c, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentJ + " does not implement interface method onNestedFling", e);
            }
        }
        return false;
    }

    public final boolean g(float f, float f2) {
        ViewParent viewParentJ;
        if (this.d && (viewParentJ = j(0)) != null) {
            try {
                return viewParentJ.onNestedPreFling(this.c, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentJ + " does not implement interface method onNestedPreFling", e);
            }
        }
        return false;
    }

    public final boolean h(int[] iArr, int i, int i2, int i3, int[] iArr2) {
        ViewParent viewParentJ;
        int i4;
        int i5;
        ViewGroup viewGroup;
        if (!this.d || (viewParentJ = j(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup2 = this.c;
        if (iArr2 != null) {
            viewGroup2.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (viewParentJ instanceof ckt) {
            ((ckt) viewParentJ).al(viewGroup2, i, i2, iArr3, i3);
            viewGroup = viewGroup2;
        } else {
            viewGroup = viewGroup2;
            if (i3 == 0) {
                try {
                    viewParentJ.onNestedPreScroll(viewGroup, i, i2, iArr3);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentJ + " does not implement interface method onNestedPreScroll", e);
                }
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean i(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent viewParentJ;
        int i6;
        int i7;
        int[] iArr3;
        if (this.d && (viewParentJ = j(i5)) != null) {
            if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
                ViewGroup viewGroup = this.c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i6 = iArr[0];
                    i7 = iArr[1];
                } else {
                    i6 = 0;
                    i7 = 0;
                }
                if (iArr2 == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    int[] iArr4 = this.e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (viewParentJ instanceof cku) {
                    ((cku) viewParentJ).ag(viewGroup, i, i2, i3, i4, i5, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i3;
                    iArr3[1] = iArr3[1] + i4;
                    if (viewParentJ instanceof ckt) {
                        ((ckt) viewParentJ).ah(viewGroup, i, i2, i3, i4, i5);
                    } else if (i5 == 0) {
                        try {
                            viewParentJ.onNestedScroll(viewGroup, i, i2, i3, i4);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + viewParentJ + " does not implement interface method onNestedScroll", e);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i6;
                    iArr[1] = iArr[1] - i7;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent j(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i != 1) {
            return null;
        }
        return this.b;
    }

    public final boolean k(int i) {
        return j(i) != null;
    }

    public final boolean l(int i, int i2) {
        boolean zOnStartNestedScroll;
        if (!k(i2)) {
            if (this.d) {
                View view = this.c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z = parent instanceof ckt;
                    if (z) {
                        zOnStartNestedScroll = ((ckt) parent).ai(view2, view, i, i2);
                    } else if (i2 == 0) {
                        try {
                            zOnStartNestedScroll = parent.onStartNestedScroll(view2, view, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            zOnStartNestedScroll = false;
                        }
                    } else {
                        zOnStartNestedScroll = false;
                    }
                    if (zOnStartNestedScroll) {
                        if (i2 == 0) {
                            this.a = parent;
                        } else if (i2 == 1) {
                            this.b = parent;
                        }
                        if (z) {
                            ((ckt) parent).aj(view2, view, i, i2);
                        } else if (i2 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i);
                            } catch (AbstractMethodError e2) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void m(int i) {
        ViewParent viewParentJ = j(i);
        if (viewParentJ != null) {
            boolean z = viewParentJ instanceof ckt;
            ViewGroup viewGroup = this.c;
            if (z) {
                ((ckt) viewParentJ).ak(viewGroup, i);
            } else if (i == 0) {
                try {
                    viewParentJ.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentJ + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.a = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.b = null;
            }
        }
    }
}
