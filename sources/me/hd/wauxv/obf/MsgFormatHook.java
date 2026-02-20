package me.hd.wauxv.obf;

import java.lang.reflect.Constructor;
import java.util.List;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import me.hd.wauxv.R;
import org.luckypray.dexkit.DexKitBridge;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MsgFormatHook extends SwitchHook implements IDexFind {
    public static final MsgFormatHook a;
    public static final List b;
    public static final String c;
    public static final String i;
    public static final String j;

    static {
        "${sendText}喵~" /* "${sendText}喵~" /* "${sendText}喵~" /* "${sendText}喵~" /* cnb.z(-470277444074282L)   */;
        "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* "HH:mm:ss" /* cnb.z(-470200134662954L)   */;
        a = new MsgFormatHook("MsgFormatHook" /* "MsgFormatHook" /* "MsgFormatHook" /* "MsgFormatHook" /* cnb.z(-469491465059114L)   */);
        b = OtherStaticHelpers.argsToList("${sendText}" /* "${sendText}" /* "${sendText}" /* "${sendText}" /* cnb.z(-470178659826474L)   */, "${line}" /* "${line}" /* "${line}" /* "${line}" /* cnb.z(-470092760480554L)   */, "${sendTime}" /* "${sendTime}" /* "${sendTime}" /* "${sendTime}" /* cnb.z(-470058400742186L)   */);
        c = "聊天" /* "聊天" /* "聊天" /* "聊天" /* cnb.z(-470590976686890L)   */;
        i = "发送文本格式" /* "发送文本格式" /* "发送文本格式" /* "发送文本格式" /* cnb.z(-470526552177450L)   */;
        j = "将聊天发送的文本进行自定义格式处理" /* "将聊天发送的文本进行自定义格式处理" /* "将聊天发送的文本进行自定义格式处理" /* "将聊天发送的文本进行自定义格式处理" /* cnb.z(-470496487406378L)   */;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final void initOnce() throws NoSuchMethodException {
        Constructor constructorBa = StaticHelpers7.toDexConstructor(ConstructorSendTextComponent.INSTANCE);
        List listBf = dqc.toSingletonList(constructorBa);
        MsgFormatHook msgFormatHookVar = a;
        HookManager hookManagerVarAb = PackageParam.createHook(msgFormatHookVar, listBf);
        msgFormatHookVar.hookBefore(hookManagerVarAb, new StillAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(constructorBa, 7));
        hookManagerVarAb.initInstantCollectionAndApplyHooks();
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getName() {
        return i;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getCategory() {
        return c;
    }

    @Override // me.hd.wauxv.obf.IDexFind
    public final void dexFind(DexKitBridge dexKitBridge) {
        StaticHelpers7.resolveDexAndCache(ConstructorSendTextComponent.INSTANCE, dexKitBridge, new EvenAnotherHugeSyntheticPileOfClosuresThatActsDifferentlyBasedOnConstructorArg(17));
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return j;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final IInvokable getOnClick() {
        return {
            View view4 = (View) obj;
            View viewK3 = StaticHelpers6.k(view4, R.layout.module_dialog_msg_format, null, false);
            int i12 = R.id.moduleDialogEdtMsgFormatTextFormat;
            TextInputEditText textInputEditText13 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                    R.id.moduleDialogEdtMsgFormatTextFormat);
            if (textInputEditText13 != null) {
                i12 = R.id.moduleDialogEdtMsgFormatTextPlaceholders;
                MaterialTextView materialTextView = (MaterialTextView) KotlinHelpers2.recursivelyFindViewById(viewK3,
                        R.id.moduleDialogEdtMsgFormatTextPlaceholders);
                if (materialTextView != null) {
                    i12 = R.id.moduleDialogEdtMsgFormatTimeFormat;
                    TextInputEditText textInputEditText14 = (TextInputEditText) KotlinHelpers2.recursivelyFindViewById(viewK3,
                            R.id.moduleDialogEdtMsgFormatTimeFormat);
                    if (textInputEditText14 != null) {
                        i12 = R.id.moduleDialogInputMsgFormatTextFormat;
                        if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3, R.id.moduleDialogInputMsgFormatTextFormat)) != null) {
                            i12 = R.id.moduleDialogInputMsgFormatTimeFormat;
                            if (((TextInputLayout) KotlinHelpers2.recursivelyFindViewById(viewK3,
                                    R.id.moduleDialogInputMsgFormatTimeFormat)) != null) {
                                cem cemVar = new cem((LinearLayout) viewK3, textInputEditText13, materialTextView,
                                        textInputEditText14, 3);
                                textInputEditText13.setText(cfz.a.o());
                                textInputEditText14.setText(cga.a.o());
                                materialTextView.setMovementMethod(LinkMovementMethod.getInstance());
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(
                                        "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* "点击占位符自动添加以下字段:\n" /* cnb.z(-469285306628906L)  */);
                                for (String str : MsgFormatHook.b) {
                                    int length = spannableStringBuilder.length();
                                    spannableStringBuilder.append((CharSequence) (str + ' '));
                                    spannableStringBuilder.setSpan(new wf(cemVar, str, 1), length,
                                            spannableStringBuilder.length() - 1, 33);
                                }
                                materialTextView.setText(spannableStringBuilder);
                                bzy bzyVar3 = new bzy(view4.getContext());
                                eg egVar3 = (eg) bzyVar3.d;
                                MsgFormatHook.a.getClass();
                                egVar3.d = MsgFormatHook.i;
                                bzyVar3.t("保存" /* "保存" /* "保存" /* cnb.z(-468666831338282L)  */, new amw(new cfx(cemVar, 0), 0));
                                bzyVar3.s("重置" /* "重置" /* "重置" /* cnb.z(-468602406828842L)  */, new amw(new Function1$VarIsInt$2(i2), 2));
                                bjs.x((3 & 2) != 0 ? new amd(1) : null, bzyVar3,
                                        "取消" /* "取消" /* "取消" /* cnb.z(-47455093652266L)  */);
                                LinearLayout linearLayout3 = cemVar.b;
                                if (linearLayout3 != null) {
                                    egVar3.r = linearLayout3;
                                }
                                bzyVar3.i().show();
                                return ensVar;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: "
                    /* "Missing required view with ID: " /* "Missing required view with ID: " /* cnb.z(-662215237565226L)  */.concat(viewK3.getResources().getResourceName(i12)));
            }

    }
}
