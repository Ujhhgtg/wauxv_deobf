package me.hd.wauxv.obf;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class cbw implements Menu {
    public static final int[] a = {1, 4, 5, 3, 2, 0};
    public final Context b;
    public final Resources c;
    public boolean d;
    public final boolean e;
    public cbu f;
    public final ArrayList g;
    public final ArrayList h;
    public boolean i;
    public final ArrayList j;
    public final ArrayList k;
    public boolean l;
    public CharSequence n;
    public Drawable o;
    public View p;
    public cbz w;
    public boolean y;
    public int m = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public final ArrayList u = new ArrayList();
    public final CopyOnWriteArrayList v = new CopyOnWriteArrayList();
    public boolean x = false;

    public cbw(Context context) {
        boolean zI;
        boolean z = false;
        this.b = context;
        Resources resources = context.getResources();
        this.c = resources;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = true;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            if (Build.VERSION.SDK_INT >= 28) {
                zI = aov.i(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                zI = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (zI) {
                z = true;
            }
        }
        this.e = z;
    }

    public final void aa(ccm ccmVar, Context context) {
        this.v.add(new WeakReference(ccmVar));
        ccmVar.af(context, this);
        this.l = true;
    }

    public final void ab(boolean z) {
        if (this.t) {
            return;
        }
        this.t = true;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar = (ccm) weakReference.get();
            if (ccmVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                ccmVar.aa(this, z);
            }
        }
        this.t = false;
    }

    public boolean ac(cbz cbzVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        boolean zAe = false;
        if (!copyOnWriteArrayList.isEmpty() && this.w == cbzVar) {
            av();
            for (WeakReference weakReference : copyOnWriteArrayList) {
                ccm ccmVar = (ccm) weakReference.get();
                if (ccmVar != null) {
                    zAe = ccmVar.ae(cbzVar);
                    if (zAe) {
                        break;
                    }
                } else {
                    copyOnWriteArrayList.remove(weakReference);
                }
            }
            au();
            if (zAe) {
                this.w = null;
            }
        }
        return zAe;
    }

    public boolean ad(cbw cbwVar, MenuItem menuItem) {
        cbu cbuVar = this.f;
        return cbuVar != null && cbuVar.bx(cbwVar, menuItem);
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return z(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            cbz cbzVarZ = z(i, i2, i3, resolveInfo.loadLabel(packageManager));
            cbzVarZ.setIcon(resolveInfo.loadIcon(packageManager));
            cbzVarZ.g = intent2;
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = cbzVarZ;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public boolean ae(cbz cbzVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        boolean zAb = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        av();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar = (ccm) weakReference.get();
            if (ccmVar != null) {
                zAb = ccmVar.ab(cbzVar);
                if (zAb) {
                    break;
                }
            } else {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        au();
        if (zAb) {
            this.w = cbzVar;
        }
        return zAb;
    }

    public final cbz af(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.u;
        arrayList.clear();
        ag(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (cbz) arrayList.get(0);
        }
        boolean zAm = am();
        for (int i2 = 0; i2 < size; i2++) {
            cbz cbzVar = (cbz) arrayList.get(i2);
            char c = zAm ? cbzVar.j : cbzVar.h;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (zAm && c == '\b' && i == 67))) {
                return cbzVar;
            }
        }
        return null;
    }

    public final void ag(List list, int i, KeyEvent keyEvent) {
        boolean zAm = am();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList = this.g;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                cbz cbzVar = (cbz) arrayList.get(i2);
                if (cbzVar.hasSubMenu()) {
                    cbzVar.o.ag(list, i, keyEvent);
                }
                char c = zAm ? cbzVar.j : cbzVar.h;
                if ((modifiers & 69647) == ((zAm ? cbzVar.k : cbzVar.i) & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (zAm && c == '\b' && i == 67)) && cbzVar.isEnabled()) {
                        list.add(cbzVar);
                    }
                }
            }
        }
    }

    public final void ah() {
        ArrayList arrayListAk = ak();
        if (this.l) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
            boolean zAd = false;
            for (WeakReference weakReference : copyOnWriteArrayList) {
                ccm ccmVar = (ccm) weakReference.get();
                if (ccmVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zAd |= ccmVar.ad();
                }
            }
            ArrayList arrayList = this.j;
            ArrayList arrayList2 = this.k;
            if (zAd) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListAk.size();
                for (int i = 0; i < size; i++) {
                    cbz cbzVar = (cbz) arrayListAk.get(i);
                    if ((cbzVar.z & 32) == 32) {
                        arrayList.add(cbzVar);
                    } else {
                        arrayList2.add(cbzVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(ak());
            }
            this.l = false;
        }
    }

    public String ai() {
        return "android:menu:actionviewstates";
    }

    public cbw aj() {
        return this;
    }

    public final ArrayList ak() {
        boolean z = this.i;
        ArrayList arrayList = this.h;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.g;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            cbz cbzVar = (cbz) arrayList2.get(i);
            if (cbzVar.isVisible()) {
                arrayList.add(cbzVar);
            }
        }
        this.i = false;
        this.l = true;
        return arrayList;
    }

    public boolean al() {
        return this.x;
    }

    public boolean am() {
        return this.d;
    }

    public boolean an() {
        return this.e;
    }

    public final void ao(boolean z) {
        if (this.q) {
            this.r = true;
            if (z) {
                this.s = true;
                return;
            }
            return;
        }
        if (z) {
            this.i = true;
            this.l = true;
        }
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        av();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar = (ccm) weakReference.get();
            if (ccmVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                ccmVar.ac(z);
            }
        }
        au();
    }

    /* JADX WARN: Found duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Found duplicated region for block: B:32:0x0051  */
    /* JADX WARN: Found duplicated region for block: B:35:0x0058  */
    /* JADX WARN: Found duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Found duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Found duplicated region for block: B:45:0x0075  */
    /* JADX WARN: Found duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Found duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Found duplicated region for block: B:53:0x0094  */
    /* JADX WARN: Found duplicated region for block: B:57:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Found duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Found duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Found duplicated region for block: B:69:0x00ce  */
    /* JADX WARN: Found duplicated region for block: B:75:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:76:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:77:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:79:0x00ac A[SYNTHETIC] */
    public final boolean ap(MenuItem menuItem, ccm ccmVar, int i) {
        boolean zExpandActionView;
        cca ccaVar;
        boolean z;
        dnw dnwVar;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList;
        ccm ccmVar2;
        cbz cbzVar = (cbz) menuItem;
        if (cbzVar == null || !cbzVar.isEnabled()) {
            return false;
        }
        cbw cbwVar = cbzVar.n;
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = cbzVar.p;
        if ((onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(cbzVar)) && !cbwVar.ad(cbwVar, cbzVar)) {
            Intent intent = cbzVar.g;
            if (intent != null) {
                try {
                    cbwVar.b.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                    cca ccaVar2 = cbzVar.ac;
                    if (ccaVar2 == null) {
                    }
                    ccaVar = cbzVar.ac;
                    z = ccaVar == null ? false : false;
                    if (cbzVar.ah()) {
                        zExpandActionView |= cbzVar.expandActionView();
                        if (zExpandActionView) {
                            ab(true);
                        }
                    } else if (cbzVar.hasSubMenu()) {
                        if ((i & 4) == 0) {
                            ab(false);
                        }
                        if (!cbzVar.hasSubMenu()) {
                            dnw dnwVar2 = new dnw(this.b, this, cbzVar);
                            cbzVar.o = dnwVar2;
                            dnwVar2.setHeaderTitle(cbzVar.e);
                        }
                        dnwVar = cbzVar.o;
                        if (z) {
                            ccaVar.b.onPrepareSubMenu(dnwVar);
                        }
                        copyOnWriteArrayList = this.v;
                        if (!copyOnWriteArrayList.isEmpty()) {
                            if (ccmVar != null) {
                            }
                            for (WeakReference weakReference : copyOnWriteArrayList) {
                                ccmVar2 = (ccm) weakReference.get();
                                if (ccmVar2 == null) {
                                    copyOnWriteArrayList.remove(weakReference);
                                } else if (!zAj) {
                                    zAj = ccmVar2.aj(dnwVar);
                                }
                            }
                        }
                        zExpandActionView |= zAj;
                        if (!zExpandActionView) {
                            ab(true);
                        }
                    } else {
                        if ((i & 4) == 0) {
                            ab(false);
                        }
                        if (!cbzVar.hasSubMenu()) {
                            dnw dnwVar22 = new dnw(this.b, this, cbzVar);
                            cbzVar.o = dnwVar22;
                            dnwVar22.setHeaderTitle(cbzVar.e);
                        }
                        dnwVar = cbzVar.o;
                        if (z) {
                            ccaVar.b.onPrepareSubMenu(dnwVar);
                        }
                        copyOnWriteArrayList = this.v;
                        if (!copyOnWriteArrayList.isEmpty()) {
                            zAj = ccmVar != null ? ccmVar.aj(dnwVar) : false;
                            while (r8.hasNext()) {
                                ccmVar2 = (ccm) weakReference.get();
                                if (ccmVar2 == null) {
                                    copyOnWriteArrayList.remove(weakReference);
                                } else if (!zAj) {
                                    zAj = ccmVar2.aj(dnwVar);
                                }
                            }
                        }
                        zExpandActionView |= zAj;
                        if (!zExpandActionView) {
                            ab(true);
                        }
                    }
                    return zExpandActionView;
                }
            } else {
                cca ccaVar22 = cbzVar.ac;
                zExpandActionView = ccaVar22 == null && ccaVar22.b.onPerformDefaultAction();
            }
        }
        ccaVar = cbzVar.ac;
        if (ccaVar == null && ccaVar.b.hasSubMenu()) {
            z = true;
        }
        if (cbzVar.ah()) {
            zExpandActionView |= cbzVar.expandActionView();
            if (zExpandActionView) {
                ab(true);
            }
        } else if (cbzVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                ab(false);
            }
            if (!cbzVar.hasSubMenu()) {
                dnw dnwVar222 = new dnw(this.b, this, cbzVar);
                cbzVar.o = dnwVar222;
                dnwVar222.setHeaderTitle(cbzVar.e);
            }
            dnwVar = cbzVar.o;
            if (z) {
                ccaVar.b.onPrepareSubMenu(dnwVar);
            }
            copyOnWriteArrayList = this.v;
            if (!copyOnWriteArrayList.isEmpty()) {
                if (ccmVar != null) {
                }
                while (r8.hasNext()) {
                    ccmVar2 = (ccm) weakReference.get();
                    if (ccmVar2 == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else if (!zAj) {
                        zAj = ccmVar2.aj(dnwVar);
                    }
                }
            }
            zExpandActionView |= zAj;
            if (!zExpandActionView) {
                ab(true);
            }
        } else if ((i & 1) == 0) {
            ab(true);
        }
        return zExpandActionView;
    }

    public final void aq(ccm ccmVar) {
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.v;
        for (WeakReference weakReference : copyOnWriteArrayList) {
            ccm ccmVar2 = (ccm) weakReference.get();
            if (ccmVar2 == null || ccmVar2 == ccmVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void ar(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ai());
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((dnw) item.getSubMenu()).ar(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    public final void as(Bundle bundle) {
        int size = this.g.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((dnw) item.getSubMenu()).as(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(ai(), sparseArray);
        }
    }

    public final void at(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = this.c.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = this.b.getDrawable(i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        ao(false);
    }

    public final void au() {
        this.q = false;
        if (this.r) {
            this.r = false;
            ao(this.s);
        }
    }

    public final void av() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        cbz cbzVar = this.w;
        if (cbzVar != null) {
            ac(cbzVar);
        }
        this.g.clear();
        ao(true);
    }

    public final void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        ao(false);
    }

    @Override // android.view.Menu
    public final void close() {
        ab(true);
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            cbz cbzVar = (cbz) arrayList.get(i2);
            if (cbzVar.a == i) {
                return cbzVar;
            }
            if (cbzVar.hasSubMenu() && (menuItemFindItem = cbzVar.o.findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.g.get(i);
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((cbz) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return af(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return ap(findItem(i), null, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        cbz cbzVarAf = af(i, keyEvent);
        boolean zAp = cbzVarAf != null ? ap(cbzVarAf, null, i2) : false;
        if ((i2 & 2) != 0) {
            ab(true);
        }
        return zAp;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((cbz) arrayList.get(i3)).b == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((cbz) arrayList.get(i3)).b != i) {
                    break;
                }
                if (i3 >= 0 && i3 < arrayList.size()) {
                    arrayList.remove(i3);
                }
                i2 = i4;
            }
            ao(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((cbz) arrayList.get(i2)).a == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0 || i2 >= arrayList.size()) {
            return;
        }
        arrayList.remove(i2);
        ao(true);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            cbz cbzVar = (cbz) arrayList.get(i2);
            if (cbzVar.b == i) {
                cbzVar.ai(z2);
                cbzVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.x = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            cbz cbzVar = (cbz) arrayList.get(i2);
            if (cbzVar.b == i) {
                cbzVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            cbz cbzVar = (cbz) arrayList.get(i2);
            if (cbzVar.b == i) {
                int i3 = cbzVar.z;
                int i4 = (i3 & (-9)) | (z ? 0 : 8);
                cbzVar.z = i4;
                if (i3 != i4) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            ao(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d = z;
        ao(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.g.size();
    }

    public cbz z(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 < 0 || i5 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i6 = (a[i5] << 16) | (65535 & i3);
        cbz cbzVar = new cbz(this, i, i2, i3, i6, charSequence, this.m);
        ArrayList arrayList = this.g;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((cbz) arrayList.get(size)).d <= i6) {
                i4 = size + 1;
                arrayList.add(i4, cbzVar);
                ao(true);
                return cbzVar;
            }
        }
        i4 = 0;
        arrayList.add(i4, cbzVar);
        ao(true);
        return cbzVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return z(0, 0, 0, this.c.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.c.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return z(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        cbz cbzVarZ = z(i, i2, i3, charSequence);
        dnw dnwVar = new dnw(this.b, this, cbzVarZ);
        cbzVarZ.o = dnwVar;
        dnwVar.setHeaderTitle(cbzVarZ.e);
        return dnwVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return z(i, i2, i3, this.c.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.c.getString(i4));
    }
}
