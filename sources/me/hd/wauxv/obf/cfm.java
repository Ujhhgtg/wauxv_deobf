package me.hd.wauxv.obf;

import android.R;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class cfm extends doo implements bnc {
    public static final cfm a;
    public static final String b;
    public static final dov c;
    public static final dov h;
    public static final dov j;
    public static final String l;
    public static final String m;
    public static final String n;
    public static final bzk r;

    static {
        cnb.z(-451744660192042L);
        a = new cfm(cnb.z(-428014965881642L));
        dov dovVar = ctf.a;
        b = ctf.c(cnb.z(-46505905879850L), cnb.z(-46467251174186L));
        c = new dov(new cfh(0));
        h = new dov(new cfh(1));
        j = new dov(new cfh(2));
        l = cnb.z(-451718890388266L);
        m = cnb.z(-451723185355562L);
        n = cnb.z(-451693120584490L);
        r = new bzk(14);
    }

    public static void s(View view, boolean z) {
        int iHSVToColor;
        int color = cnh.aa(view.getContext()) ? Color.parseColor((!z ? cfi.a : cfk.a).o()) : Color.parseColor((!z ? cfj.a : cfl.a).o());
        Resources resources = view.getResources();
        Bitmap bitmap = !z ? (Bitmap) j.getValue() : (Bitmap) h.getValue();
        Integer numValueOf = color != 0 ? Integer.valueOf(color) : null;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 1, 1, bitmap.getWidth() - 2, bitmap.getHeight() - 2);
        ArrayList<cod> arrayListAd = cnh.ad(bitmap, true);
        ArrayList<cod> arrayListAd2 = cnh.ad(bitmap, false);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((arrayListAd2.size() + arrayListAd.size()) * 8) + 68);
        byteBufferAllocate.order(ByteOrder.nativeOrder());
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put((byte) (arrayListAd.size() * 2));
        byteBufferAllocate.put((byte) (arrayListAd2.size() * 2));
        byteBufferAllocate.put((byte) 9);
        for (int i = 0; i < 2; i++) {
            byteBufferAllocate.putInt(0);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            byteBufferAllocate.putInt(0);
        }
        byteBufferAllocate.putInt(0);
        for (cod codVar : arrayListAd) {
            byteBufferAllocate.putInt(codVar.a);
            byteBufferAllocate.putInt(codVar.b);
        }
        for (cod codVar2 : arrayListAd2) {
            byteBufferAllocate.putInt(codVar2.a);
            byteBufferAllocate.putInt(codVar2.b);
        }
        for (int i3 = 0; i3 < 9; i3++) {
            byteBufferAllocate.putInt(1);
        }
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(resources, bitmapCreateBitmap, byteBufferAllocate.array(), new Rect(), null);
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (numValueOf != null) {
            ninePatchDrawable.setTint(numValueOf.intValue());
        }
        Drawable.ConstantState constantState = ninePatchDrawable.getConstantState();
        if (constantState != null) {
            Drawable drawableMutate = constantState.newDrawable().mutate();
            cfm cfmVar = a;
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                cfmVar.getClass();
                float[] fArr = new float[3];
                Color.colorToHSV(iIntValue, fArr);
                fArr[2] = fArr[2] * 0.8f;
                iHSVToColor = Color.HSVToColor(fArr);
            } else {
                cfmVar.getClass();
                float[] fArr2 = new float[3];
                Color.colorToHSV(-1, fArr2);
                fArr2[2] = fArr2[2] * 0.8f;
                iHSVToColor = Color.HSVToColor(fArr2);
            }
            drawableMutate.setTint(iHSVToColor);
            stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawableMutate);
            stateListDrawable.addState(new int[]{R.attr.state_focused}, drawableMutate);
            stateListDrawable.addState(new int[0], ninePatchDrawable);
        }
        view.setBackground(stateListDrawable);
    }

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return m;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return l;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (z()) {
            int type = msgInfoBean.getType();
            if (type == ewg.a.w || type == ewg.k.w || type == ewg.r.w || type == ewg.s.w) {
                View viewV = cnh.v(view, bhs.v());
                if (viewV != null) {
                    s(viewV, msgInfoBean.isSend());
                    return;
                }
                return;
            }
            if (type != ewg.c.w) {
                if (type == ewg.i.w) {
                    View viewV2 = cnh.v(view, cnb.ab(ewk.c) ? cnb.z(-426915454253866L) : cnb.z(-428513182087978L));
                    if (viewV2 != null) {
                        s(viewV2, msgInfoBean.isSend());
                        return;
                    }
                    return;
                }
                return;
            }
            View viewV3 = cnh.v(view, bhs.w());
            if (viewV3 != null) {
                s(viewV3, msgInfoBean.isSend());
            }
            View viewV4 = cnh.v(view, bhs.x());
            if (viewV4 != null) {
                s(viewV4, msgInfoBean.isSend());
            }
            View viewV5 = cnh.v(view, bhs.y());
            if (viewV5 != null) {
                s(viewV5, msgInfoBean.isSend());
            }
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return n;
    }

    @Override // me.hd.wauxv.obf.doo
    public final bgf p() {
        return r;
    }
}
