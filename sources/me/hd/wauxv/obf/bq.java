package me.hd.wauxv.obf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson2.JSONWriter;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;
import me.hd.wauxv.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bq implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ bq(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String originContent;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((bp) obj).invoke();
                return;
            case 1:
                ((wz) obj).c.invoke();
                return;
            case 2:
                zv zvVar = (zv) obj;
                EditText editText = zvVar.e;
                if (editText == null) {
                    return;
                }
                Editable text = editText.getText();
                if (text != null) {
                    text.clear();
                }
                zvVar.al();
                return;
            case 3:
                ((CheckBox) ((cxd) obj).b(R.id.itemContactCheckBoxSelect)).performClick();
                return;
            case 4:
                ((IHasInvokeMethod) obj).invoke(view);
                return;
            case 5:
                ((aql) obj).ae();
                return;
            case 6:
                atv.a.r(((atr) obj).i);
                return;
            case 7:
                atw.a.r(((atu) obj).f);
                return;
            case 8:
                int i2 = MainActivity.as;
                ((bfu) obj).invoke();
                return;
            case 9:
                ((cas) obj).ed();
                throw null;
            case 10:
                ((ccz) obj).ai();
                return;
            case 11:
                MsgInfoBean msgInfoBean = (MsgInfoBean) obj;
                if (cgn.a.i()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    builder.setTitle(msgInfoBean.getOrigin().getClass().getSimpleName());
                    cgo cgoVar = cgo.a;
                    if (cgoVar.i()) {
                        originContent = msgInfoBean.getContent();
                        if (dnc.d(originContent)) {
                            originContent = dnc.e(originContent).toJSONString(JSONWriter.Feature.PrettyFormat);
                        }
                    } else {
                        originContent = msgInfoBean.getOriginContent();
                    }
                    builder.setMessage(originContent);
                    builder.setPositiveButton("确定" /* cnb.z(-467696168729386L) */, (DialogInterface.OnClickListener) null);
                    builder.setNegativeButton("取消" /* cnb.z(-467700463696682L) */, (DialogInterface.OnClickListener) null);
                    TextView textView = (TextView) builder.show().findViewById(android.R.id.message);
                    textView.setTextIsSelectable(true);
                    if (cgoVar.i()) {
                        textView.setHorizontallyScrolling(true);
                        textView.scrollTo(0, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                ctb ctbVar = (ctb) obj;
                EditText editText2 = ctbVar.b;
                if (editText2 == null) {
                    return;
                }
                int selectionEnd = editText2.getSelectionEnd();
                EditText editText3 = ctbVar.b;
                if (editText3 == null || !(editText3.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                    ctbVar.b.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    ctbVar.b.setTransformationMethod(null);
                }
                if (selectionEnd >= 0) {
                    ctbVar.b.setSelection(selectionEnd);
                }
                ctbVar.al();
                return;
        }
    }
}
