package com.kodcu;

import javax.ejb.AsyncResult;
import javax.ejb.Stateless;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class MessageAnalyzer {

    public Future<Boolean> analyze(String message) {
        boolean retVal = (message.hashCode() % 2 == 0) ;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Logger.getLogger(MessageAnalyzer.class.getName()).log(Level.SEVERE, null, e);
        }
        return new AsyncResult<>(retVal);
    }


    @Override
    public String toString() {
        return "MessageAnalyzer{}";
    }
}
