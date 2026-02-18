package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class ij extends ImageButton {
    public final ea e;
    public final ik f;
    public boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ekd.b(context);
        this.g = false;
        drm.h(this, getContext());
        ea eaVar = new ea(this);
        this.e = eaVar;
        eaVar.t(attributeSet, i);
        ik ikVar = new ik(this);
        this.f = ikVar;
        ikVar.v(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.h();
        }
        ik ikVar = this.f;
        if (ikVar != null) {
            ikVar.j();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        ea eaVar = this.e;
        if (eaVar != null) {
            return eaVar.q();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ea eaVar = this.e;
        if (eaVar != null) {
            return eaVar.r();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        eke ekeVar;
        ik ikVar = this.f;
        if (ikVar == null || (ekeVar = (eke) ikVar.d) == null) {
            return null;
        }
        return ekeVar.a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        eke ekeVar;
        ik ikVar = this.f;
        if (ikVar == null || (ekeVar = (eke) ikVar.d) == null) {
            return null;
        }
        return ekeVar.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.f.c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.v();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.w(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        ik ikVar = this.f;
        if (ikVar != null) {
            ikVar.j();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        ik ikVar = this.f;
        if (ikVar != null && drawable != null && !this.g) {
            ikVar.b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (ikVar != null) {
            ikVar.j();
            if (this.g) {
                return;
            }
            ImageView imageView = (ImageView) ikVar.c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(ikVar.b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.g = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        ik ikVar = this.f;
        ImageView imageView = (ImageView) ikVar.c;
        if (i != 0) {
            Drawable drawableY = cmz.y(imageView.getContext(), i);
            if (drawableY != null) {
                apy.d(drawableY);
            }
            imageView.setImageDrawable(drawableY);
        } else {
            imageView.setImageDrawable(null);
        }
        ikVar.j();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        ik ikVar = this.f;
        if (ikVar != null) {
            ikVar.j();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.ab(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        ea eaVar = this.e;
        if (eaVar != null) {
            eaVar.ac(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        ik ikVar = this.f;
        if (ikVar != null) {
            if (((eke) ikVar.d) == null) {
                ikVar.d = new eke();
            }
            eke ekeVar = (eke) ikVar.d;
            ekeVar.a = colorStateList;
            ekeVar.d = true;
            ikVar.j();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        ik ikVar = this.f;
        if (ikVar != null) {
            if (((eke) ikVar.d) == null) {
                ikVar.d = new eke();
            }
            eke ekeVar = (eke) ikVar.d;
            ekeVar.b = mode;
            ekeVar.c = true;
            ikVar.j();
        }
    }
}
