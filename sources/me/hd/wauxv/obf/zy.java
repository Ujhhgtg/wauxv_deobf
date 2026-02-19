package me.hd.wauxv.obf;

import android.content.ClipData;
import android.content.ClipboardManager;
import io.github.rosemoe.sora.widget.CodeEditor;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class zy implements bnz {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ zy(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // me.hd.wauxv.obf.bnz
    public final String[] c() {
        switch (this.a) {
            case 0:
                return new String[]{"CLIPBOARD"};
            default:
                return new String[]{"TM_CURRENT_LINE", "TM_LINE_INDEX", "TM_LINE_NUMBER", "CURSOR_INDEX", "CURSOR_NUMBER", "TM_CURRENT_WORD", "SELECTION", "TM_SELECTED_TEXT"};
        }
    }

    @Override // me.hd.wauxv.obf.bnz
    public final String resolve(String str) {
        ClipData primaryClip;
        CodeEditor codeEditor;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ClipboardManager clipboardManager = (ClipboardManager) obj;
                if ("CLIPBOARD".equals(str)) {
                    return (clipboardManager == null || !clipboardManager.hasPrimaryClip() || (primaryClip = clipboardManager.getPrimaryClip()) == null || primaryClip.getItemCount() == 0) ? "" : primaryClip.getItemAt(0).getText().toString();
                }
                throw new IllegalArgumentException(yg.k("Unsupported variable name:", str));
            default:
                codeEditor = (CodeEditor) obj;
                str.getClass();
                switch (str) {
                    case "TM_CURRENT_LINE":
                    case "TM_LINE_NUMBER":
                        return Integer.toString(codeEditor.getCursor().c.b + 1);
                    case "TM_CURRENT_WORD":
                        aff text = codeEditor.getText();
                        long jX = ResourcesCompat.x(text.y(text.w().c.b), text.w().c.c, true);
                        return text.y(text.w().c.b).subSequence((int) (jX >> 32), (int) (jX & 4294967295L)).toString();
                    case "TM_SELECTED_TEXT":
                    case "SELECTION":
                        ahy cursor = codeEditor.getCursor();
                        return ((aff) codeEditor.getText().subSequence(cursor.c.a, cursor.d.a)).toString();
                    case "CURSOR_NUMBER":
                        return Integer.toString(codeEditor.getCursor().c.a + 1);
                    case "TM_LINE_INDEX":
                        return Integer.toString(codeEditor.getCursor().c.b);
                    case "CURSOR_INDEX":
                        return Integer.toString(codeEditor.getCursor().c.a);
                    default:
                        throw new IllegalArgumentException("Unsupported variable name:".concat(str));
                }
        }
    }
}
