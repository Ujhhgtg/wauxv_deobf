package me.hd.wauxv.obf;

import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.alibaba.fastjson2.JSONObject;
import java.util.Arrays;
import me.hd.wauxv.data.bean.MsgInfoBean;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class daf extends doo implements bnc {
    public static final daf a = new daf(cnb.z(-538649028459306L));
    public static final String b = cnb.z(-537996193430314L);
    public static final String c = cnb.z(-538000488397610L);
    public static final String h = cnb.z(-537970423626538L);

    @Override // me.hd.wauxv.obf.bmf
    public final void e() {
    }

    @Override // me.hd.wauxv.obf.doo
    public final String f() {
        return c;
    }

    @Override // me.hd.wauxv.obf.doo
    public final String g() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (z() && msgInfoBean.isGroupChat() && msgInfoBean.isRedBag()) {
            Object byPath = dnc.e(msgInfoBean.getContent()).getByPath(cnb.z(-538537359309610L));
            bzo.o(byPath, cnb.z(-537931768920874L));
            String queryParameter = Uri.parse(((JSONObject) byPath).getString(cnb.z(-538163697154858L))).getQueryParameter(cnb.z(-538137927351082L));
            if (queryParameter == null) {
                return;
            }
            int[] iArr = msgInfoBean.isSend() ? new int[]{4, 0, 0, 1, 2, 0} : new int[]{4, 1, 0, 1, 1, 2, 0};
            TextView textView = (TextView) erb.b(view, cnb.z(-538043438070570L), Arrays.copyOf(iArr, iArr.length));
            if (textView == null) {
                return;
            }
            textView.setText(((Object) textView.getText()) + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + queryParameter + ']');
        }
    }

    @Override // me.hd.wauxv.obf.doo
    public final String o() {
        return h;
    }
}
