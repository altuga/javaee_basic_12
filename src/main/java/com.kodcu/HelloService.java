package com.kodcu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.io.Serializable;
import java.util.Date;


@Startup
@Singleton
@Interceptors(MethodCallLogger.class)
public class HelloService implements Serializable  {


    @Resource
    SessionContext sessionContext;

    @PostConstruct
    public void onInit() {
        System.out.println(" Starting Created HelloService(EJB) ");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println(" Destroying EJB HelloService.... ");
    }

    public  String sayHello() {
        return "Hello " + new Date() + "  sessionContext : " + sessionContext.getCallerPrincipal();
    }
}
