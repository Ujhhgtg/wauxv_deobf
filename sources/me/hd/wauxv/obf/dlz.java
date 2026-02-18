package me.hd.wauxv.obf;

import java.util.LinkedList;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dlz implements alw {
    public final char a;
    public int g = 0;
    public final LinkedList h = new LinkedList();

    public dlz(char c) {
        this.a = c;
    }

    @Override // me.hd.wauxv.obf.alw
    public final void b(dqe dqeVar, dqe dqeVar2, int i) {
        LinkedList<alw> linkedList = this.h;
        for (alw alwVar : linkedList) {
            if (alwVar.e() <= i) {
                alwVar.b(dqeVar, dqeVar2, i);
            }
        }
        alwVar = (alw) linkedList.getFirst();
        alwVar.b(dqeVar, dqeVar2, i);
    }

    @Override // me.hd.wauxv.obf.alw
    public final char c() {
        return this.a;
    }

    @Override // me.hd.wauxv.obf.alw
    public final int d(alv alvVar, alv alvVar2) {
        int i = alvVar.g;
        LinkedList<alw> linkedList = this.h;
        for (alw alwVar : linkedList) {
            if (alwVar.e() <= i) {
                return alwVar.d(alvVar, alvVar2);
            }
        }
        alwVar = (alw) linkedList.getFirst();
        return alwVar.d(alvVar, alvVar2);
    }

    @Override // me.hd.wauxv.obf.alw
    public final int e() {
        return this.g;
    }

    @Override // me.hd.wauxv.obf.alw
    public final char f() {
        return this.a;
    }

    public final void i(alw alwVar) {
        int iE = alwVar.e();
        LinkedList linkedList = this.h;
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            int iE2 = ((alw) listIterator.next()).e();
            if (iE > iE2) {
                listIterator.previous();
                listIterator.add(alwVar);
                return;
            } else if (iE == iE2) {
                throw new IllegalArgumentException("Cannot add two delimiter processors for char '" + this.a + "' and minimum length " + iE);
            }
        }
        linkedList.add(alwVar);
        this.g = iE;
    }
}
