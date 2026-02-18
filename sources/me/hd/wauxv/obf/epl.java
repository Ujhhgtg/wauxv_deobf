package me.hd.wauxv.obf;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class epl extends epc {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;
    public epj b;
    public PorterDuffColorFilter c;
    public ColorFilter d;
    public boolean e;
    public boolean g;
    public final float[] h;
    public final Matrix i;
    public final Rect j;

    public epl() {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        epj epjVar = new epj();
        epjVar.c = null;
        epjVar.d = a;
        epjVar.b = new epi();
        this.b = epjVar;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.j;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.d;
        if (colorFilter == null) {
            colorFilter = this.c;
        }
        Matrix matrix = this.i;
        canvas.getMatrix(matrix);
        float[] fArr = this.h;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        epj epjVar = this.b;
        Bitmap bitmap = epjVar.f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != epjVar.f.getHeight()) {
            epjVar.f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            epjVar.k = true;
        }
        if (this.g) {
            epj epjVar2 = this.b;
            if (epjVar2.k || epjVar2.g != epjVar2.c || epjVar2.h != epjVar2.d || epjVar2.j != epjVar2.e || epjVar2.i != epjVar2.b.getRootAlpha()) {
                epj epjVar3 = this.b;
                epjVar3.f.eraseColor(0);
                Canvas canvas2 = new Canvas(epjVar3.f);
                epi epiVar = epjVar3.b;
                epiVar.q(epiVar.h, epi.a, canvas2, iMin, iMin2);
                epj epjVar4 = this.b;
                epjVar4.g = epjVar4.c;
                epjVar4.h = epjVar4.d;
                epjVar4.i = epjVar4.b.getRootAlpha();
                epjVar4.j = epjVar4.e;
                epjVar4.k = false;
            }
        } else {
            epj epjVar5 = this.b;
            epjVar5.f.eraseColor(0);
            Canvas canvas3 = new Canvas(epjVar5.f);
            epi epiVar2 = epjVar5.b;
            epiVar2.q(epiVar2.h, epi.a, canvas3, iMin, iMin2);
        }
        epj epjVar6 = this.b;
        if (epjVar6.b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (epjVar6.l == null) {
                Paint paint2 = new Paint();
                epjVar6.l = paint2;
                paint2.setFilterBitmap(true);
            }
            epjVar6.l.setAlpha(epjVar6.b.getRootAlpha());
            epjVar6.l.setColorFilter(colorFilter);
            paint = epjVar6.l;
        }
        canvas.drawBitmap(epjVar6.f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getAlpha() : this.b.b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getColorFilter() : this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f != null) {
            return new epk(this.f.getConstantState());
        }
        this.b.a = getChangingConfigurations();
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.b.b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.b.b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f;
        return drawable != null ? drawable.isAutoMirrored() : this.b.e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        epj epjVar = this.b;
        if (epjVar == null) {
            return false;
        }
        epi epiVar = epjVar.b;
        if (epiVar.o == null) {
            epiVar.o = Boolean.valueOf(epiVar.h.l());
        }
        if (epiVar.o.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.b.c;
        return colorStateList != null && colorStateList.isStateful();
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.e && super.mutate() == this) {
            epj epjVar = this.b;
            epj epjVar2 = new epj();
            epjVar2.c = null;
            epjVar2.d = a;
            if (epjVar != null) {
                epjVar2.a = epjVar.a;
                epi epiVar = new epi(epjVar.b);
                epjVar2.b = epiVar;
                if (epjVar.b.f != null) {
                    epiVar.f = new Paint(epjVar.b.f);
                }
                if (epjVar.b.e != null) {
                    epjVar2.b.e = new Paint(epjVar.b.e);
                }
                epjVar2.c = epjVar.c;
                epjVar2.d = epjVar.d;
                epjVar2.e = epjVar.e;
            }
            this.b = epjVar2;
            this.e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        epj epjVar = this.b;
        ColorStateList colorStateList = epjVar.c;
        if (colorStateList == null || (mode = epjVar.d) == null) {
            z = false;
        } else {
            this.c = k(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        epi epiVar = epjVar.b;
        if (epiVar.o == null) {
            epiVar.o = Boolean.valueOf(epiVar.h.l());
        }
        if (epiVar.o.booleanValue()) {
            boolean zM = epjVar.b.h.m(iArr);
            epjVar.k |= zM;
            if (zM) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.b.b.getRootAlpha() != i) {
            this.b.b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.b.e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f;
        if (drawable != null) {
            bmy.ac(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        epj epjVar = this.b;
        if (epjVar.c != colorStateList) {
            epjVar.c = colorStateList;
            this.c = k(colorStateList, epjVar.d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        epj epjVar = this.b;
        if (epjVar.d != mode) {
            epjVar.d = mode;
            this.c = k(epjVar.c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        char c;
        int i2;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        epj epjVar = this.b;
        epjVar.b = new epi();
        TypedArray typedArrayAv = emc.av(resources, theme, attributeSet, bht.g);
        epj epjVar2 = this.b;
        epi epiVar = epjVar2.b;
        int i3 = !emc.aq(xmlPullParser, "tintMode") ? -1 : typedArrayAv.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i3 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i3 != 5) {
            if (i3 != 9) {
                switch (i3) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        epjVar2.d = mode;
        ColorStateList colorStateListB = null;
        int i4 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayAv.getValue(1, typedValue);
            int i5 = typedValue.type;
            if (i5 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i5 >= 28 && i5 <= 31) {
                colorStateListB = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayAv.getResources();
                int resourceId = typedArrayAv.getResourceId(1, 0);
                ThreadLocal threadLocal = abh.a;
                try {
                    colorStateListB = abh.b(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
                }
            }
        }
        ColorStateList colorStateList = colorStateListB;
        if (colorStateList != null) {
            epjVar2.c = colorStateList;
        }
        boolean z = epjVar2.e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z = typedArrayAv.getBoolean(5, z);
        }
        epjVar2.e = z;
        float f = epiVar.k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f = typedArrayAv.getFloat(7, f);
        }
        epiVar.k = f;
        float f2 = epiVar.l;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f2 = typedArrayAv.getFloat(8, f2);
        }
        epiVar.l = f2;
        if (epiVar.k <= 0.0f) {
            throw new XmlPullParserException(typedArrayAv.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f2 > 0.0f) {
            epiVar.i = typedArrayAv.getDimension(3, epiVar.i);
            float dimension = typedArrayAv.getDimension(2, epiVar.j);
            epiVar.j = dimension;
            if (epiVar.i <= 0.0f) {
                throw new XmlPullParserException(typedArrayAv.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = epiVar.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = typedArrayAv.getFloat(4, alpha);
                }
                epiVar.setAlpha(alpha);
                String string = typedArrayAv.getString(0);
                if (string != null) {
                    epiVar.n = string;
                    epiVar.p.put(string, epiVar);
                }
                typedArrayAv.recycle();
                epjVar.a = getChangingConfigurations();
                epjVar.k = true;
                epj epjVar3 = this.b;
                epi epiVar2 = epjVar3.b;
                ArrayDeque arrayDeque = new ArrayDeque();
                epf epfVar = epiVar2.h;
                ku kuVar = epiVar2.p;
                arrayDeque.push(epfVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z2 = true;
                while (eventType != i4 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        epf epfVar2 = (epf) arrayDeque.peek();
                        i = depth;
                        if ("path".equals(name)) {
                            epe epeVar = new epe();
                            epeVar.b = 0.0f;
                            epeVar.d = 1.0f;
                            epeVar.e = 1.0f;
                            epeVar.f = 0.0f;
                            epeVar.g = 1.0f;
                            epeVar.h = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            epeVar.i = cap2;
                            Paint.Join join2 = Paint.Join.MITER;
                            epeVar.j = join2;
                            epeVar.k = 4.0f;
                            TypedArray typedArrayAv2 = emc.av(resources, theme, attributeSet, bht.i);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                String string2 = typedArrayAv2.getString(0);
                                if (string2 != null) {
                                    epeVar.o = string2;
                                }
                                String string3 = typedArrayAv2.getString(2);
                                if (string3 != null) {
                                    epeVar.n = ajn.l(string3);
                                }
                                epeVar.c = emc.ap(typedArrayAv2, xmlPullParser, theme, "fillColor", 1);
                                float f3 = epeVar.e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f3 = typedArrayAv2.getFloat(12, f3);
                                }
                                epeVar.e = f3;
                                int i6 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayAv2.getInt(8, -1) : -1;
                                Paint.Cap cap3 = epeVar.i;
                                if (i6 == 0) {
                                    cap = cap2;
                                } else if (i6 != 1) {
                                    cap = i6 != 2 ? cap3 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                epeVar.i = cap;
                                int i7 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayAv2.getInt(9, -1) : -1;
                                Paint.Join join3 = epeVar.j;
                                if (i7 == 0) {
                                    join = join2;
                                } else if (i7 != 1) {
                                    join = i7 != 2 ? join3 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                epeVar.j = join;
                                float f4 = epeVar.k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f4 = typedArrayAv2.getFloat(10, f4);
                                }
                                epeVar.k = f4;
                                epeVar.a = emc.ap(typedArrayAv2, xmlPullParser, theme, "strokeColor", 3);
                                float f5 = epeVar.d;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f5 = typedArrayAv2.getFloat(11, f5);
                                }
                                epeVar.d = f5;
                                float f6 = epeVar.b;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f6 = typedArrayAv2.getFloat(4, f6);
                                }
                                epeVar.b = f6;
                                float f7 = epeVar.g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f7 = typedArrayAv2.getFloat(6, f7);
                                }
                                epeVar.g = f7;
                                float f8 = epeVar.h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f8 = typedArrayAv2.getFloat(7, f8);
                                }
                                epeVar.h = f8;
                                float f9 = epeVar.f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f9 = typedArrayAv2.getFloat(5, f9);
                                }
                                epeVar.f = f9;
                                int i8 = epeVar.p;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i8 = typedArrayAv2.getInt(13, i8);
                                }
                                epeVar.p = i8;
                            }
                            typedArrayAv2.recycle();
                            epfVar2.b.add(epeVar);
                            if (epeVar.getPathName() != null) {
                                kuVar.put(epeVar.getPathName(), epeVar);
                            }
                            epjVar3.a = epjVar3.a;
                            z2 = false;
                            c = '\b';
                        } else {
                            c = '\b';
                            if ("clip-path".equals(name)) {
                                epd epdVar = new epd();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray typedArrayAv3 = emc.av(resources, theme, attributeSet, bht.j);
                                    String string4 = typedArrayAv3.getString(0);
                                    if (string4 != null) {
                                        epdVar.o = string4;
                                    }
                                    String string5 = typedArrayAv3.getString(1);
                                    if (string5 != null) {
                                        epdVar.n = ajn.l(string5);
                                    }
                                    epdVar.p = !emc.aq(xmlPullParser, "fillType") ? 0 : typedArrayAv3.getInt(2, 0);
                                    typedArrayAv3.recycle();
                                }
                                epfVar2.b.add(epdVar);
                                if (epdVar.getPathName() != null) {
                                    kuVar.put(epdVar.getPathName(), epdVar);
                                }
                                epjVar3.a = epjVar3.a;
                            } else if ("group".equals(name)) {
                                epf epfVar3 = new epf();
                                TypedArray typedArrayAv4 = emc.av(resources, theme, attributeSet, bht.h);
                                float f10 = epfVar3.c;
                                if (emc.aq(xmlPullParser, "rotation")) {
                                    f10 = typedArrayAv4.getFloat(5, f10);
                                }
                                epfVar3.c = f10;
                                epfVar3.d = typedArrayAv4.getFloat(1, epfVar3.d);
                                epfVar3.e = typedArrayAv4.getFloat(2, epfVar3.e);
                                float f11 = epfVar3.f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f11 = typedArrayAv4.getFloat(3, f11);
                                }
                                epfVar3.f = f11;
                                float f12 = epfVar3.g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f12 = typedArrayAv4.getFloat(4, f12);
                                }
                                epfVar3.g = f12;
                                float f13 = epfVar3.h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f13 = typedArrayAv4.getFloat(6, f13);
                                }
                                epfVar3.h = f13;
                                float f14 = epfVar3.i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f14 = typedArrayAv4.getFloat(7, f14);
                                }
                                epfVar3.i = f14;
                                String string6 = typedArrayAv4.getString(0);
                                if (string6 != null) {
                                    epfVar3.k = string6;
                                }
                                epfVar3.n();
                                typedArrayAv4.recycle();
                                epfVar2.b.add(epfVar3);
                                arrayDeque.push(epfVar3);
                                if (epfVar3.getGroupName() != null) {
                                    kuVar.put(epfVar3.getGroupName(), epfVar3);
                                }
                                epjVar3.a = epjVar3.a;
                            }
                        }
                        i2 = 1;
                    } else {
                        i = depth;
                        c = '\b';
                        i2 = 1;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i4 = i2;
                    depth = i;
                }
                if (!z2) {
                    this.c = k(epjVar.c, epjVar.d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayAv.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayAv.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public epl(epj epjVar) {
        this.g = true;
        this.h = new float[9];
        this.i = new Matrix();
        this.j = new Rect();
        this.b = epjVar;
        this.c = k(epjVar.c, epjVar.d);
    }
}
