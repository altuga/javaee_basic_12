package com.kodcu;


import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@DependsOn("HelloService")
@Singleton
@Startup
public class FireStarter {

    @PostConstruct
    public void start() {
        System.out.println("Starting FireStarter ...");
    }

}
