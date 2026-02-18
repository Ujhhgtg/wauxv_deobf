package me.hd.wauxv.obf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bxv {
    public static volatile int a;
    public static final cih b = new cih(1);
    public static final cih c = new cih(0);
    public static volatile cih d;
    public static final String[] e;

    static {
        String property;
        try {
            property = System.getProperty("slf4j.detectLoggerNameMismatch");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null) {
            property.equalsIgnoreCase("true");
        }
        e = new String[] { "2.0" };
    }

    public static ArrayList f() {
        ArrayList arrayList = new ArrayList();
        final ClassLoader classLoader = bxv.class.getClassLoader();
        String property = System.getProperty("slf4j.provider");
        cih cihVar = null;
        if (property != null && !property.isEmpty()) {
            try {
                String str = "Attempting to load provider \"" + property
                        + "\" specified via \"slf4j.provider\" system property";
                int i = dbr.a;
                if (dkz.ae(2) >= dkz.ae(dbr.b)) {
                    dbr.d().println("SLF4J(I): " + str);
                }
                cihVar = (cih) classLoader.loadClass(property).getConstructor(null).newInstance(null);
            } catch (ClassCastException e2) {
                dbr.c("Specified SLF4JServiceProvider (" + property
                        + ") does not implement SLF4JServiceProvider interface", e2);
            } catch (ClassNotFoundException e3) {
                e = e3;
                dbr.createInstanceWithArgs(
                        "Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (IllegalAccessException e4) {
                e = e4;
                dbr.createInstanceWithArgs(
                        "Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InstantiationException e5) {
                e = e5;
                dbr.createInstanceWithArgs(
                        "Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (NoSuchMethodException e6) {
                e = e6;
                dbr.createInstanceWithArgs(
                        "Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            } catch (InvocationTargetException e7) {
                e = e7;
                dbr.createInstanceWithArgs(
                        "Failed to instantiate the specified SLF4JServiceProvider (" + property + ")", e);
            }
        }
        if (cihVar != null) {
            arrayList.add(cihVar);
            return arrayList;
        }
        Iterator it = (System.getSecurityManager() == null ? ServiceLoader.load(cih.class, classLoader)
                : (ServiceLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class:
                                                                                         // me.hd.wauxv.obf.bxu
                    @Override // java.security.PrivilegedAction
                    public final Object run() {
                        return ServiceLoader.load(cih.class, classLoader);
                    }
                })).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add((cih) it.next());
            } catch (ServiceConfigurationError e8) {
                String str2 = "A service provider failed to instantiate:\n" + e8.getMessage();
                dbr.d().println("SLF4J(E): " + str2);
            }
        }
        return arrayList;
    }

    public static bxs g() {
        cih cihVar;
        bno bnoVar;
        if (a == 0) {
            synchronized (bxv.class) {
                try {
                    if (a == 0) {
                        a = 1;
                        h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        int i = a;
        if (i == 1) {
            cihVar = b;
        } else {
            if (i == 2) {
                throw new IllegalStateException(
                        "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also https://www.slf4j.org/codes.html#unsuccessfulInit");
            }
            if (i == 3) {
                cihVar = d;
            } else {
                if (i != 4) {
                    throw new IllegalStateException("Unreachable code");
                }
                cihVar = c;
            }
        }
        switch (cihVar.a) {
            case 0:
                bnoVar = (cbm) cihVar.b;
                break;
            default:
                bnoVar = (dny) cihVar.b;
                break;
        }
        return bnoVar.d();
    }

    public static final void h() {
        try {
            ArrayList arrayListF = f();
            l(arrayListF);
            if (arrayListF.isEmpty()) {
                a = 4;
                dbr.e("No SLF4J providers were found.");
                dbr.e("Defaulting to no-operation (NOP) logger implementation");
                dbr.e("See https://www.slf4j.org/codes.html#noProviders for further details.");
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                try {
                    ClassLoader classLoader = bxv.class.getClassLoader();
                    Enumeration<URL> systemResources = classLoader == null
                            ? ClassLoader.getSystemResources("org/slf4j/impl/StaticLoggerBinder.class")
                            : classLoader.getResources("org/slf4j/impl/StaticLoggerBinder.class");
                    while (systemResources.hasMoreElements()) {
                        linkedHashSet.add(systemResources.nextElement());
                    }
                } catch (IOException e2) {
                    dbr.c("Error getting resources from path", e2);
                }
                k(linkedHashSet);
            } else {
                d = (cih) arrayListF.get(0);
                d.getClass();
                d.getClass();
                a = 3;
                j(arrayListF);
            }
            i();
            if (a == 3) {
                try {
                    switch (d.a) {
                        case 0:
                            boolean z = false;
                            for (String str : e) {
                                if ("2.0.99".startsWith(str)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                return;
                            }
                            dbr.e("The requested version 2.0.99 by your slf4j provider is not compatible with "
                                    + Arrays.asList(e).toString());
                            dbr.e("See https://www.slf4j.org/codes.html#version_mismatch for further details.");
                            return;
                        default:
                            throw new UnsupportedOperationException();
                    }
                } catch (Throwable th) {
                    dbr.c("Unexpected problem occurred during version sanity check", th);
                }
            }
        } catch (Exception e3) {
            a = 2;
            dbr.c("Failed to instantiate SLF4J LoggerFactory", e3);
            throw new IllegalStateException("Unexpected initialization failure", e3);
        }
    }

    public static void i() {
        cih cihVar = b;
        synchronized (cihVar) {
            try {
                ((dny) cihVar.b).a = true;
                dny dnyVar = (dny) cihVar.b;
                dnyVar.getClass();
                for (dnx dnxVar : new ArrayList(dnyVar.b.values())) {
                    dnxVar.getClass();
                    dnxVar.a = g();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        LinkedBlockingQueue linkedBlockingQueue = ((dny) b.b).c;
        int size = linkedBlockingQueue.size();
        ArrayList<dnz> arrayList = new ArrayList(128);
        int i = 0;
        while (linkedBlockingQueue.drainTo(arrayList, 128) != 0) {
            for (dnz dnzVar : arrayList) {
                if (dnzVar != null) {
                    dnx dnxVar2 = dnzVar.b;
                    dnxVar2.getClass();
                    if (dnxVar2.a == null) {
                        throw new IllegalStateException("Delegate logger cannot be null at this state.");
                    }
                    if (!(dnxVar2.a instanceof cig)) {
                        if (!dnxVar2.j()) {
                            dbr.e("KavaRef");
                        } else if (dnxVar2.e(dnzVar.a) && dnxVar2.j()) {
                            try {
                                dnxVar2.d.invoke(dnxVar2.a, dnzVar);
                            } catch (IllegalAccessException | IllegalArgumentException
                                    | InvocationTargetException unused) {
                            }
                        }
                    }
                }
                int i2 = i + 1;
                if (i == 0) {
                    if (dnzVar.b.j()) {
                        dbr.e("A number (" + size
                                + ") of logging calls during the initialization phase have been intercepted and are");
                        dbr.e("now being replayed. These are subject to the filtering rules of the underlying logging system.");
                        dbr.e("See also https://www.slf4j.org/codes.html#replay");
                    } else if (!(dnzVar.b.a instanceof cig)) {
                        dbr.e("The following set of substitute loggers may have been accessed");
                        dbr.e("during the initialization phase. Logging calls during this");
                        dbr.e("phase were not honored. However, subsequent logging calls to these");
                        dbr.e("loggers will work as normally expected.");
                        dbr.e("See also https://www.slf4j.org/codes.html#substituteLogger");
                    }
                }
                i = i2;
            }
            arrayList.clear();
        }
        dny dnyVar2 = (dny) b.b;
        dnyVar2.b.clear();
        dnyVar2.c.clear();
    }

    public static void j(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalStateException(
                    "No providers were found which is impossible after successful initialization.");
        }
        if (arrayList.size() > 1) {
            String str = "Actual provider is of type [" + arrayList.get(0) + "]";
            int i = dbr.a;
            if (dkz.ae(2) >= dkz.ae(dbr.b)) {
                dbr.d().println("SLF4J(I): " + str);
                return;
            }
            return;
        }
        String str2 = "Connected with provider of type [" + ((cih) arrayList.get(0)).getClass().getName() + "]";
        int i2 = dbr.a;
        if (dkz.ae(1) >= dkz.ae(dbr.b)) {
            dbr.d().println("SLF4J(D): " + str2);
        }
    }

    public static void k(LinkedHashSet linkedHashSet) {
        if (linkedHashSet.isEmpty()) {
            return;
        }
        dbr.e("Class path contains SLF4J bindings targeting slf4j-api versions 1.7.x or earlier.");
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            dbr.e("Ignoring binding found at [" + ((URL) it.next()) + "]");
        }
        dbr.e("See https://www.slf4j.org/codes.html#ignoredBindings for an explanation.");
    }

    public static void l(ArrayList arrayList) {
        if (arrayList.size() > 1) {
            dbr.e("Class path contains multiple SLF4J providers.");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                dbr.e("Found provider [" + ((cih) it.next()) + "]");
            }
            dbr.e("See https://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }
}
