package okhttp3;

import com.umeng.analytics.pro.bt;
import me.hd.wauxv.obf.bzo;
import me.hd.wauxv.obf.sj;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WebSocketListener {
    public void onClosed(WebSocket webSocket, int i, String str) {
        bzo.q(webSocket, "webSocket");
        bzo.q(str, "reason");
    }

    public void onClosing(WebSocket webSocket, int i, String str) {
        bzo.q(webSocket, "webSocket");
        bzo.q(str, "reason");
    }

    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        bzo.q(webSocket, "webSocket");
        bzo.q(th, bt.aG);
    }

    public void onMessage(WebSocket webSocket, String str) {
        bzo.q(webSocket, "webSocket");
        bzo.q(str, "text");
    }

    public void onOpen(WebSocket webSocket, Response response) {
        bzo.q(webSocket, "webSocket");
        bzo.q(response, "response");
    }

    public void onMessage(WebSocket webSocket, sj sjVar) {
        bzo.q(webSocket, "webSocket");
        bzo.q(sjVar, "bytes");
    }
}
