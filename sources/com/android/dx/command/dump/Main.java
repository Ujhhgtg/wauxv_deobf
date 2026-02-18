package com.android.dx.command.dump;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.util.HexParser;
import java.io.File;
import java.io.UnsupportedEncodingException;
import me.hd.wauxv.obf.bhv;
import net.bytebuddy.dynamic.ClassFileLocator;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class Main {
    private final Args parsedArgs = new Args();

    private Main() {
    }

    public static void main(String[] strArr) {
        new Main().run(strArr);
    }

    private void processOne(String str, byte[] bArr) {
        Args args = this.parsedArgs;
        if (args.dotDump) {
            DotDumper.dump(bArr, str, args);
            return;
        }
        if (args.basicBlocks) {
            BlockDumper.dump(bArr, System.out, str, false, args);
            return;
        }
        if (args.ropBlocks) {
            BlockDumper.dump(bArr, System.out, str, true, args);
        } else if (!args.ssaBlocks) {
            ClassDumper.dump(bArr, System.out, str, args);
        } else {
            args.optimize = false;
            SsaDumper.dump(bArr, System.out, str, args);
        }
    }

    private void run(String[] strArr) {
        int i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            if (str.equals("--") || !str.startsWith("--")) {
                break;
            }
            if (str.equals("--bytes")) {
                this.parsedArgs.rawBytes = true;
            } else if (str.equals("--basic-blocks")) {
                this.parsedArgs.basicBlocks = true;
            } else if (str.equals("--rop-blocks")) {
                this.parsedArgs.ropBlocks = true;
            } else if (str.equals("--optimize")) {
                this.parsedArgs.optimize = true;
            } else if (str.equals("--ssa-blocks")) {
                this.parsedArgs.ssaBlocks = true;
            } else if (str.startsWith("--ssa-step=")) {
                this.parsedArgs.ssaStep = str.substring(str.indexOf(61) + 1);
            } else if (str.equals("--debug")) {
                this.parsedArgs.debug = true;
            } else if (str.equals("--dot")) {
                this.parsedArgs.dotDump = true;
            } else if (str.equals("--strict")) {
                this.parsedArgs.strictParse = true;
            } else if (str.startsWith("--width=")) {
                this.parsedArgs.width = Integer.parseInt(str.substring(str.indexOf(61) + 1));
            } else {
                if (!str.startsWith("--method=")) {
                    System.err.println("unknown option: ".concat(str));
                    throw new RuntimeException("usage");
                }
                this.parsedArgs.method = str.substring(str.indexOf(61) + 1);
            }
            i++;
        }
        if (i == strArr.length) {
            System.err.println("no input files specified");
            throw new RuntimeException("usage");
        }
        while (i < strArr.length) {
            try {
                String str2 = strArr[i];
                System.out.println("reading " + str2 + "...");
                byte[] bArrAf = bhv.af(new File(str2));
                if (!str2.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION)) {
                    try {
                        bArrAf = HexParser.parse(new String(bArrAf, "utf-8"));
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException("shouldn't happen", e);
                    }
                }
                processOne(str2, bArrAf);
            } catch (ParseException e2) {
                System.err.println("\ntrouble parsing:");
                if (this.parsedArgs.debug) {
                    e2.printStackTrace();
                } else {
                    e2.printContext(System.err);
                }
            }
            i++;
        }
    }
}
