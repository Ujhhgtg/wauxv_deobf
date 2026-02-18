package me.hd.wauxv.obf;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.util.ArrayList;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class oy implements dpw {
    public final ImageView a;
    public final esk b;
    public tj c;
    public boolean d;
    public boolean e;
    public Animatable f;
    public final /* synthetic */ int g;

    public oy(ImageView imageView, int i) {
        this.g = i;
        this.a = imageView;
        this.b = new esk(imageView);
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void h(dbs dbsVar) {
        this.a.setTag(R.id.glide_custom_view_target_tag, dbsVar);
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void i(Object obj) {
        s(obj);
        if (!(obj instanceof Animatable)) {
            this.f = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.f = animatable;
        animatable.start();
    }

    @Override // me.hd.wauxv.obf.bun
    public final void j() {
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void k(dht dhtVar) {
        this.b.c.remove(dhtVar);
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void l(Drawable drawable) {
        s(null);
        this.f = null;
        this.a.setImageDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.bun
    public final void m() {
        Animatable animatable = this.f;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void n(Drawable drawable) {
        tj tjVar = this.c;
        ImageView imageView = this.a;
        if (tjVar != null && !this.e) {
            imageView.addOnAttachStateChangeListener(tjVar);
            this.e = true;
        }
        s(null);
        this.f = null;
        imageView.setImageDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.dpw
    public final dbs o() {
        Object tag = this.a.getTag(R.id.glide_custom_view_target_tag);
        if (tag == null) {
            return null;
        }
        if (tag instanceof dbs) {
            return (dbs) tag;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void p(Drawable drawable) {
        tj tjVar;
        esk eskVar = this.b;
        ViewTreeObserver viewTreeObserver = eskVar.b.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(eskVar.d);
        }
        eskVar.d = null;
        eskVar.c.clear();
        boolean z = this.d;
        ImageView imageView = this.a;
        if (!z && (tjVar = this.c) != null && this.e) {
            imageView.removeOnAttachStateChangeListener(tjVar);
            this.e = false;
        }
        Animatable animatable = this.f;
        if (animatable != null) {
            animatable.stop();
        }
        s(null);
        this.f = null;
        imageView.setImageDrawable(drawable);
    }

    @Override // me.hd.wauxv.obf.bun
    public final void q() {
        Animatable animatable = this.f;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // me.hd.wauxv.obf.dpw
    public final void r(dht dhtVar) throws Throwable {
        esk eskVar = this.b;
        ArrayList arrayList = eskVar.c;
        ImageView imageView = eskVar.b;
        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int iE = eskVar.e(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        int iE2 = eskVar.e(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
        if ((iE > 0 || iE == Integer.MIN_VALUE) && (iE2 > 0 || iE2 == Integer.MIN_VALUE)) {
            dhtVar.ao(iE, iE2);
            return;
        }
        if (!arrayList.contains(dhtVar)) {
            arrayList.add(dhtVar);
        }
        if (eskVar.d == null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            agv agvVar = new agv(eskVar);
            eskVar.d = agvVar;
            viewTreeObserver.addOnPreDrawListener(agvVar);
        }
    }

    public final void s(Object obj) {
        switch (this.g) {
            case 0:
                this.a.setImageBitmap((Bitmap) obj);
                break;
            default:
                this.a.setImageDrawable((Drawable) obj);
                break;
        }
    }

    public final String toString() {
        return "Target for: " + this.a;
    }
}
