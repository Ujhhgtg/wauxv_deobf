package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import me.hd.wauxv.obf.akd;
import me.hd.wauxv.obf.bzo;
import okhttp3.Protocol;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            bzo.q(list, "protocols");
            this.protocols = list;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            bzo.q(obj, "proxy");
            bzo.q(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (bzo.f(name, "supports") && bzo.f(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (bzo.f(name, "unsupported") && bzo.f(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (bzo.f(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((bzo.f(name, "selectProtocol") || bzo.f(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    bzo.o(obj2, "null cannot be cast to non-null type kotlin.collections.List<*>");
                    List list = (List) obj2;
                    int size = list.size();
                    if (size >= 0) {
                        int i = 0;
                        while (true) {
                            Object obj3 = list.get(i);
                            bzo.o(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj3;
                            if (this.protocols.contains(str)) {
                                this.selected = str;
                                return str;
                            }
                            if (i != size) {
                                i++;
                            }
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!bzo.f(name, "protocolSelected") && !bzo.f(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            bzo.o(obj4, "null cannot be cast to non-null type kotlin.String");
            this.selected = (String) obj4;
            return null;
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public static final class Companion {
        public /* synthetic */ Companion(akd akdVar) {
            this();
        }

        public final Platform buildIfSupported() {
            String property = System.getProperty("java.specification.version", "unknown");
            try {
                bzo.p(property, "jvmVersion");
                return null;
            } catch (NumberFormatException unused) {
            }
            if (Integer.parseInt(property) < 9) {
                try {
                    Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                    Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                    Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                    Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                    Method method = cls.getMethod("put", SSLSocket.class, cls2);
                    Method method2 = cls.getMethod("get", SSLSocket.class);
                    Method method3 = cls.getMethod("remove", SSLSocket.class);
                    bzo.p(method, "putMethod");
                    bzo.p(method2, "getMethod");
                    bzo.p(method3, "removeMethod");
                    bzo.p(cls3, "clientProviderClass");
                    bzo.p(cls4, "serverProviderClass");
                    return new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
                } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                }
            }
        }

        private Companion() {
        }
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        bzo.q(method, "putMethod");
        bzo.q(method2, "getMethod");
        bzo.q(method3, "removeMethod");
        bzo.q(cls, "clientProviderClass");
        bzo.q(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sSLSocket) {
        bzo.q(sSLSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        bzo.q(sSLSocket, "sslSocket");
        bzo.q(list, "protocols");
        try {
            this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(list))));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        bzo.q(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
            bzo.o(invocationHandler, "null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (alpnProvider.getUnsupported()) {
                return null;
            }
            return alpnProvider.getSelected();
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
