package com.kodcu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.xml.registry.infomodel.User;

@Model
public class Index {

    @Inject
    HelloService helloService;

    @Inject
    EmptyDelegate emptyDelegate;

    @Inject
    GlobalCounter globalCounter;

    @Inject
    UserCounter userCounter;


    @PostConstruct
    public void onInit() {
        System.out.println(" Created Index ");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println(" Destroying Index.... ");
    }

    public String getMessage() {
        return  helloService.sayHello() + " - hashcode : " + this.hashCode() + " " + this.toString();
    }

    public int getGlobalCounter() {
        emptyDelegate.getGc().increase();
        return emptyDelegate.getGc().getValue();
    }

    public int getUserCounter() {
        emptyDelegate.getUc().increase();
        return emptyDelegate.getUc().getValue();
    }

}
