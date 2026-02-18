package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class DataBaseOperation {
    private static final String a = "VMS_SDK_DB";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "content://com.vivo.abe.exidentifier/guid";
    private static final String d = "value";
    private static final String e = "OAID";
    private static final String f = "AAID";
    private static final String g = "VAID";
    private static final String h = "OAIDBLACK";
    private static final String i = "OAIDSTATUS";
    private static final String j = "STATISTICS";
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = 4;
    private static final int p = 5;
    private static final int q = 6;
    private static final int r = 7;
    private static final String s = "UDID";
    private Context t;

    public DataBaseOperation(Context context) {
        this.t = context;
    }

    public boolean a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        int iBulkInsert;
        if (i2 == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i2 != 7) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iBulkInsert = this.t.getContentResolver().bulkInsert(uri, contentValuesArr);
            Log.d(a, "insert:" + iBulkInsert);
        } catch (Exception unused) {
            Log.e(a, "return insert is error");
        }
        return iBulkInsert != 0;
    }

    /* JADX WARN: Found duplicated region for block: B:103:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:105:? A[SYNTHETIC] */
    /* JADX WARN: Found duplicated region for block: B:76:0x0067 A[RETURN] */
    /* JADX WARN: Found duplicated region for block: B:79:0x0078 A[Catch: all -> 0x0089, Exception -> 0x009c, TRY_ENTER, TryCatch #0 {Exception -> 0x009c, blocks: (B:79:0x0078, B:81:0x007e, B:84:0x008d), top: B:99:0x0076 }] */
    /* JADX WARN: Found duplicated region for block: B:81:0x007e A[Catch: all -> 0x0089, Exception -> 0x009c, TryCatch #0 {Exception -> 0x009c, blocks: (B:79:0x0078, B:81:0x007e, B:84:0x008d), top: B:99:0x0076 }] */
    /* JADX WARN: Found duplicated region for block: B:84:0x008d A[Catch: all -> 0x0089, Exception -> 0x009c, TRY_LEAVE, TryCatch #0 {Exception -> 0x009c, blocks: (B:79:0x0078, B:81:0x007e, B:84:0x008d), top: B:99:0x0076 }] */
    /* JADX WARN: Found duplicated region for block: B:86:0x0094  */
    /* JADX WARN: Found duplicated region for block: B:96:0x00a9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v9, types: [android.database.Cursor] */
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
    public String a(int i2, String str) {
        Uri uri;
        Uri uri2;
        ?? Query;
        Throwable th;
        ?? r1 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        if (i2 == 0) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i2 == 3) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
        } else {
            if (i2 != 4) {
                if (i2 != 5) {
                    uri2 = null;
                    Query = i2;
                } else {
                    uri = Uri.parse(c);
                }
                if (uri2 == null) {
                    return null;
                }
                try {
                    Query = this.t.getContentResolver().query(uri2, null, null, null, null);
                    try {
                        if (Query != 0) {
                            Log.d(a, "return cursor is null,return");
                        } else if (Query.moveToNext()) {
                            string = Query.getString(Query.getColumnIndex(d));
                        }
                        if (Query != 0) {
                            Query.close();
                        }
                        return string;
                    } catch (Exception unused) {
                        Log.e(a, "return cursor is error");
                        if (Query != 0) {
                            Query.close();
                        }
                        return string;
                    }
                } catch (Exception unused2) {
                    Query = 0;
                } catch (Throwable th2) {
                    th = th2;
                }
                if (r1 != 0) {
                    r1.close();
                    throw th;
                }
                throw th;
            }
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
        }
        uri2 = uri;
        Query = uri;
        try {
            if (uri2 == null) {
                return null;
            }
            Query = this.t.getContentResolver().query(uri2, null, null, null, null);
            if (Query != 0) {
                Log.d(a, "return cursor is null,return");
            } else if (Query.moveToNext()) {
                string = Query.getString(Query.getColumnIndex(d));
            }
            if (Query != 0) {
                Query.close();
            }
            return string;
        } catch (Throwable th3) {
            th = th3;
            r1 = Query;
        }
        if (r1 != 0) {
            r1.close();
            throw th;
        }
        throw th;
    }

    public boolean a(int i2, String str, String str2, String str3) {
        Uri uri;
        int iDelete;
        if (i2 != 6) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iDelete = this.t.getContentResolver().delete(uri, "packageName=? and uid=?", new String[]{str2, str3});
            Log.d(a, "delete:" + iDelete);
        } catch (Exception unused) {
            Log.e(a, "return delete is error");
        }
        return iDelete != 0;
    }
}
