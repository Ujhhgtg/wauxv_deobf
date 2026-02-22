package me.hd.wauxv.obf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import me.hd.wauxv.R;
import me.hd.wauxv.data.bean.MsgInfoBean;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class MsgForwardSnsHook extends SwitchHook implements IMessageLongPressHook {
    public static final MsgForwardSnsHook INSTANCE = new MsgForwardSnsHook("MsgForwardSnsHook");
    public static final String b = "菜单";
    public static final String c = "消息转圈";
    public static final String h = "支持将部分消息转发到朋友圈编辑发表";

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

    @Override // me.hd.wauxv.obf.bna
    public final List getUiElements(MsgInfoBean msgInfoBean) {
        if (getIsEnabled()) {
            if (msgInfoBean.isText()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈",
                        R.drawable.ic_menu_forward_24dp, (obj, obj2) -> {
                    MethodResolver methodResolverVarT = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT.returnType = dal.getKClassFromClass(Activity.class);
                    Object objJ = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT.findMethods())).invoke();
                    throwIfVar1IsNull(objJ);
                    Activity activity = (Activity) objJ;
                    String content5 = ((MsgInfoBean) obj2).getContent();
                    Intent intent4 = new Intent();
                    intent4.setClassName(activity, "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
                    intent4.putExtra("Ksnsupload_type", 9);
                    intent4.putExtra("Kdescription", content5);
                    activity.startActivity(intent4);
                }));
            }
            if (msgInfoBean.isImage()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈",
                        R.drawable.ic_menu_forward_24dp, (obj, obj2) -> {
                    MethodResolver methodResolverVarT2 = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT2.returnType = dal.getKClassFromClass(Activity.class);
                    Object objJ2 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT2.findMethods())).invoke();
                    throwIfVar1IsNull(objJ2);
                    Activity activity2 = (Activity) objJ2;
                    bop bopVar2 = bop.a;
                    Object origin2 = ((MsgInfoBean) obj2).getOrigin();
                    ArrayList<String> arrayList10 = new ArrayList<>(new ReadonlyArray(new String[] { bop.b(origin2) }, true));
                    String strZ2 = "";
                    Intent intent5 = new Intent();
                    intent5.setClassName(activity2,
                            "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
                    intent5.putStringArrayListExtra("sns_kemdia_path_list", arrayList10);
                    intent5.putExtra("Kdescription", strZ2);
                    activity2.startActivity(intent5);
                }));
            }
            if (msgInfoBean.isVideo()) {
                return dqc.toSingletonList(new wj(R.id.MenuItem_Chat_ForwardSns, "转圈",
                        R.drawable.ic_menu_forward_24dp, (obj, obj2) -> {
                    MethodResolver methodResolverVarT3 = dqc.getWrapperConfiguration(obj).getMethodResolverBasedOnPreviouslyProvidedConfig();
                    methodResolverVarT3.returnType = dal.getKClassFromClass(Activity.class);
                    Object objJ3 = ((MethodHookWrapper) StaticHelpers5.safeGetFirstInList(methodResolverVarT3.findMethods())).invoke();
                    throwIfVar1IsNull(objJ3);
                    Activity activity3 = (Activity) objJ3;
                    String imgPath3 = ((MsgInfoBean) obj2).getImgPath();
                    throwIfVar1IsNull(imgPath3);
                    eqb.a.getClass();
                    String strB4 = eqb.b(imgPath3);
                    Method methodBb2 = StaticHelpers7.toDexMethod(epz.a);
                    VideoServiceDexFindHook.INSTANCE.getClass();
                    Object objInvoke2 = methodBb2.invoke(VideoServiceDexFindHook.b(), imgPath3);
                    throwIfVar1IsNull(objInvoke2, "null cannot be cast to non-null type kotlin.String");
                    String strZ3 = "";
                    Intent intent6 = new Intent();
                    intent6.setClassName(activity3,
                            "com.tencent.mm.plugin.sns.ui.SnsUploadUI");
                    intent6.putExtra("Ksnsupload_type", 14);
                    intent6.putExtra("KSightPath", strB4);
                    intent6.putExtra("KSightThumbPath", (String) objInvoke2);
                    intent6.putExtra("Kdescription", strZ3);
                    activity3.startActivity(intent6);
                }));
            }
        }
        return EmptyReadonlyList.INSTANCE;
    }

    @Override // me.hd.wauxv.obf.SwitchHook
    public final String getDescription() {
        return h;
    }
}
