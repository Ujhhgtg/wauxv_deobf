package com.umeng.commonsdk.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public class FileLockUtil {
    private final Object lockObject = new Object();

    /* JADX WARN: Found duplicated region for block: B:22:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static FileLock getFileLock(String str) {
        FileChannel channel;
        try {
            channel = new RandomAccessFile(str, "rw").getChannel();
        } catch (FileNotFoundException e) {
            e = e;
            channel = null;
        } catch (IOException e2) {
            e = e2;
            channel = null;
        }
        try {
            return channel.lock();
        } catch (FileNotFoundException e3) {
            e = e3;
            e.printStackTrace();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            return null;
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            if (channel != null) {
                channel.close();
            }
            return null;
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, Object obj) {
        FileChannel fileChannelChannel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName(), obj);
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            } catch (Exception e) {
                                e.printStackTrace();
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            }
                            fileChannelChannel.close();
                        } catch (Throwable th) {
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback, int i) {
        FileChannel fileChannelChannel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file, i);
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            } catch (Exception e) {
                                e.printStackTrace();
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            }
                            fileChannelChannel.close();
                        } catch (Throwable th) {
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(File file, FileLockCallback fileLockCallback) {
        FileChannel fileChannelChannel;
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(file.getAbsolutePath());
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName());
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            } catch (Exception e) {
                                e.printStackTrace();
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            }
                            fileChannelChannel.close();
                        } catch (Throwable th) {
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public void doFileOperateion(String str, FileLockCallback fileLockCallback) {
        FileChannel fileChannelChannel;
        File file = new File(str);
        if (file.exists()) {
            synchronized (this.lockObject) {
                FileLock fileLock = getFileLock(str);
                try {
                    if (fileLock != null) {
                        try {
                            try {
                                fileLockCallback.onFileLock(file.getName());
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            } catch (Exception e) {
                                e.printStackTrace();
                                fileLock.release();
                                fileChannelChannel = fileLock.channel();
                            }
                            fileChannelChannel.close();
                        } catch (Throwable th) {
                            try {
                                fileLock.release();
                                fileLock.channel().close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            throw th;
                        }
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
}
