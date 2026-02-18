package com.umeng.commonsdk.internal.utils;

import android.os.Build;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum a {
        check_su_binary(new String[]{"/system/xbin/which", "su"});

        String[] b;

        a(String[] strArr) {
            this.b = strArr;
        }
    }

    public ArrayList a(a aVar) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                Process processExec = Runtime.getRuntime().exec(aVar.b);
                new BufferedWriter(new OutputStreamWriter(processExec.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        arrayList.add(line);
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return arrayList;
    }
}
