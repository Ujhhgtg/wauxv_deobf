package me.hd.wauxv.obf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bmq {
    public static final HashMap a;
    public static final Pattern b;

    static {
        BufferedReader bufferedReader;
        HashMap map = new HashMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(bmq.class.getResourceAsStream("/org/commonmark/internal/util/entities.properties"), Charset.forName("UTF-8")));
        } catch (IOException e) {
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    map.put("NewLine", "\n");
                    a = map;
                    b = Pattern.compile("^&#[Xx]?");
                    return;
                }
                if (line.length() != 0) {
                    int iIndexOf = line.indexOf("=");
                    map.put(line.substring(0, iIndexOf), line.substring(iIndexOf + 1));
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
            throw new IllegalStateException("Failed reading data for HTML named character references", e);
        }
    }

    public static String c(String str) {
        Matcher matcher = b.matcher(str);
        if (!matcher.find()) {
            String str2 = (String) a.get(yg.j(str, 1, 1));
            return str2 != null ? str2 : str;
        }
        try {
            int i = Integer.parseInt(str.substring(matcher.end(), str.length() - 1), matcher.end() == 2 ? 10 : 16);
            return i == 0 ? "�" : new String(Character.toChars(i));
        } catch (IllegalArgumentException unused) {
            return "�";
        }
    }
}
