package com.kodcu;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class HelloService {

    public  String sayHello() {
        return "Hello " + new Date();
    }
}
