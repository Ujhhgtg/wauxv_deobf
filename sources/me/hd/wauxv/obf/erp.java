package me.hd.wauxv.obf;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class erp implements ccl, cbu, cqk, jm, cby, afj, afl, cdw, ako, axv {
    public static final dop s = new dop(22);
    public final /* synthetic */ int t;
    public Object v;

    public /* synthetic */ erp(int i, boolean z) {
        this.t = i;
    }

    public static void w(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw yg.d(it);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // me.hd.wauxv.obf.cqk
    public evr _ae(View view, evr evrVar) {
        evr evrVar2;
        int i = 0;
        switch (this.t) {
            case 4:
                AppBarLayout appBarLayout = (AppBarLayout) this.v;
                WeakHashMap weakHashMap = ViewCompat.a;
                evrVar2 = appBarLayout.getFitsSystemWindows() ? evrVar : null;
                if (!Objects.equals(appBarLayout.h, evrVar2)) {
                    appBarLayout.h = evrVar2;
                    if (appBarLayout.w != null && appBarLayout.getTopInset() > 0) {
                        i = 1;
                    }
                    appBarLayout.setWillNotDraw(i ^ 1);
                    appBarLayout.requestLayout();
                }
                return evrVar;
            case 8:
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) this.v;
                WeakHashMap weakHashMap2 = ViewCompat.a;
                evrVar2 = collapsingToolbarLayout.getFitsSystemWindows() ? evrVar : null;
                if (!Objects.equals(collapsingToolbarLayout.aa, evrVar2)) {
                    collapsingToolbarLayout.aa = evrVar2;
                    collapsingToolbarLayout.requestLayout();
                }
                return evrVar.b.aa();
            default:
                evo evoVar = evrVar.b;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.v;
                if (!Objects.equals(coordinatorLayout.s, evrVar)) {
                    coordinatorLayout.s = evrVar;
                    boolean z = evrVar.h() > 0;
                    coordinatorLayout.t = z;
                    coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
                    if (!evoVar.ac()) {
                        int childCount = coordinatorLayout.getChildCount();
                        while (i < childCount) {
                            View childAt = coordinatorLayout.getChildAt(i);
                            WeakHashMap weakHashMap3 = ViewCompat.a;
                            if (!childAt.getFitsSystemWindows() || ((agu) childAt.getLayoutParams()).a == null
                                    || !evoVar.ac()) {
                                i++;
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return evrVar;
        }
    }

    @Override // me.hd.wauxv.obf.afl
    public int _af() {
        return ((ContentInfo) this.v).getFlags();
    }

    @Override // me.hd.wauxv.obf.afl
    public ContentInfo _ag() {
        return (ContentInfo) this.v;
    }

    @Override // me.hd.wauxv.obf.jm
    public void a(int i) {
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
     * "finallyBlockTerminus" is null
     * at
     * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
     * (TraverserActivePathState.java:253)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:422)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    public void aa(int i, ArrayList arrayList) {
        DefaultConfig ioVar = (DefaultConfig) this.v;
        ArrayList arrayList2 = (ArrayList) ioVar.d;
        ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
        reentrantLock.lock();
        while (arrayList2.size() <= i) {
            try {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(ajn.aa(0, 5L));
                arrayList2.add(new lg(arrayList3));
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        lg lgVar = (lg) arrayList2.get(i);
        lgVar.a.lock();
        try {
            lgVar.b = arrayList;
            lgVar.a.unlock();
            reentrantLock.unlock();
        } catch (Throwable th2) {
            lgVar.a.unlock();
            throw th2;
        }
    }

    @Override // me.hd.wauxv.obf.jm
    public void b(int i) {
    }

    @Override // me.hd.wauxv.obf.afj
    public afm build() {
        return new afm(new erp(((ContentInfo.Builder) this.v).build()));
    }

    @Override // me.hd.wauxv.obf.cbu
    public void bw(cbw cbwVar) {
        ekm ekmVar = ((ActionMenuView) this.v).h;
        if (ekmVar != null) {
            ekmVar.bw(cbwVar);
        }
    }

    @Override // me.hd.wauxv.obf.cbu
    public boolean bx(cbw cbwVar, MenuItem menuItem) {
        cz czVar = ((ActionMenuView) this.v).m;
        if (czVar == null) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) ((ekm) czVar).a.ag.h).iterator();
        while (it.hasNext()) {
            if (((bdy) it.next()).a.bl()) {
                return true;
            }
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.ccl
    public void c(cbw cbwVar, boolean z) {
        if (cbwVar instanceof dnw) {
            ((dnw) cbwVar).aw.aj().ab(false);
        }
        ccl cclVar = ((cw) this.v).e;
        if (cclVar != null) {
            cclVar.c(cbwVar, z);
        }
    }

    @Override // me.hd.wauxv.obf.axv
    public Object create() {
        switch (this.t) {
            case 21:
                ik ikVar = (ik) this.v;
                return new ajr((afr) ikVar.c, (FactoryPools) ikVar.d);
            default:
                awc awcVar = (awc) this.v;
                return new awh((bia) awcVar.a, (bia) awcVar.b, (bia) awcVar.c, (bia) awcVar.d, (awd) awcVar.e,
                        (awd) awcVar.f, (FactoryPools) awcVar.g);
        }
    }

    @Override // me.hd.wauxv.obf.ccl
    public boolean d(cbw cbwVar) {
        cw cwVar = (cw) this.v;
        if (cbwVar == cwVar.c) {
            return false;
        }
        cwVar.y = ((dnw) cbwVar).ax.a;
        ccl cclVar = cwVar.e;
        if (cclVar != null) {
            return cclVar.d(cbwVar);
        }
        return false;
    }

    @Override // me.hd.wauxv.obf.jm
    public void e(int i, float f) {
    }

    @Override // me.hd.wauxv.obf.ako
    public int f() {
        return (h() << 8) | h();
    }

    @Override // me.hd.wauxv.obf.afl
    public ClipData g() {
        return ((ContentInfo) this.v).getClip();
    }

    @Override // me.hd.wauxv.obf.ako
    public short h() throws IOException {
        int i = ((InputStream) this.v).read();
        if (i != -1) {
            return (short) i;
        }
        throw new akn();
    }

    @Override // me.hd.wauxv.obf.ako
    public int i(int i, byte[] bArr) throws akn {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i && (i3 = ((InputStream) this.v).read(bArr, i2, i - i2)) != -1) {
            i2 += i3;
        }
        if (i2 == 0 && i3 == -1) {
            throw new akn();
        }
        return i2;
    }

    @Override // me.hd.wauxv.obf.afj
    public void j(Uri uri) {
        ((ContentInfo.Builder) this.v).setLinkUri(uri);
    }

    @Override // me.hd.wauxv.obf.afj
    public void k(int i) {
        ((ContentInfo.Builder) this.v).setFlags(i);
    }

    @Override // me.hd.wauxv.obf.afl
    public int l() {
        return ((ContentInfo) this.v).getSource();
    }

    public bd n(int i) {
        return null;
    }

    public bd o(int i) {
        return null;
    }

    public boolean p(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // me.hd.wauxv.obf.cby
    public void q(cbw cbwVar, MenuItem menuItem) {
        ((tm) this.v).f.removeCallbacksAndMessages(cbwVar);
    }

    @Override // me.hd.wauxv.obf.cby
    public void r(cbw cbwVar, cbz cbzVar) {
        tm tmVar = (tm) this.v;
        Handler handler = tmVar.f;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = tmVar.h;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (cbwVar == ((tl) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        handler.postAtTime(new tk(this, i2 < arrayList.size() ? (tl) arrayList.get(i2) : null, cbzVar, cbwVar), cbwVar,
                SystemClock.uptimeMillis() + 200);
    }

    @Override // me.hd.wauxv.obf.afj
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.v).setExtras(bundle);
    }

    @Override // me.hd.wauxv.obf.ako
    public long skip(long j) throws IOException {
        InputStream inputStream = (InputStream) this.v;
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            long jSkip = inputStream.skip(j2);
            if (jSkip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                jSkip = 1;
            }
            j2 -= jSkip;
        }
        return j - j2;
    }

    public String toString() {
        switch (this.t) {
            case 10:
                return "ContentInfoCompat{" + ((ContentInfo) this.v) + "}";
            case 29:
                return "[class] placeholder_hook_class [throwable] " + ((Throwable) this.v) + " [instance] null";
            default:
                return super.toString();
        }
    }

    @Override // me.hd.wauxv.obf.cdw
    public cdv u(chm chmVar) {
        return new rv((nu) this.v, 1);
    }

    /*
     * JADX WARN: Undo finally extract visitor
     * java.lang.NullPointerException: Cannot invoke
     * "jadx.core.dex.nodes.BlockNode.getInstructions()" because
     * "finallyBlockTerminus" is null
     * at
     * jadx.core.dex.visitors.finaly.traverser.state.TraverserActivePathState.<init>
     * (TraverserActivePathState.java:253)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(
     * MarkFinallyVisitor.java:422)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(
     * MarkFinallyVisitor.java:302)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(
     * MarkFinallyVisitor.java:222)
     * at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.
     * java:150)
     */
    public void x(int i) {
        DefaultConfig ioVar = (DefaultConfig) this.v;
        ArrayList arrayList = (ArrayList) ioVar.d;
        ReentrantLock reentrantLock = (ReentrantLock) ioVar.c;
        reentrantLock.lock();
        try {
            lg lgVar = (lg) arrayList.get(i);
            lgVar.a.lock();
            try {
                arrayList.remove(i);
                lgVar.a.unlock();
                reentrantLock.unlock();
            } catch (Throwable th) {
                lgVar.a.unlock();
                throw th;
            }
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public int y(int i) {
        int[] iArr = ((DialogXBaseRelativeLayout) this.v).r;
        int iAe = StaticHelpers6.ae(i);
        if (iAe == 0) {
            return iArr[0];
        }
        if (iAe == 1) {
            return iArr[1];
        }
        if (iAe == 2) {
            return iArr[2];
        }
        if (iAe != 3) {
            return 0;
        }
        return iArr[3];
    }

    public void z() {
        ((bdm) this.v).g.ck();
    }

    public /* synthetic */ erp(Object obj, int i) {
        this.t = i;
        this.v = obj;
    }

    public erp(CodeEditor codeEditor) {
        this.t = 18;
        this.v = codeEditor;
        new awy(codeEditor.i).k(ahu.class, new qp(this, 3));
    }

    public erp(erq erqVar, ero eroVar, ahx ahxVar) {
        this.t = 0;
        throwIfVar1IsNull(erqVar, "store");
        throwIfVar1IsNull(ahxVar, "defaultCreationExtras");
        this.v = new chm(erqVar, eroVar, ahxVar);
    }

    public erp(TextView textView) {
        this.t = 20;
        this.v = new aur(textView);
    }

    public erp(EditText editText) {
        this.t = 19;
        this.v = new DefaultConfig(editText, 16);
    }

    public erp(int i) {
        this.t = i;
        switch (i) {
            case 12:
                this.v = new nu(15);
                break;
            case 13:
            default:
                this.v = new be(this);
                break;
            case 14:
                this.v = new ConcurrentHashMap(16);
                break;
        }
    }

    public erp(ContentInfo contentInfo) {
        this.t = 10;
        contentInfo.getClass();
        this.v = qc.p(contentInfo);
    }

    public erp(ClipData clipData, int i) {
        this.t = 9;
        this.v = qc.n(clipData, i);
    }
}
