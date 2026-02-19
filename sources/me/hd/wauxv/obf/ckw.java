package me.hd.wauxv.obf;

import com.drake.net.exception.ConvertException;
import com.drake.net.exception.DownloadFileException;
import java.io.File;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.net.SocketException;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import net.bytebuddy.description.type.TypeDescription;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class ckw {
    public static final /* synthetic */ ckw a = new ckw();

    /* JADX WARN: Found duplicated region for block: B:81:0x012f */
    /* JADX WARN: Found duplicated region for block: B:83:0x014d */
    /* JADX WARN: Found duplicated region for block: B:84:0x0160 */
    /* JADX WARN: Found duplicated region for block: B:87:0x0176 */
    public final Object b(Type type, Response response) throws DownloadFileException, ConvertException {
        rm rmVarSource;
        Request request;
        throwIfVar1IsNull(type, "succeed");
        if (type == String.class && response.isSuccessful()) {
            ResponseBody responseBodyBody = response.body();
            if (responseBodyBody != null) {
                return responseBodyBody.string();
            }
        } else if (type == sj.class && response.isSuccessful()) {
            ResponseBody responseBodyBody2 = response.body();
            if (responseBodyBody2 != null) {
                return responseBodyBody2.byteString();
            }
        } else if ((type instanceof GenericArrayType)
                && ((GenericArrayType) type).getGenericComponentType() == Byte.TYPE && response.isSuccessful()) {
            ResponseBody responseBodyBody3 = response.body();
            if (responseBodyBody3 != null) {
                return responseBodyBody3.bytes();
            }
        } else {
            if (type != File.class || !response.isSuccessful()) {
                if (type == Response.class) {
                    return response;
                }
                throw new ConvertException(response, "An exception occurred while converting the NetConverter.DEFAULT",
                        null, null, 12, null);
            }
            Request request2 = response.request();
            throwIfVar1IsNull(request2, "<this>");
            cnc cncVar = (cnc) request2.tag(cnc.class);
            String absolutePath = cncVar != null ? cncVar.a : null;
            if (absolutePath == null) {
                absolutePath = ckv.j().getFilesDir().getAbsolutePath();
                throwIfVar1IsNull(absolutePath, "NetConfig.app.filesDir.absolutePath");
            }
            File file = new File(absolutePath);
            if (file.isDirectory()) {
                Request request3 = response.request();
                throwIfVar1IsNull(request3, "<this>");
                cne cneVar = (cne) request3.tag(cne.class);
                String strAx = cneVar != null ? cneVar.a : null;
                if (strAx == null) {
                    strAx = null;
                }
                if (strAx == null || dnj.ak(strAx)) {
                    strAx = null;
                }
                if (strAx == null) {
                    String strHeader$default = Response.header$default(response, "Content-Disposition", null, 2, null);
                    if (strHeader$default != null) {
                        CharSequence charSequenceSubSequence = "";
                        String strAu = dnj.au(strHeader$default, "filename=", "");
                        if (dnj.ak(strAu)) {
                            strAu = null;
                        }
                        if (strAu != null) {
                            strAx = strAu;
                        } else {
                            String strAu2 = dnj.au(strHeader$default, "filename*=", "");
                            char[] charArray = "UTF-8''".toCharArray();
                            throwIfVar1IsNull(charArray, "this as java.lang.String).toCharArray()");
                            char[] cArrCopyOf = Arrays.copyOf(charArray, charArray.length);
                            throwIfVar1IsNull(cArrCopyOf, "chars");
                            int length = strAu2.length();
                            for (int i = 0; i < length; i++) {
                                char cCharAt = strAu2.charAt(i);
                                int length2 = cArrCopyOf.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= length2) {
                                        i2 = -1;
                                        break;
                                    }
                                    if (cCharAt == cArrCopyOf[i2]) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (!(i2 >= 0)) {
                                    charSequenceSubSequence = strAu2.subSequence(i, strAu2.length());
                                    break;
                                }
                            }
                            strAx = charSequenceSubSequence.toString();
                            if (dnj.ak(strAx)) {
                                strAx = null;
                            }
                            if (strAx == null) {
                                strAx = dnj.ax((String) StaticHelpers5.l(response.request().url().pathSegments()),
                                        TypeDescription.Generic.OfWildcardType.SYMBOL);
                                if (dnj.ak(strAx)) {
                                    strAx = "unknown_" + System.currentTimeMillis();
                                } else {
                                    request = response.request();
                                    throwIfVar1IsNull(request, "<this>");
                                    if (request.tag(HugeSyntheticPileOfHelpers.class) != null) {
                                        throw new ClassCastException();
                                    }
                                }
                            }
                        }
                    } else {
                        strAx = dnj.ax((String) StaticHelpers5.l(response.request().url().pathSegments()),
                                TypeDescription.Generic.OfWildcardType.SYMBOL);
                        if (dnj.ak(strAx)) {
                            strAx = "unknown_" + System.currentTimeMillis();
                        } else {
                            request = response.request();
                            throwIfVar1IsNull(request, "<this>");
                            if (request.tag(HugeSyntheticPileOfHelpers.class) != null) {
                                throw new ClassCastException();
                            }
                        }
                    }
                }
                file = new File(absolutePath, strAx);
            } else {
                char c = File.separatorChar;
                int iAm = dnj.am(absolutePath, c, 0, 6);
                if (iAm != -1) {
                    throwIfVar1IsNull(absolutePath.substring(0, iAm), "substring(...)");
                }
                dnj.av(c, absolutePath, absolutePath);
            }
            try {
                if (file.exists()) {
                    Request request4 = response.request();
                    throwIfVar1IsNull(request4, "<this>");
                    if (request4.tag(KotlinHelpers2.class) != null) {
                        throw new ClassCastException();
                    }
                    Request request5 = response.request();
                    throwIfVar1IsNull(request5, "<this>");
                    if (request5.tag(cnb.class) != null) {
                        throw new ClassCastException();
                    }
                }
                Request request6 = response.request();
                throwIfVar1IsNull(request6, "<this>");
                if (request6.tag(cnh.class) != null) {
                    throw new ClassCastException();
                }
                ResponseBody responseBodyBody4 = response.body();
                if (responseBodyBody4 != null && (rmVarSource = responseBodyBody4.source()) != null) {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    cyk cykVarAg = emc.ag(emc.az(file));
                    try {
                        cykVarAg.r(rmVarSource);
                        Util.closeQuietly(rmVarSource);
                        cykVarAg.close();
                        Request request7 = response.request();
                        throwIfVar1IsNull(request7, "<this>");
                        if (request7.tag(cnh.class) == null) {
                            return file;
                        }
                        throw new ClassCastException();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            cnh.m(cykVarAg, th);
                            throw th2;
                        }
                    }
                }
            } catch (SocketException e) {
                Request request8 = response.request();
                throwIfVar1IsNull(request8, "<this>");
                if (request8.tag(cnh.class) != null) {
                    throw new ClassCastException();
                }
                CancellationException cancellationException = new CancellationException(e.toString());
                cancellationException.initCause(e);
                throw cancellationException;
            } catch (Exception e2) {
                throw new DownloadFileException(response, null, e2, null, 10, null);
            }
        }
        return null;
    }
}
