package net.bytebuddy.implementation.attribute;

import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
/* JADX INFO: loaded from: classes.dex */
public interface AnnotationValueFilter {

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public enum Default implements AnnotationValueFilter, Factory {
        SKIP_DEFAULTS { // from class: net.bytebuddy.implementation.attribute.AnnotationValueFilter.Default.1
            @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape) {
                AnnotationValue<?, ?> defaultValue = inDefinedShape.getDefaultValue();
                return defaultValue == null || !defaultValue.equals(annotationDescription.getValue(inDefinedShape));
            }
        },
        APPEND_DEFAULTS { // from class: net.bytebuddy.implementation.attribute.AnnotationValueFilter.Default.2
            @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter
            public boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape) {
                return true;
            }
        };

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        public AnnotationValueFilter on(FieldDescription fieldDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        public AnnotationValueFilter on(MethodDescription methodDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        public AnnotationValueFilter on(RecordComponentDescription recordComponentDescription) {
            return this;
        }

        @Override // net.bytebuddy.implementation.attribute.AnnotationValueFilter.Factory
        public AnnotationValueFilter on(TypeDescription typeDescription) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-b9de5da7d0413052737328a4e696e1bcc3145db8f6a41e1e318485e124198cd6 */
    public interface Factory {
        AnnotationValueFilter on(FieldDescription fieldDescription);

        AnnotationValueFilter on(MethodDescription methodDescription);

        AnnotationValueFilter on(RecordComponentDescription recordComponentDescription);

        AnnotationValueFilter on(TypeDescription typeDescription);
    }

    boolean isRelevant(AnnotationDescription annotationDescription, MethodDescription.InDefinedShape inDefinedShape);
}
