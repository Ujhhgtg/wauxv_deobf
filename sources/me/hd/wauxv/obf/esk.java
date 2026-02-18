package me.hd.wauxv.obf;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class esk {
    public static Integer a;
    public final ImageView b;
    public final ArrayList c = new ArrayList();
    public agv d;

    public esk(ImageView imageView) {
        this.b = imageView;
    }

    public final int e(int i, int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > 0) {
            return i4;
        }
        int i5 = i - i3;
        if (i5 > 0) {
            return i5;
        }
        ImageView imageView = this.b;
        if (imageView.isLayoutRequested() || i2 != -2) {
            return 0;
        }
        if (Log.isLoggable("ViewTarget", 4)) {
            Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
        }
        Context context = imageView.getContext();
        if (a == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            cmz.n(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            a = Integer.valueOf(Math.max(point.x, point.y));
        }
        return a.intValue();
    }
}
