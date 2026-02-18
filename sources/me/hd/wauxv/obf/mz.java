package me.hd.wauxv.obf;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.android.dx.io.Opcodes;
import java.io.IOException;
import java.util.Locale;
import me.hd.wauxv.R;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class mz {
    public final my a;
    public final my b = new my();
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final int i;
    public final int j;
    public final int k;

    public mz(Context context, my myVar) {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        my myVar2 = myVar == null ? new my() : myVar;
        int i = myVar2.a;
        if (i != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                attributeSet = attributeSetAsAttributeSet;
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayAn = bhu.an(context, attributeSet, cxs.c, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.c = typedArrayAn.getDimensionPixelSize(4, -1);
        this.i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.d = typedArrayAn.getDimensionPixelSize(14, -1);
        this.e = typedArrayAn.getDimension(12, resources.getDimension(R.dimen.m3_badge_size));
        this.g = typedArrayAn.getDimension(17, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f = typedArrayAn.getDimension(3, resources.getDimension(R.dimen.m3_badge_size));
        this.h = typedArrayAn.getDimension(13, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.k = typedArrayAn.getInt(24, 1);
        my myVar3 = this.b;
        int i2 = myVar2.i;
        myVar3.i = i2 == -2 ? Opcodes.CONST_METHOD_TYPE : i2;
        int i3 = myVar2.k;
        if (i3 != -2) {
            myVar3.k = i3;
        } else if (typedArrayAn.hasValue(23)) {
            this.b.k = typedArrayAn.getInt(23, 0);
        } else {
            this.b.k = -1;
        }
        String str = myVar2.j;
        if (str != null) {
            this.b.j = str;
        } else if (typedArrayAn.hasValue(7)) {
            this.b.j = typedArrayAn.getString(7);
        }
        my myVar4 = this.b;
        myVar4.o = myVar2.o;
        CharSequence charSequence = myVar2.p;
        myVar4.p = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        my myVar5 = this.b;
        int i4 = myVar2.q;
        myVar5.q = i4 == 0 ? R.plurals.mtrl_badge_content_description : i4;
        int i5 = myVar2.r;
        myVar5.r = i5 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i5;
        Boolean bool = myVar2.t;
        myVar5.t = Boolean.valueOf(bool == null || bool.booleanValue());
        my myVar6 = this.b;
        int i6 = myVar2.l;
        myVar6.l = i6 == -2 ? typedArrayAn.getInt(21, -2) : i6;
        my myVar7 = this.b;
        int i7 = myVar2.m;
        myVar7.m = i7 == -2 ? typedArrayAn.getInt(22, -2) : i7;
        my myVar8 = this.b;
        Integer num = myVar2.e;
        myVar8.e = Integer.valueOf(num == null ? typedArrayAn.getResourceId(5, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        my myVar9 = this.b;
        Integer num2 = myVar2.f;
        myVar9.f = Integer.valueOf(num2 == null ? typedArrayAn.getResourceId(6, 0) : num2.intValue());
        my myVar10 = this.b;
        Integer num3 = myVar2.g;
        myVar10.g = Integer.valueOf(num3 == null ? typedArrayAn.getResourceId(15, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        my myVar11 = this.b;
        Integer num4 = myVar2.h;
        myVar11.h = Integer.valueOf(num4 == null ? typedArrayAn.getResourceId(16, 0) : num4.intValue());
        my myVar12 = this.b;
        Integer num5 = myVar2.b;
        myVar12.b = Integer.valueOf(num5 == null ? cnb.v(context, typedArrayAn, 1).getDefaultColor() : num5.intValue());
        my myVar13 = this.b;
        Integer num6 = myVar2.d;
        myVar13.d = Integer.valueOf(num6 == null ? typedArrayAn.getResourceId(8, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = myVar2.c;
        if (num7 != null) {
            this.b.c = num7;
        } else if (typedArrayAn.hasValue(9)) {
            this.b.c = Integer.valueOf(cnb.v(context, typedArrayAn, 9).getDefaultColor());
        } else {
            int iIntValue = this.b.d.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, cxs.ao);
            typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList colorStateListV = cnb.v(context, typedArrayObtainStyledAttributes, 3);
            cnb.v(context, typedArrayObtainStyledAttributes, 4);
            cnb.v(context, typedArrayObtainStyledAttributes, 5);
            typedArrayObtainStyledAttributes.getInt(2, 0);
            typedArrayObtainStyledAttributes.getInt(1, 1);
            int i8 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
            typedArrayObtainStyledAttributes.getResourceId(i8, 0);
            typedArrayObtainStyledAttributes.getString(i8);
            typedArrayObtainStyledAttributes.getBoolean(14, false);
            cnb.v(context, typedArrayObtainStyledAttributes, 6);
            typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, cxs.aa);
            typedArrayObtainStyledAttributes2.hasValue(0);
            typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.b.c = Integer.valueOf(colorStateListV.getDefaultColor());
        }
        my myVar14 = this.b;
        Integer num8 = myVar2.s;
        myVar14.s = Integer.valueOf(num8 == null ? typedArrayAn.getInt(2, 8388661) : num8.intValue());
        my myVar15 = this.b;
        Integer num9 = myVar2.u;
        myVar15.u = Integer.valueOf(num9 == null ? typedArrayAn.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        my myVar16 = this.b;
        Integer num10 = myVar2.v;
        myVar16.v = Integer.valueOf(num10 == null ? typedArrayAn.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        my myVar17 = this.b;
        Integer num11 = myVar2.w;
        myVar17.w = Integer.valueOf(num11 == null ? typedArrayAn.getDimensionPixelOffset(18, 0) : num11.intValue());
        my myVar18 = this.b;
        Integer num12 = myVar2.x;
        myVar18.x = Integer.valueOf(num12 == null ? typedArrayAn.getDimensionPixelOffset(25, 0) : num12.intValue());
        my myVar19 = this.b;
        Integer num13 = myVar2.y;
        myVar19.y = Integer.valueOf(num13 == null ? typedArrayAn.getDimensionPixelOffset(19, myVar19.w.intValue()) : num13.intValue());
        my myVar20 = this.b;
        Integer num14 = myVar2.z;
        myVar20.z = Integer.valueOf(num14 == null ? typedArrayAn.getDimensionPixelOffset(26, myVar20.x.intValue()) : num14.intValue());
        my myVar21 = this.b;
        Integer num15 = myVar2.ac;
        myVar21.ac = Integer.valueOf(num15 == null ? typedArrayAn.getDimensionPixelOffset(20, 0) : num15.intValue());
        my myVar22 = this.b;
        Integer num16 = myVar2.aa;
        myVar22.aa = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        my myVar23 = this.b;
        Integer num17 = myVar2.ab;
        myVar23.ab = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        my myVar24 = this.b;
        Boolean bool2 = myVar2.ad;
        myVar24.ad = Boolean.valueOf(bool2 == null ? typedArrayAn.getBoolean(0, false) : bool2.booleanValue());
        typedArrayAn.recycle();
        Locale locale = myVar2.n;
        if (locale == null) {
            this.b.n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.b.n = locale;
        }
        this.a = myVar2;
    }
}
