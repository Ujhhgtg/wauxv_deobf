package me.hd.wauxv.obf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ccp extends hz implements Menu {
    public final cbw a;

    public ccp(Context context, cbw cbwVar) {
        super(context);
        if (cbwVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.a = cbwVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return l(this.a.z(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.a.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = l(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.a.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        dhq dhqVar = (dhq) this.h;
        if (dhqVar != null) {
            dhqVar.clear();
        }
        this.a.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.a.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return l(this.a.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return l(this.a.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.a.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.a.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return this.a.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.a.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((dhq) this.h) != null) {
            int i2 = 0;
            while (true) {
                dhq dhqVar = (dhq) this.h;
                if (i2 >= dhqVar.l) {
                    break;
                }
                if (((dog) dhqVar.r(i2)).getGroupId() == i) {
                    ((dhq) this.h).h(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.a.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((dhq) this.h) != null) {
            int i2 = 0;
            while (true) {
                dhq dhqVar = (dhq) this.h;
                if (i2 >= dhqVar.l) {
                    break;
                }
                if (((dog) dhqVar.r(i2)).getItemId() == i) {
                    ((dhq) this.h).h(i2);
                    break;
                }
                i2++;
            }
        }
        this.a.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        this.a.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        this.a.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        this.a.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.a.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.a.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.a.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return l(this.a.add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.a.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return l(this.a.z(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return this.a.addSubMenu(i, i2, i3, i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return l(this.a.add(i, i2, i3, i4));
    }
}
