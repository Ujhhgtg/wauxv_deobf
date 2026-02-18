package me.hd.wauxv.obf;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class sq implements afp {
    public final aff a;
    public final ud b;
    public final ud c;
    public final ArrayList d;
    public final int e;
    public final int f;

    public sq(aff affVar) {
        ud udVar = new ud();
        udVar.c = 0;
        udVar.b = 0;
        udVar.a = 0;
        this.b = udVar;
        this.c = new ud();
        this.d = new ArrayList();
        this.e = 50;
        this.f = 50;
        this.a = affVar;
        q();
    }

    public static void g(ud udVar, int i, int i2) {
        if (udVar.b != i) {
            throw new IllegalArgumentException("can not find other lines with findInLine()");
        }
        udVar.a = (udVar.a - udVar.c) + i2;
        udVar.c = i2;
    }

    @Override // me.hd.wauxv.obf.afp
    public final void cy(aff affVar) {
    }

    @Override // me.hd.wauxv.obf.afp
    public final synchronized void cz(aff affVar, int i, int i2, int i3, int i4, CharSequence charSequence) {
        try {
            for (ud udVar : this.d) {
                int i5 = udVar.b;
                if (i5 == i) {
                    if (udVar.c >= i2) {
                        udVar.a += charSequence.length();
                        udVar.b = (i3 - i) + udVar.b;
                        udVar.c = (udVar.c + i4) - i2;
                    }
                } else if (i5 > i) {
                    udVar.a += charSequence.length();
                    udVar.b = (i3 - i) + udVar.b;
                }
            }
            q();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // me.hd.wauxv.obf.afp
    public final synchronized void db(aff affVar, int i, int i2, int i3, int i4, StringBuilder sb) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ud udVar : this.d) {
                int i5 = udVar.b;
                if (i5 == i) {
                    if (udVar.c >= i2) {
                        arrayList.add(udVar);
                    }
                } else if (i5 > i) {
                    if (i5 < i3) {
                        arrayList.add(udVar);
                    } else if (i5 == i3) {
                        arrayList.add(udVar);
                    } else {
                        udVar.a -= sb.length();
                        udVar.b -= i3 - i;
                    }
                }
            }
            this.d.removeAll(arrayList);
            q();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h(ud udVar, int i, ud udVar2) {
        int i2 = udVar.a;
        if (i2 < i) {
            throw new IllegalArgumentException("Unable to find forward from method findIndexBackward()");
        }
        int i3 = udVar.b;
        int iMax = udVar.c;
        while (i2 > i) {
            i2 -= iMax + 1;
            i3--;
            if (i3 == -1) {
                i(this.b, i, udVar2);
                return;
            } else {
                iMax = ((afo) this.a.a.get(i3)).b + Math.max(r5.g().g - 1, 0);
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            i3++;
            iMax = i4 - 1;
        }
        udVar2.c = iMax;
        udVar2.b = i3;
        udVar2.a = i;
    }

    public final void i(ud udVar, int i, ud udVar2) {
        int i2 = udVar.a;
        if (i2 > i) {
            throw new IllegalArgumentException("Unable to find backward from method findIndexForward()");
        }
        int i3 = udVar.b;
        int i4 = udVar.c;
        aff affVar = this.a;
        ArrayList arrayList = affVar.a;
        ArrayList arrayList2 = affVar.a;
        int iMax = ((afo) arrayList2.get(i3)).b + Math.max(((afo) arrayList.get(i3)).g().g - 1, 0);
        int i5 = (iMax - i4) + i2;
        while (i5 < i) {
            i3++;
            iMax = ((afo) arrayList2.get(i3)).b + Math.max(r0.g().g - 1, 0);
            i5 += iMax + 1;
        }
        if (i5 > i) {
            iMax -= i5 - i;
        }
        udVar2.c = iMax;
        udVar2.b = i3;
        udVar2.a = i;
    }

    public final void j(ud udVar, int i, int i2, ud udVar2) {
        int i3 = udVar.b;
        if (i3 < i) {
            throw new IllegalArgumentException("can not find forward from findLiCoBackward()");
        }
        int i4 = udVar.a - udVar.c;
        while (i3 > i) {
            afo afoVar = (afo) this.a.a.get(i3 - 1);
            i4 -= afoVar.b + afoVar.g().g;
            i3--;
        }
        udVar2.c = 0;
        udVar2.b = i3;
        udVar2.a = i4;
        g(udVar2, i, i2);
    }

    public final void k(ud udVar, int i, int i2, ud udVar2) {
        int i3 = udVar.b;
        if (i3 > i) {
            throw new IllegalArgumentException("can not find backward from findLiCoForward()");
        }
        int i4 = udVar.a - udVar.c;
        while (i3 < i) {
            afo afoVar = (afo) this.a.a.get(i3);
            i4 += afoVar.b + afoVar.g().g;
            i3++;
        }
        udVar2.c = 0;
        udVar2.b = i3;
        udVar2.a = i4;
        g(udVar2, i, i2);
    }

    public final synchronized ud l(int i) {
        ud udVar;
        try {
            udVar = this.b;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                ud udVar2 = (ud) this.d.get(i4);
                int iAbs = Math.abs(udVar2.a - i);
                if (iAbs < i2) {
                    i3 = i4;
                    udVar = udVar2;
                    i2 = iAbs;
                }
                if (iAbs <= this.e) {
                    break;
                }
            }
            if (Math.abs(this.c.a - i) < i2) {
                udVar = this.c;
            }
            if (udVar != this.b && udVar != this.c) {
                Collections.swap(this.d, i3, r7.size() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return udVar;
    }

    public final synchronized ud m(int i) {
        ud udVar;
        try {
            udVar = this.b;
            int i2 = i;
            int i3 = 0;
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                ud udVar2 = (ud) this.d.get(i4);
                int iAbs = Math.abs(udVar2.b - i);
                if (iAbs < i2) {
                    i3 = i4;
                    udVar = udVar2;
                    i2 = iAbs;
                }
                if (i2 <= 50) {
                    break;
                }
            }
            if (Math.abs(this.c.b - i) < i2) {
                udVar = this.c;
            }
            if (udVar != this.b && udVar != this.c) {
                Collections.swap(this.d, i3, r7.size() - 1);
            }
        } catch (Throwable th) {
            throw th;
        }
        return udVar;
    }

    public final ud n(int i) {
        ud udVar = new ud();
        aff affVar = this.a;
        affVar.n(i);
        affVar.ae(false);
        try {
            ud udVarL = l(i);
            int i2 = udVarL.a;
            if (i2 == i) {
                udVar.a = i2;
                udVar.b = udVarL.b;
                udVar.c = udVarL.c;
            } else if (i2 < i) {
                i(udVarL, i, udVar);
            } else {
                h(udVarL, i, udVar);
            }
            if (Math.abs(i - udVarL.a) >= this.e) {
                p(udVar.d());
            }
            return udVar;
        } finally {
            affVar.ap(false);
        }
    }

    public final ud o(int i, int i2) {
        ud udVar = new ud();
        aff affVar = this.a;
        affVar.p(i, i2);
        affVar.ae(false);
        try {
            ud udVarM = m(i);
            int i3 = udVarM.b;
            if (i3 == i) {
                udVar.a = udVarM.a;
                udVar.b = i3;
                udVar.c = udVarM.c;
                if (udVarM.c == i2) {
                    return udVar;
                }
                g(udVar, i, i2);
            } else if (i3 < i) {
                k(udVarM, i, i2, udVar);
            } else {
                j(udVarM, i, i2, udVar);
            }
            if (Math.abs(udVarM.b - i) > 50) {
                p(udVar.d());
            }
            return udVar;
        } finally {
            affVar.ap(false);
        }
    }

    public final synchronized void p(ud udVar) {
        if (this.f <= 0) {
            return;
        }
        this.d.add(udVar);
        if (this.d.size() > this.f) {
            this.d.remove(0);
        }
    }

    public final void q() {
        aff affVar = this.a;
        int i = affVar.d;
        ud udVar = this.c;
        udVar.a = i;
        int size = affVar.a.size() - 1;
        udVar.b = size;
        udVar.c = affVar.y(size).b;
    }
}
