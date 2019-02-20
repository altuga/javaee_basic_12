package com.kodcu;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Index {

    @Inject
    HelloService helloService;

    public String getMessage() {
        return  helloService.sayHello();
    }

}
