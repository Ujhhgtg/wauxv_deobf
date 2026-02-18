package me.hd.wauxv.obf;

import android.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.SurroundingText;
import android.view.inputmethod.TextAttribute;
import android.view.inputmethod.TextSnapshot;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class asa extends BaseInputConnection {
    public static final bxt a = bxt.c("EditorInputConnection");
    public final CodeEditor b;
    public final pf c;
    public boolean d;

    public asa(CodeEditor codeEditor) {
        super(codeEditor, true);
        this.c = new pf();
        this.d = false;
        this.b = codeEditor;
        codeEditor.i.l(afh.class, new qp(this, 4));
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final synchronized boolean beginBatchEdit() {
        this.b.getProps().getClass();
        return this.b.getText().l();
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean clearMetaKeyStates(int i) {
        btm keyMetaStates = this.b.getKeyMetaStates();
        keyMetaStates.clearMetaKeyState(keyMetaStates.a, keyMetaStates.b, i);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final synchronized void closeConnection() {
        super.closeConnection();
        aff text = this.b.getText();
        while (text.e > 0) {
            text.u();
        }
        pf pfVar = this.c;
        pfVar.b = -1;
        pfVar.a = -1;
        CodeEditor codeEditor = this.b;
        codeEditor.setExtracting(null);
        codeEditor.invalidate();
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i) {
        if (!this.b.dw() || charSequence == null) {
            return false;
        }
        if (!"\n".equals(charSequence.toString())) {
            e(charSequence);
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(jUptimeMillis, jUptimeMillis, 0, 66, 0, 0, -1, 0, 6));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), jUptimeMillis, 1, 66, 0, 0, -1, 0, 6));
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i, int i2) {
        CodeEditor codeEditor = this.b;
        if (!codeEditor.dw() || i < 0 || i2 < 0) {
            return false;
        }
        pf pfVar = this.c;
        if (i == 1 && i2 == 0 && !pfVar.e()) {
            codeEditor.dj();
            return true;
        }
        if (i > 0 && i2 > 0) {
            beginBatchEdit();
        }
        boolean zE = pfVar.e();
        int i3 = zE ? pfVar.a : 0;
        int i4 = zE ? pfVar.b : 0;
        int i5 = codeEditor.getCursor().c.a;
        int i6 = i5 - i;
        if (i6 < 0) {
            i6 = 0;
        }
        codeEditor.getText().q(i6, i5);
        if (zE) {
            int iMax = Math.max(i6, i3);
            int iMax2 = i4 - Math.max(0, Math.min(i5, i4) - iMax);
            int iMax3 = Math.max(0, iMax - i6);
            i4 = iMax2 - iMax3;
            i3 -= iMax3;
        }
        int i7 = codeEditor.getCursor().d.a;
        int i8 = i7 + i2;
        if (i8 > codeEditor.getText().d) {
            i8 = codeEditor.getText().d;
        }
        codeEditor.getText().q(i7, i8);
        if (zE) {
            int iMax4 = Math.max(i7, i3);
            Math.max(0, Math.min(i8, i4) - iMax4);
            Math.max(0, iMax4 - i7);
        }
        if (i > 0 && i2 > 0) {
            endBatchEdit();
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        return false;
    }

    public final void e(CharSequence charSequence) {
        pf pfVar = this.c;
        boolean zE = pfVar.e();
        CodeEditor codeEditor = this.b;
        if (codeEditor.getProps().l) {
            if (pfVar.e()) {
                String string = ((aff) codeEditor.getText().subSequence(pfVar.a, pfVar.b)).toString();
                String string2 = charSequence.toString();
                if (pfVar.b != codeEditor.getCursor().c.a || codeEditor.getCursor().h() || !string2.startsWith(string)
                        || string2.length() <= string.length()) {
                    f();
                } else {
                    charSequence = string2.substring(string.length());
                    pfVar.b = -1;
                    pfVar.a = -1;
                }
            }
        } else if (pfVar.e()) {
            f();
        }
        codeEditor.de(charSequence, true);
        if (zE) {
            endBatchEdit();
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final synchronized boolean endBatchEdit() {
        boolean zU;
        zU = this.b.getText().u();
        if (!zU) {
            this.b.ex();
        }
        return zU;
    }

    public final void getResult() {
        pf pfVar = this.c;
        if (pfVar.e()) {
            try {
                this.b.getText().q(pfVar.a, pfVar.b);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            pfVar.b = -1;
            pfVar.a = -1;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean finishComposingText() {
        CodeEditor codeEditor = this.b;
        if (!codeEditor.dw()) {
            return false;
        }
        codeEditor.getProps().getClass();
        pf pfVar = this.c;
        pfVar.b = -1;
        pfVar.a = -1;
        endBatchEdit();
        codeEditor.ev();
        codeEditor.invalidate();
        return true;
    }

    public final CharSequence g(int i, int i2, int i3) {
        try {
            return h(i, i2, i3, false);
        } catch (IndexOutOfBoundsException e) {
            Log.w(a.b, "Failed to get text region for IME", e);
            return "";
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final int getCursorCapsMode(int i) {
        CodeEditor codeEditor = this.b;
        return TextUtils.getCapsMode(codeEditor.getText(), codeEditor.getCursor().c.a, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        CodeEditor codeEditor = this.b;
        codeEditor.getProps().getClass();
        codeEditor.getProps().getClass();
        if ((i & 1) != 0) {
            codeEditor.setExtracting(extractedTextRequest);
        } else {
            codeEditor.setExtracting(null);
        }
        return codeEditor.dp(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final Handler getHandler() {
        return this.b.getHandler();
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final CharSequence getSelectedText(int i) {
        CodeEditor codeEditor = this.b;
        codeEditor.getProps().getClass();
        int i2 = codeEditor.getCursor().c.a;
        int i3 = codeEditor.getCursor().d.a;
        if (i2 == i3) {
            return null;
        }
        return g(i2, i3, i);
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final SurroundingText getSurroundingText(int i, int i2, int i3) {
        CharSequence charSequenceH;
        CodeEditor codeEditor = this.b;
        codeEditor.getProps().getClass();
        if ((i | i2) < 0) {
            throw new IllegalArgumentException("length < 0");
        }
        int iMin = Math.min(Math.max(0, codeEditor.getCursor().c.a - i), codeEditor.getCursor().c.a);
        try {
            charSequenceH = h(iMin, Math.min(codeEditor.getText().d, codeEditor.getCursor().d.a + i2), i3, true);
        } catch (IndexOutOfBoundsException e) {
            Log.w(a.b, "Failed to get text region for IME", e);
            charSequenceH = "";
        }
        qc.s();
        return qc.r(codeEditor.getCursor().c.a - iMin, codeEditor.getCursor().d.a - iMin, iMin, charSequenceH);
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final CharSequence getTextAfterCursor(int i, int i2) {
        CodeEditor codeEditor = this.b;
        codeEditor.getProps().getClass();
        int i3 = codeEditor.getCursor().d.a;
        return g(i3, i + i3, i2);
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final CharSequence getTextBeforeCursor(int i, int i2) {
        CodeEditor codeEditor = this.b;
        codeEditor.getProps().getClass();
        int i3 = codeEditor.getCursor().c.a;
        return g(Math.max(i3 - i, i3 - codeEditor.getProps().g), i3, i2);
    }

    public final CharSequence h(int i, int i2, int i3, boolean z) {
        CodeEditor codeEditor = this.b;
        aff text = codeEditor.getText();
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        int i4 = 0;
        if (i < 0) {
            i = 0;
        }
        int i5 = text.d;
        if (i2 > i5) {
            i2 = i5;
        }
        if (i2 < i) {
            i = 0;
            i2 = 0;
        }
        if (!z && i2 - i > codeEditor.getProps().g) {
            i2 = Math.max(0, codeEditor.getProps().g) + i;
        }
        String string = ((aff) text.subSequence(i, i2)).toString();
        if (i3 != 1) {
            return string;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        pf pfVar = this.c;
        if (pfVar.e()) {
            try {
                int i6 = pfVar.a;
                int i7 = pfVar.b;
                int i8 = i6 - i;
                if (i8 < spannableStringBuilder.length()) {
                    if (i8 >= 0) {
                        i4 = i8;
                    }
                    int length = i7 - i;
                    if (length > 0) {
                        if (length >= spannableStringBuilder.length()) {
                            length = spannableStringBuilder.length();
                        }
                        spannableStringBuilder.setSpan(256, i4, length, 33);
                    }
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        return spannableStringBuilder;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean performContextMenuAction(int i) {
        CodeEditor codeEditor = this.b;
        switch (i) {
            case R.id.selectAll:
                codeEditor.em();
                return true;
            case R.id.cut:
                codeEditor.df(true);
                if (codeEditor.getCursor().h()) {
                    codeEditor.dj();
                }
                return true;
            case R.id.copy:
                codeEditor.df(true);
                return true;
            case R.id.paste:
                break;
            default:
                switch (i) {
                    case R.id.pasteAsPlainText:
                        break;
                    case R.id.undo:
                        codeEditor.eu();
                        return true;
                    case R.id.redo:
                        codeEditor.ej();
                        return true;
                    default:
                        return false;
                }
                break;
        }
        codeEditor.eg();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        CodeEditor codeEditor = this.b;
        throwIfVar1IsNull(codeEditor, "editor");
        throwIfVar1IsNull(str, com.umeng.ccg.a.z);
        codeEditor.i.g(new rp(codeEditor));
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean replaceText(int i, int i2, CharSequence charSequence, int i3, TextAttribute textAttribute) {
        int i4 = this.b.getText().d;
        if (i < 0 || i2 < 0 || i > i2 || i > i4 || i2 > i4) {
            return false;
        }
        beginBatchEdit();
        finishComposingText();
        setSelection(i, i2);
        commitText(charSequence, i3);
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean reportFullscreenMode(boolean z) {
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean requestCursorUpdates(int i) {
        this.b.ew();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int i, int i2) {
        CodeEditor codeEditor = this.b;
        if (codeEditor.dw() && codeEditor.ao == 0) {
            codeEditor.getProps().getClass();
            if (i == i2) {
                finishComposingText();
                return true;
            }
            if (i > i2) {
                i2 = i;
                i = i2;
            }
            if (i < 0) {
                i = 0;
            }
            try {
                int i3 = codeEditor.getText().d;
                if (i2 > i3) {
                    i2 = i3;
                }
                if (i < i2) {
                    pf pfVar = this.c;
                    pfVar.a = i;
                    pfVar.b = i2;
                    codeEditor.invalidate();
                    beginBatchEdit();
                    return true;
                }
            } catch (IndexOutOfBoundsException e) {
                Log.w(a.b, "set composing region for IME failed", e);
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence charSequence, int i) {
        CodeEditor codeEditor = this.b;
        if (codeEditor.dw() && codeEditor.ao == 0) {
            codeEditor.getProps().getClass();
            if (TextUtils.indexOf(charSequence, '\n') == -1) {
                pf pfVar = this.c;
                if (!pfVar.e()) {
                    if (codeEditor.getCursor().h()) {
                        codeEditor.dj();
                    }
                    beginBatchEdit();
                    pfVar.c = true;
                    codeEditor.de(charSequence, true);
                    int length = codeEditor.getCursor().c.a - charSequence.length();
                    int i2 = codeEditor.getCursor().c.a;
                    pfVar.a = length;
                    pfVar.b = i2;
                } else if (pfVar.e()) {
                    if (codeEditor.getProps().m) {
                        String string = charSequence.toString();
                        aff text = codeEditor.getText();
                        String strAn = text.an(pfVar.a, pfVar.b);
                        if (!strAn.equals(string)) {
                            if (strAn.length() < string.length() && string.startsWith(strAn)) {
                                ud udVarN = text.x().n(pfVar.b);
                                text.ab(udVarN.b, udVarN.c, string.substring(strAn.length()));
                            } else if (strAn.length() <= string.length() || !strAn.startsWith(string)) {
                                text.ag(pfVar.a, pfVar.b, string);
                            } else {
                                text.q(pfVar.b - (strAn.length() - string.length()), pfVar.b);
                            }
                        }
                    } else {
                        codeEditor.getText().ag(pfVar.a, pfVar.b, charSequence);
                    }
                    pfVar.b = pfVar.a + charSequence.length();
                }
                if (charSequence.length() == 0) {
                    finishComposingText();
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public final boolean setImeConsumesInput(boolean z) {
        this.d = z;
        this.b.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final boolean setSelection(int i, int i2) {
        CodeEditor codeEditor = this.b;
        boolean z = false;
        if (codeEditor.dw()) {
            codeEditor.getProps().getClass();
            if (i < 0) {
                i = 0;
            } else if (i > codeEditor.getText().d) {
                i = codeEditor.getText().d;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > codeEditor.getText().d) {
                i2 = codeEditor.getText().d;
            }
            if (i > i2) {
                int i3 = i2;
                i2 = i;
                i = i3;
            }
            z = true;
            if (i == codeEditor.getCursor().c.a && i2 == codeEditor.getCursor().d.a) {
                return true;
            }
            aff text = codeEditor.getText();
            ud udVarN = text.x().n(i);
            ud udVarN2 = text.x().n(i2);
            this.b.es(udVarN.b, false, udVarN.c, udVarN2.b, udVarN2.c, 4);
        }
        return z;
    }

    @Override // android.view.inputmethod.BaseInputConnection,
              // android.view.inputmethod.InputConnection
    public final TextSnapshot takeSnapshot() {
        int i;
        int i2;
        pf pfVar = this.c;
        if (pfVar.e()) {
            i = pfVar.a;
            i2 = pfVar.b;
        } else {
            i = -1;
            i2 = -1;
        }
        return av.b(getSurroundingText(1024, 1024, 1), i, i2, getCursorCapsMode(28672));
    }
}
