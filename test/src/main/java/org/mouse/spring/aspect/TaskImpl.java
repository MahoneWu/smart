package org.mouse.spring.aspect;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Created by Mahone Wu on 2017/12/14.
 */
@Service("task")
@Scope("prototype")
public class TaskImpl implements ITask {
    @Override
    public void task() {
        System.out.println("--->task()");
    }
}
