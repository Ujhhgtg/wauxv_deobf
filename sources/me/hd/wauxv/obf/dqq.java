package me.hd.wauxv.obf;

import android.os.Build;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqq {
    public static final ThreadLocal a = new ThreadLocal();
    public final Editable b;
    public final DynamicLayout c;

    public dqq() {
        Editable editableNewEditable = Editable.Factory.getInstance().newEditable("");
        this.b = editableNewEditable;
        if (Build.VERSION.SDK_INT > 28) {
            DynamicLayout.Builder lineSpacing = DynamicLayout.Builder.obtain(editableNewEditable, new TextPaint(), 1073741823).setIncludePad(true).setLineSpacing(0.0f, 0.0f);
            TextDirectionHeuristic textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            DynamicLayout.Builder textDirection = lineSpacing.setTextDirection(TextDirectionHeuristics.FIRSTSTRONG_LTR);
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            this.c = textDirection.setAlignment(Layout.Alignment.ALIGN_NORMAL).build();
            return;
        }
        DynamicLayout dynamicLayout = new DynamicLayout(editableNewEditable, new TextPaint(), 1073741823, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
        this.c = dynamicLayout;
        try {
            Field declaredField = Layout.class.getDeclaredField("mTextDir");
            declaredField.setAccessible(true);
            declaredField.set(dynamicLayout, TextDirectionHeuristics.FIRSTSTRONG_LTR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static dqq d() {
        ThreadLocal threadLocal = a;
        dqq dqqVar = (dqq) threadLocal.get();
        if (dqqVar != null) {
            return dqqVar;
        }
        dqq dqqVar2 = new dqq();
        threadLocal.set(dqqVar2);
        return dqqVar2;
    }

    public final int e(int i, afo afoVar) {
        int iMax = Math.max(0, i - 64);
        int i2 = i - iMax;
        int iMin = Math.min(afoVar.b, i + 65);
        Editable editable = this.b;
        editable.append((CharSequence) afoVar, iMax, iMin);
        Selection.setSelection(editable, Math.min(i2, editable.length()));
        Selection.moveLeft(editable, this.c);
        int selectionStart = Selection.getSelectionStart(editable);
        editable.clear();
        Selection.removeSelection(editable);
        return selectionStart + iMax;
    }
}
