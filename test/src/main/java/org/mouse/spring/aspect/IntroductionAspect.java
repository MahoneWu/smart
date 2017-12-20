package org.mouse.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * Created by Mahone Wu on 2017/12/14.
 */
@Component
@Aspect
public class IntroductionAspect {

    @DeclareParents(value = "org.mouse.spring.aspect.TaskImpl",defaultImpl = CounterImpl.class)
    public ICounter counter;
}
