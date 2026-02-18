package me.hd.wauxv.obf;

import android.util.SparseIntArray;
import io.github.rosemoe.sora.widget.CodeEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class arq {
    public static final arq a = new arq();
    public final SparseIntArray b = new SparseIntArray();
    public final ArrayList c = new ArrayList();

    public arq() {
        for (int i = 1; i <= 75; i++) {
            SparseIntArray sparseIntArray = this.b;
            int i2 = sparseIntArray.get(i);
            switch (i) {
                case 1:
                case 3:
                    i2 = -286331154;
                    break;
                case 2:
                case 45:
                    i2 = -11513776;
                    break;
                case 4:
                case 17:
                case 19:
                case 20:
                case 63:
                    i2 = -1;
                    break;
                case 5:
                case 64:
                    i2 = -13421773;
                    break;
                case 6:
                case 52:
                    i2 = 759124405;
                    break;
                case 7:
                    i2 = -581734914;
                    break;
                case 8:
                    i2 = -11309570;
                    break;
                case 9:
                    i2 = 268435456;
                    break;
                case 10:
                case 42:
                case 43:
                case 50:
                case 58:
                case 68:
                    i2 = -16777216;
                    break;
                case 11:
                    i2 = -2565928;
                    break;
                case 12:
                    i2 = -14210774;
                    break;
                case 13:
                case 18:
                case 30:
                case 39:
                case 40:
                case 57:
                    i2 = 0;
                    break;
                case 14:
                    i2 = -2236963;
                    break;
                case 15:
                case 38:
                case 70:
                case 71:
                    i2 = -6710887;
                    break;
                case 16:
                    i2 = -587202560;
                    break;
                case 21:
                    i2 = -14575885;
                    break;
                case 22:
                    i2 = -5723992;
                    break;
                case 23:
                    i2 = -16750890;
                    break;
                case 24:
                    i2 = -16744320;
                    break;
                case 25:
                    i2 = -11243910;
                    break;
                case 26:
                case 28:
                case 59:
                case 72:
                    i2 = -16537100;
                    break;
                case 27:
                    i2 = -2080517;
                    break;
                case 29:
                    i2 = -256;
                    break;
                case 31:
                    i2 = -288568116;
                    break;
                case 35:
                    i2 = -1426128896;
                    break;
                case 36:
                    i2 = -1426067200;
                    break;
                case 37:
                    i2 = 1711341329;
                    break;
                case 41:
                case 49:
                    i2 = 486539264;
                    break;
                case 44:
                case 51:
                    i2 = -1118482;
                    break;
                case 46:
                    i2 = 1725816285;
                    break;
                case 47:
                    i2 = -1428300323;
                    break;
                case 48:
                    i2 = -3355444;
                    break;
                case 53:
                case 60:
                case 65:
                case 69:
                    i2 = -65794;
                    break;
                case 54:
                    i2 = -12434878;
                    break;
                case 55:
                    i2 = -10395295;
                    break;
                case 56:
                    i2 = -12409355;
                    break;
                case 62:
                    i2 = -1712394514;
                    break;
                case 66:
                    i2 = -7829368;
                    break;
                case 67:
                    i2 = -11687172;
                    break;
                case 73:
                    i2 = 1074684828;
                    break;
                case 74:
                    i2 = 1079465815;
                    break;
                case 75:
                    i2 = -12627531;
                    break;
            }
            if (sparseIntArray.get(i) != i2) {
                sparseIntArray.put(i, i2);
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    CodeEditor codeEditor = (CodeEditor) ((WeakReference) it.next()).get();
                    if (codeEditor == null) {
                        it.remove();
                    } else {
                        codeEditor.i.g(new abg(codeEditor));
                        codeEditor.cn.c();
                        codeEditor.invalidate();
                    }
                }
            }
        }
    }

    public final void d(CodeEditor codeEditor) {
        ArrayList arrayList = this.c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == codeEditor) {
                return;
            }
        }
        arrayList.add(new WeakReference(codeEditor));
        codeEditor.i.g(new abg(codeEditor));
        codeEditor.cn.c();
        codeEditor.invalidate();
    }
}
