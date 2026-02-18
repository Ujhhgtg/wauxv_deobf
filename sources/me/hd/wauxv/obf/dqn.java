package me.hd.wauxv.obf;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class dqn extends aq {
    public final TextInputLayout a;

    public dqn(TextInputLayout textInputLayout) {
        this.a = textInputLayout;
    }

    @Override // me.hd.wauxv.obf.aq
    public final void d(View view, bd bdVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = bdVar.a;
        this.g.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.a;
        EditText editText = textInputLayout.getEditText();
        Editable text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        boolean zIsEmpty2 = TextUtils.isEmpty(hint);
        boolean z = textInputLayout.bs;
        boolean zIsEmpty3 = TextUtils.isEmpty(error);
        boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String string = !zIsEmpty2 ? hint.toString() : "";
        dmj dmjVar = textInputLayout.c;
        jp jpVar = dmjVar.b;
        if (jpVar.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(jpVar);
            accessibilityNodeInfo.setTraversalAfter(jpVar);
        } else {
            accessibilityNodeInfo.setTraversalAfter(dmjVar.d);
        }
        if (!zIsEmpty) {
            accessibilityNodeInfo.setText(text);
        } else if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setText(string);
            if (!z && placeholderText != null) {
                accessibilityNodeInfo.setText(string + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            accessibilityNodeInfo.setText(placeholderText);
        }
        if (!TextUtils.isEmpty(string)) {
            accessibilityNodeInfo.setHintText(string);
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z2) {
            if (zIsEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        jp jpVar2 = textInputLayout.k.y;
        if (jpVar2 != null) {
            accessibilityNodeInfo.setLabelFor(jpVar2);
        }
        textInputLayout.d.x().ab(bdVar);
    }

    @Override // me.hd.wauxv.obf.aq
    public final void l(View view, AccessibilityEvent accessibilityEvent) {
        super.l(view, accessibilityEvent);
        this.a.d.x().ac(accessibilityEvent);
    }
}
