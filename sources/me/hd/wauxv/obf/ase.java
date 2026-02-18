package me.hd.wauxv.obf;

import android.widget.PopupWindow;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ase {
    public final CodeEditor aa;
    public final int ab;
    public final int[] ac = new int[2];
    public final boolean ad;
    public boolean ae;
    public final boolean af;
    public final CodeEditor ag;
    public int ah;
    public int ai;
    public int aj;
    public int ak;
    public int al;
    public int am;
    public final PopupWindow z;

    public ase(CodeEditor codeEditor, int i) {
        this.aa = codeEditor;
        this.ab = i;
        this.ag = codeEditor;
        PopupWindow popupWindow = new PopupWindow();
        this.z = popupWindow;
        popupWindow.setElevation(codeEditor.getDpUnit() * 8.0f);
        tf tfVar = new tf(this, 1);
        qp qpVar = new qp(this, 5);
        if (!this.ae) {
            codeEditor.i.l(dfb.class, qpVar);
            this.ae = true;
        }
        if (ao(8) && !this.af) {
            codeEditor.addOnLayoutChangeListener(tfVar);
            this.af = true;
        }
        this.ad = true;
    }

    public final void an(boolean z) {
        int i;
        int offsetY;
        PopupWindow popupWindow = this.z;
        if (z || popupWindow.isShowing()) {
            boolean zAo = ao(1);
            CodeEditor codeEditor = this.aa;
            int offsetX = this.aj - (zAo ? codeEditor.getOffsetX() : this.ah);
            if (zAo) {
                i = this.ak;
                offsetY = codeEditor.getOffsetY();
            } else {
                i = this.ak;
                offsetY = this.ai;
            }
            int iMax = i - offsetY;
            int iMax2 = this.al + offsetX;
            int iMax3 = this.am + iMax;
            if (!ao(2)) {
                offsetX = Math.max(0, Math.min(offsetX, codeEditor.getWidth()));
                iMax2 = Math.max(0, Math.min(iMax2, codeEditor.getWidth()));
                iMax = Math.max(0, Math.min(iMax, codeEditor.getHeight()));
                iMax3 = Math.max(0, Math.min(iMax3, codeEditor.getHeight()));
                if (iMax >= iMax3 || offsetX >= iMax2) {
                    i();
                    return;
                }
            }
            if (ao(8)) {
                try {
                    ahy cursor = codeEditor.getCursor();
                    if (cursor != null) {
                        ud udVar = cursor.c;
                        int i2 = udVar.b;
                        int i3 = udVar.c;
                        float fEb = (codeEditor.eb() + codeEditor.j.r(i2, i3)[1]) - codeEditor.getOffsetX();
                        float offsetY2 = codeEditor.j.r(i2, i3)[0] - codeEditor.getOffsetY();
                        if (!Float.isNaN(fEb) && !Float.isNaN(offsetY2)) {
                            float fMax = Math.max(1.0f, codeEditor.getInsertSelectionWidth()) + fEb;
                            float rowHeight = codeEditor.getRowHeight() + offsetY2;
                            if (fEb < iMax2 && fMax > offsetX && offsetY2 < iMax3 && rowHeight > iMax) {
                                i();
                                return;
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            int[] iArr = this.ac;
            codeEditor.getLocationInWindow(iArr);
            int i4 = iMax2 - offsetX;
            int i5 = iMax3 - iMax;
            int i6 = offsetX + iArr[0];
            int i7 = iMax + iArr[1];
            if (popupWindow.isShowing()) {
                popupWindow.update(i6, i7, i4, i5);
            } else if (z) {
                popupWindow.setHeight(i5);
                popupWindow.setWidth(i4);
                popupWindow.showAtLocation(this.ag, 8388659, i6, i7);
            }
        }
    }

    public final boolean ao(int i) {
        if (Integer.bitCount(i) == 1) {
            return (i & this.ab) != 0;
        }
        throw new IllegalArgumentException("Not a valid feature integer");
    }

    public void i() {
        PopupWindow popupWindow = this.z;
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}
