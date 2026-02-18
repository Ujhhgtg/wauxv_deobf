package me.hd.wauxv.obf;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class akz implements bul {
    public final /* synthetic */ int a;
    public final Object b;
    public final Object c;

    public /* synthetic */ akz(Object obj, int i, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // me.hd.wauxv.obf.bul
    public final void e(bup bupVar, bug bugVar) {
        switch (this.a) {
            case 0:
                atg atgVar = (atg) this.b;
                switch (aky.a[bugVar.ordinal()]) {
                    case 1:
                        atgVar.getClass();
                        break;
                    case 2:
                        atgVar.getClass();
                        break;
                    case 3:
                        EmojiCompatInitializer emojiCompatInitializer = atgVar.b;
                        (Build.VERSION.SDK_INT >= 28 ? acr.a(Looper.getMainLooper())
                                : new Handler(Looper.getMainLooper())).postDelayed(new ati(), 500L);
                        atgVar.a.o(atgVar);
                        break;
                    case 4:
                        atgVar.getClass();
                        break;
                    case 5:
                        atgVar.getClass();
                        break;
                    case 6:
                        atgVar.getClass();
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    default:
                        throw new QueryDidNotReturnUniqueResultRuntimeException();
                }
                bul bulVar = (bul) this.c;
                if (bulVar != null) {
                    bulVar.e(bupVar, bugVar);
                    return;
                }
                return;
            case 1:
                bff bffVar = (bff) this.b;
                byu byuVar = (byu) this.c;
                if (byuVar.b.ci()) {
                    return;
                }
                bupVar.ap().o(this);
                if (((FrameLayout) bffVar.d).isAttachedToWindow()) {
                    byuVar.aa(bffVar);
                    return;
                }
                return;
            case 2:
                if (bugVar == bug.ON_DESTROY) {
                    ((Handler) this.b).removeCallbacks((dc) this.c);
                    bupVar.ap().o(this);
                    return;
                }
                return;
            case 3:
                if (bugVar == bug.ON_START) {
                    ((bur) this.b).o(this);
                    ((but) this.c).ag();
                    return;
                }
                return;
            default:
                HashMap map = ((zg) this.c).a;
                List list = (List) map.get(bugVar);
                Object obj = this.b;
                zg.c(list, bupVar, bugVar, obj);
                zg.c((List) map.get(bug.ON_ANY), bupVar, bugVar, obj);
                return;
        }
    }

    public akz(atg atgVar, bul bulVar) {
        this.a = 0;
        throwIfVar1IsNull(atgVar, "defaultLifecycleObserver");
        this.b = atgVar;
        this.c = bulVar;
    }

    public akz(buo buoVar) {
        this.a = 4;
        this.b = buoVar;
        zi ziVar = zi.a;
        Class<?> cls = buoVar.getClass();
        zg zgVar = (zg) ziVar.b.get(cls);
        this.c = zgVar == null ? ziVar.e(cls, null) : zgVar;
    }

    public akz(byu byuVar, bff bffVar) {
        this.a = 1;
        this.c = byuVar;
        this.b = bffVar;
    }
}
