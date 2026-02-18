package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ir {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        afj erpVar;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                erpVar = new erp(clipData, 3);
            } else {
                afk afkVar = new afk();
                afkVar.b = clipData;
                afkVar.c = 3;
                erpVar = afkVar;
            }
            eqz.o(textView, erpVar.build());
            return true;
        } finally {
            textView.endBatchEdit();
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        afj erpVar;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            erpVar = new erp(clipData, 3);
        } else {
            afk afkVar = new afk();
            afkVar.b = clipData;
            afkVar.c = 3;
            erpVar = afkVar;
        }
        eqz.o(view, erpVar.build());
        return true;
    }
}
