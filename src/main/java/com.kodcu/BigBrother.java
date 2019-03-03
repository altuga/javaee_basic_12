package com.kodcu;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 * First version
 */

@Stateless
public class BigBrother {

    @Asynchronous
    public void gatherEverything(String message) {


        System.out.println(" Big Brother is watching you " + message);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
