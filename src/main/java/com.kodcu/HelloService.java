package com.kodcu;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Date;

@Stateless
@Interceptors(MethodCallLogger.class)
public class HelloService {

    public  String sayHello() {
        return "Hello " + new Date();
    }
}
