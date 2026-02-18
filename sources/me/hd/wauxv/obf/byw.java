package me.hd.wauxv.obf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowId;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.android.dx.io.Opcodes;
import io.github.rosemoe.sora.widget.CodeEditor;
import me.hd.wauxv.R;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class byw {
    public final CodeEditor a;
    public final PopupWindow b;
    public final ImageView c;
    public final Paint d;
    public final float e;
    public int f;
    public int g;
    public final CodeEditor h;
    public final float i;

    public byw(CodeEditor codeEditor) {
        this.a = codeEditor;
        awy awyVar = new awy(codeEditor.i);
        this.h = codeEditor;
        PopupWindow popupWindow = new PopupWindow();
        this.b = popupWindow;
        popupWindow.setElevation(codeEditor.getDpUnit() * 4.0f);
        View viewInflate = LayoutInflater.from(codeEditor.getContext()).inflate(R.layout.magnifier_popup, (ViewGroup) null);
        this.c = (ImageView) viewInflate.findViewById(R.id.magnifier_image_view);
        popupWindow.setHeight((int) (codeEditor.getDpUnit() * 70.0f));
        popupWindow.setWidth((int) (codeEditor.getDpUnit() * 100.0f));
        popupWindow.setContentView(viewInflate);
        this.e = TypedValue.applyDimension(2, 28.0f, viewInflate.getResources().getDisplayMetrics());
        this.i = 1.25f;
        this.d = new Paint();
        Drawable background = popupWindow.getContentView().getBackground();
        if (background != null) {
            background.setTint(codeEditor.getColorScheme().b.get(4));
        }
        awyVar.k(abg.class, new qp(this, 9));
    }

    public final void j() {
        this.b.dismiss();
    }

    public final void k(int i, int i2) {
        if (Math.abs(i - this.f) >= 2 || Math.abs(i2 - this.g) >= 2) {
            CodeEditor codeEditor = this.a;
            float textSizePx = codeEditor.getTextSizePx();
            float f = this.e;
            PopupWindow popupWindow = this.b;
            if (textSizePx > f) {
                if (popupWindow.isShowing()) {
                    j();
                    return;
                }
                return;
            }
            popupWindow.setWidth(Math.min((codeEditor.getWidth() * 3) / 5, (int) codeEditor.getDpUnit()) * Opcodes.INVOKE_POLYMORPHIC);
            this.f = i;
            this.g = i2;
            int[] iArr = new int[2];
            codeEditor.getLocationInWindow(iArr);
            int iMax = Math.max((iArr[0] + i) - (popupWindow.getWidth() / 2), 0);
            if (popupWindow.getWidth() + iMax > codeEditor.getWidth() + iArr[0]) {
                iMax = Math.max(0, (codeEditor.getWidth() + iArr[0]) - popupWindow.getWidth());
            }
            int iMax2 = Math.max(((iArr[1] + i2) - popupWindow.getHeight()) - codeEditor.getRowHeight(), 0);
            if (popupWindow.isShowing()) {
                popupWindow.update(iMax, iMax2, popupWindow.getWidth(), popupWindow.getHeight());
            } else {
                popupWindow.showAtLocation(this.h, 8388659, iMax, iMax2);
            }
            l();
        }
    }

    public final void l() {
        int i;
        PopupWindow popupWindow = this.b;
        if (popupWindow.isShowing()) {
            CodeEditor codeEditor = this.a;
            Context context = codeEditor.getContext();
            boolean z = context instanceof Activity;
            float f = this.i;
            if (z) {
                WindowId windowId = codeEditor.getWindowId();
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    WindowId windowId2 = window.getDecorView().getWindowId();
                    if (windowId != null && windowId.equals(windowId2)) {
                        Activity activity = (Activity) codeEditor.getContext();
                        int width = (int) (popupWindow.getWidth() / f);
                        int height = (int) (popupWindow.getHeight() / f);
                        int iMax = Math.max(this.f - (width / 2), 0);
                        int iMax2 = Math.max(this.g - (height / 2), 0);
                        int iMin = Math.min(iMax + width, codeEditor.getWidth());
                        int iMin2 = Math.min(iMax2 + height, codeEditor.getHeight());
                        if (iMin - iMax < width) {
                            iMax = Math.max(0, iMin - width);
                        }
                        if (iMin2 - iMax2 < height) {
                            iMax2 = Math.max(0, iMin2 - height);
                        }
                        int i2 = iMin - iMax;
                        if (i2 <= 0 || (i = iMin2 - iMax2) <= 0) {
                            j();
                            return;
                        }
                        int[] iArr = new int[2];
                        codeEditor.getLocationInWindow(iArr);
                        final Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                        try {
                            Window window2 = activity.getWindow();
                            int i3 = iArr[0];
                            int i4 = iArr[1];
                            PixelCopy.request(window2, new Rect(iMax + i3, iMax2 + i4, i3 + iMin, i4 + iMin2), bitmapCreateBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: me.hd.wauxv.obf.byv
                                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                                public final void onPixelCopyFinished(int i5) {
                                    byw bywVar = this.a;
                                    CodeEditor codeEditor2 = bywVar.a;
                                    Paint paint = bywVar.d;
                                    PopupWindow popupWindow2 = bywVar.b;
                                    if (i5 != 0) {
                                        Log.w("Magnifier", "Failed to copy pixels, error = " + i5);
                                        return;
                                    }
                                    Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(popupWindow2.getWidth(), popupWindow2.getHeight(), Bitmap.Config.ARGB_8888);
                                    int width2 = popupWindow2.getWidth();
                                    int height2 = popupWindow2.getHeight();
                                    Bitmap bitmap = bitmapCreateBitmap;
                                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, width2, height2, true);
                                    bitmap.recycle();
                                    Canvas canvas = new Canvas(bitmapCreateBitmap2);
                                    paint.reset();
                                    paint.setAntiAlias(true);
                                    canvas.drawARGB(0, 0, 0, 0);
                                    canvas.drawRoundRect(0.0f, 0.0f, popupWindow2.getWidth(), popupWindow2.getHeight(), codeEditor2.getDpUnit() * 6.0f, codeEditor2.getDpUnit() * 6.0f, paint);
                                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                                    canvas.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
                                    bitmapCreateScaledBitmap.recycle();
                                    bywVar.c.setImageBitmap(bitmapCreateBitmap2);
                                }
                            }, codeEditor.getHandler());
                            return;
                        } catch (IllegalArgumentException unused) {
                            j();
                            if (bitmapCreateBitmap.isRecycled()) {
                                return;
                            }
                            bitmapCreateBitmap.recycle();
                            return;
                        }
                    }
                }
            }
            if (popupWindow.getWidth() <= 0 || popupWindow.getHeight() <= 0) {
                j();
                return;
            }
            int width2 = popupWindow.getWidth();
            int height2 = popupWindow.getHeight();
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width2, height2, config);
            int width3 = (int) (popupWindow.getWidth() / f);
            int height3 = (int) (popupWindow.getHeight() / f);
            int iMax3 = Math.max(this.f - (width3 / 2), 0);
            int iMax4 = Math.max(this.g - (height3 / 2), 0);
            int iMin3 = Math.min(iMax3 + width3, codeEditor.getWidth());
            int iMin4 = Math.min(iMax4 + height3, codeEditor.getHeight());
            if (iMin3 - iMax3 < width3) {
                iMax3 = Math.max(0, iMin3 - width3);
            }
            if (iMin4 - iMax4 < height3) {
                iMax4 = Math.max(0, iMin4 - height3);
            }
            if (iMin3 - iMax3 <= 0 || iMin4 - iMax4 <= 0) {
                j();
                bitmapCreateBitmap2.recycle();
                return;
            }
            Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(width3, height3, config);
            Canvas canvas = new Canvas(bitmapCreateBitmap3);
            canvas.translate((-iMax3) - codeEditor.getOffsetX(), (-iMax4) - codeEditor.getOffsetY());
            codeEditor.draw(canvas);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap3, popupWindow.getWidth(), popupWindow.getHeight(), true);
            bitmapCreateBitmap3.recycle();
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            Paint paint = this.d;
            paint.reset();
            paint.setAntiAlias(true);
            canvas2.drawARGB(0, 0, 0, 0);
            canvas2.drawRoundRect(0.0f, 0.0f, popupWindow.getWidth(), popupWindow.getHeight(), codeEditor.getDpUnit() * 6.0f, codeEditor.getDpUnit() * 6.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas2.drawBitmap(bitmapCreateScaledBitmap, 0.0f, 0.0f, paint);
            bitmapCreateScaledBitmap.recycle();
            this.c.setImageBitmap(bitmapCreateBitmap2);
        }
    }
}
