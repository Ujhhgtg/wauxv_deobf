package me.hd.wauxv.obf;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class tr extends Property {
    public final /* synthetic */ int a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tr(String str, int i, Class cls) {
        super(cls, str);
        this.a = i;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(((SwitchCompat) obj).ab);
            case 6:
                return Float.valueOf(eso.a.ab((View) obj));
            default:
                return ((View) obj).getClipBounds();
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                tu tuVar = (tu) obj;
                PointF pointF = (PointF) obj2;
                tuVar.getClass();
                tuVar.a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                tuVar.b = iRound;
                int i = tuVar.f + 1;
                tuVar.f = i;
                if (i == tuVar.g) {
                    eso.c(tuVar.e, tuVar.a, iRound, tuVar.c, tuVar.d);
                    tuVar.f = 0;
                    tuVar.g = 0;
                }
                break;
            case 1:
                tu tuVar2 = (tu) obj;
                PointF pointF2 = (PointF) obj2;
                tuVar2.getClass();
                tuVar2.c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                tuVar2.d = iRound2;
                int i2 = tuVar2.g + 1;
                tuVar2.g = i2;
                if (tuVar2.f == i2) {
                    eso.c(tuVar2.e, tuVar2.a, tuVar2.b, tuVar2.c, iRound2);
                    tuVar2.f = 0;
                    tuVar2.g = 0;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                eso.c(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                eso.c(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                eso.c(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 5:
                ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                break;
            case 6:
                float fFloatValue = ((Float) obj2).floatValue();
                eso.a.af((View) obj, fFloatValue);
                break;
            default:
                ((View) obj).setClipBounds((Rect) obj2);
                break;
        }
    }
}
