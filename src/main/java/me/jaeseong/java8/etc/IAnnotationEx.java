package me.jaeseong.java8.etc;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
@Repeatable(IAnnotationExContainer.class)
public @interface IAnnotationEx {
    String value();
}
