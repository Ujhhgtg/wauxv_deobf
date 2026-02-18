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
public final class daf extends SwitchHook implements bnc {
    public static final daf a = new daf("RedPacketTotalNumHook" /* cnb.z(-538649028459306L) */);
    public static final String b = "红包" /* cnb.z(-537996193430314L) */;
    public static final String c = "红包个数显示" /* cnb.z(-538000488397610L) */;
    public static final String h = "在普通群聊的红包消息上显示具体个数" /* cnb.z(-537970423626538L) */;

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() {
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return c;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return b;
    }

    @Override // me.hd.wauxv.obf.bnc
    public final void i(View view, Object obj, Object obj2, MsgInfoBean msgInfoBean) {
        if (getIsEnabled() && msgInfoBean.isGroupChat() && msgInfoBean.isRedBag()) {
            Object byPath = dnc.e(msgInfoBean.getContent()).getByPath("msg.appmsg.wcpayinfo" /*
                                                                                              * cnb.z(-538537359309610L)
                                                                                              */);
            throwIfVar1IsNull(byPath, "null cannot be cast to non-null type com.alibaba.fastjson2.JSONObject" /*
                                                                                                               * cnb.z(-
                                                                                                               * 537931768920874L)
                                                                                                               */);
            String queryParameter = Uri
                    .parse(((JSONObject) byPath).getString("nativeurl" /* cnb.z(-538163697154858L) */))
                    .getQueryParameter("total_num" /* cnb.z(-538137927351082L) */);
            if (queryParameter == null) {
                return;
            }
            int[] iArr = msgInfoBean.isSend() ? new int[] { 4, 0, 0, 1, 2, 0 } : new int[] { 4, 1, 0, 1, 1, 2, 0 };
            TextView textView = (TextView) erb.b(view, "RedPacket.Subtitle" /* cnb.z(-538043438070570L) */,
                    Arrays.copyOf(iArr, iArr.length));
            if (textView == null) {
                return;
            }
            textView.setText(((Object) textView.getText())
                    + TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH + queryParameter + ']');
        }
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
