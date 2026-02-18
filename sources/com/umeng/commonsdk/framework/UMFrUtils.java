package com.umeng.commonsdk.framework;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Comparator;
import me.hd.wauxv.obf.yg;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class UMFrUtils {
    private static final String KEY_LAST_INSTANT_SUCC_BUILD_TIME = "last_instant_build_time";
    private static final String KEY_LAST_SUCC_BUILD_TIME = "last_successful_build_time";
    private static Object mEnvelopeBuildTimeLock = new Object();
    private static String mDefaultEnvelopeDir = bd.b().b(bd.a);
    private static String mDefaultEnvelopeDirPath = null;
    private static Object mEnvelopeFileLock = new Object();
    private static String sCurrentProcessName = "";

    private static boolean checkPermission(Context context, String str) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
            } catch (Throwable th) {
                UMCrashManager.reportCrash(applicationContext, th);
            }
        }
        return false;
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static int envelopeFileNumber(Context context) {
        String[] list;
        if (context != null) {
            try {
                File file = new File(getEnvelopeDirPath(context));
                synchronized (mEnvelopeFileLock) {
                    try {
                        if (file.isDirectory() && (list = file.list()) != null) {
                            return list.length;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        if (TextUtils.isEmpty(sCurrentProcessName)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    String processName2 = getProcessName(Process.myPid());
                    if (!TextUtils.isEmpty(processName2)) {
                        sCurrentProcessName = processName2;
                    }
                } else {
                    sCurrentProcessName = processName;
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context.getApplicationContext(), th);
            }
        }
        return sCurrentProcessName;
    }

    private static long getDistanceDays(long j, long j2) {
        return (j < j2 ? j2 - j : j - j2) / 86400000;
    }

    public static String getEnvelopeDirPath(Context context) {
        String str;
        synchronized (mEnvelopeFileLock) {
            try {
                if (mDefaultEnvelopeDirPath == null) {
                    mDefaultEnvelopeDirPath = context.getFilesDir().getAbsolutePath() + File.separator + "." + mDefaultEnvelopeDir;
                }
                File file = new File(mDefaultEnvelopeDirPath);
                if (!file.exists() && !file.mkdir()) {
                    ULog.d("--->>> Create Envelope Directory failed!!!");
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
            str = mDefaultEnvelopeDirPath;
        }
        return str;
    }

    public static File getEnvelopeFile(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.2
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file2, File file3) {
                            long jLastModified = file2.lastModified() - file3.lastModified();
                            if (jLastModified > 0) {
                                return 1;
                            }
                            return jLastModified == 0 ? 0 : -1;
                        }
                    });
                    return fileArrListFiles[0];
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        long j;
        synchronized (mEnvelopeBuildTimeLock) {
            j = PreferenceWrapper.getDefault(context).getLong(KEY_LAST_SUCC_BUILD_TIME, 0L);
        }
        return j;
    }

    public static String getLegacyEnvelopeDir(Context context) {
        try {
            String currentProcessName = getCurrentProcessName(context);
            if (!TextUtils.isEmpty(currentProcessName)) {
                String strB = bd.b().b(bd.B);
                String strReplace = currentProcessName.replace(':', '_');
                ULog.d("--->>> getEnvelopeDir: use current process name as envelope directory.");
                return strB + strReplace;
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return mDefaultEnvelopeDir;
    }

    private static String getProcessName(int i) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            String line = bufferedReader.readLine();
            if (!TextUtils.isEmpty(line)) {
                line = line.trim();
            }
            try {
                bufferedReader.close();
            } catch (Throwable unused2) {
            }
            return line;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return null;
        }
    }

    public static String getSubProcessName(Context context) {
        String strSubstring;
        strSubstring = "";
        try {
            String currentProcessName = getCurrentProcessName(context);
            int iIndexOf = currentProcessName.indexOf(":");
            strSubstring = iIndexOf >= 0 ? currentProcessName.substring(iIndexOf + 1) : "";
            if (iIndexOf >= 0) {
                return strSubstring;
            }
            String packageName = context.getPackageName();
            return currentProcessName.length() > packageName.length() ? currentProcessName.substring(packageName.length() + 1, currentProcessName.length()) : currentProcessName;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return strSubstring;
        }
    }

    public static boolean hasEnvelopeFile(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        File[] fileArrListFiles;
        String str = bt.at;
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_INTERNAL) {
            str = bt.aA;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_ZeroEnv) {
            str = bt.aB;
        }
        if (uMBusinessType == UMLogDataProtocol.UMBusinessType.U_Silent) {
            str = bt.aE;
        }
        String envelopeDirPath = getEnvelopeDirPath(context);
        if (envelopeDirPath == null) {
            return false;
        }
        File file = new File(envelopeDirPath);
        synchronized (mEnvelopeFileLock) {
            try {
                try {
                    fileArrListFiles = file.listFiles();
                    return false;
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    for (File file2 : fileArrListFiles) {
                        if (file2.getName().startsWith(str)) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isConnectedOrConnecting();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context.getApplicationContext(), th);
            return false;
        }
    }

    public static boolean removeEnvelopeFile(File file) {
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            try {
                if (file != null) {
                    try {
                        if (file.exists()) {
                            return file.delete();
                        }
                    } catch (Throwable th) {
                        UMCrashManager.reportCrash(appContext, th);
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException
    	at java.base/java.util.Objects.requireNonNull(Objects.java:209)
    	at java.base/java.util.ArrayList.batchRemove(ArrayList.java:816)
    	at java.base/java.util.ArrayList.removeAll(ArrayList.java:791)
    	at jadx.core.dex.visitors.finaly.TryCatchEdgeBlockMap.getAllInScope(TryCatchEdgeBlockMap.java:91)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:204)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static void removeRedundantEnvelopeFiles(Context context, int i) {
        File file = new File(getEnvelopeDirPath(context));
        synchronized (mEnvelopeFileLock) {
            try {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > i) {
                    Arrays.sort(fileArrListFiles, new Comparator<File>() { // from class: com.umeng.commonsdk.framework.UMFrUtils.1
                        @Override // java.util.Comparator
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file2, File file3) {
                            long jLastModified = file2.lastModified() - file3.lastModified();
                            if (jLastModified > 0) {
                                return 1;
                            }
                            return jLastModified == 0 ? 0 : -1;
                        }
                    });
                    if (fileArrListFiles.length > i) {
                        for (int i2 = 0; i2 < fileArrListFiles.length - i; i2++) {
                            try {
                                if (!fileArrListFiles[i2].delete()) {
                                    ULog.d("--->>> remove [" + i2 + "] file fail.");
                                }
                            } catch (Throwable th) {
                                UMCrashManager.reportCrash(context, th);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static int saveEnvelopeFile(Context context, String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        if (bArr == null) {
            return 101;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getEnvelopeDirPath(context));
        File file = new File(yg.o(sb, File.separator, str));
        synchronized (mEnvelopeFileLock) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        throw th;
                    }
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                boolean zA = com.umeng.commonsdk.statistics.internal.a.a(context).a(str);
                boolean zB = com.umeng.commonsdk.statistics.internal.a.a(context).b(str);
                if (zA) {
                    updateLastSuccessfulBuildTime(context);
                }
                if (zB) {
                    updateLastInstantBuildTime(context);
                }
                return 0;
            } catch (IOException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                UMCrashManager.reportCrash(context, e);
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th3) {
                        UMCrashManager.reportCrash(context, th3);
                    }
                }
                return 101;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Throwable th5) {
                        UMCrashManager.reportCrash(context, th5);
                    }
                }
                throw th;
            }
        }
    }

    public static void syncLegacyEnvelopeIfNeeded(Context context) {
        String legacyEnvelopeDir;
        if (context == null) {
            return;
        }
        try {
            legacyEnvelopeDir = getLegacyEnvelopeDir(context);
            return;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        if (!TextUtils.isEmpty(legacyEnvelopeDir) && !legacyEnvelopeDir.equals(mDefaultEnvelopeDir)) {
            File file = new File(context.getFilesDir().getAbsolutePath() + "/." + legacyEnvelopeDir);
            if (file.exists()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                    try {
                        if (file.isDirectory()) {
                            file.delete();
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        UMCrashManager.reportCrash(context, th2);
                        return;
                    }
                }
                try {
                    String envelopeDirPath = getEnvelopeDirPath(context);
                    for (int i = 0; i < fileArrListFiles.length; i++) {
                        fileArrListFiles[i].renameTo(new File(envelopeDirPath + File.separator + fileArrListFiles[i].getName()));
                    }
                    if (file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    return;
                } catch (Throwable th3) {
                    UMCrashManager.reportCrash(context, th3);
                    return;
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    /* JADX WARN: Undo finally extract visitor
    java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.BlockNode.getSuccessors()" because "blk" is null
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.exploreTryPath(TryCatchBlockAttr.java:210)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:196)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getFallthroughTryEdges(TryCatchBlockAttr.java:180)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getTryEdges(TryCatchBlockAttr.java:201)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getEdgeBlockMap(TryCatchBlockAttr.java:347)
    	at jadx.core.dex.trycatch.TryCatchBlockAttr.getExecutionScopeGroups(TryCatchBlockAttr.java:356)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.getTryBlockData(MarkFinallyVisitor.java:202)
    	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:119)
     */
    public static byte[] toByteArray(String str) {
        Throwable th;
        IOException iOException;
        FileChannel channel;
        byte[] bArr;
        Context appContext = UMModuleRegister.getAppContext();
        synchronized (mEnvelopeFileLock) {
            FileChannel fileChannel = null;
            try {
                try {
                    try {
                        channel = new RandomAccessFile(str, "r").getChannel();
                    } catch (IOException e) {
                        iOException = e;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).load();
                    bArr = new byte[(int) channel.size()];
                    if (mappedByteBufferLoad.remaining() > 0) {
                        mappedByteBufferLoad.get(bArr, 0, mappedByteBufferLoad.remaining());
                    }
                    try {
                        channel.close();
                    } catch (Throwable th3) {
                        UMCrashManager.reportCrash(appContext, th3);
                    }
                } catch (IOException e2) {
                    iOException = e2;
                    fileChannel = channel;
                    UMCrashManager.reportCrash(appContext, iOException);
                    throw iOException;
                } catch (Throwable th4) {
                    th = th4;
                    fileChannel = channel;
                    try {
                        fileChannel.close();
                        throw th;
                    } catch (Throwable th5) {
                        UMCrashManager.reportCrash(appContext, th5);
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                throw th6;
            }
        }
        return bArr;
    }

    private static void updateLastInstantBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_INSTANT_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }

    private static void updateLastSuccessfulBuildTime(Context context) {
        synchronized (mEnvelopeBuildTimeLock) {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            sharedPreferences.edit().putLong(KEY_LAST_SUCC_BUILD_TIME, System.currentTimeMillis()).commit();
        }
    }
}
