package bsh.util;

import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DataUtil {
    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static String getFileMD5(String str) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        byte[] bArr;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                messageDigest = MessageDigest.getInstance("MD5");
                bArr = new byte[8192];
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Exception unused) {
            return null;
        }
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                String strBytesToHex = bytesToHex(messageDigest.digest());
                fileInputStream.close();
                return strBytesToHex;
            }
            messageDigest.update(bArr, 0, i);
            return null;
        }
    }
}
