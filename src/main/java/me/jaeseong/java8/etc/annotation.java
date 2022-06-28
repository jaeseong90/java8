package me.jaeseong.java8.etc;

import java.util.Arrays;

@IAnnotationEx("hell")
@IAnnotationEx("world")
public class annotation {

    public static void main(String[] args) {
        IAnnotationExContainer iAnnotationExContainer = me.jaeseong.java8.etc.annotation.class.getAnnotation(IAnnotationExContainer.class);
        Arrays.stream(iAnnotationExContainer.value()).forEach(c->System.out.println(c.value()));
    }

}
