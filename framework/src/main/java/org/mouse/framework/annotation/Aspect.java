package org.mouse.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Mahone Wu on 2017/9/13.
 * 切面注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();

}
