package me.hd.wauxv.ui.fragment.module.page;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.appbar.MaterialToolbar;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import me.hd.wauxv.obf.aam;
import me.hd.wauxv.obf.aan;
import me.hd.wauxv.obf.aff;
import me.hd.wauxv.obf.asf;
import me.hd.wauxv.obf.avc;
import me.hd.wauxv.obf.bad;
import me.hd.wauxv.obf.bdo;
import me.hd.wauxv.obf.bdp;
import me.hd.wauxv.obf.brd;
import me.hd.wauxv.obf.btq;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.cnb;
import me.hd.wauxv.obf.ctf;
import me.hd.wauxv.obf.dnj;
import me.hd.wauxv.obf.dov;
import me.hd.wauxv.obf.eqj;
import me.hd.wauxv.obf.jx;
import me.hd.wauxv.ui.fragment.module.page.CodeFragment;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class CodeFragment extends bdo {
    public CodeFragment() {
        super(aan.a);
    }

    @Override // me.hd.wauxv.obf.bdo, me.hd.wauxv.obf.bdj
    public final void h() {
        eqj eqjVar = this.d;
        bzo.n(eqjVar);
        CodeEditor codeEditor = ((bdp) eqjVar).b;
        codeEditor.bx.s();
        codeEditor.bx.t();
        codeEditor.c.i();
        codeEditor.by.d.j();
        codeEditor.d.i();
        if (!codeEditor.ap) {
            codeEditor.i.g(new asf(codeEditor));
            codeEditor.ap = true;
            btq btqVar = codeEditor.bu;
            if (btqVar != null) {
                btqVar.e().k();
                codeEditor.bu.getClass();
                codeEditor.bu.destroy();
                codeEditor.bu = new avc();
            }
            codeEditor.cm = null;
            jx jxVar = codeEditor.f;
            jxVar.f = null;
            jxVar.h = null;
            aff affVar = codeEditor.bp;
            if (affVar != null) {
                affVar.b.remove(codeEditor);
            }
            Iterator it = codeEditor.br.c.iterator();
            while (it.hasNext()) {
                if (((WeakReference) it.next()).get() == codeEditor) {
                    it.remove();
                    break;
                }
            }
        }
        super.h();
    }

    @Override // me.hd.wauxv.obf.bdj
    public final void k(View view) {
        String strZ;
        String strZ2;
        String strSubstring;
        Bundle bundle = this.ax;
        if (bundle == null || (strZ = bundle.getString("pluginId" /* cnb.z(-420846665464618L) */)) == null) {
            strZ = "" /* cnb.z(-420258254945066L) */;
        }
        Bundle bundle2 = this.ax;
        if (bundle2 == null || (strZ2 = bundle2.getString("pluginPath" /* cnb.z(-420271139846954L) */)) == null) {
            strZ2 = "" /* cnb.z(-420241075075882L) */;
        }
        eqj eqjVar = this.d;
        bzo.n(eqjVar);
        MaterialToolbar materialToolbar = ((bdp) eqjVar).c;
        materialToolbar.setTitle(strZ);
        dov dovVar = ctf.a;
        String strC = ctf.c("Plugin" /* cnb.z(-47055661693738L) */);
        bzo.q(strC, "delimiter");
        int iAl = dnj.al(6, strZ2, strC);
        if (iAl == -1) {
            strSubstring = strZ2;
        } else {
            strSubstring = strZ2.substring(strC.length() + iAl, strZ2.length());
            bzo.p(strSubstring, "substring(...)");
        }
        materialToolbar.setSubtitle(strSubstring);
        MenuItem menuItemAdd = materialToolbar.getMenu().add("撤销" /* cnb.z(-420253959977770L) */);
        menuItemAdd.setShowAsAction(2);
        final int i = 0;
        menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: me.hd.wauxv.obf.aal
            public final /* synthetic */ CodeFragment b;

            {
                this.b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                switch (i) {
                    case 0:
                        eqj eqjVar2 = this.b.d;
                        bzo.n(eqjVar2);
                        ((bdp) eqjVar2).b.eu();
                        break;
                    default:
                        eqj eqjVar3 = this.b.d;
                        bzo.n(eqjVar3);
                        ((bdp) eqjVar3).b.ej();
                        break;
                }
                return true;
            }
        });
        MenuItem menuItemAdd2 = materialToolbar.getMenu().add("重做" /* cnb.z(-420189535468330L) */);
        menuItemAdd2.setShowAsAction(2);
        final int i2 = 1;
        menuItemAdd2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(this) { // from class: me.hd.wauxv.obf.aal
            public final /* synthetic */ CodeFragment b;

            {
                this.b = this;
            }

            @Override // android.view.MenuItem.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                switch (i2) {
                    case 0:
                        eqj eqjVar2 = this.b.d;
                        bzo.n(eqjVar2);
                        ((bdp) eqjVar2).b.eu();
                        break;
                    default:
                        eqj eqjVar3 = this.b.d;
                        bzo.n(eqjVar3);
                        ((bdp) eqjVar3).b.ej();
                        break;
                }
                return true;
            }
        });
        MenuItem menuItemAdd3 = materialToolbar.getMenu().add("保存" /* cnb.z(-420211010304810L) */);
        menuItemAdd3.setShowAsAction(2);
        menuItemAdd3.setOnMenuItemClickListener(new aam(strZ2, 0, this));
        eqj eqjVar2 = this.d;
        bzo.n(eqjVar2);
        CodeEditor codeEditor = ((bdp) eqjVar2).b;
        codeEditor.setTypefaceText(Typeface.createFromAsset(codeEditor.getContext().getAssets(), "font/mono.ttf" /* cnb.z(-420215305272106L) */));
        codeEditor.setEditorLanguage(new brd());
        codeEditor.setText(bad.c(new File(strZ2)));
    }
}
