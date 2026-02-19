package bsh.commands;

import bsh.CallStack;
import bsh.Interpreter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import me.hd.wauxv.obf.StaticHelpers6;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class dir {
    static final String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void invoke(Interpreter interpreter, CallStack callStack) {
        invoke(interpreter, callStack, ".");
    }

    public static String usage() {
        return "usage: dir( String dir )\n       dir()";
    }

    public static void invoke(Interpreter interpreter, CallStack callStack, String str) {
        try {
            String absolutePath = interpreter.pathToFile(str).getAbsolutePath();
            File filePathToFile = interpreter.pathToFile(str);
            if (filePathToFile.exists() && filePathToFile.canRead()) {
                if (!filePathToFile.isDirectory()) {
                    interpreter.println("'" + str + "' is not a directory");
                }
                String[] list = filePathToFile.list();
                if (list == null) {
                    list = new String[0];
                }
                Arrays.sort(list);
                for (String str2 : list) {
                    StringBuilder sbY = StaticHelpers6.toSb(absolutePath);
                    sbY.append(File.separator);
                    sbY.append(str2);
                    File file = new File(sbY.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(file.canRead() ? "r" : "-");
                    sb.append(file.canWrite() ? "w" : "-");
                    sb.append("_ ");
                    Date date = new Date(file.lastModified());
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(date);
                    int i = gregorianCalendar.get(5);
                    sb.append(months[gregorianCalendar.get(2)] + " " + i);
                    if (i < 10) {
                        sb.append(" ");
                    }
                    sb.append(" ");
                    StringBuilder sb2 = new StringBuilder();
                    for (int i2 = 0; i2 < 8; i2++) {
                        sb2.append(" ");
                    }
                    sb2.insert(0, file.length());
                    sb2.setLength(8);
                    int iIndexOf = sb2.toString().indexOf(" ");
                    if (iIndexOf != -1) {
                        String strSubstring = sb2.toString().substring(iIndexOf);
                        sb2.setLength(iIndexOf);
                        sb2.insert(0, strSubstring);
                    }
                    sb.append(sb2.toString());
                    sb.append(" " + file.getName());
                    if (file.isDirectory()) {
                        sb.append("/");
                    }
                    interpreter.println(sb.toString());
                }
                return;
            }
            interpreter.println("Can't read " + filePathToFile);
        } catch (IOException e) {
            interpreter.println("error reading path: " + e);
        }
    }
}
