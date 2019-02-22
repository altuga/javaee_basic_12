package com.kodcu;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Index {

    @Inject
    HelloService helloService;



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
        globalCounter.increase();
        return globalCounter.getValue();
    }

    public int getUserCounter() {
        userCounter.increase();
        return userCounter.getValue();
    }

}
