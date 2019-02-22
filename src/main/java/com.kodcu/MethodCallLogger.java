package com.kodcu;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

public class MethodCallLogger {

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception{

        Method method = ic.getMethod();
        Object[] objects = ic.getParameters();
        if (objects != null) {
            for (int i = 0; i < objects.length; i++) {
                Object object = objects[i];
                System.out.println(object);
            }
        }

        System.out.println(" ic.getTarget() : " + ic.getTarget());

        long start = System.nanoTime();
        try {
            return ic.proceed();
        } finally {
            System.out.println(" Method " + method + " invoked in " + (System.nanoTime()- start) + " sec");
        }
    }
}
