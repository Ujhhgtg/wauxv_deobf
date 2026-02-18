package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import me.hd.wauxv.obf.bzo;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        bzo.q(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        bzo.q(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        bzo.q(route, "route");
        return this.failedRoutes.contains(route);
    }
}
