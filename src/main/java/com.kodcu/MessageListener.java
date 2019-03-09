package com.kodcu;

import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

public class MessageListener {


    public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) String message) {

        System.out.println("+++  " + message);
    }


    public void onFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) String message) {
        System.out.println("---  " + message);
    }


    @Override
    public String toString() {
        return "MessageListener{}";
    }
}
