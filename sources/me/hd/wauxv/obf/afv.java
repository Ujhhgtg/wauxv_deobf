package me.hd.wauxv.obf;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class afv extends ContextWrapper {
    public static Configuration a;
    public int b;
    public Resources.Theme c;
    public LayoutInflater d;
    public Configuration e;
    public Resources f;

    public afv(Context context, int i) {
        super(context);
        this.b = i;
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void g(Configuration configuration) {
        if (this.f != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.e != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.e = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Found duplicated region for block: B:13:0x002c  */
    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        if (this.f == null) {
            Configuration configuration = this.e;
            if (configuration == null) {
                this.f = super.getResources();
            } else {
                if (a == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    a = configuration2;
                }
                if (configuration.equals(a)) {
                    this.f = super.getResources();
                } else {
                    this.f = createConfigurationContext(this.e).getResources();
                }
            }
        }
        return this.f;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.d == null) {
            this.d = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.c;
        if (theme != null) {
            return theme;
        }
        if (this.b == 0) {
            this.b = R.style.Theme_AppCompat_Light;
        }
        h();
        return this.c;
    }

    public final void h() {
        if (this.c == null) {
            this.c = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.c.setTo(theme);
            }
        }
        this.c.applyStyle(this.b, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (this.b != i) {
            this.b = i;
            h();
        }
    }
}
