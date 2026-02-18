package me.hd.wauxv.obf;

import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eup {
    public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i) {
        callback.onProvideKeyboardShortcuts(list, menu, i);
    }
}
