package net.bytebuddy.dynamic;

import net.bytebuddy.description.method.MethodDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface VisibilityBridgeStrategy {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Default implements VisibilityBridgeStrategy {
        ALWAYS { // from class: net.bytebuddy.dynamic.VisibilityBridgeStrategy.Default.1
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return true;
            }
        },
        ON_NON_GENERIC_METHOD { // from class: net.bytebuddy.dynamic.VisibilityBridgeStrategy.Default.2
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return !methodDescription.isGenerified();
            }
        },
        NEVER { // from class: net.bytebuddy.dynamic.VisibilityBridgeStrategy.Default.3
            @Override // net.bytebuddy.dynamic.VisibilityBridgeStrategy
            public boolean generateVisibilityBridge(MethodDescription methodDescription) {
                return false;
            }
        }
    }

    boolean generateVisibilityBridge(MethodDescription methodDescription);
}
