package com.kodcu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Date;

@Stateless
@Interceptors(MethodCallLogger.class)
public class HelloService {


    @PostConstruct
    public void onInit() {
        System.out.println(" Created HelloService(EJB) ");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println(" Destroying EJB HelloService.... ");
    }

    public  String sayHello() {
        return "Hello " + new Date();
    }
}
