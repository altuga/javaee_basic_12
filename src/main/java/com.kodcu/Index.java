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
    NakedObject nakedObject;

    @Inject
    VeryBigBrother veryBigBrother;

    @PostConstruct
    public void onInit() {
        System.out.println(" Created Index ");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println(" Destroying Index.... ");
    }

    public String getMessage() {
        String message = helloService.sayHello();

        veryBigBrother.gatherEverything(message);
        return  message + " - hashcode : " + this.hashCode() + " " + this.toString();
    }

    public int getGlobalCounter() {
        nakedObject.sayHello();
        emptyDelegate.getGc().increase();
        return emptyDelegate.getGc().getValue();
    }

    public int getUserCounter() {
        emptyDelegate.getUc().increase();
        return emptyDelegate.getUc().getValue();
    }

}
